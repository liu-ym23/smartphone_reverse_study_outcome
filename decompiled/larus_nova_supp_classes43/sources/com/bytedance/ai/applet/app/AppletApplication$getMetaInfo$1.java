package com.bytedance.ai.applet.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletApplication", f = "AppletApplication.kt", i = {}, l = {180, 184}, m = "getMetaInfo", n = {}, s = {})
public final class AppletApplication$getMetaInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletApplication this$0;

    public AppletApplication$getMetaInfo$1(AppletApplication r1, Continuation<? super AppletApplication$getMetaInfo$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(this);
    }
}
