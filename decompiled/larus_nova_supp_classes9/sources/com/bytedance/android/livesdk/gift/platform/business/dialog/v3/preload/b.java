package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements AsyncLayoutInflater.OnInflateFinishedListener {
    public final /* synthetic */ GiftPanelViewPreloadService a;
    public final /* synthetic */ GiftPanelPreloadView b;

    public b(GiftPanelViewPreloadService r1, GiftPanelPreloadView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final /* synthetic */ void onCancel(int r1) {
        AsyncLayoutInflater.OnInflateFinishedListener.-CC.$default$onCancel(this, r1);
    }

    public final void onInflateFinished(View r1, int r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        GiftPanelViewPreloadService r4 = this.a;
        if (r4.c == true) goto L5;
        return;
    L5:
        GiftPanelPreloadViewModel r5 = r4.f;
        if (r5 == null) goto L9;
        r5.putView(this.b, r1);
        return;
    }
}
