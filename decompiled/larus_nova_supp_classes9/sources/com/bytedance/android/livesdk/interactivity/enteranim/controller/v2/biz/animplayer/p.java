package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import com.bytedance.android.live.profit.player.profilepreview.ProfilePreviewEvent;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ Mp4EnhancedEnterPlayer a;

    public p(Mp4EnhancedEnterPlayer r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ProfilePreviewEvent r3 = (ProfilePreviewEvent) r2;
        if ((r3.b instanceof uu0.b.a) == false) goto L17;
        ProfilePreviewEvent.EventType r4 = r3.getType();
        int r5 = o.a[r4.ordinal()];
        if (r5 != 1) goto L8;
        Mp4EnhancedEnterPlayer r6 = this.a;
        r6.e = true;
        Disposable r7 = r6.f;
        if (r7 == null) goto L16;
        r7.dispose();
        return;
    L16:
        return;
    L8:
        if (r5 != 2) goto L18;
        this.a.e = false;
        return;
    L18:
        return;
    }
}
