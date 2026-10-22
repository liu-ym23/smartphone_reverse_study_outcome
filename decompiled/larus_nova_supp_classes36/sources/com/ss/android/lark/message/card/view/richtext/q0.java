package com.ss.android.lark.message.card.view.richtext;

import android.view.View;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.widget.richtext.Image;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q0 implements View.OnClickListener {
    public final /* synthetic */ Image a;
    public final /* synthetic */ c0 b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        krb.a.a(this.b.f, "interaction", LoadParams.ImageFormat.IMAGE);
        this.b.getClass();
    }

    public q0(c0 r1, Image r2) {
        this.b = r1;
        this.a = r2;
    }
}
