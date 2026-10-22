package com.obric.assistant.component;

import com.obric.assistant.view.glowui.OverlayerAudioView;
import com.obric.audio.continuous_talk.ObricContinuousTalkEndType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class t1 implements Function1 {
    public final /* synthetic */ ObricIntercomComponent a;

    public /* synthetic */ t1(ObricIntercomComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        ObricIntercomComponent r0 = this.a;
        int r1 = ObricIntercomComponent.h1;
        Intrinsics.checkNotNullParameter((OverlayerAudioView) r7, "it");
        maa.e r8 = r0.G3();
        boolean r2 = false;
        if (r8 != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        if (r9 == false) goto L12;
        maa.e r10 = r0.G3();
        if (r10 == null) goto L12;
        maa.e.a.a(r10, null, null, false, 7);
    L12:
        com.obric.audio.continuous_talk.b r11 = r0.H3();
        if (r11 != null) goto L15;
    L17:
        if (r2 == false) goto L22;
        com.obric.audio.continuous_talk.c r3 = (com.obric.audio.continuous_talk.c) r0.r.getValue();
        if (r3 == null) goto L22;
        com.obric.audio.continuous_talk.c.a.a(r3, ObricContinuousTalkEndType.MANUAL, null, false, false, 14);
    L22:
        return Unit.INSTANCE;
    L15:
        if (r11.m0() != true) goto L17;
        r2 = true;
        goto L17
    L5:
        if (r8.x3() != true) goto L7;
        r9 = true;
        goto L8
    }
}
