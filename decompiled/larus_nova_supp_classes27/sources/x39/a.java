package x39;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a {

    /* JADX INFO: renamed from: x39.a$a, reason: collision with other inner class name */
    public static final class C0146a implements a {
        public static final C0146a a = null;

        static {
            a = new C0146a();
        }

        public C0146a() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0146a) == true) goto L9;
            return false;
        L9:
            C0146a r4 = (C0146a) r3;
            return true;
        }

        public final int hashCode() {
            return 1833569555;
        }

        public final String toString() {
            return "GpsClosed";
        }
    }

    public static final class b implements a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
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
            return 958736693;
        }

        public final String toString() {
            return "HotspotEnabled";
        }
    }

    public static final class c implements a {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L9;
            return false;
        L9:
            c r4 = (c) r3;
            return true;
        }

        public final int hashCode() {
            return 1333234080;
        }

        public final String toString() {
            return "Success";
        }
    }

    public static final class d implements a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
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
            return -246901520;
        }

        public final String toString() {
            return "VpnEnabled";
        }
    }

    public static final class e implements a {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof e) == true) goto L9;
            return false;
        L9:
            e r4 = (e) r3;
            return true;
        }

        public final int hashCode() {
            return -1495099084;
        }

        public final String toString() {
            return "WifiDisabled";
        }
    }
}
