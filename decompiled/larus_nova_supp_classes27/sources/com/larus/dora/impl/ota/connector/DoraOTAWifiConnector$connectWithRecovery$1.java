package com.larus.dora.impl.ota.connector;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.connector.DoraOTAWifiConnector", f = "DoraOTAWifiConnector.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {102, 106, 108, 115, 128, 131, 133, 140}, m = "connectWithRecovery", n = {"owner", "onDisconnected", "requestPermission", "owner", "onDisconnected", "requestPermission", "owner", "onDisconnected", "requestPermission", "owner", "onDisconnected", "requestPermission", "owner", "onDisconnected", "requestPermission"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
public final class DoraOTAWifiConnector$connectWithRecovery$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraOTAWifiConnector this$0;

    public DoraOTAWifiConnector$connectWithRecovery$1(DoraOTAWifiConnector r1, Continuation<? super DoraOTAWifiConnector$connectWithRecovery$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        DoraOTAWifiConnector r4 = this.this$0;
        int r0 = DoraOTAWifiConnector.i;
        return r4.f(false, null, null, this);
    }
}
