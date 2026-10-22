package com.ss.android.lark.keyboard.viewmodel;

import com.bytedance.lark.pb.im.v1.TransformMarkdownToRichTextRequest;
import com.bytedance.lark.pb.im.v1.TransformMarkdownToRichTextResponse;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.base.b;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larksuite/rucket/job/base/RucketResult;", "Lcom/bytedance/lark/pb/im/v1/TransformMarkdownToRichTextResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.viewmodel.KeyboardModel$markdownToRichText$result$1", f = "KeyboardModel.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class KeyboardModel$markdownToRichText$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends b<? extends TransformMarkdownToRichTextResponse>>>, Object> {
    final /* synthetic */ TransformMarkdownToRichTextRequest $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KeyboardModel this$0;

    public KeyboardModel$markdownToRichText$result$1(KeyboardModel r1, TransformMarkdownToRichTextRequest r2, Continuation<? super KeyboardModel$markdownToRichText$result$1> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        KeyboardModel$markdownToRichText$result$1 r0 = new KeyboardModel$markdownToRichText$result$1(this.this$0, this.$request, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends b<TransformMarkdownToRichTextResponse>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L15
    L13:
        Object r6 = Result.constructor-impl((b) r5);     // Catch: Throwable -> L15
    L18:
        return Result.box-impl(r6);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        TransformMarkdownToRichTextRequest r8 = this.$request;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        a r3 = (a) b38.b.a.create(a.class);     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L15
        RucketJob<TransformMarkdownToRichTextResponse> r9 = r3.transformMarkdownToRichText(r8);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r5 = r9.awaitGet(this);     // Catch: Throwable -> L15
        if (r5 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
