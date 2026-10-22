package com.bytedance.android.anniex.scene.core;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f3381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3382c;
    public volatile int d;

    public a() {
        this.f3380a = ((Number) com.bytedance.android.anniex.scene.settings.a.g.getValue()).longValue();
        this.f3381b = ConcurrentHashMap.newKeySet();
    }
}
