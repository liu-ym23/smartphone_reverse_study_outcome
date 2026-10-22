package com.larus.dora.impl.guide;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBatteryGuide", f = "DoraBatteryGuide.kt", i = {}, l = {251}, m = "showGuideInternal", n = {}, s = {})
public final class DoraBatteryGuide$showGuideInternal$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBatteryGuide this$0;

    public DoraBatteryGuide$showGuideInternal$1(DoraBatteryGuide r1, Continuation<? super DoraBatteryGuide$showGuideInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraBatteryGuide r3 = this.this$0;
        int r0 = DoraBatteryGuide.d;
        return r3.i(null, null, null, this);
    }
}
