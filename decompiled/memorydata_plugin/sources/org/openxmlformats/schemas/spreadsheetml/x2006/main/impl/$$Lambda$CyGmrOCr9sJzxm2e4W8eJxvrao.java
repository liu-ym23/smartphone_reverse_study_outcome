package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.-$$Lambda$CyGmrOCr9sJzxm2e4W-8eJxvrao, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class $$Lambda$CyGmrOCr9sJzxm2e4W8eJxvrao implements Consumer {
    public final /* synthetic */ CTCfRuleImpl f$0;

    public /* synthetic */ $$Lambda$CyGmrOCr9sJzxm2e4W8eJxvrao(CTCfRuleImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeFormula(((Integer) r1).intValue());
    }
}
