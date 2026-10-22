package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f815b;

    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r3) {
            if (r3.what != 1) goto L6;
            ((s) ZeusTransformUtils.preCheckCast(r3.obj, s.class, "com.obric.memorydata.plugin")).f();
            return true;
        L6:
            return false;
        }
    }

    v() {
        this.f815b = new Handler(Looper.getMainLooper(), new a());
    }

    synchronized void a(s<?> r3, boolean r4) {
        monitor-enter(this);
        s r5 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (this.f814a == true) goto L8;
        if (r4 == true) goto L8;
        this.f814a = true;     // Catch: Throwable -> L11
        r5.f();     // Catch: Throwable -> L11
        this.f814a = false;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L8:
        this.f815b.obtainMessage(1, r5).sendToTarget();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
