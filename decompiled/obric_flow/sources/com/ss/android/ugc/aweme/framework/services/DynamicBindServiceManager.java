package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DynamicBindServiceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f16214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f16215b = null;

    static {
        f16214a = new ConcurrentHashMap();
        f16215b = Collections.synchronizedMap(new HashMap());
    }
}
