package com.bytedance.badger.collect.impl.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.utils.ExecutorManager;
import com.bytedance.badger.collect.impl.utils.KLog;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class NetworkObserver {
    private final Context mContext;
    private final AtomicBoolean mHasListenNetwork;
    private final Set<WeakReference<OnNetworkReadyListener>> mListeners;

    public interface OnNetworkReadyListener {
        void onNetworkReady();
    }

    private synchronized void notifyObserver() {
        monitor-enter(this);
        ExecutorManager.getInstance().getHandler().post(new AnonymousClass2(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void tryListenNetChange() {
        if (this.mHasListenNetwork.compareAndSet(false, true) == false) goto L12;
        BroadcastReceiver r0 = new AnonymousClass1(this);
        IntentFilter r1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        INVOKEVIRTUAL_com_bytedance_badger_collect_impl_network_NetworkObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, r0, r1);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        KLog.e(Constants.TAGS.NETWORK, e.getMessage());
        return;
    }

    public NetworkObserver(Context r3) {
        this.mListeners = Collections.synchronizedSet(new HashSet());
        this.mHasListenNetwork = new AtomicBoolean(false);
        this.mContext = r3;
    }

    public static /* synthetic */ Context access$000(NetworkObserver r0) {
        return r0.mContext;
    }

    public static /* synthetic */ void access$100(NetworkObserver r0) {
        r0.notifyObserver();
    }

    public static /* synthetic */ Set access$200(NetworkObserver r0) {
        return r0.mListeners;
    }

    public synchronized void observe(OnNetworkReadyListener r3) {
        monitor-enter(this);
        this.mListeners.add(new WeakReference(r3));     // Catch: Throwable -> L6
        tryListenNetChange();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void unObserve(OnNetworkReadyListener r3) {
        monitor-enter(this);
        Iterator<WeakReference<OnNetworkReadyListener>> r0 = this.mListeners.iterator();     // Catch: Throwable -> L14
    L5:
        if (r0.hasNext() == false) goto L12;
        WeakReference<OnNetworkReadyListener> r1 = r0.next();     // Catch: Throwable -> L14
        if (r1 == null) goto L8;
        if (r1.get() != r3) goto L5;
        r0.remove();     // Catch: Throwable -> L14
        goto L12
    L8:
        r0.remove();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_badger_collect_impl_network_NetworkObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }
}
