package com.lynx.tasm.behavior;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PlatformExtraBundleHolder {
    private final Map<Integer, Object> mBundleHolder;

    public static PlatformExtraBundleHolder generateHolder() {
        return new PlatformExtraBundleHolder();
    }

    private PlatformExtraBundleHolder() {
        this.mBundleHolder = new HashMap();
    }

    public Object getBundle(int r2) {
        return this.mBundleHolder.get(Integer.valueOf(r2));
    }

    public void putBundle(int r2, Object r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.mBundleHolder.put(Integer.valueOf(r2), r3);
    }
}
