package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.SkillSearchIndex", f = "SkillSearchIndex.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {70, 71}, m = "search", n = {"context", "keyword", "$this$search_u24lambda_u246", "skill", "key", "requestEpoch", "context", "keyword", "$this$search_u24lambda_u246", "skill", "key", "requestEpoch"}, s = {"L$0", "L$1", "L$3", "L$5", "L$6", "J$0", "L$0", "L$1", "L$3", "L$5", "L$6", "J$0"})
public final class SkillSearchIndex$search$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SkillSearchIndex this$0;

    public SkillSearchIndex$search$1(SkillSearchIndex r1, Continuation<? super SkillSearchIndex$search$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
