package p21;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.multianchor.vm.g;
import com.bytedance.android.live.revlink.impl.utils.s;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final com.bytedance.android.livesdk.revenue.service.room.c a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public final Map<String, String> a() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.b;
        d31.d r2 = null;
        if (r1 == null) goto L5;
        g r3 = r1.getMultiAnchorLinkContextObj();
    L6:
        if (r3 == null) goto L8;
        Long r4 = Long.valueOf(r3.a());
    L9:
        int r5 = 0;
        long r6 = 0;
        if (r4 != null) goto L12;
    L13:
        com.bytedance.android.live.revlink.impl.global.c r7 = this.b;
        if (r7 == null) goto L16;
        g r8 = r7.getMultiAnchorLinkContextObj();
    L17:
        if (r8 == null) goto L25;
        com.bytedance.android.live.revlink.impl.global.c r9 = r8.a;
        if (r9 == null) goto L21;
        LinkCrossRoomDataHolder r10 = r9.getLinkCrossRoomDataHolder();
    L22:
        if (r10 == null) goto L24;
        r6 = r10.c();
    L24:
        Long r12 = Long.valueOf(r6);
    L26:
        com.bytedance.android.live.revlink.impl.global.c r13 = this.b;
        if (r13 == null) goto L29;
        z r14 = r13.getMultiPkMonitor();
    L30:
        if (r14 == null) goto L32;
        z.y(r14, "link_log_param_channel_id_error", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("originChannelId", String.valueOf(r4)), TuplesKt.to("channelId", String.valueOf(r12))}), null, 12);
    L32:
        r4 = r12;
    L33:
        r0.put("channel_id", String.valueOf(r4));
        com.bytedance.android.live.revlink.impl.global.c r15 = this.b;
        if (r15 == null) goto L36;
        s r16 = r15.getRevLinkCommonUtil();
    L37:
        if (r16 == null) goto L39;
        String r17 = r16.e();
    L40:
        r0.put("user_id", String.valueOf(r17));
        com.bytedance.android.livesdk.revenue.service.room.c r18 = this.a;
        if (r18 == null) goto L47;
        com.bytedance.android.livesdk.revenue.room.a r19 = r18.getRoomContext();
        if (r19 == null) goto L47;
        if (r19.getCommonIsAnchor() != true) goto L47;
        String r20 = DataType.TRUE;
    L48:
        r0.put("is_anchor", r20);
        com.bytedance.android.live.revlink.impl.global.c r22 = this.b;
        if (r22 == null) goto L51;
        LinkCrossRoomDataHolder r23 = r22.getLinkCrossRoomDataHolder();
    L52:
        if (r23 == null) goto L54;
        String r24 = r23.g();
    L55:
        String r25 = "";
        if (r24 != null) goto L58;
        r24 = "";
    L58:
        r0.put("invitee_id", r24);
        com.bytedance.android.live.revlink.impl.global.c r26 = this.b;
        if (r26 == null) goto L61;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r27 = r26.R8();
    L62:
        if (r27 == null) goto L66;
        i11.b r28 = r27.getLinkUserCenter();
        if (r28 == null) goto L66;
        Integer r29 = Integer.valueOf(r28.c());
    L67:
        r0.put("anchor_connect_status", String.valueOf(r29));
        com.bytedance.android.live.revlink.impl.global.c r30 = this.b;
        if (r30 == null) goto L70;
        q r32 = r30.getMultiAnchorLinkLogUtils();
    L71:
        if (r32 == null) goto L74;
        String r33 = r32.c();
        if (r33 == null) goto L74;
    L75:
        r0.put("connection_type", r33);
        com.bytedance.android.live.revlink.impl.global.c r34 = this.b;
        if (r34 == null) goto L78;
        d31.d r35 = r34.getRevLinkLogHelper();
    L79:
        if (r35 == null) goto L88;
        com.bytedance.android.live.revlink.impl.global.c r36 = this.b;
        if (r36 == null) goto L83;
        g r37 = r36.getMultiAnchorLinkContextObj();
    L84:
        if (r37 == null) goto L86;
        r5 = r37.b();
    L86:
        String r38 = r35.p(r5);
        if (r38 == null) goto L88;
    L89:
        r0.put("invitee_list", r38);
        com.bytedance.android.live.revlink.impl.global.c r39 = this.b;
        if (r39 == null) goto L92;
        d31.d r40 = r39.getRevLinkLogHelper();
    L93:
        if (r40 == null) goto L95;
        r25 = r40.s();
    L95:
        r0.put("room_status", r25);
        com.bytedance.android.live.revlink.impl.global.c r42 = this.b;
        if (r42 == null) goto L98;
        r2 = r42.getRevLinkLogHelper();
    L98:
        if (r2 == null) goto L100;
        r2.r(r0);
    L100:
        return r0;
    L92:
        r40 = null;
        goto L93
    L83:
        r37 = null;
    L88:
        r38 = "";
        goto L89
    L78:
        r35 = null;
    L74:
        r33 = "";
        goto L75
    L70:
        r32 = null;
    L66:
        r29 = null;
        goto L67
    L61:
        r27 = null;
        goto L62
    L54:
        r24 = null;
        goto L55
    L51:
        r23 = null;
    L47:
        r20 = DataType.FALSE;
        goto L48
    L39:
        r17 = null;
        goto L40
    L36:
        r16 = null;
        goto L37
    L29:
        r14 = null;
        goto L30
    L21:
        r10 = null;
        goto L22
    L25:
        r12 = null;
        goto L26
    L16:
        r8 = null;
        goto L17
    L12:
        if (r4.longValue() != 0) goto L33;
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public c(com.bytedance.android.livesdk.revenue.service.room.c r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
