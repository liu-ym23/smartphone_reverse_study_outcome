package com.obric.aikernel.utils;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f5594a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicLong f5595b = null;

    static {
        f5594a = new h();
        f5595b = new AtomicLong(Random.Default.nextLong(100, 200) * ((long) 1000));
    }

    private h() {
    }

    public final long a() {
        return f5595b.getAndIncrement();
    }
}
