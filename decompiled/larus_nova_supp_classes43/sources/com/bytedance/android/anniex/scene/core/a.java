package com.bytedance.android.anniex.scene.core;

import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final long a;
    public final ConcurrentHashMap.KeySetView<k, Boolean> b;
    public long c;
    public volatile int d;

    public a() {
        this.a = ((Number) SwitchCenter.j.getValue()).longValue();
        this.b = ConcurrentHashMap.newKeySet();
    }
}
