package com.bytedance.android.live.revenue.platform.sti.impl;

import c01.a;
import com.bytedance.android.live.revenue.core.util.AsyncService;
import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class StiService extends AsyncService implements a {
    public final com.bytedance.android.livesdk.revenue.service.sti.a d;

    public StiService(com.bytedance.android.livesdk.revenue.service.sti.a r2) {
        Intrinsics.checkNotNullParameter(r2, "revStiService");
        this.d = r2;
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService
    public final Object o0(Continuation<? super Unit> r1) {
        return Unit.INSTANCE;
    }

    @Override // c01.a
    public final <M extends IRevIconModel<?>> void D9(final Class<M> r3, final Function0<? extends M> r4) {
        Intrinsics.checkNotNullParameter(r3, "modelClass");
        Intrinsics.checkNotNullParameter(r4, "factory");
        p0(this.d, new StiService$loadIcon$1(r3, r4));
    }
}
