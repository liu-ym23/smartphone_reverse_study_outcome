package com.larus.uaigc.chat.image.event;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.image.event.GenerateImageTrace$onAddOrUpdateMessage$8", f = "GenerateImageTrace.kt", i = {}, l = {302}, m = "invokeSuspend", n = {}, s = {})
public final class GenerateImageTrace$onAddOrUpdateMessage$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ by7.a $event;
    final /* synthetic */ Ref.IntRef $imageSuccessCount;
    final /* synthetic */ Ref.IntRef $imageTotalCount;
    final /* synthetic */ long $lastSendMsgTime;
    final /* synthetic */ Message $msg;
    int label;

    public GenerateImageTrace$onAddOrUpdateMessage$8(Message r1, by7.a r2, Ref.IntRef r3, Ref.IntRef r4, long r5, Continuation<? super GenerateImageTrace$onAddOrUpdateMessage$8> r7) {
        this.$msg = r1;
        this.$event = r2;
        this.$imageSuccessCount = r3;
        this.$imageTotalCount = r4;
        this.$lastSendMsgTime = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new GenerateImageTrace$onAddOrUpdateMessage$8(this.$msg, this.$event, this.$imageSuccessCount, this.$imageTotalCount, this.$lastSendMsgTime, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r2 = 1;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        Message r12 = (Message) r11;
        if (r12 != null) goto L14;
    L16:
        int r3 = 0;
    L18:
        if (Intrinsics.areEqual(ap8.a.b(this.$msg), "avatar_image") == false) goto L26;
        if (r12 == null) goto L21;
        MessageStatus r13 = r12.getMessageStatus();
    L23:
        if (r13 != MessageStatus.MessageStatus_INVISIBLE) goto L25;
        this.$event.d("create_way", "replica_onboarding");
        goto L26
    L25:
        this.$event.d("create_way", "chat_action_bar");
        goto L26
    L21:
        r13 = null;
    L26:
        by7.a r14 = this.$event;
        Message r4 = this.$msg;
        Ref.IntRef r5 = this.$imageSuccessCount;
        Ref.IntRef r6 = this.$imageTotalCount;
        long r7 = this.$lastSendMsgTime;
        r14.d("message_id", r4.getMessageId());
        r14.d("success_cnt", Boxing.boxInt(r5.element));
        r14.d("total_cnt", Boxing.boxInt(r6.element));
        r14.d("duration", Boxing.boxLong(System.currentTimeMillis() - r7));
        if (r5.element > 0) goto L30;
        r2 = 0;
    L30:
        r14.d("success", Boxing.boxInt(r2));
        r14.d("with_image", Boxing.boxInt(r3));
        this.$event.b();
        return Unit.INSTANCE;
    L14:
        if (r12.getContentType() != 6) goto L16;
        r3 = 1;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        IChatRepoService r15 = RepoDispatcherDelegate.b.e();
        Message r8 = this.$msg;
        this.label = 1;
        r11 = r15.y1(r8, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
