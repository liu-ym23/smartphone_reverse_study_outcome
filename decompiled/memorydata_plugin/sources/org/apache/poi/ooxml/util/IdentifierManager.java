package org.apache.poi.ooxml.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;
import java.util.ListIterator;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes7.dex */
public class IdentifierManager {
    private final long lowerbound;
    private LinkedList<Segment> segments;
    private final long upperbound;

    private static class Segment {
        private long end;
        private long start;

        public Segment(long r1, long r3) {
            this.start = r1;
            this.end = r3;
        }

        static /* synthetic */ long access$000(Segment r2) {
            return r2.end;
        }

        static /* synthetic */ long access$002(Segment r0, long r1) {
            r0.end = r1;
            return r1;
        }

        static /* synthetic */ long access$100(Segment r2) {
            return r2.start;
        }

        static /* synthetic */ long access$102(Segment r0, long r1) {
            r0.start = r1;
            return r1;
        }

        public String toString() {
            return "[" + this.start + "; " + this.end + "]";
        }
    }

    public IdentifierManager(long r4, long r6) {
        if (r4 > r6) goto L15;
        if (r4 < 0) goto L13;
        if (r6 > 9223372036854775806L) goto L11;
        this.lowerbound = r4;
        this.upperbound = r6;
        LinkedList<Segment> r0 = new LinkedList();
        this.segments = r0;
        r0.add(new Segment(r4, r6));
        return;
    L11:
        throw new IllegalArgumentException("upperbound must be less than or equal to " + Long.toString(9223372036854775806L) + " but had " + r6);
    L13:
        throw new IllegalArgumentException("lowerbound must be greater than or equal to " + Long.toString(0));
    L15:
        throw new IllegalArgumentException("lowerbound must not be greater than upperbound, had " + r4 + " and " + r6);
    }

    private void verifyIdentifiersLeft() {
        if (this.segments.isEmpty() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("No identifiers left");
    }

    public long reserve(long r10) {
        if (r10 < this.lowerbound) goto L52;
        if (r10 > this.upperbound) goto L52;
        verifyIdentifiersLeft();
        if (r10 != this.upperbound) goto L17;
        Segment r0 = (Segment) ZeusTransformUtils.preCheckCast(this.segments.getLast(), Segment.class, "com.obric.memorydata.plugin");
        long r4 = Segment.access$000(r0);
        long r6 = this.upperbound;
        if (r4 != r6) goto L15;
        Segment.access$002(r0, r6 - 1);
        if (Segment.access$100(r0) <= Segment.access$000(r0)) goto L13;
        this.segments.removeLast();
    L13:
        return r10;
    L15:
        return reserveNew();
    L17:
        if (r10 != this.lowerbound) goto L26;
        Segment r1 = (Segment) ZeusTransformUtils.preCheckCast(this.segments.getFirst(), Segment.class, "com.obric.memorydata.plugin");
        long r5 = Segment.access$100(r1);
        long r7 = this.lowerbound;
        if (r5 != r7) goto L25;
        Segment.access$102(r1, r7 + 1);
        if (Segment.access$000(r1) >= Segment.access$100(r1)) goto L23;
        this.segments.removeFirst();
    L23:
        return r10;
    L25:
        return reserveNew();
    L26:
        ListIterator<Segment> r2 = this.segments.listIterator();
    L28:
        if (r2.hasNext() == false) goto L50;
        Segment r8 = (Segment) ZeusTransformUtils.preCheckCast(r2.next(), Segment.class, "com.obric.memorydata.plugin");
        if (Segment.access$000(r8) < r10) goto L28;
        if (Segment.access$100(r8) > r10) goto L50;
        if (Segment.access$100(r8) != r10) goto L42;
        Segment.access$102(r8, 1 + r10);
        if (Segment.access$000(r8) >= Segment.access$100(r8)) goto L40;
        r2.remove();
    L40:
        return r10;
    L42:
        if (Segment.access$000(r8) != r10) goto L47;
        Segment.access$002(r8, r10 - 1);
        if (Segment.access$100(r8) <= Segment.access$000(r8)) goto L46;
        r2.remove();
    L46:
        return r10;
    L47:
        r2.add(new Segment(r10 + 1, Segment.access$000(r8)));
        Segment.access$002(r8, r10 - 1);
        return r10;
    L50:
        return reserveNew();
    L52:
        throw new IllegalArgumentException("Value for parameter 'id' was out of bounds, had " + r10 + ", but should be within [" + this.lowerbound + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.upperbound + "]");
    }

    public long reserveNew() {
        verifyIdentifiersLeft();
        Segment r0 = (Segment) ZeusTransformUtils.preCheckCast(this.segments.getFirst(), Segment.class, "com.obric.memorydata.plugin");
        long r1 = Segment.access$100(r0);
        Segment.access$102(r0, Segment.access$100(r0) + 1);
        if (Segment.access$100(r0) <= Segment.access$000(r0)) goto L5;
        this.segments.removeFirst();
    L5:
        return r1;
    }
}
