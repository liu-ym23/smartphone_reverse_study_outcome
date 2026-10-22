package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadResType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.h;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ GiftPanelViewPreloadService a;

    public c(GiftPanelViewPreloadService r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.a(GiftPanelViewPreloadService.PreloadSource.CLOSE_PANEL);
        HashMap<GiftPreloadResType, k<?>> r4 = GiftPreloadManager.a;
        GiftPreloadManager.b(h.c.a);
    }
}
