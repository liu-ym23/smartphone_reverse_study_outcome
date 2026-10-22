package com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy;

import android.text.TextUtils;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import ju1.m;
import ju1.n;
import kotlin.jvm.internal.Intrinsics;
import r52.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements iu1.b {
    public final PropertyOwner<n> a;

    public static final class a {
    }

    static {
    }

    @Override // iu1.b
    public final void onDestroy() {
    }

    @Override // iu1.b
    public final ju1.h getStrategy() {
        ju1.h r0 = mu1.b.d((String) x.a.getValue());
        if (r0 == null) goto L8;
        if (TextUtils.equals(r0.b(), "live_component_strategy") == false) goto L8;
        return r0;
    L8:
        return new m("live_component_strategy", 0);
    }

    public g() {
        this.a = new PropertyOwner(new n(0, true));
    }

    @Override // iu1.b
    public final void a(n r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.a(r2);
    }

    @Override // iu1.b
    public final void b(n r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.a(r2);
    }
}
