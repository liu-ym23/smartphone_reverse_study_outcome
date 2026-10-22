package com.obric.memorydata.sdk.service;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Function0 {
    public /* synthetic */ d() {
    }

    public final Object invoke() {
        Context r0 = MemoryDataServiceProxy.c;
        if (r0 == null) goto L5;
        r0.unbindService(MemoryDataServiceProxy.j);
        return Unit.INSTANCE;
    L5:
        return null;
    }
}
