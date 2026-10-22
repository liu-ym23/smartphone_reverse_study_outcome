package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements View.OnTouchListener {
    public final /* synthetic */ KtvMusicFeedbackDialog a;

    public j(KtvMusicFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        if (((EditText) this.a.X90(2131380500)).isCursorVisible() == true) goto L7;
        ((EditText) this.a.X90(2131380500)).setCursorVisible(true);
        return false;
    L7:
        return false;
    }
}
