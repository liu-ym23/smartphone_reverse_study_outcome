package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s0 implements View.OnTouchListener {
    public final /* synthetic */ r0 a;

    public s0(r0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r4, "v");
        Intrinsics.checkNotNullParameter(r5, "event");
        return this.a.b(r5.getAction(), r5.getX(), r5.getY(), "2");
    }
}
