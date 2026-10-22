package com.bytedance.android.live.revlink.impl.pk.vm.pk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class d {
    public final String a;

    public static final class a extends d {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super("DISABLED");
        }
    }

    public static final class b extends d {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("FINISHED");
        }
    }

    public static final class c extends d {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
            super("OVER");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.pk.d$d, reason: collision with other inner class name */
    public static final class C0190d extends d {
        public static final C0190d b = null;

        static {
            b = new C0190d();
        }

        public C0190d() {
            super("START");
        }
    }

    public d(String r1) {
        this.a = r1;
    }
}
