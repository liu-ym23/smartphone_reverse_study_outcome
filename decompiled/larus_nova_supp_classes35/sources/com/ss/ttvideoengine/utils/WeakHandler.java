package com.ss.ttvideoengine.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class WeakHandler extends Handler {
    private final WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMessage(Message r1);
    }

    public WeakHandler(IHandler r2) {
        this.mRef = new WeakReference(r2);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r2) {
        IHandler r0 = this.mRef.get();
        if (r0 == null) goto L6;
        r0.handleMessage(r2);
        return;
    }

    public WeakHandler(Looper r1, IHandler r2) {
        super(r1);
        this.mRef = new WeakReference(r2);
    }
}
