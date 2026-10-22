package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ ExplainCardSettingDialog a;

    public l(ExplainCardSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        ExplainCardSettingDialog r4 = this.a;
        r4.i = true;
        r4.z1().savePageData();
        r2.dismiss();
        this.a.finish();
    }
}
