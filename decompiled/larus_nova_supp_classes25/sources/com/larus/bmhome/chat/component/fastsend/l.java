package com.larus.bmhome.chat.component.fastsend;

import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.utils.logger.FLogger;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ FastSendImageComponent a;

    public /* synthetic */ l(FastSendImageComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FastSendImageComponent r0 = this.a;
        KProperty[] r1 = FastSendImageComponent.M;
        f1 r2 = r0.N2();
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L20;
        va8.o r4 = (va8.o) r0.l.getValue();
        if (r4 != null) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == false) goto L21;
        FLogger.a.i("FastSendImageComponent", "checkIfNeedManualCloseBottomMenu, close menu");
        ICoreInputAbility r6 = r0.P2();
        if (r6 == null) goto L22;
        r6.C1(false, true, "");
        return;
    L22:
        return;
    L21:
        return;
    L12:
        if (r4.w() != true) goto L14;
        r5 = true;
        goto L15
    L20:
        return;
    L5:
        if (r2.sL() != true) goto L7;
        r3 = true;
        goto L8
    }
}
