package com.bytedance.android.livesdk.gift.multiplayer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftSwitchImageView;
import com.ss.android.ugc.aweme.live.alphaplayer.multi_player.MultiPlayerController;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ MultiPlayerWidget a;

    public e(MultiPlayerWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        MultiPlayerWidget r4 = this.a;
        int r0 = MultiPlayerWidget.r;
        r4.getClass();
        ConstraintLayout r5 = this.a.d;
        if (r5 == null) goto L5;
        r5.setVisibility(8);
    L5:
        c r6 = this.a.l;
        int r1 = 0;
        if (r6 == null) goto L10;
        MultiPlayerController r7 = r6.a;
        if (r7 == null) goto L10;
        r1 = r7.getDuration();
    L10:
        if (r1 <= 0) goto L17;
        GiftSwitchImageView r8 = this.a.d;
        if (r8 == null) goto L14;
        r8.setDuration(r1);
    L14:
        GiftSwitchImageView r9 = this.a.d;
        if (r9 == null) goto L17;
        r9.V5();
    L17:
        Disposable r10 = this.a.m;
        if (r10 == null) goto L21;
        r10.dispose();
        return;
    }
}
