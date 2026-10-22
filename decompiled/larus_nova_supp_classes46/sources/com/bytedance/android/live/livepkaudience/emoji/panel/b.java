package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends g {
    public final c b;

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int a() {
        return 1;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int c() {
        return 0;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final String d() {
        return "";
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final Object b() {
        return this.b;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final void e(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        Object r4 = r3.getTag();
        if (r4 == null) goto L9;
        int r5 = ((Integer) r4).intValue();
        if (r5 == this.b.b) goto L10;
        this.a.z5(r5, false);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public b(f r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "extra");
        super(r2);
        this.b = r3;
    }
}
