package com.larus.uaigc.createpage;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationTypeSelectDialog", f = "CreationTypeSelectDialog.kt", i = {0, 0, 0}, l = {688, 701}, m = "handleOpenSchema", n = {"item", "mainBotId", "conversationId"}, s = {"L$0", "L$1", "L$2"})
final class CreationTypeSelectDialog$handleOpenSchema$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationTypeSelectDialog this$0;

    public CreationTypeSelectDialog$handleOpenSchema$1(CreationTypeSelectDialog r1, Continuation<? super CreationTypeSelectDialog$handleOpenSchema$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationTypeSelectDialog.S90(this.this$0, null, this);
    }
}
