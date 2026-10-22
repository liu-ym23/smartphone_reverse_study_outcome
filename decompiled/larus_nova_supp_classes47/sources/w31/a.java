package w31;

import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.j;
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
    public boolean a;
    public long b;
    public long c;
    public int d;
    public long e;
    public final com.bytedance.android.live.revlink.impl.global.c f;

    public a(LinkFakeGlobalService r1) {
        this.f = r1;
        this.d = 2;
    }

    public final void a(String r6, Long r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        LinkCrossRoomDataHolder r1 = null;
        if (r7 == null) goto L6;
        String r8 = String.valueOf(r7.longValue());
        if (r8 == null) goto L6;
    L14:
        r0.put("channel_id", r8);
        com.bytedance.android.live.revlink.impl.global.c r9 = this.f;
        if (r9 == null) goto L17;
        d31.d r10 = r9.getRevLinkLogHelper();
    L19:
        if (r10 == null) goto L22;
        String r12 = r10.a();
        if (r12 == null) goto L22;
    L23:
        r0.put("anchor_connect_status", r12);
        if (r6 != null) goto L26;
        r6 = "";
    L26:
        r0.put("live_source", r6);
        r0.put("linkmic_scene", String.valueOf(7));
        com.bytedance.android.live.revlink.impl.global.c r13 = this.f;
        if (r13 == null) goto L29;
        s r14 = r13.getRevLinkCommonUtil();
    L30:
        if (r14 == null) goto L32;
        String r15 = r14.e();
    L33:
        r0.put("user_id", String.valueOf(r15));
        com.bytedance.android.live.revlink.impl.global.c r16 = this.f;
        if (r16 == null) goto L36;
        d31.d r17 = r16.getRevLinkLogHelper();
    L37:
        if (r17 == null) goto L39;
        String r18 = r17.h();
    L40:
        r0.put("layout_type", r18);
        com.bytedance.android.live.revlink.impl.global.c r19 = this.f;
        if (r19 == null) goto L59;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r20 = r19.U7();
        if (r20 == null) goto L59;
        if (r20.getCurrentGameStatus() != IProfitGameStatusMessage.GameStatus.BizStart.ordinal()) goto L59;
        com.bytedance.android.live.revlink.impl.global.c r22 = this.f;
        if (r22 == null) goto L59;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r23 = r22.U7();
        if (r23 == null) goto L59;
        Map<String, String> r24 = r23.getCurrentTrackInfo();
        if (r24 == null) goto L59;
        Iterator<T> r25 = r24.keySet().iterator();
    L54:
        if (r25.hasNext() == false) goto L59;
        String r3 = (String) r25.next();
        String r4 = r24.get(r3);
        if (r4 != null) goto L58;
        r4 = "";
    L58:
        r0.put(r3, r4);
    L59:
        n r26 = new n();
        Map<String, String> r27 = r26.a;
        Intrinsics.checkNotNullParameter(r27, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r27.putAll(r0);
        m r28 = new m();
        com.bytedance.android.live.revlink.impl.global.c r2 = this.f;
        if (r2 == null) goto L62;
        r1 = r2.getLinkCrossRoomDataHolder();
    L62:
        if (r1 == null) goto L64;
        r1.m(r28);
    L64:
        r28.b(LogCommon.ROOM);
        r28.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r26.b).addAll(r28.a);
        cy0.e.a.getClass();
        j r29 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r30 = com.bytedance.android.scope.m.b(r29).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r30);
        ((i) ((f80.a) r30)).w3("livesdk_connection_live_play", r26.a, r26.b);
        return;
    L39:
        r18 = "";
        goto L40
    L36:
        r17 = null;
        goto L37
    L32:
        r15 = null;
        goto L33
    L29:
        r14 = null;
    L22:
        r12 = "";
        goto L23
    L17:
        r10 = null;
    L6:
        com.bytedance.android.live.revlink.impl.global.c r32 = this.f;
        if (r32 == null) goto L9;
        LinkCrossRoomDataHolder r33 = r32.getLinkCrossRoomDataHolder();
    L10:
        if (r33 == null) goto L12;
        Long r34 = Long.valueOf(r33.c());
    L13:
        r8 = String.valueOf(r34);
        goto L14
    L12:
        r34 = null;
        goto L13
    L9:
        r33 = null;
        goto L10
    }
}
