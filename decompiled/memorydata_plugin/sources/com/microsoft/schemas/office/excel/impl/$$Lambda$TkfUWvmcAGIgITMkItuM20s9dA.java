package com.microsoft.schemas.office.excel.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: com.microsoft.schemas.office.excel.impl.-$$Lambda$TkfUWvmcAGIg-ITMkItuM20s9dA, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$TkfUWvmcAGIgITMkItuM20s9dA implements Consumer {
    public final /* synthetic */ CTClientDataImpl f$0;

    public /* synthetic */ $$Lambda$TkfUWvmcAGIgITMkItuM20s9dA(CTClientDataImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeFmlaMacro(((Integer) r1).intValue());
    }
}
