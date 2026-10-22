package com.bytedance.android.anniex.container.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.a.goBack();
    }
}
