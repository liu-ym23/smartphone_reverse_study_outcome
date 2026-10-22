package com.ss.android.lark.passport.flow.core.network;

import com.ss.android.lark.passport.PassportApmEvent;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/apm/config/EventConfig;", "Lcom/ss/android/lark/passport/PassportApmEvent;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class FlowPassportUserFetcher$fetch$2 extends Lambda implements Function1<PassportApmEvent, com.bytedance.apm.config.d> {
    public static final FlowPassportUserFetcher$fetch$2 INSTANCE = null;

    static {
        INSTANCE = new FlowPassportUserFetcher$fetch$2();
    }

    public FlowPassportUserFetcher$fetch$2() {
        super(1);
    }

    public final com.bytedance.apm.config.d invoke(PassportApmEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$monitor");
        r2.getClass();
        return PassportApmEvent.y("/accounts/web/user");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((PassportApmEvent) r1);
    }
}
