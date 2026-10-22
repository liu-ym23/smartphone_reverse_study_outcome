package com.larus.bot.impl.feature.edit.feature.autofill;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.common.apphost.AppHost;
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
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillViewModel$onClickAutoFillBtn$1", f = "BotAutoFillViewModel.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
final class BotAutoFillViewModel$onClickAutoFillBtn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotAutoFillViewModel this$0;

    public BotAutoFillViewModel$onClickAutoFillBtn$1(BotAutoFillViewModel r1, Continuation<? super BotAutoFillViewModel$onClickAutoFillBtn$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotAutoFillViewModel$onClickAutoFillBtn$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L15:
        this.this$0.g();
        BotAutoFillViewModel r6 = this.this$0;
        if (r6.k == true) goto L19;
        r6.k = true;
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        this.this$0.q.set(false);
        qu8.b.e("bot_create_auto_fill", "bot_create", false);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L12;
        this.this$0.L(new b.C0054b(new TextRes.StringResId(2131906741)));
        FLogger.a.w("BotAutoFillViewModel", "internet connect failed");
        qu8.b.d("bot_create_auto_fill", 3003);
        return Unit.INSTANCE;
    L12:
        BotAutoFillViewModel r7 = this.this$0;
        this.label = 1;
        if (BotAutoFillViewModel.w(r7, this) != r0) goto L15;
        return r0;
    }
}
