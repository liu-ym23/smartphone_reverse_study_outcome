package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.MmCustomExceptionKt;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper", f = "MmRecordingNetHelper.kt", i = {}, l = {543}, m = "setHardwareDefaultAudioSaveOption-gIAlu-s", n = {}, s = {})
final class MmRecordingNetHelper$setHardwareDefaultAudioSaveOption$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$setHardwareDefaultAudioSaveOption$1(MmRecordingNetHelper r1, Continuation<? super MmRecordingNetHelper$setHardwareDefaultAudioSaveOption$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        MmRecordingNetHelper r8 = this.this$0;
        r8.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        MmRecordingNetHelper$setHardwareDefaultAudioSaveOption$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L12;
        if (r4 != 1) goto L11;
        ResultKt.throwOnFailure(r2);
        Object r9 = ((Result) r2).unbox-impl();
    L15:
        r3 = r9;
    L17:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r3;
    L20:
        return Result.box-impl(r3);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r2);
        MmRecordingNetHelper$setHardwareDefaultAudioSaveOption$2 r5 = new MmRecordingNetHelper$setHardwareDefaultAudioSaveOption$2(r8, false, null);
        r0.label = 1;
        r9 = MmCustomExceptionKt.a(3, r5, r0);
        if (r9 != r3) goto L15;
    L5:
        r0 = new MmRecordingNetHelper$setHardwareDefaultAudioSaveOption$1(r8, this);
        goto L6
    }
}
