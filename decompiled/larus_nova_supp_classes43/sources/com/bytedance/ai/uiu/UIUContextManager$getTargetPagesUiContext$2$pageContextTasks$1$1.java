package com.bytedance.ai.uiu;

import com.byted.cast.sink.api.CastInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1", f = "UIUContextManager.kt", i = {}, l = {CastInfo.TYPE_DISCONNECT}, m = "invokeSuspend", n = {}, s = {})
public final class UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ com.bytedance.ai.model.widgets.c $value;
    int label;

    public UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1(com.bytedance.ai.model.widgets.c r1, Continuation<? super UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1> r10) {
        this.$value = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1(this.$value, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        a r11 = a.a;
        com.bytedance.ai.model.widgets.c r12 = this.$value;
        this.label = 1;
        r10 = a.a(r11, r12, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
