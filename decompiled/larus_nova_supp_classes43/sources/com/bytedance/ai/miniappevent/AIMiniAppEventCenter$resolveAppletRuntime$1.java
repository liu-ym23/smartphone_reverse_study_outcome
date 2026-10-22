package com.bytedance.ai.miniappevent;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.miniappevent.AIMiniAppEventCenter", f = "AIMiniAppEventCenter.kt", i = {0}, l = {157}, m = "resolveAppletRuntime", n = {"appletId"}, s = {"L$0"})
public final class AIMiniAppEventCenter$resolveAppletRuntime$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIMiniAppEventCenter this$0;

    public AIMiniAppEventCenter$resolveAppletRuntime$1(AIMiniAppEventCenter r1, Continuation<? super AIMiniAppEventCenter$resolveAppletRuntime$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AIMiniAppEventCenter r11 = this.this$0;
        AIMiniAppEventCenter r0 = AIMiniAppEventCenter.a;
        return r11.i(null, false, this);
    }
}
