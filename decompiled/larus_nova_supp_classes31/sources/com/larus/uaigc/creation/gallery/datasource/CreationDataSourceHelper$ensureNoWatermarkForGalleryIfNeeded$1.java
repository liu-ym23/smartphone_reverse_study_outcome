package com.larus.uaigc.creation.gallery.datasource;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.datasource.CreationDataSourceHelper", f = "CreationDataSourceHelper.kt", i = {0}, l = {132}, m = "ensureNoWatermarkForGalleryIfNeeded", n = {"message"}, s = {"L$0"})
public final class CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationDataSourceHelper this$0;

    public CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$1(CreationDataSourceHelper r1, Continuation<? super CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        CreationDataSourceHelper r3 = this.this$0;
        CreationDataSourceHelper r0 = CreationDataSourceHelper.a;
        return r3.b(null, this);
    }
}
