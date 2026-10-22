package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ PublicScreenConfigSliderView a;

    public m(PublicScreenConfigSliderView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.a.getDisable() == true) goto L5;
        this.a.b(2, true);
        return;
    L5:
        la2.a r4 = this.a.e;
        if (r4 == null) goto L10;
        r4.a();
        return;
    }
}
