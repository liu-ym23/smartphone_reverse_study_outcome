package mz0;

import com.bytedance.android.live.revenue.platform.log.api.LogDSLMaker;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.LogCommonInstance;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@LogDSLMaker
public final class m {
    public final List<Object> a;

    public m() {
        this.a = new ArrayList();
    }

    public final void a(Function1<? super j, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        com.bytedance.android.livesdk.revenue.log.e r0 = vh6.c.b(kr2.a.class).v();
        r3.invoke(new k(r0));
        List<Object> r4 = this.a;
        ArrayList r5 = (ArrayList) r4;
        r5.add(r0.a);
    }

    public final void b(LogCommon r3) {
        Intrinsics.checkNotNullParameter(r3, "log");
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(c.class));
        Intrinsics.checkNotNull(r1);
        Class<?> r4 = ((c) ((f80.a) r1)).e0(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        ((ArrayList) this.a).add(r4);
    }

    public final void c(LogCommonInstance r3) {
        Intrinsics.checkNotNullParameter(r3, "log");
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(c.class));
        Intrinsics.checkNotNull(r1);
        Object r4 = ((c) ((f80.a) r1)).t5(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        ((ArrayList) this.a).add(r4);
    }

    public final void d(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof com.bytedance.android.livesdk.revenue.log.c) == false) goto L7;
        List<Object> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(((com.bytedance.android.livesdk.revenue.log.c) r2).a());
        return;
    L7:
        if ((r2 instanceof com.bytedance.android.livesdk.revenue.log.b) == false) goto L11;
        List<Object> r3 = this.a;
        ArrayList r4 = (ArrayList) r3;
        r4.add(((com.bytedance.android.livesdk.revenue.log.b) r2).a());
        return;
    L11:
        if ((r2 instanceof com.bytedance.android.livesdk.revenue.log.a) == false) goto L14;
        List<Object> r5 = this.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(((com.bytedance.android.livesdk.revenue.log.a) r2).a());
        return;
    L14:
        ((ArrayList) this.a).add(r2);
    }
}
