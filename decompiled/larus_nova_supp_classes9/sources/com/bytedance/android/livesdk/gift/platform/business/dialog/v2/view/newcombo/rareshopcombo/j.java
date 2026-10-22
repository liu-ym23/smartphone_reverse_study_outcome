package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.Animator;
import com.bytedance.android.live.core.utils.s;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends s {
    public final /* synthetic */ GiftRareShopComboView a;

    public j(GiftRareShopComboView r1) {
        this.a = r1;
    }

    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Intrinsics.checkNotNullParameter(r2, "animation");
        HSImageView r3 = this.a.o;
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        return;
    }
}
