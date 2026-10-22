package com.volcengine.zeus;

import android.text.TextUtils;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Zeus$b extends ZeusPluginStateListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean[] b;
    public final /* synthetic */ AtomicBoolean c;
    public final /* synthetic */ CountDownLatch d;

    public final void onStateChangeOnCurThread(String r3, int r4, Object... r5) {
        if (TextUtils.equals(r3, this.a) == true) goto L6;
        return;
    L6:
        if (r4 != 9) goto L8;
    L9:
        boolean[] r6 = this.b;
        if (r4 != 9) goto L12;
        boolean r7 = true;
    L13:
        r6[0] = r7;
        if (this.c.compareAndSet(false, true) == false) goto L18;
        Zeus.unregisterPluginStateListener(this);
        ZeusLogger.i("Zeus/load_zeus", "awaitLoad event, pkg=" + this.a + ", loaded=" + this.b[0]);
        this.d.countDown();
        return;
    L18:
        return;
    L12:
        r7 = false;
        goto L13
    L8:
        if (r4 == 10) goto L9;
    }

    public Zeus$b(String r1, boolean[] r2, AtomicBoolean r3, CountDownLatch r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
