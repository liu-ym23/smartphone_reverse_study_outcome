package com.ss.android.lark.passport.flow.core.network;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.core.network.FlowPassportUserFetcher", f = "FlowPassportUserFetcher.kt", i = {0, 0, 0}, l = {ItemViewType.ITEM_VIEW_TYPE_RECOMMEND_HISTORY_HEADER}, m = "fetch-gIAlu-s", n = {"httpCode", "logId", "startTime"}, s = {"L$0", "L$1", "J$0"})
final class FlowPassportUserFetcher$fetch$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public FlowPassportUserFetcher$fetch$1(d r1, Continuation<? super FlowPassportUserFetcher$fetch$1> r2) {
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
