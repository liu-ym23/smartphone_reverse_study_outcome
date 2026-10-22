package jf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b {
    public final String a;

    public static final class a extends b {
        public static final /* synthetic */ int b = 0;

        static {
        }
    }

    /* JADX INFO: renamed from: jf.b$b, reason: collision with other inner class name */
    public static final class C0170b extends b {
        public static final C0170b b = null;

        static {
            b = new C0170b();
        }

        public C0170b() {
            super("buynow_part");
        }
    }

    public static final class c extends b {
        public c(String r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            super(r10);
        }
    }

    public static final class d extends b {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
            super("default");
        }
    }

    public static final class e extends b {
        public static final e b = null;

        static {
            b = new e();
        }

        public e() {
            super("live_auction_card");
        }
    }

    public static final class f extends b {
        public static final f b = null;

        static {
            b = new f();
        }

        public f() {
            super("live_list_card");
        }
    }

    public static final class g extends b {
        public static final g b = null;

        static {
            b = new g();
        }

        public g() {
            super("live_popup_card");
        }
    }

    public static final class h extends b {
        public static final h b = null;

        static {
            b = new h();
        }

        public h() {
            super("live_popup_related");
        }
    }

    public static final class i extends b {
        public static final i b = null;

        static {
            b = new i();
        }

        public i() {
            super("replay_live_card");
        }
    }

    public static final class j extends b {
        public static final j b = null;

        static {
            b = new j();
        }

        public j() {
            super(com.bytedance.android.ec.core.event.a.VALUE_REPlAY_POPUP_CARD);
        }
    }

    public static final class k extends b {
        public static final k b = null;

        static {
            b = new k();
        }

        public k() {
            super(com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        }
    }

    public static final class l extends b {
        public static final l b = null;

        static {
            b = new l();
        }

        public l() {
            super("live_list_card");
        }
    }

    public static final class m extends b {
        public static final m b = null;

        static {
            b = new m();
        }

        public m() {
            super("user_info");
        }
    }

    public b(String r1) {
        this.a = r1;
    }
}
