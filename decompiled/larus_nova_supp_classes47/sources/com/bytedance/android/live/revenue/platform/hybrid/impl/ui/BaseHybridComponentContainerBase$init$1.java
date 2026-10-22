package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import com.bytedance.android.live.revenue.platform.container.impl.o0;
import com.bytedance.android.live.revenue.platform.container.impl.w;
import com.bytedance.android.scope.m;
import cy0.j;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lwy0/e;", "manager", "", "invoke", "(Lwy0/e;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class BaseHybridComponentContainerBase$init$1 extends Lambda implements Function1<wy0.e, Unit> {
    final /* synthetic */ c this$0;

    public BaseHybridComponentContainerBase$init$1(c r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(wy0.e r8) {
        Intrinsics.checkNotNullParameter(r8, "manager");
        o0 r1 = new o0(r8, new BaseHybridComponentContainerBase$init$1$driver$1(this));
        c r9 = this.this$0;
        a.b r2 = ((a) r9).d;
        View r10 = r9.getHybridView();
        if (r10 == null) goto L5;
        Context r12 = r10.getContext();
    L6:
        Pair r13 = w.b(r1, r2, r12, null, new BaseHybridComponentContainerBase$init$1$driver$2(this), 8);
        c r0 = this.this$0;
        r0.b = (RevenueJsDriver) r13.getSecond();
        cy0.e.a.getClass();
        j r3 = cy0.e.a.a;
        m.e.getClass();
        Object r4 = m.b(r3).a(Reflection.getOrCreateKotlinClass(ny0.a.class));
        Intrinsics.checkNotNull(r4);
        ((ny0.a) ((f80.a) r4)).J0((com.bytedance.platform.aio.a) r13.getSecond());
        return;
    L5:
        r12 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((wy0.e) r1);
        return Unit.INSTANCE;
    }
}
