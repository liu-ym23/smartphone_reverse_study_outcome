package org.threeten.bp.temporal;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;

/* JADX INFO: loaded from: classes3.dex */
public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    public ValueRange(long r5, long r10, long r11, long r12) {
        this.minSmallest = r5;
        this.minLargest = r10;
        this.maxSmallest = r11;
        this.maxLargest = r12;
    }

    public static ValueRange of(long r10, long r12) {
        if (r10 > r12) goto L7;
        return new ValueRange(r10, r10, r12, r12);
    L7:
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public int checkValidIntValue(long r5, g r10) {
        if (isValidIntValue(r5) == false) goto L7;
        return (int) r5;
    L7:
        throw new DateTimeException("Invalid int value for " + r10 + ": " + r5);
    }

    public long checkValidValue(long r5, g r10) {
        if (isValidValue(r5) == false) goto L5;
        return r5;
    L5:
        if (r10 == null) goto L9;
        throw new DateTimeException("Invalid value for " + r10 + " (valid values " + this + "): " + r5);
    L9:
        throw new DateTimeException("Invalid value (valid values " + this + "): " + r5);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ValueRange) == false) goto L18;
        ValueRange r11 = (ValueRange) r10;
        if (this.minSmallest != r11.minSmallest) goto L17;
        if (this.minLargest != r11.minLargest) goto L17;
        if (this.maxSmallest != r11.maxSmallest) goto L17;
        if (this.maxLargest != r11.maxLargest) goto L17;
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
        long r5 = this.minSmallest;
        long r10 = this.minLargest;
        long r11 = (r5 + r10) << ((int) (r10 + 16));
        long r12 = this.maxSmallest;
        long r13 = (r11 >> ((int) (r12 + 48))) << ((int) (r12 + 32));
        long r14 = this.maxLargest;
        long r15 = ((r13 >> ((int) (32 + r14))) << ((int) (r14 + 48))) >> 16;
        return (int) (r15 ^ (r15 >>> 32));
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

    public boolean isValidIntValue(long r5) {
        if (isIntValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidValue(r5) == false) goto L7;
        return true;
    }

    public boolean isValidValue(long r5) {
        if (r5 >= getMinimum()) goto L5;
    L7:
        return false;
    L5:
        if (r5 > getMaximum()) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.minSmallest);
        if (this.minSmallest == this.minLargest) goto L5;
        r5.append('/');
        r5.append(this.minLargest);
    L5:
        r5.append(" - ");
        r5.append(this.maxSmallest);
        if (this.maxSmallest == this.maxLargest) goto L9;
        r5.append('/');
        r5.append(this.maxLargest);
    L9:
        return r5.toString();
    }

    public static ValueRange of(long r10, long r11, long r12) {
        return of(r10, r10, r11, r12);
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
}
