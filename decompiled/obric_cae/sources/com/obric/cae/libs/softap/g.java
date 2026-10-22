package com.obric.cae.libs.softap;

import android.os.Bundle;
import com.obric.cae.userAware.ui.PoiArrivalActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5492b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5493m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f5494n;

    public /* synthetic */ g(Object r8, int r10, int r11, Object r12) {
        this.f5491a = r11;
        this.f5493m = r8;
        this.f5492b = r10;
        this.f5494n = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5491a;
        int r10 = this.f5492b;
        Object r11 = this.f5494n;
        Object r12 = this.f5493m;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CaeSoftApManager.b((CaeSoftApManager.c) r12, r10, (String) r11);
        return;
    L7:
        PoiArrivalActivity.e((PoiArrivalActivity) r12, r10, (Bundle) r11);
    }
}
