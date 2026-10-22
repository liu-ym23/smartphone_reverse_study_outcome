package com.bytedance.android.live.core.utils;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroid/view/View;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt$children$1", f = "UtilityKotlinExtentions.kt", i = {0, 0}, l = {242}, m = "invokeSuspend", n = {"$this$sequence", "i"}, s = {"L$0", "I$0"})
public final class UtilityKotlinExtentionsKt$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super View>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewGroup $this_children;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    public UtilityKotlinExtentionsKt$children$1(ViewGroup r1, Continuation r2) {
        this.$this_children = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        UtilityKotlinExtentionsKt$children$1 r0 = new UtilityKotlinExtentionsKt$children$1(this.$this_children, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0046 -> B:15:0x0049). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r3 = this.I$0;
        SequenceScope r4 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r7);
        UtilityKotlinExtentionsKt$children$1 r8 = this;
    L15:
        r3 = r3 + 1;
    L9:
        if (r3 >= r2) goto L17;
        View r5 = r8.$this_children.getChildAt(r3);
        if (r5 == null) goto L17;
        r8.L$0 = r4;
        r8.I$0 = r3;
        r8.I$1 = r2;
        r8.label = 1;
        if (r4.yield(r5, r8) != r0) goto L15;
        return r0;
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        SequenceScope r9 = (SequenceScope) this.L$0;
        r2 = this.$this_children.getChildCount();
        r3 = 0;
        r4 = r9;
        r8 = this;
        goto L9
    }
}
