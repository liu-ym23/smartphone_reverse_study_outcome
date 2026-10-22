package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class StaticServiceImplManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f16220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f16221b;

    public static class SingleInstanceHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StaticServiceImplManager f16222a = null;

        static {
            f16222a = new StaticServiceImplManager();
        }
    }

    public StaticServiceImplManager() {
        this.f16220a = new ConcurrentHashMap();
        this.f16221b = Collections.synchronizedSet(new HashSet());
        new ConcurrentHashMap();
        Collections.synchronizedSet(new HashSet());
    }
}
