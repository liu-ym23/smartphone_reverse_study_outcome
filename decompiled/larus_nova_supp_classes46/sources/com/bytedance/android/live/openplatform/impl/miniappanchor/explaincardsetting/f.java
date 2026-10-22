package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ ExplainCardSettingDialog a;

    public f(ExplainCardSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.finish();
    }
}
