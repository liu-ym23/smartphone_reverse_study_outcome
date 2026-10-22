package com.lynx.clay.embedding.android;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.android.webview.chromium.DrawFunctor;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.AutoEndConversationTime;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FunctorView extends FrameLayout {
    public static Method m;
    public static Method n;
    public static Method o;
    public static Method p;
    public static Method q;
    public static boolean r;
    public static boolean s;
    public static boolean t;
    public static boolean u;
    public long a;
    public boolean b;
    public a c;
    public long d;
    public long e;
    public long f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final boolean l;

    public class a implements ComponentCallbacks2 {
        public final /* synthetic */ FunctorView a;

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r1) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public a(FunctorView r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r7) {
            FunctorView r0 = this.a;
            if (r0.e != (-1)) goto L6;
            return;
        L6:
            if (r7 < 40) goto L9;
            r0.k();
            return;
        }
    }

    private native long[] nativeCreateGLFunctor(long r1, boolean r3);

    private native void nativeDestroyDrawFunctor(long r1);

    private native void nativeUpdateSharedImage(long r1);

    public native void nativeSetSharedImageSink(long r1, long r3);

    public void notifyFunctorPresent(long r1) {
    }

    public static synchronized boolean f() {
        monitor-enter(FunctorView.class);
    L56:
        th = move-exception;
        throw th;
    L6:
        if (p == null) goto L65;
        monitor-exit(FunctorView.class);
        return true;
    L65:
        int r7 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L16
        if (r7 >= 29) goto L59;
        Class r8 = c("android.view.ViewRootImpl");     // Catch: Throwable -> L16
        Class<?> r11 = Long.TYPE;     // Catch: Throwable -> L16
        Method r9 = r8.getDeclaredMethod("invokeFunctor", new Class[]{r11, Boolean.TYPE});     // Catch: Throwable -> L16
        m = r9;     // Catch: Throwable -> L16
        r9.setAccessible(true);     // Catch: Throwable -> L16
        Method r10 = r8.getDeclaredMethod("detachFunctor", new Class[]{r11});     // Catch: Throwable -> L16
        n = r10;     // Catch: Throwable -> L16
        r10.setAccessible(true);     // Catch: Throwable -> L16
        if (r7 > 23) goto L59;
        Method r12 = c("android.view.View").getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: Throwable -> L16
        o = r12;     // Catch: Throwable -> L16
        r12.setAccessible(true);     // Catch: Throwable -> L16
    L59:
        int r2 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L50
        if (r2 < 29) goto L36;
        c5a.b.a().a.getFlutterJNI().loadLibrary(null);     // Catch: Throwable -> L30
        if (SystemLoaderFaker.loadLibrary("webviewchromium_plat_support", "_ZN7android19RegisterDrawFunctorEP7_JNIEnv") == true) goto L34;
        Class r3 = d(WebView.getWebViewClassLoader());     // Catch: Throwable -> L30
        q = r3.getDeclaredMethod("getDrawFnFunctionTable", new Class[0]);     // Catch: Throwable -> L27
    L28:
        q.setAccessible(true);     // Catch: Throwable -> L30
    L27:
        q = r3.getDeclaredMethod("nativeGetFunctionTable", new Class[0]);     // Catch: Throwable -> L30
    L34:
        p = c("android.graphics.RecordingCanvas").getMethod("drawWebViewFunctor", new Class[]{Integer.TYPE});     // Catch: Throwable -> L50
    L47:
        p.setAccessible(true);     // Catch: Throwable -> L50
        monitor-exit(FunctorView.class);
        return true;
    L30:
        th = move-exception;
        if (s == true) goto L34;
        s = true;     // Catch: Throwable -> L50
        c5a.c.f("FunctorView", "Failed to load WebView draw functor support; falling back to platform canvas API. sdk=" + Build.VERSION.SDK_INT, th);     // Catch: Throwable -> L50
        goto L34
    L36:
        if (r2 <= 28) goto L39;
        p = c("android.graphics.RecordingCanvas").getMethod("callDrawGLFunction2", new Class[]{Long.TYPE});     // Catch: Throwable -> L50
        goto L47
    L39:
        if (r2 <= 22) goto L42;
        p = c("android.view.DisplayListCanvas").getMethod("callDrawGLFunction2", new Class[]{Long.TYPE});     // Catch: Throwable -> L50
        goto L47
    L42:
        if (r2 != 21) goto L44;
        p = c("android.view.HardwareCanvas").getMethod("callDrawGLFunction", new Class[]{Long.TYPE});     // Catch: Throwable -> L50
        goto L47
    L44:
        if (r2 != 22) goto L46;
        p = c("android.view.HardwareCanvas").getMethod("callDrawGLFunction2", new Class[]{Long.TYPE});     // Catch: Throwable -> L50
        goto L47
    L46:
        p = c("android.view.HardwareCanvas").getMethod("callDrawGLFunction", new Class[]{Integer.TYPE});     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        if (t == true) goto L55;
        t = true;     // Catch: Throwable -> L56
        c5a.c.f("FunctorView", "Failed to resolve draw GL function. sdk=" + Build.VERSION.SDK_INT, th);     // Catch: Throwable -> L56
    L55:
        return false;
    L16:
        th = move-exception;
        if (r == true) goto L59;
        r = true;     // Catch: Throwable -> L56
        c5a.c.f("FunctorView", "Failed to initialize pre-Q functor reflection methods. sdk=" + Build.VERSION.SDK_INT, th);     // Catch: Throwable -> L56
        goto L59
    }

    public final void e() {
        if (this.e != (-1)) goto L6;
        return;
    L6:
        if (this.a != (-1)) goto L8;
        return;
    L8:
        long r0 = System.currentTimeMillis() - this.a;
        if (r0 < AutoEndConversationTime.AFTER_10_SECONDS) goto L11;
        k();
        return;
    L11:
        if (this.b == false) goto L13;
        return;
    L13:
        this.b = true;
        final WeakReference r4 = new WeakReference(this);
        Runnable r5 = new h(r4);
        long r2 = AutoEndConversationTime.AFTER_10_SECONDS - r0;
        com.lynx.clay.util.a.a().postDelayed(r5, r2);
    }

    public void g() {
        if (this.d == (-1)) goto L6;
        k();
        nativeDestroyDrawFunctor(this.d);
        this.d = -1;
        this.e = -1;
    L6:
        if (this.f == (-1)) goto L9;
        this.f = -1;
        return;
    }

    public final void h() {
        if (this.d != (-1)) goto L5;
    L6:
        boolean r0 = this.l;
        if (f() == true) goto L9;
        long[] r1 = {-1, -1};
    L23:
        this.d = r1[0];
        this.e = r1[1];
        return;
    L9:
        if (Build.VERSION.SDK_INT >= 29) goto L25;
        r1 = nativeCreateGLFunctor(0, r0);
        goto L23
    L25:
        Method r2 = q;     // Catch: Throwable -> L16
        if (r2 != null) goto L13;
        long r5 = DrawFunctor.a();     // Catch: Throwable -> L16
    L14:
        r1 = nativeCreateGLFunctor(r5, r0);     // Catch: Throwable -> L16
        goto L23
    L13:
        r5 = ((Long) r2.invoke(null, new Object[0])).longValue();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (u == true) goto L20;
        u = true;
        c5a.c.f("FunctorView", "Failed to create WebView functor, returning unavailable sentinel. sdk=" + Build.VERSION.SDK_INT + ", syncMode=" + r0, th);
    L20:
        r1 = new long[]{-1, -1};
        goto L23
    L5:
        if (this.e == (-1)) goto L6;
    }

    public final void k() {
        if (Build.VERSION.SDK_INT < 29) goto L44;
    L14:
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 29) goto L37;
        if (r0 <= 23) goto L19;
        Method r1 = m;
        if (r1 == null) goto L37;
        long r8 = this.e;
        if (r8 == (-1)) goto L37;
        r1.invoke(null, new Object[]{Long.valueOf(r8), Boolean.TRUE});     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        i(th);
        goto L37
    L19:
        if (m == null) goto L37;
        Method r2 = o;
        if (r2 == null) goto L37;
        if (this.e == (-1)) goto L37;
        Object r3 = r2.invoke(this, new Object[0]);     // Catch: Throwable -> L26
        m.invoke(r3, new Object[]{Long.valueOf(this.e), Boolean.TRUE});     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        i(th);
    L37:
        if (Build.VERSION.SDK_INT >= 29) goto L46;
        postInvalidateOnAnimation();
        return;
    L46:
        return;
    L44:
    L12:
        th = move-exception;
        c5a.c.f("FunctorView", "Failed to detach functor via reflection.", th);
        goto L14
    L5:
        if (n == null) goto L14;
        Method r4 = o;     // Catch: Throwable -> L12
        if (r4 == null) goto L14;
        if (this.e == (-1)) goto L14;
        Object r5 = r4.invoke(this, new Object[0]);     // Catch: Throwable -> L12
        n.invoke(r5, new Object[]{Long.valueOf(this.e)});     // Catch: Throwable -> L12
        goto L14
    }

    public final void l() {
        if (this.f == (-1)) goto L9;
        long r0 = this.d;
        if (r0 == (-1)) goto L10;
        nativeUpdateSharedImage(r0);
        return;
    L10:
        return;
    }

    public void notifyResourcesDestroyed() {
        if (this.g == true) goto L6;
        this.g = true;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c != null) goto L6;
        this.c = new a(this);
        getContext().registerComponentCallbacks(this.c);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.c == null) goto L6;
        getContext().unregisterComponentCallbacks(this.c);
        this.c = null;
        return;
    }

    public FunctorView(Context r2) {
        this(r2, null);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class d(ClassLoader r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r4 = r3.loadClass("com.android.webview.chromium.DrawFunctor");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.android.webview.chromium.DrawFunctor");     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.android.webview.chromium.DrawFunctor");
    L12:
        throw th;
    L34:
        Class<?> r5 = r3.loadClass("com.android.webview.chromium.DrawFunctor");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.android.webview.chromium.DrawFunctor");     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.android.webview.chromium.DrawFunctor");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass("com.android.webview.chromium.DrawFunctor");
    }

    private void setWindowVisibilityInternal(boolean r4) {
        boolean r0 = this.j;
        if (Build.VERSION.SDK_INT > 21) goto L8;
        if (r4 == false) goto L8;
        if (this.k == true) goto L8;
        boolean r1 = true;
    L9:
        this.j = r0 | r1;
        this.k = r4;
        if (r4 == false) goto L12;
        long r2 = -1;
    L13:
        this.a = r2;
        if (r4 == true) goto L17;
        e();
        return;
    L17:
        return;
    L12:
        r2 = System.currentTimeMillis();
    L8:
        r1 = false;
        goto L9
    }

    public final void i(Throwable r4) {
        if (this.i == false) goto L5;
        return;
    L5:
        this.i = true;
        c5a.c.f("FunctorView", "Failed to invoke GL functor for reclaim. sdk=" + Build.VERSION.SDK_INT + ", handle=" + this.e, r4);
    }

    public final boolean j(Canvas r7) {
        h();
        long r0 = this.e;
        if (r0 != (-1)) goto L16;
        return false;
    L16:
    L11:
        th = move-exception;
        if (this.h == true) goto L15;
        this.h = true;
        c5a.c.f("FunctorView", "Failed to request GL functor draw. sdk=" + Build.VERSION.SDK_INT + ", handle=" + this.e + ", syncMode=" + this.l, th);
    L15:
        return false;
    L7:
        if (Build.VERSION.SDK_INT >= 29) goto L9;
        p.invoke(r7, new Object[]{Long.valueOf(r0)});     // Catch: Throwable -> L11
    L10:
        return true;
    L9:
        p.invoke(r7, new Object[]{Integer.valueOf((int) r0)});     // Catch: Throwable -> L11
        goto L10
    }

    @Override // android.view.View
    public void onDraw(Canvas r2) {
        super.onDraw(r2);
        if (r2.isHardwareAccelerated() == false) goto L8;
        if (j(r2) == true) goto L8;
        return;
    L8:
        if (this.j == false) goto L11;
        getRootView().invalidate();
        this.j = false;
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r2) {
        if (r2 != 0) goto L4;
        boolean r3 = true;
    L6:
        if (this.k != r3) goto L8;
        return;
    L8:
        setWindowVisibilityInternal(r3);
        return;
    L4:
        r3 = false;
        goto L6
    }

    public void setSharedImageSink(long r6) {
        h();
        long r0 = this.d;
        if (r0 != (-1)) goto L5;
        return;
    L5:
        nativeSetSharedImageSink(r0, r6);
        this.f = r6;
    }

    public FunctorView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public FunctorView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, false);
    }

    public FunctorView(Context r2, AttributeSet r3, int r4, boolean r5) {
        super(r2, r3, r4);
        this.a = -1;
        this.b = false;
        this.c = null;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = true;
        this.l = false;
        this.l = r5;
        setWillNotDraw(false);
        h();
    }
}
