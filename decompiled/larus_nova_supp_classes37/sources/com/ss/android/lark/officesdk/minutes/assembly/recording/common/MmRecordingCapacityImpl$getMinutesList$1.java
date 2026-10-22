package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMinutesListItem;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMinutesListResult;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmMinutesItem;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmMinutesListResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl", f = "MmRecordingCapacityImpl.kt", i = {}, l = {859}, m = "getMinutesList-0E7RQCE", n = {}, s = {})
final class MmRecordingCapacityImpl$getMinutesList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$getMinutesList$1(MmRecordingCapacityImpl r1, Continuation<? super MmRecordingCapacityImpl$getMinutesList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.ArrayList] */
    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        MmRecordingCapacityImpl r12 = this.this$0;
        r12.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        MmRecordingCapacityImpl$getMinutesList$1 r0 = this;
    L6:
        Object r2 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 != 0) goto L9;
        ResultKt.throwOnFailure(r2);
        lvb.a.e(r12.d, "[getMinutesList] timestamp=null, size=0");
        Intrinsics.checkNotNullParameter(null, "timestamp");
        throw null;
    L9:
        if (r3 != 1) goto L31;
        ResultKt.throwOnFailure(r2);
        Object r13 = ((Result) r2).unbox-impl();
        if (Result.isSuccess-impl(r13) == false) goto L24;
        MmMinutesListResponse r14 = (MmMinutesListResponse) r13;
        List<MmMinutesItem> r4 = r14.getList();
        if (r4 == null) goto L18;
        List<MmMinutesItem> r5 = r4;
        ?? r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L16:
        if (r7.hasNext() == false) goto L19;
        MmMinutesItem r8 = (MmMinutesItem) r7.next();
        r6.add(new MmMinutesListItem(r8.getTopic(), r8.getDuration(), r8.getStatus(), r8.getUrl(), r8.getCreateTime()));
    L19:
        Boolean r15 = r14.getHasMore();
        if (r15 == null) goto L22;
        boolean r16 = r15.booleanValue();
    L23:
        Object r17 = Result.constructor-impl(new MmMinutesListResult(r6, r16));
    L26:
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        return r17;
    L29:
        return Result.box-impl(r17);
    L22:
        r16 = false;
        goto L23
    L18:
        r6 = CollectionsKt.emptyList();
        goto L19
    L24:
        r17 = Result.constructor-impl(r13);
        goto L26
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new MmRecordingCapacityImpl$getMinutesList$1(r12, this);
        goto L6
    }
}
