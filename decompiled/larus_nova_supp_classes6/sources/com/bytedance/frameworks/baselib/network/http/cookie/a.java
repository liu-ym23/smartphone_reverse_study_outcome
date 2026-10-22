package com.bytedance.frameworks.baselib.network.http.cookie;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ b.b c;

    public /* synthetic */ a(Context r1, boolean r2, b.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.e(this.a, this.b, this.c);
    }
}
