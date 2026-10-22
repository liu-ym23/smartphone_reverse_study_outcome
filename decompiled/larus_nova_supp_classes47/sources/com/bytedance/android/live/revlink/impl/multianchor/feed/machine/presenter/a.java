package com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.bridge.f2;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.y4;
import com.bytedance.android.livesdk.message.model.v8;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final CompositeDisposable a;
    public boolean b;
    public long c;
    public boolean d;
    public p0 e;
    public final MutableLiveData<List<p>> f;
    public final List<p> g;
    public final Lazy h;
    public Long i;
    public com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d j;
    public final f k;
    public final e l;
    public final Function1<r, Unit> m;
    public final Function1<r, Unit> n;
    public final Function1<r, Unit> o;
    public final Function1<r, Unit> p;
    public final z21.a q;
    public final InterfaceC0141a r;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a$a, reason: collision with other inner class name */
    public interface InterfaceC0141a {
        void a();

        void d(long r1);

        void e(x21.a r1);

        i f();

        x21.d getState();
    }

    public static final class b {
        public final long a;
        public final long b;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L10;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            return r1 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "ReqListParam(roomId=" + this.a + ", channelId=" + this.b + ")";
        }

        public b(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public final x21.f e() {
        Long r0 = this.i;
        x21.d r1 = this.r.getState();
        if (r0 == null) goto L6;
        return new x21.f(r0.longValue(), true);
    L6:
        if ((r1 instanceof x21.d.a) == false) goto L9;
        x21.f r2 = ((x21.d.a) r1).b;
        return new x21.f(r2.a, r2.b);
    L9:
        return new x21.f(com.bytedance.live.kmp.util.e.a(), false);
    }

    public static x21.g c(c1 r8) {
        long r0 = af2.d.b(r8);
        if (r8.getPunishStartTimeMs() == 0) goto L6;
        long r2 = r8.getPunishStartTimeMs();
    L10:
        return new x21.g(r2, (int) r0, r8);
    L6:
        if (r8.getStartTimeMs() == 0) goto L8;
        r2 = r8.getStartTimeMs() + (r8.getDuration() * ((long) WebcastRedirectException.UNKNOWN));
        goto L10
    L8:
        r2 = System.currentTimeMillis();
        goto L10
    }

    public final void b(Function1<? super r, Unit> r14) {
        IRoom r0 = this.q.a;
        if (r0 == null) goto L5;
        long r3 = r0.getId();
    L6:
        long r5 = this.c;
        String r1 = null;
        if (r3 != 0) goto L9;
    L11:
        b r2 = null;
    L12:
        if (r2 != null) goto L14;
        return;
    L14:
        if (this.b == true) goto L17;
        r2 = null;
    L17:
        if (r2 == null) goto L34;
        long r10 = r2.a;
        long r4 = r2.b;
        d r6 = new d(this, r14);
        r31.a r7 = (r31.a) this.h.getValue();
        if (r7 == null) goto L35;
        long r8 = 4;
        IRoom r15 = this.q.a;
        if (r15 == null) goto L25;
        IBaseUser r16 = r15.getOwnerKt();
        if (r16 == null) goto L25;
        r1 = r16.getIdString();
    L25:
        Observable r17 = r7.O(r4, r8, 7, false, "multi_anchor_feed_view", r10, r1);
        if (r17 == null) goto L36;
        Observable r18 = r17.compose(RxUtil.rxSchedulerHelper());
        if (r18 == null) goto L37;
        Disposable r19 = r18.subscribe(new com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.b(this, r6), new c(r6));
        if (r19 == null) goto L38;
        this.a.add(r19);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L9:
        if (r5 == 0) goto L11;
        r2 = new b(r3, r5);
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    public final void d(mx0.a r4) {
        if (this.d == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r0 = r4.a(com.bytedance.android.live.revenue.common.message.b.b);
        final FeedMultiMachinePresenter$onStartMessageListen$1 r1 = new FeedMultiMachinePresenter$onStartMessageListen$1(this);
        Disposable r2 = r0.subscribe(new g(r1));
        if (r2 == null) goto L8;
        RxUtilKt.c(r2, this.a);
    L8:
        Observable r3 = r4.a(com.bytedance.android.live.revenue.common.message.b.e);
        final FeedMultiMachinePresenter$onStartMessageListen$2 r5 = new FeedMultiMachinePresenter$onStartMessageListen$2(this);
        Disposable r6 = r3.subscribe(new g(r5));
        if (r6 == null) goto L11;
        RxUtilKt.c(r6, this.a);
    L11:
        Observable r7 = r4.a(com.bytedance.android.live.revenue.common.message.b.f);
        final FeedMultiMachinePresenter$onStartMessageListen$3 r8 = new FeedMultiMachinePresenter$onStartMessageListen$3(this);
        Disposable r9 = r7.subscribe(new g(r8));
        if (r9 == null) goto L14;
        RxUtilKt.c(r9, this.a);
    L14:
        Observable r10 = r4.a(com.bytedance.android.live.revenue.common.message.b.l);
        final FeedMultiMachinePresenter$onStartMessageListen$4 r12 = new FeedMultiMachinePresenter$onStartMessageListen$4(this);
        Disposable r13 = r10.subscribe(new g(r12));
        if (r13 == null) goto L17;
        RxUtilKt.c(r13, this.a);
    L17:
        Observable r14 = r4.a(com.bytedance.android.live.revenue.common.message.b.g);
        final FeedMultiMachinePresenter$onStartMessageListen$5 r15 = new FeedMultiMachinePresenter$onStartMessageListen$5(this);
        Disposable r16 = r14.subscribe(new g(r15));
        if (r16 == null) goto L20;
        RxUtilKt.c(r16, this.a);
    L20:
        this.d = true;
    }

    public final void f(x21.a r2) {
        if ((r2 instanceof x21.i) == false) goto L5;
        this.i = null;
    L5:
        this.r.e(r2);
    }

    public a(z21.a r2, com.bytedance.android.live.revlink.impl.multianchor.feed.machine.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "machine");
        this.q = r2;
        this.r = r3;
        this.a = new CompositeDisposable();
        this.f = new MutableLiveData();
        this.g = new ArrayList();
        this.h = LazyKt.lazy(FeedMultiMachinePresenter$linkNetwork$2.INSTANCE);
        this.k = new f(this);
        this.l = new e(this);
        this.m = new FeedMultiMachinePresenter$onClientPkTimeOut$1(this);
        this.n = new FeedMultiMachinePresenter$onPullLinkMicListFromServer$1(this);
        this.o = new FeedMultiMachinePresenter$onPkStandEndMsg$1(this);
        this.p = new FeedMultiMachinePresenter$onSecKillMsg$1(this);
    }

    public static final void a(a r12, yh6.c r13) {
        r12.getClass();
        if ((r13 instanceof r0) == false) goto L19;
        c5 r14 = ((vh7.c) r13).castTo(c5.class);
        u1 r6 = r14.getBattleSetting();
        if (r6 == null) goto L96;
        long r1 = r6.getBattleId();
        long r3 = r6.getStartTimeMs();
        long r7 = r6.getDuration();
        if (r3 > 0) goto L10;
        return;
    L10:
        if (r7 <= 0) goto L97;
        x21.d r0 = r12.r.getState();
        if ((r0 instanceof x21.d.c) == true) goto L15;
    L17:
        r12.f(new x21.a.c(new x21.h(r1, r3, (int) r7, r6), r14));
        return;
    L15:
        if (r3 >= ((x21.d.c) r0).b.c) goto L17;
        return;
    L97:
        return;
    L96:
        return;
    L19:
        if ((r13 instanceof v8) == false) goto L39;
        a5 r15 = ((vh7.c) r13).castTo(a5.class);
        x21.d r2 = r12.r.getState();
        if ((r2 instanceof x21.d.c) == false) goto L80;
        long r4 = ((x21.d.c) r2).b.b;
        u1 r5 = r15.getBattleSetting();
        if (r5 != null) goto L25;
        return;
    L25:
        if (r4 != r5.getBattleId()) goto L99;
        r12.r.a();
        int r16 = r15.getEndReason();
        if (r16 != 0) goto L30;
        r12.b(r12.o);
        return;
    L30:
        if (r16 != 13) goto L32;
        r12.f(new x21.a.C0342a(r12.e()));
        return;
    L32:
        if (r16 == 6) goto L35;
        if (r16 == 7) goto L35;
        return;
    L35:
        r12.b(r12.p);
        return;
    L99:
        return;
    L80:
        return;
    L39:
        if ((r13 instanceof h1) == false) goto L48;
        if (((int) ((h1) r13).castTo(i6.class).getType2()) != 7) goto L85;
        x21.d r17 = r12.r.getState();
        if ((r17 instanceof x21.d.c) == false) goto L45;
    L46:
        r12.f(new x21.a.b(r12.e()));
        return;
    L45:
        if ((r17 instanceof x21.d.b) == true) goto L46;
        return;
    L85:
        return;
    L48:
        if ((r13 instanceof f2) == false) goto L68;
        c8 r18 = ((vh7.c) r13).castTo(c8.class);
        x21.d r8 = r12.r.getState();
        long r9 = r18.getLinkStartTime();
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d r10 = r12.j;
        if (r10 == null) goto L53;
        r10.f(r18.getAnchorInfoMap());
    L53:
        if ((r8 instanceof x21.d.a) == false) goto L63;
        x21.f r19 = ((x21.d.a) r8).b;
        if (r19.b == true) goto L57;
    L59:
        r12.r.d(r9);
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d r110 = r12.j;
        if (r110 == null) goto L88;
        r110.e(r9);
        return;
    L88:
        return;
    L57:
        if (r9 >= r19.a) goto L59;
        return;
    L63:
        if ((r8 instanceof x21.d.C0344d) == false) goto L90;
        r12.i = Long.valueOf(r9);
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d r111 = r12.j;
        if (r111 == null) goto L91;
        r111.e(r9);
        return;
    L91:
        return;
    L90:
        return;
    L68:
        if ((r13 instanceof y4) == false) goto L93;
        y4 r112 = (y4) r13;
        x21.d r20 = r12.r.getState();
        if ((r20 instanceof x21.d.b) == false) goto L94;
        long r22 = ((x21.d.b) r20).b.c.getBattleId();
        u1 r113 = r112.getBattleSetting();
        if (r113 != null) goto L74;
        return;
    L74:
        if (r22 != r113.getBattleId()) goto L102;
        r12.f(new x21.a.C0342a(r12.e()));
        return;
    L102:
        return;
    L94:
        return;
    }
}
