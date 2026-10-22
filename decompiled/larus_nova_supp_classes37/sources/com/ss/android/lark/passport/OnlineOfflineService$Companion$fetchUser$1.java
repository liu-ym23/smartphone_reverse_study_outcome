package com.ss.android.lark.passport;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.OnlineOfflineService$Companion", f = "OnlineOfflineService.kt", i = {0, 0, 0, 0}, l = {84}, m = "fetchUser-gIAlu-s", n = {AppbrandHostConstants.Schema_RESERVED_FIELD.PATH, "logId", "httpCode", "startTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
public final class OnlineOfflineService$Companion$fetchUser$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnlineOfflineService.Companion this$0;

    public OnlineOfflineService$Companion$fetchUser$1(OnlineOfflineService.Companion r1, Continuation<? super OnlineOfflineService$Companion$fetchUser$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.a(null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
