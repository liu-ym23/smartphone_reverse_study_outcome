package pn0;

import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final Triple<Integer, Integer, String> a;
    public final a b;
    public final b c;
    public final List<c> d;

    public static final class a {
        public final int a;
        public int b;
        public final int c;
        public int d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L14;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "CanvasUIContainerParams[" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ']';
        }

        public a(int r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b {
        public final int a;
        public int b;
        public final int c;
        public int d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L14;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "ContentUIContainerParams[" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ']';
        }

        public b(int r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public int c;
        public int d;
        public int e;
        public int f;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L18;
            c r4 = (c) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L16;
            return false;
        L16:
            if (this.f == r4.f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            return (((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public final String toString() {
            return "SeatItemUIContainerParams[" + this.a + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + ']';
        }

        public c(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public final String toString() {
        return "absContainerWHAndReason = " + this.a + '\n' + this.b + ", \n" + this.c + ", ";
    }

    public f(Triple<Integer, Integer, String> r2, a r3, b r4, List<c> r5) {
        Intrinsics.checkNotNullParameter(r2, "absContainerWHAndReason");
        Intrinsics.checkNotNullParameter(r3, "canvasUIContainerParams");
        Intrinsics.checkNotNullParameter(r4, "contentUIContainerParams");
        Intrinsics.checkNotNullParameter(r5, "seatItemParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
