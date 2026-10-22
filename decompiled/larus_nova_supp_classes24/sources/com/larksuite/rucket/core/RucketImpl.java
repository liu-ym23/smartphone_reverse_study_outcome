package com.larksuite.rucket.core;

import b38.b;
import d38.d;
import d38.f;
import d38.g;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class RucketImpl implements b {
    public static final /* synthetic */ int e = 0;
    public final ConcurrentHashMap<Method, com.larksuite.rucket.core.proxymethod.a> b;
    public final ConcurrentHashMap<Class<?>, Object> c;
    public final ConcurrentHashMap<KClass<? extends Annotation>, Function1<Method, com.larksuite.rucket.core.proxymethod.a>> d;

    public static final class a {
    }

    static {
    }

    public RucketImpl() {
        this.b = new ConcurrentHashMap(2048);
        this.c = new ConcurrentHashMap(128);
        this.d = new ConcurrentHashMap();
        a(new d38.b());
        a(new d());
        a(new f());
        a(new g());
    }

    public final void a(c38.b r4) {
        Intrinsics.checkNotNullParameter(r4, "strategy");
        this.d.put(r4.a(), new RucketImpl$registerStrategy$1(r4));
    }

    @Override // b38.b
    public final <T> T create(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        ConcurrentHashMap<Class<?>, Object> r0 = this.c;
        T r1 = (T) r0.get(r5);
        if (r1 != null) goto L8;
        r1 = (T) Proxy.newProxyInstance(r5.getClassLoader(), new Class[]{r5}, new RucketImpl$create$1$1(this));
        Object r6 = r0.putIfAbsent((Class<?>) r5, r1);
        if (r6 == null) goto L8;
        r1 = (T) r6;
    L8:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type T of com.larksuite.rucket.core.RucketImpl.create");
        return r1;
    }
}
