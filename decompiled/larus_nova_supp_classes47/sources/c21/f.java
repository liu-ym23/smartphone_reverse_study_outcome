package c21;

import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.v0;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.android.livesdk.link.model.w2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class f {
    public final PlayMode a;

    public static final class a extends f {
        public final m3 b;

        public a(int r1, m3 r2) {
            super(PlayMode.PERSONAL_PK);
            this.b = r2;
        }
    }

    public static final class b extends f {
        public final v0 b;

        public b(int r1, PlayMode r2, v0 r3) {
            Intrinsics.checkNotNullParameter(r2, "playMode");
            super(PlayMode.PERSONAL_PK);
            this.b = r3;
        }
    }

    public static final class c extends f {
        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "gameAppId");
            super(PlayMode.PERSONAL_PK);
        }
    }

    public static final class d extends f {
        public final u2 b;
        public final v2 c;

        public d(int r1, PlayMode r2, u2 r3, v2 r4) {
            Intrinsics.checkNotNullParameter(r2, "playMode");
            super(r2);
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class e extends f {
        public final String b;

        public e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "flexActivityId");
            super(PlayMode.PERSONAL_PK);
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: c21.f$f, reason: collision with other inner class name */
    public static final class C0009f extends f {
        public final IBattleConfigSetting b;

        public C0009f(int r1, PlayMode r2, IBattleConfigSetting r3) {
            Intrinsics.checkNotNullParameter(r2, "playMode");
            super(r2);
            this.b = r3;
        }
    }

    public static final class g extends f {
        public final d4 b;

        public g(int r1, PlayMode r2, d4 r3) {
            Intrinsics.checkNotNullParameter(r2, "playMode");
            super(r2);
            this.b = r3;
        }
    }

    public static final class h extends f {
        public h(int r1, PlayMode r2) {
            Intrinsics.checkNotNullParameter(r2, "playMode");
            super(r2);
        }
    }

    public static final class i extends f {
        public i(PlayMode r2) {
            Intrinsics.checkNotNullParameter(r2, "playMode");
            super(PlayMode.PERSONAL_PK);
        }
    }

    public static final class j extends f {
        public static final j b = null;

        static {
            b = new j();
        }

        public j() {
            super(PlayMode.PERSONAL_PK);
        }
    }

    public static final class k extends f {
        public final w2 b;

        public k(int r1, PlayMode r2, w2 r3) {
            Intrinsics.checkNotNullParameter(r2, "playMode");
            super(r2);
            this.b = r3;
        }
    }

    public static final class l extends f {
        public final h9 b;

        public l(int r1, PlayMode r2, h9 r3) {
            Intrinsics.checkNotNullParameter(r2, "playMode");
            super(r2);
            this.b = r3;
        }
    }

    public static final class m extends f {
        public final aa b;

        public m(int r1, aa r2) {
            super(PlayMode.PERSONAL_PK);
            this.b = r2;
        }
    }

    public final String b() {
        if ((this instanceof m) == false) goto L6;
        return "vote";
    L6:
        if ((this instanceof d) == false) goto L9;
        return "customize_pk";
    L9:
        if ((this instanceof e) == false) goto L12;
        return "activity_pk";
    L12:
        if ((this instanceof k) == false) goto L15;
        return "compete";
    L15:
        if ((this instanceof l) == false) goto L18;
        return "focus_gift";
    L18:
        if ((this instanceof a) == false) goto L21;
        return "cooperation";
    L21:
        if ((this instanceof c) == false) goto L24;
        return "cohost_game";
    L24:
        if ((this instanceof i) == false) goto L27;
        return "c_position";
    L27:
        if ((this instanceof b) == false) goto L30;
        return "link_screen";
    L30:
        if ((this instanceof C0009f) == false) goto L33;
        return "interact_compete";
    L33:
        if (this.a != PlayMode.TEAM_PK) goto L35;
        return "team_pk";
    L35:
        return "routine_pk";
    }

    public f(PlayMode r1) {
        this.a = r1;
    }

    public final boolean a(f r2) {
        if ((this instanceof h) == false) goto L7;
        if ((r2 instanceof h) == false) goto L7;
    L46:
        return true;
    L7:
        if ((this instanceof m) == false) goto L11;
        if ((r2 instanceof m) == true) goto L46;
    L11:
        if ((this instanceof e) == false) goto L15;
        if ((r2 instanceof e) == true) goto L46;
    L15:
        if ((this instanceof d) == false) goto L19;
        if ((r2 instanceof d) == true) goto L46;
    L19:
        if ((this instanceof k) == false) goto L23;
        if ((r2 instanceof k) == true) goto L46;
    L23:
        if ((this instanceof a) == false) goto L27;
        if ((r2 instanceof a) == true) goto L46;
    L27:
        if ((this instanceof l) == false) goto L31;
        if ((r2 instanceof l) == true) goto L46;
    L31:
        if ((this instanceof c) == false) goto L35;
        if ((r2 instanceof c) == true) goto L46;
    L35:
        if ((this instanceof i) == false) goto L39;
        if ((r2 instanceof i) == true) goto L46;
    L39:
        if ((this instanceof b) == false) goto L43;
        if ((r2 instanceof b) == true) goto L46;
    L43:
        if ((this instanceof C0009f) == true) goto L45;
    L47:
        return false;
    L45:
        if ((r2 instanceof C0009f) == false) goto L47;
        goto L46
    }
}
