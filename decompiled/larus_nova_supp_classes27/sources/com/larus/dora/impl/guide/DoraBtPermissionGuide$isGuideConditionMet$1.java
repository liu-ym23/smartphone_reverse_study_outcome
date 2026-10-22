package com.larus.dora.impl.guide;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBtPermissionGuide", f = "DoraBtPermissionGuide.kt", i = {}, l = {99, 115, 127, 143}, m = "isGuideConditionMet", n = {}, s = {})
public final class DoraBtPermissionGuide$isGuideConditionMet$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBtPermissionGuide this$0;

    public DoraBtPermissionGuide$isGuideConditionMet$1(DoraBtPermissionGuide r1, Continuation<? super DoraBtPermissionGuide$isGuideConditionMet$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
