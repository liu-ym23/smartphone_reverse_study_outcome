package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.WeakReference;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\"J\r\u0010#\u001a\u00020\u0019H\u0000¢\u0006\u0002\b$J \u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190(H\u0086\bø\u0001\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00120\u0011X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "hashes", "", "getHashes$runtime_release", "()[I", "setHashes$runtime_release", "([I)V", "size", "", "getSize$runtime_release", "()I", "setSize$runtime_release", "(I)V", "values", "", "Landroidx/compose/runtime/WeakReference;", "getValues$runtime_release", "()[Landroidx/compose/runtime/WeakReference;", "setValues$runtime_release", "([Landroidx/compose/runtime/WeakReference;)V", "[Landroidx/compose/runtime/WeakReference;", "add", "", "value", "(Ljava/lang/Object;)Z", "find", "hash", "(Ljava/lang/Object;I)I", "findExactIndex", "midIndex", "valueHash", "(ILjava/lang/Object;I)I", "isValid", "isValid$runtime_release", "removeIf", "", "block", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotWeakSet<T> {
    private int[] hashes;
    private int size;
    private WeakReference<T>[] values;

    public SnapshotWeakSet() {
        this.hashes = new int[16];
        this.values = new WeakReference[16];
    }

    private final int find(T r5, int r10) {
        int r11 = this.size - 1;
        int r12 = 0;
    L3:
        if (r12 > r11) goto L18;
        int r13 = (r12 + r11) >>> 1;
        int r14 = this.hashes[r13];
        if (r14 < r10) goto L6;
        if (r14 <= r10) goto L9;
        r11 = r13 - 1;
        goto L3
    L9:
        WeakReference<T> r15 = this.values[r13];
        if (r15 == null) goto L12;
        T r16 = r15.get();
    L13:
        if (r5 != r16) goto L16;
        return r13;
    L16:
        return findExactIndex(r13, r5, r10);
    L12:
        r16 = null;
        goto L13
    L6:
        r12 = r13 + 1;
        goto L3
    L18:
        return -(r12 + 1);
    }

    private final int findExactIndex(int r5, T r10, int r11) {
        int r12 = r5 - 1;
    L3:
        T r13 = null;
        if ((-1) >= r12) goto L14;
        if (this.hashes[r12] != r11) goto L14;
        WeakReference<T> r14 = this.values[r12];
        if (r14 == null) goto L11;
        r13 = r14.get();
    L11:
        if (r13 == r10) goto L12;
        r12 = r12 - 1;
        goto L3
    L12:
        return r12;
    L14:
        int r15 = r5 + 1;
        int r16 = this.size;
    L15:
        if (r15 >= r16) goto L28;
        if (this.hashes[r15] != r11) goto L19;
        WeakReference<T> r17 = this.values[r15];
        if (r17 == null) goto L23;
        T r18 = r17.get();
    L24:
        if (r18 == r10) goto L25;
        r15 = r15 + 1;
        goto L15
    L25:
        return r15;
    L23:
        r18 = null;
        goto L24
    L19:
        return -(r15 + 1);
    L28:
        return -(this.size + 1);
    }

    public final boolean add(T r11) {
        Intrinsics.checkNotNullParameter(r11, "value");
        int r5 = this.size;
        int r10 = ActualJvm_jvmKt.identityHashCode(r11);
        if (r5 <= 0) goto L7;
        int r12 = find(r11, r10);
        if (r12 < 0) goto L8;
        return false;
    L8:
        int r13 = -(r12 + 1);
        WeakReference<T>[] r14 = this.values;
        int r15 = r14.length;
        if (r5 != r15) goto L11;
        int r16 = r15 * 2;
        WeakReference<T>[] r17 = new WeakReference[r16];
        int[] r18 = new int[r16];
        int r19 = r13 + 1;
        ArraysKt.copyInto(r14, r17, r19, r13, r5);
        ArraysKt.f(this.values, r17, 0, r13, 6);
        ArraysKt.a(r19, r13, this.hashes, r18, r5);
        ArraysKt.d(r13, 6, this.hashes, r18);
        this.values = r17;
        this.hashes = r18;
    L12:
        this.values[r13] = new WeakReference(r11);
        this.hashes[r13] = r10;
        this.size++;
        return true;
    L11:
        int r20 = r13 + 1;
        ArraysKt.copyInto(r14, r14, r20, r13, r5);
        int[] r21 = this.hashes;
        ArraysKt.a(r20, r13, r21, r21, r5);
        goto L12
    L7:
        r12 = -1;
        goto L8
    }

    public final int[] getHashes$runtime_release() {
        return this.hashes;
    }

    public final int getSize$runtime_release() {
        return this.size;
    }

    public final WeakReference<T>[] getValues$runtime_release() {
        return this.values;
    }

    public final boolean isValid$runtime_release() {
        int r5 = this.size;
        WeakReference<T>[] r10 = this.values;
        int[] r11 = this.hashes;
        int r12 = r10.length;
        if (r5 <= r12) goto L5;
        return false;
    L5:
        int r13 = Integer.MIN_VALUE;
        int r14 = 0;
    L6:
        if (r14 >= r5) goto L19;
        int r15 = r11[r14];
        if (r15 < r13) goto L9;
        WeakReference<T> r16 = r10[r14];
        if (r16 == null) goto L12;
        T r17 = r16.get();
        if (r17 == null) goto L18;
        if (r15 == ActualJvm_jvmKt.identityHashCode(r17)) goto L18;
        return false;
    L18:
        r14 = r14 + 1;
        r13 = r15;
        goto L6
    L12:
        return false;
    L9:
        return false;
    L19:
        if (r5 >= r12) goto L27;
        if (r11[r5] != 0) goto L22;
        if (r10[r5] != null) goto L25;
        r5 = r5 + 1;
        goto L19
    L25:
        return false;
    L22:
        return false;
    L27:
        return true;
    }

    public final void removeIf(Function1<? super T, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        int r5 = getSize$runtime_release();
        int r11 = 0;
        int r12 = 0;
    L3:
        T r13 = null;
        if (r11 >= r5) goto L15;
        WeakReference<T> r14 = getValues$runtime_release()[r11];
        if (r14 == null) goto L8;
        r13 = r14.get();
    L8:
        if (r13 == null) goto L14;
        if (r10.invoke(r13).booleanValue() == true) goto L14;
        if (r12 == r11) goto L13;
        getValues$runtime_release()[r12] = r14;
        getHashes$runtime_release()[r12] = getHashes$runtime_release()[r11];
    L13:
        r12 = r12 + 1;
    L14:
        r11 = r11 + 1;
        goto L3
    L15:
        int r15 = r12;
    L16:
        if (r15 >= r5) goto L18;
        getValues$runtime_release()[r15] = null;
        getHashes$runtime_release()[r15] = 0;
        r15 = r15 + 1;
        goto L16
    L18:
        if (r12 == r5) goto L26;
        setSize$runtime_release(r12);
        return;
    }

    public final void setHashes$runtime_release(int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.hashes = r5;
    }

    public final void setSize$runtime_release(int r5) {
        this.size = r5;
    }

    public final void setValues$runtime_release(WeakReference<T>[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.values = r5;
    }
}
