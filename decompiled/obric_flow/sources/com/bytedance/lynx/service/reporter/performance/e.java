package com.bytedance.lynx.service.reporter.performance;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f6851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f6852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f6853c;
    public volatile int d;
    public c e;
    public Context f;

    public e() {
        this.f6851a = new ConcurrentHashMap();
        this.f6852b = new ConcurrentHashMap();
    }
}
