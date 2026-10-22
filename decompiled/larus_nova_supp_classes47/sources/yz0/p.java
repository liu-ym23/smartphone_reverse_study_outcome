package yz0;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public static final void a(com.bytedance.android.live.revenue.core.b r4, Function1<? super o, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        if (r4 != null) goto L8;
        IllegalStateException r6 = new IllegalStateException("RevenueInstance is null");
        SafetyGuard.a(null, r6, "RoomStateService error handler");
        if (v.b() == true) goto L7;
        return;
    L7:
        throw r6;
    L8:
        boolean r2 = com.bytedance.android.live.revenue.core.util.h.a;
        o r3 = (o) com.bytedance.android.live.revenue.core.util.h.b(r4, o.class);
        if (r3 != null) goto L14;
        IllegalStateException r7 = new IllegalStateException("Attached service is not found, isScopeEntered = " + com.bytedance.android.scope.l.b(r4.e()));
        SafetyGuard.a(null, r7, "RoomStateService error handler");
        if (v.b() == true) goto L13;
        return;
    L13:
        throw r7;
    L14:
        r5.invoke(r3);
    }
}
