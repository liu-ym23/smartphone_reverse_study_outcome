package com.bytedance.android.live.initialize;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public long a;
    public final String b;

    /* JADX INFO: renamed from: com.bytedance.android.live.initialize.a$a, reason: collision with other inner class name */
    public static final class C0203a extends a {
        public static final C0203a c = null;

        static {
            c = new C0203a();
        }

        public C0203a() {
            super("BOOT_FINISH");
        }
    }

    public static final class b extends a {
        public static final b c = null;

        static {
            c = new b();
        }

        public b() {
            super("COMMON");
        }
    }

    public static final class c extends a {
        public static final c c = null;

        static {
            c = new c();
        }

        public c() {
            super("COMPONENT_INJECT");
        }
    }

    public static final class d {
    }

    public static final class e extends a {
        public static final e c = null;

        static {
            c = new e();
        }

        public e() {
            super("ENTER_ROOM");
        }
    }

    public static final class f extends a {
        public static final f c = null;

        static {
            c = new f();
        }

        public f() {
            super("FIRST_FRAME");
        }
    }

    public static final class g extends a {
        public static final g c = null;

        static {
            c = new g();
        }

        public g() {
            super("FIRST_SCREEN");
        }
    }

    public static final class h extends a {
        public static final h c = null;

        static {
            c = new h();
        }

        public h() {
            super("INTERACT_PREPARED");
        }
    }

    public static final class i extends a {
        public static final i c = null;

        static {
            c = new i();
        }

        public i() {
            super("LAUNCH");
        }
    }

    public static final class j extends a {
        public static final j c = null;

        static {
            c = new j();
        }

        public j() {
            super("PRE_ENTER_ROOM");
        }
    }

    public static final class k extends a {
        public static final k c = null;

        static {
            c = new k();
        }

        public k() {
            super("ROOM_CHANGE");
        }
    }

    public static final class l extends a {
        public static final l c = null;

        static {
            c = new l();
        }

        public l() {
            super("ROOM_EXIT");
        }
    }

    static {
    }

    public a(String r1) {
        this.b = r1;
    }
}
