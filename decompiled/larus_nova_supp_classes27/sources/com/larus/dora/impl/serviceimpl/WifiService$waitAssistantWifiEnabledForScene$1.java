package com.larus.dora.impl.serviceimpl;

import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.WifiService", f = "WifiService.kt", i = {0, 0}, l = {242}, m = "waitAssistantWifiEnabledForScene", n = {"scene", "index"}, s = {"L$0", "I$2"})
public final class WifiService$waitAssistantWifiEnabledForScene$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WifiService this$0;

    public WifiService$waitAssistantWifiEnabledForScene$1(WifiService r1, Continuation<? super WifiService$waitAssistantWifiEnabledForScene$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        WifiService r3 = this.this$0;
        Set r0 = WifiService.a;
        return r3.n(null, this);
    }
}
