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
public final class GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$1 extends Lambda implements Function1<Switch, Unit> {
    final /* synthetic */ boolean $isAnchor;

    public GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$1(boolean r1) {
        this.$isAnchor = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Switch) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Switch r5) {
        Intrinsics.checkNotNullParameter(r5, "switch");
        if (this.$isAnchor == false) goto L5;
        boolean r0 = ((Boolean) ay1.b.V.getValue(null, ay1.b.a[59])).booleanValue();
    L6:
        r5.setChecked(r0);
        return;
    L5:
        r0 = ((Boolean) ay1.b.U.getValue(null, ay1.b.a[58])).booleanValue();
        goto L6
    }
}
