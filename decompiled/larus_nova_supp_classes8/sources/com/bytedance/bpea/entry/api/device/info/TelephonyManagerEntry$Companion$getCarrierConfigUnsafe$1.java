package com.bytedance.bpea.entry.api.device.info;

import android.os.PersistableBundle;
import android.telephony.TelephonyManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/os/PersistableBundle;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class TelephonyManagerEntry$Companion$getCarrierConfigUnsafe$1 extends Lambda implements Function0<PersistableBundle> {
    final /* synthetic */ TelephonyManager $this_getCarrierConfigUnsafe;

    public TelephonyManagerEntry$Companion$getCarrierConfigUnsafe$1(TelephonyManager r1) {
        this.$this_getCarrierConfigUnsafe = r1;
        super(0);
    }

    public final PersistableBundle invoke() {
        return this.$this_getCarrierConfigUnsafe.getCarrierConfig();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1644invoke() {
        return invoke();
    }
}
