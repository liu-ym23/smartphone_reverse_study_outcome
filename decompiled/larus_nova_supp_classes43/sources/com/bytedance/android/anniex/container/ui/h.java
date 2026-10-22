package com.bytedance.android.anniex.container.ui;

import android.R;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.sdk.param.SoftInputMode;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.gyf.barlibrary.FlymeOSStatusBarFontUtils;
import com.gyf.barlibrary.OSUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public final Activity a;
    public final ia.c b;
    public final ViewGroup c;
    public View d;
    public View e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.b.goBack();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ h a;

        public c(h r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.b.close();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ h a;

        public d(h r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.b.goBack();
        }
    }

    static {
    }

    public final void a() {
        HybridLogger.m("StatusBarAndNavImp", "hide navigation bar", null, null, 12);
        View r0 = this.c.findViewById(2131363015);
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        View r1 = this.c.findViewById(2131363023);
        if (r1 == null) goto L11;
        r1.setVisibility(8);
        return;
    }

    public final void l() {
        HybridLogger.m("StatusBarAndNavImp", "show navigation bar", null, null, 12);
        View r0 = this.c.findViewById(2131363015);
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        View r1 = this.c.findViewById(2131363023);
        if (r1 == null) goto L11;
        r1.setVisibility(0);
        return;
    }

    public final void d(ab.b r12) {
        Intrinsics.checkNotNullParameter(r12, "uiModel");
        String r10 = null;
        HybridLogger.m("StatusBarAndNavImp", "===init status bar===", null, null, 12);
        y36.i r1 = r12.d;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("hideStatusBar");
        r1 = null;
    L6:
        Boolean r11 = (Boolean) r1.b;
        boolean r13 = false;
        if (r11 == null) goto L9;
        boolean r14 = r11.booleanValue();
    L10:
        Object r15 = ((y36.i) r12.c()).b;
        Boolean r16 = Boolean.TRUE;
        if (Intrinsics.areEqual(r15, r16) == true) goto L20;
        y36.i r17 = r12.o;
        if (r17 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("shouldFullScreen");
        r17 = null;
    L17:
        if (Intrinsics.areEqual(r17.b, r16) == true) goto L20;
        boolean r18 = false;
    L21:
        com.bytedance.ies.bullet.service.sdk.param.a r19 = r12.k;
        if (r19 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("statusFontMode");
        r19 = null;
    L25:
        String r20 = r19.a();
        if (r20 != null) goto L28;
        r20 = "light";
    L28:
        Activity r21 = this.a;
        y36.i r110 = r12.t;
        if (r110 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("isHostLight");
        r110 = null;
    L32:
        Boolean r111 = (Boolean) r110.b;
        if (r111 == null) goto L35;
        boolean r112 = r111.booleanValue();
    L36:
        y36.i r113 = r12.i;
        if (r113 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarBgColor");
        r113 = null;
    L40:
        Integer r114 = (Integer) r113.b;
        if (r21 != null) goto L43;
        HybridLogger.i("StatusBarAndNavImp", "setStatusBarStyle: activity is null", null, 12);
    L56:
        if (r14 == false) goto L91;
        Activity r115 = this.a;
        int r0 = com.bytedance.android.anniex.container.util.f.a;
        int r22 = com.bytedance.android.anniex.container.util.j.a;
        if (r115 != null) goto L60;
    L85:
        if (r13 == false) goto L87;
        int r116 = com.bytedance.android.anniex.container.util.j.a;
        com.bytedance.android.anniex.container.util.j.b(this.a, r20);
        goto L91
    L87:
        int r117 = com.bytedance.android.anniex.container.util.j.a;
        Activity r118 = this.a;
        if (r118 == null) goto L91;
        r118.getWindow().setFlags(1024, 1024);
        Intrinsics.checkNotNullParameter(r118, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        r118.getWindow().setStatusBarColor(r118.getResources().getColor(R.color.transparent));
        goto L91
    L60:
        if (Build.VERSION.SDK_INT < 28) goto L72;
        View r23 = r115.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L96;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r24 = ThreadMethodProxy.currentThread();
        if (r24 == com.larus.home.impl.utils.c.a) goto L96;
        com.larus.home.impl.utils.c.a(r24, "getDecorView");
    L96:
        Object r25 = r23.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(r23, new Object[0]);     // Catch: Exception -> L70
        Object r26 = r25.getClass().getDeclaredMethod("getDisplayCutout", new Class[0]).invoke(r25, new Object[0]);     // Catch: Exception -> L70
        Object r27 = r26.getClass().getMethod("getBoundingRects", new Class[0]).invoke(r26, new Object[0]);     // Catch: Exception -> L70
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type kotlin.collections.List<android.graphics.Rect>");     // Catch: Exception -> L70
        if (((List) r27).size() <= 0) goto L72;
        boolean r28 = true;
    L73:
        if (r28 == false) goto L94;
    L84:
        r13 = true;
        goto L85
    L94:
        Resources r119 = r115.getResources();     // Catch: Exception -> L81
        int r29 = r119.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");     // Catch: Exception -> L81
        if (r29 <= 0) goto L77;
        r10 = r119.getString(r29);     // Catch: Exception -> L81
    L77:
        if (r10 == null) goto L82;
        if (TextUtils.isEmpty(r10) == true) goto L82;
        boolean r120 = true;
    L83:
        if (r120 == false) goto L85;
    L82:
        r120 = false;
    L70:
        e = move-exception;
        e.printStackTrace();
    L72:
        r28 = false;
    L91:
        if (r18 == false) goto L98;
        int r121 = com.bytedance.android.anniex.container.util.j.a;
        com.bytedance.android.anniex.container.util.j.b(this.a, r20);
        return;
    L98:
        return;
    L43:
        if (r112 == false) goto L46;
        com.bytedance.android.anniex.container.util.g.g(r21);
        com.bytedance.android.anniex.container.util.g.c(r21);
        int r122 = b46.l.a;
        b46.l.e(r21, ColorProtector.parseColor(IHostContextDepend.SKIN_TYPE_WHITE));
        goto L56
    L46:
        if (Intrinsics.areEqual("light", r20) == false) goto L49;
        com.bytedance.android.anniex.container.util.g.f(r21);
        com.bytedance.android.anniex.container.util.g.c(r21);
    L54:
        if (r114 == null) goto L56;
        int r30 = b46.l.a;
        b46.l.e(r21, r114.intValue());
        goto L56
    L49:
        if (Intrinsics.areEqual("dark", r20) == false) goto L54;
        com.bytedance.android.anniex.container.util.g.g(r21);
        if (r14 == true) goto L54;
        if (r18 == true) goto L54;
        com.bytedance.android.anniex.container.util.g.c(r21);
        goto L54
    L35:
        r112 = false;
    L20:
        r18 = true;
        goto L21
    L9:
        r14 = false;
        goto L10
    }

    public final void e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "navBarColor");
        HybridLogger.m("StatusBarAndNavImp", "set navigation bar color", null, null, 12);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        View r11 = this.c.findViewById(2131363015);     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        r11.setBackgroundColor(Color.parseColor(r10));     // Catch: Throwable -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L9
    L11:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L17;
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.i("StatusBarAndNavImp", "setNavBarColor :" + r14.getMessage(), null, 12);
        return;
    L17:
        return;
    L6:
        r12 = null;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void g(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusBarColor");
        HybridLogger.m("StatusBarAndNavImp", "===set status bar color===", null, null, 12);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        int r11 = b46.l.a;     // Catch: Throwable -> L5
        b46.l.e(this.a, Color.parseColor(r10));     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L13;
        HybridLogger r14 = HybridLogger.a;
        HybridLogger.i("StatusBarAndNavImp", "setStatusBarColor :" + r13.getMessage(), null, 12);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusFontMode");
        HybridLogger.m("StatusBarAndNavImp", "===set status font mode===", null, null, 12);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(r10, "dark") == false) goto L6;
        boolean r11 = true;
    L7:
        Activity r12 = this.a;     // Catch: Throwable -> L9
        h(r12, r12.getWindow(), r11);     // Catch: Throwable -> L9
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L17;
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.i("StatusBarAndNavImp", "setStatusFontMode :" + r14.getMessage(), null, 12);
        return;
    L17:
        return;
    L6:
        Intrinsics.areEqual(r10, "light");     // Catch: Throwable -> L9
        r11 = false;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void j(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        HybridLogger.m("StatusBarAndNavImp", "set title", null, null, 12);
        TextView r0 = (TextView) this.c.findViewById(2131363024);
        if (r0 == null) goto L7;
        r0.setText(r10);
        return;
    }

    public final void k(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleColor");
        HybridLogger.m("StatusBarAndNavImp", "set title color", null, null, 12);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        TextView r11 = (TextView) this.c.findViewById(2131363024);     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        r11.setTextColor(Color.parseColor(r10));     // Catch: Throwable -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L9
    L11:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L17;
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.i("StatusBarAndNavImp", "setTitleColor :" + r14.getMessage(), null, 12);
        return;
    L17:
        return;
    L6:
        r12 = null;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void b(ab.b r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "uiModel");
        Intrinsics.checkNotNullParameter(r11, "bid");
        this.d = this.c.findViewById(2131362987);
        ImageView r0 = (ImageView) this.c.findViewById(2131362990);
        y36.i r1 = r10.s;
        Boolean r12 = null;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("closePositionRight");
        r1 = null;
    L7:
        if (Intrinsics.areEqual(r1.b, Boolean.TRUE) == false) goto L9;
        View r13 = this.c.findViewById(2131362988);
    L10:
        this.e = r13;
        if (Intrinsics.areEqual(((y36.i) r10.getType()).b, "fullscreen") == false) goto L30;
        y36.i r14 = r10.p;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("showBack");
        r14 = null;
    L16:
        Boolean r15 = (Boolean) r14.b;
        if (r15 == null) goto L30;
        if (r15.booleanValue() == true) goto L22;
        r15 = null;
    L22:
        if (r15 == null) goto L30;
        r15.booleanValue();
        View r16 = this.d;
        if (r16 == null) goto L27;
        r16.setVisibility(0);
    L27:
        View r17 = this.d;
        if (r17 == null) goto L30;
        r17.setOnClickListener(new b(this));
    L30:
        y36.i r18 = r10.r;
        if (r18 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("iconTheme");
        r18 = null;
    L34:
        Integer r19 = (Integer) r18.b;
        boolean r20 = true;
        if (r19 != null) goto L38;
    L45:
        Boolean r21 = (Boolean) ((y36.i) r10.b()).b;
        if (r21 != null) goto L48;
    L63:
        y36.i r22 = r10.q;
        if (r22 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("enableShare");
        r22 = null;
    L67:
        Boolean r23 = (Boolean) r22.b;
        if (r23 != null) goto L70;
        return;
    L70:
        if (r23.booleanValue() == false) goto L72;
        r12 = r23;
    L72:
        if (r12 == null) goto L76;
        r12.booleanValue();
        r0.setVisibility(0);
        return;
    L76:
        return;
    L48:
        if (r21.booleanValue() == true) goto L50;
    L52:
        r20 = false;
    L53:
        if (r20 == true) goto L56;
        r21 = null;
    L56:
        if (r21 == null) goto L63;
        r21.booleanValue();
        View r24 = this.e;
        if (r24 == null) goto L61;
        r24.setVisibility(0);
    L61:
        if (r24 == null) goto L63;
        r24.setOnClickListener(new c(this));
        goto L63
    L50:
        if (Intrinsics.areEqual(r11, "webcast") == false) goto L52;
    L38:
        if (r19.intValue() != 1) goto L45;
        View r25 = this.e;
        if ((r25 instanceof ImageView) == false) goto L42;
        ImageView r26 = (ImageView) r25;
    L43:
        if (r26 == null) goto L45;
        r26.setImageResource(2131231354);
        goto L45
    L42:
        r26 = null;
        goto L43
    L9:
        r13 = this.c.findViewById(2131362989);
        goto L10
    }

    public final void c(Window r10, ab.b r11) {
        Intrinsics.checkNotNullParameter(r11, "uiModel");
        y36.i r0 = r11.a;
        y36.i r12 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        r0 = null;
    L6:
        Object r1 = r0.b;
        Boolean r13 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r13) == false) goto L11;
        HybridLogger.m("StatusBarAndNavImp", "disable input scroll", null, null, 12);
        if (r10 == null) goto L20;
        r10.setSoftInputMode(48);
    L20:
        if ((this.b instanceof ia.d) == false) goto L45;
        Map r14 = x26.a.a;
        w26.g r15 = (w26.g) x26.a.a(w26.g.class);
        if (r15 == null) goto L28;
        w26.e r16 = (w26.e) r15.n0(w26.e.class);
        if (r16 == null) goto L28;
        Boolean r17 = r16.l0();
        if (r17 == null) goto L28;
        boolean r18 = r17.booleanValue();
    L29:
        if (r18 == false) goto L46;
        y36.i r19 = r11.a;
        if (r19 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        r19 = null;
    L35:
        if (Intrinsics.areEqual(r19.b, r13) == true) goto L47;
        y36.i r20 = r11.h;
        if (r20 == null) goto L39;
        r12 = r20;
    L41:
        if (r12.b != null) goto L48;
        if (r10 == null) goto L49;
        r10.setSoftInputMode(16);
        return;
    L49:
        return;
    L48:
        return;
    L39:
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        goto L41
    L47:
        return;
    L46:
        return;
    L28:
        r18 = true;
        goto L29
    L45:
        return;
    L11:
        HybridLogger.m("StatusBarAndNavImp", "use soft input mode", null, null, 12);
        y36.i r21 = r11.h;
        if (r21 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        r21 = null;
    L15:
        SoftInputMode r22 = (SoftInputMode) r21.b;
        if (r22 == null) goto L20;
        if (r10 == null) goto L20;
        r10.setSoftInputMode(r22.getSystemValue());
        goto L20
    }

    public final void f(ab.b r10, int r11) {
        Boolean r0 = null;
        if (r10 == null) goto L7;
        y36.p r1 = r10.getType();
        if (r1 == null) goto L7;
        String r12 = (String) ((y36.i) r1).b;
    L9:
        if (Intrinsics.areEqual(r12, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L57;
        y36.i r13 = r10.p;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("showBack");
        r13 = null;
    L14:
        int r14 = 0;
        if (Intrinsics.areEqual(r13.b, Boolean.FALSE) == true) goto L28;
        y36.i r15 = r10.s;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("closePositionRight");
        r15 = null;
    L21:
        Object r16 = r15.b;
        Boolean r17 = Boolean.TRUE;
        if (Intrinsics.areEqual(r16, r17) == false) goto L24;
        boolean r18 = Intrinsics.areEqual(((y36.i) r10.b()).b, r17);
    L25:
        if (r18 == true) goto L28;
        if (r11 != 0) goto L28;
        r14 = 8;
        goto L28
    L24:
        r18 = false;
    L28:
        Boolean r19 = (Boolean) ((y36.i) r10.b()).b;
        if (r19 != null) goto L31;
    L39:
        y36.i r20 = r10.p;
        if (r20 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("showBack");
        r20 = null;
    L43:
        Boolean r21 = (Boolean) r20.b;
        if (r21 != null) goto L46;
        return;
    L46:
        if (r21.booleanValue() == false) goto L48;
        r0 = r21;
    L48:
        if (r0 == null) goto L59;
        r0.booleanValue();
        View r22 = this.d;
        if (r22 == null) goto L53;
        r22.setVisibility(r11);
    L53:
        View r23 = this.d;
        if (r23 == null) goto L60;
        r23.setOnClickListener(new d(this));
        return;
    L60:
        return;
    L59:
        return;
    L31:
        if (r19.booleanValue() == true) goto L34;
        r19 = null;
    L34:
        if (r19 == null) goto L39;
        r19.booleanValue();
        View r24 = this.e;
        if (r24 == null) goto L39;
        r24.setVisibility(r14);
        goto L39
    L57:
        return;
    L7:
        r12 = null;
        goto L9
    }

    public h(Activity r10, ia.c r11, ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "rootView");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    public static void h(Activity r10, Window r11, boolean r12) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        if (r10 == null) goto L22;
        if (r11 != null) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 30) goto L15;
        WindowInsetsController r1 = r11.getInsetsController();     // Catch: Throwable -> L23
        if (r1 == null) goto L15;
        if (r12 == true) goto L13;
        r1.setSystemBarsAppearance(0, 8);     // Catch: Throwable -> L23
        goto L15
    L13:
        r1.setSystemBarsAppearance(8, 8);     // Catch: Throwable -> L23
    L15:
        if (OSUtils.isMIUI6Later() == false) goto L18;
        b46.l.d(r12, r11);     // Catch: Throwable -> L23
    L18:
        if (OSUtils.isFlymeOS4Later() == false) goto L20;
        FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(r10, r12);     // Catch: Throwable -> L23
    L20:
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L32;
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.i("StatusBarAndNavImp", "setStatusBarMode:" + r14.getMessage(), null, 12);
        return;
    L32:
        return;
    L22:
        return;
    L23:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }
}
