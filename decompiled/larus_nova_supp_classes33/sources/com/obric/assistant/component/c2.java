package com.obric.assistant.component;

import android.view.MotionEvent;
import android.view.View;
import com.obric.audio.continuous_talk.ObricContinuousTalkEndType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c2 implements View.OnTouchListener {
    public final /* synthetic */ ObricIntercomComponent a;

    public /* synthetic */ c2(ObricIntercomComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r10, MotionEvent r11) {
        ObricIntercomComponent r12 = this.a;
        int r0 = ObricIntercomComponent.h1;
        boolean r1 = true;
        if (r11.getAction() != 0) goto L15;
        maa.e r2 = r12.G3();
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L15;
        maa.e r4 = r12.G3();
        if (r4 == null) goto L15;
        maa.e.a.a(r4, null, null, false, 7);
        goto L15
    L7:
        if (r2.x3() != true) goto L9;
        r3 = true;
    L15:
        if (r11.getAction() != 0) goto L26;
        com.obric.audio.continuous_talk.b r13 = r12.H3();
        if (r13 != null) goto L19;
    L21:
        r1 = false;
    L22:
        if (r1 == false) goto L26;
        com.obric.audio.continuous_talk.c r5 = (com.obric.audio.continuous_talk.c) r12.r.getValue();
        if (r5 == null) goto L26;
        com.obric.audio.continuous_talk.c.a.a(r5, ObricContinuousTalkEndType.MANUAL, null, false, false, 14);
        goto L26
    L19:
        if (r13.m0() != true) goto L21;
    L26:
        return false;
    }
}
