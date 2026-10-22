package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import androidx.core.util.Consumer;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnPageScrollGuideAnimationEnd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ GiftTabViewHolder a;

    public z(GiftTabViewHolder r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L6;
        this.a.o(new OnPageScrollGuideAnimationEnd());
        return;
    }
}
