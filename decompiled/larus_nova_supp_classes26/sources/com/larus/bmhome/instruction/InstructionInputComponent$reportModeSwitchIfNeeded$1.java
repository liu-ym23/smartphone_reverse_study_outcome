package com.larus.bmhome.instruction;

import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$reportModeSwitchIfNeeded$1", f = "InstructionInputComponent.kt", i = {}, l = {2936}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$reportModeSwitchIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ com.larus.bmhome.actionbar.model.b2 $fromModeItem;
    final /* synthetic */ com.larus.bmhome.actionbar.model.b2 $toModeItem;
    private /* synthetic */ Object L$0;
    int label;

    public InstructionInputComponent$reportModeSwitchIfNeeded$1(String r1, com.larus.bmhome.actionbar.model.b2 r2, com.larus.bmhome.actionbar.model.b2 r3, Continuation<? super InstructionInputComponent$reportModeSwitchIfNeeded$1> r4) {
        this.$conversationId = r1;
        this.$fromModeItem = r2;
        this.$toModeItem = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        InstructionInputComponent$reportModeSwitchIfNeeded$1 r0 = new InstructionInputComponent$reportModeSwitchIfNeeded$1(this.$conversationId, this.$fromModeItem, this.$toModeItem, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
    L13:
        Object r8 = Result.constructor-impl((com.larus.network.http.a) r7);     // Catch: Throwable -> L15
    L17:
        String r2 = this.$conversationId;
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L21;
        FLogger.a.w("InstructionInputComponent", "[reportModeSwitchIfNeeded] failed, conversationId=" + r2, r9);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        String r11 = this.$conversationId;
        com.larus.bmhome.actionbar.model.b2 r3 = this.$fromModeItem;
        com.larus.bmhome.actionbar.model.b2 r4 = this.$toModeItem;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        RepoDispatcher.a.getClass();     // Catch: Throwable -> L15
        BotRepo r6 = RepoDispatcher.g;     // Catch: Throwable -> L15
        IBotRepoService.c r12 = new IBotRepoService.c(r11, r3, r4);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r6.getClass();     // Catch: Throwable -> L15
        BotRepo.a().getClass();     // Catch: Throwable -> L15
        r7 = BotApi.a(r12, this);     // Catch: Throwable -> L15
        if (r7 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
