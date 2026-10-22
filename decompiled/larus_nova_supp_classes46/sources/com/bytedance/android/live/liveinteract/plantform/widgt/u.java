package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.view.View;
import android.widget.RadioButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u implements View.OnClickListener {
    public final /* synthetic */ RadioButton a;

    public u(RadioButton r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        RadioButton r3 = this.a;
        r3.setChecked(!r3.isChecked());
    }
}
