package com.bytedance.android.livesdk.interactivity.asr;

import android.os.SystemClock;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements IHostPlugin.Callback {
    public final /* synthetic */ long a;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.c();     // Catch: Throwable -> L4
            c.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(long r1) {
        this.a = r1;
    }

    public final void onCancel(String r5) {
        long r0 = SystemClock.elapsedRealtime() - this.a;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("install plugin " + r5 + " failed. cost " + r0 + " ms");
        w52.a.c(false, r0);
    }

    public final void onSuccess(String r5) {
        long r0 = SystemClock.elapsedRealtime() - this.a;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("install plugin " + r5 + " success. cost " + r0 + " ms.");
        w52.a.c(true, r0);
        MainThreadPostUtils.e(a.a);
    }
}
