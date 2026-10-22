package com.obric.assistant.network.restrict;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.sharedstate.StateChangeListener;
import com.obric.aiagent.sharedstate.model.SharedValue;
import hm9.h;
import kotlin.jvm.internal.Intrinsics;
import pda.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class f implements StateChangeListener {
    public final /* synthetic */ ObricBackgroundNetworkBlockServiceImpl a;
    public final /* synthetic */ a b;

    public /* synthetic */ f(ObricBackgroundNetworkBlockServiceImpl r1, h r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onStateChanged(String r5, SharedValue r6) {
        ObricBackgroundNetworkBlockServiceImpl r0 = this.a;
        a r1 = this.b;
        Intrinsics.checkNotNullParameter(r5, "<unused var>");
        Intrinsics.checkNotNullParameter(r6, "value");
        Object r7 = r6.getValue();
        if ((r7 instanceof Boolean) == false) goto L5;
        Boolean r8 = (Boolean) r7;
    L6:
        if (r8 == null) goto L8;
        boolean r9 = r8.booleanValue();
    L9:
        FLogger.a.i(r0.a, "isBackground: " + r9);
        if (r9 == false) goto L12;
        r1.a();
        return;
    L12:
        r1.b();
        return;
    L8:
        r9 = false;
        goto L9
    L5:
        r8 = null;
        goto L6
    }
}
