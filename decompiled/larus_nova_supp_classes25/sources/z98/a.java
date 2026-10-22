package z98;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class a {
    public final String a;

    /* JADX INFO: renamed from: z98.a$a, reason: collision with other inner class name */
    public static final class C0098a extends a {
        public static final C0098a b = null;

        static {
            b = new C0098a();
        }

        public C0098a() {
            super("ApDetected");
        }
    }

    public static final class b extends a {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("GpsDisabled");
        }
    }

    public static final class c extends a {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
            super("Hide");
        }
    }

    public static final class d extends a {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
            super("Idle");
        }
    }

    public static final class e extends a {
        public static final e b = null;

        static {
            b = new e();
        }

        public e() {
            super("LowBattery");
        }
    }

    public static final class f extends a {
        public static final f b = null;

        static {
            b = new f();
        }

        public f() {
            super("NoPermission");
        }
    }

    public static final class g extends a {
        public static final g b = null;

        static {
            b = new g();
        }

        public g() {
            super("Recording");
        }
    }

    public static final class h extends a {
        public final int b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (this.b == r6.b) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.b * 31) + this.c;
        }

        public final String toString() {
            return "ShowDiff(imageCount=" + this.b + ", videoCount=" + this.c + ')';
        }

        public h(int r3, int r4) {
            super("ShowDiff:(" + r3 + ", " + r4 + ')');
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class i extends a {
        public static final i b = null;

        static {
            b = new i();
        }

        public i() {
            super("TransferEnded");
        }
    }

    public static final class j extends a {
        public static final j b = null;

        static {
            b = new j();
        }

        public j() {
            super("TransferStarted");
        }
    }

    public static final class k extends a {
        public static final k b = null;

        static {
            b = new k();
        }

        public k() {
            super("VpnDetected");
        }
    }

    public static final class l extends a {
        public static final l b = null;

        static {
            b = new l();
        }

        public l() {
            super("WifiConnecting");
        }
    }

    public static final class m extends a {
        public static final m b = null;

        static {
            b = new m();
        }

        public m() {
            super("WifiDisabled");
        }
    }

    public static final class n extends a {
        public static final n b = null;

        static {
            b = new n();
        }

        public n() {
            super("WifiError");
        }
    }

    public a(String r1) {
        this.a = r1;
    }
}
