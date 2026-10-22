package com.larus.uaigc.creation.gallery.datasource;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.datasource.CreationDataSourceHelper", f = "CreationDataSourceHelper.kt", i = {0, 0, 0, 0}, l = {270}, m = "getSingleParams", n = {"message", "creationTaskId", "isImage", "isMixed"}, s = {"L$0", "L$1", "Z$0", "Z$1"})
public final class CreationDataSourceHelper$getSingleParams$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationDataSourceHelper this$0;

    public CreationDataSourceHelper$getSingleParams$1(CreationDataSourceHelper r1, Continuation<? super CreationDataSourceHelper$getSingleParams$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        CreationDataSourceHelper r0 = this.this$0;
        CreationDataSourceHelper r9 = CreationDataSourceHelper.a;
        return r0.g(null, null, false, false, null, this);
    }
}
