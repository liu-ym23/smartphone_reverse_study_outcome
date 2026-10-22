package com.bytedance.keva;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class KevaImpl$PortedSpRepoHolder {
    private static final KevaImpl sInstance = null;
    private static final Map<String, ?> sPortedSpMap = null;

    private KevaImpl$PortedSpRepoHolder() {
    }

    static {
        KevaMultiProcessImpl r0 = new KevaMultiProcessImpl(KevaImpl.access$000(), null, 1);
        sInstance = r0;
        r0.init(true);
        sPortedSpMap = r0.buildNewMap(new HashMap());
    }

    public static /* synthetic */ KevaImpl access$100() {
        return sInstance;
    }

    public static /* synthetic */ Map access$400() {
        return sPortedSpMap;
    }
}
