package com.larus.bot.impl.feature.edit.feature.autofill;

import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillViewModel$generateIcon$2", f = "BotAutoFillViewModel.kt", i = {}, l = {1075, 1087, 1117}, m = "invokeSuspend", n = {}, s = {})
final class BotAutoFillViewModel$generateIcon$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botDesc;
    final /* synthetic */ String $botLang;
    final /* synthetic */ String $botName;
    final /* synthetic */ int $curRetryCount;
    final /* synthetic */ int $maxRetryCount;
    int label;
    final /* synthetic */ BotAutoFillViewModel this$0;

    public BotAutoFillViewModel$generateIcon$2(String r1, String r2, int r3, int r4, BotAutoFillViewModel r5, String r6, Continuation<? super BotAutoFillViewModel$generateIcon$2> r7) {
        this.$botName = r1;
        this.$botLang = r2;
        this.$curRetryCount = r3;
        this.$maxRetryCount = r4;
        this.this$0 = r5;
        this.$botDesc = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new BotAutoFillViewModel$generateIcon$2(this.$botName, this.$botLang, this.$curRetryCount, this.$maxRetryCount, this.this$0, this.$botDesc, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ResultKt.throwOnFailure(r16);
    L73:
        this.this$0.g.a = false;
        this.this$0.b();
        this.this$0.I();
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r16);
    L36:
        qu8.b.d("gen_icon", 0);
        if (this.this$0.g.b() == true) goto L73;
        qu8.b.d("bot_create_auto_fill", 0);
        goto L73
    L11:
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L15:
        y r2 = (com.larus.network.http.a) r1;
        if (this.this$0.g.a == false) goto L18;
        long r12 = 30021;
        com.larus.network.http.f r14 = null;
        if ((r2 instanceof y) == false) goto L42;
        y r3 = r2;
        BotAvatarIconData r4 = (BotAvatarIconData) ((com.larus.network.http.a) r3).b;
        if (r4 == null) goto L24;
        String r5 = r4.getIconUri();
    L26:
        if (o0.d(r5) == false) goto L39;
        BotAvatarIconData r6 = (BotAvatarIconData) ((com.larus.network.http.a) r3).b;
        if (r6 == null) goto L30;
        String r7 = r6.getIconUrl();
    L32:
        if (o0.d(r7) == false) goto L39;
        BotAutoFillViewModel r9 = this.this$0;
        wu8.d r10 = new wu8.d((BotAvatarIconData) ((com.larus.network.http.a) r3).b, null);
        this.label = 2;
        if (r9.C(r10, this) != r8) goto L36;
        return r8;
    L30:
        r7 = null;
    L39:
        this.this$0.B(null);
        qu8.b.d("gen_icon", 30021);
        if (this.this$0.g.b() == true) goto L73;
        qu8.b.d("bot_create_auto_fill", 3002);
        goto L73
    L24:
        r5 = null;
        goto L26
    L42:
        int r11 = this.$curRetryCount;
        int r13 = this.$maxRetryCount;
        if (r11 >= r13) goto L47;
        this.label = 3;
        if (BotAutoFillViewModel.t(this.this$0, this.$botName, this.$botLang, this.$botDesc, 1 + r11, r13, this) != r8) goto L73;
        return r8;
    L47:
        FLogger r15 = FLogger.a;
        StringBuilder r17 = new StringBuilder("generateIcon failed, errCode: ");
        boolean r18 = r2 instanceof com.larus.network.http.f;
        if (r18 == false) goto L50;
        com.larus.network.http.f r19 = (com.larus.network.http.f) r2;
    L51:
        if (r19 == null) goto L55;
        AsyncThrowable r20 = r19.d;
        if (r20 == null) goto L55;
        Long r21 = Boxing.boxLong(r20.getCode());
    L56:
        r17.append(r21);
        r15.e("BotAutoFillViewModel", r17.toString());
        BotAutoFillViewModel r22 = this.this$0;
        if (r18 == false) goto L59;
        com.larus.network.http.f r23 = (com.larus.network.http.f) r2;
    L60:
        if (r23 == null) goto L62;
        AsyncThrowable r24 = r23.d;
    L63:
        r22.B(r24);
        if (r18 == false) goto L66;
        r14 = (com.larus.network.http.f) r2;
    L66:
        if (r14 == null) goto L70;
        AsyncThrowable r25 = r14.d;
        if (r25 == null) goto L70;
        r12 = r25.getCode();
    L70:
        qu8.b.d("gen_icon", r12);
        if (this.this$0.g.b() == true) goto L73;
        qu8.b.d("bot_create_auto_fill", 3002);
        goto L73
    L62:
        r24 = null;
        goto L63
    L59:
        r23 = null;
    L55:
        r21 = null;
        goto L56
    L50:
        r19 = null;
        goto L51
    L18:
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r16);
        FLogger.a.i("BotAutoFillViewModel", "requireBotAvatar botName=" + this.$botName + ", botLang=" + this.$botLang + ", curRetryCount=" + this.$curRetryCount + ", maxRetryCount=" + this.$maxRetryCount);
        UgcBotRepo r26 = this.this$0.n;
        UgcBotRepo.c r27 = new UgcBotRepo.c(this.$botName, this.$botLang, this.$botDesc);
        this.label = 1;
        r26.getClass();
        r1 = UgcBotRepo.j(r27, this);
        if (r1 != r8) goto L15;
        return r8;
    }
}
