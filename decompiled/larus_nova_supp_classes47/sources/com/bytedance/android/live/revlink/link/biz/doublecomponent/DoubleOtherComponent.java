package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.control.launchcontext.PkAnchorLaunchType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.utils.l;
import com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import cy0.j;
import gt1.f;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;
import o51.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoubleOtherComponent implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public final j41.c c;
    public a d;
    public b e;
    public e f;
    public final DoubleOtherComponent$pkStateObserver$1 g;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a h;
    public final com.bytedance.android.live.revlink.link.biz.doublecomponent.a i;
    public final i j;

    public static final class a<T> implements Observer {
        public final /* synthetic */ DoubleOtherComponent a;

        public a(DoubleOtherComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            e r6 = (e) r5;
            if (r6 == null) goto L13;
            RevLinkWindowRegionContext r0 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this.a);
            if (r0 == null) goto L9;
            r0.setUiLayout(r6);
        L9:
            if ((!Intrinsics.areEqual(this.a.f, r6)) == false) goto L12;
            cy0.e.a.getClass();
            j r1 = cy0.e.a.a;
            m.e.getClass();
            Object r2 = m.b(r1).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
            Intrinsics.checkNotNull(r2);
            JSONObject r3 = new JSONObject();
            r3.put("eventName", "revlink_ui_update");
            r3.put("ui_layout", r6.b);
            Unit r4 = Unit.INSTANCE;
            ((vy0.b) ((f80.a) r2)).sendEventToAllJsBridges("H5_revenueInteractData", r3);
            this.a.f = r6;
            return;
        L12:
            return;
        }
    }

    public static final class b extends i11.c.a {
        public b() {
        }

        @Override // i11.c.a, i11.c.b
        public final void d(int r5, List<? extends p> r6) {
            Intrinsics.checkNotNullParameter(r6, "list");
            cy0.e.a.getClass();
            j r0 = cy0.e.a.a;
            m.e.getClass();
            Object r1 = m.b(r0).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
            Intrinsics.checkNotNull(r1);
            JSONObject r2 = new JSONObject();
            r2.put("eventName", "revlink_online_update");
            r2.put("online_cnt", ((CopyOnWriteArrayList) r6).size());
            r2.put("scene", r5);
            Unit r7 = Unit.INSTANCE;
            ((vy0.b) ((f80.a) r1)).sendEventToAllJsBridges("H5_revenueInteractData", r2);
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
        IPKLinkBizDataService r0 = com.bytedance.android.live.revlink.link.biz.service.i.T(this).g();
        if (r0 == null) goto L5;
        r0.resetBroadcastCapInfo();
    L5:
        com.bytedance.android.live.revlink.link.domain.anchorimpl.i r1 = getContext().qa();
        RevLinkWindowRegionContext r2 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this);
        if (r2 == null) goto L8;
        Map<String, String> r3 = r2.getLogParams();
    L9:
        r1.fk(1, r3);
        com.bytedance.android.live.revlink.impl.pk.service.d r4 = com.bytedance.android.live.revlink.link.biz.service.i.T(this).h();
        if (r4 == null) goto L13;
        m41.b r5 = r4.getUnLoadSource();
        if (r5 == null) goto L13;
    L14:
        IPKLinkBizDataService r6 = com.bytedance.android.live.revlink.link.biz.service.i.P(this);
        if (r6 == null) goto L17;
        boolean r7 = r6.getSelfHasAudienceBeforePk();
    L18:
        l r8 = com.bytedance.android.live.revlink.link.biz.service.i.k(this);
        i97.a r9 = i97.a.a;
        long r10 = System.currentTimeMillis() - 0;
        com.bytedance.android.live.revlink.impl.control.launchcontext.c r12 = com.bytedance.android.live.revlink.link.biz.service.i.Q(this);
        if (r12 == null) goto L21;
        PkAnchorLaunchType r13 = r12.c;
    L22:
        ld.a r14 = getContext().getLinkDataSet();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r5, "source");
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("link_type", "couple_pk");
        r15.put("link_duration", String.valueOf(r10 / ((long) WebcastRedirectException.UNKNOWN)));
        r15.put("leave_source", r5.toString());
        r15.put("connection_enter_from", String.valueOf(r13));
        r15.put("enter_with_audience", String.valueOf(r7));
        if (r14 == null) goto L28;
        NextLiveData r16 = r14.Fc();
        if (r16 == null) goto L28;
        Boolean r17 = (Boolean) r16.getValue();
        if (r17 == null) goto L28;
    L29:
        r15.put("leave_with_audience", String.valueOf(r17.booleanValue()));
        if (r14 == null) goto L35;
        NextLiveData r18 = r14.z9();
        if (r18 == null) goto L35;
        Boolean r19 = (Boolean) r18.getValue();
        if (r19 == null) goto L35;
    L36:
        r15.put("leave_rival_with_audience", String.valueOf(r19.booleanValue()));
        com.bytedance.android.live.revlink.impl.global.c r20 = r8.b;
        if (r20 == null) goto L39;
        IPKLinkBizDataService r22 = r20.mk();
    L40:
        if (r22 == null) goto L42;
        r15.put("match_type", String.valueOf(r22.getLinkTypeParams().a));
        int r23 = UserListInviteType.a;
        r15.put("invitee_list", UserListInviteType.a(r22.getLinkTypeParams().b, null));
    L42:
        r8.b(r15);
        com.bytedance.android.live.revlink.impl.global.c r24 = r8.b;
        if (r24 == null) goto L45;
        IPKLinkBizDataService r25 = r24.mk();
    L46:
        if (r25 == null) goto L49;
        String r26 = r25.getPkLinkConnectionType();
        if (r26 == null) goto L49;
    L50:
        r15.put("connection_type", r26);
        n r27 = new n();
        Map<String, String> r28 = r27.a;
        Intrinsics.checkNotNullParameter(r28, "map");
        Intrinsics.checkNotNullParameter(r15, "map");
        r28.putAll(r15);
        cy0.e.a.getClass();
        j r29 = cy0.e.a.a;
        m r30 = m.e;
        r30.getClass();
        Object r32 = m.b(r29).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r32);
        ((mz0.i) ((f80.a) r32)).w3("livesdk_rd_leave_connection", r27.a, r27.b);
        r8.c("livesdk_rd_leave_connection", r15);
        getContext().getRoomDataCenterService().tl(new f(8));
        getContext().getCommonService().k().b();
        Intrinsics.checkNotNullParameter(this, "$this$pKCustomizePlayDataService");
        com.bytedance.android.live.revlink.impl.pk.service.c r33 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).Yi();
        if (r33 == null) goto L53;
        r33.reset();
    L53:
        getContext().getLinkDataSet().so().setValue(new zg1.d(1, this.i.a, false, 4));
        p11.d r34 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r34 == null) goto L56;
        r34.i("default");
    L56:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r35 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r35 == null) goto L61;
        LiveData<PkBaseStateMachine.c> r36 = r35.getPkBaseState();
        if (r36 == null) goto L61;
        r36.removeObserver(this.g);
    L61:
        RevLinkWindowRegionContext r37 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this);
        if (r37 == null) goto L64;
        r37.onLinkDestroy();
    L64:
        getContext().md().a();
        r30.getClass();
        cy0.f r38 = r30.a(m.d, cy0.f.class);
        if (r38 == null) goto L67;
        com.bytedance.android.live.revlink.impl.pk.scope.service.a r39 = (com.bytedance.android.live.revlink.impl.pk.scope.service.a) r30.d(r38, com.bytedance.android.live.revlink.impl.pk.scope.service.a.class);
    L68:
        if (r39 == null) goto L74;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r40 = r39.a;
        if (r40 == null) goto L74;
        LiveData<List<cf2.a>> r42 = r40.getBaseScoreState();
        if (r42 == null) goto L74;
        r42.removeObserver(r39.e);
    L74:
        a r43 = this.d;
        if (r43 == null) goto L81;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r44 = getContext();
        if (r44 == null) goto L81;
        NextLiveData<e> r45 = r44.getUiLayout();
        if (r45 == null) goto L81;
        r45.removeObserver(r43);
    L81:
        b r46 = this.e;
        if (r46 == null) goto L88;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r47 = getContext();
        if (r47 == null) goto L88;
        AnchorLinkUserCenterV2 r48 = r47.getAnchorLinkUserCenter();
        if (r48 == null) goto L88;
        r48.l(r46);
    L88:
        this.d = null;
        this.e = null;
        this.f = null;
        return;
    L67:
        r39 = null;
    L49:
        r26 = "";
        goto L50
    L45:
        r25 = null;
        goto L46
    L39:
        r22 = null;
    L35:
        r19 = Boolean.FALSE;
    L28:
        r17 = Boolean.FALSE;
        goto L29
    L21:
        r13 = null;
        goto L22
    L17:
        r7 = false;
    L13:
        r5 = m41.b.c.c;
        goto L14
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        IPKLinkBizDataService r0 = com.bytedance.android.live.revlink.link.biz.service.i.T(this).g();
        if (r0 == null) goto L5;
        r0.recordBroadcastCapInfo();
    L5:
        com.bytedance.android.live.revlink.impl.pk.service.d r1 = com.bytedance.android.live.revlink.link.biz.service.i.T(this).h();
        if (r1 == null) goto L8;
        r1.setUnLoadSource(m41.b.c.c);
    L8:
        l r2 = com.bytedance.android.live.revlink.link.biz.service.i.k(this);
        com.bytedance.android.live.revlink.impl.control.launchcontext.c r3 = com.bytedance.android.live.revlink.link.biz.service.i.Q(this);
        if (r3 == null) goto L11;
        PkAnchorLaunchType r4 = r3.c;
    L12:
        IPKLinkBizDataService r5 = com.bytedance.android.live.revlink.link.biz.service.i.P(this);
        if (r5 == null) goto L15;
        boolean r6 = r5.getSelfHasAudienceBeforePk();
    L16:
        r2.getClass();
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("link_type", "couple_pk");
        r7.put("with_audience", String.valueOf(r6));
        com.bytedance.android.live.revlink.impl.global.c r8 = r2.b;
        if (r8 == null) goto L19;
        IPKLinkBizDataService r9 = r8.mk();
    L20:
        boolean r10 = true;
        if (r9 == null) goto L32;
        IPKLinkBizDataService.e r12 = r9.getPkInteactAudienceParams();
        if (r12 == null) goto L32;
        if (r12.b == false) goto L27;
    L30:
        boolean r13 = true;
    L31:
        r7.put("rival_with_audience", String.valueOf(r13));
        goto L32
    L27:
        if (r12.c == true) goto L30;
        r13 = false;
    L32:
        r7.put("connection_enter_from", String.valueOf(r4));
        com.bytedance.android.live.revlink.impl.global.c r14 = r2.b;
        if (r14 == null) goto L35;
        IPKLinkBizDataService r15 = r14.mk();
    L36:
        if (r15 == null) goto L38;
        r7.put("match_type", String.valueOf(r15.getLinkTypeParams().a));
        int r16 = UserListInviteType.a;
        r7.put("invitee_list", UserListInviteType.a(r15.getLinkTypeParams().b, null));
    L38:
        r2.b(r7);
        n r17 = new n();
        Map<String, String> r18 = r17.a;
        Intrinsics.checkNotNullParameter(r18, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r18.putAll(r7);
        cy0.e.a.getClass();
        j r19 = cy0.e.a.a;
        m.e.getClass();
        Object r20 = m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r20);
        ((mz0.i) ((f80.a) r20)).w3("livesdk_rd_enter_connection", r17.a, r17.b);
        r2.c("livesdk_rd_enter_connection", r7);
        getContext().getRoomDataCenterService().Wg();
        com.bytedance.android.live.revlink.impl.settings.live.b r22 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        r11.e r23 = r22.b();
        Intrinsics.checkNotNullParameter(r23, "$this$isMixDegradeEnable");
        Intrinsics.checkNotNullParameter(r23, "$this$isDegradeEnable");
        if (r23.getEnable() == true) goto L41;
    L43:
        boolean r24 = false;
    L44:
        if (r24 == true) goto L46;
    L48:
        r10 = false;
    L49:
        if (r10 == false) goto L51;
    L53:
        ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager().i("pk");
        d51.c r25 = d51.c.A0;
        r25.getClass();
        if (((Boolean) d51.c.D.getValue(r25, d51.c.a[28])).booleanValue() == false) goto L60;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r26 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r26 == null) goto L60;
        LiveData<PkBaseStateMachine.c> r27 = r26.getPkBaseState();
        if (r27 == null) goto L60;
        r27.observeForever(this.g);
    L60:
        PkScopeProviderService r28 = com.bytedance.android.live.revlink.link.biz.service.i.W(this).a;
        if (r28 == null) goto L63;
        r28.c();
    L63:
        com.bytedance.android.live.revlink.impl.pk.scope.service.b.a();
        getContext().md().b();
        a r29 = new a(this);
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r30 = getContext();
        if (r30 == null) goto L68;
        NextLiveData<e> r32 = r30.getUiLayout();
        if (r32 == null) goto L68;
        r32.observeForever(r29);
    L68:
        Unit r33 = Unit.INSTANCE;
        this.d = r29;
        b r34 = new b();
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r35 = getContext();
        if (r35 == null) goto L73;
        AnchorLinkUserCenterV2 r36 = r35.getAnchorLinkUserCenter();
        if (r36 == null) goto L73;
        r36.i(r34);
    L73:
        this.e = r34;
        return;
    L51:
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.b.b.getValue(r22, com.bytedance.android.live.revlink.impl.settings.live.b.a[0])).booleanValue() == false) goto L53;
        getContext().getCommonService().k().a();
        goto L53
    L46:
        if (r23.a6() == false) goto L48;
    L41:
        if (r23.V6() == false) goto L43;
        r24 = true;
        goto L44
    L35:
        r15 = null;
        goto L36
    L19:
        r9 = null;
        goto L20
    L15:
        r6 = false;
        goto L16
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.h;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.revlink.link.biz.doublecomponent.DoubleOtherComponent$pkStateObserver$1] */
    public DoubleOtherComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r2, com.bytedance.android.live.revlink.link.streaminteract.biz.c r3, com.bytedance.android.live.revlink.link.biz.doublecomponent.a r4, i r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "streamMixManagerService");
        Intrinsics.checkNotNullParameter(r4, "bizDataContext");
        Intrinsics.checkNotNullParameter(r5, "rtcManager");
        this.h = r2;
        this.i = r4;
        this.j = r5;
        this.a = "DoubleOtherComponent";
        this.b = new CompositeDisposable();
        this.c = new j41.c(r5);
        this.g = new DoubleOtherComponent$pkStateObserver$1(this);
    }
}
