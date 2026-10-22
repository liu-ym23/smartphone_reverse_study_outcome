package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.a2;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.c2;
import com.bytedance.android.livesdk.link.model.bridge.t1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.bridge.z1;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public AnchorRtcConnectModel a;
    public b2 b;
    public b7 c;
    public v1 d;
    public d7 e;
    public final com.bytedance.android.livesdk.revenue.service.room.c f;
    public final com.bytedance.android.live.revlink.impl.global.c g;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("{");
        StringBuilder r1 = new StringBuilder();
        AnchorRtcConnectModel r2 = this.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rtcConnectModel");
    L5:
        r1.append((o) r2.getRtcForwardData().getValue());
        r1.append(", ");
        r0.append(r1.toString());
        StringBuilder r3 = new StringBuilder();
        b7 r4 = this.c;
        String r5 = null;
        if (r4 == null) goto L8;
        String r6 = c7.a(r4);
    L9:
        r3.append(r6);
        r3.append(", ");
        r0.append(r3.toString());
        b2 r7 = this.b;
        if (r7 == null) goto L12;
        r5 = c2.a(r7);
    L12:
        r0.append(String.valueOf(r5));
        r0.append("}");
        return r0.toString();
    L8:
        r6 = null;
        goto L9
    }

    public final void b(b2 r3) {
        AnchorRtcConnectModel r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rtcConnectModel");
    L5:
        com.bytedance.live.datacontext.n<Map<Long, z1>> r1 = r0.getPreRtcInfoMap();
        if (r3 == null) goto L10;
        Map r2 = r3.getPreRtcUserInfo();
        if (r2 == null) goto L10;
        Map r4 = MapsKt.toMap(r2);
    L11:
        r1.setValue(r4);
        this.b = r3;
        return;
    L10:
        r4 = null;
        goto L11
    }

    public c(com.bytedance.android.livesdk.revenue.service.room.c r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.f = r1;
        this.g = r2;
    }

    public static final void a(c r18, b7 r19, b2 r20, String r22, Map r23) {
        r18.getClass();
        LinkedHashMap r2 = new LinkedHashMap();
        Map r3 = r20.getPreRtcUserInfo();
        boolean r6 = true;
        if (r3 == null) goto L15;
        com.bytedance.android.livesdk.revenue.service.room.c r7 = r18.f;
        if (r7 == null) goto L9;
        com.bytedance.android.livesdk.revenue.room.a r8 = r7.getRoomContext();
        if (r8 == null) goto L9;
        IRoomBase r9 = r8.getCommonRoom();
    L10:
        IRoomBase r10 = (IRoom) r9;
        Intrinsics.checkNotNull(r10);
        z1 r4 = (z1) r3.get(Long.valueOf(IRoomKtKt.getId(r10)));
        if (r4 == null) goto L15;
        if (AnchorRtcConnectUtilsKt.d(r4) != true) goto L15;
        boolean r5 = true;
    L16:
        boolean r12 = r20.getRtcJoinChannel();
        Map r13 = r20.getPreRtcUserInfo();
        Map r14 = r19.getChannelMap();
        if (r14 == null) goto L56;
        Map r15 = MapsKt.toMap(r14);
        if (r15 == null) goto L56;
        Iterator r16 = r15.entrySet().iterator();
    L22:
        if (r16.hasNext() == false) goto L56;
        Map.Entry r17 = (Map.Entry) r16.next();
        long r110 = ((Number) r17.getKey()).longValue();
        if (r13 == null) goto L28;
        Map r24 = MapsKt.toMap(r13);
        if (r24 == null) goto L28;
        z1 r25 = (z1) r24.get(Long.valueOf(r110));
    L29:
        if (r25 != null) goto L31;
        Map r111 = r13;
        com.bytedance.android.live.revlink.impl.global.c r26 = r18.g;
        if (r26 == null) goto L49;
        g0 r27 = r26.Rn();
    L50:
        if (r27 == null) goto L54;
        Intrinsics.checkNotNullParameter(r19, "multiChannelInfo");
        Intrinsics.checkNotNullParameter(r22, "source");
        boolean r112 = r5;
        jy0.b.c("ttlive_anchor_connect", r110 + " in multiChannelInfo but not in PreRtcInfo", null, 4);
        JSONObject r28 = new JSONObject();
        int r29 = y50.b.a;
        y50.b.a.c(r28, "target_room_id", r110);
        y50.b.a.d(r28, "source", r22);
        y50.b.a.d(r28, "pre_rtc_info", c2.a(r20));
        y50.b.a.d(r28, "multi_channel_info", t1.a(r19));
        v r30 = r27.o();
        if (r30 == null) goto L55;
        r30.I("channel_not_in_preRtcInfo", r28, true);
    L55:
        r13 = r111;
        r5 = r112;
        r6 = true;
    L54:
        r112 = r5;
        goto L55
    L49:
        r27 = null;
        goto L50
    L31:
        if (r25.getRtcPushStream() == false) goto L36;
        if (r12 == false) goto L36;
        r111 = r13;
        if ((Intrinsics.areEqual((Boolean) r23.get(r25.getLinkmicIdStr()), Boolean.TRUE) ^ r6) == false) goto L37;
        boolean r32 = true;
    L38:
        if (r32 == false) goto L41;
        r2.put(Long.valueOf(r110), r17.getValue());
        goto L54
    L41:
        if (AnchorRtcConnectUtilsKt.d(r25) == false) goto L44;
        if (r5 == false) goto L44;
        r2.put(Long.valueOf(r110), r17.getValue());
    L44:
        if (r12 == false) goto L54;
        jy0.b.c("ttlive_anchor_connect_forward", "not push stream to " + r110 + ' ' + a2.a(r25), null, 4);
    L37:
        r32 = false;
    L36:
        r111 = r13;
    L28:
        r25 = null;
    L56:
        AnchorRtcConnectModel r33 = r18.a;
        if (r33 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("rtcConnectModel");
    L59:
        o r34 = (o) r33.getRtcForwardData().getValue();
        if (r34 == null) goto L62;
        Map<Long, String> r35 = r34.a;
    L63:
        com.bytedance.android.live.revlink.impl.global.c r36 = r18.g;
        if (r36 == null) goto L66;
        g0 r37 = r36.Rn();
    L67:
        if (r37 == null) goto L108;
        b2 r38 = r18.b;
        Intrinsics.checkNotNullParameter(r2, "forwardRoomMap");
        Intrinsics.checkNotNullParameter(r22, "source");
        com.bytedance.android.live.revlink.impl.global.c r39 = r37.d;
        if (r39 == null) goto L71;
        w r40 = r39.getMultiLinkUtil();
    L72:
        if (r40 != null) goto L74;
    L75:
        if (r38 != null) goto L77;
    L79:
        if (r38 == null) goto L95;
        Map r42 = r38.getPreRtcUserInfo();
        if (r42 == null) goto L95;
        Collection r43 = r42.values();
        if (r43 == null) goto L95;
        ArrayList r44 = new ArrayList();
        Iterator r45 = r43.iterator();
    L86:
        if (r45.hasNext() == false) goto L96;
        Object r46 = r45.next();
        z1 r47 = (z1) r46;
        if (r47.getRtcPushStream() == true) goto L90;
    L92:
        boolean r48 = false;
    L93:
        if (r48 == false) goto L86;
        r44.add(r46);
        goto L86
    L90:
        if (AnchorRtcConnectUtilsKt.d(r47) == false) goto L92;
        r48 = true;
    L96:
        if (r44 == null) goto L101;
        if ((!r44.isEmpty()) == false) goto L108;
    L101:
        if (Intrinsics.areEqual(r22, "leaveMsg") == true) goto L108;
        if (r2.isEmpty() == false) goto L108;
        JSONObject r49 = new JSONObject();
        int r50 = y50.b.a;
        y50.b.a.d(r49, "forward_room_map", r2.keySet().toString());
        y50.b.a.d(r49, "source", r22);
        v r52 = r37.o();
        if (r52 == null) goto L108;
        r52.I("forward_room_map_empty", r49, true);
    L95:
        r44 = null;
        goto L96
    L77:
        if (r38.getRtcJoinChannel() == true) goto L79;
    L74:
        if (r40.c() == true) goto L79;
    L71:
        r40 = null;
    L108:
        StringBuilder r53 = new StringBuilder("forwardRooms ");
        if (r35 == null) goto L111;
        Set<Long> r54 = r35.keySet();
    L112:
        r53.append(r54);
        r53.append(" -> ");
        r53.append(r2.keySet());
        r53.append(" source=");
        r53.append(r22);
        jy0.b.c("ttlive_anchor_connect_forward", r53.toString(), null, 4);
        AnchorRtcConnectModel r0 = r18.a;
        if (r0 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("rtcConnectModel");
    L115:
        r0.getRtcForwardData().setValue(new o(r2, r22));
        return;
    L111:
        r54 = null;
        goto L112
    L66:
        r37 = null;
        goto L67
    L62:
        r35 = null;
    L9:
        r9 = null;
    L15:
        r5 = false;
        goto L16
    }
}
