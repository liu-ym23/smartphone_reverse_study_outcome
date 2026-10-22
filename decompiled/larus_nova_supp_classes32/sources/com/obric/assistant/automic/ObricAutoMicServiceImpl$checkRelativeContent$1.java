package com.obric.assistant.automic;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.automic.ObricAutoMicServiceImpl", f = "ObricAutoMicServiceImpl.kt", i = {}, l = {229}, m = "checkRelativeContent", n = {}, s = {})
public final class ObricAutoMicServiceImpl$checkRelativeContent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricAutoMicServiceImpl this$0;

    public ObricAutoMicServiceImpl$checkRelativeContent$1(ObricAutoMicServiceImpl r1, Continuation<? super ObricAutoMicServiceImpl$checkRelativeContent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, null, this);
    }
}
