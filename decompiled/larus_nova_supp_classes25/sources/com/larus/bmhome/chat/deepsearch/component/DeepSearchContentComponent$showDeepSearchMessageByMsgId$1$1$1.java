package com.larus.bmhome.chat.deepsearch.component;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepsearch.component.DeepSearchContentComponent$showDeepSearchMessageByMsgId$1$1$1", f = "DeepSearchContentComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DeepSearchContentComponent$showDeepSearchMessageByMsgId$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ DeepSearchContentComponent this$0;

    public DeepSearchContentComponent$showDeepSearchMessageByMsgId$1$1$1(Message r1, DeepSearchContentComponent r2, Continuation<? super DeepSearchContentComponent$showDeepSearchMessageByMsgId$1$1$1> r3) {
        this.$message = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DeepSearchContentComponent$showDeepSearchMessageByMsgId$1$1$1(this.$message, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r49) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L44;
        ResultKt.throwOnFailure(r49);
        Message r4 = this.$message;
        q0 r5 = null;
        List r2 = CollectionsKt.listOf(new Message[]{r4, Message.copy$default(r4, null, null, null, 0, 0, null, 2, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -65, 31, null)});
        RecyclerView r3 = this.this$0.r;
        if (r3 == null) goto L7;
        RecyclerView.Adapter r6 = r3.getAdapter();
    L9:
        if ((r6 instanceof q0) == false) goto L11;
        q0 r7 = (q0) r6;
    L12:
        if (r7 == null) goto L14;
        com.larus.bmhome.chat.deepsearch.j.a(r7, r2, true);
    L14:
        RecyclerView r8 = this.this$0.r;
        if (r8 == null) goto L17;
        RecyclerView.Adapter r9 = r8.getAdapter();
    L19:
        if ((r9 instanceof q0) == false) goto L21;
        q0 r10 = (q0) r9;
    L22:
        String r11 = "";
        if (r10 == null) goto L28;
        String r12 = this.$message.getMessageId();
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        Boxing.boxBoolean(r10.x7(r12, 800));
    L28:
        RecyclerView r13 = this.this$0.r;
        if (r13 == null) goto L31;
        RecyclerView.Adapter r14 = r13.getAdapter();
    L33:
        if ((r14 instanceof q0) == false) goto L35;
        r5 = (q0) r14;
    L35:
        if (r5 == null) goto L41;
        String r15 = this.$message.getMessageId();
        if (r15 == null) goto L40;
        r11 = r15;
    L40:
        Boxing.boxBoolean(r5.x7(r11, 2));
    L41:
        FLogger.a.d(this.this$0.m, "[biz_deep_search]DeepSearchMessageAdapter notifyItemChanged " + this.$message.getMessageId());
        return Unit.INSTANCE;
    L31:
        r14 = null;
        goto L33
    L21:
        r10 = null;
        goto L22
    L17:
        r9 = null;
        goto L19
    L11:
        r7 = null;
        goto L12
    L7:
        r6 = null;
        goto L9
    L44:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
