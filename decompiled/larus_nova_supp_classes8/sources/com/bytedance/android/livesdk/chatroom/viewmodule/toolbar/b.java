package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AbsAudienceToolbarButtonMoreDialog a;
    public final /* synthetic */ View b;

    public b(AbsAudienceToolbarButtonMoreDialog r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        View r0 = this.b;
        Resources r2 = this.a.getContext().getResources();
        r0.setBackgroundDrawable(new BitmapDrawable(r2, (Bitmap) r4));
    }
}
