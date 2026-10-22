package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeTokenState$1$1", f = "MmRecordingRepo.kt", i = {0}, l = {262}, m = "emit", n = {"it"}, s = {"L$2"})
public final class MmRecordingRepo$subscribeTokenState$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingRepo$subscribeTokenState$1.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingRepo$subscribeTokenState$1$1$emit$1(MmRecordingRepo$subscribeTokenState$1.AnonymousClass1<? super T> r1, Continuation<? super MmRecordingRepo$subscribeTokenState$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
