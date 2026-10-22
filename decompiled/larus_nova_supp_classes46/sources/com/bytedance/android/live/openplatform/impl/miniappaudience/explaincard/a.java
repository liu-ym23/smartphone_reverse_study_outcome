package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements AsyncLayoutInflater.OnInflateFinishedListener {
    public final /* synthetic */ AudienceExplainCardContextService a;

    public a(AudienceExplainCardContextService r1) {
        this.a = r1;
    }

    public final /* synthetic */ void onCancel(int r1) {
        AsyncLayoutInflater.OnInflateFinishedListener.-CC.$default$onCancel(this, r1);
    }

    public final void onInflateFinished(View r1, int r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        qo0.a.c("AudienceExplainCardContextService", "preload card layout success");
        this.a.a = r1;
    }
}
