package com.bytedance.common.utility.collection;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class WeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message r5);
    }

    public WeakHandler(IHandler r5) {
        if (Looper.myLooper() != null) goto L5;
        Looper r10 = Looper.getMainLooper();
    L6:
        this(r10, r5);
        return;
    L5:
        r10 = Looper.myLooper();
        goto L6
    }

    @Override // android.os.Handler
    public void handleMessage(Message r5) {
        IHandler r10 = this.mRef.get();
        if (r10 == null) goto L7;
        if (r5 == null) goto L8;
        r10.handleMsg(r5);
        return;
    L8:
        return;
    }

    public WeakHandler(Looper r5, IHandler r10) {
        super(r5);
        this.mRef = new WeakReference(r10);
    }
}
