package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.z1;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static final String a(v4 r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$doubleGuestLinkerID");
        b2 r7 = r5.getPreRtcInfo();
        if (r7 == null) goto L25;
        Map r8 = r7.getPreRtcUserInfo();
        if (r8 != null) goto L7;
        return "";
    L7:
        if (r8.size() != 2) goto L27;
        d51.c r1 = d51.c.A0;
        r1.getClass();
        if (((Boolean) d51.c.B.getValue(r1, d51.c.a[26])).booleanValue() == false) goto L28;
        Iterator r2 = CollectionsKt.toSet(r8.keySet()).iterator();
    L12:
        if (r2.hasNext() == false) goto L31;
        long r3 = ((Number) r2.next()).longValue();
        if (r3 == r6) goto L12;
        z1 r9 = (z1) r8.get(Long.valueOf(r3));
        if (r9 == null) goto L29;
        String r10 = r9.getLinkmicIdStr();
        if (r10 != null) goto L21;
        return "";
    L21:
        return r10;
    L29:
        return "";
    L31:
        return "";
    L28:
        return "";
    L27:
        return "";
    L25:
        return "";
    }

    public static final void b(int r5, int r6) {
        if (e21.a.a(r6) == false) goto L5;
        String r7 = "pk";
    L7:
        if (r5 != 4004129) goto L10;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("connection_type", r7);
        r8.put("control_user", "inviter");
        mz0.n r9 = new mz0.n();
        Map<String, String> r0 = r9.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r0.putAll(r8);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        r10.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r1 = r9.b;
        ArrayList r2 = (ArrayList) r1;
        r2.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_connection_anchor_control_toast_show", r9.a, r9.b);
        return;
    L10:
        if (r5 != 4004130) goto L14;
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("connection_type", r7);
        r14.put("control_user", "invitee");
        mz0.n r15 = new mz0.n();
        Map<String, String> r3 = r15.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r14, "map");
        r3.putAll(r14);
        mz0.m r16 = new mz0.m();
        r16.b(LogCommon.ROOM);
        r16.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r4 = r15.b;
        ArrayList r17 = (ArrayList) r4;
        r17.addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r19);
        ((mz0.i) ((f80.a) r19)).w3("livesdk_connection_anchor_control_toast_show", r15.a, r15.b);
        return;
    L14:
        return;
    L5:
        r7 = "anchor";
        goto L7
    }
}
