package com.larus.dora.impl.ota.connector;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.connector.DoraOTAWifiConnector", f = "DoraOTAWifiConnector.kt", i = {}, l = {74}, m = "prepareConnectorWithoutPermissionRequest", n = {}, s = {})
final class DoraOTAWifiConnector$prepareConnectorWithoutPermissionRequest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraOTAWifiConnector this$0;

    public DoraOTAWifiConnector$prepareConnectorWithoutPermissionRequest$1(DoraOTAWifiConnector r1, Continuation<? super DoraOTAWifiConnector$prepareConnectorWithoutPermissionRequest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, null, this);
    }
}
