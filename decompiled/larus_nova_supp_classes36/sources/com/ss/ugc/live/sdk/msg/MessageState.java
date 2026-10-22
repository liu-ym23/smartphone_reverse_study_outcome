package com.ss.ugc.live.sdk.msg;

import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MessageState implements com.ss.ugc.live.sdk.msg.a {
    public final StateMachine<c, a, b> a;
    public final com.ss.ugc.live.sdk.msg.b b;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.MessageState$a$a, reason: collision with other inner class name */
        public static final class C0202a extends a {
            public static final C0202a a = null;

            static {
                a = new C0202a();
            }

            public C0202a() {
            }
        }

        public static final class b extends a {
            public final boolean a;

            public b(boolean r2) {
                this.a = r2;
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

        public static final class d extends a {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public static final class e extends a {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
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

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.MessageState$b$b, reason: collision with other inner class name */
        public static final class C0203b extends b {
            public final boolean a;

            public C0203b(boolean r1) {
                this.a = r1;
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
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
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

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.MessageState$c$c, reason: collision with other inner class name */
        public static final class C0204c extends c {
            public static final C0204c a = null;

            static {
                a = new C0204c();
            }

            public C0204c() {
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

        public c() {
        }
    }

    @Override // com.ss.ugc.live.sdk.msg.a
    public final boolean isRunning() {
        return Intrinsics.areEqual(this.a.b(), c.e.a);
    }

    public MessageState(com.ss.ugc.live.sdk.msg.b r2, final vlc.c r3) {
        Intrinsics.checkNotNullParameter(r2, "stateListener");
        Intrinsics.checkNotNullParameter(r3, "logger");
        this.b = r2;
        StateMachine.a r4 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r0 = new MessageState$stateMachine$1(this, r3);
        r4.getClass();
        this.a = StateMachine.a.a(r0);
    }
}
