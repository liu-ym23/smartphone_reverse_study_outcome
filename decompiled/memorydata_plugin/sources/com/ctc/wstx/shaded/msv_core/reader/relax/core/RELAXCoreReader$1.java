package com.ctc.wstx.shaded.msv_core.reader.relax.core;

import com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;

/* JADX INFO: loaded from: classes2.dex */
class RELAXCoreReader$1 extends ReferenceContainer {
    final /* synthetic */ a this$0;

    RELAXCoreReader$1(a r1) {
        this.this$0 = r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceContainer
    public ReferenceExp createReference(String r1) {
        return new ReferenceExp(r1);
    }
}
