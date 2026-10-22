package com.obric.cae.location;

import com.obric.cae.userAware.ui.StoreArrivalActivity;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5613a;

    public /* synthetic */ a(int r8) {
        this.f5613a = r8;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r8) {
        switch(this.f5613a) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return StarLocationManager.b(r8);
    L8:
        return StoreArrivalActivity.g(r8);
    }
}
