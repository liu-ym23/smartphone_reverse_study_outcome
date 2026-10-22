package com.larus.dora.impl.onboarding.g.v2.viewmodel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface o {

    public static final class a implements o {
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
            return -1566419830;
        }

        public final String toString() {
            return "Empty";
        }
    }

    public static final class b implements o {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "State(state=" + this.a + ')';
        }

        public b(boolean r1) {
            this.a = r1;
        }
    }
}
