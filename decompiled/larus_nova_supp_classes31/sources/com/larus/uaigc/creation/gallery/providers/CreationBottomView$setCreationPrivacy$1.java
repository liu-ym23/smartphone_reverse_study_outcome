package com.larus.uaigc.creation.gallery.providers;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationBottomView", f = "CreationBottomView.kt", i = {1, 1, 1, 1, 2, 2, 2}, l = {578, 595, 615, 619}, m = "setCreationPrivacy", n = {"private", "previousStatus", "privateStatus", "buttonStatus", "previousStatus", "privateStatus", "buttonStatus"}, s = {"Z$0", "I$0", "I$1", "I$2", "I$0", "I$1", "I$2"})
final class CreationBottomView$setCreationPrivacy$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationBottomView this$0;

    public CreationBottomView$setCreationPrivacy$1(CreationBottomView r1, Continuation<? super CreationBottomView$setCreationPrivacy$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationBottomView.V5(this.this$0, false, this);
    }
}
