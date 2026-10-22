package com.bytedance.android.live.revlink.impl.multianchor.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class e extends y50.b {
    public final ld.a b;
    public final com.bytedance.android.livesdk.revenue.service.room.c c;
    public final com.bytedance.android.live.revlink.impl.global.c d;

    private final com.bytedance.android.live.revlink.impl.utils.a i() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.B8();
    }

    public final Map<String, Object> j() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.c;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L7;
        IRoomBase r2 = r1.getCommonRoom();
    L8:
        IRoomBase r3 = (IRoom) r2;
        LinkedHashMap r4 = new LinkedHashMap();
        if (r3 == null) goto L11;
        long r5 = IRoomKtKt.getId(r3);
    L12:
        r4.put("room_id", Long.valueOf(r5));
        if (r3 == null) goto L18;
        IBaseUser r6 = r3.getOwnerKt();
        if (r6 == null) goto L18;
        String r7 = r6.getIdString();
        if (r7 == null) goto L18;
    L19:
        r4.put("anchor_id", r7);
        return r4;
    L18:
        r7 = "";
        goto L19
    L11:
        r5 = 0;
    L7:
        r2 = null;
        goto L8
    }

    public final boolean k() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.c;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L7;
        return r1.getCommonIsAnchor();
    L7:
        return false;
    }

    public final void b(Map<String, Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.f r2 = r0.Z0();
    L6:
        if (r2 == null) goto L12;
        LiveData<ey.f> r3 = r2.connectState();
        if (r3 == null) goto L12;
        ey.f r4 = (ey.f) r3.getValue();
        if (r4 == null) goto L12;
        r12.put("connect_state", r4.toString());
        r12.put("biz_type", String.valueOf(r4.c));
    L12:
        com.bytedance.android.live.revlink.impl.global.c r5 = this.d;
        if (r5 == null) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r6 = r5.R8();
    L16:
        int r7 = 1;
        if (r6 == null) goto L50;
        i11.b r8 = r6.getLinkUserCenter();
        if (r8 == null) goto L50;
        StringBuilder r9 = new StringBuilder();
        r9.append(r8.getOnlineUserList().size());
        r9.append('_');
        r9.append(r8.a().size());
        r12.put("list_cnt", r9.toString());
        List<com.bytedance.android.livesdk.link.model.p> r10 = r8.getOnlineUserList();
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r14 = r10.iterator();
    L22:
        if (r14.hasNext() == false) goto L32;
        com.bytedance.android.livesdk.link.model.p r15 = (com.bytedance.android.livesdk.link.model.p) r14.next();
        StringBuilder r16 = new StringBuilder();
        IBaseUser r17 = r15.getUser();
        if (r17 == null) goto L26;
        String r18 = r17.getIdString();
    L27:
        r16.append(r18);
        r16.append('#');
        r16.append(r15.getInteractId());
        r16.append('#');
        IBaseUser r19 = r15.getUser();
        if (r19 == null) goto L30;
        Long r20 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r19));
    L31:
        r16.append(r20);
        r13.add(r16.toString());
        goto L22
    L30:
        r20 = null;
        goto L31
    L26:
        r18 = null;
        goto L27
    L32:
        r12.put("online", r13.toString());
        List<com.bytedance.android.livesdk.link.model.p> r22 = r8.a();
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator<T> r24 = r22.iterator();
    L34:
        if (r24.hasNext() == false) goto L44;
        com.bytedance.android.livesdk.link.model.p r25 = (com.bytedance.android.livesdk.link.model.p) r24.next();
        StringBuilder r26 = new StringBuilder();
        IBaseUser r27 = r25.getUser();
        if (r27 == null) goto L38;
        String r28 = r27.getIdString();
    L39:
        r26.append(r28);
        r26.append('#');
        r26.append(r25.getInteractId());
        r26.append('#');
        IBaseUser r29 = r25.getUser();
        if (r29 == null) goto L42;
        Long r30 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r29));
    L43:
        r26.append(r30);
        r23.add(r26.toString());
        goto L34
    L42:
        r30 = null;
        goto L43
    L38:
        r28 = null;
        goto L39
    L44:
        r12.put("waiting", r23.toString());
        List<IBaseUser> r32 = r8.getInviteeList();
        if ((!r32.isEmpty()) == true) goto L48;
        r32 = null;
    L48:
        if (r32 == null) goto L50;
        r12.put("invitee_list", r32.toString());
    L50:
        com.bytedance.android.live.revlink.impl.global.c r33 = this.d;
        if (r33 == null) goto L53;
        com.bytedance.android.live.revenuelink.rtc.f r34 = r33.m0();
    L54:
        if (r34 == null) goto L78;
        com.bytedance.android.live.revenuelink.rtc.i r35 = r34.getRtcManager();
        if (r35 == null) goto L78;
        r12.put("rtc_users", r35.L().toString());
        if ((!r35.L0().isEmpty()) == false) goto L77;
        List<vc0.a> r36 = r35.L0();
        ArrayList r37 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10));
        Iterator<T> r38 = r36.iterator();
    L61:
        if (r38.hasNext() == false) goto L76;
        vc0.a r39 = (vc0.a) r38.next();
        Object r40 = r39.b;
        if ((r40 instanceof xh6.c) == true) goto L65;
        xh6.c r42 = vh6.c.b(fr2.g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.g.class), r39.a);
        if ((r42 instanceof fr2.g) == true) goto L71;
        r42 = null;
    L71:
        fr2.g r43 = (fr2.g) r42;
    L72:
        if (r43 == null) goto L74;
        String r44 = r43.getRoomId();
    L75:
        r37.add(r44);
        goto L61
    L74:
        r44 = null;
        goto L75
    L65:
        if ((r40 instanceof fr2.g) == true) goto L67;
        r40 = null;
    L67:
        r43 = (fr2.g) r40;
        goto L72
    L76:
        r12.put("forward_rooms", r37.toString());
    L77:
        r12.put("linker_session_id", r35.c0());
    L78:
        com.bytedance.android.live.revlink.impl.global.c r45 = this.d;
        if (r45 == null) goto L83;
        AnchorRtcConnectModel r46 = r45.Hb();
        if (r46 == null) goto L83;
        r12.put("forward_info", r46.forwardInfoString());
        r12.put("frame_info", r46.frameInfoString());
    L83:
        com.bytedance.android.live.revlink.impl.global.c r47 = this.d;
        if (r47 == null) goto L86;
        AnchorRtcConnectModel r48 = r47.Hb();
    L87:
        if (r48 != null) goto L90;
        r7 = 0;
    L90:
        r12.put("is_new_multi_channel_data", Integer.valueOf(r7));
        com.bytedance.android.live.revlink.impl.global.c r49 = this.d;
        if (r49 == null) goto L93;
        r1 = r49.Ig();
    L93:
        if (r1 != null) goto L95;
        return;
    L95:
        if (r1.isBattleShow() == false) goto L108;
        r12.put("multi_pk", Boolean.valueOf(r1.isBattleShow()));
        return;
    L108:
        return;
    L86:
        r48 = null;
        goto L87
    L53:
        r34 = null;
        goto L54
    L15:
        r6 = null;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    public final void c(JSONObject r12) {
        Intrinsics.checkNotNullParameter(r12, "json");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.f r2 = r0.Z0();
    L6:
        if (r2 == null) goto L12;
        LiveData<ey.f> r3 = r2.connectState();
        if (r3 == null) goto L12;
        ey.f r4 = (ey.f) r3.getValue();
        if (r4 == null) goto L12;
        y50.b.a.d(r12, "connect_state", r4.toString());
        y50.b.a.d(r12, "biz_type", String.valueOf(r4.c));
    L12:
        com.bytedance.android.live.revlink.impl.global.c r5 = this.d;
        if (r5 == null) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r6 = r5.R8();
    L16:
        int r7 = 1;
        if (r6 == null) goto L50;
        i11.b r8 = r6.getLinkUserCenter();
        if (r8 == null) goto L50;
        StringBuilder r9 = new StringBuilder();
        r9.append(r8.getOnlineUserList().size());
        r9.append('_');
        r9.append(r8.a().size());
        y50.b.a.d(r12, "list_cnt", r9.toString());
        List<com.bytedance.android.livesdk.link.model.p> r10 = r8.getOnlineUserList();
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r14 = r10.iterator();
    L22:
        if (r14.hasNext() == false) goto L32;
        com.bytedance.android.livesdk.link.model.p r15 = (com.bytedance.android.livesdk.link.model.p) r14.next();
        StringBuilder r16 = new StringBuilder();
        IBaseUser r17 = r15.getUser();
        if (r17 == null) goto L26;
        String r18 = r17.getIdString();
    L27:
        r16.append(r18);
        r16.append('#');
        r16.append(r15.getInteractId());
        r16.append('#');
        IBaseUser r19 = r15.getUser();
        if (r19 == null) goto L30;
        Long r20 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r19));
    L31:
        r16.append(r20);
        r13.add(r16.toString());
        goto L22
    L30:
        r20 = null;
        goto L31
    L26:
        r18 = null;
        goto L27
    L32:
        y50.b.a.d(r12, "online", r13.toString());
        List<com.bytedance.android.livesdk.link.model.p> r22 = r8.a();
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator<T> r24 = r22.iterator();
    L34:
        if (r24.hasNext() == false) goto L44;
        com.bytedance.android.livesdk.link.model.p r25 = (com.bytedance.android.livesdk.link.model.p) r24.next();
        StringBuilder r26 = new StringBuilder();
        IBaseUser r27 = r25.getUser();
        if (r27 == null) goto L38;
        String r28 = r27.getIdString();
    L39:
        r26.append(r28);
        r26.append('#');
        r26.append(r25.getInteractId());
        r26.append('#');
        IBaseUser r29 = r25.getUser();
        if (r29 == null) goto L42;
        Long r30 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r29));
    L43:
        r26.append(r30);
        r23.add(r26.toString());
        goto L34
    L42:
        r30 = null;
        goto L43
    L38:
        r28 = null;
        goto L39
    L44:
        y50.b.a.d(r12, "waiting", r23.toString());
        List<IBaseUser> r32 = r8.getInviteeList();
        if ((!r32.isEmpty()) == true) goto L48;
        r32 = null;
    L48:
        if (r32 == null) goto L50;
        y50.b.a.d(r12, "invitee_list", r32.toString());
    L50:
        com.bytedance.android.live.revlink.impl.global.c r33 = this.d;
        if (r33 == null) goto L53;
        com.bytedance.android.live.revenuelink.rtc.f r34 = r33.m0();
    L54:
        if (r34 == null) goto L77;
        com.bytedance.android.live.revenuelink.rtc.i r35 = r34.getRtcManager();
        if (r35 == null) goto L77;
        y50.b.a.d(r12, "rtc_users", r35.L().toString());
        if ((!r35.L0().isEmpty()) == false) goto L77;
        List<vc0.a> r36 = r35.L0();
        ArrayList r37 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10));
        Iterator<T> r38 = r36.iterator();
    L61:
        if (r38.hasNext() == false) goto L76;
        vc0.a r39 = (vc0.a) r38.next();
        Object r40 = r39.b;
        if ((r40 instanceof xh6.c) == true) goto L65;
        xh6.c r42 = vh6.c.b(fr2.g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.g.class), r39.a);
        if ((r42 instanceof fr2.g) == true) goto L71;
        r42 = null;
    L71:
        fr2.g r43 = (fr2.g) r42;
    L72:
        if (r43 == null) goto L74;
        String r44 = r43.getRoomId();
    L75:
        r37.add(r44);
        goto L61
    L74:
        r44 = null;
        goto L75
    L65:
        if ((r40 instanceof fr2.g) == true) goto L67;
        r40 = null;
    L67:
        r43 = (fr2.g) r40;
        goto L72
    L76:
        y50.b.a.d(r12, "forward_rooms", r37.toString());
    L77:
        com.bytedance.android.live.revlink.impl.global.c r45 = this.d;
        if (r45 == null) goto L82;
        AnchorRtcConnectModel r46 = r45.Hb();
        if (r46 == null) goto L82;
        y50.b.a.d(r12, "forward_info", r46.forwardInfoString());
        y50.b.a.d(r12, "frame_info", r46.frameInfoString());
    L82:
        com.bytedance.android.live.revlink.impl.global.c r47 = this.d;
        if (r47 == null) goto L85;
        AnchorRtcConnectModel r48 = r47.Hb();
    L86:
        if (r48 != null) goto L89;
        r7 = 0;
    L89:
        y50.b.a.b(r12, "is_new_multi_channel_data", r7);
        com.bytedance.android.live.revlink.impl.global.c r49 = this.d;
        if (r49 == null) goto L92;
        r1 = r49.Ig();
    L92:
        if (r1 != null) goto L94;
        return;
    L94:
        if (r1.isBattleShow() == false) goto L107;
        y50.b.a.e(r12, "multi_pk", r1.isBattleShow());
        return;
    L107:
        return;
    L85:
        r48 = null;
        goto L86
    L53:
        r34 = null;
        goto L54
    L15:
        r6 = null;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    public final void d(Map<String, Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "params");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        LinkRevInternalServiceContext r1 = null;
        if (r0 == null) goto L5;
        i11.b r2 = r0.c8();
    L6:
        if (r2 == null) goto L20;
        List<com.bytedance.android.livesdk.link.model.p> r3 = r2.getOnlineUserList();
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L19;
        com.bytedance.android.livesdk.link.model.p r6 = (com.bytedance.android.livesdk.link.model.p) r5.next();
        StringBuilder r7 = new StringBuilder();
        IBaseUser r9 = r6.getUser();
        if (r9 == null) goto L13;
        String r10 = r9.getIdString();
    L14:
        r7.append(r10);
        r7.append('#');
        r7.append(r6.getInteractId());
        r7.append('#');
        IBaseUser r12 = r6.getUser();
        if (r12 == null) goto L17;
        Long r13 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r12));
    L18:
        r7.append(r13);
        r4.add(r7.toString());
        goto L9
    L17:
        r13 = null;
        goto L18
    L13:
        r10 = null;
        goto L14
    L19:
        r8.put("online", r4.toString());
    L20:
        com.bytedance.android.live.revlink.impl.utils.a r14 = i();
        if (r14 == null) goto L25;
        String r15 = r14.a();
        if (r15 == null) goto L25;
        r8.put("load_source", r15);
    L25:
        com.bytedance.android.live.revlink.impl.global.c r16 = this.d;
        if (r16 == null) goto L28;
        r1 = r16.Cj();
    L28:
        if (r1 != null) goto L30;
    L38:
        f(r8);
        return;
    L30:
        if (((Boolean) r1.isAppBackground().getValue()).booleanValue() == false) goto L32;
        r8.put("app_background", Boolean.TRUE);
    L37:
        i97.a r17 = i97.a.a;
        r8.put("room_stay_duration", Long.valueOf(System.currentTimeMillis() - r1.getEnterRoomTs()));
        r8.put("enter_room_info", String.valueOf(r1.getEnterRoomLinkInfo().getValue()));
        goto L38
    L32:
        com.bytedance.android.live.revlink.impl.service.internal.a r18 = (com.bytedance.android.live.revlink.impl.service.internal.a) r1.getService().getValue();
        if (r18 == null) goto L37;
        if (r18.dc() != true) goto L37;
        r8.put("live_background", Boolean.TRUE);
        goto L37
    L5:
        r2 = null;
        goto L6
    }

    public final void e(JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "json");
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.c;
        LinkRevInternalServiceContext r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r2 = r0.getRoomContext();
        if (r2 == null) goto L7;
        IRoomBase r3 = r2.getCommonRoom();
    L8:
        IRoomBase r4 = (IRoom) r3;
        if (r4 == null) goto L11;
        long r5 = IRoomKtKt.getId(r4);
    L12:
        y50.b.a.c(r8, "room_id", r5);
        if (r4 == null) goto L15;
        String r6 = IRoomKt_androidKt.getOwnerUserIdString(r4);
    L16:
        y50.b.a.d(r8, "anchor_id", r6);
        com.bytedance.android.live.revlink.impl.global.c r7 = this.d;
        if (r7 == null) goto L19;
        LinkCrossRoomDataHolder r9 = r7.getLinkCrossRoomDataHolder();
    L20:
        long r10 = 0;
        if (r9 == null) goto L23;
        long r12 = r9.c();
    L24:
        y50.b.a.c(r8, "channel_id", r12);
        com.bytedance.android.live.revlink.impl.global.c r13 = this.d;
        if (r13 == null) goto L27;
        w31.c r14 = r13.getPkLinkUtils();
    L28:
        if (r14 == null) goto L30;
        r10 = r14.i();
    L30:
        y50.b.a.c(r8, "pk_id", r10);
        com.bytedance.android.live.revlink.impl.utils.a r15 = i();
        if (r15 == null) goto L33;
        String r16 = r15.b();
    L34:
        y50.b.a.d(r8, "link_type", r16);
        com.bytedance.android.live.revlink.impl.utils.a r17 = i();
        if (r17 == null) goto L39;
        String r18 = r17.a();
        if (r18 == null) goto L39;
        y50.b.a.d(r8, "load_source", r18);
    L39:
        com.bytedance.android.live.revlink.impl.global.c r19 = this.d;
        if (r19 == null) goto L42;
        i11.b r20 = r19.c8();
    L43:
        if (r20 == null) goto L57;
        List<com.bytedance.android.livesdk.link.model.p> r22 = r20.getOnlineUserList();
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator<T> r24 = r22.iterator();
    L46:
        if (r24.hasNext() == false) goto L56;
        com.bytedance.android.livesdk.link.model.p r25 = (com.bytedance.android.livesdk.link.model.p) r24.next();
        StringBuilder r26 = new StringBuilder();
        IBaseUser r27 = r25.getUser();
        if (r27 == null) goto L50;
        String r28 = r27.getIdString();
    L51:
        r26.append(r28);
        r26.append('#');
        r26.append(r25.getInteractId());
        r26.append('#');
        IBaseUser r29 = r25.getUser();
        if (r29 == null) goto L54;
        Long r30 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r29));
    L55:
        r26.append(r30);
        r23.add(r26.toString());
        goto L46
    L54:
        r30 = null;
        goto L55
    L50:
        r28 = null;
        goto L51
    L56:
        y50.b.a.d(r8, "online", r23.toString());
    L57:
        com.bytedance.android.live.revlink.impl.global.c r32 = this.d;
        if (r32 == null) goto L60;
        r1 = r32.Cj();
    L60:
        if (r1 != null) goto L62;
        return;
    L62:
        if (((Boolean) r1.isAppBackground().getValue()).booleanValue() == false) goto L64;
        y50.b.a.e(r8, "app_background", true);
    L69:
        i97.a r33 = i97.a.a;
        y50.b.a.c(r8, "room_stay_duration", System.currentTimeMillis() - r1.getEnterRoomTs());
        y50.b.a.d(r8, "enter_room_info", String.valueOf(r1.getEnterRoomLinkInfo().getValue()));
        return;
    L64:
        com.bytedance.android.live.revlink.impl.service.internal.a r34 = (com.bytedance.android.live.revlink.impl.service.internal.a) r1.getService().getValue();
        if (r34 == null) goto L69;
        if (r34.dc() != true) goto L69;
        y50.b.a.e(r8, "live_background", true);
        goto L69
    L42:
        r20 = null;
        goto L43
    L33:
        r16 = null;
        goto L34
    L27:
        r14 = null;
        goto L28
    L23:
        r12 = 0;
        goto L24
    L19:
        r9 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    L11:
        r5 = -1;
    L7:
        r3 = null;
        goto L8
    }

    public final void f(Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        r5.putAll(j());
        com.bytedance.android.live.revlink.impl.utils.a r0 = i();
        if (r0 == null) goto L6;
        Object r1 = r0.b();
        if (r1 == null) goto L6;
    L7:
        r5.put("link_type", r1);
        com.bytedance.android.live.revlink.impl.global.c r2 = this.d;
        com.bytedance.android.live.revenuelink.connect.f r3 = null;
        if (r2 == null) goto L10;
        LinkCrossRoomDataHolder r4 = r2.getLinkCrossRoomDataHolder();
    L11:
        if (r4 == null) goto L13;
        long r6 = r4.c();
    L14:
        r5.put("channel_id", Long.valueOf(r6));
        com.bytedance.android.live.revlink.impl.global.c r7 = this.d;
        if (r7 == null) goto L17;
        r3 = r7.Z0();
    L17:
        if (r3 == null) goto L24;
        LiveData<ey.f> r8 = r3.connectState();
        if (r8 == null) goto L25;
        ey.f r9 = (ey.f) r8.getValue();
        if (r9 == null) goto L26;
        r5.put("biz_type", String.valueOf(r9.c));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L13:
        r6 = 0;
        goto L14
    L10:
        r4 = null;
    L6:
        r1 = 0;
        goto L7
    }

    public final void g(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        JSONObject r1 = new JSONObject(j());
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter("common", "key");
        r5.put("common", r1);     // Catch: Throwable -> L5
    L7:
        com.bytedance.android.live.revlink.impl.utils.a r0 = i();
        com.bytedance.android.live.revenuelink.connect.f r2 = null;
        if (r0 == null) goto L10;
        String r3 = r0.b();
    L11:
        y50.b.a.d(r5, "link_type", r3);
        if (k() == false) goto L14;
        String r4 = "anchor";
    L15:
        y50.b.a.d(r5, "role_type", r4);
        com.bytedance.android.live.revlink.impl.global.c r6 = this.d;
        if (r6 == null) goto L18;
        LinkCrossRoomDataHolder r7 = r6.getLinkCrossRoomDataHolder();
    L19:
        if (r7 == null) goto L21;
        long r8 = r7.c();
    L22:
        y50.b.a.c(r5, "channel_id", r8);
        com.bytedance.android.live.revlink.impl.global.c r9 = this.d;
        if (r9 == null) goto L25;
        r2 = r9.Z0();
    L25:
        if (r2 == null) goto L34;
        LiveData<ey.f> r10 = r2.connectState();
        if (r10 == null) goto L35;
        ey.f r12 = (ey.f) r10.getValue();
        if (r12 == null) goto L36;
        y50.b.a.d(r5, "biz_type", String.valueOf(r12.c));
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L21:
        r8 = 0;
        goto L22
    L18:
        r7 = null;
        goto L19
    L14:
        r4 = "audience";
        goto L15
    L10:
        r3 = null;
    L5:
        th = move-exception;
        jy0.b.b("BaseMonitor", "", th);
        goto L7
    }

    public final void h(Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        b0 r1 = null;
        if (r0 == null) goto L5;
        b0 r2 = r0.Tj();
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.a() == null) goto L36;
        com.bytedance.android.live.revlink.impl.global.c r3 = this.d;
        if (r3 == null) goto L13;
        b0 r5 = r3.Tj();
    L14:
        if (r5 == null) goto L16;
        PlayMode r6 = r5.d();
    L17:
        r4.put("pk_mode", String.valueOf(r6));
        com.bytedance.android.live.revlink.impl.global.c r7 = this.d;
        if (r7 == null) goto L20;
        b0 r8 = r7.Tj();
    L21:
        if (r8 == null) goto L26;
        PkBaseStateMachine.c r9 = r8.e();
        if (r9 == null) goto L26;
        String r10 = r9.c;
        if (r10 == null) goto L26;
    L27:
        r4.put("pk_state", r10);
        com.bytedance.android.live.revlink.impl.global.c r12 = this.d;
        if (r12 == null) goto L30;
        r1 = r12.Tj();
    L30:
        if (r1 == null) goto L32;
        long r13 = r1.c();
    L33:
        r4.put("pk_id", Long.valueOf(r13));
        return;
    L32:
        r13 = 0;
    L26:
        r10 = "";
        goto L27
    L20:
        r8 = null;
        goto L21
    L16:
        r6 = null;
        goto L17
    L13:
        r5 = null;
        goto L14
    L36:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static void l(Throwable r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "extra");
        if (r5 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof CustomApiServerException) == false) goto L8;
        CustomApiServerException r0 = (CustomApiServerException) r5;
        r6.put("url", r0.getUrl());
        r6.put("xTtLogId", r0.getXTtLogId());
    L8:
        if ((r5 instanceof ApiServerException) == false) goto L18;
        ApiServerException r1 = (ApiServerException) r5;
        String r3 = r1.getErrorMsg();
        if (r3 == null) goto L18;
        if (r3.length() <= 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 != true) goto L18;
        r6.put("error_code", r1.getErrorCode());
        r6.put("error_msg", r1.getErrorMsg());
        return;
    L14:
        r4 = false;
    L18:
        if ((r5 instanceof yy.a) == false) goto L23;
        r6.put("error_code", ((yy.a) r5).getErrorCode());
        String r7 = r5.getMessage();
        if (r7 == null) goto L31;
        r6.put("error_msg", r7);
        return;
    L31:
        return;
    L23:
        if ((r5 instanceof Exception) == false) goto L27;
        r6.put("error_code", -1);
        String r8 = r5.getMessage();
        if (r8 == null) goto L33;
        r6.put("error_msg", r8);
        return;
    L33:
        return;
    L27:
        r6.put("error_code", -1);
        r6.put("error_msg", r5.toString());
    }

    public e(ld.a r1, com.bytedance.android.livesdk.revenue.service.room.c r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
