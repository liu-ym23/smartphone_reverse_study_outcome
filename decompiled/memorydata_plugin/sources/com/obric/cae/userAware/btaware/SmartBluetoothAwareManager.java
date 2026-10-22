package com.obric.cae.userAware.btaware;

import android.bluetooth.le.ScanResult;
import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class SmartBluetoothAwareManager {
    private static final String TAG = "SmartBluetoothAwareManager";
    private static SmartBluetoothEBikeAware mEBikeAware;
    private static volatile SmartBluetoothAwareManager sInstance;
    private final List<SmartBluetoothAwareListener> mBluetoothAwareListenerList;
    private final Context mContext;

    private SmartBluetoothAwareManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mBluetoothAwareListenerList = new CopyOnWriteArrayList();
        a.g(TAG, TAG);
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public static SmartBluetoothAwareManager getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (sInstance != null) goto L15;
        monitor-enter(SmartBluetoothAwareManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmartBluetoothAwareManager(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmartBluetoothAwareManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void addSmartBluetoothAwareListener(SmartBluetoothAwareListener r3) {
        SmartBluetoothAwareListener r4 = (SmartBluetoothAwareListener) ZeusTransformUtils.wrapperContextForParams(r3, SmartBluetoothAwareListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        List<SmartBluetoothAwareListener> r0 = this.mBluetoothAwareListenerList;
        monitor-enter(r0);
        this.mBluetoothAwareListenerList.add(r4);     // Catch: Throwable -> L10
        a.c(TAG, "add listener to mBluetoothAwareListenerList");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void cleanup() {
        this.mBluetoothAwareListenerList.clear();
        SmartBluetoothEBikeAware r0 = mEBikeAware;
        if (r0 == null) goto L5;
        r0.cleanup();
    L5:
        sInstance = null;
    }

    public List<SmartBluetoothAwareListener> getSmartBluetoothAwareListenerList() {
        return this.mBluetoothAwareListenerList;
    }

    public void init() {
        a.c(TAG, CommonConsts.APM_INNER_EVENT_COST_INIT);
        mEBikeAware = SmartBluetoothEBikeAware.getInstance(this.mContext);
    }

    public void onScanResult(int r1, ScanResult r2) {
        a.c(TAG, "onScanResult " + r2.getDevice());
        SmartBluetoothEBikeAware r0 = mEBikeAware;
        if (r0 == null) goto L6;
        r0.onScanResult(r2);
        return;
    }

    public void removeSmartBluetoothAwareListener(SmartBluetoothAwareListener r3) {
        SmartBluetoothAwareListener r4 = (SmartBluetoothAwareListener) ZeusTransformUtils.wrapperContextForParams(r3, SmartBluetoothAwareListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        List<SmartBluetoothAwareListener> r0 = this.mBluetoothAwareListenerList;
        monitor-enter(r0);
        this.mBluetoothAwareListenerList.remove(r4);     // Catch: Throwable -> L10
        a.c(TAG, "remove listener from mBluetoothAwareListenerList");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
