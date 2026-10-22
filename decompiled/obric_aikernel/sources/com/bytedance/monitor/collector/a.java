package com.bytedance.monitor.collector;

import android.os.Message;
import androidx.annotation.CallSuper;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f2242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f2243c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f2244a;

    static {
    }

    public a() {
        this.f2244a = false;
    }

    @CallSuper
    public void a(String r10) {
    }

    @CallSuper
    public void b(String r10, Message r11) {
        this.f2244a = false;
        a(r10);
    }

    @CallSuper
    public void c(String r10) {
        this.f2244a = true;
    }

    public boolean d() {
        return false;
    }
}
