package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Unit;
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nSparseBooleanArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n77#1,4:97\n1#2:96\n*S KotlinDebug\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n*L\n73#1:97,4\n*E\n"})
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfKey(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsKey(SparseBooleanArray r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfKey(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsValue(SparseBooleanArray r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.indexOfValue(r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(SparseBooleanArray r10, Function2<? super Integer, ? super Boolean, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r10.keyAt(r13)), Boolean.valueOf(r10.valueAt(r13)));
        r13 = r13 + 1;
        goto L3
    }

    public static final boolean getOrDefault(SparseBooleanArray r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.get(r11, r12);
    }

    public static final boolean getOrElse(SparseBooleanArray r10, int r11, Function0<Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        int r13 = r10.indexOfKey(r11);
        if (r13 < 0) goto L6;
        return r10.valueAt(r13);
    L6:
        return r12.invoke().booleanValue();
    }

    public static final int getSize(SparseBooleanArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size();
    }

    public static final boolean isEmpty(SparseBooleanArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(SparseBooleanArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IntIterator keyIterator(final SparseBooleanArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass1(r10);
    }

    public static final SparseBooleanArray plus(SparseBooleanArray r10, SparseBooleanArray r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        SparseBooleanArray r12 = new SparseBooleanArray(r10.size() + r11.size());
        putAll(r12, r10);
        putAll(r12, r11);
        return r12;
    }

    public static final void putAll(SparseBooleanArray r10, SparseBooleanArray r11) {
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

    public static final boolean remove(SparseBooleanArray r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r13 = r10.indexOfKey(r11);
        if (r13 >= 0) goto L5;
        return false;
    L5:
        if (r12 != r10.valueAt(r13)) goto L10;
        r10.delete(r11);
        return true;
    L10:
        return false;
    }

    public static final void set(SparseBooleanArray r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.put(r11, r12);
    }

    public static final BooleanIterator valueIterator(final SparseBooleanArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new C03301(r10);
    }
}
