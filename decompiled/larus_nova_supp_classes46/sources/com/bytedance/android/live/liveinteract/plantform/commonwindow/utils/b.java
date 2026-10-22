package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import com.bytedance.android.livesdk.chatroom.model.interact.j2;
import com.bytedance.android.livesdk.link.model.bridge.m2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(int r12) {
        tc0.c r0 = tc0.c.h();
        Map r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.m;
    L6:
        tc0.c r3 = tc0.c.h();
        if (r3 == null) goto L13;
        u1 r4 = r3.r;
        if (r4 == null) goto L13;
        m2 r5 = r4.getVideoPositionLiveCoreInfo();
        if (r5 == null) goto L13;
        r1 = r5.getLiveCoreInfoMap();
    L13:
        if (r1 == null) goto L33;
        Iterator r6 = r1.keySet().iterator();
        long r7 = -1;
    L16:
        if (r6.hasNext() == false) goto L23;
        long r8 = ((Number) r6.next()).longValue();
        if (r12 < r8) goto L16;
        if (r8 <= r7) goto L16;
        r7 = r8;
        goto L16
    L23:
        if (r7 > (-1)) goto L25;
        return r2;
    L25:
        return (String) r1.get(Long.valueOf(r7));
    L33:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public static String b(int r12) {
        tc0.c r0 = tc0.c.h();
        Map r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.k;
    L6:
        tc0.c r3 = tc0.c.h();
        if (r3 == null) goto L13;
        v1 r4 = r3.n;
        if (r4 == null) goto L13;
        j2 r5 = r4.getVideoPositionRtcInfo();
        if (r5 == null) goto L13;
        r1 = r5.getRtcInfoMap();
    L13:
        if (r1 == null) goto L33;
        Iterator r6 = r1.keySet().iterator();
        long r7 = -1;
    L16:
        if (r6.hasNext() == false) goto L23;
        long r8 = ((Number) r6.next()).longValue();
        if (r12 < r8) goto L16;
        if (r8 <= r7) goto L16;
        r7 = r8;
        goto L16
    L23:
        if (r7 > (-1)) goto L25;
        return r2;
    L25:
        return (String) r1.get(Long.valueOf(r7));
    L33:
        return r2;
    L5:
        r2 = null;
        goto L6
    }
}
