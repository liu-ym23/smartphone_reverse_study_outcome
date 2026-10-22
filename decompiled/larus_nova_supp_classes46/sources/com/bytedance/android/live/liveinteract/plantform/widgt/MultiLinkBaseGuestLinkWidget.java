package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.u2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.GuestRtcLinkerContext;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.base.h;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h0;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.j0;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.revenue.PaidLinkMicPlayModeHandler;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.m0;
import com.bytedance.android.live.liveinteract.plantform.utils.n0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.voicechat.dialog.ChatRoomDistributeTipsDialog;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService;
import com.bytedance.android.livesdk.chatroom.model.AudienceLeaveSourceEnum;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.a0;
import com.bytedance.android.livesdk.chatroom.model.d1;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.config.LiveKtvRealtimeChorusDynamicSettingConfig;
import com.bytedance.android.livesdk.config.wl0;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i0;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.android.livesdk.message.model.d9;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFirstFrameOptConfigV2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import com.bytedance.live.datacontext.DataContext;
import gd0.x;
import hh1.u0;
import hh1.v0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.z;
import zf2.s0;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00042\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/MultiLinkBaseGuestLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/base/h;", "T", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "", "Lcom/bytedance/android/live/liveinteract/plantform/base/b;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class MultiLinkBaseGuestLinkWidget<T extends com.bytedance.android.live.liveinteract.plantform.base.h> extends PlatformMultiLinkWidget implements gg6.d, gg6.c, hg6.j, hg6.o, gg6.b, hg6.l, hg6.d, hg6.k, yb6.b, hg6.a, hg6.c, hg6.p, hg6.m, hg6.n, yb6.f, yb6.a, yb6.m, yb6.d, yb6.l, yb6.c, com.bytedance.android.live.liveinteract.plantform.core.k, com.bytedance.android.live.liveinteract.plantform.core.u, com.bytedance.android.live.liveinteract.plantform.base.b {
    public IRoom a;
    public y b;
    public v0 c;
    public com.bytedance.android.live.liveinteract.plantform.datamergev2.l d;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.d e;
    public eh0.b f;
    public eh0.b g;
    public String h;
    public boolean i;
    public String j;
    public m0 k;
    public boolean l;
    public final MultiLinkFirstFrameOptConfigV2 m;
    public final CompositeDisposable n;
    public ILinkerBattleConnectContent o;
    public final Lazy p;
    public boolean q;
    public final tf0.i r;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MultiLinkBaseGuestLinkWidget a;

        public a(MultiLinkBaseGuestLinkWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            d1 r5 = (d1) ((com.bytedance.android.live.network.response.e) r4).data;
            if (r5 == null) goto L22;
            List r6 = r5.getEntranceList();
            if (r6 == null) goto L23;
            y r0 = this.a.zq();
            y r2 = null;
            if ((r0 instanceof y) == true) goto L9;
            r0 = null;
        L9:
            if (r0 == null) goto L13;
            List<ILinkmicInteractEntrance> r1 = r0.D;
            if (r1 == null) goto L13;
            ((ArrayList) r1).clear();
        L13:
            y r3 = this.a.zq();
            if ((r3 instanceof y) == false) goto L17;
            r2 = r3;
        L17:
            if (r2 == null) goto L24;
            List<ILinkmicInteractEntrance> r7 = r2.D;
            if (r7 == null) goto L25;
            ((ArrayList) r7).addAll(r6);
            return;
        L25:
            return;
        L24:
            return;
        L23:
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

    public abstract int Cq();

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void D1(String r1, ByteBuffer r2, int r3) {
    }

    public final void E2() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void G9(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void Lb() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void M1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.u
    public void Qc() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void R(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void S(String r1, int r2, int r3) {
    }

    public void T3(com.bytedance.android.livesdk.chatroom.model.interact.m r1, int r2) {
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

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void al(String r1, int r2) {
    }

    public void c0(Throwable r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void ci() {
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

    public final void k4() {
    }

    public final void l0(Throwable r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.u
    public final void l8() {
    }

    public final void m0(Throwable r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void o() {
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

    public final void u0() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void wf(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wk(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void y0(String r1, SurfaceView r2, int r3, int r4) {
    }

    public void yi() {
        this.c = null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void z7() {
    }

    public abstract y zq();

    private final void wq() {
        if (this.q == false) goto L5;
        return;
    L5:
        this.q = true;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L13;
        if (getScene() == 9) goto L13;
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r1 == null) goto L156;
        r1.N1(P2());
        return;
    L156:
        return;
    L13:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == false) goto L45;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r2 = this.e;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L17:
        r2.O1();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r3 = this.e;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L20:
        r3.g1(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.f());
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r4 = this.e;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L23:
        r4.g1(new h0(false, ((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r5 = this.e;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L26:
        r5.g1(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.n());
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r6 = this.e;
        if (r6 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L29:
        r6.M0(new fh0.b(((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r7 = this.e;
        if (r7 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L32:
        r7.M0(new fh0.a(zq(), ((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r8 = this.e;
        if (r8 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L35:
        r8.M0(new PaidLinkMicPlayModeHandler(this, zq(), ((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r9 = this.e;
        if (r9 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L38:
        r9.M0(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.l(P2(), false));
        eh0.b r10 = this.f;
        if (r10 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L41:
        r10.O1();
        eh0.b r11 = this.g;
        if (r11 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("linkCrossRoomGameDataMergeCenter");
    L44:
        r11.O1();
        return;
    L45:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r12 = this.e;
        if (r12 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L48:
        r12.O1();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r13 = this.e;
        if (r13 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L51:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r14 = null;
        if ((r13 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L54;
        r13 = null;
    L54:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r15 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r13;
        if (r15 == null) goto L57;
        r15.g1(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.f());
    L57:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r16 = this.e;
        if (r16 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L61:
        if ((r16 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L63;
        r16 = null;
    L63:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r17 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r16;
        if (r17 == null) goto L66;
        r17.g1(new h0(false, ((Widget) this).dataCenter));
    L66:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r18 = this.e;
        if (r18 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L70:
        if ((r18 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L72;
        r18 = null;
    L72:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r19 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r18;
        if (r19 == null) goto L75;
        r19.g1(new fh0.e(((Widget) this).dataCenter, Cq()));
    L75:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r20 = this.e;
        if (r20 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L79:
        if ((r20 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L81;
        r20 = null;
    L81:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r21 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r20;
        if (r21 == null) goto L84;
        r21.g1(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.n());
    L84:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r22 = this.e;
        if (r22 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L88:
        if ((r22 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L90;
        r22 = null;
    L90:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r23 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r22;
        if (r23 == null) goto L93;
        r23.M0(new j0());
    L93:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r24 = this.e;
        if (r24 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L97:
        if ((r24 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L99;
        r24 = null;
    L99:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r25 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r24;
        if (r25 == null) goto L102;
        r25.M0(new fh0.b(((Widget) this).dataCenter));
    L102:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r26 = this.e;
        if (r26 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L106:
        if ((r26 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L108;
        r26 = null;
    L108:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r27 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r26;
        if (r27 == null) goto L111;
        r27.M0(new fh0.a(zq(), ((Widget) this).dataCenter));
    L111:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r28 = this.e;
        if (r28 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L115:
        if ((r28 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L117;
        r28 = null;
    L117:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r29 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r28;
        if (r29 == null) goto L120;
        r29.M0(new fh0.f(((Widget) this).dataCenter));
    L120:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r30 = this.e;
        if (r30 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L124:
        if ((r30 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L126;
        r30 = null;
    L126:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r31 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r30;
        if (r31 == null) goto L129;
        r31.M0(new fh0.d(((Widget) this).dataCenter));
    L129:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r32 = this.e;
        if (r32 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L133:
        if ((r32 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L135;
        r32 = null;
    L135:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r33 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r32;
        if (r33 == null) goto L138;
        r33.M0(new PaidLinkMicPlayModeHandler(this, zq(), ((Widget) this).dataCenter));
    L138:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r34 = this.e;
        if (r34 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L142:
        if ((r34 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == false) goto L145;
        r14 = r34;
    L145:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r35 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r14;
        if (r35 == null) goto L148;
        r35.M0(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.l(P2(), false));
    L148:
        eh0.b r36 = this.f;
        if (r36 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L151:
        r36.O1();
        eh0.b r37 = this.g;
        if (r37 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("linkCrossRoomGameDataMergeCenter");
    L154:
        r37.O1();
    }

    public final y Aq() {
        y r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoCenter");
    L5:
        return r0;
    }

    public final cg6.a Bq() {
        return getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    public final boolean Fq() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L9;
        gd0.i r1 = r0.getInteractFloatWindowService();
        if (r1 == null) goto L9;
        if (((com.bytedance.android.live.liveinteract.service.g) r1).b() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean Gq() {
        return jc1.k.n(IMultiLinkServiceExternal.class).getControlServiceExternal().c();
    }

    public void Jq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("cmd_interact_state_change", new a1(4));
    L5:
        hd0.c.f().k(0);
    }

    public final IRoom getMRoom() {
        IRoom r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L5:
        return r0;
    }

    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d md() {
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L5:
        return r0;
    }

    public final eh0.b p5() {
        eh0.b r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L5:
        return r0;
    }

    public final rf6.a xq() {
        qf6.a r0 = getScopeServiceOrNullInMultiLinkRoom(qf6.a.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ob();
    }

    public final jg6.a Eq() {
        cg6.a r0 = Bq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e5();
    }

    public void H1() {
        int r0 = com.bytedance.android.live.liveinteract.linkpanel.util.o.d();
        if (((LiveKtvRealtimeChorusDynamicSettingConfig) wl0.a.getValue()).getEnableSwitchStreamOpt() == false) goto L7;
        if (r0 != 63) goto L7;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L15;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L16;
        r2.put("cmd_interact_state_change", new a1(3));
        return;
    L16:
        return;
    L15:
        return;
    L7:
        if (r0 == 62) goto L8;
        r1 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.b
    public final hg6.g P2() {
        cg6.a r0 = Bq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRtcManager();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.b
    public final ei6.a V0() {
        cg6.a r0 = Bq();
        if (r0 == null) goto L7;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L7;
        return r1.V0();
    L7:
        return null;
    }

    public void Y4() {
        xs2.b.a().post(new jd0.p("MultiLinkBaseGuestLinkWidget onLinkSuccess"));
        if (((LiveKtvRealtimeChorusDynamicSettingConfig) wl0.a.getValue()).getEnableSwitchStreamOpt() == true) goto L16;
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getVideoTalkRoomSubScene();
        if (r0 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = r1.t();
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.c != 63) goto L20;
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L21;
        r3.put("cmd_interact_state_change", new a1(3));
        return;
    L21:
        return;
    L20:
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        super.onCreate();
        cg6.a r0 = Bq();
        if (r0 == null) goto L7;
        com.bytedance.live.bizlink.impl.platform.manager.a r1 = r0.A0();
        if (r1 == null) goto L7;
        r1.c(this);
    L7:
        cg6.a r2 = Bq();
        if (r2 == null) goto L12;
        MultiLinkGuestManager r3 = r2.W4();
        if (r3 == null) goto L12;
        r3.b(this);
    L12:
        hg6.g r4 = P2();
        if (r4 == null) goto L15;
        r4.p(this);
    L15:
        DataCenter r5 = ((Widget) this).dataCenter;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r7 = null;
        eh0.b r8 = null;
        if (r5 == null) goto L18;
        IRoom r6 = (IRoom) r5.get("data_room", vh7.f.c(IRoom.class));
    L19:
        if (r6 == null) goto L21;
        IRoom r9 = (IRoom) ((Widget) this).dataCenter.get("data_room", vh7.f.c(IRoom.class));
    L26:
        this.a = r9;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L43;
        int r10 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r11 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r11 == null) goto L31;
        y r12 = r11.getLinkUserCenter();
    L32:
        if (r12 == null) goto L43;
        if (getScene() == 9) goto L43;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r13 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r13 == null) goto L38;
        y r14 = r13.getLinkUserCenter();
    L39:
        if (r14 == null) goto L42;
    L47:
        this.b = r14;
        IMultiPkAudienceLinkOutService r15 = (IMultiPkAudienceLinkOutService) jc1.k.n(IMultiPkAudienceLinkOutService.class);
        if (r15.isRtcEngineOn() == false) goto L72;
        x r16 = r15.createRtcData();
        if (r16 == null) goto L54;
        hg6.g r17 = P2();
        if (r17 == null) goto L54;
        r17.a0(pg6.a.a(r16), null);
    L54:
        Object r18 = r15.getLiveVideoClientFactory();
        if ((r18 instanceof v0) == true) goto L57;
        r18 = null;
    L57:
        this.c = (v0) r18;
        if (je0.d.U() == false) goto L64;
        v0 r19 = this.c;
        if (r19 == null) goto L64;
        d0 r20 = r19.getLiveCore();
        if (r20 == null) goto L64;
        SurfaceView r21 = (SurfaceView) this.p.getValue();
        r20.x();
    L64:
        v0 r22 = this.c;
        if (r22 == null) goto L71;
        hg6.g r23 = P2();
        if (r23 == null) goto L71;
        yb6.e r24 = r23.j();
        if (r24 == null) goto L71;
        r24.s0(gc6.b.c(r22, null), "MultiLinkBaseGuestLinkWidget create from pk audience");
    L71:
        hd0.c.f().k(2);
    L114:
        LinkmicApplyFloatWindowManager.d r25 = LinkmicApplyFloatWindowManager.y;
        LinkmicApplyFloatWindowManager r26 = LinkmicApplyFloatWindowManager.e.a();
        IRoom r27 = this.a;
        if (r27 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L118:
        if (r26.i(r27.getRoomId()) == null) goto L123;
        com.bytedance.live.datacontext.m r28 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).G();
        if (r28 == null) goto L123;
        r28.setValue(Boolean.TRUE);
    L123:
        if (vm2.d.q0().isUserInfoCenterForwardInit() == true) goto L125;
        zq().i();
    L125:
        this.k = new m0(((Widget) this).context, com.bytedance.android.live.liveinteract.api.utils.m.k(this, ((Widget) this).dataCenter), P2(), this);
        Pair r29 = com.bytedance.live.datacontext.d.a(MultiLinkBaseGuestLinkWidget$onCreate$pair$1.INSTANCE);
        ((GuestRtcLinkerContext) r29.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r29.getFirst(), "guest_rtc_linker_service");
        this.n.add((Disposable) r29.getSecond());
        if (MultiLinkLoadWidgetUtils.g() == false) goto L147;
        int r30 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r31 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r31 == null) goto L130;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r32 = r31.md();
    L131:
        if (r32 == null) goto L147;
        if (getScene() == 9) goto L147;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r33 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r33 == null) goto L137;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r34 = r33.md();
    L138:
        Intrinsics.checkNotNull(r34);
        this.e = r34;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r35 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r35 == null) goto L141;
        eh0.b r36 = r35.p5();
    L142:
        Intrinsics.checkNotNull(r36);
        this.f = r36;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r37 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
        if (r37 == null) goto L145;
        r8 = r37.Y3();
    L145:
        Intrinsics.checkNotNull(r8);
        this.g = r8;
    L184:
        if (this.m.isEnableDataMergeCenterAttachOpt() == false) goto L187;
        wq();
        return;
    L187:
        return;
    L141:
        r36 = null;
        goto L142
    L137:
        r34 = null;
        goto L138
    L130:
        r32 = null;
    L147:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == false) goto L162;
        y r110 = zq();
        eg6.d r38 = P2();
        if (r38 != null) goto L152;
        r38 = new eg6.d();
    L152:
        eg6.d r111 = r38;
        IRoom r39 = this.a;
        if (r39 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L155:
        this.d = new com.bytedance.android.live.liveinteract.plantform.datamergev2.l(r110, r39, ((Widget) this).dataCenter, this);
        this.e = new com.bytedance.android.live.liveinteract.plantform.datamergev2.h(this, this.d, new we0.a(), r111, 0, ((Widget) this).dataCenter, this);
        this.f = new com.bytedance.android.live.liveinteract.plantform.datamergev2.f(this, r111, ((Widget) this).dataCenter, 0, this.d);
        this.g = new com.bytedance.android.live.liveinteract.plantform.datamergev2.e(this, r110, r111, ((Widget) this).dataCenter, 0, this.d);
        Pair r40 = com.bytedance.live.datacontext.d.a(MultiLinkBaseGuestLinkWidget$initLinkUserDataMergeCenterV2$pair$1.INSTANCE);
        LinkUserDataMergeContext r41 = (LinkUserDataMergeContext) r40.getFirst();
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.d> r42 = r41.getDataMergeCenter();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r43 = this.e;
        if (r43 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L158:
        r42.d(r43);
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.b> r44 = r41.getLinkRoomFightDataMergeCenter();
        eh0.b r45 = this.f;
        if (r45 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L161:
        r44.d(r45);
        r41.share(((Widget) this).dataCenter);
        this.n.add((Disposable) r40.getSecond());
        ((Widget) this).dataCenter.put("data_multi_link_data_merge_center_init", Boolean.TRUE);
        goto L184
    L162:
        y r112 = zq();
        eg6.d r46 = P2();
        if (r46 != null) goto L166;
        r46 = new eg6.d();
    L166:
        eg6.d r113 = r46;
        this.e = new com.bytedance.android.live.liveinteract.plantform.datamerge.j(this, r112, new we0.a(), r113, this, ((Widget) this).dataCenter);
        this.f = new com.bytedance.android.live.liveinteract.plantform.datamerge.h(this, r112, r113, ((Widget) this).dataCenter);
        this.g = new com.bytedance.android.live.liveinteract.plantform.datamerge.e(this, r112, r113, ((Widget) this).dataCenter);
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d r47 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r48 = this.e;
        if (r48 != null) goto L170;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L170:
        if ((r48 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == false) goto L173;
        r7 = r48;
    L173:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r49 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r7;
        if (r49 == null) goto L176;
        r49.M0(r47);
    L176:
        Pair r50 = com.bytedance.live.datacontext.d.a(MultiLinkBaseGuestLinkWidget$initLinkUserDataMergeCenter$pair$1.INSTANCE);
        LinkUserDataMergeContext r51 = (LinkUserDataMergeContext) r50.getFirst();
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.d> r52 = r51.getDataMergeCenter();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r53 = this.e;
        if (r53 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L179:
        r52.d(r53);
        r51.getDynamicHandler().d(r47);
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.b> r54 = r51.getLinkRoomFightDataMergeCenter();
        eh0.b r55 = this.f;
        if (r55 != null) goto L182;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L182:
        r54.d(r55);
        r51.share(((Widget) this).dataCenter);
        this.n.add((Disposable) r50.getSecond());
        ((Widget) this).dataCenter.put("data_multi_link_data_merge_center_init", Boolean.TRUE);
        goto L184
    L72:
        String r56 = LinkmicOnlineFloatWindowManager.Y;
        if (LinkmicOnlineFloatWindowManager.c.a().q == null) goto L113;
        x r57 = LinkmicOnlineFloatWindowManager.c.a().r;
        if (r57 == null) goto L80;
        hg6.g r58 = P2();
        if (r58 == null) goto L79;
        r58.a0(pg6.a.a(r57), null);
    L79:
        LinkmicOnlineFloatWindowManager.c.a().v(null);
    L80:
        this.c = LinkmicOnlineFloatWindowManager.c.a().q;
        if (je0.d.U() == false) goto L93;
        v0 r59 = this.c;
        if ((r59 instanceof m00.g) == true) goto L85;
        r59 = null;
    L85:
        m00.g r60 = (m00.g) r59;
        if (r60 == null) goto L88;
        r60.i();
    L88:
        v0 r61 = this.c;
        if (r61 == null) goto L93;
        d0 r62 = r61.getLiveCore();
        if (r62 == null) goto L93;
        SurfaceView r63 = (SurfaceView) this.p.getValue();
        r62.x();
    L93:
        com.bytedance.live.datacontext.m r65 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).m();
        if (r65 == null) goto L96;
        r65.setValue(Boolean.TRUE);
    L96:
        LinkmicOnlineFloatWindowManager.c.a().q = null;
        tc0.c r66 = LinkmicOnlineFloatWindowManager.c.a().n;
        v0 r67 = this.c;
        if (r67 == null) goto L108;
        sg6.b r68 = xq();
        if (r68 == null) goto L103;
        vf6.b r69 = r68.i();
        if (r69 == null) goto L103;
        r69.i9(gc6.b.c(r67, null));
    L103:
        hg6.g r70 = P2();
        if (r70 == null) goto L108;
        yb6.e r71 = r70.j();
        if (r71 == null) goto L108;
        r71.s0(gc6.b.c(r67, null), "MultiLinkBaseGuestLinkWidget create back from linkmic float window");
    L108:
        hd0.c.f().k(2);
        jg6.a r72 = LinkmicOnlineFloatWindowManager.c.a().w;
        if (r72 == null) goto L114;
        kg6.e r73 = r72.b();
        if (r73 == null) goto L114;
        ((Widget) this).dataCenter.put("data_self_is_silenced", Boolean.valueOf(r73.q()));
        goto L114
    L113:
        hd0.c.f().j();
        goto L114
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.core.LinkUserInfoCenterV2");
    L38:
        r14 = null;
        goto L39
    L31:
        r12 = null;
    L43:
        IRoom r74 = this.a;
        if (r74 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L46:
        r14 = new y(r74, ((Widget) this).dataCenter);
        goto L47
    L21:
        com.bytedance.live.datacontext.m r75 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r75 == null) goto L25;
        r9 = (IRoom) r75.getValue();
        if (r9 != null) goto L26;
    L25:
        r9 = vh7.f.c(IRoom.class);
        goto L26
    L18:
        r6 = null;
        goto L19
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        super.onDestroy();
        Iq("onDestroy");
        cg6.a r0 = Bq();
        if (r0 == null) goto L7;
        com.bytedance.live.bizlink.impl.platform.manager.a r1 = r0.A0();
        if (r1 == null) goto L7;
        r1.l(this);
    L7:
        cg6.a r2 = Bq();
        if (r2 == null) goto L12;
        MultiLinkGuestManager r3 = r2.W4();
        if (r3 == null) goto L12;
        r3.i(this);
    L12:
        hg6.g r4 = P2();
        if (r4 == null) goto L15;
        r4.Z(this);
    L15:
        com.bytedance.live.datacontext.m r5 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).G();
        if (r5 == null) goto L18;
        r5.setValue(Boolean.FALSE);
    L18:
        zq().l();
        m0 r6 = this.k;
        if (r6 == null) goto L21;
        r6.c();
    L21:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r7 = this.e;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L24:
        r7.detach();
        eh0.b r8 = this.f;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L27:
        r8.detach();
        eh0.b r9 = this.g;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("linkCrossRoomGameDataMergeCenter");
    L30:
        r9.detach();
        this.n.clear();
    }

    public void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        this.l = true;
    }

    public void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        this.l = false;
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public void onStart() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStart();
        if (this.m.isEnableDataMergeCenterAttachOpt() == true) goto L6;
        wq();
        return;
    }

    public final vb6.g yq() {
        cg6.a r0 = Bq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.O5();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.b
    public final v0 getLiveVideoClientFactory() {
        return this.c;
    }

    public MultiLinkBaseGuestLinkWidget(tc0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "dataHolder");
        this.r = r2;
        this.h = "";
        this.j = "";
        this.m = (MultiLinkFirstFrameOptConfigV2) u2.a.getValue();
        this.n = new CompositeDisposable();
        this.p = LazyKt.lazy(new MultiLinkBaseGuestLinkWidget$surfaceViewByLazy$2(this));
    }

    public void G1(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    public void G2(d9 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    public void H4(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    public final void Iq(String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        bn0.b r1 = getMultiLinkRoomScope();
        if (r1 != null) goto L5;
    L6:
        HashMap r2 = new HashMap();
        if (getMultiLinkRoomScope() != null) goto L9;
        String r3 = "scope_null";
    L11:
        if (Bq() != null) goto L13;
        boolean r4 = true;
    L14:
        r2.put("error_type", r3);
        r2.put("get_scope_is_null", String.valueOf(r4));
        r2.put("source", r7);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.b0(r2);
        StringBuilder r0 = new StringBuilder();
        r0.append(r7);
        r0.append(": call in room[");
        com.bytedance.live.datacontext.m r8 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r8 == null) goto L19;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L19;
        Long r10 = Long.valueOf(r9.getRoomId());
    L20:
        r0.append(r10);
        r0.append("] error: ");
        r0.append(r3);
        r0.append(" getScopeIsNull: ");
        r0.append(r4);
        r0.append(", stack = ");
        r0.append(Log.getStackTraceString(new Exception(r3)));
        ALogger.e("MultiLinkBaseGuestLinkWidget", r0.toString());
        return;
    L19:
        r10 = null;
        goto L20
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = "service_null";
        goto L11
    L5:
        if (com.bytedance.android.scope.m.e.d(r1, cg6.a.class) == null) goto L6;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L(String r2) {
        m0 r0 = this.k;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        TextUtils.equals(r2, this.r.u());
    }

    public void M4(cc6.b r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        gg6.a.a(r2);
    }

    public final ec6.a O2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        return null;
    }

    public void P8(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public void Y(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        int r0 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d0.a;
        ILinkerKickOutContent r3 = r2.getMKickOut();
        if (r3 == null) goto L5;
        int r4 = r3.getKickOutSource();
    L6:
        this.j = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d0.c(Integer.valueOf(r4));
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public final void b1(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        Intrinsics.checkNotNullParameter(r2, "throwable");
        Intrinsics.checkNotNullParameter(r2, "throwable");
    }

    public void bd(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    public void be(ExtraResponse<? extends IJoinChannelResult, Extra> r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        m0 r0 = this.k;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        tc0.c r1 = tc0.c.h();
        r1.D = this.l;
        com.bytedance.android.live.liveinteract.plantform.utils.k.a(((Widget) this).context, this.r.getScene());
        IJoinChannelResult r2 = (IJoinChannelResult) r4.data;
        if (r2 != null) goto L8;
    L20:
        IJoinChannelResult r3 = ((IJoinChannelResult) r4.data).castToOrNull(IJoinChannelResult.class);
        IJoinChannelResult r5 = (IJoinChannelResult) r4.data;
        if (r5 == null) goto L24;
        String r6 = r5.getToken();
        if (r6 == null) goto L24;
    L25:
        this.h = r6;
        if (r3 == null) goto L28;
        boolean r7 = r3.getPaidLinkmic();
    L29:
        this.i = r7;
        LinkAudienceApi r8 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r9 = this.a;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L32:
        ((ObservableSubscribeProxy) r8.fetchInteractEntrances(r9.getId()).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(new a(this), b.a);
        ChatRoomDistributeTipsDialog.a r10 = ChatRoomDistributeTipsDialog.f;
        Context r11 = ((Widget) this).context;
        a0 r12 = ((IJoinChannelResult) r4.data).castTo(IJoinChannelResult.class).getDelegateSetting();
        r10.getClass();
        ChatRoomDistributeTipsDialog.a.a(r11, r12);
        return;
    L28:
        r7 = false;
    L24:
        r6 = "";
        goto L25
    L8:
        if (r2.getLinkedUsers() == null) goto L20;
        if (vm2.d.m().useJoinChannelList == false) goto L20;
        i0 r13 = jm2.a.d((vh7.c) r4.data);
        if (r13 == null) goto L19;
        i0 r14 = r13;
        y r15 = zq();
        if ((r15 instanceof y) == true) goto L16;
        r15 = null;
    L16:
        if (r15 == null) goto L20;
        r15.E(r14);
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.IJoinChannelResultBridge");
    }

    public final void f5(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        int r0 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d0.a;
        LinkerSysKickOutContent r3 = r2.getMLinkerSysKickOutContent();
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getKickOutSource());
    L6:
        this.j = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d0.c(Integer.valueOf(r4.intValue()));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public void l1(g1 r1) {
        int r2 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d0.a;
        this.j = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d0.c(Integer.valueOf(AudienceLeaveSourceEnum.AudienceLeave_Leave.getValue()));
    }

    public final void onPermitSuccess(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r2, "userId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "s");
        Intrinsics.checkNotNullParameter(r2, "s");
    }

    public void ti(ExtraResponse<? extends IJoinChannelResult, Extra> r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r2, "response");
    }

    public void x2(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        int r0 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d0.a;
        this.j = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d0.c(Integer.valueOf(r2.getKickOutSource()));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void A(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    public final void D0(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "reqFrom");
        Intrinsics.checkNotNullParameter(r1, "reqFrom");
        Intrinsics.checkNotNullParameter(r1, "reqFrom");
    }

    public final void I2(ei6.a r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r4, "source");
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
        Intrinsics.checkNotNullParameter(r1, "user");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J3(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        com.bytedance.android.live.liveinteract.plantform.core.g.a(r2, r3);
    }

    public final void R3(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "reqFrom");
        Intrinsics.checkNotNullParameter(r1, "reqFrom");
        Intrinsics.checkNotNullParameter(r1, "reqFrom");
    }

    public final void Rb(IBaseUser r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "user");
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
        zq().getClass();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f0(long r1, Exception r3) {
        m0 r2 = this.k;
        if (r2 == null) goto L6;
        r2.c();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void g(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    public final void l(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r1, "userId");
    }

    public final void lf(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
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
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r4, "source");
    }

    public void u4(long r1, ec6.a r3) {
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r3, "client");
    }

    public void v5(IBaseUser r1, List<? extends e1> r2) {
        Intrinsics.checkNotNullParameter(r1, "user");
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
    public void J(String[] r5, boolean[] r6, int[] r7) {
        if (r5 == null) goto L54;
        if (r6 == null) goto L62;
        int r8 = r5.length;
        String r0 = this.r.getInteractId();
        if (r0 != null) goto L9;
        r0 = "0";
    L9:
        int r2 = 0;
    L10:
        if (r2 >= r8) goto L63;
        if (TextUtils.equals(r5[r2], r0) == false) goto L53;
        if (r6[r2] == false) goto L53;
        y r9 = zq();
        u0 r10 = null;
        if ((r9 instanceof y) == true) goto L18;
        r9 = null;
    L18:
        if (r9 == null) goto L20;
        ILinkPlayerInfoBridge r11 = r9.o("", r0);
    L21:
        if (r11 != null) goto L23;
    L45:
        u0 r12 = this.c;
        if ((r12 instanceof u0) == false) goto L49;
        r10 = r12;
    L49:
        u0 r13 = r10;
        if (r13 == null) goto L61;
        r13.x0();
        return;
    L61:
        return;
    L23:
        if (com.bytedance.android.live.liveinteract.plantform.model.n.f(r11) != true) goto L45;
        u0 r14 = this.c;
        if ((r14 instanceof u0) == false) goto L28;
        r10 = r14;
    L28:
        u0 r15 = r10;
        if (r15 == null) goto L59;
        kd1.b r16 = r11.getMicDress();
        if (r16 == null) goto L39;
        kd1.c r17 = r16.getVoiceWave();
        if (r17 == null) goto L39;
        py.k r18 = r17.getMediumImg();
        if (r18 == null) goto L39;
        List r19 = r18.getUrls();
        if (r19 == null) goto L39;
        String r20 = (String) CollectionsKt.getOrNull(r19, 0);
    L39:
        kd1.b r21 = r11.getMicDress();
        if (r21 == null) goto L44;
        kd1.c r22 = r21.getVoiceWave();
        if (r22 == null) goto L44;
        r22.getDressId();
    L44:
        r15.a();
        return;
    L59:
        return;
    L20:
        r11 = null;
    L53:
        r2 = r2 + 1;
        goto L10
    L63:
        return;
    L62:
        return;
    }

    public void Ng(sf0.a r1, long r2, ExtraResponse<? extends IApplyResult, Extra> r4) {
        Intrinsics.checkNotNullParameter(r1, "applyParams");
        Intrinsics.checkNotNullParameter(r4, "response");
        Intrinsics.checkNotNullParameter(r1, "applyParams");
        Intrinsics.checkNotNullParameter(r4, "response");
        Intrinsics.checkNotNullParameter(r1, "applyParams");
        Intrinsics.checkNotNullParameter(r4, "response");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Rj(int r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    public final void U7(sf0.a r1, long r2, Throwable r4) {
        Intrinsics.checkNotNullParameter(r1, "applyParams");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        Intrinsics.checkNotNullParameter(r1, "applyParams");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        Intrinsics.checkNotNullParameter(r1, "applyParams");
        Intrinsics.checkNotNullParameter(r4, "throwable");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void x1(LiveWrappedNetworkDetectionLinkType r1, int r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L0(String r3, TextureView r4, int r5, int r6) {
        long r7 = hd0.c.f().e;
        if (TextUtils.equals(r3, this.r.u()) == true) goto L5;
    L7:
        TextUtils.equals(r3, this.r.u());
        return;
    L5:
        if (r7 <= 0) goto L7;
        hd0.c.f().e = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void b4(String r3, z.a r4, int r5, int r6) {
        long r7 = hd0.c.f().e;
        if (TextUtils.equals(r3, this.r.u()) == true) goto L5;
    L7:
        TextUtils.equals(r3, this.r.u());
        return;
    L5:
        if (r7 <= 0) goto L7;
        hd0.c.f().e = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void h1(String r3, SurfaceView r4, int r5, int r6) {
        long r7 = hd0.c.f().e;
        if (TextUtils.equals(r3, this.r.u()) == true) goto L5;
    L7:
        TextUtils.equals(r3, this.r.u());
        return;
    L5:
        if (r7 <= 0) goto L7;
        hd0.c.f().e = 0;
        goto L7
    }
}
