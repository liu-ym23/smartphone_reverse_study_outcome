package com.bytedance.common.utility.collection;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class WeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message r10);
    }

    public WeakHandler(Looper r10, IHandler r11) {
        super(r10);
        this.mRef = new WeakReference(r11);
    }

    public WeakHandler(IHandler r10) {
        if (Looper.myLooper() != null) goto L5;
        Looper r11 = Looper.getMainLooper();
    L6:
        this(r11, r10);
        return;
    L5:
        r11 = Looper.myLooper();
        goto L6
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
