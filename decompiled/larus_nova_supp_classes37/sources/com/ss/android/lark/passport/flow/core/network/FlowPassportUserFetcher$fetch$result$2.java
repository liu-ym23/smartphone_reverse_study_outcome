package com.ss.android.lark.passport.flow.core.network;

import com.ss.android.lark.passport.PassportApmEvent;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/apm/config/EventConfig;", "Lcom/ss/android/lark/passport/PassportApmEvent;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class FlowPassportUserFetcher$fetch$result$2 extends Lambda implements Function1<PassportApmEvent, com.bytedance.apm.config.d> {
    final /* synthetic */ Ref.ObjectRef<Integer> $httpCode;
    final /* synthetic */ Ref.ObjectRef<String> $logId;
    final /* synthetic */ long $startTime;

    public FlowPassportUserFetcher$fetch$result$2(long r1, Ref.ObjectRef<Integer> r3, Ref.ObjectRef<String> r4) {
        this.$startTime = r1;
        this.$httpCode = r3;
        this.$logId = r4;
        super(1);
    }

    public final com.bytedance.apm.config.d invoke(PassportApmEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$monitor");
        long r3 = System.currentTimeMillis() - this.$startTime;
        Integer r5 = (Integer) this.$httpCode.element;
        String r6 = (String) this.$logId.element;
        r8.getClass();
        return PassportApmEvent.x("/accounts/web/user", false, r3, r5, r6);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((PassportApmEvent) r1);
    }
}
