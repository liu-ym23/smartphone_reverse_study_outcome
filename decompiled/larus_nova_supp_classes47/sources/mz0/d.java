package mz0;

import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final e<?> b(LogCommon r2) {
        Intrinsics.checkNotNullParameter(r2, "logCommon");
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(c.class));
        Intrinsics.checkNotNull(r1);
        return ((c) ((f80.a) r1)).W2(r2);
    }

    public static final void c(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "uniqueId");
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r1);
        ((i) ((f80.a) r1)).removeSendLogFilter(r2);
    }

    public static final void a(Object r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "uniqueId");
        Intrinsics.checkNotNullParameter(r3, FileUtils.FILTER);
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r1);
        ((i) ((f80.a) r1)).addSendLogFilter(r2, r3);
    }
}
