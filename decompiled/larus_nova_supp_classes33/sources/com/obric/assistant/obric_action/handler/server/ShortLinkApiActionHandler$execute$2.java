package com.obric.assistant.obric_action.handler.server;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aiagent.assistant.idl.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.obric_action.handler.server.ShortLinkApiActionHandler$execute$2", f = "ShortLinkApiActionHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ShortLinkApiActionHandler$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $shortLink;
    private /* synthetic */ Object L$0;
    int label;

    public ShortLinkApiActionHandler$execute$2(String r1, Continuation<? super ShortLinkApiActionHandler$execute$2> r2) {
        this.$shortLink = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ShortLinkApiActionHandler$execute$2 r0 = new ShortLinkApiActionHandler$execute$2(this.$shortLink, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        String r9 = this.$shortLink;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        IAgentAppIntentIDL r3 = a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L13
        if (r3 == null) goto L8;
        r3.callShortLink(r9);     // Catch: Throwable -> L13
    L8:
        if (r3 != null) goto L10;
        FLogger.a.w("ShortLinkApiActionHandler", "IAgentAppIntentIDL is null");     // Catch: Throwable -> L13
        boolean r10 = false;
    L11:
        Object r11 = Result.constructor-impl(Boxing.boxBoolean(r10));     // Catch: Throwable -> L13
    L15:
        Throwable r4 = Result.exceptionOrNull-impl(r11);
        if (r4 == null) goto L19;
        FLogger.a.w("ShortLinkApiActionHandler", "callShortLink failed: " + r4.getMessage(), r4);
    L19:
        if (Result.isSuccess-impl(r11) == false) goto L21;
        ((Boolean) r11).booleanValue();
        FLogger.a.i("ShortLinkApiActionHandler", "callShortLink success");
    L21:
        Boolean r0 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r11) == true) goto L24;
        return r11;
    L24:
        return r0;
    L10:
        r10 = true;
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
