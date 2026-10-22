package com.bytedance.common.utility;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3964c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public g(Context r5, int r10, String r11, int r12, int r13) {
        this.f3962a = r5;
        this.f3963b = r10;
        this.f3964c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.d;
        int r10 = this.e;
        UIUtils.access$000(this.f3962a, this.f3963b, this.f3964c, r5, r10);
    }
}
