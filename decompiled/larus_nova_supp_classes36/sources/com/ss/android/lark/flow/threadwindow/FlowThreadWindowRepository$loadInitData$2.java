package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.chat.chatwindow.chat.perload.ExtensionKt;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.threadwindow.FlowThreadWindowRepository$loadInitData$2", f = "FlowThreadWindowRepository.kt", i = {}, l = {31, 33}, m = "invokeSuspend", n = {}, s = {})
final class FlowThreadWindowRepository$loadInitData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends i7b.a>>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlowThreadWindowRepository this$0;

    public FlowThreadWindowRepository$loadInitData$2(FlowThreadWindowRepository r1, Continuation<? super FlowThreadWindowRepository$loadInitData$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FlowThreadWindowRepository$loadInitData$2 r0 = new FlowThreadWindowRepository$loadInitData$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends i7b.a>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L20
        Result r5 = (Result) r4;     // Catch: Throwable -> L20
    L8:
        Object r6 = r5.unbox-impl();     // Catch: Throwable -> L20
    L18:
        Object r7 = Result.constructor-impl(Result.box-impl(r6));     // Catch: Throwable -> L20
    L22:
        Throwable r2 = Result.exceptionOrNull-impl(r7);
        if (r2 != null) goto L26;
        return r7;
    L26:
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r2)));
    L6:
        if (r1 != 2) goto L11;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L20
        r5 = (Result) r4;     // Catch: Throwable -> L20
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        FlowThreadWindowRepository r9 = this.this$0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L20
        r9.a.getClass();     // Catch: Throwable -> L20
        com.ss.android.lark.chat.chatwindow.chat.perload.c r10 = com.ss.android.lark.chat.chatwindow.chat.perload.c.a.a;     // Catch: Throwable -> L20
        ChatBundle r11 = r9.a;     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        r6 = ExtensionKt.a(r10, r11, this);     // Catch: Throwable -> L20
        if (r6 != r0) goto L18;
        return r0;
    L20:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
