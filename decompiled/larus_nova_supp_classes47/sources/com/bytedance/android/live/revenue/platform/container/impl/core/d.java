package com.bytedance.android.live.revenue.platform.container.impl.core;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.b0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements o, m, dy0.d {
    public h a;
    public final CompositeDisposable b;
    public boolean c;
    public final BehaviorSubject<h> d;
    public final vy0.d e;
    public final yz0.g f;
    public final ny0.a g;
    public final g h;
    public final cy0.f i;
    public final NativeHostServiceImpl j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.a();
        }
    }

    @Override // yz0.m
    public final void i() {
    }

    public final void onStart() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    public final void a() {
        if (this.a == null) goto L5;
        return;
    L5:
        vy0.d r2 = this.e;
        ny0.a r4 = this.g;
        g r5 = this.h;
        NativeHostServiceImpl r6 = this.j;
        Context r7 = this.f.getContext();
        cy0.f r8 = this.i;
        if (k.a() == false) goto L8;
        h r0 = new DynamicCenterServiceManager(r4, r5, r6, r7, r8);
    L9:
        this.a = r0;
        r0.onStart();
        this.d.onNext(r0);
        return;
    L8:
        r0 = new DynamicCenterServiceManagerOld(r2, r4, r5, r7, r8);
        goto L9
    }

    public final void onStop() {
        this.b.clear();
        h r0 = this.a;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        this.d.onComplete();
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
        h r0 = this.a;
        if (r0 == null) goto L6;
        r0.onWidgetLoaded();
        return;
    }

    @Override // yz0.m
    public final void x() {
        if (this.c == false) goto L5;
        return;
    L5:
        this.c = true;
        com.bytedance.android.scope.m r0 = com.bytedance.android.scope.m.e;
        cy0.e.a.getClass();
        com.bytedance.android.live.revenue.platform.room.impl.i r1 = (com.bytedance.android.live.revenue.platform.room.impl.i) r0.d(cy0.e.a.a, com.bytedance.android.live.revenue.platform.room.impl.i.class);
        if (r1 == null) goto L16;
        IRoomBase r2 = this.f.mo444getRoom();
        Intrinsics.checkNotNullParameter(r2, "room");
        yz0.a r3 = new yz0.a();
        r3.b(r2.getIdStr());
        IBaseUser r4 = r2.getOwnerKt();
        String r5 = null;
        if (r4 == null) goto L10;
        String r6 = r4.getUserId();
    L11:
        r3.a(String.valueOf(r6));
        IBaseUser r7 = r2.getOwnerKt();
        if (r7 == null) goto L14;
        Intrinsics.checkNotNullParameter(r7, "$this$secUidExt");
        r5 = r7.getCastSecUid();
    L14:
        r3.c(String.valueOf(r5));
        r1.a.onNext(r3);
        goto L16
    L10:
        r6 = null;
    L16:
        if (b0.b().D() == true) goto L18;
        this.d.onError(new Error("service center is not enabled"));
        return;
    L18:
        if (b0.b().j8() <= 0) goto L20;
        Observable r8 = Observable.timer(b0.b().j8(), TimeUnit.MILLISECONDS);
        int r9 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r8.observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), this.b);
        return;
    L20:
        a();
    }

    public d(vy0.d r2, yz0.g r3, ny0.a r4, g r5, cy0.f r6, NativeHostServiceImpl r7) {
        Intrinsics.checkNotNullParameter(r2, "lynxCardService");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "rpcService");
        Intrinsics.checkNotNullParameter(r5, "centerService");
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r7, "nativeHostServiceImpl");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.b = new CompositeDisposable();
        this.d = BehaviorSubject.create();
    }
}
