package com.obric.assistant.component;

import android.os.Bundle;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.p1;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class z1 implements Runnable {
    public final /* synthetic */ ObricIntercomComponent a;
    public final /* synthetic */ Bundle b;

    public /* synthetic */ z1(ObricIntercomComponent r1, Bundle r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final ObricIntercomComponent r0 = this.a;
        final Bundle r1 = this.b;
        int r2 = ObricIntercomComponent.h1;
        r0.j();
        p1 r3 = (p1) r0.u.getValue();
        if (r3 == null) goto L7;
        com.larus.bmhome.chat.model.j1 r4 = r3.Y3();
        if (r4 == null) goto L7;
        r4.q();
    L7:
        ICoreInputAbility r5 = (ICoreInputAbility) r0.m.getValue();
        if (r5 == null) goto L10;
        r5.p80(false);
    L10:
        r0.V3().g(ObricListeningVisualMode.CLICK_TALK, "speak_loading", new j2(r0, r1), new k2(r0));
    }
}
