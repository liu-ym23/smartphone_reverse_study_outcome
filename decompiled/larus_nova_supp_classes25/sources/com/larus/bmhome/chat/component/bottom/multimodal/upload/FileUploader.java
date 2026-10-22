package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.component.bottom.multimodal.VLMUploadDowngradeData;
import com.larus.bmhome.chat.component.bottom.multimodal.preprocess.FileProcessor;
import com.larus.bmhome.chat.component.bottom.multimodal.preprocess.SendResourcePreprocessManager;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.z2;
import com.larus.trace.audioattachment.AudioAttachmentUploadEvent;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.r;
import ic8.m0;
import ic8.n0;
import java.io.File;
import java.io.FileDescriptor;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class FileUploader {
    public static final FileUploader a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProcessFileResultCode.values().length];
            r0[ProcessFileResultCode.PREPARE_OVER_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[ProcessFileResultCode.PREPARE_OVER_META_LIMIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[ProcessFileResultCode.PREPARE_OVER_DURATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[ProcessFileResultCode.PREPARE_RES_NOT_FOUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[ProcessFileResultCode.PREPARE_FILE_NOT_FOUND.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[ProcessFileResultCode.PREPARE_CLONE_FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[ProcessFileResultCode.PREPARE_OVER_STORAGE_FREE_SPACE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[ProcessFileResultCode.PREPARE_TYPE_NO_MATCH.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    static {
        a = new FileUploader();
    }

    public FileUploader() {
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "fileIdentifier");
        SharedAlbumUploadCoordinator r0 = SharedAlbumUploadCoordinator.a;
        if (z2.a.fastAlbumSingleUploadAttachmentSyncEnable() == true) goto L5;
        return;
    L5:
        String r2 = SharedAlbumUploadCoordinator.c(r1).b;
        if (r2 == null) goto L9;
        ResourceUploader r3 = ResourceUploader.a;
        ResourceUploader.b(r2, ResourceUploader.a.b.a);
        return;
    }

    public static String c(UplinkFileEntity r2) {
        String r0 = r2.getFileIdentifier();
        if (r0 != null) goto L5;
    L12:
        r0 = UUID.randomUUID().toString();
    L14:
        if (Intrinsics.areEqual(r0, r2.getFileIdentifier()) == true) goto L16;
        r2.setFileIdentifier(r0);
    L16:
        return r0;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 != null) goto L14;
    L7:
        r1 = false;
        goto L8
    }

    public static FlowResourceScene j(UplinkFileEntity r1, String r2) {
        if (n1.e(r1) == false) goto L6;
        return FlowResourceScene.VideoUpload;
    L6:
        if (n1.b(r1) == true) goto L22;
        if (n1.a(r1) == true) goto L22;
        if (n1.d(r1) == false) goto L18;
        if (Intrinsics.areEqual(r2, "shoot_ocr") == true) goto L24;
        if (Intrinsics.areEqual(r2, "album_ocr") == false) goto L18;
    L24:
        return FlowResourceScene.ImageOCR;
    L18:
        if (n1.d(r1) == true) goto L25;
        return null;
    L25:
        return FlowResourceScene.ImageVLM;
    L22:
        return FlowResourceScene.FileUpload;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object k(final d r30, Continuation r31) {
        UplinkFileEntity r1 = r30.e;
        final String r2 = i(r1, r30.j, r30.k, j(r1, r30.o));
        ux9.a r3 = ux9.a.i.c(r2);
        if (r3 == null) goto L5;
        r3.d(r30.i, null);
    L5:
        if (r3 == null) goto L7;
        final ux9.a.c r4 = r3.c();
    L9:
        if (r30.j == true) goto L11;
    L15:
        ResourceCenter r5 = ResourceCenter.a;
        String r6 = r30.e.getFileIdentifier();
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        r5.getClass();
        boolean r7 = ResourceCenter.d(r6);
        String r9 = com.larus.platform.service.o.a.getDeviceId();
        String r8 = r30.f;
        if (r8 != null) goto L21;
        String r10 = "";
    L22:
        String r11 = r30.g;
        if (r11 != null) goto L25;
        String r12 = "";
    L26:
        String r13 = r30.h;
        if (r13 != null) goto L29;
        String r14 = "";
    L30:
        String r15 = r30.i;
        if (r15 != null) goto L33;
        String r16 = "";
    L34:
        mr9.h r17 = new mr9.h(r7, new ResourceAttachmentExtra(r9, r10, r12, r14, r16), r30.e, new j(r30), new k(r30));
        FLogger.a.i("FileUploadHelper", "[buildResourceCenterUploadParam] param:" + r17);
        final mr9.h r18 = r17;
    L35:
        String r19 = r30.b;
        UplinkFileEntity r20 = r30.e;
        if (n1.d(r20) == false) goto L40;
        UploadDataType r21 = UploadDataType.IMAGE;
    L38:
        UploadDataType r22 = r21;
        Function1 r23 = new f(r4, r18, r30, r2);
        Function1 r110 = new g(r2, r30);
        Function1 r111 = new h(r4, r2, r30);
        if (n1.d(r30.e) == false) goto L52;
        String r24 = r30.b;
    L54:
        String r112 = StringsKt.substringAfterLast$default(r24, '.', null, 2, null);
    L56:
        boolean r113 = r30.a;
        if (r113 == false) goto L59;
        CountDownLatch r114 = new CountDownLatch(1);
    L60:
        String r115 = r30.l;
        Boolean r25 = r30.m;
        mr9.c r26 = r30.n;
        String r116 = r30.o;
        Long r117 = r30.p;
        if (r4 == null) goto L63;
        i r27 = new i(r4);
    L64:
        mr9.j r28 = new mr9.j(r19, "bot_chat", r22, r23, r110, r111, false, null, null, r112, r2, r113, r114, r18, r115, r25, r26, r116, r117, r27, 960);
        FLogger r29 = FLogger.a;
        String r0 = r30.e.getFileIdentifier();
        if (r0 != null) goto L67;
        r0 = "";
    L67:
        r29.i("FileUploadHelper", "[uploadFile] route to facade bridge, identifier=".concat(r0));
        Object r32 = com.larus.bmhome.upload.sdk.i.a(r28, "file_uploader", r31);
        if (r32 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L71;
        return r32;
    L71:
        return Unit.INSTANCE;
    L63:
        r27 = 0;
        goto L64
    L59:
        r114 = null;
        goto L60
    L52:
        r24 = r30.c;
        if (r24 != null) goto L54;
        r112 = null;
        goto L56
    L40:
        if (n1.b(r20) == false) goto L42;
    L48:
        r21 = UploadDataType.FILE;
        goto L38
    L42:
        if (n1.a(r20) == true) goto L48;
        if (n1.e(r20) == false) goto L47;
        r21 = UploadDataType.VIDEO;
        goto L38
    L47:
        r21 = UploadDataType.UNCLEAR;
        goto L38
    L33:
        r16 = r15;
        goto L34
    L29:
        r14 = r13;
        goto L30
    L25:
        r12 = r11;
        goto L26
    L21:
        r10 = r8;
        goto L22
    L11:
        if (n1.e(r30.e) == true) goto L15;
        if (r30.k == true) goto L15;
        FLogger.a.i("FileUploadHelper", "[buildResourceCenterUploadParam] skippedAttachment");
        r18 = new mr9.h(false, null, null, 31);
        goto L35
    L7:
        r4 = null;
        goto L9
    }

    public final Object e(q r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof FileUploader$interceptDisallowedFileType$1) == false) goto L7;
        FileUploader$interceptDisallowedFileType$1 r0 = (FileUploader$interceptDisallowedFileType$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        m0 r13 = (m0) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L62:
        String r14 = r4;
    L63:
        int r5 = com.larus.bmhome.chat.trace.multimodal.a.a;
        com.larus.bmhome.chat.trace.multimodal.a.c(r14, ProcessFileResultCode.PREPARE_TYPE_NO_MATCH, r13, 8);
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        boolean r6 = false;
        if (n1.a(r10.e) == true) goto L17;
        r14 = r10.e.getFileIdentifier();
        if (r14 != null) goto L22;
        r14 = UUID.randomUUID().toString();
    L22:
        if (Intrinsics.areEqual(r10.d, "file") == true) goto L24;
    L26:
        boolean r7 = false;
    L27:
        boolean r8 = !r10.b;
        if (r7 == false) goto L66;
        if (r8 == false) goto L66;
        ImFileUtil r9 = ImFileUtil.a;
        Uri r15 = r10.e.getUri();
        if (r15 != null) goto L33;
        r15 = Uri.EMPTY;
    L33:
        Intrinsics.checkNotNull(r15);
        r9.getClass();
        r13 = ImFileUtil.f(r15);
        String r16 = r13.b;
        String r17 = r13.d;
        if (r17 != null) goto L36;
    L41:
        boolean r18 = false;
    L43:
        if (r18 == true) goto L56;
        List r19 = ImFileUtil.q().k();
        if (r19 == null) goto L54;
        if (r16 == null) goto L50;
        String r20 = StringsKt.substringAfterLast(r16, ".", "");
        if (r20 == null) goto L50;
        String r21 = r20.toLowerCase(Locale.getDefault());
    L52:
        if (r19.contains(r21) == true) goto L54;
        boolean r22 = true;
    L55:
        if (r22 == true) goto L56;
    L57:
        if (r6 == false) goto L63;
        MainCoroutineDispatcher r23 = Dispatchers.getMain();
        FileUploader$interceptDisallowedFileType$2$1 r24 = new FileUploader$interceptDisallowedFileType$2$1(null);
        r0.L$0 = r14;
        r0.L$1 = r13;
        r0.label = 1;
        if (BuildersKt.withContext(r23, r24, r0) != r2) goto L61;
        return r2;
    L61:
        r4 = r14;
    L50:
        r21 = null;
    L54:
        r22 = false;
    L56:
        r6 = true;
        goto L57
    L36:
        if (r17.length() != 0) goto L38;
        boolean r25 = true;
    L39:
        if (r25 != true) goto L41;
        r18 = true;
        goto L43
    L38:
        r25 = false;
    L66:
        return Boxing.boxBoolean(false);
    L24:
        if (n1.d(r10.e) == false) goto L26;
        r7 = true;
        goto L27
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new FileUploader$interceptDisallowedFileType$1(this, r11);
        goto L8
    }

    public final Object b(q r38, ns8.b r39, Continuation<? super n0> r40) {
        q r0 = r38;
        if ((r40 instanceof FileUploader$doPreprocess$1) == false) goto L7;
        FileUploader$doPreprocess$1 r2 = (FileUploader$doPreprocess$1) r40;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r8 = false;
        switch(r2.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        n0 r5 = (n0) r2.L$0;
        ResultKt.throwOnFailure(r1);
        return r5;
    L13:
        n0 r6 = (n0) r2.L$1;
        q r7 = (q) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Object r9 = r4;
        FileUploader$doPreprocess$1 r10 = r2;
    L252:
        Continuation r11 = null;
    L256:
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        FileUploader$doPreprocess$2$5 r13 = new FileUploader$doPreprocess$2$5(r7, r6, r11);
        r10.L$0 = r6;
        r10.L$1 = r11;
        r10.L$2 = r11;
        r10.label = 8;
        if (BuildersKt.withContext(r12, r13, r10) != r9) goto L280;
        return r9;
    L280:
        return r6;
    L14:
        r6 = (n0) r2.L$1;
        r7 = (q) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r9 = r4;
        r11 = null;
        r10 = r2;
        goto L256
    L15:
        q r14 = (q) r2.L$1;
        q r15 = (q) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L94:
        n0 r16 = (n0) r1;
        q r17 = r15;
        r7 = r14;
    L102:
        m0 r18 = r16.a;
        if (r18 == null) goto L114;
        UplinkEntityContent r19 = r17.e.getUplinkEntityContent();
        if (r19 == null) goto L111;
        Image r20 = r19.getUplinkImageInfo();
        if (r20 == null) goto L111;
        Map r21 = r20.ext;
        if (r21 == null) goto L111;
        String r22 = (String) r21.get("is_marked");
    L112:
        r18.i = Intrinsics.areEqual(r22, "1");
    L111:
        r22 = null;
    L114:
        if (IBachDetectCenterAbility.a.b() == false) goto L140;
        m0 r23 = r16.a;
        if (r23 == null) goto L140;
        String r24 = r23.e;
        if (r24 == null) goto L140;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L125
        PolarisFileWrapper r26 = new PolarisFileWrapper(r24);     // Catch: Throwable -> L125
        if (r26.exists() == false) goto L122;
        Uri r27 = Uri.fromFile(r26);     // Catch: Throwable -> L125
    L123:
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L125
    L128:
        if (Result.isSuccess-impl(r28) == false) goto L132;
        Uri r29 = (Uri) r28;
        if (r29 == null) goto L132;
        IBachDetectCenterAbility.a.a(r29);
    L132:
        Result.box-impl(r28);
        goto L140
    L122:
        r27 = null;
    L125:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
    L140:
        r6 = r16;
        FileUploader$doPreprocess$1 r210 = r2;
        Object r211 = r4;
    L231:
        ProcessFileResultCode r31 = r6.b;
        if (r31 != null) goto L234;
        int r32 = -1;
    L236:
        if (r32 != 1) goto L238;
        r9 = r211;
        r10 = r210;
        FLogger.a.w("FileUploadHelper", "[doPreprocess] PREPARE_OVER_SIZE");
        MainCoroutineDispatcher r33 = Dispatchers.getMain();
        r11 = null;
        FileUploader$doPreprocess$2$1 r34 = new FileUploader$doPreprocess$2$1(r7, null);
        r10.L$0 = r7;
        r10.L$1 = r6;
        r10.L$2 = null;
        r10.label = 4;
        if (BuildersKt.withContext(r33, r34, r10) != r9) goto L256;
        return r9;
    L238:
        if (r32 != 2) goto L240;
        r9 = r211;
        r10 = r210;
        FLogger.a.w("FileUploadHelper", "[doPreprocess] PREPARE_OVER_META_LIMIT");
        MainCoroutineDispatcher r35 = Dispatchers.getMain();
        FileUploader$doPreprocess$2$2 r36 = new FileUploader$doPreprocess$2$2(null);
        r10.L$0 = r7;
        r10.L$1 = r6;
        r10.L$2 = null;
        r10.label = 5;
        if (BuildersKt.withContext(r35, r36, r10) != r9) goto L252;
        return r9;
    L240:
        if (r32 == 3) goto L246;
        if (r32 == 4) goto L243;
        r9 = r211;
        r10 = r210;
        goto L252
    L243:
        FLogger.a.w("FileUploadHelper", "[doPreprocess] PREPARE_OPEN_FILE_ERROR");
        MainCoroutineDispatcher r37 = Dispatchers.getMain();
        FileUploader$doPreprocess$2$4 r41 = new FileUploader$doPreprocess$2$4(null);
        r10 = r210;
        r10.L$0 = r7;
        r10.L$1 = r6;
        r10.L$2 = null;
        r10.label = 7;
        r9 = r211;
        if (BuildersKt.withContext(r37, r41, r10) != r9) goto L252;
        return r9;
    L246:
        r9 = r211;
        r10 = r210;
        FLogger.a.w("FileUploadHelper", "[doPreprocess] PREPARE_OVER_DURATION");
        MainCoroutineDispatcher r42 = Dispatchers.getMain();
        FileUploader$doPreprocess$2$3 r43 = new FileUploader$doPreprocess$2$3(null);
        r10.L$0 = r7;
        r10.L$1 = r6;
        r10.L$2 = null;
        r10.label = 6;
        if (BuildersKt.withContext(r42, r43, r10) != r9) goto L252;
        return r9;
    L234:
        r32 = a.a[r31.ordinal()];
        goto L236
    L16:
        ResultKt.throwOnFailure(r1);
    L40:
        return new n0(null, ProcessFileResultCode.PREPARE_RES_NOT_FOUND);
    L17:
        boolean r44 = r2.Z$0;
        q r45 = (q) r2.L$2;
        final ns8.b r110 = (ns8.b) r2.L$1;
        r17 = (q) r2.L$0;
        ResultKt.throwOnFailure(r1);
        boolean r46 = r44;
        r0 = r45;
        Object r47 = r1;
    L34:
        Uri r48 = (Uri) r47;
        if (r48 != null) goto L41;
        MainCoroutineDispatcher r49 = Dispatchers.getMain();
        FileUploader$doPreprocess$2$uri$1$1 r50 = new FileUploader$doPreprocess$2$uri$1$1(r0, null);
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.label = 2;
        if (BuildersKt.withContext(r49, r50, r2) != r4) goto L40;
        return r4;
    L41:
        boolean r310 = r46;
        final q r51 = r0;
        boolean r52 = r310;
    L46:
        String r111 = "";
        if (n1.d(r51.e) == false) goto L134;
        VLMUploadDowngradeData r112 = com.larus.bmhome.chat.component.bottom.multimodal.p.b();
        z2 r113 = z2.a;
        oq9.b r114 = r113.getAppImageUploadConfig();
        if (r112 == null) goto L60;
        Integer r115 = r112.getVlmResolution();
        if (r115 == null) goto L60;
        if (r115.intValue() <= 0) goto L55;
        boolean r116 = true;
    L56:
        if (r116 == true) goto L59;
        r115 = null;
    L59:
        if (r115 == null) goto L60;
    L61:
        Integer r117 = r115;
        if (r112 == null) goto L73;
        Integer r118 = r112.getVlmQuality();
        if (r118 == null) goto L73;
        if (r118.intValue() <= 0) goto L68;
        boolean r119 = true;
    L69:
        if (r119 == true) goto L72;
        r118 = null;
    L72:
        if (r118 == null) goto L73;
    L74:
        final ns8.a r120 = new ns8.a(r117, null, r118, null, r113.d2(), 232);
        if (r52 == false) goto L79;
        ResourceRef r53 = dr9.a.c(r48.toString(), 0, 0, 14);
        if (r53 == null) goto L79;
        String r54 = dr9.a.a(r53);
    L80:
        if (r52 == false) goto L84;
        if (r54 != null) goto L87;
    L88:
        if (r8 == false) goto L100;
        if (r54 == null) goto L95;
        PreviewAttachmentResourcePreparer r55 = PreviewAttachmentResourcePreparer.a;
        Function1 r56 = new e(r51, r120, r110);
        r2.L$0 = r17;
        r2.L$1 = r51;
        r2.L$2 = null;
        r2.label = 3;
        Object r57 = BuildersKt.withContext(Dispatchers.getIO(), new PreviewAttachmentResourcePreparer$preprocessImageCopy$2(r54, r56, null), r2);
        if (r57 != r4) goto L93;
        return r4;
    L93:
        r15 = r17;
        q r311 = r51;
        r1 = r57;
        r14 = r311;
        goto L94
    L95:
        SendResourcePreprocessManager r121 = SendResourcePreprocessManager.a;
        String r58 = r48.getPath();
        if (r58 == null) goto L99;
        r111 = r58;
    L99:
        n0 r59 = ye8.b$a.c(r121, r111, r51.b, r120, r110, 16);
    L101:
        r7 = r51;
        r16 = r59;
        goto L102
    L100:
        SendResourcePreprocessManager r122 = SendResourcePreprocessManager.a;
        Intrinsics.checkNotNull(r48);
        r59 = ye8.b$a.b(r122, r48, r51.b, r120, r51.d, r110, 32);
    L87:
        r8 = true;
        goto L88
    L84:
        if (Intrinsics.areEqual(r51.d, "shoot") == true) goto L87;
        if (Intrinsics.areEqual(r51.d, "shoot_ocr") == false) goto L88;
    L79:
        r54 = null;
        goto L80
    L68:
        r119 = false;
    L73:
        r118 = r114.c();
        goto L74
    L55:
        r116 = false;
    L60:
        r115 = r114.b();
        goto L61
    L134:
        if (n1.a(r51.e) == false) goto L142;
        SendResourcePreprocessManager r60 = SendResourcePreprocessManager.a;
        Intrinsics.checkNotNull(r48);
        boolean r61 = r51.b;
        ux9.a r62 = ux9.a.i.c(r51.e.getFileIdentifier());
        if (r62 == null) goto L138;
        ux9.a.c r123 = r62.e();
    L139:
        Intrinsics.checkNotNullParameter(r48, "uri");
        long r212 = SystemClock.elapsedRealtime();
        n0 r63 = ((FileProcessor) SendResourcePreprocessManager.b.getValue()).k(FileType.FileTypeAudio, r48, r61, r110, r123);
        long r124 = SystemClock.elapsedRealtime() - r212;
        FLogger.a.i("SendResourcePreprocessManager", "[preprocessAudioFile] spendTime:" + r124 + "ms, result:" + r63);
        r7 = r51;
        r16 = r63;
        goto L140
    L138:
        r123 = null;
        goto L139
    L142:
        if (n1.e(r51.e) == false) goto L230;
        SendResourcePreprocessManager r64 = SendResourcePreprocessManager.a;
        Intrinsics.checkNotNull(r48);
        String r65 = r51.e.getFileIdentifier();
        if (r65 == null) goto L147;
        r111 = r65;
    L147:
        Intrinsics.checkNotNullParameter(r48, "uri");
        Intrinsics.checkNotNullParameter(r111, "identifier");
        long r213 = SystemClock.elapsedRealtime();
        com.larus.bmhome.chat.component.bottom.multimodal.preprocess.b r66 = new com.larus.bmhome.chat.component.bottom.multimodal.preprocess.b();
        Intrinsics.checkNotNullParameter(r48, "uri");
        Intrinsics.checkNotNullParameter(r111, "identifier");
        FLogger r67 = FLogger.a;
        r67.d("AlbumVideoProcessor", "[execIncludeClone] uri:" + r48 + ", compressConfig:null");
        m0 r125 = new m0(r48.toString(), null, 0, null, null, null, null, 16382);
        ImFileUtil.a.getClass();
        if (ImFileUtil.y(r48) == true) goto L278;
        r67.e("AlbumVideoProcessor", "[execIncludeClone] not video type, abort uri: " + r48);
        n0 r68 = new n0(r125, ProcessFileResultCode.PREPARE_TYPE_NO_MATCH);
    L156:
        q r214 = r51;
        r210 = r2;
        r211 = r4;
    L229:
        long r69 = SystemClock.elapsedRealtime() - r213;
        FLogger.a.i("SendResourcePreprocessManager", "[preprocessAlbumVideo] spendTime:" + r69 + "ms, result:" + r68);
        r6 = r68;
        r7 = r214;
        goto L231
    L278:
        ParcelFileDescriptor r70 = com.larus.bmhome.chat.component.bottom.multimodal.preprocess.b.l((ContentResolver) r66.b.getValue(), r48);     // Catch: Throwable -> L152
    L154:
        if (r70 != null) goto L157;
        r68 = new n0(r125, ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR);
        goto L156
    L157:
        FileDescriptor r71 = r70.getFileDescriptor();
        ImFileUtil.a.getClass();
        String r72 = ImFileUtil.i(r48);
        r125.d = r72;
        FLogger r73 = FLogger.a;
        r211 = r4;
        r210 = r2;
        r73.i("AlbumVideoProcessor", "[execIncludeClone] videoType: " + r72);
        Intrinsics.checkNotNull(r71);
        q r74 = r51;
        long r75 = com.larus.bmhome.chat.component.bottom.multimodal.preprocess.e.c(r71, r48);
        r125.c = r75;
        if (ImFileUtil.A(r75) == false) goto L162;
        Intrinsics.checkNotNullParameter(r70, "<this>");
        r70.close();     // Catch: Throwable -> L260
    L161:
        r68 = new n0(r125, ProcessFileResultCode.PREPARE_OVER_SIZE);
        r214 = r74;
        goto L229
    L162:
        mr9.e r76 = com.larus.bmhome.chat.component.bottom.multimodal.preprocess.b.n(r48, r125, r111, true);
        if (r76 == null) goto L176;
        r214 = r74;
        r73.i("AlbumVideoProcessor", "[retrieveMetaInfo] videoMeta:" + r76);
        boolean r77 = false;
        if (ImFileUtil.z(r76, false) == true) goto L168;
        ProcessFileResultCode r78 = null;
    L171:
        if (r78 == null) goto L175;
        Intrinsics.checkNotNullParameter(r70, "<this>");
        r70.close();     // Catch: Throwable -> L261
    L174:
        r68 = new n0(r125, r78);
        goto L229
    L175:
        com.larus.bmhome.upload.h r79 = com.larus.bmhome.upload.h.a;
        com.larus.bmhome.upload.h.a(r111, r76, "AlbumVideoProcessor#execIncludeClone");
    L177:
        if (r110 != null) goto L179;
    L181:
        if (r77 == false) goto L216;
        r73.i("AlbumVideoProcessor", "[execIncludeClone] skip clone");
        if (r125.e == null) goto L270;
        Intrinsics.checkNotNullParameter(r70, "<this>");
        r70.close();     // Catch: Throwable -> L262
    L186:
        n0 r80 = new n0(r125, ProcessFileResultCode.PREPARE_CLONE_SUCCESS);
    L187:
        r68 = r80;
        goto L229
    L270:
        Result.Companion r81 = Result.Companion;     // Catch: Throwable -> L196
        String r82 = r.j(AppHost.a.getApplication(), r48);     // Catch: Throwable -> L196
        if (r82 == null) goto L193;
        PolarisFileWrapper r83 = new PolarisFileWrapper(r82);     // Catch: Throwable -> L196
        if (r83.exists() == false) goto L193;
    L194:
        Object r84 = Result.constructor-impl(r83);     // Catch: Throwable -> L196
    L198:
        Throwable r85 = Result.exceptionOrNull-impl(r84);
        if (r85 == null) goto L202;
        FLogger.a.w("AlbumVideoProcessor", "[execIncludeClone] get original file path failed: " + r85);
    L202:
        if (Result.isFailure-impl(r84) == false) goto L204;
        r84 = null;
    L204:
        File r86 = (File) r84;
        if (r86 == null) goto L207;
        String r87 = r86.getAbsolutePath();
    L208:
        if (r87 == null) goto L216;
        r125.e = r86.getAbsolutePath();
        if (r110.f == true) goto L212;
        ImFileUtil.a.getClass();
        String r88 = ImFileUtil.g(r86);
    L213:
        r125.f = r88;
        Intrinsics.checkNotNullParameter(r70, "<this>");
        r70.close();     // Catch: Throwable -> L263
    L215:
        r80 = new n0(r125, ProcessFileResultCode.PREPARE_CLONE_SUCCESS);
        goto L187
    L212:
        r88 = null;
        goto L213
    L207:
        r87 = null;
    L193:
        r83 = null;
    L196:
        th = move-exception;
        Result.Companion r89 = Result.Companion;
        r84 = Result.constructor-impl(ResultKt.createFailure(th));
    L216:
        ImFileUtil.a.getClass();
        Pair r90 = com.larus.bmhome.chat.component.bottom.multimodal.preprocess.e.h(r66, r72, r71, false, null, true, r110, ImFileUtil.f(r48).b, null, DoraCallStateCode.DOUBAO_ENV_OBE_STOP_CONVERSATION);
        FLogger r91 = FLogger.a;
        r91.i("AlbumVideoProcessor", "[execIncludeClone] cloneFileInfo:" + r90);
        r125.e = (String) r90.getFirst();
        r125.f = (String) r90.getSecond();
        String r92 = r125.e;
        if (r92 == null) goto L219;
        String r93 = StringsKt.substringAfterLast$default(r92, '/', null, 2, null);
    L220:
        r125.b = r93;
        r91.i("AlbumVideoProcessor", "[execIncludeClone] tryCloneOriginalRes result: " + ((String) r90.getFirst()));
        Intrinsics.checkNotNullParameter(r70, "<this>");
        r70.close();     // Catch: Throwable -> L223
    L225:
        if (o0.d((String) r90.getFirst()) == false) goto L227;
        ProcessFileResultCode r94 = ProcessFileResultCode.PREPARE_CLONE_SUCCESS;
    L228:
        r68 = new n0(r125, r94);
        goto L229
    L227:
        r94 = ProcessFileResultCode.PREPARE_CLONE_FAILED;
        goto L228
    L219:
        r93 = null;
        goto L220
    L179:
        if (r110.e != true) goto L181;
        r77 = true;
        goto L181
    L168:
        if (ImFileUtil.z(r76, true) == true) goto L170;
        r78 = ProcessFileResultCode.PREPARE_OVER_DURATION;
        goto L171
    L170:
        r78 = ProcessFileResultCode.PREPARE_OVER_META_LIMIT;
        goto L171
    L176:
        r214 = r74;
        r77 = false;
    L152:
        th = move-exception;
        FLogger.a.e("AlbumVideoProcessor", "[execIncludeClone] openFileDescriptor failed: " + th);
        r70 = null;
        goto L154
    L230:
        r210 = r2;
        r211 = r4;
        SendResourcePreprocessManager r95 = SendResourcePreprocessManager.a;
        Intrinsics.checkNotNull(r48);
        boolean r96 = r51.b;
        Intrinsics.checkNotNullParameter(r48, "uri");
        long r97 = SystemClock.elapsedRealtime();
        FileProcessor r126 = (FileProcessor) SendResourcePreprocessManager.b.getValue();
        FileType r127 = FileType.FileTypeFile;
        int r99 = FileProcessor.d;
        r6 = r126.k(r127, r48, r96, r110, null);
        long r100 = SystemClock.elapsedRealtime() - r97;
        FLogger.a.i("SendResourcePreprocessManager", "[preprocessFile] spendTime:" + r100 + "ms, result:" + r6);
        r7 = r51;
        goto L231
    L18:
        ResultKt.throwOnFailure(r1);
        UplinkFileEntity r101 = r0.e;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Map r102 = r101.getExtra();
        if (r102 == null) goto L21;
        String r103 = (String) r102.get("preview_snapshot_stable_id");
    L22:
        if (r103 != null) goto L24;
    L27:
        boolean r104 = true;
    L28:
        r46 = !r104;
        if (r46 == false) goto L42;
        PreviewAttachmentResourcePreparer r105 = PreviewAttachmentResourcePreparer.a;
        UplinkFileEntity r128 = r0.e;
        r2.L$0 = r0;
        r2.L$1 = r39;
        r2.L$2 = r0;
        r2.Z$0 = r46;
        r2.label = 1;
        r47 = r105.c(r128, r2);
        if (r47 != r4) goto L33;
        return r4;
    L33:
        r110 = r39;
        r17 = r0;
        goto L34
    L42:
        r48 = r0.e.getUri();
        if (r48 != null) goto L45;
        r48 = Uri.EMPTY;
    L45:
        r110 = r39;
        r17 = r0;
        r52 = r46;
        r51 = r17;
        goto L46
    L24:
        if (StringsKt.isBlank(r103) == true) goto L27;
        r104 = false;
        goto L28
    L21:
        r103 = null;
        goto L22
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r2 = new FileUploader$doPreprocess$1(this, r40);
        goto L8
    }

    public final Object h(q r17, ns8.b r18, Continuation<? super Unit> r19) {
        if ((r19 instanceof FileUploader$processBeforeUploadFileInternal$1) == false) goto L7;
        FileUploader$processBeforeUploadFileInternal$1 r2 = (FileUploader$processBeforeUploadFileInternal$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        FileUploader r6 = a;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L18;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L16;
        ResultKt.throwOnFailure(r1);
    L104:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r0 = (String) r2.L$4;
        ux9.a.c r7 = (ux9.a.c) r2.L$3;
        ux9.a r8 = (ux9.a) r2.L$2;
        q r9 = (q) r2.L$1;
        ns8.b r13 = (ns8.b) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L56:
        n0 r10 = (n0) r1;
        if (r8 == null) goto L75;
        m0 r11 = r10.a;
        if (r11 == null) goto L63;
        String r12 = r11.b;
        if (r12 == null) goto L63;
        String r14 = StringsKt.substringAfterLast(r12, '.', "");
    L64:
        m0 r15 = r10.a;
        if (r15 == null) goto L67;
        Long r16 = Boxing.boxLong(r15.c);
    L68:
        m0 r110 = r10.a;
        if (r110 == null) goto L73;
        Float r111 = r110.n;
        if (r111 == null) goto L73;
        Long r112 = Boxing.boxLong((long) (r111.floatValue() * 1000));
    L74:
        r8.f(r14, r16, r112);
    L76:
        ProcessFileResultCode r20 = r10.b;
        if (r20 != null) goto L79;
    L81:
        boolean r113 = false;
    L82:
        if (r113 == true) goto L100;
        if (r7 == null) goto L98;
        ProcessFileResultCode r21 = r10.b;
        if (r21 != null) goto L87;
        int r22 = -1;
    L88:
        switch(r22) {
            case 1: goto L96;
            case 2: goto L89;
            case 3: goto L95;
            case 4: goto L94;
            case 5: goto L93;
            case 6: goto L93;
            case 7: goto L92;
            case 8: goto L91;
            case 9: goto L90;
            default: goto L89;
        };
    L89:
        AudioAttachmentUploadEvent.Result r23 = AudioAttachmentUploadEvent.Result.VALIDATION_UNKNOWN;
    L97:
        ux9.a.c.e(r7, r23, null, null, 6);
        goto L98
    L90:
        r23 = AudioAttachmentUploadEvent.Result.UNSUPPORTED_TYPE;
        goto L97
    L91:
        r23 = AudioAttachmentUploadEvent.Result.INSUFFICIENT_STORAGE;
        goto L97
    L92:
        r23 = AudioAttachmentUploadEvent.Result.COPY_FAILED;
        goto L97
    L93:
        r23 = AudioAttachmentUploadEvent.Result.SOURCE_UNAVAILABLE;
        goto L97
    L94:
        r23 = AudioAttachmentUploadEvent.Result.EMPTY_DATA;
        goto L97
    L95:
        r23 = AudioAttachmentUploadEvent.Result.OVER_DURATION;
        goto L97
    L96:
        r23 = AudioAttachmentUploadEvent.Result.OVERSIZE;
        goto L97
    L87:
        r22 = a.a[r21.ordinal()];
    L98:
        int r24 = com.larus.bmhome.chat.trace.multimodal.a.a;
        com.larus.bmhome.chat.trace.multimodal.a.c(r0, r10.b, r10.a, 8);
        FLogger.a.w("FileUploadHelper", "tryAttachmentUpload ProcessResult for not Success");
        return Unit.INSTANCE;
    L100:
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.label = 4;
        if (r6.d(r9, r10, r13, r2) != r4) goto L104;
        return r4;
    L79:
        if (r20.isSuccess() != true) goto L81;
        r113 = true;
    L73:
        r112 = null;
        goto L74
    L67:
        r16 = null;
    L63:
        r14 = null;
        goto L64
    L75:
        r13 = r13;
        goto L76
    L18:
        boolean r25 = r2.Z$0;
        String r26 = (String) r2.L$4;
        ux9.a.c r27 = (ux9.a.c) r2.L$3;
        ux9.a r114 = (ux9.a) r2.L$2;
        q r115 = (q) r2.L$1;
        ns8.b r116 = (ns8.b) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r9 = r115;
    L49:
        if (r25 == false) goto L52;
        FLogger.a.w("FileUploadHelper", "[tryUploadFile] interceptResult true");
        return Unit.INSTANCE;
    L52:
        r2.L$0 = r116;
        r2.L$1 = r9;
        r2.L$2 = r114;
        r2.L$3 = r27;
        r2.L$4 = r26;
        r2.label = 3;
        r1 = r6.b(r9, r116, r2);
        if (r1 != r4) goto L55;
        return r4;
    L55:
        r0 = r26;
        r7 = r27;
        r8 = r114;
        r13 = r116;
        goto L56
    L19:
        String r28 = (String) r2.L$4;
        ux9.a.c r29 = (ux9.a.c) r2.L$3;
        r114 = (ux9.a) r2.L$2;
        q r117 = (q) r2.L$1;
        r116 = (ns8.b) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L45:
        boolean r30 = ((Boolean) r1).booleanValue();
        MainCoroutineDispatcher r31 = Dispatchers.getMain();
        FileUploader$processBeforeUploadFileInternal$2$1 r118 = new FileUploader$processBeforeUploadFileInternal$2$1(r117, r30, null);
        r2.L$0 = r116;
        r2.L$1 = r117;
        r2.L$2 = r114;
        r2.L$3 = r29;
        r2.L$4 = r28;
        r2.Z$0 = r30;
        r2.label = 2;
        if (BuildersKt.withContext(r31, r118, r2) != r4) goto L48;
        return r4;
    L48:
        r27 = r29;
        r9 = r117;
        r26 = r28;
        r25 = r30;
        goto L49
    L20:
        ResultKt.throwOnFailure(r1);
        FLogger.a.i("FileUploadHelper", "[tryUploadFile] " + r17);
        String r32 = r17.e.getFileIdentifier();
        if (r32 != null) goto L23;
        r32 = UUID.randomUUID().toString();
    L23:
        r114 = ux9.a.i.c(r32);
        if (r114 == null) goto L26;
        r114.d(r17.g, null);
    L26:
        if (r114 == null) goto L28;
        r29 = r114.c();
    L29:
        if (r29 == null) goto L38;
        monitor-enter(r29);
        r29.e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L34
        monitor-exit(r29);
    L34:
        th = move-exception;
        throw th;
    L38:
        if (r17.b == false) goto L40;
        AttachmentAreaType r119 = AttachmentAreaType.MULTI_ATTACHMENT;
    L41:
        int r120 = MultimodalSendCostTrace.a;
        MultimodalSendCostTrace.c(r32, r17.g, r17.a, r17.d, r119);
        r2.L$0 = r18;
        r2.L$1 = r17;
        r2.L$2 = r114;
        r2.L$3 = r29;
        r2.L$4 = r32;
        r2.label = 1;
        Object r121 = r6.e(r17, r2);
        if (r121 != r4) goto L44;
        return r4;
    L44:
        r117 = r17;
        r28 = r32;
        r116 = r18;
        r1 = r121;
        goto L45
    L40:
        r119 = AttachmentAreaType.SINGLE_ATTACHMENT;
        goto L41
    L28:
        r29 = null;
    L7:
        r2 = new FileUploader$processBeforeUploadFileInternal$1(this, r19);
        goto L8
    }

    public static /* synthetic */ Object g(q r2, ns8.b r3, Continuation r4, int r5) {
        FileUploader r0 = a;
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        return r0.f(r2, r3, null, r4);
    }

    public static String i(UplinkFileEntity r1, boolean r2, boolean r3, FlowResourceScene r4) {
        String r0 = c(r1);
        if (n1.e(r1) == true) goto L8;
        if (r3 == true) goto L8;
        if (r2 == false) goto L8;
        boolean r5 = false;
    L9:
        if (r5 == true) goto L11;
        return r0;
    L11:
        if (r4 == null) goto L16;
        ResourceCenter.a.getClass();
        if (ResourceCenter.g(r0) != FlowResourceScene.Unknown) goto L16;
        ResourceCenter.k(r0, r4);
    L16:
        return r0;
    L8:
        r5 = true;
        goto L9
    }

    public final Object d(q r32, n0 r33, ns8.b r34, Continuation<? super Unit> r35) {
        if ((r35 instanceof FileUploader$handleProcessResultSuccess$1) == false) goto L7;
        FileUploader$handleProcessResultSuccess$1 r4 = (FileUploader$handleProcessResultSuccess$1) r35;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        q r0 = (q) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L54:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r3);
    L30:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r3);
        String r8 = c(r32.e);
        UplinkFileEntity r9 = r32.e;
        i(r9, r32.f, false, j(r9, r32.d));
        int r10 = MultimodalSendCostTrace.a;
        MultimodalSendCostTrace.a(r8, r33.a);
        m0 r11 = r33.a;
        if (r11 == null) goto L47;
        String r15 = r11.e;
        if (r15 == null) goto L47;
        if (r34 != null) goto L22;
    L24:
        boolean r2 = false;
    L25:
        if (r2 == false) goto L31;
        MainCoroutineDispatcher r1 = Dispatchers.getMain();
        FileUploader$handleProcessResultSuccess$2$1$1 r12 = new FileUploader$handleProcessResultSuccess$2$1$1(r32, r15, r32, null);
        r4.label = 1;
        if (BuildersKt.withContext(r1, r12, r4) != r6) goto L30;
        return r6;
    L31:
        boolean r14 = r32.b;
        String r13 = r11.b;
        m r16 = r32.c;
        UplinkFileEntity r17 = r32.e;
        String r18 = r32.a;
        String r19 = r32.h;
        String r110 = r32.i;
        String r20 = r32.g;
        boolean r21 = r32.f;
        String r22 = r11.a;
        Boolean r26 = Boxing.boxBoolean(com.larus.bmhome.chat.component.bottom.multimodal.preprocess.h.b(r22));
        m0 r23 = r33.a;
        if (r23 == null) goto L34;
        mr9.c r27 = r23.l;
    L35:
        String r24 = r32.d;
        if (r23 == null) goto L43;
        Long r25 = Boxing.boxLong(r23.c);
        if (r25.longValue() <= 0) goto L40;
        boolean r111 = true;
    L41:
        if (r111 == false) goto L43;
        Long r29 = r25;
    L44:
        d r28 = new d(r14, r15, r13, r16, r17, r18, r19, r110, r20, r21, false, r22, r26, r27, r24, r29, 1024);
        r4.L$0 = r32;
        r4.label = 2;
        if (k(r28, r4) != r6) goto L54;
        return r6;
    L40:
        r111 = false;
    L43:
        r29 = null;
        goto L44
    L34:
        r27 = null;
        goto L35
    L22:
        if (r34.c != true) goto L24;
        r2 = true;
    L47:
        ux9.a r30 = ux9.a.i.c(r32.e.getFileIdentifier());
        if (r30 == null) goto L52;
        ux9.a.c r31 = r30.e();
        if (r31 == null) goto L52;
        ux9.a.c.e(r31, AudioAttachmentUploadEvent.Result.INVALID_SOURCE, null, null, 6);
    L52:
        FLogger.a.w("FileUploadHelper", "tryAttachmentUpload localAppPath is null");
    L7:
        r4 = new FileUploader$handleProcessResultSuccess$1(this, r35);
        goto L8
    }

    public final Object f(q r11, ns8.b r12, Function0<Unit> r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof FileUploader$processBeforeUploadFile$1) == false) goto L7;
        FileUploader$processBeforeUploadFile$1 r0 = (FileUploader$processBeforeUploadFile$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r15);
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = (ns8.b) r0.L$1;
        r11 = (q) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L20:
        if (((Boolean) r15).booleanValue() == true) goto L22;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (h(r11, r12, r0) != r7) goto L27;
        return r7;
    L22:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r15);
        SharedAlbumUploadCoordinator r3 = SharedAlbumUploadCoordinator.a;
        FileUploader$processBeforeUploadFile$2 r4 = new FileUploader$processBeforeUploadFile$2(null);
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.label = 1;
        r15 = r3.i(r11, r12, r4, r13, r0);
        if (r15 != r7) goto L20;
        return r7;
    L7:
        r0 = new FileUploader$processBeforeUploadFile$1(this, r14);
        goto L8
    }
}
