package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.passport.PassportApmEvent;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/apm/config/EventConfig;", "Lcom/ss/android/lark/passport/PassportApmEvent;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class FlowMfaFlowSession$reportFactorCancel$1 extends Lambda implements Function1<PassportApmEvent, com.bytedance.apm.config.d> {
    final /* synthetic */ a0 $reportInfo;

    public FlowMfaFlowSession$reportFactorCancel$1(a0 r1) {
        this.$reportInfo = r1;
        super(1);
    }

    public final com.bytedance.apm.config.d invoke(PassportApmEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$monitor");
        a0 r0 = this.$reportInfo;
        String r1 = r0.a;
        String r2 = r0.b;
        String r3 = r0.c;
        String r4 = r0.d;
        String r5 = r0.e;
        r6.getClass();
        return PassportApmEvent.t(r1, r2, r3, r4, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((PassportApmEvent) r1);
    }
}
