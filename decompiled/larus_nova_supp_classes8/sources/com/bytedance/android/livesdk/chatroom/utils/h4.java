package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h4 {
    public static final /* synthetic */ int a = 0;

    static {
        new SimpleDateFormat("yyyy-MM-dd");
    }

    public static String a(long r13) {
        StringBuilder r0 = new StringBuilder();
        long r1 = 3600000;
        long r3 = r13 / r1;
        long r5 = 60000;
        long r7 = (r13 / r5) % ((long) 60);
        long r14 = ((r13 % r1) % r5) / ((long) BubbleId.PadCast);
        if (r3 > 0) goto L5;
    L9:
        long r2 = 10;
        if (r7 < r2) goto L13;
        r0.append(r7);
    L16:
        r0.append(":");
        if (r14 < r2) goto L20;
        r0.append(r14);
    L24:
        return r0.toString();
    L20:
        if (r14 <= 0) goto L22;
        r0.append(0);
        r0.append(r14);
        goto L24
    L22:
        r0.append("00");
        goto L24
    L13:
        if (r7 <= 0) goto L15;
        r0.append(0);
        r0.append(r7);
        goto L16
    L15:
        r0.append("00");
        goto L16
    L5:
        if (r3 < 10) goto L7;
        r0.append(r3);
    L8:
        r0.append(":");
        goto L9
    L7:
        r0.append(0);
        r0.append(r3);
        goto L8
    }
}
