package com.bytedance.awemeopen.infra.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class j {
    public boolean a;
    public final i b;

    public abstract void a(LifecycleOwner r1, Lifecycle.Event r2);

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.awemeopen.infra.util.i] */
    public j() {
        this.b = new i(this);
    }
}
