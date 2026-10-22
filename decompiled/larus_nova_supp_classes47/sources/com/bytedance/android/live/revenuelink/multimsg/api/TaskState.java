package com.bytedance.android.live.revenuelink.multimsg.api;

import com.bytedance.android.live.revenuelink.multimsg.api.c;
import com.bytedance.live.kmp.statemachine.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class TaskState<INPUT, OUTPUT, T extends com.bytedance.android.live.revenuelink.multimsg.api.c<INPUT, OUTPUT>> {
    public T a;
    public MainThreadTaskStateListener b;
    public long c;
    public final StateMachine<c, a, b> d;

    public static final class MainThreadTaskStateListener<INPUT, OUTPUT, T extends com.bytedance.android.live.revenuelink.multimsg.api.c<INPUT, OUTPUT>> implements d<OUTPUT, T> {
        public final d<OUTPUT, T> a;

        public MainThreadTaskStateListener(g.a r2) {
            Intrinsics.checkNotNullParameter(r2, "delegate");
            this.a = r2;
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void b(final T r5) {
            Intrinsics.checkNotNullParameter(r5, "task");
            com.bytedance.live.kmp.util.d.b(0, false, new TaskState$MainThreadTaskStateListener$onTaskInit$1(this, r5), 7);
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void c(final T r5) {
            Intrinsics.checkNotNullParameter(r5, "task");
            com.bytedance.live.kmp.util.d.b(0, false, new TaskState$MainThreadTaskStateListener$onTaskStart$1(this, r5), 7);
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void a(final T r4, final e<? extends OUTPUT, ? extends Exception> r5) {
            Intrinsics.checkNotNullParameter(r4, "task");
            Intrinsics.checkNotNullParameter(r5, "result");
            com.bytedance.live.kmp.util.d.b(0, false, new TaskState$MainThreadTaskStateListener$onTaskFinished$1(this, r4, r5), 7);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.multimsg.api.TaskState$a$a, reason: collision with other inner class name */
        public static final class C0113a extends a {
            public final e<?, Exception> a;

            /* JADX WARN: Multi-variable type inference failed */
            public C0113a(e<?, ? extends Exception> r2) {
                Intrinsics.checkNotNullParameter(r2, "result");
                this.a = r2;
            }
        }

        public static final class b extends a {
            public final Object a;

            public b(Object r1) {
                this.a = r1;
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

        /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.multimsg.api.TaskState$b$b, reason: collision with other inner class name */
        public static final class C0114b extends b {
            public static final C0114b a = null;

            static {
                a = new C0114b();
            }

            public C0114b() {
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {
            static {
                new a();
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

        /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.multimsg.api.TaskState$c$c, reason: collision with other inner class name */
        public static final class C0115c extends c {
            public static final C0115c a = null;

            static {
                a = new C0115c();
            }

            public C0115c() {
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

    public TaskState() {
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r1 = new TaskState$stateMachine$1(this);
        r0.getClass();
        this.d = StateMachine.a.a(r1);
    }
}
