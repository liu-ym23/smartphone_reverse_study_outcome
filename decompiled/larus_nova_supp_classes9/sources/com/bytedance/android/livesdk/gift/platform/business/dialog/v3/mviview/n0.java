package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.text.Spannable;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RechargeViewParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n0 implements yr2.a {
    public final /* synthetic */ GiftMVIRechargeView a;
    public final /* synthetic */ RechargeViewParams b;

    public final void a(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "image");
        Intrinsics.checkNotNullParameter(r2, "image");
    }

    public n0(GiftMVIRechargeView r1, RechargeViewParams r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(Spannable r2, yr2.a.a r3) {
        Intrinsics.checkNotNullParameter(r2, "spannable");
        Intrinsics.checkNotNullParameter(r3, "info");
        TextView r4 = this.a.n;
        if (r4 == null) goto L5;
        r4.setText(r2);
    L5:
        TextView r5 = this.a.n;
        if (r5 == null) goto L8;
        r5.setTextSize(1, this.b.getTextSize());
    L8:
        HSImageView r6 = this.a.o;
        if (r6 == null) goto L12;
        r6.setVisibility(8);
        return;
    }
}
