package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationImageUploadPolicy", f = "CreationImageUploadPolicy.kt", i = {}, l = {261}, m = "findReusablePreprocessResult", n = {}, s = {})
public final class CreationImageUploadPolicy$findReusablePreprocessResult$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationImageUploadPolicy this$0;

    public CreationImageUploadPolicy$findReusablePreprocessResult$1(CreationImageUploadPolicy r1, Continuation<? super CreationImageUploadPolicy$findReusablePreprocessResult$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        CreationImageUploadPolicy r3 = this.this$0;
        CreationImageUploadPolicy r0 = CreationImageUploadPolicy.a;
        return r3.c(null, null, this);
    }
}
