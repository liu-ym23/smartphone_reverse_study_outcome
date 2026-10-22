package com.larus.bmhome.chat.auth;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginAuthRepository", f = "PluginAuthRepository.kt", i = {}, l = {MessageCellStateTransformerType.AWEME_POST_LIST}, m = "requestPluginList", n = {}, s = {})
public final class PluginAuthRepository$requestPluginList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PluginAuthRepository this$0;

    public PluginAuthRepository$requestPluginList$1(PluginAuthRepository r1, Continuation<? super PluginAuthRepository$requestPluginList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, 0, 0, null, this);
    }
}
