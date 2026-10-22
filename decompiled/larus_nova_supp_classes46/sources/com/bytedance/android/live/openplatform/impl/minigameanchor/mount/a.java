package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void accept(Object r2) {
        Response r3 = (Response) r2;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getSupportChangeMount();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(((yq0.f) r3.data).a()));
        return;
    L9:
        return;
    }
}
