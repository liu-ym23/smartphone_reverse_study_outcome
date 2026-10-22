package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nLongSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n1#1,132:1\n104#1,4:133\n*S KotlinDebug\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n98#1:133,4\n*E\n"})
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03281<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        C03281(LongSparseArray<T> r10) {
            this.$this_valueIterator = r10;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        @SuppressLint({"ClassVerificationFailure"})
        public boolean hasNext() {
            if (this.index >= this.$this_valueIterator.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        @SuppressLint({"ClassVerificationFailure"})
        public T next() {
            LongSparseArray<T> r10 = this.$this_valueIterator;
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

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean contains(LongSparseArray<T> r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfKey(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean containsKey(LongSparseArray<T> r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfKey(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean containsValue(LongSparseArray<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfValue(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> void forEach(LongSparseArray<T> r10, Function2<? super Long, ? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Long.valueOf(r10.keyAt(r13)), r10.valueAt(r13));
        r13 = r13 + 1;
        goto L3
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> T getOrDefault(LongSparseArray<T> r10, long r11, T r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        T r13 = r10.get(r11);
        if (r13 != null) goto L6;
        return r12;
    L6:
        return r13;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> T getOrElse(LongSparseArray<T> r10, long r11, Function0<? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        T r13 = r10.get(r11);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return r12.invoke();
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> int getSize(LongSparseArray<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size();
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean isEmpty(LongSparseArray<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean isNotEmpty(LongSparseArray<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(16)
    public static final <T> LongIterator keyIterator(final LongSparseArray<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass1(r10);
    }

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> r10, LongSparseArray<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        LongSparseArray<T> r12 = new LongSparseArray(r10.size() + r11.size());
        putAll(r12, r10);
        putAll(r12, r11);
        return r12;
    }

    @RequiresApi(16)
    public static final <T> void putAll(LongSparseArray<T> r10, LongSparseArray<T> r11) {
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

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean remove(LongSparseArray<T> r10, long r11, T r12) {
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

    @RequiresApi(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> void set(LongSparseArray<T> r10, long r11, T r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.put(r11, r12);
    }

    @RequiresApi(16)
    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new C03281(r10);
    }
}
