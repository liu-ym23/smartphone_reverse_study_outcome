package px8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class d {

    public static final class a extends d {
        public final boolean a;

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
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Capturing(engineReady=" + this.a + ')';
        }

        public a(boolean r1) {
            this.a = r1;
        }
    }

    public static final class b extends d {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends d {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    /* JADX INFO: renamed from: px8.d$d, reason: collision with other inner class name */
    public static final class C0130d extends d {
        public static final C0130d a = null;

        static {
            a = new C0130d();
        }

        public C0130d() {
        }
    }

    public static final class e extends d {
        public final float a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.a, ((e) r4).a) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.a);
        }

        public final String toString() {
            return "HoldRecordingRatio(ratio=" + this.a + ')';
        }

        public e(float r1) {
            this.a = r1;
        }
    }

    public static final class f extends d {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }
    }

    public d() {
    }
}
