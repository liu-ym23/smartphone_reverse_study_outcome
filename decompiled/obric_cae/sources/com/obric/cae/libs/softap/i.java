package com.obric.cae.libs.softap;

import com.obric.cae.userAware.ui.PoiArrivalActivity;
import com.obric.cae.utils.AIKernelJavaBridge;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5500a;

    public /* synthetic */ i(int r8) {
        this.f5500a = r8;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r8) {
        switch(this.f5500a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L10;
        };
    L6:
        return PoiArrivalActivity.l(r8);
    L8:
        return CaeSoftApManager.a(r8);
    L10:
        return AIKernelJavaBridge.b(r8);
    }
}
