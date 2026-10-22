package com.larus.dora.impl.guide;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBtPermissionGuide", f = "DoraBtPermissionGuide.kt", i = {}, l = {160, 168, 175}, m = "isChannelOrUserStrategyMet", n = {}, s = {})
public final class DoraBtPermissionGuide$isChannelOrUserStrategyMet$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBtPermissionGuide this$0;

    public DoraBtPermissionGuide$isChannelOrUserStrategyMet$1(DoraBtPermissionGuide r1, Continuation<? super DoraBtPermissionGuide$isChannelOrUserStrategyMet$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraBtPermissionGuide r3 = this.this$0;
        int r0 = DoraBtPermissionGuide.k;
        return r3.g(this);
    }
}
