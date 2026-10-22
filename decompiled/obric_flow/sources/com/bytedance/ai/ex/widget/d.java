package com.bytedance.ai.ex.widget;

import android.view.ViewTreeObserver;
import kotlinx.coroutines.channels.u;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2152b;

    public /* synthetic */ d(Object r5, int r10) {
        this.f2151a = r10;
        this.f2152b = r5;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean r5) {
        int r10 = this.f2151a;
        Object r11 = this.f2152b;
        switch(r10) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ViewLifecycleOwner.b((ViewLifecycleOwner) r11, r5);
        return;
    L6:
        RepeatWhenAttachedKt.AnonymousClass2.b((u) r11, r5);
    }
}
