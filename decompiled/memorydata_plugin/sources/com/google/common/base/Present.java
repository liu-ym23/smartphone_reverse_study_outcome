package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    Present(T r1) {
        this.reference = r1;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Present.class) == false) goto L6;
        Present r4 = (Present) ZeusTransformUtils.preCheckCast(r3, Present.class, "com.obric.memorydata.plugin");
        return this.reference.equals(r4.reference);
    L6:
        return false;
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
    public Optional<T> or(Optional<? extends T> r1) {
        n.a(r1);
        return this;
    }

    @Override // com.google.common.base.Optional
    public T or(r<? extends T> r3) {
        n.a((r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin"));
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public T or(T r2) {
        n.a(r2, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.of(" + this.reference + ")";
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(g<? super T, V> r3) {
        return new Present(n.a(((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin")).apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }
}
