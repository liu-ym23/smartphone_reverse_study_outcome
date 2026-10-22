package com.ss.android.lark.movable;

import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.movable.MovableView$render$1$islandTasks$1$1", f = "MovableView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MovableView$render$1$islandTasks$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends byte[]>>, Object> {
    final /* synthetic */ int $islandID;
    final /* synthetic */ MovableView.c $renderContext;
    int label;
    final /* synthetic */ MovableView this$0;

    public MovableView$render$1$islandTasks$1$1(MovableView r1, MovableView.c r2, int r3, Continuation<? super MovableView$render$1$islandTasks$1$1> r4) {
        this.this$0 = r1;
        this.$renderContext = r2;
        this.$islandID = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MovableView$render$1$islandTasks$1$1(this.this$0, this.$renderContext, this.$islandID, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<Integer, byte[]>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r3);
    L11:
        e = move-exception;
        Log.e("MovableView", "Failed to request island " + this.$islandID + ": " + e.getMessage());
        return TuplesKt.to(Boxing.boxInt(this.$islandID), null);
    L6:
        if (this.this$0.i == false) goto L8;
        MovableView.c r4 = this.$renderContext;     // Catch: Exception -> L11
        byte[] r5 = Lark_markdown_renderKt.ffiRequestIslandRenderStream-zly0blg(r4.c, r4.d, UInt.constructor-impl(this.$islandID));     // Catch: Exception -> L11
    L9:
        return TuplesKt.to(Boxing.boxInt(this.$islandID), r5);
    L8:
        MovableView.c r6 = this.$renderContext;     // Catch: Exception -> L11
        r5 = Lark_markdown_renderKt.ffiRequestIslandRenderStreamInTextApi-zly0blg(r6.c, r6.d, UInt.constructor-impl(this.$islandID));     // Catch: Exception -> L11
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
