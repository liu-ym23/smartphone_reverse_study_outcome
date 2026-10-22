package tia;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public final long a;
    public final ArrayDeque<a> b;
    public long c;
    public long d;

    public static final class a {
        public final byte[] a;
        public final long b;
        public final long c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = Arrays.hashCode(this.a) * 31;
            long r1 = this.b;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r3 = this.c;
            return r2 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "CaptureAudioFrame(data=" + Arrays.toString(this.a) + ", startMs=" + this.b + ", endMs=" + this.c + ')';
        }

        public a(byte[] r2, long r3, long r5) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
            this.b = r3;
            this.c = r5;
        }
    }

    public f() {
        this.a = 30000;
        this.b = new ArrayDeque();
    }

    public final d b(long r21, byte[] r23) {
        Intrinsics.checkNotNullParameter(r23, "dst");
        int r3 = 0;
        if (r23.length != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        return new d(0, r21, 0);
    L10:
        if (this.b.peekFirst() == null) goto L12;
        long r4 = this.c;
        long r6 = 0;
        if (r21 >= r4) goto L16;
        long r12 = r4;
        long r18 = r4 - r21;
    L18:
        if (r12 >= this.d) goto L20;
        Iterator<a> r5 = this.b.iterator();
        long r7 = r12;
    L23:
        if (r5.hasNext() == false) goto L40;
        a r8 = r5.next();
        if (r8.c <= r12) goto L38;
        long r9 = r8.b;
        if (r9 <= r7) goto L31;
        if (r3 > 0) goto L40;
    L31:
        long r10 = RangesKt.coerceAtLeast(r12, r9);
        long r14 = RangesKt.coerceAtLeast(r10 - r8.b, r6);
        int r11 = tia.a.a;
        int r13 = (int) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r14, r6) * ((long) 128), r8.a.length);
        int r15 = r8.a.length - r13;
        if (r15 <= 0) goto L38;
        int r16 = Math.min(r15, r23.length - r3);
        System.arraycopy(r8.a, r13, r23, r3, r16);
        r3 = r3 + r16;
        r7 = tia.a.a(r16) + r10;
        if (r3 >= r23.length) goto L40;
        r12 = r7;
    L38:
        r6 = 0;
    L40:
        return new d(r3, r7, r18);
    L20:
        return new d(0, r12, r18);
    L16:
        r12 = r21;
        r18 = 0;
        goto L18
    L12:
        return new d(0, r21, 0);
    L5:
        r2 = false;
        goto L6
    }

    public final void a(byte[] r9, int r10, long r11, long r13) {
        Intrinsics.checkNotNullParameter(r9, "data");
        if (r10 > 0) goto L5;
        return;
    L5:
        if (r9.length != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L28;
        a r1 = new a(Arrays.copyOf(r9, RangesKt.coerceAtMost(r10, r9.length)), r11, RangesKt.coerceAtLeast(r13, r11));
        this.b.addLast(r1);
        long r12 = r1.c;
        this.d = r12;
        if (this.c > 0) goto L13;
        this.c = r1.b;
    L13:
        long r14 = r12 - this.a;
    L15:
        if ((!this.b.isEmpty()) == false) goto L19;
        if (this.b.peekFirst().c > r14) goto L19;
        this.b.removeFirst();
    L19:
        a r15 = this.b.peekFirst();
        if (r15 == null) goto L22;
        long r16 = r15.b;
    L23:
        this.c = r16;
        return;
    L22:
        r16 = this.d;
        goto L23
    L28:
        return;
    L7:
        r0 = false;
        goto L8
    }
}
