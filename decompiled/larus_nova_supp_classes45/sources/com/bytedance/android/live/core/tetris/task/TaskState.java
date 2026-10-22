package com.bytedance.android.live.core.tetris.task;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.StateMachine;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import y70.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class TaskState<T extends y70.a> {
    public T a;
    public b b;
    public long c;
    public final StateMachine<d, a, c> d;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.task.TaskState$a$a, reason: collision with other inner class name */
        public static final class C0162a extends a {
            public static final C0162a a = null;

            static {
                a = new C0162a();
            }

            public C0162a() {
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

    public static final class b<T extends y70.a> implements y70.b<T> {
        public final y70.b<T> a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ y70.a b;

            public a(b r1, y70.a r2) {
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

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.task.TaskState$b$b, reason: collision with other inner class name */
        public static final class RunnableC0163b implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ y70.a b;

            public RunnableC0163b(b r1, y70.a r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.d(this.b);     // Catch: Throwable -> L4
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
            public final /* synthetic */ y70.a b;

            public c(b r1, y70.a r2) {
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

        public static final class d implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ y70.a b;

            public d(b r1, y70.a r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.b(this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(y70.b<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "delegate");
            this.a = r2;
        }

        @Override // y70.b
        public final void a(T r2) {
            Intrinsics.checkNotNullParameter(r2, "task");
            MainThreadPostUtils.e(new a(this, r2));
        }

        @Override // y70.b
        public final void b(T r2) {
            Intrinsics.checkNotNullParameter(r2, "task");
            MainThreadPostUtils.e(new d(this, r2));
        }

        @Override // y70.b
        public final void c(T r2) {
            Intrinsics.checkNotNullParameter(r2, "task");
            MainThreadPostUtils.e(new c(this, r2));
        }

        @Override // y70.b
        public final void d(T r2) {
            Intrinsics.checkNotNullParameter(r2, "task");
            MainThreadPostUtils.e(new RunnableC0163b(this, r2));
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

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.task.TaskState$c$c, reason: collision with other inner class name */
        public static final class C0164c extends c {
            public static final C0164c a = null;

            static {
                a = new C0164c();
            }

            public C0164c() {
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

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.task.TaskState$d$d, reason: collision with other inner class name */
        public static final class C0165d extends d {
            public static final C0165d a = null;

            static {
                a = new C0165d();
            }

            public C0165d() {
            }
        }

        public d() {
        }
    }

    public final boolean b() {
        if (Intrinsics.areEqual(this.d.b(), d.C0165d.a) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.d.b(), d.a.a) == true) goto L8;
        return false;
    }

    public TaskState() {
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<d, a, c>, Unit> r1 = new TaskState$stateMachine$1(this);
        r0.getClass();
        this.d = StateMachine.a.a(r1);
    }

    public static final /* synthetic */ y70.a a(TaskState r1) {
        T r2 = r1.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("task");
    L5:
        return r2;
    }
}
