package com.ss.android.lark.opmonitor.process;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.api.IOPMonitorHeartBeatListenerStub;
import com.ss.android.lark.opmonitor.config.OPMonitorHeartBeatConfig;
import com.ss.android.lark.opmonitor.model.OPMonitorHeartBeatMonitorData;
import eyb.a;
import eyb.b;
import fyb.d;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IOPMonitorHeartBeatIPCStub extends Binder implements IInterface, a {
    public final b base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IOPMonitorHeartBeatIPCStub(Context r2) {
        this.base = new b(r2);
        attachInterface(this, IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
    }

    public void endHeartBeat(String r4) {
        this.base.getClass();
        d r0 = d.a();
        r0.getClass();
        if (TextUtils.isEmpty(r4) == true) goto L17;
        OPMonitorHeartBeatConfig r1 = r0.a;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.b == false) goto L15;
        OPMonitorHeartBeatMonitorData r2 = r0.f.get(r4);
        if (r2 != null) goto L12;
        r0.g.remove(r4);
        return;
    L12:
        r2.c = 0;
        r0.g.remove(r4);
        return;
    L15:
        return;
    }

    public void setLarkStatus(boolean r5) {
        this.base.getClass();
        d r0 = d.a();
        monitor-enter(r0);
        OPMonitorHeartBeatConfig r2 = r0.a;     // Catch: Throwable -> L19
        if (r2 != null) goto L7;
    L17:
        monitor-exit(r0);
        return;
    L7:
        if (r2.b == false) goto L17;
        Log.i("OPMonitorHeartBeatManager", "lark status is change isLarkForeground: " + r5);     // Catch: Throwable -> L19
        if (r5 == false) goto L11;
        r0.b();     // Catch: Throwable -> L19
        goto L17
    L11:
        Log.i("OPMonitorHeartBeatManager", "stopTimer");     // Catch: Throwable -> L19
        ScheduledExecutorService r6 = r0.e;     // Catch: Throwable -> L19
        if (r6 == null) goto L17;
        if (r6.isShutdown() == true) goto L17;
        r0.e.shutdownNow();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static IOPMonitorHeartBeatIPCProxy asInterface(Context r2, IBinder r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r3.queryLocalInterface(IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IOPMonitorHeartBeatIPCProxy) == false) goto L12;
        return (IOPMonitorHeartBeatIPCProxy) r0;
    L12:
        return new IOPMonitorHeartBeatIPCProxy(r2, r3);
    }

    public void registerHeartBeat(OPMonitorHeartBeatMonitorData r4, byb.a r5) {
        this.base.getClass();
        Log.i("OPMonitorHeartBeatIPC", "registerHeartBeat source:" + r4.b);
        d r0 = d.a();
        OPMonitorHeartBeatConfig r1 = r0.a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.b == false) goto L9;
        r0.f.put(r4.b, r4);
        r0.g.put(r4.b, r5);
        return;
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
        if (r5.readInt() == 0) goto L25;
        OPMonitorHeartBeatMonitorData r8 = OPMonitorHeartBeatMonitorData.CREATOR.createFromParcel(r5);
    L26:
        registerHeartBeat(r8, IOPMonitorHeartBeatListenerStub.asInterface(r5.readStrongBinder()));
        r6.writeNoException();
        return true;
    L25:
        r8 = null;
        goto L26
    L5:
        if (r4 != 2) goto L7;
        r5.enforceInterface(IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
        endHeartBeat(r5.readString());
        r6.writeNoException();
        return true;
    L7:
        if (r4 != 3) goto L9;
        r5.enforceInterface(IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
        if (r5.readInt() != 0) goto L17;
        boolean r9 = false;
    L18:
        setLarkStatus(r9);
        r6.writeNoException();
        return true;
    L17:
        r9 = true;
        goto L18
    L9:
        if (r4 != 1598968902) goto L11;
        r6.writeString(IOPMonitorHeartBeatIPCProxy.DESCRIPTOR);
        return true;
    L11:
        return super.onTransact(r4, r5, r6, r7);
    }
}
