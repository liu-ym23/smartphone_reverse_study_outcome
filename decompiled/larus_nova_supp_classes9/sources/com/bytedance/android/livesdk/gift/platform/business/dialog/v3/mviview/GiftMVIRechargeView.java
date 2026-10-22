package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftRechargeViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RechargeIconParams;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RechargeViewParams;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.text.RevRenderConfig;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIRechargeView extends BaseGiftMVIViewChildNode<GiftPanelState, GiftRechargeViewState, GiftAction> {
    public static final /* synthetic */ int w = 0;
    public View m;
    public TextView n;
    public HSImageView o;
    public View p;
    public View q;
    public TextView r;
    public TextView s;
    public zv0.b t;
    public HSImageView u;
    public final DataCenter v;

    public static final class a {
    }

    static {
    }

    public final void g() {
        int r0 = 0;
        p(0);
        this.m = r().findViewById(2131364417);
        this.n = (TextView) r().findViewById(2131383900);
        this.o = r().findViewById(2131367088);
        this.p = r().findViewById(2131365496);
        this.q = r().findViewById(2131383876);
        TextView r1 = (TextView) r().findViewById(2131375210);
        this.r = r1;
        if (r1 == null) goto L5;
        r1.setText(s1.C(2131917145, new Object[]{r3.c()}));
    L5:
        this.s = (TextView) r().findViewById(2131375211);
        this.u = r().findViewById(2131362590);
        View r2 = this.m;
        if (r2 != null) goto L8;
    L13:
        View r3 = this.p;
        if (r3 == null) goto L17;
        r3.setOnClickListener(new o0(this));
        return;
    L17:
        return;
    L8:
        if (u() == true) goto L10;
    L11:
        r0 = 8;
    L12:
        r2.setVisibility(r0);
        goto L13
    L10:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.p() == false) goto L12;
        goto L11
    }

    public final void i() {
        zv0.b r0 = this.t;
        if (r0 == null) goto L5;
        r0.onUnload();
    L5:
        this.t = null;
    }

    public final void t() {
        TextView r0 = this.n;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
    L7:
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r1 = null;
    L9:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.l(u(), null) == false) goto L19;
        View r3 = this.q;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        if (r2 == null) goto L16;
        r2.rightMargin = s1.f(8.0f);
    L16:
        TextView r4 = this.n;
        if (r4 == null) goto L28;
        r4.setLayoutParams(r2);
        return;
    L28:
        return;
    L19:
        View r5 = this.q;
        if (r5 == null) goto L22;
        r5.setVisibility(0);
    L22:
        if (r2 == null) goto L24;
        r2.rightMargin = s1.f(20.0f);
    L24:
        TextView r6 = this.n;
        if (r6 == null) goto L30;
        r6.setLayoutParams(r2);
        return;
    L30:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean u() {
        Boolean r0 = (Boolean) this.v.get("data_is_portrait", Boolean.TRUE);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        if (PadConfigUtils.c() == false) goto L5;
        return 2131565246;
    L5:
        return 2131565245;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIRechargeView$bindToParent$1 r0 = GiftMVIRechargeView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final void b(com.bytedance.android.anya.k r20, MVIState r21) {
        GiftRechargeViewState r2 = (GiftRechargeViewState) r21;
        Intrinsics.checkNotNullParameter(r20, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r2, "state");
        com.bytedance.android.anya.r0<GiftRechargeViewState, RechargeViewParams> r3 = r2.getRechargeViewParams();
        Object r4 = r20.c.a(r3);
        ViewGroup.LayoutParams r8 = null;
        if (r4 == null) goto L50;
        r20.b.a.invoke(r3);
        RechargeViewParams r5 = (RechargeViewParams) r4;
        if (r5.getEnableAnchorPanelEntrance() == false) goto L22;
        View r6 = this.p;
        if (r6 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r6);
    L9:
        TextView r7 = this.r;
        if (r7 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r7);
    L12:
        TextView r9 = this.s;
        if (r9 == null) goto L15;
        UtilityKotlinExtentionsKt.t(r9);
    L15:
        HSImageView r10 = this.u;
        if (r10 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r10);
    L18:
        HSImageView r11 = this.u;
        if (r11 == null) goto L50;
        r11.setOnClickListener(new m0(this));
        goto L50
    L22:
        if (r5.getTouchText() == null) goto L24;
        vh6.c.b(ur2.a.class).a4(r5.getTouchText(), RevRenderConfig.SyncDecodeContext, new n0(this, r5));
    L49:
        t();
        goto L50
    L24:
        TextView r13 = this.n;
        if (r13 == null) goto L27;
        r13.setText(r5.getText());
    L27:
        View r14 = this.p;
        if (r14 == null) goto L34;
        Object[] r15 = new Object[3];
        TextView r16 = this.n;
        if (r16 == null) goto L32;
        CharSequence r17 = r16.getText();
    L33:
        r15[0] = r17;
        r15[1] = r3.c();
        r15[2] = e4.a();
        r14.setContentDescription(s1.C(2131919843, r15));
        goto L34
    L32:
        r17 = null;
    L34:
        TextView r18 = this.n;
        if (r18 == null) goto L37;
        r18.setTextSize(1, r5.getTextSize());
    L37:
        TextView r19 = this.n;
        if (r19 == null) goto L40;
        r19.setTextColor(getContext().getResources().getColor(r5.getTextColorRes()));
    L40:
        String r23 = e4.a();
        TextView r24 = this.n;
        if (r24 == null) goto L48;
        CharSequence r25 = r24.getText();
        if (r25 == null) goto L48;
        String r26 = r25.toString();
        if (r26 == null) goto L48;
        if (r26.equals(r23) == true) goto L49;
    L48:
        com.bytedance.android.livesdk.r3.c(this.p, getContext().getString(2131917160, new Object[]{r5.getText(), e4.a()}), true);
    L50:
        com.bytedance.android.anya.r0<GiftRechargeViewState, RechargeIconParams> r27 = r2.getIconViewParams();
        Object r28 = r20.c.a(r27);
        if (r28 == null) goto L61;
        r20.b.a.invoke(r27);
        RechargeIconParams r29 = (RechargeIconParams) r28;
        HSImageView r30 = this.o;
        if (r30 == null) goto L55;
        r30.setVisibility(r29.getVisibility());
    L55:
        py.k r31 = r29.getImageModel();
        if (r31.isValid() == true) goto L59;
        r31 = null;
    L59:
        if (r31 == null) goto L61;
        ImageUtil.loadImage(this.o, r31, 0);
    L61:
        com.bytedance.android.anya.r0<GiftRechargeViewState, Boolean> r33 = r2.getShowIncomeToCoins();
        Object r34 = r20.c.a(r33);
        if (r34 == null) goto L108;
        r20.b.a.invoke(r33);
        boolean r35 = ((Boolean) r34).booleanValue();
        View r36 = this.p;
        if (r36 == null) goto L66;
        ViewGroup.LayoutParams r37 = r36.getLayoutParams();
    L68:
        if ((r37 instanceof ConstraintLayout.LayoutParams) == true) goto L70;
        r37 = null;
    L70:
        ConstraintLayout.LayoutParams r38 = (ConstraintLayout.LayoutParams) r37;
        if (r35 == true) goto L73;
        TextView r39 = this.r;
        if (r39 == null) goto L99;
        r39.setVisibility(8);
    L99:
        TextView r40 = this.s;
        if (r40 == null) goto L102;
        r40.setVisibility(8);
    L102:
        if (r38 == null) goto L104;
        ((ViewGroup.MarginLayoutParams) r38).rightMargin = s1.f(16.0f);
    L104:
        View r41 = this.p;
        if (r41 == null) goto L107;
        r41.setLayoutParams(r38);
    L107:
        t();
        goto L108
    L73:
        if (this.r == null) goto L108;
        if (this.s == null) goto L108;
        ArrayList r110 = new ArrayList(2);
        TextView r43 = this.r;
        if (r43 == null) goto L80;
        r110.add(r43);
    L80:
        TextView r44 = this.s;
        if (r44 == null) goto L83;
        r110.add(r44);
    L83:
        IRechargeService r111 = jc1.k.n(IRechargeService.class);
        TextView r112 = this.r;
        TextView r113 = this.s;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.d.g.getValue(null, com.bytedance.android.livesdk.gift.platform.business.d.a[5])).booleanValue() == false) goto L87;
        Function1 r45 = GiftMVIRechargeView$incomeToCoinsEntranceOptimize$1.INSTANCE;
    L90:
        Function1 r114 = r45;
    L91:
        zv0.b r46 = r111.getCashExchangeDelegate(r112, r110, r113, r114, 2, getContext());
        this.t = r46;
        if (r46 == null) goto L94;
        r46.setDataCenter(this.v);
    L94:
        if (r38 == null) goto L104;
        ((ViewGroup.MarginLayoutParams) r38).rightMargin = s1.f(12.0f);
        goto L104
    L87:
        if (this.m != null) goto L89;
        r114 = null;
        goto L91
    L89:
        r45 = new GiftMVIRechargeView$adjustContainerHeight$1(this);
        goto L90
    L66:
        r37 = null;
    L108:
        com.bytedance.android.anya.r0<GiftRechargeViewState, Boolean> r47 = r2.getShowExchangeDouyinDiamond();
        Object r48 = r20.c.a(r47);
        if (r48 == null) goto L154;
        r20.b.a.invoke(r47);
        boolean r1 = ((Boolean) r48).booleanValue();
        View r49 = this.p;
        if (r49 == null) goto L113;
        ViewGroup.LayoutParams r50 = r49.getLayoutParams();
    L115:
        if ((r50 instanceof ConstraintLayout.LayoutParams) == false) goto L118;
        r8 = r50;
    L118:
        ConstraintLayout.LayoutParams r51 = (ConstraintLayout.LayoutParams) r8;
        if (r1 == true) goto L121;
        TextView r53 = this.r;
        if (r53 == null) goto L144;
        r53.setVisibility(8);
    L144:
        TextView r54 = this.s;
        if (r54 == null) goto L147;
        r54.setVisibility(8);
    L147:
        if (r51 == null) goto L149;
        ((ViewGroup.MarginLayoutParams) r51).rightMargin = s1.f(16.0f);
    L149:
        View r55 = this.p;
        if (r55 == null) goto L152;
        r55.setLayoutParams(r51);
    L152:
        t();
        return;
    L121:
        if (this.r == null) goto L155;
        TextView r56 = this.s;
        if (r56 == null) goto L156;
        r56.setVisibility(8);
        TextView r57 = this.r;
        if (r57 == null) goto L129;
        r57.setVisibility(0);
    L129:
        if (Intrinsics.areEqual(r3.c(), "抖币") == false) goto L133;
        TextView r58 = this.r;
        if (r58 == null) goto L136;
        r58.setText(s1.C(2131917163, new Object[]{r3.c()}));
    L136:
        if (r51 == null) goto L138;
        ((ViewGroup.MarginLayoutParams) r51).rightMargin = s1.f(12.0f);
    L138:
        TextView r59 = this.r;
        if (r59 == null) goto L149;
        r59.setOnClickListener(new l0(this));
        goto L149
    L133:
        TextView r60 = this.r;
        if (r60 == null) goto L136;
        r60.setText(s1.C(2131917162, new Object[]{r3.c()}));
        goto L136
    L156:
        return;
    L155:
        return;
    L113:
        r50 = null;
        goto L115
    }

    public GiftMVIRechargeView(Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(r2, r3);
        this.v = r4;
    }
}
