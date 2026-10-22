package com.obric.assistant.component;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class u1 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ ObricIntercomComponent b;

    public /* synthetic */ u1(ObricIntercomComponent r2) {
        this.a = false;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = this.a;
        ObricIntercomComponent r1 = this.b;
        int r2 = ObricIntercomComponent.h1;
        FLogger.a.i("OrionIntercomComponent", "mockView gone, success: " + r0);
        if (r1.X == false) goto L12;
        com.obric.audio.continuous_talk.b r3 = r1.H3();
        if (r3 == null) goto L9;
        boolean r4 = true;
        if (r3.m0() != true) goto L9;
    L10:
        if (r4 == true) goto L13;
        ObricIntercomComponent.G4(r1, false, null, false, 6);
    L13:
        Function1 r5 = r1.S;
        if (r5 == null) goto L16;
        r5.invoke(Boolean.FALSE);
    L16:
        r1.T.invoke(Boolean.FALSE);
        return;
    L9:
        r4 = false;
        goto L10
    L12:
        com.larus.utils.e1.o(r1.W3());
        r1.W3().getClass();
        goto L13
    }
}
