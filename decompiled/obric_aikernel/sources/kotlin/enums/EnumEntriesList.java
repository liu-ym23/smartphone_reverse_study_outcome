package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.SinceKotlin;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.8")
final class EnumEntriesList<T extends Enum<T>> extends AbstractList<T> implements EnumEntries<T>, Serializable {
    private final T[] entries;

    public EnumEntriesList(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entries");
        this.entries = r10;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.entries);
    }

    public boolean contains(T r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        if (((Enum) ArraysKt.getOrNull(this.entries, r10.ordinal())) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof Enum) == true) goto L7;
        return false;
    L7:
        return contains((Enum) r10);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int r10) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r10, this.entries.length);
        return this.entries[r10];
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return get(r10);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.entries.length;
    }

    public int indexOf(T r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        int r11 = r10.ordinal();
        if (((Enum) ArraysKt.getOrNull(this.entries, r11)) == r10) goto L7;
        return -1;
    L7:
        return r11;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r10) {
        if ((r10 instanceof Enum) == true) goto L7;
        return -1;
    L7:
        return indexOf((Enum) r10);
    }

    public int lastIndexOf(T r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        return indexOf(r10);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r10) {
        if ((r10 instanceof Enum) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((Enum) r10);
    }
}
