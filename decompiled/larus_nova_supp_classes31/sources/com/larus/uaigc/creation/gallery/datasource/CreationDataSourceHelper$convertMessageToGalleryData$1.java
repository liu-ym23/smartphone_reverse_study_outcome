package com.larus.uaigc.creation.gallery.datasource;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.datasource.CreationDataSourceHelper", f = "CreationDataSourceHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7}, l = {95, 100, 103, 106, 109, 112, 115, 119}, m = "convertMessageToGalleryData", n = {"creationContext", "message", "$this$convertMessageToGalleryData_u24lambda_u240", "list", "creationContext", "message", "$this$convertMessageToGalleryData_u24lambda_u240", "list", "desc", "creationContext", "message", "list", "desc", "creationStatus", "list", "list", "list", "list", "list"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$0", "L$0", "L$0", "L$0"})
public final class CreationDataSourceHelper$convertMessageToGalleryData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationDataSourceHelper this$0;

    public CreationDataSourceHelper$convertMessageToGalleryData$1(CreationDataSourceHelper r1, Continuation<? super CreationDataSourceHelper$convertMessageToGalleryData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
