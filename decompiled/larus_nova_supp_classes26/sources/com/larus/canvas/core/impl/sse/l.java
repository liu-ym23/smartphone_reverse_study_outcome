package com.larus.canvas.core.impl.sse;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class l {

    public static final class a extends l {
        public final Long a;
        public final List<cy8.b> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Long r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "Blocks(sequenceId=" + this.a + ", blocks=" + this.b + ')';
        }

        public a(Long r2, List<cy8.b> r3) {
            Intrinsics.checkNotNullParameter(r3, "blocks");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends l {
        public static final b a = null;

        static {
            a = new b();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof b) == true) goto L9;
            return false;
        L9:
            b r4 = (b) r3;
            return true;
        }

        public final int hashCode() {
            return -1422663030;
        }

        public final String toString() {
            return "Done";
        }

        public b() {
        }
    }

    public static final class c extends l {
        public final int a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(code=" + this.a + ", message=" + this.b + ')';
        }

        public c(int r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d extends l {
        public static final d a = null;

        static {
            a = new d();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof d) == true) goto L9;
            return false;
        L9:
            d r4 = (d) r3;
            return true;
        }

        public final int hashCode() {
            return 96878794;
        }

        public final String toString() {
            return "Ignored";
        }

        public d() {
        }
    }

    public l() {
    }
}
