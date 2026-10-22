package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ FullScreenOpenPanel a;

    public e(FullScreenOpenPanel r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ViewGroup r0 = this.a.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
    L5:
        r0.setVisibility(8);
        this.a.h();
        View.OnClickListener r1 = this.a.B;
        if (r1 == null) goto L9;
        r1.onClick(r3);
        return;
    }
}
