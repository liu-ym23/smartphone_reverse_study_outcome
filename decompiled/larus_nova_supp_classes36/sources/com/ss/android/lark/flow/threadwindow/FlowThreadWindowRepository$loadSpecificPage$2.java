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
@DebugMetadata(c = "com.ss.android.lark.flow.threadwindow.FlowThreadWindowRepository$loadSpecificPage$2", f = "FlowThreadWindowRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowThreadWindowRepository$loadSpecificPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends n5b.a>>>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ int $position;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlowThreadWindowRepository this$0;

    public FlowThreadWindowRepository$loadSpecificPage$2(int r1, FlowThreadWindowRepository r2, String r3, Continuation<? super FlowThreadWindowRepository$loadSpecificPage$2> r4) {
        this.$position = r1;
        this.this$0 = r2;
        this.$chatId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        FlowThreadWindowRepository$loadSpecificPage$2 r0 = new FlowThreadWindowRepository$loadSpecificPage$2(this.$position, this.this$0, this.$chatId, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends List<? extends n5b.a>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        int r6 = this.$position;
        FlowThreadWindowRepository r0 = this.this$0;
        String r1 = this.$chatId;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L18
        if (r6 >= 0) goto L9;
        r6 = 0;
    L9:
        l5b.b r7 = FlowThreadWindowRepository.a(r0, r1, MessageFetchScene.SPECIFIED_POSITION, r6);     // Catch: Throwable -> L18
        if (r7 != null) goto L12;
        Object r8 = Result.constructor-impl(ResultKt.createFailure(new ErrorResult("load thread window specific page failed")));     // Catch: Throwable -> L18
    L16:
        Object r9 = Result.constructor-impl(Result.box-impl(r8));     // Catch: Throwable -> L18
    L20:
        Throwable r3 = Result.exceptionOrNull-impl(r9);
        if (r3 != null) goto L24;
        return r9;
    L24:
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r3)));
    L12:
        List r10 = r7.a;     // Catch: Throwable -> L18
        if (r10 != null) goto L15;
        r10 = CollectionsKt.emptyList();     // Catch: Throwable -> L18
    L15:
        r8 = Result.constructor-impl(r10);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
