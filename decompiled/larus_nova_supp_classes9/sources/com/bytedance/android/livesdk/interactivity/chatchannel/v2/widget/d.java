package com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget;

import ak6.g;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements qb2.e {
    public final /* synthetic */ ChatChannelWidgetV2 a;

    public d(ChatChannelWidgetV2 r1) {
        this.a = r1;
    }

    @Override // qb2.e
    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    @Override // qb2.e
    public final void b(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        TextView r0 = this.a.k;
        if (r0 == null) goto L6;
        r0.setText(r2.a);
        return;
    }
}
