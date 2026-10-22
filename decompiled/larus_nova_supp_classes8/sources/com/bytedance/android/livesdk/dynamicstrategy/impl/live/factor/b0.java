package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 extends DynamicFactor<Integer> {
    public Disposable b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ b0 a;

        public b(b0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.update(Integer.valueOf(((IBaseUser) r2).getGender()));
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_user_gender";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L9;
        IBaseUser r2 = r1.b();
        if (r2 == null) goto L9;
        int r3 = r2.getGender();
    L11:
        return Integer.valueOf(r3);
    L9:
        r3 = -1;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L11;
        Observable r2 = r1.p();
        if (r2 == null) goto L11;
        Observable r3 = RxUtilKt.h(r2);
        if (r3 == null) goto L11;
        Disposable r4 = r3.subscribe(new b(this));
    L12:
        this.b = r4;
        return;
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public b0() {
    }
}
