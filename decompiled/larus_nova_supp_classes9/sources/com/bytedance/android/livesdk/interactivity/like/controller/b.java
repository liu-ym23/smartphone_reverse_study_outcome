package com.bytedance.android.livesdk.interactivity.like.controller;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.message.model.d4;
import com.bytedance.android.livesdkapi.message.Text;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final StateMachine<e, AbstractC0171b, d> a;

    public static final class a {
        public final long a;
        public final com.bytedance.android.livesdk.interactivity.api.like.model.a b;
        public final List<d4> c;
        public final Text d;
        public final Text e;

        public a() {
            this(0, null, null, null, null, 31);
        }

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L16;
            a r7 = (a) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            com.bytedance.android.livesdk.interactivity.api.like.model.a r2 = this.b;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            int r5 = (r1 + r4) * 31;
            List<d4> r6 = this.c;
            if (r6 == null) goto L9;
            int r7 = r6.hashCode();
        L10:
            int r8 = (r5 + r7) * 31;
            Text r9 = this.d;
            if (r9 == null) goto L13;
            int r10 = r9.hashCode();
        L14:
            int r11 = (r8 + r10) * 31;
            Text r13 = this.e;
            if (r13 == null) goto L18;
            r3 = r13.hashCode();
        L18:
            return r11 + r3;
        L13:
            r10 = 0;
            goto L14
        L9:
            r7 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        public final String toString() {
            return "DoubleLikeInfo(msgId=" + this.a + ", detail=" + this.b + ", rankList=" + this.c + ", normalSummary=" + this.d + ", joinSummary=" + this.e + ")";
        }

        public a(long r3, com.bytedance.android.livesdk.interactivity.api.like.model.a r5, List r6, Text r7, Text r8, int r9) {
            if ((r9 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r9 & 2) == 0) goto L9;
            r5 = null;
        L9:
            if ((r9 & 4) == 0) goto L12;
            r6 = null;
        L12:
            if ((r9 & 8) == 0) goto L15;
            r7 = null;
        L15:
            if ((r9 & 16) == 0) goto L17;
            r8 = null;
        L17:
            this.a = r3;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0171b {
        public final String a;
        public final a b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$b$a */
        public static final class a extends AbstractC0171b {
            public a(a r2) {
                Intrinsics.checkNotNullParameter(r2, "info");
                super("EndEvent", r2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$b$b, reason: collision with other inner class name */
        public static final class C0172b extends AbstractC0171b {
            public C0172b(a r2) {
                Intrinsics.checkNotNullParameter(r2, "info");
                super("StartEvent", r2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$b$c */
        public static final class c extends AbstractC0171b {
            public c(a r2) {
                Intrinsics.checkNotNullParameter(r2, "info");
                super("SummaryEvent", r2);
            }
        }

        public AbstractC0171b(String r1, a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface c {
        void a(a r1);

        void b(a r1);

        void c(a r1);

        void d(a r1);
    }

    public static abstract class d {
        public final String a;

        public static final class a extends d {
            public static final a b = null;

            static {
                b = new a();
            }

            public a() {
                super("EndActivity");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$d$b, reason: collision with other inner class name */
        public static final class C0173b extends d {
            public static final C0173b b = null;

            static {
                b = new C0173b();
            }

            public C0173b() {
                super("StartActivity");
            }
        }

        public static final class c extends d {
            public static final c b = null;

            static {
                b = new c();
            }

            public c() {
                super("SummaryActivity");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$d$d, reason: collision with other inner class name */
        public static final class C0174d extends d {
            public static final C0174d b = null;

            static {
                b = new C0174d();
            }

            public C0174d() {
                super("UpdateActivity");
            }
        }

        public d(String r1) {
            this.a = r1;
        }
    }

    public static abstract class e {
        public final String a;

        public static final class a extends e {
            public static final a b = null;

            static {
                b = new a();
            }

            public a() {
                super("Activity");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$e$b, reason: collision with other inner class name */
        public static final class C0175b extends e {
            public static final C0175b b = null;

            static {
                b = new C0175b();
            }

            public C0175b() {
                super("Idle");
            }
        }

        public static final class c extends e {
            public static final c b = null;

            static {
                b = new c();
            }

            public c() {
                super("Summary");
            }
        }

        public e(String r1) {
            this.a = r1;
        }
    }

    public b(final DoubleLikeManager.a r3) {
        Intrinsics.checkNotNullParameter(r3, "controller");
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<e, AbstractC0171b, d>, Unit> r1 = new DoubleLikeStateMachine$stateMachine$1(r3);
        r0.getClass();
        this.a = StateMachine.a.a(r1);
    }

    public final void a(AbstractC0171b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine<e, AbstractC0171b, d> r0 = this.a;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }
}
