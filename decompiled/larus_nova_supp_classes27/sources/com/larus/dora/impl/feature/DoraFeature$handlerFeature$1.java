package com.larus.dora.impl.feature;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feature.DoraFeature", f = "DoraFeature.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {89, 107}, m = "handlerFeature", n = {"uid", "p2pRTCRuntimeState", "linkMode", "xLinkConfig", "userBluetoothRTCEnabled", "userP2PRTCEnabled", "p2pRTCRuntimeSupported", "effectiveBluetoothRTCEnabled", "effectiveP2PRTCEnabled"}, s = {"L$0", "L$0", "L$1", "L$2", "Z$0", "Z$1", "Z$2", "I$0", "I$1"})
public final class DoraFeature$handlerFeature$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFeature this$0;

    public DoraFeature$handlerFeature$1(DoraFeature r1, Continuation<? super DoraFeature$handlerFeature$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraFeature r3 = this.this$0;
        DoraFeature r0 = DoraFeature.a;
        return r3.a(this);
    }
}
