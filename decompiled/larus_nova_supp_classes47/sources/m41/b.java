package m41;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b {
    public final String a;
    public final String b;

    public static final class a extends b {
        public static final a c = null;

        public a() {
            super("AutoUnload", null);
        }

        static {
            c = new a();
        }
    }

    /* JADX INFO: renamed from: m41.b$b, reason: collision with other inner class name */
    public static final class C0272b extends b {
        public static final C0272b c = null;

        public C0272b() {
            super("switch_to_link", null);
        }

        static {
            c = new C0272b();
        }
    }

    public static final class c extends b {
        public static final c c = null;

        public c() {
            super("Unknown", null);
        }

        static {
            c = new c();
        }
    }

    public static final class d extends b {
        public d() {
            Intrinsics.checkNotNullParameter("CMD_AUDIENCE_TURN_OFF_ENGINE", "source");
            super("Unexpected", "CMD_AUDIENCE_TURN_OFF_ENGINE");
        }
    }

    public final String toString() {
        String r0 = this.b;
        if (r0 == null) goto L7;
        String r1 = this.a + '_' + r0;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.a;
    }

    public b(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
