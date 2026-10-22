package androidx.collection;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0001J\u0018\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0003J\u0011\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0013\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u000bH\u0086\nJ\u0011\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\u0011\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0014\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u000bH\u0086\nJ\u0011\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0003J\u001a\u0010\u0018\u001a\u00020\f2\b\b\u0001\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u001b\u0010\u001c\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002J\u0006\u0010\u001d\u001a\u00020\fJ\u0006\u0010\u001e\u001a\u00020\fJ\u0010\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\u0003R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006!"}, d2 = {"Landroidx/collection/MutableFloatList;", "Landroidx/collection/FloatList;", "initialCapacity", "", "(I)V", "capacity", "getCapacity", "()I", "add", "", "element", "", "", "index", "addAll", "elements", "", "clear", "ensureCapacity", "minusAssign", "plusAssign", "remove", "removeAll", "removeAt", "removeRange", CommonConsts.APM_INNER_EVENT_COST_START, "end", "retainAll", "set", LBSLightLocationTraceLogger.SORT, "sortDescending", "trim", "minCapacity", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableFloatList extends FloatList {
    public MutableFloatList() {
        this(0, 1, null);
    }

    public MutableFloatList(int r2) {
        super(r2, null);
    }

    public /* synthetic */ MutableFloatList(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 16;
    L5:
        this(r1);
    }

    public static /* synthetic */ void trim$default(MutableFloatList r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = r0._size;
    L5:
        r0.trim(r1);
    }

    public final void add(int r5, float r6) {
        boolean r0 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r0 == false) goto L14;
        ensureCapacity(this._size + 1);
        float[] r1 = this.content;
        if (r5 == this._size) goto L11;
        ArraysKt.copyInto(r1, r1, r5 + 1, r5, this._size);
    L11:
        r1[r5] = r6;
        this._size++;
        return;
    L14:
        throw new IndexOutOfBoundsException("Index " + r5 + " must be in 0.." + this._size);
    L5:
        if (r5 > this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final boolean add(float r4) {
        ensureCapacity(this._size + 1);
        this.content[this._size] = r4;
        this._size++;
        return true;
    }

    public final boolean addAll(int r6, FloatList r7) {
        Intrinsics.checkNotNullParameter(r7, "elements");
        if (r6 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L18;
        if (r7.isEmpty() == false) goto L12;
        return false;
    L12:
        ensureCapacity(this._size + r7._size);
        float[] r3 = this.content;
        if (r6 == this._size) goto L15;
        ArraysKt.copyInto(r3, r3, r7._size + r6, r6, this._size);
    L15:
        ArraysKt.copyInto(r7.content, r3, r6, 0, r7._size);
        this._size += r7._size;
        return true;
    L18:
        throw new IndexOutOfBoundsException("Index " + r6 + " must be in 0.." + this._size);
    L5:
        if (r6 > this._size) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean addAll(int r10, float[] r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r10 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L21;
        if (r11.length != 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return false;
    L15:
        ensureCapacity(this._size + r11.length);
        float[] r4 = this.content;
        if (r10 == this._size) goto L18;
        ArraysKt.copyInto(r4, r4, r11.length + r10, r10, this._size);
    L18:
        ArraysKt.copyInto$default(r11, r4, r10, 0, 0, 12, null);
        this._size += r11.length;
        return true;
    L12:
        r3 = false;
        goto L13
    L21:
        throw new IndexOutOfBoundsException("Index " + r10 + " must be in 0.." + this._size);
    L5:
        if (r10 > this._size) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean addAll(FloatList r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        return addAll(this._size, r2);
    }

    public final boolean addAll(float[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        return addAll(this._size, r2);
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int r3) {
        float[] r0 = this.content;
        if (r0.length >= r3) goto L6;
        float[] r4 = Arrays.copyOf(r0, Math.max(r3, (r0.length * 3) / 2));
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        this.content = r4;
        return;
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(float r1) {
        remove(r1);
    }

    public final void minusAssign(FloatList r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        float[] r0 = r4.content;
        int r5 = r4._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        remove(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void minusAssign(float[] r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(float r1) {
        add(r1);
    }

    public final void plusAssign(FloatList r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        addAll(this._size, r2);
    }

    public final void plusAssign(float[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        addAll(this._size, r2);
    }

    public final boolean remove(float r1) {
        int r2 = indexOf(r1);
        if (r2 < 0) goto L6;
        removeAt(r2);
        return true;
    L6:
        return false;
    }

    public final boolean removeAll(FloatList r7) {
        Intrinsics.checkNotNullParameter(r7, "elements");
        int r0 = this._size;
        int r1 = r7._size - 1;
        if (r1 < 0) goto L9;
        int r4 = 0;
    L5:
        remove(r7.get(r4));
        if (r4 == r1) goto L9;
        r4 = r4 + 1;
    L9:
        if (r0 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean removeAll(float[] r6) {
        Intrinsics.checkNotNullParameter(r6, "elements");
        int r0 = this._size;
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        remove(r6[r3]);
        r3 = r3 + 1;
        goto L3
    L6:
        if (r0 == this._size) goto L10;
        return true;
    L10:
        return false;
    }

    public final float removeAt(int r6) {
        boolean r0 = false;
        if (r6 < 0) goto L8;
        if (r6 >= this._size) goto L8;
        r0 = true;
    L8:
        if (r0 == false) goto L15;
        float[] r1 = this.content;
        float r3 = r1[r6];
        if (r6 == (((FloatList) ZeusTransformUtils.preCheckCast(this, FloatList.class, "com.obric.memorydata.plugin"))._size - 1)) goto L12;
        ArraysKt.copyInto(r1, r1, r6, r6 + 1, this._size);
    L12:
        this._size--;
        return r3;
    L15:
        throw new IndexOutOfBoundsException("Index " + r6 + " must be in 0.." + (((FloatList) ZeusTransformUtils.preCheckCast(this, FloatList.class, "com.obric.memorydata.plugin"))._size - 1));
    }

    public final void removeRange(int r5, int r6) {
        boolean r0 = true;
        if (r5 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L26;
        if (r6 >= 0) goto L12;
    L14:
        r0 = false;
    L15:
        if (r0 == false) goto L26;
        if (r6 < r5) goto L24;
        if (r6 != r5) goto L19;
        return;
    L19:
        if (r6 >= this._size) goto L21;
        ArraysKt.copyInto(this.content, this.content, r5, r6, this._size);
    L21:
        this._size -= r6 - r5;
        return;
    L24:
        throw new IllegalArgumentException("Start (" + r5 + ") is more than end (" + r6 + ')');
    L12:
        if (r6 > this._size) goto L14;
    L26:
        throw new IndexOutOfBoundsException("Start (" + r5 + ") and end (" + r6 + ") must be in 0.." + this._size);
    L5:
        if (r5 > this._size) goto L7;
        r2 = true;
        goto L9
    }

    public final boolean retainAll(FloatList r6) {
        Intrinsics.checkNotNullParameter(r6, "elements");
        int r0 = this._size;
        float[] r1 = this.content;
        int r2 = ((FloatList) ZeusTransformUtils.preCheckCast(this, FloatList.class, "com.obric.memorydata.plugin"))._size - 1;
    L4:
        if ((-1) >= r2) goto L10;
        if (r6.contains(r1[r2]) == true) goto L8;
        removeAt(r2);
    L8:
        r2 = r2 - 1;
        goto L4
    L10:
        if (r0 != this._size) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean retainAll(float[] r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r0 = this._size;
        float[] r1 = this.content;
        int r2 = ((FloatList) ZeusTransformUtils.preCheckCast(this, FloatList.class, "com.obric.memorydata.plugin"))._size - 1;
    L3:
        int r5 = -1;
        if ((-1) >= r2) goto L18;
        float r6 = r1[r2];
        int r7 = r11.length;
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L14;
        if (r11[r8] != r6) goto L10;
        boolean r9 = true;
    L11:
        if (r9 == true) goto L12;
        r8 = r8 + 1;
        goto L6
    L12:
        r5 = r8;
        goto L14
    L10:
        r9 = false;
    L14:
        if (r5 >= 0) goto L16;
        removeAt(r2);
    L16:
        r2 = r2 - 1;
        goto L3
    L18:
        if (r0 == this._size) goto L21;
        return true;
    L21:
        return false;
    }

    public final float set(int r4, float r5) {
        boolean r1 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r1 == false) goto L11;
        float[] r3 = this.content;
        float r0 = r3[r4];
        r3[r4] = r5;
        return r0;
    L11:
        throw new IndexOutOfBoundsException("set index " + r4 + " must be between 0 .. " + (((FloatList) ZeusTransformUtils.preCheckCast(this, FloatList.class, "com.obric.memorydata.plugin"))._size - 1));
    L5:
        if (r4 >= this._size) goto L7;
        r1 = true;
        goto L7
    }

    public final void sort() {
        ArraysKt.sort(this.content, 0, this._size);
    }

    public final void sortDescending() {
        ArraysKt.sortDescending(this.content, 0, this._size);
    }

    public final void trim(int r2) {
        int r3 = Math.max(r2, this._size);
        if (this.content.length <= r3) goto L6;
        float[] r4 = Arrays.copyOf(this.content, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        this.content = r4;
        return;
    }
}
