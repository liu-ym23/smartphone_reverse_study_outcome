package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl", f = "UserManagerImpl.kt", i = {0}, l = {568}, m = "awaitUserApiForSession$officesdk_core_release", n = {"timeoutMs"}, s = {"J$0"})
public final class UserManagerImpl$awaitUserApiForSession$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserManagerImpl this$0;

    public UserManagerImpl$awaitUserApiForSession$1(UserManagerImpl r1, Continuation<? super UserManagerImpl$awaitUserApiForSession$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, 0, this);
    }
}
