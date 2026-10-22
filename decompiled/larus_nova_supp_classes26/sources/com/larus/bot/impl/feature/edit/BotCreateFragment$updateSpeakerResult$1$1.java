package com.larus.bot.impl.feature.edit;

import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.spi.IAIChatService;
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
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotCreateFragment$updateSpeakerResult$1$1", f = "BotCreateFragment.kt", i = {0}, l = {575}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u241"}, s = {"L$4"})
final class BotCreateFragment$updateSpeakerResult$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fromVoiceId;
    final /* synthetic */ w2a.f $it;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ BotCreateFragment this$0;

    public BotCreateFragment$updateSpeakerResult$1$1(BotCreateFragment r1, w2a.f r2, String r3, Continuation<? super BotCreateFragment$updateSpeakerResult$1$1> r4) {
        this.this$0 = r1;
        this.$it = r2;
        this.$fromVoiceId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotCreateFragment$updateSpeakerResult$1$1(this.this$0, this.$it, this.$fromVoiceId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ItemTextArrow r2 = (ItemTextArrow) this.L$4;
        String r3 = (String) this.L$3;
        w2a.f r4 = (w2a.f) this.L$2;
        BotCreateFragment r5 = (BotCreateFragment) this.L$1;
        ItemTextArrow r6 = (ItemTextArrow) this.L$0;
        ResultKt.throwOnFailure(r12);
    L19:
        SpeakerVoice r7 = (SpeakerVoice) r12;
        ItemTextArrow r13 = r2;
    L20:
        BotCreateFragment r8 = r5;
        w2a.f r9 = r4;
        SpeakerVoice r10 = r7;
        String r11 = r3;
        if (r10 != null) goto L23;
    L25:
        v2a.b r14 = IAIChatService.a.f7();
        r8.getClass();
        r14.a(r9, "bot_create_page", r11, "create", r10, r9.h);
        p2a.r r15 = p2a.r.b;
        ouc.e0 r16 = new ouc.e0();
        ouc.j.c(r16, "is_scheme", "False");
        ouc.j.c(r16, "enter_method", "bot_create_page");
        if (r10 == null) goto L28;
        ouc.j.c(r16, "result", "Success");
    L29:
        r15.T0(r16.a());
        r13.V5();
        r8.ca0();
    L31:
        return Unit.INSTANCE;
    L28:
        ouc.j.c(r16, "result", "Fail");
        ouc.j.c(r16, "reason", "ConfCreateFailed");
        goto L29
    L23:
        if (r8.B == true) goto L25;
        r8.u = r10;
        r8.V90().updateVoice(r10, true);
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        r5 = this.this$0;
        r13 = r5.y;
        if (r13 == null) goto L31;
        r4 = this.$it;
        r3 = this.$fromVoiceId;
        r13.Y5();
        r13.c6();
        p2a.f r17 = (p2a.f) r5.I.getValue();
        r7 = null;
        if (r17 == null) goto L20;
        BotLanguage r18 = r5.s;
        if (r18 == null) goto L15;
        r7 = r18.c();
    L15:
        this.L$0 = r13;
        this.L$1 = r5;
        this.L$2 = r4;
        this.L$3 = r3;
        this.L$4 = r13;
        this.label = 1;
        Object r19 = r17.F1(r4, r7, this);
        if (r19 != r0) goto L18;
        return r0;
    L18:
        r2 = r13;
        r12 = r19;
        goto L19
    }
}
