package com.microsoft.schemas.office.excel.impl;

import java.util.function.Supplier;

/* JADX INFO: renamed from: com.microsoft.schemas.office.excel.impl.-$$Lambda$2Yedp1qIwrlR2TJ845f2Zc0vZq0, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$2Yedp1qIwrlR2TJ845f2Zc0vZq0 implements Supplier {
    public final /* synthetic */ CTClientDataImpl f$0;

    public /* synthetic */ $$Lambda$2Yedp1qIwrlR2TJ845f2Zc0vZq0(CTClientDataImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.f$0.sizeOfAccel2Array());
    }
}
