package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ovb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "data"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeTokenState$1$1$1$1", f = "MmRecordingRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingRepo$subscribeTokenState$1$1$1$1 extends SuspendLambda implements Function2<b, Continuation<? super b>, Object> {
    final /* synthetic */ MmCreateAudioResponse $it;
    /* synthetic */ Object L$0;
    int label;

    public MmRecordingRepo$subscribeTokenState$1$1$1$1(MmCreateAudioResponse r1, Continuation<? super MmRecordingRepo$subscribeTokenState$1$1$1$1> r2) {
        this.$it = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingRepo$subscribeTokenState$1$1$1$1 r0 = new MmRecordingRepo$subscribeTokenState$1$1$1$1(this.$it, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public final Object invoke(b r1, Continuation<? super b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r11);
        return b.a((b) this.L$0, null, 0, null, this.$it.getObjectToken(), null, null, false, 247);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
