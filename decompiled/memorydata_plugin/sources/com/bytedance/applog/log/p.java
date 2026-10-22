package com.bytedance.applog.log;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f1643a;

    static {
        f1643a = false;
    }

    public static String a(com.bytedance.applog.n.a r4) {
        if (r4 != null) goto L6;
        return "";
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.n.f.class) == false) goto L10;
        return "FORWARD_EVENT";
    L10:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.n.e.class) == false) goto L17;
        if ("applog_trace".equals(((com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin")).u()) == false) goto L15;
        return CipherConst.LEVEL_TRACE;
    L15:
        return "EVENT_V3";
    L17:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.n.i.class) == false) goto L20;
        return "EVENT_V3";
    L20:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.n.c.class) == false) goto L24;
        return ((com.bytedance.applog.n.c) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.n.c.class, "com.obric.memorydata.plugin")).v.toUpperCase(Locale.ROOT);
    L24:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.n.g.class) == false) goto L28;
        return "LAUNCH";
    L28:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.n.j.class) == false) goto L32;
        return "TERMINATE";
    L32:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.n.d.class) == false) goto L35;
        return "LOG_DATA";
    L35:
        return "";
    }

    private static String a(String r2) {
        return "applog_" + r2;
    }

    public static void a(String r3, g.a r4) {
        g.a r5 = (g.a) ZeusTransformUtils.wrapperContextForParams(r4, g.a.class, "com.obric.memorydata.plugin");
        if (a() == false) goto L5;
        return;
    L5:
        if (com.bytedance.applog.util.o.b(r3) == true) goto L10;
        ((g) ZeusTransformUtils.preCheckCast(g.f1630a.c(new Object[0]), g.class, "com.obric.memorydata.plugin")).a(a(r3), r5);
        return;
    }

    public static void a(String r3, final Object r4) {
        if (a() == false) goto L5;
        return;
    L5:
        if (com.bytedance.applog.util.o.b(r3) == false) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.n.a.class) == false) goto L10;
        ((g) ZeusTransformUtils.preCheckCast(g.f1630a.c(new Object[0]), g.class, "com.obric.memorydata.plugin")).a(a(r3), new AnonymousClass1(r4));
        return;
    L10:
        ((g) ZeusTransformUtils.preCheckCast(g.f1630a.c(new Object[0]), g.class, "com.obric.memorydata.plugin")).a(a(r3), r4);
    }

    public static void a(String r3, String r4) {
        if (a() == false) goto L5;
        return;
    L5:
        if (com.bytedance.applog.util.o.b(r3) == true) goto L10;
        ((g) ZeusTransformUtils.preCheckCast(g.f1630a.c(new Object[0]), g.class, "com.obric.memorydata.plugin")).a(a(r3), r4);
        return;
    }

    public static void a(boolean r0) {
        f1643a = Boolean.valueOf(r0);
    }

    public static boolean a() {
        return !f1643a.booleanValue();
    }
}
