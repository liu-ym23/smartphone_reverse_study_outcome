package com.lynx.animax.player;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.util.AnimaXLog;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements SurfaceTexture.OnFrameAvailableListener, IVideoPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VideoAsset f9673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceTexture f9674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f9675c;
    public float[] d;
    public boolean e;
    public int f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f9677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ReentrantLock f9679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Condition f9680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f9681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f9682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f9683o;

    public i(e r5) {
        this.e = false;
        this.f = 0;
        this.g = false;
        this.f9676h = false;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AbsVideoPlayer", "create: " + this);
        this.f9677i = r5;
        ReentrantLock r10 = new ReentrantLock();
        this.f9679k = r10;
        this.f9680l = r10.newCondition();
        this.f9683o = false;
        Looper r11 = Looper.myLooper();
        if (r11 == null) goto L5;
        this.f9682n = new Handler(r11);
    L5:
        a(new g(this, 0));
        if (r5.f9665a > 0) goto L9;
        r5.f9665a = 20;
    L9:
        if (r5.f9666b > 0) goto L12;
        r5.f9666b = 1000;
        return;
    }

    public final void a(Runnable r5) {
        if (this.f9683o == false) goto L6;
        return;
    L6:
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (b.d != null) goto L14;
        b r10 = new b(0);     // Catch: Throwable -> L12
        b.d = r10;     // Catch: Throwable -> L12
        if (((HandlerThread) r10.f9657b) != null) goto L14;
        HandlerThread r11 = new HandlerThread("Animax_Codec", -4);     // Catch: Throwable -> L12
        r10.f9657b = r11;     // Catch: Throwable -> L12
        r11.start();     // Catch: Throwable -> L12
        r10.f9658c = new Handler(((HandlerThread) r10.f9657b).getLooper());     // Catch: Throwable -> L12
    L14:
        b r12 = b.d;     // Catch: Throwable -> L12
        monitor-exit(b.class);     // Catch: Throwable -> L12
        if (((Handler) r12.f9658c) != null) goto L21;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "CodecThreadManager", "Attempted to post to codec thread after it was released or not alive.");
        return;
    L21:
        if (Looper.myLooper() != ((Handler) r12.f9658c).getLooper()) goto L24;
        r5.run();
        return;
    L24:
        ((Handler) r12.f9658c).post(r5);
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public final void attachAsset(VideoAsset r5) {
        if (this.f9673a == null) goto L5;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AbsVideoPlayer", "Attach asset more than once");
    L11:
        boolean r10 = false;
        ab.b r11 = new ab.b(18, this, r10, r5);
        a(new ab.b(21, this, r10, r11));
        return;
    L5:
        if (r5 != null) goto L7;
    L10:
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AbsVideoPlayer", "attachAsset error: asset isn't valid");
        goto L11
    L7:
        if (r5.f9643c == false) goto L10;
        this.f9673a = r5;
        goto L11
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public final void destroy() {
        if (this.f9683o == false) goto L5;
        return;
    L5:
        this.f9683o = true;
        CountDownLatch r5 = new CountDownLatch(1);
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (b.d != null) goto L14;
        b r10 = new b(0);     // Catch: Throwable -> L12
        b.d = r10;     // Catch: Throwable -> L12
        if (((HandlerThread) r10.f9657b) != null) goto L14;
        HandlerThread r11 = new HandlerThread("Animax_Codec", -4);     // Catch: Throwable -> L12
        r10.f9657b = r11;     // Catch: Throwable -> L12
        r11.start();     // Catch: Throwable -> L12
        r10.f9658c = new Handler(((HandlerThread) r10.f9657b).getLooper());     // Catch: Throwable -> L12
    L14:
        b r12 = b.d;     // Catch: Throwable -> L12
        monitor-exit(b.class);     // Catch: Throwable -> L12
        ab.b r13 = new ab.b(19, this, false, r5);
        Handler r14 = (Handler) r12.f9658c;
        if (r14 != null) goto L19;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "CodecThreadManager", "Attempted to post to codec thread after it was released or not alive.");
    L43:
        long r15 = this.f9677i.f9666b;     // Catch: InterruptedException -> L24
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "VideoPlayerImpl", "destroy: wait for codec thread to complete destroy tasks with " + r15 + "ms");     // Catch: InterruptedException -> L24
        if (r5.await(r15, TimeUnit.MILLISECONDS) == true) goto L25;
        AnimaXLog.a(AnimaXLog.LogLevel.f9714b, "VideoPlayerImpl", "Timeout waiting for codec thread to complete destroy tasks");     // Catch: InterruptedException -> L24
    L25:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AbsVideoPlayer", "destroy: " + this);
        this.f9673a = null;
        Surface r16 = this.f9675c;
        if (r16 == null) goto L28;
        r16.release();
        this.f9675c = null;
    L28:
        SurfaceTexture r17 = this.f9674b;
        if (r17 == null) goto L32;
        r17.setOnFrameAvailableListener(null);
        this.f9674b.release();
        this.f9674b = null;
    L32:
        if (this.f <= 0) goto L45;
        String r18 = "[" + i.class.getName() + "]: Error has occurred, mHasDrewOnce: " + this.g + ", mHasDrewOnceAfterError: " + this.f9676h;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AbsVideoPlayer", "Error(" + this.f + "): " + r18);
        IAnimaXMonitorService r19 = (IAnimaXMonitorService) ((b) this.f9677i.f9667c).c(IAnimaXMonitorService.class);
        if (r19 == null) goto L46;
        HashMap r20 = new HashMap();
        r20.put("code", 4);
        r20.put("msg", r18);
        r20.put("error_count", Integer.valueOf(this.f));
        r19.reportError(new dm.a(r20));
        return;
    L46:
        return;
    L45:
        return;
    L24:
        AnimaXLog.a(AnimaXLog.LogLevel.f9714b, "VideoPlayerImpl", "Interrupted while waiting for codec thread to complete destroy tasks");
        Thread.currentThread().interrupt();
        goto L25
    L19:
        r14.removeCallbacksAndMessages(null);
        ((Handler) r12.f9658c).postAtFrontOfQueue(r13);
        goto L43
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public final float[] getTransformMatrix() {
        if (this.d != null) goto L5;
        this.d = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    L5:
        SurfaceTexture r5 = this.f9674b;
        if (r5 == null) goto L9;
        r5.getTransformMatrix(this.d);
    L9:
        return this.d;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r5) {
        ReentrantLock r10 = this.f9679k;
        r10.lock();
        this.f9678j = true;
        this.f9680l.signalAll();     // Catch: Throwable -> L6
        r10.unlock();
        return;
    L6:
        th = move-exception;
        r10.unlock();
        throw th;
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public final void setSurface(int r5) {
        Surface r10 = this.f9675c;
        if (r10 == null) goto L5;
        r10.release();
        this.f9675c = null;
    L5:
        SurfaceTexture r11 = this.f9674b;
        if (r11 == null) goto L8;
        r11.setOnFrameAvailableListener(null);
        this.f9674b.release();
        this.f9674b = null;
    L8:
        this.f9674b = new SurfaceTexture(r5);
        this.f9675c = new Surface(this.f9674b);
        this.f9678j = false;
        this.f9674b.setOnFrameAvailableListener(this, jm.c.a());
        if (this.f9673a != null) goto L12;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoPlayerImpl", "setSurface error: mAsset is null");
        return;
    L12:
        int r12 = 21;
        boolean r13 = false;
        a(new ab.b(r12, this, r13, new g(this, 1)));
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public final boolean updateSurface(int r10) {
        if (this.f9683o == false) goto L5;
        return false;
    L5:
        a(new ab.b(21, this, false, new h(this, r10)));
        if (this.f9682n == null) goto L26;
        if (Looper.myLooper() != this.f9682n.getLooper()) goto L26;
        this.f9679k.lock();
        if (this.f9678j == false) goto L29;
        this.f9678j = false;
        this.f9679k.unlock();
        boolean r11 = true;
    L21:
        if (r11 == true) goto L23;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoPlayerImpl", "await onFrameAvailable time out");
        return false;
    L23:
        this.f9674b.updateTexImage();
        return true;
    L29:
        this.f9680l.await(this.f9677i.f9665a, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L13 InterruptedException -> L15
    L17:
        r11 = this.f9678j;
        this.f9678j = false;
        this.f9679k.unlock();
        goto L21
    L15:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoPlayerImpl", "await onFrameAvailable error: " + e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.f9678j = false;
        this.f9679k.unlock();
        throw th;
    L26:
        throw new IllegalStateException("Must be called on GL thread, current: " + Thread.currentThread().getName());
    }
}
