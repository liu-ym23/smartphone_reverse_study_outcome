package com.obric.cae.userAware.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.obric.cae.R;
import com.obric.cae.libs.location.IStarLocationService;
import com.obric.cae.libs.location.poi.IStarPoiCallback;
import com.obric.cae.libs.location.poi.IStarPoiManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.datacollection.PoiArrivalFeedbackInfo;
import com.obric.cae.userAware.db.PoiArrivalRecordDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class StoreArrivalEventManager {
    private static final int MAX_ARRIVAL_RECORD_COUNT = 100;
    private static final String NOTIFICATION_CHANNEL_ID = "store_arrival_channel";
    private static final String STAR_LOCATION_SERVICE_ACTION = "com.obric.cae.libs.location.IStarLocationService";
    private static final String STORE_ARRIVAL_ACTIVITY_CLASS_NAME = "com.obric.cae.userAware.ui.StoreArrivalActivity";
    private static final String TAG = "StoreArrivalEventManager";
    private static Context sAppContext;
    private static final CopyOnWriteArrayList<PoiArrivalFeedbackInfo> sArrivalRecords = null;
    private static boolean sBound;
    private static boolean sExternalCallbackRegistered;
    private static final Set<Listener> sListeners = null;
    private static IStarLocationService sLocationService;
    private static final Object sLock = null;
    private static final Handler sMainHandler = null;
    private static final IStarPoiCallback sNearPoiCallback = null;
    private static IStarPoiManager sPoiManager;
    private static boolean sRegistered;
    private static final ServiceConnection sServiceConnection = null;

    public static final class HistoryLoadTask {
        private HistoryRecordsCallback mCallback;
        private volatile boolean mCanceled;
        private Runnable mDeliverRunnable;
        private final Object mTaskLock;

        private HistoryLoadTask(HistoryRecordsCallback r8) {
            this.mTaskLock = new Object();
            this.mCallback = r8;
        }

        public static /* synthetic */ void a(HistoryLoadTask r8, ArrayList r10) {
            r8.lambda$start$0(r10);
        }

        public static /* synthetic */ void access$800(HistoryLoadTask r8) {
            r8.start();
        }

        public static /* synthetic */ void b(HistoryLoadTask r8) {
            r8.lambda$start$1();
        }

        private void clearCallback() {
            Object r8 = this.mTaskLock;
            monitor-enter(r8);
            this.mCallback = null;     // Catch: Throwable -> L8
            this.mDeliverRunnable = null;     // Catch: Throwable -> L8
            monitor-exit(r8);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void deliver(ArrayList<PoiArrivalFeedbackInfo> r8) {
            Object r10 = this.mTaskLock;
            monitor-enter(r10);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.mCanceled == false) goto L9;
            this.mCallback = null;     // Catch: Throwable -> L14
            this.mDeliverRunnable = null;     // Catch: Throwable -> L14
            monitor-exit(r10);     // Catch: Throwable -> L14
            return;
        L9:
            HistoryRecordsCallback r11 = this.mCallback;     // Catch: Throwable -> L14
            this.mCallback = null;     // Catch: Throwable -> L14
            this.mDeliverRunnable = null;     // Catch: Throwable -> L14
            monitor-exit(r10);     // Catch: Throwable -> L14
            if (r11 == null) goto L18;
            r11.onHistoryRecordsLoaded(r8);
            return;
        }

        private /* synthetic */ void lambda$start$0(ArrayList r8) {
            if (this.mCanceled == false) goto L6;
            clearCallback();
            return;
        L6:
            deliver(r8);
        }

        private /* synthetic */ void lambda$start$1() {
            ArrayList r8 = StoreArrivalEventManager.access$1000();
            if (this.mCanceled == false) goto L6;
            clearCallback();
            return;
        L6:
            e1 r10 = new e1(2, this, r8);
            Object r11 = this.mTaskLock;
            monitor-enter(r11);
        L17:
            th = move-exception;
            throw th;
        L9:
            if (this.mCanceled == false) goto L13;
            this.mCallback = null;     // Catch: Throwable -> L17
            monitor-exit(r11);     // Catch: Throwable -> L17
            return;
        L13:
            this.mDeliverRunnable = r10;     // Catch: Throwable -> L17
            monitor-exit(r11);     // Catch: Throwable -> L17
            StoreArrivalEventManager.access$900().post(r10);
        }

        private void start() {
            new Thread(new androidx.activity.k(this, 26), "StoreArrivalHistoryLoader").start();
        }

        public void cancel() {
            Object r8 = this.mTaskLock;
            monitor-enter(r8);
            this.mCanceled = true;     // Catch: Throwable -> L10
            this.mCallback = null;     // Catch: Throwable -> L10
            Runnable r10 = this.mDeliverRunnable;     // Catch: Throwable -> L10
            this.mDeliverRunnable = null;     // Catch: Throwable -> L10
            monitor-exit(r8);     // Catch: Throwable -> L10
            if (r10 == null) goto L15;
            StoreArrivalEventManager.access$900().removeCallbacks(r10);
            return;
        L15:
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ HistoryLoadTask(HistoryRecordsCallback r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public interface HistoryRecordsCallback {
        void onHistoryRecordsLoaded(ArrayList<PoiArrivalFeedbackInfo> r8);
    }

    public interface Listener {
        void onStoreArrivalEvent(PoiArrivalFeedbackInfo r8);

        default void onStoreArrivalFeedbackUpdated(PoiArrivalFeedbackInfo r8) {
        }
    }

    static {
        sLock = new Object();
        sArrivalRecords = new CopyOnWriteArrayList();
        sListeners = Collections.newSetFromMap(new WeakHashMap());
        sMainHandler = new Handler(Looper.getMainLooper());
        sNearPoiCallback = new AnonymousClass1();
        sServiceConnection = new AnonymousClass2();
    }

    private StoreArrivalEventManager() {
    }

    public static /* synthetic */ void a(ArrayList r8, PoiArrivalFeedbackInfo r10) {
        lambda$notifyPoiArrivalFeedbackUpdated$0(r8, r10);
    }

    public static /* synthetic */ PoiArrivalFeedbackInfo access$000(Bundle r8) {
        return handleNearPoiReport(r8);
    }

    public static /* synthetic */ Object access$100() {
        return sLock;
    }

    public static /* synthetic */ ArrayList access$1000() {
        return getHistoryRecords();
    }

    public static /* synthetic */ IStarLocationService access$200() {
        return sLocationService;
    }

    public static /* synthetic */ IStarLocationService access$202(IStarLocationService r8) {
        sLocationService = r8;
        return r8;
    }

    public static /* synthetic */ IStarPoiManager access$302(IStarPoiManager r8) {
        sPoiManager = r8;
        return r8;
    }

    public static /* synthetic */ void access$400() {
        registerNearPoiCallbackLocked();
    }

    public static /* synthetic */ boolean access$502(boolean r8) {
        sRegistered = r8;
        return r8;
    }

    public static /* synthetic */ boolean access$602(boolean r8) {
        sExternalCallbackRegistered = r8;
        return r8;
    }

    public static /* synthetic */ Handler access$900() {
        return sMainHandler;
    }

    private static void addArrivalRecordLocked(PoiArrivalFeedbackInfo r8) {
        sArrivalRecords.add(0, r8);
    L3:
        CopyOnWriteArrayList<PoiArrivalFeedbackInfo> r10 = sArrivalRecords;
        if (r10.size() <= 100) goto L6;
        r10.remove(r10.size() - 1);
        goto L3
    }

    public static void addListener(Listener r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        sListeners.add(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void b(ArrayList r8, PoiArrivalFeedbackInfo r10) {
        lambda$handleNearPoiReport$1(r8, r10);
    }

    private static void bindStarLocationServiceLocked() {
        Context r8 = sAppContext;
        if (r8 != null) goto L5;
        return;
    L5:
        if (sBound == true) goto L19;
        Intent r10 = new Intent(STAR_LOCATION_SERVICE_ACTION);
        r10.setPackage(r8.getPackageName());
        boolean r11 = r8.bindService(r10, sServiceConnection, 1);     // Catch: Exception -> L12
        sBound = r11;     // Catch: Exception -> L12
        if (r11 == true) goto L18;
        CaeLog.e(TAG, "bind StarLocationService failed");     // Catch: Exception -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        CaeLog.e(TAG, "bind StarLocationService exception", e);
        return;
    }

    private static String buildCategoryText(Bundle r8) {
        return r8.getString("new_type_name_l1", "") + ";" + r8.getString("new_type_name_l2", "") + ";" + r8.getString("new_type_name_l3", "");
    }

    private static PoiArrivalFeedbackInfo buildFeedbackInfo(Bundle r8) {
        PoiArrivalFeedbackInfo r10 = new PoiArrivalFeedbackInfo();
        r10.setTimeStamp(r8.getLong("timestamp", 0));
        r10.setAoiName(r8.getString("aoi_name", ""));
        r10.setPoiName(r8.getString("poi_name", ""));
        r10.setCategory(buildCategoryText(r8));
        return r10;
    }

    private static String buildNotificationContent(PoiArrivalFeedbackInfo r8) {
        String r10 = TextUtils.join(" ", new String[]{nullToEmpty(r8.getAoiName()), nullToEmpty(r8.getPoiName())}).trim();
        String r11 = r8.getCategory();
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return r10;
    L5:
        if (";;".equals(r11) == false) goto L7;
        return r10;
    L7:
        return defpackage.a.f(r10, " ", r11);
    }

    public static void ensureRegistered(Context r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        sAppContext = r8.getApplicationContext();     // Catch: Throwable -> L19
        if (sRegistered == false) goto L7;
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L7:
        if (sExternalCallbackRegistered == true) goto L17;
        if (sPoiManager == null) goto L14;
        registerNearPoiCallbackLocked();     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L14:
        bindStarLocationServiceLocked();     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private static ArrayList<PoiArrivalFeedbackInfo> getHistoryRecords() {
        Object r8 = sLock;
        monitor-enter(r8);
        Context r10 = sAppContext;     // Catch: Throwable -> L12
        if (r10 != null) goto L9;
        ArrayList<PoiArrivalFeedbackInfo> r11 = new ArrayList(sArrivalRecords);     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
        return r11;
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L12
        return new ArrayList(new PoiArrivalRecordDatabase(r10).getRecords(100));
    L12:
        th = move-exception;
        throw th;
    }

    private static PoiArrivalFeedbackInfo handleNearPoiReport(Bundle r8) {
        String r10 = r8.getString("aoi_name", "");
        String r11 = r8.getString("poi_name", "");
        if (TextUtils.isEmpty(r10) == true) goto L5;
    L8:
        PoiArrivalFeedbackInfo r12 = buildFeedbackInfo(r8);
        persistPoiArrivalRecord(r12);
        Object r13 = sLock;
        monitor-enter(r13);
        addArrivalRecordLocked(r12);     // Catch: Throwable -> L14
        ArrayList r14 = new ArrayList(sListeners);     // Catch: Throwable -> L14
        monitor-exit(r13);     // Catch: Throwable -> L14
        showStoreArrivalNotification(r12);
        sMainHandler.post(new f1(4, r14, r12));
        return r12;
    L14:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return null;
    }

    private static boolean isPoiDetectEnabled(Context r8) {
        if (Settings.Global.getInt(r8.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isSameRecord(PoiArrivalFeedbackInfo r8, PoiArrivalFeedbackInfo r10) {
        if (r8.getId() == (-1)) goto L12;
        if (r10.getId() == (-1)) goto L12;
        if (r8.getId() != r10.getId()) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (r8.getTimeStamp() != r10.getTimeStamp()) goto L21;
        if (TextUtils.equals(r8.getPoiName(), r10.getPoiName()) == false) goto L21;
        if (TextUtils.equals(r8.getAoiName(), r10.getAoiName()) == false) goto L21;
        if (TextUtils.equals(r8.getCategory(), r10.getCategory()) == false) goto L21;
        return true;
    L21:
        return false;
    }

    private static boolean isStoreArrivalPageVisible(Context r8) {
        ComponentName r10 = new ComponentName(r8, STORE_ARRIVAL_ACTIVITY_CLASS_NAME);
        if (r8.getPackageManager().getComponentEnabledSetting(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static /* synthetic */ void lambda$handleNearPoiReport$1(ArrayList r8, PoiArrivalFeedbackInfo r10) {
        notifyListeners(r8, r10);
    }

    private static /* synthetic */ void lambda$notifyPoiArrivalFeedbackUpdated$0(ArrayList r8, PoiArrivalFeedbackInfo r10) {
        notifyFeedbackUpdated(r8, r10);
    }

    public static HistoryLoadTask loadHistoryRecordsAsync(HistoryRecordsCallback r8) {
        HistoryLoadTask r10 = new HistoryLoadTask(r8, null);
        HistoryLoadTask.access$800(r10);
        return r10;
    }

    private static void notifyFeedbackUpdated(ArrayList<Listener> r8, PoiArrivalFeedbackInfo r10) {
        Iterator<Listener> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onStoreArrivalFeedbackUpdated(r10);
        goto L4
    }

    private static void notifyListeners(ArrayList<Listener> r8, PoiArrivalFeedbackInfo r10) {
        Iterator<Listener> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onStoreArrivalEvent(r10);
        goto L4
    }

    public static void notifyPoiArrivalFeedbackUpdated(PoiArrivalFeedbackInfo r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        updateRecordFeedbackLocked(r8);     // Catch: Throwable -> L8
        ArrayList r11 = new ArrayList(sListeners);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        sMainHandler.post(new p0(r11, r8));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static String nullToEmpty(String r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        return r8;
    }

    public static void onExternalNearPoiCallbackRegistered() {
        Object r8 = sLock;
        monitor-enter(r8);
        sExternalCallbackRegistered = true;     // Catch: Throwable -> L8
        sRegistered = false;     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void onExternalNearPoiCallbackUnregistered() {
        Object r8 = sLock;
        monitor-enter(r8);
        sExternalCallbackRegistered = false;     // Catch: Throwable -> L13
        if (sPoiManager == null) goto L9;
        registerNearPoiCallbackLocked();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L9:
        if (sAppContext == null) goto L11;
        bindStarLocationServiceLocked();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public static PoiArrivalFeedbackInfo onNearPoiReportFromExternalCallback(Bundle r8) {
        return handleNearPoiReport(new Bundle(r8));
    }

    public static void onUserAwareEntryHidden(Context r8) {
        PoiArrivalNotificationHelper.cancel(r8.getApplicationContext());
    }

    private static void persistPoiArrivalRecord(PoiArrivalFeedbackInfo r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        Context r11 = sAppContext;     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        new PoiArrivalRecordDatabase(r11).insertOrGetRecord(r8);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static void registerNearPoiCallbackLocked() {
        IStarPoiManager r8 = sPoiManager;
        if (r8 != null) goto L5;
        return;
    L5:
        if (sRegistered == false) goto L7;
        return;
    L7:
        if (sExternalCallbackRegistered == true) goto L18;
        r8.registerNearPoiCallback(sNearPoiCallback);     // Catch: Throwable -> L11
        sRegistered = true;     // Catch: Throwable -> L11
        CaeLog.d(TAG, "registerNearPoiCallback success");     // Catch: Throwable -> L11
        return;
    L11:
        e = move-exception;
        CaeLog.e(TAG, "registerNearPoiCallback failed", e);
        return;
    }

    public static void removeListener(Listener r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        sListeners.remove(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void showStoreArrivalNotification(PoiArrivalFeedbackInfo r8) {
        Object r10 = sLock;
        monitor-enter(r10);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (sExternalCallbackRegistered == false) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L8:
        Context r11 = sAppContext;     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L18
        if (r11 != null) goto L12;
        return;
    L12:
        if (isPoiDetectEnabled(r11) == true) goto L14;
        return;
    L14:
        if (isStoreArrivalPageVisible(r11) == false) goto L24;
        String r12 = buildNotificationContent(r8);
        PoiArrivalNotificationHelper.createChannel(r11, NOTIFICATION_CHANNEL_ID, r11.getString(R.string.user_aware_store_arrival_title), r11.getString(R.string.user_aware_store_arrival_title));
        PoiArrivalNotificationHelper.show(r11, TAG, NOTIFICATION_CHANNEL_ID, StoreArrivalActivity.class, r11.getString(R.string.user_aware_store_arrival_title), r12);
        return;
    }

    private static void unbindStarLocationServiceLocked() {
        Context r8 = sAppContext;
        if (r8 != null) goto L5;
        return;
    L5:
        if (sBound == true) goto L19;
        return;
    L19:
        r8.unbindService(sServiceConnection);     // Catch: Throwable -> L10 Exception -> L12
    L9:
        sBound = false;
        sLocationService = null;
        sPoiManager = null;
        return;
    L12:
        e = move-exception;
        CaeLog.e(TAG, "unbind StarLocationService failed", e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        sBound = false;
        sLocationService = null;
        sPoiManager = null;
        throw th;
    }

    public static void unregister() {
        Object r8 = sLock;
        monitor-enter(r8);
        unregisterNearPoiCallbackLocked();     // Catch: Throwable -> L7
        unbindStarLocationServiceLocked();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void unregisterNearPoiCallbackLocked() {
        IStarPoiManager r8 = sPoiManager;
        if (r8 != null) goto L5;
        return;
    L5:
        if (sRegistered == true) goto L19;
        return;
    L19:
        r8.unregisterNearPoiCallback();     // Catch: Throwable -> L10 Throwable -> L12
        CaeLog.d(TAG, "unregisterNearPoiCallback success");     // Catch: Throwable -> L10 Throwable -> L12
    L9:
        sRegistered = false;
        return;
    L12:
        e = move-exception;
        CaeLog.e(TAG, "unregisterNearPoiCallback failed", e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        sRegistered = false;
        throw th;
    }

    private static void updateRecordFeedbackLocked(PoiArrivalFeedbackInfo r8) {
        Iterator<PoiArrivalFeedbackInfo> r10 = sArrivalRecords.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        PoiArrivalFeedbackInfo r11 = r10.next();
        if (isSameRecord(r11, r8) == false) goto L4;
        r11.setId(r8.getId());
        r11.setHasFeedback(r8.getHasFeedback());
        r11.setUserChoice(r8.getUserChoice());
        r11.setFeedbackTime(r8.getFeedbackTime());
        goto L4
    }
}
