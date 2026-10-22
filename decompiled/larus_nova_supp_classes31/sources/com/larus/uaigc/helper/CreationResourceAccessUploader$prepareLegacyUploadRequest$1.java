package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationResourceAccessUploader", f = "CreationResourceAccessUploader.kt", i = {0, 0, 1, 1}, l = {521, 560}, m = "prepareLegacyUploadRequest", n = {"request", "resourceInput", "request", "resourceInput"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class CreationResourceAccessUploader$prepareLegacyUploadRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationResourceAccessUploader this$0;

    public CreationResourceAccessUploader$prepareLegacyUploadRequest$1(CreationResourceAccessUploader r1, Continuation<? super CreationResourceAccessUploader$prepareLegacyUploadRequest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationResourceAccessUploader.a(this.this$0, null, this);
    }
}
