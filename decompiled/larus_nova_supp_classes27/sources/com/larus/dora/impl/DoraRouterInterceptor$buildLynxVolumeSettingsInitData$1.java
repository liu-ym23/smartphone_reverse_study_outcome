package com.larus.dora.impl;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraRouterInterceptor", f = "DoraRouterInterceptor.kt", i = {}, l = {285}, m = "buildLynxVolumeSettingsInitData", n = {}, s = {})
public final class DoraRouterInterceptor$buildLynxVolumeSettingsInitData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraRouterInterceptor this$0;

    public DoraRouterInterceptor$buildLynxVolumeSettingsInitData$1(DoraRouterInterceptor r1, Continuation<? super DoraRouterInterceptor$buildLynxVolumeSettingsInitData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraRouterInterceptor r3 = this.this$0;
        List r0 = DoraRouterInterceptor.c;
        return r3.d(this);
    }
}
