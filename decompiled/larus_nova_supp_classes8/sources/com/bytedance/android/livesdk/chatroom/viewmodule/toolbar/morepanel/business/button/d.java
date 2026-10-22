package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ lp1.a d;

    public d(e r1, View r2, Context r3, lp1.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r4) {
        View r0 = this.b;
        Resources r2 = this.c.getResources();
        r0.setBackgroundDrawable(new BitmapDrawable(r2, (Bitmap) r4));
        e r5 = this.a;
        View r1 = this.b;
        lp1.a r3 = this.d;
        r5.getClass();
        e.a(r1, r3);
    }
}
