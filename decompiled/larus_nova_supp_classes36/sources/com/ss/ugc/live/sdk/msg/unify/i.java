package com.ss.ugc.live.sdk.msg.unify;

import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public final StateMachine<c, a, b> a;
    public final com.ss.ugc.live.sdk.msg.unify.a b;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.i$a$a, reason: collision with other inner class name */
        public static final class C0224a extends a {
            public static final C0224a a = null;

            static {
                a = new C0224a();
            }

            public C0224a() {
            }
        }

        public static final class b extends a {
            static {
                new b();
            }

            public b() {
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.i$b$b, reason: collision with other inner class name */
        public static final class C0225b extends b {
            public static final C0225b a = null;

            static {
                a = new C0225b();
            }

            public C0225b() {
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

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.i$c$c, reason: collision with other inner class name */
        public static final class C0226c extends c {
            public static final C0226c a = null;

            static {
                a = new C0226c();
            }

            public C0226c() {
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

        public c() {
        }
    }

    public i(com.ss.ugc.live.sdk.msg.unify.a r2, final kmc.d r3) {
        Intrinsics.checkNotNullParameter(r2, "stateListener");
        Intrinsics.checkNotNullParameter(r3, "logger");
        this.b = r2;
        StateMachine.a r4 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r0 = new UnifyMessageState$stateMachine$1(this, r3);
        r4.getClass();
        this.a = StateMachine.a.a(r0);
    }
}
