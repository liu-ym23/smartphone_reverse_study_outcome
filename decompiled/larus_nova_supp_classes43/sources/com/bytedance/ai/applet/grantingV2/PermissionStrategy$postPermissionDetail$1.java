package com.bytedance.ai.applet.grantingV2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.PermissionStrategy", f = "PermissionStrategy.kt", i = {}, l = {361}, m = "postPermissionDetail", n = {}, s = {})
public final class PermissionStrategy$postPermissionDetail$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PermissionStrategy this$0;

    public PermissionStrategy$postPermissionDetail$1(PermissionStrategy r1, Continuation<? super PermissionStrategy$postPermissionDetail$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        PermissionStrategy r11 = this.this$0;
        int r0 = PermissionStrategy.d;
        return r11.m(null, null, null, this);
    }
}
