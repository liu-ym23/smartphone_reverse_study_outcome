package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public class TTWeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message r1);
    }

    public TTWeakHandler(Looper r3, IHandler r4) {
        IHandler r5 = (IHandler) ZeusTransformUtils.wrapperContextForParams(r4, IHandler.class, "com.obric.memorydata.plugin");
        super(r3);
        this.mRef = new WeakReference(r5);
    }

    public TTWeakHandler(IHandler r3) {
        this.mRef = new WeakReference((IHandler) ZeusTransformUtils.wrapperContextForParams(r3, IHandler.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.os.Handler
    public void handleMessage(Message r3) {
        IHandler r2 = (IHandler) ZeusTransformUtils.preCheckCast(this.mRef.get(), IHandler.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        r2.handleMsg(r3);
        return;
    L8:
        return;
    }
}
