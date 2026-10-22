package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.chain.PreCheckInterceptor", f = "PreCheckInterceptor.kt", i = {0, 0}, l = {105}, m = "intercept", n = {"models", "startTime"}, s = {"L$0", "J$0"})
final class PreCheckInterceptor$intercept$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public PreCheckInterceptor$intercept$1(d r1, Continuation<? super PreCheckInterceptor$intercept$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return this.this$0.b(null, this);
    }
}
