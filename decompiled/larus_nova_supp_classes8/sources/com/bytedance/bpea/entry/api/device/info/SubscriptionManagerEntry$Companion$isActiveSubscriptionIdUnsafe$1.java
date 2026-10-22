package com.bytedance.bpea.entry.api.device.info;

import android.telephony.SubscriptionManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class SubscriptionManagerEntry$Companion$isActiveSubscriptionIdUnsafe$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ int $subscriptionId;
    final /* synthetic */ SubscriptionManager $this_isActiveSubscriptionIdUnsafe;

    public SubscriptionManagerEntry$Companion$isActiveSubscriptionIdUnsafe$1(SubscriptionManager r1, int r2) {
        this.$this_isActiveSubscriptionIdUnsafe = r1;
        this.$subscriptionId = r2;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m1635invoke());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m1635invoke() {
        return this.$this_isActiveSubscriptionIdUnsafe.isActiveSubscriptionId(this.$subscriptionId);
    }
}
