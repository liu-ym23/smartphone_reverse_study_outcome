package com.larus.bmhome.instruction;

import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import java.util.List;
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
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$performConversationChangeAfterCachePreload$1", f = "InstructionInputComponent.kt", i = {}, l = {1107, 1113}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$performConversationChangeAfterCachePreload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ Deferred<List<com.larus.bmhome.actionbar.model.z0>> $cacheLoad;
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public InstructionInputComponent$performConversationChangeAfterCachePreload$1(Deferred<? extends List<com.larus.bmhome.actionbar.model.z0>> r1, InstructionInputComponent r2, BotModel r3, Continuation<? super InstructionInputComponent$performConversationChangeAfterCachePreload$1> r4) {
        this.$cacheLoad = r1;
        this.this$0 = r2;
        this.$bot = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new InstructionInputComponent$performConversationChangeAfterCachePreload$1(this.$cacheLoad, this.this$0, this.$bot, r5);
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
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L35:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        List r8 = (List) r7;
        FLogger r2 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[ActionBarEarlyRender] actionbar cache preload finished, size=");
        if (r8 == null) goto L16;
        Integer r5 = Boxing.boxInt(r8.size());
    L17:
        r4.append(r5);
        r4.append(", initialPerformed=");
        r4.append(this.this$0.E2);
        r2.i("InstructionInputComponent", r4.toString());
        List r9 = r8;
        if (r9 != null) goto L20;
    L23:
        if (r3 == true) goto L37;
        InstructionInputComponent r10 = this.this$0;
        if (r10.E2 == true) goto L37;
        com.larus.bmhome.chat.component.cvs.y r11 = r10.u0();
        if (r11 == null) goto L35;
        wc9.e r12 = r11.h();
        if (r12 == null) goto L35;
        InstructionInputComponent r6 = this.this$0;
        BotModel r13 = this.$bot;
        this.label = 2;
        if (InstructionInputComponent.h3(r6, r12, r13, this) != r0) goto L35;
        return r0;
    L37:
        return Unit.INSTANCE;
    L20:
        if (r9.isEmpty() == true) goto L23;
        r3 = false;
        goto L23
    L16:
        r5 = null;
        goto L17
    L10:
        ResultKt.throwOnFailure(r7);
        Deferred<List<com.larus.bmhome.actionbar.model.z0>> r14 = this.$cacheLoad;
        this.label = 1;
        r7 = r14.await(this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
