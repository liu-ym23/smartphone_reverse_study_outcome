package com.obric.memorydata.sdk.memory;

import com.obric.memorydata.sdk.service.BinderCode;
import com.obric.memorydata.sdk.service.MemoryDataServiceProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class MemoryServiceProxy {
    public static final /* synthetic */ int a = 0;

    static {
        MemoryDataServiceProxy r0 = MemoryDataServiceProxy.a;
        int r1 = BinderCode.MEMORY.ordinal();
        MemoryDataServiceProxy.a r2 = new a();
        Intrinsics.checkNotNullParameter(r2, "listener");
        Integer r3 = Integer.valueOf(r1);
        MemoryDataServiceProxy.h.put(r3, r2);
    }
}
