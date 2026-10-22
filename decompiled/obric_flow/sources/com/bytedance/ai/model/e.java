package com.bytedance.ai.model;

import android.app.AlertDialog;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertDialog.Builder f2238b;

    public /* synthetic */ e(AlertDialog.Builder r5, int r10) {
        this.f2237a = r10;
        this.f2238b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlertDialog.Builder r5 = this.f2238b;
        switch(this.f2237a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r10 = AppletRuntime.f2196x;
        r5.create().show();
        return;
    L6:
        int r11 = AppletRuntime.f2196x;
        r5.create().show();
    }
}
