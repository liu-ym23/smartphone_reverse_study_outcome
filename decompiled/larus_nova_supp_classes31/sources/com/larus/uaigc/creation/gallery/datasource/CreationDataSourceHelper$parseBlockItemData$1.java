package com.larus.uaigc.creation.gallery.datasource;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.datasource.CreationDataSourceHelper", f = "CreationDataSourceHelper.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {603, 785}, m = "parseBlockItemData", n = {"creationContext", "list", "desc", "creationStatus", "$this$parseBlockItemData_u24lambda_u2457", "msg", "creationContext", "list", "desc", "creationStatus", "$this$parseBlockItemData_u24lambda_u2457", "msg", "params", "canvasInfo", "destination$iv$iv", "creationItem", "noWatermarkSelected", "finalDesc", "index$iv$iv$iv", "index"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "I$0", "I$1"})
public final class CreationDataSourceHelper$parseBlockItemData$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
    Object L$18;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationDataSourceHelper this$0;

    public CreationDataSourceHelper$parseBlockItemData$1(CreationDataSourceHelper r1, Continuation<? super CreationDataSourceHelper$parseBlockItemData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        CreationDataSourceHelper r0 = this.this$0;
        CreationDataSourceHelper r9 = CreationDataSourceHelper.a;
        return r0.i(null, null, null, null, null, this);
    }
}
