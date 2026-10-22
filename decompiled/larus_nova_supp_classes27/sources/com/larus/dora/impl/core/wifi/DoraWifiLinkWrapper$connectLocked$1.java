package com.larus.dora.impl.core.wifi;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper", f = "DoraWifiLinkWrapper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {92, 787}, m = "connectLocked", n = {"scene", "strategy", "owner", "onDisconnected", "scene", "owner", "onDisconnected", "wifiManager", "finalStrategy"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class DoraWifiLinkWrapper$connectLocked$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraWifiLinkWrapper this$0;

    public DoraWifiLinkWrapper$connectLocked$1(DoraWifiLinkWrapper r1, Continuation<? super DoraWifiLinkWrapper$connectLocked$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        DoraWifiLinkWrapper r0 = this.this$0;
        DoraWifiLinkWrapper r9 = DoraWifiLinkWrapper.a;
        return r0.c(null, null, false, null, null, this);
    }
}
