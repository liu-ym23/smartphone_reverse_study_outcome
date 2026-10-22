package com.alibaba.excel.support.cglib.core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class c<K, KK, V> {
    public static final b d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ConcurrentMap<KK, Object> f362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final b<K, V> f363b;
    protected final b<K, KK> c;

    static {
        d = new AnonymousClass1();
    }

    public c(b<K, KK> r3, b<K, V> r4) {
        b<K, KK> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        b<K, V> r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        this.c = r5;
        this.f363b = r6;
        this.f362a = new ConcurrentHashMap();
    }

    public V a(K r4) {
        KK r0 = this.c.a(r4);
        V r1 = (V) this.f362a.get(r0);
        if (r1 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, FutureTask.class) == true) goto L8;
        return r1;
    L8:
        return a(r4, r0, r1);
    }

    public V a(final K r4, KK r5, Object r6) {
        boolean r1 = false;
        if (r6 == null) goto L6;
        Object r7 = ZeusTransformUtils.preCheckCast(r6, FutureTask.class, "com.obric.memorydata.plugin");
    L5:
        FutureTask r8 = (FutureTask) r7;
    L27:
        V r9 = (V) r8.get();
        if (r1 == false) goto L15;
        this.f362a.put(r5, r9);
    L15:
        return r9;
    L23:
        e = move-exception;
        throw new IllegalStateException("Interrupted while loading cache item", e);
    L16:
        e = move-exception;
        Throwable r3 = e.getCause();
        if (ZeusTransformUtils.instanceOf(r3, RuntimeException.class) == false) goto L22;
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r3, RuntimeException.class, "com.obric.memorydata.plugin"));
    L22:
        throw new IllegalStateException("Unable to load cache item", r3);
    L6:
        FutureTask r10 = new FutureTask(new AnonymousClass2(this, r4));
        V r11 = (V) this.f362a.putIfAbsent(r5, r10);
        if (r11 != null) goto L10;
        r1 = true;
        r10.run();
        r8 = r10;
        goto L27
    L10:
        if (ZeusTransformUtils.instanceOf(r11, FutureTask.class) == false) goto L26;
        r7 = ZeusTransformUtils.preCheckCast(r11, FutureTask.class, "com.obric.memorydata.plugin");
        goto L5
    L26:
        return r11;
    }
}
