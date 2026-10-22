package e41;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final Handler a;
    public Runnable b;
    public MessageQueue.IdleHandler c;

    public final void a() {
        Runnable r0 = this.b;
        if (r0 == null) goto L5;
        this.a.removeCallbacks(r0);
    L5:
        this.b = null;
        MessageQueue.IdleHandler r1 = this.c;
        if (r1 != null) goto L8;
    L14:
        this.c = null;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        Looper r2 = this.a.getLooper();
        if (r2 == null) goto L14;
        MessageQueue r3 = r2.getQueue();
        if (r3 == null) goto L14;
        r3.removeIdleHandler(r1);
        goto L14
    }

    public a() {
        this.a = new Handler(Looper.getMainLooper());
    }

    public final void b(Runnable r6) {
        Intrinsics.checkNotNullParameter(r6, "runnable");
        long r0 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.d();
        if (r0 > 0) goto L6;
        r6.run();
        return;
    L6:
        Runnable r2 = this.b;
        if (r2 == null) goto L9;
        this.a.removeCallbacks(r2);
    L9:
        this.a.postDelayed(r6, r0);
        this.b = r6;
    }

    public final void c(MessageQueue.IdleHandler r5) {
        Intrinsics.checkNotNullParameter(r5, "runnable");
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r0 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r0.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.k.getValue(r0, com.bytedance.android.live.revlink.impl.settings.dynamic.a.a[9])).booleanValue() == true) goto L5;
    L21:
        r5.queueIdle();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L21;
        MessageQueue.IdleHandler r1 = this.c;
        if (r1 == null) goto L14;
        Looper r2 = this.a.getLooper();
        if (r2 == null) goto L14;
        MessageQueue r3 = r2.getQueue();
        if (r3 == null) goto L14;
        r3.removeIdleHandler(r1);
    L14:
        Looper r4 = this.a.getLooper();
        if (r4 == null) goto L19;
        MessageQueue r6 = r4.getQueue();
        if (r6 == null) goto L19;
        r6.addIdleHandler(r5);
    L19:
        this.c = r5;
    }
}
