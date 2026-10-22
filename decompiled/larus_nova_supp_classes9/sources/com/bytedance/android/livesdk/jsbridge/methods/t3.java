package com.bytedance.android.livesdk.jsbridge.methods;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t3 implements Runnable {
    public final /* synthetic */ com.bytedance.android.live.pushstream.d a;
    public final /* synthetic */ String b;

    public static final class a extends tp2.b {
        public a() {
        }
    }

    public t3(com.bytedance.android.live.pushstream.d r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        xs2.b.a().post(new zg1.n1(this.a, new a(), false, 0, false, this.b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
