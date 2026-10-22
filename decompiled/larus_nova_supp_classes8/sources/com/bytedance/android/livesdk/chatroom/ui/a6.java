package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a6 extends BaseControllerListener<Object> {
    public final /* synthetic */ DynamicEmojiView a;
    public final /* synthetic */ wj0.b b;

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
    }

    public a6(DynamicEmojiView r1, wj0.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r2, Throwable r3) {
        this.a.b.b(new wj0.a.a(this.b));
    }
}
