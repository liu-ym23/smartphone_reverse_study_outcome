package com.larus.bmhome.instruction;

import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$startPreloadBot$1", f = "InstructionInputComponent.kt", i = {}, l = {1005}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$startPreloadBot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $mainBotId;
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public InstructionInputComponent$startPreloadBot$1(String r1, InstructionInputComponent r2, Continuation<? super InstructionInputComponent$startPreloadBot$1> r3) {
        this.$mainBotId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InstructionInputComponent$startPreloadBot$1(this.$mainBotId, this.this$0, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        BotModel r12 = (BotModel) r11;
        if (this.this$0.D == false) goto L14;
        this.this$0.C = r12;
        this.this$0.D = false;
        FLogger.a.i("InstructionInputComponent", "[ActionBarEarlyRender] bot preload by findBot success");
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        RepoDispatcher.a.getClass();
        BotRepo r3 = RepoDispatcher.g;
        String r4 = this.$mainBotId;
        this.label = 1;
        r11 = IBotRepoService.b.a(r3, r4, false, null, false, this, 30);
        if (r11 != r0) goto L11;
        return r0;
    }
}
