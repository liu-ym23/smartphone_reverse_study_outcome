package com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle;

import com.bytedance.android.live.core.utils.rxutils.autodispose.OutsideScopeException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LifecycleEndedException extends OutsideScopeException {
    public LifecycleEndedException() {
        this("Lifecycle has ended!");
    }

    public LifecycleEndedException(String r1) {
        super(r1);
    }
}
