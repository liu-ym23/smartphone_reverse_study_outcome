package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc;

import android.graphics.drawable.Drawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ OgcVSWebActivityBehavior a;

    public d(OgcVSWebActivityBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Drawable r3 = (Drawable) r2;
        View r0 = this.a.g;
        if (r0 == null) goto L6;
        r0.setBackgroundDrawable(r3);
        return;
    }
}
