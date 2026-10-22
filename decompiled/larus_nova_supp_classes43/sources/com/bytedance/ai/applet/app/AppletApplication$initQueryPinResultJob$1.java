package com.bytedance.ai.applet.app;

import com.bytedance.ai.model.AppletRuntimeManager;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletApplication$initQueryPinResultJob$1", f = "AppletApplication.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
final class AppletApplication$initQueryPinResultJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $appId;
    int label;
    final /* synthetic */ AppletApplication this$0;

    public AppletApplication$initQueryPinResultJob$1(String r1, AppletApplication r10, Continuation<? super AppletApplication$initQueryPinResultJob$1> r11) {
        this.$appId = r1;
        this.this$0 = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletApplication$initQueryPinResultJob$1(this.$appId, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r11 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L21
    L16:
        if (((Boolean) r10).booleanValue() == true) goto L19;
    L18:
        r11 = false;
    L19:
        return Boxing.boxBoolean(r11);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        AppletRuntimeManager.INSTANCE.getClass();     // Catch: Exception -> L21
        g2.b r12 = AppletRuntimeManager.d;     // Catch: Exception -> L21
        if (r12 == null) goto L18;
        String r13 = this.$appId;     // Catch: Exception -> L21
        this.label = 1;     // Catch: Exception -> L21
        r10 = r12.l(r13, this);     // Catch: Exception -> L21
        if (r10 != r0) goto L16;
        return r0;
    L21:
        e = move-exception;
        AtomicInteger r14 = com.bytedance.ai.applet.base.log.d.d;
        this.this$0.i().a("queryPinResult error: " + e, null);
        return null;
    }
}
