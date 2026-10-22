package com.larus.bmhome.chat.deepresearch.component;

import android.content.Context;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.helper.s0;
import com.larus.im.bean.message.block.Block;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.DeepReSearchTitleComponent$performCopy$1$markdownContentList$1", f = "DeepReSearchTitleComponent.kt", i = {}, l = {DoraCallStateCode.DOUBAO_ENV_OBE_STOP_CONVERSATION}, m = "invokeSuspend", n = {}, s = {})
public final class DeepReSearchTitleComponent$performCopy$1$markdownContentList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends lw8.l>>, Object> {
    final /* synthetic */ List<Block> $blocks;
    int label;
    final /* synthetic */ DeepReSearchTitleComponent this$0;

    public DeepReSearchTitleComponent$performCopy$1$markdownContentList$1(DeepReSearchTitleComponent r1, List<Block> r2, Continuation<? super DeepReSearchTitleComponent$performCopy$1$markdownContentList$1> r3) {
        this.this$0 = r1;
        this.$blocks = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DeepReSearchTitleComponent$performCopy$1$markdownContentList$1(this.this$0, this.$blocks, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends lw8.l>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L16:
        return (List) r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        s0 r3 = ILegacyChatUiServiceDelegate.b.X8();
        if (r3 == null) goto L14;
        Context r4 = this.this$0.getContext();
        List<Block> r5 = this.$blocks;
        this.label = 1;
        r11 = s0.a.c(r3, r4, r5, false, null, this, 504);
        if (r11 != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
