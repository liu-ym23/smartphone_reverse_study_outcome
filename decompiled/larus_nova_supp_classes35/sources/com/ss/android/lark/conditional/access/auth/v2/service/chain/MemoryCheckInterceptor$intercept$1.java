package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.chain.MemoryCheckInterceptor", f = "MemoryCheckInterceptor.kt", i = {1, 1}, l = {MediaContent.COMPRESS_PROGRESS_PROPORTION, 100}, m = "intercept", n = {"authResultMap", "noCacheModels"}, s = {"L$0", "L$1"})
final class MemoryCheckInterceptor$intercept$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public MemoryCheckInterceptor$intercept$1(b r1, Continuation<? super MemoryCheckInterceptor$intercept$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return this.this$0.b(null, this);
    }
}
