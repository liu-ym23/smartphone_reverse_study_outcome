package com.bytedance.monitor.collector;

import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f2831b;
    public static long c;
    public volatile boolean d;

    static {
    }

    public a() {
        this.d = false;
    }

    public void a(String r1) {
        this.d = true;
    }

    public void a(String r1, Message r2) {
        this.d = false;
        b(r1);
    }

    public boolean a() {
        return false;
    }

    public void b(String r1) {
    }
}
