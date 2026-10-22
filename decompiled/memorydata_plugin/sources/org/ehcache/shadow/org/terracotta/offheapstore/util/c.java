package org.ehcache.shadow.org.terracotta.offheapstore.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f18142a = false;

    static {
        ZeusTransformUtils.forName("org.ehcache.shadow.org.terracotta.offheapstore.util.ValidationTest", "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        boolean r0 = true;
    L5:
        f18142a = r0;
        return;
    L4:
        r0 = false;
        goto L5
    }

    public static boolean a(Class<?> r1) {
        if (f18142a == false) goto L5;
    L8:
        return true;
    L5:
        if (Boolean.getBoolean(r1.getName() + ".VALIDATE") == true) goto L8;
        return false;
    }
}
