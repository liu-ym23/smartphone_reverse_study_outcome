package com.larus.bot.impl.feature.botmaker;

import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bot.impl.bean.BotEnrichRespData;
import com.larus.bot.impl.feature.edit.feature.autofill.model.BotEnrichParam;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.network.http.y;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.botmaker.BotMakerModel$generateVoice$job$1", f = "BotMakerModel.kt", i = {}, l = {GuidePriority.VLM_REALTIME_CALL_PRIORITY}, m = "invokeSuspend", n = {}, s = {})
final class BotMakerModel$generateVoice$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $language;
    final /* synthetic */ String $msgId;
    final /* synthetic */ String $name;
    final /* synthetic */ Ref.ObjectRef<String> $voiceId;
    int label;

    public BotMakerModel$generateVoice$job$1(String r1, String r2, Ref.ObjectRef<String> r3, String r4, Continuation<? super BotMakerModel$generateVoice$job$1> r5) {
        this.$name = r1;
        this.$language = r2;
        this.$voiceId = r3;
        this.$msgId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BotMakerModel$generateVoice$job$1(this.$name, this.$language, this.$voiceId, this.$msgId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        y r15 = (com.larus.network.http.a) r14;
        if ((r15 instanceof y) == false) goto L21;
        Ref.ObjectRef<String> r2 = this.$voiceId;
        BotEnrichRespData r16 = (BotEnrichRespData) ((com.larus.network.http.a) r15).b;
        if (r16 == null) goto L16;
        String r17 = r16.getVoiceId();
    L17:
        r2.element = r17;
        if (o0.d((String) this.$voiceId.element) == false) goto L21;
        k.k.put(this.$msgId, (String) this.$voiceId.element);
        goto L21
    L16:
        r17 = null;
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        UgcBotRepo r18 = k.c;
        BotEnrichParam r3 = new BotEnrichParam(this.$name, this.$language, Boxing.boxBoolean(false), Boxing.boxBoolean(true), null, null, null, 112, null);
        this.label = 1;
        r18.getClass();
        r14 = UgcBotRepo.h(r3, this);
        if (r14 != r0) goto L11;
        return r0;
    }
}
