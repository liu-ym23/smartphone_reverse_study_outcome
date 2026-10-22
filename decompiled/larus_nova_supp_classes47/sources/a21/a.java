package a21;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.e;
import cy0.j;
import d31.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final c a;

    public final LinkCrossRoomDataHolder a() {
        c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkCrossRoomDataHolder();
    }

    public a(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public final void b(String r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        LinkCrossRoomDataHolder r1 = a();
        String r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.c());
    L6:
        r0.put("channel_id", String.valueOf(r3));
        c r4 = this.a;
        if (r4 == null) goto L9;
        s r5 = r4.getRevLinkCommonUtil();
    L10:
        if (r5 == null) goto L12;
        r2 = r5.e();
    L12:
        r0.put("user_id", String.valueOf(r2));
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        r0.put("end_reason", r6);
        n r7 = new n();
        Map<String, String> r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r8.putAll(r0);
        m r9 = new m();
        LinkCrossRoomDataHolder r10 = a();
        if (r10 == null) goto L18;
        r10.m(r9);
    L18:
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r7.b).addAll(r9.a);
        e.a.getClass();
        j r12 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r13);
        ((i) ((f80.a) r13)).w3("livesdk_connection_ai_assistant_over", r7.a, r7.b);
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void c(long r6, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "pkSource");
        Intrinsics.checkNotNullParameter(r9, "inviteMode");
        LinkedHashMap r0 = new LinkedHashMap();
        LinkCrossRoomDataHolder r1 = a();
        d r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.c());
    L6:
        r0.put("channel_id", String.valueOf(r3));
        r0.put("live_source", r8);
        c r10 = this.a;
        if (r10 == null) goto L9;
        d r12 = r10.getRevLinkLogHelper();
    L11:
        if (r12 == null) goto L14;
        String r13 = r12.a();
        if (r13 == null) goto L14;
    L15:
        r0.put("anchor_connect_status", r13);
        c r14 = this.a;
        if (r14 == null) goto L18;
        s r15 = r14.getRevLinkCommonUtil();
    L19:
        if (r15 == null) goto L21;
        String r16 = r15.e();
    L22:
        r0.put("user_id", String.valueOf(r16));
        r0.put("invite_mode", r9);
        c r17 = this.a;
        if (r17 == null) goto L25;
        r2 = r17.getRevLinkLogHelper();
    L25:
        if (r2 == null) goto L27;
        String r18 = r2.h();
    L28:
        r0.put("layout_type", r18);
        r0.put("pk_id", String.valueOf(r6));
        c r7 = this.a;
        if (r7 == null) goto L47;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r19 = r7.U7();
        if (r19 == null) goto L47;
        if (r19.getCurrentGameStatus() != IProfitGameStatusMessage.GameStatus.BizStart.ordinal()) goto L47;
        c r20 = this.a;
        if (r20 == null) goto L47;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r22 = r20.U7();
        if (r22 == null) goto L47;
        Map<String, String> r23 = r22.getCurrentTrackInfo();
        if (r23 == null) goto L47;
        Iterator<T> r24 = r23.keySet().iterator();
    L42:
        if (r24.hasNext() == false) goto L47;
        String r25 = (String) r24.next();
        String r26 = r23.get(r25);
        if (r26 != null) goto L46;
        r26 = "";
    L46:
        r0.put(r25, r26);
    L47:
        n r27 = new n();
        Map<String, String> r28 = r27.a;
        Intrinsics.checkNotNullParameter(r28, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r28.putAll(r0);
        m r29 = new m();
        LinkCrossRoomDataHolder r30 = a();
        if (r30 == null) goto L50;
        r30.m(r29);
    L50:
        r29.b(LogCommon.ROOM);
        r29.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r27.b).addAll(r29.a);
        e.a.getClass();
        j r32 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r33 = com.bytedance.android.scope.m.b(r32).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r33);
        ((i) ((f80.a) r33)).w3("livesdk_pk_live_play", r27.a, r27.b);
        return;
    L27:
        r18 = "";
        goto L28
    L21:
        r16 = null;
        goto L22
    L18:
        r15 = null;
    L14:
        r13 = "";
        goto L15
    L9:
        r12 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public final void d(String r6, long r7, long r9, String r12, int r13) {
        Intrinsics.checkNotNullParameter(r6, "inviteMode");
        Intrinsics.checkNotNullParameter(r12, "liveSource");
        c r0 = this.a;
        Long r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = r0.Ig();
    L6:
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("watch_pk_duration", String.valueOf(r7 / ((long) WebcastRedirectException.UNKNOWN)));
        c r8 = this.a;
        if (r8 == null) goto L9;
        w31.c r10 = r8.getPkLinkUtils();
    L10:
        if (r10 == null) goto L12;
        Integer r14 = Integer.valueOf(r10.a());
    L13:
        r3.put("pk_time", String.valueOf(r14));
        if (r2 != null) goto L16;
    L20:
        r3.put("channel_id", String.valueOf(r9));
        if (r13 != 1) goto L23;
        String r15 = "2";
    L31:
        r3.put("anchor_connect_status", r15);
        r3.put("invite_mode", r6);
        c r16 = this.a;
        if (r16 == null) goto L34;
        d r17 = r16.getRevLinkLogHelper();
    L35:
        String r18 = "";
        if (r17 == null) goto L38;
        String r19 = r17.b();
    L39:
        r3.put("connection_sub_type", r19);
        r3.put("live_source", r12);
        c r20 = this.a;
        if (r20 == null) goto L42;
        s r22 = r20.getRevLinkCommonUtil();
    L43:
        if (r22 == null) goto L45;
        String r23 = r22.e();
    L46:
        r3.put("user_id", String.valueOf(r23));
        c r24 = this.a;
        if (r24 == null) goto L49;
        w31.c r25 = r24.getPkLinkUtils();
    L50:
        if (r25 == null) goto L52;
        r1 = Long.valueOf(r25.i());
    L52:
        r3.put("pk_id", String.valueOf(r1));
        c r26 = this.a;
        if (r26 == null) goto L73;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r27 = r26.U7();
        if (r27 == null) goto L73;
        Map<String, String> r28 = r27.getCurrentTrackInfo();
        if (r28 == null) goto L73;
        if ((true ^ r28.isEmpty()) == false) goto L73;
        Iterator<T> r29 = r28.keySet().iterator();
    L62:
        if (r29.hasNext() == false) goto L64;
        String r30 = (String) r29.next();
        r3.put(r30, String.valueOf(r28.get(r30)));
        goto L62
    L64:
        c r32 = this.a;
        if (r32 == null) goto L72;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r33 = r32.U7();
        if (r33 == null) goto L72;
        String r34 = String.valueOf(r33.getWatchDuration());
        if (r34 == null) goto L72;
        r18 = r34;
    L72:
        r3.put("link_game_name_duration", r18);
    L73:
        n r35 = new n();
        Map<String, String> r36 = r35.a;
        Intrinsics.checkNotNullParameter(r36, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r36.putAll(r3);
        m r37 = new m();
        LinkCrossRoomDataHolder r38 = a();
        if (r38 == null) goto L76;
        r38.m(r37);
    L76:
        r37.b(LogCommon.ROOM);
        r37.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r35.b).addAll(r37.a);
        e.a.getClass();
        j r39 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r40 = com.bytedance.android.scope.m.b(r39).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r40);
        ((i) ((f80.a) r40)).w3("livesdk_pk_watch_duration", r35.a, r35.b);
        return;
    L49:
        r25 = null;
        goto L50
    L45:
        r23 = null;
        goto L46
    L42:
        r22 = null;
        goto L43
    L38:
        r19 = "";
        goto L39
    L34:
        r17 = null;
        goto L35
    L23:
        c r42 = this.a;
        if (r42 == null) goto L26;
        w31.a r43 = r42.getConnectionDataLogUtils();
    L27:
        if (r43 == null) goto L29;
        Integer r44 = Integer.valueOf(r43.d);
    L30:
        r15 = String.valueOf(r44);
        goto L31
    L29:
        r44 = null;
        goto L30
    L26:
        r43 = null;
        goto L27
    L16:
        if (r2.isOnceMoreBattle() == false) goto L18;
        String r45 = DataType.TRUE;
    L19:
        r3.put("is_oncemore", r45);
        goto L20
    L18:
        r45 = DataType.FALSE;
        goto L19
    L12:
        r14 = null;
        goto L13
    L9:
        r10 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
