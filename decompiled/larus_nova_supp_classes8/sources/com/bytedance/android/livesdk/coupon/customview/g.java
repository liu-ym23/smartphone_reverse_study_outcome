package com.bytedance.android.livesdk.coupon.customview;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ Function1 a;

    public g(Function1 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r2) {
        this.a.invoke(r2);
    }
}
