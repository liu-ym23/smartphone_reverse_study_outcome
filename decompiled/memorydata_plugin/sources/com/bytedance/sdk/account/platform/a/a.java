package com.bytedance.sdk.account.platform.a;

import com.bytedance.sdk.account.platform.api.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Class, b> f3133a;

    static {
        f3133a = new ConcurrentHashMap();
    }

    public static <T extends b> T a(Class<T> r2) {
        return (T) ZeusTransformUtils.preCheckCast(f3133a.get(r2), b.class, "com.obric.memorydata.plugin");
    }
}
