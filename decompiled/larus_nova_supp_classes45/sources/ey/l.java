package ey;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class l {
    public final f a;
    public final f b;

    public static final class a extends l {
        public a(f r2, f.d r3) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, "to");
            super(r2, r3);
        }
    }

    public static final class b extends l {
        public b(f r2) {
            Intrinsics.checkNotNullParameter(r2, "from");
            super(r2, r2);
        }
    }

    public static final class c extends l {
        public c(f r2, f.C0229f r3) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, "to");
            super(r2, r3);
        }
    }

    public static final class d extends l {
        public d(f.C0229f r2, f.C0229f r3) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, "to");
            super(r2, r3);
        }
    }

    public static final class e extends l {
        public e(f.d r2, f r3) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, "to");
            super(r2, r3);
        }
    }

    public l(f r1, f r2) {
        this.a = r1;
        this.b = r2;
    }
}
