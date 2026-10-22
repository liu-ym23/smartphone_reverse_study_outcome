package com.larus.bmhome.chat.component.bottom.core;

import androidx.lifecycle.Observer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v5 implements Observer {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ v5(CoreInputComponent r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        CoreInputComponent r0 = this.a;
        Unit r4 = (Unit) r3;
        int r5 = CoreInputComponent.d3;
        r0.U5(!com.larus.platform.service.i3.a.a(), "tourist_changed");
    }
}
