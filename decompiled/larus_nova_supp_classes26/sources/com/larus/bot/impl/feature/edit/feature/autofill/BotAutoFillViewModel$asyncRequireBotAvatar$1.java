package com.larus.bot.impl.feature.edit.feature.autofill;

import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.settings.value.e10;
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
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillViewModel$asyncRequireBotAvatar$1", f = "BotAutoFillViewModel.kt", i = {}, l = {1053, 1066}, m = "invokeSuspend", n = {}, s = {})
final class BotAutoFillViewModel$asyncRequireBotAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotAutoFillViewModel this$0;

    public BotAutoFillViewModel$asyncRequireBotAvatar$1(BotAutoFillViewModel r1, Continuation<? super BotAutoFillViewModel$asyncRequireBotAvatar$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotAutoFillViewModel$asyncRequireBotAvatar$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L33:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r13);
        BotAutoFillViewModel r14 = this.this$0;
        int r2 = BotAutoFillViewModel.x;
        String r3 = null;
        if (r14.H() == false) goto L13;
        String r5 = null;
    L14:
        BotLanguage r15 = this.this$0.a().getLanguage();
        if (r15 == null) goto L17;
        String r16 = r15.c();
    L18:
        if (r16 != null) goto L20;
        r16 = "";
    L20:
        String r6 = r16;
        if (this.this$0.G() == true) goto L24;
        r3 = this.this$0.a().getDescription();
    L24:
        String r7 = r3;
        if (this.this$0.l() == false) goto L29;
        qu8.b.e("bot_create/autofill/bg", "bot_create_auto_fill", false);
        BotAutoFillViewModel r4 = this.this$0;
        String r17 = r4.a().getUserBotGenderStarlingKey();
        String r8 = this.this$0.a().getUserBotTypeStarlingKey();
        e10 r9 = e10.a;
        int r10 = e10.F();
        this.label = 1;
        if (BotAutoFillViewModel.u(r4, r5, r7, r17, r8, 0, r10, this) != r0) goto L33;
        return r0;
    L29:
        qu8.b.e("gen_icon", "bot_create_auto_fill", false);
        BotAutoFillViewModel r11 = this.this$0;
        e10 r18 = e10.a;
        int r12 = e10.F();
        this.label = 2;
        if (BotAutoFillViewModel.t(r11, r5, r6, r7, 0, r12, this) != r0) goto L33;
        return r0;
    L17:
        r16 = null;
        goto L18
    L13:
        r5 = this.this$0.a().getName();
        goto L14
    }
}
