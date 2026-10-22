package com.bytedance.apm.trace.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, Integer> f1436a;

    static {
        f1436a = new HashMap();
        a();
    }

    public static Integer a(String r2) {
        return (Integer) ZeusTransformUtils.preCheckCast(f1436a.get(r2), Integer.class, "com.obric.memorydata.plugin");
    }

    private static void a() {
        a("xx", 12334);
    }

    public static void a(String r1, int r2) {
        f1436a.put(r1, Integer.valueOf(r2));
    }
}
