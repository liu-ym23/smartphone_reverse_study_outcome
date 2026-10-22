package com.bytedance.ai.applet.permission;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletAuthorizeHelper", f = "AppletAuthorizeHelper.kt", i = {0, 0, 0, 0}, l = {99}, m = "authorize", n = {"scopeName", "resultDetail", "permissionCheckSession", "session"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class AppletAuthorizeHelper$authorize$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAuthorizeHelper this$0;

    public AppletAuthorizeHelper$authorize$1(AppletAuthorizeHelper r1, Continuation<? super AppletAuthorizeHelper$authorize$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, false, null, null, null, this);
    }
}
