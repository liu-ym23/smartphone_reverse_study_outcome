package com.bytedance.ai.lynx;

import com.byted.cast.sink.api.CastInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.lynx.AppletLynxViewApi$createLynxView$4$createUI$1$4", f = "AppletLynxViewApi.kt", i = {}, l = {CastInfo.TYPE_PAUSED}, m = "authorizeRecord", n = {}, s = {})
public final class AppletLynxViewApi$createLynxView$4$createUI$1$4$authorizeRecord$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletLynxViewApi$createLynxView$4$createUI$1$4 this$0;

    public AppletLynxViewApi$createLynxView$4$createUI$1$4$authorizeRecord$1(AppletLynxViewApi$createLynxView$4$createUI$1$4 r1, Continuation<? super AppletLynxViewApi$createLynxView$4$createUI$1$4$authorizeRecord$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
