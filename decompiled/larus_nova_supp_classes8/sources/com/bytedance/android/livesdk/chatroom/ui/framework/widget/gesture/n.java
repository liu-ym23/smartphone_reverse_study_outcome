package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import android.view.MotionEvent;
import com.bytedance.android.livesdk.clearscreen.gesture.ClickPS2ClearScreenGestureBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements ClickPS2ClearScreenGestureBehavior.a {
    public final /* synthetic */ GestureWidget a;

    public n(GestureWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.gesture.ClickPS2ClearScreenGestureBehavior.a
    public final void a(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "motionEvent");
        GestureWidget.c r0 = this.a.h;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
