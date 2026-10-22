package x39;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class b {
    public final String a;

    public static final class a extends b {
        public final String b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((a) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "Failed(reason=" + this.b + ')';
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            super(r2);
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: x39.b$b, reason: collision with other inner class name */
    public static final class C0147b extends b {
        public static final C0147b b = null;

        static {
            b = new C0147b();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0147b) == true) goto L9;
            return false;
        L9:
            C0147b r4 = (C0147b) r3;
            return true;
        }

        public final int hashCode() {
            return 1582308414;
        }

        public final String toString() {
            return "GpsDisabled";
        }

        public C0147b() {
            super("GpsDisabled");
        }
    }

    public static final class c extends b {
        public static final c b = null;

        static {
            b = new c();
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
            return -1252797574;
        }

        public final String toString() {
            return "HotspotEnabled";
        }

        public c() {
            super("HotspotEnabled");
        }
    }

    public static final class d extends b {
        public static final d b = null;

        static {
            b = new d();
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
            return -2038756313;
        }

        public final String toString() {
            return "LocationPermissionDenied";
        }

        public d() {
            super("LocationPermissionDenied");
        }
    }

    public static final class e extends b {
        public static final e b = null;

        static {
            b = new e();
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
            return -722852623;
        }

        public final String toString() {
            return "NearbyPermissionDenied";
        }

        public e() {
            super("NearbyPermissionDenied");
        }
    }

    public static final class f extends b {
        public final String b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((f) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "Success(host=" + this.b + ')';
        }

        public f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "host");
            super("Success");
            this.b = r2;
        }
    }

    public static final class g extends b {
        public static final g b = null;

        static {
            b = new g();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof g) == true) goto L9;
            return false;
        L9:
            g r4 = (g) r3;
            return true;
        }

        public final int hashCode() {
            return 487139765;
        }

        public final String toString() {
            return "VpnEnabled";
        }

        public g() {
            super("VpnEnabled");
        }
    }

    public static final class h extends b {
        public static final h b = null;

        static {
            b = new h();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof h) == true) goto L9;
            return false;
        L9:
            h r4 = (h) r3;
            return true;
        }

        public final int hashCode() {
            return -456060743;
        }

        public final String toString() {
            return "WifiDisabled";
        }

        public h() {
            super("WifiDisabled");
        }
    }

    public b(String r1) {
        this.a = r1;
    }
}
