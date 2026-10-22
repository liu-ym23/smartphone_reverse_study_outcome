package com.bytedance.android.live.core.tetris.componentx.schedule;

import android.os.Handler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class ComponentBatchBaseLoadState {
    public final Lazy a;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState$a$a, reason: collision with other inner class name */
        public static final class C0152a extends a {
            public C0152a() {
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

        public a() {
        }
    }

    public static abstract class b {
        public final String a;

        public static final class a extends b {
            public static final a b = null;

            static {
                b = new a();
            }

            public a() {
                super("OnAllBatchEnd");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState$b$b, reason: collision with other inner class name */
        public static final class C0153b extends b {
            public static final C0153b b = null;

            static {
                b = new C0153b();
            }

            public C0153b() {
                super("OnComponentInit");
            }
        }

        public static final class c extends b {
            public static final c b = null;

            static {
                b = new c();
            }

            public c() {
                super("OnComponentLoad");
            }
        }

        public static final class d extends b {
            public static final d b = null;

            static {
                b = new d();
            }

            public d() {
                super("OnDestory");
            }
        }

        public b(String r1) {
            this.a = r1;
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
            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState$c$c, reason: collision with other inner class name */
        public static final class C0154c extends c {
            public static final C0154c a = null;

            static {
                a = new C0154c();
            }

            public C0154c() {
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

    public abstract com.bytedance.android.live.core.tetris.componentx.schedule.b b();

    public abstract void c(BatchTogetherConditionManager.BatchLoadConditionType r1);

    public abstract void d();

    public void a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        ((Handler) this.a.getValue()).removeCallbacksAndMessages(null);     // Catch: Throwable -> L4
        d();     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public ComponentBatchBaseLoadState() {
        this.a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ComponentBatchBaseLoadState$sHandler$2.INSTANCE);
    }
}
