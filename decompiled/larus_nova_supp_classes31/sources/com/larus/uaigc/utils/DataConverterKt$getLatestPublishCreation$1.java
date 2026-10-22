package com.larus.uaigc.utils;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.utils.DataConverterKt", f = "DataConverter.kt", i = {0}, l = {53}, m = "getLatestPublishCreation", n = {"creationTaskId"}, s = {"L$0"})
public final class DataConverterKt$getLatestPublishCreation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public DataConverterKt$getLatestPublishCreation$1(Continuation<? super DataConverterKt$getLatestPublishCreation$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DataConverterKt.e(null, null, this);
    }
}
