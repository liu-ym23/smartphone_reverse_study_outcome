package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes2.dex */
public final class UArraysKt___UArraysJvmKt$asList$4 extends AbstractList<UShort> implements RandomAccess {
    final /* synthetic */ short[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$4(short[] r10) {
        this.$this_asList = r10;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof UShort) == true) goto L7;
        return false;
    L7:
        return m559containsxj2QHRw(((UShort) r10).m363unboximpl());
    }

    /* JADX INFO: renamed from: contains-xj2QHRw, reason: not valid java name */
    public boolean m559containsxj2QHRw(short r10) {
        return UShortArray.m367containsxj2QHRw(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return UShort.m307boximpl(m560getMh2AYeg(r10));
    }

    /* JADX INFO: renamed from: get-Mh2AYeg, reason: not valid java name */
    public short m560getMh2AYeg(int r10) {
        return UShortArray.m371getMh2AYeg(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UShortArray.m372getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r10) {
        if ((r10 instanceof UShort) == true) goto L7;
        return -1;
    L7:
        return m561indexOfxj2QHRw(((UShort) r10).m363unboximpl());
    }

    /* JADX INFO: renamed from: indexOf-xj2QHRw, reason: not valid java name */
    public int m561indexOfxj2QHRw(short r10) {
        return ArraysKt.indexOf(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UShortArray.m374isEmptyimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r10) {
        if ((r10 instanceof UShort) == true) goto L7;
        return -1;
    L7:
        return m562lastIndexOfxj2QHRw(((UShort) r10).m363unboximpl());
    }

    /* JADX INFO: renamed from: lastIndexOf-xj2QHRw, reason: not valid java name */
    public int m562lastIndexOfxj2QHRw(short r10) {
        return ArraysKt.lastIndexOf(this.$this_asList, r10);
    }
}
