package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.-$$Lambda$V3HSI2h2ZG_Mqv9TDMED6uJafKc, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class $$Lambda$V3HSI2h2ZG_Mqv9TDMED6uJafKc implements Consumer {
    public final /* synthetic */ CTProtectedRangeImpl f$0;

    public /* synthetic */ $$Lambda$V3HSI2h2ZG_Mqv9TDMED6uJafKc(CTProtectedRangeImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeSecurityDescriptor(((Integer) r1).intValue());
    }
}
