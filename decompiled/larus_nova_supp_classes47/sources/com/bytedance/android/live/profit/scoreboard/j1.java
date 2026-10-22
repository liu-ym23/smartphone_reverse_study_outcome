package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j1 implements com.bytedance.android.scope.o, l {
    public final List<Observer<?>> a;
    public final PropertyOwner b;
    public final PropertyOwner<Pair<RegionId, j80.d>> c;
    public final PropertyOwner<Pair<RegionId, j80.d>> d;
    public final PropertyOwner e;
    public final PropertyOwner f;
    public final PublishSubject g;
    public final PropertyOwner h;
    public final PublishSubject i;
    public final PublishSubject j;
    public final PropertyOwner k;
    public final PublishSubject l;
    public final PublishSubject m;
    public final PublishSubject n;
    public final PublishSubject o;
    public final PublishSubject p;
    public final yz0.k q;

    public final void onStart() {
    }

    public final void onStop() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Observer) r0.next()).onComplete();
        goto L4
    }

    public final <T> PublishSubject<T> y() {
        Observer<?> r0 = PublishSubject.create();
        this.a.add(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner a() {
        return this.e;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject c() {
        return this.p;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner d() {
        return this.h;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject f() {
        return this.g;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject g() {
        return this.o;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject h() {
        return this.j;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject i() {
        return this.m;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject j() {
        return this.i;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner k() {
        return this.k;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner n() {
        return this.c;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject o() {
        return this.l;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject q() {
        return this.n;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner s() {
        return this.f;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner w() {
        return this.b;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner x() {
        return this.d;
    }

    public j1(yz0.k r7) {
        Intrinsics.checkNotNullParameter(r7, "roomDataService");
        this.q = r7;
        this.a = new ArrayList();
        Boolean r0 = Boolean.FALSE;
        this.b = A(r0);
        RegionId r1 = RegionId.B;
        PropertyOwner<Pair<RegionId, j80.d>> r2 = A(TuplesKt.to(r1, new j80.d(0.0f, 1.0f)));
        this.c = r2;
        PropertyOwner<Pair<RegionId, j80.d>> r3 = A(TuplesKt.to(r1, new j80.d(0.0f, 1.0f)));
        this.d = r3;
        if (r7.isAnchor() == false) goto L5;
        r2 = r3;
    L5:
        this.e = r2;
        this.f = A(0);
        this.g = y();
        this.h = A(r0);
        this.i = y();
        this.j = y();
        this.k = A(sh6.a.a);
        this.l = y();
        this.m = y();
        this.n = y();
        this.o = y();
        this.p = y();
    }

    public final <T> PropertyOwner<T> A(T r2) {
        Observer<?> r0 = new PropertyOwner(r2);
        this.a.add(r0);
        return r0;
    }
}
