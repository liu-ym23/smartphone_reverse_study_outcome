package com.obric.assistant.component;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class v1 implements Function0 {
    public final /* synthetic */ ObricIntercomComponent a;

    public /* synthetic */ v1(ObricIntercomComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricIntercomComponent r0 = this.a;
        int r1 = ObricIntercomComponent.h1;
        maa.e r2 = r0.G3();
        boolean r3 = false;
        if (r2 != null) goto L5;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L22;
        com.obric.audio.continuous_talk.c r5 = (com.obric.audio.continuous_talk.c) r0.r.getValue();
        if (r5 != null) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == true) goto L22;
    L24:
        return Boolean.valueOf(r3);
    L18:
        if (r5.m0() != true) goto L20;
        r6 = true;
    L22:
        r3 = true;
        goto L24
    L5:
        if (r2.nZ() == (-1)) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 != true) goto L13;
        r4 = true;
        goto L14
    L7:
        if (r2.gn() == true) goto L10;
        r7 = false;
        goto L11
    }
}
