package com.larus.bmhome.chat.component.playback;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.playback.MessagePlaybackHelper", f = "MessagePlaybackHelper.kt", i = {0, 1}, l = {192, 62}, m = "submitMessageOneByOne", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class MessagePlaybackHelper$submitMessageOneByOne$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessagePlaybackHelper this$0;

    public MessagePlaybackHelper$submitMessageOneByOne$1(MessagePlaybackHelper r1, Continuation<? super MessagePlaybackHelper$submitMessageOneByOne$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
