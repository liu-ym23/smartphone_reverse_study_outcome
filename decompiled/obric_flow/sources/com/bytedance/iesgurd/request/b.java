package com.bytedance.iesgurd.request;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final ConcurrentHashMap e = null;
    public static final AtomicLong f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f6666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f6667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6668c;
    public final String d;

    static {
        e = new ConcurrentHashMap();
        f = new AtomicLong(System.currentTimeMillis());
    }

    public b(boolean r5, boolean r10, String r11, g r12) {
        this.f6668c = r10;
        this.d = r11;
        this.f6666a = new AtomicBoolean(r5);
        this.f6667b = r12;
    }
}
