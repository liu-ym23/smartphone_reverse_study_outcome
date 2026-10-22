package com.bytedance.android.ec.core.imagex.opt;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@"}, d2 = {"", "", "configKeys", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "onInitConfig"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.imagex.opt.ECImageMainHandlerOpt", f = "ECImageMainHandlerOpt.kt", i = {0, 0, 0}, l = {49}, m = "onInitConfig", n = {"emptyConfig", "rules", "retryKeys"}, s = {"L$0", "L$1", "L$2"})
public final class ECImageMainHandlerOpt$onInitConfig$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECImageMainHandlerOpt this$0;

    public ECImageMainHandlerOpt$onInitConfig$1(ECImageMainHandlerOpt r1, Continuation r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        ECImageMainHandlerOpt r11 = this.this$0;
        KProperty[] r0 = ECImageMainHandlerOpt.a;
        return r11.b(null, this);
    }
}
