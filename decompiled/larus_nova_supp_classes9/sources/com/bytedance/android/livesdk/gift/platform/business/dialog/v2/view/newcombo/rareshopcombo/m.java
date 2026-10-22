package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ GiftRareShopComboView a;

    public m(GiftRareShopComboView r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        AnimatedDrawable2 r5 = this.a.y;
        if (r5 == null) goto L6;
        r5.setAnimationBackend(new q(r5.getAnimationBackend()));
        r5.stop();
        return;
    }
}
