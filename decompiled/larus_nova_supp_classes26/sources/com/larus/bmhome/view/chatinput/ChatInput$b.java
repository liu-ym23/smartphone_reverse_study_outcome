package com.larus.bmhome.view.chatinput;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatInput$b extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ ChatInput a;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        return true;
    }

    public ChatInput$b(ChatInput r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.a.performClick();
        return true;
    }
}
