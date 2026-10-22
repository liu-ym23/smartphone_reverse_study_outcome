package com.larus.bmhome.view.actionbar.custom;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.bean.PromptContent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.ActionBarSuggestActionHelper$doDispatch$1", f = "ActionBarSuggestActionHelper.kt", i = {0}, l = {29}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class ActionBarSuggestActionHelper$doDispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ o this$0;

    public ActionBarSuggestActionHelper$doDispatch$1(o r1, Continuation<? super ActionBarSuggestActionHelper$doDispatch$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ActionBarSuggestActionHelper$doDispatch$1 r0 = new ActionBarSuggestActionHelper$doDispatch$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        PromptContent.SuggestV2ExtraForMultiAction r2 = (PromptContent.SuggestV2ExtraForMultiAction) this.L$1;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L39:
        if (r2 != null) goto L42;
    L40:
        o r9 = this.this$0;
        new eq8.a().c("decode bizString error", "bizString:" + r9.b, null);
    L42:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        o r4 = this.this$0;
        r4.getClass();
        Gson r5 = new Gson();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L21
        String r7 = r4.b;     // Catch: Throwable -> L21
        if (r7 != null) goto L12;
    L18:
        wa8.x1 r11 = null;
    L19:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r12) == false) goto L26;
        r12 = null;
    L26:
        wa8.x1 r13 = (wa8.x1) r12;
        if (r13 == null) goto L33;
        wa8.w1 r14 = r13.a;
        if (r14 == null) goto L33;
        PromptContent.SuggestV2ExtraForMultiAction r15 = (PromptContent.SuggestV2ExtraForMultiAction) GsonProtectorUtils.fromJson(r5, r14.b, PromptContent.SuggestV2ExtraForMultiAction.class);
        if (r15 == null) goto L33;
        r15.setBotId(r14.a);
    L34:
        if (r15 == null) goto L40;
        o r16 = this.this$0;
        MainCoroutineDispatcher r17 = Dispatchers.getMain();
        ActionBarSuggestActionHelper$doDispatch$1$1$1 r18 = new ActionBarSuggestActionHelper$doDispatch$1$1$1(r16, r15, null);
        this.L$0 = r10;
        this.L$1 = r15;
        this.label = 1;
        if (BuildersKt.withContext(r17, r18, this) != r0) goto L38;
        return r0;
    L38:
        r2 = r15;
    L33:
        r15 = null;
        goto L34
    L12:
        if ((!StringsKt.isBlank(r7)) == true) goto L15;
        r7 = null;
    L15:
        if (r7 == null) goto L18;
        r11 = (wa8.x1) xt7.d.b.c(kuc.a.d(wa8.x1.Companion.serializer()), r7);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }
}
