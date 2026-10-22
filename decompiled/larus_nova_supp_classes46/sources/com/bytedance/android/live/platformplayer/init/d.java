package com.bytedance.android.live.platformplayer.init;

import com.bytedance.android.livesdk.config.w51;
import com.bytedance.android.livesdkapi.host.ILivePlayerNetwork;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements ILivePlayerNetwork {
    public d() {
    }

    public final String apiHost() {
        return "aweme.snssdk.com";
    }

    public final ILivePlayerApi createLivePlayerAPI() {
        int r0 = w51.a;
        um0.a r1 = om0.c.i();
        if (r1 == null) goto L7;
        ILivePlayerApi r2 = (ILivePlayerApi) r1.getService(ILivePlayerApi.class);
        if (r2 == null) goto L7;
        return r2;
    L7:
        return (ILivePlayerApi) com.bytedance.android.live.network.c.b().e(ILivePlayerApi.class);
    }

    public final <T> T createAPIByClass(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "cls");
        int r0 = w51.a;
        um0.a r1 = om0.c.i();
        if (r1 == null) goto L7;
        T r3 = (T) r1.getService(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return (T) com.bytedance.android.live.network.c.b().e(r2);
    }
}
