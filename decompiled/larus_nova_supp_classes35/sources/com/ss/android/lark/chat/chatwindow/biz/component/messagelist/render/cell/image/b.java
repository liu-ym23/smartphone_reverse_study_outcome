package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image;

import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ ImageCellLoader.b b;

    public b(Object r1, ImageCellLoader.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Object r0 = this.a;
        if ((r0 instanceof GifDrawable) == true) goto L5;
        ImageCellLoader.b r1 = this.b;
        if (r1.c.e == true) goto L17;
        r1.b.a().setVisibility(8);
        return;
    L17:
        return;
    L5:
        if (((GifDrawable) r0).isOverLimit() == false) goto L7;
        this.b.b.a().setText(UIHelper.getString(2131891138));
        this.b.b.a().setVisibility(0);
        return;
    L7:
        ImageCellLoader.b r2 = this.b;
        if (r2.c.e == true) goto L15;
        r2.b.a().setVisibility(8);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
