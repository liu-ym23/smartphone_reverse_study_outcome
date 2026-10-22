package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x extends DynamicFactor<Integer> {
    public Disposable b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ x a;

        public b(x r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.update(Integer.valueOf(((IBaseUser) r2).getAgeRange()));
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_user_age";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L9;
        IBaseUser r2 = r1.b();
        if (r2 == null) goto L9;
        int r3 = r2.getAgeRange();
    L11:
        return Integer.valueOf(r3);
    L9:
        r3 = -1;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.b = RxUtilKt.h(jc1.k.n(IMiddlewareUserService.class).user().p()).subscribe(new b(this));
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public x() {
    }
}
