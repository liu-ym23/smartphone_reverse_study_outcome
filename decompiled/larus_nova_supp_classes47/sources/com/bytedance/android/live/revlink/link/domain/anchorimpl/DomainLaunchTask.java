package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.core.service.r;
import com.bytedance.android.live.revlink.link.streaminteract.biz.PushModeManagerService;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import com.bytedance.android.livesdk.link.model.bridge.o1;
import com.bytedance.android.livesdk.link.model.bridge.p1;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.y6;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DomainLaunchTask extends com.bytedance.android.live.revenuelink.rtc.e implements com.bytedance.android.live.revenuelink.connect.i, com.bytedance.android.live.revlink.link.biz.service.c {
    public static final /* synthetic */ int h = 0;
    public final String a;
    public final CompositeDisposable b;
    public final com.bytedance.android.live.revenuelink.rtc.i c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g d;
    public final PushModeManagerService e;
    public final AnchorUILayoutManager f;
    public final com.bytedance.android.livesdk.revenue.service.room.c g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.domain.anchorimpl.DomainLaunchTask$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(DomainLaunchTask r8) {
            super(0, r8, DomainLaunchTask.class, "onSwitchScene", "onSwitchScene()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m933invoke() {
            DomainLaunchTask r0 = (DomainLaunchTask) ((CallableReference) this).receiver;
            int r1 = DomainLaunchTask.h;
            int r2 = r0.getContext().d.o;
            if (r2 != 1) goto L5;
            IConfig.b.c1.getClass();
            IConfig.b r3 = IConfig.b.a.b;
            if (r3 == null) goto L14;
            vc0.a r4 = vc0.b.a(r3);
            r0.c.v1(r4, 1, 2);
        L14:
            if (r0.c.Q0() == true) goto L16;
            r0.c.q1("switch scene");
        L16:
            r0.j();
            return;
        L5:
            if (r2 != 7) goto L14;
            IConfig.b.c1.getClass();
            IConfig.b r5 = IConfig.b.a.a;
            if (r5 == null) goto L14;
            vc0.a r6 = vc0.b.a(r5);
            r0.c.v1(r6, 7, 6);
            goto L14
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m933invoke();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void Z2(fy.d r2) {
        Intrinsics.checkNotNullParameter(r2, "finishParams");
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void h3(fy.f r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "joinChannelParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void i3(fy.d r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "finishParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void k3(fy.h r1, ExtraResponse<n0, Extra> r2) {
        Intrinsics.checkNotNullParameter(r1, "leaveParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void m2(fy.h r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "leaveParams");
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        j();
        com.bytedance.android.live.revenuelink.connect.f r0 = getContext().Z0();
        if (r0 == null) goto L5;
        r0.addLinkInListener(1, this);
    L5:
        com.bytedance.android.live.revenuelink.connect.f r1 = getContext().Z0();
        if (r1 == null) goto L8;
        r1.addLinkInListener(7, this);
    L8:
        this.c.g1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.g(getContext().d.e, new AnonymousClass1(this)), this.b);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        com.bytedance.android.live.revenuelink.connect.f r0 = getContext().Z0();
        if (r0 == null) goto L5;
        r0.removeLinkInListener(1, this);
    L5:
        com.bytedance.android.live.revenuelink.connect.f r1 = getContext().Z0();
        if (r1 == null) goto L8;
        r1.removeLinkInListener(7, this);
    L8:
        this.c.i1(this);
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    public final void j() {
        getContext().getClass();
        if (getContext().o == false) goto L8;
        if (this.c.isEngineOn() == true) goto L8;
        jy0.b.c("RevenueLinkAnchorComponent", "rtc start wrong", null, 4);
    L8:
        if (this.c.isEngineOn() == false) goto L11;
        o();
        return;
    L11:
        boolean r0 = getContext().p;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void o() {
        NextLiveData<com.bytedance.android.live.revlink.link.core.layoutstatus.l> r0 = getContext().a;
        com.bytedance.android.live.revlink.link.core.layoutstatus.l r1 = com.bytedance.android.live.revlink.link.core.layoutstatus.l.c;
        r0.setValue(com.bytedance.android.live.revlink.link.core.layoutstatus.l.c);
        getContext().l.h();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g getContext() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void m3(fy.f r19, ExtraResponse<com.bytedance.android.livesdk.link.model.bridge.f, Extra> r20) {
        Intrinsics.checkNotNullParameter(r19, "joinChannelParams");
        Intrinsics.checkNotNullParameter(r20, "response");
        com.bytedance.android.livesdk.link.model.bridge.f r2 = (com.bytedance.android.livesdk.link.model.bridge.f) r20.data;
        int r3 = f31.g.c;
        y6 r4 = com.bytedance.android.livesdk.link.model.l.a(r2);
        Map r5 = null;
        if (r4 != null) goto L5;
        f31.g r6 = null;
    L6:
        PushModeManagerService r7 = this.e;
        if (r6 == null) goto L13;
        v1 r8 = r6.a;
        if (r8 == null) goto L13;
        o1 r9 = r8.getMultiAnchorLinkMicRtcInfo();
        if (r9 == null) goto L13;
        Map r10 = r9.getPushStreamModeRTCMap();
    L14:
        if (r6 == null) goto L20;
        u1 r12 = r6.b;
        if (r12 == null) goto L20;
        p1 r13 = r12.getMultiAnchorLiveCoreInfo();
        if (r13 == null) goto L20;
        Map r14 = r13.getPushStreamModeLiveCoreMap();
    L21:
        if (r6 == null) goto L27;
        v1 r15 = r6.a;
        if (r15 == null) goto L27;
        o1 r16 = r15.getMultiAnchorLinkMicRtcInfo();
        if (r16 == null) goto L27;
        Map r17 = r16.getRtcInfoMap();
    L28:
        if (r6 == null) goto L34;
        u1 r18 = r6.b;
        if (r18 == null) goto L34;
        p1 r22 = r18.getMultiAnchorLiveCoreInfo();
        if (r22 == null) goto L34;
        r5 = r22.getLiveCoreExtInfoMap();
    L34:
        PushModeManagerService.d(r7, r10, r14, r17, r5, "joinChannelSuccess");
        com.bytedance.android.livesdk.link.model.bridge.h r23 = ((com.bytedance.android.livesdk.link.model.bridge.f) r20.data).getAnchorLayOutInfo();
        if (r23 == null) goto L37;
        int r110 = r23.getUiLayout();
    L38:
        com.bytedance.android.livesdk.link.model.bridge.h r24 = ((com.bytedance.android.livesdk.link.model.bridge.f) r20.data).getAnchorLayOutInfo();
        if (r24 == null) goto L41;
        int r111 = r24.getRange();
    L42:
        int r112 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown.ordinal();
        com.bytedance.android.livesdk.link.model.bridge.h r25 = ((com.bytedance.android.livesdk.link.model.bridge.f) r20.data).getAnchorLayOutInfo();
        if (r25 == null) goto L45;
        boolean r113 = r25.isOrientation();
    L46:
        String r26 = getContext().d.k;
        com.bytedance.android.livesdk.link.model.bridge.h r1 = ((com.bytedance.android.livesdk.link.model.bridge.f) r20.data).getAnchorLayOutInfo();
        if (r1 == null) goto L50;
        Map r27 = r1.getLayoutDetails();
        if (r27 == null) goto L50;
    L51:
        this.f.d(new r(r110, r111, r112, r113, r26, new com.bytedance.android.live.revlink.link.core.service.o(r27)), "bizOptLink");
        return;
    L50:
        r27 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        goto L51
    L45:
        r113 = false;
        goto L46
    L41:
        r111 = 0;
        goto L42
    L37:
        r110 = 0;
    L27:
        r17 = null;
    L20:
        r14 = null;
    L13:
        r10 = null;
        goto L14
    L5:
        r6 = new f31.g(r4.getRtcInfo(), r4.getLiveCoreInfo());
        goto L6
    }

    public DomainLaunchTask(com.bytedance.android.live.revenuelink.rtc.i r2, com.bytedance.android.live.revenuelink.connect.l r3, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r4, PushModeManagerService r5, AnchorUILayoutManager r6, com.bytedance.android.livesdk.revenue.service.room.c r7, com.bytedance.android.live.revlink.link.streaminteract.biz.c r8) {
        Intrinsics.checkNotNullParameter(r2, "anchorRtcManager");
        Intrinsics.checkNotNullParameter(r3, "linkInManger");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "pushManager");
        Intrinsics.checkNotNullParameter(r6, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r7, "revRoomService");
        Intrinsics.checkNotNullParameter(r8, "streamMixManager");
        this.c = r2;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.a = "DomainLaunchTask";
        this.b = new CompositeDisposable();
    }
}
