package com.bytedance.ai.ex.widget;

import android.view.ViewTreeObserver;
import kotlinx.coroutines.channels.u;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements ViewTreeObserver.OnWindowVisibilityChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2154b;

    public /* synthetic */ e(Object r5, int r10) {
        this.f2153a = r10;
        this.f2154b = r5;
    }

    @Override // android.view.ViewTreeObserver.OnWindowVisibilityChangeListener
    public final void onWindowVisibilityChanged(int r5) {
        int r10 = this.f2153a;
        Object r11 = this.f2154b;
        switch(r10) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ViewLifecycleOwner.a((ViewLifecycleOwner) r11, r5);
        return;
    L6:
        RepeatWhenAttachedKt.C01602.b((u) r11, r5);
    }
}
