package com.google.common.base;

import java.io.Serializable;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public Optional() {
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromJavaUtil(java.util.Optional<T> r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return fromNullable(r5.orElse(null));
    }

    public static <T> Optional<T> fromNullable(T r5) {
        if (r5 != null) goto L5;
        return absent();
    L5:
        return new Present(r5);
    }

    public static <T> Optional<T> of(T r5) {
        r5.getClass();
        return new Present(r5);
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> r5) {
        r5.getClass();
        return new com.bumptech.glide.load.engine.v(r5, 1);
    }

    public static <T> java.util.Optional<T> toJavaUtil(Optional<T> r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.toJavaUtil();
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object r5);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> r5);

    public abstract T or(e0 r5);

    public abstract T or(T r5);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(q r5);

    public java.util.Optional<T> toJavaUtil() {
        return java.util.Optional.ofNullable(orNull());
    }
}
