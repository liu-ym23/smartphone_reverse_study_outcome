package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.AnchorRtcLinkerContext;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.base.h;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h0;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.revenue.PaidLinkMicPlayModeHandler;
import com.bytedance.android.live.liveinteract.plantform.utils.AnchorParamChangeListener;
import com.bytedance.android.live.liveinteract.plantform.utils.n0;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.d1;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import uf2.z;
import zf2.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/MultiLinkBaseAnchorLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/base/h;", "T", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "", "Lcom/bytedance/android/live/liveinteract/plantform/base/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class MultiLinkBaseAnchorLinkWidget<T extends com.bytedance.android.live.liveinteract.plantform.base.h> extends PlatformMultiLinkWidget implements com.bytedance.android.live.liveinteract.plantform.core.k, gg6.c, hg6.j, hg6.o, gg6.b, hg6.l, hg6.d, hg6.k, yb6.b, com.bytedance.android.live.liveinteract.plantform.base.a {
    public IRoom a;
    public y b;
    public com.bytedance.android.live.liveinteract.plantform.datamergev2.l c;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.d d;
    public eh0.b e;
    public eh0.b f;
    public int g;
    public String h;
    public AnchorParamChangeListener i;
    public final HashMap<Long, Long> j;
    public final HashMap<String, Long> k;
    public String l;
    public final CompositeDisposable m;
    public boolean n;
    public final tf0.i o;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MultiLinkBaseAnchorLinkWidget a;

        public a(MultiLinkBaseAnchorLinkWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            d1 r4 = (d1) ((com.bytedance.android.live.network.response.e) r3).data;
            if (r4 == null) goto L20;
            List r5 = r4.getEntranceList();
            if (r5 == null) goto L21;
            y r0 = this.a.xq();
            if (r0 == null) goto L19;
            List<ILinkmicInteractEntrance> r1 = r0.D;
            if (r1 == null) goto L11;
            ((ArrayList) r1).clear();
        L11:
            y r2 = this.a.xq();
            if (r2 == null) goto L17;
            List<ILinkmicInteractEntrance> r6 = r2.D;
            if (r6 == null) goto L22;
            ArrayList r7 = (ArrayList) r6;
            r7.addAll(r5);
            return;
        L22:
            return;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.core.LinkUserInfoCenterV2");
        L19:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.core.LinkUserInfoCenterV2");
        L21:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            r3.printStackTrace();
        }
    }

    public abstract int Aq();

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void D1(String r1, ByteBuffer r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void G9(long r1, Exception r3) {
    }

    public void H1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void J(String[] r1, boolean[] r2, int[] r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void Lb() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void M1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void R(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void S(String r1, int r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void T6(String r1, s0 r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void V4(String r1, z.a r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void Xi(int r1, int r2) {
    }

    public final void Y4() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void al(String r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void ci() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void f0(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void f1(long r1, long r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f4() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h6(int r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void ip(Object r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void j0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void k1() {
    }

    public final void l0(Throwable r1) {
    }

    public void m0(Throwable r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o0(long r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.t
    public final void p2(fi6.a r1) {
    }

    public final void s1() {
    }

    public final void t1() {
    }

    public void u0() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void wf(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wk(String r1) {
    }

    public abstract y xq();

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void y0(String r1, SurfaceView r2, int r3, int r4) {
    }

    public void yi() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void z7() {
    }

    public IRoom getMRoom() {
        IRoom r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L5:
        return r0;
    }

    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d md() {
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L5:
        return r0;
    }

    public final rf6.a wq() {
        qf6.a r0 = getScopeServiceOrNullInMultiLinkRoom(qf6.a.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ob();
    }

    public final y yq() {
        y r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoCenter");
    L5:
        return r0;
    }

    public final cg6.a zq() {
        return getScopeServiceInMultiLinkRoom(cg6.a.class);
    }

    public final jg6.a Bq() {
        return zq().e5();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.a
    public final hg6.g R1() {
        return zq().getRtcManager();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        super.onCreate();
        Eq("onCreate");
        com.bytedance.live.bizlink.impl.platform.manager.a r0 = zq().A0();
        if (r0 == null) goto L5;
        r0.c(this);
    L5:
        Fq((IRoom) ((Widget) this).dataCenter.get("data_room", vh7.f.c(IRoom.class)));
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r7 = null;
        eh0.b r8 = null;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L22;
        int r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r2 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r2 == null) goto L10;
        y r3 = r2.getLinkUserCenter();
    L11:
        if (r3 == null) goto L22;
        if (getScene() == 9) goto L22;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r4 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r4 == null) goto L17;
        y r5 = r4.getLinkUserCenter();
    L18:
        if (r5 == null) goto L21;
    L23:
        this.b = r5;
        xq().i();
        if (vm2.d.a() == true) goto L30;
        pc0.e r6 = jc1.k.n(IMultiLinkServiceExternal.class).createRevRtcData();
        if (r6 == null) goto L30;
        hg6.g r9 = R1();
        if (r9 == null) goto L30;
        r9.d0(r6.b);
    L30:
        this.g = Aq();
        AnchorParamChangeListener r10 = new AnchorParamChangeListener(R1());
        this.i = r10;
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L33;
        r11.observeForever("data_interact_anchor_param_change", r10);
    L33:
        Pair r12 = com.bytedance.live.datacontext.d.a(MultiLinkBaseAnchorLinkWidget$onCreate$pair$1.INSTANCE);
        ((AnchorRtcLinkerContext) r12.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r12.getFirst(), "rtc_anchor_linker_service");
        this.m.add((Disposable) r12.getSecond());
        if (MultiLinkLoadWidgetUtils.g() == false) goto L55;
        int r13 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r14 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r14 == null) goto L38;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r15 = r14.md();
    L39:
        if (r15 == null) goto L55;
        if (getScene() == 9) goto L55;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r16 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r16 == null) goto L45;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r17 = r16.md();
    L46:
        Intrinsics.checkNotNull(r17);
        this.d = r17;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r18 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r18 == null) goto L49;
        eh0.b r19 = r18.p5();
    L50:
        Intrinsics.checkNotNull(r19);
        this.e = r19;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r20 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r20 == null) goto L53;
        r8 = r20.Y3();
    L53:
        Intrinsics.checkNotNull(r8);
        this.f = r8;
        return;
    L49:
        r19 = null;
        goto L50
    L45:
        r17 = null;
        goto L46
    L38:
        r15 = null;
    L55:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == false) goto L63;
        y r110 = xq();
        hg6.g r111 = R1();
        Intrinsics.checkNotNull(r111);
        this.c = new com.bytedance.android.live.liveinteract.plantform.datamergev2.l(r110, getMRoom(), ((Widget) this).dataCenter, this);
        this.d = new com.bytedance.android.live.liveinteract.plantform.datamergev2.h(this, this.c, new we0.a(), r111, 0, ((Widget) this).dataCenter, this);
        this.e = new com.bytedance.android.live.liveinteract.plantform.datamergev2.f(this, r111, ((Widget) this).dataCenter, 0, this.c);
        this.f = new com.bytedance.android.live.liveinteract.plantform.datamergev2.e(this, r110, r111, ((Widget) this).dataCenter, 0, this.c);
        Pair r21 = com.bytedance.live.datacontext.d.a(MultiLinkBaseAnchorLinkWidget$initLinkUserDataMergeCenterV2$pair$1.INSTANCE);
        LinkUserDataMergeContext r22 = (LinkUserDataMergeContext) r21.getFirst();
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.d> r23 = r22.getDataMergeCenter();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r24 = this.d;
        if (r24 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L59:
        r23.d(r24);
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.b> r25 = r22.getLinkRoomFightDataMergeCenter();
        eh0.b r26 = this.e;
        if (r26 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L62:
        r25.d(r26);
        r22.share(((Widget) this).dataCenter);
        this.m.add((Disposable) r21.getSecond());
        ((Widget) this).dataCenter.put("data_multi_link_data_merge_center_init", Boolean.TRUE);
        return;
    L63:
        y r112 = xq();
        hg6.g r113 = R1();
        Intrinsics.checkNotNull(r113);
        this.d = new com.bytedance.android.live.liveinteract.plantform.datamerge.j(this, r112, new we0.a(), r113, this, ((Widget) this).dataCenter);
        this.e = new com.bytedance.android.live.liveinteract.plantform.datamerge.h(this, r112, r113, ((Widget) this).dataCenter);
        this.f = new com.bytedance.android.live.liveinteract.plantform.datamerge.e(this, r112, r113, ((Widget) this).dataCenter);
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d r27 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r28 = this.d;
        if (r28 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L67:
        if ((r28 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == false) goto L70;
        r7 = r28;
    L70:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r29 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r7;
        if (r29 == null) goto L73;
        r29.M0(r27);
    L73:
        Pair r30 = com.bytedance.live.datacontext.d.a(MultiLinkBaseAnchorLinkWidget$initLinkUserDataMergeCenter$pair$1.INSTANCE);
        LinkUserDataMergeContext r31 = (LinkUserDataMergeContext) r30.getFirst();
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.d> r32 = r31.getDataMergeCenter();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r33 = this.d;
        if (r33 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L76:
        r32.d(r33);
        r31.getDynamicHandler().d(r27);
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.b> r34 = r31.getLinkRoomFightDataMergeCenter();
        eh0.b r35 = this.e;
        if (r35 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L79:
        r34.d(r35);
        r31.share(((Widget) this).dataCenter);
        this.m.add((Disposable) r30.getSecond());
        DataCenter r36 = ((Widget) this).dataCenter;
        if (r36 == null) goto L85;
        r36.put("data_multi_link_data_merge_center_init", Boolean.TRUE);
        return;
    L85:
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.core.LinkUserInfoCenterV2");
    L17:
        r5 = null;
        goto L18
    L10:
        r3 = null;
    L22:
        r5 = new y(getMRoom(), ((Widget) this).dataCenter);
        goto L23
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        super.onDestroy();
        Eq("onDestroy");
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L7;
        com.bytedance.live.bizlink.impl.platform.manager.a r1 = r0.A0();
        if (r1 == null) goto L7;
        r1.l(this);
    L7:
        cg6.a r2 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r2 == null) goto L12;
        hg6.g r3 = r2.getRtcManager();
        if (r3 == null) goto L12;
        r3.Z(this);
    L12:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L15;
        r4.removeObserver(this.i);
    L15:
        xq().l();
        this.m.dispose();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r5 = this.d;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L18:
        r5.detach();
        eh0.b r6 = this.e;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L21:
        r6.detach();
        eh0.b r7 = this.f;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("linkCrossRoomGameDataMergeCenter");
    L24:
        r7.detach();
        tc0.c.h().j(Boolean.FALSE);
    }

    public void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public void onStart() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStart();
        if (this.n == true) goto L156;
        this.n = true;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L13;
        if (getScene() == 9) goto L13;
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r1 == null) goto L153;
        r1.N1(R1());
        return;
    L153:
        return;
    L13:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == false) goto L45;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r2 = this.d;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L17:
        r2.O1();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r3 = this.d;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L20:
        r3.g1(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.f());
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r4 = this.d;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L23:
        r4.g1(new h0(true, ((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r5 = this.d;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L26:
        r5.g1(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.n());
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r6 = this.d;
        if (r6 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L29:
        r6.M0(new fh0.b(((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r7 = this.d;
        if (r7 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L32:
        r7.M0(new fh0.a(xq(), ((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r8 = this.d;
        if (r8 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L35:
        r8.M0(new PaidLinkMicPlayModeHandler(this, xq(), ((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r9 = this.d;
        if (r9 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L38:
        hg6.g r10 = R1();
        Intrinsics.checkNotNull(r10);
        r9.M0(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.l(r10, true));
        eh0.b r11 = this.e;
        if (r11 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L41:
        r11.O1();
        eh0.b r12 = this.f;
        if (r12 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("linkCrossRoomGameDataMergeCenter");
    L44:
        r12.O1();
        return;
    L45:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r13 = this.d;
        if (r13 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L48:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r14 = null;
        if ((r13 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L51;
        r13 = null;
    L51:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r15 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r13;
        if (r15 == null) goto L54;
        r15.O1();
    L54:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r16 = this.d;
        if (r16 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L58:
        if ((r16 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L60;
        r16 = null;
    L60:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r17 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r16;
        if (r17 == null) goto L63;
        r17.g1(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.f());
    L63:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r18 = this.d;
        if (r18 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L67:
        if ((r18 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L69;
        r18 = null;
    L69:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r19 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r18;
        if (r19 == null) goto L72;
        r19.g1(new h0(true, ((Widget) this).dataCenter));
    L72:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r20 = this.d;
        if (r20 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L76:
        if ((r20 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L78;
        r20 = null;
    L78:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r21 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r20;
        if (r21 == null) goto L81;
        r21.g1(new fh0.e(((Widget) this).dataCenter, this.g));
    L81:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r22 = this.d;
        if (r22 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L85:
        if ((r22 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L87;
        r22 = null;
    L87:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r23 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r22;
        if (r23 == null) goto L90;
        r23.g1(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.n());
    L90:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r24 = this.d;
        if (r24 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L94:
        if ((r24 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L96;
        r24 = null;
    L96:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r25 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r24;
        if (r25 == null) goto L99;
        r25.M0(new fh0.b(((Widget) this).dataCenter));
    L99:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r26 = this.d;
        if (r26 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L103:
        if ((r26 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L105;
        r26 = null;
    L105:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r27 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r26;
        if (r27 == null) goto L108;
        r27.M0(new fh0.a(xq(), ((Widget) this).dataCenter));
    L108:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r28 = this.d;
        if (r28 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L112:
        if ((r28 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L114;
        r28 = null;
    L114:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r29 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r28;
        if (r29 == null) goto L117;
        r29.M0(new fh0.f(((Widget) this).dataCenter));
    L117:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r30 = this.d;
        if (r30 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L121:
        if ((r30 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L123;
        r30 = null;
    L123:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r31 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r30;
        if (r31 == null) goto L126;
        r31.M0(new fh0.d(((Widget) this).dataCenter));
    L126:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r32 = this.d;
        if (r32 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L130:
        if ((r32 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L132;
        r32 = null;
    L132:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r33 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r32;
        if (r33 == null) goto L135;
        r33.M0(new PaidLinkMicPlayModeHandler(this, xq(), ((Widget) this).dataCenter));
    L135:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r34 = this.d;
        if (r34 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L139:
        if ((r34 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == false) goto L142;
        r14 = r34;
    L142:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r35 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r14;
        if (r35 == null) goto L145;
        hg6.g r36 = R1();
        Intrinsics.checkNotNull(r36);
        r35.M0(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.l(r36, true));
    L145:
        eh0.b r37 = this.e;
        if (r37 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L148:
        r37.O1();
        eh0.b r38 = this.f;
        if (r38 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("linkCrossRoomGameDataMergeCenter");
    L151:
        r38.O1();
        return;
    }

    public MultiLinkBaseAnchorLinkWidget(tc0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "dataHolder");
        this.o = r2;
        this.h = "";
        new ArrayList();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = "";
        this.m = new CompositeDisposable();
    }

    private final void Cq(String r8) {
        IBaseUser r9 = xq().U4(r8);
        if (r9 == null) goto L18;
        String r10 = r9.getIdString();
        if (r10 == null) goto L19;
        long r0 = System.currentTimeMillis();
        Long r2 = this.j.get(StringsKt.toLongOrNull(r10));
        if (r2 == null) goto L16;
        long r3 = r2.longValue();
        if (r3 <= 0) goto L11;
        long r1 = r0 - r3;
        x.B(getScene(), r1);
    L11:
        HashMap<Long, Long> r4 = this.j;
        Long r5 = StringsKt.toLongOrNull(r10);
        if (r4 == null) goto L15;
        Long r6 = (Long) TypeIntrinsics.asMutableMap(r4).remove(r5);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L16:
        this.h = r10;
        Long r11 = (Long) tc0.c.h().t.remove(this.h);
        return;
    L19:
        return;
    }

    private final void Eq(String r6) {
        bn0.b r0 = getMultiLinkRoomScope();
        if (r0 != null) goto L5;
    L6:
        HashMap r1 = new HashMap();
        if (getMultiLinkRoomScope() != null) goto L9;
        String r2 = "scope_null";
    L11:
        if (getScopeServiceOrNullInMultiLinkRoom(cg6.a.class) != null) goto L13;
        boolean r3 = true;
    L14:
        r1.put("error_type", r2);
        r1.put("get_scope_is_null", String.valueOf(r3));
        r1.put("source", r6);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.b0(r1);
        StringBuilder r4 = new StringBuilder();
        r4.append(r6);
        r4.append(": call in room[");
        com.bytedance.live.datacontext.m r7 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r7 == null) goto L19;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L19;
        Long r9 = Long.valueOf(r8.getRoomId());
    L20:
        r4.append(r9);
        r4.append("] error: ");
        r4.append(r2);
        r4.append(" getScopeIsNull: ");
        r4.append(r3);
        r4.append(", stack = ");
        r4.append(Log.getStackTraceString(new Exception(r2)));
        ALogger.e("MultiLinkBaseAnchorLinkWidget", r4.toString());
        return;
    L19:
        r9 = null;
        goto L20
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = "service_null";
        goto L11
    L5:
        if (com.bytedance.android.scope.m.e.d(r0, cg6.a.class) == null) goto L6;
    }

    public void Fq(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void L(String r9) {
        IBaseUser r10 = xq().U4(r9);
        if (r10 == null) goto L13;
        String r11 = r10.getIdString();
        if (r11 == null) goto L14;
        long r0 = System.currentTimeMillis();
        Long r2 = this.k.get(r11);
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.longValue() <= 0) goto L11;
        long r1 = r0 - r2.longValue();
        com.bytedance.android.live.liveinteract.api.utils.n.u(getScene(), r1, this.l);
    L11:
        this.k.remove(r11);
        this.l = "";
        return;
    L14:
        return;
    }

    public void M4(cc6.b r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public void bd(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    public void be(ExtraResponse<? extends IJoinChannelResult, Extra> r8) {
        Intrinsics.checkNotNullParameter(r8, "response");
        com.bytedance.android.live.liveinteract.plantform.utils.k.a(((Widget) this).context, this.o.getScene());
        ((ObservableSubscribeProxy) ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).fetchInteractEntrances(getMRoom().getId()).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(new a(this), b.a);
        IJoinChannelResult r9 = (IJoinChannelResult) r8.data;
        if (r9 != null) goto L5;
        return;
    L5:
        if (vm2.d.m().useJoinChannelList == false) goto L16;
        List r0 = r9.getLinkedUsers();
        if (r0 == null) goto L9;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r1 = jm2.a.a(r0);
    L10:
        y r2 = xq();
        if (r1 != null) goto L13;
        r1 = new ArrayList();
    L13:
        r2.S4(r1, r9.getClientUiInfo(), r9.getVersion(), "joinChannel");
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final void onPermitSuccess(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r2, "userId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "s");
        Intrinsics.checkNotNullParameter(r2, "s");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void A(String r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "interactId");
        y r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoCenter");
    L5:
        hg6.g r2 = R1();
        com.bytedance.live.datacontext.m r9 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r9 == null) goto L10;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L10;
        long r3 = r10.getRoomId();
    L11:
        com.bytedance.android.live.liveinteract.plantform.utils.b.a(true, r1, r2, r7, r3);
        return;
    L10:
        r3 = 0;
        goto L11
    }

    public final void I2(ei6.a r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r4, "source");
    }

    public final void Il(IBaseUser r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "user");
        Intrinsics.checkNotNullParameter(r1, "user");
        Intrinsics.checkNotNullParameter(r1, "user");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J3(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        com.bytedance.android.live.liveinteract.plantform.core.g.a(r2, r3);
    }

    public final void Rb(IBaseUser r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "user");
        Intrinsics.checkNotNullParameter(r1, "user");
        Intrinsics.checkNotNullParameter(r1, "user");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S1(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.c(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Z4(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void d5(dg2.e r4, dg2.e[] r5) {
        Intrinsics.checkNotNullParameter(r4, "localQuality");
        Intrinsics.checkNotNullParameter(r5, "remoteQualities");
        com.bytedance.android.live.liveinteract.plantform.core.g.d(r4, r5);
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L5;
        Boolean r7 = (Boolean) r6.get("data_rtc_network_status_report", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L14;
        IInteractService r8 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r8 == null) goto L15;
        ih0.b r9 = r8.dynamicService(((Widget) this).dataCenter);
        if (r9 == null) goto L16;
        r9.Dk("logic_widget", "rtc_network_quality", n0.a(r4), false);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r7 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void e1(String r1, long r2) {
        xq().getClass();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void g(String r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "interactId");
        y r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoCenter");
    L5:
        hg6.g r2 = R1();
        com.bytedance.live.datacontext.m r9 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r9 == null) goto L10;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L10;
        long r3 = r10.getRoomId();
    L11:
        com.bytedance.android.live.liveinteract.plantform.utils.b.a(false, r1, r2, r7, r3);
        return;
    L10:
        r3 = 0;
        goto L11
    }

    public final void l(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r1, "userId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void n2(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.b(r2, r3);
    }

    public final void t5(ec6.a r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r4, "source");
    }

    public void v5(IBaseUser r1, List<? extends e1> r2) {
        Intrinsics.checkNotNullParameter(r1, "user");
        Intrinsics.checkNotNullParameter(r1, "user");
        Intrinsics.checkNotNullParameter(r1, "user");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Hf(int r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "deviceId");
        Intrinsics.checkNotNullParameter(r2, "deviceId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Rj(int r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void x1(LiveWrappedNetworkDetectionLinkType r1, int r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void L0(String r1, TextureView r2, int r3, int r4) {
        Cq(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void b4(String r1, z.a r2, int r3, int r4) {
        Cq(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h1(String r1, SurfaceView r2, int r3, int r4) {
        Cq(r1);
    }
}
