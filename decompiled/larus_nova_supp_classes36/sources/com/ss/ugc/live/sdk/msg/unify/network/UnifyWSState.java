package com.ss.ugc.live.sdk.msg.unify.network;

import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tlc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UnifyWSState implements d {
    public long a;
    public com.ss.ugc.live.sdk.msg.unify.network.b b;
    public d c;
    public final StateMachine<c, a, b> d;
    public final com.ss.ugc.live.sdk.msg.unify.network.c e;
    public final kmc.d f;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState$a$a, reason: collision with other inner class name */
        public static final class C0227a extends a {
            public static final C0227a a = null;

            static {
                a = new C0227a();
            }

            public C0227a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {
            public final String a;

            public c(String r2) {
                Intrinsics.checkNotNullParameter(r2, "reason");
                this.a = r2;
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

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState$b$b, reason: collision with other inner class name */
        public static final class C0228b extends b {
            public static final C0228b a = null;

            static {
                a = new C0228b();
            }

            public C0228b() {
            }
        }

        public static final class c extends b {
            public final String a;

            public c(String r2) {
                Intrinsics.checkNotNullParameter(r2, "reason");
                this.a = r2;
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

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState$c$c, reason: collision with other inner class name */
        public static final class C0229c extends c {
            public static final C0229c a = null;

            static {
                a = new C0229c();
            }

            public C0229c() {
            }
        }

        public c() {
        }
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.network.d
    public final void a() {
        this.d.d(a.b.a);
    }

    public final boolean e() {
        if (Intrinsics.areEqual(this.d.b(), c.a.a) == false) goto L9;
        com.ss.ugc.live.sdk.msg.unify.network.b r0 = this.b;
        if (r0 == null) goto L9;
        if (r0.a() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.network.d
    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.d.d(new a.c(r3));
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.network.d
    public final void d(f r2) {
        Intrinsics.checkNotNullParameter(r2, "payloadItem");
        d r0 = this.c;
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    public final void f(f r2) {
        Intrinsics.checkNotNullParameter(r2, "payloadItem");
        com.ss.ugc.live.sdk.msg.unify.network.b r0 = this.b;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public UnifyWSState(com.ss.ugc.live.sdk.msg.unify.network.c r2, kmc.d r3) {
        Intrinsics.checkNotNullParameter(r2, "wsClient");
        Intrinsics.checkNotNullParameter(r3, "unifyTracer");
        this.e = r2;
        this.f = r3;
        StateMachine.a r4 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r5 = new UnifyWSState$stateMachine$1(this);
        r4.getClass();
        this.d = StateMachine.a.a(r5);
    }

    public final void c(String r2, Map r3, com.ss.ugc.live.sdk.msg.unify.f.b r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "OnUnifyWSListener");
        this.c = r4;
        this.b = this.e.a(r2, r3, this, r5);
        this.d.d(a.C0227a.a);
    }
}
