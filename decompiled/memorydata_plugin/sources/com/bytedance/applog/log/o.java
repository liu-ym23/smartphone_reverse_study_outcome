package com.bytedance.applog.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArraySet<k> f1641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, k> f1642b = null;

    static {
        f1641a = new CopyOnWriteArraySet();
        f1642b = new ConcurrentHashMap();
    }

    public static k a(String r2) {
        if (b(r2) == true) goto L5;
        return null;
    L5:
        return (k) ZeusTransformUtils.preCheckCast(f1642b.get(r2), k.class, "com.obric.memorydata.plugin");
    }

    public static void a(k r2) {
        k r3 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin");
        f1641a.add(r3);
    }

    public static void a(l r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (f1641a.isEmpty() == false) goto L7;
        return;
    L7:
        Iterator<k> r0 = b();
    L9:
        if (r0.hasNext() == false) goto L11;
        ((k) ZeusTransformUtils.preCheckCast(r0.next(), k.class, "com.obric.memorydata.plugin")).a(r4);
        goto L9
    }

    public static void a(String r2, k r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        f1642b.put(r2, r4);
    }

    public static boolean a() {
        if (f1641a.isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (f1642b.isEmpty() == false) goto L7;
        return true;
    }

    public static Iterator<k> b() {
        return f1641a.iterator();
    }

    private static boolean b(String r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.isEmpty() == true) goto L6;
        return true;
    }

    public static Iterator<k> c() {
        return f1642b.values().iterator();
    }
}
