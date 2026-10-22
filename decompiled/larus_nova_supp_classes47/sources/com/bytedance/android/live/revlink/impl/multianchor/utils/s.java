package com.bytedance.android.live.revlink.impl.multianchor.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s {
    public final List<g> a;
    public int b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public final int c() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 == null) goto L5;
        MultiLinkAnchorControlContext r1 = r0.ua();
    L6:
        if (r1 != null) goto L10;
        return 0;
    L10:
        return r1.getMultiLinkTimes();
    L5:
        r1 = null;
        goto L6
    }

    public final long d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.utils.s r1 = r0.getRevLinkCommonUtil();
    L6:
        if (r1 == null) goto L10;
        IRoomBase r2 = r1.a();
        if (r2 == null) goto L10;
        return IRoomKtKt.getId(r2);
    L10:
        return 0;
    L5:
        r1 = null;
        goto L6
    }

    public final com.bytedance.android.live.revenuelink.rtc.i e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenuelink.rtc.f r1 = r0.m0();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getRtcManager();
    L5:
        r1 = null;
        goto L6
    }

    public s(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.c = r1;
        this.a = new ArrayList();
    }

    public final g b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "bindID");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        g r1 = (g) r0.next();
        if (Intrinsics.areEqual(r1.j, r4) == false) goto L4;
        if (r4.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L4;
        return r1;
    L10:
        r2 = false;
        goto L11
    L13:
        return null;
    }

    public final g f(String r18) {
        g r3 = null;
        if (((ArrayList) this.a).isEmpty() == false) goto L5;
        return null;
    L5:
        i97.a r2 = i97.a.a;
        long r4 = System.currentTimeMillis();
        Iterator r5 = ((ArrayList) this.a).iterator();
    L6:
        int r7 = 0;
        if (r5.hasNext() == false) goto L30;
        g r6 = (g) r5.next();
        long r9 = r4 - r6.f;
        u41.d r12 = u41.d.n;
        r12.getClass();
        if (r9 > ((Number) u41.d.d.getValue(r12, u41.d.a[2])).intValue()) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == true) goto L6;
        r5.remove();
        com.bytedance.android.live.revlink.impl.global.c r13 = this.c;
        if (r13 == null) goto L16;
        v r14 = r13.getMultiLinkMonitor();
    L17:
        if (r14 == null) goto L29;
        Intrinsics.checkNotNullParameter(r6, "connect");
        JSONObject r15 = new JSONObject();
        r15.put("connect_build_role", r6.e.b);
        r15.put("connection_id", r6.g);
        r15.put("from_status", !r6.h ? 1 : 0);
        r15.put("opposite_status", !r6.i ? 1 : 0);
        StringBuilder r16 = new StringBuilder("[");
        Iterator<T> r17 = r6.b.iterator();
    L20:
        if (r17.hasNext() == false) goto L28;
        Object r19 = r17.next();
        int r110 = r7 + 1;
        if (r7 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        r16.append((String) r19);
        if (r7 == (r6.b.size() - 1)) goto L27;
        r16.append(", ");
    L27:
        r7 = r110;
        goto L20
    L28:
        r16.append("]");
        r15.put("frame_info", r16.toString());
        v.x(r14, "multi_anchor_invalid_connect", r15, r6.e.b, null, null, 56);
    L29:
        this.b++;
        goto L6
    L16:
        r14 = null;
        goto L17
    L11:
        r10 = false;
        goto L12
    L30:
        com.bytedance.android.live.revlink.impl.global.c r8 = this.c;
        if (r8 == null) goto L33;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r20 = r8.getMultiAnchorLinkContextObj();
    L34:
        if (r20 == null) goto L37;
        String r22 = r20.c();
        if (r22 == null) goto L37;
    L44:
        Iterator r23 = ((ArrayList) this.a).iterator();
    L46:
        if (r23.hasNext() == false) goto L48;
        g r24 = (g) r23.next();
        r24.getClass();
        Intrinsics.checkNotNullParameter(r22, "self");
        r24.b.remove(r22);
        goto L46
    L48:
        Iterator r25 = CollectionsKt.reversed(this.a).iterator();
    L50:
        if (r25.hasNext() == false) goto L60;
        g r26 = (g) r25.next();
        r26.getClass();
        Intrinsics.checkNotNullParameter(r18, "newFrame");
        Iterator<String> r27 = r26.b.iterator();
    L53:
        if (r27.hasNext() == false) goto L57;
        String r28 = r27.next();
        if (Intrinsics.areEqual(r28, r18) == false) goto L53;
        r26.b.remove(r28);
        r26.a++;
        boolean r29 = true;
    L58:
        if (r29 == false) goto L50;
        r3 = r26;
        goto L60
    L57:
        r29 = false;
    L60:
        if (r3 != null) goto L62;
    L64:
        return r3;
    L62:
        if ((!r3.b.isEmpty()) == true) goto L64;
        ((ArrayList) this.a).remove(r3);
    L37:
        com.bytedance.android.live.revlink.impl.global.c r30 = this.c;
        if (r30 == null) goto L40;
        LinkCrossRoomDataHolder r32 = r30.getLinkCrossRoomDataHolder();
    L41:
        if (r32 == null) goto L43;
        r22 = r32.e();
        goto L44
    L43:
        r22 = "";
        goto L44
    L40:
        r32 = null;
        goto L41
    L33:
        r20 = null;
        goto L34
    }

    public static final void a(s r10, g r12, List r13) {
        r10.getClass();
        List r14 = r13;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r0.add(((com.bytedance.android.live.revenuelink.rtc.o) r15.next()).b);
        goto L4
    L6:
        Iterator r16 = r0.iterator();
    L8:
        if (r16.hasNext() == false) goto L56;
        String r1 = (String) r16.next();
        if (r12.b.contains(r1) == false) goto L8;
        r10.f(r1);
        JSONObject r8 = new JSONObject();
        int r2 = y50.b.a;
        y50.b.a.b(r8, "is_first_frame_optimize", AnchorRtcConnectUtilsKt.a(r10.c) ? 1 : 0);
        y50.b.a.d(r8, "frame_uid", r1);
        y50.b.a.b(r8, "is_pk_to_multi", r12.k ? 1 : 0);
        y50.b.a.d(r8, "connection_id", r12.g);
        y50.b.a.b(r8, "connect_build_role", r12.e.b);
        y50.b.a.b(r8, "first_frame_index", r12.a);
        i97.a r3 = i97.a.a;
        y50.b.a.c(r8, "first_frame_duration", System.currentTimeMillis() - r12.f);
        boolean r4 = true;
        y50.b.a.b(r8, "connect_build_success", (!r12.b.isEmpty() ? 1 : 0) ^ 1);
        y50.b.a.b(r8, "from_status", !r12.h ? 1 : 0);
        y50.b.a.b(r8, "opposite_status", !r12.i ? 1 : 0);
        y50.b.a.b(r8, "wait_frame_total_count", r12.c);
        y50.b.a.b(r8, "is_not_match_connect", 0);
        com.bytedance.android.live.revenuelink.rtc.i r5 = r10.e();
        String r6 = "";
        if (r5 == null) goto L15;
        String r7 = r5.O();
        if (r7 == null) goto L15;
    L16:
        y50.b.a.d(r8, "channel_id", r7);
        y50.b.a.d(r8, "event_session_id", r7);
        com.bytedance.android.live.revenuelink.rtc.i r9 = r10.e();
        if (r9 == null) goto L22;
        String r17 = r9.c0();
        if (r17 == null) goto L22;
        r6 = r17;
    L22:
        y50.b.a.d(r8, "linker_session_id", r6);
        com.bytedance.android.live.revlink.impl.global.c r18 = r10.c;
        if (r18 == null) goto L25;
        com.bytedance.android.live.revlink.impl.utils.s r19 = r18.getRevLinkCommonUtil();
    L26:
        if (r19 == null) goto L40;
        IRoom r20 = r19.a();
        if (r20 == null) goto L40;
        Intrinsics.checkNotNullParameter(r20, "$this$isValid");
        if (IRoomKtKt.getId((IRoomBase) r20) > 0) goto L32;
    L34:
        r4 = false;
    L35:
        if (r4 == true) goto L38;
        r20 = null;
    L38:
        if (r20 == null) goto L40;
        y50.b.a.d(r8, "room_id", r20.getIdStr());
        y50.b.a.d(r8, "anchor_id", String.valueOf(iz.a.a(r20.getOwnerKt())));
        goto L40
    L32:
        if (r20.getOwnerKt() == null) goto L34;
    L40:
        com.bytedance.android.live.revlink.impl.global.c r22 = r10.c;
        if (r22 == null) goto L43;
        com.bytedance.android.live.revenuelink.connect.f r23 = r22.Z0();
    L44:
        if (r23 == null) goto L50;
        LiveData<ey.f> r24 = r23.connectState();
        if (r24 == null) goto L50;
        ey.f r25 = (ey.f) r24.getValue();
        if (r25 == null) goto L50;
        y50.b.a.d(r8, "connect_state", r25.toString());
    L50:
        jy0.b.d("ttlive_anchor_connect", "report frame has rendered " + r8);
        HashMap r26 = new HashMap();
        r26.put("business_api_name", "frame_has_rendered");
        r26.put("android_event_key", "frame_has_rendered");
        com.bytedance.android.live.revlink.impl.global.c r27 = r10.c;
        if (r27 == null) goto L53;
        com.bytedance.android.live.revenuelink.f r28 = r27.getRevenueLinkTraceMonitor();
    L54:
        if (r28 == null) goto L8;
        r28.c0("ttlive_multilinker_business_api_call", LiveTracingMonitorKt.EventModule.MULTI_LINKER, 0, "", r26, r8);
        goto L8
    L53:
        r28 = null;
        goto L54
    L43:
        r23 = null;
        goto L44
    L25:
        r19 = null;
    L15:
        r7 = "";
        goto L16
    }
}
