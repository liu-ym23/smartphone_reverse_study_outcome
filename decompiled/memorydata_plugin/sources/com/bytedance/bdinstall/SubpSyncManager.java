package com.bytedance.bdinstall;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.Singleton;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        void onUpdate(String r1, String r2);
    }

    static {
        sCacheValues = new ConcurrentHashMap();
        sListeners = new ConcurrentHashMap();
        INSTANCE = new AnonymousClass1();
    }

    private SubpSyncManager(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mHasObserve = new AtomicBoolean(false);
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
    }

    /* synthetic */ SubpSyncManager(Context r2, AnonymousClass1 r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Context access$100(SubpSyncManager r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$200(SubpSyncManager r0, Uri r1) {
        r0.notifyWithUri(r1);
    }

    static SubpSyncManager inst(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return (SubpSyncManager) ZeusTransformUtils.preCheckCast(INSTANCE.get(new Object[]{r5}), SubpSyncManager.class, "com.obric.memorydata.plugin");
    }

    private void notifyWithUri(Uri r6) {
        monitor-enter(this);
        String r0 = r6.getQueryParameter(KEY_EVENT_KEY);     // Catch: Throwable -> L21
        String r1 = r6.getQueryParameter("value");     // Catch: Throwable -> L21
        String r7 = r6.getQueryParameter("aid");     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r0) == false) goto L6;
    L18:
        DrLog.e("multi process: key or value is nullvalue: " + r1 + " aid ：" + r7);     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L18;
        sCacheValues.put(r0, r1);     // Catch: Throwable -> L21
        DrLog.d("install_info 发送到子进程 onUpdate " + r1 + " aid ：" + r7);     // Catch: Throwable -> L21
        List r2 = (List) ZeusTransformUtils.preCheckCast(sListeners.get(r0), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r2 == null) goto L16;
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L21
    L12:
        if (r3.hasNext() == false) goto L16;
        OnUpdateListener r4 = (OnUpdateListener) ZeusTransformUtils.preCheckCast(r3.next(), OnUpdateListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r4 == null) goto L12;
        r4.onUpdate(r1, r7);     // Catch: Throwable -> L21
    L16:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    private void observer() {
        if (this.mHasObserve.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Uri r0 = BDInstallProvider.getContentUri(this.mContext, EVENT_INSTALL_INFO_CHANGE);
        if (r0 != null) goto L8;
        return;
    L8:
        ContentResolver r1 = this.mContext.getContentResolver();
        final Handler r4 = ExecutorUtil.getFirstHandler();
        ZeusProviderTransform.registerContentObserver(r1, r0, true, new AnonymousClass3(this, r4), "com.obric.memorydata.plugin");
    }

    private void putToListenerCache(String r4, OnUpdateListener r5) {
        OnUpdateListener r3 = (OnUpdateListener) ZeusTransformUtils.wrapperContextForParams(r5, OnUpdateListener.class, "com.obric.memorydata.plugin");
        Map<String, List<OnUpdateListener>> r6 = sListeners;
        List<OnUpdateListener> r0 = (List) ZeusTransformUtils.preCheckCast(r6.get(r4), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        r6.put(r4, r0);
    L5:
        r0.add(r3);
    }

    private void tryNotify(String r2, String r3, OnUpdateListener r4) {
        OnUpdateListener r1 = (OnUpdateListener) ZeusTransformUtils.wrapperContextForParams(r4, OnUpdateListener.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.onUpdate(r2, r3);
        return;
    }

    void observer(String r4, String r5, OnUpdateListener r6) {
        OnUpdateListener r7 = (OnUpdateListener) ZeusTransformUtils.wrapperContextForParams(r6, OnUpdateListener.class, "com.obric.memorydata.plugin");
        observer();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        putToListenerCache(r5, r7);     // Catch: Throwable -> L16
        Map<String, String> r0 = sCacheValues;     // Catch: Throwable -> L16
        if (r0.containsKey(r5) == false) goto L11;
        tryNotify((String) ZeusTransformUtils.preCheckCast(r0.get(r5), String.class, "com.obric.memorydata.plugin"), r4, r7);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L11:
        String r8 = this.mContext.getSharedPreferences(F_NAME_MULTI_PROCESS, 0).getString(r5 + "_" + r4, null);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r8) == true) goto L14;
        tryNotify(r8, r4, r7);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    void sendSubpEvent(final String r4, String r5, String r6) {
        this.mContext.getSharedPreferences(F_NAME_MULTI_PROCESS, 0).edit().putString(r5 + "_" + r4, r6).apply();     // Catch: Exception -> L7
        Uri r0 = BDInstallProvider.getContentUri(this.mContext, EVENT_INSTALL_INFO_CHANGE);     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        return;
    L5:
        final Uri r7 = r0.buildUpon().appendQueryParameter(KEY_EVENT_KEY, r5).appendQueryParameter("aid", r4).appendQueryParameter("value", r6).build();     // Catch: Exception -> L7
        final int[] r8 = new int[1];     // Catch: Exception -> L7
        new AnonymousClass2(this, r7, r8, r4).run();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        DrLog.e("sendSubpEvent error", e);
    }
}
