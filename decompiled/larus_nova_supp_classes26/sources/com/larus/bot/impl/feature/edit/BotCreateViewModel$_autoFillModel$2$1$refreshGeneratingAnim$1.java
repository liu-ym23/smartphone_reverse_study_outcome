package com.larus.bot.impl.feature.edit;

import com.larus.bot.impl.bean.ContentType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotCreateViewModel$_autoFillModel$2$1$refreshGeneratingAnim$1", f = "BotCreateViewModel.kt", i = {0, 1}, l = {268, 269, 270}, m = "invokeSuspend", n = {"generatingInfo", "generatingInfo"}, s = {"L$0", "L$0"})
public final class BotCreateViewModel$_autoFillModel$2$1$refreshGeneratingAnim$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ BotCreateViewModel this$0;

    public BotCreateViewModel$_autoFillModel$2$1$refreshGeneratingAnim$1(BotCreateViewModel r1, Continuation<? super BotCreateViewModel$_autoFillModel$2$1$refreshGeneratingAnim$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotCreateViewModel$_autoFillModel$2$1$refreshGeneratingAnim$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r9);
    L22:
        BotCreateViewModel.access$checkCreateParam(this.this$0);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        wu8.b r2 = (wu8.b) this.L$0;
        ResultKt.throwOnFailure(r9);
    L19:
        MutableSharedFlow<e0> r10 = this.this$0.getUiEvent();
        e0.a r3 = new e0.a(r2.g, ContentType.VOICE_ID);
        this.L$0 = null;
        this.label = 3;
        if (r10.emit(r3, this) != r0) goto L22;
        return r0;
    L11:
        r2 = (wu8.b) this.L$0;
        ResultKt.throwOnFailure(r9);
    L16:
        MutableSharedFlow<e0> r11 = this.this$0.getUiEvent();
        e0.a r4 = new e0.a(r2.c, ContentType.DESC);
        this.L$0 = r2;
        this.label = 2;
        if (r11.emit(r4, this) != r0) goto L19;
        return r0;
    L12:
        ResultKt.throwOnFailure(r9);
        wu8.b r12 = BotCreateViewModel.access$get_autoFillModel(this.this$0).s();
        this.this$0.refreshAvatarLoading(r12.a);
        BotCreateViewModel.access$get_firstMetModel(this.this$0).kl(r12.e);
        BotCreateViewModel.access$get_firstMetModel(this.this$0).vn(r12.f);
        BotCreateViewModel.access$get_bioModel(this.this$0).Sf(r12.h);
        MutableSharedFlow<e0> r5 = this.this$0.getUiEvent();
        e0.a r6 = new e0.a(r12.b, ContentType.NAME);
        this.L$0 = r12;
        this.label = 1;
        if (r5.emit(r6, this) != r0) goto L15;
        return r0;
    L15:
        r2 = r12;
        goto L16
    }
}
