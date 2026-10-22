package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u {
    public final LinkedHashMap<String, Long> a;
    public final LinkedHashMap<String, Long> b;

    public u(LinkedHashMap<String, Long> r2, LinkedHashMap<String, Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "blackDownloadList");
        Intrinsics.checkNotNullParameter(r3, "whiteDeleteList");
        this.a = r2;
        this.b = r3;
    }
}
