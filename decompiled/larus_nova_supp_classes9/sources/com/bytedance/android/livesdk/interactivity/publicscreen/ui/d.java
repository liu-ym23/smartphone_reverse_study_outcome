package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ AnchorPublicScreenConfigDialog a;

    public d(AnchorPublicScreenConfigDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        AnchorPublicScreenConfigDialog r3 = this.a;
        int r0 = AnchorPublicScreenConfigDialog.B;
        r3.onCancel();
    }
}
