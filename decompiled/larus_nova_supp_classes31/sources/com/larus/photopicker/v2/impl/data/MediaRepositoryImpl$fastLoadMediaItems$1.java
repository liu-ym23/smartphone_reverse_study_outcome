package com.larus.photopicker.v2.impl.data;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.photopicker.v2.impl.data.MediaRepositoryImpl", f = "MediaRepositoryImpl.kt", i = {}, l = {50}, m = "fastLoadMediaItems", n = {}, s = {})
public final class MediaRepositoryImpl$fastLoadMediaItems$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaRepositoryImpl this$0;

    public MediaRepositoryImpl$fastLoadMediaItems$1(MediaRepositoryImpl r1, Continuation<? super MediaRepositoryImpl$fastLoadMediaItems$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(0, 0, null, this);
    }
}
