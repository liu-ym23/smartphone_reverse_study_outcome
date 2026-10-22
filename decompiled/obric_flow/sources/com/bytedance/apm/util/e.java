package com.bytedance.apm.util;

import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f3910a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3911b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3912c = 0;
    public static final boolean d = false;
    public static final int e = 0;

    static {
        boolean r5 = j.f3887a;
        ActivityLifeObserver.getInstance().register(new d());
        f3912c = 60;
        f3911b = 60;
        d = true;
        f3910a = 1000.0f / 60;
        e = 60;
    }
}
