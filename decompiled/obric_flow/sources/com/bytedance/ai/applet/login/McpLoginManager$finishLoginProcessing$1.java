package com.bytedance.ai.applet.login;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.McpLoginManager$finishLoginProcessing$1", f = "McpLoginManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class McpLoginManager$finishLoginProcessing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public McpLoginManager$finishLoginProcessing$1(Continuation r5) {
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new McpLoginManager$finishLoginProcessing$1(r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return new McpLoginManager$finishLoginProcessing$1(r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        c r10 = (c) j.f1751b.get();
        if (r10 == null) goto L5;
        r10.a();
    L5:
        c r11 = (c) j.f1751b.get();
        if (r11 == null) goto L11;
        FrameLayout r12 = r11.f1738c;
        if (r12 == null) goto L11;
        r12.removeAllViews();
    L11:
        return Unit.INSTANCE;
    }
}
