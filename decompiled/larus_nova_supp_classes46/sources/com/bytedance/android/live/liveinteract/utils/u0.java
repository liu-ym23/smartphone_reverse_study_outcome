package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.livesdk.chatroom.model.interact.j2;
import com.bytedance.android.livesdk.link.model.bridge.m2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(int r11, tc0.b r12) {
        Map r0 = null;
        if (r12 == null) goto L5;
        String r1 = r12.getLiveCoreExtInfo();
    L6:
        if (r12 == null) goto L12;
        u1 r13 = r12.getMultiLiveCoreInfo();
        if (r13 == null) goto L12;
        m2 r14 = r13.getVideoPositionLiveCoreInfo();
        if (r14 == null) goto L12;
        r0 = r14.getLiveCoreInfoMap();
    L12:
        if (r0 == null) goto L32;
        Iterator r15 = r0.keySet().iterator();
        long r4 = -1;
    L15:
        if (r15.hasNext() == false) goto L22;
        long r6 = ((Number) r15.next()).longValue();
        if (r11 < r6) goto L15;
        if (r6 <= r4) goto L15;
        r4 = r6;
        goto L15
    L22:
        if (r4 > (-1)) goto L24;
        return r1;
    L24:
        return (String) r0.get(Long.valueOf(r4));
    L32:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public static String b(int r11, tc0.b r12) {
        Map r0 = null;
        if (r12 == null) goto L5;
        String r1 = r12.getRtcExtInfo();
    L6:
        if (r12 == null) goto L12;
        v1 r13 = r12.getMultiRtcInfo();
        if (r13 == null) goto L12;
        j2 r14 = r13.getVideoPositionRtcInfo();
        if (r14 == null) goto L12;
        r0 = r14.getRtcInfoMap();
    L12:
        if (r0 == null) goto L35;
        Iterator r15 = r0.keySet().iterator();
        long r4 = -1;
    L15:
        if (r15.hasNext() == false) goto L22;
        long r6 = ((Number) r15.next()).longValue();
        if (r11 < r6) goto L15;
        if (r6 <= r4) goto L15;
        r4 = r6;
        goto L15
    L22:
        if (r4 <= (-1)) goto L36;
        String r16 = (String) r0.get(Long.valueOf(r4));
        if (r16 != null) goto L27;
        return r1;
    L27:
        return r16;
    L36:
        return r1;
    L35:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}
