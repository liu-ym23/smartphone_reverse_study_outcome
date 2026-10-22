package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ CastScreenCompositeWidget a;

    public g(CastScreenCompositeWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        h80.c r2 = (h80.c) r1;
        this.a.wq();
    }
}
