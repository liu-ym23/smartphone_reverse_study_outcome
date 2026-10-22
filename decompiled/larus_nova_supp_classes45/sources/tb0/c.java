package tb0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class c {
    public tb0.b a;
    public final String b;

    public static final class a extends c {
        public a(tb0.b r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            super(r2, "Feed");
        }
    }

    public static final class b extends c {
        public b(tb0.b r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            super(r2, "InRoom");
        }
    }

    /* JADX INFO: renamed from: tb0.c$c, reason: collision with other inner class name */
    public static final class C0281c extends c {
        public static final C0281c c = null;

        public C0281c() {
            super(null, "init");
        }

        static {
            c = new C0281c();
        }
    }

    public c(tb0.b r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
