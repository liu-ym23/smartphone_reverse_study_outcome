package com.bytedance.android.live.browser;

import com.bytedance.android.live.core.log.ALogger;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements f8.a {
    public final /* synthetic */ w a;

    public final List<com.lynx.tasm.behavior.a> provide() {
        ALogger.i("AnnieNGInitHelper", "provide getBehaviorList");
        return this.a.getBehaviorList();
    }

    public b(w r1) {
        this.a = r1;
    }
}
