package com.larus.bmhome.instruction.suggest;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tx9.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.suggest.PromptSelectActionDispatcher$handleUgcBotCall$1", f = "PromptSelectActionDispatcher.kt", i = {0, 0, 1, 1}, l = {416, 426}, m = "invokeSuspend", n = {"$this$launch", "botId", "botId", "id"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class PromptSelectActionDispatcher$handleUgcBotCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ c this$0;

    public PromptSelectActionDispatcher$handleUgcBotCall$1(c r1, Continuation<? super PromptSelectActionDispatcher$handleUgcBotCall$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        PromptSelectActionDispatcher$handleUgcBotCall$1 r0 = new PromptSelectActionDispatcher$handleUgcBotCall$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r39) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        c r1 = (c) this.L$3;
        CoroutineScope r2 = (CoroutineScope) this.L$2;
        String r3 = (String) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r39);
        String r34 = r4;
        int r15 = 2;
        String r5 = r3;
        c r6 = r1;
        Object r7 = r39;
    L39:
        wc9.e r8 = (wc9.e) r7;
        if (r8 == null) goto L52;
        Map r9 = r8.x;
        if (r9 == null) goto L45;
        Map r10 = MapsKt.toMutableMap(r9);
        if (r10 == null) goto L45;
    L46:
        r10.put("is_from_local_discovery", TriggerSendLoading.NO_LOADING);
        RepoDispatcherDelegate.b.f().c(r8, r10);
        Integer r11 = r8.v;
        if (r11 == null) goto L52;
        if (r11.intValue() != r15) goto L52;
        e1.a(r34, null, null, null, r6.c, null, null, null, r6.d, "", null, null, null, null, r34, null, null, 7327677);
    L45:
        r10 = new HashMap();
    L52:
        if (r8 == null) goto L54;
        String r16 = r8.a;
    L55:
        c.a(r6, r16);
        FLogger.a.i("PromptSelectActionDispatcher", "handleUgcBotCall: jumpCallByConversationId, create CvsId:" + r5);
    L57:
        return Unit.INSTANCE;
    L54:
        r16 = null;
        goto L55
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r12 = (String) this.L$1;
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r39);
        Object r17 = r39;
    L10:
        String r18 = r12;
        wc9.e r19 = (wc9.e) r17;
        if (r19 == null) goto L32;
        Integer r20 = r19.t;
        if (r20 == null) goto L32;
        if (r20.intValue() != 1) goto L32;
        String r21 = r19.a;
    L33:
        if (r21 == null) goto L35;
        c.a(this.this$0, r21);
        FLogger.a.i("PromptSelectActionDispatcher", "handleUgcBotCall: jumpCallByConversationId, findCvsId:".concat(r21));
        goto L57
    L35:
        c r22 = this.this$0;
        this.L$0 = r18;
        this.L$1 = r21;
        this.L$2 = r14;
        this.L$3 = r22;
        this.label = 2;
        r22.getClass();
        String r110 = r21;
        r15 = 2;
        r7 = IConversationRepoService.a.a(RepoDispatcherDelegate.b.f(), r18, 2, null, null, false, null, null, null, null, this, 508);
        if (r7 != r13) goto L38;
        return r13;
    L38:
        r5 = r110;
        r34 = r18;
        r6 = r22;
    L32:
        r21 = null;
        goto L33
    L11:
        ResultKt.throwOnFailure(r39);
        r14 = (CoroutineScope) this.L$0;
        r12 = this.this$0.b.getBotId();
        if (r12 != null) goto L14;
    L17:
        boolean r23 = true;
    L18:
        if (r23 == false) goto L21;
        FLogger.a.i("PromptSelectActionDispatcher", "handleUgcBotCall: botId is null");
        eq8.a r24 = this.this$0.e;
        int r25 = eq8.a.d;
        r24.c("handleUgcBotCall error", "bot_id is null", null);
        return Unit.INSTANCE;
    L21:
        c r26 = this.this$0;
        this.L$0 = r14;
        this.L$1 = r12;
        this.label = 1;
        r26.getClass();
        r17 = RepoDispatcherDelegate.b.f().a(r12, this);
        if (r17 != r13) goto L10;
        return r13;
    L14:
        if (r12.length() == 0) goto L17;
        r23 = false;
        goto L18
    }
}
