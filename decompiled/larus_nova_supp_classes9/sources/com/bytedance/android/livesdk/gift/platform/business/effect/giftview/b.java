package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftSwitchImageView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ LynxVideoView a;
    public final /* synthetic */ int b;

    public b(LynxVideoView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        LynxVideoView r4 = this.a;
        if (r4.d == false) goto L13;
        GiftSwitchImageView r5 = r4.b;
        if (r5 == null) goto L9;
        if (r5.getCurrentSwitchType() == 0) goto L13;
    L9:
        if (this.b == 0) goto L13;
        ConstraintLayout r6 = this.a.b;
        if (r6 == null) goto L16;
        r6.setVisibility(0);
    L16:
        int r7 = this.b;
        if (r7 == 0) goto L24;
        GiftSwitchImageView r0 = this.a.b;
        if (r0 == null) goto L21;
        r0.setDuration(r7);
    L21:
        GiftSwitchImageView r8 = this.a.b;
        if (r8 == null) goto L24;
        r8.V5();
    L24:
        Disposable r9 = this.a.e;
        if (r9 == null) goto L28;
        r9.dispose();
        return;
    L28:
        return;
    L13:
        ConstraintLayout r10 = this.a.b;
        if (r10 == null) goto L16;
        r10.setVisibility(8);
        goto L16
    }
}
