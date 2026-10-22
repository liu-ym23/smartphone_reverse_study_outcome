package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ PublicScreenConfigSliderView a;

    public n(PublicScreenConfigSliderView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a.getDisable() == true) goto L5;
        this.a.b(1, true);
        return;
    L5:
        la2.a r3 = this.a.e;
        if (r3 == null) goto L10;
        r3.a();
        return;
    }
}
