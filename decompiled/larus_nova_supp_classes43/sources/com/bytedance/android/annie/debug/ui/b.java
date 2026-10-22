package com.bytedance.android.annie.debug.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ DialogItem a;
    public final /* synthetic */ DialogAdapter b;

    public b(DialogItem r1, DialogAdapter r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        this.a.a(this.b.b);
    }
}
