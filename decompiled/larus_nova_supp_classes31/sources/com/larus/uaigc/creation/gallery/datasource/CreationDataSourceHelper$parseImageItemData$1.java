package com.larus.uaigc.creation.gallery.datasource;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.datasource.CreationDataSourceHelper", f = "CreationDataSourceHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {209}, m = "parseImageItemData", n = {"creationContext", "list", "desc", "creationStatus", "$this$parseImageItemData_u24lambda_u247", "getTemplateByIndex", "item", "index$iv", "index"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$8", "I$0", "I$1"})
public final class CreationDataSourceHelper$parseImageItemData$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationDataSourceHelper this$0;

    public CreationDataSourceHelper$parseImageItemData$1(CreationDataSourceHelper r1, Continuation<? super CreationDataSourceHelper$parseImageItemData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        CreationDataSourceHelper r0 = this.this$0;
        CreationDataSourceHelper r9 = CreationDataSourceHelper.a;
        return r0.j(null, null, null, null, null, this);
    }
}
