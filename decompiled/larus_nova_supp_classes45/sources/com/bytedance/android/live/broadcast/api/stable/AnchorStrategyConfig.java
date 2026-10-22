package com.bytedance.android.live.broadcast.api.stable;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnchorStrategyConfig {
    public final ArrayList<AbsAnchorFactor<? extends Object>> a;
    public final AnchorStrategy b;

    public AnchorStrategyConfig(AnchorStrategy r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.b = r2;
        AnchorStrategyConfig$isOpen$1 r3 = AnchorStrategyConfig$isOpen$1.INSTANCE;
        AnchorStrategyConfig$onInit$1 r4 = AnchorStrategyConfig$onInit$1.INSTANCE;
        this.a = new ArrayList();
    }
}
