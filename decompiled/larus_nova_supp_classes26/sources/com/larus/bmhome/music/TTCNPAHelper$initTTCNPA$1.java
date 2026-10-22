package com.larus.bmhome.music;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.TTCNPAHelper", f = "TTCNPAHelper.kt", i = {0}, l = {122, 113}, m = "initTTCNPA", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class TTCNPAHelper$initTTCNPA$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TTCNPAHelper this$0;

    public TTCNPAHelper$initTTCNPA$1(TTCNPAHelper r1, Continuation<? super TTCNPAHelper$initTTCNPA$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
