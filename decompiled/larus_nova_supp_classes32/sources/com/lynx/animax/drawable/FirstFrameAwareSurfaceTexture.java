package com.lynx.animax.drawable;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.animax.util.AnimaXLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import y4a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FirstFrameAwareSurfaceTexture extends SurfaceTexture implements SurfaceTexture.OnFrameAvailableListener {
    public static final /* synthetic */ int h = 0;
    public WeakReference<a> a;
    public b b;
    public boolean c;
    public WeakReference<TextureView> d;
    public boolean e;
    public boolean f;
    public WeakReference<Surface> g;

    public interface a {
        void onFirstFrameAvailable();
    }

    public static class b extends Handler {
        public final WeakReference<FirstFrameAwareSurfaceTexture> a;
        public final WeakReference<SurfaceTexture.OnFrameAvailableListener> b;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            FirstFrameAwareSurfaceTexture r3 = this.a.get();
            if (r3 != null) goto L5;
            return;
        L5:
            SurfaceTexture.OnFrameAvailableListener r0 = this.b.get();
            if (r0 == null) goto L9;
            r0.onFrameAvailable(r3);
            return;
        }

        public b(Looper r1, FirstFrameAwareSurfaceTexture r2, SurfaceTexture.OnFrameAvailableListener r3) {
            super(r1);
            this.a = new WeakReference(r2);
            this.b = new WeakReference(r3);
        }
    }

    public FirstFrameAwareSurfaceTexture() {
        super(0);
        new Handler(Looper.getMainLooper());
        this.e = false;
        this.f = false;
        super.setOnFrameAvailableListener(this, d.a());
    }

    public final synchronized Surface c() {
        monitor-enter(this);
        WeakReference<Surface> r0 = this.g;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        Surface r1 = r0.get();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r1;
    L7:
        r1 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        Field r1 = SurfaceTexture.class.getDeclaredField("mOnSetFrameRateHandler");     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        if (r1.get(this) != null) goto L12;
        return true;
    L12:
        return false;
    L7:
        th = move-exception;
        AnimaXLog.a("AnimaXFirstFrameAwareSurfaceTexture", "isOnSetFrameRateHandlerNull fail: " + th.getMessage());
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.graphics.SurfaceTexture$OnSetFrameRateListener");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.graphics.SurfaceTexture$OnSetFrameRateListener");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.graphics.SurfaceTexture$OnSetFrameRateListener");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.graphics.SurfaceTexture$OnSetFrameRateListener");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.graphics.SurfaceTexture$OnSetFrameRateListener");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.graphics.SurfaceTexture$OnSetFrameRateListener");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.graphics.SurfaceTexture$OnSetFrameRateListener");
    }

    @Override // android.graphics.SurfaceTexture
    public final synchronized void finalize() throws Throwable {
        monitor-enter(this);
        this.e = true;     // Catch: Throwable -> L13
        Surface r2 = c();     // Catch: Throwable -> L13
        if (r2 != null) goto L8;
    L10:
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "FirstFrameAwareSurfaceTexture finalize: " + this);     // Catch: Throwable -> L13
        super.finalize();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L8:
        if (r2.isValid() == false) goto L10;
        r2.release();     // Catch: Throwable -> L13
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "release Surface in finalize: " + r2);     // Catch: Throwable -> L13
        g(null);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.graphics.SurfaceTexture
    public synchronized void release() {
        monitor-enter(this);
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "release with " + this);     // Catch: Throwable -> L39
        if (this.e == false) goto L10;
        AnimaXLog.d("AnimaXFirstFrameAwareSurfaceTexture", "release() called after finalize(). Skip releasing SurfaceTexture. " + this);     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L10:
        if (this.f == false) goto L15;
        AnimaXLog.d("AnimaXFirstFrameAwareSurfaceTexture", "release() called multiple times. " + this);     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L15:
        this.f = true;     // Catch: Throwable -> L39
        Surface r4 = c();     // Catch: Throwable -> L39
        if (r4 == null) goto L21;
        if (r4.isValid() == false) goto L21;
        r4.release();     // Catch: Throwable -> L39
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "release Surface: " + r4);     // Catch: Throwable -> L39
        g(null);     // Catch: Throwable -> L39
    L21:
        if (Build.VERSION.SDK_INT >= 26) goto L23;
    L42:
        Field r0 = SurfaceTexture.class.getDeclaredField("mSurfaceTexture");     // Catch: Throwable -> L29
        r0.setAccessible(true);     // Catch: Throwable -> L29
        long r2 = r0.getLong(this);     // Catch: Throwable -> L29
    L32:
        if (r2 != 0) goto L36;
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "surfaceTextureField is 0, skip release");     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L36:
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "release SurfaceTexture: " + this);     // Catch: Throwable -> L39
        super.release();     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L29:
        th = move-exception;
        AnimaXLog.a("AnimaXFirstFrameAwareSurfaceTexture", "fail to getSurfaceTextureField: " + th.getMessage());     // Catch: Throwable -> L39
        r2 = -1;
        goto L32
    L23:
        if (isReleased() == false) goto L42;
        AnimaXLog.d("AnimaXFirstFrameAwareSurfaceTexture", "already released: " + this);     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public static void b(Object r10) throws Exception {
        if (r10 != null) goto L6;
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "clearMiuiStubCallbackIfNeeded: Skipped, stub is null.");
        return;
    L6:
        Field r1 = r10.getClass().getDeclaredField("mOnFrameAvailableHandler");
        r1.setAccessible(true);
        Object r3 = r1.get(r10);
        Field r4 = r10.getClass().getDeclaredField("mUpdateListener");
        r4.setAccessible(true);
        Object r5 = r4.get(r10);
        Method r6 = r10.getClass().getMethod("setOnFrameAvailableHandler", new Class[]{Handler.class});
        r6.setAccessible(true);
        r6.invoke(r10, new Object[]{null});
        r4.set(r10, null);
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "clearMiuiStubCallbackIfNeeded: Finished cleanup, origin handler: " + r3 + ", origin update listener: " + r5 + ", current handler: " + r1.get(r10) + ", current update listener: " + r4.get(r10));
    }

    public final synchronized void g(Surface r2) {
        monitor-enter(this);
        this.g = new WeakReference(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r4) {
        b r5 = this.b;
        if (r5 == null) goto L9;
        Message r6 = r5.obtainMessage(0);
        if (Build.VERSION.SDK_INT < 22) goto L7;
        r6.setAsynchronous(true);
    L7:
        this.b.sendMessage(r6);
    L9:
        if (this.c == true) goto L18;
        this.c = true;
        WeakReference<a> r7 = this.a;
        if (r7 == null) goto L13;
        a r8 = r7.get();
    L14:
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "trigger first frame callback with " + r8);
        if (r8 == null) goto L19;
        r8.onFirstFrameAvailable();
        return;
    L19:
        return;
    L13:
        r8 = null;
        goto L14
    }

    @Override // android.graphics.SurfaceTexture
    public final void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r2) {
        e(r2, null);
    }

    public final void e(SurfaceTexture.OnFrameAvailableListener r5, Handler r6) {
        if (Build.VERSION.SDK_INT < 25) goto L22;
        if (r5 == null) goto L22;
        if (this.b == null) goto L22;
        WeakReference<TextureView> r0 = this.d;
        if (r0 == null) goto L12;
        final TextureView r1 = r0.get();
    L13:
        if (r1 == null) goto L22;
        Runnable r2 = new s4a.a(r1);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L21;
        r2.run();
        goto L22
    L21:
        d.a().post(r2);
        goto L22
    L18:
        r3 = false;
        goto L19
    L12:
        r1 = null;
    L22:
        if (r5 == null) goto L27;
        if (r6 == null) goto L25;
        Looper r7 = r6.getLooper();
    L26:
        this.b = new b(r7, this, r5);
        return;
    L25:
        r7 = Looper.getMainLooper();
        goto L26
    L27:
        this.b = null;
    }

    @Override // android.graphics.SurfaceTexture
    public final void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r2, Handler r3) {
        e(r2, r3);
        if (Build.VERSION.SDK_INT < 35) goto L7;
        final WeakReference r4 = new WeakReference(this);
        AnimaXLog.b("AnimaXFirstFrameAwareSurfaceTexture", "clearInternalFrameRateListenerAsync: Posting cleanup action");
        Runnable r5 = new s4a.b(r4);
        d.a().post(r5);
        return;
    }
}
