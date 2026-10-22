package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.-$$Lambda$hVVeWmLZlNzBqNP1lQ5seLwTwdc, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class $$Lambda$hVVeWmLZlNzBqNP1lQ5seLwTwdc implements Consumer {
    public final /* synthetic */ CTVectorImpl f$0;

    public /* synthetic */ $$Lambda$hVVeWmLZlNzBqNP1lQ5seLwTwdc(CTVectorImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeFiletime(((Integer) r1).intValue());
    }
}
