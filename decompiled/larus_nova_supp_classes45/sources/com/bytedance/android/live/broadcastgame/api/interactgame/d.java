package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public c a;
    public final boolean b;
    public boolean c;

    public static final class a {
    }

    static {
    }

    public d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "gameGuideParams");
        this.a = (c) GsonHelper.get().fromJson(r3, c.class);     // Catch: Exception -> L5
        this.b = true;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ALogger.e("GameGuideHelper", e.getMessage(), e);
    }
}
