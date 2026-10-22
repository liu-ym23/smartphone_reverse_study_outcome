package com.ss.android.lark.flow.threadwindow;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lcom/ss/android/lark/chat/entity/thread/ThreadInfo;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.threadwindow.FlowThreadWindowRepository$loadFirstPage$2", f = "FlowThreadWindowRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowThreadWindowRepository$loadFirstPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends n5b.a>>>, Object> {
    final /* synthetic */ String $chatId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlowThreadWindowRepository this$0;

    public FlowThreadWindowRepository$loadFirstPage$2(FlowThreadWindowRepository r1, String r2, Continuation<? super FlowThreadWindowRepository$loadFirstPage$2> r3) {
        this.this$0 = r1;
        this.$chatId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        FlowThreadWindowRepository$loadFirstPage$2 r0 = new FlowThreadWindowRepository$loadFirstPage$2(this.this$0, this.$chatId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends List<? extends n5b.a>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        FlowThreadWindowRepository r8 = this.this$0;
        String r0 = this.$chatId;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L24
        int r2 = r8.a.c;     // Catch: Throwable -> L24
        if (r2 == (-1)) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        MessageFetchScene r4 = MessageFetchScene.SPECIFIED_POSITION;     // Catch: Throwable -> L24
    L12:
        if (r3 == true) goto L15;
        r2 = 0;
    L15:
        l5b.b r9 = FlowThreadWindowRepository.a(r8, r0, r4, r2);     // Catch: Throwable -> L24
        if (r9 != null) goto L18;
        Object r10 = Result.constructor-impl(ResultKt.createFailure(new ErrorResult("load thread window first page failed")));     // Catch: Throwable -> L24
    L22:
        Object r11 = Result.constructor-impl(Result.box-impl(r10));     // Catch: Throwable -> L24
    L26:
        Throwable r5 = Result.exceptionOrNull-impl(r11);
        if (r5 != null) goto L30;
        return r11;
    L30:
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r5)));
    L18:
        List r12 = r9.a;     // Catch: Throwable -> L24
        if (r12 != null) goto L21;
        r12 = CollectionsKt.emptyList();     // Catch: Throwable -> L24
    L21:
        r10 = Result.constructor-impl(r12);     // Catch: Throwable -> L24
        goto L22
    L11:
        r4 = MessageFetchScene.FIRST_SCREEN;     // Catch: Throwable -> L24
        goto L12
    L8:
        r3 = false;
    L24:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
