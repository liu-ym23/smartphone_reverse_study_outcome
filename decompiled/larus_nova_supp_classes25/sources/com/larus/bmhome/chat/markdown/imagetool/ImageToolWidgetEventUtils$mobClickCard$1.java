package com.larus.bmhome.chat.markdown.imagetool;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import oi8.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.imagetool.ImageToolWidgetEventUtils$mobClickCard$1", f = "ImageToolWidgetEventUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ImageToolWidgetEventUtils$mobClickCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ boolean $isFold;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $toolName;
    int label;

    public ImageToolWidgetEventUtils$mobClickCard$1(boolean r1, Message r2, String r3, String r4, Continuation<? super ImageToolWidgetEventUtils$mobClickCard$1> r5) {
        this.$isFold = r1;
        this.$message = r2;
        this.$botId = r3;
        this.$toolName = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ImageToolWidgetEventUtils$mobClickCard$1(this.$isFold, this.$message, this.$botId, this.$toolName, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r25);
        int r1 = n.a;
        ChatParam r3 = g.a();
        ri8.c r2 = ri8.c.a;
        n.a(this.$message, r3, null, null, null, "tool_card", this.$botId, ri8.c.g(Boxing.boxBoolean(!this.$isFold)), null, null, null, null, Boxing.boxBoolean(true), null, null, null, null, this.$toolName, null, null, null, 3923740);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
