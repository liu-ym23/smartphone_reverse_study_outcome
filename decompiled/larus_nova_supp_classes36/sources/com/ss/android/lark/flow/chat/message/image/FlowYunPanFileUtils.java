package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.util.LruCache;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowYunPanFileUtils {
    public static final FlowYunPanFileUtils a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public FlowYunPanFileUtils() {
    }

    static {
        a = new FlowYunPanFileUtils();
        b = LazyKt.lazy(FlowYunPanFileUtils$yunPanImageLocalPathCache$2.INSTANCE);
        c = LazyKt.lazy(FlowYunPanFileUtils$yunPanCoverLocalPathCache$2.INSTANCE);
    }

    public static final Object b(String r3, Continuation r4) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r0.C();
        ((com.bytedance.ee.drive.preview.f) k.a(LarkContext.getApplication(), com.bytedance.ee.drive.preview.f.class)).y7().fetchDriveImagePreview(r3, new j(r0));
        Object r5 = r0.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r5;
    }

    public static final PolarisFileWrapper c(String r4, FlowYunPanCoverType r5) {
        boolean r1 = true;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L20;
        String r6 = r4 + '_' + r5.getType();
        Lazy r7 = c;
        String r2 = (String) ((LruCache) r7.getValue()).get(r6);
        if (r2 != null) goto L11;
    L14:
        if (r1 == true) goto L20;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2);
        if (r3.exists() == true) goto L22;
        ((LruCache) r7.getValue()).remove(r6);
        goto L20
    L22:
        return r3;
    L11:
        if (r2.length() == 0) goto L14;
        r1 = false;
    L20:
        return null;
    L5:
        r0 = false;
        goto L6
    }

    public final Object f(String r8, String r9, Continuation<? super File> r10) {
        if ((r10 instanceof FlowYunPanFileUtils$driveDownloadImageWithFile$1) == false) goto L7;
        FlowYunPanFileUtils$driveDownloadImageWithFile$1 r0 = (FlowYunPanFileUtils$driveDownloadImageWithFile$1) r10;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L27:
        String r12 = (String) r11;
        if (TextUtils.isEmpty(r12) == false) goto L30;
        return null;
    L30:
        PolarisFileWrapper r13 = new PolarisFileWrapper(r12);
        if (r13.exists() == true) goto L33;
        return null;
    L33:
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        Log.i("FlowYunPanFileUtils", "driveDownloadImageWithFile, token: " + r8.hashCode() + ", localPath: " + r9);
        boolean r6 = false;
        if (r8.length() != 0) goto L17;
        boolean r14 = true;
    L18:
        if (r14 == false) goto L20;
    L34:
        Log.e("FlowYunPanFileUtils", "token or localPath is empty, token: " + r8.hashCode() + ", localPath: " + r9);
        return null;
    L20:
        if (r9.length() != 0) goto L22;
        r6 = true;
    L22:
        if (r6 == true) goto L34;
        CoroutineDispatcher r15 = Dispatchers.getIO();
        FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1 r4 = new FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1(r8, r9, null);
        r0.label = 1;
        r11 = BuildersKt.withContext(r15, r4, r0);
        if (r11 != r2) goto L27;
        return r2;
    L17:
        r14 = false;
    L7:
        r0 = new FlowYunPanFileUtils$driveDownloadImageWithFile$1(this, r10);
        goto L8
    }

    public static final Object a(FlowYunPanFileUtils r26, String r27, final String r28, Continuation r29) {
        r26.getClass();
        if ((r29 instanceof FlowYunPanFileUtils$driveDownloadImageInner$1) == false) goto L7;
        FlowYunPanFileUtils$driveDownloadImageInner$1 r2 = (FlowYunPanFileUtils$driveDownloadImageInner$1) r29;
        int r3 = r2.label;
        if ((r3 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r2.label = r3 - Target.SIZE_ORIGINAL;
    L8:
        Object r0 = r2.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        String r1 = (String) r2.L$1;
        String r5 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L21:
        return (String) r0;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r2.L$0 = r27;
        r2.L$1 = r28;
        r2.label = 1;
        final kotlinx.coroutines.j r6 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r2), 1);
        r6.C();
        DrivePriority.DownloadPriority r7 = DrivePriority.DownloadPriority.DEFAULT;
        r7.getPriority();
        DownloadRequestInfo.DownloadType r8 = DownloadRequestInfo.DownloadType.DRIVE;
        DriveBizScene r10 = DriveBizScene.DriveBizScene_UNKNOWN;
        int r11 = r7.getPriority();
        DownloadRequestInfo.DownloadType r12 = DownloadRequestInfo.DownloadType.IMG;
        DriveBizScene r19 = DriveBizScene.DriveBizScene_IM;
        FlowYunPanFileUtils$driveDownloadImageInner$1 r22 = r2;
        DownloadRequestInfo r13 = new DownloadRequestInfo(r28, r27, "", "explorer", r11, "", r12, "", 0, false, "", 2, new FlowYunPanFileUtils$driveDownloadImageInner$downloadFilePath$1$requestInfo$1$1(r6, r28), null, false, null, null, r19, null);
        ((com.bytedance.ee.bear.drive.sdk.service.f) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().g(r13);
        r0 = r6.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        DebugProbesKt.probeCoroutineSuspended(r22);
    L18:
        if (r0 != r9) goto L21;
        return r9;
    L7:
        r2 = new FlowYunPanFileUtils$driveDownloadImageInner$1(r26, r29);
        goto L8
    }

    public final Object e(Context r16, String r17, boolean r18, Continuation<? super File> r19) {
        if ((r19 instanceof FlowYunPanFileUtils$downloadYunPanPictureWithFile$1) == false) goto L7;
        FlowYunPanFileUtils$downloadYunPanPictureWithFile$1 r1 = (FlowYunPanFileUtils$downloadYunPanPictureWithFile$1) r19;
        int r2 = r1.label;
        if ((r2 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r1.label = r2 - Target.SIZE_ORIGINAL;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r5 = r1.J$0;
        String r6 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L18:
        File r7 = (File) r0;
        Log.i("FlowYunPanFileUtils", "downloadYunPanPictureWithFile, token: " + r6.hashCode() + ", total cost: " + (System.currentTimeMillis() - r5));
        return r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        long r13 = System.currentTimeMillis();
        CoroutineDispatcher r8 = Dispatchers.getIO();
        FlowYunPanFileUtils$downloadYunPanPictureWithFile$file$1 r9 = new FlowYunPanFileUtils$downloadYunPanPictureWithFile$file$1(r17, r18, r13, r16, null);
        r1.L$0 = r17;
        r1.J$0 = r13;
        r1.label = 1;
        r0 = BuildersKt.withContext(r8, r9, r1);
        if (r0 != r3) goto L17;
        return r3;
    L17:
        r6 = r17;
        r5 = r13;
    L7:
        r1 = new FlowYunPanFileUtils$downloadYunPanPictureWithFile$1(this, r19);
        goto L8
    }

    public final Object d(Context r15, String r16, FlowYunPanCoverType r17, boolean r18, Continuation<? super File> r19) {
        if ((r19 instanceof FlowYunPanFileUtils$downloadYunPanPictureCoverFile$1) == false) goto L7;
        FlowYunPanFileUtils$downloadYunPanPictureCoverFile$1 r1 = (FlowYunPanFileUtils$downloadYunPanPictureCoverFile$1) r19;
        int r2 = r1.label;
        if ((r2 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r1.label = r2 - Target.SIZE_ORIGINAL;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r5 = r1.J$0;
        String r6 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L18:
        File r7 = (File) r0;
        Log.i("FlowYunPanFileUtils", "downloadYunPanPictureCoverFile, token: " + r6.hashCode() + ", total cost: " + (System.currentTimeMillis() - r5));
        return r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        long r8 = System.currentTimeMillis();
        CoroutineDispatcher r9 = Dispatchers.getIO();
        FlowYunPanFileUtils$downloadYunPanPictureCoverFile$file$1 r10 = new FlowYunPanFileUtils$downloadYunPanPictureCoverFile$file$1(r16, r17, r18, r15, null);
        r1.L$0 = r16;
        r1.J$0 = r8;
        r1.label = 1;
        r0 = BuildersKt.withContext(r9, r10, r1);
        if (r0 != r3) goto L17;
        return r3;
    L17:
        r5 = r8;
        r6 = r16;
    L7:
        r1 = new FlowYunPanFileUtils$downloadYunPanPictureCoverFile$1(this, r19);
        goto L8
    }
}
