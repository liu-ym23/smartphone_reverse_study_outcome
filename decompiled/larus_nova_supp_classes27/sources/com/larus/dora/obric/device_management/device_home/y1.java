package com.larus.dora.obric.device_management.device_home;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface y1 {

    public static final class a implements y1 {
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
            return -774487244;
        }

        public final String toString() {
            return "Unavailable";
        }
    }
}
