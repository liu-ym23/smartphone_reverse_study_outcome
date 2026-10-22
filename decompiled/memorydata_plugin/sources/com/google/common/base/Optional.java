package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    Optional() {
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromJavaUtil(java.util.Optional<T> r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return fromNullable(r1.orElse(null));
    }

    public static <T> Optional<T> fromNullable(T r1) {
        if (r1 != null) goto L5;
        return absent();
    L5:
        return new Present(r1);
    }

    public static <T> Optional<T> of(T r1) {
        return new Present(n.a(r1));
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> r2) {
        final Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        n.a(r3);
        return new AnonymousClass1(r3);
    }

    public static <T> java.util.Optional<T> toJavaUtil(Optional<T> r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.toJavaUtil();
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object r1);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> r1);

    public abstract T or(r<? extends T> r1);

    public abstract T or(T r1);

    public abstract T orNull();

    public java.util.Optional<T> toJavaUtil() {
        return java.util.Optional.ofNullable(orNull());
    }

    public abstract String toString();

    public abstract <V> Optional<V> transform(g<? super T, V> r1);
}
