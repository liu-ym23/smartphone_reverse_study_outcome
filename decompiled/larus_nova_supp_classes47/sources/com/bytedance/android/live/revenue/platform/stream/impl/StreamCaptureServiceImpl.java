package com.bytedance.android.live.revenue.platform.stream.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.scope.o;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.SingleSubject;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class StreamCaptureServiceImpl implements o, d01.c {
    public boolean a;
    public final yz0.g b;
    public final com.bytedance.android.livesdk.revenue.service.room.c c;

    public static final class a {
    }

    public static final class b {
        public final Bitmap.CompressFormat a;
        public final int b;

        public b(Bitmap.CompressFormat r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "format");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final Surface a;
        public final int b;
        public final int c;

        public c(Surface r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "surface");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ StreamCaptureServiceImpl a;
        public final /* synthetic */ d01.c.a b;

        public d(StreamCaptureServiceImpl r1, d01.c.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            Intrinsics.checkNotNullParameter(r5, "bitmap");
            d01.c.a r1 = this.b;
            b r0 = new b(r1.a, r1.b);
            StreamCaptureServiceImpl r2 = this.a;
            r2.getClass();
            return Single.create(new g(r2, r0, r5)).subscribeOn(Schedulers.io());
        }
    }

    public static final class e<T, R> implements Function {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r2) {
            File r3 = (File) r2;
            Intrinsics.checkNotNullParameter(r3, "file");
            return new d01.c.b(r3);
        }
    }

    public static final class f<T1, T2> implements ttc.a {
        public final /* synthetic */ u0 a;

        public f(u0 r1) {
            this.a = r1;
        }

        public final void accept(Object r6, Object r7) {
            d01.c.b r8 = (d01.c.b) r6;
            Throwable r9 = (Throwable) r7;
            u0 r0 = u0.f;
            long r1 = t0.b().b(this.a).a;
            if (r8 == null) goto L5;
            jy0.b.a("StreamCaptureService", "captureVideoFrame finished in " + r1 + "ms: " + r8.a);
            return;
        L5:
            StringBuilder r10 = new StringBuilder("captureVideoFrame failed in ");
            r10.append(r1);
            r10.append("ms: ");
            if (r9 == null) goto L8;
            String r12 = r9.getMessage();
        L9:
            r10.append(r12);
            jy0.b.a("StreamCaptureService", r10.toString());
            return;
        L8:
            r12 = null;
            goto L9
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    private final Context getContext() {
        return this.b.getContext();
    }

    public final PolarisFileWrapper c() {
        return new PolarisFileWrapper(getContext().getCacheDir(), "live/stream_capture/pid");
    }

    public final c d() {
        ILivePlayerClient r0 = LivePlatformPlayerManager.c(IRoomKtKt.getId(this.b.mo444getRoom()), false).player();
        Surface r1 = null;
        if (r0 == null) goto L5;
        IRenderView r2 = r0.getRenderView();
    L6:
        if (r2 == null) goto L15;
        SurfaceHolder r3 = r2.getSurfaceHolder();
        if (r3 == null) goto L10;
        r1 = r3.getSurface();
    L10:
        if (r1 == null) goto L14;
        return new c(r1, r2.getWidth(), r2.getHeight());
    L14:
        throw new IllegalStateException("player surface is not present");
    L15:
        com.bytedance.android.livesdk.revenue.pushstream.a r4 = (com.bytedance.android.livesdk.revenue.pushstream.a) this.c.getRoomContext().getLiveStream().getValue();
        if (r4 == null) goto L24;
        View r5 = r4.getSurfaceView();
        if ((r5 instanceof SurfaceView) == false) goto L22;
        SurfaceView r6 = (SurfaceView) r5;
        return new c(r6.getHolder().getSurface(), r6.getWidth(), r6.getHeight());
    L22:
        throw new IllegalStateException("surfaceView type check fail: " + r5);
    L24:
        throw new IllegalStateException("liveStream is null");
    L5:
        r2 = null;
        goto L6
    }

    @Override // d01.c
    public final Single<d01.c.b> a(d01.c.a r7) {
        Intrinsics.checkNotNullParameter(r7, "request");
        u0 r0 = u0.f;
        u0 r1 = t0.b();
        if (this.b.isAnchor() == true) goto L22;
        final ILivePlayerClient r2 = LivePlatformPlayerManager.c(IRoomKtKt.getId(this.b.mo444getRoom()), false).player();
        if (r2 == null) goto L7;
        Single r3 = Single.create(new StreamCaptureServiceImpl$captureVideoFrame$bitmap$1(r2));
    L21:
        return r3.flatMap(new d(this, r7)).map(e.a).doOnEvent(new f(r1));
    L7:
        return Single.error(new IllegalStateException("LivePlayerClient is null"));
    L22:
        c r4 = d();     // Catch: Throwable -> L18
        Bitmap r5 = Bitmap.createBitmap(r4.b, r4.c, Bitmap.Config.ARGB_8888);
        Surface r6 = r4.a;
        if (Build.VERSION.SDK_INT >= 24) goto L24;
        Single r8 = Single.error(new IllegalStateException("PixelCopy is not supported on this device"));
    L17:
        r3 = r8.flatMap(new com.bytedance.android.live.revenue.platform.stream.impl.d(r5));
        goto L21
    L24:
        Handler r9 = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L15
        Single r10 = SingleSubject.create();     // Catch: Throwable -> L15
        PixelCopy.request(r6, r5, new com.bytedance.android.live.revenue.platform.stream.impl.f(r10), r9);     // Catch: Throwable -> L15
        r8 = r10;
    L15:
        th = move-exception;
        r8 = Single.error(th);
    L18:
        th = move-exception;
        r3 = Single.error(th);
        goto L21
    }

    public StreamCaptureServiceImpl(yz0.g r2, com.bytedance.android.livesdk.revenue.service.room.c r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "revRoomService");
        this.b = r2;
        this.c = r3;
    }
}
