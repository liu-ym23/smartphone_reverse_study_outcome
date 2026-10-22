package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import com.bytedance.android.livesdk.clearscreen.gesture.ClickPS2ClearScreenGestureBehavior;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o implements Action {
    public final /* synthetic */ GestureWidget a;
    public final /* synthetic */ ClickPS2ClearScreenGestureBehavior b;

    public o(GestureWidget r1, ClickPS2ClearScreenGestureBehavior r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        int r0 = gh1.a.c;
        gh1.a.a.b(((Widget) this.a).dataCenter, this.b);
        this.a.n = null;
    }
}
