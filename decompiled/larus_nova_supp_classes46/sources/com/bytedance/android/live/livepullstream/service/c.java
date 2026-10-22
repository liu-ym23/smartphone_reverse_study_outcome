package com.bytedance.android.live.livepullstream.service;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.config.y3;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements gl0.c {
    public static final Boolean a = null;
    public static final c b = null;

    public c() {
    }

    static {
        b = new c();
        a = (Boolean) y3.a.getValue();
    }

    public final boolean a() {
        return a.booleanValue();
    }

    public static boolean d(Bundle r3) {
        if (r3 != null) goto L5;
    L9:
        return false;
    L5:
        if (r3.getInt(VSConstants.EXTRA_ITEM_TYPE, VSConstants.LIVE_NORMAL) != VSConstants.LIVE_NORMAL) goto L9;
        return r3.getBoolean("live.intent.extra.IS_PSEUDO_LIVING", false);
    }

    public final boolean c(long r2, Bundle r4) {
        return LivePlatformPlayerManager.c(r2, d(r4)).r(r4);
    }

    public final boolean b(Context r2, long r3, Bundle r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return LivePlatformPlayerManager.c(r3, d(r5)).e(r2, r5);
    }
}
