package com.larus.dora.impl.wlan.wifi.add;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface h {

    public static final class a implements h {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "ConnectFailed(errorCode=" + this.a + ')';
        }

        public a(int r1) {
            this.a = r1;
        }
    }

    public static final class b implements h {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c implements h {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }
}
