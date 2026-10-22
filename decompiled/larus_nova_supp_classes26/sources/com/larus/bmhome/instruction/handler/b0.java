package com.larus.bmhome.instruction.handler;

import com.larus.bmhome.instruction.w1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 extends i {
    public b0(com.larus.bmhome.instruction.p r2) {
        Intrinsics.checkNotNullParameter(r2, "instructionCoreAbility");
        super(r2);
    }

    @Override // com.larus.bmhome.instruction.handler.m
    public final void a(com.larus.bmhome.instruction.n r8) {
        Intrinsics.checkNotNullParameter(r8, "inputData");
        if (r8.c == false) goto L5;
        w1.b("PromptToImageHandler", "PromptToImageHandler  autoSend is not available now");
        return;
    L5:
        com.larus.bmhome.instruction.g r1 = (com.larus.bmhome.instruction.g) this.f.getValue();
        if (r1 == null) goto L10;
        com.larus.bmhome.instruction.g.a.e(r1, null, 4, r8.b, 5, 1);
        return;
    }
}
