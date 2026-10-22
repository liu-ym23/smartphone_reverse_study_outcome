package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public final PublishSubject<Unit> k;
    public final PublishSubject<Unit> l;
    public final PublishSubject<Unit> m;
    public final PublishSubject<Unit> n;
    public final PublishSubject<Unit> o;
    public final PublishSubject<Unit> p;
    public final PublishSubject<Unit> q;
    public final PublishSubject<Unit> r;
    public final PublishSubject<Unit> s;
    public final PublishSubject<Unit> t;
    public final CompositeDisposable u;

    public final void a() {
        this.u.clear();
        this.a = 0;
        PublishSubject<Unit> r2 = this.k;
        Unit r3 = Unit.INSTANCE;
        r2.onNext(r3);
        this.b = 0 - this.a;
        this.l.onNext(r3);
        this.c = 0 - this.a;
        this.m.onNext(r3);
        this.d = 0 - this.a;
        this.n.onNext(r3);
        this.e = 0 - this.a;
        this.o.onNext(r3);
        this.f = 0 - this.a;
        this.p.onNext(r3);
        this.g = 0 - this.a;
        this.q.onNext(r3);
        this.h = 0 - this.a;
        this.r.onNext(r3);
        this.i = 0 - this.a;
        this.s.onNext(r3);
        this.j = 0 - this.a;
        this.t.onNext(r3);
    }

    public final String toString() {
        return "LoadDurationMonitorData(clickTimeInMillis=" + this.a + ", startGameApiRequest=" + this.b + ", startGameApiSucccess=" + this.c + ", receivedStartGameMsg=" + this.d + ", startGameStateMachineTransition=" + this.e + ", receivedSwitchSceneMsg=" + this.f + ", startSwitchScene=" + this.g + ", switchSceneSuccess=" + this.h + ", uiRenderStart=" + this.i + ", uiRenderEnd=" + this.j + ')';
    }

    public e() {
        this.k = PublishSubject.create();
        this.l = PublishSubject.create();
        this.m = PublishSubject.create();
        this.n = PublishSubject.create();
        this.o = PublishSubject.create();
        this.p = PublishSubject.create();
        this.q = PublishSubject.create();
        this.r = PublishSubject.create();
        this.s = PublishSubject.create();
        this.t = PublishSubject.create();
        this.u = new CompositeDisposable();
    }
}
