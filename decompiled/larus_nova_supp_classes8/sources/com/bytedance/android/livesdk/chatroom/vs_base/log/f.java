package com.bytedance.android.livesdk.chatroom.vs_base.log;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public static String a;
    public static long b;

    static {
        a = "";
    }

    public static void a(DataCenter r12, int r13, Integer r14, int r15) {
        if (r12 != null) goto L4;
        return;
    L4:
        d r16 = d.a(r12);
        String r1 = "click";
        if (r13 == 0) goto L11;
        if (r13 == 1) goto L10;
        if (r13 == 2) goto L9;
        String r3 = "";
    L12:
        a = r3;
        Pair[] r4 = new Pair[4];
        if (r13 == 2) goto L16;
        if (r13 == 3) goto L16;
    L17:
        r4[0] = TuplesKt.to("change_way", r1);
        long r7 = 0;
        if (b == 0) goto L21;
        long r5 = System.currentTimeMillis();
        long r8 = r5 - b;
        b = r5;
        r7 = r8 / ((long) BubbleId.PadCast);
    L21:
        r4[1] = TuplesKt.to("duration", String.valueOf(r7));
        if (r14 == null) goto L24;
        int r17 = r14.intValue();
    L25:
        String r18 = "4";
        if (r17 == 0) goto L34;
        if (r17 == 1) goto L33;
        if (r17 == 6) goto L32;
        if (r17 == 8) goto L31;
        Object r19 = "4";
    L35:
        r4[2] = TuplesKt.to("room_orientation_before", r19);
        if (r15 == 0) goto L44;
        if (r15 == 1) goto L43;
        if (r15 == 6) goto L42;
        if (r15 != 8) goto L45;
        r18 = "2";
    L45:
        r4[3] = TuplesKt.to("room_orientation_after", r18);
        r16.d("screen_rotate", MapsKt.hashMapOf(r4), new Object[0]);
        return;
    L42:
        r18 = "3";
        goto L45
    L43:
        r18 = "0";
        goto L45
    L44:
        r18 = "1";
        goto L45
    L31:
        r19 = "2";
        goto L35
    L32:
        r19 = "3";
        goto L35
    L33:
        r19 = "0";
        goto L35
    L34:
        r19 = "1";
        goto L35
    L24:
        r17 = 1;
    L16:
        r1 = "auto";
        goto L17
    L9:
        r3 = "counterclockwise_slide";
        goto L12
    L10:
        r3 = "clockwise_slide";
        goto L12
    L11:
        r3 = "click";
        goto L12
    }
}
