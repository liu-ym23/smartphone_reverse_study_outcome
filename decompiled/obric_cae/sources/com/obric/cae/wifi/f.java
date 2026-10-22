package com.obric.cae.wifi;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6083b;

    public /* synthetic */ f(Object r8, int r10) {
        this.f6082a = r10;
        this.f6083b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f6082a;
        Object r10 = this.f6083b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CaeWifiDatabaseService.AnonymousClass5.a((CaeWifiDatabaseService.AnonymousClass5) r10);
        return;
    L7:
        CaeWifiDatabaseService.f((Context) r10);
    }
}
