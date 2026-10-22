package com.obric.assistant.component;

import android.view.View;
import com.obric.audio.continuous_talk.ObricContinuousTalkEndType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class s1 implements View.OnClickListener {
    public final /* synthetic */ ObricIntercomComponent a;

    public /* synthetic */ s1(ObricIntercomComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        ObricIntercomComponent r8 = this.a;
        int r0 = ObricIntercomComponent.h1;
        maa.e r1 = r8.G3();
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L12;
        maa.e r4 = r8.G3();
        if (r4 == null) goto L12;
        maa.e.a.a(r4, null, null, false, 7);
    L12:
        com.obric.audio.continuous_talk.b r5 = r8.H3();
        if (r5 != null) goto L15;
    L17:
        if (r2 == false) goto L22;
        com.obric.audio.continuous_talk.c r6 = (com.obric.audio.continuous_talk.c) r8.r.getValue();
        if (r6 == null) goto L23;
        com.obric.audio.continuous_talk.c.a.a(r6, ObricContinuousTalkEndType.MANUAL, null, false, false, 14);
        return;
    L23:
        return;
    L22:
        return;
    L15:
        if (r5.m0() != true) goto L17;
        r2 = true;
        goto L17
    L5:
        if (r1.x3() != true) goto L7;
        r3 = true;
        goto L8
    }
}
