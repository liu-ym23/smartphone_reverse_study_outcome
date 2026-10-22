package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmUploadLocationResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import jvb.o;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/request/http/MmUploadLocationResponse;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper$uploadMMLocation$2", f = "MmRecordingNetHelper.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingNetHelper$uploadMMLocation$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends MmUploadLocationResponse>>, Object> {
    final /* synthetic */ double $latitude;
    final /* synthetic */ String $location;
    final /* synthetic */ String $locationIdentity;
    final /* synthetic */ double $longitude;
    final /* synthetic */ MmRecordingSource $source;
    final /* synthetic */ boolean $useRecordingApi;
    int label;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$uploadMMLocation$2(MmRecordingNetHelper r1, String r2, double r3, double r5, String r7, MmRecordingSource r8, boolean r9, Continuation<? super MmRecordingNetHelper$uploadMMLocation$2> r10) {
        this.this$0 = r1;
        this.$locationIdentity = r2;
        this.$latitude = r3;
        this.$longitude = r5;
        this.$location = r7;
        this.$source = r8;
        this.$useRecordingApi = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new MmRecordingNetHelper$uploadMMLocation$2(this.this$0, this.$locationIdentity, this.$latitude, this.$longitude, this.$location, this.$source, this.$useRecordingApi, r13);
    }

    public final Object invoke(int r1, Continuation<? super Result<MmUploadLocationResponse>> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
        Object r15 = ((Result) r14).unbox-impl();
    L12:
        return Result.box-impl(r15);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        MmMockAwareRequestService r16 = this.this$0.a.M();
        o r12 = new o(this.$locationIdentity, this.$latitude, this.$longitude, this.$location, this.$source, this.$useRecordingApi);
        this.label = 1;
        r15 = r16.c(MmUploadLocationResponse.class, r12, this);
        if (r15 != r0) goto L12;
        return r0;
    }
}
