package com.obric.assistant.component;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class k6 implements Runnable {
    public final /* synthetic */ OrionInstructionComponent a;

    public /* synthetic */ k6(OrionInstructionComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OrionInstructionComponent r0 = this.a;
        int r1 = OrionInstructionComponent.p1;
        com.larus.bmhome.instruction.g r2 = r0.vc();
        if (r2 == null) goto L7;
        com.larus.bmhome.actionbar.model.z0 r3 = r2.yF();
        if (r3 == null) goto L7;
        String r4 = r3.b;
    L9:
        if (OrionInstructionComponent.i4(r4) == false) goto L20;
        ada.c r5 = r0.Z3();
        if (r5 == null) goto L13;
        r5.Ep();
    L13:
        ICoreInputAbility r6 = r0.B3();
        if (r6 == null) goto L16;
        r6.qp(false);
    L16:
        ICoreInputAbility r7 = r0.B3();
        if (r7 == null) goto L21;
        r7.g2(2, false);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r4 = null;
        goto L9
    }
}
