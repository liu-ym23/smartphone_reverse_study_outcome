package com.bytedance.ai.applet.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletApplication", f = "AppletApplication.kt", i = {0}, l = {599}, m = "refreshPinMenuStatus", n = {"context"}, s = {"L$0"})
public final class AppletApplication$refreshPinMenuStatus$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletApplication this$0;

    public AppletApplication$refreshPinMenuStatus$1(AppletApplication r1, Continuation<? super AppletApplication$refreshPinMenuStatus$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AppletApplication r11 = this.this$0;
        int r0 = AppletApplication.o;
        return r11.E(null, false, this);
    }
}
