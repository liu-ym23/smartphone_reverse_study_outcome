package o51;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.link.core.UILayoutIOSIndex;
import com.bytedance.android.live.revlink.link.core.UILayoutLayoutConfigIndex;
import com.bytedance.android.live.revlink.link.core.UILayoutServerIndex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class f {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public static final class a extends f {
        public a(int r3) {
            super("common", UILayoutServerIndex.Normal.ordinal(), r3, r3);
        }
    }

    public static final class b extends f {
        public static final b e = null;

        static {
            e = new b();
        }

        public b() {
            super("focus", UILayoutServerIndex.Focus.ordinal(), UILayoutLayoutConfigIndex.Focus.getLayoutKey(), UILayoutIOSIndex.MultiFocus.ordinal());
        }
    }

    public static final class c extends f {
        public static final c e = null;

        static {
            e = new c();
        }

        public c() {
            super("full", UILayoutServerIndex.Full.ordinal(), UILayoutLayoutConfigIndex.Full.getLayoutKey(), UILayoutIOSIndex.MultiFullIncludeScreenV.ordinal());
        }
    }

    public static final class d extends f {
        public static final d e = null;

        static {
            e = new d();
        }

        public d() {
            super("full_record", UILayoutServerIndex.Full.ordinal(), UILayoutLayoutConfigIndex.FullRecord.getLayoutKey(), UILayoutIOSIndex.MultiFullScreenH.ordinal());
        }
    }

    public static final class e extends f {
        public static final e e = null;

        static {
            e = new e();
        }

        public e() {
            super("full_record_norma", UILayoutServerIndex.Full.ordinal(), UILayoutLayoutConfigIndex.FullRecordNormal.getLayoutKey(), UILayoutIOSIndex.MultiFullIncludeScreenV.ordinal());
        }
    }

    /* JADX INFO: renamed from: o51.f$f, reason: collision with other inner class name */
    public static final class C0284f extends f {
        public static final C0284f e = null;

        static {
            e = new C0284f();
        }

        public C0284f() {
            super("link_game_horizontal", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.LinkGameHorizontal.getLayoutKey(), UILayoutIOSIndex.LinkGameHorizontal.ordinal());
        }
    }

    public static final class g extends f {
        public static final g e = null;

        static {
            e = new g();
        }

        public g() {
            super("link_game_landscape", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.LinkGameLandscape.ordinal(), UILayoutIOSIndex.MultiNormal.ordinal());
        }
    }

    public static final class h extends f {
        public static final h e = null;

        static {
            e = new h();
        }

        public h() {
            super("media_focus", UILayoutServerIndex.Focus.ordinal(), UILayoutLayoutConfigIndex.Focus.getLayoutKey(), UILayoutIOSIndex.MultiFocus.ordinal());
        }
    }

    public static final class i extends f {
        public static final i e = null;

        static {
            e = new i();
        }

        public i() {
            super("media_normal", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.Normal.getLayoutKey(), UILayoutIOSIndex.MultiNormal.ordinal());
        }
    }

    public static final class j extends f {
        public static final j e = null;

        static {
            e = new j();
        }

        public j() {
            super(DataType.Normal, UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.Normal.getLayoutKey(), UILayoutIOSIndex.MultiNormal.ordinal());
        }
    }

    public static final class k extends f {
        public static final k e = null;

        static {
            e = new k();
        }

        public k() {
            super("pk", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.PK.getLayoutKey(), UILayoutIOSIndex.DoublePK.ordinal());
        }
    }

    public static final class l extends f {
        public static final l e = null;

        static {
            e = new l();
        }

        public l() {
            super("pk_game", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.PKGame.getLayoutKey(), UILayoutIOSIndex.PKGame.ordinal());
        }
    }

    public static final class m extends f {
        public static final m e = null;

        static {
            e = new m();
        }

        public m() {
            super("pk_game_full", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.PKGameFull.getLayoutKey(), UILayoutIOSIndex.PKGame.ordinal());
        }
    }

    public static final class n extends f {
        public static final n e = null;

        static {
            e = new n();
        }

        public n() {
            super("pk_with_audience", UILayoutServerIndex.Normal.ordinal(), UILayoutLayoutConfigIndex.PKWithAudience.getLayoutKey(), UILayoutIOSIndex.PKWithGuest.ordinal());
        }
    }

    public final boolean a() {
        if ((this instanceof c) == false) goto L5;
    L10:
        return true;
    L5:
        if ((this instanceof d) == true) goto L10;
        if ((this instanceof e) == true) goto L10;
        return false;
    }

    public f(String r1, int r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
