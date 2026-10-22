package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.chain.HandleInvalidDataInterceptor", f = "HandleInvalidDataInterceptor.kt", i = {0}, l = {172}, m = "intercept", n = {"models"}, s = {"L$0"})
final class HandleInvalidDataInterceptor$intercept$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HandleInvalidDataInterceptor this$0;

    public HandleInvalidDataInterceptor$intercept$1(HandleInvalidDataInterceptor r1, Continuation<? super HandleInvalidDataInterceptor$intercept$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return this.this$0.b(null, this);
    }
}
