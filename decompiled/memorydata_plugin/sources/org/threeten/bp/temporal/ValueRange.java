package org.threeten.bp.temporal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.threeten.bp.DateTimeException;

/* JADX INFO: loaded from: classes8.dex */
public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    private ValueRange(long r1, long r3, long r5, long r7) {
        this.minSmallest = r1;
        this.minLargest = r3;
        this.maxSmallest = r5;
        this.maxLargest = r7;
    }

    public static ValueRange of(long r10, long r12) {
        if (r10 > r12) goto L7;
        return new ValueRange(r10, r10, r12, r12);
    L7:
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static ValueRange of(long r8, long r10, long r12) {
        return of(r8, r8, r10, r12);
    }

    public static ValueRange of(long r10, long r12, long r14, long r16) {
        if (r10 > r12) goto L15;
        if (r14 > r16) goto L13;
        if (r12 > r16) goto L11;
        return new ValueRange(r10, r12, r14, r16);
    L11:
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    L13:
        throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
    L15:
        throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
    }

    public int checkValidIntValue(long r3, TemporalField r5) {
        TemporalField r6 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r5, TemporalField.class, "com.obric.memorydata.plugin");
        if (isValidIntValue(r3) == false) goto L7;
        return (int) r3;
    L7:
        throw new DateTimeException("Invalid int value for " + r6 + ": " + r3);
    }

    public long checkValidValue(long r5, TemporalField r7) {
        TemporalField r8 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r7, TemporalField.class, "com.obric.memorydata.plugin");
        if (isValidValue(r5) == false) goto L5;
        return r5;
    L5:
        if (r8 == null) goto L9;
        throw new DateTimeException("Invalid value for " + r8 + " (valid values " + this + "): " + r5);
    L9:
        throw new DateTimeException("Invalid value (valid values " + this + "): " + r5);
    }

    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ValueRange.class) == false) goto L18;
        ValueRange r10 = (ValueRange) ZeusTransformUtils.preCheckCast(r9, ValueRange.class, "com.obric.memorydata.plugin");
        if (this.minSmallest != r10.minSmallest) goto L17;
        if (this.minLargest != r10.minLargest) goto L17;
        if (this.maxSmallest != r10.maxSmallest) goto L17;
        if (this.maxLargest != r10.maxLargest) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public long getLargestMinimum() {
        return this.minLargest;
    }

    public long getMaximum() {
        return this.maxLargest;
    }

    public long getMinimum() {
        return this.minSmallest;
    }

    public long getSmallestMaximum() {
        return this.maxSmallest;
    }

    public int hashCode() {
        long r0 = this.minSmallest;
        long r2 = this.minLargest;
        long r1 = (r0 + r2) << ((int) (r2 + 16));
        long r3 = this.maxSmallest;
        long r4 = (r1 >> ((int) (r3 + 48))) << ((int) (r3 + 32));
        long r5 = this.maxLargest;
        long r6 = ((r4 >> ((int) (32 + r5))) << ((int) (r5 + 48))) >> 16;
        return (int) (r6 ^ (r6 >>> 32));
    }

    public boolean isFixed() {
        if (this.minSmallest == this.minLargest) goto L5;
    L7:
        return false;
    L5:
        if (this.maxSmallest != this.maxLargest) goto L7;
        return true;
    }

    public boolean isIntValue() {
        if (getMinimum() >= (-2147483648L)) goto L5;
    L7:
        return false;
    L5:
        if (getMaximum() > 2147483647L) goto L7;
        return true;
    }

    public boolean isValidIntValue(long r2) {
        if (isIntValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidValue(r2) == false) goto L7;
        return true;
    }

    public boolean isValidValue(long r3) {
        if (r3 >= getMinimum()) goto L5;
    L7:
        return false;
    L5:
        if (r3 > getMaximum()) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.minSmallest);
        if (this.minSmallest == this.minLargest) goto L5;
        r0.append('/').append(this.minLargest);
    L5:
        r0.append(" - ").append(this.maxSmallest);
        if (this.maxSmallest == this.maxLargest) goto L9;
        r0.append('/').append(this.maxLargest);
    L9:
        return r0.toString();
    }
}
