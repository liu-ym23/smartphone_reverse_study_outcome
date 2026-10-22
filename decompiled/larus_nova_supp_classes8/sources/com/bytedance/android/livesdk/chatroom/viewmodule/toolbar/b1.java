package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.drawable.Drawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class b1 implements Consumer {
    public final /* synthetic */ View a;

    public /* synthetic */ b1(View r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.setBackgroundDrawable((Drawable) r2);
    }
}
