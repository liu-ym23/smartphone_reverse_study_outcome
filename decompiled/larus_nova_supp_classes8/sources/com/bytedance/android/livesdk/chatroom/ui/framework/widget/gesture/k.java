package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import android.view.MotionEvent;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements com.bytedance.android.livesdk.clearscreen.gesture.a.InterfaceC0107a {
    public final /* synthetic */ GestureWidget a;

    public k(GestureWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.gesture.a.InterfaceC0107a
    public final boolean onSingleTapUp(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "motionEvent");
        GestureWidget r0 = this.a;
        if (r0.g == null) goto L9;
        Disposable r5 = r0.v;
        if (r5 == null) goto L8;
        if (r5 == null) goto L8;
        r5.dispose();
    L8:
        return false;
    L9:
        GestureWidget.c r1 = r0.h;
        if (r1 != null) goto L12;
        return false;
    L12:
        return r1.a(r4);
    }
}
