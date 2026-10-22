package com.larus.bmhome.block.holder.content.lynx;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.block.holder.content.lynx.SpringLynxBlockHolder", f = "SpringLynxBlockHolder.kt", i = {0}, l = {297}, m = "createIvyPluginView", n = {"ivyPluginView"}, s = {"L$0"})
final class SpringLynxBlockHolder$createIvyPluginView$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpringLynxBlockHolder this$0;

    public SpringLynxBlockHolder$createIvyPluginView$1(SpringLynxBlockHolder r1, Continuation<? super SpringLynxBlockHolder$createIvyPluginView$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return SpringLynxBlockHolder.j(this.this$0, null, null, this);
    }
}
