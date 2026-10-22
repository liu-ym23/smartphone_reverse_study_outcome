package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.gift.configmodel.s1;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftAccessibilityUtilsKt$addContentDescriptionWithoutClickable$1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickMinorsNoticeCloseButton;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftMinorsNoticeState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIMinorsNoticeView extends BaseGiftMVIViewChildNode<GiftPanelState, GiftMinorsNoticeState, GiftAction> {
    public View m;
    public ImageView n;
    public TextView o;
    public View p;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ GiftMVIMinorsNoticeView a;
        public final /* synthetic */ s1 b;

        public c(GiftMVIMinorsNoticeView r1, s1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.a.o(new ClickMinorsNoticeCloseButton());
            if (this.b.b() != 1) goto L5;
            ToastUtil.b("已关闭提示，今日不再提醒", 0);
            return;
        L5:
            int r4 = ToastUtil.a;
            ToastUtil.b("已关闭提示，" + this.b.b() + "日内不再提醒", 0);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131568010;
    }

    public final void g() {
        this.m = r().findViewById(2131366980);
        this.n = (ImageView) r().findViewById(2131366997);
        View r0 = this.m;
        Resources r1 = getContext().getResources();
        final String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getString(2131918650);
    L6:
        r3.c(r0, r3, true);
        this.o = (TextView) r().findViewById(2131381026);
        this.p = r().findViewById(2131367744);
        s1 r4 = nz1.a.p();
        TextView r5 = this.o;
        if (r5 == null) goto L9;
        r5.setText(r4.e());
    L9:
        r().setOnClickListener(b.a);
        View r6 = this.m;
        if (r6 == null) goto L12;
        r6.setOnClickListener(new c(this, r4));
    L12:
        View r7 = r();
        TextView r8 = this.o;
        if (r8 == null) goto L17;
        CharSequence r9 = r8.getText();
        if (r9 == null) goto L17;
        r2 = r9.toString();
    L17:
        if (r7 == null) goto L22;
        if (r2 == null) goto L23;
        ViewCompat.setAccessibilityDelegate(r7, new GiftAccessibilityUtilsKt$addContentDescriptionWithoutClickable$1(r2));
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIMinorsNoticeView$bindToParent$1 r0 = GiftMVIMinorsNoticeView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final void b(com.bytedance.android.anya.k r11, MVIState r13) {
        GiftMinorsNoticeState r14 = (GiftMinorsNoticeState) r13;
        Intrinsics.checkNotNullParameter(r11, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r14, "state");
        com.bytedance.android.anya.r0<GiftMinorsNoticeState, Boolean> r0 = r14.getShouldShow();
        Object r1 = r11.c.a(r0);
        Object r2 = null;
        if (r1 == null) goto L11;
        r11.b.a.invoke(r0);
        boolean r3 = ((Boolean) r1).booleanValue();
        ViewUtilsKt.g(r(), r3);
        if (r3 == false) goto L11;
        TextView r4 = this.o;
        if (r4 == null) goto L9;
        CharSequence r5 = r4.getText();
    L10:
        String r6 = String.valueOf(r5);
        KProperty[] r7 = ay1.b.a;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        ay1.b.m0.setValue(null, ay1.b.a[76], r6);
        goto L11
    L9:
        r5 = null;
    L11:
        com.bytedance.android.anya.r0<GiftMinorsNoticeState, Boolean> r8 = r14.getNeedChangeLayout();
        Object r9 = r11.c.a(r8);
        boolean r10 = false;
        if (r9 == null) goto L38;
        r11.b.a.invoke(r8);
        boolean r15 = ((Boolean) r9).booleanValue();
        ConstraintLayout r16 = UtilityKotlinExtentionsKt.p(this.l);
        if (r16 == null) goto L37;
        ConstraintLayout r17 = r16;
        if (r15 == false) goto L32;
        int r18 = com.bytedance.android.live.recharge.util.d.a;
        if (com.bytedance.android.live.recharge.util.d.b(getContext()) == false) goto L32;
        View r19 = this.p;
        if (r19 == null) goto L22;
        r19.setBackground(com.bytedance.android.live.core.utils.s1.m(2131248748));
    L22:
        View r20 = this.p;
        if (r20 == null) goto L25;
        com.bytedance.android.live.core.utils.a1.m(r20, com.bytedance.android.live.core.utils.s1.f(8.0f));
    L25:
        View r21 = this.p;
        if (r21 == null) goto L28;
        com.bytedance.android.live.core.utils.a1.n(r21, com.bytedance.android.live.core.utils.s1.f(8.0f));
    L28:
        View r23 = this.p;
        if (r23 == null) goto L31;
        com.bytedance.android.livesdk.gift.platform.core.preview.view.s.a(r23, com.bytedance.android.live.core.utils.s1.f(31.0f));
    L31:
        ConstraintSet r24 = new ConstraintSet();
        r24.constrainHeight(this.l.getId(), com.bytedance.android.live.core.utils.s1.f(31.0f));
        r24.connect(this.l.getId(), 6, 0, 6);
        r24.connect(this.l.getId(), 7, 0, 7);
        r24.connect(this.l.getId(), 4, 2131389148, 3);
        r24.applyTo(r17);
    L32:
        View r25 = this.p;
        if (r25 == null) goto L35;
        r25.setBackground(com.bytedance.android.live.core.utils.s1.m(2131252412));
    L35:
        ConstraintSet r26 = new ConstraintSet();
        r26.constrainHeight(this.l.getId(), com.bytedance.android.live.core.utils.s1.f(44.0f));
        r26.constrainWidth(this.l.getId(), 0);
        r26.connect(this.l.getId(), 4, 2131387023, 3);
        r26.connect(this.l.getId(), 6, 0, 6);
        r26.connect(this.l.getId(), 7, 0, 7);
        r26.applyTo(r17);
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L38:
        com.bytedance.android.anya.internal.c r27 = r14.getShowAnchorEffectCloseNotice();
        com.bytedance.android.anya.internal.c r28 = r14.getAnchorEffectCloseNotice();
        com.bytedance.android.anya.internal.c r110 = r14.getShouldShow();
        Object r29 = r11.c.a(r27);
        if (r29 == null) goto L41;
        r11.b.a.invoke(r27);
    L42:
        Object r30 = r11.c.a(r28);
        if (r30 == null) goto L45;
        r11.b.a.invoke(r28);
    L46:
        Object r31 = r11.c.a(r110);
        if (r31 == null) goto L49;
        r11.b.a.invoke(r110);
        r2 = r31;
    L49:
        if (r29 != null) goto L52;
        if (r30 != null) goto L52;
        if (r2 != null) goto L52;
        return;
    L52:
        if (r29 != null) goto L54;
        r29 = r27.c();
    L54:
        if (r30 != null) goto L56;
        r30 = r28.c();
    L56:
        if (r2 != null) goto L58;
        r2 = r110.c();
    L58:
        boolean r111 = ((Boolean) r2).booleanValue();
        String r33 = (String) r30;
        boolean r112 = ((Boolean) r29).booleanValue();
        View r34 = r();
        if (r112 == true) goto L61;
        if (r111 == true) goto L61;
    L62:
        ViewUtilsKt.g(r34, r10);
        View r113 = this.m;
        if (r113 == null) goto L65;
        ViewUtilsKt.g(r113, !r112);
    L65:
        ImageView r114 = this.n;
        if (r114 == null) goto L68;
        ViewUtilsKt.g(r114, !r112);
    L68:
        if (r112 == false) goto L72;
        TextView r115 = this.o;
        if (r115 == null) goto L77;
        r115.setText(r33);
        return;
    L77:
        return;
    L72:
        TextView r116 = this.o;
        if (r116 == null) goto L79;
        r116.setText(nz1.a.p().e());
        return;
    L79:
        return;
    L61:
        r10 = true;
        goto L62
    L45:
        r30 = null;
        goto L46
    L41:
        r29 = null;
        goto L42
    }

    public GiftMVIMinorsNoticeView(Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(r2, r3);
    }
}
