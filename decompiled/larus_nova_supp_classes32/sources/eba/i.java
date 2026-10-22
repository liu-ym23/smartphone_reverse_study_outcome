package eba;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Process;
import android.os.SystemClock;
import android.view.Display;
import android.view.SurfaceControl;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.AutoEndConversationTime;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.runtime.manager.ActivationSource;
import com.obric.assistant.activation.presentation.ui.ObricListeningVisualView;
import com.obric.assistant.common.utils.a0;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.lang.reflect.Method;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static final /* synthetic */ int F = 0;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public final c E;
    public final long a;
    public final long b;
    public final Function0<Unit> c;
    public final Function4<SurfaceControl, Integer, Integer, Integer, Unit> d;
    public final Function2<Integer, Long, Unit> e;
    public final Function1<Integer, Unit> f;
    public final Context g;
    public final KeyguardManager h;
    public WindowManager i;
    public Context j;
    public Display k;
    public WindowManager.LayoutParams l;
    public WindowInsets m;
    public jba.f n;
    public k o;
    public b p;
    public FrameLayout q;
    public ObricListeningVisualView r;
    public int s;
    public int t;
    public ObricListeningViewState u;
    public hba.g v;
    public g w;
    public SurfaceControl x;
    public int y;
    public int z;

    public static final class a {
    }

    static {
    }

    public final void a() {
        SurfaceControl r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = this.y;
        i(false, "child_surface_destroyed");
        this.x = null;
        this.A = -1;
        this.B = -1;
        hba.e.a.getClass();
        if (hba.e.e(r0) == false) goto L8;
        FLogger.a.i("ObricListeningChildWindow", "destroy: side=child stage=surface generation=" + r1);
    L8:
        this.f.invoke(Integer.valueOf(r1));
    }

    public static void c(WindowManager.LayoutParams r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Method r1 = WindowManager.LayoutParams.class.getDeclaredMethod("setTrustedOverlay", new Class[0]);     // Catch: Throwable -> L4
        r1.setAccessible(true);     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(r1.invoke(r4, new Object[0]));     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        FLogger.a.e("ObricListeningChildWindow", "trusted_overlay_reflection_failed: side=child stage=window error=" + ExceptionsKt.stackTraceToString(r6));
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void b(boolean r10) {
        b r0 = this.p;
        if (r0 != null) goto L6;
        this.C = r10;
        return;
    L6:
        int r1 = this.s;
        this.C = r10;
        r0.removeCallbacks(this.E);
        this.D = false;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("detach: side=child stage=window type=");
        r4.append(r1);
        r4.append(" display=");
        r4.append(this.t);
        r4.append(" preserveLinkFence=");
        r4.append(r10);
        r4.append(" spec=");
        k r6 = this.o;
        if (r6 == null) goto L9;
        jba.e r7 = r6.a;
    L10:
        r4.append(r7);
        r3.i("ObricListeningChildWindow", r4.toString());
        ObricListeningVisualView r5 = this.r;
        if (r5 == null) goto L13;
        r5.e(ObricListeningViewState.d);
    L13:
        hba.g r8 = this.v;
        if (r8 == null) goto L16;
        r8.close();
    L16:
        this.v = null;
        g r9 = this.w;
        if (r9 == null) goto L24;
        ViewTreeObserver r11 = r0.getViewTreeObserver();
        if (r11.isAlive() == true) goto L22;
        r11 = null;
    L22:
        if (r11 == null) goto L24;
        r11.removeOnPreDrawListener(r9);
    L24:
        this.w = null;
        a();
        r0.setOnApplyWindowInsetsListener(null);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L31
        WindowManager r13 = this.i;     // Catch: Throwable -> L31
        if (r13 == null) goto L28;
        r13.removeViewImmediate(r0);     // Catch: Throwable -> L31
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L29:
        Object r14 = Result.constructor-impl(r2);     // Catch: Throwable -> L31
    L34:
        if (Result.isSuccess-impl(r14) == false) goto L36;
        Unit r15 = (Unit) r14;
        FLogger.a.i("ObricListeningChildWindow", "detach_success: side=child stage=window type=" + r1 + " display=" + this.t);
    L36:
        Throwable r16 = Result.exceptionOrNull-impl(r14);
        if (r16 == null) goto L39;
        FLogger.a.w("ObricListeningChildWindow", "remove_failed: side=child stage=window type=" + r1 + " error=" + r16.getClass().getSimpleName() + ':' + r16.getMessage());
    L39:
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = 0;
        this.t = -1;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        if (r10 == true) goto L42;
        this.u = ObricListeningViewState.d;
    L42:
        this.i = null;
        return;
    L28:
        r2 = null;
    L31:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L9:
        r7 = null;
        goto L10
    }

    public final void e(String r11) {
        if (this.p != null) goto L5;
        return;
    L5:
        FrameLayout r0 = this.q;
        if (r0 != null) goto L8;
        return;
    L8:
        Context r1 = this.j;
        if (r1 != null) goto L11;
        return;
    L11:
        Display r2 = this.k;
        if (r2 != null) goto L14;
        return;
    L14:
        WindowManager r3 = this.i;
        if (r3 != null) goto L18;
        return;
    L18:
        if (this.l != null) goto L20;
        return;
    L20:
        l r4 = l.a;
        WindowInsets r5 = this.m;
        jba.f r6 = this.n;
        r4.getClass();
        k r7 = l.c(r1, r2, r3, r5, r6);
        k r8 = this.o;
        ViewGroup.LayoutParams r9 = r0.getLayoutParams();
        if ((r9 instanceof FrameLayout.LayoutParams) == false) goto L23;
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r9;
    L24:
        FrameLayout.LayoutParams r12 = h(r1, r7);
        boolean r13 = true;
        if (r10 != null) goto L27;
    L41:
        boolean r14 = false;
    L42:
        boolean r15 = !r14;
        boolean r16 = !r15;
        if (r15 == true) goto L62;
    L56:
        l.a.getClass();
        l.a(r0, r7);
        this.n = r7.c.g;
        this.o = r7;
        if (r15 == false) goto L59;
    L60:
        FLogger.a.i("ObricListeningChildWindow", "layout_update: side=child stage=window reason=" + r11 + " changed=" + r15 + " applied=" + r16 + " inputs={" + r7.c.a() + "} result={spec=" + r7.a + " radii=" + r7.b + '}');
        return;
    L59:
        if (Intrinsics.areEqual(r8, r7) == false) goto L60;
        return;
    L62:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L46
        r0.setLayoutParams(r12);     // Catch: Throwable -> L46
        r0.requestLayout();     // Catch: Throwable -> L46
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L49:
        if (Result.isSuccess-impl(r18) == false) goto L51;
        Unit r19 = (Unit) r18;
    L52:
        Throwable r20 = Result.exceptionOrNull-impl(r18);
        if (r20 == null) goto L55;
        FLogger.a.w("ObricListeningChildWindow", "content_layout_update_failed: side=child stage=window reason=" + r11 + " error=" + r20.getClass().getSimpleName() + ':' + r20.getMessage());
    L55:
        r16 = r13;
        goto L56
    L51:
        r13 = r16;
    L46:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L27:
        if (r10.width != r12.width) goto L41;
        if (r10.height != r12.height) goto L41;
        if (r10.gravity != r12.gravity) goto L41;
        if (r10.leftMargin != r12.leftMargin) goto L41;
        if (r10.topMargin != r12.topMargin) goto L41;
        if (r10.rightMargin != r12.rightMargin) goto L41;
        if (r10.bottomMargin != r12.bottomMargin) goto L41;
        r14 = true;
        goto L42
    L23:
        r10 = null;
        goto L24
    }

    public final void f(Integer r2) {
        if (r2 == null) goto L6;
        int r0 = this.y;
        if (r2.intValue() == r0) goto L6;
        return;
    L6:
        i(false, "main_surface_released");
        this.A = -1;
        this.B = -1;
        this.C = false;
        b r3 = this.p;
        if (r3 == null) goto L10;
        r3.invalidate();
        return;
    }

    public static FrameLayout.LayoutParams h(Context r3, k r4) {
        jba.e r5 = r4.a;
        if (r5.f == false) goto L5;
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(r5.a, r5.b, r5.c);
        r6.rightMargin = r5.d;
        r6.topMargin = r5.e;
        return r6;
    L5:
        int r0 = ObricListeningVisualView.i;
        return new FrameLayout.LayoutParams(-1, ObricListeningVisualView.a.a(r3), 81);
    }

    public final void i(boolean r10, String r11) {
        b r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        WindowManager r1 = this.i;
        if (r1 != null) goto L8;
        return;
    L8:
        WindowManager.LayoutParams r2 = this.l;
        if (r2 != null) goto L11;
        return;
    L11:
        int r3 = r2.flags;
        if ((r3 & 16) == 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 != r10) goto L17;
        return;
    L17:
        if (r10 == false) goto L19;
        int r5 = r3 | 16;
    L20:
        r2.flags = r5;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L23
        r1.updateViewLayout(r0, r2);     // Catch: Throwable -> L23
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L26:
        if (Result.isSuccess-impl(r7) == false) goto L28;
        Unit r8 = (Unit) r7;
        FLogger.a.i("ObricListeningChildWindow", "touch_passthrough_changed: side=child stage=window enabled=" + r10 + " reason=" + r11 + " generation=" + this.y);
    L28:
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 == null) goto L34;
        r2.flags = r3;
        FLogger.a.w("ObricListeningChildWindow", "touch_passthrough_update_failed: side=child stage=window enabled=" + r10 + " reason=" + r11 + " generation=" + this.y + " error=" + r9.getClass().getSimpleName() + ':' + r9.getMessage());
        return;
    L34:
        return;
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L19:
        r5 = r3 & (-17);
        goto L20
    L14:
        r4 = false;
        goto L15
    }

    public final boolean g(ObricListeningPresentationState r32, ActivationSource r33, long r34) {
        Intrinsics.checkNotNullParameter(r32, "state");
        Intrinsics.checkNotNullParameter(r33, "source");
        if (r32.b() == true) goto L5;
    L78:
        b(false);
        return true;
    L5:
        if (r32.c != 1) goto L78;
        if (this.h.isKeyguardLocked() == false) goto L10;
        int r6 = 2009;
    L12:
        if (this.p != null) goto L14;
    L20:
        ObricListeningViewState r1 = r32.e;
        this.u = r1;
        b r0 = this.p;
        if (r0 != null) goto L23;
        boolean r18 = true;
    L25:
        if (r0 != null) goto L66;
        com.obric.assistant.common.utils.i.a r19 = com.obric.assistant.common.utils.i.a("ObricListeningChildWindow_attach");
        long r20 = SystemClock.uptimeMillis();     // Catch: Throwable -> L62
        sda.b r2 = sda.b.a;     // Catch: Throwable -> L62
        int r10 = Process.myTid();     // Catch: Throwable -> L62
        r2.getClass();     // Catch: Throwable -> L62
        sda.b.a("child_activation_ui", r10);     // Catch: Throwable -> L62
    L32:
        th = move-exception;
        FLogger.a.e("ObricListeningChildWindow", "turn_screen_on_failed: side=child stage=window", th);     // Catch: Throwable -> L62
    L80:
        DisplayManager r3 = (DisplayManager) this.g.getSystemService(DisplayManager.class);     // Catch: RuntimeException -> L56 Throwable -> L62
        if (r3 == null) goto L37;
        Display r4 = r3.getDisplay(0);     // Catch: RuntimeException -> L56 Throwable -> L62
    L38:
        if (r4 != null) goto L42;
        FLogger.a.e("ObricListeningChildWindow", "attach_failed: side=child stage=window type=" + r6 + " error=display_unavailable");     // Catch: RuntimeException -> L56 Throwable -> L62
        if (r19 == null) goto L66;
        r19.a();
        goto L66
    L42:
        Context r12 = this.g.createDisplayContext(r4).createWindowContext(r6, null);     // Catch: RuntimeException -> L56 Throwable -> L62
        Object r11 = r12.getSystemService("window");     // Catch: RuntimeException -> L56 Throwable -> L62
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: RuntimeException -> L56 Throwable -> L62
        WindowManager r13 = (WindowManager) r11;     // Catch: RuntimeException -> L56 Throwable -> L62
        final b r14 = new b(r12);     // Catch: RuntimeException -> L56 Throwable -> L62
        r14.a = new d(this, r14);     // Catch: RuntimeException -> L56 Throwable -> L62
        ObricListeningVisualView r5 = new ObricListeningVisualView(r12, true);     // Catch: RuntimeException -> L54 Throwable -> L62
        FrameLayout r15 = new FrameLayout(r12);     // Catch: RuntimeException -> L54 Throwable -> L62
        r5.e(r1);     // Catch: RuntimeException -> L54 Throwable -> L62
        r15.addView(r5, new FrameLayout.LayoutParams(-1, ObricListeningVisualView.a.a(r12), 81));     // Catch: RuntimeException -> L54 Throwable -> L62
        l.a.getClass();     // Catch: RuntimeException -> L54 Throwable -> L62
        k r7 = l.c(r12, r4, r13, null, null);     // Catch: RuntimeException -> L54 Throwable -> L62
        r15.setLayoutParams(h(r12, r7));     // Catch: RuntimeException -> L54 Throwable -> L62
        r14.addView(r15);     // Catch: RuntimeException -> L54 Throwable -> L62
        String r27 = "attach_failed: side=child stage=window type=";
        WindowManager.LayoutParams r9 = new WindowManager.LayoutParams(-1, -1, r6, 16777480, -3);     // Catch: RuntimeException -> L52 Throwable -> L62
        r9.gravity = 119;     // Catch: RuntimeException -> L52 Throwable -> L62
        r9.x = 0;     // Catch: RuntimeException -> L52 Throwable -> L62
        r9.y = 0;     // Catch: RuntimeException -> L52 Throwable -> L62
        r9.alpha = 1.0f;     // Catch: RuntimeException -> L52 Throwable -> L62
        r9.dimAmount = 0.0f;     // Catch: RuntimeException -> L52 Throwable -> L62
        r9.windowAnimations = 0;     // Catch: RuntimeException -> L52 Throwable -> L62
        r9.softInputMode = 48;     // Catch: RuntimeException -> L52 Throwable -> L62
        r9.setTitle("ObricListeningChildWindow");     // Catch: RuntimeException -> L52 Throwable -> L62
        r9.packageName = this.g.getPackageName();     // Catch: RuntimeException -> L52 Throwable -> L62
        r9.setFitInsetsTypes(0);     // Catch: RuntimeException -> L52 Throwable -> L62
        c(r9);     // Catch: RuntimeException -> L52 Throwable -> L62
        l.a(r15, r7);     // Catch: RuntimeException -> L52 Throwable -> L62
        r14.setOnApplyWindowInsetsListener(new e(this, r14));     // Catch: RuntimeException -> L52 Throwable -> L62
        FLogger r16 = FLogger.a;     // Catch: RuntimeException -> L52 Throwable -> L62
        r16.i("ObricListeningChildWindow", "attach_prepare: side=child stage=window mode=" + r1.a + " visible=" + r1.b() + " type=" + r6 + " inputs={" + r7.c.a() + "} result={spec=" + r7.a + " radii=" + r7.b + '}');     // Catch: RuntimeException -> L52 Throwable -> L62
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r14, r9);     // Catch: RuntimeException -> L52 Throwable -> L62
        r13.addView(r14, r9);     // Catch: RuntimeException -> L52 Throwable -> L62
        this.i = r13;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.j = r12;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.k = r4;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.l = r9;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.o = r7;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.p = r14;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.q = r15;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.r = r5;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.s = r6;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.t = r4.getDisplayId();     // Catch: RuntimeException -> L52 Throwable -> L62
        r16.i("ObricListeningChildWindow", "attach_success: side=child stage=window type=" + r6 + " display=" + this.t + " attrs={width=" + r9.width + " height=" + r9.height + " gravity=" + r9.gravity + " x=" + r9.x + " y=" + r9.y + "} content={spec=" + r7.a + '}');     // Catch: RuntimeException -> L52 Throwable -> L62
        this.D = false;     // Catch: RuntimeException -> L52 Throwable -> L62
        r14.postDelayed(this.E, this.a);     // Catch: RuntimeException -> L52 Throwable -> L62
        StringBuilder r8 = new StringBuilder("initial_main_update_timeout_scheduled: side=child stage=window timeoutMs=");     // Catch: RuntimeException -> L52 Throwable -> L62
        r8.append(this.a);     // Catch: RuntimeException -> L52 Throwable -> L62
        r8.append(" type=");     // Catch: RuntimeException -> L52 Throwable -> L62
        r8.append(r6);     // Catch: RuntimeException -> L52 Throwable -> L62
        r8.append(" display=");     // Catch: RuntimeException -> L52 Throwable -> L62
        r8.append(this.t);     // Catch: RuntimeException -> L52 Throwable -> L62
        r16.i("ObricListeningChildWindow", r8.toString());     // Catch: RuntimeException -> L52 Throwable -> L62
        int r17 = r6;
        String r110 = "ObricListeningChildWindow";
        d(r14, r33, r20, r34);     // Catch: RuntimeException -> L50 Throwable -> L62
        r14.requestApplyInsets();     // Catch: RuntimeException -> L50 Throwable -> L62
    L59:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L62
        if (r19 == null) goto L68;
        r19.a();
    L68:
        if (this.p != null) goto L72;
        FLogger.a.w(r110, "render_failed: side=child stage=window mode=" + r32.e.a + " targetType=" + r17);
        return false;
    L72:
        if (r18 == true) goto L90;
        ObricListeningVisualView r22 = this.r;
        if (r22 == null) goto L91;
        r22.e(r32.e);
        return true;
    L91:
        return true;
    L90:
        return true;
    L50:
        e = e;
    L58:
        FLogger.a.e(r110, r27 + r17 + " error=" + e.getClass().getSimpleName() + ':' + e.getMessage());     // Catch: Throwable -> L62
    L52:
        e = e;
        r17 = r6;
        r110 = "ObricListeningChildWindow";
    L54:
        e = e;
        r17 = r6;
        r110 = "ObricListeningChildWindow";
        r27 = "attach_failed: side=child stage=window type=";
        goto L58
    L37:
        r4 = null;
    L56:
        e = e;
        r17 = r6;
        r110 = "ObricListeningChildWindow";
        r27 = "attach_failed: side=child stage=window type=";
        goto L58
    L29:
        if (a0.a() == true) goto L80;
        FLogger.a.i("ObricListeningChildWindow", "turn_screen_on: side=child stage=window");     // Catch: Throwable -> L32
        a0.b();     // Catch: Throwable -> L32
    L62:
        th = move-exception;
        if (r19 == null) goto L65;
        r19.a();
    L65:
        throw th;
    L66:
        r17 = r6;
        r110 = "ObricListeningChildWindow";
        goto L68
    L23:
        r18 = false;
        goto L25
    L14:
        if (r6 == this.s) goto L20;
        if (this.A != this.y) goto L18;
        boolean r23 = true;
    L19:
        b(r23);
        goto L20
    L18:
        r23 = false;
        goto L19
    L10:
        r6 = 2038;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.ViewTreeObserver$OnPreDrawListener, eba.g] */
    public final void d(b r9, final ActivationSource r10, final long r11, final long r13) {
        ?? r7 = new g(this, r11, r10, r13);
        this.w = r7;
        r9.getViewTreeObserver().addOnPreDrawListener(r7);
        hba.e r12 = hba.e.a;
        j r14 = new j(this);
        r12.getClass();
        this.v = hba.e.f(r9, r14);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [eba.c] */
    public i(Context r2, long r3, Function0 r5, Function4 r6, Function2 r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "onTimeoutReached");
        Intrinsics.checkNotNullParameter(r6, "onSurfaceAvailable");
        Intrinsics.checkNotNullParameter(r7, "onFirstDrawReady");
        Intrinsics.checkNotNullParameter(r8, "onSurfaceDestroyed");
        this.a = r3;
        this.b = AutoEndConversationTime.AFTER_10_SECONDS;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        Context r4 = r2.getApplicationContext();
        this.g = r4;
        Object r9 = r4.getSystemService("keyguard");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.app.KeyguardManager");
        this.h = (KeyguardManager) r9;
        this.t = -1;
        this.u = ObricListeningViewState.d;
        this.z = -1;
        this.A = -1;
        this.B = -1;
        this.E = new c(this);
    }
}
