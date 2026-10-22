package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.-$$Lambda$Y-SxgeP3PPHLOYS-PdSLlRdzXFI, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class $$Lambda$YSxgeP3PPHLOYSPdSLlRdzXFI implements Consumer {
    public final /* synthetic */ CTVectorImpl f$0;

    public /* synthetic */ $$Lambda$YSxgeP3PPHLOYSPdSLlRdzXFI(CTVectorImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeError(((Integer) r1).intValue());
    }
}
