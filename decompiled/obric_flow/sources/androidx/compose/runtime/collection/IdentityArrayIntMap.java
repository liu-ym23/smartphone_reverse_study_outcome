package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\tJ&\u0010\u0014\u001a\u00020\u00152\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\tH\u0002J&\u0010\u001c\u001a\u00020\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001d0\u0017H\u0086\bø\u0001\u0000J\u0011\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0001H\u0086\u0002J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0001J&\u0010!\u001a\u00020\u001d2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000R0\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "", "()V", "<set-?>", "", "keys", "getKeys", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "", "size", "getSize", "()I", "", "values", "getValues", "()[I", "add", STGroup.DICT_KEY, "value", "any", "", "predicate", "Lkotlin/Function2;", "find", "findExactIndex", "midIndex", "valueHash", "forEach", "", "block", "get", "remove", "removeValueIf", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IdentityArrayIntMap {
    private Object[] keys;
    private int size;
    private int[] values;

    public IdentityArrayIntMap() {
        this.keys = new Object[4];
        this.values = new int[4];
    }

    public static final /* synthetic */ void access$setSize$p(IdentityArrayIntMap r5, int r10) {
        r5.size = r10;
    }

    private final int find(Object r10) {
        int r5 = this.size - 1;
        int r11 = ActualJvm_jvmKt.identityHashCode(r10);
        Object[] r12 = this.keys;
        int r13 = 0;
    L3:
        if (r13 > r5) goto L14;
        int r14 = (r13 + r5) >>> 1;
        Object r15 = r12[r14];
        int r16 = ActualJvm_jvmKt.identityHashCode(r15);
        if (r16 < r11) goto L6;
        if (r16 <= r11) goto L9;
        r5 = r14 - 1;
        goto L3
    L9:
        if (r15 != r10) goto L12;
        return r14;
    L12:
        return findExactIndex(r14, r10, r11);
    L6:
        r13 = r14 + 1;
        goto L3
    L14:
        return -(r13 + 1);
    }

    private final int findExactIndex(int r5, Object r10, int r11) {
        Object[] r12 = this.keys;
        int r13 = this.size;
        int r14 = r5 - 1;
    L4:
        if ((-1) >= r14) goto L12;
        Object r15 = r12[r14];
        if (r15 == r10) goto L7;
        if (ActualJvm_jvmKt.identityHashCode(r15) != r11) goto L12;
        r14 = r14 - 1;
        goto L4
    L7:
        return r14;
    L12:
        r5 = r5 + 1;
        if (r5 >= r13) goto L22;
        Object r16 = r12[r5];
        if (r16 == r10) goto L16;
        if (ActualJvm_jvmKt.identityHashCode(r16) == r11) goto L12;
        return -(r5 + 1);
    L16:
        return r5;
    L22:
        return -(r13 + 1);
    }

    public final int add(Object r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        int[] r5 = this.values;
        if (this.size <= 0) goto L8;
        int r12 = find(r10);
        if (r12 < 0) goto L9;
        int r13 = r5[r12];
        r5[r12] = r11;
        return r13;
    L9:
        int r14 = -(r12 + 1);
        Object[] r15 = this.keys;
        int r16 = this.size;
        if (r16 != r15.length) goto L12;
        Object[] r17 = new Object[r15.length * 2];
        int[] r18 = new int[r15.length * 2];
        int r19 = r14 + 1;
        ArraysKt.copyInto(r15, r17, r19, r14, r16);
        ArraysKt.a(r19, r14, r5, r18, r16);
        ArraysKt.f(r15, r17, 0, r14, 6);
        ArraysKt.d(r14, 6, r5, r18);
        this.keys = r17;
        this.values = r18;
    L13:
        this.keys[r14] = r10;
        this.values[r14] = r11;
        this.size++;
        return -1;
    L12:
        int r20 = r14 + 1;
        ArraysKt.copyInto(r15, r15, r20, r14, r16);
        ArraysKt.a(r20, r14, r5, r5, r16);
        goto L13
    L8:
        r12 = -1;
        goto L9
    }

    public final boolean any(Function2<Object, ? super Integer, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "predicate");
        Object[] r5 = getKeys();
        int[] r11 = getValues();
        int r12 = getSize();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        Object r14 = r5[r13];
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Any");
        if (r10.mo2invoke(r14, Integer.valueOf(r11[r13])).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final void forEach(Function2<Object, ? super Integer, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        Object[] r5 = getKeys();
        int[] r11 = getValues();
        int r12 = getSize();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Object r14 = r5[r13];
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Any");
        r10.mo2invoke(r14, Integer.valueOf(r11[r13]));
        r13 = r13 + 1;
        goto L3
    }

    public final int get(Object r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        int r10 = find(r5);
        if (r10 < 0) goto L7;
        return this.values[r10];
    L7:
        throw new IllegalStateException("Key not found");
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public final int getSize() {
        return this.size;
    }

    public final int[] getValues() {
        return this.values;
    }

    public final boolean remove(Object r10) {
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        int r11 = find(r10);
        Object[] r5 = this.keys;
        int[] r12 = this.values;
        int r13 = this.size;
        if (r11 < 0) goto L9;
        int r14 = r13 - 1;
        if (r11 >= r14) goto L7;
        int r15 = r11 + 1;
        ArraysKt.copyInto(r5, r5, r11, r15, r13);
        ArraysKt.a(r11, r15, r12, r12, r13);
    L7:
        r5[r14] = null;
        this.size = r14;
        return true;
    L9:
        return false;
    }

    public final void removeValueIf(Function2<Object, ? super Integer, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "predicate");
        Object[] r5 = getKeys();
        int[] r11 = getValues();
        int r12 = getSize();
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L10;
        Object r15 = r5[r13];
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Any");
        int r16 = r11[r13];
        if (r10.mo2invoke(r15, Integer.valueOf(r16)).booleanValue() == true) goto L9;
        if (r14 == r13) goto L8;
        r5[r14] = r15;
        r11[r14] = r16;
    L8:
        r14 = r14 + 1;
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        int r17 = r14;
    L11:
        if (r17 >= r12) goto L13;
        r5[r17] = null;
        r17 = r17 + 1;
        goto L11
    L13:
        access$setSize$p(this, r14);
    }
}
