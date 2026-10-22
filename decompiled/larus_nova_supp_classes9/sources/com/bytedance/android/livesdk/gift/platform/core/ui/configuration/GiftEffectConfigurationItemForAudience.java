package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.Context;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i2;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel.GiftEffectConfigurationViewModelForAnchor;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftEffectConfigurationItemForAudience implements n {
    public final i2 a;
    public final Context b;

    @Override // com.bytedance.android.livesdk.gift.platform.core.ui.configuration.n
    public final List<i> a() {
        final GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$1 r1 = new GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$1(this);
        final GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$2 r2 = new GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$2(this);
        return CollectionsKt.listOf(new i[]{new i(GiftEffectSwitchConfigType.NormalGiftSwitch, "礼物特效", new GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$3(r1), new GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$4(r2), false, null, BuildConfig.FLAVOR), GiftEffectConfigurationCommonItemKt.a(this.b, false, new GiftEffectConfigurationItemForAudience$loadGiftEffectConfigurationItems$1(this))});
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.ui.configuration.n
    public final void b(GiftEffectConfigurationViewModelForAnchor r1) {
    }

    public GiftEffectConfigurationItemForAudience(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.b = r3;
        i12.e r4 = i12.o.b();
        if (r4 == null) goto L5;
        Object r5 = com.bytedance.android.scope.m.e.d(r4, i2.class);
    L6:
        this.a = (i2) r5;
        return;
    L5:
        r5 = null;
        goto L6
    }
}
