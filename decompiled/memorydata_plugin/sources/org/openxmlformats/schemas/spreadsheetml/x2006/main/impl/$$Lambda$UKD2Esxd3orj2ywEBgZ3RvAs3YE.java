package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.-$$Lambda$UKD2Esxd3orj2ywEBgZ3RvAs3YE, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class $$Lambda$UKD2Esxd3orj2ywEBgZ3RvAs3YE implements Supplier {
    public final /* synthetic */ CTProtectedRangeImpl f$0;

    public /* synthetic */ $$Lambda$UKD2Esxd3orj2ywEBgZ3RvAs3YE(CTProtectedRangeImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.f$0.sizeOfSecurityDescriptorArray());
    }
}
