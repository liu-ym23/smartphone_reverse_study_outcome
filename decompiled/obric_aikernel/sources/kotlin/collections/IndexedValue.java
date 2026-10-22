package kotlin.collections;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class IndexedValue<T> {
    private final int index;
    private final T value;

    public IndexedValue(int r10, T r11) {
        this.index = r10;
        this.value = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IndexedValue copy$default(IndexedValue r10, int r11, Object r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.index;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.value;
    L9:
        return r10.copy(r11, r12);
    }

    public final int component1() {
        return this.index;
    }

    public final T component2() {
        return this.value;
    }

    public final IndexedValue<T> copy(int r10, T r11) {
        return new IndexedValue(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof IndexedValue) == true) goto L8;
        return false;
    L8:
        IndexedValue r11 = (IndexedValue) r10;
        if (this.index == r11.index) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r11.value) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int r10 = Integer.hashCode(this.index) * 31;
        T r11 = this.value;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "IndexedValue(index=" + this.index + ", value=" + this.value + ')';
    }
}
