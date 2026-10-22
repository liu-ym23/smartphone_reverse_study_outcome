package com.bytedance.android.live.livepkaudience.seat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends a {
    public a b;
    public a c;

    @Override // com.bytedance.android.live.livepkaudience.seat.a
    public final void b(PkDynamicEmojiTask r1) {
    }

    public d() {
    }

    @Override // com.bytedance.android.live.livepkaudience.seat.a
    public final void a(h r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
