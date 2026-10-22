package com.bytedance.bdinstall;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.Singleton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class SubpSyncManager {
    private static final String EVENT_INSTALL_INFO_CHANGE = "install_info_change";
    static final String F_NAME_MULTI_PROCESS = "ug_install_op_pref";
    private static final Singleton<SubpSyncManager> INSTANCE = null;
    public static final String KEY_EVENT_AID = "aid";
    private static final String KEY_EVENT_KEY = "key";
    private static final String KEY_EVENT_VALUE = "value";
    private static final Map<String, String> sCacheValues = null;
    private static final Map<String, List<OnUpdateListener>> sListeners = null;
    private final Context mContext;
    private AtomicBoolean mHasObserve;

    public interface OnUpdateListener {
        void onUpdate(String r10, String r11);
    }

    static {
        sCacheValues = new ConcurrentHashMap();
        sListeners = new ConcurrentHashMap();
        INSTANCE = new AnonymousClass1();
    }

    private SubpSyncManager(Context r10) {
        this.mHasObserve = new AtomicBoolean(false);
        this.mContext = r10;
    }

    /* synthetic */ SubpSyncManager(Context r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ Context access$100(SubpSyncManager r10) {
        return r10.mContext;
    }

    static /* synthetic */ void access$200(SubpSyncManager r10, Uri r11) {
        r10.notifyWithUri(r11);
    }

    static SubpSyncManager inst(Context r10) {
        return INSTANCE.get(new Object[]{r10});
    }

    private void notifyWithUri(Uri r10) {
        monitor-enter(this);
        String r11 = r10.getQueryParameter(KEY_EVENT_KEY);     // Catch: Throwable -> L17
        String r12 = r10.getQueryParameter("value");     // Catch: Throwable -> L17
        String r13 = r10.getQueryParameter("aid");     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r11) == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L7:
        sCacheValues.put(r11, r12);     // Catch: Throwable -> L17
        DrLog.d("install_info 发送到子进程 onUpdate " + r12 + " aid ：" + r13);     // Catch: Throwable -> L17
        List<OnUpdateListener> r14 = sListeners.get(r11);     // Catch: Throwable -> L17
        if (r14 == null) goto L15;
        Iterator<OnUpdateListener> r15 = r14.iterator();     // Catch: Throwable -> L17
    L11:
        if (r15.hasNext() == false) goto L15;
        OnUpdateListener r16 = r15.next();     // Catch: Throwable -> L17
        if (r16 == null) goto L11;
        r16.onUpdate(r12, r13);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void observer() {
        if (this.mHasObserve.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Uri r10 = BDInstallProvider.getContentUri(this.mContext, EVENT_INSTALL_INFO_CHANGE);
        if (r10 != null) goto L8;
        return;
    L8:
        ContentResolver r11 = this.mContext.getContentResolver();
        final Handler r12 = ExecutorUtil.getFirstHandler();
        r11.registerContentObserver(r10, true, new AnonymousClass3(this, r12));
    }

    private void putToListenerCache(String r10, OnUpdateListener r11) {
        Map<String, List<OnUpdateListener>> r12 = sListeners;
        List<OnUpdateListener> r13 = r12.get(r10);
        if (r13 != null) goto L5;
        r13 = new ArrayList();
        r12.put(r10, r13);
    L5:
        r13.add(r11);
    }

    private void tryNotify(String r10, String r11, OnUpdateListener r12) {
        if (r12 == null) goto L5;
        r12.onUpdate(r10, r11);
        return;
    }

    void observer(String r10, String r11, OnUpdateListener r12) {
        observer();
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        putToListenerCache(r11, r12);     // Catch: Throwable -> L16
        Map<String, String> r13 = sCacheValues;     // Catch: Throwable -> L16
        if (r13.containsKey(r11) == false) goto L11;
        tryNotify(r13.get(r11), r10, r12);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L11:
        String r14 = this.mContext.getSharedPreferences(F_NAME_MULTI_PROCESS, 0).getString(r11 + "_" + r10, null);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r14) == true) goto L14;
        tryNotify(r14, r10, r12);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    void sendSubpEvent(final String r10, String r11, String r12) {
        this.mContext.getSharedPreferences(F_NAME_MULTI_PROCESS, 0).edit().putString(r11 + "_" + r10, r12).apply();     // Catch: Exception -> L7
        Uri r13 = BDInstallProvider.getContentUri(this.mContext, EVENT_INSTALL_INFO_CHANGE);     // Catch: Exception -> L7
        if (r13 != null) goto L5;
        return;
    L5:
        final Uri r14 = r13.buildUpon().appendQueryParameter(KEY_EVENT_KEY, r11).appendQueryParameter("aid", r10).appendQueryParameter("value", r12).build();     // Catch: Exception -> L7
        final int[] r15 = new int[1];     // Catch: Exception -> L7
        new AnonymousClass2(this, r14, r15, r10).run();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        DrLog.e("sendSubpEvent error", e);
    }
}
