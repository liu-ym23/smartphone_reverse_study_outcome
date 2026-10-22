package com.ss.android.lark.inline.ai.ui.view;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/keyboard/edittext2/edittors/editinfo/InsertAtInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.view.InlineEditTextFunctionImpl$insertSearchResult$1$1$1", f = "InlineEditTextFunctionImpl.kt", i = {}, l = {510}, m = "invokeSuspend", n = {}, s = {})
public final class InlineEditTextFunctionImpl$insertSearchResult$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super hob.c>, Object> {
    final /* synthetic */ hob.c $atInfo;
    int label;
    final /* synthetic */ c this$0;

    public InlineEditTextFunctionImpl$insertSearchResult$1$1$1(c r1, hob.c r2, Continuation<? super InlineEditTextFunctionImpl$insertSearchResult$1$1$1> r3) {
        this.this$0 = r1;
        this.$atInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InlineEditTextFunctionImpl$insertSearchResult$1$1$1(this.this$0, this.$atInfo, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super hob.c> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        c r6 = this.this$0;
        hob.c r2 = this.$atInfo;
        this.label = 1;
        int r3 = c.k;
        r6.getClass();
        r5 = BuildersKt.withContext(Dispatchers.getIO(), new InlineEditTextFunctionImpl$getAtInfo$2(r2, null), this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
