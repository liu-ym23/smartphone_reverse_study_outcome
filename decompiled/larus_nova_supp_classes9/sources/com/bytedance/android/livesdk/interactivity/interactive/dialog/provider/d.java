package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ a.b a;

    public d(a.b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        k82.a r2 = this.a.t.a;
        if (r2 == null) goto L6;
        r2.A();
        return;
    }
}
