package com.ss.android.lark.newemoji.emojioptions;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ OptionsSelectPopupMenu<Object> a;
    public final /* synthetic */ Object b;

    public h(OptionsSelectPopupMenu<Object> r1, Object r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        OptionsSelectPopupMenu<Object> r3 = this.a;
        r3.c = this.b;
        r3.e();
        this.a.d(false);
    }
}
