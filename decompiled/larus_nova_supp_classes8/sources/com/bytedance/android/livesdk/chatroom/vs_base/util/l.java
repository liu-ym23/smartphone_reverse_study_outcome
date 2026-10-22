package com.bytedance.android.livesdk.chatroom.vs_base.util;

import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.feed.services.AppointmentService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l {
    public static String a(long r12) {
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.a == false) goto L7;
        return IESUIUtils.getDisplayCount(r12, "w");
    L7:
        if (r12 >= AppointmentService.SOURCE_UNDEFINED) goto L10;
        return String.valueOf(r12);
    L10:
        if (r12 >= 100000) goto L13;
        return n.a("%.1f", new Object[]{Double.valueOf((r12 * 1.0d) / 10000.0d)}) + "万";
    L13:
        if (r12 >= 1000000) goto L16;
        return n.a("%.0f", new Object[]{Double.valueOf((r12 * 1.0d) / 10000.0d)}) + "万";
    L16:
        if (r12 >= 10000000) goto L19;
        return n.a("%.0f", new Object[]{Double.valueOf((r12 * 1.0d) / 10000.0d)}) + "万";
    L19:
        if (r12 >= 100000000) goto L22;
        return n.a("%.1f", new Object[]{Double.valueOf((r12 * 1.0d) / 1.0E7d)}) + "千万";
    L22:
        if (r12 >= 1000000000) goto L25;
        return n.a("%.1f", new Object[]{Double.valueOf((r12 * 1.0d) / 1.0E8d)}) + "亿";
    L25:
        return n.a("%.0f", new Object[]{Double.valueOf((r12 * 1.0d) / 1.0E8d)}) + "亿";
    }
}
