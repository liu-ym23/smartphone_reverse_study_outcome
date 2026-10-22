package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nSparseIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n*L\n71#1:95,4\n*E\n"})
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfKey(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsKey(SparseIntArray r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfKey(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsValue(SparseIntArray r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfValue(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(SparseIntArray r10, Function2<? super Integer, ? super Integer, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r10.keyAt(r13)), Integer.valueOf(r10.valueAt(r13)));
        r13 = r13 + 1;
        goto L3
    }

    public static final int getOrDefault(SparseIntArray r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.get(r11, r12);
    }

    public static final int getOrElse(SparseIntArray r10, int r11, Function0<Integer> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        int r13 = r10.indexOfKey(r11);
        if (r13 < 0) goto L6;
        return r10.valueAt(r13);
    L6:
        return r12.invoke().intValue();
    }

    public static final int getSize(SparseIntArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size();
    }

    public static final boolean isEmpty(SparseIntArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(SparseIntArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IntIterator keyIterator(final SparseIntArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass1(r10);
    }

    public static final SparseIntArray plus(SparseIntArray r10, SparseIntArray r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        SparseIntArray r12 = new SparseIntArray(r10.size() + r11.size());
        putAll(r12, r10);
        putAll(r12, r11);
        return r12;
    }

    public static final void putAll(SparseIntArray r10, SparseIntArray r11) {
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

    public static final boolean remove(SparseIntArray r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r13 = r10.indexOfKey(r11);
        if (r13 >= 0) goto L5;
        return false;
    L5:
        if (r12 != r10.valueAt(r13)) goto L10;
        r10.removeAt(r13);
        return true;
    L10:
        return false;
    }

    public static final void set(SparseIntArray r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.put(r11, r12);
    }

    public static final IntIterator valueIterator(final SparseIntArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new C03311(r10);
    }
}
