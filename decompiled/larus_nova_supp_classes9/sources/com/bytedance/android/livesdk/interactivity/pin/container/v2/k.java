package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import android.view.ViewGroup;
import cc2.n;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements n<cc2.k> {
    public final /* synthetic */ PinWidget a;

    public k(PinWidget r1) {
        this.a = r1;
    }

    @Override // cc2.n
    public final void a(cc2.k r1, Boolean r2) {
        ViewGroup r3 = ((Widget) this.a).containerView;
        if (r3 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r3);
        return;
    }

    @Override // cc2.n
    public final void b(cc2.k r1, Boolean r2) {
        ViewGroup r3 = ((Widget) this.a).containerView;
        if (r3 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    }
}
