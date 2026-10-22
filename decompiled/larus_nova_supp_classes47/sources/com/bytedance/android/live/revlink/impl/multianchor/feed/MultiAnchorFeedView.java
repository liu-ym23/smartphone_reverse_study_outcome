package com.bytedance.android.live.revlink.impl.multianchor.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.link.player.MultiPlayerScene;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiFeedUtils;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import iq2.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k31.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import qc0.f;
import rc0.d;
import u01.k;
import u01.l;
import u01.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiAnchorFeedView extends FrameLayout implements f {
    public static final /* synthetic */ int j = 0;
    public final Lazy a;
    public final Lazy b;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.a c;
    public String d;
    public IRenderView e;
    public IRoom f;
    public final qc0.a g;
    public boolean h;
    public final int i;

    public static final class a {
    }

    static {
    }

    private final d getMultiPlayerMonitor() {
        return (d) this.b.getValue();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.transfer.b getTransfer() {
        return (com.bytedance.android.live.revlink.impl.multianchor.transfer.b) this.a.getValue();
    }

    public final void a(m r1) {
    }

    public final void b() {
    }

    public final void c() {
    }

    public String getFeedViewName() {
        return "RevMultiAnchorFeedView";
    }

    public qc0.b getIMultiFeedView() {
        return null;
    }

    public qc0.c getIPkFeedView() {
        return null;
    }

    public List<String> getImCacheTags() {
        return null;
    }

    public final Observable<pc0.d> observeFeedViewExposeData() {
        return null;
    }

    public final void onOnlineListChanged() {
    }

    public final void onViewHolderPause() {
    }

    public final void onViewHolderResume() {
    }

    public final void onViewHolderSelected() {
    }

    public final void onViewHolderUnSelected() {
    }

    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
    }

    private final AbsLivePlayerView getPlayerView() {
        IRenderView r0 = this.e;
        ViewParent r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L7:
        if ((r2 instanceof AbsLivePlayerView) == false) goto L11;
        r1 = r2;
    L11:
        return (AbsLivePlayerView) r1;
    L5:
        r2 = null;
        goto L7
    }

    public final boolean g() {
        return vh6.c.b(vr2.b.class).N7(this.i);
    }

    public List<ILinkPlayerInfoBridge> getOnlineList() {
        return new ArrayList();
    }

    public final void reset() {
        ViewParent r2 = null;
        jy0.b.c("MultiAnchorFeedView", "reset", null, 4);
        if (this.h == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.transfer.b r0 = getTransfer();
        Disposable r1 = r0.d;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        r0.d = null;
        AbsLivePlayerView r3 = getPlayerView();
        if (r3 == null) goto L11;
        MultiFeedUtils.b(r3);
    L11:
        AbsLivePlayerView r4 = getPlayerView();
        if (r4 == null) goto L14;
        ViewParent r5 = r4.getParent();
    L16:
        if ((r5 instanceof ViewGroup) == true) goto L18;
        r5 = null;
    L18:
        ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L21;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
    L23:
        if ((r7 instanceof FrameLayout.LayoutParams) == true) goto L25;
        r7 = null;
    L25:
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) r7;
        if (g() == false) goto L63;
        if (r8 == null) goto L30;
        r8.gravity = 17;
    L30:
        if (PadConfigUtils.a() == true) goto L32;
    L43:
        if (r4 == null) goto L45;
        ViewGroup.LayoutParams r9 = r4.getLayoutParams();
    L47:
        if ((r9 instanceof FrameLayout.LayoutParams) == true) goto L49;
        r9 = null;
    L49:
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r9;
        if (r10 == null) goto L52;
        r10.gravity = 17;
    L52:
        if (r8 == null) goto L63;
        if (r4 == null) goto L55;
        ViewParent r12 = r4.getParent();
    L57:
        if ((r12 instanceof ViewGroup) == false) goto L60;
        r2 = r12;
    L60:
        ViewGroup r13 = (ViewGroup) r2;
        if (r13 == null) goto L63;
        r13.setLayoutParams(r8);
        goto L63
    L55:
        r12 = null;
        goto L57
    L45:
        r9 = null;
        goto L47
    L32:
        if (e5.n() == false) goto L43;
        if (r4 == null) goto L38;
        ILivePlayerClient r14 = r4.getClient();
        if (r14 == null) goto L38;
        Pair r15 = r14.getVideoSize();
        if (r15 == null) goto L38;
    L39:
        int r16 = ((Number) r15.component1()).intValue();
        int r17 = ((Number) r15.component2()).intValue();
        if (r17 == 0) goto L43;
        if (r8 == null) goto L43;
        r8.width = (int) ((s1.w() * r16) / r17);
    L38:
        r15 = new Pair(0, 0);
    L63:
        IRenderView r18 = this.e;
        if (r18 == null) goto L66;
        r18.setScaleType(2);
    L66:
        IRenderView r19 = this.e;
        if (r19 == null) goto L69;
        FrameLayout.LayoutParams r20 = new FrameLayout.LayoutParams(-1, -1);
        r20.gravity = 17;
        Unit r22 = Unit.INSTANCE;
        r19.setLayoutParams(r20);
    L69:
        getMultiPlayerMonitor().c();
        this.h = false;
        qc0.a r23 = this.g;
        if (r23 == null) goto L73;
        r23.reset();
        return;
    L73:
        return;
    L21:
        r7 = null;
        goto L23
    L14:
        r5 = null;
        goto L16
    }

    public qc0.a getKtvComponentFeedView() {
        return this.g;
    }

    public final int getShowFrom() {
        return this.i;
    }

    public final void d(l r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        Intrinsics.checkNotNullParameter(r2, "hub");
    }

    public final void e(k r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        Intrinsics.checkNotNullParameter(r2, "caller");
    }

    public final void monitorLayouts(String r5) {
        this.c.getClass();
        if (com.bytedance.android.live.revlink.impl.multianchor.feed.a.a(r5) == true) goto L6;
        return;
    L6:
        if (g() == true) goto L8;
        return;
    L8:
        if (r5 != null) goto L10;
        return;
    L10:
        AbsLivePlayerView r0 = getPlayerView();
        if (r0 != null) goto L13;
        return;
    L13:
        getMultiPlayerMonitor().b(new hs0.b(MultiPlayerScene.PREVIEW_FEED_FULL_SCREEN, r0, r5));
    }

    public final void onSeiUpdatedRaw(String r22) {
        this.c.getClass();
        if (com.bytedance.android.live.revlink.impl.multianchor.feed.a.a(r22) == true) goto L6;
        return;
    L6:
        if (g() == true) goto L8;
        return;
    L8:
        if (r22 != null) goto L10;
        return;
    L10:
        IRoom r1 = this.f;
        if (r1 != null) goto L13;
        return;
    L13:
        AbsLivePlayerView r5 = getPlayerView();
        if (r5 != null) goto L16;
        return;
    L16:
        boolean r6 = !e5.n();
        if (getTransfer().b(r1.getStreamType(), r6) == false) goto L125;
        Intrinsics.checkNotNullParameter(r22, "sei");
        JSONArray r2 = com.bytedance.android.live.revenue.common.player.utils.a.b(r22);
        if (r2 == null) goto L21;
        int r3 = r2.length();
    L23:
        if (r3 < 2) goto L126;
        AbsLivePlayerView r4 = getPlayerView();
        k31.m r12 = null;
        if (r4 != null) goto L29;
    L41:
        boolean r7 = false;
    L52:
        if (r7 == true) goto L54;
        jy0.b.d("MultiAnchorFeedView", "prepare env failed, player = " + r5 + ", player parent = " + r5.getParent() + ", render = " + r5.getRenderView());
        goto L126
    L54:
        int r8 = r5.getWidth();
        int r9 = r5.getHeight();
        ViewParent r10 = r5.getParent();
        if ((r10 instanceof ViewGroup) == true) goto L57;
        r10 = null;
    L57:
        ViewGroup r13 = (ViewGroup) r10;
        if (r13 == null) goto L60;
        r8 = r13.getWidth();
        r9 = r13.getHeight();
    L60:
        ViewParent r14 = r5.getParent();
        if (r14 == null) goto L63;
        ViewParent r15 = r14.getParent();
    L65:
        if ((r15 instanceof ViewGroup) == true) goto L67;
        r15 = null;
    L67:
        ViewGroup r16 = (ViewGroup) r15;
        if (r16 == null) goto L71;
        r8 = r16.getWidth();
        r9 = r16.getHeight();
    L71:
        if (g() == false) goto L86;
        r8 = s1.y();
        if (g() == true) goto L75;
    L77:
        boolean r17 = false;
    L78:
        if (r17 == false) goto L80;
        Context r18 = getContext();
        int r19 = s1.A();
        Intrinsics.checkNotNullParameter(r18, "context");
        b03.a r20 = b03.a.a;
        r9 = b03.c.a(r18, r6, r19);
    L81:
        if (r9 <= r8) goto L83;
        boolean r23 = true;
    L84:
        if (r6 == r23) goto L86;
        int r24 = r8;
    L87:
        IRoom r25 = this.f;
        if (r25 == null) goto L100;
        boolean r26 = g();
        LiveMode r27 = r25.getStreamType();
        if (g() == true) goto L93;
    L95:
        boolean r28 = false;
    L96:
        if (r28 == false) goto L98;
        boolean r29 = false;
    L99:
        r12 = new k31.m(r9, r24, r26, r5, r6, r27, r22, null, new k31.k(r29, s1.A()), new k31.a(null, null), false);
        goto L100
    L98:
        r29 = p.c(r6, p.b(getContext()), false);
        goto L99
    L93:
        if (rc0.b.a() != DeviceType.NORMAL_MOBILE) goto L95;
        r28 = true;
    L100:
        if (r12 == null) goto L122;
        getTransfer().a(r12);
        k31.c r30 = getTransfer().c;
        if (r30 == null) goto L122;
        LocalTestManager.a(new Class[]{wy.a.class});
        k31.f r32 = r12.h;
        if (r32 == null) goto L115;
        p0 r33 = r32.b;
        if (r33 == null) goto L115;
        m0 r34 = r33.f();
        if (r34 == null) goto L115;
        if (r34.c() != UILayout.FULL.ordinal()) goto L115;
        AbsLivePlayerView r35 = getPlayerView();
        if (r35 == null) goto L122;
        MultiFeedUtils.b(r35);
    L115:
        View r110 = r12.d;
        if ((r110 instanceof AbsLivePlayerView) == true) goto L118;
        r110 = null;
    L118:
        AbsLivePlayerView r36 = (AbsLivePlayerView) r110;
        if (r36 == null) goto L122;
        int r37 = MultiFeedUtils.a;
        Intrinsics.checkNotNullParameter(r36, "playerView");
        Intrinsics.checkNotNullParameter(r30, "coreLayout");
        int r38 = r30.c;
        int r39 = r38 + r30.b;
        MultiFeedUtils.ViewIndex r40 = MultiFeedUtils.ViewIndex.INDEX_FRONT;
        Intrinsics.checkNotNullParameter(r36, "container");
        Intrinsics.checkNotNullParameter(r40, "index");
        d51.c r42 = d51.c.A0;
        MultiFeedUtils.e(r36, r38, r39, r40, r42.k(), r42.j());
    L122:
        if (this.h == true) goto L124;
        getMultiPlayerMonitor().a();
        this.h = true;
    L124:
        jy0.b.c("MultiAnchorFeedView", "seiUpdate", null, 4);
        goto L126
    L83:
        r23 = false;
        goto L84
    L80:
        r9 = p.a(getContext(), r6, false);
        goto L81
    L75:
        if (rc0.b.a() != DeviceType.NORMAL_MOBILE) goto L77;
        r17 = true;
    L86:
        r24 = r9;
        r9 = r8;
        goto L87
    L63:
        r15 = null;
        goto L65
    L29:
        if (g() == false) goto L49;
        ViewParent r43 = r4.getParent();
        if ((r43 instanceof ViewGroup) == true) goto L33;
        r43 = null;
    L33:
        ViewGroup.LayoutParams r44 = f((ViewGroup) r43, null);
        if (r44 == null) goto L41;
        ViewGroup.LayoutParams r45 = f(r4, null);
        if (r45 == null) goto L41;
        ViewGroup.LayoutParams r46 = f(null, r4);
        if (r46 == null) goto L41;
        ViewParent r47 = r4.getParent();
        if ((r47 instanceof ViewGroup) == true) goto L45;
        r47 = null;
    L45:
        ViewGroup r48 = (ViewGroup) r47;
        if (r48 == null) goto L48;
        r48.setLayoutParams(r44);
    L48:
        r4.setLayoutParams(r45);
        r4.getRenderView().setLayoutParams(r46);
    L50:
        r7 = true;
        goto L52
    L49:
        r4.getRenderView().setLayoutParams(f(null, r4));
    L126:
        this.d = r22;
        return;
    L21:
        r3 = 0;
        goto L23
    L125:
        reset();
        goto L126
    }

    public final void putImCacheContent(Map<String, ? extends RevImCacheUnit> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
    }

    public final void sendMessage(List<? extends yh6.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgList");
        Intrinsics.checkNotNullParameter(r2, "msgList");
    }

    public void setJsBridgeMap(Map<String, ? extends com.bytedance.ies.web.jsbridge2.f.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
    }

    public void setLivePlayerView(Object r2) {
        if ((r2 instanceof IRenderView) == true) goto L5;
        r2 = null;
    L5:
        this.e = (IRenderView) r2;
        String r3 = this.d;
        if (r3 == null) goto L9;
        onSeiUpdatedRaw(r3);
        return;
    }

    public final void updateRoom(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        this.f = r2;
        qc0.a r0 = this.g;
        if (r0 == null) goto L6;
        r0.updateRoom(r2);
        return;
    }

    public MultiAnchorFeedView(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.i = r4;
        this.a = LazyKt.lazy(new MultiAnchorFeedView$transfer$2(this));
        this.b = LazyKt.lazy(MultiAnchorFeedView$multiPlayerMonitor$2.INSTANCE);
        this.c = new com.bytedance.android.live.revlink.impl.multianchor.feed.a();
        e r5 = vh6.c.b(er2.b.class).getKtvComponentFeedViewService();
        if (r5 == null) goto L5;
        iq2.d r6 = r5.a();
    L6:
        this.g = r6;
        if (r6 == null) goto L10;
        r6.setAttachParent(this, new FrameLayout.LayoutParams(-1, -2));
        return;
    L10:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static ViewGroup.LayoutParams f(View r2, AbsLivePlayerView r3) {
        if (r3 != null) goto L8;
        if (r2 == null) goto L6;
        r3 = r2.getParent();
        goto L8
    L6:
        r3 = null;
    L8:
        if ((r3 instanceof FrameLayout) == false) goto L12;
        return new FrameLayout.LayoutParams(-1, -1);
    L12:
        if ((r3 instanceof RelativeLayout) == true) goto L14;
        return null;
    L14:
        return new RelativeLayout.LayoutParams(-1, -1);
    }
}
