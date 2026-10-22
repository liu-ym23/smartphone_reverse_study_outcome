package com.bytedance.android.anniex.lite.container;

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
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;
import y36.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXFlowPopupContainer extends AnnieXLiteContainer implements ia.f {
    public final FragmentActivity a;
    public ia.f.a b;
    public DialogFragment c;
    public View d;
    public Dialog e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final Lazy k;
    public final Lazy l;
    public com.bytedance.android.anniex.container.ui.h m;
    public Integer n;
    public View o;
    public View p;
    public int q;
    public FrameLayout r;
    public final b s;
    public Boolean t;
    public int u;
    public View v;
    public int w;
    public int x;
    public int y;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.anniex.base.lifecycle.a {
        public final /* synthetic */ AnnieXFlowPopupContainer a;

        public b(AnnieXFlowPopupContainer r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void i(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            super.i(r10, r11);
            AnnieXFlowPopupContainer r12 = this.a;
            View r13 = r12.getKitView();
            if (r13 != null) goto L5;
            return;
        L5:
            if ((r13 instanceof WebView) == false) goto L9;
            r12.a.runOnUiThread(new h(r13, r12));
            return;
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

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$observerKeyboardStatusChange$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(Object r10) {
            super(1, r10, AnnieXFlowPopupContainer.class, "onSoftInputChange", "onSoftInputChange(Z)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r10) {
            ((AnnieXFlowPopupContainer) ((CallableReference) this).receiver).onSoftInputChange(r10);
        }
    }

    static {
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
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
        Object r0 = this.e;
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
        return this.n;
    L5:
        r1 = null;
        goto L6
    }

    @Override // ia.e
    public final void onStart() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        z();     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final ab.a r() {
        return (ab.a) this.k.getValue();
    }

    public final ab.b s() {
        return (ab.b) this.l.getValue();
    }

    public final void t() {
        Dialog r0 = this.e;
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.clearFlags(2);
    L7:
        Dialog r10 = this.e;
        if (r10 == null) goto L13;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L14;
        r11.setDimAmount(0.0f);
        return;
    L14:
        return;
    }

    public final boolean v() {
        return com.bytedance.android.anniex.container.util.h.a(this.a);
    }

    public final void z() {
        Dialog r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        Window r1 = r0.getWindow();
        Boolean r10 = this.t;
        Boolean r11 = Boolean.TRUE;
        if (Intrinsics.areEqual(r10, r11) == false) goto L28;
        if (r1 == null) goto L28;
        ab.a r12 = r();
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
        if (this.t != null) goto L31;
        this.t = r11;
        return;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b
    public final void observerKeyboardStatusChange() {
        if (com.bytedance.ies.bullet.service.base.h.o0() == false) goto L7;
        Dialog r0 = this.e;
        if (r0 == null) goto L9;
        SoftInputKt.d(r0, new AnonymousClass1(this));
        return;
    L9:
        return;
    L7:
        super.observerKeyboardStatusChange();
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

    public final boolean u() {
        ab.a r0 = r();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L15;
        ab.a r10 = r();
        if (r10 != null) goto L12;
    L14:
        return false;
    L12:
        if (r10.y() != true) goto L14;
        return true;
    L15:
        ab.a r11 = r();
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

    public final boolean x() {
        ab.a r0 = r();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.n() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final void y() {
        ab.a r0 = r();
        if (r0 == null) goto L15;
        Dialog r1 = this.e;
        if (r1 == null) goto L9;
        Window r10 = r1.getWindow();
        if (r10 == null) goto L9;
        r10.addFlags(2);
    L9:
        Dialog r11 = this.e;
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

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final Scenes getScenes() {
        return Scenes.PopupFragment;
    }

    public AnnieXFlowPopupContainer(com.bytedance.android.anniex.base.builder.c r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        super(r10);
        this.a = r10.e();
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        this.f = -16777216;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = LazyKt.lazy(new AnnieXFlowPopupContainer$annieXPopupModel$2(this));
        this.l = LazyKt.lazy(new AnnieXFlowPopupContainer$annieXStatusAndNavModel$2(this));
        this.q = -1;
        this.s = new b(this);
        this.w = 1024;
        this.x = 2048;
        this.y = -1;
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

    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.app.Dialog, com.bytedance.android.anniex.container.popup.SheetBaseDialog] */
    @Override // ia.e
    public final void a(View r21) {
        this.d = r21;
        if (r21 == null) goto L5;
        FrameLayout r1 = (FrameLayout) r21.findViewById(2131363000);
    L6:
        if (r1 != null) goto L8;
        r1 = new FrameLayout(this.a);
    L8:
        setParentViewGroup(r1);
        Window r10 = this.a.getWindow();
        this.w = q(r10).getSystemUiVisibility();
        this.x = r10.getAttributes().flags;
        this.y = r10.getStatusBarColor();
        FragmentActivity r11 = this.a;
        View r12 = this.d;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.ViewGroup");
        this.m = new com.bytedance.android.anniex.container.ui.h(r11, this, (ViewGroup) r12);
        initUi();
        ab.b r13 = s();
        if (r13 == null) goto L21;
        com.bytedance.android.anniex.container.ui.h r14 = this.m;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r14 = null;
    L13:
        Dialog r15 = this.e;
        if (r15 == null) goto L16;
        Window r16 = r15.getWindow();
    L17:
        r14.c(r16, r13);
        com.bytedance.android.anniex.container.ui.h r17 = this.m;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r17 = null;
    L20:
        r17.b(r13, getBid());
        goto L21
    L16:
        r16 = null;
    L21:
        ab.a r18 = r();
        if (r18 == null) goto L31;
        y36.a r19 = r18.k;
        if (r19 == null) goto L28;
        Boolean r20 = (Boolean) ((y36.i) r19).b;
        if (r20 == null) goto L28;
        boolean r22 = r20.booleanValue();
    L29:
        if (r22 != true) goto L31;
        boolean r23 = true;
    L32:
        if (r23 == false) goto L36;
        View r24 = this.d;
        if (r24 == null) goto L39;
        View r25 = (ImageView) r24.findViewById(2131362988);
    L40:
        this.p = r25;
        ab.a r26 = r();
        if (r26 != null) goto L43;
    L45:
        boolean r27 = false;
    L46:
        if (r27 == false) goto L61;
        ab.b r28 = s();
        if (r28 == null) goto L55;
        y36.i r29 = r28.g;
        if (r29 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("showClosealways");
        r29 = null;
    L53:
        if (r29 == null) goto L55;
        boolean r30 = Intrinsics.areEqual(r29.b, Boolean.TRUE);
    L56:
        if (r30 == true) goto L61;
        View r31 = this.p;
        if (r31 == null) goto L61;
        r31.setAlpha(0.0f);
    L55:
        r30 = false;
    L61:
        ab.b r32 = s();
        if (r32 == null) goto L78;
        y36.a r33 = r32.b();
        if (r33 == null) goto L78;
        Boolean r34 = (Boolean) ((y36.i) r33).b;
        if (r34 == null) goto L78;
        if (r34.booleanValue() == true) goto L71;
        r34 = null;
    L71:
        if (r34 == null) goto L78;
        r34.booleanValue();
        View r35 = this.p;
        if (r35 == null) goto L76;
        r35.setVisibility(0);
    L76:
        if (r35 == null) goto L78;
        r35.setOnClickListener(new g(this));
    L78:
        ab.a r36 = r();
        if (r36 != null) goto L81;
    L86:
        boolean r37 = true;
    L87:
        if (r37 == true) goto L101;
        ab.a r38 = r();
        if (r38 != null) goto L91;
    L93:
        boolean r39 = false;
    L94:
        if (r39 == false) goto L101;
        DialogFragment r40 = this.c;
        if (r40 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r40 = null;
    L98:
        r40.setCancelable(true);
        Dialog r41 = this.e;
        if (r41 == null) goto L104;
        r41.setCanceledOnTouchOutside(true);
    L104:
        ab.a r42 = r();
        if (r42 == null) goto L107;
        r42.e();
    L107:
        Resources r43 = getContext().getResources();
        int r44 = WindowDisplayMetricsOverride.apply(r43, r43.getDisplayMetrics()).widthPixels;
        com.bytedance.android.anniex.container.util.i r45 = com.bytedance.android.anniex.container.util.i.a;
        int r46 = com.bytedance.android.anniex.container.util.i.c(this.a).heightPixels;
        i16.c r47 = i16.c.a;
        int r48 = r46 - r47.h(this.a);
        boolean r49 = v();
        if (r49 == true) goto L111;
        r46 = r48;
    L111:
        HybridLogger r50 = HybridLogger.a;
        HybridLogger.m("AnnieXFlowPopupContainer", "screenHeight: " + r46 + "; screenWidth: " + r44, null, null, 12);
        ab.a r51 = r();
        if (r51 != null) goto L114;
    L145:
        Window r52 = this.a.getWindow();
        if (r52 == null) goto L148;
        this.f = r52.getStatusBarColor();
    L148:
        ab.a r53 = r();
        if (r53 == null) goto L274;
        int r54 = r53.A();
        com.bytedance.android.anniex.container.util.i r55 = com.bytedance.android.anniex.container.util.i.a;
        r53.G(RangesKt.coerceAtMost(r54, (int) r55.e(r44)));
        if (r53.v() <= 0) goto L154;
        if (r49 == true) goto L154;
        r53.E((int) r55.e((int) (((double) (r53.v() * r44)) / 375.0d)));
        HybridLogger.m("AnnieXFlowPopupContainer", "rateHeight: " + r53.v() + "; screenWidth: " + r44 + " ; this.height1: " + r53.e(), null, null, 12);
    L154:
        if (r49 == true) goto L156;
    L158:
        if (r49 == false) goto L165;
        y36.a r56 = r53.r;
        if (r56 == null) goto L162;
        boolean r57 = Intrinsics.areEqual(((y36.i) r56).b, Boolean.TRUE);
    L163:
        if (r57 == false) goto L165;
    L170:
        if ((r53.e() + r53.l()) < ((int) r55.e(r46))) goto L173;
        r53.E(r53.e() - r53.l());
    L173:
        if (r53.f() <= 0) goto L176;
        if (r49 == true) goto L176;
        r53.E((int) r55.e((int) (r46 * (r53.f() / 100.0f))));
    L176:
        if (r49 == true) goto L181;
        if (r53.e() <= r46) goto L181;
        r53.E((int) r55.e(r46));
    L181:
        if (u() == false) goto L184;
        r53.E((int) r55.e(com.bytedance.android.anniex.container.util.i.c(this.a).heightPixels - r47.h(this.a)));
    L184:
        if (r53.B() <= 0) goto L187;
        if (r49 == true) goto L187;
        r53.G((int) r55.e((int) (r44 * (r53.B() / 100.0f))));
    L187:
        y36.a r58 = r53.s;
        if (r58 == null) goto L190;
        boolean r59 = Intrinsics.areEqual(((y36.i) r58).b, Boolean.TRUE);
    L191:
        if (r59 == false) goto L195;
        if (r49 == false) goto L195;
        r53.G((int) r55.e(r53.k() + r46));
    L195:
        if (r53.e() > 0) goto L198;
        r53.E(450);
    L198:
        if (r53.A() > 0) goto L200;
        r53.G(FontWeight.WEIGHT_300);
    L200:
        y36.a r60 = r53.R;
        if (r60 == null) goto L203;
        boolean r61 = Intrinsics.areEqual(((y36.i) r60).b, Boolean.TRUE);
    L204:
        if (r61 == false) goto L207;
        r53.E(r53.e() + 48);
    L207:
        if (r53.w() == false) goto L229;
        int r62 = r47.h(getContext());
        if (r53.z() == false) goto L211;
        int r63 = com.bytedance.android.anniex.container.util.i.c(this.a).heightPixels - r62;
    L212:
        r53.E(((int) r55.e(r63)) + 2);
        if (r53.x() <= 0) goto L222;
        float r64 = 1 - RangesKt.coerceAtMost(r53.x() / 100.0f, 1.0f);
        if (r53.z() == false) goto L217;
        r63 = r63 + r62;
    L217:
        float r65 = r63 * r64;
        if (r53.z() == false) goto L220;
        int r66 = r62 + 2;
    L221:
        r53.O = new y36.d(Integer.valueOf((int) r55.e((int) (r65 - r66))));
        goto L222
    L220:
        r66 = 0;
    L222:
        r r67 = r53.P;
        if (r67 == null) goto L227;
        Integer r68 = (Integer) ((y36.i) r67).b;
        if (r68 == null) goto L227;
        int r69 = r68.intValue();
    L228:
        this.g = r69;
    L227:
        r69 = 1580077;
        goto L228
    L211:
        r63 = r55.d();
    L229:
        y36.a r70 = r53.S;
        if (r70 == null) goto L232;
        boolean r71 = Intrinsics.areEqual(((y36.i) r70).b, Boolean.TRUE);
    L233:
        if (r71 == false) goto L243;
        if (v() == true) goto L243;
        ia.f.a r72 = this.b;
        if (r72 != null) goto L239;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r72 = null;
    L239:
        Integer r73 = r72.f(MapsKt.emptyMap());
        if (r73 == null) goto L243;
        r53.E((int) (((double) r55.e(r73.intValue())) + 0.5d));
        r53.F = new y36.d(0);
        r53.G = new y36.d(0);
    L243:
        if (r53.q() >= 0) goto L246;
        r53.F(0);
    L246:
        if (r53.t() >= 0) goto L249;
        r53.F = new y36.d(0);
    L249:
        if (r53.u() >= 0) goto L252;
        r53.G = new y36.d(0);
    L252:
        if (r53.s() >= 0) goto L255;
        r53.I = new y36.d(0);
    L255:
        if (r53.r() >= 0) goto L257;
        r53.H = new y36.d(0);
    L257:
        if (r49 == false) goto L274;
        float r74 = RangesKt.coerceAtMost(r53.h(), 100) / 100.0f;
        float r75 = 0;
        if (r74 <= r75) goto L261;
        r53.E((int) r55.e((int) (r46 * r74)));
    L261:
        y36.j r76 = r53.p;
        if (r76 == null) goto L266;
        Integer r77 = (Integer) ((y36.i) r76).b;
        if (r77 == null) goto L266;
        int r78 = r77.intValue();
    L267:
        float r79 = RangesKt.coerceAtMost(r78, 100) / 100.0f;
        if (r79 <= r75) goto L271;
        r53.G((int) r55.e((int) (r44 * r79)));
    L271:
        if (r53.i() <= 0) goto L274;
        r53.F(r53.i());
    L266:
        r78 = 0;
        goto L267
    L232:
        r71 = false;
        goto L233
    L203:
        r61 = false;
        goto L204
    L190:
        r59 = false;
        goto L191
    L162:
        r57 = false;
    L165:
        if (r53.d() != 80) goto L170;
        int r80 = (int) (r46 * 0.85f);
        if (r53.e() <= r55.e(r80)) goto L170;
        r53.E((int) r55.e(r80));
        HybridLogger.m("AnnieXFlowPopupContainer", "screenHeight: " + r46 + "; screenWidth: " + r44 + " ; this.height2: " + r53.e(), null, null, 12);
        goto L170
    L156:
        if (r53.e() <= r46) goto L158;
        r53.E((int) r55.e(r46 - (r53.k() * 2)));
    L274:
        if (r() == null) goto L291;
        ab.a r81 = r();
        if (r81 == null) goto L291;
        Object r82 = this.e;
        if ((r82 instanceof SheetBaseDialog) == false) goto L280;
        ?? r83 = (SheetBaseDialog) r82;
    L281:
        if (r83 == 0) goto L291;
        boolean r84 = r81.w();
        int r85 = r81.e();
        y36.d r86 = r81.O;
        if (r86 == null) goto L287;
        Integer r87 = (Integer) ((y36.i) r86).b;
        if (r87 == null) goto L287;
        int r88 = r87.intValue();
    L288:
        r83.p = r84;
        if (r88 <= 0) goto L291;
        r83.q = i16.c.f(r85 - r88, r83.getContext());
    L287:
        r88 = 0;
        goto L288
    L280:
        r83 = 0;
    L291:
        Dialog r89 = this.e;
        if (r89 == null) goto L296;
        Window r90 = r89.getWindow();
        if (r90 == null) goto L296;
        r90.addFlags(Integer.MIN_VALUE);
        r90.setStatusBarColor(0);
        r90.setNavigationBarColor(0);
    L296:
        HybridLogger.m("AnnieXFlowPopupContainer", "===onCreateView: " + getUrl(), null, null, 12);
        return;
    L114:
        if (v() == false) goto L143;
        y36.a r91 = r51.r;
        if (r91 == null) goto L118;
        boolean r92 = Intrinsics.areEqual(((y36.i) r91).b, Boolean.TRUE);
    L119:
        if (r92 == true) goto L121;
        r51.F(8);
        r51.E((int) com.bytedance.android.anniex.container.util.i.a.e(r46 - (r51.k() * 2)));
        r51.G(FontWeight.WEIGHT_300);
    L121:
        y36.a r93 = r51.q;
        if (r93 == null) goto L124;
        boolean r94 = Intrinsics.areEqual(((y36.i) r93).b, Boolean.FALSE);
    L125:
        if (r94 == false) goto L128;
        r51.h = 8388613;
    L131:
        if (r51.j() <= 0) goto L134;
        r51.G(r51.j());
    L134:
        if (r51.g() <= 0) goto L137;
        r51.E(r51.g());
    L137:
        if (r51.h() <= 0) goto L139;
        r51.E((int) com.bytedance.android.anniex.container.util.i.a.e((com.bytedance.android.anniex.container.util.i.c(this.a).heightPixels * r51.h()) / 100));
    L139:
        r51.M = new y36.a(Boolean.FALSE);
        if (i16.c.d(getContext()) == false) goto L145;
        r51.W = new y36.d(Integer.valueOf(r47.h(getContext())));
        goto L145
    L128:
        if (r51.d() != 80) goto L131;
        r51.h = 8388693;
        goto L131
    L124:
        r94 = false;
        goto L125
    L118:
        r92 = false;
        goto L119
    L143:
        if (i16.c.d(getContext()) == false) goto L145;
        r51.X = new y36.d(Integer.valueOf(r47.h(getContext())));
        goto L145
    L91:
        if (r38.c() != true) goto L93;
        r39 = true;
    L101:
        Dialog r95 = this.e;
        if (r95 == null) goto L104;
        r95.hide();
        goto L104
    L81:
        if (r36.A() == 0) goto L83;
    L85:
        r37 = false;
        goto L87
    L83:
        if (r36.e() != 0) goto L85;
    L43:
        if (r26.w() != true) goto L45;
        r27 = true;
    L39:
        r25 = null;
        goto L40
    L36:
        View r96 = this.d;
        if (r96 == null) goto L39;
        r25 = r96.findViewById(2131362989);
    L28:
        r22 = true;
    L31:
        r23 = false;
        goto L32
    L5:
        r1 = null;
        goto L6
    }

    @Override // ia.g
    public final boolean c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusBarBgColor");
        com.bytedance.android.anniex.container.ui.h r0 = this.m;
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
        com.bytedance.android.anniex.container.ui.h r0 = this.m;
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
        com.bytedance.android.anniex.container.ui.h r11 = this.m;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
    L8:
        r0.l();
        return;
    L7:
        r0 = r11;
        goto L8
    L9:
        com.bytedance.android.anniex.container.ui.h r12 = this.m;
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
    public final Dialog h(Bundle r14) {
        ab.a r0 = r();
        if (r0 == null) goto L7;
        y36.a r1 = r0.c;
        if (r1 == null) goto L7;
        boolean r10 = Intrinsics.areEqual(((y36.i) r1).b, Boolean.TRUE);
    L8:
        DialogFragment r11 = null;
        boolean r12 = true;
        if (r10 == false) goto L19;
        ia.f.a r13 = this.b;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r13 = null;
    L13:
        AppCompatDialog r15 = r13.g(r14);
        if (r15 == null) goto L18;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L27;
        r16.setBackgroundDrawable(new ColorDrawable(0));
        r16.addFlags(256);
    L27:
        this.e = r15;
        ab.a r17 = r();
        if (r17 == null) goto L30;
        r12 = r17.c();
    L30:
        DialogFragment r18 = this.c;
        if (r18 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L34:
        r11.setCancelable(r12);
        Dialog r19 = this.e;
        if (r19 == null) goto L37;
        r19.setCanceledOnTouchOutside(r12);
    L37:
        Dialog r110 = this.e;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.app.Dialog");
        return r110;
    L33:
        r11 = r18;
        goto L34
    L18:
        r15 = null;
        goto L27
    L19:
        Context r20 = getContext();
        boolean r21 = v();
        boolean r22 = v();
        if (u() == false) goto L23;
        if (r22 == true) goto L23;
        boolean r111 = true;
    L24:
        r15 = new SheetBaseDialog(r20, r21, false, r111, false, 0);
        Window r23 = r15.getWindow();
        if (r23 == null) goto L27;
        r23.setBackgroundDrawable(new ColorDrawable(0));
        r23.addFlags(256);
    L23:
        r111 = r22;
    L7:
        r10 = false;
        goto L8
    }

    @Override // ia.f
    public final void m(boolean r1) {
        this.h = r1;
    }

    @Override // ia.f
    public final void o(DialogFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "dialogFragment");
        this.c = r10;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.e
    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        HybridLogger r11 = HybridLogger.a;
        HybridLogger.m("AnnieXFlowPopupContainer", "===onConfigurationChanged: " + getUrl(), null, null, 12);
        ab.a r12 = r();
        if (r12 == null) goto L6;
        A(this.e, r12.A(), r12.e(), r12.d());
        return;
    }

    @Override // ia.b, ia.c
    public final void onCreate(Bundle r10) {
        HybridLogger r11 = HybridLogger.a;
        DialogFragment r12 = null;
        HybridLogger.m("AnnieXFlowPopupContainer", "onCreate: " + getUrl(), null, null, 12);
        com.bytedance.android.anniex.container.b r13 = getLifecycleDispatcher();
        b r0 = this.s;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, "lifecycle");
        r13.a.add(r0);
        setContainerVisible(true);
        if (v() == false) goto L9;
        DialogFragment r1 = this.c;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L8:
        r12.setStyle(1, 2131954095);
        return;
    L7:
        r12 = r1;
        goto L8
    L9:
        DialogFragment r14 = this.c;
        if (r14 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L13:
        r12.setStyle(1, 2131954089);
        return;
    L12:
        r12 = r14;
        goto L13
    }

    @Override // ia.f
    public final void onDismiss(DialogInterface r10) {
        HybridLogger r11 = HybridLogger.a;
        y36.i r12 = null;
        HybridLogger.m("AnnieXFlowPopupContainer", "===onDismiss: " + getUrl(), null, null, 12);
        ab.b r13 = s();
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
        ab.b r16 = s();
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
        int r19 = this.f;
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
        q(r20).setSystemUiVisibility(this.w);
        r20.addFlags(this.x);
        r20.setStatusBarColor(this.y);
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
        HybridLogger.m("AnnieXFlowPopupContainer", "===onShow: " + getUrl(), null, null, 12);
        if (v() == false) goto L10;
        Dialog r12 = this.e;
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
        com.bytedance.android.anniex.container.ui.h r0 = this.m;
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
        com.bytedance.android.anniex.container.ui.h r0 = this.m;
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
        com.bytedance.android.anniex.container.ui.h r0 = this.m;
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

    public final void w(int r10) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, r10);     // Catch: JSONException -> L4
        sendEvent(new c(r0));     // Catch: JSONException -> L4
        return;
    }

    @Override // ia.e
    public final void b(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        HybridLogger r15 = HybridLogger.a;
        Integer r1 = null;
        HybridLogger.m("AnnieXFlowPopupContainer", "===onViewCreated: " + getUrl(), null, null, 12);
        Object r16 = this.e;
        if ((r16 instanceof SheetBaseDialog) == false) goto L5;
        SheetBaseDialog r17 = (SheetBaseDialog) r16;
    L6:
        if (r17 == null) goto L8;
        r17.o = new com.bytedance.android.anniex.lite.container.a(this);
    L8:
        View r18 = this.d;
        if (r18 == null) goto L11;
        r18.setOnClickListener(new com.bytedance.android.anniex.lite.container.b(this));
    L11:
        Object r19 = this.e;
        if ((r19 instanceof SheetBaseDialog) == false) goto L14;
        SheetBaseDialog r110 = (SheetBaseDialog) r19;
    L15:
        if (r110 == null) goto L19;
        com.bytedance.android.anniex.lite.container.c r10 = new com.bytedance.android.anniex.lite.container.c(this);
        Intrinsics.checkNotNullParameter(r10, "bottomSheetPullUpProcessor");
        r110.n = new com.bytedance.android.anniex.container.popup.a(r10, r110);
        SheetBaseBehavior<?> r11 = r110.f;
        if (r11 == null) goto L19;
        Intrinsics.checkNotNull(r11);
        r11.e = r110.n;
    L19:
        ab.a r111 = r();
        boolean r12 = true;
        if (r111 != null) goto L22;
    L24:
        boolean r112 = false;
    L25:
        if (r112 == false) goto L27;
        w(1);
    L27:
        Object r113 = this.e;
        if ((r113 instanceof SheetBaseDialog) == false) goto L30;
        SheetBaseDialog r114 = (SheetBaseDialog) r113;
    L31:
        if (r114 == null) goto L35;
        d r20 = new d(this);
        Intrinsics.checkNotNullParameter(r20, "bottomSheetSlideProcessor");
        r114.m = new com.bytedance.android.anniex.container.popup.b(r20, r114);
        SheetBaseBehavior<?> r21 = r114.f;
        if (r21 == null) goto L35;
        Intrinsics.checkNotNull(r21);
        r21.d = r114.m;
    L35:
        Object r115 = this.e;
        if ((r115 instanceof SheetBaseDialog) == false) goto L38;
        SheetBaseDialog r116 = (SheetBaseDialog) r115;
    L39:
        if (r116 == null) goto L43;
        e r22 = new e(this);
        if (r116.l.contains(r22) == true) goto L43;
        r116.l.add(r22);
    L43:
        ab.a r117 = r();
        if (r117 == null) goto L48;
        y36.a r118 = r117.R;
        if (r118 == null) goto L48;
        boolean r119 = Intrinsics.areEqual(((y36.i) r118).b, Boolean.TRUE);
    L49:
        if (r119 == false) goto L55;
        View r120 = this.d;
        if (r120 == null) goto L55;
        ImageView r121 = (ImageView) r120.findViewById(2131363002);
        if (r121 == null) goto L55;
        r121.setVisibility(0);
        r121.setOnClickListener(new f(this));
    L55:
        Dialog r122 = this.e;
        if (r122 == null) goto L58;
        Window r123 = r122.getWindow();
    L59:
        ab.a r23 = r();
        if (r23 == null) goto L158;
        A(this.e, r23.A(), r23.e(), r23.d());
        if (r23.q() <= 0) goto L68;
        float r24 = com.bytedance.android.anniex.container.util.i.a.a(r23.q());
        View r25 = this.d;
        if (r25 == null) goto L73;
        RadiusFrameLayout r26 = (RadiusFrameLayout) r25.findViewById(2131363000);
        if (r26 == null) goto L73;
        r26.setRadius(r24);
    L73:
        if (r123 == null) goto L158;
        y36.a r27 = r23.Y;
        if (r27 == null) goto L79;
        Boolean r28 = (Boolean) ((y36.i) r27).b;
        if (r28 == null) goto L79;
        boolean r29 = r28.booleanValue();
    L80:
        if (r29 == true) goto L82;
        r123.setSoftInputMode(48);
    L82:
        WindowManager.LayoutParams r30 = r123.getAttributes();
        r30.width = -1;
        r30.height = -1;
        y36.a r31 = r23.y;
        if (r31 == null) goto L85;
        boolean r32 = Intrinsics.areEqual(((y36.i) r31).b, Boolean.TRUE);
    L86:
        if (r32 == true) goto L88;
        r30.windowAnimations = 2131954098;
    L202:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L101
        r123.setAttributes(r30);     // Catch: Throwable -> L101
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L104:
        if (x() == false) goto L106;
        y();
    L204:
        r r34 = r23.x;     // Catch: Exception -> L131
        if (r34 == null) goto L128;
        Integer r35 = (Integer) ((y36.i) r34).b;     // Catch: Exception -> L131
        if (r35 == null) goto L128;
        int r36 = r35.intValue();     // Catch: Exception -> L131
    L129:
        r123.setBackgroundDrawable(new ColorDrawable(r36));     // Catch: Exception -> L131
    L134:
        if (r23.A() <= 0) goto L136;
        int r0 = com.bytedance.android.anniex.container.util.i.a.a(r23.A() + r23.m());
    L137:
        r123.setLayout(r0, -1);
        if (u() == true) goto L140;
        r123.setFlags(1024, 1024);
    L140:
        ab.a r37 = r();
        if (r37 != null) goto L143;
    L148:
        if (r12 == false) goto L151;
        r123.addFlags(32);
        r123.getAttributes().dimAmount = 0.0f;
    L151:
        if (r23.w() == false) goto L158;
        Object r124 = this.e;
        j r38 = new j(this);
        if ((r124 instanceof SheetBaseDialog) == false) goto L155;
        SheetBaseDialog r125 = (SheetBaseDialog) r124;
    L156:
        if (r125 == null) goto L158;
        r125.k = r38;
        goto L158
    L155:
        r125 = null;
        goto L156
    L143:
        if (r37.A() == 0) goto L145;
    L147:
        r12 = false;
        goto L148
    L145:
        if (r37.e() != 0) goto L147;
    L136:
        r0 = r23.A();
    L128:
        r36 = ColorProtector.parseColor("#00FFFFFF");     // Catch: Exception -> L131
    L131:
        e = move-exception;
        HybridLogger r39 = HybridLogger.a;
        HybridLogger.i("AnnieXFlowPopupContainer", "maskBgColor: " + e.getMessage(), null, 12);
        goto L134
    L106:
        ab.a r40 = r();
        if (r40 == null) goto L120;
        y36.a r41 = r40.K;
        if (r41 == null) goto L111;
        boolean r42 = Intrinsics.areEqual(((y36.i) r41).b, Boolean.TRUE);
    L112:
        if (r42 == true) goto L119;
        y36.a r43 = r40.L;
        if (r43 == null) goto L116;
        boolean r44 = Intrinsics.areEqual(((y36.i) r43).b, Boolean.TRUE);
    L117:
        if (r44 == true) goto L119;
    L116:
        r44 = false;
    L119:
        boolean r45 = false;
    L121:
        if (r45 == false) goto L204;
        t();
        goto L204
    L111:
        r42 = false;
    L120:
        r45 = true;
    L101:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L104
    L88:
        if (com.bytedance.android.anniex.container.util.i.a.getResources().getConfiguration().orientation != 2) goto L90;
        r30.windowAnimations = 2131954096;
        goto L202
    L90:
        y36.l r47 = r23.z;
        if (r47 == null) goto L93;
        PopupType r48 = (PopupType) ((y36.i) r47).b;
    L95:
        if (r48 != PopupType.RIGHT) goto L97;
        r30.windowAnimations = 2131954096;
        goto L202
    L97:
        r30.windowAnimations = 2131954097;
        goto L202
    L93:
        r48 = null;
        goto L95
    L85:
        r32 = false;
    L79:
        r29 = true;
        goto L80
    L68:
        com.bytedance.android.anniex.container.util.i r49 = com.bytedance.android.anniex.container.util.i.a;
        float r50 = r49.a(r23.t());
        float r51 = r49.a(r23.u());
        float r126 = r49.a(r23.s());
        float r52 = r49.a(r23.r());
        View r127 = this.d;
        if (r127 == null) goto L73;
        RadiusFrameLayout r53 = (RadiusFrameLayout) r127.findViewById(2131363000);
        if (r53 == null) goto L73;
        r53.a(r50, r51, r126, r52);
    L158:
        ab.a r128 = r();
        if (r128 != null) goto L161;
    L195:
        FrameLayout r129 = this.r;
        if (r129 == null) goto L200;
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
        if (r130 == null) goto L200;
        r1 = Integer.valueOf(r130.height);
    L200:
        this.n = r1;
        return;
    L161:
        if (r128.o() == false) goto L163;
    L164:
        y36.a r54 = r128.D;
        if (r54 == null) goto L169;
        Boolean r55 = (Boolean) ((y36.i) r54).b;
        if (r55 == null) goto L169;
        boolean r56 = r55.booleanValue();
    L170:
        if (r56 == true) goto L195;
        if (com.bytedance.android.anniex.container.util.h.a(this.a) == true) goto L195;
        View r57 = r13.findViewById(2131363008);
        y36.p r131 = r128.B;
        if (r131 == null) goto L177;
        String r132 = (String) ((y36.i) r131).b;
        if (r132 == null) goto L177;
    L178:
        this.o = r13.findViewById(2131363007);
        if (r57 == null) goto L183;
        r57.setVisibility(0);
    L183:
        if (Intrinsics.areEqual(IHostContextDepend.SKIN_TYPE_WHITE, r132) == false) goto L188;
        View r133 = this.o;
        if (r133 == null) goto L195;
        r133.setBackgroundResource(2131231352);
        goto L195
    L188:
        if (Intrinsics.areEqual("dark", r132) == false) goto L192;
        View r134 = this.o;
        if (r134 == null) goto L195;
        r134.setBackgroundResource(2131231351);
        goto L195
    L192:
        View r135 = this.o;
        if (r135 == null) goto L195;
        r135.setBackgroundResource(2131231352);
    L177:
        r132 = "";
    L169:
        r56 = false;
        goto L170
    L163:
        if (r128.w() == false) goto L195;
    L58:
        r123 = null;
    L48:
        r119 = false;
        goto L49
    L38:
        r116 = null;
        goto L39
    L30:
        r114 = null;
        goto L31
    L22:
        if (r111.w() != true) goto L24;
        r112 = true;
        goto L25
    L14:
        r110 = null;
        goto L15
    L5:
        r17 = null;
        goto L6
    }

    public final void A(Dialog r10, int r11, int r12, int r13) {
        if (r10 == null) goto L29;
        Window r14 = r10.getWindow();
        if (r14 == null) goto L29;
        if (r() == null) goto L29;
        WindowManager.LayoutParams r15 = r14.getAttributes();
        r15.gravity = r13;
        if (r11 <= 0) goto L12;
        r15.width = com.bytedance.android.anniex.container.util.i.a.a(r11);
    L12:
        ab.a r16 = r();
        if (r16 != null) goto L15;
    L115:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L27
        r14.setAttributes(r15);     // Catch: Throwable -> L27
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L15:
        if (r16.C() <= 0) goto L18;
        r15.x = r16.C();
    L18:
        if (r16.D() <= 0) goto L21;
        r15.y = r16.D();
    L21:
        if (r16.B() <= 0) goto L115;
        if (com.bytedance.android.anniex.container.util.i.a.getResources().getConfiguration().orientation == 2) goto L115;
        float r19 = r16.B() / 100.0f;
        i16.c r20 = i16.c.a;
        r15.width = (int) (i16.c.j(this.a) * r19);
    L29:
        View r21 = this.d;
        ViewGroup.LayoutParams r22 = null;
        if (r21 == null) goto L32;
        FrameLayout r23 = (FrameLayout) r21.findViewById(2131363003);
    L33:
        this.r = r23;
        if (r23 == null) goto L36;
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
    L37:
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r25 = (RelativeLayout.LayoutParams) r24;
        if (r11 <= 0) goto L40;
        r11 = com.bytedance.android.anniex.container.util.i.a.a(r11);
    L40:
        r25.width = r11;
        if (r12 <= 0) goto L43;
        r12 = com.bytedance.android.anniex.container.util.i.a.a(r12);
    L43:
        r25.height = r12;
        ab.a r26 = r();
        boolean r110 = true;
        if (r26 == null) goto L70;
        com.bytedance.android.anniex.container.util.i r27 = com.bytedance.android.anniex.container.util.i.a;
        if (r27.getResources().getConfiguration().orientation == 2) goto L64;
        if (u() == false) goto L51;
        r25.height = com.bytedance.android.anniex.container.util.i.c(this.a).heightPixels - i16.c.a.h(this.a);
        goto L64
    L51:
        if (r26.z() == true) goto L61;
        if (r26.f() <= 0) goto L64;
        y36.a r1 = r26.S;
        if (r1 == null) goto L57;
        boolean r28 = Intrinsics.areEqual(((y36.i) r1).b, Boolean.TRUE);
    L58:
        if (r28 == true) goto L64;
        r25.height = (int) (r27.d() * RangesKt.coerceAtMost(r26.f() / 100.0f, 1.0f));
        goto L64
    L57:
        r28 = false;
        goto L58
    L61:
        if (r26.f() <= 0) goto L64;
        r25.height = (int) (com.bytedance.android.anniex.container.util.i.c(getContext()).heightPixels * RangesKt.coerceAtMost(r26.f() / 100.0f, 1.0f));
    L64:
        if (r26.l() <= 0) goto L67;
        r25.bottomMargin = r27.a(r26.l() * 1.0f);
    L67:
        if (r26.m() <= 0) goto L70;
        r25.rightMargin = r27.a(r26.m() * 1.0f);
    L70:
        if (r13 != 0) goto L72;
    L83:
        r25.addRule(13);
    L84:
        FrameLayout r111 = this.r;
        if (r111 == null) goto L88;
        r111.setLayoutParams(r25);
    L88:
        int r29 = r25.height;
        if (com.bytedance.ies.bullet.service.base.h.x() == false) goto L111;
        ab.a r112 = r();
        if (r112 != null) goto L93;
    L95:
        boolean r30 = false;
    L96:
        if (r30 == false) goto L111;
        ab.a r31 = r();
        if (r31 != null) goto L100;
    L102:
        r110 = false;
    L103:
        if (r110 == false) goto L111;
        View r32 = this.d;
        if (r32 == null) goto L107;
        View r33 = r32.findViewById(2131363000);
    L108:
        if (r33 == null) goto L110;
        r22 = r33.getLayoutParams();
    L110:
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r34 = (FrameLayout.LayoutParams) r22;
        r34.height = r29;
        r33.setLayoutParams(r34);
        goto L111
    L107:
        r33 = null;
        goto L108
    L100:
        if (r31.w() == true) goto L102;
    L93:
        if (r112.d() != 80) goto L95;
        r30 = true;
    L111:
        FrameLayout r35 = this.r;
        if (r35 == null) goto L117;
        r35.requestLayout();
        return;
    L117:
        return;
    L72:
        if ((r13 & 17) == 17) goto L83;
        if ((r13 & 80) != 80) goto L78;
        r25.addRule(12);
        r25.addRule(11);
        goto L84
    L78:
        if ((r13 & 5) != 5) goto L81;
        r25.addRule(11);
        goto L84
    L81:
        if ((r13 & 8388613) != 8388613) goto L84;
        r25.addRule(21);
        goto L84
    L36:
        r24 = null;
        goto L37
    L32:
        r23 = null;
        goto L33
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final void onWebScrollChanged(int r1, int r10, int r11, int r12) {
        super.onWebScrollChanged(r1, r10, r11, r12);
        this.u = r10;
        boolean r13 = true;
        if (r10 <= 0) goto L16;
        ab.a r14 = r();
        if (r14 != null) goto L7;
    L9:
        boolean r15 = false;
    L10:
        if (r15 == false) goto L16;
        if (this.q != 3) goto L14;
    L15:
        f(true);
        return;
    L14:
        if (u() == true) goto L15;
        return;
    L7:
        if (r14.b() != true) goto L9;
        r15 = true;
    L16:
        if (r10 != 0) goto L28;
        ab.a r16 = r();
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
}
