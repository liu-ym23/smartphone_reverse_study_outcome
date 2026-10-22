package com.google.android.material.internal;

import android.content.BroadcastReceiver;
import android.view.View;
import com.obric.clockwidgets.c;
import com.obric.clockwidgets.receivers.SystemClockPackageReceiver;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f8556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8557c;

    public /* synthetic */ b(View r5, boolean r10) {
        this.f8555a = 0;
        this.f8557c = r5;
        this.f8556b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r5 = this.f8557c;
        boolean r10 = this.f8556b;
        switch(this.f8555a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        BroadcastReceiver.PendingResult r11 = (BroadcastReceiver.PendingResult) r5;
        int r12 = SystemClockPackageReceiver.f11264b;
        c.b(r10);     // Catch: Throwable -> L8
        r11.finish();
        return;
    L8:
        th = move-exception;
        r11.finish();
        throw th;
    L11:
        ViewUtils.a((View) r5, r10);
    }

    public /* synthetic */ b(boolean r5, BroadcastReceiver.PendingResult r10) {
        this.f8555a = 1;
        this.f8556b = r5;
        this.f8557c = r10;
    }
}
