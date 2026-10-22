package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements View.OnTouchListener {
    public final /* synthetic */ GestureDetector a;

    public n(GestureDetector r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        return this.a.onTouchEvent(r2);
    }
}
