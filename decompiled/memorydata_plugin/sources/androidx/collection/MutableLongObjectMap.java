package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J'\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\nJ\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001aH\u0086\nJ\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086\nJ\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001bH\u0086\nJ\u0017\u0010\u001c\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001d\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010#J\u001b\u0010\"\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\bH\u0002J&\u0010'\u001a\u00020\b2\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0)H\u0086\bø\u0001\u0000J\u0017\u0010*\u001a\u0004\u0018\u00018\u00002\u0006\u0010+\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0004H\u0002J\u001e\u0010/\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0004J\u0019\u00102\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\fH\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00063"}, d2 = {"Landroidx/collection/MutableLongObjectMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/collection/LongObjectMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "key", "", "findFirstAvailableSlot", "hash1", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/LongList;", "Landroidx/collection/LongSet;", "", "plusAssign", "from", "put", EventBody.KEY_VALUE, "(JLjava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(J)Ljava/lang/Object;", "", "(JLjava/lang/Object;)Z", "removeDeletedMarkers", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", "set", "(JLjava/lang/Object;)V", "trim", "writeMetadata", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableLongObjectMap<V> extends LongObjectMap<V> {
    private int growthLimit;

    public MutableLongObjectMap() {
        this(0, 1, null);
    }

    public MutableLongObjectMap(int r2) {
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

    public /* synthetic */ MutableLongObjectMap(int r1, int r2, DefaultConstructorMarker r3) {
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
        if (this.keys[r15] == r22) goto L11;
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
        this.keys = new long[r3];
        this.values = new Object[r3];
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

    private final void resizeStorage(int r23) {
        long[] r1 = this.metadata;
        long[] r2 = this.keys;
        Object[] r3 = this.values;
        int r4 = this._capacity;
        initializeStorage(r23);
        long[] r5 = this.keys;
        Object[] r6 = this.values;
        int r8 = 0;
    L3:
        if (r8 >= r4) goto L12;
        if (((r1[r8 >> 3] >> ((r8 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == false) goto L10;
        long r10 = r2[r8];
        int r13 = Long.hashCode(r10) * ScatterMapKt.MurmurHashC1;
        int r14 = r13 ^ (r13 << 16);
        int r15 = findFirstAvailableSlot(r14 >>> 7);
        int r16 = r8;
        long r7 = r14 & 127;
        long[] r17 = this.metadata;
        int r18 = r15 >> 3;
        int r19 = (r15 & 7) << 3;
        r17[r18] = (r17[r18] & (~(255 << r19))) | (r7 << r19);
        int r11 = this._capacity;
        int r12 = ((r15 - 7) & r11) + (r11 & 7);
        int r20 = r12 >> 3;
        int r21 = (r12 & 7) << 3;
        r17[r20] = (r7 << r21) | (r17[r20] & (~(255 << r21)));
        r5[r15] = r10;
        r6[r15] = r3[r16];
    L11:
        r8 = r16 + 1;
        r1 = r1;
        r2 = r2;
        goto L3
    L10:
        r16 = r8;
        goto L11
    L7:
        r9 = false;
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

    public final void clear() {
        this._size = 0;
        if (this.metadata == ScatterMapKt.EmptyGroup) goto L5;
        ArraysKt.fill$default(this.metadata, -9187201950435737472L, 0, 0, 6, null);
        long[] r1 = this.metadata;
        int r2 = this._capacity;
        int r3 = r2 >> 3;
        long r6 = 255 << ((r2 & 7) << 3);
        r1[r3] = (r1[r3] & (~r6)) | r6;
    L5:
        ArraysKt.fill(this.values, null, 0, this._capacity);
        initializeGrowth();
    }

    public final V getOrPut(long r3, Function0<? extends V> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "defaultValue");
        V r0 = get(r3);
        if (r0 != null) goto L6;
        V r1 = (V) r6.invoke();
        set(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public final void minusAssign(long r1) {
        remove(r1);
    }

    public final void minusAssign(LongList r5) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        long[] r0 = r5.content;
        int r6 = r5._size;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        remove(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void minusAssign(LongSet r14) {
        Intrinsics.checkNotNullParameter(r14, "keys");
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
        remove(r0[(r3 << 3) + r8]);
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
        Intrinsics.checkNotNullParameter(r5, "keys");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(r5[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(LongObjectMap<V> r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        putAll(r2);
    }

    public final V put(long r4, V r6) {
        int r0 = findAbsoluteInsertIndex(r4);
        V r1 = (V) this.values[r0];
        this.keys[r0] = r4;
        this.values[r0] = r6;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(LongObjectMap<V> r15) {
        Intrinsics.checkNotNullParameter(r15, "from");
        long[] r0 = r15.keys;
        Object[] r1 = r15.values;
        long[] r16 = r15.metadata;
        int r2 = r16.length - 2;
        if (r2 < 0) goto L19;
        int r4 = 0;
    L5:
        long r5 = r16[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L16;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L15;
        int r11 = (r4 << 3) + r9;
        set(r0[r11], r1[r11]);
    L15:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L16:
        if (r7 == 8) goto L17;
        return;
    L17:
        if (r4 == r2) goto L26;
        r4 = r4 + 1;
        goto L5
    L26:
        return;
    }

    public final V remove(long r18) {
        LongObjectMap r1 = (LongObjectMap) ZeusTransformUtils.preCheckCast(this, LongObjectMap.class, "com.obric.memorydata.plugin");
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
        if (r1.keys[r15] == r18) goto L16;
        r13 = r13 & (r13 - 1);
    L16:
        if (r15 >= 0) goto L18;
        return null;
    L18:
        return removeValueAt(r15);
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

    public final boolean remove(long r18, V r20) {
        LongObjectMap r1 = (LongObjectMap) ZeusTransformUtils.preCheckCast(this, LongObjectMap.class, "com.obric.memorydata.plugin");
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
        if (r1.keys[r15] == r18) goto L16;
        r13 = r13 & (r13 - 1);
    L16:
        if (r15 >= 0) goto L18;
    L21:
        return false;
    L18:
        if (Intrinsics.areEqual(this.values[r15], r20) == false) goto L21;
        removeValueAt(r15);
        return true;
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

    public final void removeIf(Function2<? super Long, ? super V, Boolean> r15) {
        Function2 r16 = (Function2) ZeusTransformUtils.wrapperContextForParams(r15, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "predicate");
        long[] r0 = ((LongObjectMap) ZeusTransformUtils.preCheckCast(this, LongObjectMap.class, "com.obric.memorydata.plugin")).metadata;
        int r2 = r0.length - 2;
        if (r2 < 0) goto L21;
        int r4 = 0;
    L5:
        long r5 = r0[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L18;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L17;
        int r11 = (r4 << 3) + r9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16.invoke(Long.valueOf(this.keys[r11]), this.values[r11]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        removeValueAt(r11);
    L17:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L18:
        if (r7 == 8) goto L19;
        return;
    L19:
        if (r4 == r2) goto L29;
        r4 = r4 + 1;
        goto L5
    L29:
        return;
    }

    public final V removeValueAt(int r12) {
        this._size--;
        long[] r0 = this.metadata;
        int r1 = r12 >> 3;
        int r2 = (r12 & 7) << 3;
        r0[r1] = (r0[r1] & (~(255 << r2))) | (254 << r2);
        int r3 = this._capacity;
        int r4 = ((r12 - 7) & r3) + (r3 & 7);
        int r5 = r4 >> 3;
        int r6 = (r4 & 7) << 3;
        r0[r5] = (r0[r5] & (~(255 << r6))) | (254 << r6);
        V r7 = (V) this.values[r12];
        this.values[r12] = null;
        return r7;
    }

    public final void set(long r3, V r5) {
        int r0 = findAbsoluteInsertIndex(r3);
        this.keys[r0] = r3;
        this.values[r0] = r5;
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
