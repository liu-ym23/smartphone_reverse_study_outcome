package com.bytedance.android.livesdk.interactivity.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p extends c {
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void e() {
        super.e();
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
    }

    public p() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void b(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "statMap");
        r3.put("high_priority_action_number", String.valueOf(this.q));
        r3.put("medium_priority_action_number", String.valueOf(this.r));
        r3.put("low_priority_action_number", String.valueOf(this.s));
        r3.put("base_action_number", String.valueOf(this.t));
        r3.put("comment_action_number", String.valueOf(this.u));
        r3.put("send_gift_action_number", String.valueOf(this.v));
        r3.put("order_action_number", String.valueOf(this.w));
        r3.put("other_action_number", String.valueOf(this.x));
    }
}
