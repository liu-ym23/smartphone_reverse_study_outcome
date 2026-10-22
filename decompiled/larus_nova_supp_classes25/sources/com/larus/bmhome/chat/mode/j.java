package com.larus.bmhome.chat.mode;

import android.view.View;
import com.larus.bmhome.auth.LaunchInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ ModeSwitchComponent a;
    public final /* synthetic */ View b;

    public /* synthetic */ j(ModeSwitchComponent r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        ModeSwitchComponent r0 = this.a;
        View r1 = this.b;
        LaunchInfo r4 = (LaunchInfo) r3;
        if (r0.u != null) goto L8;
        if (r0.m3().loadConfig() == false) goto L8;
        r0.H3(r1);
    L8:
        return Unit.INSTANCE;
    }
}
