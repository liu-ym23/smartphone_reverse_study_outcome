package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes2.dex */
public final class UArraysKt___UArraysJvmKt$asList$1 extends AbstractList<UInt> implements RandomAccess {
    final /* synthetic */ int[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$1(int[] r10) {
        this.$this_asList = r10;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof UInt) == true) goto L7;
        return false;
    L7:
        return m547containsWZ4Q5Ns(((UInt) r10).m179unboximpl());
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m547containsWZ4Q5Ns(int r10) {
        return UIntArray.m183containsWZ4Q5Ns(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return UInt.m121boximpl(m548getpVg5ArA(r10));
    }

    /* JADX INFO: renamed from: get-pVg5ArA, reason: not valid java name */
    public int m548getpVg5ArA(int r10) {
        return UIntArray.m187getpVg5ArA(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UIntArray.m188getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r10) {
        if ((r10 instanceof UInt) == true) goto L7;
        return -1;
    L7:
        return m549indexOfWZ4Q5Ns(((UInt) r10).m179unboximpl());
    }

    /* JADX INFO: renamed from: indexOf-WZ4Q5Ns, reason: not valid java name */
    public int m549indexOfWZ4Q5Ns(int r10) {
        return ArraysKt.indexOf(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UIntArray.m190isEmptyimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r10) {
        if ((r10 instanceof UInt) == true) goto L7;
        return -1;
    L7:
        return m550lastIndexOfWZ4Q5Ns(((UInt) r10).m179unboximpl());
    }

    /* JADX INFO: renamed from: lastIndexOf-WZ4Q5Ns, reason: not valid java name */
    public int m550lastIndexOfWZ4Q5Ns(int r10) {
        return ArraysKt.lastIndexOf(this.$this_asList, r10);
    }
}
