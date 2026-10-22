package com.bytedance.android.live.browser.schema.core.strategy;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends c {
    public final String b;

    @Override // com.bytedance.android.live.browser.schema.core.strategy.c
    public final boolean a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
        throw new IllegalStateException(("illegal rule for " + this.b).toString());
    }

    public b(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        super(r2);
        this.b = r3;
    }
}
