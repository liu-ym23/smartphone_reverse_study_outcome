package com.microsoft.schemas.office.excel.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: com.microsoft.schemas.office.excel.impl.-$$Lambda$apy7EavKKHd2WpwvZHXqeZMaDc4, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$apy7EavKKHd2WpwvZHXqeZMaDc4 implements Consumer {
    public final /* synthetic */ CTClientDataImpl f$0;

    public /* synthetic */ $$Lambda$apy7EavKKHd2WpwvZHXqeZMaDc4(CTClientDataImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeAutoScale(((Integer) r1).intValue());
    }
}
