package com.bytedance.observer;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.Keep;
import com.bytedance.apm.block.e;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ObserverWrapper extends e.a implements Looper.Observer {
    private Looper.Observer mOriginObserver;

    public ObserverWrapper() {
    }

    public void dispatchingThrewException(Object r8, Message r10, Exception r11) {
        Thread r12 = e.f3757a;
    }

    public Object messageDispatchStarting() {
        if (e.f3757a != Thread.currentThread()) goto L7;
        messageDispatchStarting(">>>>> Dispatching to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee: 0");
        return null;
    L7:
        return null;
    }

    public void messageDispatched(Object r8, Message r10) {
        if (e.f3757a != Thread.currentThread()) goto L6;
        messageDispatched("<<<<< Finished to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee", r10);
        return;
    }

    @Override // com.bytedance.apm.block.e.a
    public void setup(Object r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if ((r8 instanceof Looper.Observer) == false) goto L8;
        this.mOriginObserver = (Looper.Observer) r8;
        return;
    }
}
