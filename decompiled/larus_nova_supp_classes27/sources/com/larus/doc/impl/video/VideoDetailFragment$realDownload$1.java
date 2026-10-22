package com.larus.doc.impl.video;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.i1;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.video.VideoDetailFragment$realDownload$1", f = "VideoDetailFragment.kt", i = {0}, l = {274, 287}, m = "invokeSuspend", n = {"videoPath"}, s = {"L$0"})
public final class VideoDetailFragment$realDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $resultPath;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ VideoDetailFragment this$0;

    /* JADX INFO: renamed from: com.larus.doc.impl.video.VideoDetailFragment$realDownload$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.impl.video.VideoDetailFragment$realDownload$1$1", f = "VideoDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $videoPath;
        int label;
        final /* synthetic */ VideoDetailFragment this$0;

        public AnonymousClass1(Ref.ObjectRef<String> r1, VideoDetailFragment r2, Continuation<? super AnonymousClass1> r3) {
            this.$videoPath = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$videoPath, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r3);
            if (this.$videoPath.element == null) goto L7;
            s r4 = s.a;
            Context r1 = this.this$0.getContext();
            r4.getClass();
            s.o(r1, 2131908983, false);
        L8:
            VideoDetailFragment r5 = this.this$0;
            int r2 = VideoDetailFragment.l;
            r5.S90().I4(false);
            this.this$0.f = false;
            return Unit.INSTANCE;
        L7:
            s r6 = s.a;
            Context r7 = this.this$0.getContext();
            r6.getClass();
            s.b(r7, 2131908982, false);
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public VideoDetailFragment$realDownload$1(VideoDetailFragment r1, String r2, Continuation<? super VideoDetailFragment$realDownload$1> r3) {
        this.this$0 = r1;
        this.$resultPath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VideoDetailFragment$realDownload$1(this.this$0, this.$resultPath, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        PolarisFileInputStreamWrapper r4 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L75:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r3 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r14);
    L16:
        r2.element = r14;
        if (r3.element != null) goto L19;
    L71:
        MainCoroutineDispatcher r15 = Dispatchers.getMain();
        AnonymousClass1 r5 = new AnonymousClass1(r3, this.this$0, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (BuildersKt.withContext(r15, r5, this) != r0) goto L75;
        return r0;
    L19:
        if (Build.VERSION.SDK_INT > 28) goto L66;
        VideoDetailFragment r16 = this.this$0;
        Application r6 = AppHost.a.getApplication();
        String r7 = (String) r3.element;
        int r8 = VideoDetailFragment.l;
        r16.getClass();
        PolarisFileWrapper r9 = new PolarisFileWrapper(r7);
        String r10 = i1.b() + File.separator + System.currentTimeMillis() + ".mp4";
        PolarisFileWrapper r11 = new PolarisFileWrapper(r10);
        PolarisFileInputStreamWrapper r12 = new PolarisFileInputStreamWrapper(r9);     // Catch: Throwable -> L38 Exception -> L40
        BufferedOutputStream r13 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r11));     // Catch: Throwable -> L33 Exception -> L36
    L79:
        byte[] r17 = new byte[1024];     // Catch: Exception -> L31 Throwable -> L55
    L25:
        int r18 = r12.read(r17);     // Catch: Exception -> L31 Throwable -> L55
        if (r18 <= 0) goto L28;
        r13.write(r17, 0, r18);     // Catch: Exception -> L31 Throwable -> L55
        goto L25
    L28:
        Uri r20 = i1.f(r6, r10, false);     // Catch: Exception -> L31 Throwable -> L55
        r12.close();     // Catch: IOException -> L52
    L50:
        r13.close();     // Catch: IOException -> L52
    L67:
        if (r20 == null) goto L69;
        String r110 = r20.toString();
    L70:
        r3.element = r110;
        goto L71
    L69:
        r110 = null;
    L52:
        e = move-exception;
        Uri r21 = r20;
        e = e;
    L54:
        FLogger.a.e("VideoDetailFragment", "finally close stream failed", e);
        r20 = r21;
    L31:
        e = e;
    L42:
        FLogger.a.e("VideoDetailFragment", "saveVideoToAlbumBeforeQ failed", e);     // Catch: Throwable -> L55
        if (r12 != null) goto L77;
    L48:
        r20 = null;
        if (r13 == null) goto L67;
    L77:
        r12.close();     // Catch: IOException -> L46
    L46:
        e = e;
        r21 = null;
    L36:
        e = e;
        r13 = null;
    L33:
        th = th;
        r9 = null;
    L35:
        r4 = r12;
    L57:
        if (r4 != null) goto L81;
    L61:
        if (r9 == null) goto L65;
        r9.close();     // Catch: IOException -> L59
    L59:
        e = move-exception;
        FLogger.a.e("VideoDetailFragment", "finally close stream failed", e);
    L65:
        throw th;
    L81:
        r4.close();     // Catch: IOException -> L59
        goto L61
    L55:
        th = th;
    L40:
        e = e;
        r13 = null;
        r12 = null;
    L38:
        th = th;
        r9 = null;
        goto L57
    L66:
        r20 = i1.f(AppHost.a.getApplication(), (String) r3.element, false);
        goto L67
    L10:
        ResultKt.throwOnFailure(r14);
        r2 = new Ref.ObjectRef();
        VideoDetailFragment r111 = this.this$0;
        Application r22 = AppHost.a.getApplication();
        VideoDetailFragment r23 = this.this$0;
        String r24 = r23.i;
        String r25 = this.$resultPath;
        String r26 = r23.j;
        this.L$0 = r2;
        this.L$1 = r2;
        this.label = 1;
        r111.getClass();
        kotlinx.coroutines.j r112 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r112.C();
        DownloadTask r27 = Downloader.with(r22).url(r24).savePath(r25).name(System.currentTimeMillis() + '.' + r26).subThreadListener(new n(r112));
        r112.i(new m(r27, r22));
        r27.asyncDownload(null);
        r14 = r112.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        DebugProbesKt.probeCoroutineSuspended(this);
    L13:
        if (r14 != r0) goto L15;
        return r0;
    L15:
        r3 = r2;
        goto L16
    }
}
