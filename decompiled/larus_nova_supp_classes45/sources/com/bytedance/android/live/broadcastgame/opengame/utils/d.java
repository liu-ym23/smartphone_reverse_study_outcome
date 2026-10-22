package com.bytedance.android.live.broadcastgame.opengame.utils;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public int a;
    public final HashMap<Integer, Long> b;
    public final PluginContext c;

    public d(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.c = r2;
        this.b = new HashMap();
    }
}
