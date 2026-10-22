package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper", f = "MmRecordingNetHelper.kt", i = {}, l = {577}, m = "reportUpgradeEvent-hUnOzRk", n = {}, s = {})
public final class MmRecordingNetHelper$reportUpgradeEvent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$reportUpgradeEvent$1(MmRecordingNetHelper r1, Continuation<? super MmRecordingNetHelper$reportUpgradeEvent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        Object r9 = this.this$0.u(null, null, null, null, null, this);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Result.box-impl(r9);
    }
}
