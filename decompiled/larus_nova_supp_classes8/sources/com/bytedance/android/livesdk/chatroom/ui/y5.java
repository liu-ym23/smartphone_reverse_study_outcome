package com.bytedance.android.livesdk.chatroom.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y5<T> implements Consumer {
    public final /* synthetic */ DynamicEmojiView a;
    public final /* synthetic */ wj0.b b;

    public y5(DynamicEmojiView r1, wj0.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        this.a.b.b(new wj0.a.e(this.b));
    }
}
