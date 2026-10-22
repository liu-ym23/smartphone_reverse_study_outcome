package com.bytedance.vmsdk.jsbridge.utils;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class SystemMessageHandler extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7559b;

    public SystemMessageHandler(long r5) {
        this.f7558a = r5;
        this.f7559b = true;
    }

    @CalledByNative
    public static SystemMessageHandler create(long r5) {
        return new SystemMessageHandler(r5);
    }

    private native void nativeRunWork(long r5);

    @CalledByNative
    private void scheduleWork() {
        Message r5 = Message.obtain();
        r5.what = 1;
        r5.setAsynchronous(true);
        sendMessage(r5);
    }

    @CalledByNative
    private void stop() {
        this.f7559b = false;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r5) {
        if (this.f7559b == false) goto L6;
        nativeRunWork(this.f7558a);
        return;
    }
}
