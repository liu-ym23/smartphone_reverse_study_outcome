package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedPkStateMachine {
    public static final /* synthetic */ int k = 0;
    public w a;
    public t b;
    public q c;
    public final d41.c d;
    public final d41.c e;
    public final d41.a f;
    public final d41.f g;
    public final FeedPkMachinePresenter h;
    public final StateMachine<l, e, k> i;
    public final Function1<StateMachine.c<? extends l, ? extends e, ? extends k>, Unit> j;

    public static final class a {
    }

    public static final class b implements m, d41.d, d41.b, d41.g {
        public final /* synthetic */ FeedPkStateMachine a;

        @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.n
        public final void a() {
            FeedPkStateMachine r0 = this.a;
            l r1 = r0.a();
            if ((r1 instanceof l.c) == false) goto L6;
            ((l.c) r1).c.a = false;
            r0.g.a();
            return;
        }

        @Override // d41.g
        public final void b() {
            FeedPkMachinePresenter r0 = this.a.h;
            IRoom r1 = r0.b;
            if (r1 == null) goto L7;
            r0.d(r1, new h(r0));
            return;
        }

        @Override // d41.g
        public final boolean c() {
            l r0 = this.a.a();
            if ((r0 instanceof l.c) == true) goto L5;
            r0 = null;
        L5:
            l.c r1 = (l.c) r0;
            if (r1 == null) goto L10;
            v r2 = r1.c;
            if (r2 == null) goto L10;
            return r2.a;
        L10:
            return false;
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.n
        public final l getState() {
            return this.a.a();
        }

        public b(FeedPkStateMachine r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.y
        public final void d(long r4) {
            FeedPkStateMachine r0 = this.a;
            l r1 = r0.a();
            if ((r1 instanceof l.a) == false) goto L6;
            p r2 = ((l.a) r1).c;
            r2.a = r4;
            r2.b = true;
            r0.f.update(RangesKt.coerceAtLeast(com.bytedance.live.kmp.util.e.a() - r4, 0) / 1000);
            return;
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.n
        public final void f(e r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            StateMachine<l, e, k> r0 = this.a.i;
            StateMachine.a r1 = StateMachine.c;
            r0.d(r3, null);
        }

        @Override // d41.b
        public final void e(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            q r4 = this.a.c;
            if (r4 == null) goto L6;
            r4.d(r3);
            return;
        }

        @Override // d41.d
        public final void g(String r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "name");
            FeedPkStateMachine r0 = this.a;
            r0.getClass();
            if (Intrinsics.areEqual(r4, "pk_left_timer") == false) goto L10;
            if (r5 != 0) goto L6;
            r0.g.b();
        L6:
            w r1 = r0.a;
            if (r1 == null) goto L10;
            r1.h(r5);
        L10:
            if (Intrinsics.areEqual(r4, "penal_left_timer") == false) goto L17;
            if (r5 != 0) goto L13;
            FeedPkMachinePresenter r6 = r0.h;
            r6.getClass();
            r6.i(new e.b(r6.f()));
        L13:
            t r7 = r0.b;
            if (r7 == null) goto L18;
            r7.g(r5);
            return;
        L18:
            return;
        }
    }

    static {
    }

    public final l a() {
        return (l) this.i.b();
    }

    public FeedPkStateMachine(Function1<? super StateMachine.c<? extends l, ? extends e, ? extends k>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.j = r3;
        b r4 = new b(this);
        this.d = new d41.c("pk_left_timer", r4);
        this.e = new d41.c("penal_left_timer", r4);
        this.f = new d41.a("link_timer", r4);
        this.g = new d41.f(r4);
        this.h = new FeedPkMachinePresenter(r4);
        StateMachine.a r5 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<l, e, k>, Unit> r0 = new FeedPkStateMachine$stateMachine$1(this);
        r5.getClass();
        this.i = StateMachine.a.a(r0);
    }
}
