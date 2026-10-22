package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f0<T> implements Consumer {
    public final /* synthetic */ LandscapeTopMoreHolder a;

    public f0(LandscapeTopMoreHolder r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        View r0 = this.a.c;
        Resources r2 = this.a.getContext().getResources();
        r0.setBackground(new BitmapDrawable(r2, (Bitmap) r4));
    }
}
