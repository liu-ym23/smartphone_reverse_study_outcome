package com.larus.asr;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static final Object a = null;

    public static final class a {
        public final long a;
        public final boolean b;
        public final boolean c;
        public final boolean d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r3 = 1231;
        L6:
            int r4 = (r1 + r3) * 31;
            if (this.c == false) goto L9;
            int r5 = 1231;
        L10:
            int r6 = (r4 + r5) * 31;
            if (this.d == true) goto L15;
            r2 = 1237;
        L15:
            return r6 + r2;
        L9:
            r5 = 1237;
            goto L10
        L5:
            r3 = 1237;
            goto L6
        }

        public final String toString() {
            return "Result(sizeBytes=" + this.a + ", deleted=" + this.b + ", plaintextAbsent=" + this.c + ", encryptedAfterDeleteFailure=" + this.d + ')';
        }

        public a(long r1, boolean r3, boolean r4, boolean r5) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
        a = new Object();
    }
}
