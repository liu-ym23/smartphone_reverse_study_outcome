package com.bytedance.ai.applet.permission;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletAuthorizeHelper", f = "AppletAuthorizeHelper.kt", i = {0, 0, 0}, l = {391}, m = "trackPermissionStatusBackend", n = {"authTaskSession", "permissionCheckSession", "startTs"}, s = {"L$0", "L$1", "J$0"})
public final class AppletAuthorizeHelper$trackPermissionStatusBackend$1<T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAuthorizeHelper this$0;

    public AppletAuthorizeHelper$trackPermissionStatusBackend$1(AppletAuthorizeHelper r1, Continuation<? super AppletAuthorizeHelper$trackPermissionStatusBackend$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AppletAuthorizeHelper r11 = this.this$0;
        Lazy<Keva> r0 = AppletAuthorizeHelper.d;
        return r11.j(null, null, null, this);
    }
}
