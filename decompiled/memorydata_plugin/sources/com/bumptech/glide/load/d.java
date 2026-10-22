package com.bumptech.glide.load;

import com.bumptech.glide.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a<Object> f668a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f669b;
    private final a<T> c;
    private final String d;
    private volatile byte[] e;

    public interface a<T> {
        void update(byte[] r1, T r2, MessageDigest r3);
    }

    static {
        f668a = new AnonymousClass1();
    }

    private d(String r3, T r4, a<T> r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        this.d = j.a(r3);
        this.f669b = r4;
        this.c = (a) ZeusTransformUtils.preCheckCast(j.a(r6), a.class, "com.obric.memorydata.plugin");
    }

    public static <T> d<T> a(String r3) {
        return new d(r3, null, c());
    }

    public static <T> d<T> a(String r2, T r3) {
        return new d(r2, r3, c());
    }

    public static <T> d<T> a(String r2, T r3, a<T> r4) {
        return new d(r2, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin"));
    }

    private byte[] b() {
        if (this.e != null) goto L6;
        this.e = this.d.getBytes(c.f667a);
    L6:
        return this.e;
    }

    private static <T> a<T> c() {
        return (a<T>) f668a;
    }

    public T a() {
        return this.f669b;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L6;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
        return this.d.equals(r4.d);
    L6:
        return false;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.d + "'}";
    }

    public void update(T r2, MessageDigest r3) {
        this.c.update(b(), r2, r3);
    }
}
