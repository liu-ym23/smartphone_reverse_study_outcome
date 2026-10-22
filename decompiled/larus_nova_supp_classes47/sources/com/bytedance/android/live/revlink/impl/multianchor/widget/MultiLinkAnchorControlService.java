package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenuelink.connect.m;
import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.kmpwidget.KmpStatelessLiveWidget;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.connect.MultiAnchorRelinkService;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.MultiLinkConfigManager;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.o;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiInviteLogDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkControlContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PKControlServiceContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchManager;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkInviteLogDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkPrecisionMatchDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkPrecisionMatchManager;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleManager;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.IListUserLinkmicContent;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.c2;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.m1;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.d5;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.i2;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j5;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.l2;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.q;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.link.model.x5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import dq2.w;
import fr2.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/widget/MultiLinkAnchorControlService;", "Lcom/bytedance/android/live/revlink/impl/kmpwidget/KmpStatelessLiveWidget;", "Lcom/bytedance/android/live/revenuelink/connect/m;", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/a;", "", "Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/c;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkAnchorControlService extends KmpStatelessLiveWidget implements m, com.bytedance.android.live.revlink.impl.multianchor.service.a, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c {
    public MultiLinkConfigManager A;
    public com.bytedance.android.live.revlink.impl.multianchor.utils.i B;
    public com.bytedance.android.live.revlink.impl.multianchor.connect.i C;
    public final u.a D;
    public com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e E;
    public com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e F;
    public u G;
    public MultiLinkAnchorControlContext H;
    public f21.a I;
    public com.bytedance.android.live.revlink.impl.multianchor.scope.e J;
    public final Lazy K;
    public PkAutoMatchManager L;
    public PkPrecisionMatchManager M;
    public PkReserveBattleManager N;
    public t O;
    public final com.bytedance.android.live.revlink.impl.b P;
    public final u51.b Q;
    public final Function0<v51.b> R;
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.c S;
    public n a;
    public final CompositeDisposable b;
    public IRoom c;
    public i11.b d;
    public n31.a e;
    public AnchorRtcConnectManager f;
    public AnchorRtcConnectModel g;
    public f41.a h;
    public final MutableLiveData<q11.c> i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public final com.bytedance.android.live.revlink.impl.global.c Aq() {
        return (com.bytedance.android.live.revlink.impl.global.c) this.o.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final com.bytedance.android.live.revenuelink.connect.f getAnchorConnectService() {
        return (com.bytedance.android.live.revenuelink.connect.f) this.k.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final ld.a getLinkInternalDataSet() {
        return (ld.a) this.m.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final x11.a getRevInternalLinkService() {
        return (x11.a) this.n.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final wq2.f getRoomDataCenterService() {
        return (wq2.f) this.l.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final MultiAnchorRelinkService Fa() {
        return (MultiAnchorRelinkService) this.K.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final String Me() {
        i11.b r0 = this.d;
        if (r0 == null) goto L27;
        List<p> r1 = r0.getOnlineUserList();
        if (r1 == null) goto L28;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        if (q.a((p) r3) != IListUserLinkmicContent.IAnchorAuthRole.AnchorAuthRoleOrganizer.ordinal()) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L8;
    L16:
        p r5 = (p) r3;
        if (r5 == null) goto L29;
        IBaseUser r6 = r5.getUser();
        if (r6 != null) goto L21;
        return null;
    L21:
        return iz.a.a(r6);
    L29:
        return null;
    L12:
        r4 = false;
        goto L13
    L15:
        r3 = null;
        goto L16
    L28:
        return null;
    L27:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.m X9() {
        if (((com.bytedance.android.live.revlink.impl.multianchor.vm.b) this.s.getValue()) == null) goto L12;
        String r1 = this.D.f;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r2 = (com.bytedance.android.live.revlink.impl.multianchor.vm.b) this.s.getValue();
        if (r2 == null) goto L10;
        com.bytedance.live.datacontext.m<String> r3 = r2.getInviteeList();
        if (r3 == null) goto L10;
        String r4 = (String) r3.getValue();
        if (r4 == null) goto L10;
    L14:
        return new com.bytedance.android.live.revlink.impl.multianchor.utils.m(r1, r4);
    L10:
        r4 = "";
        goto L14
    L12:
        u.a r5 = this.D;
        return new com.bytedance.android.live.revlink.impl.multianchor.utils.m(r5.f, r5.h);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final boolean ae() {
        i11.b r0 = this.d;
        if (r0 == null) goto L29;
        List<p> r1 = r0.getOnlineUserList();
        if (r1 == null) goto L30;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        if (q.a((p) r3) != IListUserLinkmicContent.IAnchorAuthRole.AnchorAuthRoleOrganizer.ordinal()) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L8;
    L16:
        p r5 = (p) r3;
        if (r5 == null) goto L31;
        k1 r6 = r5.getContent();
        if (r6 == null) goto L32;
        m1 r7 = r6.getLinkMicContent();
        if (r7 != null) goto L23;
        return false;
    L23:
        return r7.getHostSwitch();
    L32:
        return false;
    L31:
        return false;
    L12:
        r4 = false;
        goto L13
    L15:
        r3 = null;
        goto L16
    L30:
        return false;
    L29:
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final com.bytedance.android.live.revlink.impl.multianchor.scope.c getLinkDialogService() {
        int r0 = com.bytedance.android.live.revlink.impl.multianchor.scope.c.d;
        com.bytedance.android.live.revlink.impl.multianchor.scope.e r1 = this.J;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L5:
        Intrinsics.checkNotNullParameter(r1, "scope");
        com.bytedance.android.live.revlink.impl.multianchor.scope.c r2 = (com.bytedance.android.live.revlink.impl.multianchor.scope.c) com.bytedance.android.scope.m.e.d(r1, com.bytedance.android.live.revlink.impl.multianchor.scope.c.class);
        if (r2 != null) goto L13;
        com.bytedance.android.live.revlink.impl.global.c r3 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r3 == null) goto L10;
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r4 = r3.of();
    L11:
        if (r4 == null) goto L13;
        Intrinsics.checkNotNullParameter("linkDialogService null", "message");
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("error_msg", "linkDialogService null");
        r4.c("ensure_not_reach_here", r5);
        goto L13
    L10:
        r4 = null;
    L13:
        return r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final n getLinkOutManagerFn() {
        n r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkManager");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final o getLinkTypeParams() {
        if (((com.bytedance.android.live.revlink.impl.multianchor.vm.b) this.s.getValue()) == null) goto L12;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r1 = (com.bytedance.android.live.revlink.impl.multianchor.vm.g) this.v.getValue();
        int r2 = 0;
        if (r1 == null) goto L7;
        int r3 = r1.d();
    L8:
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r4 = (com.bytedance.android.live.revlink.impl.multianchor.vm.g) this.v.getValue();
        if (r4 == null) goto L14;
        r2 = r4.b();
    L14:
        return new o(r3, r2);
    L7:
        r3 = 0;
        goto L8
    L12:
        u.a r5 = this.D;
        return new o(r5.c, r5.g);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.d
    public final i11.b getLinkUserCenter() {
        i11.b r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new AnchorLinkUserCenterV2(ld.d.a(), KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class), (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class), (yz0.f) KmpStatelessLiveWidget.zq(yz0.f.class));
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final IRoom getMRoom() {
        IRoom r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final UnexpectedFrameMonitor getUnexpectedFrameMonitor() {
        MultiLinkAnchorControlContext r0 = this.H;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getUnexpectedFrameMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final String ij() {
        return this.D.d;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final boolean isLinkWithAudience() {
        Intrinsics.checkNotNullParameter(com.bytedance.android.livesdk.revenue.service.interact.d.class, "typeId");
        w r0 = ((dy0.a) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class)).M1();
        if (r0 == null) goto L5;
        int r1 = r0.w();
    L6:
        if (r1 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = 0;
        goto L6
    }

    public final void onCreate() {
        super.onCreate();
        String r3 = null;
        jy0.b.c("ttlive_anchor_link", "MultiLinkAnchorControlWidget onCreate", null, 4);
        this.O = new t(Aq());
        this.I = new f21.a(Aq(), null, 0, false, null, false, false, false, false, 0, null, null, null, null, null, null, 0, null, 2097150);
        this.A = new MultiLinkConfigManager(KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class), Aq());
        yz0.g r2 = (yz0.g) KmpStatelessLiveWidget.zq(yz0.g.class);
        if (r2 == null) goto L7;
        IRoomBase r4 = r2.mo444getRoom();
        if (r4 == null) goto L7;
        IRoom r5 = (IRoom) r4;
    L8:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.c = r5;
        this.B = new com.bytedance.android.live.revlink.impl.multianchor.utils.i(ld.d.a(), KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class), Aq());
        this.C = new com.bytedance.android.live.revlink.impl.multianchor.connect.i((com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class));
        com.bytedance.android.live.revenuelink.connect.f r6 = getAnchorConnectService();
        if (r6 == null) goto L15;
        n r7 = r6.linkOutManager();
        if (r7 == null) goto L15;
        this.a = r7;
        r6.addLinkOutListener(7, this);
        r6.addLinkOutListener(2, this);
        r6.addLinkOutListener(1, this);
        t r8 = this.O;
        if (r8 == null) goto L15;
        r7.b(r8);
    L15:
        LinkRevInternalServiceContext r9 = (LinkRevInternalServiceContext) this.y.getValue();
        if (r9 == null) goto L22;
        com.bytedance.live.datacontext.j<AnchorLinkUserCenterV2> r10 = r9.getLinkUserCenter();
        if (r10 == null) goto L22;
        AnchorLinkUserCenterV2 r12 = (AnchorLinkUserCenterV2) r10.getValue();
        if (r12 == null) goto L22;
    L23:
        this.d = r12;
        n31.a r13 = new n31.a(Aq(), getMRoom());
        this.e = r13;
        Intrinsics.checkNotNullParameter(this, "widget");
        Intrinsics.checkNotNullParameter(this, "widget");
        ((com.bytedance.android.livesdk.common.k) r13).a = this;
        StringBuilder r14 = new StringBuilder("composite opt=");
        com.bytedance.android.live.revlink.impl.global.c r15 = r13.c;
        if (r15 == null) goto L26;
        AnchorLinkOptUtils r16 = r15.vk();
    L27:
        if (r16 == null) goto L29;
        Boolean r17 = Boolean.valueOf(r16.c());
    L30:
        r14.append(r17);
        r14.append(" config=");
        com.bytedance.android.live.revlink.impl.global.c r18 = r13.c;
        if (r18 == null) goto L33;
        AnchorLinkOptUtils r19 = r18.vk();
    L34:
        if (r19 == null) goto L36;
        r11.b r20 = r19.b();
    L37:
        r14.append(r20);
        jy0.b.f("ttlive_anchor_link", r14.toString(), null, 4);
        Pair r1 = com.bytedance.live.datacontext.d.a(new AnonymousClass2(this));
        DataContext r22 = (DataContext) r1.getFirst();
        Intrinsics.checkNotNullParameter(MultiLinkControlContext.Companion, "$this$TAG");
        com.bytedance.android.live.revlink.impl.global.d.a(r22, "MultiLinkControlContext", Aq());
        ((MultiLinkAnchorControlContext) r1.getFirst()).sharedWithRoomId(IRoomKtKt.getId(getMRoom()));
        ((MultiLinkAnchorControlContext) r1.getFirst()).getService().d(this);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r1.getSecond(), this.b);
        this.H = (MultiLinkAnchorControlContext) r1.getFirst();
        if (AnchorRtcConnectUtilsKt.f() == false) goto L44;
        Pair r23 = com.bytedance.live.datacontext.d.a(new AnonymousClass4(this));
        com.bytedance.android.live.revlink.impl.global.d.a((DataContext) r23.getFirst(), Reflection.getOrCreateKotlinClass(AnchorRtcConnectModel.class), Aq());
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r23.getSecond(), this.b);
        this.g = (AnchorRtcConnectModel) r23.getFirst();
        com.bytedance.android.live.revlink.impl.b r24 = this.P;
        if (r24 == null) goto L42;
        v r25 = r24.getLiveVideoClientFactory();
    L43:
        AnchorRtcConnectManager r26 = new AnchorRtcConnectManager(r25, (AnchorRtcConnectModel) r23.getFirst(), (yz0.g) KmpStatelessLiveWidget.zq(yz0.g.class), (yz0.f) KmpStatelessLiveWidget.zq(yz0.f.class), Aq(), ld.d.a());
        this.f = r26;
        r26.a();
        goto L44
    L42:
        r25 = null;
    L44:
        final com.bytedance.android.live.revlink.impl.global.c r27 = Aq();
        if (r27 == null) goto L52;
        com.bytedance.android.live.revlink.impl.global.c r28 = Aq();
        if (r28 == null) goto L50;
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r29 = new com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e(ld.d.a(), r28, this);
        this.F = r29;
    L51:
        this.E = r29;
        Pair r30 = com.bytedance.live.datacontext.d.a(new MultiLinkAnchorControlService$loadSceneMergeCompactComponent$pair$1(this, r27));
        com.bytedance.android.live.revlink.impl.global.d.a((DataContext) r30.getFirst(), "IPKLinkDataService", r27);
        com.bytedance.android.live.revlink.impl.global.d.a((DataContext) r30.getFirst(), "IPKLinkBizDataService", r27);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r30.getSecond(), this.b);
        Pair r32 = com.bytedance.live.datacontext.d.a(MultiLinkAnchorControlService$loadSceneMergeCompactComponent$controlServicePair$1.INSTANCE);
        ((PKControlServiceContext) r32.getFirst()).getService().d(r30.getFirst());
        com.bytedance.live.datacontext.b.a((DataContext) r32.getFirst(), "IPKControlService");
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r32.getSecond(), this.b);
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.a r33 = new com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.a(this.S);
        this.M = new PkPrecisionMatchManager(ld.d.a(), KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class), (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class), (yz0.f) KmpStatelessLiveWidget.zq(yz0.f.class), (x11.a) KmpStatelessLiveWidget.xq(x11.a.class), new MultiLinkAnchorControlService$loadSceneMergeCompactComponent$2(r33), new MultiLinkAnchorControlService$loadSceneMergeCompactComponent$3(r33));
        this.L = new PkAutoMatchManager(r33, ld.d.a(), KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class), Aq(), (yz0.f) KmpStatelessLiveWidget.zq(yz0.f.class));
        com.bytedance.android.livesdk.revenue.service.room.c r110 = KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class);
        yz0.f r111 = (yz0.f) KmpStatelessLiveWidget.zq(yz0.f.class);
        ld.a r112 = ld.d.a();
        Intrinsics.checkNotNullParameter(lr2.a.class, "typeId");
        this.N = new PkReserveBattleManager(r110, r111, r112, z11.a.a(lr2.a.class), (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class), new MultiLinkAnchorControlService$loadSceneMergeCompactComponent$4(r33), new MultiLinkAnchorControlService$loadSceneMergeCompactComponent$5(r33));
        goto L52
    L50:
        r29 = null;
    L52:
        u51.b r34 = this.Q;
        Intrinsics.checkNotNull(r34);
        i11.b r35 = this.d;
        Intrinsics.checkNotNull(r35);
        com.bytedance.android.live.revlink.impl.global.c r36 = Aq();
        Intrinsics.checkNotNull(r36);
        com.bytedance.android.livesdk.revenue.service.room.c r37 = KmpStatelessLiveWidget.yq(com.bytedance.android.livesdk.revenue.service.room.c.class);
        Intrinsics.checkNotNull(r37);
        Intrinsics.checkNotNullParameter(this, "kmpWidget");
        Intrinsics.checkNotNullParameter(r34, "linkScope");
        Intrinsics.checkNotNullParameter(r35, "linkUserCenter");
        Intrinsics.checkNotNullParameter(r36, "linkFakeGlobalService");
        Intrinsics.checkNotNullParameter(r37, "roomService");
        com.bytedance.android.live.revlink.impl.multianchor.scope.e r38 = new com.bytedance.android.live.revlink.impl.multianchor.scope.e(r34);
        Intrinsics.checkNotNullParameter(r38, "scope");
        Context r39 = ((Widget) this).context;
        Intrinsics.checkNotNullParameter(r39, "value");
        r38.e = r39;
        Intrinsics.checkNotNullParameter(this, "value");
        r38.f = this;
        Intrinsics.checkNotNullParameter(r35, "value");
        r38.g = r35;
        Object r40 = e33.k.a;
        if (r38.e != r40) goto L56;
        r3 = "context";
    L60:
        if (r3 != null) goto L102;
        com.bytedance.android.scope.l.a(r38);
        this.J = r38;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.gift.a.class).syncMultiAnchorList();
        MultiLinkConfigManager r42 = this.A;
        if (r42 == null) goto L64;
        r42.a((yz0.f) KmpStatelessLiveWidget.zq(yz0.f.class), this);
    L64:
        com.bytedance.android.live.revlink.impl.multianchor.utils.i r43 = this.B;
        if (r43 == null) goto L84;
        ld.a r44 = r43.c;
        if (r44 == null) goto L75;
        NextLiveData r45 = r44.A6();
        if (r45 == null) goto L75;
        Observable r46 = ld.c.a(r45);
        if (r46 == null) goto L75;
        Disposable r47 = r46.subscribe(new com.bytedance.android.live.revlink.impl.multianchor.utils.j(r43));
        if (r47 == null) goto L75;
        r43.a.add(r47);
    L75:
        ld.a r48 = r43.c;
        if (r48 == null) goto L84;
        NextLiveData r49 = r48.so();
        if (r49 == null) goto L84;
        Observable r50 = ld.c.a(r49);
        if (r50 == null) goto L84;
        Disposable r52 = r50.subscribe(new com.bytedance.android.live.revlink.impl.multianchor.utils.k(r43));
        if (r52 == null) goto L84;
        r43.a.add(r52);
    L84:
        com.bytedance.android.live.revlink.impl.multianchor.connect.i r53 = this.C;
        if (r53 == null) goto L89;
        i11.b r54 = r53.a();
        if (r54 == null) goto L89;
        r54.i(r53.b);
    L89:
        UnexpectedFrameMonitor r55 = getUnexpectedFrameMonitor();
        if (r55 == null) goto L92;
        r55.attach();
    L92:
        com.bytedance.android.live.revenuelink.rtc.f r56 = (com.bytedance.android.live.revenuelink.rtc.f) this.j.getValue();
        if (r56 == null) goto L97;
        com.bytedance.android.live.revenuelink.rtc.i r57 = r56.getRtcManager();
        if (r57 == null) goto L97;
        r57.F1(LiveTracingMonitorKt.EventModule.MULTI_LINKER, new com.bytedance.android.live.revlink.impl.multianchor.connect.m((com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class)));
    L97:
        com.bytedance.android.live.revenuelink.connect.f r58 = getAnchorConnectService();
        if (r58 == null) goto L103;
        r58.registerRefuseStrategy(7, new com.bytedance.android.live.revlink.impl.multianchor.connect.k(ld.d.a(), (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class)));
        return;
    L103:
        return;
    L102:
        throw new UninitializedPropertyAccessException(r3);
    L56:
        if (r38.f != r40) goto L58;
        r3 = "lifeCycle";
        goto L60
    L58:
        if (r35 != r40) goto L60;
        r3 = "linkUserCenter";
        goto L60
    L36:
        r20 = null;
        goto L37
    L33:
        r19 = null;
        goto L34
    L29:
        r17 = null;
        goto L30
    L26:
        r16 = null;
    L22:
        int r59 = AnchorLinkUserCenterV2.u;
        jy0.b.c("ttlive_anchor_link_users_v2", "create empty AnchorLinkUserCenter", null, 4);
        r12 = new AnchorLinkUserCenterV2(null, null, null, null);
    L7:
        r5 = vh7.f.c(IRoom.class);
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final int getInviteType() {
        return getLinkTypeParams().b;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final String getInviteeList() {
        return X9().b;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final n getLinkOutManager() {
        return getLinkOutManagerFn();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final int getMatchType() {
        return getLinkTypeParams().a;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final Pair<Integer, Integer> getPreviewSize() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Ii();
        if (r1 == null) goto L8;
        Pair<Integer, Integer> r2 = (Pair) r1.getValue();
        if (r2 == null) goto L8;
    L10:
        if (((Number) r2.getFirst()).intValue() > 0) goto L12;
    L15:
        b03.a r3 = b03.a.a;
        return new Pair(Integer.valueOf(s1.y()), Integer.valueOf((s1.w() - s1.A()) - 52));
    L12:
        if (((Number) r2.getSecond()).intValue() <= 0) goto L15;
        return r2;
    L8:
        r2 = TuplesKt.to(0, 0);
        goto L10
    }

    @Override // com.bytedance.android.live.revlink.scopeui.KmpWidget
    public final void onDestroy() {
        com.bytedance.android.live.revenuelink.connect.f r0 = getAnchorConnectService();
        if (r0 == null) goto L7;
        r0.removeLinkOutListener(7, this);
        r0.removeLinkOutListener(2, this);
        t r1 = this.O;
        if (r1 == null) goto L7;
        r0.linkOutManager().i(r1);
    L7:
        com.bytedance.android.live.revlink.impl.multianchor.scope.c r2 = getLinkDialogService();
        if (r2 == null) goto L10;
        r2.c();
    L10:
        super.onDestroy();
        PkPrecisionMatchManager r3 = this.M;
        if (r3 == null) goto L25;
        r3.a.dispose();
        PkPrecisionMatchDataContext r4 = r3.b;
        if (r4 == null) goto L15;
        r4.clearIt();
    L15:
        PkPrecisionMatchDataContext r5 = r3.b;
        if (r5 == null) goto L20;
        MutableLiveData<d5> r6 = r5.getShowDialogData();
        if (r6 == null) goto L20;
        r6.removeObserver(r3.c);
    L20:
        PkPrecisionMatchDataContext r7 = r3.b;
        if (r7 == null) goto L25;
        MutableLiveData<d5> r8 = r7.getUpdateLynxMatchUserStatus();
        if (r8 == null) goto L25;
        r8.removeObserver(r3.d);
    L25:
        PkAutoMatchManager r9 = this.L;
        if (r9 == null) goto L28;
        r9.j();
    L28:
        PkReserveBattleManager r10 = this.N;
        if (r10 == null) goto L40;
        r10.a.dispose();
        PkReserveBattleDataContext r12 = r10.b;
        if (r12 == null) goto L35;
        MutableLiveData<l2> r13 = r12.getShowReserveSettleDialog();
        if (r13 == null) goto L35;
        r13.removeObserver(r10.c);
    L35:
        PkReserveBattleDataContext r14 = r10.b;
        if (r14 == null) goto L40;
        MutableLiveData<i2> r15 = r14.getShowReserveInviteDialog();
        if (r15 == null) goto L40;
        r15.removeObserver(r10.d);
    L40:
        PkAutoMatchManager r16 = this.L;
        if (r16 == null) goto L43;
        r16.j();
    L43:
        UnexpectedFrameMonitor r17 = getUnexpectedFrameMonitor();
        if (r17 == null) goto L51;
        com.bytedance.android.live.revenuelink.connect.f r18 = com.bytedance.android.live.revlink.impl.global.b.a();
        if (r18 == null) goto L50;
        LiveData<ey.f> r19 = r18.connectState();
        if (r19 == null) goto L50;
        r19.removeObserver(r17.n);
    L50:
        r17.g.dispose();
    L51:
        AnchorRtcConnectManager r20 = this.f;
        if (r20 == null) goto L54;
        r20.l("detach", false);
        r20.b.dispose();
    L54:
        MultiLinkConfigManager r22 = this.A;
        if (r22 == null) goto L57;
        r22.c = null;
        r22.a.clear();
    L57:
        n31.a r23 = this.e;
        if (r23 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L60:
        ((com.bytedance.android.livesdk.common.k) r23).a = null;
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r24 = this.E;
        if (r24 == null) goto L63;
        r24.reset("MultiLinkAnchorControlWidget onDestroy");
    L63:
        this.b.clear();
        com.bytedance.android.live.revlink.impl.multianchor.utils.i r25 = this.B;
        if (r25 == null) goto L66;
        r25.a.dispose();
    L66:
        com.bytedance.android.live.revlink.impl.multianchor.connect.i r26 = this.C;
        if (r26 == null) goto L75;
        i11.b r27 = r26.a();
        if (r27 == null) goto L71;
        r27.l(r26.b);
    L71:
        Disposable r28 = r26.a;
        if (r28 == null) goto L76;
        r28.dispose();
        return;
    L76:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final String y3() {
        return X9().a;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final i11.b getAnchorLinkUserCenter() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final t getConnectMonitor() {
        return this.O;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final f21.a getConnectionContext() {
        return this.I;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final MultiLinkAnchorControlContext getControlContext() {
        return this.H;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final f41.a getJsbInvitePkCallback() {
        return this.h;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final u getLaunchParameters() {
        return this.G;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final u.a getLaunchRecord() {
        return this.D;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final i11.b getMLinkUserCenter() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final MutableLiveData<q11.c> getPkLinkState() {
        return this.i;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final AnchorRtcConnectManager getRtcConnectManager() {
        return this.f;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final AnchorRtcConnectModel getRtcConnectModel() {
        return this.g;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final Function0<v51.b> getStreamInteractScopeFn() {
        return this.R;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final MultiLinkConfigManager sp() {
        return this.A;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void A3(d11.d r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r1 = this.E;
        if (r1 == null) goto L32;
        Intrinsics.checkNotNullParameter(r7, "params");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.d r2 = r1.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "params");
        u.a r0 = r2.getLaunchRecord();
        r0.c = r7.e;
        r0.q(r7.d);
        IRoom r3 = r7.h;
        String r4 = null;
        if (r3 == null) goto L9;
        IBaseUser r5 = r3.getOwnerKt();
        if (r5 == null) goto L9;
        String r6 = iz.a.a(r5);
    L10:
        r0.f = r6;
        IRoom r8 = r7.h;
        r0.p = r8;
        if (r8 == null) goto L13;
        IBaseUser r9 = r8.getOwnerKt();
    L14:
        r0.o = r9;
        IRoom r10 = r7.h;
        if (r10 == null) goto L19;
        IBaseUser r12 = r10.getOwnerKt();
        if (r12 == null) goto L19;
        r4 = r12.getIdString();
    L19:
        r0.q = r4;
        boolean r13 = false;
        if (r0.t.length() <= 0) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == true) goto L25;
    L27:
        r0.s = r13;
        Set<String> r15 = r1.e;
        String r16 = r7.f;
        if (r16 != null) goto L30;
        r16 = "";
    L30:
        r15.add(r16);
        return;
    L25:
        if ((!Intrinsics.areEqual(r0.t, "common_pk")) == false) goto L27;
        r13 = true;
        goto L27
    L22:
        r14 = false;
        goto L23
    L13:
        r9 = null;
    L9:
        r6 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void M2(d11.b r18) {
        Intrinsics.checkNotNullParameter(r18, "params");
        StringBuilder r2 = new StringBuilder("apply timeout for toUser=");
        IBaseUser r3 = r18.h.getOwnerKt();
        if (r3 == null) goto L5;
        String r4 = r3.getIdString();
    L6:
        r2.append(r4);
        r2.append(" channel=");
        r2.append(r18.g);
        jy0.b.c("ttlive_anchor_link", r2.toString(), null, 4);
        LinkCrossRoomDataHolder r5 = (LinkCrossRoomDataHolder) this.z.getValue();
        long r6 = 0;
        if (r5 != null) goto L9;
    L10:
        com.bytedance.android.live.revlink.impl.service.internal.a r7 = (com.bytedance.android.live.revlink.impl.service.internal.a) this.x.getValue();
        if (r7 != null) goto L13;
        return;
    L13:
        if (r7.k0(64) == true) goto L33;
        n r8 = this.a;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkManager");
    L17:
        LinkCrossRoomDataHolder r9 = (LinkCrossRoomDataHolder) this.z.getValue();
        if (r9 == null) goto L20;
        r6 = r9.c();
    L20:
        long r10 = r6;
        long r12 = r18.c;
        IBaseUser r13 = r18.h.getOwnerKt();
        if (r13 == null) goto L23;
        String r14 = iz.a.a(r13);
    L24:
        r8.e(new d11.c(7, r10, r12, r14, r18.e, 1, "invite_apply_timeout"), null);
        AnchorRtcConnectManager r1 = this.f;
        if (r1 != null) goto L27;
        return;
    L27:
        if (r1.i() == true) goto L35;
        r1.l("applyTimeout", true);
        return;
    L35:
        return;
    L23:
        r14 = null;
        goto L24
    L33:
        return;
    L9:
        if (r5.c() != 0) goto L10;
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final boolean N(String r2) {
        i11.b r0 = this.d;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.N(r2);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void Q4(d11.d r19) {
        Intrinsics.checkNotNullParameter(r19, "params");
        StringBuilder r2 = new StringBuilder("link onInviteTimeOut, ");
        r2.append(r19.c);
        r2.append(' ');
        IRoom r3 = r19.h;
        if (r3 == null) goto L7;
        IBaseUser r4 = r3.getOwnerKt();
        if (r4 == null) goto L7;
        String r5 = iz.a.a(r4);
    L8:
        r2.append(r5);
        r2.append(" inviteSource=");
        r2.append(r19.n);
        jy0.b.c("ttlive_anchor_link", r2.toString(), null, 4);
        com.bytedance.android.live.revlink.impl.global.c r6 = (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class);
        if (r6 == null) goto L13;
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r7 = r6.getMultiLinkMonitor();
        if (r7 == null) goto L13;
        int r8 = r19.a;
        long r9 = r19.c;
        int r10 = r19.n;
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("invite_scene", Integer.valueOf(r8));
        r12.put("invite_source", Integer.valueOf(r10));
        r12.put("to_room_id", Long.valueOf(r9));
        r7.b(r12);
        r7.f(r12);
        r7.H("invite_timeout", r12);
    L13:
        x11.a r13 = (x11.a) KmpStatelessLiveWidget.xq(x11.a.class);
        y41.f r14 = y41.f.N;
        r14.getClass();
        if (((Boolean) y41.f.d.getValue(r14, y41.f.a[2])).booleanValue() == false) goto L33;
        i11.b r15 = this.d;
        if (r15 == null) goto L18;
        List<IBaseUser> r16 = r15.getInviteeList();
    L19:
        if (r16 != null) goto L21;
        r16 = CollectionsKt.emptyList();
    L21:
        Iterator<IBaseUser> r17 = r16.iterator();
    L23:
        if (r17.hasNext() == false) goto L33;
        IBaseUser r18 = r17.next();
        if (Intrinsics.areEqual(com.bytedance.android.live.base.model.user.o.a(r18), r19.g) == false) goto L23;
        if (r15 == null) goto L28;
        r15.r(r18);
    L28:
        MultiLinkAnchorControlContext r20 = (MultiLinkAnchorControlContext) this.q.getValue();
        if (r20 == null) goto L33;
        MultiInviteLogDataContext r22 = r20.getInviteLogContext();
        if (r22 == null) goto L33;
        r22.a(iz.a.a(r18));
        goto L33
    L18:
        r16 = null;
    L33:
        LinkCrossRoomDataHolder r23 = (LinkCrossRoomDataHolder) this.z.getValue();
        long r24 = 0;
        if (r23 != null) goto L36;
    L37:
        int r25 = r19.n;
        if (r25 != 2) goto L40;
        return;
    L40:
        if (r25 == 1) goto L76;
        if (r13 == null) goto L52;
        y11.b r26 = r13.mo1159do();
        if (r26 == null) goto L52;
        IRoom r27 = r19.h;
        if (r27 == null) goto L49;
        IBaseUser r28 = r27.getOwnerKt();
        if (r28 == null) goto L49;
        String r29 = iz.a.a(r28);
    L51:
        if (r26.a(r29) != true) goto L52;
        return;
    L49:
        r29 = null;
    L52:
        n r30 = this.a;
        if (r30 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkManager");
    L55:
        LinkCrossRoomDataHolder r32 = (LinkCrossRoomDataHolder) this.z.getValue();
        if (r32 == null) goto L58;
        r24 = r32.c();
    L58:
        long r110 = r24;
        long r111 = r19.c;
        IRoom r33 = r19.h;
        if (r33 == null) goto L63;
        IBaseUser r34 = r33.getOwnerKt();
        if (r34 == null) goto L63;
        String r112 = iz.a.a(r34);
    L64:
        r30.e(new d11.c(7, r110, r111, r112, r19.g, 0, "invite_apply_timeout"), null);
        AnchorRtcConnectManager r1 = this.f;
        if (r1 != null) goto L67;
        return;
    L67:
        if (r1.i() == true) goto L79;
        r1.l("inviteTimeout", true);
        return;
    L79:
        return;
    L63:
        r112 = null;
        goto L64
    L76:
        return;
    L36:
        if (r23.c() != 0) goto L37;
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final void S9(long r2) {
        this.D.b = r2;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void Z3(d11.g r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r1 = this.E;
        if (r1 == null) goto L22;
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r4.e != 1) goto L19;
        vh7.c r0 = r4.j.k;
        if (r0 == null) goto L19;
        e6 r2 = r0.castTo(e6.class);
        if (r2 == null) goto L19;
        v3 r3 = e21.e.b(r2);
        if (r3 == null) goto L14;
        String r5 = r3.getImprId();
        if (r5 == null) goto L14;
    L15:
        com.bytedance.android.live.revlink.impl.control.d r6 = com.bytedance.android.live.revlink.link.biz.service.i.e(r1);
        if (r6 == null) goto L19;
        r6.setRequestId(r5);
    L14:
        r5 = "";
    L19:
        if (e21.a.a(r4.b) == false) goto L23;
        LiveFullLinkPKMonitor r7 = com.bytedance.android.live.revlink.link.biz.service.i.s(r1);
        r7.getClass();
        i97.a r8 = i97.a.a;
        r7.d = System.currentTimeMillis();
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final void na(com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g r3) {
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r0 = (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e) this.w.getValue();
        if (r0 == null) goto L5;
        r0.b(null);
    L5:
        com.bytedance.android.live.revlink.impl.service.internal.a r1 = (com.bytedance.android.live.revlink.impl.service.internal.a) this.x.getValue();
        if (r1 == null) goto L9;
        r1.startSwitchPk(r3);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void reset(String r2) {
        Intrinsics.checkNotNullParameter(r2, "src");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r0 = this.E;
        if (r0 == null) goto L6;
        r0.reset(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setConnectionContext(f21.a r1) {
        this.I = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setJsbInvitePkCallback(f41.a r1) {
        this.h = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setLaunchParameters(u r1) {
        this.G = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setRtcConnectModel(AnchorRtcConnectModel r1) {
        this.g = r1;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void Y1(d11.c r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "params");
        if (this.E == null) goto L6;
        Intrinsics.checkNotNullParameter(r1, "params");
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void Z1(d11.e r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        com.bytedance.android.live.revlink.impl.global.c r1 = (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class);
        if (r1 == null) goto L8;
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r2 = r1.getMultiLinkMonitor();
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "params");
        JSONObject r3 = new JSONObject();
        int r4 = y50.b.a;
        y50.b.a.d(r3, "params", r5.toString());
        r2.E("anchor_kick_out_success", r6, r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.a
    public final void vo(String r3, com.bytedance.android.live.revenuelink.i r4) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        Intrinsics.checkNotNullParameter(r4, "source");
        jy0.b.d("ttlive_anchor_link", "unloadModule reason=".concat(r3));
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r0 = this.E;
        if (r0 == null) goto L5;
        r0.reset("finishMultiLink ".concat(r3));
    L5:
        boolean r5 = r4 instanceof com.bytedance.android.live.revenuelink.i.d;
        com.bytedance.android.live.revlink.impl.service.internal.a r6 = (com.bytedance.android.live.revlink.impl.service.internal.a) this.x.getValue();
        if (r6 == null) goto L9;
        com.bytedance.android.live.revlink.impl.service.internal.b.a.a(r6, 64, r5, 4);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void Je(int r17, i6 r18, ey.l r19) {
        Intrinsics.checkNotNullParameter(r18, "_linkerMessage");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r3 = this.E;
        if (r3 == null) goto L75;
        Intrinsics.checkNotNullParameter(r18, "_linkerMessage");
        i6 r0 = r18.castTo(i6.class);
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r1 = com.bytedance.android.live.revlink.link.biz.service.i.H(r3);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, Constants.OperatorKey.MSG);
        JSONObject r4 = new JSONObject();
        x5 r5 = r0.getCancel();
        if (r5 == null) goto L7;
        int r6 = y50.b.a;
        y50.b.a.b(r4, "invite_source", r5.getInviteSource());
    L7:
        com.bytedance.android.live.revlink.impl.multianchor.utils.v.m(r0, r4);
        r1.I("receive_cancel_msg", r4, false);
        Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
        if (((int) r0.getScene()) == 7) goto L12;
        Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
        if (((int) r0.getScene()) == 1) goto L12;
        return;
    L12:
        x5 r2 = r0.getCancel();
        if (r2 != null) goto L15;
    L19:
        AnchorRtcConnectManager r7 = r3.getRtcConnectManager();
        if (r7 == null) goto L50;
        Intrinsics.checkNotNullParameter(r0, "linkerMessage");
        if (r7.i() == true) goto L50;
        com.bytedance.android.live.revlink.impl.global.c r8 = r7.m;
        if (r8 == null) goto L29;
        com.bytedance.android.live.revenuelink.connect.g r9 = r8.getAnchorConnectUtils();
        if (r9 == null) goto L29;
        Long r10 = Long.valueOf(r9.getChannelId());
    L30:
        if (r10 != null) goto L33;
    L34:
        Intrinsics.checkNotNullParameter(r0, "$this$linkerIdExt");
        long r12 = r0.getLinkerId();
        if (r10 != null) goto L38;
    L39:
        StringBuilder r13 = new StringBuilder("receive cancel from another channel ");
        com.bytedance.android.live.revlink.impl.global.c r14 = r7.m;
        if (r14 == null) goto L46;
        com.bytedance.android.live.revenuelink.connect.g r15 = r14.getAnchorConnectUtils();
        if (r15 == null) goto L46;
        LiveData<ey.f> r16 = r15.connectState();
        if (r16 == null) goto L46;
        ey.f r20 = (ey.f) r16.getValue();
    L47:
        r13.append(r20);
        r13.append(" msgLinker=");
        Intrinsics.checkNotNullParameter(r0, "$this$linkerIdExt");
        r13.append(r0.getLinkerId());
        jy0.b.c("ttlive_anchor_connect_mgr", r13.toString(), null, 4);
    L46:
        r20 = null;
        goto L47
    L38:
        if (r12 != r10.longValue()) goto L39;
    L48:
        r7.l("receiveCancel", true);
        goto L50
    L33:
        if (r10.longValue() == 0) goto L48;
    L29:
        r10 = null;
    L50:
        if (r3.getLaunchRecord().b == 0) goto L54;
        long r110 = r3.getLaunchRecord().b;
        Intrinsics.checkNotNullParameter(r0, "$this$linkerIdExt");
        if (r110 == r0.getLinkerId()) goto L54;
        return;
    L54:
        ld.a r22 = r3.f;
        if (r22 == null) goto L59;
        NextLiveData r23 = r22.ke();
        if (r23 == null) goto L59;
        r23.setValue(0);
    L59:
        Intrinsics.checkNotNullParameter(r0, "$this$typeExt");
        int r24 = (int) r0.getType2();
        if (r24 != 9) goto L70;
        com.bytedance.android.live.revlink.impl.service.internal.a r25 = com.bytedance.android.live.revlink.link.biz.service.i.p(r3);
        if (r25 == null) goto L68;
        int r26 = r25.getCurrentMode();
        if (com.bytedance.android.live.utils.c.a(r26, 64) == true) goto L68;
        if (com.bytedance.android.live.utils.c.a(r26, 4) == true) goto L68;
        r3.finishMultiAnchor(r17, null, false, "receive_link_message_9", false);
    L68:
        int r27 = ToastUtil.a;
        int r28 = w11.a.a;
        ToastUtil.a(2131914772, 1);
        return;
    L70:
        if (r24 != 14) goto L79;
        int r29 = ToastUtil.a;
        int r30 = w11.a.a;
        ToastUtil.a(2131914725, 1);
        com.bytedance.android.live.revlink.impl.multianchor.scope.c r32 = r3.getLinkDialogService();
        if (r32 == null) goto L80;
        r32.c();
        return;
    L80:
        return;
    L79:
        return;
    L15:
        if (r2.getInviteSource() != 2) goto L19;
        jy0.b.c("ttlive_anchor_link", "receive MultiAnchorReply, dismissLinkDialog", null, 4);
        com.bytedance.android.live.revlink.impl.multianchor.scope.c r33 = r3.getLinkDialogService();
        if (r33 == null) goto L76;
        r33.c();
        return;
    L76:
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void O1(d11.e r5, Throwable r6, long r7) {
        Intrinsics.checkNotNullParameter(r5, "params");
        com.bytedance.android.live.revlink.impl.global.c r1 = (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class);
        if (r1 == null) goto L8;
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r2 = r1.getMultiLinkMonitor();
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "params");
        JSONObject r3 = new JSONObject();
        int r4 = y50.b.a;
        y50.b.a.d(r3, "params", r5.toString());
        r2.G("anchor_kick_out_failed", r6, r3, Long.valueOf(r7));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void Tg(int r1, i6 r2, ey.l r3) {
        Intrinsics.checkNotNullParameter(r2, "_linkerMessage");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r4 = this.E;
        if (r4 == null) goto L6;
        r4.b(r2);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void ej(int r1, i6 r2, ey.l r3) {
        Intrinsics.checkNotNullParameter(r2, "_linkerMessage");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r4 = this.E;
        if (r4 == null) goto L6;
        Intrinsics.checkNotNullParameter(r2, "_linkerMessage");
        i6 r5 = r2.castTo(i6.class);
        r4.b.a.a(r5);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void jo(int r22, i6 r23, ey.l.b r24) {
        Intrinsics.checkNotNullParameter(r23, "_linkerMessage");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r3 = this.E;
        if (r3 == null) goto L124;
        Intrinsics.checkNotNullParameter(r23, "_linkerMessage");
        i6 r0 = (i6) r23.castTo(i6.class);
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r1 = com.bytedance.android.live.revlink.link.biz.service.i.H(r3);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, Constants.OperatorKey.MSG);
        JSONObject r4 = new JSONObject();
        com.bytedance.android.live.revlink.impl.multianchor.utils.v.m(r0, r4);
        g1 r5 = r0.getInvite();
        if (r5 == null) goto L10;
        int r7 = y50.b.a;
        g1 r8 = r5;
        Intrinsics.checkNotNullParameter(r8, "$this$fromUid");
        String r9 = r8.get_fromUid();
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        y50.b.a.d(r4, "from_user", r9);
        y50.b.a.c(r4, "from_room", r5.getFromRoomId());
    L10:
        r1.I("receive_apply_msg", r4, false);
        Intrinsics.checkNotNullParameter(r0, "linkerMessage");
        Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
        if (((int) r0.getScene()) == 7) goto L16;
        Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
        if (((int) r0.getScene()) == 2) goto L16;
        boolean r2 = false;
    L17:
        if (r2 == true) goto L19;
        return;
    L19:
        if (r0.getInvite() != null) goto L22;
        return;
    L22:
        if (com.bytedance.android.live.revlink.link.biz.service.i.d(r3).getChannelId() == 0) goto L55;
        long r10 = com.bytedance.android.live.revlink.link.biz.service.i.d(r3).getChannelId();
        Intrinsics.checkNotNullParameter(r0, "$this$linkerIdExt");
        if (r10 == r0.getLinkerId()) goto L55;
        i11.b r12 = r3.getMLinkUserCenter();
        if (r12 == null) goto L29;
        List<p> r13 = r12.d();
        if (r13 == null) goto L29;
    L30:
        Iterator<p> r14 = r13.iterator();
        String r17 = null;
    L32:
        if (r14.hasNext() == false) goto L44;
        p r15 = r14.next();
        IBaseUser r16 = r15.getUser();
        if (r16 == null) goto L36;
        String r18 = r16.getIdString();
    L37:
        g1 r19 = r0.getInvite();
        if (r19 == null) goto L40;
        g1 r110 = r19;
        Intrinsics.checkNotNullParameter(r110, "$this$fromUid");
        String r111 = r110.get_fromUid();
    L42:
        if (Intrinsics.areEqual(r18, r111) == false) goto L32;
        IBaseUser r20 = r15.getUser();
        Intrinsics.checkNotNull(r20);
        r17 = com.bytedance.android.live.base.model.user.o.a(r20);
        goto L32
    L40:
        r111 = null;
        goto L42
    L36:
        r18 = null;
        goto L37
    L44:
        com.bytedance.android.live.revlink.link.biz.service.i.H(r3).n(r0, "channel_id_mismatch");
        n r25 = r3.getLinkOutManager();
        Intrinsics.checkNotNullParameter(r0, "$this$linkerIdExt");
        long r112 = r0.getLinkerId();
        long r113 = IRoomKtKt.getId(r3.getMRoom());
        g1 r26 = r0.getInvite();
        if (r26 == null) goto L47;
        g1 r27 = r26;
        Intrinsics.checkNotNullParameter(r27, "$this$fromUid");
        String r114 = r27.get_fromUid();
    L48:
        e6 r28 = r0.getInvite();
        if (r28 == null) goto L53;
        j5 r29 = r28.getFromLinkMicInfo();
        if (r29 == null) goto L53;
        String r115 = r29.getInteractIdStr();
    L54:
        r25.k(new d11.f(7, r112, 2, r113, r114, r17, r115), null);
    L53:
        r115 = null;
        goto L54
    L47:
        r114 = null;
    L29:
        r13 = CollectionsKt.emptyList();
    L55:
        i11.b r30 = r3.getMLinkUserCenter();
        if (r30 == null) goto L62;
        g1 r32 = r0.getInvite();
        if (r32 == null) goto L60;
        g1 r33 = r32;
        Intrinsics.checkNotNullParameter(r33, "$this$fromUid");
        String r34 = r33.get_fromUid();
    L61:
        r30.u(r34);
        goto L62
    L60:
        r34 = null;
    L62:
        u.a r35 = r3.getLaunchRecord();
        Intrinsics.checkNotNullParameter(r0, "$this$linkerIdExt");
        r35.b = r0.getLinkerId();
        u.a r6 = r3.getLaunchRecord();
        IBattleLinkerInviteMessageExtra r36 = j6.a(r0);
        if (r36 == null) goto L65;
        int r37 = (int) r36.getInviteType();
    L66:
        r6.q(r37);
        u.a r38 = r3.getLaunchRecord();
        IBaseUser r39 = r3.getMRoom().getOwnerKt();
        if (r39 == null) goto L69;
        String r40 = iz.a.a(r39);
    L70:
        r38.f = r40;
        com.bytedance.android.live.revlink.impl.multianchor.scope.c r42 = r3.getLinkDialogService();
        if (r42 == null) goto L74;
        r42.c();
    L74:
        if (r41.b.a == true) goto L129;
        Intrinsics.checkNotNullParameter(r0, "$this$typeExt");
        if (((int) r0.getType2()) != 4) goto L97;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r43 = com.bytedance.android.live.revlink.link.biz.service.i.K(r3);
        if (r43 == null) goto L97;
        if (com.bytedance.android.live.revlink.impl.multianchor.match.b.a(r43) != true) goto L97;
        com.bytedance.android.live.revlink.link.biz.service.i.H(r3).n(r0, "random_matching");
        n r44 = r3.getLinkOutManager();
        long r45 = com.bytedance.android.live.revlink.link.biz.service.i.d(r3).getChannelId();
        long r116 = IRoomKtKt.getId(r3.getMRoom());
        g1 r46 = r0.getInvite();
        if (r46 == null) goto L85;
        g1 r47 = r46;
        Intrinsics.checkNotNullParameter(r47, "$this$fromUid");
        String r117 = r47.get_fromUid();
    L86:
        g1 r48 = r0.getInvite();
        if (r48 == null) goto L89;
        g1 r49 = r48;
        Intrinsics.checkNotNullParameter(r49, "$this$secFromUid");
        String r118 = r49.get_secFromUid();
    L90:
        e6 r50 = r0.getInvite();
        if (r50 == null) goto L95;
        j5 r52 = r50.getFromLinkMicInfo();
        if (r52 == null) goto L95;
        String r119 = r52.getInteractIdStr();
    L96:
        r44.k(new d11.f(7, r45, 10, r116, r117, r118, r119), null);
        return;
    L95:
        r119 = null;
        goto L96
    L89:
        r118 = null;
        goto L90
    L85:
        r117 = null;
    L97:
        com.bytedance.android.live.revlink.impl.multianchor.scope.c r53 = r3.getLinkDialogService();
        if (r53 == null) goto L100;
        r53.d(r0);
    L100:
        AnchorRtcConnectManager r54 = r3.getRtcConnectManager();
        if (r54 == null) goto L109;
        e6 r55 = r0.getInvite();
        if (r55 == null) goto L109;
        if (r54.i() == true) goto L108;
        jy0.b.c("ttlive_anchor_connect_mgr", "receive apply when not linking", null, 4);
        goto L109
    L108:
        r54.j.updatePushRtcStreamInfo(r55.getPreRtcInfo(), r55.getMultiChannelInfo(), "receiveApply");
    L109:
        UnexpectedFrameMonitor r56 = r3.getUnexpectedFrameMonitor();
        if (r56 == null) goto L127;
        e6 r57 = r0.getInvite();
        if (r57 != null) goto L115;
        return;
    L115:
        if (y.b() == false) goto L131;
        r56.q(r57.getPreRtcInfo());
        return;
    L131:
        return;
    L127:
        return;
    L129:
        return;
    L69:
        r40 = null;
        goto L70
    L65:
        r37 = 0;
    L16:
        r2 = true;
        goto L17
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void q9(d11.c r12, long r13, ey.l r15) {
        Intrinsics.checkNotNullParameter(r12, "params");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r0 = this.E;
        if (r0 == null) goto L117;
        Intrinsics.checkNotNullParameter(r12, "params");
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r1 = com.bytedance.android.live.revlink.link.biz.service.i.H(r0);
        long r2 = r12.b;
        long r4 = r12.c;
        int r6 = r12.f;
        i97.a r7 = i97.a.a;
        long r8 = System.currentTimeMillis() - r13;
        r1.getClass();
        JSONObject r9 = new JSONObject();
        int r10 = y50.b.a;
        y50.b.a.c(r9, "req_channel_id", r2);
        y50.b.a.c(r9, "to_room_id", r4);
        y50.b.a.b(r9, "cancel_type", r6);
        r1.c(r9);
        r1.E("anchor_cancel_invite_success", r8, r9);
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.d r3 = r0.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r12, "params");
        PkInviteLogDataContext r5 = r3.a;
        String r14 = r12.d;
        if (r14 != null) goto L7;
        r5.getClass();
    L28:
        d31.f r16 = com.bytedance.android.live.revlink.link.biz.service.i.b0(r0);
        int r17 = d31.a.m;
        r16.e("linkmic/cancel/", d31.a.C0230a.a(r12), com.bytedance.android.live.revlink.impl.utils.t.a(r13));
        i11.b r18 = r0.getMLinkUserCenter();
        if (r18 == null) goto L31;
        List<IBaseUser> r19 = r18.getInviteeList();
    L32:
        if (r19 != null) goto L34;
        r19 = CollectionsKt.emptyList();
    L34:
        Iterator<IBaseUser> r110 = r19.iterator();
    L36:
        if (r110.hasNext() == false) goto L46;
        IBaseUser r20 = r110.next();
        if (Intrinsics.areEqual(com.bytedance.android.live.base.model.user.o.a(r20), r12.e) == false) goto L36;
        if (r18 == null) goto L41;
        r18.r(r20);
    L41:
        MultiLinkAnchorControlContext r111 = com.bytedance.android.live.revlink.link.biz.service.i.G(r0);
        if (r111 == null) goto L46;
        MultiInviteLogDataContext r112 = r111.getInviteLogContext();
        if (r112 == null) goto L46;
        r112.a(iz.a.a(r20));
    L46:
        if (r18 == null) goto L48;
        List<IBaseUser> r113 = r18.n();
    L49:
        if (r113 != null) goto L51;
        r113 = CollectionsKt.emptyList();
    L51:
        Iterator<IBaseUser> r114 = r113.iterator();
    L53:
        if (r114.hasNext() == false) goto L59;
        IBaseUser r22 = r114.next();
        if (Intrinsics.areEqual(com.bytedance.android.live.base.model.user.o.a(r22), r12.e) == false) goto L53;
        if (r18 == null) goto L59;
        r18.t(r22);
    L59:
        if (r12.b != r0.getLaunchRecord().b) goto L73;
        com.bytedance.android.live.revlink.impl.pk.service.a r115 = com.bytedance.android.live.revlink.link.biz.service.i.N(r0);
        if (r115 == null) goto L65;
        NextLiveData<y31.k> r116 = r115.b();
        if (r116 == null) goto L65;
        y31.k r117 = (y31.k) r116.getValue();
    L66:
        if (r117 != null) goto L73;
        ld.a r118 = r0.f;
        if (r118 == null) goto L73;
        NextLiveData r119 = r118.ke();
        if (r119 == null) goto L73;
        r119.setValue(0);
    L65:
        r117 = null;
    L73:
        if (r12.b == r0.getLaunchRecord().b) goto L75;
    L91:
        AnchorRtcConnectManager r23 = r0.getRtcConnectManager();
        if (r23 == null) goto L108;
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r23.i() == true) goto L108;
        com.bytedance.android.live.revlink.impl.global.c r120 = r23.m;
        if (r120 == null) goto L107;
        com.bytedance.android.live.revenuelink.connect.g r121 = r120.getAnchorConnectUtils();
        if (r121 == null) goto L107;
        if (r121.u1() != true) goto L107;
        StringBuilder r122 = new StringBuilder("cancel ");
        r122.append(r12.d);
        r122.append(" success but still have invitee ");
        LiveData<ey.f> r123 = r23.m.getAnchorConnectUtils().connectState();
        if (r123 == null) goto L105;
        ey.f r124 = (ey.f) r123.getValue();
    L106:
        r122.append(r124);
        jy0.b.f("ttlive_anchor_connect_mgr", r122.toString(), null, 4);
        goto L108
    L105:
        r124 = null;
    L107:
        r23.l("cancelSuccess", true);
    L108:
        if (r18 == null) goto L118;
        r18.b(4, "cancel_success_callback");
        return;
    L118:
        return;
    L75:
        if (com.bytedance.android.live.revlink.link.biz.service.i.I(r0).c() == true) goto L91;
        if (r18 == null) goto L91;
        List<IBaseUser> r24 = r18.getInviteeList();
        if (r24 == null) goto L91;
        if (r24.isEmpty() != true) goto L91;
        String r25 = r12.h;
        if (r25 != null) goto L84;
    L87:
        boolean r26 = true;
    L89:
        if ((!r26) == true) goto L91;
        Intrinsics.checkNotNullParameter(r0, "$this$anchorLinkStateCheckerObj");
        com.bytedance.android.live.revlink.link.biz.service.i.getContext(r0).of().a("linkCanceled");
        r18.clear(false);
        r0.getLaunchRecord().p("onCancelInviteSuccess");
        goto L91
    L84:
        if (r25.length() == 0) goto L87;
        r26 = false;
        goto L89
    L48:
        r113 = null;
        goto L49
    L31:
        r19 = null;
        goto L32
    L7:
        r5.a().remove(r14);
        if (r5.c != null) goto L20;
        com.bytedance.android.live.revlink.impl.global.c r27 = r5.e;
        if (r27 == null) goto L12;
        LinkRevInternalServiceContext r28 = r27.Cj();
    L13:
        if (r28 == null) goto L17;
        com.bytedance.live.datacontext.j<AnchorLinkUserCenterV2> r29 = r28.getLinkUserCenter();
        if (r29 == null) goto L17;
        AnchorLinkUserCenterV2 r30 = (AnchorLinkUserCenterV2) r29.getValue();
    L18:
        r5.c = r30;
    L17:
        r30 = null;
        goto L18
    L12:
        r28 = null;
    L20:
        if (r5.a().isEmpty() == true) goto L27;
        AnchorLinkUserCenterV2 r32 = r5.c;
        if (r32 == null) goto L27;
        List<IBaseUser> r33 = r32.getInviteeList();
        if (r33 == null) goto L27;
        if (r33.isEmpty() == false) goto L28;
    L27:
        r5.a = false;
        r5.a().clear();
        goto L28
    }

    public MultiLinkAnchorControlService(com.bytedance.android.live.revlink.impl.b r2, u51.d r3, Function0 r4, f r5) {
        Intrinsics.checkNotNullParameter(r4, "streamInteractScopeFn");
        this.P = r2;
        this.Q = r3;
        this.R = r4;
        this.S = r5;
        this.b = new CompositeDisposable();
        this.i = new MutableLiveData();
        this.j = LazyKt.lazy(new MultiLinkAnchorControlService$anchorLinkRtcService$2(this));
        this.k = LazyKt.lazy(new MultiLinkAnchorControlService$anchorConnectService$2(this));
        this.l = LazyKt.lazy(new MultiLinkAnchorControlService$roomDataCenterService$2(this));
        this.m = LazyKt.lazy(new MultiLinkAnchorControlService$linkInternalDataSet$2(this));
        this.n = LazyKt.lazy(new MultiLinkAnchorControlService$revInternalLinkService$2(this));
        this.o = LazyKt.lazy(new MultiLinkAnchorControlService$linkFakeGlobalService$2(this));
        this.p = LazyKt.lazy(new MultiLinkAnchorControlService$revLinkMultiChannelDataContext$2(this));
        this.q = LazyKt.lazy(new MultiLinkAnchorControlService$multiLinkAnchorControlContext$2(this));
        this.r = LazyKt.lazy(new MultiLinkAnchorControlService$multiAnchorPkLaunchService$2(this));
        this.s = LazyKt.lazy(new MultiLinkAnchorControlService$multiAnchorLinkContext$2(this));
        this.t = LazyKt.lazy(new MultiLinkAnchorControlService$anchorConnectionContextObj$2(this));
        this.u = LazyKt.lazy(new MultiLinkAnchorControlService$linkCrossRoomDataHolder$2(this));
        this.v = LazyKt.lazy(new MultiLinkAnchorControlService$multiAnchorLinkContextObj$2(this));
        this.w = LazyKt.lazy(new MultiLinkAnchorControlService$linkOptLogContext$2(this));
        this.x = LazyKt.lazy(new MultiLinkAnchorControlService$linkRevInternalService$2(this));
        this.y = LazyKt.lazy(new MultiLinkAnchorControlService$linkRevInternalServiceContext$2(this));
        this.z = LazyKt.lazy(new MultiLinkAnchorControlService$mDataHolder$2(this));
        this.D = new u.a();
        this.K = LazyKt.lazy(new MultiLinkAnchorControlService$relinkService$2(this));
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void Cn(d11.g r16, Throwable r17, long r18, ey.l r20) {
        Intrinsics.checkNotNullParameter(r16, "params");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r3 = this.E;
        if (r3 == null) goto L25;
        Intrinsics.checkNotNullParameter(r16, "params");
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r1 = com.bytedance.android.live.revlink.link.biz.service.i.H(r3);
        int r4 = r16.a;
        d11.a r5 = r16.j;
        i97.a r6 = i97.a.a;
        long r7 = System.currentTimeMillis() - r18;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "replyParams");
        JSONObject r8 = new JSONObject();
        int r9 = y50.b.a;
        y50.b.a.b(r8, "req_scene", r4);
        y50.b.a.d(r8, "reply_params", r5.toString());
        y50.b.a.b(r8, "invite_type", r5.b);
        y50.b.a.b(r8, "invite_source", r5.c);
        y50.b.a.b(r8, "match_type", r5.a);
        y50.b.a.d(r8, "req_from", r5.h);
        r1.c(r8);
        r1.G("anchor_reply_failed", r17, r8, Long.valueOf(r7));
        d31.f r10 = com.bytedance.android.live.revlink.link.biz.service.i.b0(r3);
        int r2 = d31.a.m;
        r10.c("linkmic/reply/", d31.a.C0230a.c(r16), r17, com.bytedance.android.live.revlink.impl.utils.t.a(r18));
        if (r16.j.f == false) goto L8;
        return;
    L8:
        if (com.bytedance.android.live.revlink.link.biz.service.i.I(r3).c() == true) goto L26;
        i11.b r0 = r3.getMLinkUserCenter();
        if (r0 == null) goto L12;
        r0.f(false);
    L12:
        r3.getLaunchRecord().p("onReplyFailed");
        com.bytedance.android.live.revlink.impl.service.internal.a r12 = com.bytedance.android.live.revlink.link.biz.service.i.p(r3);
        if (r12 == null) goto L15;
        r12.onMultiAnchorStateChange(0);
    L15:
        AnchorRtcConnectManager r13 = r3.getRtcConnectManager();
        if (r13 == null) goto L27;
        com.bytedance.android.live.revlink.impl.global.c r14 = r13.m;
        if (r14 == null) goto L23;
        com.bytedance.android.live.revenuelink.connect.g r15 = r14.getAnchorConnectUtils();
        if (r15 == null) goto L23;
        if (r15.u1() != true) goto L23;
        return;
    L23:
        r13.l("replyFailed", true);
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void Jd(d11.f r22, com.bytedance.android.livesdk.link.model.v r23, long r24, ey.l r26) {
        Intrinsics.checkNotNullParameter(r22, "params");
        Intrinsics.checkNotNullParameter(r23, "_permitData");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r5 = this.E;
        if (r5 == null) goto L37;
        Intrinsics.checkNotNullParameter(r22, "params");
        Intrinsics.checkNotNullParameter(r23, "_permitData");
        com.bytedance.android.livesdk.link.model.v r1 = r23.castTo(com.bytedance.android.livesdk.link.model.v.class);
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r2 = com.bytedance.android.live.revlink.link.biz.service.i.H(r5);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, Constants.Keys.DATA);
        JSONObject r3 = new JSONObject();
        int r6 = y50.b.a;
        y50.b.a.d(r3, "resp_link_id", r1.getLinkMicIdStr());
        boolean r7 = false;
        r2.I("anchor_permit_success", r3, false);
        com.bytedance.android.live.revlink.link.biz.service.i.b0(r5).e("linkmic/permit/", new d31.a(0, 0, 0, r22.a, null, r22.c, 0, null, null, null, null, 4055), com.bytedance.android.live.revlink.impl.utils.t.a(r24));
        String r4 = r1.getFromUid();
        i11.b r8 = r5.getMLinkUserCenter();
        if (r8 == null) goto L7;
        String r9 = r8.w();
    L9:
        if (Intrinsics.areEqual(r4, r9) == false) goto L12;
        r5.getMLinkUserCenter().u(null);
    L12:
        if (r22.c != 1) goto L33;
        u.a r0 = r5.getLaunchRecord();
        if (r1.getLinkMicIdStr().length() != 0) goto L16;
        r7 = true;
    L16:
        if (r7 == false) goto L18;
        String r10 = String.valueOf(r1.getLinkMicId());
    L19:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r0.i = r10;
        r5.getLaunchRecord().j = r1.getRtcExtInfo();
        b7 r12 = r1.getMultiChannelInfo();
        if (r12 != null) goto L22;
    L28:
        v51.b r13 = (v51.b) r5.getStreamInteractScopeFn().invoke();
        if (r13 == null) goto L33;
        AnchorUILayoutManager r14 = com.bytedance.android.live.revlink.link.utils.a.b(r13);
        if (r14 == null) goto L33;
        r14.a(new com.bytedance.android.live.revlink.link.core.service.o(r1.getLayoutInfo().getLayoutDetails()), "multi_permit_success");
        goto L33
    L22:
        if (r12.getUseMultiChannel() == false) goto L28;
        Map r15 = r12.getChannelMap();
        if (r15 == null) goto L28;
        if ((!r15.isEmpty()) != true) goto L28;
        r5.getLaunchRecord().e = r12;
        goto L28
    L18:
        r10 = r1.getLinkMicIdStr();
    L33:
        i11.b r16 = r5.getMLinkUserCenter();
        if (r16 == null) goto L38;
        r16.b(4, "permit_success");
        return;
    L38:
        return;
    L7:
        r9 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void O8(d11.b r20, com.bytedance.android.livesdk.link.model.f r22, long r23, ey.l r24) {
        Intrinsics.checkNotNullParameter(r20, "params");
        Intrinsics.checkNotNullParameter(r22, "applyResult");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r5 = this.E;
        if (r5 == null) goto L29;
        Intrinsics.checkNotNullParameter(r20, "params");
        Intrinsics.checkNotNullParameter(r22, "applyResult");
        com.bytedance.android.live.revlink.link.biz.service.i.b0(r5).e("linkmic/apply/", new d31.a(0, 0, 0, r20.a, null, r20.d, 0, null, null, null, null, 4055), com.bytedance.android.live.revlink.impl.utils.t.a(r23));
        IBaseUser r2 = r20.h.getOwnerKt();
        if (r2 == null) goto L9;
        i11.b r3 = r5.getMLinkUserCenter();
        if (r3 == null) goto L9;
        r3.q(r2);
    L9:
        u.a r4 = r5.getLaunchRecord();
        r4.b = r20.g;
        r5.getLaunchRecord().q(r20.d);
        u.a r6 = r5.getLaunchRecord();
        IBaseUser r7 = r20.h.getOwnerKt();
        if (r7 == null) goto L12;
        String r8 = iz.a.a(r7);
    L13:
        r6.f = r8;
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r9 = com.bytedance.android.live.revlink.link.biz.service.i.H(r5);
        int r10 = r20.a;
        IRoomBase r0 = r20.h;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "targetRoom");
        JSONObject r12 = new JSONObject();
        int r13 = y50.b.a;
        y50.b.a.b(r12, "req_scene", r10);
        y50.b.a.c(r12, "target_room", IRoomKtKt.getId(r0));
        r9.I("anchor_apply_success", r12, false);
        AnchorRtcConnectManager r1 = r5.getRtcConnectManager();
        if (r1 == null) goto L22;
        Intrinsics.checkNotNullParameter(r22, "_applyResult");
        com.bytedance.android.livesdk.link.model.f r14 = r22.castTo(com.bytedance.android.livesdk.link.model.f.class);
        if (r1.i() == true) goto L22;
        r1.j.onApplySuccess(r14);
        if (r1.j.enableFirstFrameOpt() == false) goto L22;
        r1.k(AnchorRtcConnectUtilsKt.b(r14.getMultiRtcInfo(), ""), "applySuccess", BizType.AnchorLink.ordinal());
    L22:
        UnexpectedFrameMonitor r15 = r5.getUnexpectedFrameMonitor();
        if (r15 == null) goto L30;
        Intrinsics.checkNotNullParameter(r22, "_applyResult");
        com.bytedance.android.livesdk.link.model.f r16 = r22.castTo(com.bytedance.android.livesdk.link.model.f.class);
        if (y.b() == true) goto L31;
        r15.q(r16.getPreRtcInfo());
        return;
    L31:
        return;
    L30:
        return;
    L12:
        r8 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void Vc(d11.b r22, Throwable r23, long r24, ey.l.b r26) {
        Intrinsics.checkNotNullParameter(r22, "params");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r4 = this.E;
        if (r4 == null) goto L20;
        Intrinsics.checkNotNullParameter(r22, "params");
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r2 = com.bytedance.android.live.revlink.link.biz.service.i.H(r4);
        int r5 = r22.a;
        r2.getClass();
        JSONObject r6 = new JSONObject();
        int r7 = y50.b.a;
        y50.b.a.b(r6, "req_scene", r5);
        Throwable r8 = null;
        r2.G("anchor_apply_failed", r23, r6, null);
        d31.f.d(com.bytedance.android.live.revlink.link.biz.service.i.b0(r4), "linkmic/apply/", new d31.a(0, 0, 0, r22.a, null, r22.d, 0, null, null, null, null, 4055), r23);
        if ((r23 instanceof ApiServerException) == false) goto L8;
        r8 = r23;
    L8:
        ApiServerException r9 = (ApiServerException) r8;
        if (r9 == null) goto L21;
        int r0 = ((ApiServerException) r23).getErrorCode();
        if (r0 != 31012) goto L14;
        r4.a();
        return;
    L14:
        if (r0 != 4004129) goto L16;
    L17:
        com.bytedance.android.live.revlink.impl.multianchor.connect.h.b(r0, BizType.AnchorLink.ordinal());
    L18:
        int r1 = ToastUtil.a;
        ToastUtil.b(r9.getPrompt(), 0);
        return;
    L16:
        if (r0 != 4004130) goto L18;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void hl(d11.d r22, long r23, v4 r24, ey.l r25) {
        Intrinsics.checkNotNullParameter(r22, "params");
        Intrinsics.checkNotNullParameter(r24, "_inviteResult");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r6 = this.E;
        if (r6 == null) goto L167;
        Intrinsics.checkNotNullParameter(r22, "params");
        Intrinsics.checkNotNullParameter(r24, "_inviteResult");
        v4 r1 = r24.castTo(v4.class);
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.d r7 = r6.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r22, "params");
        Intrinsics.checkNotNullParameter(r1, "inviteResult");
        if (r22.n != 2) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == true) goto L10;
        r7.getLaunchRecord().b = r1.getChannelId();
    L10:
        r7.getLaunchRecord().k = r22.h;
        r7.getLaunchRecord().l = r1.getSupportMultiInvite();
        r7.a.a = r1.getSupportMultiInvite();
        if (com.bytedance.android.live.revlink.link.biz.service.i.d(r7).s1() == 1) goto L13;
    L22:
        LiveFullLinkPKMonitor r8 = com.bytedance.android.live.revlink.link.biz.service.i.s(r6);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "inviteResult");
        r8.b = 0;
        r8.c = 0;
        r8.d = 0;
        r8.e = 0;
        r8.j = 0;
        r8.k = 0;
        r8.l = false;
        r8.m = false;
        r8.h = false;
        i97.a r10 = i97.a.a;
        r8.b = System.currentTimeMillis();
        r8.l = r1.getSupportMultiInvite();
        d31.f r12 = com.bytedance.android.live.revlink.link.biz.service.i.b0(r6);
        int r13 = d31.a.m;
        r12.e("linkmic/invite/", d31.a.C0230a.b(r22), com.bytedance.android.live.revlink.impl.utils.t.a(r23));
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r14 = com.bytedance.android.live.revlink.link.biz.service.i.H(r6);
        int r15 = r22.a;
        IRoomBase r16 = r22.h;
        int r17 = r22.d;
        long r18 = System.currentTimeMillis() - r23;
        long r19 = com.bytedance.android.live.revlink.link.biz.service.i.d(r6).getChannelId();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r1, "inviteResult");
        Intrinsics.checkNotNullParameter(r22, "inviteParams");
        JSONObject r110 = new JSONObject();
        int r111 = y50.b.a;
        if (r16 == null) goto L25;
        long r4 = IRoomKtKt.getId(r16);
    L26:
        y50.b.a.c(r110, "target_room", r4);
        y50.b.a.b(r110, "invite_type", r17);
        y50.b.a.b(r110, "match_type", r22.e);
        y50.b.a.b(r110, "invite_source", r22.n);
        y50.b.a.b(r110, "req_scene", r15);
        y50.b.a.c(r110, "invite_channel_id", r1.getChannelId());
        b7 r5 = r1.getMultiChannelInfo();
        if (r5 == null) goto L29;
        String r20 = c7.a(r5);
    L30:
        y50.b.a.d(r110, "multi_channel_info", r20);
        b2 r26 = r1.getPreRtcInfo();
        if (r26 == null) goto L33;
        String r27 = c2.a(r26);
    L34:
        y50.b.a.d(r110, "pre_rtc_info", r27);
        r14.c(r110);
        if (r19 != 0) goto L37;
        new LinkedHashMap().put("extra_str", r110.toString());
    L37:
        r14.E("anchor_invite_success", r18, r110);
        if (com.bytedance.android.live.revlink.link.biz.service.i.d(r6).getChannelId() <= 0) goto L46;
        IRoom r28 = r22.h;
        if (r28 == null) goto L46;
        IBaseUser r29 = r28.getOwnerKt();
        if (r29 == null) goto L46;
        i11.b r30 = r6.getMLinkUserCenter();
        if (r30 == null) goto L46;
        r30.e(new i11.d(r29, r22.s));
    L46:
        f41.a r32 = r6.getJsbInvitePkCallback();
        if (r32 == null) goto L49;
        r32.a();
        r6.setJsbInvitePkCallback(null);
    L49:
        AnchorRtcConnectManager r33 = r6.getRtcConnectManager();
        if (r33 == null) goto L75;
        Intrinsics.checkNotNullParameter(r22, "params");
        String r34 = "_inviteResult";
        Intrinsics.checkNotNullParameter(r1, r34);
        v4 r112 = r1.castTo(v4.class);
        if (r22.n != 2) goto L54;
        boolean r35 = true;
    L55:
        if (r35 == true) goto L76;
        com.bytedance.android.live.revlink.impl.global.c r36 = r33.m;
        if (r36 == null) goto L71;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r37 = r36.getMultiLinkUtil();
        if (r37 == null) goto L71;
        if (r37.c() != true) goto L71;
        if (r33.m.getMultiLinkUtil().e() == false) goto L69;
        g0 r113 = r33.m.Rn();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r22, "params");
        jy0.b.c("ttlive_anchor_link", "unexpected invite when in double pk " + r22, null, 4);
        JSONObject r114 = new JSONObject();
        y50.b.a.d(r114, "invite_params", r22.toString());
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r115 = r113.o();
        if (r115 == null) goto L69;
        r115.I("unexpected_invite_resp_in_double_pk", r114, true);
    L69:
        if (r33.m.getMultiLinkUtil().d() == false) goto L76;
        r33.j.updatePushRtcStreamInfo(r112.getPreRtcInfo(), r112.getMultiChannelInfo(), "linkInviteSuccess");
    L71:
        r33.j.onInviteSuccess(r112);
        if (r33.j.enableFirstFrameOpt() == false) goto L76;
        r33.k(AnchorRtcConnectUtilsKt.b(r112.getMultiRtcInfo(), r112.getRtcExtInfo()), "inviteSuccess", r112.getBizType());
    L76:
        UnexpectedFrameMonitor r38 = r6.getUnexpectedFrameMonitor();
        if (r38 == null) goto L91;
        Intrinsics.checkNotNullParameter(r22, "params");
        Intrinsics.checkNotNullParameter(r1, r34);
        v4 r39 = r1.castTo(v4.class);
        if (r22.n != 2) goto L81;
        boolean r116 = true;
    L82:
        if (r116 == true) goto L91;
        if (y.c() == true) goto L90;
        com.bytedance.android.live.revenuelink.connect.g r117 = com.bytedance.android.live.revlink.impl.global.b.b();
        if (r117 == null) goto L90;
        if (r117.v1() == true) goto L91;
    L90:
        r38.q(r39.getPreRtcInfo());
        goto L91
    L81:
        r116 = false;
    L91:
        MultiLinkAnchorControlContext r40 = r6.getControlContext();
        if (r40 == null) goto L103;
        MultiInviteLogDataContext r42 = r40.getInviteLogContext();
        if (r42 == null) goto L103;
        Intrinsics.checkNotNullParameter(r22, "params");
        IRoom r43 = r22.h;
        if (r43 == null) goto L100;
        IBaseUser r44 = r43.getOwnerKt();
        if (r44 == null) goto L100;
        String r45 = r44.getIdString();
    L101:
        if (r45 == null) goto L103;
        ((Map) r42.b.getValue()).put(r45, r22);
    L100:
        r45 = null;
    L103:
        String r46 = r22.f;
        if (r46 != null) goto L106;
        r46 = "";
    L106:
        r6.e.remove(r46);
        i6 r47 = (i6) ((LinkedHashMap) r6.d).get(r46);
        if (r47 == null) goto L110;
        r6.getLinkOutManager().c(r47);
    L110:
        if (r25 == null) goto L168;
        ey.f r48 = r25.a;
        if (r48 != null) goto L114;
        return;
    L114:
        if (r48.d == 0) goto L116;
        return;
    L116:
        if (r25.b.d != 1) goto L176;
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.d r2 = r6.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r22, "params");
        Intrinsics.checkNotNullParameter(r1, "inviteResult");
        u.a r3 = r2.getLaunchRecord();
        r3.u = true;
        r3.v = r2.isLinkWithAudience();
        r3.y = r1.getInviteeWithAudience();
        r3.z = l51.a.j();
        String r49 = l51.a.m();
        Intrinsics.checkNotNullParameter(r49, "<set-?>");
        r3.A = r49;
        Intrinsics.checkNotNullParameter(r1, "$this$cannotPkAnchorUidList");
        List r50 = r1.get_cannotPkAnchorIds();
        if (r50 != null) goto L122;
        r50 = null;
    L122:
        if (r50 == null) goto L124;
        List<String> r52 = CollectionsKt.toList(r50);
    L125:
        r3.B = r52;
        r3.C = r1.getSwitchPlayMode();
        r3.D = r1.getVoteSetting();
        IRoom r53 = r22.h;
        if (r53 == null) goto L131;
        IBaseUser r54 = r53.getOwnerKt();
        if (r54 == null) goto L131;
        String r55 = r54.getIdString();
        if (r55 == null) goto L131;
    L137:
        r3.q = r55;
        IRoom r56 = r22.h;
        if (r56 == null) goto L140;
        IBaseUser r57 = r56.getOwnerKt();
    L141:
        r3.o = r57;
        IRoomBase r58 = r22.h;
        if (r58 == null) goto L145;
        IRoomKtKt.getId(r58);
    L145:
        if (r3.c != 12) goto L147;
        r3.E = com.bytedance.android.live.revlink.link.biz.service.i.h(r2).g;
    L147:
        r3.a = com.bytedance.android.live.revlink.impl.multianchor.connect.h.a(r1, IRoomKtKt.getId(r2.getMRoom()));
        jy0.b.c("rev_double_guest_linker_id", "handle invite success set guestUserLinkerID: " + r3.a, null, 4);
        LiveFullLinkPKMonitor r59 = com.bytedance.android.live.revlink.link.biz.service.i.s(r2);
        b2 r60 = r1.getPreRtcInfo();
        if (r60 == null) goto L150;
        boolean r62 = r60.getRtcJoinChannel();
    L151:
        r59.f = r62;
        LiveFullLinkPKMonitor r63 = com.bytedance.android.live.revlink.link.biz.service.i.s(r2);
        b2 r64 = r1.getPreRtcInfo();
        if (r64 == null) goto L154;
        boolean r118 = r64.getRtcJoinChannel();
    L155:
        r63.g = r118;
        if (e21.a.a(r22.i) == false) goto L171;
        com.bytedance.android.live.revlink.impl.pk.service.a r0 = com.bytedance.android.live.revlink.link.biz.service.i.N(r2);
        if (r0 != null) goto L160;
        return;
    L160:
        if (r0.isInviting() == true) goto L173;
        ld.a r65 = r2.getLinkInternalDataSet();
        if (r65 == null) goto L174;
        NextLiveData r66 = r65.ke();
        if (r66 == null) goto L175;
        r66.setValue(1);
        return;
    L175:
        return;
    L174:
        return;
    L173:
        return;
    L171:
        return;
    L154:
        r118 = false;
        goto L155
    L150:
        r62 = false;
        goto L151
    L140:
        r57 = null;
    L131:
        IRoom r67 = r22.h;
        if (r67 == null) goto L136;
        IBaseUser r68 = r67.getOwnerKt();
        if (r68 == null) goto L136;
        r55 = r68.getIdString();
    L136:
        r55 = null;
        goto L137
    L124:
        r52 = null;
        goto L125
    L176:
        return;
    L168:
        return;
    L54:
        r35 = false;
        goto L55
    L75:
        r34 = r4;
        goto L76
    L33:
        r27 = null;
        goto L34
    L29:
        r20 = null;
        goto L30
    L25:
        r4 = 0;
        goto L26
    L13:
        if (e21.a.a(r22.i) == false) goto L22;
        r7.getLaunchRecord().n++;
        PkInviteLogDataContext r69 = r7.a;
        r69.getClass();
        Intrinsics.checkNotNullParameter(r22, "params");
        IRoom r70 = r22.h;
        if (r70 == null) goto L19;
        IBaseUser r72 = r70.getOwnerKt();
        if (r72 == null) goto L19;
        String r73 = r72.getIdString();
    L20:
        if (r73 == null) goto L22;
        r69.b++;
        r69.a().put(r73, TuplesKt.to(Integer.valueOf(r69.b), r22));
    L19:
        r73 = null;
        goto L20
    L7:
        r9 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void nf(d11.g r1, q5 r2, long r3, ey.l r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r2, "_replyResult");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r6 = this.E;
        if (r6 == null) goto L6;
        r6.c(r1, r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void pp(d11.f r22, Throwable r23, long r24, ey.l.b r26) {
        Intrinsics.checkNotNullParameter(r22, "params");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r4 = this.E;
        if (r4 == null) goto L11;
        Intrinsics.checkNotNullParameter(r22, "params");
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r2 = com.bytedance.android.live.revlink.link.biz.service.i.H(r4);
        int r5 = r22.a;
        r2.getClass();
        JSONObject r6 = new JSONObject();
        int r7 = y50.b.a;
        y50.b.a.b(r6, "req_scene", r5);
        r2.G("anchor_permit_failed", r23, r6, null);
        d31.f.d(com.bytedance.android.live.revlink.link.biz.service.i.b0(r4), "linkmic/permit/", new d31.a(0, 0, 0, r22.a, null, r22.c, 0, null, null, null, null, 4055), r23);
        i11.b r0 = r4.getMLinkUserCenter();
        if (r0 == null) goto L7;
        r0.u(null);
    L7:
        i11.b r1 = r4.getMLinkUserCenter();
        if (r1 == null) goto L12;
        r1.b(4, "permit_failed");
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void rp(d11.d r9, Throwable r10, long r12, ey.l.b r13) {
        Intrinsics.checkNotNullParameter(r9, "params");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r0 = this.E;
        if (r0 == null) goto L64;
        Intrinsics.checkNotNullParameter(r9, "params");
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r1 = com.bytedance.android.live.revlink.link.biz.service.i.H(r0);
        int r2 = r9.a;
        i97.a r3 = i97.a.a;
        long r4 = System.currentTimeMillis() - r12;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "params");
        JSONObject r14 = new JSONObject();
        int r5 = y50.b.a;
        y50.b.a.b(r14, "req_scene", r2);
        y50.b.a.d(r14, "invite_params", r9.toString());
        y50.b.a.b(r14, "match_type", r9.e);
        y50.b.a.b(r14, "invite_source", r9.n);
        y50.b.a.b(r14, "invite_type", r9.d);
        r1.c(r14);
        r1.G("anchor_invite_failed", r10, r14, Long.valueOf(r4));
        f41.a r15 = r0.getJsbInvitePkCallback();
        if (r15 == null) goto L7;
        r15.b();
        r0.setJsbInvitePkCallback(null);
    L7:
        d31.f r6 = com.bytedance.android.live.revlink.link.biz.service.i.b0(r0);
        int r16 = d31.a.m;
        r6.c("linkmic/invite/", d31.a.C0230a.b(r9), r10, com.bytedance.android.live.revlink.impl.utils.t.a(r12));
        if (r41.b.a == false) goto L12;
        if (r9.e == 0) goto L12;
    L26:
        if (e21.a.a(r9.i) == false) goto L66;
        HashMap r17 = new HashMap();
        r17.put("event_name", "INVITE_BATTLE_FAILED");
        IRoomBase r18 = com.bytedance.android.live.revlink.link.biz.service.i.T(r0).k();
        if (r18 == null) goto L31;
        String r19 = String.valueOf(IRoomKtKt.getId(r18));
        if (r19 == null) goto L31;
    L32:
        r17.put("target_room_id", r19);
        int r110 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.f("ttlive_pk", r17);
        com.bytedance.android.live.revlink.impl.service.internal.a r20 = com.bytedance.android.live.revlink.link.biz.service.i.p(r0);
        if (r20 == null) goto L67;
        r20.getCurrentMode();
        com.bytedance.android.live.revenuelink.connect.f r22 = r0.getAnchorConnectService();
        if (r22 == null) goto L41;
        LiveData<ey.f> r23 = r22.connectState();
        if (r23 == null) goto L41;
        ey.f r24 = (ey.f) r23.getValue();
        if (r24 == null) goto L41;
        Integer r25 = Integer.valueOf(r24.d);
    L43:
        if (r25 == null) goto L48;
        if (r25.intValue() != 4) goto L48;
        return;
    L48:
        if (r25 != null) goto L51;
    L52:
        Intrinsics.checkNotNullParameter(r0, "$this$anchorLinkStateCheckerObj");
        com.bytedance.android.live.revlink.link.biz.service.i.getContext(r0).of().a("pkInviteFailed");
        Intrinsics.checkNotNullParameter(r0, "$this$anchorLinkOptUtils");
        AnchorLinkOptUtils r26 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(r0).vk();
        if (r26.c() == true) goto L55;
    L57:
        boolean r27 = false;
    L58:
        if (r27 == true) goto L60;
    L62:
        r0.reset("onInviteFailed");
        return;
    L60:
        if (com.bytedance.android.live.revlink.link.biz.service.i.I(r0).d() != true) goto L62;
        jy0.b.f("ttlive_anchor_link", "pkInviteFailed intercept reset dataHolder", null, 4);
        goto L62
    L55:
        if (r26.b().k0() == false) goto L57;
        r27 = true;
        goto L58
    L51:
        if (r25.intValue() != 1) goto L52;
        return;
    L41:
        r25 = null;
        goto L43
    L67:
        return;
    L31:
        r19 = "";
        goto L32
    L66:
        return;
    L12:
        if ((r10 instanceof ApiServerException) == true) goto L14;
        Throwable r111 = null;
    L16:
        if (((ApiServerException) r111) == null) goto L26;
        int r112 = ((ApiServerException) r10).getErrorCode();
        if (r112 != 31012) goto L21;
        r0.a();
        return;
    L21:
        if (r112 != 4004129) goto L23;
    L24:
        com.bytedance.android.live.revlink.impl.multianchor.connect.h.b(r112, r9.i);
        goto L26
    L23:
        if (r112 != 4004130) goto L26;
    L14:
        r111 = r10;
        goto L16
    }

    @Override // com.bytedance.android.live.revenuelink.connect.m
    public final void wh(d11.c r15, Throwable r16, long r17, ey.l r19) {
        Intrinsics.checkNotNullParameter(r15, "params");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r3 = this.E;
        if (r3 == null) goto L15;
        Intrinsics.checkNotNullParameter(r15, "params");
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r1 = com.bytedance.android.live.revlink.link.biz.service.i.H(r3);
        i97.a r4 = i97.a.a;
        long r5 = System.currentTimeMillis() - r17;
        r1.getClass();
        JSONObject r6 = new JSONObject();
        r1.c(r6);
        r1.G("anchor_cancel_invite_failed", r16, r6, Long.valueOf(r5));
        d31.f r8 = com.bytedance.android.live.revlink.link.biz.service.i.b0(r3);
        int r2 = d31.a.m;
        r8.c("linkmic/cancel/", d31.a.C0230a.a(r15), r16, com.bytedance.android.live.revlink.impl.utils.t.a(r17));
        com.bytedance.android.live.revenuelink.connect.f r0 = r3.getAnchorConnectService();
        if (r0 == null) goto L13;
        LiveData<ey.f> r7 = r0.connectState();
        if (r7 == null) goto L13;
        ey.f r9 = (ey.f) r7.getValue();
        if (r9 == null) goto L13;
        if (r9.d != 4) goto L13;
        return;
    L13:
        r3.reset("onCancelInviteFailed");
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.d, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void finishMultiAnchor(int r3, Function0<Unit> r4, boolean r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "reqSrc");
        if (r3 != 14) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = (com.bytedance.android.live.revlink.impl.service.internal.a) this.x.getValue();
        if (r0 != null) goto L8;
    L12:
        if (r4 != null) goto L30;
        if (r7 == false) goto L16;
        y41.f r8 = y41.f.N;
        r8.getClass();
        if (((Boolean) y41.f.c.getValue(r8, y41.f.a[1])).booleanValue() == true) goto L16;
    L27:
        com.bytedance.android.live.revlink.impl.multianchor.scope.c r9 = getLinkDialogService();
        if (r9 == null) goto L30;
        r9.c();
    L16:
        com.bytedance.android.live.revlink.impl.global.c r10 = (com.bytedance.android.live.revlink.impl.global.c) KmpStatelessLiveWidget.xq(com.bytedance.android.live.revlink.impl.global.c.class);
        if (r10 == null) goto L21;
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r12 = r10.of();
        if (r12 == null) goto L21;
        r12.a("finish_" + r6);
    L21:
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.e r13 = this.E;
        if (r13 == null) goto L24;
        r13.reset("finishMultiAnchor " + r6);
    L24:
        i11.b r14 = this.d;
        if (r14 == null) goto L27;
        r14.clear(false);
    L30:
        if (r5 == false) goto L35;
        com.bytedance.android.live.revlink.impl.multianchor.scope.c r15 = getLinkDialogService();
        if (r15 == null) goto L36;
        r15.c();
        return;
    L36:
        return;
    L35:
        return;
    L8:
        if (r3 != 7) goto L12;
        if (r0.k0(64) == false) goto L12;
        r0.tn(r4, r6, r7);
        goto L12
    }
}
