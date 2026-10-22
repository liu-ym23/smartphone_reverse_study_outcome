package com.bytedance.android.live.broadcastgame.xplay;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayCompositeTaskBuilderScopeImpl implements l {
    public final List<j1> a;
    public final List<Function2<l1, m1, Unit>> b;
    public final Function2<XplayCompositeTaskBuilderScopeImpl, List<? extends j1>, j1> c;

    /* JADX WARN: Multi-variable type inference failed */
    public XplayCompositeTaskBuilderScopeImpl(Function2<? super XplayCompositeTaskBuilderScopeImpl, ? super List<? extends j1>, ? extends j1> r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.c = r2;
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.n1
    public final void c(Function2<? super l1, ? super m1, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.b).add(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.l
    public final void b(String r5, Function1<? super k1, Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, "block");
        List<j1> r0 = this.a;
        final XplayTaskBuilderScopeImpl r1 = new XplayTaskBuilderScopeImpl(r5);
        r6.invoke(r1);
        ArrayList r2 = (ArrayList) r0;
        r2.add(new i1(r1.a, r1.c, new XplayTaskBuilderScopeImpl$build$1(r1)));
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.l
    public final void d(final String r4, Function1<? super l, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "block");
        List<j1> r0 = this.a;
        XplayCompositeTaskBuilderScopeImpl r1 = new XplayCompositeTaskBuilderScopeImpl(new XplayCompositeTaskBuilderScopeImpl$parallel$1(r4));
        r5.invoke(r1);
        ArrayList r2 = (ArrayList) r0;
        r2.add((j1) r1.c.invoke(r1, r1.a));
    }
}
