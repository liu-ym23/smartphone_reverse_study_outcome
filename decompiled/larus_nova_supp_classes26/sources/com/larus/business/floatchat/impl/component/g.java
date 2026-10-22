package com.larus.business.floatchat.impl.component;

import android.view.View;
import com.larus.business.floatchat.api.AIChatInputConfig;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ AIChatInputConfigComponent a;
    public final /* synthetic */ AIChatInputConfig b;
    public final /* synthetic */ View c;

    public /* synthetic */ g(AIChatInputConfigComponent r1, AIChatInputConfig r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AIChatInputConfigComponent r0 = this.a;
        AIChatInputConfig r1 = this.b;
        View r2 = this.c;
        if (Intrinsics.areEqual(r0.s, r1) == true) goto L5;
        FLogger.a.i("AIChatInputConfigComponent", "[applyActionBar] skip stale config, enable=" + r1.h);
        return;
    L5:
        View r3 = r2.findViewById(2131362044);
        com.larus.bmhome.instruction.g r4 = (com.larus.bmhome.instruction.g) r0.q.getValue();
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[applyActionBar] enable=");
        r6.append(r0.E2());
        r6.append(", hasInstructionAbility=");
        int r7 = 0;
        if (r4 == null) goto L8;
        boolean r8 = true;
    L9:
        r6.append(r8);
        r6.append(", containerVisibility=");
        Integer r9 = null;
        if (r3 == null) goto L12;
        Integer r10 = Integer.valueOf(r3.getVisibility());
    L13:
        r6.append(r10);
        r6.append(", containerHeight=");
        if (r3 == null) goto L16;
        r9 = Integer.valueOf(r3.getHeight());
    L16:
        r6.append(r9);
        r5.i("AIChatInputConfigComponent", r6.toString());
        if (r4 == null) goto L19;
        r4.SF();
    L25:
        if (r3 == null) goto L27;
        r3.requestLayout();
    L27:
        r2.requestLayout();
        return;
    L19:
        if (r3 == null) goto L25;
        if (r0.E2() == true) goto L24;
        r7 = 8;
    L24:
        r3.setVisibility(r7);
        goto L25
    L12:
        r10 = null;
        goto L13
    L8:
        r8 = false;
        goto L9
    }
}
