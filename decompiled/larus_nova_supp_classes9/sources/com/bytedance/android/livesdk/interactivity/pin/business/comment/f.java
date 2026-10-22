package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements ak6.e {
    public final /* synthetic */ TextView a;

    public f(TextView r1) {
        this.a = r1;
    }

    public final void a(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    public final void b(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        TextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setText(r2.a);
        return;
    }
}
