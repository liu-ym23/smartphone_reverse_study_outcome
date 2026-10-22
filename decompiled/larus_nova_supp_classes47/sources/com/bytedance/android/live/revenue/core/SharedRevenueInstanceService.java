package com.bytedance.android.live.revenue.core;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.revenue.core.util.g;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SharedRevenueInstanceService implements o, m, com.bytedance.android.live.revenue.b {
    public Disposable a;
    public a b;
    public final com.bytedance.android.live.revenue.core.a c;

    public static final class a extends DataContext implements j {
        private final b inst;

        public final void shareAsCurrent() {
            j.a r0 = j.C0;
            int r1 = com.bytedance.live.datacontext.d.a;
            Intrinsics.checkNotNullParameter(this, "self");
            com.bytedance.live.datacontext.b.a(this, r0);
        }

        @Override // com.bytedance.android.live.revenue.core.util.j
        public b getInst() {
            return this.inst;
        }

        public a(b r2) {
            Intrinsics.checkNotNullParameter(r2, "inst");
            this.inst = r2;
        }

        public final void shareToLiveRoom(IAbilityCenter r3) {
            int r0 = g.a;
            b r1 = getInst();
            Intrinsics.checkNotNullParameter(r1, "instance");
            g.a r2 = new g.a((com.bytedance.android.live.revenue.core.a) r1);
            if (r3 == null) goto L6;
            r3.registerAbility(g.a.class, r2);
            return;
        }
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    public final void onStart() {
        com.bytedance.android.live.revenue.core.a r0 = this.c;
        r0.b(com.bytedance.android.live.revenue.b.class, r0.getScope());
        Pair r1 = com.bytedance.live.datacontext.d.a(new AnonymousClass1(this));
        a r2 = (a) r1.component1();
        this.a = (Disposable) r1.component2();
        this.b = r2;
    }

    public final void onStop() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
    }

    @Override // com.bytedance.android.live.revenue.b
    public final void shareAsCurrent() {
        a r0 = this.b;
        if (r0 == null) goto L5;
        r0.shareAsCurrent();
    L5:
        StringBuilder r1 = new StringBuilder("shareAsCurrent");
        a r2 = this.b;
        if (r2 == null) goto L8;
        int r3 = r2.hashCode();
    L9:
        r1.append(r3);
        ALogger.d("SharedRevenueInstanceService", r1.toString());
        return;
    L8:
        r3 = 0;
        goto L9
    }

    @Override // yz0.m
    public final void i() {
        shareAsCurrent();
    }

    public SharedRevenueInstanceService(com.bytedance.android.live.revenue.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        this.c = r2;
    }

    @Override // com.bytedance.android.live.revenue.b
    public final void shareToLiveRoom(IAbilityCenter r2) {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.shareToLiveRoom(r2);
        return;
    }
}
