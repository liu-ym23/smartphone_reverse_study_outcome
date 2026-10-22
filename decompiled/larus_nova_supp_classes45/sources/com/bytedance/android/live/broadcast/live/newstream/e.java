package com.bytedance.android.live.broadcast.live.newstream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class e {

    public static final class a extends e {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
            super("CreatingToCreatedEffect");
        }
    }

    public static final class b extends e {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
            super("DestroyEffect");
        }
    }

    public static final class c extends e {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
            super("IdleToRunningEffect");
        }
    }

    public static final class d extends e {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
            super("InitialToCreating");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcast.live.newstream.e$e, reason: collision with other inner class name */
    public static final class C0027e extends e {
        public static final C0027e a = null;

        static {
            a = new C0027e();
        }

        public C0027e() {
            super("InitialToIdle");
        }
    }

    public static final class f extends e {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
            super("InvalidEffect");
        }
    }

    public static final class g extends e {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
            super("ResumeEffect");
        }
    }

    public static final class h extends e {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
            super("RunningToPauseEffect");
        }
    }

    public static final class i extends e {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
            super("StopCaptureEffect");
        }
    }

    public e(String r1) {
    }
}
