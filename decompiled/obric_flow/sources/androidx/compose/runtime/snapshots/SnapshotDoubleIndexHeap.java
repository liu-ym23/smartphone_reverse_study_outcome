package androidx.compose.runtime.snapshots;

import ai.j0;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "", "()V", "firstFreeHandle", "", "handles", "", "index", "<set-?>", "size", "getSize", "()I", "values", "add", "value", "allocateHandle", "ensure", "", "atLeast", "freeHandle", "handle", "lowestOrDefault", "default", "remove", "shiftDown", "shiftUp", "swap", "a", "b", "validate", "validateHandle", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotDoubleIndexHeap {
    private int firstFreeHandle;
    private int[] handles;
    private int[] index;
    private int size;
    private int[] values;

    public SnapshotDoubleIndexHeap() {
        this.values = new int[16];
        this.index = new int[16];
        int[] r5 = new int[16];
        int r10 = 0;
    L3:
        if (r10 >= 16) goto L5;
        int r11 = r10 + 1;
        r5[r10] = r11;
        r10 = r11;
        goto L3
    L5:
        this.handles = r5;
    }

    private final int allocateHandle() {
        int r5 = this.handles.length;
        if (this.firstFreeHandle < r5) goto L8;
        int r10 = r5 * 2;
        int[] r11 = new int[r10];
        int r12 = 0;
    L5:
        if (r12 >= r10) goto L7;
        int r13 = r12 + 1;
        r11[r12] = r13;
        r12 = r13;
        goto L5
    L7:
        ArraysKt.d(0, 14, this.handles, r11);
        this.handles = r11;
    L8:
        int r14 = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[r14];
        return r14;
    }

    private final void ensure(int r5) {
        int[] r10 = this.values;
        int r11 = r10.length;
        if (r5 > r11) goto L5;
        return;
    L5:
        int r12 = r11 * 2;
        int[] r13 = new int[r12];
        int[] r14 = new int[r12];
        ArraysKt.d(0, 14, r10, r13);
        ArraysKt.d(0, 14, this.index, r14);
        this.values = r13;
        this.index = r14;
    }

    private final void freeHandle(int r5) {
        this.handles[r5] = this.firstFreeHandle;
        this.firstFreeHandle = r5;
    }

    public static /* synthetic */ int lowestOrDefault$default(SnapshotDoubleIndexHeap r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        return r5.lowestOrDefault(r10);
    }

    private final void shiftDown(int r10) {
        int[] r5 = this.values;
        int r11 = this.size >> 1;
    L3:
        if (r10 >= r11) goto L15;
        int r12 = (r10 + 1) << 1;
        int r13 = r12 - 1;
        if (r12 >= this.size) goto L13;
        int r14 = r5[r12];
        if (r14 >= r5[r13]) goto L13;
        if (r14 >= r5[r10]) goto L11;
        swap(r12, r10);
        r10 = r12;
        goto L3
    L11:
        return;
    L13:
        if (r5[r13] >= r5[r10]) goto L25;
        swap(r13, r10);
        r10 = r13;
        goto L3
    L25:
        return;
    }

    private final void shiftUp(int r5) {
        int[] r10 = this.values;
        int r11 = r10[r5];
    L3:
        if (r5 <= 0) goto L7;
        int r12 = ((r5 + 1) >> 1) - 1;
        if (r10[r12] <= r11) goto L10;
        swap(r12, r5);
        r5 = r12;
        goto L3
    L10:
        return;
    }

    private final void swap(int r5, int r10) {
        int[] r11 = this.values;
        int[] r12 = this.index;
        int[] r13 = this.handles;
        int r14 = r11[r5];
        r11[r5] = r11[r10];
        r11[r10] = r14;
        int r15 = r12[r5];
        r12[r5] = r12[r10];
        r12[r10] = r15;
        r13[r12[r5]] = r5;
        r13[r12[r10]] = r10;
    }

    public final int add(int r5) {
        ensure(this.size + 1);
        int r10 = this.size;
        this.size = r10 + 1;
        int r11 = allocateHandle();
        this.values[r10] = r5;
        this.index[r10] = r11;
        this.handles[r11] = r10;
        shiftUp(r10);
        return r11;
    }

    public final int getSize() {
        return this.size;
    }

    public final int lowestOrDefault(int r5) {
        if (this.size > 0) goto L5;
        return r5;
    L5:
        return this.values[0];
    }

    public final void remove(int r5) {
        int r10 = this.handles[r5];
        swap(r10, this.size - 1);
        this.size--;
        shiftUp(r10);
        shiftDown(r10);
        freeHandle(r5);
    }

    public final void validate() {
        int r5 = this.size;
        int r10 = 1;
    L3:
        if (r10 >= r5) goto L9;
        int r11 = r10 + 1;
        int[] r12 = this.values;
        if (r12[(r11 >> 1) - 1] > r12[r10]) goto L8;
        r10 = r11;
        goto L3
    L8:
        throw new IllegalStateException(("Index " + r10 + " is out of place").toString());
    }

    public final void validateHandle(int r5, int r10) {
        int r11 = this.handles[r5];
        if (this.index[r11] != r5) goto L10;
        if (this.values[r11] != r10) goto L7;
        return;
    L7:
        StringBuilder r12 = j0.s(r5, "Value for handle ", " was ");
        r12.append(this.values[r11]);
        r12.append(" but was supposed to be ");
        r12.append(r10);
        throw new IllegalStateException(r12.toString().toString());
    L10:
        throw new IllegalStateException(("Index for handle " + r5 + " is corrupted").toString());
    }
}
