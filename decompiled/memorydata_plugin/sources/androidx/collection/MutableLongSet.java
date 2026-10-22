package androidx.collection;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\b\u0010 \u001a\u00020\u0003H\u0007J\u0019\u0010!\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\tH\u0082\bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/collection/MutableLongSet;", "Landroidx/collection/LongSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "", "addAll", "elements", "", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "plusAssign", "remove", "removeAll", "removeDeletedMarkers", "removeElementAt", "index", "resizeStorage", "newCapacity", "trim", "writeMetadata", EventBody.KEY_VALUE, "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableLongSet extends LongSet {
    private int growthLimit;

    public MutableLongSet() {
        this(0, 1, null);
    }

    public MutableLongSet(int r2) {
        super(null);
        if (r2 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        initializeStorage(ScatterMapKt.unloadedCapacity(r2));
        return;
    L10:
        throw new IllegalArgumentException("Capacity must be a positive value.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public /* synthetic */ MutableLongSet(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 6;
    L5:
        this(r1);
    }

    private final void adjustStorage() {
        if (this._capacity > 8) goto L5;
    L7:
        resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        return;
    L5:
        if (Long.compareUnsigned(ULong.m1595constructorimpl(ULong.m1595constructorimpl(this._size) * 32), ULong.m1595constructorimpl(ULong.m1595constructorimpl(this._capacity) * 25)) > 0) goto L7;
        removeDeletedMarkers();
    }

    private final int findAbsoluteInsertIndex(long r22) {
        int r1 = Long.hashCode(r22) * ScatterMapKt.MurmurHashC1;
        int r2 = r1 ^ (r1 << 16);
        int r3 = r2 >>> 7;
        int r4 = r2 & 127;
        int r5 = this._capacity;
        int r6 = r3 & r5;
        int r7 = 0;
    L3:
        long[] r8 = this.metadata;
        int r9 = r6 >> 3;
        int r10 = (r6 & 7) << 3;
        long r11 = ((r8[r9 + 1] << (64 - r10)) & ((-r10) >> 63)) | (r8[r9] >>> r10);
        long r12 = r4;
        int r17 = r7;
        long r13 = r11 ^ (r12 * ScatterMapKt.BitmaskLsb);
        long r14 = ((~r13) & (r13 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r14 == 0) goto L7;
        boolean r18 = true;
    L8:
        if (r18 == false) goto L14;
        int r15 = ((Long.numberOfTrailingZeros(r14) >> 3) + r6) & r5;
        if (this.elements[r15] == r22) goto L11;
        r14 = r14 & (r14 - 1);
        goto L5
    L11:
        return r15;
    L14:
        if (((((~r11) << 6) & r11) & (-9187201950435737472L)) != 0) goto L15;
        r7 = r17 + 8;
        r6 = (r6 + r7) & r5;
        goto L3
    L15:
        int r16 = findFirstAvailableSlot(r3);
        if (this.growthLimit == 0) goto L18;
    L23:
        this._size++;
        int r19 = this.growthLimit;
        int r20 = r16 >> 3;
        int r21 = (r16 & 7) << 3;
        if (((this.metadata[r20] >> r21) & 255) != 128) goto L26;
        int r110 = 1;
    L27:
        this.growthLimit = r19 - r110;
        long[] r23 = this.metadata;
        r23[r20] = (r23[r20] & (~(255 << r21))) | (r12 << r21);
        int r0 = this._capacity;
        int r24 = ((r16 - 7) & r0) + (r0 & 7);
        int r25 = r24 >> 3;
        int r26 = (r24 & 7) << 3;
        r23[r25] = ((~(255 << r26)) & r23[r25]) | (r12 << r26);
        return r16;
    L26:
        r110 = 0;
        goto L27
    L18:
        if (((this.metadata[r16 >> 3] >> ((r16 & 7) << 3)) & 255) != 254) goto L20;
        boolean r27 = true;
    L21:
        if (r27 == true) goto L23;
        adjustStorage();
        r16 = findFirstAvailableSlot(r3);
        goto L23
    L20:
        r27 = false;
        goto L21
    L7:
        r18 = false;
        goto L8
    }

    private final int findFirstAvailableSlot(int r10) {
        int r0 = this._capacity;
        int r11 = r10 & r0;
        int r1 = 0;
    L3:
        long[] r2 = this.metadata;
        int r3 = r11 >> 3;
        int r4 = (r11 & 7) << 3;
        long r5 = ((r2[r3 + 1] << (64 - r4)) & ((-r4) >> 63)) | (r2[r3] >>> r4);
        long r6 = (r5 & ((~r5) << 7)) & (-9187201950435737472L);
        if (r6 != 0) goto L6;
        r1 = r1 + 8;
        r11 = (r11 + r1) & r0;
        goto L3
    L6:
        return (r11 + (Long.numberOfTrailingZeros(r6) >> 3)) & r0;
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    private final void initializeMetadata(int r9) {
        if (r9 != 0) goto L4;
        long[] r0 = ScatterMapKt.EmptyGroup;
    L5:
        this.metadata = r0;
        long[] r1 = this.metadata;
        int r2 = r9 >> 3;
        long r4 = 255 << ((r9 & 7) << 3);
        r1[r2] = (r1[r2] & (~r4)) | r4;
        initializeGrowth();
        return;
    L4:
        r0 = new long[((((r9 + 1) + 7) + 7) & (-8)) >> 3];
        ArraysKt.fill$default(r0, -9187201950435737472L, 0, 0, 6, null);
        goto L5
    }

    private final void initializeStorage(int r2) {
        if (r2 <= 0) goto L4;
        int r3 = Math.max(7, ScatterMapKt.normalizeCapacity(r2));
    L5:
        this._capacity = r3;
        initializeMetadata(r3);
        this.elements = new long[r3];
        return;
    L4:
        r3 = 0;
        goto L5
    }

    private final void removeDeletedMarkers() {
        long[] r0 = this.metadata;
        int r1 = this._capacity;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L8;
        int r4 = r2 >> 3;
        int r7 = (r2 & 7) << 3;
        if (((r0[r4] >> r7) & 255) != 254) goto L7;
        long[] r10 = this.metadata;
        r10[r4] = (r10[r4] & (~(255 << r7))) | (128 << r7);
        int r5 = this._capacity;
        int r8 = ((r2 - 7) & r5) + (r5 & 7);
        int r6 = r8 >> 3;
        int r9 = (r8 & 7) << 3;
        long r11 = 128 << r9;
        r10[r6] = r11 | ((~(255 << r9)) & r10[r6]);
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        this.growthLimit += r3;
    }

    private final void removeElementAt(int r12) {
        this._size--;
        long[] r0 = this.metadata;
        int r1 = r12 >> 3;
        int r2 = (r12 & 7) << 3;
        r0[r1] = (r0[r1] & (~(255 << r2))) | (254 << r2);
        int r11 = this._capacity;
        int r13 = ((r12 - 7) & r11) + (r11 & 7);
        int r14 = r13 >> 3;
        int r15 = (r13 & 7) << 3;
        r0[r14] = (r0[r14] & (~(255 << r15))) | (254 << r15);
    }

    private final void resizeStorage(int r21) {
        long[] r1 = this.metadata;
        long[] r2 = this.elements;
        int r3 = this._capacity;
        initializeStorage(r21);
        long[] r4 = this.elements;
        int r6 = 0;
    L3:
        if (r6 >= r3) goto L12;
        if (((r1[r6 >> 3] >> ((r6 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L11;
        long r8 = r2[r6];
        int r11 = Long.hashCode(r8) * ScatterMapKt.MurmurHashC1;
        int r12 = r11 ^ (r11 << 16);
        int r13 = findFirstAvailableSlot(r12 >>> 7);
        long r14 = r12 & 127;
        long[] r15 = this.metadata;
        int r16 = r13 >> 3;
        int r17 = (r13 & 7) << 3;
        r15[r16] = (r15[r16] & (~(255 << r17))) | (r14 << r17);
        int r5 = this._capacity;
        int r9 = ((r13 - 7) & r5) + (r5 & 7);
        int r10 = r9 >> 3;
        int r18 = (r9 & 7) << 3;
        r15[r10] = ((~(255 << r18)) & r15[r10]) | (r14 << r18);
        r4[r13] = r8;
    L11:
        r6 = r6 + 1;
        goto L3
    L7:
        r7 = false;
        goto L8
    }

    private final void writeMetadata(int r10, long r11) {
        long[] r0 = this.metadata;
        int r1 = r10 >> 3;
        int r2 = (r10 & 7) << 3;
        r0[r1] = (r0[r1] & (~(255 << r2))) | (r11 << r2);
        int r9 = this._capacity;
        int r12 = ((r10 - 7) & r9) + (r9 & 7);
        int r13 = r12 >> 3;
        int r14 = (r12 & 7) << 3;
        r0[r13] = (r11 << r14) | (r0[r13] & (~(255 << r14)));
    }

    public final boolean add(long r4) {
        int r0 = this._size;
        int r1 = findAbsoluteInsertIndex(r4);
        this.elements[r1] = r4;
        if (this._size == r0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(LongSet r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(long[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void clear() {
        this._size = 0;
        if (this.metadata == ScatterMapKt.EmptyGroup) goto L5;
        ArraysKt.fill$default(this.metadata, -9187201950435737472L, 0, 0, 6, null);
        long[] r0 = this.metadata;
        int r1 = this._capacity;
        int r2 = r1 >> 3;
        long r5 = 255 << ((r1 & 7) << 3);
        r0[r2] = (r0[r2] & (~r5)) | r5;
    L5:
        initializeGrowth();
    }

    public final void minusAssign(long r18) {
        LongSet r1 = (LongSet) ZeusTransformUtils.preCheckCast(this, LongSet.class, "com.obric.memorydata.plugin");
        int r2 = Long.hashCode(r18) * ScatterMapKt.MurmurHashC1;
        int r3 = r2 ^ (r2 << 16);
        int r4 = r3 & 127;
        int r5 = r1._capacity;
        int r6 = (r3 >>> 7) & r5;
        int r7 = 0;
    L3:
        long[] r8 = r1.metadata;
        int r9 = r6 >> 3;
        int r10 = (r6 & 7) << 3;
        long r11 = ((r8[r9 + 1] << (64 - r10)) & ((-r10) >> 63)) | (r8[r9] >>> r10);
        long r12 = (((long) r4) * ScatterMapKt.BitmaskLsb) ^ r11;
        long r13 = ((~r12) & (r12 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r13 == 0) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == false) goto L14;
        int r15 = ((Long.numberOfTrailingZeros(r13) >> 3) + r6) & r5;
        if (r1.elements[r15] == r18) goto L16;
        r13 = r13 & (r13 - 1);
    L16:
        if (r15 < 0) goto L23;
        removeElementAt(r15);
        return;
    L23:
        return;
    L14:
        if (((r11 & ((~r11) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r7 = r7 + 8;
        r6 = (r6 + r7) & r5;
        goto L3
    L15:
        r15 = -1;
        goto L16
    L7:
        r14 = false;
        goto L8
    }

    public final void minusAssign(LongSet r14) {
        Intrinsics.checkNotNullParameter(r14, "elements");
        long[] r0 = r14.elements;
        long[] r15 = r14.metadata;
        int r1 = r15.length - 2;
        if (r1 < 0) goto L19;
        int r3 = 0;
    L5:
        long r4 = r15[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L16;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        minusAssign(r0[(r3 << 3) + r8]);
    L15:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L16:
        if (r6 == 8) goto L17;
        return;
    L17:
        if (r3 == r1) goto L26;
        r3 = r3 + 1;
        goto L5
    L26:
        return;
    }

    public final void minusAssign(long[] r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        minusAssign(r5[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(long r2) {
        int r0 = findAbsoluteInsertIndex(r2);
        this.elements[r0] = r2;
    }

    public final void plusAssign(LongSet r14) {
        Intrinsics.checkNotNullParameter(r14, "elements");
        long[] r0 = r14.elements;
        long[] r15 = r14.metadata;
        int r1 = r15.length - 2;
        if (r1 < 0) goto L19;
        int r3 = 0;
    L5:
        long r4 = r15[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L16;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        plusAssign(r0[(r3 << 3) + r8]);
    L15:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L16:
        if (r6 == 8) goto L17;
        return;
    L17:
        if (r3 == r1) goto L26;
        r3 = r3 + 1;
        goto L5
    L26:
        return;
    }

    public final void plusAssign(long[] r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        plusAssign(r5[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final boolean remove(long r18) {
        LongSet r1 = (LongSet) ZeusTransformUtils.preCheckCast(this, LongSet.class, "com.obric.memorydata.plugin");
        int r2 = Long.hashCode(r18) * ScatterMapKt.MurmurHashC1;
        int r3 = r2 ^ (r2 << 16);
        int r4 = r3 & 127;
        int r5 = r1._capacity;
        int r6 = (r3 >>> 7) & r5;
        boolean r7 = false;
        int r8 = 0;
    L3:
        long[] r9 = r1.metadata;
        int r10 = r6 >> 3;
        int r11 = (r6 & 7) << 3;
        long r12 = ((r9[r10 + 1] << (64 - r11)) & ((-r11) >> 63)) | (r9[r10] >>> r11);
        long r13 = (((long) r4) * ScatterMapKt.BitmaskLsb) ^ r12;
        long r14 = ((~r13) & (r13 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r14 == 0) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == false) goto L14;
        int r16 = ((Long.numberOfTrailingZeros(r14) >> 3) + r6) & r5;
        if (r1.elements[r16] == r18) goto L16;
        r14 = r14 & (r14 - 1);
    L16:
        if (r16 < 0) goto L18;
        r7 = true;
    L18:
        if (r7 == false) goto L20;
        removeElementAt(r16);
    L20:
        return r7;
    L14:
        if (((r12 & ((~r12) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r8 = r8 + 8;
        r6 = (r6 + r8) & r5;
        goto L3
    L15:
        r16 = -1;
        goto L16
    L7:
        r15 = false;
        goto L8
    }

    public final boolean removeAll(LongSet r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        minusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(long[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        minusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final int trim() {
        int r0 = this._capacity;
        int r1 = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (r1 >= r0) goto L6;
        resizeStorage(r1);
        return r0 - this._capacity;
    L6:
        return 0;
    }
}
