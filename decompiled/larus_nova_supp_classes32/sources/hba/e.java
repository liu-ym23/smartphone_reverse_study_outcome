package hba;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.AttachedSurfaceControl;
import android.view.SurfaceControl;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.activation.presentation.runtime.surface.ObricRootSurfaceEvent;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final e a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public static final class a implements g, View.OnAttachStateChangeListener {
        public final View a;
        public final f b;
        public boolean c;
        public Object d;
        public Object e;
        public boolean f;

        public final void b() {
            if (this.f == true) goto L5;
            return;
        L5:
            this.f = false;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
            this.b.onRootSurfaceDestroyed();     // Catch: Throwable -> L8
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        public final void c() {
            e();
            e.a.getClass();     // Catch: Throwable -> L16
            Class r1 = (Class) e.b.getValue();     // Catch: Throwable -> L16
            if (r1 == null) goto L15;
            final AttachedSurfaceControl r2 = this.a.getRootSurfaceControl();     // Catch: Throwable -> L16
            if (r2 == null) goto L13;
            Object r3 = Proxy.newProxyInstance(r1.getClassLoader(), new Class[]{r1}, new d(this, r2));     // Catch: Throwable -> L16
            Method r4 = e.g(r2.getClass(), "addSurfaceChangedCallback", new Class[]{r1});     // Catch: Throwable -> L16
            if (r4 == null) goto L11;
            r4.invoke(r2, new Object[]{r3});     // Catch: Throwable -> L16
            this.d = r2;     // Catch: Throwable -> L16
            this.e = r3;     // Catch: Throwable -> L16
            a(r2, ObricRootSurfaceEvent.INITIAL, null);     // Catch: Throwable -> L16
            return;
        L11:
            throw new NoSuchMethodException("addSurfaceChangedCallback");     // Catch: Throwable -> L16
        L13:
            throw new IllegalStateException("rootSurfaceControl unavailable");     // Catch: Throwable -> L16
        L15:
            throw new ClassNotFoundException("ViewRootImpl.SurfaceChangedCallback");     // Catch: Throwable -> L16
        L16:
            th = th;
            e();
            Throwable r5 = th.getCause();
            if (r5 == null) goto L21;
            th = r5;
        L21:
            d("reflection_".concat(th.getClass().getSimpleName()));
        }

        @Override // hba.g
        public final void close() {
            if (this.c == false) goto L5;
            return;
        L5:
            this.c = true;
            this.a.removeOnAttachStateChangeListener(this);
            e();
            b();
        }

        public final void e() {
            Object r0 = this.d;
            Object r1 = this.e;
            Object r2 = null;
            this.d = null;
            this.e = null;
            if (r0 == null) goto L19;
            if (r1 == null) goto L20;
            e.a.getClass();
            Class r3 = (Class) e.b.getValue();
            if (r3 != null) goto L17;
            return;
        L17:
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
            Method r5 = e.g(r0.getClass(), "removeSurfaceChangedCallback", new Class[]{r3});     // Catch: Throwable -> L14
            if (r5 == null) goto L12;
            r2 = r5.invoke(r0, new Object[]{r1});     // Catch: Throwable -> L14
        L12:
            Result.constructor-impl(r2);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        L20:
            return;
        }

        public final void d(String r2) {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            this.b.onRootSurfaceUnavailable(r2);     // Catch: Throwable -> L4
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            if (this.c == true) goto L6;
            c();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            e();
            b();
        }

        public a(View r2, f r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "listener");
            this.a = r2;
            this.b = r3;
        }

        public final void a(Object r7, ObricRootSurfaceEvent r8, SurfaceControl.Transaction r9) {
            if (this.c == false) goto L5;
            return;
        L5:
            if (this.d == r7) goto L8;
            return;
        L8:
            if (r8 == ObricRootSurfaceEvent.INITIAL) goto L12;
            if (r9 != null) goto L12;
            d("missing_callback_transaction");
            return;
        L12:
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L23
            e.a.getClass();     // Catch: Throwable -> L23
            Method r2 = e.g(r7.getClass(), "getSurfaceControl", new Class[0]);     // Catch: Throwable -> L23
            if (r2 == null) goto L16;
            Object r10 = r2.invoke(r7, new Object[0]);     // Catch: Throwable -> L23
        L18:
            if ((r10 instanceof SurfaceControl) == false) goto L20;
            SurfaceControl r11 = (SurfaceControl) r10;     // Catch: Throwable -> L23
        L21:
            Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L23
        L26:
            if (Result.isFailure-impl(r12) == true) goto L29;
            r0 = r12;
        L29:
            SurfaceControl r3 = (SurfaceControl) r0;
            e.a.getClass();
            if (e.e(r3) == false) goto L32;
            this.f = true;
            f r13 = this.b;     // Catch: Throwable -> L42
            if (r3 == null) goto L41;
            r13.onRootSurfaceAvailable(r3, r8, r9);     // Catch: Throwable -> L42
            Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L42
        L44:
            Throwable r15 = Result.exceptionOrNull-impl(r14);
            if (r15 == null) goto L52;
            d("listener_".concat(r15.getClass().getSimpleName()));
            return;
        L52:
            return;
        L41:
            throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L44
        L32:
            if (r8 != ObricRootSurfaceEvent.INITIAL) goto L34;
            return;
        L34:
            b();
            d("invalid_root_surface");
            return;
        L20:
            r11 = null;
            goto L21
        L16:
            r10 = null;
        L23:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L26
        }
    }

    public e() {
    }

    static {
        a = new e();
        b = LazyKt.lazy(new hba.a());
        c = LazyKt.lazy(new b());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.view.ViewRootImpl$SurfaceChangedCallback");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.ViewRootImpl$SurfaceChangedCallback");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.ViewRootImpl$SurfaceChangedCallback");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.view.ViewRootImpl$SurfaceChangedCallback");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.ViewRootImpl$SurfaceChangedCallback");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.ViewRootImpl$SurfaceChangedCallback");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.ViewRootImpl$SurfaceChangedCallback");
    }

    public static boolean e(SurfaceControl r2) {
        if (r2 != null) goto L15;
    L13:
        return false;
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(Boolean.valueOf(r2.isValid()));     // Catch: Throwable -> L5
    L7:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r3) == false) goto L11;
        r3 = r1;
    L11:
        if (((Boolean) r3).booleanValue() == false) goto L13;
        return true;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static boolean c(SurfaceControl.Transaction r2, SurfaceControl r3) {
        Intrinsics.checkNotNullParameter(r2, "transaction");
        Intrinsics.checkNotNullParameter(r3, "root");
        if (e(r3) == true) goto L14;
        return false;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        r2.setLayer(r3, 0);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L7
    L9:
        Boolean r5 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L13;
        r4 = r5;
    L13:
        return ((Boolean) r4).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static boolean d(View r3, SurfaceControl.Transaction r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "transaction");
        if (r3.isAttachedToWindow() == false) goto L25;
        Looper r0 = Looper.myLooper();
        Handler r2 = r3.getHandler();
        if (r2 == null) goto L7;
        Looper r5 = r2.getLooper();
    L8:
        if (r0 != r5) goto L25;
        AttachedSurfaceControl r1 = r3.getRootSurfaceControl();
        if (r1 != null) goto L26;
        return false;
    L26:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L18
        boolean r7 = r1.applyTransactionOnDraw(r4);     // Catch: Throwable -> L18
        if (r7 == false) goto L16;
        r3.invalidate();     // Catch: Throwable -> L18
    L16:
        Object r8 = Result.constructor-impl(Boolean.valueOf(r7));     // Catch: Throwable -> L18
    L20:
        Boolean r9 = Boolean.FALSE;
        if (Result.isFailure-impl(r8) == false) goto L24;
        r8 = r9;
    L24:
        return ((Boolean) r8).booleanValue();
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L7:
        r5 = null;
    L25:
        return false;
    }

    public static g f(View r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "listener");
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 35) goto L6;
        r3.onRootSurfaceUnavailable("unsupported_sdk_" + r0);
        return new c();
    L6:
        a r1 = new a(r2, r3);
        if (Looper.myLooper() != null) goto L9;
    L19:
        r1.d("wrong_thread");
    L20:
        return r1;
    L9:
        if (r1.a.isAttachedToWindow() == false) goto L16;
        Looper r4 = Looper.myLooper();
        Handler r5 = r1.a.getHandler();
        if (r5 == null) goto L13;
        Looper r6 = r5.getLooper();
    L14:
        if (r4 == r6) goto L16;
    L13:
        r6 = null;
    L16:
        r1.a.addOnAttachStateChangeListener(r1);
        if (r1.a.isAttachedToWindow() == false) goto L20;
        r1.c();
        goto L20
    }

    public static boolean b(SurfaceControl.Transaction r3, SurfaceControl r4, SurfaceControl r5) {
        Intrinsics.checkNotNullParameter(r3, "transaction");
        Intrinsics.checkNotNullParameter(r4, "childRoot");
        Intrinsics.checkNotNullParameter(r5, "mainRoot");
        if (e(r5) == true) goto L5;
    L19:
        return false;
    L5:
        if (e(r4) == false) goto L19;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Method r1 = (Method) c.getValue();     // Catch: Throwable -> L12
        if (r1 == null) goto L11;
        r1.invoke(r3, new Object[]{r5, r4, -1});     // Catch: Throwable -> L12
        Object r6 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L12
    L14:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L18;
        r6 = r7;
    L18:
        return ((Boolean) r6).booleanValue();
    L11:
        throw new NoSuchMethodException("SurfaceControl.Transaction#setRelativeLayer");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static Method g(Class r9, String r10, Class... r11) {
        Class<?> r1 = new Class[0].getClass();
        Object r2 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
        Method r3 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, r1});     // Catch: Throwable -> L12
        r3.setAccessible(true);     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L12
        Object r0 = r3.invoke(r9, new Object[]{r10, r11});     // Catch: Throwable -> L12
        if ((r0 instanceof Method) == false) goto L6;
        Method r5 = (Method) r0;     // Catch: Throwable -> L12
    L7:
        if (r5 == null) goto L9;
        r5.setAccessible(true);     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r6) == false) goto L17;
        r6 = null;
    L17:
        Method r7 = (Method) r6;
        if (r7 != null) goto L33;
        Method r12 = r9.getDeclaredMethod(r10, (Class[]) Arrays.copyOf(r11, r11.length));     // Catch: Throwable -> L21
        r12.setAccessible(true);     // Catch: Throwable -> L21
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r13) == true) goto L28;
        r2 = r13;
    L28:
        return (Method) r2;
    L21:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L33:
        return r7;
    L9:
        r5 = null;
        goto L10
    L6:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
