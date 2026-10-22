package com.bytedance.common.utility.collection;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class WeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message r8);
    }

    public WeakHandler(Looper r8, IHandler r10) {
        super(r8);
        this.mRef = new WeakReference(r10);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r8) {
        IHandler r10 = this.mRef.get();
        if (r10 == null) goto L7;
        if (r8 == null) goto L8;
        r10.handleMsg(r8);
        return;
    L8:
        return;
    }

    public WeakHandler(IHandler r8) {
        if (Looper.myLooper() != null) goto L5;
        Looper r10 = Looper.getMainLooper();
    L6:
        this(r10, r8);
        return;
    L5:
        r10 = Looper.myLooper();
        goto L6
    }
}
