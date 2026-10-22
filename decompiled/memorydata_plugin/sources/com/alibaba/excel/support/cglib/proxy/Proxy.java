package com.alibaba.excel.support.cglib.proxy;

import com.alibaba.excel.support.cglib.core.CodeGenerationException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Proxy implements Serializable {
    private static final c BAD_OBJECT_METHOD_FILTER = null;
    protected l h;

    private static class ProxyImpl extends Proxy {
        public ProxyImpl(l r3) {
            super((l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        BAD_OBJECT_METHOD_FILTER = new AnonymousClass1();
    }

    public Proxy(l r5) {
        l r6 = (l) ZeusTransformUtils.wrapperContextForParams(r5, l.class, "com.obric.memorydata.plugin");
        h.a(getClass(), new b[]{r6, null});
        this.h = r6;
    }

    public static l getInvocationHandler(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ProxyImpl.class) == false) goto L7;
        return ((Proxy) ZeusTransformUtils.preCheckCast(r2, Proxy.class, "com.obric.memorydata.plugin")).h;
    L7:
        throw new IllegalArgumentException("Object is not a proxy");
    }

    public static Class getProxyClass(ClassLoader r3, Class[] r4) {
        h r5 = new h();
        r5.d(ProxyImpl.class);
        r5.a(r4);
        r5.b(new Class[]{l.class, r.class});
        r5.a(BAD_OBJECT_METHOD_FILTER);
        r5.a(false);
        return r5.c();
    }

    public static boolean isProxyClass(Class r1) {
        return r1.getSuperclass().equals(ProxyImpl.class);
    }

    public static Object newProxyInstance(ClassLoader r3, Class[] r4, l r5) {
        l r6 = (l) ZeusTransformUtils.wrapperContextForParams(r5, l.class, "com.obric.memorydata.plugin");
        return getProxyClass(r3, r4).getConstructor(new Class[]{l.class}).newInstance(new Object[]{r6});
    L8:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        throw new CodeGenerationException(e);
    }
}
