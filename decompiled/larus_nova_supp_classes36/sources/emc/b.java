package emc;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ugc.live.sdk.msg.utils.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends PthreadThreadV2 {
    public final d<c> v;
    public final Handler w;

    public final void run() {
    L15:
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    L3:
        if (isInterrupted() == true) goto L21;
        c r0 = (c) this.v.c();     // Catch: Throwable -> L6 InterruptedException -> L8
        r0.a.toString();     // Catch: Throwable -> L6 InterruptedException -> L8
        Handler r1 = this.w;     // Catch: Throwable -> L6 InterruptedException -> L8
        r1.sendMessage(r1.obtainMessage(7968, r0.a));     // Catch: Throwable -> L6 InterruptedException -> L8
    }

    public b(d r2, i r3) {
        super("StreamMessageDelayThread");
        this.v = r2;
        this.w = r3;
    }
}
