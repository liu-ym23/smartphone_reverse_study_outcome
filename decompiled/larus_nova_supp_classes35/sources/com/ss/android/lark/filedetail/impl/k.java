package com.ss.android.lark.filedetail.impl;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ FileDetailFragment a;

    public k(FileDetailFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.finish();
    }
}
