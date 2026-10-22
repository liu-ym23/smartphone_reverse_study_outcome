package com.obric.assistant.spi.audio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class a {
    public final int a;
    public final String b;

    /* JADX INFO: renamed from: com.obric.assistant.spi.audio.a$a, reason: collision with other inner class name */
    public static final class C0025a extends a {
        public C0025a(String r2) {
            super(5, r2);
        }
    }

    public static final class b extends a {
        public b() {
            super(3, null);
        }
    }

    public static final class c extends a {
        public c() {
            super(1, null);
        }
    }

    public static final class d extends a {
        public d() {
            super(0, null);
        }
    }

    public static final class e extends a {
        public e() {
            super(2, null);
        }
    }

    public static final class f extends a {
        public f() {
            super(4, null);
        }
    }

    public a(int r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
