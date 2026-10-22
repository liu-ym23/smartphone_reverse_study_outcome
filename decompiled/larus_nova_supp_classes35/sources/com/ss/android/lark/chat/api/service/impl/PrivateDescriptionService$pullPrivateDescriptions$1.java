package com.ss.android.lark.chat.api.service.impl;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.api.service.impl.PrivateDescriptionService", f = "PrivateDescriptionService.kt", i = {0, 0}, l = {44}, m = "pullPrivateDescriptions-BWLJW6A", n = {"source", "validUserIds"}, s = {"L$0", "L$1"})
public final class PrivateDescriptionService$pullPrivateDescriptions$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PrivateDescriptionService this$0;

    public PrivateDescriptionService$pullPrivateDescriptions$1(PrivateDescriptionService r1, Continuation<? super PrivateDescriptionService$pullPrivateDescriptions$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        Object r3 = this.this$0.S0(null, null, null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
