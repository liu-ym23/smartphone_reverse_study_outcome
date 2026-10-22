package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements View.OnTouchListener {
    public final /* synthetic */ BaseModelListScrollManager a;

    public a(BaseModelListScrollManager r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        if (r2.getAction() == 1) goto L5;
        return false;
    L5:
        if (this.a.j.canScrollVertically(1) == true) goto L7;
        this.a.d(BaseModelListScrollManager.ScrollState.AutoScroll);
        return false;
    L7:
        this.a.d(BaseModelListScrollManager.ScrollState.Focus);
        BaseModelListScrollManager.a(this.a);
        return false;
    }
}
