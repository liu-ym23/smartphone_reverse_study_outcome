package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ ToolbarAudienceWelfareBehavior a;

    public c(ToolbarAudienceWelfareBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.f(true);
    }
}
