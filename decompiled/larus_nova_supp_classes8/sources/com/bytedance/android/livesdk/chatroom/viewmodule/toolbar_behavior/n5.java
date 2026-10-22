package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n5<T> implements Consumer {
    public final /* synthetic */ ToolbarTransformWidgetBehavior a;

    public n5(ToolbarTransformWidgetBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        ToolbarTransformWidgetBehavior.b(this.a);
    }
}
