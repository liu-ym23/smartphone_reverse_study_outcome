package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n1#1,94:1\n76#1,4:95\n*S KotlinDebug\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n72#1:95,4\n*E\n"})
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03291<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ SparseArray<T> $this_valueIterator;
        private int index;

        C03291(SparseArray<T> r10) {
            this.$this_valueIterator = r10;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_valueIterator.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArray<T> r10 = this.$this_valueIterator;
            int r11 = this.index;
            this.index = r11 + 1;
            return r10.valueAt(r11);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int r10) {
            this.index = r10;
        }
    }

    public static final <T> boolean contains(SparseArray<T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfKey(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> boolean containsKey(SparseArray<T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfKey(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> boolean containsValue(SparseArray<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfValue(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> void forEach(SparseArray<T> r10, Function2<? super Integer, ? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r10.keyAt(r13)), r10.valueAt(r13));
        r13 = r13 + 1;
        goto L3
    }

    public static final <T> T getOrDefault(SparseArray<T> r10, int r11, T r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        T r13 = r10.get(r11);
        if (r13 != null) goto L6;
        return r12;
    L6:
        return r13;
    }

    public static final <T> T getOrElse(SparseArray<T> r10, int r11, Function0<? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        T r13 = r10.get(r11);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return r12.invoke();
    }

    public static final <T> int getSize(SparseArray<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> IntIterator keyIterator(final SparseArray<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass1(r10);
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> r10, SparseArray<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        SparseArray<T> r12 = new SparseArray(r10.size() + r11.size());
        putAll(r12, r10);
        putAll(r12, r11);
        return r12;
    }

    public static final <T> void putAll(SparseArray<T> r10, SparseArray<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.put(r11.keyAt(r13), r11.valueAt(r13));
        r13 = r13 + 1;
        goto L3
    }

    public static final <T> boolean remove(SparseArray<T> r10, int r11, T r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r13 = r10.indexOfKey(r11);
        if (r13 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r12, r10.valueAt(r13)) == false) goto L10;
        r10.removeAt(r13);
        return true;
    L10:
        return false;
    }

    public static final <T> void set(SparseArray<T> r10, int r11, T r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.put(r11, r12);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new C03291(r10);
    }
}
