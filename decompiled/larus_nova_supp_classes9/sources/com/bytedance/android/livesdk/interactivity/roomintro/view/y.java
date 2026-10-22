package com.bytedance.android.livesdk.interactivity.roomintro.view;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.utils.x0;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y implements View.OnTouchListener {
    public final /* synthetic */ RoomIntroDialogV2 a;

    public y(RoomIntroDialogV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        if (RoomIntroDialogV2.S90(this.a) == false) goto L9;
        x0.a(this.a.g);
        TextCorrectionEditText r3 = this.a.g;
        if (r3 == null) goto L10;
        r3.clearFocus();
        return false;
    L10:
        return false;
    L9:
        return false;
    }
}
