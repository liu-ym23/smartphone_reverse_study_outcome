package com.bytedance.observer;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Keep;
import com.bytedance.apm.block.k;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ObserverWrapper extends k.a implements Looper.Observer {
    private Looper.Observer mOriginObserver;

    static {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        return;
    L6:
        throw new IllegalStateException("load class error");
    }

    public ObserverWrapper() {
    }

    public void dispatchingThrewException(Object r10, Message r11, Exception r12) {
        if (k.f781c == null) goto L16;
        Looper.Observer r13 = this.mOriginObserver;
        if (r13 == null) goto L14;
        r13.dispatchingThrewException(r10, r11, r12);
        return;
    L14:
        k.f784f.invoke(k.f781c, new Object[]{r10, r11, r12});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L19:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public Object messageDispatchStarting() {
        if (k.f781c == null) goto L13;
        Looper.Observer r10 = this.mOriginObserver;
        if (r10 == null) goto L18;
        Object r11 = r10.messageDispatchStarting();
    L15:
        if (k.f785g != Thread.currentThread()) goto L17;
        messageDispatchStarting(">>>>> Dispatching to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee: 0");
    L17:
        return r11;
    L18:
        r11 = k.f782d.invoke(k.f781c, new Object[0]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L13:
        r11 = null;
        goto L15
    }

    public void messageDispatched(Object r10, Message r11) {
        if (k.f781c == null) goto L14;
        Looper.Observer r12 = this.mOriginObserver;
        if (r12 == null) goto L17;
        r12.messageDispatched(r10, r11);
        goto L14
    L17:
        k.f783e.invoke(k.f781c, new Object[]{r10, r11});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L14:
        if (k.f785g != Thread.currentThread()) goto L19;
        messageDispatched("<<<<< Finished to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee", r11);
        return;
    }

    @Override // com.bytedance.apm.block.k.a
    protected void setup(Object r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof Looper.Observer) == false) goto L8;
        this.mOriginObserver = (Looper.Observer) r10;
        return;
    }
}
