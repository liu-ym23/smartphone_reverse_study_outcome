package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel.GiftEffectConfigurationViewModelForAnchor;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"doStateChange", BuildConfig.FLAVOR, "currentState", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final class GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ GiftEffectConfigurationItemForAnchor this$0;

    public GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$2(GiftEffectConfigurationItemForAnchor r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(boolean r5) {
        GiftEffectConfigurationViewModelForAnchor r0 = this.this$0.b;
        if (r0 == null) goto L5;
        r0.logConfigSetResult(ClickType.NormalGiftEffectSwitch, r5, true);
    L5:
        ay1.d.d.setValue(null, ay1.d.a[5], Boolean.valueOf(r5));
        yz0.k r1 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L11;
        DataCenter r2 = r1.getDataCenter();
        if (r2 == null) goto L12;
        r2.put("cmd_toggle_gift_video_view", Boolean.valueOf(r5));
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
