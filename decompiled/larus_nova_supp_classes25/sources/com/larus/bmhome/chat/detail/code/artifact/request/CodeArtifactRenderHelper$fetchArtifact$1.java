package com.larus.bmhome.chat.detail.code.artifact.request;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.detail.code.artifact.request.CodeArtifactRenderHelper", f = "CodeArtifactRenderHelper.kt", i = {}, l = {39}, m = "fetchArtifact", n = {}, s = {})
final class CodeArtifactRenderHelper$fetchArtifact$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public CodeArtifactRenderHelper$fetchArtifact$1(a r1, Continuation<? super CodeArtifactRenderHelper$fetchArtifact$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return a.a(this.this$0, 0, null, this);
    }
}
