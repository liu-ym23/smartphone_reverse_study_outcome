package com.larus.bot.impl.feature.edit.feature.language;

import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/bot/bean/LanguageUpdateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.language.BotLanguageSettingViewModel$updateLanguage$1$1$updateResult$1", f = "BotLanguageSettingViewModel.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
public final class BotLanguageSettingViewModel$updateLanguage$1$1$updateResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ub8.f>, Object> {
    final /* synthetic */ BotModel $it;
    final /* synthetic */ BotLanguage $language;
    int label;
    final /* synthetic */ BotLanguageSettingViewModel this$0;

    public BotLanguageSettingViewModel$updateLanguage$1$1$updateResult$1(BotLanguageSettingViewModel r1, BotModel r2, BotLanguage r3, Continuation<? super BotLanguageSettingViewModel$updateLanguage$1$1$updateResult$1> r4) {
        this.this$0 = r1;
        this.$it = r2;
        this.$language = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotLanguageSettingViewModel$updateLanguage$1$1$updateResult$1(this.this$0, this.$it, this.$language, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ub8.f> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L20:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        UgcBotRepo r8 = BotLanguageSettingViewModel.access$getRepo$p(this.this$0);
        BotModel r2 = this.$it;
        BotLanguage r3 = this.$language;
        this.label = 1;
        r8.getClass();
        kotlinx.coroutines.j r9 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r9.C();
        BotServiceImpl r4 = com.larus.im.d.a();
        String r5 = r2.getBotId();
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r4.modifyBotLanguage(r5, r3.c(), new com.larus.bot.impl.repository.h(r9, r3));
        r7 = r9.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(this);
    L15:
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        r7 = (ub8.f) r7;
    L18:
        if (r7 != r0) goto L20;
        return r0;
    }
}
