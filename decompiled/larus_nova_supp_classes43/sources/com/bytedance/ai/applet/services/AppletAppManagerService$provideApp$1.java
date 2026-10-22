package com.bytedance.ai.applet.services;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.services.AppletAppManagerService", f = "AppletAppManagerService.kt", i = {0}, l = {159, 164}, m = "provideApp", n = {BdpAwemeConstant.KEY_APP_ID}, s = {"L$0"})
public final class AppletAppManagerService$provideApp$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAppManagerService this$0;

    public AppletAppManagerService$provideApp$1(AppletAppManagerService r1, Continuation<? super AppletAppManagerService$provideApp$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
