package com.ss.android.lark.integrator.im.impl;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.integrator.im.impl.IIMUserServiceImpl", f = "IIMUserServiceImpl.kt", i = {}, l = {275}, m = "getHumanFeedDisplayItem-IoAF18A", n = {}, s = {})
public final class IIMUserServiceImpl$getHumanFeedDisplayItem$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IIMUserServiceImpl this$0;

    public IIMUserServiceImpl$getHumanFeedDisplayItem$1(IIMUserServiceImpl r1, Continuation<? super IIMUserServiceImpl$getHumanFeedDisplayItem$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        Object r3 = this.this$0.ma(this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
