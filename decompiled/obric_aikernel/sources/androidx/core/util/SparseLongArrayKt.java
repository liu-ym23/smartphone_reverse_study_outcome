package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nSparseLongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,125:1\n103#1,4:127\n1#2:126\n*S KotlinDebug\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n*L\n97#1:127,4\n*E\n"})
public final class SparseLongArrayKt {
    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean contains(SparseLongArray r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfKey(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean containsKey(SparseLongArray r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfKey(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean containsValue(SparseLongArray r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfValue(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void forEach(SparseLongArray r10, Function2<? super Integer, ? super Long, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r10.keyAt(r13)), Long.valueOf(r10.valueAt(r13)));
        r13 = r13 + 1;
        goto L3
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long getOrDefault(SparseLongArray r10, int r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.get(r11, r12);
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long getOrElse(SparseLongArray r10, int r11, Function0<Long> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        int r13 = r10.indexOfKey(r11);
        if (r13 < 0) goto L6;
        return r10.valueAt(r13);
    L6:
        return r12.invoke().longValue();
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final int getSize(SparseLongArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size();
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isEmpty(SparseLongArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isNotEmpty(SparseLongArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final IntIterator keyIterator(final SparseLongArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass1(r10);
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final SparseLongArray plus(SparseLongArray r10, SparseLongArray r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        SparseLongArray r12 = new SparseLongArray(r10.size() + r11.size());
        putAll(r12, r10);
        putAll(r12, r11);
        return r12;
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void putAll(SparseLongArray r10, SparseLongArray r11) {
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

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean remove(SparseLongArray r10, int r11, long r12) {
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

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void set(SparseLongArray r10, int r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.put(r11, r12);
    }

    @RequiresApi(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final LongIterator valueIterator(final SparseLongArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new C03321(r10);
    }
}
