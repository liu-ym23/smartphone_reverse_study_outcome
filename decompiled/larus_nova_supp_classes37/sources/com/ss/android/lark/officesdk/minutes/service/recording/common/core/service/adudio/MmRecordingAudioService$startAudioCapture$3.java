package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio.ExternalAudioCodec;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public /* synthetic */ class MmRecordingAudioService$startAudioCapture$3 extends FunctionReferenceImpl implements Function1<sub.a, Unit> {
    public MmRecordingAudioService$startAudioCapture$3(Object r8) {
        super(1, r8, MmRecordingAudioService.class, "handleEncodedAudioFrame", "handleEncodedAudioFrame(Lcom/ss/android/lark/officesdk/minutes/api/recording/common/external_audio/ExternalEncodedAudioFrame;)V", 0);
    }

    public final void invoke(sub.a r12) {
        Intrinsics.checkNotNullParameter(r12, "p0");
        MmRecordingAudioService r0 = (MmRecordingAudioService) ((CallableReference) this).receiver;
        int r1 = MmRecordingAudioService.G;
        MmRecordingEncodedAudioProcessor r2 = (MmRecordingEncodedAudioProcessor) r0.w.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r12, "frame");
        r12.getClass();
        if (ExternalAudioCodec.OPUS == null) goto L5;
        lvb.a.h(r2.c, "processEncodedFrameData skip, unsupported codec=null");
        long r3 = r2.i;
    L16:
        if (r3 < 14340000) goto L19;
        lvb.a.h(r0.e, "encoded audio exceed max duration, duration:" + r3);
        r0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k(EndRecordingReason.MAX_LIMIT_TIME));
        return;
    L19:
        if (r3 >= 12540000) goto L21;
    L23:
        long r4 = r3 / 1000;
        if (r4 == r0.p) goto L29;
        r0.p = r4;
        BuildersKt.launch$default(r0.g, null, null, new MmRecordingAudioService$emitAudioDurationIfNeeded$1(r0, r4, null), 3, null);
        return;
    L29:
        return;
    L21:
        if (r0.q == true) goto L23;
        r0.q = true;
        BuildersKt.launch$default(r0.g, null, null, new MmRecordingAudioService$handleEncodedAudioFrame$1(r0, null), 3, null);
        goto L23
    L5:
        r2.i += (long) RangesKt.coerceAtLeast(0, 1);
        Object r13 = r2.f.trySend-JP2dKIU(r12);
        g.c r5 = g.b;
        if ((r13 instanceof g.c) == false) goto L14;
        lvb.a.b(r2.c, "processEncodedFrameData failed to send frame, sequence=null");
        qvb.a r6 = qvb.a.a;
        Throwable r14 = g.a(r13);
        if (r14 == null) goto L10;
        String r15 = r14.getClass().getSimpleName();
    L11:
        if (r15 != null) goto L13;
        r15 = "";
    L13:
        qvb.a.b(null, "encoded_channel_send_failed", r15, null, 9);
        goto L14
    L10:
        r15 = null;
    L14:
        r3 = r2.i;
        goto L16
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((sub.a) r1);
        return Unit.INSTANCE;
    }
}
