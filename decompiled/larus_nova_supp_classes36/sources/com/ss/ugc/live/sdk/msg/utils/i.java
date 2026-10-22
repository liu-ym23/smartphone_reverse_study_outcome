package com.ss.ugc.live.sdk.msg.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends Handler {
    public final WeakReference<a> a;

    public interface a {
        void handleMsg(Message r1);
    }

    public i(a r2) {
        this.a = new WeakReference(r2);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r2) {
        a r0 = this.a.get();
        if (r0 == null) goto L7;
        if (r2 == null) goto L8;
        r0.handleMsg(r2);
        return;
    L8:
        return;
    }

    public i(Looper r1, a r2) {
        super(r1);
        this.a = new WeakReference(r2);
    }
}
