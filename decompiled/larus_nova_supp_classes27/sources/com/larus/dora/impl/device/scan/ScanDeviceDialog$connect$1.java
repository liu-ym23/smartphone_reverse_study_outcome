package com.larus.dora.impl.device.scan;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.scan.ScanDeviceDialog", f = "ScanDeviceDialog.kt", i = {0}, l = {185, 188}, m = "connect", n = {"device"}, s = {"L$0"})
final class ScanDeviceDialog$connect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScanDeviceDialog this$0;

    public ScanDeviceDialog$connect$1(ScanDeviceDialog r1, Continuation<? super ScanDeviceDialog$connect$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ScanDeviceDialog.S90(this.this$0, null, this);
    }
}
