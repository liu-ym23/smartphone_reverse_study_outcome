package com.larus.bmhome.chat.markdown.code.share;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.share.CodeShareHelper", f = "CodeShareHelper.kt", i = {0}, l = {DoraCallStateCode.DOUBAO_CMD_12}, m = "applyCodeExportWatermark", n = {"perf"}, s = {"L$0"})
final class CodeShareHelper$applyCodeExportWatermark$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CodeShareHelper this$0;

    public CodeShareHelper$applyCodeExportWatermark$1(CodeShareHelper r1, Continuation<? super CodeShareHelper$applyCodeExportWatermark$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CodeShareHelper.a(this.this$0, null, this);
    }
}
