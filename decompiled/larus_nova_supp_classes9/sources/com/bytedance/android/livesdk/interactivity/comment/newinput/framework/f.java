package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements View.OnTouchListener {
    public final /* synthetic */ boolean a;

    public f(boolean r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        return !this.a;
    }
}
