package com.bytedance.pia.core.worker.binding;

import ai.j0;
import android.content.Context;
import com.bytedance.vmsdk.jsbridge.JSModule;
import rh.b;

/* JADX INFO: loaded from: classes2.dex */
public class WarmupModule extends JSModule {
    public static final String NAME = "WarmupModule";
    private final b worker;

    public WarmupModule(Context r5, Object r10) {
        super(r5, r10);
        j0.A(r10);
    }

    @com.bytedance.vmsdk.jsbridge.b
    public void finishWarmup() {
        throw null;
    }
}
