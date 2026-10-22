package com.bytedance.apm.block;

import android.view.FrameMetrics;
import androidx.annotation.CallSuper;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f744c;

    public a() {
        this.f744c = false;
    }

    @CallSuper
    public void c(String r10) {
        this.f744c = true;
    }

    @CallSuper
    public void d(long r10, long r11, long r12, long r13, boolean r14) {
        this.f744c = false;
    }

    public void e(String r10, long r11, long r12) {
    }

    public boolean f() {
        return this.f744c;
    }

    public void g(String r10, long r11, int r12) {
    }

    public void h(String r10, FrameMetrics r11, int r12) {
    }
}
