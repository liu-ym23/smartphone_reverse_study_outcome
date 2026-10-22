package com.ss.ugc.live.sdk.msg.utils.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.sdk.msg.utils.MainTaskScheduler;
import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import com.ss.ugc.live.sdk.msg.utils.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mmc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TaskState<INPUT, OUTPUT, T extends mmc.a<INPUT, OUTPUT>> {
    public T a;
    public b b;
    public long c;
    public final StateMachine<d, a, c> d;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.utils.task.TaskState$a$a, reason: collision with other inner class name */
        public static final class C0233a extends a {
            public final g<?, Throwable> a;

            /* JADX WARN: Multi-variable type inference failed */
            public C0233a(g<?, ? extends Throwable> r2) {
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

    public static final class b<INPUT, OUTPUT, T extends mmc.a<INPUT, OUTPUT>> implements mmc.b<OUTPUT, T> {
        public final mmc.b<OUTPUT, T> a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ mmc.a b;
            public final /* synthetic */ g c;

            public a(b r1, mmc.a r2, g r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.b(this.b, this.c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.utils.task.TaskState$b$b, reason: collision with other inner class name */
        public static final class RunnableC0234b implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ mmc.a b;

            public RunnableC0234b(b r1, mmc.a r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.c(this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class c implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ mmc.a b;

            public c(b r1, mmc.a r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.a(this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(com.ss.ugc.live.sdk.msg.utils.task.d.a r2) {
            Intrinsics.checkNotNullParameter(r2, "delegate");
            this.a = r2;
        }

        @Override // mmc.b
        public final void a(T r2) {
            Intrinsics.checkNotNullParameter(r2, "task");
            MainTaskScheduler.a(new c(this, r2));
        }

        @Override // mmc.b
        public final void c(T r2) {
            Intrinsics.checkNotNullParameter(r2, "task");
            MainTaskScheduler.a(new RunnableC0234b(this, r2));
        }

        @Override // mmc.b
        public final void b(T r2, g<? extends OUTPUT, ? extends Throwable> r3) {
            Intrinsics.checkNotNullParameter(r2, "task");
            Intrinsics.checkNotNullParameter(r3, "result");
            MainTaskScheduler.a(new a(this, r2, r3));
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

        public c() {
        }
    }

    public static abstract class d {

        public static final class a extends d {
            static {
                new a();
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

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.utils.task.TaskState$d$d, reason: collision with other inner class name */
        public static final class C0235d extends d {
            public static final C0235d a = null;

            static {
                a = new C0235d();
            }

            public C0235d() {
            }
        }

        public d() {
        }
    }

    public TaskState() {
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<d, a, c>, Unit> r1 = new TaskState$stateMachine$1(this);
        r0.getClass();
        this.d = StateMachine.a.a(r1);
    }
}
