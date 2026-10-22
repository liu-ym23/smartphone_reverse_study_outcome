package com.bytedance.android.livesdk.gift.format;

import com.bytedance.android.livesdk.gift.platform.business.effect.player.k;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ GiftPlayerView a;

    public e(GiftPlayerView r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        String r1 = (String) r9;
        int r2 = GiftPlayerView.k;
        this.a.e("get assets path success: " + r1);
        if (r1.length() <= 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        k r0 = this.a.a;
        if (r0 == null) goto L12;
        ITextureViewPlayerController.DefaultImpls.start$default(r0, r1, false, false, false, null, 28, null);
        return;
    L12:
        return;
    L10:
        GiftPlayerView.c(this.a);
        return;
    L5:
        r10 = false;
        goto L6
    }
}
