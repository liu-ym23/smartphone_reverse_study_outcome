package com.bytedance.map.api.plugin;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class MapPluginManager {
    public MapPluginManager(Context r5) {
        Class.forName("com.bytedance.map.aweme.plugin.AwemePluginServiceImpl").newInstance();     // Catch: Throwable -> L5
    L13:
        Class.forName("com.ss.android.ugc.aweme.poi_map").newInstance();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }
}
