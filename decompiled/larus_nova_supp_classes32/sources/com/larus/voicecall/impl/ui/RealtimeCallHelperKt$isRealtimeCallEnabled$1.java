package com.larus.voicecall.impl.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallHelperKt", f = "RealtimeCallHelper.kt", i = {0, 0, 1, 1}, l = {269, 269}, m = "isRealtimeCallEnabled", n = {"botModel", "realtimeCallLanguageConfig", "botModel", "realtimeCallLanguageConfig"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class RealtimeCallHelperKt$isRealtimeCallEnabled$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public RealtimeCallHelperKt$isRealtimeCallEnabled$1(Continuation<? super RealtimeCallHelperKt$isRealtimeCallEnabled$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return RealtimeCallHelperKt.c(null, null, null, this);
    }
}
