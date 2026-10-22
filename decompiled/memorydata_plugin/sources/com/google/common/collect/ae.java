package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ae<E> extends v<E> implements Set<E> {
    public ae() {
    }

    @Override // com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.v, com.google.common.collect.ac
    public abstract Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r1) == true) goto L7;
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean standardEquals(Object r1) {
        return Sets.a(this, r1);
    }

    public int standardHashCode() {
        return Sets.a(this);
    }

    @Override // com.google.common.collect.v
    public boolean standardRemoveAll(Collection<?> r3) {
        return Sets.a(this, (Collection) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
    }
}
