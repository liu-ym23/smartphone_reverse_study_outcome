package com.google.common.base;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    public Present(T r5) {
        this.reference = r5;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object r5) {
        if ((r5 instanceof Present) == true) goto L5;
        return false;
    L5:
        return this.reference.equals(((Present) r5).reference);
    }

    @Override // com.google.common.base.Optional
    public T get() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.common.base.Optional
    public T or(T r5) {
        b0.n(r5, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        String r5 = String.valueOf(this.reference);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 13, "Optional.of(", r5, ")");
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(q r5) {
        Object r10 = r5.apply(this.reference);
        b0.n(r10, "the Function passed to Optional.transform() must not return null.");
        return new Present(r10);
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> r5) {
        r5.getClass();
        return this;
    }

    @Override // com.google.common.base.Optional
    public T or(e0 r5) {
        r5.getClass();
        return this.reference;
    }
}
