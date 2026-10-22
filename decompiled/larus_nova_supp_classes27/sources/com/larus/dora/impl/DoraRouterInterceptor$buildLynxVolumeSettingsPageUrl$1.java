package com.larus.dora.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraRouterInterceptor", f = "DoraRouterInterceptor.kt", i = {}, l = {250}, m = "buildLynxVolumeSettingsPageUrl", n = {}, s = {})
final class DoraRouterInterceptor$buildLynxVolumeSettingsPageUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraRouterInterceptor this$0;

    public DoraRouterInterceptor$buildLynxVolumeSettingsPageUrl$1(DoraRouterInterceptor r1, Continuation<? super DoraRouterInterceptor$buildLynxVolumeSettingsPageUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraRouterInterceptor.c(this.this$0, this);
    }
}
