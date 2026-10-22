package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import com.bytedance.android.live.base.model.user.UserEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ DrawerHistoryItemViewHolder a;

    public q(DrawerHistoryItemViewHolder r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((UserEvent) r2).isLogin() == false) goto L6;
        DrawerHistoryItemViewHolder r3 = this.a;
        int r0 = DrawerHistoryItemViewHolder.n;
        r3.V3();
        return;
    }
}
