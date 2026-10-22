package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f0 extends DynamicFactor<Integer> {
    public Disposable b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ f0 a;

        public b(f0 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            IBaseUser r5 = (IBaseUser) r4;
            if (r5.getUserWatchMonthValid() == false) goto L6;
            this.a.update(Integer.valueOf((int) r5.getUserWatchMonth()));
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_watch_duration_month";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        HashMap r0 = (HashMap) l42.a.b.getValue();
        if (r0 == null) goto L10;
        String r1 = (String) r0.get("watch");
        if (r1 != null) goto L9;
        return 0;
    L9:
        return Integer.valueOf(CastIntegerProtector.parseInt(r1));
    L10:
        return 0;
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

    public f0() {
    }
}
