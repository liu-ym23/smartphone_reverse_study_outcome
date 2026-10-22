package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class k implements j1 {
    public final List<j1> a;
    public final Function2<l1, m1, Unit> b;

    public final class a implements l1 {
        public final k a;
        public m1 b;
        public final Completable c;
        public final Collection<l1> d;
        public final /* synthetic */ k e;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.k$a$a, reason: collision with other inner class name */
        public static final class C0104a<T> implements Consumer {
            public final /* synthetic */ a a;

            public C0104a(a r1) {
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

        public a(k r4) {
            this.e = r4;
            this.a = r4;
            this.b = m1.d.a;
            List<j1> r0 = r4.a;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            r1.add(((j1) r2.next()).a());
            goto L4
        L6:
            this.d = r1;
            b(m1.d.a);
            this.c = r4.b(r1).doOnSubscribe(new C0104a(this)).doOnEvent(new b(this));
        }

        public final void b(m1 r8) {
            Intrinsics.checkNotNullParameter(r8, "value");
            this.b = r8;
            if ((r8 instanceof m1.d) == false) goto L6;
        L17:
            Function2<l1, m1, Unit> r0 = this.e.b;
            if (r0 == null) goto L21;
            Unit r9 = (Unit) r0.invoke(this, r8);
            return;
        L21:
            return;
        L6:
            if ((r8 instanceof m1.f) == false) goto L9;
            int r1 = XplayLog.a;
            XplayLog.c("XplayTask", "composite task '" + this.e.getName() + "' skipped");
            goto L17
        L9:
            if ((r8 instanceof m1.e) == false) goto L12;
            int r2 = XplayLog.a;
            XplayLog.c("XplayTask", "composite task '" + this.e.getName() + "' started");
            goto L17
        L12:
            if ((r8 instanceof m1.b) == false) goto L15;
            int r3 = XplayLog.a;
            XplayLog.c("XplayTask", "composite task '" + this.e.getName() + "' completed in " + ((m1.b) r8).a().longValue() + "ms");
            goto L17
        L15:
            if ((r8 instanceof m1.c) == false) goto L17;
            int r4 = XplayLog.a;
            StringBuilder r5 = new StringBuilder("composite task '");
            r5.append(this.e.getName());
            r5.append("' failed in ");
            m1.c r6 = (m1.c) r8;
            r5.append(Long.valueOf(Long.valueOf(r6.b).longValue() - Long.valueOf(r6.a).longValue()).longValue());
            r5.append("ms: ");
            r5.append(r6.c);
            XplayLog.b("XplayTask", r5.toString());
            goto L17
        }
    }

    public abstract Completable b(Collection<? extends l1> r1);

    @Override // com.bytedance.android.live.broadcastgame.xplay.j1
    public final l1 a() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(List<? extends j1> r2, Function2<? super l1, ? super m1, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "tasks");
        this.a = r2;
        this.b = r3;
    }
}
