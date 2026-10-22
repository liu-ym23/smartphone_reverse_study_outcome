package com.larus.dispatcher.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.api.GetAllDevicesRepo", f = "GetAllDevicesRepo.kt", i = {0}, l = {389}, m = "requestAllDevices", n = {"caller"}, s = {"L$0"})
final class GetAllDevicesRepo$requestAllDevices$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetAllDevicesRepo this$0;

    public GetAllDevicesRepo$requestAllDevices$1(GetAllDevicesRepo r1, Continuation<? super GetAllDevicesRepo$requestAllDevices$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return GetAllDevicesRepo.b(this.this$0, null, this);
    }
}
