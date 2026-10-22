package com.microsoft.schemas.office.excel.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: com.microsoft.schemas.office.excel.impl.-$$Lambda$s1j7_sPNt94mJc-UzDVhxvhZOaQ, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$s1j7_sPNt94mJcUzDVhxvhZOaQ implements Consumer {
    public final /* synthetic */ CTClientDataImpl f$0;

    public /* synthetic */ $$Lambda$s1j7_sPNt94mJcUzDVhxvhZOaQ(CTClientDataImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeValidIds(((Integer) r1).intValue());
    }
}
