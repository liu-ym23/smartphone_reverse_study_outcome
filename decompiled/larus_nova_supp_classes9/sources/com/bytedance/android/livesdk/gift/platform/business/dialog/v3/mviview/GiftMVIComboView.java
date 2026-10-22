package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.GiftComboView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnComboSingleClickStart;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboBottomAnimationView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIComboView extends BaseGiftMVIViewChildNode<GiftVerticalState, GiftComboState, GiftAction> {
    public ComboBottomAnimationView m;
    public final GiftComboView n;
    public final Lazy o;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131565236;
    }

    public final void g() {
        this.m = (ComboBottomAnimationView) r().findViewById(2131367232);
    }

    public final void i() {
        View r0 = r();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L9;
        r1.removeAllViews();
        return;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftVerticalState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIComboView$bindToParent$1 r0 = GiftMVIComboView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVIComboView(final Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "containerView");
        super(r4, r5);
        View r2 = null;
        GiftComboView r6 = new GiftComboView(r4, null, 0, 6);
        View r0 = r();
        if ((r0 instanceof ViewGroup) == false) goto L6;
        r2 = r0;
    L6:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L9;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.rightMargin = UtilityKotlinExtentionsKt.i(-35);
        r1.bottomMargin = UtilityKotlinExtentionsKt.i(-95);
        Unit r7 = Unit.INSTANCE;
        r3.addView(r6, r1);
    L9:
        Unit r8 = Unit.INSTANCE;
        this.n = r6;
        this.o = LazyKt.lazy(LazyThreadSafetyMode.NONE, new GiftMVIComboView$groupHintView$2(this, r4));
    }

    public final void b(com.bytedance.android.anya.k r10, MVIState r11) {
        GiftComboState r13 = (GiftComboState) r11;
        Intrinsics.checkNotNullParameter(r10, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r13, "state");
        com.bytedance.android.anya.r0<GiftComboState, Integer> r0 = r13.getComboNum();
        Object r1 = r10.c.a(r0);
        if (r1 == null) goto L12;
        r10.b.a.invoke(r0);
        int r2 = ((Number) r1).intValue();
        yz0.k r3 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r3 != null) goto L7;
    L11:
        UtilityKotlinExtentionsKt.w(this.n);
        this.n.setComboCount(r2);
        this.n.c(new b(this), 0, 0);
        goto L12
    L7:
        if (r3.isPortraitInteraction() != true) goto L11;
        ComboBottomAnimationView r4 = this.m;
        if (r4 == null) goto L11;
        r4.b(r2);
    L12:
        com.bytedance.android.anya.r0<GiftComboState, Integer> r5 = r13.getPositionX();
        Object r6 = r10.c.a(r5);
        if (r6 == null) goto L20;
        r10.b.a.invoke(r5);
        int r7 = ((Number) r6).intValue();
        int[] r8 = new int[2];
        this.l.getLocationInWindow(r8);
        int r9 = r8[0] + UtilityKotlinExtentionsKt.i(35);
        ViewGroup.LayoutParams r14 = this.n.getLayoutParams();
        if ((r14 instanceof FrameLayout.LayoutParams) == false) goto L20;
        if (com.bytedance.android.livesdk.gift.util.c.c() == false) goto L19;
        int[] r15 = new int[2];
        this.l.getLocationInWindow(r15);
        ((FrameLayout.LayoutParams) r14).leftMargin = ((int) ((r7 - r15[0]) / nz1.a.q().c())) - UtilityKotlinExtentionsKt.i(35);
        goto L20
    L19:
        ((FrameLayout.LayoutParams) r14).leftMargin = r7 - r9;
    L20:
        com.bytedance.android.anya.r0<GiftComboState, Integer> r16 = r13.getPositionY();
        Object r17 = r10.c.a(r16);
        if (r17 == null) goto L36;
        r10.b.a.invoke(r16);
        int r18 = ((Number) r17).intValue();
        if (b02.a.e() == false) goto L25;
        int[] r19 = new int[2];
        this.l.getLocationInWindow(r19);
        int r20 = r19[1];
        int r21 = UtilityKotlinExtentionsKt.i(95);
    L26:
        int r23 = r20 + r21;
        ViewGroup.LayoutParams r24 = this.n.getLayoutParams();
        if ((r24 instanceof FrameLayout.LayoutParams) == false) goto L36;
        if (com.bytedance.android.livesdk.gift.util.c.c() == true) goto L31;
        ((FrameLayout.LayoutParams) r24).topMargin = r18 - r23;
        goto L36
    L31:
        if (b02.a.e() == false) goto L33;
        int r25 = UtilityKotlinExtentionsKt.i(95);
    L34:
        int[] r26 = new int[2];
        this.l.getLocationInWindow(r26);
        ((FrameLayout.LayoutParams) r24).topMargin = ((int) ((r18 - r26[1]) / nz1.a.q().c())) - r25;
        goto L36
    L33:
        r25 = UtilityKotlinExtentionsKt.i(75);
        goto L34
    L25:
        int[] r27 = new int[2];
        this.l.getLocationInWindow(r27);
        r20 = r27[1];
        r21 = UtilityKotlinExtentionsKt.i(75);
    L36:
        com.bytedance.android.anya.r0<GiftComboState, Boolean> r28 = r13.isSingleTap();
        Object r29 = r10.c.a(r28);
        if (r29 == null) goto L42;
        r10.b.a.invoke(r28);
        if (((Boolean) r29).booleanValue() == false) goto L41;
        this.n.g();
        goto L42
    L41:
        this.n.f();
    L42:
        com.bytedance.android.anya.r0<GiftComboState, ComboState> r110 = r13.getComboStatus();
        Object r30 = r10.c.a(r110);
        if (r30 == null) goto L54;
        r10.b.a.invoke(r110);
        int r111 = a.a[((ComboState) r30).ordinal()];
        if (r111 == 1) goto L52;
        if (r111 != 2) goto L48;
        this.n.setVisibility(0);
        o(new OnComboSingleClickStart(false, 1, null));
        return;
    L48:
        if (r111 != 3) goto L57;
        this.n.setVisibility(0);
        return;
    L57:
        return;
    L52:
        UtilityKotlinExtentionsKt.t(this.n);
        this.n.d();
        return;
    }
}
