package com.bytedance.ai.applet.app;

import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.model.AppMeta;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/bridge/remote/model/AppMeta;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletApplication$initMetaInfoJob$2", f = "AppletApplication.kt", i = {}, l = {491}, m = "invokeSuspend", n = {}, s = {})
final class AppletApplication$initMetaInfoJob$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppMeta>, Object> {
    final /* synthetic */ String $appId;
    int label;
    final /* synthetic */ AppletApplication this$0;

    public AppletApplication$initMetaInfoJob$2(String r1, AppletApplication r10, Continuation<? super AppletApplication$initMetaInfoJob$2> r11) {
        this.$appId = r1;
        this.this$0 = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletApplication$initMetaInfoJob$2(this.$appId, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AppMeta> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L18
        Object r11 = ((Result) r10).unbox-impl();     // Catch: Exception -> L18
    L14:
        if (Result.isFailure-impl(r11) == false) goto L16;
        r11 = null;
    L16:
        return (AppMeta) r11;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        UserAuthService r12 = UserAuthService.a;     // Catch: Exception -> L18
        String r13 = this.$appId;     // Catch: Exception -> L18
        this.label = 1;     // Catch: Exception -> L18
        r11 = r12.h(r13, this);     // Catch: Exception -> L18
        if (r11 != r0) goto L14;
        return r0;
    L18:
        e = move-exception;
        AtomicInteger r14 = com.bytedance.ai.applet.base.log.d.d;
        this.this$0.i().a("getAppletMetaInfo error: " + e, null);
        return null;
    }
}
