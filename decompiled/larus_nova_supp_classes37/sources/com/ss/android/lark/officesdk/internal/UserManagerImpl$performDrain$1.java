package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl", f = "UserManagerImpl.kt", i = {0}, l = {406}, m = "performDrain-0E7RQCE", n = {"uid"}, s = {"L$0"})
public final class UserManagerImpl$performDrain$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserManagerImpl this$0;

    public UserManagerImpl$performDrain$1(UserManagerImpl r1, Continuation<? super UserManagerImpl$performDrain$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        UserManagerImpl r3 = this.this$0;
        int r0 = UserManagerImpl.q;
        Object r4 = r3.k(null, null, this);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Result.box-impl(r4);
    }
}
