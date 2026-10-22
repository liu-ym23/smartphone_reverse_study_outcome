package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.livesdk.gift.model.p2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class d0 implements s {
    public d0() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.s
    public y a(t r2, y r3, List<? extends r> r4, Function1<? super y, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter(r5, "nextPlugin");
        return r3;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.s
    public void c(t r1, p2 r2, List<? extends r> r3, Function1<? super y, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "info");
        Intrinsics.checkNotNullParameter(r3, "listener");
        Intrinsics.checkNotNullParameter(r4, "nextPlugin");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.s
    public y b(t r2, List<? extends r> r3, Function1<? super y, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "listener");
        Intrinsics.checkNotNullParameter(r4, "nextPlugin");
        return y.d.c;
    }
}
