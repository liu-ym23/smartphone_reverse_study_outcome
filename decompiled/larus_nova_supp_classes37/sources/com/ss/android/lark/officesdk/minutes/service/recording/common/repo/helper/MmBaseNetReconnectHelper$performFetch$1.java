package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper", f = "MmBaseNetReconnectHelper.kt", i = {}, l = {109, 121}, m = "performFetch", n = {}, s = {})
final class MmBaseNetReconnectHelper$performFetch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmBaseNetReconnectHelper this$0;

    public MmBaseNetReconnectHelper$performFetch$1(MmBaseNetReconnectHelper r1, Continuation<? super MmBaseNetReconnectHelper$performFetch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmBaseNetReconnectHelper.a(this.this$0, this);
    }
}
