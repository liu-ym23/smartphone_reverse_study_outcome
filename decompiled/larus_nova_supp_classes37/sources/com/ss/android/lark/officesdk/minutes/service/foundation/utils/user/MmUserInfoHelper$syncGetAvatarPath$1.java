package com.ss.android.lark.officesdk.minutes.service.foundation.utils.user;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper", f = "MmUserInfoHelper.kt", i = {}, l = {216}, m = "syncGetAvatarPath-yxL6bBk", n = {}, s = {})
public final class MmUserInfoHelper$syncGetAvatarPath$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmUserInfoHelper this$0;

    public MmUserInfoHelper$syncGetAvatarPath$1(MmUserInfoHelper r1, Continuation<? super MmUserInfoHelper$syncGetAvatarPath$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        Object r8 = this.this$0.g(null, null, 0, 0.0f, this);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Result.box-impl(r8);
    }
}
