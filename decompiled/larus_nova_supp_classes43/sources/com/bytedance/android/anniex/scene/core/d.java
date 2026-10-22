package com.bytedance.android.anniex.scene.core;

import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final ConcurrentLinkedQueue<c> a;
    public long b;
    public final long c;

    public d() {
        this.a = new ConcurrentLinkedQueue();
        this.c = ((Number) SwitchCenter.k.getValue()).longValue();
    }
}
