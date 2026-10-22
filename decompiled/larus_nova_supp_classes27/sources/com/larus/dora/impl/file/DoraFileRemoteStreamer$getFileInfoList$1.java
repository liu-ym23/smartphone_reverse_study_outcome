package com.larus.dora.impl.file;

import com.larus.dora.impl.ota.g2.j0;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileRemoteStreamer", f = "DoraFileRemoteStreamer.kt", i = {0, 0, 0, 0}, l = {j0.G2_OTA_GLASSES_BATTERY_MIN}, m = "getFileInfoList", n = {"transportType", "fetchFrom", "type", "startTime"}, s = {"L$0", "L$1", "I$0", "J$0"})
public final class DoraFileRemoteStreamer$getFileInfoList$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileRemoteStreamer this$0;

    public DoraFileRemoteStreamer$getFileInfoList$1(DoraFileRemoteStreamer r1, Continuation<? super DoraFileRemoteStreamer$getFileInfoList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(0, null, null, this);
    }
}
