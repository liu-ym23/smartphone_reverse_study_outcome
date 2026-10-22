package h41;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.n;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.i;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import cy0.j;
import dq2.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ int d = 0;
    public x11.a a;
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public static final class a {
    }

    static {
    }

    public final LinkCrossRoomDataHolder a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkCrossRoomDataHolder();
    }

    public final n b() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 == null) goto L5;
        w31.c r1 = r0.getPkLinkUtils();
    L6:
        if (r1 == null) goto L11;
        IPKLinkBizDataService r2 = r1.g();
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.getPkConnectContext();
    L11:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final IPKLinkBizDataService c() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 == null) goto L5;
        w31.c r1 = r0.getPkLinkUtils();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.g();
    L5:
        r1 = null;
        goto L6
    }

    public c(com.bytedance.android.livesdk.revenue.service.room.c r1, LinkFakeGlobalService r2) {
        this.b = r1;
        this.c = r2;
    }

    public final void d(IRoom r17, int r18, Throwable r19, IRivalExtraInfo r20, Map<String, String> r22, int r23, long r24, String r25) {
        LinkCrossRoomDataHolder r3 = a();
        Integer r4 = null;
        if (r3 == null) goto L5;
        Integer r5 = Integer.valueOf(r3.f());
    L6:
        boolean r6 = true;
        if (r5 != null) goto L10;
    L11:
        if (r5 != null) goto L14;
    L15:
        if (r5 != null) goto L18;
    L19:
        if (r5 != null) goto L22;
    L23:
        if (r5 != null) goto L26;
    L27:
        if (r5 != null) goto L30;
    L31:
        if (r5 != null) goto L34;
    L35:
        if (r5 != null) goto L38;
    L39:
        if (r5 != null) goto L42;
    L43:
        if (r5 != null) goto L46;
    L47:
        if (r5 != null) goto L50;
    L51:
        if (r5 != null) goto L54;
    L55:
        d51.c r7 = d51.c.A0;
        r7.getClass();
        if (ArraysKt.contains((Integer[]) d51.c.o0.getValue(r7, d51.c.a[65]), r5) == true) goto L58;
        return;
    L58:
        LinkedHashMap r8 = new LinkedHashMap();
        if (r19 != null) goto L62;
        r8.put("invitee_status", DataType.FALSE);
    L67:
        if (r17 == null) goto L73;
        r8.put("invitee_room_id", String.valueOf(IRoomKtKt.getId((IRoomBase) r17)));
        if (r17.getOwnerKt() == null) goto L73;
        IBaseUser r1 = r17.getOwnerKt();
        if (r1 == null) goto L73;
        String r2 = r1.getIdString();
    L74:
        r8.put("is_oncemore", DataType.FALSE);
        r8.put("pitch_on", DataType.FALSE);
        com.bytedance.android.live.revlink.impl.global.c r9 = this.c;
        if (r9 == null) goto L77;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r10 = r9.getLinkOptLogContext();
    L79:
        if (r10 == null) goto L82;
        String r12 = r10.c;
        if (r12 == null) goto L82;
    L83:
        r8.put("source", r12);
        r8.put("pk_time", String.valueOf(l51.a.j()));
        r8.put("list_num", String.valueOf(r23 + 1));
        r8.put("stay_time", String.valueOf(r24 / 1000));
        if (r20 != null) goto L86;
    L93:
        com.bytedance.android.livesdk.revenue.service.room.c r13 = this.b;
        if (r13 == null) goto L98;
        com.bytedance.android.livesdk.revenue.room.a r14 = r13.getRoomContext();
        if (r14 == null) goto L98;
        IRoomBase r15 = r14.getCommonRoom();
    L99:
        IRoom r16 = (IRoom) r15;
        if (r16 == null) goto L104;
        IBaseUser r26 = r16.getOwnerKt();
        if (r26 == null) goto L104;
        String r27 = r26.getIdString();
    L105:
        r8.put("is_recommend_list", DataType.FALSE);
        r8.put("pk_description", "routine");
        r8.put("room_status", "live");
        if (c() == null) goto L110;
        IPKLinkBizDataService r110 = c();
        Intrinsics.checkNotNull(r110);
        if (r110.getSelfHasAudienceBeforePk() == false) goto L110;
        r8.put("room_status", "audience_connection");
    L110:
        com.bytedance.android.live.revlink.impl.global.c r111 = this.c;
        if (r111 == null) goto L113;
        IPKLinkBizDataService r112 = r111.mk();
    L114:
        if (r112 == null) goto L125;
        IBattleRivalTag.a r113 = IBattleRivalTag.Companion;
        com.bytedance.android.live.revlink.impl.global.c r114 = this.c;
        if (r114 == null) goto L118;
        IPKLinkBizDataService r115 = r114.mk();
    L119:
        if (r115 == null) goto L123;
        List r116 = r115.getPkBattleRivalTagsInfo();
        if (r116 == null) goto L123;
    L124:
        r113.getClass();
        IBattleRivalTag.a.a(r116, r8);
    L123:
        r116 = CollectionsKt.emptyList();
        goto L124
    L118:
        r115 = null;
    L125:
        com.bytedance.android.live.revlink.impl.global.c r117 = this.c;
        if (r117 == null) goto L128;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r118 = r117.getLinkOptLogContext();
    L129:
        if (r118 == null) goto L131;
        String r119 = r118.a();
    L132:
        r8.put("from_room_status", r119);
        x11.a r120 = this.a;
        if (r120 == null) goto L135;
        y11.d r121 = r120.getPkService();
    L136:
        if (r121 == null) goto L138;
        String r122 = r121.D();
    L140:
        if (r122 != null) goto L142;
    L147:
        if (r121 == null) goto L149;
        String r123 = r121.getInviteMode();
    L151:
        if (r123 != null) goto L153;
    L158:
        if (r121 == null) goto L160;
        String r124 = r121.getTheme();
    L161:
        if (r124 != null) goto L163;
    L168:
        IPKLinkBizDataService r125 = c();
        if (r125 == null) goto L172;
        String r126 = r125.getFlexActivityId();
        if (r126 == null) goto L172;
    L174:
        if (r126.length() > 0) goto L177;
        r6 = false;
    L177:
        if (r6 == false) goto L194;
        IPKLinkBizDataService r28 = c();
        if (r28 == null) goto L181;
        String r29 = r28.getFlexActivityId();
    L182:
        r8.put("pk_activity_type", String.valueOf(r29));
        r8.put("invite_mode", "activity_pk");
        r8.put("connection_type", "manual_pk");
        LinkRevPanelDataContext.b r30 = LinkRevPanelDataContext.Companion;
        int r127 = IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal();
        IPKLinkBizDataService r128 = c();
        if (r128 == null) goto L185;
        String r129 = r128.getFlexActivityId();
    L186:
        com.bytedance.android.live.revlink.impl.control.dialog.e r32 = r30.a(r127, String.valueOf(r129));
        if (r32 == null) goto L194;
        Map<String, String> r33 = r32.f;
        if (r33 == null) goto L194;
        Iterator<Map.Entry<String, String>> r34 = r33.entrySet().iterator();
    L192:
        if (r34.hasNext() == false) goto L194;
        Map.Entry<String, String> r130 = r34.next();
        r8.put(r130.getKey(), r130.getValue());
        goto L192
    L185:
        r129 = null;
        goto L186
    L181:
        r29 = null;
    L194:
        com.bytedance.android.live.revlink.impl.global.c r35 = this.c;
        if (r35 == null) goto L197;
        ox0.a r36 = r35.getModeMerge();
    L198:
        if (r36 == null) goto L200;
        int r37 = r36.a();
    L202:
        if (com.bytedance.android.live.utils.c.a(r37, 32) == false) goto L211;
        cy0.e.a.getClass();
        j r131 = cy0.e.a.a;
        m.e.getClass();
        Object r38 = m.b(r131).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r38);
        if (((com.bytedance.live.kmp.core.c) r38).M1() == null) goto L211;
        Object r39 = m.b(r131).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r39);
        w r40 = ((com.bytedance.live.kmp.core.c) r39).M1();
        if (r40 == null) goto L209;
        String r42 = String.valueOf(r40.w());
        if (r42 == null) goto L209;
    L210:
        r8.put("audience_connect_cnt", r42);
    L212:
        r8.put("invite_type", "anchor");
        r8.put("connection_sub_type", "");
        r8.put("anchor_connection_type", "invite");
        r8.put("anchor_connect_status", DataType.FALSE);
        r8.put("invitee_room_status", "live");
        r8.put("invitee_connect_cnt", DataType.FALSE);
        r8.put("is_random_match", DataType.FALSE);
        r8.put("anchor_invite_type", "invite");
        if (b() == null) goto L234;
        n r43 = b();
        if (r43 == null) goto L217;
        Boolean r44 = Boolean.valueOf(r43.a);
    L218:
        if (r44 == null) goto L234;
        r8.put("support_multi_invite", DataType.TRUE);
        com.bytedance.android.live.revlink.impl.global.c r45 = this.c;
        if (r45 == null) goto L222;
        com.bytedance.android.live.revlink.impl.pk.service.b r46 = r45.Ud();
    L223:
        if (r46 == null) goto L225;
        i11.b r47 = r46.getLinkUserCenter();
    L226:
        if (r47 == null) goto L235;
        i11.b r48 = r46.getLinkUserCenter();
        if (r48 == null) goto L230;
        r48.getInviteeList();
    L230:
        n r49 = b();
        if (r49 == null) goto L233;
        r4 = Integer.valueOf(r49.b);
    L233:
        r8.put("invited_cnt", String.valueOf(r4));
    L235:
        if (r22 == null) goto L237;
        r8.putAll(r22);
    L237:
        if (r25 == null) goto L241;
        Map<String, String> r50 = h.a(r25);
        if (r50 == null) goto L241;
        r8.putAll(r50);
    L241:
        mz0.n r52 = new mz0.n();
        Map<String, String> r53 = r52.a;
        Intrinsics.checkNotNullParameter(r53, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r53.putAll(r8);
        mz0.m r54 = new mz0.m();
        LinkCrossRoomDataHolder r55 = a();
        if (r55 == null) goto L244;
        r55.m(r54);
    L244:
        i r56 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r56, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live", "belong");
        r56.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r56.d("other");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r56.c("live_detail");
        ((ArrayList) r54.a).add(r56.a);
        com.bytedance.android.livesdk.revenue.log.h r57 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r57, "linkInfoLog");
        r57.f(r2);
        r57.e(r27);
        String r58 = l51.a.m();
        Intrinsics.checkNotNullParameter(r58, "title");
        r57.h(r58);
        LinkCrossRoomDataHolder r59 = a();
        if (r59 == null) goto L247;
        long r60 = r59.f();
    L248:
        r57.c(r60);
        r57.g();
        ((ArrayList) r54.a).add(r57.a);
        r54.b(LogCommon.ROOM);
        ((ArrayList) r52.b).addAll(r54.a);
        cy0.e.a.getClass();
        j r62 = cy0.e.a.a;
        m.e.getClass();
        Object r63 = m.b(r62).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r63);
        ((mz0.i) ((f80.a) r63)).w3("connection_invite", r52.a, r52.b);
        return;
    L247:
        r60 = 0;
        goto L248
    L225:
        r47 = null;
        goto L226
    L222:
        r46 = null;
        goto L223
    L217:
        r44 = null;
    L234:
        r8.put("support_multi_invite", DataType.FALSE);
    L209:
        r42 = "";
    L211:
        r8.put("audience_connect_cnt", DataType.FALSE);
        goto L212
    L200:
        r37 = 0;
        goto L202
    L197:
        r36 = null;
    L172:
        r126 = "";
        goto L174
    L163:
        if (r124.length() <= 0) goto L165;
        boolean r132 = true;
    L166:
        if (r132 != true) goto L168;
        r8.put(FileUtils.PICTURE_THEME, r124);
        goto L168
    L165:
        r132 = false;
        goto L166
    L160:
        r124 = null;
        goto L161
    L153:
        if (r123.length() <= 0) goto L155;
        boolean r133 = true;
    L156:
        if (r133 != true) goto L158;
        r8.put("invite_mode", r123);
        goto L158
    L155:
        r133 = false;
        goto L156
    L149:
        r123 = null;
        goto L151
    L142:
        if (r122.length() <= 0) goto L144;
        boolean r134 = true;
    L145:
        if (r134 != true) goto L147;
        r8.put("transform_reason", r122);
        goto L147
    L144:
        r134 = false;
        goto L145
    L138:
        r122 = null;
        goto L140
    L135:
        r121 = null;
        goto L136
    L131:
        r119 = "";
        goto L132
    L128:
        r118 = null;
        goto L129
    L113:
        r112 = null;
    L104:
        r27 = null;
    L98:
        r15 = null;
        goto L99
    L86:
        if (r20.getText_type() != IRivalExtraInfo.TextType.Distance.ordinal()) goto L89;
        String r64 = "distance";
    L92:
        r8.put("inviter_level", String.valueOf(r18));
        HashMap r135 = new HashMap();
        r135.put(r64, r20.getText());
        r8.put("anchor_info", GsonProtectorUtils.toJson(l97.a.a, r135));
        goto L93
    L89:
        if (r20.getText_type() != IRivalExtraInfo.TextType.DistanceCity.ordinal()) goto L91;
        r64 = "city";
        goto L92
    L91:
        r64 = "money";
    L82:
        r12 = "";
        goto L83
    L77:
        r10 = null;
    L73:
        r2 = null;
        goto L74
    L62:
        if ((r19 instanceof ApiServerException) == true) goto L64;
    L66:
        r8.put("invitee_status", "2");
        goto L67
    L64:
        if (((ApiServerException) r19).getErrorCode() != 31002) goto L66;
        r8.put("invitee_status", DataType.TRUE);
        goto L66
    L54:
        if (r5.intValue() == 102) goto L58;
    L50:
        if (r5.intValue() == 101) goto L58;
    L46:
        if (r5.intValue() == 106) goto L58;
    L42:
        if (r5.intValue() == 105) goto L58;
    L38:
        if (r5.intValue() == 12) goto L58;
    L34:
        if (r5.intValue() == 9) goto L58;
    L30:
        if (r5.intValue() == 4) goto L58;
    L26:
        if (r5.intValue() == 104) goto L58;
    L22:
        if (r5.intValue() == 103) goto L58;
    L18:
        if (r5.intValue() == 3) goto L58;
    L14:
        if (r5.intValue() == 2) goto L58;
    L10:
        if (r5.intValue() == 1) goto L58;
    L5:
        r5 = null;
        goto L6
    }
}
