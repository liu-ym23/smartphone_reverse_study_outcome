package com.larus.bmhome.instruction;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.im.internal.jni.bean.OmniBotConversationType;
import com.larus.im.internal.jni.bean.OmniConversationType;
import com.larus.im.internal.jni.bean.OmniModifyConversationRequest;
import com.larus.im.internal.legacy.b5;
import com.larus.im.internal.legacy.c5;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$notifyConversationReplyModeChanged$1", f = "InstructionInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$notifyConversationReplyModeChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ ModelItemIdentity $model;
    final /* synthetic */ ReplyOption $option;
    int label;

    public InstructionInputComponent$notifyConversationReplyModeChanged$1(wc9.e r1, ModelItemIdentity r2, ReplyOption r3, String r4, Continuation<? super InstructionInputComponent$notifyConversationReplyModeChanged$1> r5) {
        this.$conversation = r1;
        this.$model = r2;
        this.$option = r3;
        this.$conversationId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new InstructionInputComponent$notifyConversationReplyModeChanged$1(this.$conversation, this.$model, this.$option, this.$conversationId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r14);
        int r15 = c5.a;
        Integer r16 = this.$conversation.j;
        if (r16 == null) goto L7;
        int r17 = r16.intValue();
    L8:
        OmniConversationType r3 = c5.a(r17);
        int r18 = b5.a;
        Integer r19 = this.$conversation.v;
        if (r19 == null) goto L11;
        int r110 = r19.intValue();
    L12:
        OmniBotConversationType r4 = b5.c(Boxing.boxInt(r110));
        String r5 = String.valueOf(this.$model.getDeprecatedItemId());
        String r111 = this.$model.getKey();
        if (r111 != null) goto L15;
        String r7 = "";
    L16:
        Integer r112 = this.$option.getReasoningEffort();
        if (r112 == null) goto L19;
        int r9 = r112.intValue();
    L20:
        String r113 = this.$option.getModeId();
        if (r113 != null) goto L23;
        String r8 = "";
    L24:
        OmniModifyConversationRequest r114 = new OmniModifyConversationRequest(this.$conversationId, r3, r4, r5, null, r7, r8, r9, null, 272, null);
        com.larus.im.d.d().modifyConversation(r114, null);
        return Unit.INSTANCE;
    L23:
        r8 = r113;
        goto L24
    L19:
        r9 = 0;
        goto L20
    L15:
        r7 = r111;
        goto L16
    L11:
        r110 = 0;
        goto L12
    L7:
        r17 = 0;
        goto L8
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
