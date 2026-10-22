package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u00011B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rJ\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u001b\u0010\u000b\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010J\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015J\u0006\u0010\u0016\u001a\u00020\u0013J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010\u001f\u001a\u00020\u00132\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010 J\u0017\u0010\u001f\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0086\u0002J\u0017\u0010\u001f\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u001e\u0010\u001f\u001a\u00020\u00132\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0002\u0010!J\u0017\u0010\u001f\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0086\u0002J\u0017\u0010\u001f\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\u0002J\u0016\u0010\"\u001a\u00020\u00132\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010 J\u0017\u0010\"\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0086\u0002J\u0017\u0010\"\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u001e\u0010\"\u001a\u00020\u00132\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0086\u0002J\u0017\u0010\"\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\u0002J\u0013\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010$\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rJ\u0014\u0010$\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u001b\u0010$\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e¢\u0006\u0002\u0010\u000fJ\u0014\u0010$\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010J\u0014\u0010$\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\b\u0010%\u001a\u00020\u0013H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0004H\u0001J \u0010(\u001a\u00020\u00132\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0*H\u0086\bø\u0001\u0000J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0004H\u0007J\u0019\u0010.\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00042\u0006\u0010/\u001a\u000200H\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00062"}, d2 = {"Landroidx/collection/MutableScatterSet;", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/ScatterSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "Landroidx/collection/ObjectList;", "", "([Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "adjustStorage", "", "asMutableSet", "", "clear", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeDeletedMarkers", "removeElementAt", "index", "removeIf", "predicate", "Lkotlin/Function1;", "resizeStorage", "newCapacity", "trim", "writeMetadata", EventBody.KEY_VALUE, "", "MutableSetWrapper", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableScatterSet<E> extends ScatterSet<E> {
    private int growthLimit;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0016\u0010\u0011\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u0016\u0010\u0012\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¨\u0006\u0013"}, d2 = {"Landroidx/collection/MutableScatterSet$MutableSetWrapper;", "Landroidx/collection/ScatterSet$SetWrapper;", "Landroidx/collection/ScatterSet;", "", "(Landroidx/collection/MutableScatterSet;)V", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "iterator", "", "remove", "removeAll", "retainAll", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class MutableSetWrapper extends ScatterSet<E>.SetWrapper implements Set<E>, KMutableSet {
        final /* synthetic */ MutableScatterSet<E> this$0;

        public MutableSetWrapper(MutableScatterSet r3) {
            this.this$0 = r3;
            super((ScatterSet) ZeusTransformUtils.preCheckCast(r3, ScatterSet.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean add(E r1) {
            return this.this$0.add(r1);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends E> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "elements");
            return this.this$0.addAll((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return (Iterator) ZeusTransformUtils.preCheckCast(new MutableScatterSet$MutableSetWrapper$iterator$1(this.this$0), Iterator.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean remove(Object r1) {
            return this.this$0.remove(r1);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean removeAll(Collection<? extends Object> r4) {
            Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "elements");
            int r0 = this.this$0.getSize();
            Iterator<E> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L7;
            E r1 = r6.next();
            this.this$0.minusAssign(r1);
            goto L4
        L7:
            if (r0 == this.this$0.getSize()) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean retainAll(Collection<? extends Object> r15) {
            Collection r16 = (Collection) ZeusTransformUtils.wrapperContextForParams(r15, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r16, "elements");
            ScatterSet r0 = (ScatterSet) ZeusTransformUtils.preCheckCast(this.this$0, ScatterSet.class, "com.obric.memorydata.plugin");
            MutableScatterSet<E> r14 = this.this$0;
            long[] r1 = r0.metadata;
            int r2 = r1.length - 2;
            boolean r3 = false;
            if (r2 < 0) goto L23;
            int r4 = 0;
            boolean r5 = false;
        L5:
            long r6 = r1[r4];
            if (((((~r6) << 7) & r6) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
            int r7 = 8 - ((~(r4 - r2)) >>> 31);
            int r9 = 0;
        L8:
            if (r9 >= r7) goto L18;
            if ((255 & r6) >= 128) goto L12;
            boolean r10 = true;
        L13:
            if (r10 == false) goto L17;
            int r11 = (r4 << 3) + r9;
            if (r16.contains(r14.elements[r11]) == true) goto L17;
            r14.removeElementAt(r11);
            r5 = true;
        L17:
            r6 = r6 >> 8;
            r9 = r9 + 1;
            goto L8
        L12:
            r10 = false;
            goto L13
        L18:
            if (r7 == 8) goto L19;
            return r5;
        L19:
            if (r4 == r2) goto L21;
            r4 = r4 + 1;
            goto L5
        L21:
            r3 = r5;
        L23:
            return r3;
        }
    }

    public MutableScatterSet() {
        this(0, 1, null);
    }

    public MutableScatterSet(int r2) {
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

    public /* synthetic */ MutableScatterSet(int r1, int r2, DefaultConstructorMarker r3) {
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

    private final int findAbsoluteInsertIndex(E r21) {
        if (r21 == null) goto L5;
        int r3 = r21.hashCode();
    L6:
        int r4 = r3 * ScatterMapKt.MurmurHashC1;
        int r5 = r4 ^ (r4 << 16);
        int r6 = r5 >>> 7;
        int r7 = r5 & 127;
        int r8 = this._capacity;
        int r9 = r6 & r8;
        int r10 = 0;
    L7:
        long[] r11 = this.metadata;
        int r12 = r9 >> 3;
        int r13 = (r9 & 7) << 3;
        long r14 = ((r11[r12 + 1] << (64 - r13)) & ((-r13) >> 63)) | (r11[r12] >>> r13);
        long r15 = r7;
        int r18 = r7;
        long r2 = r14 ^ (r15 * ScatterMapKt.BitmaskLsb);
        long r16 = ((~r2) & (r2 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r16 == 0) goto L11;
        boolean r19 = true;
    L12:
        if (r19 == false) goto L18;
        int r17 = (r9 + (Long.numberOfTrailingZeros(r16) >> 3)) & r8;
        if (Intrinsics.areEqual(this.elements[r17], r21) == true) goto L15;
        r16 = r16 & (r16 - 1);
        goto L9
    L15:
        return r17;
    L18:
        if (((((~r14) << 6) & r14) & (-9187201950435737472L)) != 0) goto L19;
        r10 = r10 + 8;
        r9 = (r9 + r10) & r8;
        r7 = r18;
        goto L7
    L19:
        int r1 = findFirstAvailableSlot(r6);
        if (this.growthLimit == 0) goto L22;
    L27:
        this._size++;
        int r20 = this.growthLimit;
        int r22 = r1 >> 3;
        int r23 = (r1 & 7) << 3;
        if (((this.metadata[r22] >> r23) & 255) != 128) goto L30;
        int r110 = 1;
    L31:
        this.growthLimit = r20 - r110;
        long[] r24 = this.metadata;
        r24[r22] = (r24[r22] & (~(255 << r23))) | (r15 << r23);
        int r0 = this._capacity;
        int r25 = ((r1 - 7) & r0) + (r0 & 7);
        int r26 = r25 >> 3;
        int r27 = (r25 & 7) << 3;
        r24[r26] = ((~(255 << r27)) & r24[r26]) | (r15 << r27);
        return r1;
    L30:
        r110 = 0;
        goto L31
    L22:
        if (((this.metadata[r1 >> 3] >> ((r1 & 7) << 3)) & 255) != 254) goto L24;
        boolean r28 = true;
    L25:
        if (r28 == true) goto L27;
        adjustStorage();
        r1 = findFirstAvailableSlot(r6);
        goto L27
    L24:
        r28 = false;
        goto L25
    L11:
        r19 = false;
        goto L12
    L5:
        r3 = 0;
        goto L6
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
        this.elements = new Object[r3];
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

    private final void resizeStorage(int r20) {
        long[] r1 = this.metadata;
        Object[] r2 = this.elements;
        int r3 = this._capacity;
        initializeStorage(r20);
        Object[] r4 = this.elements;
        int r6 = 0;
    L3:
        if (r6 >= r3) goto L16;
        if (((r1[r6 >> 3] >> ((r6 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L15;
        Object r8 = r2[r6];
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = r9 * ScatterMapKt.MurmurHashC1;
        int r11 = r10 ^ (r10 << 16);
        int r12 = findFirstAvailableSlot(r11 >>> 7);
        long r13 = r11 & 127;
        long[] r14 = this.metadata;
        int r15 = r12 >> 3;
        int r16 = (r12 & 7) << 3;
        r14[r15] = (r14[r15] & (~(255 << r16))) | (r13 << r16);
        int r5 = this._capacity;
        int r17 = ((r12 - 7) & r5) + (r5 & 7);
        int r18 = r17 >> 3;
        int r19 = (r17 & 7) << 3;
        r14[r18] = ((~(255 << r19)) & r14[r18]) | (r13 << r19);
        r4[r12] = r8;
        goto L15
    L12:
        r9 = 0;
    L15:
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

    public final boolean add(E r4) {
        int r0 = getSize();
        int r1 = findAbsoluteInsertIndex(r4);
        this.elements[r1] = r4;
        if (getSize() == r0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(ObjectList<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        plusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(ScatterSet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        plusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(Iterable<? extends E> r3) {
        Iterable<? extends E> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = getSize();
        plusAssign(r4);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(Sequence<? extends E> r3) {
        Sequence<? extends E> r4 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r3, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = getSize();
        plusAssign(r4);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(E[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        plusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final Set<E> asMutableSet() {
        return (Set) ZeusTransformUtils.preCheckCast(new MutableSetWrapper(this), Set.class, "com.obric.memorydata.plugin");
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
        ArraysKt.fill(this.elements, null, 0, this._capacity);
        initializeGrowth();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        Object[] r0 = r4.content;
        int r5 = r4._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        minusAssign(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> r14) {
        Intrinsics.checkNotNullParameter(r14, "elements");
        Object[] r0 = r14.elements;
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(Iterable<? extends E> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        minusAssign(r5.next());
        goto L4
    }

    public final void minusAssign(E r19) {
        ScatterSet r2 = (ScatterSet) ZeusTransformUtils.preCheckCast(this, ScatterSet.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L5;
        int r4 = r19.hashCode();
    L6:
        int r5 = r4 * ScatterMapKt.MurmurHashC1;
        int r6 = r5 ^ (r5 << 16);
        int r7 = r6 & 127;
        int r8 = r2._capacity;
        int r9 = (r6 >>> 7) & r8;
        int r10 = 0;
    L7:
        long[] r11 = r2.metadata;
        int r12 = r9 >> 3;
        int r13 = (r9 & 7) << 3;
        long r14 = ((r11[r12 + 1] << (64 - r13)) & ((-r13) >> 63)) | (r11[r12] >>> r13);
        long r15 = (((long) r7) * ScatterMapKt.BitmaskLsb) ^ r14;
        long r16 = ((~r15) & (r15 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r16 == 0) goto L11;
        boolean r17 = true;
    L12:
        if (r17 == false) goto L18;
        int r18 = ((Long.numberOfTrailingZeros(r16) >> 3) + r9) & r8;
        if (Intrinsics.areEqual(r2.elements[r18], r19) == true) goto L20;
        r16 = r16 & (r16 - 1);
    L20:
        if (r18 < 0) goto L27;
        removeElementAt(r18);
        return;
    L27:
        return;
    L18:
        if (((r14 & ((~r14) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r10 = r10 + 8;
        r9 = (r9 + r10) & r8;
        goto L7
    L19:
        r18 = -1;
        goto L20
    L11:
        r17 = false;
        goto L12
    L5:
        r4 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(Sequence<? extends E> r3) {
        Sequence r4 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r3, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        minusAssign(r5.next());
        goto L4
    }

    public final void minusAssign(E[] r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        minusAssign(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ObjectList<E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        Object[] r0 = r4.content;
        int r5 = r4._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        plusAssign(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> r14) {
        Intrinsics.checkNotNullParameter(r14, "elements");
        Object[] r0 = r14.elements;
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(Iterable<? extends E> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        plusAssign(r5.next());
        goto L4
    }

    public final void plusAssign(E r2) {
        int r0 = findAbsoluteInsertIndex(r2);
        this.elements[r0] = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(Sequence<? extends E> r3) {
        Sequence r4 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r3, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        plusAssign(r5.next());
        goto L4
    }

    public final void plusAssign(E[] r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        plusAssign(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final boolean remove(E r19) {
        ScatterSet r2 = (ScatterSet) ZeusTransformUtils.preCheckCast(this, ScatterSet.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L5;
        int r4 = r19.hashCode();
    L6:
        int r5 = r4 * ScatterMapKt.MurmurHashC1;
        int r6 = r5 ^ (r5 << 16);
        int r7 = r6 & 127;
        int r8 = r2._capacity;
        int r9 = (r6 >>> 7) & r8;
        int r10 = 0;
    L7:
        long[] r11 = r2.metadata;
        int r12 = r9 >> 3;
        int r13 = (r9 & 7) << 3;
        long r14 = ((r11[r12 + 1] << (64 - r13)) & ((-r13) >> 63)) | (r11[r12] >>> r13);
        long r15 = (((long) r7) * ScatterMapKt.BitmaskLsb) ^ r14;
        long r16 = ((~r15) & (r15 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r16 == 0) goto L11;
        boolean r17 = true;
    L12:
        if (r17 == false) goto L18;
        int r18 = ((Long.numberOfTrailingZeros(r16) >> 3) + r9) & r8;
        if (Intrinsics.areEqual(r2.elements[r18], r19) == true) goto L20;
        r16 = r16 & (r16 - 1);
    L20:
        if (r18 < 0) goto L22;
        boolean r3 = true;
    L23:
        if (r3 == false) goto L25;
        removeElementAt(r18);
    L25:
        return r3;
    L22:
        r3 = false;
        goto L23
    L18:
        if (((r14 & ((~r14) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r10 = r10 + 8;
        r9 = (r9 + r10) & r8;
        goto L7
    L19:
        r18 = -1;
        goto L20
    L11:
        r17 = false;
        goto L12
    L5:
        r4 = 0;
        goto L6
    }

    public final boolean removeAll(ObjectList<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        minusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(ScatterSet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        minusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(Iterable<? extends E> r3) {
        Iterable<? extends E> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = getSize();
        minusAssign(r4);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(Sequence<? extends E> r3) {
        Sequence<? extends E> r4 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r3, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = getSize();
        minusAssign(r4);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(E[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        minusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void removeElementAt(int r12) {
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
        this.elements[r12] = null;
    }

    public final void removeIf(Function1<? super E, Boolean> r18) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "predicate");
        Object[] r3 = this.elements;
        long[] r4 = ((ScatterSet) ZeusTransformUtils.preCheckCast(this, ScatterSet.class, "com.obric.memorydata.plugin")).metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L21;
        int r7 = 0;
    L5:
        long r8 = r4[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r10 = 8 - ((~(r7 - r5)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L18;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L17;
        int r14 = (r7 << 3) + r12;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(r3[r14]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        removeElementAt(r14);
    L17:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L18:
        if (r10 == 8) goto L19;
        return;
    L19:
        if (r7 == r5) goto L29;
        r7 = r7 + 1;
        goto L5
    L29:
        return;
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
