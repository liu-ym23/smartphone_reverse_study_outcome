package com.larus.bmhome.view;

import android.view.View;
import android.widget.FrameLayout;
import com.larus.chat.common.databinding.LarusLayoutTextMessageMultiActionButtonBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.TextAnswerMultiActionButton$config$1$6$1", f = "TextAnswerMultiActionButton.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
public final class TextAnswerMultiActionButton$config$1$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<View, Continuation<? super Unit>, Unit> $callback;
    final /* synthetic */ LarusLayoutTextMessageMultiActionButtonBinding $this_with;
    final /* synthetic */ FrameLayout $view;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public TextAnswerMultiActionButton$config$1$6$1(LarusLayoutTextMessageMultiActionButtonBinding r1, Function2<? super View, ? super Continuation<? super Unit>, Unit> r2, FrameLayout r3, Continuation<? super TextAnswerMultiActionButton$config$1$6$1> r4) {
        this.$this_with = r1;
        this.$callback = r2;
        this.$view = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new TextAnswerMultiActionButton$config$1$6$1(this.$this_with, this.$callback, this.$view, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        FrameLayout r2 = (FrameLayout) this.L$1;
        Function2 r3 = (Function2) this.L$0;
        ResultKt.throwOnFailure(r6);
    L13:
        this.$this_with.d.setRotation(0.0f);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.$this_with.d.setRotation(180.0f);
        Function2<View, Continuation<? super Unit>, Unit> r7 = this.$callback;
        FrameLayout r4 = this.$view;
        this.L$0 = r7;
        this.L$1 = r4;
        this.label = 1;
        kotlinx.coroutines.j r5 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r5.C();
        r7.invoke(r4, r5);
        Object r8 = r5.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r8 != r0) goto L13;
        return r0;
    }
}
