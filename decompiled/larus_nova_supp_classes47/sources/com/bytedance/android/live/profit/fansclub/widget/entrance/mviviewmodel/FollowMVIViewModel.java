package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.f8;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.LogCommonInstance;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.x1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.LiveVisionFrameDegradeConfig;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import eu0.a0;
import eu0.c0;
import eu0.u;
import eu0.v;
import eu0.w;
import eu0.x;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import mz0.m;
import mz0.n;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FollowMVIViewModel extends com.bytedance.android.anya.f<eu0.j, eu0.l, eu0.h> implements o {
    public boolean u;
    public final CompositeDisposable v;
    public final int w;
    public final yz0.k x;
    public final com.bytedance.android.live.revenue.core.a y;

    public final void onStart() {
    }

    public final DataCenter getDataCenter() {
        return this.x.getDataCenter();
    }

    public final void onStop() {
        this.v.clear();
    }

    public final int s1() {
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.c() == false) goto L9;
        int r1 = this.w;
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L15;
        if (r1 != 2) goto L8;
    L14:
        return 2131249417;
    L15:
        return 2131249416;
    L8:
        return 2131249419;
    L9:
        int r2 = this.w;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
    L16:
        return 2131249418;
    }

    public final String t1() {
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r0 = ((mz0.c) com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class)).W2(LogCommon.PAGE_SOURCE_LOG);
        if (r0 == null) goto L6;
        Map<String, String> r1 = r0.getMap();
        if (r1 == null) goto L6;
    L7:
        KmpEnv r2 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L16;
        if (r1.containsKey("enter_from_ad_type") == false) goto L16;
        if (TextUtils.isEmpty(r1.get("enter_from_ad_type")) == true) goto L16;
        String r3 = r1.get("enter_from_ad_type");
        Intrinsics.checkNotNull(r3);
        return r3;
    L16:
        if (r1.containsKey("enter_from_merge") == true) goto L18;
        return "";
    L18:
        if (TextUtils.isEmpty(r1.get("enter_from_merge")) == true) goto L23;
        String r4 = r1.get("enter_from_merge");
        Intrinsics.checkNotNull(r4);
        return r4;
    L23:
        return "";
    L6:
        r1 = MapsKt.emptyMap();
        goto L7
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new eu0.l();
    }

    public final void d(com.bytedance.android.anya.dsl.h<eu0.j, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        FollowMVIViewModel$bindToParent$1 r0 = FollowMVIViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, eu0.h.class));
    }

    public final void u1(JSONObject r6) {
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r2 = ((mz0.c) com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class)).W2(LogCommon.PAGE_SOURCE_LOG);     // Catch: JSONException -> L18
        if (r2 == null) goto L7;
        Map<String, String> r3 = r2.getMap();     // Catch: JSONException -> L18
        if (r3 == null) goto L7;
    L8:
        String r4 = r3.get("action_type");     // Catch: JSONException -> L18
        String r5 = "";
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        r6.put("action_type", r4);     // Catch: JSONException -> L18
        String r1 = r3.get("enter_method");     // Catch: JSONException -> L18
        if (r1 == null) goto L16;
        r5 = r1;
    L16:
        r6.put("enter_method", r5);     // Catch: JSONException -> L18
        r6.put("enter_from_merge", t1());     // Catch: JSONException -> L18
        return;
    L7:
        r3 = MapsKt.emptyMap();     // Catch: JSONException -> L18
    }

    public FollowMVIViewModel(yz0.k r2, com.bytedance.android.live.revenue.core.a r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "inst");
        this.x = r2;
        this.y = r3;
        this.v = new CompositeDisposable();
        this.w = ((LiveVisionFrameDegradeConfig) f8.a.getValue()).getFirstLineStyle();
    }

    public static final void e1(FollowMVIViewModel r3, String r4) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r5 = fu0.b.a(r3.getDataCenter());
        if (r5 == null) goto L20;
        Context r6 = r5.getContext();
        if (r6 != null) goto L8;
        return;
    L8:
        if (r3.l(r6) == true) goto L11;
        return;
    L11:
        if (((Boolean) com.bytedance.android.live.profit.fansclub.i.h.getValue(null, com.bytedance.android.live.profit.fansclub.i.a[6])).booleanValue() == false) goto L13;
        Toast.makeText(r6, r4, 0).show();
        return;
    L13:
        AccessibilityEvent r0 = new AccessibilityEvent();
        r0.setEventType(16384);
        List<CharSequence> r1 = r0.getText();
        if (r1 == null) goto L16;
        r1.add(r4);
    L16:
        AccessibilityManager r7 = r3.j(r6);
        if (r7 == null) goto L22;
        r7.sendAccessibilityEvent(r0);
        return;
    L22:
        return;
    }

    public static Map h1(JSONObject r2, Map r3) {
        HashMap r0 = new HashMap();
        r0.put("ad_extra_data", r2.toString());
        r0.putAll(r3);
        return r0;
    }

    public final void y0(final l0 r20, MVIState r22, p r23) {
        final eu0.l r2 = (eu0.l) r22;
        eu0.h r3 = (eu0.h) r23;
        Intrinsics.checkNotNullParameter(r20, "$this$reduce");
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "action");
        boolean r5 = false;
        if ((r3 instanceof eu0.k) == false) goto L22;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r4 = fu0.b.a(getDataCenter());
        if (r4 != null) goto L8;
    L15:
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r6 = fu0.b.a(getDataCenter());
        if (r6 == null) goto L22;
        if (r6.I() == true) goto L22;
        this.u = true;
        RxUtilKt.c(r6.n().r(r6.f()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r6), new g(this)), this.v);
        goto L22
    L8:
        if (com.bytedance.android.live.profit.fansclub.i.c() == false) goto L10;
        r4.J(r4.getRoom().getOwner(), "FollowMVIViewModel-initState", false, new FollowMVIViewModel$initState$1(this, r20, r2));
        goto L15
    L10:
        r0<eu0.l, Boolean> r7 = r2.getShow();
        Boolean r8 = Boolean.valueOf(!r4.I());
        r20.getClass();
        l0.h(r7, r8);
        r r9 = r2.b;
        KProperty[] r10 = eu0.l.h;
        KProperty r12 = r10[1];
        r9.getClass();
        Boolean r13 = Boolean.FALSE;
        l0.h(r9, r13);
        r r14 = r2.c;
        KProperty r15 = r10[2];
        r14.getClass();
        l0.h(r14, Integer.valueOf(s1()));
        r r16 = r2.d;
        KProperty r17 = r10[3];
        r16.getClass();
        if (this.w == 2) goto L13;
        int r18 = 2131107944;
    L14:
        l0.h(r16, Integer.valueOf(r18));
        l0.h(r2.c(), Boolean.TRUE);
        l0.h(r2.b(), r13);
        l0.h(r2.a(), EntranceAnimState.NONE);
        goto L15
    L13:
        r18 = 2131107945;
    L22:
        if ((r3 instanceof w) == false) goto L25;
        r0<eu0.l, Boolean> r19 = r2.getShow();
        Boolean r24 = Boolean.FALSE;
        r20.getClass();
        l0.h(r19, r24);
    L25:
        if ((r3 instanceof c0) == false) goto L28;
        r0<eu0.l, Boolean> r25 = r2.getShow();
        Boolean r26 = Boolean.TRUE;
        r20.getClass();
        l0.h(r25, r26);
        l0.h(r2.c(), r26);
        l0.h(r2.b(), Boolean.FALSE);
        l0.h(r2.a(), EntranceAnimState.NONE);
    L28:
        if ((r3 instanceof x) == false) goto L31;
        r r27 = r2.c();
        Boolean r28 = Boolean.FALSE;
        r20.getClass();
        l0.h(r27, r28);
        l0.h(r2.b(), r28);
        l0.h(r2.a(), EntranceAnimState.FOLLOWED_TICKING);
    L31:
        if ((r3 instanceof v) == false) goto L34;
        r r29 = r2.c();
        Boolean r30 = Boolean.TRUE;
        r20.getClass();
        l0.h(r29, r30);
        l0.h(r2.b(), Boolean.FALSE);
        l0.h(r2.a(), EntranceAnimState.NONE);
    L34:
        if ((r3 instanceof a0) == false) goto L37;
        r r32 = r2.a();
        EntranceAnimState r33 = EntranceAnimState.FOLLOWED_HIDING;
        r20.getClass();
        l0.h(r32, r33);
    L37:
        if ((r3 instanceof u) == false) goto L40;
        r0<eu0.l, Boolean> r34 = r2.getShow();
        Boolean r35 = Boolean.FALSE;
        r20.getClass();
        l0.h(r34, r35);
        l0.h(r2.a(), EntranceAnimState.NONE);
    L40:
        if ((r3 instanceof eu0.c) == true) goto L42;
        return;
    L42:
        if (this.u == true) goto L179;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r36 = fu0.b.a(getDataCenter());
        if (r36 == null) goto L181;
        com.bytedance.android.livesdk.revenue.service.user.a r37 = r36.n();
        Context r38 = r36.getContext();
        if (r37.isLogin() == true) goto L50;
        r36.d = true;
        final com.bytedance.android.livesdk.revenue.room.c r1 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).v7();
        ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(r38, new FollowMVIViewModel$tryFollowAnchor$1(r1));
        return;
    L50:
        if (this.w != 0) goto L52;
        r r39 = r2.c();
        Boolean r40 = Boolean.FALSE;
        r20.getClass();
        l0.h(r39, r40);
        l0.h(r2.b(), Boolean.TRUE);
    L52:
        String r42 = null;
        if ((r38 instanceof FragmentActivity) == true) goto L55;
        Context r43 = null;
    L56:
        FragmentActivity r44 = (FragmentActivity) r43;
        if (r44 == null) goto L59;
        vh6.c.b(wh6.a.class).checkAndShowGuide(r44, "live", ((FragmentActivity) r38).getResources().getString(2131911631));
    L59:
        DataCenter r45 = r36.a;
        if (r45 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L62:
        String r46 = r36.f();
        long r47 = r36.k();
        if (c1.b(r45) == false) goto L68;
        JSONObject r48 = new JSONObject();
        r48.put("anchor_id", r46);     // Catch: JSONException -> L172
        r48.put("room_id", String.valueOf(r47));     // Catch: JSONException -> L172
    L66:
        u1(r48);
        jc1.k.n(ILiveDouPlusService.class).logEvent(true, "live_ad", "follow", h1(r48, c1.e(r45)));
    L68:
        if (c1.c(r45) == false) goto L72;
        JSONObject r49 = new JSONObject();
        r49.put("anchor_id", r46);     // Catch: JSONException -> L173
        r49.put("room_id", String.valueOf(r47));     // Catch: JSONException -> L173
    L71:
        u1(r49);
        jc1.k.n(ILiveDouPlusService.class).logEvent(true, "live_ad", "follow", h1(r49, c1.f(r45)));
    L72:
        int r50 = x1.a;
        int r52 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        DataCenter r53 = getDataCenter();
        yz0.k r54 = this.x;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r55 = fu0.b.a(r53);
        String r110 = DataType.TRUE;
        if (r55 == null) goto L114;
        IRoom r111 = r55.getRoom();
        HashMap r112 = new HashMap();
        r112.put("growth_deepevent", DataType.TRUE);
        if (vh6.c.b(IRevBroadcastService.class).isPlayingGame() == false) goto L78;
        Object r113 = DataType.TRUE;
    L79:
        r112.put("is_gaming", r113);
        if (r111 == null) goto L82;
        LiveMode r56 = r111.getStreamType();
    L83:
        int r114 = h1.a;
        r112.put("live_type", i1.a(r56));
        r112.put("is_vr_machine", vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).getVrMachineLogStr(r53));
        r112.putAll(h1.a(r111));
        if (r111 != null) goto L86;
    L87:
        if (r111 != null) goto L89;
    L91:
        String r57 = "other";
    L92:
        r112.put("cover_type", r57);
    L94:
        if (((Boolean) wt0.c.b.getValue(null, wt0.c.a[0])).booleanValue() == false) goto L96;
        Object r58 = DataType.TRUE;
    L97:
        r112.put("is_screen_clear", r58);
        xp2.d r59 = vh6.c.b(IRevBroadcastService.class).getAudienceGameContext();
        if (r59 == null) goto L102;
        com.bytedance.android.livesdk.revenue.util.j r60 = r59.a;
        if (r60 == null) goto L102;
        xp2.a r62 = (xp2.a) r60.getValue();
    L103:
        if (r62 == null) goto L105;
        r112.put("game_id", String.valueOf(r62.getGameId()));
        r112.put("game_name", String.valueOf(r62.getGameName()));
    L105:
        r112.put("connection_type", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getLinkConnectionType());
        r112.put("anchor_cnt", ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getLinkAnchorCount());
        if (r54 != null) goto L109;
        r112.put("if_clear_mode", DataType.FALSE);
    L113:
        n r63 = new n();
        Map<String, String> r64 = r63.a;
        Intrinsics.checkNotNullParameter(r64, "map");
        Intrinsics.checkNotNullParameter(r112, "map");
        r64.putAll(r112);
        m r65 = new m();
        r65.b(LogCommon.LIVE_SHARE_LOG);
        com.bytedance.android.livesdk.revenue.log.g r66 = vh6.c.b(kr2.a.class).K7();
        Intrinsics.checkNotNullParameter(r66, "followLog");
        Intrinsics.checkNotNullParameter("live", "source");
        r66.b();
        String r67 = r55.f();
        Intrinsics.checkNotNullParameter(r67, "userId");
        r66.c(r67);
        r66.d();
        Intrinsics.checkNotNullParameter("left_up", "scene");
        Intrinsics.checkNotNullParameter("audience_to_anchor", "followTarget");
        Intrinsics.checkNotNullParameter(DataType.TRUE, "isCurrentAnchor");
        r66.a("left_up", "audience_to_anchor", DataType.TRUE);
        ((ArrayList) r65.a).add(r66.a);
        com.bytedance.android.livesdk.revenue.log.i r68 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r68, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_interact", "belong");
        r68.a("live_interact");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r68.c("live_detail");
        ((ArrayList) r65.a).add(r68.a);
        r65.b(LogCommon.ROOM);
        r65.b(LogCommon.RECOMMEND_SOURCE_LOG);
        r65.c(LogCommonInstance.LIVE_AD_LOG);
        r65.b(LogCommon.LIVE_END_PAGE_LOG);
        ((ArrayList) r63.b).addAll(r65.a);
        cy0.e.a.getClass();
        cy0.j r69 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r70 = com.bytedance.android.scope.m.b(r69).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r70);
        ((mz0.i) ((f80.a) r70)).w3("livesdk_follow", r63.a, r63.b);
        goto L114
    L109:
        if (r54.isCleanMode() == false) goto L111;
        Object r72 = DataType.TRUE;
    L112:
        r112.put("if_clear_mode", r72);
        goto L113
    L111:
        r72 = DataType.FALSE;
    L102:
        r62 = null;
        goto L103
    L96:
        r58 = DataType.FALSE;
        goto L97
    L89:
        if (r111.getAutoCover() != 1) goto L91;
        r57 = "autocover";
        goto L92
    L86:
        if (r111.getAutoCover() == 0) goto L94;
    L82:
        r56 = null;
        goto L83
    L78:
        r113 = DataType.FALSE;
    L114:
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r73 = fu0.b.a(getDataCenter());
        if (r73 == null) goto L167;
        IRoom r74 = r73.getRoom();
        if (r74 == null) goto L167;
        IMainRoom r75 = iy0.e.a(r74);
        if (r75 == null) goto L167;
        iy0.b r76 = r75.mo397getGameData();
        if (r76 == null) goto L167;
        iy0.d r77 = r76.mo395getRoomGameDataChannelConfig();
        if (r77 == null) goto L167;
        String r78 = r77.getGameId();
        if (r78 != null) goto L129;
    L132:
        boolean r79 = true;
    L133:
        if (r79 == true) goto L167;
        String r80 = r77.getFusionTagId();
        if (r80 != null) goto L137;
    L140:
        boolean r82 = true;
    L141:
        if (r82 == true) goto L167;
        HashMap r83 = new HashMap();
        String r84 = r77.getGameId();
        String r85 = "";
        if (r84 != null) goto L146;
        r84 = "";
    L146:
        r83.put("game_id", r84);
        r83.put("action_type", "follow");
        String r86 = vh6.c.b(qq2.a.class).getCreativeID();
        if (r86.length() <= 0) goto L149;
        boolean r87 = true;
    L150:
        if (r87 == false) goto L152;
        r42 = r86;
    L152:
        if (r42 != null) goto L154;
    L158:
        r110 = DataType.FALSE;
    L159:
        r83.put("is_ads", r110);
        String r88 = r75.getAnchorId();
        if (r88 != null) goto L162;
        r88 = "";
    L162:
        r83.put("host_id", r88);
        r83.put("content_id", String.valueOf(r75.getId()));
        r83.put("scene", DataType.FALSE);
        String r89 = r75.getRequestId();
        if (r89 == null) goto L166;
        r85 = r89;
    L166:
        r83.put(Constants.Keys.REQ_ID, r85);
        vh6.c.b(dr2.e.class).dataChannelLinkEvent("douyin_game_content_consume_click_monitor", r83);
        goto L167
    L154:
        if (r42.length() <= 0) goto L156;
        r5 = true;
    L156:
        if (r5 == false) goto L158;
    L149:
        r87 = false;
        goto L150
    L137:
        if (r80.length() == 0) goto L140;
        r82 = false;
        goto L141
    L129:
        if (r78.length() == 0) goto L132;
        r79 = false;
    L167:
        final com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r90 = fu0.b.a(getDataCenter());
        if (r90 == null) goto L182;
        final com.bytedance.android.livesdk.revenue.service.user.a r92 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        RxUtilKt.c(r90.n().om(r90.getContext(), r90.getRoom(), new ds2.c(new FollowMVIViewModel$follow$params$1(r90, r92))).subscribe(new b(this, r90), new c(this)), this.v);
        return;
    L182:
        return;
    L55:
        r43 = r38;
        goto L56
    L181:
        return;
    }
}
