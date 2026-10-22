package com.bytedance.android.monitorV2.listener;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f3614b;

    public /* synthetic */ d(e r5, int r10) {
        this.f3613a = r10;
        this.f3614b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f3613a) {
            case 0: goto L10;
            case 1: goto L8;
            default: goto L4;
        };
    L4:
        e r5 = this.f3614b;
        e.h(r5);
        Handler r10 = r5.f3618c;
        if (r10 == null) goto L12;
        r10.postDelayed(new d(r5, 2), 600000);
        return;
    L12:
        return;
    L8:
        e.h(this.f3614b);
        return;
    L10:
        e.h(this.f3614b);
    }
}
