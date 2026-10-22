package com.bytedance.android.anniex.scene.core;

import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class HotUrlCache {
    public final int a;
    public final HotUrlCache$map$1 b;

    public HotUrlCache() {
        Lazy r0 = SwitchCenter.a;
        this.a = ((Number) SwitchCenter.l.getValue()).intValue();
        this.b = new HotUrlCache$map$1(this);
    }
}
