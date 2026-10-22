package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    private final T lowerEndpoint;
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;
    private final T upperEndpoint;

    /* JADX WARN: Multi-variable type inference failed */
    private GeneralRange(Comparator<? super T> r4, boolean r5, T r6, BoundType r7, boolean r8, T r9, BoundType r10) {
        Comparator r11 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        this.comparator = (Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r11), Comparator.class, "com.obric.memorydata.plugin");
        this.hasLowerBound = r5;
        this.hasUpperBound = r8;
        this.lowerEndpoint = r6;
        this.lowerBoundType = (BoundType) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r7), BoundType.class, "com.obric.memorydata.plugin");
        this.upperEndpoint = r9;
        this.upperBoundType = (BoundType) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r10), BoundType.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L5;
        r11.compare(ao.a(r6), ao.a(r6));
    L5:
        if (r8 == false) goto L7;
        r11.compare(ao.a(r9), ao.a(r9));
    L7:
        if (r5 == false) goto L23;
        if (r8 == false) goto L24;
        int r3 = r11.compare(ao.a(r6), ao.a(r9));
        boolean r12 = true;
        if (r3 > 0) goto L12;
        boolean r13 = true;
    L13:
        com.google.common.base.n.a(r13, "lowerEndpoint (%s) > upperEndpoint (%s)", r6, r9);
        if (r3 == 0) goto L16;
        return;
    L16:
        if (r7 == BoundType.OPEN) goto L18;
    L21:
        com.google.common.base.n.a(r12);
        return;
    L18:
        if (r10 != BoundType.OPEN) goto L21;
        r12 = false;
        goto L21
    L12:
        r13 = false;
        goto L13
    L24:
        return;
    }

    static <T> GeneralRange<T> all(Comparator<? super T> r8) {
        return new GeneralRange((Comparator) ZeusTransformUtils.wrapperContextForParams(r8, Comparator.class, "com.obric.memorydata.plugin"), false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }

    static <T> GeneralRange<T> downTo(Comparator<? super T> r8, T r9, BoundType r10) {
        return new GeneralRange((Comparator) ZeusTransformUtils.wrapperContextForParams(r8, Comparator.class, "com.obric.memorydata.plugin"), true, r9, r10, false, null, BoundType.OPEN);
    }

    static <T extends Comparable> GeneralRange<T> from(Range<T> r10) {
        Comparable r1 = null;
        if (r10.hasLowerBound() == false) goto L5;
        Comparable r5 = r10.lowerEndpoint();
    L7:
        if (r10.hasLowerBound() == false) goto L9;
        BoundType r0 = r10.lowerBoundType();
    L10:
        BoundType r6 = r0;
        if (r10.hasUpperBound() == false) goto L13;
        r1 = r10.upperEndpoint();
    L13:
        Comparable r8 = r1;
        if (r10.hasUpperBound() == false) goto L16;
        BoundType r2 = r10.upperBoundType();
    L18:
        return new GeneralRange(Ordering.natural(), r10.hasLowerBound(), r5, r6, r10.hasUpperBound(), r8, r2);
    L16:
        r2 = BoundType.OPEN;
        goto L18
    L9:
        r0 = BoundType.OPEN;
        goto L10
    L5:
        r5 = null;
        goto L7
    }

    static <T> GeneralRange<T> range(Comparator<? super T> r8, T r9, BoundType r10, T r11, BoundType r12) {
        return new GeneralRange((Comparator) ZeusTransformUtils.wrapperContextForParams(r8, Comparator.class, "com.obric.memorydata.plugin"), true, r9, r10, true, r11, r12);
    }

    static <T> GeneralRange<T> upTo(Comparator<? super T> r8, T r9, BoundType r10) {
        return new GeneralRange((Comparator) ZeusTransformUtils.wrapperContextForParams(r8, Comparator.class, "com.obric.memorydata.plugin"), false, null, BoundType.OPEN, true, r9, r10);
    }

    Comparator<? super T> comparator() {
        return this.comparator;
    }

    boolean contains(T r2) {
        if (tooLow(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (tooHigh(r2) == true) goto L7;
        return true;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, GeneralRange.class) == false) goto L20;
        GeneralRange r5 = (GeneralRange) ZeusTransformUtils.preCheckCast(r4, GeneralRange.class, "com.obric.memorydata.plugin");
        if (this.comparator.equals(r5.comparator) == true) goto L7;
        return false;
    L7:
        if (this.hasLowerBound == r5.hasLowerBound) goto L9;
        return false;
    L9:
        if (this.hasUpperBound == r5.hasUpperBound) goto L11;
        return false;
    L11:
        if (getLowerBoundType().equals(r5.getLowerBoundType()) == true) goto L13;
        return false;
    L13:
        if (getUpperBoundType().equals(r5.getUpperBoundType()) == true) goto L15;
        return false;
    L15:
        if (com.google.common.base.k.a(getLowerEndpoint(), r5.getLowerEndpoint()) == true) goto L17;
        return false;
    L17:
        if (com.google.common.base.k.a(getUpperEndpoint(), r5.getUpperEndpoint()) == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        return false;
    }

    BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return com.google.common.base.k.a(new Object[]{this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType()});
    }

    GeneralRange<T> intersect(GeneralRange<T> r12) {
        com.google.common.base.n.a(r12);
        com.google.common.base.n.a(this.comparator.equals(r12.comparator));
        boolean r0 = this.hasLowerBound;
        T r1 = getLowerEndpoint();
        BoundType r2 = getLowerBoundType();
        if (hasLowerBound() == true) goto L7;
        r0 = r12.hasLowerBound;
    L5:
        r1 = r12.getLowerEndpoint();
        r2 = r12.getLowerBoundType();
    L14:
        boolean r5 = r0;
        boolean r3 = this.hasUpperBound;
        T r4 = getUpperEndpoint();
        BoundType r6 = getUpperBoundType();
        if (hasUpperBound() == true) goto L19;
        r3 = r12.hasUpperBound;
    L17:
        r4 = r12.getUpperEndpoint();
        r6 = r12.getUpperBoundType();
    L26:
        boolean r8 = r3;
        T r9 = r4;
        if (r5 == false) goto L37;
        if (r8 == false) goto L37;
        int r13 = this.comparator.compare(r1, r9);
        if (r13 > 0) goto L36;
        if (r13 != 0) goto L37;
        if (r2 != BoundType.OPEN) goto L37;
        if (r6 != BoundType.OPEN) goto L37;
    L36:
        BoundType r14 = BoundType.OPEN;
        BoundType r7 = r14;
        BoundType r10 = BoundType.CLOSED;
        T r11 = r9;
    L39:
        return new GeneralRange(this.comparator, r5, r11, r7, r8, r9, r10);
    L37:
        r11 = r1;
        r7 = r2;
        r10 = r6;
        goto L39
    L19:
        if (r12.hasUpperBound() == false) goto L26;
        int r15 = this.comparator.compare(getUpperEndpoint(), r12.getUpperEndpoint());
        if (r15 > 0) goto L17;
        if (r15 != 0) goto L26;
        if (r12.getUpperBoundType() != BoundType.OPEN) goto L26;
    L7:
        if (r12.hasLowerBound() == false) goto L14;
        int r16 = this.comparator.compare(getLowerEndpoint(), r12.getLowerEndpoint());
        if (r16 < 0) goto L5;
        if (r16 != 0) goto L14;
        if (r12.getLowerBoundType() != BoundType.OPEN) goto L14;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean isEmpty() {
        if (hasUpperBound() == false) goto L7;
        if (tooLow(ao.a(getUpperEndpoint())) == false) goto L7;
    L10:
        return true;
    L7:
        if (hasLowerBound() == true) goto L9;
    L11:
        return false;
    L9:
        if (tooHigh(ao.a(getLowerEndpoint())) == false) goto L11;
        goto L10
    }

    GeneralRange<T> reverse() {
        GeneralRange<T> r0 = this.reverse;
        if (r0 != null) goto L6;
        GeneralRange<T> r1 = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        r1.reverse = this;
        this.reverse = r1;
        return r1;
    L6:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append(this.comparator).append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (this.lowerBoundType != BoundType.CLOSED) goto L5;
        char r1 = '[';
    L6:
        StringBuilder r2 = r0.append(r1);
        if (this.hasLowerBound == false) goto L9;
        Object r3 = this.lowerEndpoint;
    L10:
        StringBuilder r4 = r2.append(r3).append(',');
        if (this.hasUpperBound == false) goto L13;
        Object r5 = this.upperEndpoint;
    L14:
        StringBuilder r6 = r4.append(r5);
        if (this.upperBoundType != BoundType.CLOSED) goto L17;
        char r7 = ']';
    L19:
        return r6.append(r7).toString();
    L17:
        r7 = ')';
        goto L19
    L13:
        r5 = "∞";
        goto L14
    L9:
        r3 = "-∞";
        goto L10
    L5:
        r1 = '(';
        goto L6
    }

    boolean tooHigh(T r5) {
        boolean r1 = false;
        if (hasUpperBound() == true) goto L5;
        return false;
    L5:
        int r6 = this.comparator.compare(r5, ao.a(getUpperEndpoint()));
        if (r6 <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r6 != 0) goto L11;
        boolean r7 = true;
    L13:
        if (getUpperBoundType() != BoundType.OPEN) goto L16;
        r1 = true;
    L16:
        return (r7 & r1) | r2;
    L11:
        r7 = false;
        goto L13
    L8:
        r2 = false;
        goto L9
    }

    boolean tooLow(T r5) {
        boolean r1 = false;
        if (hasLowerBound() == true) goto L5;
        return false;
    L5:
        int r6 = this.comparator.compare(r5, ao.a(getLowerEndpoint()));
        if (r6 >= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r6 != 0) goto L11;
        boolean r7 = true;
    L13:
        if (getLowerBoundType() != BoundType.OPEN) goto L16;
        r1 = true;
    L16:
        return (r7 & r1) | r2;
    L11:
        r7 = false;
        goto L13
    L8:
        r2 = false;
        goto L9
    }
}
