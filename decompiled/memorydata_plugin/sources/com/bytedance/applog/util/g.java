package com.bytedance.applog.util;

import android.content.Context;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.log.q;
import com.bytedance.crash.constants.Constants;
import com.ss.android.common.lib.AppLogNewUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f1885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, h> f1886b = null;
    private static final com.bytedance.applog.log.b<Boolean> c = null;

    static {
        f1885a = Collections.singletonList("EventsSenderUtils");
        f1886b = new ConcurrentHashMap();
        c = new AnonymousClass1();
    }

    public static void a(String r2, String r3) {
        h r4 = b(r2);
        if (r4 == null) goto L5;
        r4.setEventVerifyUrl(r3);
        return;
    L5:
        q.a().d(f1885a, "can't find ET, should compile with ET", new Object[0]);
    }

    public static void a(String r0, String r1, JSONArray r2) {
        h r3 = b(r0);
        if (r3 == null) goto L6;
        r3.putEvent(r1, r2);
        return;
    }

    public static void a(String r2, boolean r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        h r6 = b(r2);
        if (r6 == null) goto L5;
        r6.setEnable(r3, r5);
        return;
    L5:
        q.a().d(f1885a, "can't find ET, should compile with ET", new Object[0]);
    }

    public static boolean a(String r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(c.c(new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        return false;
    L5:
        h r5 = b(r4);
        if (r5 != null) goto L9;
        return false;
    L9:
        return r5.isEnable();
    }

    private static h b(String r3) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(c.c(new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        return null;
    L6:
        Map<String, h> r0 = f1886b;
        if (r0.containsKey(r3) == true) goto L11;
        h r1 = c(r3);
        r0.put(r3, r1);
        return r1;
    L11:
        return (h) ZeusTransformUtils.preCheckCast(r0.get(r3), h.class, "com.obric.memorydata.plugin");
    }

    private static h c(String r8) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(c.c(new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        return null;
    L5:
        com.bytedance.applog.b r9 = com.bytedance.applog.a.b(r8);
        if (r9 != null) goto L18;
        r9 = (com.bytedance.applog.b) ZeusTransformUtils.preCheckCast(AppLog.getInstance(), com.bytedance.applog.b.class, "com.obric.memorydata.plugin");
    L18:
        Constructor r1 = ZeusTransformUtils.forName("com.bytedance.applog.et_verify.EventVerify", "com.obric.memorydata.plugin").getConstructor(new Class[]{com.bytedance.applog.b.class});     // Catch: Throwable -> L13 Exception -> L16
        r1.setAccessible(true);     // Catch: Throwable -> L13 Exception -> L16
        h r10 = (h) ZeusTransformUtils.preCheckCast(r1.newInstance(new Object[]{r9}), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13 Exception -> L16
        if (r10 != null) goto L11;
        q.a().c(f1885a, "can't find event verify, should compile with ET", new Object[0]);
    L20:
        return r10;
    L11:
        q.a().b(f1885a, "found event sender: {}", new Object[]{r10});
        goto L20
    L16:
        q.a().c(f1885a, "can't find event verify, should compile with ET", new Object[0]);
        return null;
    L13:
        th = move-exception;
        q.a().c(f1885a, "can't find event verify, should compile with ET", new Object[0]);
        throw th;
    }

    public static String getType(com.bytedance.applog.n.a r1) {
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.c.class) == false) goto L7;
        return "event";
    L7:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.e.class) == false) goto L11;
        return AppLogNewUtils.EVENT_V3_CATEGORY;
    L11:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.d.class) == false) goto L15;
        return "log_data";
    L15:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.g.class) == false) goto L19;
        return Constants.LAUNCH_TAG;
    L19:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.j.class) == false) goto L22;
        return "terminate";
    L22:
        return null;
    }
}
