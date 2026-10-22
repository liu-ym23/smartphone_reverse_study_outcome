package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaType;
import com.ss.android.lark.picker.base.view.ItemViewType;
import jvb.i;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper$reportUpgradeEvent$2", f = "MmRecordingNetHelper.kt", i = {}, l = {578}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingNetHelper$reportUpgradeEvent$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ String $billFeatureKey;
    final /* synthetic */ String $licensePlanKey;
    final /* synthetic */ String $objectToken;
    final /* synthetic */ MmQuotaType $quotaType;
    final /* synthetic */ MmRecordingSource $source;
    int label;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$reportUpgradeEvent$2(MmRecordingNetHelper r1, String r2, MmQuotaType r3, String r4, String r5, MmRecordingSource r6, Continuation<? super MmRecordingNetHelper$reportUpgradeEvent$2> r7) {
        this.this$0 = r1;
        this.$objectToken = r2;
        this.$quotaType = r3;
        this.$billFeatureKey = r4;
        this.$licensePlanKey = r5;
        this.$source = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new MmRecordingNetHelper$reportUpgradeEvent$2(this.this$0, this.$objectToken, this.$quotaType, this.$billFeatureKey, this.$licensePlanKey, this.$source, r10);
    }

    public final Object invoke(int r1, Continuation<? super Result<Unit>> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) r11).unbox-impl();
    L12:
        if (Result.isSuccess-impl(r12) == false) goto L15;
        String r13 = (String) r12;
        r12 = Unit.INSTANCE;
    L15:
        return Result.box-impl(Result.constructor-impl(r12));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MmMockAwareRequestService r14 = this.this$0.a.M();
        i r9 = new i(this.$objectToken, String.valueOf(this.$quotaType.getValue()), this.$billFeatureKey, this.$licensePlanKey, this.$source);
        this.label = 1;
        r12 = r14.c(String.class, r9, this);
        if (r12 != r0) goto L12;
        return r0;
    }
}
