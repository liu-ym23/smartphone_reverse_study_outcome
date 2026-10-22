package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "rtcService", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/rtc/IOfficeSDKRtcService;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmRtcWrapper$setBandWidthJson$1 extends Lambda implements Function1<nub.b, Unit> {
    final /* synthetic */ JSONObject $input;

    public MmRtcWrapper$setBandWidthJson$1(JSONObject r1) {
        this.$input = r1;
        super(1);
    }

    public final void invoke(nub.b r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcService");
        r2.x(this.$input);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((nub.b) r1);
        return Unit.INSTANCE;
    }
}
