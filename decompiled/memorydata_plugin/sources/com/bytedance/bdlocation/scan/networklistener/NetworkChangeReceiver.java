package com.bytedance.bdlocation.scan.networklistener;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class NetworkChangeReceiver extends PluginBroadcastReceiver {
    private boolean doRegister;
    private NetworkInfo sLastNetWork;
    private long sLastNetWorkTime;
    private Object sLock;

    public NetworkChangeReceiver() {
        this.sLock = new Object();
    }

    static /* synthetic */ Object access$000(NetworkChangeReceiver r0) {
        return r0.sLock;
    }

    static /* synthetic */ NetworkInfo access$100(NetworkChangeReceiver r0) {
        return r0.sLastNetWork;
    }

    static /* synthetic */ long access$200(NetworkChangeReceiver r2) {
        return r2.sLastNetWorkTime;
    }

    public void doRegister(boolean r1) {
        this.doRegister = r1;
    }

    public void notify(NetworkInfo r3) {
        NetworkManager.getInstance().notifyWifiChangedTwo(r3);
        this.sLastNetWork = r3;
        this.sLastNetWorkTime = System.currentTimeMillis();
    }

    public void onReceive(Context r3, final Intent r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.doRegister == false) goto L6;
        Logger.i("NetworkChangeReceiver onReceive doRegister");
        this.doRegister = false;
        return;
    L6:
        AppExecutors.getInstance().networkIO().execute(new AnonymousClass1(this, r4, r5));
    }
}
