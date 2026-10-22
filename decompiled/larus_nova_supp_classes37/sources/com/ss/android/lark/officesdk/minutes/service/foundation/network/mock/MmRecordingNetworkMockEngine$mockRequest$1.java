package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmRecordingNetworkMockEngine", f = "MmRecordingNetworkMockEngine.kt", i = {0, 0, 0}, l = {130}, m = "mockRequest", n = {"context", "respType", "scenario"}, s = {"L$0", "L$1", "L$2"})
final class MmRecordingNetworkMockEngine$mockRequest$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ g this$0;

    public MmRecordingNetworkMockEngine$mockRequest$1(g r1, Continuation<? super MmRecordingNetworkMockEngine$mockRequest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        g r3 = this.this$0;
        g.a r0 = g.h;
        return r3.b(null, this);
    }
}
