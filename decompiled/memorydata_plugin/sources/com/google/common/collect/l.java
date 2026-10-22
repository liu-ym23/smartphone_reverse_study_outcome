package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class l<E> extends AbstractList<List<E>> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient ImmutableList<List<E>> f4683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient int[] f4684b;

    private int a(int r3, int r4) {
        return (r3 / this.f4684b[r4 + 1]) % ((List) ZeusTransformUtils.preCheckCast(this.f4683a.get(r4), List.class, "com.obric.memorydata.plugin")).size();
    }

    static /* synthetic */ int a(l r0, int r1, int r2) {
        return r0.a(r1, r2);
    }

    static /* synthetic */ ImmutableList a(l r0) {
        return r0.f4683a;
    }

    public ImmutableList<E> a(final int r2) {
        com.google.common.base.n.a(r2, size());
        return new CartesianList$1(this, r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, List.class) == true) goto L5;
        return false;
    L5:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        if (r8.size() == this.f4683a.size()) goto L8;
        return false;
    L8:
        Iterator<E> r9 = r8.iterator();
        int r0 = 0;
    L10:
        if (r9.hasNext() == false) goto L15;
        if (((List) ZeusTransformUtils.preCheckCast(this.f4683a.get(r0), List.class, "com.obric.memorydata.plugin")).contains(r9.next()) == false) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* synthetic */ Object get(int r1) {
        return a(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, List.class) == true) goto L5;
        return -1;
    L5:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        if (r8.size() == this.f4683a.size()) goto L8;
        return -1;
    L8:
        ListIterator<E> r9 = r8.listIterator();
        int r0 = 0;
    L10:
        if (r9.hasNext() == false) goto L15;
        int r3 = r9.nextIndex();
        int r4 = ((List) ZeusTransformUtils.preCheckCast(this.f4683a.get(r3), List.class, "com.obric.memorydata.plugin")).indexOf(r9.next());
        if (r4 == (-1)) goto L13;
        r0 = r0 + (r4 * this.f4684b[r3 + 1]);
        goto L10
    L13:
        return -1;
    L15:
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, List.class) == true) goto L5;
        return -1;
    L5:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        if (r8.size() == this.f4683a.size()) goto L8;
        return -1;
    L8:
        ListIterator<E> r9 = r8.listIterator();
        int r0 = 0;
    L10:
        if (r9.hasNext() == false) goto L15;
        int r3 = r9.nextIndex();
        int r4 = ((List) ZeusTransformUtils.preCheckCast(this.f4683a.get(r3), List.class, "com.obric.memorydata.plugin")).lastIndexOf(r9.next());
        if (r4 == (-1)) goto L13;
        r0 = r0 + (r4 * this.f4684b[r3 + 1]);
        goto L10
    L13:
        return -1;
    L15:
        return r0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f4684b[0];
    }
}
