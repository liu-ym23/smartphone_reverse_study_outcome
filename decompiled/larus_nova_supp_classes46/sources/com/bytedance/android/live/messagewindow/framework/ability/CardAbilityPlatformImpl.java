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
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
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
public final class CardAbilityPlatformImpl implements r61.a {
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
        public final /* synthetic */ CardAbilityPlatformImpl a;

        public a(CardAbilityPlatformImpl r1) {
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
        public final /* synthetic */ CardAbilityPlatformImpl a;

        public c(CardAbilityPlatformImpl r1) {
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
        return r0.middlewareCardCtx(this.b);
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
        o r4 = IRoomContextService.a.a(r3, this.q.getDataCenter(), 0, 2);
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

    public CardAbilityPlatformImpl(v61.a r3) {
        Intrinsics.checkNotNullParameter(r3, "card");
        this.q = r3;
        this.c = new ArrayList();
        this.g = new CompositeDisposable();
        Observable<ICardLifecycle.State> r4 = new PropertyOwner(ICardLifecycle.State.Initialized, CardAbilityPlatformImpl$_cardLifecycle$1.INSTANCE);
        r4.doOnSubscribe(new a(this));
        Unit r0 = Unit.INSTANCE;
        this.h = r4;
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L5;
        r4 = r4.observeOn(AndroidSchedulers.mainThread());
    L5:
        this.i = r4;
        PublishSubject<p71.a> r5 = PublishSubject.create();
        this.j = r5;
        this.k = r5;
        PublishSubject<CardAnimState> r6 = PublishSubject.create();
        this.l = r6;
        this.m = r6;
        PublishSubject<b71.a> r7 = PublishSubject.create();
        this.n = r7;
        this.o = r7;
        y61.b r8 = d();
        if (r8 == null) goto L8;
        i r9 = r8.monitor();
    L9:
        this.p = r9;
        return;
    L8:
        r9 = null;
        goto L9
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
        switch(d.a[r8.ordinal()]) {
            case 2: goto L40;
            case 3: goto L37;
            case 4: goto L34;
            case 5: goto L31;
            case 6: goto L25;
            case 7: goto L5;
            default: goto L46;
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
        if (r10 == null) goto L46;
        int r11 = r71.e.c;
        v61.a r12 = this.q;
        Intrinsics.checkNotNullParameter(r12, "card");
        r10.b(new r71.e(r12, ICardLifecycle.State.Hidden));
        goto L46
    L25:
        f r13 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_ability_lifecycle_show");
        i r14 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r14 == null) goto L28;
        r14.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r13));
    L28:
        Single.create(new e(this)).subscribeOn(Schedulers.io()).subscribe();
        this.q.L();
        q71.d<r71.e> r15 = e();
        if (r15 == null) goto L46;
        int r16 = r71.e.c;
        v61.a r17 = this.q;
        Intrinsics.checkNotNullParameter(r17, "card");
        r15.b(new r71.e(r17, ICardLifecycle.State.Showed));
        goto L46
    L31:
        this.q.M();
        q71.d<r71.e> r18 = e();
        if (r18 == null) goto L46;
        int r19 = r71.e.c;
        v61.a r20 = this.q;
        Intrinsics.checkNotNullParameter(r20, "card");
        r18.b(new r71.e(r20, ICardLifecycle.State.Started));
        goto L46
    L34:
        q71.d<r71.e> r21 = e();
        if (r21 == null) goto L46;
        int r22 = r71.e.c;
        v61.a r23 = this.q;
        Intrinsics.checkNotNullParameter(r23, "card");
        r21.b(new r71.e(r23, ICardLifecycle.State.Stored));
        goto L46
    L37:
        this.q.I();
        q71.d<r71.e> r24 = e();
        if (r24 == null) goto L46;
        int r25 = r71.e.c;
        v61.a r26 = this.q;
        Intrinsics.checkNotNullParameter(r26, "card");
        r24.b(new r71.e(r26, ICardLifecycle.State.Created));
        goto L46
    L40:
        q71.d<r71.e> r27 = e();
        if (r27 == null) goto L43;
        int r28 = r71.e.c;
        v61.a r29 = this.q;
        Intrinsics.checkNotNullParameter(r29, "card");
        r27.b(new r71.e(r29, ICardLifecycle.State.Destroyed));
    L43:
        this.q.J();
        Disposable r30 = this.f;
        if (r30 == null) goto L46;
        r30.dispose();
    L46:
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
        r1.xl(this.q, r4, CardAbilityPlatformImpl$updateConstraint$1.INSTANCE);
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
