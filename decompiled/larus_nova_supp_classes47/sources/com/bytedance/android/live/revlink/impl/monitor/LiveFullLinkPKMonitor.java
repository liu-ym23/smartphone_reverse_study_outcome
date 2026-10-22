package com.bytedance.android.live.revlink.impl.monitor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.n;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenuelink.rtc.f;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revenuelink.rtc.o;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.plantform.RevLinkMultiChannelDataContext;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.k2;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import cy0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LiveFullLinkPKMonitor extends y50.b {
    public static final /* synthetic */ int p = 0;
    public long b;
    public long c;
    public long d;
    public long e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public long j;
    public int k;
    public boolean l;
    public boolean m;
    public final com.bytedance.android.livesdk.revenue.service.room.c n;
    public final com.bytedance.android.live.revlink.impl.global.c o;

    public static final class a {
    }

    static {
    }

    public final f e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.o;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m0();
    }

    public final or2.d f() {
        cy0.e.a.getClass();
        j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(or2.d.class);
        Intrinsics.checkNotNull(r0);
        return (com.bytedance.live.kmp.core.c) r0;
    }

    public final LinkCrossRoomDataHolder g() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.o;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkCrossRoomDataHolder();
    }

    public final w31.c h() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.o;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    public final com.bytedance.android.live.revenuelink.f i() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.o;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevenueLinkTraceMonitor();
    }

    public final void b(JSONObject r8) {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.n;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L7;
        IRoomBase r2 = r1.getCommonRoom();
    L8:
        IRoomBase r3 = (IRoom) r2;
        if (r3 == null) goto L11;
        int r4 = (int) IRoomKtKt.getId(r3);
    L12:
        y50.b.a.b(r8, "room_id", r4);
        if (r3 == null) goto L15;
        String r5 = IRoomKt_androidKt.getOwnerUserIdString(r3);
    L16:
        y50.b.a.d(r8, "anchor_id", r5);
        LinkCrossRoomDataHolder r6 = g();
        if (r6 == null) goto L19;
        Long r7 = Long.valueOf(r6.c());
    L20:
        y50.b.a.d(r8, "channel_id", String.valueOf(r7));
        w31.c r9 = h();
        if (r9 == null) goto L23;
        long r10 = r9.i();
    L24:
        y50.b.a.c(r8, "pk_id", r10);
        com.bytedance.android.live.revlink.impl.global.c r12 = this.o;
        if (r12 == null) goto L27;
        com.bytedance.android.live.revlink.impl.utils.a r13 = r12.B8();
    L28:
        if (r13 == null) goto L30;
        String r14 = r13.b();
    L31:
        y50.b.a.d(r8, "link_type", r14);
        com.bytedance.android.live.revlink.impl.global.c r15 = this.o;
        if (r15 == null) goto L34;
        LinkRevInternalServiceContext r16 = r15.Cj();
    L35:
        if (r16 != null) goto L37;
    L45:
        com.bytedance.android.live.revlink.impl.global.c r17 = this.o;
        if (r17 == null) goto L48;
        com.bytedance.android.live.revlink.impl.utils.a r18 = r17.B8();
    L49:
        if (r18 == null) goto L53;
        String r19 = r18.a();
        if (r19 == null) goto L53;
        y50.b.a.d(r8, "load_source", r19);
    L53:
        com.bytedance.android.live.revlink.impl.global.c r20 = this.o;
        if (r20 == null) goto L56;
        i11.b r22 = r20.c8();
    L57:
        if (r22 == null) goto L75;
        List<p> r23 = r22.getOnlineUserList();
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator<T> r25 = r23.iterator();
    L60:
        if (r25.hasNext() == false) goto L70;
        p r26 = (p) r25.next();
        StringBuilder r27 = new StringBuilder();
        IBaseUser r28 = r26.getUser();
        if (r28 == null) goto L64;
        String r29 = r28.getIdString();
    L65:
        r27.append(r29);
        r27.append('#');
        r27.append(r26.getInteractId());
        r27.append('#');
        IBaseUser r30 = r26.getUser();
        if (r30 == null) goto L68;
        Long r32 = Long.valueOf(n.a(r30));
    L69:
        r27.append(r32);
        r24.add(r27.toString());
        goto L60
    L68:
        r32 = null;
        goto L69
    L64:
        r29 = null;
        goto L65
    L70:
        y50.b.a.d(r8, "online", r24.toString());
        return;
    L75:
        return;
    L56:
        r22 = null;
        goto L57
    L48:
        r18 = null;
        goto L49
    L37:
        if (((Boolean) r16.isAppBackground().getValue()).booleanValue() == false) goto L39;
        y50.b.a.e(r8, "app_background", true);
    L44:
        i97.a r33 = i97.a.a;
        y50.b.a.c(r8, "room_stay_duration", System.currentTimeMillis() - r16.getEnterRoomTs());
        y50.b.a.d(r8, "enter_room_info", String.valueOf(r16.getEnterRoomLinkInfo().getValue()));
        goto L45
    L39:
        com.bytedance.android.live.revlink.impl.service.internal.a r34 = (com.bytedance.android.live.revlink.impl.service.internal.a) r16.getService().getValue();
        if (r34 == null) goto L44;
        if (r34.dc() != true) goto L44;
        y50.b.a.e(r8, "live_background", true);
        goto L44
    L34:
        r16 = null;
        goto L35
    L30:
        r14 = null;
        goto L31
    L27:
        r13 = null;
        goto L28
    L23:
        r10 = 0;
        goto L24
    L19:
        r7 = null;
        goto L20
    L15:
        r5 = null;
        goto L16
    L11:
        r4 = -1;
    L7:
        r2 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [int] */
    /* JADX WARN: Type inference failed for: r3v67 */
    public final void d(JSONObject r14) {
        Intrinsics.checkNotNullParameter(r14, "extra");
        LinkCrossRoomDataHolder r0 = g();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.o;
        com.bytedance.android.live.revenuelink.connect.f r2 = null;
        if (r1 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r3 = r1.Ig();
    L6:
        LinkCrossRoomDataHolder r4 = g();
        if (r4 == null) goto L9;
        Long r5 = Long.valueOf(r4.c());
    L10:
        y50.b.a.d(r14, "channel_id", String.valueOf(r5));
        LinkCrossRoomDataHolder r6 = g();
        if (r6 == null) goto L13;
        Long r7 = Long.valueOf(r6.c());
    L14:
        y50.b.a.d(r14, "event_session_id", String.valueOf(r7));
        com.bytedance.android.livesdk.revenue.service.room.c r8 = this.n;
        if (r8 == null) goto L19;
        com.bytedance.android.livesdk.revenue.room.a r9 = r8.getRoomContext();
        if (r9 == null) goto L19;
        IRoomBase r10 = r9.getCommonRoom();
    L20:
        IRoomBase r12 = (IRoom) r10;
        int r13 = 0;
        if (r12 != null) goto L23;
    L25:
        boolean r15 = false;
    L26:
        if (r15 == false) goto L28;
        IRoomBase r16 = r12;
    L29:
        String r17 = "";
        String r18 = DataType.FALSE;
        if (r16 == null) goto L47;
        if (r12 != null) goto L33;
    L35:
        String r19 = DataType.FALSE;
    L36:
        y50.b.a.d(r14, "room_id", r19);
        if (r12 != null) goto L39;
    L45:
        String r20 = null;
    L46:
        y50.b.a.d(r14, "anchor_id", r20);
        goto L47
    L39:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r12) != true) goto L45;
        IBaseUser r22 = r16.getOwnerKt();
        if (r22 == null) goto L44;
        r20 = r22.getIdString();
        if (r20 != null) goto L46;
    L44:
        r20 = "";
        goto L46
    L33:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r12) != true) goto L35;
        r19 = r16.getIdStr();
    L47:
        w31.c r23 = h();
        if (r23 == null) goto L58;
        IRoomBase r24 = r23.k();
        if (r24 == null) goto L58;
        y50.b.a.c(r14, "to_room_id", IRoomKtKt.getId(r24));
        if (r24.getOwnerKt() == null) goto L58;
        IBaseUser r25 = r24.getOwnerKt();
        if (r25 == null) goto L56;
        Intrinsics.checkNotNullParameter(r25, "$this$secUidExt");
        String r26 = r25.getCastSecUid();
    L57:
        y50.b.a.d(r14, "set_to_user_id", r26);
        goto L58
    L56:
        r26 = null;
    L58:
        com.bytedance.android.live.revlink.impl.global.c r27 = this.o;
        if (r27 == null) goto L61;
        IPKLinkBizDataService r28 = r27.mk();
    L62:
        if (r28 == null) goto L72;
        IPKLinkBizDataService.c r29 = r28.getGuestInfo();
        if (r29 == null) goto L72;
        k2 r30 = r29.f;
        if (r30 == null) goto L72;
        y50.b.a.c(r14, "opposite_webcast_version", r30.getWebcastVersion());
        String r32 = r30.getDevicePlatform();
        if (r32 != null) goto L70;
        r32 = "";
    L70:
        y50.b.a.d(r14, "opposite_device_platform", r32);
    L72:
        if (r0 == null) goto L74;
        long r110 = r0.i();
    L75:
        y50.b.a.c(r14, "match_type", r110);
        f r33 = e();
        if (r33 == null) goto L84;
        i r34 = r33.getRtcManager();
        if (r34 == null) goto L84;
        if (r34.F() != true) goto L82;
        int r35 = 1;
    L83:
        y50.b.a.b(r14, "is_client_mixstream", r35);
        goto L84
    L82:
        r35 = 0;
    L84:
        w31.c r36 = h();
        if (r36 == null) goto L97;
        String r37 = r36.b();
        if (r37 == null) goto L97;
        f r38 = e();
        if (r38 == null) goto L97;
        i r39 = r38.getRtcManager();
        if (r39 == null) goto L97;
        com.bytedance.android.live.revenuelink.rtc.p r40 = r39.L();
        if (r40 == null) goto L97;
        o r42 = r40.k(r37);
        if (r42 == null) goto L97;
        ?? r43 = r42.g;
    L98:
        y50.b.a.b(r14, "disable_opposite_mic", r43);
        w31.c r44 = h();
        if (r44 == null) goto L101;
        long r111 = r44.i();
    L102:
        y50.b.a.c(r14, "pk_id", r111);
        if (r0 == null) goto L105;
        int r45 = r0.f();
    L106:
        y50.b.a.b(r14, "invitee_list", r45);
        w31.c r46 = h();
        if (r46 == null) goto L109;
        String r47 = r46.c();
    L110:
        y50.b.a.d(r14, "invitee_id", r47);
        com.bytedance.android.live.revlink.impl.global.c r48 = this.o;
        if (r48 == null) goto L113;
        IPKLinkBizDataService r49 = r48.mk();
    L114:
        if (r49 == null) goto L116;
        int r50 = r49.getPeakSwitchPlayMode();
    L117:
        y50.b.a.b(r14, "switch_play_mode", r50);
        cy0.e.a.getClass();
        j r52 = cy0.e.a.a;
        m.e.getClass();
        Object r53 = m.b(r52).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r53);
        IBaseUser r54 = ((com.bytedance.live.kmp.core.c) r53).b();
        if (r54 == null) goto L121;
        String r55 = r54.getIdString();
        if (r55 == null) goto L121;
    L122:
        y50.b.a.d(r14, "inviter_id", r55);
        com.bytedance.android.live.revlink.impl.global.c r56 = this.o;
        if (r56 == null) goto L125;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r57 = r56.getPKBaseUtils();
    L126:
        if (r57 == null) goto L130;
        cf2.a r58 = r57.a();
        if (r58 == null) goto L130;
        long r112 = r58.a;
    L131:
        y50.b.a.c(r14, "left_score", r112);
        com.bytedance.android.live.revlink.impl.global.c r59 = this.o;
        if (r59 == null) goto L134;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r60 = r59.el();
    L135:
        if (r60 == null) goto L139;
        cf2.a r62 = r60.a();
        if (r62 == null) goto L139;
        long r113 = r62.a;
    L140:
        y50.b.a.c(r14, "right_score", r113);
        com.bytedance.android.live.revlink.impl.global.c r63 = this.o;
        if (r63 == null) goto L143;
        q r64 = r63.getPkUtils();
    L144:
        if (r64 != null) goto L146;
    L148:
        int r65 = 0;
    L149:
        y50.b.a.b(r14, "is_oncemore", r65);
        w31.c r66 = h();
        if (r66 != null) goto L152;
    L154:
        int r67 = 0;
    L155:
        y50.b.a.b(r14, "is_transform", r67);
        y50.b.a.c(r14, "pk_invite_time_interval", this.b);
        y50.b.a.c(r14, "pk_receive_invite_time_interval", this.c);
        y50.b.a.c(r14, "pk_reply_time_interval", this.d);
        y50.b.a.c(r14, "pk_reveive_reply_interval", this.e);
        y50.b.a.c(r14, "pk_server_join_channel_time_interval", 0);
        boolean r68 = this.f;
        String r69 = DataType.TRUE;
        if (r68 == false) goto L158;
        String r70 = DataType.TRUE;
    L159:
        y50.b.a.d(r14, "join_channel_in_advance", r70);
        if (this.g == false) goto L162;
        String r72 = DataType.TRUE;
    L163:
        y50.b.a.d(r14, "push_stream_in_advance", r72);
        if (this.h == false) goto L166;
        String r73 = DataType.TRUE;
    L167:
        y50.b.a.d(r14, "remove_business_join_channel", r73);
        y50.b.a.d(r14, "battle_open_source", this.i);
        if (r14.has("support_multi_invite") == true) goto L175;
        if (this.l == false) goto L172;
        String r74 = DataType.TRUE;
    L173:
        y50.b.a.d(r14, "support_multi_invite", r74);
        goto L175
    L172:
        r74 = DataType.FALSE;
    L175:
        if (r14.has("is_first_invite") == false) goto L177;
    L181:
        y50.b.a.c(r14, "pk_score_bar_load_time_interval", this.j);
        y50.b.a.b(r14, "battle_type", this.k);
        com.bytedance.android.live.revlink.impl.global.c r75 = this.o;
        if (r75 == null) goto L184;
        RevLinkMultiChannelDataContext r76 = r75.Lj();
    L185:
        if (r76 == null) goto L193;
        LiveData<b7> r77 = r76.getMultiChannelData();
        if (r77 == null) goto L193;
        b7 r78 = (b7) r77.getValue();
        if (r78 == null) goto L193;
        if (r78.getUseMultiChannel() != true) goto L193;
        String r79 = DataType.TRUE;
    L194:
        y50.b.a.d(r14, "use_multi_channel", r79);
        b03.a r80 = b03.a.a;
        if (FoldScreenUtils.f() == false) goto L197;
        String r82 = DataType.TRUE;
    L198:
        y50.b.a.d(r14, "is_fold_screen", r82);
        if (b03.a.b() == false) goto L201;
        String r83 = DataType.TRUE;
    L202:
        y50.b.a.d(r14, "is_pad", r83);
        if (r3 == null) goto L205;
        r13 = r3.getPkPlayTimes();
    L205:
        y50.b.a.b(r14, "current_pk_times", r13);
        if (r3 == null) goto L210;
        PkBaseDataContext.PKModType r84 = r3.modType();
        if (r84 == null) goto L210;
    L211:
        y50.b.a.b(r14, "mod_type", r84.getType());
        if (r3 == null) goto L217;
        MutableLiveData<Long> r85 = r3.getAudioPunishRemainTime();
        if (r85 == null) goto L217;
        Long r86 = (Long) r85.getValue();
        if (r86 == null) goto L217;
    L219:
        if (r86.longValue() > 0) goto L222;
        r69 = DataType.FALSE;
    L222:
        y50.b.a.d(r14, "is_in_audio_punish", r69);
        f r87 = e();
        if (r87 == null) goto L230;
        i r88 = r87.getRtcManager();
        if (r88 == null) goto L230;
        String r89 = r88.c0();
        if (r89 == null) goto L230;
        r17 = r89;
    L230:
        y50.b.a.d(r14, "linker_session_id", r17);
        com.bytedance.android.live.revlink.impl.global.c r90 = this.o;
        if (r90 == null) goto L233;
        r2 = r90.Z0();
    L233:
        if (r2 == null) goto L242;
        LiveData<ey.f> r92 = r2.connectState();
        if (r92 == null) goto L242;
        ey.f r93 = (ey.f) r92.getValue();
        if (r93 == null) goto L242;
        String r94 = String.valueOf(r93.c);
        if (r94 == null) goto L242;
        r18 = r94;
    L242:
        y50.b.a.d(r14, "biz_type", r18);
        return;
    L217:
        r86 = 0L;
    L210:
        r84 = PkBaseDataContext.PKModType.Default;
        goto L211
    L201:
        r83 = DataType.FALSE;
        goto L202
    L197:
        r82 = DataType.FALSE;
    L193:
        r79 = DataType.FALSE;
        goto L194
    L184:
        r76 = null;
        goto L185
    L177:
        if (this.m == false) goto L179;
        String r95 = DataType.TRUE;
    L180:
        y50.b.a.d(r14, "is_first_invite", r95);
        goto L181
    L179:
        r95 = DataType.FALSE;
        goto L180
    L166:
        r73 = DataType.FALSE;
        goto L167
    L162:
        r72 = DataType.FALSE;
        goto L163
    L158:
        r70 = DataType.FALSE;
        goto L159
    L152:
        if (r66.q() != true) goto L154;
        r67 = 1;
        goto L155
    L146:
        if (r64.e() != true) goto L148;
        r65 = 1;
        goto L149
    L143:
        r64 = null;
    L139:
        r113 = 0;
        goto L140
    L134:
        r60 = null;
    L130:
        r112 = 0;
        goto L131
    L125:
        r57 = null;
    L121:
        r55 = "";
        goto L122
    L116:
        r50 = 0;
        goto L117
    L113:
        r49 = null;
        goto L114
    L109:
        r47 = null;
        goto L110
    L105:
        r45 = 0;
        goto L106
    L101:
        r111 = 0;
    L97:
        r43 = 0;
        goto L98
    L74:
        r110 = 0;
        goto L75
    L61:
        r28 = null;
        goto L62
    L28:
        r16 = null;
        goto L29
    L23:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r12) != true) goto L25;
        r15 = true;
    L19:
        r10 = null;
        goto L20
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void k(String r7) {
        JSONObject r5 = new JSONObject();
        y50.b.a.d(r5, "business_api_name", "live_click_in_pk_inviting");
        d(r5);
        HashMap r4 = new HashMap();
        r4.put("business_api_name", "live_click_in_pk_inviting");
        r4.put("android_event_key", "live_click_in_pk_inviting");
        com.bytedance.android.live.revenuelink.f r0 = i();
        if (r0 == null) goto L6;
        com.bytedance.android.live.revenuelink.f.a.b(r0, LiveTracingMonitorKt.EventModule.PK, 0, r7, r4, r5);
        return;
    }

    public LiveFullLinkPKMonitor(com.bytedance.android.livesdk.revenue.service.room.c r1, LinkFakeGlobalService r2) {
        this.n = r1;
        this.o = r2;
        this.i = "";
    }

    public static void m(LiveFullLinkPKMonitor r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        JSONObject r7 = new JSONObject();
        LiveTracingMonitorKt.EventModule r3 = LiveTracingMonitorKt.EventModule.PK;
        r8.c(r7, r3);
        y50.b.a.d(r7, "business_api_name", r9);
        HashMap r6 = new HashMap();
        r6.put("business_api_name", r9);
        r6.put("android_event_key", r9);
        com.bytedance.android.live.revenuelink.f r1 = r8.i();
        if (r1 == null) goto L6;
        r1.c0("ttlive_pk_business_api_call", r3, 0, "", r6, r7);
        return;
    }

    public final void c(JSONObject r7, LiveTracingMonitorKt.EventModule r8) {
        if (r8 != LiveTracingMonitorKt.EventModule.PK) goto L5;
        d(r7);
    L5:
        LinkCrossRoomDataHolder r9 = g();
        String r0 = null;
        if (r9 == null) goto L8;
        Long r10 = Long.valueOf(r9.c());
    L9:
        y50.b.a.d(r7, "channel_id", String.valueOf(r10));
        LinkCrossRoomDataHolder r12 = g();
        if (r12 == null) goto L12;
        Long r13 = Long.valueOf(r12.c());
    L13:
        y50.b.a.d(r7, "event_session_id", String.valueOf(r13));
        com.bytedance.android.livesdk.revenue.service.room.c r14 = this.n;
        if (r14 == null) goto L18;
        com.bytedance.android.livesdk.revenue.room.a r15 = r14.getRoomContext();
        if (r15 == null) goto L18;
        IRoomBase r16 = r15.getCommonRoom();
    L19:
        IRoomBase r17 = (IRoom) r16;
        int r1 = 0;
        if (r17 != null) goto L22;
    L24:
        boolean r3 = false;
    L25:
        if (r3 == false) goto L27;
        IRoomBase r4 = r17;
    L28:
        if (r4 == null) goto L45;
        if (r17 != null) goto L31;
    L33:
        String r5 = DataType.FALSE;
    L34:
        y50.b.a.d(r7, "room_id", r5);
        if (r17 != null) goto L37;
    L43:
        String r18 = null;
    L44:
        y50.b.a.d(r7, "anchor_id", r18);
        goto L45
    L37:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r17) != true) goto L43;
        IBaseUser r19 = r4.getOwnerKt();
        if (r19 == null) goto L41;
        String r20 = r19.getIdString();
    L42:
        r18 = String.valueOf(r20);
        goto L44
    L41:
        r20 = null;
        goto L42
    L31:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r17) != true) goto L33;
        r5 = r4.getIdStr();
    L45:
        w31.c r22 = h();
        if (r22 == null) goto L55;
        IRoomBase r23 = r22.k();
        if (r23 == null) goto L55;
        y50.b.a.c(r7, "to_room_id", IRoomKtKt.getId(r23));
        if (r23.getOwnerKt() == null) goto L55;
        IBaseUser r24 = r23.getOwnerKt();
        if (r24 == null) goto L54;
        Intrinsics.checkNotNullParameter(r24, "$this$secUidExt");
        r0 = r24.getCastSecUid();
    L54:
        y50.b.a.d(r7, "set_to_user_id", r0);
    L55:
        f r25 = e();
        if (r25 == null) goto L63;
        i r26 = r25.getRtcManager();
        if (r26 == null) goto L63;
        if (r26.F() != true) goto L62;
        r1 = 1;
    L62:
        y50.b.a.b(r7, "is_client_mixstream", r1);
    L63:
        cy0.e.a.getClass();
        j r2 = cy0.e.a.a;
        m.e.getClass();
        Object r27 = m.b(r2).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r27);
        IBaseUser r28 = ((com.bytedance.live.kmp.core.c) r27).b();
        if (r28 == null) goto L67;
        String r29 = r28.getIdString();
        if (r29 == null) goto L67;
    L68:
        y50.b.a.d(r7, "inviter_id", r29);
        return;
    L67:
        r29 = "";
        goto L68
    L27:
        r4 = null;
        goto L28
    L22:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r17) != true) goto L24;
        r3 = true;
    L18:
        r16 = null;
        goto L19
    L12:
        r13 = null;
        goto L13
    L8:
        r10 = null;
        goto L9
    }

    public final void j(int r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "sei");
        JSONObject r3 = new JSONObject();
        y50.b.a.d(r3, "business_api_name", "live_pk_audience_sei_timeout");
        y50.b.a.d(r3, "sei", r10);
        y50.b.a.d(r3, "player_is_playing", String.valueOf(f().isPlaying()));
        y50.b.a.d(r3, "player_has_first_frame", String.valueOf(f().getHasFirstFrame()));
        y50.b.a.d(r3, "player_play_prepared", String.valueOf(f().getPlayPrepared()));
        final String r12 = f().u2();
        if (r12 != null) goto L5;
        String r0 = "";
    L6:
        y50.b.a.d(r3, "stream_cdn_play_url", r0);
        com.bytedance.android.live.revlink.impl.global.c r1 = this.o;
        if (r1 == null) goto L9;
        com.bytedance.android.live.revlink.impl.service.internal.a r2 = r1.Do();
    L10:
        if (r2 != null) goto L12;
    L15:
        u(this, "live_pk_audience_sei_timeout", r3, r9, null, new LiveFullLinkPKMonitor$monitorAudienceSeiTimeout$1(r12), 8);
        return;
    L12:
        if (r2.dc() != true) goto L15;
        b(r3);
        jy0.b.f("ttlive_pk_monitor", "live_pk_audience_sei_timeout: code=" + r9 + " extra=" + r3, null, 4);
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r0 = r12;
        goto L6
    }

    public final void l(String r12, JSONObject r13, LiveTracingMonitorKt.EventModule r14) {
        Intrinsics.checkNotNullParameter(r12, "reason");
        Intrinsics.checkNotNullParameter(r13, "extra");
        Intrinsics.checkNotNullParameter(r14, "eventModule");
        y50.b.a.d(r13, "business_api_name", "abnormal_finish");
        y50.b.a.d(r13, "source", "app_abnormal_exit");
        y50.b.a.d(r13, "reason", r12);
        HashMap r9 = new HashMap();
        r9.put("business_api_name", "abnormal_finish");
        r9.put("android_event_key", "abnormal_finish");
        com.bytedance.android.live.revenuelink.f r5 = i();
        if (r5 == null) goto L6;
        com.bytedance.android.live.revenuelink.f.a.b(r5, r14, 0, DataType.FALSE, r9, r13);
        return;
    }

    public static void n(LiveFullLinkPKMonitor r6, int r7, long r8, int r10) {
        HashMap r0 = new HashMap();
        Intrinsics.checkNotNullParameter(r0, "bizExtra");
        com.bytedance.android.livesdk.revenue.service.room.c r1 = r6.n;
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.revenue.room.a r2 = r1.getRoomContext();
        if (r2 == null) goto L9;
        if (r2.getCommonIsAnchor() != true) goto L9;
        int r3 = 1;
    L10:
        JSONObject r4 = new JSONObject();
        y50.b.a.d(r4, "business_api_name", "live_pk_dynamic_hub_lynx_load");
        y50.b.a.b(r4, "is_stats_obtained", r7);
        y50.b.a.b(r4, "is_anchor", r3);
        y50.b.a.c(r4, Constants.Keys.duration, r8);
        y50.b.a.b(r4, "is_preload", r10);
        y50.b.a.b(r4, "sync_room_load", 1);
        Iterator r9 = r0.entrySet().iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        Map.Entry r12 = (Map.Entry) r9.next();
        y50.b.a.d(r4, (String) r12.getKey(), (String) r12.getValue());
        goto L12
    L14:
        r6.d(r4);
        HashMap r13 = new HashMap();
        r13.put("android_event_key", "live_pk_dynamic_hub_lynx_load");
        com.bytedance.android.live.revenuelink.f r14 = r6.i();
        if (r14 == null) goto L19;
        com.bytedance.android.live.revenuelink.f.a.a(r14, "ttlive_pk_business_api_call", LiveTracingMonitorKt.EventModule.PK, r13, r4);
        return;
    L19:
        return;
    L9:
        r3 = 0;
        goto L10
    }

    public static void t(LiveFullLinkPKMonitor r9, String r10, JSONObject r12, Map r13, int r14) {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = null;
        if ((r14 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = null;
    L8:
        r9.getClass();
        if (r12 != null) goto L11;
        r12 = new JSONObject();
    L11:
        y50.b.a.d(r12, "business_api_name", r10);
        r9.d(r12);
        int r2 = 0;
        if (StringsKt.equals$default(r10, "live_pk_score_bar_load", false, 2, null) == false) goto L35;
        com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.getClass();
        String r0 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.e(false);
        int r3 = StringsKt.indexOf$default(r0, "live_pk_enable_lynx_progress_bar", 0, false, 6, null);
        int r4 = r3 + 35;
        if (r3 != (-1)) goto L16;
    L20:
        boolean r5 = false;
    L22:
        if (r5 == true) goto L24;
    L26:
        if (r5 == true) goto L28;
        r12.put("is_lynx_score_bar", DataType.FALSE);
    L28:
        if (r5 == false) goto L35;
        com.bytedance.android.live.revlink.impl.global.c r6 = r9.o;
        if (r6 == null) goto L32;
        r1 = r6.Ig();
    L32:
        if (r1 == null) goto L34;
        r2 = r1.queryLaunchToBizTypeAndReset();
    L34:
        r12.put("to_biz_type", r2);
        goto L35
    L24:
        if (r12.has("is_lynx_score_bar") == true) goto L26;
        return;
    L16:
        if (r4 >= r0.length()) goto L20;
        if (r0.charAt(r4) != '1') goto L20;
        r5 = true;
    L35:
        if (r13 == null) goto L40;
        Iterator r15 = r13.entrySet().iterator();
    L38:
        if (r15.hasNext() == false) goto L40;
        Map.Entry r7 = (Map.Entry) r15.next();
        r12.put((String) r7.getKey(), r7.getValue());
    L40:
        HashMap r16 = new HashMap();
        r16.put("business_api_name", r10);
        r16.put("android_event_key", r10);
        com.bytedance.android.live.revenuelink.f r17 = r9.i();
        if (r17 == null) goto L45;
        com.bytedance.android.live.revenuelink.f.a.a(r17, "ttlive_pk_business_api_call", LiveTracingMonitorKt.EventModule.PK, r16, r12);
        return;
    }

    public static void o(LiveFullLinkPKMonitor r3, String r4, String r5, String r6, int r7, int r8, int r9) {
        if ((r9 & 8) == 0) goto L6;
        r7 = 1;
    L6:
        if ((r9 & 16) == 0) goto L8;
        r8 = 0;
    L8:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "apiName");
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r6, "failReason");
        JSONObject r10 = new JSONObject();
        y50.b.a.d(r10, "business_api_name", r4);
        y50.b.a.d(r10, "lynx_url", r5);
        y50.b.a.d(r10, "reason", r6);
        y50.b.a.b(r10, "load_source", r8);
        r3.d(r10);
        HashMap r12 = new HashMap();
        r12.put("business_api_name", r4);
        r12.put("android_event_key", r4);
        com.bytedance.android.live.revenuelink.f r13 = r3.i();
        if (r13 == null) goto L15;
        if (r7 != 1) goto L12;
        LiveTracingMonitorKt.EventModule r14 = LiveTracingMonitorKt.EventModule.PK;
    L13:
        com.bytedance.android.live.revenuelink.f.a.a(r13, "ttlive_pk_business_api_call", r14, r12, r10);
        return;
    L12:
        r14 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
        goto L13
    }

    public static void s(LiveFullLinkPKMonitor r10, String r12, long r13, int r14, int r15, HashMap r16, int r17) {
        if ((r17 & 4) == 0) goto L5;
        int r7 = 0;
    L7:
        if ((r17 & 8) == 0) goto L9;
        int r8 = 1;
    L11:
        if ((r17 & 16) == 0) goto L13;
        HashMap r9 = null;
    L14:
        Intrinsics.checkNotNullParameter(r12, "apiPath");
        q(r10, r12, 0, "", r13, r7, r8, r9);
        return;
    L13:
        r9 = r16;
        goto L14
    L9:
        r8 = r15;
        goto L11
    L5:
        r7 = r14;
        goto L7
    }

    public static void u(LiveFullLinkPKMonitor r7, String r8, JSONObject r9, int r10, String r12, Function1 r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r14 & 8) == 0) goto L9;
        r12 = "";
    L9:
        String r4 = r12;
        if ((r14 & 16) == 0) goto L12;
        r13 = null;
    L12:
        r7.b(r9);
        jy0.b.f("ttlive_pk_monitor", r8 + ": code=" + r3 + " msg=" + r4 + " extra=" + r9, null, 4);
        HashMap r5 = new HashMap();
        r5.put("business_api_name", r8);
        r5.put("android_event_key", r8);
        if (r13 == null) goto L15;
        Unit r15 = (Unit) r13.invoke(r5);
    L15:
        com.bytedance.android.live.revenuelink.f r0 = r7.i();
        if (r0 == null) goto L19;
        r0.c0("ttlive_pk_business_api_call", LiveTracingMonitorKt.EventModule.PK, r3, r4, r5, r9);
        return;
    L19:
        return;
    L5:
        r3 = r10;
        goto L7
    }

    public static /* synthetic */ void q(LiveFullLinkPKMonitor r10, String r12, int r13, String r14, long r15, int r16, int r17, HashMap r18) {
        r10.p(r12, r13, r14, r15, r16, r17, r18, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void r(LiveFullLinkPKMonitor r10, String r12, Throwable r13, long r14, int r15, int r16, HashMap r17, int r18) {
        if ((r18 & 8) == 0) goto L5;
        int r6 = 0;
    L7:
        if ((r18 & 16) == 0) goto L9;
        int r7 = 1;
    L11:
        if ((r18 & 32) == 0) goto L13;
        HashMap r8 = null;
    L14:
        Intrinsics.checkNotNullParameter(r12, "apiPath");
        if ((r13 instanceof ApiServerException) == false) goto L22;
        ApiServerException r0 = (ApiServerException) r13;
        int r3 = r0.getErrorCode();
        String r1 = r0.getErrorMsg();
        if (r1 != null) goto L19;
        String r4 = "";
    L20:
        r10.p(r12, r3, r4, r14, r6, r7, r8, r13);
        return;
    L19:
        r4 = r1;
        goto L20
    L22:
        if (r13 == null) goto L27;
        String r2 = r13.toString();
        if (r2 == null) goto L27;
        String r5 = r2;
    L28:
        r10.p(r12, 1, r5, r14, r6, r7, r8, r13);
        return;
    L27:
        r5 = "";
        goto L28
    L13:
        r8 = r17;
        goto L14
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    public final void p(String r12, int r13, String r14, long r15, int r17, int r18, HashMap<String, String> r19, Throwable r20) {
        com.bytedance.android.live.revenuelink.f r2 = i();
        if (r2 != null) goto L5;
    L7:
        JSONObject r10 = new JSONObject();
        d(r10);
        y50.b.a.c(r10, Constants.Keys.duration, r15);
        y50.b.a.d(r10, "server_api_name", r12);
        if (r12.equals("battle/rivals/recommend") == false) goto L10;
        r10.put("load_type", r17);
    L10:
        if (r19 == null) goto L15;
        Iterator<Map.Entry<String, String>> r5 = r19.entrySet().iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        Map.Entry<String, String> r6 = r5.next();
        r10.put(r6.getKey(), r6.getValue());
    L15:
        HashMap r9 = new HashMap();
        if (r20 != null) goto L18;
    L20:
        r9.put("server_api_name", r12);
        r9.put("android_event_key", r12);
        com.bytedance.android.live.revenuelink.f r4 = i();
        if (r4 != null) goto L23;
        return;
    L23:
        if (r18 != 1) goto L25;
        LiveTracingMonitorKt.EventModule r0 = LiveTracingMonitorKt.EventModule.PK;
    L26:
        r4.c0("ttlive_pk_server_api_call", r0, r13, r14, r9, r10);
        return;
    L25:
        r0 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
        goto L26
    L18:
        if ((r20 instanceof CustomApiServerException) == false) goto L20;
        CustomApiServerException r1 = (CustomApiServerException) r20;
        y50.b.a.d(r10, "log_id", r1.getXTtLogId());
        r9.put("log_id", r1.getXTtLogId());
        goto L20
    L5:
        if (r2.X(r12) != true) goto L7;
    }
}
