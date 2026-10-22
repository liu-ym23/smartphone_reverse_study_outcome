package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hwpf.model.PropertyNode;

/* JADX INFO: loaded from: classes7.dex */
public abstract class PropertyNode<T extends PropertyNode<T>> implements Comparable<T> {
    public static final Comparator<PropertyNode<?>> EndComparator = null;
    private static final c LOG = null;
    public static final Comparator<PropertyNode<?>> StartComparator = null;
    protected Object _buf;
    private int _cpEnd;
    private int _cpStart;

    static {
        EndComparator = Comparator.comparingInt($$Lambda$2iuO4IXqFM7znWzX2Dlj78mSXXo.INSTANCE);
        StartComparator = Comparator.comparingInt($$Lambda$nO_kV3CbAmvW9PrteJpXphyHQm0.INSTANCE);
        LOG = b.a(PropertyNode.class);
    }

    public PropertyNode(int r1, int r2, Object r3) {
        this._cpStart = r1;
        this._cpEnd = r2;
        this._buf = r3;
        if (r1 >= 0) goto L6;
        LOG.atWarn().a("A property claimed to start before zero, at {}! Resetting it to zero, and hoping for the best", v.a(this._cpStart));
        this._cpStart = 0;
    L6:
        if (this._cpEnd >= this._cpStart) goto L9;
        LOG.atWarn().a("A property claimed to end ({}) before start! Resetting end to start, and hoping for the best", v.a(this._cpEnd));
        this._cpEnd = this._cpStart;
        return;
    }

    public void adjustForDelete(int r4, int r5) {
        int r0 = r4 + r5;
        int r1 = this._cpEnd;
        if (r1 <= r4) goto L12;
        int r2 = this._cpStart;
        if (r2 >= r0) goto L10;
        if (r0 < r1) goto L8;
        int r3 = r4;
    L9:
        this._cpEnd = r3;
        this._cpStart = Math.min(r4, r2);
        return;
    L8:
        r3 = r1 - r5;
        goto L9
    L10:
        this._cpEnd = r1 - r5;
        this._cpStart = r2 - r5;
        return;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r3) {
        return compareTo((PropertyNode) ZeusTransformUtils.preCheckCast(r3, PropertyNode.class, "com.obric.memorydata.plugin"));
    }

    public int compareTo(T r1) {
        return Integer.compare(this._cpEnd, r1.getEnd());
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, PropertyNode.class) == true) goto L6;
        return false;
    L6:
        if (limitsAreEqual(r5) == false) goto L15;
        Object r6 = ((PropertyNode) ZeusTransformUtils.preCheckCast(r5, PropertyNode.class, "com.obric.memorydata.plugin"))._buf;
        if ((r6 instanceof byte[]) == false) goto L14;
        if ((this._buf instanceof byte[]) == false) goto L14;
        return Arrays.equals((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r6, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(this._buf, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
    L14:
        return this._buf.equals(r6);
    L15:
        return false;
    }

    public int getEnd() {
        return this._cpEnd;
    }

    public int getStart() {
        return this._cpStart;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this._cpStart), this._buf});
    }

    public boolean limitsAreEqual(Object r5) {
        if (((PropertyNode) ZeusTransformUtils.preCheckCast(r5, PropertyNode.class, "com.obric.memorydata.plugin")).getStart() == this._cpStart) goto L5;
    L7:
        return false;
    L5:
        if (((PropertyNode) ZeusTransformUtils.preCheckCast(r5, PropertyNode.class, "com.obric.memorydata.plugin")).getEnd() != this._cpEnd) goto L7;
        return true;
    }

    public void setEnd(int r1) {
        this._cpEnd = r1;
    }

    public void setStart(int r1) {
        this._cpStart = r1;
    }
}
