package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i1 implements j1 {
    public final Function0<Completable> a;
    public final String b;
    public final Function2<l1, m1, Unit> c;

    public final class a implements l1 {
        public final i1 a;
        public m1 b;
        public final Completable c;
        public final /* synthetic */ i1 d;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.i1$a$a, reason: collision with other inner class name */
        public static final class C0103a<T> implements Consumer {
            public final /* synthetic */ a a;

            public C0103a(a r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Disposable r3 = (Disposable) r2;
                this.a.b(new m1.e());
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            public final void accept(Object r5) {
                Throwable r6 = (Throwable) r5;
                a r0 = this.a;
                if (r6 != null) goto L9;
                m1 r2 = this.a.b;
                if (r2 == null) goto L8;
                m1 r7 = new m1.b((m1.e) r2);
            L12:
                r0.b(r7);
                return;
            L8:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.xplay.XplayTaskState.Running");
            L9:
                m1 r3 = this.a.b;
                if (r3 == null) goto L15;
                r7 = new m1.c((m1.e) r3, r6);
                goto L12
            L15:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.xplay.XplayTaskState.Running");
            }
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.l1
        public final Completable a() {
            return this.c;
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.l1
        public final j1 getTask() {
            return this.a;
        }

        public a(i1 r2) {
            this.d = r2;
            this.a = r2;
            m1.d r0 = m1.d.a;
            this.b = r0;
            Completable r3 = (Completable) r2.a.invoke();
            if (r3 != null) goto L5;
            b(m1.f.a);
            this.c = Completable.complete();
            return;
        L5:
            b(r0);
            this.c = r3.doOnSubscribe(new C0103a(this)).doOnEvent(new b(this));
        }

        public final void b(m1 r8) {
            Intrinsics.checkNotNullParameter(r8, "value");
            this.b = r8;
            if ((r8 instanceof m1.d) == false) goto L6;
        L17:
            Function2<l1, m1, Unit> r0 = this.d.c;
            if (r0 == null) goto L21;
            Unit r9 = (Unit) r0.invoke(this, r8);
            return;
        L21:
            return;
        L6:
            if ((r8 instanceof m1.f) == false) goto L9;
            int r1 = XplayLog.a;
            XplayLog.c("XplayTask", "task '" + this.d.b + "' skipped");
            goto L17
        L9:
            if ((r8 instanceof m1.e) == false) goto L12;
            int r2 = XplayLog.a;
            XplayLog.c("XplayTask", "task '" + this.d.b + "' started");
            goto L17
        L12:
            if ((r8 instanceof m1.b) == false) goto L15;
            int r3 = XplayLog.a;
            XplayLog.c("XplayTask", "task '" + this.d.b + "' completed in " + ((m1.b) r8).a().longValue() + "ms");
            goto L17
        L15:
            if ((r8 instanceof m1.c) == false) goto L17;
            int r4 = XplayLog.a;
            StringBuilder r5 = new StringBuilder("task '");
            r5.append(this.d.b);
            r5.append("' failed in ");
            m1.c r6 = (m1.c) r8;
            r5.append(Long.valueOf(Long.valueOf(r6.b).longValue() - Long.valueOf(r6.a).longValue()).longValue());
            r5.append("ms: ");
            Throwable r7 = r6.c;
            PublishSubject<Unit> r11 = q1.a;
            Intrinsics.checkNotNullParameter(r7, "$this$printStackTraceAsString");
            StringWriter r12 = new StringWriter();
            r7.printStackTrace(new PrintWriter(r12));
            r5.append(r12.toString());
            XplayLog.b("XplayTask", r5.toString());
            goto L17
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.j1
    public final l1 a() {
        return new a(this);
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.j1
    public final String getName() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i1(Function0<? extends Completable> r2, String r3, Function2<? super l1, ? super m1, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "actionProvider");
        Intrinsics.checkNotNullParameter(r3, "name");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
