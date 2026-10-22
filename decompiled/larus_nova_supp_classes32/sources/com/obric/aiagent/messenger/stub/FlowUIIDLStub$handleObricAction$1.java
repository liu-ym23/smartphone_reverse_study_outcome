package com.obric.aiagent.messenger.stub;

import com.larus.nova.NovaApplication;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IObricActionResultCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.utils.FunctionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FlowUIIDLStub$handleObricAction$1", f = "FlowUIIDLStub.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
public final class FlowUIIDLStub$handleObricAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IObricActionResultCallbackIDL $callback;
    final /* synthetic */ String $expectKey;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlowUIIDLStub this$0;

    public FlowUIIDLStub$handleObricAction$1(FlowUIIDLStub r1, String r2, String r3, IObricActionResultCallbackIDL r4, Continuation<? super FlowUIIDLStub$handleObricAction$1> r5) {
        this.this$0 = r1;
        this.$url = r2;
        this.$expectKey = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        FlowUIIDLStub$handleObricAction$1 r6 = new FlowUIIDLStub$handleObricAction$1(this.this$0, this.$url, this.$expectKey, this.$callback, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L15
    L13:
        Object r7 = Result.constructor-impl((com.obric.assistant.obric_action.h) r6);     // Catch: Throwable -> L15
    L17:
        Throwable r3 = Result.exceptionOrNull-impl(r7);
        if (r3 == null) goto L20;
        FLogger.a.e("FlowUIIDLStub", "handleObricAction failed. " + r3.getMessage(), r3);
    L20:
        Throwable r4 = Result.exceptionOrNull-impl(r7);
        if (r4 == null) goto L33;
        com.obric.assistant.obric_action.h.a r8 = com.obric.assistant.obric_action.h.d;
        String r5 = r4.getMessage();
        if (r5 != null) goto L27;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L27:
        if (r5.length() == 0) goto L30;
        r2 = false;
    L30:
        if (r2 == false) goto L32;
        r5 = "handle obric action failed";
    L32:
        r7 = com.obric.assistant.obric_action.h.a.a(r8, r5, 2);
    L33:
        final com.obric.assistant.obric_action.h r9 = (com.obric.assistant.obric_action.h) r7;
        final IObricActionResultCallbackIDL r10 = this.$callback;
        FunctionsKt.a(new m(r10, r9));
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        FlowUIIDLStub r12 = this.this$0;
        String r13 = this.$url;
        String r14 = this.$expectKey;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L15
        gd9.i r16 = com.larus.im.b.a;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L15
        NovaApplication r17 = r16.getApplication();     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r6 = FlowUIIDLStub.access$dispatchObricActionSync(r12, r17, r13, r14, this);     // Catch: Throwable -> L15
        if (r6 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
