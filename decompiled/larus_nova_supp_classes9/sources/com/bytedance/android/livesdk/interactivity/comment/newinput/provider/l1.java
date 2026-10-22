package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l1 implements View.OnClickListener {
    public final /* synthetic */ o1.a a;

    public l1(o1.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        i40.h.c("shadow view click", true);
        this.a.b.K();
    }
}
