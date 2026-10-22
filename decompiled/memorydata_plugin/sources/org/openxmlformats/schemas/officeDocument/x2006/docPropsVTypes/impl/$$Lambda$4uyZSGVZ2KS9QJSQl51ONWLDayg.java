package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.-$$Lambda$4uyZSGVZ2KS9QJSQl51ONWLDayg, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class $$Lambda$4uyZSGVZ2KS9QJSQl51ONWLDayg implements Consumer {
    public final /* synthetic */ CTVectorImpl f$0;

    public /* synthetic */ $$Lambda$4uyZSGVZ2KS9QJSQl51ONWLDayg(CTVectorImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeClsid(((Integer) r1).intValue());
    }
}
