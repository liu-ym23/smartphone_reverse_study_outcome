package x21;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class d {
    public final String a;

    public static final class a extends d {
        public final f b;

        public a(f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("LINK");
            this.b = r2;
        }
    }

    public static final class b extends d {
        public final g b;

        public b(g r2) {
            Intrinsics.checkNotNullParameter(r2, "penalInfo");
            super("PENAL");
            this.b = r2;
        }
    }

    public static final class c extends d {
        public final h b;

        public c(h r2) {
            Intrinsics.checkNotNullParameter(r2, "pkInfo");
            super("PK");
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: x21.d$d, reason: collision with other inner class name */
    public static final class C0344d extends d {
        public C0344d() {
            super("UNKNOWN");
        }
    }

    public d(String r1) {
        this.a = r1;
    }
}
