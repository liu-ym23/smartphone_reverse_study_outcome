package com.microsoft.schemas.office.excel.impl;

import java.util.function.Supplier;

/* JADX INFO: renamed from: com.microsoft.schemas.office.excel.impl.-$$Lambda$tzACmQL7ZloZ4q2EP8lxgRKaITY, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$tzACmQL7ZloZ4q2EP8lxgRKaITY implements Supplier {
    public final /* synthetic */ CTClientDataImpl f$0;

    public /* synthetic */ $$Lambda$tzACmQL7ZloZ4q2EP8lxgRKaITY(CTClientDataImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.f$0.sizeOfScriptExtendedArray());
    }
}
