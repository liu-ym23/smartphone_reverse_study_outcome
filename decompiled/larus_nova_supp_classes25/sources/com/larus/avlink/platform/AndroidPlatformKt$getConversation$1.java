package com.larus.avlink.platform;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.platform.AndroidPlatformKt", f = "AndroidPlatform.kt", i = {0, 0}, l = {MessageCellStateTransformerType.SUMMARY_CARD, 39}, m = "getConversation", n = {"conversationId", "conversationRepo"}, s = {"L$0", "L$1"})
public final class AndroidPlatformKt$getConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public AndroidPlatformKt$getConversation$1(Continuation<? super AndroidPlatformKt$getConversation$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AndroidPlatformKt.b(null, this);
    }
}
