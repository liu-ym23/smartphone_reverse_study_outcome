package com.bytedance.android.live.messagewindow.framework.ability;

import android.os.Looper;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimState;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimType;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.live.room.api.messagewindow.monitor.f;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.utils.t0;
import com.bytedance.android.livesdkapi.model.DSConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s71.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class CardAbilityImpl implements r61.a {
    public o a;
    public DataCenter b;
    public final List<t71.a> c;
    public t61.a d;
    public g<v61.c> e;
    public Disposable f;
    public final CompositeDisposable g;
    public final PropertyOwner<ICardLifecycle.State> h;
    public final Observable<ICardLifecycle.State> i;
    public final PublishSubject<p71.a> j;
    public final PublishSubject k;
    public final PublishSubject<CardAnimState> l;
    public final PublishSubject m;
    public final PublishSubject<b71.a> n;
    public final PublishSubject o;
    public final i p;
    public final v61.a q;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ CardAbilityImpl a;

        public a(CardAbilityImpl r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CompositeDisposable r0 = this.a.g;
            r0.add((Disposable) r2);
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CardAbilityImpl a;

        public c(CardAbilityImpl r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            Disposable r3 = this.a.f;
            if (r3 == null) goto L5;
            r3.dispose();
        L5:
            this.a.dismiss();
        }
    }

    static {
    }

    public final y61.b d() {
        IMiddlewareMsgWindowService r0 = k.f(IMiddlewareMsgWindowService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.middlewareCardCtx(this.q.getDataCenter());
    }

    public final ICardLifecycle.State m() {
        return (ICardLifecycle.State) this.h.a;
    }

    public final void dismiss() {
        y61.b r0 = d();
        if (r0 == null) goto L8;
        e71.a r1 = r0.windowManager();
        if (r1 == null) goto L9;
        r1.dismiss(this.q);
        return;
    L9:
        return;
    }

    public final q71.d<r71.e> e() {
        y61.b r0 = d();
        if (r0 == null) goto L7;
        q71.b r1 = r0.stateDispatcher();
        if (r1 == null) goto L7;
        q71.d<r71.e> r2 = r1.a();
    L9:
        if ((r2 instanceof q71.d) == true) goto L12;
        return null;
    L12:
        return r2;
    L7:
        r2 = null;
        goto L9
    }

    public final void hide() {
        y61.b r0 = d();
        if (r0 == null) goto L8;
        e71.a r1 = r0.windowManager();
        if (r1 == null) goto L9;
        r1.hide(this.q);
        return;
    L9:
        return;
    }

    public final boolean o() {
        y61.b r0 = d();
        if (r0 == null) goto L7;
        d71.d r1 = r0.recordManager(this.q.getPosition());
        if (r1 == null) goto L7;
        return r1.g(this.q);
    L7:
        return false;
    }

    public final void show() {
        y61.b r0 = d();
        if (r0 == null) goto L7;
        e71.a r1 = r0.windowManager();
        if (r1 == null) goto L7;
        r1.show(this.q);
        return;
    L7:
        String r2 = v71.a.g(1024);
        IRoomContextService r3 = k.f(IRoomContextService.class);
        if (r3 == null) goto L10;
        o r4 = IRoomContextService.a.a(r3, this.b, 0, 2);
    L11:
        String r5 = v71.a.f(r4, null);
        i r6 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r6 == null) goto L15;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r7 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_msg_card_show_fail");
        JSONObject r8 = new JSONObject();
        r8.put("stackMsg", r2);
        r8.put("container_loadMsg", r5);
        r7.c(new Pair[]{TuplesKt.to("card_id", this.q.j), TuplesKt.to("reason", "CardContextNull"), TuplesKt.to("extra_msg", r8.toString())});
        Unit r9 = Unit.INSTANCE;
        r6.b(r7.a());
    L15:
        p71.a.b r10 = new p71.a.b();
        Intrinsics.checkNotNullParameter("the cardContext is null when invoke card.show()", "<set-?>");
        ((p71.a) r10).b = "the cardContext is null when invoke card.show()";
        Unit r11 = Unit.INSTANCE;
        p(r10);
        f r12 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_context_get_null");
        r12.b = 1000;
        r12.b(r2);
        r12.c("container_load_msg", r5);
        i r13 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r13 == null) goto L20;
        r13.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r12));
        return;
    L20:
        return;
    L10:
        r4 = null;
        goto L11
    }

    public final t61.a b() {
        return this.d;
    }

    public final Observable<CardAnimState> f() {
        return this.m;
    }

    public final DataCenter getDataCenter() {
        return this.b;
    }

    public final o getRoomContext() {
        return this.a;
    }

    public final g<v61.c> j() {
        return this.e;
    }

    public final Observable<b71.a> l() {
        return this.o;
    }

    public final Collection<t71.a> u() {
        return this.c;
    }

    public final Observable<ICardLifecycle.State> v() {
        return this.i;
    }

    public final Observable<p71.a> w() {
        return this.k;
    }

    public CardAbilityImpl(v61.a r4) {
        Intrinsics.checkNotNullParameter(r4, "card");
        this.q = r4;
        y61.b r5 = d();
        i r0 = null;
        if (r5 == null) goto L5;
        o r6 = r5.getRoomContext();
    L6:
        this.a = r6;
        y61.b r7 = d();
        if (r7 == null) goto L9;
        DataCenter r8 = r7.getDataCenter();
    L10:
        this.b = r8;
        this.c = new ArrayList();
        this.g = new CompositeDisposable();
        Observable<ICardLifecycle.State> r9 = new PropertyOwner(ICardLifecycle.State.Initialized, CardAbilityImpl$_cardLifecycle$1.INSTANCE);
        r9.doOnSubscribe(new a(this));
        Unit r1 = Unit.INSTANCE;
        this.h = r9;
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L13;
        r9 = r9.observeOn(AndroidSchedulers.mainThread());
    L13:
        this.i = r9;
        PublishSubject<p71.a> r10 = PublishSubject.create();
        this.j = r10;
        this.k = r10;
        PublishSubject<CardAnimState> r11 = PublishSubject.create();
        this.l = r11;
        this.m = r11;
        PublishSubject<b71.a> r12 = PublishSubject.create();
        this.n = r12;
        this.o = r12;
        y61.b r13 = d();
        if (r13 == null) goto L16;
        r0 = r13.monitor();
    L16:
        this.p = r0;
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    public final void a(CardAnimType r4) {
        Intrinsics.checkNotNullParameter(r4, "animType");
        CardAnimState r0 = new CardAnimState(CardAnimState.State.START, r4);
        this.l.onNext(r0);
        y61.b r5 = d();
        q71.d r1 = null;
        if (r5 == null) goto L7;
        q71.b r6 = r5.stateDispatcher();
        if (r6 == null) goto L7;
        q71.d r7 = r6.b();
    L9:
        if ((r7 instanceof q71.d) == false) goto L12;
        r1 = r7;
    L12:
        if (r1 == null) goto L15;
        int r8 = r71.a.a;
        r1.b(r71.a.a.a(this.q, r0));
        return;
    L15:
        return;
    L7:
        r7 = null;
        goto L9
    }

    public final void c(t61.a r2) {
        Intrinsics.checkNotNullParameter(r2, "anim");
        this.d = r2;
    }

    public final void h(CardAnimType r4) {
        Intrinsics.checkNotNullParameter(r4, "animType");
        CardAnimState r0 = new CardAnimState(CardAnimState.State.END, r4);
        this.l.onNext(r0);
        y61.b r5 = d();
        q71.d r1 = null;
        if (r5 == null) goto L7;
        q71.b r6 = r5.stateDispatcher();
        if (r6 == null) goto L7;
        q71.d r7 = r6.b();
    L9:
        if ((r7 instanceof q71.d) == false) goto L12;
        r1 = r7;
    L12:
        if (r1 == null) goto L15;
        int r8 = r71.a.a;
        r1.b(r71.a.a.a(this.q, r0));
        return;
    L15:
        return;
    L7:
        r7 = null;
        goto L9
    }

    public final void i(t71.a r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        if (((ArrayList) this.c).contains(r2) == true) goto L6;
        ((ArrayList) this.c).add(r2);
        return;
    }

    public final /* bridge */ /* synthetic */ void k(Object r1) {
        p((p71.a) r1);
    }

    public final void n(Object r7) {
        ICardLifecycle.State r8 = (ICardLifecycle.State) r7;
        Intrinsics.checkNotNullParameter(r8, "state");
        switch(com.bytedance.android.live.messagewindow.framework.ability.a.a[r8.ordinal()]) {
            case 2: goto L58;
            case 3: goto L55;
            case 4: goto L52;
            case 5: goto L49;
            case 6: goto L25;
            case 7: goto L5;
            default: goto L64;
        };
    L5:
        b71.a r0 = this.q.h;
        if (r0 == null) goto L19;
        Intrinsics.checkNotNullParameter(r0, "hideReason");
        this.n.onNext(r0);
        y61.b r3 = d();
        q71.d r4 = null;
        if (r3 == null) goto L12;
        q71.b r5 = r3.stateDispatcher();
        if (r5 == null) goto L12;
        q71.d r6 = r5.e();
    L14:
        if ((r6 instanceof q71.d) == false) goto L17;
        r4 = r6;
    L17:
        if (r4 == null) goto L19;
        int r9 = r71.b.a;
        Intrinsics.checkNotNullParameter(this.q, "card");
        Intrinsics.checkNotNullParameter(r0, "hideReason");
        r4.b(new r71.b());
    L12:
        r6 = null;
    L19:
        this.q.h = new b71.a.b();
        f r1 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_ability_lifecycle_hide");
        i r2 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r2 == null) goto L22;
        r2.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r1));
    L22:
        this.q.K();
        q71.d<r71.e> r10 = e();
        if (r10 == null) goto L64;
        int r11 = r71.e.c;
        v61.a r12 = this.q;
        Intrinsics.checkNotNullParameter(r12, "card");
        r10.b(new r71.e(r12, ICardLifecycle.State.Hidden));
        goto L64
    L25:
        f r13 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_ability_lifecycle_show");
        i r14 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r14 == null) goto L28;
        r14.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r13));
    L28:
        Single.create(new com.bytedance.android.live.messagewindow.framework.ability.b(this)).subscribeOn(Schedulers.io()).subscribe();
        MiddlewareRoomContext r15 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.b, 0, 2);
        boolean r16 = false;
        if (r15 == null) goto L35;
        m r17 = r15.isShowDSGuideAnim();
        if (r17 == null) goto L35;
        Boolean r18 = (Boolean) r17.getValue();
        if (r18 == null) goto L35;
        boolean r19 = r18.booleanValue();
    L36:
        if (r19 == false) goto L45;
        DSConfig r20 = t0.a;
        if (r20 == null) goto L40;
        r16 = r20.getRightCardOPt();
    L40:
        if (r16 == false) goto L45;
        if (r20 == null) goto L43;
        long r21 = r20.getDuration();
    L44:
        Observable.timer(r21 + ((long) 1000), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.messagewindow.framework.ability.c(this));
    L46:
        q71.d<r71.e> r22 = e();
        if (r22 == null) goto L64;
        int r23 = r71.e.c;
        v61.a r24 = this.q;
        Intrinsics.checkNotNullParameter(r24, "card");
        r22.b(new r71.e(r24, ICardLifecycle.State.Showed));
        goto L64
    L43:
        r21 = 3000;
    L45:
        this.q.L();
    L35:
        r19 = false;
        goto L36
    L49:
        this.q.M();
        q71.d<r71.e> r25 = e();
        if (r25 == null) goto L64;
        int r26 = r71.e.c;
        v61.a r27 = this.q;
        Intrinsics.checkNotNullParameter(r27, "card");
        r25.b(new r71.e(r27, ICardLifecycle.State.Started));
        goto L64
    L52:
        q71.d<r71.e> r28 = e();
        if (r28 == null) goto L64;
        int r29 = r71.e.c;
        v61.a r30 = this.q;
        Intrinsics.checkNotNullParameter(r30, "card");
        r28.b(new r71.e(r30, ICardLifecycle.State.Stored));
        goto L64
    L55:
        this.q.I();
        q71.d<r71.e> r31 = e();
        if (r31 == null) goto L64;
        int r32 = r71.e.c;
        v61.a r33 = this.q;
        Intrinsics.checkNotNullParameter(r33, "card");
        r31.b(new r71.e(r33, ICardLifecycle.State.Created));
        goto L64
    L58:
        q71.d<r71.e> r34 = e();
        if (r34 == null) goto L61;
        int r35 = r71.e.c;
        v61.a r36 = this.q;
        Intrinsics.checkNotNullParameter(r36, "card");
        r34.b(new r71.e(r36, ICardLifecycle.State.Destroyed));
    L61:
        this.q.J();
        Disposable r37 = this.f;
        if (r37 == null) goto L64;
        r37.dispose();
    L64:
        this.h.a(r8);
    }

    public final void p(p71.a r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        this.j.onNext(r4);
        y61.b r0 = d();
        q71.d r1 = null;
        if (r0 == null) goto L7;
        q71.b r2 = r0.stateDispatcher();
        if (r2 == null) goto L7;
        q71.d r3 = r2.d();
    L9:
        if ((r3 instanceof q71.d) == false) goto L12;
        r1 = r3;
    L12:
        if (r1 == null) goto L15;
        int r5 = r71.d.a;
        Intrinsics.checkNotNullParameter(this.q, "card");
        Intrinsics.checkNotNullParameter(r4, "failure");
        r1.b(new r71.d());
        return;
    L15:
        return;
    L7:
        r3 = null;
        goto L9
    }

    public final void s(CardConstraint r4) {
        Intrinsics.checkNotNullParameter(r4, "newConstraint");
        y61.b r0 = d();
        if (r0 == null) goto L8;
        w61.a r1 = r0.windowContainer(this.q.getPosition());
        if (r1 == null) goto L9;
        r1.xl(this.q, r4, CardAbilityImpl$updateConstraint$1.INSTANCE);
        return;
    L9:
        return;
    }

    public final void t(g<? extends v61.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "fight");
        this.e = r2;
    }

    public final Disposable x(long r2) {
        Disposable r0 = this.f;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r3 = Observable.timer(r2, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        this.f = r3;
        return r3;
    }

    public final void g(o r1, DataCenter r2) {
        if (r1 == null) goto L4;
        this.a = r1;
    L4:
        if (r2 == null) goto L7;
        this.b = r2;
        return;
    }
}
