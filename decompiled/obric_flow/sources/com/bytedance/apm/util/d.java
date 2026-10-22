package com.bytedance.apm.util;

import android.app.Activity;
import com.bytedance.apm.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements oj.c {
    @Override // oj.c
    public final void b(Activity r5) {
    }

    @Override // oj.c
    public final void c(Activity r5) {
        float r10 = r5.getWindowManager().getDefaultDisplay().getRefreshRate();
        if (Math.abs(r10 - 60.0f) >= 5.1f) goto L6;
    L9:
        boolean r11 = j.f3887a;
        return;
    L6:
        if (Math.abs(r10 - 90.0f) < 5.1f) goto L9;
        Math.abs(r10 - 120.0f);
        goto L9
    }

    @Override // oj.c
    public final void f(Activity r5) {
    }
}
