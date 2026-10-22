package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.bridge.f2;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.x2;
import com.bytedance.android.livesdk.message.model.v8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedPkMachinePresenter {
    public final CompositeDisposable a;
    public IRoom b;
    public mx0.a c;
    public boolean d;
    public boolean e;
    public boolean f;
    public List<? extends yh6.c> g;
    public Long h;
    public final Lazy i;
    public final m j;

    public final void e() {
        List<? extends yh6.c> r0 = this.g;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        g((yh6.c) r1.next());
    L8:
        this.g = null;
    }

    public final p f() {
        l r0 = this.j.getState();
        if ((r0 instanceof l.a) == false) goto L6;
        p r1 = ((l.a) r0).c;
        return new p(r1.a, r1.b);
    L6:
        if ((r0 instanceof l.d) == false) goto L11;
        Long r2 = this.h;
        if (r2 != null) goto L15;
        p r3 = new p(com.bytedance.live.kmp.util.e.a(), false);
    L13:
        return r3;
    L15:
        return new p(r2.longValue(), true);
    L11:
        r3 = new p(com.bytedance.live.kmp.util.e.a(), false);
        goto L13
    }

    public FeedPkMachinePresenter(FeedPkStateMachine.b r2) {
        Intrinsics.checkNotNullParameter(r2, "machine");
        this.j = r2;
        this.a = new CompositeDisposable();
        this.i = LazyKt.lazy(FeedPkMachinePresenter$linkNetwork$2.INSTANCE);
    }

    public final void c(mx0.a r4) {
        if (this.d == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r0 = r4.a(com.bytedance.android.live.revenue.common.message.b.e);
        final FeedPkMachinePresenter$doMessageListen$1 r1 = new FeedPkMachinePresenter$doMessageListen$1(this);
        Disposable r2 = r0.subscribe(new a(r1));
        if (r2 == null) goto L8;
        RxUtilKt.c(r2, this.a);
    L8:
        Observable r3 = r4.a(com.bytedance.android.live.revenue.common.message.b.f);
        final FeedPkMachinePresenter$doMessageListen$2 r5 = new FeedPkMachinePresenter$doMessageListen$2(this);
        Disposable r6 = r3.subscribe(new a(r5));
        if (r6 == null) goto L11;
        RxUtilKt.c(r6, this.a);
    L11:
        Observable r7 = r4.a(com.bytedance.android.live.revenue.common.message.b.l);
        final FeedPkMachinePresenter$doMessageListen$3 r8 = new FeedPkMachinePresenter$doMessageListen$3(this);
        Disposable r9 = r7.subscribe(new a(r8));
        if (r9 == null) goto L14;
        RxUtilKt.c(r9, this.a);
    L14:
        Observable r10 = r4.a(com.bytedance.android.live.revenue.common.message.b.g);
        final FeedPkMachinePresenter$doMessageListen$4 r12 = new FeedPkMachinePresenter$doMessageListen$4(this);
        Disposable r13 = r10.subscribe(new a(r12));
        if (r13 == null) goto L17;
        RxUtilKt.c(r13, this.a);
    L17:
        this.d = true;
    }

    public final void g(yh6.c r13) {
        if ((r13 instanceof r0) == false) goto L19;
        c5 r14 = ((vh7.c) r13).castTo(c5.class);
        u1 r9 = r14.getBattleSetting();
        if (r9 == null) goto L74;
        long r4 = r9.getBattleId();
        long r6 = r9.getStartTimeMs();
        long r10 = r9.getDuration();
        if (r6 > 0) goto L10;
        return;
    L10:
        if (r10 <= 0) goto L75;
        l r0 = this.j.getState();
        if ((r0 instanceof l.c) == true) goto L15;
    L17:
        i(new e.a(new c(new v(r4, r6, (int) r10, r9, r14.getSkinConfig(), r14.getSkinType()), r14)));
        return;
    L15:
        if (r6 >= ((l.c) r0).c.c) goto L17;
        return;
    L75:
        return;
    L74:
        return;
    L19:
        if ((r13 instanceof v8) == false) goto L51;
        a5 r15 = (a5) ((vh7.c) r13).castTo(a5.class);
        l r1 = this.j.getState();
        if ((r1 instanceof l.c) == false) goto L64;
        long r2 = ((l.c) r1).c.b;
        u1 r3 = r15.getBattleSetting();
        if (r3 != null) goto L25;
        return;
    L25:
        if (r2 != r3.getBattleId()) goto L77;
        this.j.a();
        int r5 = r15.getEndReason();
        if (r5 != 0) goto L30;
        Intrinsics.checkNotNullParameter(r15, "message");
        u1 r7 = r15.getBattleSetting();
        if (r7 != null) goto L44;
    L46:
        u1 r8 = r15.getBattleSetting();
        if (r8 == null) goto L79;
        i(new e.d(new b(b(r8, r15.getSkinConfig(), r15.getSkinType()), r15)));
        return;
    L79:
        return;
    L44:
        if (af2.d.d(r7) != true) goto L46;
        i(new e.c(f()));
        return;
    L30:
        if (r5 != 4) goto L32;
    L40:
        i(new e.k(f()));
        return;
    L32:
        if (r5 == 16) goto L40;
        if (r5 != 6) goto L36;
        Intrinsics.checkNotNullParameter(r15, "message");
        RxUtilKt.c(Observable.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this, r15)), this.a);
        return;
    L36:
        if (r5 != 7) goto L78;
        h(r15);
        return;
    L78:
        return;
    L77:
        return;
    L64:
        return;
    L51:
        if ((r13 instanceof f2) == false) goto L71;
        c8 r16 = ((vh7.c) r13).castTo(c8.class);
        Long r12 = this.h;
        if (r12 == null) goto L55;
        long r17 = r12.longValue();
    L57:
        if ((r16.getLinkStartTime() - r17) < 0) goto L72;
        this.h = Long.valueOf(r16.getLinkStartTime());
        if ((this.j.getState() instanceof l.a) == false) goto L73;
        this.j.d(r16.getLinkStartTime());
        return;
    L73:
        return;
    L72:
        return;
    L55:
        r17 = 0;
        goto L57
    }

    public final void h(a5 r6) {
        l r0 = this.j.getState();
        if ((r0 instanceof l.c) == false) goto L19;
        long r1 = ((l.c) r0).c.b;
        u1 r2 = r6.getBattleSetting();
        if (r2 != null) goto L7;
        return;
    L7:
        if (r1 != r2.getBattleId()) goto L22;
        u1 r3 = r6.getBattleSetting();
        if (r3 != null) goto L12;
    L14:
        u1 r4 = r6.getBattleSetting();
        if (r4 != null) goto L17;
        return;
    L17:
        i(new e.m(new z(b(r4, r6.getSkinConfig(), r6.getSkinType()), r6)));
        return;
    L12:
        if (af2.d.d(r3) != true) goto L14;
        i(new e.l(f()));
        return;
    L22:
        return;
    }

    public final void i(e r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isTargetLink");
        if ((r2 instanceof e.g) == false) goto L5;
    L18:
        boolean r0 = true;
    L19:
        if (r0 == false) goto L21;
        this.h = null;
    L21:
        this.j.f(r2);
        return;
    L5:
        if ((r2 instanceof e.h) == true) goto L18;
        if ((r2 instanceof e.C0169e) == true) goto L18;
        if ((r2 instanceof e.l) == true) goto L18;
        if ((r2 instanceof e.c) == true) goto L18;
        if ((r2 instanceof e.b) == true) goto L18;
        if ((r2 instanceof e.k) == true) goto L18;
        r0 = false;
        goto L19
    }

    public static final void a(FeedPkMachinePresenter r3, c3 r4) {
        r3.getClass();
        if (r4 == null) goto L5;
        c1 r1 = r4.getBattleSetting();
    L6:
        if (r1 != null) goto L18;
        l r2 = r3.j.getState();
        if ((r2 instanceof l.c) == false) goto L22;
        IBaseBattleSetting r5 = ((l.c) r2).c.e;
        if (r4 == null) goto L12;
        x2 r6 = r4.getSkinConfig();
    L13:
        if (r4 == null) goto L15;
        int r7 = r4.getSkinType();
    L16:
        r3.i(new e.f(new x(b(r5, r6, r7), null)));
        return;
    L15:
        r7 = 0;
        goto L16
    L12:
        r6 = null;
        goto L13
    L22:
        return;
    L18:
        if (af2.d.d(r1) == false) goto L20;
        r3.i(new e.C0169e(r3.f()));
        return;
    L20:
        r3.i(new e.f(new x(b(r1, r4.getSkinConfig(), r4.getSkinType()), r4)));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void d(IRoom r14, com.bytedance.android.live.revlink.impl.pk.feedview.machine.a r15) {
        a9 r0 = ((IRoomLinkExt) r14.castTo(IRoomLinkExt.class)).getLinkMicInfo();
        if (r0 == null) goto L5;
        long r1 = r0.getChannelId();
    L6:
        long r3 = r1;
        r31.a r2 = (r31.a) this.i.getValue();
        if (r2 == null) goto L20;
        long r5 = 2;
        if (com.bytedance.android.live.revlink.impl.global.b.r() == null) goto L11;
        String r4 = d21.d.c(PkDoubleAudienceDataContext.BattleStatsFromType.Feed.ordinal());
    L12:
        Observable r16 = r2.O(r3, r5, 1, true, r4, r14.getRoomId(), iz.a.a(r14.getOwner()));
        if (r16 == null) goto L21;
        Observable r17 = r16.compose(RxUtil.rxSchedulerHelper());
        if (r17 == null) goto L22;
        Disposable r18 = r17.subscribe(new f(r15), new g(r15));
        if (r18 == null) goto L23;
        this.a.add(r18);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r4 = null;
        goto L12
    L20:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public static s b(IBaseBattleSetting r12, x2 r13, int r14) {
        if (r12.getPunishDuration() == 0) goto L5;
        long r0 = r12.getPunishDuration();
    L7:
        if (r12.getPunishStartTimeMs() == 0) goto L11;
        long r2 = r12.getPunishStartTimeMs();
    L15:
        return new s(r2, (int) r0, r12, r13, r14);
    L11:
        if (r12.getStartTimeMs() == 0) goto L13;
        r2 = r12.getStartTimeMs() + (r12.getDuration() * ((long) WebcastRedirectException.UNKNOWN));
        goto L15
    L13:
        r2 = System.currentTimeMillis();
        goto L15
    L5:
        r0 = af2.d.a(r12);
        goto L7
    }
}
