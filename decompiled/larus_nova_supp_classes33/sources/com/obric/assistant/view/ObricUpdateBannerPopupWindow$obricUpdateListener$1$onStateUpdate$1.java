package com.obric.assistant.view;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.view.ObricUpdateBannerPopupWindow$obricUpdateListener$1$onStateUpdate$1", f = "ObricUpdateBannerPopupWindow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricUpdateBannerPopupWindow$obricUpdateListener$1$onStateUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ ObricUpdateBannerPopupWindow this$0;

    public ObricUpdateBannerPopupWindow$obricUpdateListener$1$onStateUpdate$1(int r1, ObricUpdateBannerPopupWindow r2, Continuation<? super ObricUpdateBannerPopupWindow$obricUpdateListener$1$onStateUpdate$1> r3) {
        this.$state = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricUpdateBannerPopupWindow$obricUpdateListener$1$onStateUpdate$1(this.$state, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        if (this.$state != (-1)) goto L8;
        this.this$0.c();
        return Unit.INSTANCE;
    L8:
        ObricUpdateBannerPopupWindow r3 = this.this$0;
        int r0 = ObricUpdateBannerPopupWindow.m;
        r3.h();
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
