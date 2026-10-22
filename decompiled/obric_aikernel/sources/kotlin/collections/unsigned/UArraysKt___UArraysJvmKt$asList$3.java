package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes2.dex */
public final class UArraysKt___UArraysJvmKt$asList$3 extends AbstractList<UByte> implements RandomAccess {
    final /* synthetic */ byte[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$3(byte[] r10) {
        this.$this_asList = r10;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof UByte) == true) goto L7;
        return false;
    L7:
        return m555contains7apg3OU(((UByte) r10).m100unboximpl());
    }

    /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
    public boolean m555contains7apg3OU(byte r10) {
        return UByteArray.m104contains7apg3OU(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return UByte.m44boximpl(m556getw2LRezQ(r10));
    }

    /* JADX INFO: renamed from: get-w2LRezQ, reason: not valid java name */
    public byte m556getw2LRezQ(int r10) {
        return UByteArray.m108getw2LRezQ(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UByteArray.m109getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r10) {
        if ((r10 instanceof UByte) == true) goto L7;
        return -1;
    L7:
        return m557indexOf7apg3OU(((UByte) r10).m100unboximpl());
    }

    /* JADX INFO: renamed from: indexOf-7apg3OU, reason: not valid java name */
    public int m557indexOf7apg3OU(byte r10) {
        return ArraysKt.indexOf(this.$this_asList, r10);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UByteArray.m111isEmptyimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r10) {
        if ((r10 instanceof UByte) == true) goto L7;
        return -1;
    L7:
        return m558lastIndexOf7apg3OU(((UByte) r10).m100unboximpl());
    }

    /* JADX INFO: renamed from: lastIndexOf-7apg3OU, reason: not valid java name */
    public int m558lastIndexOf7apg3OU(byte r10) {
        return ArraysKt.lastIndexOf(this.$this_asList, r10);
    }
}
