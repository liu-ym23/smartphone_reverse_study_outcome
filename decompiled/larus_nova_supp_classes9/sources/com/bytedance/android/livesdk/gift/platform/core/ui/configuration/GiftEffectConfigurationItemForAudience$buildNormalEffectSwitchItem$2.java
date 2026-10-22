package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.widget.Switch;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"onCheckStateChanged", BuildConfig.FLAVOR, "switch", "Landroid/widget/Switch;", "invoke"}, k = 3, mv = {1, 4, 3})
final class GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$2 extends Lambda implements Function1<Switch, Unit> {
    final /* synthetic */ GiftEffectConfigurationItemForAudience this$0;

    public GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$2(GiftEffectConfigurationItemForAudience r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(Switch r5) {
        Intrinsics.checkNotNullParameter(r5, "switch");
        boolean r6 = r5.isChecked();
        if (this.this$0.a == null) goto L5;
        ay1.b.T.setValue(null, ay1.b.a[57], Boolean.valueOf(r6));
    L5:
        int r0 = p.a;
        p.e("gift_effect_switch", Boolean.valueOf(r6));
        yz0.k r1 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L11;
        DataCenter r2 = r1.getDataCenter();
        if (r2 == null) goto L12;
        r2.put("cmd_gift_effect_is_open", Boolean.valueOf(r6));
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Switch) r1);
        return Unit.INSTANCE;
    }
}
