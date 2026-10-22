package com.larus.dora.impl.onboarding.g.v2.viewmodel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface y {

    public static final class a implements y {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            a r4 = (a) r3;
            return true;
        }

        public final int hashCode() {
            return 281866213;
        }

        public final String toString() {
            return "Empty";
        }
    }

    public static final class b implements y {
        public final boolean a;
        public final long b;

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
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            long r1 = this.b;
            return (r0 * 31) + ((int) (r1 ^ (r1 >>> 32)));
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "State(state=" + this.a + ", ts=" + this.b + ')';
        }

        public b(boolean r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }
}
