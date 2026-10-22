package com.bytedance.android.livesdk.gift.fastgift.di;

import android.content.Context;
import com.bytedance.android.livesdk.gift.platform.business.h;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements h.a {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h.a
    public final h a(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        return new com.bytedance.android.livesdk.gift.fastgift.b(r2, r3);
    }
}
