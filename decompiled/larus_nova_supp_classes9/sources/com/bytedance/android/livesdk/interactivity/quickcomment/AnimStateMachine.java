package com.bytedance.android.livesdk.interactivity.quickcomment;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AnimStateMachine {
    public final StateMachine<c, a, b> a;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.quickcomment.AnimStateMachine$a$a, reason: collision with other inner class name */
        public static final class C0212a extends a {
            public C0212a() {
            }
        }

        public static final class b extends a {
            public b() {
            }
        }

        public static final class c extends a {
            public c() {
            }
        }

        public static final class d extends a {
            public d() {
            }
        }

        public static final class e extends a {
            public e() {
            }
        }

        public static final class f extends a {
            public f() {
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

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.quickcomment.AnimStateMachine$b$b, reason: collision with other inner class name */
        public static final class C0213b extends b {
            public static final C0213b a = null;

            static {
                a = new C0213b();
            }

            public C0213b() {
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

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.quickcomment.AnimStateMachine$c$c, reason: collision with other inner class name */
        public static final class C0214c extends c {
            public static final C0214c a = null;

            static {
                a = new C0214c();
            }

            public C0214c() {
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

    public AnimStateMachine(final com.bytedance.android.livesdk.interactivity.quickcomment.a r3) {
        Intrinsics.checkNotNullParameter(r3, "controller");
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r1 = new AnimStateMachine$stateMachine$1(r3);
        r0.getClass();
        this.a = StateMachine.a.a(r1);
    }

    public final void a(a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine<c, a, b> r0 = this.a;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }
}
