package com.larus.dora.impl.onboarding.othersmart.streamlined;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class n0 {

    public static final class a extends n0 {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends n0 {
        public final long a;
        public final String b;
        public final String c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Listening(roundToken=" + this.a + ", source=" + this.b + ", text=" + this.c + ')';
        }

        public b(long r2, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "source");
            Intrinsics.checkNotNullParameter(r5, "text");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class c extends n0 {
        public final long a;
        public final String b;
        public final String c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return ((r1 + r3) * 31) + this.c.hashCode();
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public final String toString() {
            return "Submitted(roundToken=" + this.a + ", text=" + this.b + ", source=" + this.c + ')';
        }

        public c(long r2, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "source");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public n0() {
    }
}
