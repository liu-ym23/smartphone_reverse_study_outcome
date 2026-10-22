package com.ss.android.lark.conditional.access.network.easynetwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.larksuite.framework.utils.NetworkUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class NetworkTypeDetector extends BroadcastReceiver {
    public static NetworkTypeDetector a;
    public static final CopyOnWriteArrayList<l8b.a> b = null;
    public static PthreadHandlerThreadV2 c;
    public static Handler d;
    public static EasyNetworkState e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<l8b.a> r0 = NetworkTypeDetector.b.iterator();     // Catch: Throwable -> L9
        L4:
            if (r0.hasNext() == false) goto L21;
            l8b.a r1 = r0.next();     // Catch: Throwable -> L9
            if (r1 == null) goto L4;
            r1.a(NetworkTypeDetector.e);     // Catch: Throwable -> L9
            goto L4
        L21:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    static {
        b = new CopyOnWriteArrayList();
    }

    public static void d() {
        if (c == null) goto L6;
    L13:
        d.post(new a());
        return;
    L6:
        monitor-enter(NetworkTypeDetector.class);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (c != null) goto L12;
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("handler-nettype");     // Catch: Throwable -> L10
        c = r1;     // Catch: Throwable -> L10
        ThreadMethodProxy.start(r1);     // Catch: Throwable -> L10
        d = new Handler(c.getLooper());     // Catch: Throwable -> L10
    L12:
        monitor-exit(NetworkTypeDetector.class);     // Catch: Throwable -> L10
        goto L13
    }

    public NetworkTypeDetector() {
    }

    public static EasyNetworkState a(Context r4) {
        Log.i("NetworkTypeDetector", "getCurrNetworkType: start");
        ConnectivityManager r1 = (ConnectivityManager) r4.getApplicationContext().getSystemService("connectivity");
        EasyNetworkType r5 = EasyNetworkType.getBasicEasyType(NetworkUtils.b(r4));
        if (b(r1) == false) goto L6;
        r5 = EasyNetworkType.VPN;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        Network r2 = r1.getActiveNetwork();
        if (r2 == null) goto L10;
        String r3 = String.valueOf(r2.getNetworkHandle());
    L11:
        EasyNetworkState r6 = new EasyNetworkState(r5, r3);
        Log.i("NetworkTypeDetector", "getCurrNetworkType: end,easyNetworkType=" + r6.toString());
        return r6;
    L10:
        r3 = BuildConfig.FLAVOR;
        goto L11
    }

    public static boolean b(ConnectivityManager r5) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Network[] r0 = r5.getAllNetworks();
        int r1 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L15;
        if (c(r5, r0[r3]) == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return true;
    L15:
        return false;
    L5:
        return c(r5, r5.getActiveNetwork());
    }

    public static boolean e(EasyNetworkState r3) {
        Log.i("NetworkTypeDetector", "updateNetworkType: sCurrNetworkState  == " + e.toString());
        Log.i("NetworkTypeDetector", "updateNetworkType: received networkState == " + r3.toString());
        if (e.getEasyNetworkType().getNumber() == r3.getEasyNetworkType().getNumber()) goto L5;
    L8:
        e = r3;
        return true;
    L5:
        if (TextUtils.equals(e.getNetworkId(), r3.getNetworkId()) == false) goto L8;
        return false;
    }

    public static boolean c(ConnectivityManager r3, Network r4) {
        boolean r1 = false;
        if (r4 != null) goto L19;
        Log.w("NetworkTypeDetector", "hasVPN network==null no VPN");
        return false;
    L19:
        NetworkCapabilities r5 = r3.getNetworkCapabilities(r4);     // Catch: Exception -> L15
        if (r5 != null) goto L9;
    L11:
        if (r5 == null) goto L13;
        Log.i("NetworkTypeDetector", "hasVPN network capabilities has no VPN");     // Catch: Exception -> L15
    L18:
    L17:
        return r1;
    L13:
        Log.i("NetworkTypeDetector", "hasVPN network capabilities == null");     // Catch: Exception -> L15
        goto L18
    L9:
        if (r5.hasTransport(4) == false) goto L11;
        r1 = true;
        Log.i("NetworkTypeDetector", "hasVPN network capabilities has VPN");     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.e("NetworkTypeDetector", "has VPN() method crash, crashInfo:" + e.toString());
        goto L17
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r4, Intent r5) {
        if (r4 == null) goto L29;
        if (r5 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r5.getAction()) == false) goto L10;
        return;
    L10:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r5.getAction()) == false) goto L30;
        NetworkUtils.NetworkType r6 = NetworkUtils.b(r4);     // Catch: Exception -> L25
        ConnectivityManager r7 = (ConnectivityManager) r4.getApplicationContext().getSystemService("connectivity");     // Catch: Exception -> L25
        EasyNetworkType r8 = EasyNetworkType.getBasicEasyType(r6);     // Catch: Exception -> L25
        if (b(r7) == false) goto L15;
        r8 = EasyNetworkType.VPN;     // Catch: Exception -> L25
    L15:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        Network r9 = r7.getActiveNetwork();     // Catch: Exception -> L25
        if (r9 == null) goto L19;
        String r10 = String.valueOf(r9.getNetworkHandle());     // Catch: Exception -> L25
    L21:
        if (e(new EasyNetworkState(r8, r10)) == false) goto L23;
        d();     // Catch: Exception -> L25
        return;
    L23:
        Log.i("NetworkTypeDetector", "onReceive end: NetworkType does not change");     // Catch: Exception -> L25
        return;
    L19:
        r10 = BuildConfig.FLAVOR;
    L25:
        e = move-exception;
        e.printStackTrace();
        Log.e("NetworkTypeDetector", "onReceive: exp on NetworkTypeChange", e);
        return;
    L30:
        return;
    }
}
