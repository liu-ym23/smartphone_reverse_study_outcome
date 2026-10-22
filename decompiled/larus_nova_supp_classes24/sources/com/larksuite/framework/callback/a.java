package com.larksuite.framework.callback;

import android.os.Handler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class a {
    public final Handler a;

    public a(Handler r1) {
        this.a = r1;
    }

    public void a(Runnable r2) {
        this.a.post(r2);
    }

    public void b(Runnable r2, long r3) {
        this.a.postDelayed(r2, r3);
    }
}
