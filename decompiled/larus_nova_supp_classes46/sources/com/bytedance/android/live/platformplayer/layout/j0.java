package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0<T> implements Observer {
    public static final j0 a = null;

    static {
        a = new j0();
    }

    public j0() {
    }

    public final void onChanged(Object r3) {
        Long r4 = (Long) r3;
        if (r4 == null) goto L8;
        long r0 = r4.longValue();
        IPerformanceManager r5 = jc1.k.f(IPerformanceManager.class);
        if (r5 == null) goto L9;
        r5.onAudioStall(Long.valueOf(r0));
        return;
    L9:
        return;
    }
}
