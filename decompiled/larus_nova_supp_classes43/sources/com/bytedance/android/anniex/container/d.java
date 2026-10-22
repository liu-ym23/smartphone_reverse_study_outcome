package com.bytedance.android.anniex.container;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.container.popup.SheetBaseBehavior;
import com.bytedance.android.anniex.container.popup.SheetBaseDialog;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.container.view.RadiusFrameLayout;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;
import y36.p;
import y36.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends AnnieXContainer implements ia.f {
    public final FragmentActivity a;
    public ia.f.a b;
    public DialogFragment c;
    public Dialog d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public ab.a j;
    public ab.b k;
    public com.bytedance.android.anniex.container.ui.h l;
    public Integer m;
    public View n;
    public View o;
    public int p;
    public FrameLayout q;
    public Boolean r;
    public int s;
    public int t;
    public int u;
    public int v;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ WebView a;
        public final /* synthetic */ d b;

        public b(WebView r1, d r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void a() {
            WebView r0 = this.a;
            if (r0 == null) goto L7;
            boolean r10 = true;
            if (r0.canGoBack() != true) goto L7;
        L8:
            com.bytedance.android.anniex.container.ui.h r1 = null;
            if (r10 == false) goto L15;
            com.bytedance.android.anniex.container.ui.h r11 = this.b.l;
            if (r11 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        L14:
            r1.f(this.b.k, 0);
            return;
        L13:
            r1 = r11;
            goto L14
        L15:
            com.bytedance.android.anniex.container.ui.h r12 = this.b.l;
            if (r12 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        L19:
            r1.f(this.b.k, 8);
            return;
        L18:
            r1 = r12;
        L7:
            r10 = false;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final Object a;

        public final String getName() {
            return "H5_halfFullStatusChange";
        }

        public final Object getParams() {
            return this.a;
        }

        public c(JSONObject r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.b, ia.c
    public final String getViewType() {
        return com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP;
    }

    @Override // ia.h
    public final void k(boolean r1) {
    }

    @Override // ia.g
    public final void n(boolean r1) {
    }

    @Override // ia.e
    public final void onActivityCreated(Bundle r1) {
    }

    @Override // ia.e
    public final void onActivityResult(int r1, int r10, Intent r11) {
    }

    @Override // ia.e
    public final void onDestroy() {
    }

    @Override // ia.e
    public final void onPause() {
    }

    @Override // ia.f
    public final Integer i() {
        Object r0 = this.d;
        Integer r10 = null;
        if ((r0 instanceof SheetBaseDialog) == false) goto L5;
        SheetBaseDialog r1 = (SheetBaseDialog) r0;
    L6:
        if (r1 == null) goto L12;
        if (r1.p == false) goto L10;
        r10 = Integer.valueOf(r1.q);
    L10:
        if (r10 == null) goto L12;
        return r10;
    L12:
        return this.m;
    L5:
        r1 = null;
        goto L6
    }

    @Override // ia.e
    public final void onStart() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        y();     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void r() {
        Dialog r0 = this.d;
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.clearFlags(2);
    L7:
        Dialog r10 = this.d;
        if (r10 == null) goto L13;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L14;
        r11.setDimAmount(0.0f);
        return;
    L14:
        return;
    }

    public final boolean s() {
        ab.a r0 = this.j;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L15;
        ab.a r10 = this.j;
        if (r10 != null) goto L12;
    L14:
        return false;
    L12:
        if (r10.y() != true) goto L14;
        return true;
    L15:
        ab.a r11 = this.j;
        if (r11 == null) goto L18;
        int r12 = r11.f();
    L20:
        if (RangesKt.coerceAtMost(r12 / 100.0f, 1.0f) < 1.0f) goto L14;
        return true;
    L18:
        r12 = 0;
        goto L20
    L5:
        if (r0.w() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean t() {
        return com.bytedance.android.anniex.container.util.h.a(this.a);
    }

    public final boolean w() {
        ab.a r0 = this.j;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.n() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final void x() {
        ab.a r0 = this.j;
        if (r0 == null) goto L15;
        Dialog r1 = this.d;
        if (r1 == null) goto L9;
        Window r10 = r1.getWindow();
        if (r10 == null) goto L9;
        r10.addFlags(2);
    L9:
        Dialog r11 = this.d;
        if (r11 == null) goto L16;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L17;
        r12.setDimAmount(r0.n());
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void y() {
        Dialog r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        Window r1 = r0.getWindow();
        Boolean r10 = this.r;
        Boolean r11 = Boolean.TRUE;
        if (Intrinsics.areEqual(r10, r11) == false) goto L28;
        if (r1 == null) goto L28;
        ab.a r12 = this.j;
        if (r12 == null) goto L28;
        WindowManager.LayoutParams r13 = r1.getAttributes();
        y36.a r14 = r12.y;
        if (r14 == null) goto L13;
        boolean r15 = Intrinsics.areEqual(((y36.i) r14).b, r11);
    L14:
        if (r15 == true) goto L16;
    L26:
        r1.setAttributes(r13);
        goto L28
    L16:
        if (com.bytedance.android.anniex.container.util.i.a.getResources().getConfiguration().orientation != 2) goto L18;
        r13.windowAnimations = 2131954099;
        goto L26
    L18:
        y36.l r16 = r12.z;
        if (r16 == null) goto L21;
        PopupType r17 = (PopupType) ((y36.i) r16).b;
    L23:
        if (r17 != PopupType.RIGHT) goto L25;
        r13.windowAnimations = 2131954099;
        goto L26
    L25:
        r13.windowAnimations = 2131954100;
        goto L26
    L21:
        r17 = null;
        goto L23
    L13:
        r15 = false;
    L28:
        if (this.r != null) goto L31;
        this.r = r11;
        return;
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.b
    public final void observerKeyboardStatusChange() {
        super.observerKeyboardStatusChange();
        Dialog r0 = this.d;
        if (r0 == null) goto L6;
        SoftInputKt.d(r0, getOnSoftInputChangeListener$anniex_release());
        return;
    }

    @Override // ia.e
    public final void onResume() {
        enterForeground();
        if (AnnieXContainerManager.isTopContainer(this) == false) goto L6;
        onVisibleChange(true, Boolean.TRUE);
        return;
    }

    @Override // ia.e
    public final void onStop() {
        enterBackground();
        onVisibleChange(false, Boolean.TRUE);
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void parseSchema() {
        t36.d r0 = getBulletContext().e;
        if (r0 == null) goto L9;
        Lazy r1 = SchemaService.f;
        SchemaService.a.a().getClass();
        ab.a r10 = (ab.a) SchemaService.d(r0, ab.a.class);
        this.j = r10;
        if (r10 == null) goto L8;
        r10.b = getContext();
    L8:
        SchemaService.a.a().getClass();
        this.k = (ab.b) SchemaService.d(r0, ab.b.class);
    L9:
        BulletContext r11 = getBulletContext();
        Scenes r12 = Scenes.PopupFragment;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.i = r12;
        BulletContext r13 = getBulletContext();
        Components r14 = Components.DialogFragment;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.j = r14;
        getBulletContext().I = true;
        super.parseSchema();
    }

    public d(com.bytedance.android.anniex.base.builder.c r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        super(r10);
        this.a = r10.e();
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        this.e = -16777216;
        this.g = true;
        this.h = true;
        this.i = true;
        this.p = -1;
        this.t = 1024;
        this.u = 2048;
        this.v = -1;
    }

    public static View q(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [android.app.Dialog, com.bytedance.android.anniex.container.popup.SheetBaseDialog] */
    /* JADX WARN: Type inference failed for: r3v56 */
    @Override // ia.e
    public final void a(View r21) {
        setRootView(r21);
        if (r21 == null) goto L5;
        FrameLayout r1 = (FrameLayout) r21.findViewById(2131363000);
    L6:
        if (r1 != null) goto L8;
        r1 = new FrameLayout(this.a);
    L8:
        setParentViewGroup(r1);
        Window r10 = this.a.getWindow();
        this.t = q(r10).getSystemUiVisibility();
        this.u = r10.getAttributes().flags;
        this.v = r10.getStatusBarColor();
        FragmentActivity r11 = this.a;
        View r12 = getRootView();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.ViewGroup");
        this.l = new com.bytedance.android.anniex.container.ui.h(r11, this, (ViewGroup) r12);
        initUi();
        ab.b r13 = this.k;
        if (r13 == null) goto L35;
        Map r14 = x26.a.a;
        w26.g r15 = (w26.g) x26.a.a(w26.g.class);
        if (r15 == null) goto L17;
        w26.e r16 = (w26.e) r15.n0(w26.e.class);
        if (r16 == null) goto L17;
        Boolean r17 = r16.A();
        if (r17 == null) goto L17;
        boolean r18 = r17.booleanValue();
    L19:
        if (r18 == true) goto L24;
        com.bytedance.android.anniex.container.ui.h r19 = this.l;
        if (r19 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r19 = null;
    L23:
        r19.d(r13);
    L24:
        com.bytedance.android.anniex.container.ui.h r20 = this.l;
        if (r20 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r20 = null;
    L27:
        Dialog r22 = this.d;
        if (r22 == null) goto L30;
        Window r23 = r22.getWindow();
    L31:
        r20.c(r23, r13);
        com.bytedance.android.anniex.container.ui.h r24 = this.l;
        if (r24 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r24 = null;
    L34:
        r24.b(r13, getBid());
        goto L35
    L30:
        r23 = null;
    L17:
        r18 = true;
    L35:
        ab.a r25 = this.j;
        if (r25 == null) goto L45;
        y36.a r26 = r25.k;
        if (r26 == null) goto L42;
        Boolean r27 = (Boolean) ((y36.i) r26).b;
        if (r27 == null) goto L42;
        boolean r28 = r27.booleanValue();
    L43:
        if (r28 != true) goto L45;
        boolean r29 = true;
    L46:
        if (r29 == false) goto L50;
        View r30 = getRootView();
        if (r30 == null) goto L53;
        View r31 = (ImageView) r30.findViewById(2131362988);
    L54:
        this.o = r31;
        ab.a r32 = this.j;
        if (r32 != null) goto L57;
    L59:
        boolean r33 = false;
    L60:
        if (r33 == false) goto L75;
        ab.b r34 = this.k;
        if (r34 == null) goto L69;
        y36.i r35 = r34.g;
        if (r35 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("showClosealways");
        r35 = null;
    L67:
        if (r35 == null) goto L69;
        boolean r36 = Intrinsics.areEqual(r35.b, Boolean.TRUE);
    L70:
        if (r36 == true) goto L75;
        View r37 = this.o;
        if (r37 == null) goto L75;
        r37.setAlpha(0.0f);
    L69:
        r36 = false;
    L75:
        ab.b r38 = this.k;
        if (r38 == null) goto L92;
        y36.a r39 = r38.b();
        if (r39 == null) goto L92;
        Boolean r40 = (Boolean) ((y36.i) r39).b;
        if (r40 == null) goto L92;
        if (r40.booleanValue() == true) goto L85;
        r40 = null;
    L85:
        if (r40 == null) goto L92;
        r40.booleanValue();
        View r41 = this.o;
        if (r41 == null) goto L90;
        r41.setVisibility(0);
    L90:
        if (r41 == null) goto L92;
        r41.setOnClickListener(new k(this));
    L92:
        ab.a r42 = this.j;
        if (r42 != null) goto L95;
    L100:
        boolean r43 = true;
    L101:
        if (r43 == true) goto L110;
        ab.a r44 = this.j;
        if (r44 != null) goto L105;
    L107:
        boolean r45 = false;
    L108:
        if (r45 == false) goto L110;
        v(true);
    L113:
        ab.a r46 = this.j;
        if (r46 == null) goto L116;
        r46.e();
    L116:
        Resources r47 = getContext().getResources();
        int r48 = WindowDisplayMetricsOverride.apply(r47, r47.getDisplayMetrics()).widthPixels;
        com.bytedance.android.anniex.container.util.i r49 = com.bytedance.android.anniex.container.util.i.a;
        int r50 = com.bytedance.android.anniex.container.util.i.c(this.a).heightPixels;
        int r51 = r50 - getRealNavigationBarHeight();
        boolean r52 = t();
        if (r52 == true) goto L120;
        r50 = r51;
    L120:
        HybridLogger r53 = HybridLogger.a;
        HybridLogger.m("AnnieXPopupContainer", "screenHeight: " + r50 + "; screenWidth: " + r48, null, null, 12);
        ab.a r54 = this.j;
        if (r54 != null) goto L123;
    L154:
        Window r55 = this.a.getWindow();
        if (r55 == null) goto L157;
        this.e = r55.getStatusBarColor();
    L157:
        ab.a r56 = this.j;
        if (r56 == null) goto L282;
        int r57 = r56.A();
        com.bytedance.android.anniex.container.util.i r58 = com.bytedance.android.anniex.container.util.i.a;
        r56.G(RangesKt.coerceAtMost(r57, (int) r58.e(r48)));
        if (r56.v() <= 0) goto L163;
        if (r52 == true) goto L163;
        r56.E((int) r58.e((int) (((double) (r56.v() * r48)) / 375.0d)));
        HybridLogger.m("AnnieXPopupContainer", "rateHeight: " + r56.v() + "; screenWidth: " + r48 + " ; this.height1: " + r56.e(), null, null, 12);
    L163:
        if (r52 == true) goto L165;
    L167:
        if (r52 == false) goto L174;
        y36.a r59 = r56.r;
        if (r59 == null) goto L171;
        boolean r60 = Intrinsics.areEqual(((y36.i) r59).b, Boolean.TRUE);
    L172:
        if (r60 == false) goto L174;
    L179:
        if ((r56.e() + r56.l()) < ((int) r58.e(r50))) goto L182;
        r56.E(r56.e() - r56.l());
    L182:
        if (r56.f() <= 0) goto L185;
        if (r52 == true) goto L185;
        r56.E((int) r58.e((int) (r50 * (r56.f() / 100.0f))));
    L185:
        if (r52 == true) goto L190;
        if (r56.e() <= r50) goto L190;
        r56.E((int) r58.e(r50));
    L190:
        if (s() == false) goto L193;
        r56.E((int) r58.e(com.bytedance.android.anniex.container.util.i.c(this.a).heightPixels - getRealNavigationBarHeight()));
    L193:
        if (r56.B() <= 0) goto L196;
        if (r52 == true) goto L196;
        r56.G((int) r58.e((int) (r48 * (r56.B() / 100.0f))));
    L196:
        y36.a r61 = r56.s;
        if (r61 == null) goto L199;
        boolean r62 = Intrinsics.areEqual(((y36.i) r61).b, Boolean.TRUE);
    L200:
        if (r62 == false) goto L204;
        if (r52 == false) goto L204;
        r56.G((int) r58.e(r56.k() + r50));
    L204:
        if (r56.e() > 0) goto L207;
        r56.E(450);
    L207:
        if (r56.A() > 0) goto L209;
        r56.G(FontWeight.WEIGHT_300);
    L209:
        y36.a r63 = r56.R;
        if (r63 == null) goto L212;
        boolean r64 = Intrinsics.areEqual(((y36.i) r63).b, Boolean.TRUE);
    L213:
        if (r64 == false) goto L216;
        r56.E(r56.e() + 48);
    L216:
        if (r56.w() == false) goto L238;
        int r65 = getRealNavigationBarHeight();
        if (r56.z() == false) goto L220;
        int r66 = com.bytedance.android.anniex.container.util.i.c(this.a).heightPixels - r65;
    L221:
        r56.E(((int) r58.e(r66)) + 2);
        if (r56.x() <= 0) goto L231;
        float r110 = 1 - RangesKt.coerceAtMost(r56.x() / 100.0f, 1.0f);
        if (r56.z() == false) goto L226;
        r66 = r66 + r65;
    L226:
        float r67 = r66 * r110;
        if (r56.z() == false) goto L229;
        int r68 = r65 + 2;
    L230:
        r56.O = new y36.d(Integer.valueOf((int) r58.e((int) (r67 - r68))));
        goto L231
    L229:
        r68 = 0;
    L231:
        r r69 = r56.P;
        if (r69 == null) goto L236;
        Integer r70 = (Integer) ((y36.i) r69).b;
        if (r70 == null) goto L236;
        int r71 = r70.intValue();
    L237:
        this.f = r71;
    L236:
        r71 = 1580077;
        goto L237
    L220:
        r66 = r58.d();
    L238:
        y36.a r72 = r56.S;
        if (r72 == null) goto L241;
        boolean r73 = Intrinsics.areEqual(((y36.i) r72).b, Boolean.TRUE);
    L242:
        if (r73 == false) goto L252;
        if (t() == true) goto L252;
        ia.f.a r74 = this.b;
        if (r74 != null) goto L248;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r74 = null;
    L248:
        Integer r75 = r74.f(MapsKt.emptyMap());
        if (r75 == null) goto L252;
        r56.E((int) (((double) r58.e(r75.intValue())) + 0.5d));
        r56.F = new y36.d(0);
        r56.G = new y36.d(0);
    L252:
        if (r56.q() >= 0) goto L255;
        r56.F(0);
    L255:
        if (r56.t() >= 0) goto L258;
        r56.F = new y36.d(0);
    L258:
        if (r56.u() >= 0) goto L261;
        r56.G = new y36.d(0);
    L261:
        if (r56.s() >= 0) goto L264;
        r56.I = new y36.d(0);
    L264:
        if (r56.r() >= 0) goto L266;
        r56.H = new y36.d(0);
    L266:
        if (r52 == false) goto L282;
        float r76 = RangesKt.coerceAtMost(r56.h(), 100) / 100.0f;
        float r77 = 0;
        if (r76 <= r77) goto L270;
        r56.E((int) r58.e((int) (r50 * r76)));
    L270:
        y36.j r78 = r56.p;
        if (r78 == null) goto L275;
        Integer r79 = (Integer) ((y36.i) r78).b;
        if (r79 == null) goto L275;
        int r80 = r79.intValue();
    L276:
        float r81 = RangesKt.coerceAtMost(r80, 100) / 100.0f;
        if (r81 <= r77) goto L280;
        r56.G((int) r58.e((int) (r48 * r81)));
    L280:
        if (r56.i() <= 0) goto L282;
        r56.F(r56.i());
    L275:
        r80 = 0;
        goto L276
    L241:
        r73 = false;
        goto L242
    L212:
        r64 = false;
        goto L213
    L199:
        r62 = false;
        goto L200
    L171:
        r60 = false;
    L174:
        if (r56.d() != 80) goto L179;
        int r111 = (int) (r50 * 0.85f);
        if (r56.e() <= r58.e(r111)) goto L179;
        r56.E((int) r58.e(r111));
        HybridLogger.m("AnnieXPopupContainer", "screenHeight: " + r50 + "; screenWidth: " + r48 + " ; this.height2: " + r56.e(), null, null, 12);
        goto L179
    L165:
        if (r56.e() <= r50) goto L167;
        r56.E((int) r58.e(r50 - (r56.k() * 2)));
    L282:
        ab.a r82 = this.j;
        if (r82 == null) goto L298;
        Object r83 = this.d;
        if ((r83 instanceof SheetBaseDialog) == false) goto L287;
        ?? r84 = (SheetBaseDialog) r83;
    L288:
        if (r84 == 0) goto L298;
        boolean r85 = r82.w();
        int r86 = r82.e();
        y36.d r87 = r82.O;
        if (r87 == null) goto L294;
        Integer r88 = (Integer) ((y36.i) r87).b;
        if (r88 == null) goto L294;
        int r89 = r88.intValue();
    L295:
        r84.p = r85;
        if (r89 <= 0) goto L298;
        r84.q = i16.c.f(r86 - r89, r84.getContext());
    L294:
        r89 = 0;
        goto L295
    L287:
        r84 = 0;
    L298:
        Dialog r90 = this.d;
        if (r90 == null) goto L303;
        Window r91 = r90.getWindow();
        if (r91 == null) goto L303;
        r91.addFlags(Integer.MIN_VALUE);
        r91.setStatusBarColor(0);
        r91.setNavigationBarColor(0);
    L303:
        HybridLogger.m("AnnieXPopupContainer", "===onCreateView: " + getUrl(), null, null, 12);
        return;
    L123:
        if (t() == false) goto L151;
        y36.a r92 = r54.r;
        if (r92 == null) goto L127;
        boolean r93 = Intrinsics.areEqual(((y36.i) r92).b, Boolean.TRUE);
    L128:
        if (r93 == true) goto L130;
        r54.F(8);
        r54.E((int) com.bytedance.android.anniex.container.util.i.a.e(r50 - (r54.k() * 2)));
        r54.G(FontWeight.WEIGHT_300);
    L130:
        y36.a r94 = r54.q;
        if (r94 == null) goto L133;
        boolean r95 = Intrinsics.areEqual(((y36.i) r94).b, Boolean.FALSE);
    L134:
        if (r95 == false) goto L137;
        r54.h = 8388613;
    L140:
        if (r54.j() <= 0) goto L143;
        r54.G(r54.j());
    L143:
        if (r54.g() <= 0) goto L146;
        r54.E(r54.g());
    L146:
        if (r54.h() <= 0) goto L148;
        r54.E((int) com.bytedance.android.anniex.container.util.i.a.e((com.bytedance.android.anniex.container.util.i.c(this.a).heightPixels * r54.h()) / 100));
    L148:
        r54.M = new y36.a(Boolean.FALSE);
        i16.c r96 = i16.c.a;
        if (i16.c.d(getContext()) == false) goto L154;
        r54.W = new y36.d(Integer.valueOf(getRealNavigationBarHeight()));
        goto L154
    L137:
        if (r54.d() != 80) goto L140;
        r54.h = 8388693;
        goto L140
    L133:
        r95 = false;
        goto L134
    L127:
        r93 = false;
        goto L128
    L151:
        i16.c r97 = i16.c.a;
        if (i16.c.d(getContext()) == false) goto L154;
        r54.X = new y36.d(Integer.valueOf(getRealNavigationBarHeight()));
        goto L154
    L105:
        if (r44.c() != true) goto L107;
        r45 = true;
    L110:
        Dialog r98 = this.d;
        if (r98 == null) goto L113;
        r98.hide();
        goto L113
    L95:
        if (r42.A() == 0) goto L97;
    L99:
        r43 = false;
        goto L101
    L97:
        if (r42.e() != 0) goto L99;
    L57:
        if (r32.w() != true) goto L59;
        r33 = true;
    L53:
        r31 = null;
        goto L54
    L50:
        View r99 = getRootView();
        if (r99 == null) goto L53;
        r31 = r99.findViewById(2131362989);
    L42:
        r28 = true;
    L45:
        r29 = false;
        goto L46
    L5:
        r1 = null;
        goto L6
    }

    @Override // ia.g
    public final boolean c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusBarBgColor");
        com.bytedance.android.anniex.container.ui.h r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L5:
        r0.g(r10);
        return true;
    }

    @Override // ia.f
    public final void d(ia.f.a r10) {
        Intrinsics.checkNotNullParameter(r10, "popupComponent");
        this.b = r10;
        super.setUiComponent(r10);
    }

    @Override // ia.h
    public final boolean e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleBarBgColor");
        com.bytedance.android.anniex.container.ui.h r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L5:
        r0.e(r10);
        return true;
    }

    @Override // ia.h
    public final void f(boolean r10) {
        com.bytedance.android.anniex.container.ui.h r0 = null;
        if (r10 == false) goto L9;
        com.bytedance.android.anniex.container.ui.h r11 = this.l;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
    L8:
        r0.l();
        return;
    L7:
        r0 = r11;
        goto L8
    L9:
        com.bytedance.android.anniex.container.ui.h r12 = this.l;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
    L13:
        r0.a();
        return;
    L12:
        r0 = r12;
        goto L13
    }

    @Override // ia.f
    public final Dialog h(Bundle r13) {
        ab.a r0 = this.j;
        if (r0 == null) goto L7;
        y36.a r1 = r0.c;
        if (r1 == null) goto L7;
        boolean r10 = Intrinsics.areEqual(((y36.i) r1).b, Boolean.TRUE);
    L8:
        boolean r11 = true;
        if (r10 == false) goto L19;
        ia.f.a r12 = this.b;
        AppCompatDialog r14 = null;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r12 = null;
    L13:
        AppCompatDialog r15 = r12.g(r13);
        if (r15 == null) goto L33;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L18;
        r16.setBackgroundDrawable(new ColorDrawable(0));
        r16.addFlags(256);
    L18:
        r14 = r15;
    L33:
        this.d = r14;
        ab.a r17 = this.j;
        if (r17 == null) goto L36;
        r11 = r17.c();
    L36:
        v(r11);
        Dialog r18 = this.d;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.app.Dialog");
        return r18;
    L19:
        Context r19 = getContext();
        boolean r20 = t();
        boolean r110 = t();
        if (s() == false) goto L23;
        if (r110 == true) goto L23;
        boolean r21 = true;
    L24:
        Window r111 = this.a.getWindow();
        if (r111 == null) goto L29;
        View r112 = q(r111);
        if (r112 == null) goto L29;
        int r113 = r112.getWidth();
    L30:
        r14 = new SheetBaseDialog(r19, r20, false, r21, false, r113);
        Window r114 = r14.getWindow();
        if (r114 == null) goto L33;
        r114.setBackgroundDrawable(new ColorDrawable(0));
        r114.addFlags(256);
    L29:
        r113 = 0;
    L23:
        r21 = r110;
    L7:
        r10 = false;
        goto L8
    }

    @Override // ia.f
    public final void m(boolean r1) {
        this.g = r1;
    }

    @Override // ia.f
    public final void o(DialogFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "dialogFragment");
        this.c = r10;
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.e
    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        HybridLogger r11 = HybridLogger.a;
        HybridLogger.m("AnnieXPopupContainer", "===onConfigurationChanged: " + getUrl(), null, null, 12);
        ab.a r12 = this.j;
        if (r12 == null) goto L6;
        z(this.d, r12.A(), r12.e(), r12.d());
        return;
    }

    @Override // ia.b, ia.c
    public final void onCreate(Bundle r10) {
        HybridLogger r11 = HybridLogger.a;
        DialogFragment r12 = null;
        HybridLogger.m("AnnieXPopupContainer", "===onCreate: " + getUrl(), null, null, 12);
        setContainerVisible(true);
        if (t() == false) goto L9;
        DialogFragment r0 = this.c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L8:
        r12.setStyle(1, 2131954095);
        return;
    L7:
        r12 = r0;
        goto L8
    L9:
        DialogFragment r1 = this.c;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L13:
        r12.setStyle(1, 2131954089);
        return;
    L12:
        r12 = r1;
        goto L13
    }

    @Override // ia.f
    public final void onDismiss(DialogInterface r10) {
        HybridLogger r11 = HybridLogger.a;
        y36.i r12 = null;
        HybridLogger.m("AnnieXPopupContainer", "===onDismiss: " + getUrl(), null, null, 12);
        ab.b r13 = this.k;
        boolean r0 = false;
        if (r13 == null) goto L10;
        y36.i r14 = r13.d;
        if (r14 == null) goto L7;
        r12 = r14;
    L8:
        if (r12 == null) goto L10;
        boolean r15 = Intrinsics.areEqual(r12.b, Boolean.TRUE);
    L11:
        if (r15 == true) goto L18;
        ab.b r16 = this.k;
        if (r16 == null) goto L17;
        y36.a r17 = r16.c();
        if (r17 == null) goto L17;
        r0 = Intrinsics.areEqual(((y36.i) r17).b, Boolean.TRUE);
    L17:
        if (r0 == true) goto L18;
    L19:
        Window r18 = this.a.getWindow();
        if (r18 == null) goto L25;
        int r1 = r18.getStatusBarColor();
        int r19 = this.e;
        if (r1 == r19) goto L26;
        r18.setStatusBarColor(r19);
        return;
    L26:
        return;
    L25:
        return;
    L18:
        Window r20 = this.a.getWindow();
        r20.clearFlags(Integer.MIN_VALUE);
        q(r20).setSystemUiVisibility(this.t);
        r20.addFlags(this.u);
        r20.setStatusBarColor(this.v);
        goto L19
    L7:
        Intrinsics.throwUninitializedPropertyAccessException("hideStatusBar");
    L10:
        r15 = false;
        goto L11
    }

    @Override // ia.f
    public final void onShow(DialogInterface r10) {
        HybridLogger r11 = HybridLogger.a;
        HybridLogger.m("AnnieXPopupContainer", "===onShow: " + getUrl(), null, null, 12);
        if (t() == false) goto L10;
        Dialog r12 = this.d;
        if (r12 == null) goto L11;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L12;
        r13.clearFlags(8);
        q(r13).setSystemUiVisibility(5894);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // ia.h
    public final boolean p(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleColor");
        com.bytedance.android.anniex.container.ui.h r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L5:
        r0.k(r10);
        return true;
    }

    @Override // ia.g
    public final boolean setStatusFontMode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusFontMode");
        com.bytedance.android.anniex.container.ui.h r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L5:
        r0.i(r10);
        return true;
    }

    @Override // ia.h
    public final void setTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        com.bytedance.android.anniex.container.ui.h r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L5:
        r0.j(r10);
    }

    @Override // ia.e
    public final void setUserVisibleHint(boolean r10) {
        if (r10 == true) goto L4;
    L6:
        onVisibleChange(r10, Boolean.FALSE);
        return;
    L4:
        if (getContainerVisible() == false) goto L6;
        setContainerVisible(false);
        goto L6
    }

    public final void u(int r10) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, r10);     // Catch: JSONException -> L4
        sendEvent(new c(r0));     // Catch: JSONException -> L4
        return;
    }

    public final void v(boolean r10) {
        DialogFragment r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r0 = null;
    L5:
        r0.setCancelable(r10);
        Dialog r1 = this.d;
        if (r1 == null) goto L9;
        r1.setCanceledOnTouchOutside(r10);
        return;
    }

    @Override // ia.e
    public final void b(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        HybridLogger r0 = HybridLogger.a;
        Integer r10 = null;
        HybridLogger.m("AnnieXPopupContainer", "===onViewCreated: " + getUrl(), null, null, 12);
        Object r1 = this.d;
        if ((r1 instanceof SheetBaseDialog) == false) goto L5;
        SheetBaseDialog r11 = (SheetBaseDialog) r1;
    L6:
        if (r11 == null) goto L8;
        r11.o = new e(this);
    L8:
        View r12 = getRootView();
        if (r12 == null) goto L11;
        r12.setOnClickListener(new f(this));
    L11:
        Object r13 = this.d;
        if ((r13 instanceof SheetBaseDialog) == false) goto L14;
        SheetBaseDialog r14 = (SheetBaseDialog) r13;
    L15:
        if (r14 == null) goto L19;
        g r15 = new g(this);
        Intrinsics.checkNotNullParameter(r15, "bottomSheetPullUpProcessor");
        r14.n = new com.bytedance.android.anniex.container.popup.a(r15, r14);
        SheetBaseBehavior<?> r16 = r14.f;
        if (r16 == null) goto L19;
        Intrinsics.checkNotNull(r16);
        r16.e = r14.n;
    L19:
        ab.a r19 = this.j;
        if (r19 != null) goto L22;
    L24:
        boolean r20 = false;
    L25:
        if (r20 == false) goto L27;
        u(1);
    L27:
        Object r21 = this.d;
        if ((r21 instanceof SheetBaseDialog) == false) goto L30;
        SheetBaseDialog r22 = (SheetBaseDialog) r21;
    L31:
        if (r22 == null) goto L35;
        h r23 = new h(this);
        Intrinsics.checkNotNullParameter(r23, "bottomSheetSlideProcessor");
        r22.m = new com.bytedance.android.anniex.container.popup.b(r23, r22);
        SheetBaseBehavior<?> r24 = r22.f;
        if (r24 == null) goto L35;
        Intrinsics.checkNotNull(r24);
        r24.d = r22.m;
    L35:
        Object r25 = this.d;
        if ((r25 instanceof SheetBaseDialog) == false) goto L38;
        SheetBaseDialog r26 = (SheetBaseDialog) r25;
    L39:
        if (r26 == null) goto L43;
        i r27 = new i(this);
        if (r26.l.contains(r27) == true) goto L43;
        r26.l.add(r27);
    L43:
        ab.a r28 = this.j;
        if (r28 == null) goto L48;
        y36.a r29 = r28.R;
        if (r29 == null) goto L48;
        boolean r30 = Intrinsics.areEqual(((y36.i) r29).b, Boolean.TRUE);
    L49:
        if (r30 == false) goto L55;
        View r31 = getRootView();
        if (r31 == null) goto L55;
        ImageView r32 = (ImageView) r31.findViewById(2131363002);
        if (r32 == null) goto L55;
        r32.setVisibility(0);
        r32.setOnClickListener(new j(this));
    L55:
        Dialog r33 = this.d;
        if (r33 == null) goto L58;
        Window r34 = r33.getWindow();
    L59:
        ab.a r35 = this.j;
        if (r35 == null) goto L159;
        z(this.d, r35.A(), r35.e(), r35.d());
        int r36 = r35.q();
        int r110 = r35.t();
        int r111 = r35.u();
        int r112 = r35.s();
        int r113 = r35.r();
        if (r36 <= 0) goto L68;
        float r37 = com.bytedance.android.anniex.container.util.i.a.a(r36);
        HybridLogger.f("PopupLog", "setRadius: 窗口圆角 = " + r37 + "px", null, 12);
        View r114 = getRootView();
        if (r114 == null) goto L73;
        RadiusFrameLayout r115 = (RadiusFrameLayout) r114.findViewById(2131363000);
        if (r115 == null) goto L73;
        r115.setRadius(r37);
    L73:
        if (r34 == null) goto L159;
        y36.a r38 = r35.Y;
        if (r38 == null) goto L79;
        Boolean r39 = (Boolean) ((y36.i) r38).b;
        if (r39 == null) goto L79;
        boolean r40 = r39.booleanValue();
    L80:
        if (r40 == true) goto L82;
        r34.setSoftInputMode(48);
    L82:
        WindowManager.LayoutParams r41 = r34.getAttributes();
        r41.width = -1;
        r41.height = -1;
        y36.a r116 = r35.y;
        if (r116 == null) goto L85;
        boolean r117 = Intrinsics.areEqual(((y36.i) r116).b, Boolean.TRUE);
    L86:
        if (r117 == true) goto L88;
        r41.windowAnimations = 2131954098;
    L203:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L101
        r34.setAttributes(r41);     // Catch: Throwable -> L101
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L104:
        if (w() == false) goto L106;
        x();
    L205:
        r r119 = r35.x;     // Catch: Exception -> L131
        if (r119 == null) goto L128;
        Integer r120 = (Integer) ((y36.i) r119).b;     // Catch: Exception -> L131
        if (r120 == null) goto L128;
        int r121 = r120.intValue();     // Catch: Exception -> L131
    L129:
        r34.setBackgroundDrawable(new ColorDrawable(r121));     // Catch: Exception -> L131
    L134:
        if (r35.A() <= 0) goto L136;
        int r42 = com.bytedance.android.anniex.container.util.i.a.a(r35.A() + r35.m());
    L137:
        r34.setLayout(r42, -1);
        if (s() == true) goto L140;
        r34.setFlags(1024, 1024);
    L140:
        ab.a r43 = this.j;
        if (r43 != null) goto L143;
    L148:
        boolean r44 = true;
    L149:
        if (r44 == false) goto L152;
        r34.addFlags(32);
        r34.getAttributes().dimAmount = 0.0f;
    L152:
        if (r35.w() == false) goto L159;
        Object r45 = this.d;
        m r46 = new m(this);
        if ((r45 instanceof SheetBaseDialog) == false) goto L156;
        SheetBaseDialog r47 = (SheetBaseDialog) r45;
    L157:
        if (r47 == null) goto L159;
        r47.k = r46;
        goto L159
    L156:
        r47 = null;
        goto L157
    L143:
        if (r43.A() == 0) goto L145;
    L147:
        r44 = false;
        goto L149
    L145:
        if (r43.e() != 0) goto L147;
    L136:
        r42 = r35.A();
    L128:
        r121 = ColorProtector.parseColor("#00FFFFFF");     // Catch: Exception -> L131
    L131:
        e = move-exception;
        HybridLogger r122 = HybridLogger.a;
        HybridLogger.i("AnnieXPopupContainer", "maskBgColor: " + e.getMessage(), null, 12);
        goto L134
    L106:
        ab.a r48 = this.j;
        if (r48 == null) goto L120;
        y36.a r123 = r48.K;
        if (r123 == null) goto L111;
        boolean r124 = Intrinsics.areEqual(((y36.i) r123).b, Boolean.TRUE);
    L112:
        if (r124 == true) goto L119;
        y36.a r49 = r48.L;
        if (r49 == null) goto L116;
        boolean r50 = Intrinsics.areEqual(((y36.i) r49).b, Boolean.TRUE);
    L117:
        if (r50 == true) goto L119;
    L116:
        r50 = false;
    L119:
        boolean r51 = false;
    L121:
        if (r51 == false) goto L205;
        r();
        goto L205
    L111:
        r124 = false;
    L120:
        r51 = true;
    L101:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L104
    L88:
        if (com.bytedance.android.anniex.container.util.i.a.getResources().getConfiguration().orientation != 2) goto L90;
        r41.windowAnimations = 2131954096;
        goto L203
    L90:
        y36.l r126 = r35.z;
        if (r126 == null) goto L93;
        PopupType r127 = (PopupType) ((y36.i) r126).b;
    L95:
        if (r127 != PopupType.RIGHT) goto L97;
        r41.windowAnimations = 2131954096;
        goto L203
    L97:
        r41.windowAnimations = 2131954097;
        goto L203
    L93:
        r127 = null;
        goto L95
    L85:
        r117 = false;
    L79:
        r40 = true;
        goto L80
    L68:
        com.bytedance.android.anniex.container.util.i r52 = com.bytedance.android.anniex.container.util.i.a;
        float r128 = r52.a(r110);
        float r129 = r52.a(r111);
        float r130 = r52.a(r112);
        float r53 = r52.a(r113);
        HybridLogger.f("PopupLog", "setRadius: 窗口圆角 = (" + r128 + "px, " + r129 + "px, " + r130 + "px, " + r53 + "px)", null, 12);
        View r54 = getRootView();
        if (r54 == null) goto L73;
        RadiusFrameLayout r55 = (RadiusFrameLayout) r54.findViewById(2131363000);
        if (r55 == null) goto L73;
        r55.a(r128, r129, r130, r53);
    L159:
        ab.a r56 = this.j;
        if (r56 != null) goto L162;
    L196:
        FrameLayout r57 = this.q;
        if (r57 == null) goto L201;
        ViewGroup.LayoutParams r58 = r57.getLayoutParams();
        if (r58 == null) goto L201;
        r10 = Integer.valueOf(r58.height);
    L201:
        this.m = r10;
        return;
    L162:
        if (r56.o() == false) goto L164;
    L165:
        y36.a r59 = r56.D;
        if (r59 == null) goto L170;
        Boolean r60 = (Boolean) ((y36.i) r59).b;
        if (r60 == null) goto L170;
        boolean r61 = r60.booleanValue();
    L171:
        if (r61 == true) goto L196;
        if (com.bytedance.android.anniex.container.util.h.a(this.a) == true) goto L196;
        View r62 = r17.findViewById(2131363008);
        p r63 = r56.B;
        if (r63 == null) goto L178;
        String r64 = (String) ((y36.i) r63).b;
        if (r64 == null) goto L178;
    L179:
        this.n = r17.findViewById(2131363007);
        if (r62 == null) goto L184;
        r62.setVisibility(0);
    L184:
        if (Intrinsics.areEqual(IHostContextDepend.SKIN_TYPE_WHITE, r64) == false) goto L189;
        View r65 = this.n;
        if (r65 == null) goto L196;
        r65.setBackgroundResource(2131231352);
        goto L196
    L189:
        if (Intrinsics.areEqual("dark", r64) == false) goto L193;
        View r66 = this.n;
        if (r66 == null) goto L196;
        r66.setBackgroundResource(2131231351);
        goto L196
    L193:
        View r67 = this.n;
        if (r67 == null) goto L196;
        r67.setBackgroundResource(2131231352);
    L178:
        r64 = "";
    L170:
        r61 = false;
        goto L171
    L164:
        if (r56.w() == false) goto L196;
    L58:
        r34 = null;
    L48:
        r30 = false;
        goto L49
    L38:
        r26 = null;
        goto L39
    L30:
        r22 = null;
        goto L31
    L22:
        if (r19.w() != true) goto L24;
        r20 = true;
        goto L25
    L14:
        r14 = null;
        goto L15
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void onWebPageFinish(WebView r10, String r11) {
        super.onWebPageFinish(r10, r11);
        Map r12 = x26.a.a;
        w26.g r13 = (w26.g) x26.a.a(w26.g.class);
        if (r13 == null) goto L9;
        w26.e r14 = (w26.e) r13.n0(w26.e.class);
        if (r14 == null) goto L9;
        Boolean r15 = r14.C();
        if (r15 == null) goto L9;
        boolean r16 = r15.booleanValue();
    L10:
        if (r16 == false) goto L12;
    L15:
        this.a.runOnUiThread(new b(r10, this));
        return;
    L12:
        if (this.l != null) goto L15;
        HybridLogger.p("AnnieXPopupContainer", "onWebPageFinish is called before statusBarAndNavImp initialized, skip UI update.", null, 12);
        return;
    L9:
        r16 = false;
        goto L10
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void onWebScrollChanged(int r1, int r10, int r11, int r12) {
        super.onWebScrollChanged(r1, r10, r11, r12);
        this.s = r10;
        boolean r13 = true;
        if (r10 <= 0) goto L16;
        ab.a r14 = this.j;
        if (r14 != null) goto L7;
    L9:
        boolean r15 = false;
    L10:
        if (r15 == false) goto L16;
        if (this.p != 3) goto L14;
    L15:
        f(true);
        return;
    L14:
        if (s() == true) goto L15;
        return;
    L7:
        if (r14.b() != true) goto L9;
        r15 = true;
    L16:
        if (r10 != 0) goto L28;
        ab.a r16 = this.j;
        if (r16 != null) goto L20;
    L22:
        r13 = false;
    L23:
        if (r13 == false) goto L29;
        f(false);
        return;
    L29:
        return;
    L20:
        if (r16.b() != true) goto L22;
    }

    public final void z(Dialog r11, int r12, int r13, int r14) {
        if (r11 == null) goto L29;
        Window r15 = r11.getWindow();
        if (r15 == null) goto L29;
        if (this.j == null) goto L29;
        WindowManager.LayoutParams r10 = r15.getAttributes();
        r10.gravity = r14;
        if (r12 <= 0) goto L12;
        r10.width = com.bytedance.android.anniex.container.util.i.a.a(r12);
    L12:
        ab.a r16 = this.j;
        if (r16 != null) goto L15;
    L140:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L27
        r15.setAttributes(r10);     // Catch: Throwable -> L27
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L15:
        if (r16.C() <= 0) goto L18;
        r10.x = r16.C();
    L18:
        if (r16.D() <= 0) goto L21;
        r10.y = r16.D();
    L21:
        if (r16.B() <= 0) goto L140;
        if (com.bytedance.android.anniex.container.util.i.a.getResources().getConfiguration().orientation == 2) goto L140;
        float r19 = r16.B() / 100.0f;
        i16.c r20 = i16.c.a;
        r10.width = (int) (i16.c.j(this.a) * r19);
    L29:
        View r110 = getRootView();
        ViewGroup.LayoutParams r21 = null;
        if (r110 == null) goto L32;
        FrameLayout r111 = (FrameLayout) r110.findViewById(2131363003);
    L33:
        this.q = r111;
        if (r111 == null) goto L36;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
    L37:
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r113 = (RelativeLayout.LayoutParams) r112;
        if (r12 <= 0) goto L40;
        r12 = com.bytedance.android.anniex.container.util.i.a.a(r12);
    L40:
        r113.width = r12;
        if (r13 <= 0) goto L43;
        r13 = com.bytedance.android.anniex.container.util.i.a.a(r13);
    L43:
        r113.height = r13;
        ab.a r114 = this.j;
        boolean r115 = true;
        if (r114 == null) goto L95;
        com.bytedance.android.anniex.container.util.i r22 = com.bytedance.android.anniex.container.util.i.a;
        if (r22.getResources().getConfiguration().orientation == 2) goto L80;
        if (s() == false) goto L51;
        r113.height = com.bytedance.android.anniex.container.util.i.c(this.a).heightPixels - getRealNavigationBarHeight();
    L89:
        if (r114.l() <= 0) goto L92;
        r113.bottomMargin = r22.a(r114.l() * 1.0f);
    L92:
        if (r114.m() <= 0) goto L95;
        r113.rightMargin = r22.a(r114.m() * 1.0f);
        goto L95
    L51:
        if (r114.z() == true) goto L61;
        if (r114.f() <= 0) goto L89;
        y36.a r1 = r114.S;
        if (r1 == null) goto L57;
        boolean r23 = Intrinsics.areEqual(((y36.i) r1).b, Boolean.TRUE);
    L58:
        if (r23 == true) goto L89;
        r113.height = (int) (r22.d() * RangesKt.coerceAtMost(r114.f() / 100.0f, 1.0f));
        goto L89
    L57:
        r23 = false;
        goto L58
    L61:
        if (r114.f() <= 0) goto L89;
        float r0 = RangesKt.coerceAtMost(r114.f() / 100.0f, 1.0f);
        if (isPadOrFold() == false) goto L78;
        Map r24 = x26.a.a;
        w26.g r25 = (w26.g) x26.a.a(w26.g.class);
        if (r25 == null) goto L71;
        w26.e r26 = (w26.e) r25.n0(w26.e.class);
        if (r26 == null) goto L71;
        Boolean r27 = r26.k0();
        if (r27 == null) goto L71;
        boolean r28 = r27.booleanValue();
    L72:
        if (r28 == false) goto L78;
        int r29 = com.bytedance.android.anniex.container.util.i.c(getContext()).heightPixels;
        i16.c r30 = i16.c.a;
        Context r31 = getContext();
        Intrinsics.checkNotNullParameter(r31, "context");
        Resources r32 = r30.getResources(r31);
        int r33 = r32.getIdentifier("status_bar_height", "dimen", "android");
        if (r33 <= 0) goto L76;
        int r34 = r32.getDimensionPixelSize(r33);
    L77:
        r113.height = (int) (((r29 - r34) - getRealNavigationBarHeight()) * r0);
        goto L89
    L76:
        r34 = 0;
    L71:
        r28 = true;
    L78:
        r113.height = (int) (com.bytedance.android.anniex.container.util.i.c(getContext()).heightPixels * r0);
        goto L89
    L80:
        if (r22.getResources().getConfiguration().orientation != 2) goto L89;
        if (r114.z() == true) goto L89;
        if (r114.f() <= 0) goto L89;
        y36.a r35 = r114.S;
        if (r35 == null) goto L89;
        Intrinsics.areEqual(((y36.i) r35).b, Boolean.TRUE);
    L95:
        if (r14 != 0) goto L97;
    L108:
        r113.addRule(13);
    L109:
        FrameLayout r116 = this.q;
        if (r116 == null) goto L113;
        r116.setLayoutParams(r113);
    L113:
        int r117 = r113.height;
        if (com.bytedance.ies.bullet.service.base.h.x() == false) goto L136;
        ab.a r118 = this.j;
        if (r118 != null) goto L118;
    L120:
        boolean r119 = false;
    L121:
        if (r119 == false) goto L136;
        ab.a r120 = this.j;
        if (r120 != null) goto L125;
    L127:
        r115 = false;
    L128:
        if (r115 == false) goto L136;
        View r121 = getRootView();
        if (r121 == null) goto L132;
        View r122 = r121.findViewById(2131363000);
    L133:
        if (r122 == null) goto L135;
        r21 = r122.getLayoutParams();
    L135:
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r36 = (FrameLayout.LayoutParams) r21;
        r36.height = r117;
        r122.setLayoutParams(r36);
        goto L136
    L132:
        r122 = null;
        goto L133
    L125:
        if (r120.w() == true) goto L127;
    L118:
        if (r118.d() != 80) goto L120;
        r119 = true;
    L136:
        FrameLayout r123 = this.q;
        if (r123 == null) goto L142;
        r123.requestLayout();
        return;
    L142:
        return;
    L97:
        if ((r14 & 17) == 17) goto L108;
        if ((r14 & 80) != 80) goto L103;
        r113.addRule(12);
        r113.addRule(11);
        goto L109
    L103:
        if ((r14 & 5) != 5) goto L106;
        r113.addRule(11);
        goto L109
    L106:
        if ((r14 & 8388613) != 8388613) goto L109;
        r113.addRule(21);
        goto L109
    L36:
        r112 = null;
        goto L37
    L32:
        r111 = null;
        goto L33
    }
}
