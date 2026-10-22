package com.google.android.material.e;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f3900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3901b;
    private int c;

    public c(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.f3901b = false;
        this.c = 0;
        this.f3900a = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
    }

    private void d() {
        ViewParent r0 = this.f3900a.getParent();
        if (ZeusTransformUtils.instanceOf(r0, CoordinatorLayout.class) == false) goto L6;
        ((CoordinatorLayout) ZeusTransformUtils.preCheckCast(r0, CoordinatorLayout.class, "com.obric.memorydata.plugin")).dispatchDependentViewsChanged(this.f3900a);
        return;
    }

    public void a(int r1) {
        this.c = r1;
    }

    public void a(Bundle r3) {
        this.f3901b = r3.getBoolean("expanded", false);
        this.c = r3.getInt("expandedComponentIdHint", 0);
        if (this.f3901b == false) goto L6;
        d();
        return;
    }

    public boolean a() {
        return this.f3901b;
    }

    public boolean a(boolean r2) {
        if (this.f3901b == r2) goto L6;
        this.f3901b = r2;
        d();
        return true;
    L6:
        return false;
    }

    public Bundle b() {
        Bundle r0 = new Bundle();
        r0.putBoolean("expanded", this.f3901b);
        r0.putInt("expandedComponentIdHint", this.c);
        return r0;
    }

    public int c() {
        return this.c;
    }
}
