package com.microsoft.schemas.office.excel.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: com.microsoft.schemas.office.excel.impl.-$$Lambda$Y8FtMSs8h-JOwB4gVPDbNAVNZYA, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$Y8FtMSs8hJOwB4gVPDbNAVNZYA implements Consumer {
    public final /* synthetic */ CTClientDataImpl f$0;

    public /* synthetic */ $$Lambda$Y8FtMSs8hJOwB4gVPDbNAVNZYA(CTClientDataImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeHoriz(((Integer) r1).intValue());
    }
}
