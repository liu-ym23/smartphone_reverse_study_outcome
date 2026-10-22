package h31;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.w2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class h {
    public final h31.b a;

    public static final class a extends h {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super(h31.b.a.b);
        }
    }

    public static final class b extends h {
        public final IBattleConfigSetting b;

        public b(IBattleConfigSetting r2) {
            Intrinsics.checkNotNullParameter(r2, "battleConfigSetting");
            super(h31.b.C0247b.b);
            this.b = r2;
        }
    }

    public static final class c extends h {
        public final d4 b;

        public c(d4 r2) {
            Intrinsics.checkNotNullParameter(r2, "customConfig");
            super(h31.b.c.b);
            this.b = r2;
        }
    }

    public static final class d extends h {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
            super(h31.b.d.b);
        }
    }

    public static final class e extends h {
        public final w2 b;

        public e(w2 r2) {
            Intrinsics.checkNotNullParameter(r2, "shellConfig");
            super(h31.b.f.b);
            this.b = r2;
        }
    }

    public static final class f extends h {
        public final h9 b;

        public f(h9 r2) {
            Intrinsics.checkNotNullParameter(r2, "specifyGiftConfig");
            super(h31.b.g.b);
            this.b = r2;
        }
    }

    public static final class g extends h {
        public static final g b = null;

        static {
            b = new g();
        }

        public g() {
            super(h31.b.h.b);
        }
    }

    /* JADX INFO: renamed from: h31.h$h, reason: collision with other inner class name */
    public static final class C0248h extends h {
        public static final C0248h b = null;

        static {
            b = new C0248h();
        }

        public C0248h() {
            super(h31.b.i.b);
        }
    }

    public static final class i extends h {
        public i() {
            super(h31.b.e.b);
        }
    }

    public h(h31.b r1) {
        this.a = r1;
    }
}
