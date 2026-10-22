package com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy;

import android.text.TextUtils;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ju1.m;
import ju1.n;
import ju1.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements iu1.b {
    public final PropertyOwner<n> a;
    public final DataCenter b;

    public static final class a {
    }

    static {
    }

    @Override // iu1.b
    public final void onDestroy() {
    }

    @Override // iu1.b
    public final ju1.h getStrategy() {
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.a(a0.d(this.b, false), a0.n(this.b)) == false) goto L10;
        ju1.h r0 = mu1.b.d(com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.a);
        if (r0 == null) goto L10;
        if (TextUtils.equals(r0.b(), "danmaku_speed_strategy") == false) goto L10;
        return r0;
    L10:
        return new m("danmaku_speed_strategy", 3);
    }

    public f(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.b = r4;
        this.a = new PropertyOwner(new n(3, true));
    }

    @Override // iu1.b
    public final void a(n r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if ((r3 instanceof r) == false) goto L8;
        int r0 = lu1.k.a;
        LandscapeDanmakuStrategy$traceResult$1 r1 = new LandscapeDanmakuStrategy$traceResult$1(r3);
        Intrinsics.checkNotNullParameter(r1, "info");
        if (v.a() == false) goto L8;
        ALogger.i("DynamicStrategy", (String) r1.invoke());
    L8:
        this.a.a(r3);
    }

    @Override // iu1.b
    public final void b(n r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if ((r3 instanceof r) == false) goto L8;
        int r0 = lu1.k.a;
        LandscapeDanmakuStrategy$traceResult$1 r1 = new LandscapeDanmakuStrategy$traceResult$1(r3);
        Intrinsics.checkNotNullParameter(r1, "info");
        if (v.a() == false) goto L8;
        ALogger.i("DynamicStrategy", (String) r1.invoke());
    L8:
        this.a.a(r3);
    }
}
