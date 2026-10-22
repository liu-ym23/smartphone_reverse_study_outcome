package com.obric.cae.userAware;

import android.content.Context;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AlipayActivityMonitor {
    private static final String ALIPAY_PACKAGE = "com.eg.android.AlipayGphone";
    private static final String ALIPAY_RIDING_CODE_ACTIVITY = "com.alipay.android.phone.xriver.bundlex.CSGAPushActivity";
    private static final String TAG = "AlipayActivityMonitor";
    private static volatile AlipayActivityMonitor sInstance;
    private ActivityMonitor mActivityMonitor;
    private final ActivityMonitor.ActivityMonitorListenerEx mActivityMonitorListener;
    private Context mContext;
    private boolean mIsAlipayInForeground;
    private boolean mIsListenerRegistered;
    private final CopyOnWriteArrayList<AlipayRidingCodeListener> mListeners;

    public interface AlipayRidingCodeListener {
        void onAlipayRidingCodeShow();
    }

    private AlipayActivityMonitor() {
        this.mIsListenerRegistered = false;
        this.mIsAlipayInForeground = false;
        this.mListeners = new CopyOnWriteArrayList();
        this.mActivityMonitorListener = new AnonymousClass1(this);
    }

    public static /* synthetic */ boolean access$000(AlipayActivityMonitor r8) {
        return r8.mIsAlipayInForeground;
    }

    public static /* synthetic */ boolean access$002(AlipayActivityMonitor r8, boolean r10) {
        r8.mIsAlipayInForeground = r10;
        return r10;
    }

    public static /* synthetic */ void access$100(AlipayActivityMonitor r8) {
        r8.notifyRidingCodeShow();
    }

    public static AlipayActivityMonitor getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(AlipayActivityMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AlipayActivityMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AlipayActivityMonitor.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void notifyRidingCodeShow() {
        CaeLog.i(TAG, "Alipay riding code show detected");
        Iterator<AlipayRidingCodeListener> r8 = this.mListeners.iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        r8.next().onAlipayRidingCodeShow();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        CaeLog.e(TAG, "Failed to notify listener", e);
        goto L4
    }

    public void init(Context r8) {
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mActivityMonitor = ActivityMonitor.getInstance(r10);
        CaeLog.d(TAG, "AlipayActivityMonitor initialized");
    }

    public void registerListener(AlipayRidingCodeListener r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.mListeners.contains(r8) == true) goto L8;
        this.mListeners.add(r8);
        return;
    }

    public void startListening() {
        if (this.mIsListenerRegistered == true) goto L9;
        ActivityMonitor r8 = this.mActivityMonitor;
        if (r8 == null) goto L10;
        r8.registerActivityListener(this.mActivityMonitorListener);
        this.mIsListenerRegistered = true;
        CaeLog.d(TAG, "Start listening Alipay activity changes");
        return;
    L10:
        return;
    }

    public void stopListening() {
        if (this.mIsListenerRegistered == false) goto L9;
        ActivityMonitor r8 = this.mActivityMonitor;
        if (r8 == null) goto L10;
        r8.unregisterActivityListener(this.mActivityMonitorListener);
        this.mIsListenerRegistered = false;
        CaeLog.d(TAG, "Stop listening Alipay activity changes");
        return;
    L10:
        return;
    }

    public void unregisterListener(AlipayRidingCodeListener r8) {
        if (r8 == null) goto L5;
        this.mListeners.remove(r8);
        return;
    }
}
