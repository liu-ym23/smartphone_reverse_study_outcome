package com.google.common.reflect;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static <T> T a(Class<T> r3, InvocationHandler r4) {
        InvocationHandler r5 = (InvocationHandler) ZeusTransformUtils.wrapperContextForParams(r4, InvocationHandler.class, "com.obric.memorydata.plugin");
        n.a(r5);
        n.a(r3.isInterface(), "%s is not an interface", r3);
        return r3.cast(Proxy.newProxyInstance(r3.getClassLoader(), new Class[]{r3}, r5));
    }
}
