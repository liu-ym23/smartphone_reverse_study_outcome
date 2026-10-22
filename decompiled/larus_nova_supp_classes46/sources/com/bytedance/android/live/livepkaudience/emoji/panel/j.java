package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends g {
    public final String b;

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int c() {
        return 2131251833;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final String d() {
        if (r2.a(this.b) == false) goto L6;
        return this.b;
    L6:
        return s1.B(2131919825);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final void e(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.g();
    }

    public j(f r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "title");
        super(r2);
        this.b = r3;
    }
}
