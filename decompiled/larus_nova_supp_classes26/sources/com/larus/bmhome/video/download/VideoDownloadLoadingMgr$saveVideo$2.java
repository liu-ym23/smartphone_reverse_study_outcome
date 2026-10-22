package com.larus.bmhome.video.download;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.download.VideoDownloadLoadingMgr$saveVideo$2", f = "VideoDownloadLoadingMgr.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoDownloadLoadingMgr$saveVideo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $finalPath;
    final /* synthetic */ boolean $isAIGC;
    final /* synthetic */ g $videoContent;
    int label;
    final /* synthetic */ VideoDownloadLoadingMgr this$0;

    public VideoDownloadLoadingMgr$saveVideo$2(VideoDownloadLoadingMgr r1, String r2, boolean r3, Context r4, g r5, Continuation<? super VideoDownloadLoadingMgr$saveVideo$2> r6) {
        this.this$0 = r1;
        this.$finalPath = r2;
        this.$isAIGC = r3;
        this.$context = r4;
        this.$videoContent = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new VideoDownloadLoadingMgr$saveVideo$2(this.this$0, this.$finalPath, this.$isAIGC, this.$context, this.$videoContent, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Uri> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L56;
        ResultKt.throwOnFailure(r10);
        FLogger.a.i(this.this$0.b, "[saveVideo] finalPath " + this.$finalPath);
        if (this.$isAIGC == false) goto L8;
        int r11 = com.larus.platform.service.e.a;
        com.larus.platform.service.e.b(this.$finalPath);
    L8:
        if (Build.VERSION.SDK_INT > 28) goto L53;
        VideoDownloadLoadingMgr r12 = this.this$0;
        Context r0 = this.$context;
        String r2 = this.$finalPath;
        String r3 = r12.g(this.$videoContent);
        PolarisFileWrapper r5 = new PolarisFileWrapper(r2);
        String r4 = r.h() + File.separator + System.currentTimeMillis() + r3;
        PolarisFileWrapper r6 = new PolarisFileWrapper(r4);
        PolarisFileInputStreamWrapper r7 = null;
        PolarisFileInputStreamWrapper r8 = new PolarisFileInputStreamWrapper(r5);     // Catch: Throwable -> L29 Exception -> L31
        BufferedOutputStream r9 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r6));     // Catch: Throwable -> L24 Exception -> L27
    L62:
        byte[] r13 = new byte[1024];     // Catch: Exception -> L22 Throwable -> L42
    L14:
        int r14 = r8.read(r13);     // Catch: Exception -> L22 Throwable -> L42
        if (r14 <= 0) goto L17;
        r9.write(r13, 0, r14);     // Catch: Exception -> L22 Throwable -> L42
        goto L14
    L17:
        PolarisFileInputStreamWrapper r1 = r.u(r0, r4, false);     // Catch: Exception -> L22 Throwable -> L42
        r8.close();     // Catch: IOException -> L20
        r7 = r1;
    L39:
        r9.close();     // Catch: IOException -> L36
        return r7;
    L36:
        e = move-exception;
        IOException e = e;
    L41:
        FLogger.a.e(r12.b, "finally close stream failed", e);
        return r7;
    L20:
        e = e;
        r7 = r1;
    L22:
        e = e;
    L33:
        FLogger.a.e(r12.b, "saveVideoToAlbumBeforeQ failed", e);     // Catch: Throwable -> L42
        if (r8 != null) goto L60;
    L38:
        if (r9 != null) goto L39;
        return null;
    L60:
        r8.close();     // Catch: IOException -> L36
    L27:
        e = e;
        r9 = null;
    L24:
        th = th;
        r5 = null;
    L26:
        r7 = r8;
    L44:
        if (r7 != null) goto L64;
    L48:
        if (r5 == null) goto L52;
        r5.close();     // Catch: IOException -> L46
    L46:
        e = move-exception;
        FLogger.a.e(r12.b, "finally close stream failed", e);
    L52:
        throw th;
    L64:
        r7.close();     // Catch: IOException -> L46
        goto L48
    L42:
        th = th;
    L31:
        e = e;
        r9 = null;
        r8 = null;
    L29:
        th = th;
        r5 = null;
        goto L44
    L53:
        char r15 = r.a;
        return r.u(this.$context, this.$finalPath, false);
    L56:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
