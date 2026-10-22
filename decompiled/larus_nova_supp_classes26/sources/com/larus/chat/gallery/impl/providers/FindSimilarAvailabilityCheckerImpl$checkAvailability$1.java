package com.larus.chat.gallery.impl.providers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.providers.FindSimilarAvailabilityCheckerImpl", f = "FindSimilarAvailabilityCheckerImpl.kt", i = {0}, l = {54}, m = "checkAvailability", n = {"imageUri"}, s = {"L$0"})
public final class FindSimilarAvailabilityCheckerImpl$checkAvailability$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FindSimilarAvailabilityCheckerImpl this$0;

    public FindSimilarAvailabilityCheckerImpl$checkAvailability$1(FindSimilarAvailabilityCheckerImpl r1, Continuation<? super FindSimilarAvailabilityCheckerImpl$checkAvailability$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
