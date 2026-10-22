package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w2<T> implements Consumer {
    public final /* synthetic */ ToolbarBubbleManager.i a;

    public w2(ToolbarBubbleManager.i r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.b.a(ToolbarBubbleManager.BubbleInfo.State.DISMISSED);
    }
}
