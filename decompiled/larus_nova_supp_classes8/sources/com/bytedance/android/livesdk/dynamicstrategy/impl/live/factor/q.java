package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q extends DynamicFactor<Integer> {
    public int b;
    public final CompositeDisposable c;
    public final DataCenter d;

    public static final class a {
    }

    public static final class b extends g61.a.a {
        public final /* synthetic */ q a;

        public final boolean a() {
            q r0 = this.a;
            if (r0.b != 1) goto L5;
            r0.b = 0;
            r0.update(0);
        L5:
            return true;
        }

        public final boolean b() {
            q r0 = this.a;
            if (r0.b != 0) goto L5;
            r0.b = 1;
            r0.update(1);
        L5:
            return true;
        }

        public b(q r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_interactive_comp_delay_degrade";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        ILiveExpMiddlewareService r0 = jc1.k.f(ILiveExpMiddlewareService.class);
        if (r0 == null) goto L8;
        l61.c r1 = r0.getSceneState(this.d, l61.d.a.z0.e);
        if (r1 == null) goto L8;
        this.b = r1.a() ? 1 : 0;
    L8:
        return Integer.valueOf(this.b);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        ILiveExpMiddlewareService r0 = jc1.k.f(ILiveExpMiddlewareService.class);
        if (r0 == null) goto L8;
        Disposable r1 = r0.registerExpBizListener(l61.d.a.z0.e, new b(this));
        if (r1 == null) goto L9;
        RxUtilKt.c(r1, this.c);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        this.c.clear();
    }

    public q(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.d = r2;
        this.b = 1;
        this.c = new CompositeDisposable();
    }
}
