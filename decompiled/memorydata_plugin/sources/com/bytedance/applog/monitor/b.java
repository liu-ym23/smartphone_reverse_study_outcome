package com.bytedance.applog.monitor;

import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.applog.monitor.v3.e;
import com.bytedance.applog.monitor.v3.h;
import com.bytedance.applog.n.c;
import com.bytedance.applog.n.d;
import com.bytedance.applog.n.g;
import com.bytedance.applog.n.j;
import com.bytedance.crash.constants.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(e r10, EventStage r11, h r12) {
        if (r10.d() == true) goto L5;
        return;
    L5:
        r10.a(r12.e, r12.f, r11, r12.f1702a, r12.f1703b, r12.c, r12.d);
    }

    public static void a(e r9, EventStage r10, com.bytedance.applog.n.a r11) {
        if (r9.d() == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r11, c.class) == false) goto L10;
        String r3 = ((c) ZeusTransformUtils.preCheckCast(r11, c.class, "com.obric.memorydata.plugin")).w;
        String r4 = String.valueOf(r11.r);
        long r5 = r11.f1725b;
        StageEventType r7 = StageEventType.V1_EVENT;
    L8:
        r9.a(r10, r3, r4, r5, r7);
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.n.e.class) == false) goto L13;
        r3 = ((com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r11, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin")).u();
        r4 = String.valueOf(r11.r);
        r5 = r11.f1725b;
        r7 = StageEventType.V3_EVENT;
        goto L8
    L13:
        if (ZeusTransformUtils.instanceOf(r11, d.class) == false) goto L16;
        r3 = ((d) ZeusTransformUtils.preCheckCast(r11, d.class, "com.obric.memorydata.plugin")).t();
        r4 = String.valueOf(r11.r);
        r5 = r11.f1725b;
        r7 = StageEventType.LOG_DATA;
        goto L8
    L16:
        if (ZeusTransformUtils.instanceOf(r11, g.class) == false) goto L20;
        String r6 = String.valueOf(r11.r);
        long r8 = r11.f1725b;
        StageEventType r12 = StageEventType.LAUNCH;
        String r13 = Constants.LAUNCH_TAG;
    L18:
        r9.a(r10, r13, r6, r8, r12);
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r11, j.class) == false) goto L24;
        r6 = String.valueOf(r11.r);
        r8 = r11.f1725b;
        r12 = StageEventType.TERMINATE;
        r13 = "terminate";
        goto L18
    }

    public static void a(com.bytedance.applog.n.a r9) {
        if (com.bytedance.applog.monitor.exception.b.a().b() == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L10;
        com.bytedance.applog.monitor.exception.b r2 = com.bytedance.applog.monitor.exception.b.a();
        StageEventType r3 = StageEventType.V1_EVENT;
        String r4 = ((c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin")).w;
    L8:
        r2.a(r3, r4, r9.f1725b, r9.j());
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.applog.n.e.class) == false) goto L13;
        r2 = com.bytedance.applog.monitor.exception.b.a();
        r3 = StageEventType.V3_EVENT;
        r4 = ((com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r9, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin")).u();
        goto L8
    L13:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == false) goto L16;
        r2 = com.bytedance.applog.monitor.exception.b.a();
        r3 = StageEventType.LOG_DATA;
        r4 = ((d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin")).t();
        goto L8
    }

    public static boolean a(e r3, com.bytedance.applog.n.a r4) {
        if (r3.d() == true) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L11;
        String r5 = ((c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin")).x;
    L9:
        return r3.b(r5);
    L11:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.n.e.class) == false) goto L14;
        r5 = ((com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin")).u();
        goto L9
    L14:
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L17;
        r5 = ((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin")).t();
        goto L9
    L17:
        if (ZeusTransformUtils.instanceOf(r4, g.class) == false) goto L20;
        r5 = Constants.LAUNCH_TAG;
        goto L9
    L20:
        if (ZeusTransformUtils.instanceOf(r4, j.class) == false) goto L22;
        r5 = "terminate";
        goto L9
    L22:
        return false;
    }

    public static boolean a(e r1, String r2) {
        if (r1.d() == true) goto L7;
        return false;
    L7:
        return r1.b(r2);
    }

    public static int b(e r0, String r1) {
        if (a(r0, r1) == true) goto L5;
        return 0;
    L5:
        if (r0.e() == false) goto L9;
        return 3;
    L9:
        return 1;
    }

    public static boolean b(e r3, com.bytedance.applog.n.a r4) {
        if (r3.d() == true) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L11;
        String r5 = ((c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin")).x;
    L9:
        return r3.c(r5);
    L11:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.n.e.class) == false) goto L14;
        r5 = ((com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin")).u();
        goto L9
    L14:
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L17;
        r5 = ((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin")).t();
        goto L9
    L17:
        if (ZeusTransformUtils.instanceOf(r4, g.class) == false) goto L20;
        r5 = Constants.LAUNCH_TAG;
        goto L9
    L20:
        if (ZeusTransformUtils.instanceOf(r4, j.class) == false) goto L22;
        r5 = "terminate";
        goto L9
    L22:
        return false;
    }

    public static int c(e r0, com.bytedance.applog.n.a r1) {
        if (a(r0, r1) == true) goto L5;
        return 0;
    L5:
        if (r0.e() == false) goto L9;
        return 3;
    L9:
        return 1;
    }
}
