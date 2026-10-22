package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements View.OnTouchListener {
    public final /* synthetic */ AiAgentPSSelectedMsgView a;
    public final /* synthetic */ GestureDetector b;

    public d(AiAgentPSSelectedMsgView r1, GestureDetector r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        if (r4 == null) goto L4;
        Integer r5 = Integer.valueOf(r4.getAction());
    L6:
        if (r5 != null) goto L9;
    L11:
        if (r4 != null) goto L14;
        return false;
    L14:
        return this.b.onTouchEvent(r4);
    L9:
        if (r5.intValue() != 3) goto L11;
        this.a.a = false;
        goto L11
    L4:
        r5 = null;
        goto L6
    }
}
