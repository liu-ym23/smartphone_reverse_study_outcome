package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.r3;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVITopView extends com.bytedance.android.anya.e<GiftPanelState, GiftTopViewState, GiftAction> {
    public static final /* synthetic */ int A = 0;
    public final q1 k;
    public boolean l;
    public View m;
    public View n;
    public View o;
    public AnimatorSet p;
    public AnimatorSet q;
    public ViewGroup r;
    public final Set<GiftTopViewState.Mode> s;
    public View t;
    public final Lazy u;
    public final Map<GiftTopViewState.Mode, Pair<ViewGroup, BaseGiftMVIViewChildNode<GiftTopViewState, ?, ?>>> v;
    public final Context w;
    public final ViewGroup x;
    public final ViewGroup y;
    public final DataCenter z;

    public static final class a {
    }

    static {
    }

    public final View s() {
        return (View) this.u.getValue();
    }

    public final void i() {
        AnimatorSet r0 = this.q;
        if (r0 != null) goto L5;
    L19:
        q1 r1 = this.k;
        if (com.bytedance.android.scope.l.b(r1) == true) goto L23;
        r1 = null;
    L23:
        if (r1 == null) goto L31;
        com.bytedance.android.scope.l.c(r1);
        return;
    L31:
        return;
    L5:
        if (r0.isRunning() != true) goto L19;
        AnimatorSet r2 = this.q;
        if (r2 == null) goto L9;
        r2.end();
    L9:
        AnimatorSet r3 = this.q;
        if (r3 == null) goto L19;
        ArrayList<Animator> r4 = r3.getChildAnimations();
        if (r4 == null) goto L19;
        Iterator<T> r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Animator r6 = (Animator) r5.next();
        if ((r6 instanceof ValueAnimator) == false) goto L15;
        r6.removeAllListeners();
        goto L15
    }

    public final Collection<com.bytedance.android.anya.z<GiftTopViewState, ?, ?>> p() {
        final ArrayList r0 = new ArrayList();
        com.bytedance.android.scope.m r1 = com.bytedance.android.scope.m.e;
        q1 r2 = this.k;
        Function1<Sequence<? extends com.bytedance.android.scope.o>, Unit> r3 = new GiftMVITopView$childNodes$$inlined$apply$lambda$1(r0, this);
        r1.getClass();
        com.bytedance.android.scope.m.f(r2, r3);
        return r0;
    }

    public final void g() {
        s().setVisibility(0);
        this.m = s().findViewById(2131366987);
        this.o = s().findViewById(2131366986);
        this.n = s().findViewById(2131389151);
        this.t = this.x.findViewById(2131389152);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L10;
        View r0 = s();
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.preview.view.s.a(r0, com.bytedance.android.live.revenue.common.i.b(58));
    L7:
        View r1 = this.t;
        if (r1 == null) goto L10;
        r1.setVisibility(0);
    L10:
        DataCenter r2 = this.z;
        Boolean r3 = Boolean.TRUE;
        Boolean r4 = (Boolean) r2.get("data_is_portrait", r3);
        if (r4 == null) goto L13;
        boolean r5 = r4.booleanValue();
    L14:
        int r6 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r5) == false) goto L25;
        View r7 = this.m;
        if (r7 == null) goto L19;
        r7.setBackground(null);
    L19:
        View r8 = this.m;
        if (r8 == null) goto L22;
        r8.setBackgroundColor(s1.h(2131108453));
    L22:
        View r9 = this.n;
        if (r9 == null) goto L25;
        r9.setBackground(s1.m(2131249178));
    L25:
        Boolean r10 = (Boolean) this.z.get("data_is_portrait", r3);
        if (r10 == null) goto L28;
        boolean r11 = r10.booleanValue();
    L30:
        if (r11 == false) goto L34;
        View r13 = this.n;
        if (r13 == null) goto L37;
        r13.setVisibility(8);
    L37:
        View r14 = this.m;
        if (r14 == null) goto L40;
        r14.setOnClickListener(new c1(this));
    L40:
        View r15 = this.m;
        if (r15 == null) goto L43;
        r15.setVisibility(8);
    L43:
        View r16 = this.o;
        if (r16 == null) goto L46;
        r16.setVisibility(8);
    L46:
        r3.a(this.m, s1.B(2131914422));
        return;
    L34:
        View r17 = this.n;
        if (r17 == null) goto L37;
        r17.setVisibility(0);
        goto L37
    L28:
        r11 = false;
        goto L30
    L13:
        r5 = false;
        goto L14
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVITopView$bindToParent$1 r0 = GiftMVITopView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final void q(com.bytedance.android.anya.k r21, MVIState r23, Function1 r24) {
        com.bytedance.android.anya.k r1 = r21;
        Function1 r2 = r24;
        GiftTopViewState r3 = (GiftTopViewState) r23;
        Intrinsics.checkNotNullParameter(r1, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r2, "dispatchDiff");
        com.bytedance.android.anya.r0<GiftTopViewState, Boolean> r4 = r3.getVisibility();
        Object r5 = r1.c.a(r4);
        int r7 = 0;
        if (r5 == null) goto L14;
        r1.b.a.invoke(r4);
        boolean r6 = ((Boolean) r5).booleanValue();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L14;
        if (r6 == false) goto L11;
        this.x.setVisibility(0);
        ViewGroup r8 = this.y;
        if (r8 == null) goto L14;
        r8.setVisibility(0);
        goto L14
    L11:
        this.x.setVisibility(8);
        ViewGroup r9 = this.y;
        if (r9 == null) goto L14;
        r9.setVisibility(8);
    L14:
        com.bytedance.android.anya.r0<GiftTopViewState, Boolean> r10 = r3.getShowAnim();
        Object r11 = r1.c.a(r10);
        if (r11 == null) goto L17;
        r1.b.a.invoke(r10);
        this.l = ((Boolean) r11).booleanValue();
    L17:
        com.bytedance.android.anya.internal.c r13 = r3.getMode();
        com.bytedance.android.anya.internal.c r14 = r3.getShowDetail();
        com.bytedance.android.anya.internal.c r15 = r3.getMarketingHiddenAnim();
        Object r16 = r1.c.a(r13);
        if (r16 == null) goto L20;
        r1.b.a.invoke(r13);
    L21:
        Object r17 = r1.c.a(r14);
        if (r17 == null) goto L24;
        r1.b.a.invoke(r14);
    L25:
        Object r18 = r1.c.a(r15);
        if (r18 == null) goto L28;
        r1.b.a.invoke(r15);
    L29:
        if (r16 != null) goto L32;
        if (r17 != null) goto L32;
        if (r18 != null) goto L32;
    L170:
        r2.invoke(r1);
        return;
    L32:
        if (r16 != null) goto L34;
        r16 = r13.c();
    L34:
        if (r17 != null) goto L36;
        r17 = r14.c();
    L36:
        if (r18 != null) goto L38;
        r18 = r15.c();
    L38:
        boolean r19 = ((Boolean) r18).booleanValue();
        boolean r20 = ((Boolean) r17).booleanValue();
        GiftTopViewState.Mode r25 = (GiftTopViewState.Mode) r16;
        Iterator r26 = ((LinkedHashMap) this.v).entrySet().iterator();
        Pair r110 = null;
        Pair r111 = null;
    L40:
        if (r26.hasNext() == false) goto L82;
        Map.Entry r112 = (Map.Entry) r26.next();
        GiftTopViewState.Mode r27 = (GiftTopViewState.Mode) r112.getKey();
        Pair r113 = (Pair) r112.getValue();
        if (r27 != r25) goto L74;
        if (r19 == false) goto L46;
        this.s.add(r27);
        boolean r114 = r20;
        Iterator r115 = r26;
        GiftTopViewState.Mode r116 = r25;
        r111 = r113;
    L81:
        r26 = r115;
        r25 = r116;
        r20 = r114;
        r7 = 0;
        goto L40
    L46:
        if (this.l == false) goto L72;
        ViewGroup r117 = (ViewGroup) r113.getFirst();
        if (Intrinsics.areEqual(r117, this.r) == false) goto L51;
    L68:
        r114 = r20;
        r115 = r26;
        r116 = r25;
        int r28 = 0;
    L73:
        ((BaseGiftMVIViewChildNode) r113.getSecond()).p(r28);
        this.s.add(r27);
        goto L81
    L51:
        if (this.r != null) goto L55;
        this.r = r117;
        if (r117 == null) goto L68;
        r117.setVisibility(r7);
        goto L68
    L55:
        AnimatorSet r29 = this.p;
        if (r29 != null) goto L58;
    L69:
        ViewGroup r30 = this.r;
        this.r = r117;
        ObjectAnimator r31 = ObjectAnimator.ofFloat(r30, "alpha", new float[]{1.0f, 0.0f});
        long r33 = 150;
        r31.setDuration(r33);
        r115 = r26;
        r116 = r25;
        r114 = r20;
        r31.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.34f, 0.46f, 1.0f));
        r31.addListener(new d1(r30));
        r117.setVisibility(0);
        r117.setAlpha(0.0f);
        ObjectAnimator r34 = ObjectAnimator.ofFloat(r117, "alpha", new float[]{0.0f, 1.0f});
        r34.setDuration(r33);
        r34.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        r34.addListener(new e1(r117));
        AnimatorSet r35 = new AnimatorSet();
        this.p = r35;
        r28 = 0;
        r35.playTogether(new Animator[]{r31, r34});
        AnimatorSet r36 = this.p;
        if (r36 == null) goto L73;
        r36.start();
        goto L73
    L58:
        if (r29.isRunning() != true) goto L69;
        AnimatorSet r37 = this.p;
        if (r37 == null) goto L62;
        r37.end();
    L62:
        ViewGroup r38 = this.r;
        if (r38 == null) goto L65;
        r38.setVisibility(8);
    L65:
        this.r = r117;
        if (r117 == null) goto L68;
        r117.setVisibility(r7);
        goto L68
    L72:
        r114 = r20;
        r115 = r26;
        r116 = r25;
        r28 = 0;
        ((ViewGroup) r113.getFirst()).setVisibility(0);
        goto L73
    L74:
        r114 = r20;
        r115 = r26;
        r116 = r25;
        if (this.s.contains(r27) == false) goto L81;
        if (((ViewGroup) r113.getFirst()).getVisibility() != 0) goto L80;
        if (r19 == false) goto L80;
        r110 = r113;
    L80:
        ((ViewGroup) r113.getFirst()).setVisibility(8);
        ((BaseGiftMVIViewChildNode) r113.getSecond()).p(8);
        goto L81
    L82:
        boolean r118 = r20;
        GiftTopViewState.Mode r119 = r25;
        if (r19 == false) goto L127;
        if (r110 == null) goto L151;
        if (r111 == null) goto L151;
        AnimatorSet r39 = this.q;
        if (r39 != null) goto L90;
    L95:
        ObjectAnimator r40 = ObjectAnimator.ofFloat(r110.getFirst(), "alpha", new float[]{1.0f, 0.0f});
        r40.setDuration(300);
        r40.addListener(new y0(r110));
        float r41 = ((ViewGroup) r110.getFirst()).getTranslationY();
        float r43 = UIUtils.dip2Px(((ViewGroup) r110.getFirst()).getContext(), 12.0f);
        ObjectAnimator r44 = ObjectAnimator.ofFloat(r110.getFirst(), "translationY", new float[]{r41, r41 - r43});
        r44.setDuration(300);
        r44.addListener(new z0(r110, r41));
        ObjectAnimator r45 = ObjectAnimator.ofFloat(r111.getFirst(), "alpha", new float[]{0.0f, 1.0f});
        r45.setDuration(300);
        r45.addListener(new a1(r111));
        float r46 = r43 + r41;
        ObjectAnimator r47 = ObjectAnimator.ofFloat(r111.getFirst(), "translationY", new float[]{r46, r41});
        r47.setDuration(300);
        if (r118 == false) goto L115;
        Map<GiftTopViewState.Mode, Pair<ViewGroup, BaseGiftMVIViewChildNode<GiftTopViewState, ?, ?>>> r120 = this.v;
        GiftTopViewState.Mode r121 = GiftTopViewState.Mode.Detail;
        Pair r122 = (Pair) ((LinkedHashMap) r120).get(r121);
        if (r122 == null) goto L100;
        ViewGroup r123 = (ViewGroup) r122.getFirst();
    L101:
        Pair r124 = (Pair) ((LinkedHashMap) this.v).get(r121);
        if (r124 == null) goto L104;
        BaseGiftMVIViewChildNode r125 = (BaseGiftMVIViewChildNode) r124.getSecond();
    L105:
        if (r123 == null) goto L115;
        if (r125 == null) goto L115;
        ObjectAnimator r126 = ObjectAnimator.ofFloat(r123, "alpha", new float[]{0.0f, 1.0f});
        if (r126 == null) goto L110;
        r126.setDuration(300);
    L110:
        if (r126 == null) goto L112;
        r126.addListener(new b1(r123, r125));
    L112:
        ObjectAnimator r48 = ObjectAnimator.ofFloat(r123, "translationY", new float[]{r46, r41});
        if (r48 == null) goto L116;
        r48.setDuration(300);
    L116:
        AnimatorSet r49 = new AnimatorSet();
        this.q = r49;
        if (r126 == null) goto L120;
        if (r48 == null) goto L120;
        r49.playTogether(new Animator[]{r40, r44, r45, r47, r126, r48});
    L121:
        AnimatorSet r50 = this.q;
        if (r50 == null) goto L151;
        r50.start();
    L120:
        r49.playTogether(new Animator[]{r40, r44, r45, r47});
        goto L121
    L104:
        r125 = null;
        goto L105
    L100:
        r123 = null;
    L115:
        r48 = null;
        r126 = null;
        goto L116
    L90:
        if (r39.isRunning() != true) goto L95;
        AnimatorSet r51 = this.q;
        if (r51 == null) goto L94;
        r51.end();
    L94:
        ((ViewGroup) r110.getFirst()).setVisibility(8);
        ((BaseGiftMVIViewChildNode) r110.getSecond()).p(8);
        ((ViewGroup) r111.getFirst()).setVisibility(0);
        ((BaseGiftMVIViewChildNode) r111.getSecond()).p(0);
    L151:
        if (s().getVisibility() == 0) goto L153;
    L155:
        boolean r53 = false;
    L156:
        Map<GiftTopViewState.Mode, Pair<ViewGroup, BaseGiftMVIViewChildNode<GiftTopViewState, ?, ?>>> r54 = this.v;
        LinkedHashMap r55 = new LinkedHashMap();
        Iterator r56 = ((LinkedHashMap) r54).entrySet().iterator();
    L158:
        if (r56.hasNext() == false) goto L165;
        Map.Entry r57 = (Map.Entry) r56.next();
        if (((ViewGroup) ((Pair) r57.getValue()).getFirst()).getVisibility() != 0) goto L162;
        boolean r58 = true;
    L163:
        if (r58 == false) goto L158;
        r55.put(r57.getKey(), r57.getValue());
        goto L158
    L162:
        r58 = false;
        goto L163
    L165:
        if (r53 == true) goto L167;
    L168:
        jy0.b.c("ttlive_gift_panel_top", "not top view visible for " + r119 + ", contentVisible=" + r53, null, 4);
    L169:
        r1 = r21;
        r2 = r24;
        goto L170
    L167:
        if (r55.isEmpty() == false) goto L169;
    L153:
        if (this.x.getVisibility() != 0) goto L155;
        r53 = true;
        goto L156
    L127:
        if (r118 == true) goto L129;
    L140:
        Map<GiftTopViewState.Mode, Pair<ViewGroup, BaseGiftMVIViewChildNode<GiftTopViewState, ?, ?>>> r59 = this.v;
        GiftTopViewState.Mode r60 = GiftTopViewState.Mode.Detail;
        Pair r61 = (Pair) ((LinkedHashMap) r59).get(r60);
        if (r61 == null) goto L145;
        ViewGroup r63 = (ViewGroup) r61.getFirst();
        if (r63 == null) goto L145;
        r63.setVisibility(8);
    L145:
        Pair r64 = (Pair) ((LinkedHashMap) this.v).get(r60);
        if (r64 == null) goto L151;
        BaseGiftMVIViewChildNode r65 = (BaseGiftMVIViewChildNode) r64.getSecond();
        if (r65 == null) goto L151;
        r65.p(8);
        goto L151
    L129:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L140;
        Map<GiftTopViewState.Mode, Pair<ViewGroup, BaseGiftMVIViewChildNode<GiftTopViewState, ?, ?>>> r66 = this.v;
        GiftTopViewState.Mode r67 = GiftTopViewState.Mode.Detail;
        Pair r68 = (Pair) ((LinkedHashMap) r66).get(r67);
        if (r68 == null) goto L135;
        ViewGroup r69 = (ViewGroup) r68.getFirst();
        if (r69 == null) goto L135;
        r69.setVisibility(0);
    L135:
        Pair r70 = (Pair) ((LinkedHashMap) this.v).get(r67);
        if (r70 == null) goto L151;
        BaseGiftMVIViewChildNode r71 = (BaseGiftMVIViewChildNode) r70.getSecond();
        if (r71 == null) goto L151;
        r71.p(0);
        goto L151
    L28:
        r18 = null;
        goto L29
    L24:
        r17 = null;
        goto L25
    L20:
        r16 = null;
        goto L21
    }

    public GiftMVITopView(Context r2, ViewGroup r3, ViewGroup r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r2, "currentContext");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.w = r2;
        this.x = r3;
        this.y = r4;
        this.z = r5;
        com.bytedance.android.scope.m.e.getClass();
        q1 r6 = new q1(com.bytedance.android.scope.m.d);
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r2, "value");
        r6.e = r2;
        if (r2 != e33.k.a) goto L5;
        String r7 = "context";
    L6:
        if (r7 != null) goto L10;
        com.bytedance.android.scope.l.a(r6);
        Unit r8 = Unit.INSTANCE;
        this.k = r6;
        this.s = new LinkedHashSet();
        this.u = LazyKt.lazy(new GiftMVITopView$contentView$2(this));
        this.v = new LinkedHashMap();
        return;
    L10:
        throw new UninitializedPropertyAccessException(r7);
    L5:
        r7 = null;
        goto L6
    }
}
