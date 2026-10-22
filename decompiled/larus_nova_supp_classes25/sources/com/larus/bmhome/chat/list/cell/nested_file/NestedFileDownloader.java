package com.larus.bmhome.chat.list.cell.nested_file;

import android.content.Context;
import android.webkit.MimeTypeMap;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.IChatAzerothService;
import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.ResourceSignUrlData;
import com.larus.bmhome.rc.ResourceSignUrlDataV2;
import com.larus.bmhome.rc.ResourceSignUrlParamV2;
import com.larus.bmhome.rc.SignUrlMode;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class NestedFileDownloader {
    public static final NestedFileDownloader a = null;

    public static final class a {
        public final int a;
        public final Integer b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            Integer r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "DownloadResult(resultCode=" + this.a + ", errorCode=" + this.b + ", errorMessage=" + this.c + ", filePath=" + this.d + ')';
        }

        public a(int r3, Integer r4, String r5, String r6, int r7) {
            if ((r7 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r7 & 4) == 0) goto L9;
            r5 = null;
        L9:
            if ((r7 & 8) == 0) goto L11;
            r6 = null;
        L11:
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public static final class b extends AbsDownloadListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ kotlinx.coroutines.i<lr8.g> b;

        public final void onCanceled(DownloadInfo r13) {
            FLogger.a.i("NestedFileDownloader", "fileName :" + this.a + " download onCanceled");
            this.b.resumeWith(Result.constructor-impl(new lr8.g(2003, null, null, null, null, null, null, null, null, 510)));
        }

        public final void onStart(DownloadInfo r3) {
            FLogger.a.i("NestedFileDownloader", "fileName: " + this.a + " download onStart");
        }

        public final void onSuccessed(DownloadInfo r14) {
            FLogger.a.i("NestedFileDownloader", "fileName: " + this.a + " download onSuccess");
            kotlinx.coroutines.i<lr8.g> r0 = this.b;
            Result.Companion r1 = Result.Companion;
            if (r14 == null) goto L5;
            String r15 = r14.getTargetFilePath();
        L6:
            r0.resumeWith(Result.constructor-impl(new lr8.g(0, null, null, null, null, null, null, r15, null, 382)));
            return;
        L5:
            r15 = null;
            goto L6
        }

        public b(String r1, kotlinx.coroutines.j r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFailed(DownloadInfo r13, BaseException r14) {
            FLogger.a.i("NestedFileDownloader", "fileName: " + this.a + " download onFailed");
            kotlinx.coroutines.i<lr8.g> r15 = this.b;
            Result.Companion r0 = Result.Companion;
            if (r14 == null) goto L5;
            Integer r7 = Integer.valueOf(r14.getErrorCode());
        L6:
            if (r14 == null) goto L8;
            String r8 = r14.getErrorMessage();
        L9:
            r15.resumeWith(Result.constructor-impl(new lr8.g(2002, null, null, null, null, r7, r8, null, null, 414)));
            return;
        L8:
            r8 = null;
            goto L9
        L5:
            r7 = null;
            goto L6
        }
    }

    static {
        a = new NestedFileDownloader();
    }

    public NestedFileDownloader() {
    }

    public final Object a(String r10, Continuation<? super String> r11) {
        if ((r11 instanceof NestedFileDownloader$applyWatermarkOrFallback$1) == false) goto L7;
        NestedFileDownloader$applyWatermarkOrFallback$1 r0 = (NestedFileDownloader$applyWatermarkOrFallback$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = null;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        WatermarkPerfLogger.a r13 = (WatermarkPerfLogger.a) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
    L50:
        if ((r12 instanceof com.larus.platform.service.watermark.g.c) == false) goto L52;
        com.larus.platform.service.watermark.g.c r14 = (com.larus.platform.service.watermark.g.c) r12;     // Catch: Throwable -> L14
    L53:
        if (r14 == null) goto L55;
        String r15 = r14.a;     // Catch: Throwable -> L14
    L56:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L14
    L62:
        Throwable r6 = Result.exceptionOrNull-impl(r16);
        if (r6 != null) goto L75;
        String r17 = (String) r16;
        r13.a("applyWatermarkToFileAsLocal");
        if (r17 == null) goto L67;
        WatermarkPerfLogger.Result r7 = WatermarkPerfLogger.Result.SUCCESS;
    L68:
        if (r17 != null) goto L70;
        r4 = "no_ready_local_file";
    L70:
        r13.b(r7, r4);
        if (r17 != null) goto L74;
        return r5;
    L74:
        return r17;
    L67:
        r7 = WatermarkPerfLogger.Result.FAIL;
        goto L68
    L75:
        FLogger.a.w("NestedFileDownloader", "applyWatermarkOrFallback failed: " + r6);
        r13.b(WatermarkPerfLogger.Result.FAIL, r6.getClass().getSimpleName());
        return r5;
    L55:
        r15 = null;
        goto L56
    L52:
        r14 = null;
    L14:
        Throwable th = th;
        WatermarkPerfLogger.a r8 = r13;
    L61:
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        r13 = r8;
        goto L62
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        if (r10 != null) goto L21;
    L77:
        return r10;
    L21:
        if (r10.length() <= 0) goto L23;
        boolean r19 = true;
    L24:
        if (r19 == false) goto L26;
        String r110 = r10;
    L27:
        if (r110 == null) goto L77;
        DownloadWatermarkService r111 = DownloadWatermarkService.a;
        r111.getClass();
        if (DownloadWatermarkService.d() == true) goto L33;
        r111 = null;
    L33:
        int r9 = WatermarkPerfLogger.a;
        if (r111 != null) goto L36;
        WatermarkPerfLogger.Version r20 = WatermarkPerfLogger.Version.PERSONAL;
    L37:
        DownloadWatermarkScene r21 = DownloadWatermarkScene.NESTED_FILE_DOWNLOAD;
        r8 = WatermarkPerfLogger.a("nested_file_download", r20, r21);
        if (r111 != null) goto L40;
        WatermarkPerfLogger.Path r22 = WatermarkPerfLogger.Path.NONE;
    L41:
        r8.c(r22);
        if (r111 != null) goto L80;
        r8.b(WatermarkPerfLogger.Result.SUCCESS, null);
        return r110;
    L80:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L59
        com.larus.platform.service.watermark.a r24 = new com.larus.platform.service.watermark.a(r110, MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.substringAfterLast(r110, '.', "").toLowerCase(Locale.ROOT)), r21);     // Catch: Throwable -> L59
        r0.L$0 = r110;     // Catch: Throwable -> L59
        r0.L$1 = r8;     // Catch: Throwable -> L59
        r0.label = 1;     // Catch: Throwable -> L59
        Object r112 = r111.a(r24, r0);     // Catch: Throwable -> L59
        if (r112 != r2) goto L48;
        return r2;
    L48:
        r5 = r110;
        r12 = r112;
        r13 = r8;
    L59:
        th = move-exception;
        r5 = r110;
        th = th;
        goto L61
    L40:
        r22 = WatermarkPerfLogger.Path.B_FILE;
        goto L41
    L36:
        r20 = WatermarkPerfLogger.Version.ENTERPRISE;
        goto L37
    L26:
        r110 = null;
        goto L27
    L23:
        r19 = false;
    L7:
        r0 = new NestedFileDownloader$applyWatermarkOrFallback$1(this, r11);
        goto L8
    }

    public final Object f(UplinkFileInfo r10, Continuation<? super lr8.g> r11) {
        if ((r11 instanceof NestedFileDownloader$requireFileUrl$1) == false) goto L7;
        NestedFileDownloader$requireFileUrl$1 r0 = (NestedFileDownloader$requireFileUrl$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        ResultKt.throwOnFailure(r12);
    L58:
        return r12;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r12);
    L54:
        return r12;
    L18:
        r10 = (UplinkFileInfo) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L44:
        if (((lr8.g) r12).a != 0) goto L46;
        r4 = true;
    L46:
        if (r4 == true) goto L49;
        r12 = null;
    L49:
        r12 = (lr8.g) r12;
        if (r12 != null) goto L54;
        r0.L$0 = null;
        r0.label = 3;
        r12 = i(r10, r0);
        if (r12 != r2) goto L54;
        return r2;
    L19:
        r10 = (UplinkFileInfo) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L25:
        lr8.g r5 = (lr8.g) r12;
        if (r5.a == 0) goto L34;
        Integer r6 = r5.b;
        if (r6 != null) goto L31;
    L33:
        boolean r7 = false;
    L35:
        if (r7 == true) goto L38;
        r12 = null;
    L38:
        r12 = (lr8.g) r12;
        if (r12 != null) goto L54;
        r0.L$0 = r10;
        r0.label = 2;
        r12 = g(r10, r0);
        if (r12 != r2) goto L44;
        return r2;
    L31:
        if (r6.intValue() != 14007) goto L33;
    L34:
        r7 = true;
        goto L35
    L20:
        ResultKt.throwOnFailure(r12);
        ResourceCenter.a.getClass();
        if (ResourceCenter.c() == false) goto L55;
        r0.L$0 = r10;
        r0.label = 1;
        r12 = h(r10, r0);
        if (r12 != r2) goto L25;
        return r2;
    L55:
        r0.label = 4;
        r12 = i(r10, r0);
        if (r12 != r2) goto L58;
        return r2;
    L7:
        r0 = new NestedFileDownloader$requireFileUrl$1(this, r11);
        goto L8
    }

    public final Object g(UplinkFileInfo r21, Continuation<? super lr8.g> r22) {
        if ((r22 instanceof NestedFileDownloader$requireFileUrlByResourceId$1) == false) goto L7;
        NestedFileDownloader$requireFileUrlByResourceId$1 r1 = (NestedFileDownloader$requireFileUrlByResourceId$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r5 = true;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        String r6 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L35:
        ResourceSignUrlData r7 = (ResourceSignUrlData) ((Map) r0).get(r6);
        if (r7 == null) goto L38;
        String r8 = r7.getExternalUrl();
    L39:
        String r11 = r8;
        if (r11 != null) goto L42;
    L45:
        if (r5 == false) goto L47;
        FLogger.a.w("NestedFileDownloader", "require file url by resource id error: url is empty");
        return new lr8.g(1001, null, null, null, null, null, null, null, null, 510);
    L47:
        FLogger.a.i("NestedFileDownloader", "require file url by resource id success, urlPresent=true");
        return new lr8.g(0, null, r11, Boxing.boxBoolean(false), null, null, null, null, null, 498);
    L42:
        if (r11.length() == 0) goto L45;
        r5 = false;
        goto L45
    L38:
        r8 = null;
        goto L39
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        String r9 = r21.getResourceId();
        FLogger r10 = FLogger.a;
        StringBuilder r12 = new StringBuilder("require file url by resource id, resourceIdPresent=");
        if (r9 != null) goto L17;
    L20:
        boolean r13 = true;
    L21:
        r12.append(!r13);
        r10.i("NestedFileDownloader", r12.toString());
        if (r9 != null) goto L24;
    L27:
        boolean r14 = true;
    L28:
        if (r14 == false) goto L31;
        r10.w("NestedFileDownloader", "require file url by resource id error: illegal params");
        return new lr8.g(1001, null, null, null, null, null, null, null, null, 510);
    L31:
        ResourceCenter r15 = ResourceCenter.a;
        List r16 = CollectionsKt.listOf(r9);
        SignUrlMode r17 = SignUrlMode.Outer;
        r1.L$0 = r9;
        r1.label = 1;
        Object r18 = r15.m(r16, r17, r1);
        if (r18 != r3) goto L34;
        return r3;
    L34:
        r6 = r9;
        r0 = r18;
        goto L35
    L24:
        if (r9.length() == 0) goto L27;
        r14 = false;
        goto L28
    L17:
        if (r9.length() == 0) goto L20;
        r13 = false;
    L7:
        r1 = new NestedFileDownloader$requireFileUrlByResourceId$1(this, r22);
        goto L8
    }

    public final Object h(UplinkFileInfo r21, Continuation<? super lr8.g> r22) {
        if ((r22 instanceof NestedFileDownloader$requireFileUrlByResourceIdV2$1) == false) goto L7;
        NestedFileDownloader$requireFileUrlByResourceIdV2$1 r1 = (NestedFileDownloader$requireFileUrlByResourceIdV2$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r5 = false;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L60:
        ResourceSignUrlDataV2 r6 = (ResourceSignUrlDataV2) CollectionsKt.getOrNull((List) r0, 0);
        if (r6 == null) goto L68;
        Integer r7 = r6.getStatusCode();
        if (r7 == null) goto L68;
        if (r7.intValue() != 0) goto L68;
        boolean r8 = true;
    L69:
        if (r8 == true) goto L82;
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("require file url by resource id v2 error: code: ");
        Integer r11 = null;
        if (r6 == null) goto L73;
        Integer r12 = r6.getStatusCode();
    L74:
        r10.append(r12);
        r10.append(", msg: ");
        if (r6 == null) goto L77;
        String r13 = r6.getMessage();
    L78:
        r10.append(r13);
        r9.w("NestedFileDownloader", r10.toString());
        if (r6 == null) goto L96;
        r11 = r6.getStatusCode();
    L96:
        return new lr8.g(1001, r11, null, null, null, null, null, null, null, 508);
    L77:
        r13 = null;
        goto L78
    L73:
        r12 = null;
        goto L74
    L82:
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("require file url by resource id v2 success, urlPresent=");
        String r16 = r6.getMainUrl();
        if (r16 != null) goto L85;
    L88:
        boolean r17 = true;
    L89:
        r15.append(!r17);
        r15.append(", isEncrypted=");
        r15.append(r6.isEncrypted());
        r15.append(", keyPresent=");
        String r18 = r6.getDecryptionKey();
        if (r18 != null) goto L92;
    L93:
        r5 = true;
    L94:
        r15.append(!r5);
        r14.i("NestedFileDownloader", r15.toString());
        return new lr8.g(0, null, r6.getMainUrl(), r6.isEncrypted(), r6.getDecryptionKey(), null, null, null, null, 482);
    L92:
        if (r18.length() != 0) goto L94;
    L85:
        if (r16.length() == 0) goto L88;
        r17 = false;
    L68:
        r8 = false;
        goto L69
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        String r19 = r21.getResourceId();
        String r20 = r21.getTosKey();
        FLogger r23 = FLogger.a;
        StringBuilder r24 = new StringBuilder("require file url by resource id v2, resourceIdPresent=");
        if (r19 != null) goto L17;
    L20:
        boolean r110 = true;
    L21:
        r24.append(!r110);
        r24.append(", uriPresent=");
        if (r20 != null) goto L24;
    L27:
        boolean r111 = true;
    L28:
        r24.append(!r111);
        r23.i("NestedFileDownloader", r24.toString());
        if (r20 != null) goto L31;
    L34:
        boolean r25 = true;
    L35:
        if (r25 == false) goto L38;
        r23.w("NestedFileDownloader", "require file url by resource id v2 error: illegal params");
        return new lr8.g(1001, null, null, null, null, null, null, null, null, 510);
    L38:
        ResourceCenter r26 = ResourceCenter.a;
        Integer r112 = r21.getFileType();
        int r113 = FileType.FileTypeFile.getValue();
        if (r112 != null) goto L42;
    L44:
        int r114 = FileType.FileTypeAudio.getValue();
        if (r112 != null) goto L48;
    L50:
        int r115 = FileType.FileTypeVideo.getValue();
        if (r112 != null) goto L54;
    L56:
        FlowResourceType r116 = FlowResourceType.Unknown;
    L57:
        List r27 = CollectionsKt.listOf(new ResourceSignUrlParamV2(r19, r20, Boxing.boxInt(r116.getValue())));
        r1.label = 1;
        r0 = r26.n(r27, true, r1);
        if (r0 != r3) goto L60;
        return r3;
    L54:
        if (r112.intValue() != r115) goto L56;
        r116 = FlowResourceType.Video;
        goto L57
    L48:
        if (r112.intValue() != r114) goto L50;
        r116 = FlowResourceType.Audio;
        goto L57
    L42:
        if (r112.intValue() != r113) goto L44;
        r116 = FlowResourceType.File;
        goto L57
    L31:
        if (r20.length() == 0) goto L34;
        r25 = false;
        goto L35
    L24:
        if (r20.length() == 0) goto L27;
        r111 = false;
        goto L28
    L17:
        if (r19.length() == 0) goto L20;
        r110 = false;
    L7:
        r1 = new NestedFileDownloader$requireFileUrlByResourceIdV2$1(this, r22);
        goto L8
    }

    public final Object i(UplinkFileInfo r20, Continuation<? super lr8.g> r21) {
        if ((r21 instanceof NestedFileDownloader$requireFileUrlByTosKey$1) == false) goto L7;
        NestedFileDownloader$requireFileUrlByTosKey$1 r1 = (NestedFileDownloader$requireFileUrlByTosKey$1) r21;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r5 = true;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L34:
        FileUrlRespData r6 = (FileUrlRespData) ((com.larus.network.http.a) r0).b;
        if (r6 == null) goto L41;
        List<FileUrlData> r7 = r6.getFileUrlList();
        if (r7 == null) goto L41;
        FileUrlData r8 = (FileUrlData) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L41;
        String r9 = r8.getMainUrl();
    L42:
        String r11 = r9;
        if (r11 != null) goto L45;
    L48:
        if (r5 == false) goto L50;
        FLogger.a.w("NestedFileDownloader", "require file url by tos key error: url is empty");
        return new lr8.g(1001, null, null, null, null, null, null, null, null, 510);
    L50:
        FLogger.a.i("NestedFileDownloader", "require file url by tos key success, urlPresent=true");
        return new lr8.g(0, null, r11, Boxing.boxBoolean(false), null, null, null, null, null, 498);
    L45:
        if (r11.length() == 0) goto L48;
        r5 = false;
    L41:
        r9 = null;
        goto L42
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        String r10 = r20.getTosKey();
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("require file url by tos key, uriPresent=");
        if (r10 != null) goto L17;
    L20:
        boolean r14 = true;
    L21:
        r13.append(!r14);
        r12.i("NestedFileDownloader", r13.toString());
        if (r10 != null) goto L24;
    L27:
        boolean r15 = true;
    L28:
        if (r15 == false) goto L31;
        r12.w("NestedFileDownloader", "require file url by tos key error: illegal params");
        return new lr8.g(1001, null, null, null, null, null, null, null, null, 510);
    L31:
        Lazy<ChatApi> r16 = ChatApi.a;
        ChatApi r17 = ChatApi.a.a();
        List r18 = CollectionsKt.listOf(r10);
        String r19 = UploadDataType.FILE.getType();
        r1.label = 1;
        r17.getClass();
        r0 = ChatApi.e(r18, r19, r1);
        if (r0 != r3) goto L34;
        return r3;
    L24:
        if (r10.length() == 0) goto L27;
        r15 = false;
        goto L28
    L17:
        if (r10.length() == 0) goto L20;
        r14 = false;
    L7:
        r1 = new NestedFileDownloader$requireFileUrlByTosKey$1(this, r21);
        goto L8
    }

    public final Object b(String r31, String r32, String r33, Continuation<? super lr8.g> r34) {
        if ((r34 instanceof NestedFileDownloader$decryptFile$1) == false) goto L7;
        NestedFileDownloader$decryptFile$1 r3 = (NestedFileDownloader$decryptFile$1) r34;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        String r0 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L52:
        String r18 = r0;
        int r1 = ((Number) r2).intValue();
    L54:
        if (r1 != 0) goto L56;
        FLogger.a.i("NestedFileDownloader", "decrypt file success");
        return new lr8.g(0, null, null, null, null, null, null, null, r18, DoraCallStateCode.DOUBAO_STOP_CALL_BY_SPRING_DEGRADE);
    L56:
        FLogger.a.w("NestedFileDownloader", "decrypt file error: " + r1);
        return new lr8.g(r1, null, null, null, null, null, null, null, null, 510);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("decrypt file, keyPresent=");
        boolean r10 = false;
        if (r31.length() <= 0) goto L17;
        boolean r9 = true;
    L18:
        r8.append(r9);
        r8.append(", inputPresent=");
        if (r32 != null) goto L21;
    L24:
        boolean r11 = true;
    L25:
        r8.append(!r11);
        r8.append(", outputPresent=");
        if (r33 != null) goto L28;
    L31:
        boolean r12 = true;
    L32:
        r8.append(!r12);
        r7.i("NestedFileDownloader", r8.toString());
        if (r32 != null) goto L35;
    L38:
        boolean r13 = true;
    L39:
        if (r13 == true) goto L58;
        if (r33 != null) goto L42;
    L43:
        r10 = true;
    L44:
        if (r10 == true) goto L58;
        IChatAzerothService r14 = com.larus.bmhome.x.a();
        if (r14 == null) goto L53;
        r3.L$0 = r33;
        r3.label = 1;
        r2 = r14.c(r31, r32, r33, r3);
        if (r2 != r5) goto L51;
        return r5;
    L51:
        r0 = r33;
        goto L52
    L53:
        r1 = 3001;
        r18 = r33;
        goto L54
    L42:
        if (r33.length() != 0) goto L44;
    L58:
        r7.w("NestedFileDownloader", "decrypt file error: illegal params");
        return new lr8.g(3002, null, null, null, null, null, null, null, null, 510);
    L35:
        if (r32.length() == 0) goto L38;
        r13 = false;
        goto L39
    L28:
        if (r33.length() == 0) goto L31;
        r12 = false;
        goto L32
    L21:
        if (r32.length() == 0) goto L24;
        r11 = false;
        goto L25
    L17:
        r9 = false;
    L7:
        r3 = new NestedFileDownloader$decryptFile$1(this, r34);
        goto L8
    }

    public static void e(String r2, int r3, Long r4, String r5, Integer r6) {
        JSONObject r0 = new JSONObject();
        r0.put("stage", r2);
        r0.put("result", r3);
        r0.put("duration", r4);
        r0.put("toskey", r5);
        r0.put("error_code", r6);
        com.larus.platform.service.o.a.reportEvent("message_file_open_stage", r0);
    }

    public final Object c(Context r36, UplinkFileInfo r37, lr8.g r38, String r39, Continuation<? super a> r40) {
        UplinkFileInfo r1 = r37;
        if ((r40 instanceof NestedFileDownloader$download$1) == false) goto L7;
        NestedFileDownloader$download$1 r3 = (NestedFileDownloader$download$1) r40;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r12 = "get_url";
        String r14 = "full";
        switch(r3.label) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        int r9 = r3.I$0;
        ResultKt.throwOnFailure(r2);
        int r5 = r9;
    L152:
        return new a(r5, null, null, (String) r2, 6);
    L13:
        long r6 = r3.J$0;
        String r7 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Object r0 = r10;
    L144:
        lr8.g r8 = (lr8.g) r2;
        int r11 = r8.a;
        if (r11 == 0) goto L147;
        e("download", 1, null, r7, Boxing.boxInt(r11));
        e("full", 1, null, r7, Boxing.boxInt(r8.a));
        return new a(r8.a, r8.f, r8.g, null, 8);
    L147:
        e(r13, 0, null, r7, null);
        e(r14, 0, Boxing.boxLong(System.currentTimeMillis() - r6), r7, null);
        String r13 = r8.h;
        r3.L$0 = null;
        r3.I$0 = 0;
        r3.label = 9;
        r2 = a(r13, r3);
        if (r2 != r0) goto L150;
        return r0;
    L150:
        r5 = 0;
        goto L152
    L14:
        int r15 = r3.I$0;
        ResultKt.throwOnFailure(r2);
        int r16 = r15;
    L135:
        return new a(r16, null, null, (String) r2, 6);
    L15:
        long r17 = r3.J$0;
        String r18 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r24 = "download";
        String r19 = "full";
        NestedFileDownloader r110 = this;
        Object r20 = r10;
    L127:
        lr8.g r21 = (lr8.g) r2;
        int r22 = r21.a;
        if (r22 == 0) goto L130;
        e(r24, 1, null, r18, Boxing.boxInt(r22));
        e(r19, 1, null, r18, Boxing.boxInt(r21.a));
        return new a(r21.a, r21.f, r21.g, null, 8);
    L130:
        e(r24, 0, null, r18, null);
        e(r19, 0, Boxing.boxLong(System.currentTimeMillis() - r17), r18, null);
        String r23 = r21.h;
        r3.L$0 = null;
        r3.I$0 = 0;
        r3.label = 7;
        r2 = r110.a(r23, r3);
        if (r2 != r20) goto L133;
        return r20;
    L133:
        r16 = 0;
        goto L135
    L16:
        long r25 = r3.J$0;
        r18 = (String) r3.L$3;
        String r26 = (String) r3.L$2;
        UplinkFileInfo r27 = (UplinkFileInfo) r3.L$1;
        Context r111 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r28 = r26;
        r12 = "get_url";
        r24 = "download";
        r19 = "full";
        r110 = this;
        r20 = r10;
        Context r29 = r111;
        long r112 = r25;
    L115:
        lr8.g r30 = (lr8.g) r2;
        int r31 = r30.a;
        if (r31 == 0) goto L119;
        e(r12, 1, null, r18, Boxing.boxInt(r31));
        e(r19, 1, null, r18, Boxing.boxInt(r30.a));
        return new a(1001, null, null, null, 14);
    L119:
        e(r12, 0, null, r18, null);
        String r32 = r30.c;
        String r33 = r27.getFileName();
        if (r33 != null) goto L122;
        String r34 = "";
    L123:
        r3.L$0 = r18;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.J$0 = r112;
        r3.label = 6;
        r2 = d(r29, r32, r34, false, r28, r3);
        if (r2 != r20) goto L126;
        return r20;
    L126:
        r17 = r112;
        goto L127
    L122:
        r34 = r33;
        goto L123
    L17:
        int r35 = r3.I$0;
        ResultKt.throwOnFailure(r2);
        int r41 = r35;
    L110:
        return new a(r41, null, null, (String) r2, 6);
    L18:
        long r42 = r3.J$0;
        r18 = (String) r3.L$3;
        String r43 = (String) r3.L$2;
        UplinkFileInfo r113 = (UplinkFileInfo) r3.L$1;
        Context r44 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r210 = "NestedFileDownloader";
        r27 = r113;
        r24 = "download";
        r14 = "full";
        r110 = this;
        r20 = r10;
    L103:
        lr8.g r45 = (lr8.g) r2;
        if (r45.a != 0) goto L111;
        e("decrypt_file", 0, null, r18, null);
        e(r14, 0, Boxing.boxLong(System.currentTimeMillis() - r42), r18, null);
        String r46 = r45.i;
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.I$0 = 0;
        r3.label = 4;
        r2 = r110.a(r46, r3);
        if (r2 != r20) goto L108;
        return r20;
    L108:
        r41 = 0;
        goto L110
    L111:
        r19 = r14;
        FLogger.a.i(r210, "decrypt failed, downgrade to download non-encrypted file");
        e("decrypt_file", 1, null, r18, Boxing.boxInt(r45.a));
        r3.L$0 = r44;
        r3.L$1 = r27;
        r3.L$2 = r43;
        r3.L$3 = r18;
        r3.J$0 = r42;
        r3.label = 5;
        r2 = r110.g(r27, r3);
        if (r2 != r20) goto L114;
        return r20;
    L114:
        r112 = r42;
        r28 = r43;
        r29 = r44;
        goto L115
    L19:
        long r47 = r3.J$0;
        lr8.g r48 = (lr8.g) r3.L$4;
        String r49 = (String) r3.L$3;
        String r50 = (String) r3.L$2;
        UplinkFileInfo r114 = (UplinkFileInfo) r3.L$1;
        Context r51 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r27 = r114;
        lr8.g r52 = r48;
        r18 = r49;
        long r53 = r47;
        Object r54 = r2;
    L68:
        lr8.g r55 = (lr8.g) r54;
        int r115 = r55.a;
        if (r115 == 0) goto L72;
        e("download", 1, null, r18, Boxing.boxInt(r115));
        e("full", 1, null, r18, Boxing.boxInt(r55.a));
        return new a(r55.a, r55.f, r55.g, null, 8);
    L72:
        e("download", 0, null, r18, null);
        String r116 = r55.h;
        if (r116 != null) goto L75;
    L78:
        boolean r117 = true;
    L79:
        if (r117 == false) goto L81;
        r10 = r10;
        r24 = "download";
        r14 = "full";
        r210 = "NestedFileDownloader";
        String r118 = "";
    L96:
        String r56 = r52.e;
        if (r56 != null) goto L99;
        r56 = "";
    L99:
        String r57 = r55.h;
        r3.L$0 = r51;
        r3.L$1 = r27;
        r3.L$2 = r50;
        r3.L$3 = r18;
        r3.L$4 = null;
        r3.J$0 = r53;
        r3.label = 3;
        r110 = this;
        r2 = r110.b(r56, r57, r118, r3);
        r20 = r10;
        if (r2 != r20) goto L102;
        return r20;
    L102:
        r42 = r53;
        r43 = r50;
        r44 = r51;
        goto L103
    L81:
        int r119 = StringsKt.lastIndexOf$default(r116, '/', 0, false, 6, null);
        r24 = "download";
        if (r119 != (-1)) goto L84;
    L94:
        r210 = r7;
    L95:
        r118 = r116;
        goto L96
    L84:
        if (r119 == (r116.length() - 1)) goto L94;
        int r120 = r119 + 1;
        r210 = r7;
        String r121 = r116.substring(0, r120);
        String r122 = r116.substring(r120);
        int r123 = StringsKt.lastIndexOf$default(r122, '.', 0, false, 6, null);
        if (r123 <= 0) goto L95;
        r14 = "full";
        String r124 = r122.substring(0, r123);
        String r125 = r122.substring(r123);
        r10 = r10;
        if (StringsKt.endsWith$default(r124, "_encrypted", false, 2, null) == false) goto L92;
        String r126 = StringsKt.removeSuffix(r124, "_encrypted") + r125;
    L93:
        r118 = r121 + r126;
        goto L96
    L92:
        r126 = r122;
        goto L93
    L75:
        if (r116.length() == 0) goto L78;
        r117 = false;
        goto L79
    L20:
        long r58 = r3.J$0;
        String r59 = (String) r3.L$3;
        String r60 = (String) r3.L$2;
        UplinkFileInfo r61 = (UplinkFileInfo) r3.L$1;
        Context r62 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r63 = r59;
        r1 = r61;
        String r64 = r60;
        Context r65 = r62;
        Object r66 = r2;
    L43:
        String r127 = r63;
        r52 = (lr8.g) r66;
    L44:
        long r310 = r58;
        String r67 = r64;
        int r68 = r52.a;
        if (r68 == 0) goto L50;
        e("get_url", 1, null, r127, Boxing.boxInt(r68));
        e("full", 1, null, r127, Boxing.boxInt(r52.a));
        return new a(1001, null, null, null, 14);
    L50:
        e("get_url", 0, null, r127, null);
        if (Intrinsics.areEqual(r52.d, Boxing.boxBoolean(true)) == false) goto L136;
        String r69 = r52.e;
        if (r69 != null) goto L55;
    L58:
        boolean r70 = true;
    L59:
        if (r70 == true) goto L136;
        FLogger.a.i("NestedFileDownloader", "download and decrypt");
        String r128 = r52.c;
        String r71 = r1.getFileName();
        if (r71 != null) goto L63;
        String r129 = "";
    L64:
        r3.L$0 = r65;
        r3.L$1 = r1;
        r3.L$2 = r67;
        r3.L$3 = r127;
        r3.L$4 = r52;
        r3.J$0 = r310;
        r3.label = 2;
        Context r72 = r65;
        Context r130 = r65;
        String r73 = r129;
        String r131 = r127;
        r54 = d(r72, r128, r73, true, r67, r3);
        if (r54 != r10) goto L67;
        return r10;
    L67:
        r51 = r130;
        r27 = r1;
        r18 = r131;
        r50 = r67;
        r53 = r310;
        goto L68
    L63:
        r129 = r71;
        goto L64
    L55:
        if (r69.length() == 0) goto L58;
        r70 = false;
    L136:
        Context r311 = r65;
        String r132 = r127;
        r0 = r10;
        FLogger.a.i("NestedFileDownloader", "just download");
        String r74 = r52.c;
        String r75 = r1.getFileName();
        if (r75 != null) goto L139;
        String r76 = "";
    L140:
        r3.L$0 = r132;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.J$0 = r310;
        r3.label = 8;
        Object r77 = d(r311, r74, r76, false, r67, r3);
        if (r77 != r0) goto L143;
        return r0;
    L143:
        r6 = r310;
        r2 = r77;
        r7 = r132;
        goto L144
    L139:
        r76 = r75;
        goto L140
    L21:
        ResultKt.throwOnFailure(r2);
        FLogger r78 = FLogger.a;
        r78.i("NestedFileDownloader", "download start");
        FlowFileProtectionService r79 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r79 != null) goto L24;
    L26:
        boolean r80 = false;
    L27:
        if (r80 == false) goto L38;
        r78.i("NestedFileDownloader", "download blocked by enterprise file security");
        com.larus.platform.service.o r81 = com.larus.platform.service.o.a;
        JSONObject r82 = new JSONObject();
        r82.put("action", "open_external");
        r82.put("entry", "nested_file_download");
        r82.put("content_type", "file");
        Unit r83 = Unit.INSTANCE;
        r81.reportEvent("flow_enterprise_file_egress_block", r82);
        String r84 = r79.A0();
        if (r84 == null) goto L37;
        if ((!StringsKt.isBlank(r84)) == false) goto L33;
        String r85 = r84;
    L34:
        if (r85 == null) goto L37;
        t19.s.j(t19.s.a, r36, r85, null, false, 28);
        goto L37
    L33:
        r85 = null;
    L37:
        return new a(2004, null, null, null, 14);
    L38:
        r58 = System.currentTimeMillis();
        r63 = r37.getTosKey();
        if (r38 != null) goto L45;
        r65 = r36;
        r3.L$0 = r65;
        r3.L$1 = r1;
        r64 = r39;
        r3.L$2 = r64;
        r3.L$3 = r63;
        r3.J$0 = r58;
        r3.label = 1;
        r66 = f(r1, r3);
        if (r66 != r10) goto L43;
        return r10;
    L45:
        r65 = r36;
        r64 = r39;
        r127 = r63;
        r52 = r38;
        goto L44
    L24:
        if (r79.I0() != true) goto L26;
        r80 = true;
        goto L27
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r3 = new NestedFileDownloader$download$1(this, r40);
        goto L8
    }

    public static Object d(Context r19, String r20, String r21, boolean r22, String r23, Continuation r24) {
        boolean r1 = true;
        kotlinx.coroutines.j r7 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r24), 1);
        r7.C();
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("download file, urlPresent=");
        if (r20 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        r2.append(!r4);
        r2.append(", fileNamePresent=");
        if (r21.length() <= 0) goto L12;
        boolean r5 = true;
    L13:
        r2.append(r5);
        r2.append(", isEncrypted=");
        r2.append(r22);
        r0.i("NestedFileDownloader", r2.toString());
        if (r20 != null) goto L16;
    L19:
        if (r1 == false) goto L21;
        r0.w("NestedFileDownloader", "download file error: illegal params");
        r7.resumeWith(Result.constructor-impl(new lr8.g(2001, null, null, null, null, null, null, null, null, 510)));
    L22:
        Object r3 = r7.B();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r24);
    L25:
        return r3;
    L21:
        ChatInputService.b.f().c(r19, r20, r21, r22, r23, new b(r21, r7));
        goto L22
    L16:
        if (r20.length() == 0) goto L19;
        r1 = false;
        goto L19
    L12:
        r5 = false;
        goto L13
    L5:
        if (r20.length() == 0) goto L8;
        r4 = false;
        goto L9
    }
}
