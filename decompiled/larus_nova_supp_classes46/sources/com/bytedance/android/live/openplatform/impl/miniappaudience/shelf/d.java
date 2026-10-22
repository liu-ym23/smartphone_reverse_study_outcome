package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public Long a;
    public Long b;
    public long c;
    public long d;
    public final StateMachine<AbstractC0177d, b, c> e;
    public final a f;

    public interface a {
        void a();

        void b(long r1, long r3);
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

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$b$b, reason: collision with other inner class name */
        public static final class C0173b extends b {
            public static final C0173b a = null;

            static {
                a = new C0173b();
            }

            public C0173b() {
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

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$b$d, reason: collision with other inner class name */
        public static final class C0174d extends b {
            public static final C0174d a = null;

            static {
                a = new C0174d();
            }

            public C0174d() {
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

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$c$c, reason: collision with other inner class name */
        public static final class C0175c extends c {
            public static final C0175c a = null;

            static {
                a = new C0175c();
            }

            public C0175c() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$c$d, reason: collision with other inner class name */
        public static final class C0176d extends c {
            public static final C0176d a = null;

            static {
                a = new C0176d();
            }

            public C0176d() {
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

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$d, reason: collision with other inner class name */
    public static abstract class AbstractC0177d {

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$d$a */
        public static final class a extends AbstractC0177d {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$d$b */
        public static final class b extends AbstractC0177d {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$d$c */
        public static final class c extends AbstractC0177d {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$d$d, reason: collision with other inner class name */
        public static final class C0178d extends AbstractC0177d {
            public static final C0178d a = null;

            static {
                a = new C0178d();
            }

            public C0178d() {
            }
        }

        public AbstractC0177d() {
        }
    }

    public d(AudienceShelfDisplayDialog.f r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.f = r2;
        StateMachine.a r3 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<AbstractC0177d, b, c>, Unit> r0 = new AudienceShelfState$shelfState$1(this);
        r3.getClass();
        this.e = StateMachine.a.a(r0);
    }

    public final void a(b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine<AbstractC0177d, b, c> r0 = this.e;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }
}
