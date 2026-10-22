package com.bytedance.android.live.broadcastgame.opengame.runtime;

import com.bytedance.android.live.core.utils.StateMachine;
import java.io.File;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y {
    public final StateMachine<d, b, c> a;
    public final com.bytedance.android.live.broadcastgame.opengame.t b;
    public final p c;
    public final Function1<b, Unit> d;

    public static final class a {
    }

    public static abstract class b {

        public static final class a extends b {
            public final com.bytedance.android.live.broadcastgame.opengame.runtime.g a;

            public a(com.bytedance.android.live.broadcastgame.opengame.runtime.g r2) {
                Intrinsics.checkNotNullParameter(r2, "bootInfo");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.runtime.y$b$b, reason: collision with other inner class name */
        public static final class C0080b extends b {
            public final String a;

            public C0080b(String r2) {
                Intrinsics.checkNotNullParameter(r2, "error");
                this.a = r2;
            }
        }

        public static final class c extends b {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends b {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public static final class e extends b {
            public final File a;

            public e(File r1) {
                this.a = r1;
            }
        }

        public static final class f extends b {
            public static final f a = null;

            static {
                a = new f();
            }

            public f() {
            }
        }

        public static final class g extends b {
            public final Map<String, String> a;

            public g(Map<String, String> r1) {
                this.a = r1;
            }
        }

        public static final class h extends b {
            public static final h a = null;

            static {
                a = new h();
            }

            public h() {
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.runtime.y$c$c, reason: collision with other inner class name */
        public static final class C0081c extends c {
            public static final C0081c a = null;

            static {
                a = new C0081c();
            }

            public C0081c() {
            }
        }

        public static final class d extends c {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public static final class e extends c {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }
        }

        public static final class f extends c {
            public static final f a = null;

            static {
                a = new f();
            }

            public f() {
            }
        }

        public c() {
        }
    }

    public static abstract class d {

        public static final class a extends d {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public static final class b extends d {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends d {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.runtime.y$d$d, reason: collision with other inner class name */
        public static final class C0082d extends d {
            public static final C0082d a = null;

            static {
                a = new C0082d();
            }

            public C0082d() {
            }
        }

        public static final class e extends d {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }
        }

        public static final class f extends d {
            public static final f a = null;

            static {
                a = new f();
            }

            public f() {
            }
        }

        public static final class g extends d {
            public static final g a = null;

            static {
                a = new g();
            }

            public g() {
            }
        }

        public static final class h extends d {
            public static final h a = null;

            static {
                a = new h();
            }

            public h() {
            }
        }

        public d() {
        }
    }

    static {
    }

    public final void a(b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine<d, b, c> r0 = this.a;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }

    public y(com.bytedance.android.live.broadcastgame.opengame.t r2, OpenApiSupportPluginRuntime r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "gameInfo");
        Intrinsics.checkNotNullParameter(r3, "pluginLifecycle");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        StateMachine.a r5 = StateMachine.c;
        LivePluginState$stateMachine$1 r6 = new LivePluginState$stateMachine$1(this);
        r5.getClass();
        this.a = StateMachine.a.a(r6);
    }
}
