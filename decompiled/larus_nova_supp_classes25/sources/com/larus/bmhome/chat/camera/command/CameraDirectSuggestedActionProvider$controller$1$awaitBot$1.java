package com.larus.bmhome.chat.camera.command;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.camera.command.CameraDirectSuggestedActionProvider$controller$1", f = "CameraDirectSuggestedActionProvider.kt", i = {}, l = {MessageCellStateTransformerType.NESTED_FILE}, m = "awaitBot", n = {}, s = {})
public final class CameraDirectSuggestedActionProvider$controller$1$awaitBot$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraDirectSuggestedActionProvider$controller$1 this$0;

    public CameraDirectSuggestedActionProvider$controller$1$awaitBot$1(CameraDirectSuggestedActionProvider$controller$1 r1, Continuation<? super CameraDirectSuggestedActionProvider$controller$1$awaitBot$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
