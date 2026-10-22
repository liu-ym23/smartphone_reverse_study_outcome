package com.larus.bmhome.block.holder.content.lynx;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.block.holder.content.lynx.LynxCardBlockHolder", f = "LynxCardBlockHolder.kt", i = {0, 0, 0}, l = {384}, m = "createIvyPluginView", n = {"ivyPluginView", "start", "ts1"}, s = {"L$0", "J$0", "J$1"})
final class LynxCardBlockHolder$createIvyPluginView$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LynxCardBlockHolder this$0;

    public LynxCardBlockHolder$createIvyPluginView$1(LynxCardBlockHolder r1, Continuation<? super LynxCardBlockHolder$createIvyPluginView$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return LynxCardBlockHolder.j(this.this$0, null, null, this);
    }
}
