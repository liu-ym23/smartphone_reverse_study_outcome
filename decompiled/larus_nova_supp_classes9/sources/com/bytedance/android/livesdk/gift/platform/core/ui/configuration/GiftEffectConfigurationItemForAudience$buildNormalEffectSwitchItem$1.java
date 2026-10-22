package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.widget.Switch;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i2;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"initialCheckStatus", BuildConfig.FLAVOR, "switch", "Landroid/widget/Switch;", "invoke"}, k = 3, mv = {1, 4, 3})
final class GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$1 extends Lambda implements Function1<Switch, Unit> {
    final /* synthetic */ GiftEffectConfigurationItemForAudience this$0;

    public GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$1(GiftEffectConfigurationItemForAudience r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(Switch r2) {
        Intrinsics.checkNotNullParameter(r2, "switch");
        if (this.this$0.a == null) goto L5;
        boolean r0 = i2.d();
    L6:
        r2.setChecked(r0);
        return;
    L5:
        r0 = true;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Switch) r1);
        return Unit.INSTANCE;
    }
}
