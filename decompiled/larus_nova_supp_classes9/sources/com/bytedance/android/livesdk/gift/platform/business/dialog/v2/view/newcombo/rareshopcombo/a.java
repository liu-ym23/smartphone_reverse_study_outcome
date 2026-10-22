package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.Animator;
import com.bytedance.android.live.core.utils.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends s {
    public final /* synthetic */ GiftRareShopComboHeatHelper a;

    public a(GiftRareShopComboHeatHelper r1) {
        this.a = r1;
    }

    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.c.setValue(Boolean.TRUE);
    }
}
