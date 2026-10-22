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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/keyboard/edittext2/edittors/editinfo/InsertAtInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.view.InlineEditTextFunctionImpl$getAtInfo$2", f = "InlineEditTextFunctionImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InlineEditTextFunctionImpl$getAtInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super hob.c>, Object> {
    final /* synthetic */ hob.c $atInfo;
    int label;

    public InlineEditTextFunctionImpl$getAtInfo$2(hob.c r1, Continuation<? super InlineEditTextFunctionImpl$getAtInfo$2> r2) {
        this.$atInfo = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InlineEditTextFunctionImpl$getAtInfo$2(this.$atInfo, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super hob.c> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return this.$atInfo;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
