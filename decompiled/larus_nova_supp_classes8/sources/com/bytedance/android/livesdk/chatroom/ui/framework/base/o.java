package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.platformplayer.model.VideoRenderViewParams;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.castscreen.views.bytecast.LiveCastControlLayout;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.widget.SlideGuideView;
import com.bytedance.android.livesdk.chatroom.wornhole.PreloadInteractionViewManager;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.config.a1;
import com.bytedance.android.livesdk.config.nq;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.preinflate.LiveNitaViewInfo;
import com.bytedance.android.livesdk.utils.LiveInflateUtil;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o extends i implements com.bytedance.android.livesdk.chatroom.ui.framework.d {
    public Map<f70.b, ViewGroup> b;
    public View c;
    public View d;
    public com.bytedance.android.livesdk.chatroom.widget.landscape.r e;
    public int f;
    public int g;
    public p h;
    public InteractionWidgetsPosContext i;
    public Disposable j;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View A8() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131378275);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View B9() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131380026);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View Bc() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131368021);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final LinearLayout C6() {
        View r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (LinearLayout) r0.findViewById(2131392867);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View Co() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131373341);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View Dj() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131363437);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final int En() {
        View r0 = this.c;
        if (r0 == null) goto L5;
        int r1 = r0.getHeight();
    L6:
        int r2 = this.f;
        if (r2 <= 0) goto L9;
        int r3 = r2;
    L10:
        if (r2 != r1) goto L12;
    L14:
        r1 = r3;
    L15:
        if (r1 > 0) goto L18;
        int r4 = UIUtils.getScreenHeight(getContext().q.getContext());
        ALogger.w("AbsInteractionFragment.adjustTextMessage", "failed to obtain iaHeight");
        return r4;
    L18:
        return r1;
    L12:
        if (r1 <= s1.f(200.0f)) goto L14;
        this.f = r1;
        goto L15
    L9:
        r3 = r1;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View Eo() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131382347);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View Fj() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131372516);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View Ia() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131383618);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final AnchorPauseTipsView J7() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (AnchorPauseTipsView) r0.findViewById(2131362592);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final ViewGroup M7() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ViewGroup) r0.findViewById(2131362579);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final LottieAnimationView Oc() {
        View r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131392866);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final HSImageView Tb() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131364116);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final LiveCastControlLayout Vo() {
        View r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131365271);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final ViewGroup Wa() {
        Map<f70.b, ViewGroup> r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(mg2.e.d);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View Wn() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131386039);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final ViewGroup Yh() {
        Map<f70.b, ViewGroup> r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(mg2.e.c);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View b6() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131392393);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View b8() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131392509);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final ViewGroup bg() {
        Map<f70.b, ViewGroup> r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(mg2.e.e);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View c6() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131380990);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final int c9() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getHeight();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final TextView ch() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (TextView) r0.findViewById(2131362577);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View de() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131374354);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void f() {
        int r2 = 0;
        if (com.bytedance.android.livesdk.summer.i.a == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L14;
        Object r1 = com.bytedance.android.livesdk.summer.a.b.lookup(com.bytedance.android.livesdk.summer.i.d, Pair.class, InteractionLayoutManager$initWidgetYPosContext$contextPair$1.INSTANCE);
        if (r1 == null) goto L13;
        Pair r3 = (Pair) r1;
    L15:
        this.i = (InteractionWidgetsPosContext) r3.getFirst();
        this.j = (Disposable) r3.getSecond();
        InteractionWidgetsPosContext r4 = this.i;
        if (r4 == null) goto L22;
        r4.share(getContext().b(), getContext().c().getRoomId());
        int r5 = y.a;
        y.a(getContext().b(), (CompositeDisposable) getContext().d().getCompositeDisposable().getValue(), "InteractionLayoutManager#ctxshare()", new r(r4));
        StringBuilder r6 = new StringBuilder("CreateRoomContext this=");
        r6.append(hashCode());
        r6.append(" context=");
        InteractionWidgetsPosContext r7 = this.i;
        if (r7 == null) goto L20;
        r2 = r7.hashCode();
    L20:
        r6.append(r2);
        ALogger.i("LiveRoomLayoutManager", r6.toString());
    L22:
        if ((!getContext().r) == false) goto L34;
        if (nq.a.getValue().booleanValue() == false) goto L34;
        this.g = x1.j(getContext().q.getContext());
        if (this.h != null) goto L28;
        this.h = new p(this);
    L28:
        View r8 = this.c;
        if (r8 == null) goto L34;
        ViewTreeObserver r9 = r8.getViewTreeObserver();
        if (r9 == null) goto L34;
        r9.addOnGlobalLayoutListener(this.h);
    L34:
        if (getContext().r == true) goto L36;
        return;
    L36:
        if ((!getContext().a) == true) goto L38;
        return;
    L38:
        if (a1.a.getValue().booleanValue() == true) goto L52;
        RoomSpecificSceneTypeInfo r10 = getContext().c().getSceneTypeInfo();
        if (r10 != null) goto L42;
        return;
    L42:
        if (r10.isCommentaryRoom() != true) goto L54;
        View r11 = this.d;
        if (r11 == null) goto L55;
        View r12 = r11.findViewById(2131365275);
        if (r12 == null) goto L56;
        new VideoRenderViewParams(getContext().b()).a.observe(getContext().q, new q(this, r12));
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L52:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Pair<com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext, io.reactivex.disposables.Disposable>");
    L14:
        r3 = com.bytedance.live.datacontext.d.a(InteractionLayoutManager$initWidgetYPosContext$contextPair$2.INSTANCE);
        goto L15
    L5:
        if (com.bytedance.android.livesdk.summer.i.c == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View fj() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131364417);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View fp() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131381836);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View g8() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131392510);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final TextView gp() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (TextView) r0.findViewById(2131372517);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View in() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131362177);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View ln() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131378191);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View n6() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131377137);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final ViewGroup nn() {
        Map<f70.b, ViewGroup> r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(mg2.e.b);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final GestureDetectLayout oh() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131381934);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void onDestroy() {
        p r0 = this.h;
        if (r0 == null) goto L9;
        View r1 = this.c;
        if (r1 == null) goto L9;
        ViewTreeObserver r2 = r1.getViewTreeObserver();
        if (r2 == null) goto L9;
        r2.removeOnGlobalLayoutListener(r0);
    L9:
        StringBuilder r3 = new StringBuilder("DisposeRoomContext this=");
        r3.append(hashCode());
        r3.append(" context=");
        InteractionWidgetsPosContext r4 = this.i;
        if (r4 == null) goto L12;
        int r5 = r4.hashCode();
    L13:
        r3.append(r5);
        ALogger.i("LiveRoomLayoutManager", r3.toString());
        Disposable r6 = this.j;
        if (r6 == null) goto L16;
        r6.dispose();
    L16:
        this.j = null;
        this.i = null;
        this.c = null;
        this.d = null;
        if (this.e == null) goto L19;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r.a();
    L19:
        this.e = null;
        Map<f70.b, ViewGroup> r7 = this.b;
        if (r7 == null) goto L22;
        ((LinkedHashMap) r7).clear();
    L22:
        this.b = null;
        e0 r8 = getContext().d;
        if (r8 == null) goto L26;
        ho1.a.q(r8, com.bytedance.android.livesdk.chatroom.ui.framework.d.class);
        return;
    L26:
        return;
    L12:
        r5 = 0;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View r7() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131376921);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final FrameLayout va() {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (FrameLayout) r0.findViewById(2131364575);
    }

    public o() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View Fo() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final InteractionWidgetsPosContext Om() {
        return this.i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final View getRootView() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final com.bytedance.android.livesdk.chatroom.widget.landscape.r sl() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final void af(SlideGuideView r2) {
        ViewGroup r0 = (ViewGroup) this.c;
        if (r0 == null) goto L6;
        r0.addView(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final void bk(SlideGuideView r2) {
        if (r2 == null) goto L7;
        ViewGroup r0 = (ViewGroup) this.c;
        if (r0 == null) goto L8;
        r0.removeView(r2);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void g(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        if (PadConfigUtils.c() == false) goto L6;
        this.f = 0;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.d
    public final ViewGroup zb(f70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        Map<f70.b, ViewGroup> r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void r(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        View r10 = this.c;
        if (r10 == null) goto L11;
        LinkedHashMap r0 = new LinkedHashMap();
        if ((!getContext().r) == false) goto L8;
        r0.put(mg2.e.a, r10.findViewById(2131393417));
        r0.put(mg2.e.b, r10.findViewById(2131372593));
        r0.put(mg2.e.c, r10.findViewById(2131373130));
        r0.put(mg2.e.d, r10.findViewById(2131375551));
        r0.put(mg2.e.e, r10.findViewById(2131378328));
        r0.put(mg2.e.f, r10.findViewById(2131373003));
        r0.put(mg2.e.g, (ViewGroup) r10);
    L9:
        this.b = r0;
        goto L11
    L8:
        r0.put(mg2.e.a, r10.findViewById(2131367832));
        r0.put(mg2.e.b, r10.findViewById(2131368635));
        r0.put(mg2.e.c, r10.findViewById(2131373130));
        r0.put(mg2.e.d, r10.findViewById(2131375551));
        r0.put(mg2.e.e, r10.findViewById(2131378328));
        r0.put(mg2.e.f, r10.findViewById(2131373003));
        r0.put(mg2.e.g, (ViewGroup) r10);
    L11:
        if (LocalTestManager.b(new Class[]{wy.a.class}) == false) goto L18;
        View r11 = this.c;
        if ((r11 instanceof ViewGroup) == true) goto L15;
        r11 = null;
    L15:
        ViewGroup r12 = (ViewGroup) r11;
        if (r12 == null) goto L18;
        TextView r1 = new TextView(r12.getContext());
        r1.setText("NEW");
        r1.setTextSize(1, 12.0f);
        r1.setTextColor(ColorProtector.parseColor("#50CC7F"));
        r1.setBackgroundColor(ColorProtector.parseColor("#0050CC7F"));
        r1.setLayoutParams(new FrameLayout.LayoutParams(s1.f(30.0f), s1.f(15.0f), 80));
        r12.addView(r1);
    L18:
        e0 r13 = getContext().d;
        if (r13 == null) goto L22;
        ho1.a.p(r13, com.bytedance.android.livesdk.chatroom.ui.framework.d.class, this);
        return;
    }

    public final View s(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        if ((!getContext().r) == false) goto L7;
        View r7 = LayoutInflater.from(getContext().q.getContext()).inflate(2131566037, r6, false);
        this.c = r7;
        this.d = r7;
        return r7;
    L7:
        if (getContext().r == false) goto L13;
        if (getContext().a == false) goto L13;
        PreloadInteractionViewManager r8 = PreloadInteractionViewManager.d;
        Context r0 = getContext().q.requireContext();
        r8.getClass();
        View r9 = PreloadInteractionViewManager.c(r0, r6);
        this.c = r9;
        this.d = r9;
        return r9;
    L13:
        if (getContext().r == true) goto L15;
    L22:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("create view: [AudiencePortrait]");
        PreloadInteractionViewManager r10 = PreloadInteractionViewManager.d;
        Context r1 = getContext().q.requireContext();
        r10.getClass();
        View r11 = PreloadInteractionViewManager.c(r1, r6);
        this.c = r11;
        this.d = r11;
        return r11;
    L15:
        if ((!getContext().a) == false) goto L22;
        com.bytedance.android.livesdk.castscreen.utils.f.b("landscape_interaction_show", getContext().b(), getContext().c(), null);
        if (com.bytedance.android.livesdk.utils.landscape.e.b(false, getContext().c()) == false) goto L20;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("create view: [AudienceSplitLandscape]");
        LiveNitaViewInfo r12 = LiveNitaViewInfo.TTLIVE_FRAGMENT_LANDSCAPE_INTERACTION;
        Activity r2 = getContext().getActivity();
        Intrinsics.checkNotNull(r2);
        View r13 = LiveInflateUtil.b("AudienceLandscapeInteractionFragment", r12, r2, r6);
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r14 = new com.bytedance.android.livesdk.chatroom.widget.landscape.r(r13);
        r14.g();
        View r3 = r14.a;
        this.c = r3;
        this.d = r13;
        this.e = r14;
        return r3;
    L20:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("create view: [AudienceNormalLandscape]");
        LiveNitaViewInfo r15 = LiveNitaViewInfo.TTLIVE_FRAGMENT_LANDSCAPE_INTERACTION;
        Activity r4 = getContext().getActivity();
        Intrinsics.checkNotNull(r4);
        View r16 = LiveInflateUtil.b("AudienceLandscapeInteractionFragment", r15, r4, r6);
        this.c = r16;
        this.d = r16;
        return r16;
    }
}
