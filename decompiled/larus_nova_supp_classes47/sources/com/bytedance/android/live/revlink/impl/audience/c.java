package com.bytedance.android.live.revlink.impl.audience;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class c {
    public final String a;

    public static final class a extends c {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super("linkerEnter");
        }
    }

    public static final class b extends c {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("onRoomSync");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.audience.c$c, reason: collision with other inner class name */
    public static final class C0119c extends c {
        public static final C0119c b = null;

        static {
            b = new C0119c();
        }

        public C0119c() {
            super("sei backup");
        }
    }

    public c(String r1) {
        this.a = r1;
    }
}
