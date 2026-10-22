package com.larus.dora.impl.ota;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface c extends j69.c {

    public static final class a implements c {
        public static final a a = null;
        public static final String b = null;

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
            return 530578543;
        }

        public final String toString() {
            return "Next";
        }

        static {
            a = new a();
            b = "NEXT";
        }

        @Override // j69.c
        public final String a() {
            return b;
        }
    }
}
