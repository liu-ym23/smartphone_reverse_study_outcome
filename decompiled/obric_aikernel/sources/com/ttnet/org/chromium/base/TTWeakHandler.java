package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class TTWeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message r10);
    }

    public TTWeakHandler(Looper r10, IHandler r11) {
        super(r10);
        this.mRef = new WeakReference(r11);
    }

    public TTWeakHandler(IHandler r10) {
        this.mRef = new WeakReference(r10);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r10) {
        IHandler r11 = this.mRef.get();
        if (r11 == null) goto L7;
        if (r10 == null) goto L8;
        r11.handleMsg(r10);
        return;
    L8:
        return;
    }
}
