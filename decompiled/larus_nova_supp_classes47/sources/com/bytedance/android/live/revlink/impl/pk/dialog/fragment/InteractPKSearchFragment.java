package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.r;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.live.revlink.impl.pk.utils.u;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.d6;
import com.bytedance.android.livesdk.link.model.u6;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import dq2.w;
import gd0.v;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import r11.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPKSearchFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/contract/InteractDialogPKSearchContract$View;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractPKSearchFragment extends InteractDialogPKSearchContract$View {
    public static final /* synthetic */ int n = 0;
    public DataCenter g;
    public ViewGroup h;
    public String i;
    public boolean j;
    public String k;
    public boolean l;
    public u m;

    public static final class a {
        public static InteractPKSearchFragment a(r r3, DataCenter r4, String r5, boolean r6, boolean r7, u r8) {
            Intrinsics.checkNotNullParameter(r8, "searchSource");
            SearchSourceFlag r0 = r8.a;
            InteractPKSearchFragment r1 = new InteractPKSearchFragment();
            r1.f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j(r1, r7, r0);
            r1.d = r3;
            r1.g = r4;
            r1.i = r5;
            r1.j = r6;
            r1.k = "";
            r1.l = r7;
            r1.m = r8;
            return r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        r11.p r0 = b51.b.c0.j();
        if (r0 != null) goto L5;
    L7:
        return 432.0f;
    L5:
        if (r0.getEnable() == false) goto L7;
        return t6.d(s1.getContext(), t6.b(s1.getContext()) * q.a(r0)) - 48;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup Z90() {
        ViewGroup r0 = this.h;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View
    public final void ba0() {
        ((com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j) this.f).g.postValue(null);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View
    public final void finish() {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        this.d.dismiss();
    }

    public final void onDestroyView() {
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r0 = (com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j) this.f;
        ((ArrayList) r0.k).clear();
        r0.n = true;
        r0.s = 0;
        r0.r = "";
        super.onDestroyView();
    }

    public InteractPKSearchFragment() {
        this.m = new u(SearchSourceFlag.UNDEFINE, "");
    }

    public final void onDestroy() {
        super.onDestroy();
        ((com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j) this.f).b();
    }

    public final void onResume() {
        super.onResume();
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r0 = (com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j) this.f;
        String r1 = this.k;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r5 = r1;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "activityName");
        Observable r2 = r31.b.a(r31.a.a).c(0, false, 0, r5, 0, IRivalRankRecommendResponse.LoadType.All.ordinal());
        if (r2 == null) goto L11;
        ObservableSubscribeProxy r3 = (ObservableSubscribeProxy) r2.as(r0.c());
        if (r3 == null) goto L12;
        r3.subscribe(new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.h(r0), new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.i(r0));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View
    public final void ca0(IRivalRankRecommendResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "rivalRankRecommendResponse");
        ((com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j) this.f).g.postValue(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View
    public final void da0(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        int r0 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getRevLinkControlService().getCurrentMode();
        if (v.a(r0, 4) == false) goto L9;
        return;
    L9:
        if (v.a(r0, 64) == false) goto L12;
        return;
    L12:
        if ((r3 instanceof ApiServerException) == true) goto L14;
        return;
    L14:
        if (((ApiServerException) r3).getErrorCode() != 31012) goto L18;
        this.d.dismiss();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View
    public final void fa0(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        ((com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j) this.f).p.postValue(Boolean.FALSE);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View
    public final void ga0(u6 r2) {
        Intrinsics.checkNotNullParameter(r2, "rivalsSearchData");
        ((com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j) this.f).p.postValue(Boolean.FALSE);
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        View r10 = LayoutInflater.from(getContext()).inflate(2131565702, null);
        if (r10 == null) goto L19;
        ViewGroup r12 = (ViewGroup) r10;
        this.h = r12;
        EditText r13 = (EditText) r12.findViewById(2131385411);
        if (r13 == null) goto L7;
        r13.setHint(this.i);
    L7:
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r1 = (com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j) this.f;
        r r2 = this.d;
        ViewGroup r3 = this.h;
        Intrinsics.checkNotNull(r3);
        boolean r4 = this.j;
        String r5 = this.k;
        Intrinsics.checkNotNull(r5);
        u r6 = this.m;
        Intrinsics.checkNotNull(r6);
        PKRivalsPanelBaseWidget r14 = new PKRivalsPanelBaseWidget(r1, r2, r3, r4, r5, r6);
        WidgetManager r15 = WidgetManager.of(this, getView());
        r15.setDataCenter(this.g);
        r15.load(2131381907, r14);
        h41.f r16 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r16 != null) goto L10;
        return;
    L10:
        if (this.l == false) goto L12;
        String r17 = "npk_invite_page";
    L13:
        Intrinsics.checkNotNullParameter(r17, "source");
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("source", r17);
        mz0.n r18 = new mz0.n();
        Map<String, String> r0 = r18.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r0.putAll(r7);
        mz0.m r19 = new mz0.m();
        r19.b(LogCommon.PAGE_SOURCE_LOG);
        r19.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder r20 = r16.d();
        if (r20 == null) goto L16;
        r20.m(r19);
    L16:
        List<Object> r22 = r18.b;
        ArrayList r23 = (ArrayList) r22;
        r23.addAll(r19.a);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r25);
        ((mz0.i) ((f80.a) r25)).w3("livesdk_pk_search_panel_show", r18.a, r18.b);
        return;
    L12:
        r17 = "pk_tab";
        goto L13
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View
    public final void ea0(IRoom r18, d11.d r19, v4 r20) {
        Intrinsics.checkNotNullParameter(r18, "targetRoom");
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r20, "inviteResult");
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        u r2 = this.m;
        if (r2 == null) goto L9;
        SearchSourceFlag r3 = r2.a;
        if (r3 == null) goto L9;
    L10:
        SearchSourceFlag r5 = SearchSourceFlag.MAIN_LINK;
        boolean r6 = true;
        if (r3 != r5) goto L13;
    L19:
        HashMap r7 = new HashMap();
        r7.put("is_oncemore", DataType.FALSE);
        r7.put("is_recommend_list", DataType.FALSE);
        String r8 = this.k;
        Intrinsics.checkNotNull(r8);
        if (r8.length() == 0) goto L23;
        r6 = false;
    L23:
        if (r6 == true) goto L25;
        String r9 = "activity";
    L26:
        r7.put("pk_description", r9);
        if (TextUtils.isEmpty(this.k) == true) goto L29;
        String r10 = this.k;
        Intrinsics.checkNotNull(r10);
        r7.put("pk_activity_type", r10);
    L29:
        String r12 = "routine_pk";
        r7.put("invite_mode", "routine_pk");
        String r13 = iz.a.a(r18.getOwner());
        r7.put("invitee_id", String.valueOf(r13));
        r7.put("is_random_match", DataType.FALSE);
        String r14 = "";
        if (r3 != SearchSourceFlag.INVITE_LINKING) goto L39;
        r7.put("anchor_connection_type", "invite");
        r7.put("connection_type", "manual_link");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r4 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r4 == null) goto L35;
        String r15 = r4.a;
        if (r15 == null) goto L35;
    L36:
        r7.put("source", r15);
        r7.put("invite_mode", "connection");
        com.bytedance.android.live.revlink.impl.multianchor.service.d r16 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r16 == null) goto L62;
        int r17 = r16.getLinkUserCenter().c();
        r7.put("anchor_connect_status", Integer.toString(r17));
        r7.put("connection_anchor_cnt", Integer.toString(r17));
    L62:
        r7.put("room_status", "live");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r22 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r22 == null) goto L65;
        String r23 = r22.a();
    L66:
        r7.put("from_room_status", r23);
        if (v.a(com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode(), 32) == true) goto L69;
    L71:
        Object r24 = DataType.FALSE;
        r7.put("audience_connect_cnt", r24);
    L72:
        r7.put("invite_type", "anchor");
        r7.put("anchor_connection_type", "invite");
        r7.put("anchor_connect_status", r24);
        r7.put("invitee_room_status", "live");
        r7.put("invitee_connect_cnt", r24);
        T r25 = this.f;
        if (r25 == 0) goto L84;
        IRivalExtraInfo r26 = ((com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j) r25).l;
        if (r26 == null) goto L84;
        if (r26 == null) goto L84;
        d6 r27 = r26.getLinkerInfo();
        if (r27 == null) goto L84;
        List r28 = r27.getLinkedUserInfos();
        if (r28 == null) goto L84;
        if (r28.size() <= 0) goto L84;
        r7.put("invitee_room_status", "connection");
        r7.put("invitee_connect_cnt", String.valueOf(r28.size()));
    L84:
        d31.d r29 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r29 == null) goto L87;
        String r30 = r29.c();
    L89:
        if (TextUtils.isEmpty(r30) == true) goto L95;
        d31.d r32 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r32 == null) goto L93;
        String r33 = r32.c();
    L94:
        r7.put("connection_type", r33);
        goto L95
    L93:
        r33 = "";
    L95:
        int r34 = UserListInviteType.a;
        r7.put("invitee_list", UserListInviteType.a(r19.d, null));
        if (y.b() == false) goto L107;
        r7.put("connection_sub_type", "manual_nlink");
        d31.d r1 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r1 == null) goto L103;
        String r35 = r1.a();
        if (r35 == null) goto L103;
        r14 = r35;
    L103:
        r7.put("anchor_connect_status", r14);
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.a() == false) goto L106;
        r7.put("room_status", "pk");
    L108:
        r7.put("invitee_room_id", String.valueOf(r18.getRoomId()));
        String r36 = r20.getEventTrackingInfo();
        if (r36 == null) goto L113;
        Map<String, String> r37 = h41.h.a(r36);
        if (r37 == null) goto L113;
        r7.putAll(r37);
    L113:
        mz0.n r38 = new mz0.n();
        Map<String, String> r39 = r38.a;
        Intrinsics.checkNotNullParameter(r39, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r39.putAll(r7);
        mz0.m r40 = new mz0.m();
        LinkCrossRoomDataHolder.a r42 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r40);
        r40.b(LogCommon.ROOM);
        List<Object> r43 = r38.b;
        ArrayList r44 = (ArrayList) r43;
        r44.addAll(r40.a);
        cy0.e.a.getClass();
        cy0.j r45 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r46 = com.bytedance.android.scope.m.b(r45).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r46);
        ((mz0.i) ((f80.a) r46)).w3("connection_invite", r38.a, r38.b);
        return;
    L106:
        r7.put("room_status", "connection");
        goto L108
    L107:
        r7.put("connection_sub_type", "");
        goto L108
    L87:
        r30 = null;
        goto L89
    L69:
        if (com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1() == null) goto L71;
        w r47 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        Intrinsics.checkNotNull(r47);
        r7.put("audience_connect_cnt", String.valueOf(r47.w()));
        r24 = DataType.FALSE;
        goto L72
    L65:
        r23 = "";
    L35:
        r15 = "";
        goto L36
    L39:
        if (r3 != r5) goto L43;
        r7.put("anchor_connection_type", "invite");
        r7.put("connection_type", "manual_link");
        r7.put("source", "link_banner");
        r7.put("invite_mode", "connection");
        com.bytedance.android.live.revlink.impl.multianchor.service.d r48 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r48 == null) goto L62;
        int r49 = r48.getLinkUserCenter().c();
        r7.put("anchor_connect_status", Integer.toString(r49));
        r7.put("connection_anchor_cnt", Integer.toString(r49));
        goto L62
    L43:
        r7.put("source", "pk_banner");
        r7.put("invite_mode", "routine_pk");
        r7.put("pk_time", Integer.toString(l51.a.j()));
        p11.h r50 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r50 == null) goto L46;
        String r52 = r50.getInviteMode();
    L48:
        if (TextUtils.isEmpty(r52) == true) goto L50;
        Intrinsics.checkNotNull(r52);
        r12 = r52;
    L50:
        r7.put("invite_mode", r12);
        if (r50 == null) goto L53;
        String r53 = r50.getTheme();
    L55:
        if (TextUtils.isEmpty(r53) == true) goto L57;
        Intrinsics.checkNotNull(r53);
        r7.put(FileUtils.PICTURE_THEME, r53);
    L57:
        String r54 = iz.a.a(com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b());
        IPKLinkBizDataService r55 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r55 == null) goto L62;
        String r56 = r55.getTransformReason(r13, r54);
        if (TextUtils.isEmpty(r56) == true) goto L62;
        r7.put("transform_reason", r56);
        goto L62
    L53:
        r53 = null;
        goto L55
    L46:
        r52 = null;
        goto L48
    L25:
        r9 = "routine";
        goto L26
    L13:
        if (r3 == SearchSourceFlag.INVITE_LINKING) goto L19;
        if (r19.a == 1) goto L17;
    L18:
        this.d.dismiss();
        goto L19
    L17:
        if (r20.getSupportMultiInvite() == true) goto L19;
    L9:
        r3 = SearchSourceFlag.UNDEFINE;
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566062, r3, false);
    }
}
