package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.model.o2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.GiftTabTextView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickTabItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollGuideState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollGuideStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.TopicLabelStatus;
import com.bytedance.android.livesdk.r3;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.drawable.ScalingUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftTabViewHolder extends BaseMVIListItem<GiftTabItem, GiftAction> {
    public final Lazy l;
    public TopicLabelStatus m;
    public ScrollGuideState n;
    public int o;
    public boolean p;
    public boolean q;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GiftTabViewHolder a;

        public a(GiftTabViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            GiftTabViewHolder r9 = this.a;
            r9.o(new ClickTabItem(r9.p(), 0, false, 6, null));
            com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).sendEventToAllJsBridges("giftPanelTabChanged", new LinkedHashMap());
        }
    }

    public static final class b {
    }

    static {
    }

    public final GiftTabTextView q() {
        return (GiftTabTextView) this.l.getValue();
    }

    public final void r() {
        StringBuilder r0 = new StringBuilder();
        r0.append(q().getText());
        r0.append("按钮");
        if (this.q == false) goto L5;
        int r1 = this.o;
    L7:
        if (this.p == false) goto L19;
        r0.append(", ");
        Map<Integer, Integer> r3 = tz1.a.a;
        if (r1 != 0) goto L11;
        String r2 = "默认排序";
    L18:
        r0.append(r2);
        goto L19
    L11:
        if (r1 != 1) goto L13;
        r2 = "按价格从低到高排序";
        goto L18
    L13:
        if (r1 == 2) goto L15;
        r2 = BuildConfig.FLAVOR;
        goto L18
    L15:
        r2 = "按价格从高到低排序";
    L19:
        String r4 = r0.toString();
        r3.d(((BaseMVIListItem) this).j, r4, this.q, false);
        return;
    L5:
        r1 = 0;
        goto L7
    }

    public final void i() {
        GiftTabTextView r0 = q();
        ObjectAnimator r1 = r0.f;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isRunning() == false) goto L9;
        r0.f.cancel();
        return;
    }

    public GiftTabViewHolder(View r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r7, "inflateView");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        super(r7, new GiftTabItem());
        this.l = LazyKt.lazy(new GiftTabViewHolder$giftTabTextView$2(this));
        this.m = TopicLabelStatus.ARROW_GONE;
        this.n = new ScrollGuideState(null, null, null, 7, null);
        q().setGravity(48);
        q().setTextSize(14.0f);
        ((BaseMVIListItem) this).j.setOnClickListener(new a(this));
    }

    public final void b(com.bytedance.android.anya.k r13, MVIState r14) {
        GiftTabItem r15 = (GiftTabItem) r14;
        Intrinsics.checkNotNullParameter(r13, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r15, "state");
        r0<GiftTabItem, String> r0 = r15.getTitle();
        Object r1 = r13.c.a(r0);
        if (r1 == null) goto L5;
        r13.b.a.invoke(r0);
        q().setText((String) r1);
    L5:
        r0<GiftTabItem, Integer> r2 = r15.getOrderIcon();
        Object r3 = r13.c.a(r2);
        if (r3 == null) goto L11;
        r13.b.a.invoke(r2);
        int r4 = ((Number) r3).intValue();
        if (r4 == 0) goto L10;
        q().setIsNeedSort(Boolean.TRUE);
        q().setOrderView(r4);
        r3.q(((BaseMVIListItem) this).j.getContext(), "礼物已重新排序");
        goto L11
    L10:
        q().setIsNeedSort(Boolean.FALSE);
    L11:
        com.bytedance.android.anya.internal.c r5 = r15.getOrderRule();
        com.bytedance.android.anya.internal.c r6 = r15.getOrderIcon();
        Object r7 = r13.c.a(r5);
        if (r7 == null) goto L14;
        r13.b.a.invoke(r5);
    L15:
        Object r8 = r13.c.a(r6);
        if (r8 == null) goto L18;
        r13.b.a.invoke(r6);
    L20:
        if (r7 != null) goto L22;
        if (r8 != null) goto L22;
    L31:
        r0<GiftTabItem, Boolean> r9 = r15.getSelected();
        Object r10 = r13.c.a(r9);
        if (r10 == null) goto L34;
        r13.b.a.invoke(r9);
        boolean r11 = ((Boolean) r10).booleanValue();
        q().setTextColor(r11);
        this.q = r11;
        r();
    L34:
        r0<GiftTabItem, Boolean> r16 = r15.getShowRedDot();
        Object r17 = r13.c.a(r16);
        if (r17 == null) goto L42;
        r13.b.a.invoke(r16);
        boolean r18 = ((Boolean) r17).booleanValue();
        View r19 = q().c;
        if (r19 == null) goto L42;
        if (r18 == false) goto L40;
        int r20 = 0;
    L41:
        r19.setVisibility(r20);
        goto L42
    L40:
        r20 = 8;
    L42:
        com.bytedance.android.anya.internal.c r21 = r15.getTopicLabelIconStatus();
        com.bytedance.android.anya.internal.c r23 = r15.getSelected();
        Object r24 = r13.c.a(r21);
        if (r24 == null) goto L45;
        r13.b.a.invoke(r21);
    L46:
        Object r25 = r13.c.a(r23);
        if (r25 == null) goto L49;
        r13.b.a.invoke(r23);
    L51:
        if (r24 != null) goto L53;
        if (r25 != null) goto L53;
    L92:
        com.bytedance.android.anya.internal.c r26 = r15.getScrollGuideState();
        com.bytedance.android.anya.internal.c r110 = r15.getSelected();
        Object r27 = r13.c.a(r26);
        if (r27 == null) goto L95;
        r13.b.a.invoke(r26);
    L96:
        Object r28 = r13.c.a(r110);
        if (r28 == null) goto L99;
        r13.b.a.invoke(r110);
    L100:
        if (r27 != null) goto L102;
        if (r28 != null) goto L102;
        return;
    L102:
        if (r27 != null) goto L104;
        r27 = r26.c();
    L104:
        if (r28 != null) goto L106;
        r28 = r110.c();
    L106:
        boolean r111 = ((Boolean) r28).booleanValue();
        ScrollGuideState r29 = (ScrollGuideState) r27;
        if (r29.getScrollGuideInfo() == null) goto L131;
        ScrollGuideStatus r112 = r29.getStatus();
        ScrollGuideStatus r30 = ScrollGuideStatus.SHOW;
        if (r112 != r30) goto L131;
        if (r111 == true) goto L131;
        o2 r113 = this.n.getScrollGuideInfo();
        if (r113 != null) goto L115;
    L118:
        final GiftTabTextView r114 = q();
        o2 r115 = r29.getScrollGuideInfo();
        final z r31 = new z(this);
        r114.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.d() == false) goto L139;
        ViewSwitcher r33 = r114.b;
        if (r33 == null) goto L139;
        if (r33.getChildCount() <= 1) goto L126;
        ViewSwitcher r34 = r114.b;
        r34.removeViews(1, r34.getChildCount() - 1);
    L126:
        r114.b.setInAnimation(s1.getContext(), 2130772695);
        r114.b.setOutAnimation(s1.getContext(), 2130772696);
        if (r115.getNameImage() == null) goto L129;
        View r35 = new HSImageView(r114.getContext());
        ViewGroup.LayoutParams r36 = new ViewGroup.LayoutParams(r114.b.getWidth(), r114.b.getHeight());
        r35.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        ImageLoader.bindImage(r35, r115.getNameImage());
        r114.b.addView(r35, r36);
    L130:
        r114.b.setDisplayedChild(0);
        r114.a();
        r114.g = Observable.interval(0, 2400, TimeUnit.MILLISECONDS).take(r114.b.getChildCount()).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new oz1.a(r31)).subscribe(new oz1.b(r114));
        goto L139
    L129:
        TextView r37 = (TextView) r114.b.getChildAt(0);
        TextView r38 = new TextView(r114.getContext());
        r38.setText(r115.getName());
        r38.setTextSize(0, r37.getTextSize());
        r38.setLayoutParams(r37.getLayoutParams());
        r38.setTextColor(r37.getTextColors());
        r38.setGravity(r37.getGravity());
        r38.setTypeface(r37.getTypeface());
        r114.b.addView(r38);
    L139:
        this.n = r29;
        return;
    L115:
        if (r113.getRelatedTopicId() != r29.getScrollGuideInfo().getRelatedTopicId()) goto L118;
        if (this.n.getStatus() == r30) goto L139;
    L131:
        GiftTabTextView r116 = q();
        r116.a();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.d() == false) goto L139;
        ViewSwitcher r117 = r116.b;
        if (r117 == null) goto L139;
        if (r117.getChildCount() < 2) goto L139;
        r116.b.setInAnimation(null);
        r116.b.setOutAnimation(null);
        r116.b.setDisplayedChild(0);
        ViewSwitcher r118 = r116.b;
        r118.removeViews(1, r118.getChildCount() - 1);
        goto L139
    L99:
        r28 = null;
        goto L100
    L95:
        r27 = null;
    L53:
        if (r24 != null) goto L55;
        r24 = r21.c();
    L55:
        if (r25 != null) goto L57;
        r25 = r23.c();
    L57:
        boolean r39 = ((Boolean) r25).booleanValue();
        TopicLabelStatus r40 = (TopicLabelStatus) r24;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.g() == false) goto L91;
        TopicLabelStatus r41 = TopicLabelStatus.ARROW_GONE;
        if (r40 != r41) goto L62;
        q().setIsNeedTopicLabel(Boolean.FALSE);
        this.m = r41;
        goto L92
    L62:
        q().setIsNeedTopicLabel(Boolean.TRUE);
        int r43 = y.a[this.m.ordinal()];
        if (r43 == 1) goto L83;
        if (r43 != 2) goto L66;
        if (r39 == true) goto L80;
        q().setTopicLabelBackground(2131250743);
        q().setTopicViewRotation(0.0f);
    L90:
        this.m = r40;
        goto L92
    L80:
        if (r40 != TopicLabelStatus.ARROW_DOWN) goto L90;
        q().setTopicLabelBackground(2131250742);
        q().b(Float.valueOf(180.0f), Float.valueOf(360.0f));
        goto L90
    L66:
        if (r43 != 3) goto L90;
        if (r40 != TopicLabelStatus.ARROW_DOWN) goto L74;
        if (r39 == false) goto L72;
        q().setTopicLabelBackground(2131250742);
        goto L74
    L72:
        q().setTopicLabelBackground(2131250743);
    L74:
        if (r40 != TopicLabelStatus.ARROW_UP) goto L90;
        if (r39 == false) goto L90;
        q().setTopicViewRotation(180.0f);
        q().setTopicLabelBackground(2131250742);
        goto L90
    L83:
        if (r40 != TopicLabelStatus.ARROW_DOWN) goto L88;
        if (r39 == false) goto L86;
        q().setTopicLabelBackground(2131250742);
        goto L88
    L86:
        q().setTopicLabelBackground(2131250743);
    L88:
        if (r40 != TopicLabelStatus.ARROW_UP) goto L90;
        q().setTopicLabelBackground(2131250742);
        q().b(Float.valueOf(0.0f), Float.valueOf(180.0f));
        goto L90
    L91:
        q().setIsNeedTopicLabel(Boolean.FALSE);
        goto L92
    L49:
        r25 = null;
        goto L51
    L45:
        r24 = null;
    L22:
        if (r7 != null) goto L24;
        r7 = r5.c();
    L24:
        if (r8 != null) goto L26;
        r8 = r6.c();
    L26:
        int r44 = ((Number) r8).intValue();
        int r45 = ((Number) r7).intValue();
        if (r44 != 0) goto L29;
        this.p = false;
    L30:
        r();
        goto L31
    L29:
        this.p = true;
        this.o = r45;
        goto L30
    L18:
        r8 = null;
        goto L20
    L14:
        r7 = null;
        goto L15
    }
}
