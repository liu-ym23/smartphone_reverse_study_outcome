package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import android.view.MotionEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ GestureWidget a;
    public final /* synthetic */ MotionEvent b;

    public p(GestureWidget r1, MotionEvent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        GestureWidget.xq(this.a, this.b);
        this.a.t = null;
    }
}
