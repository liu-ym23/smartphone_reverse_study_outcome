package com.bytedance.ai.applet.services;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.model.objects.Applet;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/applet/app/AppletApplication;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.services.AppletAppManagerService$provideApp$3", f = "AppletAppManagerService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppletAppManagerService$provideApp$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppletApplication>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ Applet $manifest;
    private /* synthetic */ Object L$0;
    int label;

    public AppletAppManagerService$provideApp$3(String r1, Applet r10, Continuation<? super AppletAppManagerService$provideApp$3> r11) {
        this.$appId = r1;
        this.$manifest = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletAppManagerService$provideApp$3 r0 = new AppletAppManagerService$provideApp$3(this.$appId, this.$manifest, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AppletApplication> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        AppletAppManagerService r12 = AppletAppManagerService.INSTANCE;
        String r0 = this.$appId;
        r12.getClass();
        AppletApplication r13 = AppletAppManagerService.a(r0);
        if (r13 == null) goto L7;
        String r1 = this.$appId;
        com.bytedance.ai.applet.base.log.b r14 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("AppletAppManagerService", "provideApp: " + r1 + " is already installed before install", null);
        return r13;
    L7:
        String r15 = this.$appId;
        Applet r16 = this.$manifest;
        com.bytedance.ai.applet.base.log.b r17 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AppletAppManagerService", "provideApp: install " + r15 + " after load manifest");
        return AppletAppManagerService.c(r16);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
