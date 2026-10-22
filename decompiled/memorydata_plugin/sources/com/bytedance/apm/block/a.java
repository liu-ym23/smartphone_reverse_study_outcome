package com.bytedance.apm.block;

import android.view.FrameMetrics;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1178a;

    public a() {
        this.f1178a = false;
    }

    public void a(long r1, long r3, long r5, long r7, boolean r9) {
        this.f1178a = false;
    }

    public void a(String r1) {
        this.f1178a = true;
    }

    public void a(String r1, long r2, int r4) {
    }

    public void a(String r1, long r2, long r4) {
    }

    public void a(String r1, FrameMetrics r2, int r3) {
    }

    public boolean a() {
        return this.f1178a;
    }
}
