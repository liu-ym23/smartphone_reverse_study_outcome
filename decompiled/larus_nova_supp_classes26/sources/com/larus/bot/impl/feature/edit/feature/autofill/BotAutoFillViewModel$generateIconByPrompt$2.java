package com.larus.bot.impl.feature.edit.feature.autofill;

import com.larus.bot.impl.bean.GenBotImageRequest;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillViewModel$generateIconByPrompt$2", f = "BotAutoFillViewModel.kt", i = {}, l = {1155, 1172, 1174}, m = "invokeSuspend", n = {}, s = {})
final class BotAutoFillViewModel$generateIconByPrompt$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botDesc;
    final /* synthetic */ String $botName;
    final /* synthetic */ int $curRetryCount;
    final /* synthetic */ int $maxRetryCount;
    final /* synthetic */ String $userBotGender;
    final /* synthetic */ String $userBotType;
    int label;
    final /* synthetic */ BotAutoFillViewModel this$0;

    public BotAutoFillViewModel$generateIconByPrompt$2(int r1, int r2, BotAutoFillViewModel r3, String r4, String r5, String r6, String r7, Continuation<? super BotAutoFillViewModel$generateIconByPrompt$2> r8) {
        this.$curRetryCount = r1;
        this.$maxRetryCount = r2;
        this.this$0 = r3;
        this.$botName = r4;
        this.$botDesc = r5;
        this.$userBotGender = r6;
        this.$userBotType = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new BotAutoFillViewModel$generateIconByPrompt$2(this.$curRetryCount, this.$maxRetryCount, this.this$0, this.$botName, this.$botDesc, this.$userBotGender, this.$userBotType, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r30) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r30);
    L68:
        this.this$0.g.a = false;
        this.this$0.b();
        this.this$0.I();
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r30);
        Object r1 = r30;
    L18:
        com.larus.network.http.f r2 = (com.larus.network.http.a) r1;
        if (this.this$0.g.a == true) goto L23;
        return Unit.INSTANCE;
    L23:
        if ((r2 instanceof y) == false) goto L27;
        BotAutoFillViewModel r3 = this.this$0;
        this.label = 2;
        if (BotAutoFillViewModel.v(r3, r2, this) != r9) goto L68;
        return r9;
    L27:
        int r4 = this.$curRetryCount;
        int r6 = this.$maxRetryCount;
        if (r4 >= r6) goto L32;
        this.label = 3;
        if (BotAutoFillViewModel.u(this.this$0, this.$botName, this.$botDesc, this.$userBotGender, this.$userBotType, r4 + 1, r6, this) != r9) goto L68;
        return r9;
    L32:
        FLogger r5 = FLogger.a;
        StringBuilder r7 = new StringBuilder("generateBgImage failed, errCode: ");
        boolean r8 = r2 instanceof com.larus.network.http.f;
        com.larus.network.http.f r10 = null;
        if (r8 == false) goto L35;
        com.larus.network.http.f r11 = r2;
    L36:
        if (r11 == null) goto L40;
        AsyncThrowable r12 = r11.d;
        if (r12 == null) goto L40;
        Long r13 = Boxing.boxLong(r12.getCode());
    L41:
        r7.append(r13);
        r5.e("BotAutoFillViewModel", r7.toString());
        BotAutoFillViewModel r14 = this.this$0;
        if (r8 == false) goto L44;
        com.larus.network.http.f r15 = r2;
    L45:
        if (r15 == null) goto L47;
        AsyncThrowable r16 = r15.d;
    L48:
        r14.B(r16);
        if (r8 == false) goto L51;
        com.larus.network.http.f r17 = r2;
    L52:
        long r18 = 30021;
        if (r17 == null) goto L57;
        AsyncThrowable r19 = r17.d;
        if (r19 == null) goto L57;
        long r20 = r19.getCode();
    L58:
        qu8.b.d("gen_icon_by_prompt", r20);
        if (r8 == false) goto L61;
        r10 = r2;
    L61:
        if (r10 == null) goto L65;
        AsyncThrowable r21 = r10.d;
        if (r21 == null) goto L65;
        r18 = r21.getCode();
    L65:
        qu8.b.d("bot_create/autofill/bg", r18);
        if (this.this$0.g.b() == true) goto L68;
        qu8.b.d("bot_create_auto_fill", 3002);
    L57:
        r20 = 30021;
        goto L58
    L51:
        r17 = null;
        goto L52
    L47:
        r16 = null;
        goto L48
    L44:
        r15 = null;
    L40:
        r13 = null;
        goto L41
    L35:
        r11 = null;
        goto L36
    L12:
        ResultKt.throwOnFailure(r30);
        FLogger.a.i("BotAutoFillViewModel", "generateIconByPrompt, curRetryCount = " + this.$curRetryCount + ", maxRetryCount = " + this.$maxRetryCount);
        if (this.$curRetryCount != 0) goto L15;
        qu8.b.e("gen_icon_by_prompt", "bot_create/autofill/bg", false);
    L15:
        BotAutoFillViewModel r22 = this.this$0;
        int r23 = BotAutoFillViewModel.x;
        AIGenBgImageRepository r24 = (AIGenBgImageRepository) r22.o.getValue();
        GenBotImageRequest r25 = new GenBotImageRequest(this.$botName, this.$botDesc, null, null, null, null, null, this.$userBotGender, this.$userBotType, Boxing.boxBoolean(false), 124, null);
        String r26 = this.this$0.getBotCreateTrace().d();
        this.label = 1;
        r1 = r24.b("", 1, r25, "auto_fill", r26, this);
        if (r1 != r9) goto L18;
        return r9;
    }
}
