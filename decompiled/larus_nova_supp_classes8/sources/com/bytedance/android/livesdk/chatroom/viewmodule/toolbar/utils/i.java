package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ View a;

    public i(View r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        View r0 = this.a;
        r0.setBackgroundDrawable((Drawable) r2);
    }
}
