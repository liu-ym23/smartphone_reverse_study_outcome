package e59;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class b {

    public static final class a extends b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Connected(mac=" + this.a + ')';
        }

        public a(String r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: e59.b$b, reason: collision with other inner class name */
    public static final class C0125b extends b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0125b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0125b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Connecting(mac=" + this.a + ')';
        }

        public C0125b(String r1) {
            this.a = r1;
        }
    }

    public static final class c extends b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Disconnected(mac=" + this.a + ')';
        }

        public c(String r1) {
            this.a = r1;
        }
    }

    public static final class d extends b {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public b() {
    }
}
