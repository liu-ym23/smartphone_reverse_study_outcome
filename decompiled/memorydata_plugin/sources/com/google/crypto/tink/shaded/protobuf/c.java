package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
abstract class c<E> extends AbstractList<E> implements ab.i<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5011a;

    c() {
        this(true);
    }

    c(boolean r1) {
        this.f5011a = r1;
    }

    public boolean a() {
        return this.f5011a;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r1, E r2) {
        c();
        super.add(r1, r2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r1) {
        c();
        return super.add(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r3, Collection<? extends E> r4) {
        Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        c();
        return super.addAll(r3, r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        c();
        return super.addAll(r4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.i
    public final void b() {
        if (this.f5011a == false) goto L6;
        this.f5011a = false;
        return;
    }

    public void c() {
        if (this.f5011a == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        c();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, List.class) == true) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r7, RandomAccess.class) == false) goto L11;
        List r8 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        int r1 = size();
        if (r1 == r8.size()) goto L15;
        return false;
    L15:
        int r3 = 0;
    L16:
        if (r3 >= r1) goto L21;
        if (get(r3).equals(r8.get(r3)) == false) goto L19;
        r3 = r3 + 1;
        goto L16
    L19:
        return false;
    L21:
        return true;
    L11:
        return super.equals(r7);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r0 = size();
        int r1 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = (r1 * 31) + get(r2).hashCode();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r1) {
        c();
        return (E) super.remove(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r2) {
        c();
        int r3 = indexOf(r2);
        if (r3 != (-1)) goto L6;
        return false;
    L6:
        remove(r3);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        c();
        return super.removeAll(r4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        c();
        return super.retainAll(r4);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r1, E r2) {
        c();
        return (E) super.set(r1, r2);
    }
}
