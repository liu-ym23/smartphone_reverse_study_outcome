package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class DowngradeImplManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f16210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f16211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f16212c;
    public final Set d;
    public final Set e;

    public static class SingleInstanceHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DowngradeImplManager f16213a = null;

        static {
            f16213a = new DowngradeImplManager();
        }
    }

    public DowngradeImplManager() {
        this.f16210a = new ConcurrentHashMap();
        this.f16211b = new ConcurrentHashMap();
        this.f16212c = new ConcurrentHashMap();
        this.d = Collections.synchronizedSet(new HashSet());
        this.e = Collections.synchronizedSet(new HashSet());
    }
}
