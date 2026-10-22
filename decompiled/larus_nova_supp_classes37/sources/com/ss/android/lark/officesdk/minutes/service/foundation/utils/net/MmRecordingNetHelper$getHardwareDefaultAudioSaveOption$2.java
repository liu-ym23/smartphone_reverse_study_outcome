package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.picker.base.view.ItemViewType;
import jvb.f;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/request/http/MmHardwareDefaultAudioSaveResponse;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper$getHardwareDefaultAudioSaveOption$2", f = "MmRecordingNetHelper.kt", i = {}, l = {535}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingNetHelper$getHardwareDefaultAudioSaveOption$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends f>>, Object> {
    int label;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$getHardwareDefaultAudioSaveOption$2(MmRecordingNetHelper r1, Continuation<? super MmRecordingNetHelper$getHardwareDefaultAudioSaveOption$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingNetHelper$getHardwareDefaultAudioSaveOption$2(this.this$0, r3);
    }

    public final Object invoke(int r1, Continuation<? super Result<f>> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L12:
        return Result.box-impl(r6);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MmMockAwareRequestService r7 = this.this$0.a.M();
        jvb.b r3 = new jvb.b();
        this.label = 1;
        r6 = r7.c(f.class, r3, this);
        if (r6 != r0) goto L12;
        return r0;
    }
}
