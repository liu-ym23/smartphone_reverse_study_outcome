package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
final class bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final bg f4976a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bm f4977b;
    private final ConcurrentMap<Class<?>, bl<?>> c;

    static {
        f4976a = new bg();
    }

    private bg() {
        this.c = new ConcurrentHashMap();
        this.f4977b = new am();
    }

    public static bg a() {
        return f4976a;
    }

    public <T> bl<T> a(Class<T> r4) {
        ab.a(r4, "messageType");
        bl<T> r0 = (bl) ZeusTransformUtils.preCheckCast(this.c.get(r4), bl.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        bl<T> r1 = this.f4977b.a(r4);
        bl<T> r3 = (bl<T>) a(r4, r1);
        if (r3 != null) goto L7;
        return r1;
    L7:
        return r3;
    L8:
        return r0;
    }

    public bl<?> a(Class<?> r3, bl<?> r4) {
        bl<?> r5 = (bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin");
        ab.a(r3, "messageType");
        ab.a(r5, "schema");
        return (bl) ZeusTransformUtils.preCheckCast(this.c.putIfAbsent(r3, r5), bl.class, "com.obric.memorydata.plugin");
    }

    public <T> bl<T> a(T r1) {
        return a(r1.getClass());
    }
}
