package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    public static final enum a extends Enum<a> {
        private static final /* synthetic */ a[] $VALUES = null;
        public static final C0016a Companion = null;
        public static final a ON_ANY = null;
        public static final a ON_CREATE = null;
        public static final a ON_DESTROY = null;
        public static final a ON_PAUSE = null;
        public static final a ON_RESUME = null;
        public static final a ON_START = null;
        public static final a ON_STOP = null;

        /* JADX INFO: renamed from: androidx.lifecycle.h$a$a, reason: collision with other inner class name */
        public static final class C0016a {
            public static a a(b r8) {
                he.i.f(r8, "state");
                int r10 = r8.ordinal();
                if (r10 == 2) goto L12;
                if (r10 == 3) goto L15;
                if (r10 == 4) goto L14;
                return null;
            L14:
                return a.ON_PAUSE;
            L15:
                return a.ON_STOP;
            L12:
                return a.ON_DESTROY;
            }

            public static a b(b r8) {
                he.i.f(r8, "state");
                int r10 = r8.ordinal();
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L15;
                if (r10 == 3) goto L14;
                return null;
            L14:
                return a.ON_RESUME;
            L15:
                return a.ON_START;
            L12:
                return a.ON_CREATE;
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f2156a = null;

            static {
                int[] r8 = new int[a.values().length];
                r8[a.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r8[a.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r8[a.ON_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r8[a.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r8[a.ON_RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r8[a.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r8[a.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                f2156a = r8;
            }
        }

        static {
            a r8 = new a("ON_CREATE", 0);
            ON_CREATE = r8;
            a r10 = new a("ON_START", 1);
            ON_START = r10;
            a r11 = new a("ON_RESUME", 2);
            ON_RESUME = r11;
            a r12 = new a("ON_PAUSE", 3);
            ON_PAUSE = r12;
            a r13 = new a("ON_STOP", 4);
            ON_STOP = r13;
            a r14 = new a("ON_DESTROY", 5);
            ON_DESTROY = r14;
            a r15 = new a("ON_ANY", 6);
            ON_ANY = r15;
            $VALUES = new a[]{r8, r10, r11, r12, r13, r14, r15};
            Companion = new C0016a();
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) $VALUES.clone();
        }

        public final b a() {
            switch(b.f2156a[ordinal()]) {
                case 1: goto L13;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L5;
            };
        L5:
            throw new IllegalArgumentException(this + " has no target state");
        L7:
            return b.f2157a;
        L9:
            return b.f2161o;
        L11:
            return b.f2160n;
        L13:
            return b.f2159m;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f2157a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f2158b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f2159m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f2160n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final b f2161o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final /* synthetic */ b[] f2162p = null;

        static {
            b r8 = new b("DESTROYED", 0);
            f2157a = r8;
            b r10 = new b("INITIALIZED", 1);
            f2158b = r10;
            b r11 = new b("CREATED", 2);
            f2159m = r11;
            b r12 = new b("STARTED", 3);
            f2160n = r12;
            b r13 = new b("RESUMED", 4);
            f2161o = r13;
            f2162p = new b[]{r8, r10, r11, r12, r13};
        }

        public b(String r8, int r10) {
            super(r8, r10);
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f2162p.clone();
        }

        public final boolean a(b r8) {
            if (compareTo(r8) < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public h() {
        new AtomicReference();
    }

    public abstract void a(l r8);

    public abstract b b();

    public abstract void c(l r8);
}
