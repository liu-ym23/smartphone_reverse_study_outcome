package com.ttnet.org.chromium.net;

import ac.f;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6740b;

    public /* synthetic */ a(Object r8, int r10) {
        this.f6739a = r10;
        this.f6740b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f6739a;
        Object r10 = this.f6740b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        ProxyChangeListener.a((ProxyChangeListener) r10);
        return;
    L7:
        ((f) r10).f285b = true;
    }
}
