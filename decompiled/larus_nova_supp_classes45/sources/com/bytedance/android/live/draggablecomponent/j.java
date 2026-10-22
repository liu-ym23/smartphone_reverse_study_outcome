package com.bytedance.android.live.draggablecomponent;

import com.bytedance.android.livesdk.message.model.InfoBoxBackGround;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ LiveAnchorTeleprompterView a;

    public j(LiveAnchorTeleprompterView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.e((InfoBoxBackGround) sh6.c.b((sh6.b) r2));
    }
}
