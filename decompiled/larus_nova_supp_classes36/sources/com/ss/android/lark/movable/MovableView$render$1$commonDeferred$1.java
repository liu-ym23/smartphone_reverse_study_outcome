package com.ss.android.lark.movable;

import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.movable.MovableView$render$1$commonDeferred$1", f = "MovableView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MovableView$render$1$commonDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ MovableView.c $renderContext;
    int label;
    final /* synthetic */ MovableView this$0;

    public MovableView$render$1$commonDeferred$1(MovableView r1, MovableView.c r2, Continuation<? super MovableView$render$1$commonDeferred$1> r3) {
        this.this$0 = r1;
        this.$renderContext = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MovableView$render$1$commonDeferred$1(this.this$0, this.$renderContext, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super byte[]> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        if (this.this$0.i == false) goto L7;
        MovableView.c r3 = this.$renderContext;
        return Lark_markdown_renderKt.ffiRequestRenderStream-feOb9K0(r3.c, r3.d);
    L7:
        MovableView.c r4 = this.$renderContext;
        return Lark_markdown_renderKt.ffiRequestRenderStreamInTextApi-feOb9K0(r4.c, r4.d);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
