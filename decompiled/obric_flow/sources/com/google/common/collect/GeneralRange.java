package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class GeneralRange<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient GeneralRange f8809a;
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    private final T lowerEndpoint;
    private final BoundType upperBoundType;
    private final T upperEndpoint;

    /* JADX WARN: Multi-variable type inference failed */
    public GeneralRange(Comparator r5, boolean r10, Object r11, BoundType r12, boolean r13, Object r14, BoundType r15) {
        r5.getClass();
        this.comparator = r5;
        this.hasLowerBound = r10;
        this.hasUpperBound = r13;
        this.lowerEndpoint = r11;
        r12.getClass();
        this.lowerBoundType = r12;
        this.upperEndpoint = r14;
        r15.getClass();
        this.upperBoundType = r15;
        if (r10 == false) goto L5;
        r5.compare(r11, r11);
    L5:
        if (r13 == false) goto L7;
        r5.compare(r14, r14);
    L7:
        if (r10 == false) goto L21;
        if (r13 == false) goto L22;
        int r16 = r5.compare(r11, r14);
        boolean r17 = false;
        if (r16 > 0) goto L12;
        boolean r18 = true;
    L13:
        com.google.common.base.b0.k(r18, "lowerEndpoint (%s) > upperEndpoint (%s)", r11, r14);
        if (r16 != 0) goto L23;
        BoundType r19 = BoundType.OPEN;
        if (r12 != r19) goto L18;
        if (r15 != r19) goto L18;
    L19:
        com.google.common.base.b0.i(r17);
        return;
    L18:
        r17 = true;
        goto L19
    L23:
        return;
    L12:
        r18 = false;
        goto L13
    L22:
        return;
    }

    public static <T> GeneralRange<T> all(Comparator<? super T> r10) {
        BoundType r11 = BoundType.OPEN;
        return new GeneralRange(r10, false, null, r11, false, null, r11);
    }

    public static <T> GeneralRange<T> downTo(Comparator<? super T> r10, T r11, BoundType r12) {
        return new GeneralRange(r10, true, r11, r12, false, null, BoundType.OPEN);
    }

    public static <T extends Comparable> GeneralRange<T> from(Range<T> r10) {
        Comparable r5 = null;
        if (r10.hasLowerBound() == false) goto L5;
        Comparable r11 = r10.lowerEndpoint();
    L7:
        if (r10.hasLowerBound() == false) goto L10;
        BoundType r12 = r10.lowerBoundType();
    L9:
        BoundType r13 = r12;
        if (r10.hasUpperBound() == false) goto L14;
        r5 = r10.upperEndpoint();
    L14:
        Comparable r14 = r5;
        if (r10.hasUpperBound() == false) goto L18;
        BoundType r15 = r10.upperBoundType();
    L20:
        return new GeneralRange(g8.natural(), r10.hasLowerBound(), r11, r13, r10.hasUpperBound(), r14, r15);
    L18:
        r15 = BoundType.OPEN;
        goto L20
    L10:
        r12 = BoundType.OPEN;
        goto L9
    L5:
        r11 = null;
        goto L7
    }

    public static <T> GeneralRange<T> range(Comparator<? super T> r10, T r11, BoundType r12, T r13, BoundType r14) {
        return new GeneralRange(r10, true, r11, r12, true, r13, r14);
    }

    public static <T> GeneralRange<T> upTo(Comparator<? super T> r10, T r11, BoundType r12) {
        return new GeneralRange(r10, false, null, BoundType.OPEN, true, r11, r12);
    }

    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    public boolean contains(T r5) {
        if (tooLow(r5) == false) goto L5;
    L7:
        return false;
    L5:
        if (tooHigh(r5) == true) goto L7;
        return true;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof GeneralRange) == false) goto L20;
        GeneralRange r10 = (GeneralRange) r5;
        if (this.comparator.equals(r10.comparator) == true) goto L7;
        return false;
    L7:
        if (this.hasLowerBound == r10.hasLowerBound) goto L9;
        return false;
    L9:
        if (this.hasUpperBound == r10.hasUpperBound) goto L11;
        return false;
    L11:
        if (getLowerBoundType().equals(r10.getLowerBoundType()) == true) goto L13;
        return false;
    L13:
        if (getUpperBoundType().equals(r10.getUpperBoundType()) == true) goto L15;
        return false;
    L15:
        if (com.google.common.base.b0.w(getLowerEndpoint(), r10.getLowerEndpoint()) == true) goto L17;
        return false;
    L17:
        if (com.google.common.base.b0.w(getUpperEndpoint(), r10.getUpperEndpoint()) == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        return false;
    }

    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType()});
    }

    public GeneralRange<T> intersect(GeneralRange<T> r12) {
        r12.getClass();
        com.google.common.base.b0.i(this.comparator.equals(r12.comparator));
        boolean r5 = this.hasLowerBound;
        T r10 = getLowerEndpoint();
        BoundType r11 = getLowerBoundType();
        if (hasLowerBound() == true) goto L7;
        r5 = r12.hasLowerBound;
        r10 = r12.getLowerEndpoint();
        r11 = r12.getLowerBoundType();
    L5:
        boolean r13 = r5;
        boolean r14 = this.hasUpperBound;
        T r15 = getUpperEndpoint();
        BoundType r16 = getUpperBoundType();
        if (hasUpperBound() == true) goto L19;
        r14 = r12.hasUpperBound;
        r15 = r12.getUpperEndpoint();
        r16 = r12.getUpperBoundType();
    L17:
        boolean r17 = r14;
        T r18 = r15;
        if (r13 == false) goto L35;
        if (r17 == false) goto L35;
        int r19 = this.comparator.compare(r10, r18);
        if (r19 > 0) goto L34;
        if (r19 != 0) goto L35;
        BoundType r110 = BoundType.OPEN;
        if (r11 != r110) goto L35;
        if (r16 != r110) goto L35;
    L34:
        BoundType r111 = BoundType.OPEN;
        BoundType r20 = r111;
        BoundType r112 = BoundType.CLOSED;
        T r21 = r18;
    L37:
        return new GeneralRange(this.comparator, r13, r21, r20, r17, r18, r112);
    L35:
        r21 = r10;
        r20 = r11;
        r112 = r16;
        goto L37
    L19:
        if (r12.hasUpperBound() == false) goto L17;
        int r22 = this.comparator.compare(getUpperEndpoint(), r12.getUpperEndpoint());
        if (r22 > 0) goto L25;
        if (r22 != 0) goto L17;
        if (r12.getUpperBoundType() != BoundType.OPEN) goto L17;
    L25:
        r15 = r12.getUpperEndpoint();
        r16 = r12.getUpperBoundType();
        goto L17
    L7:
        if (r12.hasLowerBound() == false) goto L5;
        int r23 = this.comparator.compare(getLowerEndpoint(), r12.getLowerEndpoint());
        if (r23 < 0) goto L13;
        if (r23 != 0) goto L5;
        if (r12.getLowerBoundType() != BoundType.OPEN) goto L5;
    L13:
        r10 = r12.getLowerEndpoint();
        r11 = r12.getLowerBoundType();
        goto L5
    }

    public boolean isEmpty() {
        if (hasUpperBound() == false) goto L7;
        if (tooLow(getUpperEndpoint()) == false) goto L7;
    L10:
        return true;
    L7:
        if (hasLowerBound() == true) goto L9;
    L11:
        return false;
    L9:
        if (tooHigh(getLowerEndpoint()) == false) goto L11;
        goto L10
    }

    public GeneralRange<T> reverse() {
        GeneralRange<T> r5 = this.f8809a;
        if (r5 != null) goto L6;
        GeneralRange<T> r10 = new GeneralRange(g8.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        r10.f8809a = this;
        this.f8809a = r10;
        return r10;
    L6:
        return r5;
    }

    public String toString() {
        String r5 = String.valueOf(this.comparator);
        BoundType r10 = this.lowerBoundType;
        BoundType r11 = BoundType.CLOSED;
        if (r10 != r11) goto L5;
        char r12 = '[';
    L7:
        if (this.hasLowerBound == false) goto L9;
        Object r13 = this.lowerEndpoint;
    L10:
        String r14 = String.valueOf(r13);
        if (this.hasUpperBound == false) goto L13;
        Object r15 = this.upperEndpoint;
    L14:
        String r16 = String.valueOf(r15);
        if (this.upperBoundType != r11) goto L17;
        char r17 = ']';
    L18:
        int r18 = r5.length() + 4;
        int r19 = r14.length() + r18;
        StringBuilder r20 = new StringBuilder(r16.length() + r19);
        r20.append(r5);
        r20.append(":");
        r20.append(r12);
        r20.append(r14);
        r20.append(',');
        r20.append(r16);
        r20.append(r17);
        return r20.toString();
    L17:
        r17 = ')';
        goto L18
    L13:
        r15 = "∞";
        goto L14
    L9:
        r13 = "-∞";
        goto L10
    L5:
        r12 = '(';
        goto L7
    }

    public boolean tooHigh(T r5) {
        boolean r10 = false;
        if (hasUpperBound() == true) goto L5;
        return false;
    L5:
        int r11 = this.comparator.compare(r5, getUpperEndpoint());
        if (r11 <= 0) goto L8;
        boolean r12 = true;
    L9:
        if (r11 != 0) goto L11;
        boolean r13 = true;
    L13:
        if (getUpperBoundType() != BoundType.OPEN) goto L16;
        r10 = true;
    L16:
        return (r13 & r10) | r12;
    L11:
        r13 = false;
        goto L13
    L8:
        r12 = false;
        goto L9
    }

    public boolean tooLow(T r5) {
        boolean r10 = false;
        if (hasLowerBound() == true) goto L5;
        return false;
    L5:
        int r11 = this.comparator.compare(r5, getLowerEndpoint());
        if (r11 >= 0) goto L8;
        boolean r12 = true;
    L9:
        if (r11 != 0) goto L11;
        boolean r13 = true;
    L13:
        if (getLowerBoundType() != BoundType.OPEN) goto L16;
        r10 = true;
    L16:
        return (r13 & r10) | r12;
    L11:
        r13 = false;
        goto L13
    L8:
        r12 = false;
        goto L9
    }
}
