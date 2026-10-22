package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes2.dex */
public final class UArraysKt___UArraysJvmKt$asList$2 extends AbstractList<ULong> implements RandomAccess {
    final /* synthetic */ long[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$2(long[] r10) {
        this.$this_asList = r10;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof ULong) == true) goto L7;
        return false;
    L7:
        return m551containsVKZWuLQ(((ULong) r10).m258unboximpl());
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m551containsVKZWuLQ(long r10) {
        return ULongArray.m262containsVKZWuLQ(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return ULong.m200boximpl(m552getsVKNKU(r10));
    }

    /* JADX INFO: renamed from: get-s-VKNKU, reason: not valid java name */
    public long m552getsVKNKU(int r10) {
        return ULongArray.m266getsVKNKU(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return ULongArray.m267getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r10) {
        if ((r10 instanceof ULong) == true) goto L7;
        return -1;
    L7:
        return m553indexOfVKZWuLQ(((ULong) r10).m258unboximpl());
    }

    /* JADX INFO: renamed from: indexOf-VKZWuLQ, reason: not valid java name */
    public int m553indexOfVKZWuLQ(long r10) {
        return ArraysKt.indexOf(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ULongArray.m269isEmptyimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r10) {
        if ((r10 instanceof ULong) == true) goto L7;
        return -1;
    L7:
        return m554lastIndexOfVKZWuLQ(((ULong) r10).m258unboximpl());
    }

    /* JADX INFO: renamed from: lastIndexOf-VKZWuLQ, reason: not valid java name */
    public int m554lastIndexOfVKZWuLQ(long r10) {
        return ArraysKt.lastIndexOf(this.$this_asList, r10);
    }
}
