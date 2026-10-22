package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.Completable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayTaskBuilderScopeImpl implements k1 {
    public Function0<? extends Completable> a;
    public final List<Function2<l1, m1, Unit>> b;
    public final String c;

    public XplayTaskBuilderScopeImpl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.c = r2;
        this.a = XplayTaskBuilderScopeImpl$actionProvider$1.INSTANCE;
        this.b = new ArrayList();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.k1
    public final void a(Function0<? extends Completable> r2) {
        Intrinsics.checkNotNullParameter(r2, "actionProvider");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.n1
    public final void c(Function2<? super l1, ? super m1, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.b).add(r2);
    }
}
