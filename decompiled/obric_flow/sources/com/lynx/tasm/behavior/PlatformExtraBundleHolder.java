package com.lynx.tasm.behavior;

import androidx.annotation.Keep;
import com.lynx.tasm.base.CalledByNative;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class PlatformExtraBundleHolder {
    private final Map<Integer, Object> mBundleHolder;

    private PlatformExtraBundleHolder() {
        this.mBundleHolder = new HashMap();
    }

    @CalledByNative
    public static PlatformExtraBundleHolder generateHolder() {
        return new PlatformExtraBundleHolder();
    }

    @CalledByNative
    public Object getBundle(int r5) {
        return this.mBundleHolder.get(Integer.valueOf(r5));
    }

    @CalledByNative
    public void putBundle(int r5, Object r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mBundleHolder.put(Integer.valueOf(r5), r10);
    }
}
