package com.larus.bmhome.chat.auth;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginItemPagingCache", f = "PluginItemPagingCache.kt", i = {}, l = {53}, m = "updateFirstPage", n = {}, s = {})
public final class PluginItemPagingCache$updateFirstPage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PluginItemPagingCache this$0;

    public PluginItemPagingCache$updateFirstPage$1(PluginItemPagingCache r1, Continuation<? super PluginItemPagingCache$updateFirstPage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        PluginItemPagingCache r3 = this.this$0;
        int r0 = PluginItemPagingCache.g;
        return r3.b(null, this);
    }
}
