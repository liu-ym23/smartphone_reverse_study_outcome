package com.bytedance.android.live.revlink.impl.multianchor.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class h {
    public final String a;
    public final int b;

    public static final class a extends h {
        public static final a c = null;

        public a() {
            super("BePermitted", 1);
        }

        static {
            c = new a();
        }
    }

    public static final class b extends h {
        public static final b c = null;

        public b() {
            super("BeReplied", 5);
        }

        static {
            c = new b();
        }
    }

    public static final class c extends h {
        public static final c c = null;

        public c() {
            super("BeRepliedLinker", 6);
        }

        static {
            c = new c();
        }
    }

    public static final class d extends h {
        public static final d c = null;

        public d() {
            super("None", 0);
        }

        static {
            c = new d();
        }
    }

    public static final class e extends h {
        public static final e c = null;

        public e() {
            super("PermitAgree", 2);
        }

        static {
            c = new e();
        }
    }

    public static final class f extends h {
        public static final f c = null;

        public f() {
            super("PermitLinker", 3);
        }

        static {
            c = new f();
        }
    }

    public static final class g extends h {
        public static final g c = null;

        public g() {
            super("ReplyAgree", 4);
        }

        static {
            c = new g();
        }
    }

    public h(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
