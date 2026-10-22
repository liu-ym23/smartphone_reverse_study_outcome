package com.bytedance.android.live.broadcastgame.opengame.utils;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class k<T> {
    public static final /* synthetic */ int b = 0;
    public final String a;

    public static final class a extends k<String> {
        public static final a c = null;

        static {
            c = new a();
        }

        public a() {
            super(OpenPlatformBaseDebugger.APP_ID);
        }
    }

    public static final class b {
    }

    public static final class c extends k<String> {
        public static final c c = null;

        static {
            c = new c();
        }

        public c() {
            super("extra");
        }
    }

    public static final class d extends k<String> {
        public static final d c = null;

        static {
            c = new d();
        }

        public d() {
            super("game_id");
        }
    }

    public static final class e extends k<String> {
        public static final e c = null;

        static {
            c = new e();
        }

        public e() {
            super("game_name");
        }
    }

    public static final class f extends k<Integer> {
        public static final f c = null;

        static {
            c = new f();
        }

        public f() {
            super("game_type");
        }
    }

    public static final class g extends k<String> {
        public static final g c = null;

        static {
            c = new g();
        }

        public g() {
            super("icon");
        }
    }

    public static final class h extends k<Boolean> {
        public static final /* synthetic */ int c = 0;

        static {
        }
    }

    public static final class i extends k<String> {
        public static final i c = null;

        static {
            c = new i();
        }

        public i() {
            super("launch_from");
        }
    }

    public static final class j extends k<List<? extends Integer>> {
        public static final j c = null;

        static {
            c = new j();
        }

        public j() {
            super("support_live_scene");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.utils.k$k, reason: collision with other inner class name */
    public static final class C0089k extends k<String> {
        public static final C0089k c = null;

        static {
            c = new C0089k();
        }

        public C0089k() {
            super("version");
        }
    }

    static {
    }

    public k(String r1) {
        this.a = r1;
    }
}
