package com.ss.android.lark.keyboard.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.ResourceFile;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.keyboard.base.ImageCompressInfo;
import com.ss.android.lark.keyboard.base.ResourceUploadInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.checker.VideoSendChecker;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowSendMessageUtils {
    public static final FlowSendMessageUtils a = null;

    static {
        a = new FlowSendMessageUtils();
    }

    public FlowSendMessageUtils() {
    }

    public static ResourceFile.FileType c(UplinkFileEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "entity");
        if (wxa.f.d(r1) == false) goto L6;
        return ResourceFile.FileType.IMAGE;
    L6:
        if (wxa.f.c(r1) == false) goto L9;
        return ResourceFile.FileType.FILE;
    L9:
        if (wxa.f.e(r1) == true) goto L15;
        ResourceFile.FileType r2 = ResourceFile.DEFAULT_FILE_TYPE;
        Intrinsics.checkNotNull(r2);
        return r2;
    L15:
        return ResourceFile.FileType.MEDIA;
    }

    public final Object a(String r7, Continuation<? super f> r8) {
        if ((r8 instanceof FlowSendMessageUtils$getFlowImageInfo$1) == false) goto L7;
        FlowSendMessageUtils$getFlowImageInfo$1 r0 = (FlowSendMessageUtils$getFlowImageInfo$1) r8;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L21:
        ImageInfo r10 = (ImageInfo) r9;
        if (r10 != null) goto L25;
        Log.e("FlowSendMessageUtils", "getFlowImageInfo error, imageInfo is null, filePath: " + r7);
        return null;
    L25:
        int r4 = r10.a;
        if (r4 <= 0) goto L32;
        int r5 = r10.b;
        if (r5 <= 0) goto L32;
        return new f(r4, r5);
    L32:
        Log.e("FlowSendMessageUtils", "getFlowImageInfo error, width: " + r10.a + ", height: " + r10.b + ", filePath: " + r7);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (TextUtils.isEmpty(r7) == false) goto L18;
        Log.e("FlowSendMessageUtils", "getFlowImageInfo error, filePath is empty");
        return null;
    L18:
        CoroutineDispatcher r11 = Dispatchers.getIO();
        FlowSendMessageUtils$getFlowImageInfo$imageInfo$1 r6 = new FlowSendMessageUtils$getFlowImageInfo$imageInfo$1(r7, null);
        r0.L$0 = r7;
        r0.label = 1;
        r9 = BuildersKt.withContext(r11, r6, r0);
        if (r9 != r2) goto L21;
        return r2;
    L7:
        r0 = new FlowSendMessageUtils$getFlowImageInfo$1(this, r8);
        goto L8
    }

    public final Object b(Context r20, String r21, String r22, UplinkFileEntity r23, ConcurrentHashMap<String, ResourceUploadInfo> r24, Continuation<? super g> r25) {
        String r2 = r21;
        String r3 = r22;
        UplinkFileEntity r4 = r23;
        ConcurrentHashMap<String, ResourceUploadInfo> r5 = r24;
        if ((r25 instanceof FlowSendMessageUtils$handleResourceBeforeUpload$1) == false) goto L7;
        FlowSendMessageUtils$handleResourceBeforeUpload$1 r7 = (FlowSendMessageUtils$handleResourceBeforeUpload$1) r25;
        int r8 = r7.label;
        if ((r8 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r7.label = r8 - Target.SIZE_ORIGINAL;
    L8:
        Object r6 = r7.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r13 = "";
        switch(r7.label) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResourceFile.FileType r1 = (ResourceFile.FileType) r7.L$1;
        String r10 = (String) r7.L$0;
        ResultKt.throwOnFailure(r6);
        r13 = "";
    L80:
        String r11 = (String) r6;
        Log.i("FlowSendMessageUtils", "compress video, originPath: " + r10 + ", compressPath: " + r11);
        if (r11 != null) goto L83;
        String r14 = r13;
    L85:
        return new g(r1, r14);
    L83:
        r14 = r11;
        goto L85
    L13:
        r1 = (ResourceFile.FileType) r7.L$5;
        ConcurrentHashMap<String, ResourceUploadInfo> r12 = (ConcurrentHashMap) r7.L$4;
        UplinkFileEntity r15 = (UplinkFileEntity) r7.L$3;
        String r16 = (String) r7.L$2;
        String r17 = (String) r7.L$1;
        Context r18 = (Context) r7.L$0;
        ResultKt.throwOnFailure(r6);
        r5 = r12;
        r2 = r17;
    L75:
        if (((VideoSendChecker.Result) r6) != VideoSendChecker.Result.VALID) goto L86;
        FlowMediaCompressHelper r19 = FlowMediaCompressHelper.a;
        r7.L$0 = r16;
        r7.L$1 = r1;
        r7.L$2 = null;
        r7.L$3 = null;
        r7.L$4 = null;
        r7.L$5 = null;
        r7.label = 6;
        r6 = r19.a(r18, r15, r16, r2, r7);
        if (r6 != r9) goto L79;
        return r9;
    L79:
        r10 = r16;
        goto L80
    L86:
        String r26 = r15.getFileIdentifier();
        if (r26 == null) goto L89;
        r5.put(r26, new ResourceUploadInfo(ResourceFile.FileType.FILE, null, 2, null));
    L91:
        return new g(ResourceFile.FileType.FILE, r16);
    L89:
        Log.e("FlowSendMessageUtils", "fileIdentifier is null");
        goto L91
    L14:
        String r27 = (String) r7.L$4;
        ResourceFile.FileType r28 = (ResourceFile.FileType) r7.L$3;
        ConcurrentHashMap<String, ResourceUploadInfo> r29 = (ConcurrentHashMap) r7.L$2;
        UplinkFileEntity r30 = (UplinkFileEntity) r7.L$1;
        String r31 = (String) r7.L$0;
        ResultKt.throwOnFailure(r6);
        r13 = "";
    L56:
        f r32 = (f) r6;
        if (r32 == null) goto L63;
        ImageCompressInfo r33 = new ImageCompressInfo(r31, r32.a, r32.b);
        String r34 = r30.getFileIdentifier();
        if (r34 == null) goto L61;
        r29.put(r34, new ResourceUploadInfo(r28, r33));
        goto L63
    L61:
        Log.e("FlowSendMessageUtils", "fileIdentifier is null");
    L63:
        if (r27 != null) goto L65;
        String r110 = r13;
    L67:
        return new g(r28, r110);
    L65:
        r110 = r27;
        goto L67
    L15:
        ResourceFile.FileType r35 = (ResourceFile.FileType) r7.L$3;
        ConcurrentHashMap<String, ResourceUploadInfo> r36 = (ConcurrentHashMap) r7.L$2;
        UplinkFileEntity r37 = (UplinkFileEntity) r7.L$1;
        String r38 = (String) r7.L$0;
        ResultKt.throwOnFailure(r6);
        r31 = r38;
        r13 = "";
    L16:
        r30 = r37;
        r29 = r36;
        r28 = r35;
        r27 = (String) r6;
        Log.i("FlowSendMessageUtils", "compress image, originPath: " + r31 + ", compressPath: " + r27);
        r7.L$0 = r31;
        r7.L$1 = r30;
        r7.L$2 = r29;
        r7.L$3 = r28;
        r7.L$4 = r27;
        r7.label = 4;
        r6 = a(r27, r7);
        if (r6 != r9) goto L56;
        return r9;
    L17:
        r35 = (ResourceFile.FileType) r7.L$5;
        r36 = (ConcurrentHashMap) r7.L$4;
        r37 = (UplinkFileEntity) r7.L$3;
        String r39 = (String) r7.L$2;
        String r40 = (String) r7.L$1;
        Context r41 = (Context) r7.L$0;
        ResultKt.throwOnFailure(r6);
        r13 = "";
    L37:
        alb.a r42 = (alb.a) r6;
        Log.i("FlowSendMessageUtils", "FileTypeChecker, " + r42.a);
        if (r42.a() == true) goto L46;
        String r43 = r37.getFileIdentifier();
        if (r43 == null) goto L42;
        r36.put(r43, new ResourceUploadInfo(ResourceFile.FileType.FILE, null, 2, null));
    L44:
        return new g(ResourceFile.FileType.FILE, r39);
    L42:
        Log.e("FlowSendMessageUtils", "fileIdentifier is null");
        goto L44
    L46:
        if (Intrinsics.areEqual(r37.isOriginalImageChecked(), Boxing.boxBoolean(true)) == false) goto L49;
        Log.i("FlowSendMessageUtils", "isOriginalImageChecked: true");
        return new g(r35, r39);
    L49:
        FlowMediaCompressHelper r44 = FlowMediaCompressHelper.a;
        r7.L$0 = r39;
        r7.L$1 = r37;
        r7.L$2 = r36;
        r7.L$3 = r35;
        r7.L$4 = null;
        r7.L$5 = null;
        r7.label = 3;
        r6 = r44.a(r41, r37, r39, r40, r7);
        if (r6 != r9) goto L52;
        return r9;
    L52:
        r31 = r39;
        goto L16
    L18:
        ImageUploadTask r45 = (ImageUploadTask) r7.L$6;
        ResourceFile.FileType r46 = (ResourceFile.FileType) r7.L$5;
        ConcurrentHashMap<String, ResourceUploadInfo> r47 = (ConcurrentHashMap) r7.L$4;
        r4 = (UplinkFileEntity) r7.L$3;
        String r48 = (String) r7.L$2;
        String r49 = (String) r7.L$1;
        Context r111 = (Context) r7.L$0;
        ResultKt.throwOnFailure(r6);
        r5 = r47;
        r3 = r48;
    L25:
        alb.a r50 = (alb.a) r6;
        Log.i("FlowSendMessageUtils", "FileSizeChecker, " + r50.a);
        if (r50.a() == true) goto L33;
        String r51 = r4.getFileIdentifier();
        if (r51 == null) goto L30;
        r5.put(r51, new ResourceUploadInfo(ResourceFile.FileType.FILE, null, 2, null));
    L32:
        return new g(ResourceFile.FileType.FILE, r3);
    L30:
        Log.e("FlowSendMessageUtils", "fileIdentifier is null");
        goto L32
    L33:
        CoroutineDispatcher r52 = Dispatchers.getIO();
        FlowSendMessageUtils$handleResourceBeforeUpload$fileTypeCheckResult$1 r112 = new FlowSendMessageUtils$handleResourceBeforeUpload$fileTypeCheckResult$1(r45, null);
        r7.L$0 = r111;
        r7.L$1 = r49;
        r7.L$2 = r3;
        r7.L$3 = r4;
        r7.L$4 = r5;
        r7.L$5 = r46;
        r7.L$6 = null;
        r7.label = 2;
        r6 = BuildersKt.withContext(r52, r112, r7);
        if (r6 != r9) goto L36;
        return r9;
    L36:
        r35 = r46;
        r36 = r5;
        r40 = r49;
        r41 = r111;
        UplinkFileEntity r113 = r4;
        r39 = r3;
        r37 = r113;
        goto L37
    L19:
        ResultKt.throwOnFailure(r6);
        ResourceFile.FileType r53 = c(r23);
        Log.i("FlowSendMessageUtils", "handleResourceBeforeUpload, uploadId: " + r2 + ", fileType: " + r53 + ", localPath: " + r3);
        if (wxa.f.d(r23) == false) goto L69;
        flb.a.C0262a r54 = new flb.a.C0262a();
        flb.a r114 = new flb.a(r54.a, r54.b);
        ImageUploadTask r55 = new ImageUploadTask(r20);
        r55.d = r114;
        com.ss.android.lark.image.uploader.entity.b.a r115 = new com.ss.android.lark.image.uploader.entity.b.a();
        Intrinsics.checkNotNullParameter(r3, "path");
        r115.a = r3;
        com.ss.android.lark.image.uploader.entity.b r116 = r115.b();
        Intrinsics.checkNotNullParameter(r116, LoadParams.ImageFormat.IMAGE);
        r55.b.add(r116);
        CoroutineDispatcher r117 = Dispatchers.getIO();
        FlowSendMessageUtils$handleResourceBeforeUpload$fileSizeCheckResult$1 r118 = new FlowSendMessageUtils$handleResourceBeforeUpload$fileSizeCheckResult$1(r55, null);
        r7.L$0 = r20;
        r7.L$1 = r2;
        r7.L$2 = r3;
        r7.L$3 = r4;
        r7.L$4 = r5;
        r7.L$5 = r53;
        r7.L$6 = r55;
        r7.label = 1;
        Object r119 = BuildersKt.withContext(r117, r118, r7);
        if (r119 != r9) goto L24;
        return r9;
    L24:
        r111 = r20;
        r45 = r55;
        r49 = r2;
        r46 = r53;
        r6 = r119;
        goto L25
    L69:
        if (wxa.f.e(r23) == false) goto L93;
        CoroutineDispatcher r56 = Dispatchers.getIO();
        FlowSendMessageUtils$handleResourceBeforeUpload$result$1 r120 = new FlowSendMessageUtils$handleResourceBeforeUpload$result$1(r3, null);
        r7.L$0 = r20;
        r7.L$1 = r2;
        r7.L$2 = r3;
        r7.L$3 = r4;
        r7.L$4 = r5;
        r7.L$5 = r53;
        r7.label = 5;
        Object r57 = BuildersKt.withContext(r56, r120, r7);
        if (r57 != r9) goto L73;
        return r9;
    L73:
        r18 = r20;
        r1 = r53;
        r6 = r57;
        r16 = r3;
        r15 = r4;
        goto L75
    L93:
        return new g(c(r23), r3);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r7 = new FlowSendMessageUtils$handleResourceBeforeUpload$1(this, r25);
        goto L8
    }
}
