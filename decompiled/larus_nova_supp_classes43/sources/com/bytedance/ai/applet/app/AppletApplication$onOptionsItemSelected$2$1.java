package com.bytedance.ai.applet.app;

import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.model.AppletRuntimeManager;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletApplication$onOptionsItemSelected$2$1", f = "AppletApplication.kt", i = {}, l = {435}, m = "invokeSuspend", n = {}, s = {})
public final class AppletApplication$onOptionsItemSelected$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletAppActivity $activity;
    final /* synthetic */ com.bytedance.ai.applet.app.view.m $item;
    int label;
    final /* synthetic */ AppletApplication this$0;

    public AppletApplication$onOptionsItemSelected$2$1(AppletApplication r1, AppletAppActivity r10, com.bytedance.ai.applet.app.view.m r11, Continuation<? super AppletApplication$onOptionsItemSelected$2$1> r12) {
        this.this$0 = r1;
        this.$activity = r10;
        this.$item = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletApplication$onOptionsItemSelected$2$1(this.this$0, this.$activity, this.$item, r11);
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
    L11:
        AppMeta r11 = (AppMeta) r10;
        if (r11 == null) goto L15;
        String r12 = r11.getAppName();
        if (r12 == null) goto L15;
    L16:
        String r13 = r12;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r14 = AppletRuntimeManager.d;
        if (r14 == null) goto L20;
        r14.d(this.$activity, this.$item.a, this.this$0.getAppId(), r13, null);
    L20:
        return Unit.INSTANCE;
    L15:
        r12 = this.this$0.j().a;
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletApplication r15 = this.this$0;
        this.label = 1;
        r10 = r15.k(this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
