package com.ss.android.lark.officesdk.launcher.load;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.OfficeBizType;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class OfficeLoadCoordinator$finishWarmupFailed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OfficeBizType $bizType;
    final /* synthetic */ OfficeLoadCoordinator.a $key;
    final /* synthetic */ String $reason;

    public OfficeLoadCoordinator$finishWarmupFailed$1(OfficeBizType r1, String r2, OfficeLoadCoordinator.a r3) {
        this.$bizType = r1;
        this.$reason = r2;
        this.$key = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m145invoke() {
        Log.e("OfficeLoadCoordinator", "warmup failed, bizType=" + this.$bizType + ", reason=" + this.$reason);
        OfficeLoadCoordinator.e.put(this.$key, OfficeLoadCoordinator.ExecuteState.FAILED);
        IOfficeSDKLifeCycle r0 = OfficeSDKManager.getLifeCycle();
        if (r0 == null) goto L6;
        r0.onWarmupFailed(this.$bizType, this.$reason);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m145invoke();
        return Unit.INSTANCE;
    }
}
