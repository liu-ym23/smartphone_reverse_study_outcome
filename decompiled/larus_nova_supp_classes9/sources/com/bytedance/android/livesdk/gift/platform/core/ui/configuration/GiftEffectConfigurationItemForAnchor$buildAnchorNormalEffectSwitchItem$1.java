package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.widget.Switch;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"initialCheckStatus", BuildConfig.FLAVOR, "switch", "Landroid/widget/Switch;", "invoke"}, k = 3, mv = {1, 4, 3})
final class GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$1 extends Lambda implements Function1<Switch, Unit> {
    public static final GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$1 INSTANCE = null;

    static {
        INSTANCE = new GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$1();
    }

    public GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$1() {
        super(1);
    }

    public final void invoke(Switch r2) {
        Intrinsics.checkNotNullParameter(r2, "switch");
        r2.setChecked(ay1.d.b());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Switch) r1);
        return Unit.INSTANCE;
    }
}
