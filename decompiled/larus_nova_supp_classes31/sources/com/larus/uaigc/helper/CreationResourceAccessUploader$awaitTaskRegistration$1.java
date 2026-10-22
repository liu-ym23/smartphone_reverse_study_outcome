package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationResourceAccessUploader", f = "CreationResourceAccessUploader.kt", i = {0, 0, 0, 0, 0}, l = {140}, m = "awaitTaskRegistration", n = {"scene", "mediaType", "bizScope", "identifier", "deadlineMs"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
public final class CreationResourceAccessUploader$awaitTaskRegistration$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationResourceAccessUploader this$0;

    public CreationResourceAccessUploader$awaitTaskRegistration$1(CreationResourceAccessUploader r1, Continuation<? super CreationResourceAccessUploader$awaitTaskRegistration$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, null, null, this);
    }
}
