package com.lynx.tasm.base;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f10123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f10124b;

    public d() {
        this.f10123a = new ConcurrentHashMap();
        this.f10124b = new AtomicLong(0);
    }
}
