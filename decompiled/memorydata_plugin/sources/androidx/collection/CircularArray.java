package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0016\u001a\u00020\u0012J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0016\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000b\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u000b\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/collection/CircularArray;", ExifInterface.LONGITUDE_EAST, "", "minCapacity", "", "(I)V", "capacityBitmask", "elements", "", "[Ljava/lang/Object;", "first", "getFirst", "()Ljava/lang/Object;", "head", "last", "getLast", "tail", "addFirst", "", "element", "(Ljava/lang/Object;)V", "addLast", "clear", "doubleCapacity", "get", "index", "(I)Ljava/lang/Object;", "isEmpty", "", "popFirst", "popLast", "removeFromEnd", CommonConsts.COUNT_TYPE, "removeFromStart", "size", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CircularArray<E> {
    private int capacityBitmask;
    private E[] elements;
    private int head;
    private int tail;

    public CircularArray() {
        this(0, 1, null);
    }

    public CircularArray(int r4) {
        boolean r0 = false;
        if (r4 < 1) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L19;
        if (r4 > 1073741824) goto L10;
        r0 = true;
    L10:
        if (r0 == false) goto L17;
        if (Integer.bitCount(r4) == 1) goto L14;
        r4 = Integer.highestOneBit(r4 - 1) << 1;
    L14:
        this.capacityBitmask = r4 - 1;
        this.elements = (E[]) new Object[r4];
        return;
    L17:
        throw new IllegalArgumentException("capacity must be <= 2^30".toString());
    L19:
        throw new IllegalArgumentException("capacity must be >= 1".toString());
    L5:
        r2 = false;
        goto L6
    }

    public /* synthetic */ CircularArray(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 8;
    L5:
        this(r1);
    }

    private final void doubleCapacity() {
        E[] r0 = this.elements;
        int r1 = r0.length;
        int r2 = this.head;
        int r3 = r1 - r2;
        int r4 = r1 << 1;
        if (r4 < 0) goto L7;
        E[] r5 = (E[]) new Object[r4];
        ArraysKt.copyInto(r0, r5, 0, r2, r1);
        ArraysKt.copyInto(this.elements, r5, r3, 0, this.head);
        this.elements = r5;
        this.head = 0;
        this.tail = r1;
        this.capacityBitmask = r4 - 1;
        return;
    L7:
        throw new RuntimeException("Max array capacity exceeded");
    }

    public final void addFirst(E r3) {
        int r0 = (this.head - 1) & this.capacityBitmask;
        this.head = r0;
        this.elements[r0] = r3;
        if (r0 != this.tail) goto L6;
        doubleCapacity();
        return;
    }

    public final void addLast(E r3) {
        E[] r0 = this.elements;
        int r1 = this.tail;
        r0[r1] = r3;
        int r4 = this.capacityBitmask;
        int r5 = r4 & (r1 + 1);
        this.tail = r5;
        if (r5 != this.head) goto L6;
        doubleCapacity();
        return;
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final E get(int r3) {
        if (r3 >= 0) goto L4;
    L7:
        CollectionPlatformUtils r2 = CollectionPlatformUtils.INSTANCE;
        throw ((IndexOutOfBoundsException) ZeusTransformUtils.preCheckCast(new ArrayIndexOutOfBoundsException(), IndexOutOfBoundsException.class, "com.obric.memorydata.plugin"));
    L4:
        if (r3 >= size()) goto L7;
        E[] r0 = this.elements;
        int r1 = this.head + r3;
        E r4 = r0[this.capacityBitmask & r1];
        Intrinsics.checkNotNull(r4);
        return r4;
    }

    public final E getFirst() {
        int r0 = this.head;
        if (r0 == this.tail) goto L6;
        E r2 = this.elements[r0];
        Intrinsics.checkNotNull(r2);
        return r2;
    L6:
        CollectionPlatformUtils r3 = CollectionPlatformUtils.INSTANCE;
        throw ((IndexOutOfBoundsException) ZeusTransformUtils.preCheckCast(new ArrayIndexOutOfBoundsException(), IndexOutOfBoundsException.class, "com.obric.memorydata.plugin"));
    }

    public final E getLast() {
        int r0 = this.head;
        int r1 = this.tail;
        if (r0 == r1) goto L6;
        E r2 = this.elements[this.capacityBitmask & (r1 - 1)];
        Intrinsics.checkNotNull(r2);
        return r2;
    L6:
        CollectionPlatformUtils r3 = CollectionPlatformUtils.INSTANCE;
        throw ((IndexOutOfBoundsException) ZeusTransformUtils.preCheckCast(new ArrayIndexOutOfBoundsException(), IndexOutOfBoundsException.class, "com.obric.memorydata.plugin"));
    }

    public final boolean isEmpty() {
        if (this.head != this.tail) goto L5;
        return true;
    L5:
        return false;
    }

    public final E popFirst() {
        int r0 = this.head;
        if (r0 == this.tail) goto L6;
        E[] r1 = this.elements;
        E r2 = r1[r0];
        r1[r0] = null;
        this.head = (r0 + 1) & this.capacityBitmask;
        return r2;
    L6:
        CollectionPlatformUtils r4 = CollectionPlatformUtils.INSTANCE;
        throw ((IndexOutOfBoundsException) ZeusTransformUtils.preCheckCast(new ArrayIndexOutOfBoundsException(), IndexOutOfBoundsException.class, "com.obric.memorydata.plugin"));
    }

    public final E popLast() {
        int r0 = this.head;
        int r1 = this.tail;
        if (r0 == r1) goto L6;
        int r2 = this.capacityBitmask & (r1 - 1);
        E[] r3 = this.elements;
        E r4 = r3[r2];
        r3[r2] = null;
        this.tail = r2;
        return r4;
    L6:
        CollectionPlatformUtils r5 = CollectionPlatformUtils.INSTANCE;
        throw ((IndexOutOfBoundsException) ZeusTransformUtils.preCheckCast(new ArrayIndexOutOfBoundsException(), IndexOutOfBoundsException.class, "com.obric.memorydata.plugin"));
    }

    public final void removeFromEnd(int r6) {
        if (r6 > 0) goto L5;
        return;
    L5:
        if (r6 > size()) goto L20;
        int r0 = 0;
        int r1 = this.tail;
        if (r6 >= r1) goto L9;
        r0 = r1 - r6;
    L9:
        int r2 = r0;
    L11:
        if (r2 >= r1) goto L13;
        this.elements[r2] = null;
        r2 = r2 + 1;
        goto L11
    L13:
        int r3 = this.tail;
        int r4 = r3 - r0;
        int r7 = r6 - r4;
        this.tail = r3 - r4;
        if (r7 <= 0) goto L24;
        int r5 = this.elements.length;
        this.tail = r5;
        int r8 = r5 - r7;
        int r9 = r8;
    L16:
        if (r9 >= r5) goto L18;
        this.elements[r9] = null;
        r9 = r9 + 1;
        goto L16
    L18:
        this.tail = r8;
        return;
    L24:
        return;
    L20:
        CollectionPlatformUtils r10 = CollectionPlatformUtils.INSTANCE;
        throw ((IndexOutOfBoundsException) ZeusTransformUtils.preCheckCast(new ArrayIndexOutOfBoundsException(), IndexOutOfBoundsException.class, "com.obric.memorydata.plugin"));
    }

    public final void removeFromStart(int r5) {
        if (r5 > 0) goto L5;
        return;
    L5:
        if (r5 > size()) goto L19;
        int r0 = this.elements.length;
        int r1 = this.head;
        if (r5 >= (r0 - r1)) goto L10;
        r0 = r1 + r5;
    L10:
        if (r1 >= r0) goto L12;
        this.elements[r1] = null;
        r1 = r1 + 1;
        goto L10
    L12:
        int r2 = this.head;
        int r3 = r0 - r2;
        int r6 = r5 - r3;
        int r4 = r2 + r3;
        this.head = this.capacityBitmask & r4;
        if (r6 <= 0) goto L24;
        int r7 = 0;
    L15:
        if (r7 >= r6) goto L17;
        this.elements[r7] = null;
        r7 = r7 + 1;
        goto L15
    L17:
        this.head = r6;
        return;
    L24:
        return;
    L19:
        CollectionPlatformUtils r8 = CollectionPlatformUtils.INSTANCE;
        throw ((IndexOutOfBoundsException) ZeusTransformUtils.preCheckCast(new ArrayIndexOutOfBoundsException(), IndexOutOfBoundsException.class, "com.obric.memorydata.plugin"));
    }

    public final int size() {
        int r0 = this.tail - this.head;
        return this.capacityBitmask & r0;
    }
}
