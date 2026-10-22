package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.LoginProcessor", f = "LoginProcessor.kt", i = {0, 0, 1, 1}, l = {637, 640}, m = "routeToLoginEntry", n = {"appletId", "loginContext", "appletId", "loginContext"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class LoginProcessor$routeToLoginEntry$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginProcessor this$0;

    public LoginProcessor$routeToLoginEntry$1(LoginProcessor r1, Continuation<? super LoginProcessor$routeToLoginEntry$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return LoginProcessor.b(this.this$0, null, this);
    }
}
