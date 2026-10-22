package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g0 implements com.bytedance.android.scope.o, x2 {
    public final CompositeDisposable a;
    public final MutableLiveData<Boolean> b;
    public final a c;
    public final i12.e d;
    public final yz0.k e;

    public static final class a<T> implements Observer {
        public final /* synthetic */ g0 a;

        public a(g0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            if (r4 != null) goto L6;
        L8:
            if (r4 != null) goto L11;
        L13:
            if (r4 != null) goto L16;
        L18:
            if (r4 != null) goto L21;
            return;
        L21:
            if (r4.intValue() != 0) goto L27;
            this.a.b.setValue(Boolean.FALSE);
            return;
        L27:
            return;
        L16:
            if (r4.intValue() != 11) goto L18;
            this.a.b.setValue(Boolean.TRUE);
            return;
        L11:
            if (r4.intValue() != 2) goto L13;
            this.a.b.setValue(Boolean.TRUE);
            return;
        L6:
            if (r4.intValue() != 1) goto L8;
            this.a.b.setValue(Boolean.TRUE);
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.x2
    public final void g0() {
        RxUtilKt.c(com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).O3(new o02.a(this.d, this.e.getDataCenter())), this.a);
    }

    public final void onStop() {
        this.a.dispose();
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.i().a() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.t.a() == false) goto L9;
        LiveData r0 = vh6.c.b(tr2.a.class).Ki("degrade_level", -1);
        if (r0 == null) goto L12;
        r0.removeObserver(this.c);
        return;
    L12:
        return;
    L9:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.d.class).unregisterPerformanceStrategyTask(530);
    }

    public final void onStart() {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.i().a() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.t.a() == false) goto L9;
        LiveData r0 = vh6.c.b(tr2.a.class).Ki("degrade_level", -1);
        if (r0 == null) goto L12;
        r0.observeForever(this.c);
        return;
    L12:
        return;
    L9:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.d.class).e6(530, new h0(this));
    }

    public g0(i12.e r2, yz0.k r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        this.d = r2;
        this.e = r3;
        this.a = new CompositeDisposable();
        this.b = new MutableLiveData();
        this.c = new a(this);
    }
}
