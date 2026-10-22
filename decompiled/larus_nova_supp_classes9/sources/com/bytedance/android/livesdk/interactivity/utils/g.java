package com.bytedance.android.livesdk.interactivity.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends c {
    public long q;
    public long r;

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void e() {
        super.e();
        this.q = 0;
        this.r = 0;
    }

    public g() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void b(Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "statMap");
        long r0 = this.r;
        if (r0 <= 0) goto L6;
        r6.put("chat_align_delay_time", String.valueOf(this.q / r0));
        return;
    }
}
