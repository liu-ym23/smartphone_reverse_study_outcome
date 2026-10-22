package com.obric.assistant.zeus.plugin;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.zeus.plugin.ZeusPluginServiceImpl", f = "ZeusPluginServiceImpl.kt", i = {0}, l = {268}, m = "preInstallPlugin", n = {"startTime"}, s = {"J$0"})
public final class ZeusPluginServiceImpl$preInstallPlugin$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZeusPluginServiceImpl this$0;

    public ZeusPluginServiceImpl$preInstallPlugin$1(ZeusPluginServiceImpl r1, Continuation<? super ZeusPluginServiceImpl$preInstallPlugin$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, 0, this);
    }
}
