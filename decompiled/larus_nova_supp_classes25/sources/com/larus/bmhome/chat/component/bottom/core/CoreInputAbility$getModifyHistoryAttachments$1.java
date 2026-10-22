package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputAbility", f = "CoreInputAbility.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {1293, 1297}, m = "getModifyHistoryAttachments", n = {"message", "historyEntities", "collectionId", "message", "historyEntities", "collectionId", "blockAttachmentReeditFix"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "Z$0"})
final class CoreInputAbility$getModifyHistoryAttachments$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoreInputAbility<ComponentFeature> this$0;

    public CoreInputAbility$getModifyHistoryAttachments$1(CoreInputAbility<ComponentFeature> r1, Continuation<? super CoreInputAbility$getModifyHistoryAttachments$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CoreInputAbility.b(this.this$0, null, this);
    }
}
