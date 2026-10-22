package com.bytedance.ai.applet.grantingV2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.PermissionStrategy", f = "PermissionStrategy.kt", i = {0, 1, 2, 2, 2, 3, 3, 3}, l = {174, 176, 202, 204}, m = "handlePendingOrRefusedStatus", n = {"context", "context", "context", "meta", "isHistory", "context", "meta", "isHistory"}, s = {"L$0", "L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
final class PermissionStrategy$handlePendingOrRefusedStatus$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PermissionStrategy this$0;

    public PermissionStrategy$handlePendingOrRefusedStatus$1(PermissionStrategy r1, Continuation<? super PermissionStrategy$handlePendingOrRefusedStatus$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        PermissionStrategy r0 = this.this$0;
        int r11 = PermissionStrategy.d;
        return r0.l(null, null, null, false, false, this);
    }
}
