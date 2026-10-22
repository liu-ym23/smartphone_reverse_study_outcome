package com.larus.dora.impl.serviceimpl;

import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.WifiService", f = "WifiService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3}, l = {173, 176, 182, 183}, m = "connectWithAssistantWifiCheck", n = {"scene", "strategy", "useAssistantWifi", "hasRequestedAssistantWifi", "scene", "strategy", "useAssistantWifi", "hasRequestedAssistantWifi", "scene", "strategy", "result", "useAssistantWifi", "scene", "result", "useAssistantWifi"}, s = {"L$0", "L$1", "I$0", "Z$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
public final class WifiService$connectWithAssistantWifiCheck$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WifiService this$0;

    public WifiService$connectWithAssistantWifiCheck$1(WifiService r1, Continuation<? super WifiService$connectWithAssistantWifiCheck$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        WifiService r3 = this.this$0;
        Set r0 = WifiService.a;
        return r3.i(null, null, this);
    }
}
