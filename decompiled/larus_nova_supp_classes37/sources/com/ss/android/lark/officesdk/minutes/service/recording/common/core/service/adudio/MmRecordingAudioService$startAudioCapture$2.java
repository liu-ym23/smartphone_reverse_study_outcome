package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmRtcWrapper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public /* synthetic */ class MmRecordingAudioService$startAudioCapture$2 extends FunctionReferenceImpl implements Function1<sub.a, Unit> {
    public MmRecordingAudioService$startAudioCapture$2(Object r8) {
        super(1, r8, MmRtcWrapper.class, "pushExternalEncodedAudioFrame", "pushExternalEncodedAudioFrame(Lcom/ss/android/lark/officesdk/minutes/api/recording/common/external_audio/ExternalEncodedAudioFrame;)V", 0);
    }

    public final void invoke(sub.a r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((MmRtcWrapper) ((CallableReference) this).receiver).i(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((sub.a) r1);
        return Unit.INSTANCE;
    }
}
