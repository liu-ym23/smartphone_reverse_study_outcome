package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/EffectSwitchStatus;", BuildConfig.FLAVOR, "OPEN", "CLOSE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EffectSwitchStatus extends Enum<EffectSwitchStatus> {
    public static final EffectSwitchStatus CLOSE = null;
    public static final EffectSwitchStatus OPEN = null;
    public static final /* synthetic */ EffectSwitchStatus[] a = null;

    static {
        EffectSwitchStatus r1 = new EffectSwitchStatus("OPEN", 0);
        OPEN = r1;
        EffectSwitchStatus r2 = new EffectSwitchStatus("CLOSE", 1);
        CLOSE = r2;
        a = new EffectSwitchStatus[]{r1, r2};
    }

    public static EffectSwitchStatus valueOf(String r1) {
        return (EffectSwitchStatus) r27.a.a(EffectSwitchStatus.class, r1);
    }

    public static EffectSwitchStatus[] values() {
        return (EffectSwitchStatus[]) a.clone();
    }

    public EffectSwitchStatus(String r1, int r2) {
        super(r1, r2);
    }
}
