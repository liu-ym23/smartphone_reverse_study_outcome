package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bot.impl.bean.BotGenBgImageDescPromptResponse;
import com.larus.bot.impl.bean.GenBotImageRequest;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.network.http.AsyncThrowable;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.BgPromptGenerateViewModel$generatePrompt$1", f = "BgPromptGenerateViewModel.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
public final class BgPromptGenerateViewModel$generatePrompt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageUploadResult $result;
    int label;
    final /* synthetic */ BgPromptGenerateViewModel this$0;

    public BgPromptGenerateViewModel$generatePrompt$1(BgPromptGenerateViewModel r1, ImageUploadResult r2, Continuation<? super BgPromptGenerateViewModel$generatePrompt$1> r3) {
        this.this$0 = r1;
        this.$result = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BgPromptGenerateViewModel$generatePrompt$1(this.this$0, this.$result, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r21);
        Object r3 = r21;
    L23:
        com.larus.network.http.f r4 = (com.larus.network.http.a) r3;
        BotGenBgImageDescPromptResponse r5 = (BotGenBgImageDescPromptResponse) ((com.larus.network.http.a) r4).b;
        if (r5 == null) goto L26;
        String r6 = r5.getBgImgPrompt();
    L28:
        if (r6 != null) goto L30;
    L33:
        boolean r7 = true;
    L34:
        String r8 = "";
        if (r7 == false) goto L67;
        boolean r9 = r4 instanceof com.larus.network.http.f;
        if (r9 == false) goto L39;
        int r10 = lm9.e.a;
        String r11 = lm9.e.a(r4.d, "");
    L41:
        if (StringsKt.isBlank(r11) == false) goto L47;
        BgPromptGenerateViewModel r12 = this.this$0;
        if (((f) r12.f.getValue()).c != 2) goto L45;
        int r13 = 2131901034;
    L46:
        r12.i(new e.c(new TextRes.StringResId(r13)));
    L48:
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("generateBgImageDescPrompt error, msg: ");
        if (r9 == false) goto L51;
        com.larus.network.http.f r16 = r4;
    L52:
        if (r16 == null) goto L56;
        AsyncThrowable r17 = r16.d;
        if (r17 == null) goto L56;
        String r18 = r17.getMessage();
    L57:
        r15.append(r18);
        r14.e("BgPromptGenerateViewModel", r15.toString());
        uc9.b r19 = this.this$0.d();
        BgPromptGenerateViewModel r20 = this.this$0;
        r19.a = r20.j;
        uc9.b r22 = r20.d();
        r22.b = this.this$0.k;
        if (r9 == false) goto L60;
        com.larus.network.http.f r23 = r4;
    L61:
        if (r23 == null) goto L65;
        AsyncThrowable r24 = r23.d;
        if (r24 == null) goto L65;
        long r25 = r24.getCode();
    L66:
        qu8.b.d("gen_prompt", r25);
    L81:
        BgPromptGenerateViewModel r26 = this.this$0;
        TextRes.StringResId r27 = new TextRes.StringResId(2131901612);
        int r28 = BgPromptGenerateViewModel.q;
        r26.h(r27, false, 0);
        BgPromptGenerateViewModel r29 = this.this$0;
        String r30 = r29.d().a;
        if (r30 == null) goto L85;
        r8 = r30;
    L85:
        r29.i(new e.a(r8));
        this.this$0.l = false;
        return Unit.INSTANCE;
    L65:
        r25 = -2;
        goto L66
    L60:
        r23 = null;
    L56:
        r18 = null;
        goto L57
    L51:
        r16 = null;
        goto L52
    L45:
        r13 = 2131911070;
        goto L46
    L47:
        BgPromptGenerateViewModel r31 = this.this$0;
        e.c r32 = new e.c(new TextRes.PlainText(r11));
        int r33 = BgPromptGenerateViewModel.q;
        r31.i(r32);
        goto L48
    L39:
        r11 = "";
        goto L41
    L67:
        this.this$0.d().a = r6;
        uc9.b r34 = this.this$0.d();
        BotGenBgImageDescPromptResponse r35 = (BotGenBgImageDescPromptResponse) ((com.larus.network.http.a) r4).b;
        if (r35 == null) goto L70;
        String r36 = r35.getBgImgPromptEn();
    L71:
        r34.b = r36;
        this.this$0.o = true;
        if ((r4 instanceof com.larus.network.http.f) == false) goto L74;
        com.larus.network.http.f r37 = r4;
    L75:
        if (r37 == null) goto L79;
        AsyncThrowable r38 = r37.d;
        if (r38 == null) goto L79;
        long r39 = r38.getCode();
    L80:
        qu8.b.d("gen_prompt", r39);
    L79:
        r39 = 0;
        goto L80
    L74:
        r37 = null;
        goto L75
    L70:
        r36 = null;
        goto L71
    L30:
        if (StringsKt.isBlank(r6) == true) goto L33;
        r7 = false;
        goto L34
    L26:
        r6 = null;
        goto L28
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        BgPromptGenerateViewModel r40 = this.this$0;
        AIGenBgImageRepository r41 = r40.b;
        String r42 = r40.j;
        String r43 = r40.a();
        String r44 = this.this$0.f();
        ImageUploadResult r45 = this.$result;
        if (r45 == null) goto L11;
        String r110 = r45.getUploadUri();
    L12:
        ImageUploadResult r46 = this.$result;
        if (r46 == null) goto L15;
        String r111 = r46.getReferenceBgImgStyle();
    L16:
        ImageUploadResult r47 = this.$result;
        if (r47 == null) goto L19;
        String r112 = r47.getReferenceBgImgPrompt();
    L20:
        GenBotImageRequest r113 = new GenBotImageRequest(r43, r44, null, r110, r111, r112, null, this.this$0.e(), this.this$0.c(), null, 580, null);
        String r48 = this.this$0.p.c();
        this.label = 1;
        r3 = r41.c(r42, r113, r48, this);
        if (r3 != r1) goto L23;
        return r1;
    L19:
        r112 = null;
        goto L20
    L15:
        r111 = null;
        goto L16
    L11:
        r110 = null;
        goto L12
    }
}
