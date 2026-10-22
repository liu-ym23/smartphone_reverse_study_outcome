package com.ss.android.ugc.aweme.framework.services;

import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DynamicProxy {
    public DynamicProxy() {
    }

    public static <T> T get(Class<?> r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isInterface() == true) goto L7;
        return null;
    L7:
        return (T) Proxy.newProxyInstance(r3.getClassLoader(), new Class[]{r3}, new AnonymousClass1());
    }
}
