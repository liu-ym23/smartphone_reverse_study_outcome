package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmRtcWrapper$startAudioCapture$1 extends Lambda implements Function1<Throwable, Unit> {
    public static final MmRtcWrapper$startAudioCapture$1 INSTANCE = null;

    static {
        INSTANCE = new MmRtcWrapper$startAudioCapture$1();
    }

    public MmRtcWrapper$startAudioCapture$1() {
        super(1);
    }

    public final void invoke(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }
}
