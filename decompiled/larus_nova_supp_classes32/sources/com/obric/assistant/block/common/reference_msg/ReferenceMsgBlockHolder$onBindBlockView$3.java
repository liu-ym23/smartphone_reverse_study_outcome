package com.obric.assistant.block.common.reference_msg;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.block.common.reference_msg.view.ObricChatReplyHeaderView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.block.common.reference_msg.ReferenceMsgBlockHolder$onBindBlockView$3", f = "ReferenceMsgBlockHolder.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
final class ReferenceMsgBlockHolder$onBindBlockView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $blockModel;
    final /* synthetic */ boolean $hasClickIntent;
    final /* synthetic */ q0 $msgAdapter;
    final /* synthetic */ String $refMsgId;
    final /* synthetic */ ObricChatReplyHeaderView $replyHeaderView;
    private /* synthetic */ Object L$0;
    int label;

    public ReferenceMsgBlockHolder$onBindBlockView$3(String r1, ObricChatReplyHeaderView r2, q0 r3, a r4, boolean r5, Continuation<? super ReferenceMsgBlockHolder$onBindBlockView$3> r6) {
        this.$refMsgId = r1;
        this.$replyHeaderView = r2;
        this.$msgAdapter = r3;
        this.$blockModel = r4;
        this.$hasClickIntent = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        ReferenceMsgBlockHolder$onBindBlockView$3 r7 = new ReferenceMsgBlockHolder$onBindBlockView$3(this.$refMsgId, this.$replyHeaderView, this.$msgAdapter, this.$blockModel, this.$hasClickIntent, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
    L13:
        Object r11 = Result.constructor-impl((Message) r10);     // Catch: Throwable -> L15
    L17:
        String r3 = this.$refMsgId;
        Throwable r4 = Result.exceptionOrNull-impl(r11);
        if (r4 == null) goto L20;
        FLogger.a.w("ReferenceMsgBlockHolder", "load ref msg failed, refMsgId: " + r3 + ", " + r4.getMessage(), r4);
    L20:
        ObricChatReplyHeaderView r5 = this.$replyHeaderView;
        q0 r6 = this.$msgAdapter;
        a r7 = this.$blockModel;
        boolean r8 = this.$hasClickIntent;
        if (Result.isSuccess-impl(r11) == false) goto L36;
        Message r12 = (Message) r11;
        FLogger.a.i("ReferenceMsgBlockHolder", "query msg result: " + r12);
        if (r12 != null) goto L25;
    L29:
        String r13 = r5.getContext().getString(2131908670);
        Intrinsics.checkNotNull(r13);
    L31:
        if (r6.I7() != null) goto L34;
        r2 = false;
    L34:
        r5.a(r13, Boxing.boxBoolean(r2), com.larus.bmhome.chat.bean.d.G0(r7.j()), r8);
        goto L36
    L25:
        if (com.larus.bmhome.chat.bean.d.U(r12) == false) goto L29;
        r13 = com.larus.bmhome.chat.bean.d.H(r12);
        if (r13 != null) goto L31;
        r13 = NameKeys.UnloadStrategy_No_Strategy;
    L36:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        String r15 = this.$refMsgId;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L15
        IChatRepoService r16 = zh8.a.a;     // Catch: Throwable -> L15
        IChatRepoService r17 = zh8.a.a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r10 = r17.E1(r15, this);     // Catch: Throwable -> L15
        if (r10 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
