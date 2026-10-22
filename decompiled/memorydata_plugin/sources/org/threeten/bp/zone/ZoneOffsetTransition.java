package org.threeten.bp.zone;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes8.dex */
public final class ZoneOffsetTransition implements Serializable, Comparable<ZoneOffsetTransition> {
    private static final long serialVersionUID = -6946044323557704546L;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final LocalDateTime transition;

    ZoneOffsetTransition(long r2, ZoneOffset r4, ZoneOffset r5) {
        this.transition = LocalDateTime.ofEpochSecond(r2, 0, r4);
        this.offsetBefore = r4;
        this.offsetAfter = r5;
    }

    ZoneOffsetTransition(LocalDateTime r1, ZoneOffset r2, ZoneOffset r3) {
        this.transition = r1;
        this.offsetBefore = r2;
        this.offsetAfter = r3;
    }

    private int getDurationSeconds() {
        return getOffsetAfter().getTotalSeconds() - getOffsetBefore().getTotalSeconds();
    }

    public static ZoneOffsetTransition of(LocalDateTime r1, ZoneOffset r2, ZoneOffset r3) {
        Jdk8Methods.requireNonNull(r1, "transition");
        Jdk8Methods.requireNonNull(r2, "offsetBefore");
        Jdk8Methods.requireNonNull(r3, "offsetAfter");
        if (r2.equals(r3) == true) goto L11;
        if (r1.getNano() != 0) goto L9;
        return new ZoneOffsetTransition(r1, r2, r3);
    L9:
        throw new IllegalArgumentException("Nano-of-second must be zero");
    L11:
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    static ZoneOffsetTransition readExternal(DataInput r4) {
        DataInput r5 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r4, DataInput.class, "com.obric.memorydata.plugin");
        long r0 = Ser.readEpochSec(r5);
        ZoneOffset r2 = Ser.readOffset(r5);
        ZoneOffset r6 = Ser.readOffset(r5);
        if (r2.equals(r6) == true) goto L7;
        return new ZoneOffsetTransition(r0, r2, r6);
    L7:
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ZoneOffsetTransition r3) {
        return compareTo2((ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(r3, ZoneOffsetTransition.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ZoneOffsetTransition r1) {
        return getInstant().compareTo2(r1.getInstant());
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ZoneOffsetTransition.class) == false) goto L16;
        ZoneOffsetTransition r6 = (ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(r5, ZoneOffsetTransition.class, "com.obric.memorydata.plugin");
        if (this.transition.equals(r6.transition) == false) goto L15;
        if (this.offsetBefore.equals(r6.offsetBefore) == false) goto L15;
        if (this.offsetAfter.equals(r6.offsetAfter) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public LocalDateTime getDateTimeAfter() {
        return this.transition.plusSeconds(getDurationSeconds());
    }

    public LocalDateTime getDateTimeBefore() {
        return this.transition;
    }

    public Duration getDuration() {
        return Duration.ofSeconds(getDurationSeconds());
    }

    public Instant getInstant() {
        return this.transition.toInstant(this.offsetBefore);
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    List<ZoneOffset> getValidOffsets() {
        if (isGap() == false) goto L7;
        return Collections.emptyList();
    L7:
        return Arrays.asList(new ZoneOffset[]{getOffsetBefore(), getOffsetAfter()});
    }

    public int hashCode() {
        int r0 = this.transition.hashCode() ^ this.offsetBefore.hashCode();
        return Integer.rotateLeft(this.offsetAfter.hashCode(), 16) ^ r0;
    }

    public boolean isGap() {
        if (getOffsetAfter().getTotalSeconds() <= getOffsetBefore().getTotalSeconds()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOverlap() {
        if (getOffsetAfter().getTotalSeconds() >= getOffsetBefore().getTotalSeconds()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValidOffset(ZoneOffset r3) {
        if (isGap() == false) goto L6;
        return false;
    L6:
        if (getOffsetBefore().equals(r3) == false) goto L8;
    L9:
        return true;
    L8:
        if (getOffsetAfter().equals(r3) == true) goto L9;
        return false;
    }

    public long toEpochSecond() {
        return this.transition.toEpochSecond(this.offsetBefore);
    }

    /* JADX WARN: String concatenation convert failed
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 java.lang.StringBuilder, still in use, count: 1, list:
      (r1v1 java.lang.StringBuilder) from 0x0016: INVOKE (r1v1 java.lang.StringBuilder), (r2v2 java.lang.String) VIRTUAL call: java.lang.StringBuilder.append(java.lang.String):java.lang.StringBuilder A[MD:(java.lang.String):java.lang.StringBuilder (c), WRAPPED]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
    	at jadx.core.dex.visitors.SimplifyVisitor.removeStringBuilderInsns(SimplifyVisitor.java:520)
    	at jadx.core.dex.visitors.SimplifyVisitor.convertStringBuilderChain(SimplifyVisitor.java:440)
    	at jadx.core.dex.visitors.SimplifyVisitor.convertInvoke(SimplifyVisitor.java:337)
    	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:145)
    	at jadx.core.dex.visitors.SimplifyVisitor.simplifyArgs(SimplifyVisitor.java:115)
    	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:132)
    	at jadx.core.dex.visitors.SimplifyVisitor.simplifyBlock(SimplifyVisitor.java:86)
    	at jadx.core.dex.visitors.SimplifyVisitor.visit(SimplifyVisitor.java:71)
     */
    public String toString() {
        if (isGap() == false) goto L5;
        String r2 = "Gap";
    L6:
        r1.append(r2).append(" at ").append(this.transition).append(this.offsetBefore).append(" to ").append(this.offsetAfter).append(']');
        return r0.toString();
    L5:
        r2 = "Overlap";
        goto L6
    }

    void writeExternal(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.memorydata.plugin");
        Ser.writeEpochSec(toEpochSecond(), r4);
        Ser.writeOffset(this.offsetBefore, r4);
        Ser.writeOffset(this.offsetAfter, r4);
    }
}
