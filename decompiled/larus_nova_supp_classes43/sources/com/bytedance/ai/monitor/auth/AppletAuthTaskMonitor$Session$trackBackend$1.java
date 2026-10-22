package com.bytedance.ai.monitor.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor$Session", f = "AppletAuthTaskMonitor.kt", i = {0}, l = {159}, m = "trackBackend", n = {"start"}, s = {"J$0"})
public final class AppletAuthTaskMonitor$Session$trackBackend$1<T> extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAuthTaskMonitor.Session this$0;

    public AppletAuthTaskMonitor$Session$trackBackend$1(AppletAuthTaskMonitor.Session r1, Continuation<? super AppletAuthTaskMonitor$Session$trackBackend$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, this);
    }
}
