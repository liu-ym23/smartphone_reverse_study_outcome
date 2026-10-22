package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ ExplainCardSettingDialog a;

    public h(ExplainCardSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ExplainCardSettingDialog r3 = this.a;
        int r0 = ExplainCardSettingDialog.k;
        r3.z1().fetchPresetData();
    }
}
