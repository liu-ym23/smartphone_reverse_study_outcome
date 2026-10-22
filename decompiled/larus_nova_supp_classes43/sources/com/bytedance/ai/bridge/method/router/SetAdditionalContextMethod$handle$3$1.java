package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntimeManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.router.SetAdditionalContextMethod$handle$3$1", f = "SetAdditionalContextMethod.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
final class SetAdditionalContextMethod$handle$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f3.h<AbsSetAdditionalContextMethodIDL.b> $callback;
    final /* synthetic */ k2.j $containerView;
    final /* synthetic */ AbsSetAdditionalContextMethodIDL.a $params;
    int label;

    public SetAdditionalContextMethod$handle$3$1(k2.j r1, AbsSetAdditionalContextMethodIDL.a r10, f3.h<AbsSetAdditionalContextMethodIDL.b> r11, Continuation<? super SetAdditionalContextMethod$handle$3$1> r12) {
        this.$containerView = r1;
        this.$params = r10;
        this.$callback = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new SetAdditionalContextMethod$handle$3$1(this.$containerView, this.$params, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L15:
        Boolean r11 = (Boolean) r10;
    L17:
        if (r11 == null) goto L19;
        boolean r12 = r11.booleanValue();
    L20:
        if (r12 == true) goto L22;
        this.$containerView.getAppletRuntime().E(this.$params.getAdditionalContext(), this.$params.getBotId());
    L22:
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_SetAdditionalContextMethod", "call success, containerType=PAGE");
        f3.h<AbsSetAdditionalContextMethodIDL.b> r13 = this.$callback;
        Intrinsics.checkNotNullParameter(AbsSetAdditionalContextMethodIDL.b.class, "<this>");
        f3.h.a.b(r13, (ResultModel) k3.c.a(AbsSetAdditionalContextMethodIDL.b.class));
        return Unit.INSTANCE;
    L19:
        r12 = false;
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        String r14 = this.$containerView.getPageInfo().getMessageId();
        if (r14 == null) goto L19;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r15 = AppletRuntimeManager.d;
        if (r15 == null) goto L16;
        this.label = 1;
        r10 = r15.G(r14, this);
        if (r10 != r0) goto L15;
        return r0;
    L16:
        r11 = null;
        goto L17
    }
}
