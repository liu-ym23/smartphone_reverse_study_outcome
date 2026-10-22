package o91;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b {

    public static final class a extends n {
        public a() {
            super("anchor_text", "主播侧可动态更新文案展示");
        }
    }

    /* JADX INFO: renamed from: o91.b$b, reason: collision with other inner class name */
    public static final class C0286b extends n {
        public C0286b() {
            super("audience_image", "看播侧常驻icon类型展示");
        }
    }

    public static final class c extends n {
        public c() {
            super("audience_image_and_text", "看播侧常驻icon+文案类型展示");
        }
    }

    public static final class d extends n {
        public d() {
            super("audience_text", "看播侧常驻文案展示类型");
        }
    }

    public static final class e {
    }

    public static final class f extends n {
        public f() {
            super("digg", "点赞");
        }
    }

    public static final class g extends n {
        public g() {
            super("digg_temporary", "临时展示的点赞，会自动消失");
        }
    }

    public static final class h extends n {
        public h() {
            super("double_like", "双赞加成");
        }
    }

    public static final class i extends n {
        public static final i b = null;

        static {
            b = new i();
        }

        public i() {
            super("empty", "占位，不携带任何数据");
        }
    }

    public static final class j extends n {
        public static final j b = null;

        static {
            b = new j();
        }

        public j() {
            super("nickname", "昵称");
        }
    }

    public static final class k extends n {
        public k() {
            super("pv", "观看人次");
        }
    }

    public static final class l extends n {
        public l() {
            super("ticket", "音浪");
        }
    }

    public static final class m extends n {
        public m() {
            super("uv", "在线人数");
        }
    }

    public static class n extends b {
        public final String a;

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "WithNameTab(name='" + this.a + "')";
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L5;
            return true;
        L5:
            Class<?> r1 = getClass();
            if (r4 == null) goto L8;
            Class<?> r2 = r4.getClass();
        L10:
            if ((!Intrinsics.areEqual(r1, r2)) == false) goto L12;
            return false;
        L12:
            if (r4 == null) goto L18;
            if ((!Intrinsics.areEqual(this.a, ((n) r4).a)) == false) goto L16;
            return false;
        L16:
            return true;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.navi.userinfo_p.flipper.business.TabType.WithNameTab");
        L8:
            r2 = null;
            goto L10
        }

        public n(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "desc");
            this.a = r2;
        }
    }

    static {
    }

    public b() {
    }
}
