package com.obric.cae.userAware.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.obric.cae.R;
import com.obric.cae.libs.location.IStarLocationService;
import com.obric.cae.libs.location.poi.IStarPoiCallback;
import com.obric.cae.libs.location.poi.IStarPoiManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.datacollection.PoiArrivalFeedbackInfo;
import com.obric.cae.userAware.db.PoiArrivalRecordDatabase;
import com.obric.oui.titlebar.OCTitleBar;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class PoiArrivalActivity extends Activity implements StoreArrivalEventManager.Listener {
    private static final String CHANNEL_ID = "poi_arrival_channel";
    private static final ExecutorService DB_EXECUTOR = null;
    private static final String KEY_AOI_NAME = "aoi_name";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_NEAR_POI_AOI_NAME = "aoi_name";
    private static final String KEY_NEAR_POI_POI_NAME = "poi_name";
    private static final String KEY_NEAR_POI_TIMESTAMP = "timestamp";
    private static final String KEY_POI_NAME = "poi_name";
    private static final Handler MAIN_HANDLER = null;
    private static final int MAX_ARRIVAL_RECORD_COUNT = 100;
    private static final long POI_DETECT_STATE_POLL_INTERVAL_MS = 1000;
    private static final int REQUEST_NOTIFICATION_PERMISSION = 1001;
    private static final String STAR_LOCATION_SERVICE_ACTION = "com.obric.cae.libs.location.IStarLocationService";
    private static final String TAG = "PoiArrivalActivity";
    private static final String USER_AWARE_LAUNCHER_ACTIVITY_CLASS_NAME = "com.obric.cae.userAware.ui.UserAwareLauncherActivity";
    private static final ArrayList<PoiArrivalFeedbackInfo> sArrivalRecords = null;
    private static boolean sRegistered;
    private boolean mBound;
    private Button mDebugBypassNearPoiCheckButton;
    private boolean mDebugBypassNearPoiCheckEnabled;
    private boolean mDestroyed;
    private TextView mEmptyText;
    private final ArrayList<FeedbackUpdateTask> mFeedbackUpdateTasks;
    private HistoryLoadTask mHistoryLoadTask;
    private LinearLayout mListContainer;
    private IStarLocationService mLocationService;
    private final IStarPoiCallback mNearPoiCallback;
    private boolean mPendingRegister;
    private TextView mPoiDetectCategoryValue;
    private LinearLayout mPoiDetectStateContainer;
    private TextView mPoiDetectStateTime;
    private TextView mPoiDetectStateValue;
    private TextView mPoiDetectStationaryValue;
    private IStarPoiManager mPoiManager;
    private Handler mPoiStateHandler;
    private Runnable mPoiStateRunnable;
    private Button mRegisterButton;
    private boolean mRegistered;
    private ScrollView mScrollView;
    private final ServiceConnection mServiceConnection;
    private EditText mStationaryDelayInput;
    private Button mUnregisterButton;

    /* JADX INFO: renamed from: com.obric.cae.userAware.ui.PoiArrivalActivity$1, reason: invalid class name */
    public class AnonymousClass1 extends IStarPoiCallback.Stub {
        final /* synthetic */ PoiArrivalActivity this$0;

        public AnonymousClass1(PoiArrivalActivity r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void H2(AnonymousClass1 r8, Bundle r10, PoiArrivalFeedbackInfo r11) {
            r8.lambda$onNearPoiReport$0(r10, r11);
        }

        private /* synthetic */ void lambda$onNearPoiReport$0(Bundle r8, PoiArrivalFeedbackInfo r10) {
            boolean r11 = PoiArrivalActivity.access$200(this.this$0);
            PoiArrivalActivity r12 = this.this$0;
            if (r11 == false) goto L6;
            PoiArrivalActivity.access$300(r12, r8, r10);
            return;
        L6:
            PoiArrivalActivity.access$400(r12, r8, r10);
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiCallback
        public void onNearPoiReport(Bundle r8) {
            if (r8 != null) goto L6;
            CaeLog.w(PoiArrivalActivity.TAG, "onNearPoiReport extras is null");
            return;
        L6:
            CaeLog.d(PoiArrivalActivity.TAG, "onNearPoiReport extras=" + PoiArrivalActivity.access$000(this.this$0, r8));
            final PoiArrivalFeedbackInfo r10 = StoreArrivalEventManager.onNearPoiReportFromExternalCallback(r8);
            final Bundle r11 = PoiArrivalActivity.access$100(this.this$0, r8);
            this.this$0.runOnUiThread(new n0(this, r11, r10));
        }
    }

    public static final class FeedbackUpdateTask {
        private final WeakReference<PoiArrivalActivity> mActivityRef;
        private final Context mAppContext;
        private volatile boolean mCanceled;
        private Runnable mDeliverRunnable;
        private Button mFeedbackButton;
        private Future<?> mFuture;
        private final boolean mIsCorrect;
        private PoiArrivalFeedbackInfo mRecord;
        private final Object mTaskLock;

        public FeedbackUpdateTask(PoiArrivalActivity r8, Context r10, PoiArrivalFeedbackInfo r11, Button r12, boolean r13) {
            this.mTaskLock = new Object();
            this.mActivityRef = new WeakReference(r8);
            this.mAppContext = r10;
            this.mRecord = r11;
            this.mFeedbackButton = r12;
            this.mIsCorrect = r13;
        }

        public static /* synthetic */ void a(FeedbackUpdateTask r8) {
            r8.runUpdate();
        }

        public static /* synthetic */ void b(FeedbackUpdateTask r8, int r10) {
            r8.lambda$runUpdate$0(r10);
        }

        private void clearUiRefs() {
            Object r8 = this.mTaskLock;
            monitor-enter(r8);
            clearUiRefsLocked();     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void clearUiRefsLocked() {
            this.mActivityRef.clear();
            this.mRecord = null;
            this.mFeedbackButton = null;
            this.mDeliverRunnable = null;
        }

        private void deliver(int r8) {
            Object r10 = this.mTaskLock;
            monitor-enter(r10);
        L20:
            th = move-exception;
            throw th;
        L5:
            if (this.mCanceled == false) goto L7;
        L17:
            clearUiRefsLocked();     // Catch: Throwable -> L20
            monitor-exit(r10);     // Catch: Throwable -> L20
            return;
        L7:
            if (this.mRecord == null) goto L17;
            if (this.mFeedbackButton == null) goto L17;
            PoiArrivalActivity r11 = this.mActivityRef.get();     // Catch: Throwable -> L20
            PoiArrivalFeedbackInfo r12 = this.mRecord;     // Catch: Throwable -> L20
            Button r13 = this.mFeedbackButton;     // Catch: Throwable -> L20
            this.mFuture = null;     // Catch: Throwable -> L20
            this.mDeliverRunnable = null;     // Catch: Throwable -> L20
            monitor-exit(r10);     // Catch: Throwable -> L20
            if (r11 == null) goto L15;
            PoiArrivalActivity.access$2100(r11, this, r12, r13, r8);
        L15:
            clearUiRefs();
        }

        private /* synthetic */ void lambda$runUpdate$0(int r8) {
            deliver(r8);
        }

        private void runUpdate() {
            Object r8 = this.mTaskLock;
            monitor-enter(r8);
        L31:
            th = move-exception;
            throw th;
        L5:
            if (this.mCanceled == true) goto L28;
            PoiArrivalFeedbackInfo r10 = this.mRecord;     // Catch: Throwable -> L31
            if (r10 == null) goto L28;
            monitor-exit(r8);     // Catch: Throwable -> L31
            int r11 = new PoiArrivalRecordDatabase(this.mAppContext).updateFeedback(r10, this.mIsCorrect);
            if (this.mCanceled == false) goto L14;
            clearUiRefs();
            return;
        L14:
            o0 r12 = new o0(r11, 0, this);
            Object r13 = this.mTaskLock;
            monitor-enter(r13);
        L25:
            th = move-exception;
            throw th;
        L17:
            if (this.mCanceled == false) goto L21;
            clearUiRefsLocked();     // Catch: Throwable -> L25
            monitor-exit(r13);     // Catch: Throwable -> L25
            return;
        L21:
            this.mDeliverRunnable = r12;     // Catch: Throwable -> L25
            monitor-exit(r13);     // Catch: Throwable -> L25
            PoiArrivalActivity.access$1800().post(r12);
            return;
        L28:
            clearUiRefsLocked();     // Catch: Throwable -> L31
            monitor-exit(r8);     // Catch: Throwable -> L31
        }

        public void cancel() {
            Object r8 = this.mTaskLock;
            monitor-enter(r8);
            this.mCanceled = true;     // Catch: Throwable -> L12
            Future<?> r10 = this.mFuture;     // Catch: Throwable -> L12
            this.mFuture = null;     // Catch: Throwable -> L12
            Runnable r11 = this.mDeliverRunnable;     // Catch: Throwable -> L12
            clearUiRefsLocked();     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            if (r10 == null) goto L9;
            r10.cancel(true);
        L9:
            if (r11 == null) goto L17;
            PoiArrivalActivity.access$1800().removeCallbacks(r11);
            return;
        L17:
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public void start() {
            Future<?> r8 = PoiArrivalActivity.access$1700().submit(new c0(this, 1));
            Object r10 = this.mTaskLock;
            monitor-enter(r10);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mCanceled == false) goto L9;
            r8.cancel(true);     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
            return;
        L9:
            this.mFuture = r8;     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
        }
    }

    public static final class HistoryLoadTask {
        private final WeakReference<PoiArrivalActivity> mActivityRef;
        private final Context mAppContext;
        private volatile boolean mCanceled;
        private Runnable mDeliverRunnable;
        private Future<?> mFuture;
        private final Object mTaskLock;

        public HistoryLoadTask(PoiArrivalActivity r8, Context r10) {
            this.mTaskLock = new Object();
            this.mActivityRef = new WeakReference(r8);
            this.mAppContext = r10;
        }

        public static /* synthetic */ void a(HistoryLoadTask r8) {
            r8.runLoad();
        }

        public static /* synthetic */ void b(HistoryLoadTask r8, ArrayList r10) {
            r8.lambda$runLoad$0(r10);
        }

        private void clearRefs() {
            Object r8 = this.mTaskLock;
            monitor-enter(r8);
            clearRefsLocked();     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void clearRefsLocked() {
            this.mActivityRef.clear();
            this.mDeliverRunnable = null;
        }

        private void deliver(ArrayList<PoiArrivalFeedbackInfo> r8) {
            Object r10 = this.mTaskLock;
            monitor-enter(r10);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.mCanceled == false) goto L9;
            clearRefsLocked();     // Catch: Throwable -> L15
            monitor-exit(r10);     // Catch: Throwable -> L15
            return;
        L9:
            PoiArrivalActivity r11 = this.mActivityRef.get();     // Catch: Throwable -> L15
            this.mFuture = null;     // Catch: Throwable -> L15
            this.mDeliverRunnable = null;     // Catch: Throwable -> L15
            monitor-exit(r10);     // Catch: Throwable -> L15
            if (r11 == null) goto L13;
            PoiArrivalActivity.access$2000(r11, this, r8);
        L13:
            clearRefs();
        }

        private /* synthetic */ void lambda$runLoad$0(ArrayList r8) {
            deliver(r8);
        }

        private void runLoad() {
            ArrayList r8 = PoiArrivalActivity.access$1900(this.mAppContext);
            if (this.mCanceled == false) goto L6;
            clearRefs();
            return;
        L6:
            p0 r10 = new p0(0, this, r8);
            Object r11 = this.mTaskLock;
            monitor-enter(r11);
        L17:
            th = move-exception;
            throw th;
        L9:
            if (this.mCanceled == false) goto L13;
            clearRefsLocked();     // Catch: Throwable -> L17
            monitor-exit(r11);     // Catch: Throwable -> L17
            return;
        L13:
            this.mDeliverRunnable = r10;     // Catch: Throwable -> L17
            monitor-exit(r11);     // Catch: Throwable -> L17
            PoiArrivalActivity.access$1800().post(r10);
        }

        public void cancel() {
            Object r8 = this.mTaskLock;
            monitor-enter(r8);
            this.mCanceled = true;     // Catch: Throwable -> L12
            Future<?> r10 = this.mFuture;     // Catch: Throwable -> L12
            this.mFuture = null;     // Catch: Throwable -> L12
            Runnable r11 = this.mDeliverRunnable;     // Catch: Throwable -> L12
            clearRefsLocked();     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            if (r10 == null) goto L9;
            r10.cancel(true);
        L9:
            if (r11 == null) goto L17;
            PoiArrivalActivity.access$1800().removeCallbacks(r11);
            return;
        L17:
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public void start() {
            Future<?> r8 = PoiArrivalActivity.access$1700().submit(new b0(this, 1));
            Object r10 = this.mTaskLock;
            monitor-enter(r10);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mCanceled == false) goto L9;
            r8.cancel(true);     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
            return;
        L9:
            this.mFuture = r8;     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
        }
    }

    static {
        sArrivalRecords = new ArrayList();
        MAIN_HANDLER = new Handler(Looper.getMainLooper());
        DB_EXECUTOR = Executors.newSingleThreadExecutor(new com.obric.cae.libs.softap.i(1));
    }

    public PoiArrivalActivity() {
        this.mDebugBypassNearPoiCheckEnabled = false;
        this.mFeedbackUpdateTasks = new ArrayList();
        this.mNearPoiCallback = new AnonymousClass1(this);
        this.mServiceConnection = new AnonymousClass2(this);
    }

    public static /* synthetic */ void a(PoiArrivalActivity r8, PoiArrivalFeedbackInfo r10, Button r11, DialogInterface r12, int r13) {
        r8.lambda$showPoiFeedbackDialog$15(r10, r11, r12, r13);
    }

    public static /* synthetic */ String access$000(PoiArrivalActivity r8, Bundle r10) {
        return r8.describeBundle(r10);
    }

    public static /* synthetic */ Bundle access$100(PoiArrivalActivity r8, Bundle r10) {
        return r8.buildDisplayBundle(r10);
    }

    public static /* synthetic */ void access$1000(PoiArrivalActivity r8) {
        r8.startPoiDetectStatePolling();
    }

    public static /* synthetic */ void access$1100(PoiArrivalActivity r8, boolean r10) {
        r8.updateButtonState(r10);
    }

    public static /* synthetic */ boolean access$1202(PoiArrivalActivity r8, boolean r10) {
        r8.mBound = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1302(PoiArrivalActivity r8, boolean r10) {
        r8.mRegistered = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1402(boolean r8) {
        sRegistered = r8;
        return r8;
    }

    public static /* synthetic */ void access$1500(PoiArrivalActivity r8) {
        r8.stopPoiDetectStatePolling();
    }

    public static /* synthetic */ Handler access$1600(PoiArrivalActivity r8) {
        return r8.mPoiStateHandler;
    }

    public static /* synthetic */ ExecutorService access$1700() {
        return DB_EXECUTOR;
    }

    public static /* synthetic */ Handler access$1800() {
        return MAIN_HANDLER;
    }

    public static /* synthetic */ ArrayList access$1900(Context r8) {
        return loadHistoryRecords(r8);
    }

    public static /* synthetic */ boolean access$200(PoiArrivalActivity r8) {
        return r8.mDestroyed;
    }

    public static /* synthetic */ void access$2000(PoiArrivalActivity r8, HistoryLoadTask r10, ArrayList r11) {
        r8.onHistoryLoadTaskFinished(r10, r11);
    }

    public static /* synthetic */ void access$2100(PoiArrivalActivity r8, FeedbackUpdateTask r10, PoiArrivalFeedbackInfo r11, Button r12, int r13) {
        r8.onFeedbackUpdateTaskFinished(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$300(PoiArrivalActivity r8, Bundle r10, PoiArrivalFeedbackInfo r11) {
        r8.handleNearPoiReportWithoutUi(r10, r11);
    }

    public static /* synthetic */ void access$400(PoiArrivalActivity r8, Bundle r10, PoiArrivalFeedbackInfo r11) {
        r8.handleNearPoiReport(r10, r11);
    }

    public static /* synthetic */ IStarLocationService access$500(PoiArrivalActivity r8) {
        return r8.mLocationService;
    }

    public static /* synthetic */ IStarLocationService access$502(PoiArrivalActivity r8, IStarLocationService r10) {
        r8.mLocationService = r10;
        return r10;
    }

    public static /* synthetic */ IStarPoiManager access$602(PoiArrivalActivity r8, IStarPoiManager r10) {
        r8.mPoiManager = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$700(PoiArrivalActivity r8) {
        return r8.mPendingRegister;
    }

    public static /* synthetic */ boolean access$702(PoiArrivalActivity r8, boolean r10) {
        r8.mPendingRegister = r10;
        return r10;
    }

    public static /* synthetic */ void access$800(PoiArrivalActivity r8) {
        r8.registerNearPoiCallback();
    }

    public static /* synthetic */ void access$900(PoiArrivalActivity r8) {
        r8.updatePoiDetectState();
    }

    private static void addArrivalRecordLocked(PoiArrivalFeedbackInfo r8) {
        sArrivalRecords.add(0, r8);
    L3:
        ArrayList<PoiArrivalFeedbackInfo> r10 = sArrivalRecords;
        if (r10.size() <= 100) goto L6;
        r10.remove(r10.size() - 1);
        goto L3
    }

    private void addArrivalRecordView(final PoiArrivalFeedbackInfo r8, int r10) {
        TextView r11 = this.mEmptyText;
        if (r11 == null) goto L5;
        r11.setVisibility(8);
    L5:
        LinearLayout r12 = new LinearLayout(this);
        r12.setOrientation(0);
        r12.setGravity(16);
        r12.setTag(r8);
        updateItemBackground(r12, r8);
        r12.setPadding(20, 16, 20, 16);
        TextView r13 = new TextView(this);
        r13.setText(formatDisplayLine(r8));
        r13.setTextColor(-16777216);
        r13.setTextSize(16.0f);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        r14.rightMargin = 12;
        r12.addView(r13, r14);
        final Button r15 = new Button(this);
        r15.setText(getFeedbackButtonText(r8));
        r15.setTextSize(14.0f);
        r15.setAllCaps(false);
        r15.setOnClickListener(new h0(this, r8, r15));
        r12.addView(r15, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-1, -2);
        r16.setMargins(0, 0, 0, 1);
        this.mListContainer.addView(r12, r10, r16);
        this.mScrollView.post(new b0(this, 2));
    }

    private void appendArrivalRecord(PoiArrivalFeedbackInfo r8) {
        ArrayList<PoiArrivalFeedbackInfo> r10 = sArrivalRecords;
        monitor-enter(r10);
        addArrivalRecordLocked(r8);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        addArrivalRecordView(r8, 0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void b(PoiArrivalActivity r8, PoiArrivalFeedbackInfo r10, Button r11, DialogInterface r12, int r13) {
        r8.lambda$showPoiFeedbackDialog$16(r10, r11, r12, r13);
    }

    private void bindStarLocationService() {
        if (this.mBound == false) goto L5;
        return;
    L5:
        Intent r8 = new Intent(STAR_LOCATION_SERVICE_ACTION);
        r8.setPackage(getPackageName());
        boolean r10 = bindService(r8, this.mServiceConnection, 1);     // Catch: Exception -> L10
        this.mBound = r10;     // Catch: Exception -> L10
        if (r10 == true) goto L15;
        CaeLog.e(TAG, "bind StarLocationService failed");     // Catch: Exception -> L10
        this.mPendingRegister = false;     // Catch: Exception -> L10
        updateButtonState(false);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        CaeLog.e(TAG, "bind StarLocationService exception", e);
        this.mPendingRegister = false;
        updateButtonState(false);
    }

    private String buildCategoryText(Bundle r8) {
        return r8.getString("new_type_name_l1", "") + ";" + r8.getString("new_type_name_l2", "") + ";" + r8.getString("new_type_name_l3", "");
    }

    private Bundle buildDisplayBundle(Bundle r8) {
        Bundle r10 = new Bundle();
        r10.putLong("timestamp", r8.getLong("timestamp", 0));
        r10.putString("aoi_name", r8.getString("aoi_name", ""));
        r10.putString("poi_name", r8.getString("poi_name", ""));
        r10.putString("category", buildCategoryText(r8));
        return r10;
    }

    private PoiArrivalFeedbackInfo buildFeedbackInfo(Bundle r8) {
        PoiArrivalFeedbackInfo r10 = new PoiArrivalFeedbackInfo();
        r10.setTimeStamp(r8.getLong("timestamp", 0));
        r10.setAoiName(r8.getString("aoi_name", ""));
        r10.setPoiName(r8.getString("poi_name", ""));
        r10.setCategory(r8.getString("category", ""));
        return r10;
    }

    public static /* synthetic */ void c(PoiArrivalActivity r8, View r10) {
        r8.lambda$initViews$3(r10);
    }

    private void cancelFeedbackUpdateTasks() {
        Iterator r8 = new ArrayList(this.mFeedbackUpdateTasks).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ((FeedbackUpdateTask) r8.next()).cancel();
        goto L4
    L6:
        this.mFeedbackUpdateTasks.clear();
    }

    private void cancelHistoryLoadTask() {
        HistoryLoadTask r8 = this.mHistoryLoadTask;
        if (r8 == null) goto L6;
        r8.cancel();
        this.mHistoryLoadTask = null;
        return;
    }

    private void clearArrivalRecordViews() {
        int r8 = this.mListContainer.getChildCount() - 1;
    L3:
        if (r8 < 0) goto L8;
        if (this.mListContainer.getChildAt(r8) == this.mEmptyText) goto L7;
        this.mListContainer.removeViewAt(r8);
    L7:
        r8 = r8 - 1;
        goto L3
    }

    private void createNotificationChannel() {
        PoiArrivalNotificationHelper.createChannel(this, CHANNEL_ID, getString(R.string.user_aware_poi_arrival_notification_title), getString(R.string.user_aware_poi_arrival_title));
    }

    public static /* synthetic */ void d(PoiArrivalActivity r8, View r10) {
        r8.lambda$initViews$1(r10);
    }

    private String describeBundle(Bundle r8) {
        StringBuilder r10 = new StringBuilder("{");
        Iterator<String> r11 = r8.keySet().iterator();
        boolean r12 = true;
    L4:
        if (r11.hasNext() == false) goto L9;
        String r13 = r11.next();
        if (r12 == true) goto L8;
        r10.append(", ");
    L8:
        r10.append(r13);
        r10.append("=");
        r10.append(r8.get(r13));
        r12 = false;
        goto L4
    L9:
        r10.append("}");
        return r10.toString();
    }

    public static /* synthetic */ void e(PoiArrivalActivity r8, int r10, Bundle r11) {
        r8.lambda$updatePoiDetectState$17(r10, r11);
    }

    public static /* synthetic */ void f(PoiArrivalActivity r8, View r10) {
        r8.lambda$initViews$5(r10);
    }

    private String formatDisplayLine(Bundle r8) {
        long r10 = r8.getLong("timestamp", 0);
        String r11 = r8.getString("aoi_name", "");
        String r12 = r8.getString("poi_name", "");
        String r13 = r8.getString("category", "");
        String r14 = formatLocalTime(r10) + " " + r11 + " " + r12;
        if (TextUtils.isEmpty(r13) == false) goto L5;
        return r14;
    L5:
        if (";;".equals(r13) == false) goto L7;
        return r14;
    L7:
        return defpackage.a.f(r14, " ", r13);
    }

    private String formatLocalTime(long r8) {
        if (r8 > 100000000000L) goto L7;
        r8 = r8 * 1000;
    L7:
        return new SimpleDateFormat("HH:mm:ss", Locale.US).format(new Date(r8));
    }

    public static /* synthetic */ void g(Context r8, PoiArrivalFeedbackInfo r10) {
        lambda$persistPoiArrivalRecordAsync$12(r8, r10);
    }

    private PoiArrivalFeedbackInfo getArrivalRecord(Bundle r8, PoiArrivalFeedbackInfo r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        return buildFeedbackInfo(r8);
    }

    private String getCategoryString(String r8) {
        if ("sittable".equals(r8) == false) goto L8;
        int r10 = R.string.user_aware_poi_detect_category_sittable;
    L6:
        return getString(r10);
    L8:
        if ("walkable".equals(r8) == false) goto L10;
        r10 = R.string.user_aware_poi_detect_category_walkable;
        goto L6
    L10:
        r10 = R.string.user_aware_poi_detect_category_unknown;
        goto L6
    }

    private String getFeedbackButtonText(PoiArrivalFeedbackInfo r8) {
        if (r8.getHasFeedback() == true) goto L7;
        return getString(R.string.user_aware_poi_arrival_feedback);
    L7:
        if (r8.getUserChoice() != 1) goto L9;
        int r10 = R.string.user_aware_poi_arrival_feedback_correct;
    L11:
        return getString(r10);
    L9:
        r10 = R.string.user_aware_poi_arrival_feedback_incorrect;
        goto L11
    }

    private String getStateString(int r8) {
        if (r8 != 0) goto L4;
        int r10 = R.string.user_aware_poi_detect_state_stopped;
    L13:
        return getString(r10);
    L4:
        if (r8 != 1) goto L6;
        r10 = R.string.user_aware_poi_detect_state_inside;
        goto L13
    L6:
        if (r8 != 2) goto L8;
        r10 = R.string.user_aware_poi_detect_state_monitoring;
        goto L13
    L8:
        if (r8 != 3) goto L10;
        r10 = R.string.user_aware_poi_detect_state_energy_saving_sit;
        goto L13
    L10:
        if (r8 == 4) goto L14;
        r10 = R.string.user_aware_poi_detect_state_unknown;
        goto L13
    L14:
        r10 = R.string.user_aware_poi_detect_state_energy_saving_walk;
        goto L13
    }

    public static /* synthetic */ void h(PoiArrivalActivity r8, View r10) {
        r8.lambda$initViews$8(r10);
    }

    private void handleNearPoiReport(Bundle r8, PoiArrivalFeedbackInfo r10) {
        String r11 = r8.getString("aoi_name", "");
        String r12 = r8.getString("poi_name", "");
        if (TextUtils.isEmpty(r11) == true) goto L5;
    L8:
        String r13 = formatDisplayLine(r8);
        PoiArrivalFeedbackInfo r14 = getArrivalRecord(r8, r10);
        persistPoiArrivalRecordAsync(r14);
        appendArrivalRecord(r14);
        if (this.mRegistered == false) goto L12;
        showPoiArrivalNotification(r13);
        return;
    L12:
        return;
    L5:
        if (TextUtils.isEmpty(r12) == false) goto L8;
        CaeLog.d(TAG, "skip empty near poi report");
    }

    private void handleNearPoiReportWithoutUi(Bundle r8, PoiArrivalFeedbackInfo r10) {
        String r11 = r8.getString("aoi_name", "");
        String r12 = r8.getString("poi_name", "");
        if (TextUtils.isEmpty(r11) == true) goto L5;
    L7:
        String r13 = formatDisplayLine(r8);
        PoiArrivalFeedbackInfo r14 = getArrivalRecord(r8, r10);
        persistPoiArrivalRecordAsync(r14);
        ArrayList<PoiArrivalFeedbackInfo> r15 = sArrivalRecords;
        monitor-enter(r15);
        addArrivalRecordLocked(r14);     // Catch: Throwable -> L15
        monitor-exit(r15);     // Catch: Throwable -> L15
        if (sRegistered == false) goto L20;
        showPoiArrivalNotification(r13);
        return;
    L20:
        return;
    L15:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r12) == false) goto L7;
    }

    private void handlePoiFeedbackResult(PoiArrivalFeedbackInfo r8, Button r10, int r11) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        r10.setEnabled(true);
        if (r11 > 0) goto L10;
        int r12 = R.string.user_aware_poi_arrival_feedback_write_failed;
    L8:
        Toast.makeText(this, r12, 0).show();
        return;
    L10:
        StoreArrivalEventManager.notifyPoiArrivalFeedbackUpdated(r8);
        r12 = R.string.user_aware_poi_arrival_feedback_updated;
        goto L8
    }

    public static /* synthetic */ void i(PoiArrivalActivity r8, View r10) {
        r8.lambda$initViews$2(r10);
    }

    private void initViews() {
        OCTitleBar r8 = (OCTitleBar) findViewById(R.id.poi_arrival_title);
        final int r10 = 0;
        if (r8 == null) goto L5;
        r8.getMLeftActionBack().setOnClickListener(new k0(this, r10));
    L5:
        this.mRegisterButton = (Button) findViewById(R.id.register_near_poi_btn);
        this.mUnregisterButton = (Button) findViewById(R.id.unregister_near_poi_btn);
        this.mListContainer = (LinearLayout) findViewById(R.id.poi_arrival_list_container);
        this.mEmptyText = (TextView) findViewById(R.id.poi_arrival_empty_text);
        this.mScrollView = (ScrollView) findViewById(R.id.poi_arrival_scroll_view);
        this.mRegisterButton.setOnClickListener(new m0(this, r10));
        final int r11 = 1;
        this.mUnregisterButton.setOnClickListener(new k0(this, r11));
        this.mPoiDetectStateContainer = (LinearLayout) findViewById(R.id.poi_detect_state_container);
        this.mPoiDetectStateValue = (TextView) findViewById(R.id.poi_detect_state_value);
        this.mPoiDetectStateTime = (TextView) findViewById(R.id.poi_detect_state_time);
        this.mPoiDetectCategoryValue = (TextView) findViewById(R.id.poi_detect_category_value);
        this.mPoiDetectStationaryValue = (TextView) findViewById(R.id.poi_detect_stationary_value);
        findViewById(R.id.poi_debug_state_stopped).setOnClickListener(new l0(this, r11));
        findViewById(R.id.poi_debug_state_inside).setOnClickListener(new m0(this, r11));
        final int r12 = 2;
        findViewById(R.id.poi_debug_state_monitoring).setOnClickListener(new k0(this, r12));
        findViewById(R.id.poi_debug_state_sit).setOnClickListener(new l0(this, r12));
        findViewById(R.id.poi_debug_state_walk).setOnClickListener(new m0(this, r12));
        final int r13 = 3;
        findViewById(R.id.poi_debug_trigger_location).setOnClickListener(new k0(this, r13));
        Button r14 = (Button) findViewById(R.id.poi_debug_bypass_near_poi_check);
        this.mDebugBypassNearPoiCheckButton = r14;
        r14.setOnClickListener(new l0(this, r13));
        this.mStationaryDelayInput = (EditText) findViewById(R.id.poi_stationary_delay_input);
        findViewById(R.id.poi_apply_stationary_delay).setOnClickListener(new l0(this, r10));
    }

    private boolean isUserAwareLauncherVisible() {
        ComponentName r8 = new ComponentName(this, USER_AWARE_LAUNCHER_ACTIVITY_CLASS_NAME);
        if (getPackageManager().getComponentEnabledSetting(r8) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static /* synthetic */ void j(PoiArrivalActivity r8, View r10) {
        r8.lambda$initViews$6(r10);
    }

    public static /* synthetic */ void k(PoiArrivalActivity r8, View r10) {
        r8.lambda$initViews$9(r10);
    }

    public static /* synthetic */ Thread l(Runnable r8) {
        return lambda$static$0(r8);
    }

    private /* synthetic */ void lambda$addArrivalRecordView$13(PoiArrivalFeedbackInfo r8, Button r10, View r11) {
        showPoiFeedbackDialog(r8, r10);
    }

    private /* synthetic */ void lambda$addArrivalRecordView$14() {
        this.mScrollView.smoothScrollTo(0, 0);
    }

    private /* synthetic */ void lambda$initViews$1(View r8) {
        finish();
    }

    private /* synthetic */ void lambda$initViews$10(View r8) {
        onDebugToggleBypassNearPoiCheck();
    }

    private /* synthetic */ void lambda$initViews$11(View r8) {
        onApplyStationaryDelay();
    }

    private /* synthetic */ void lambda$initViews$2(View r8) {
        onRegisterClicked();
    }

    private /* synthetic */ void lambda$initViews$3(View r8) {
        onUnregisterClicked();
    }

    private /* synthetic */ void lambda$initViews$4(View r8) {
        onDebugSetState(0);
    }

    private /* synthetic */ void lambda$initViews$5(View r8) {
        onDebugSetState(1);
    }

    private /* synthetic */ void lambda$initViews$6(View r8) {
        onDebugSetState(2);
    }

    private /* synthetic */ void lambda$initViews$7(View r8) {
        onDebugSetState(3);
    }

    private /* synthetic */ void lambda$initViews$8(View r8) {
        onDebugSetState(4);
    }

    private /* synthetic */ void lambda$initViews$9(View r8) {
        onDebugTriggerLocation();
    }

    private static /* synthetic */ void lambda$persistPoiArrivalRecordAsync$12(Context r8, PoiArrivalFeedbackInfo r10) {
        new PoiArrivalRecordDatabase(r8).insertOrGetRecord(r10);
    }

    private /* synthetic */ void lambda$showPoiFeedbackDialog$15(PoiArrivalFeedbackInfo r8, Button r10, DialogInterface r11, int r12) {
        updatePoiFeedback(r8, r10, true);
    }

    private /* synthetic */ void lambda$showPoiFeedbackDialog$16(PoiArrivalFeedbackInfo r8, Button r10, DialogInterface r11, int r12) {
        updatePoiFeedback(r8, r10, false);
    }

    private static /* synthetic */ Thread lambda$static$0(Runnable r8) {
        return new Thread(r8, "PoiArrivalDbWorker");
    }

    private /* synthetic */ void lambda$updatePoiDetectState$17(int r8, Bundle r10) {
        this.mPoiDetectStateContainer.setVisibility(0);
        this.mPoiDetectStateValue.setText(getStateString(r8));
        this.mPoiDetectStateTime.setText(formatLocalTime(System.currentTimeMillis()));
        if (r10 == null) goto L5;
        String r11 = r10.getString("poi_category");
    L6:
        this.mPoiDetectCategoryValue.setText(getCategoryString(r11));
        if (r10 != null) goto L9;
    L11:
        boolean r12 = false;
    L12:
        TextView r13 = this.mPoiDetectStationaryValue;
        if (r12 == false) goto L15;
        int r14 = R.string.user_aware_poi_detect_stationary_yes;
    L16:
        r13.setText(getString(r14));
        if (r10 == null) goto L26;
        EditText r15 = this.mStationaryDelayInput;
        if (r15 != null) goto L21;
        return;
    L21:
        if (r15.hasFocus() == true) goto L28;
        int r16 = r10.getInt("stationaryDelaySeconds", 0);
        if (r16 <= 0) goto L29;
        this.mStationaryDelayInput.setText(String.valueOf(r16));
        return;
    L29:
        return;
    L28:
        return;
    L26:
        return;
    L15:
        r14 = R.string.user_aware_poi_detect_stationary_no;
        goto L16
    L9:
        if (r10.getBoolean("isStationary", false) == false) goto L11;
        r12 = true;
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    private static ArrayList<PoiArrivalFeedbackInfo> loadHistoryRecords(Context r8) {
        ArrayList<PoiArrivalFeedbackInfo> r10 = new ArrayList(new PoiArrivalRecordDatabase(r8).getRecords(100));
        if (r10.isEmpty() == true) goto L5;
        return r10;
    L5:
        ArrayList<PoiArrivalFeedbackInfo> r11 = sArrivalRecords;
        monitor-enter(r11);
        ArrayList<PoiArrivalFeedbackInfo> r12 = new ArrayList(r11);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r12;
    L10:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void m(PoiArrivalActivity r8, View r10) {
        r8.lambda$initViews$7(r10);
    }

    public static /* synthetic */ void n(PoiArrivalActivity r8, PoiArrivalFeedbackInfo r10, Button r11, View r12) {
        r8.lambda$addArrivalRecordView$13(r10, r11, r12);
    }

    private static String nullToEmpty(String r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        return r8;
    }

    public static /* synthetic */ void o(PoiArrivalActivity r8, View r10) {
        r8.lambda$initViews$11(r10);
    }

    private void onApplyStationaryDelay() {
        IStarPoiManager r8 = this.mPoiManager;
        if (r8 != null) goto L6;
        CaeLog.w(TAG, "onApplyStationaryDelay: poiManager is null, binding service first");
        bindStarLocationService();
        return;
    L6:
        EditText r10 = this.mStationaryDelayInput;
        if (r10 == null) goto L9;
        String r11 = r10.getText().toString().trim();
    L11:
        if (TextUtils.isEmpty(r11) == false) goto L26;
        CaeLog.w(TAG, "onApplyStationaryDelay: input is empty");
        return;
    L26:
        int r12 = Integer.parseInt(r11);     // Catch: Throwable -> L20 NumberFormatException -> L22
        if (r12 > 0) goto L18;
        CaeLog.w(TAG, "onApplyStationaryDelay: invalid seconds=" + r12);     // Catch: Throwable -> L20 NumberFormatException -> L22
        return;
    L18:
        r8.setStationaryDelaySeconds(r12);     // Catch: Throwable -> L20 NumberFormatException -> L22
        CaeLog.d(TAG, "onApplyStationaryDelay: seconds=" + r12);     // Catch: Throwable -> L20 NumberFormatException -> L22
        updatePoiDetectState();     // Catch: Throwable -> L20 NumberFormatException -> L22
        return;
    L20:
        e = e;
        String r13 = "onApplyStationaryDelay failed";
    L24:
        CaeLog.e(TAG, r13, e);
        return;
    L22:
        e = e;
        r13 = "onApplyStationaryDelay parse failed";
        goto L24
    L9:
        r11 = "";
        goto L11
    }

    private void onDebugSetState(int r8) {
        IStarPoiManager r10 = this.mPoiManager;
        if (r10 != null) goto L11;
        CaeLog.w(TAG, "onDebugSetState: poiManager is null, binding service first");
        bindStarLocationService();
        return;
    L11:
        r10.setPoiDetectStateDebug(r8);     // Catch: Throwable -> L8
        updatePoiDetectState();     // Catch: Throwable -> L8
        CaeLog.d(TAG, "onDebugSetState: state=" + r8);     // Catch: Throwable -> L8
        return;
    L8:
        e = move-exception;
        CaeLog.e(TAG, "onDebugSetState failed", e);
    }

    private void onDebugToggleBypassNearPoiCheck() {
        IStarPoiManager r8 = this.mPoiManager;
        if (r8 != null) goto L6;
        CaeLog.w(TAG, "onDebugToggleBypassNearPoiCheck: poiManager is null, binding service first");
        bindStarLocationService();
        return;
    L6:
        boolean r10 = !this.mDebugBypassNearPoiCheckEnabled;
        this.mDebugBypassNearPoiCheckEnabled = r10;
        r8.setDebugBypassNearPoiCheck(r10);     // Catch: Throwable -> L15
        CaeLog.d(TAG, "onDebugToggleBypassNearPoiCheck: enabled=" + this.mDebugBypassNearPoiCheckEnabled);     // Catch: Throwable -> L15
        Button r11 = this.mDebugBypassNearPoiCheckButton;     // Catch: Throwable -> L15
        if (r11 != null) goto L10;
        return;
    L10:
        if (this.mDebugBypassNearPoiCheckEnabled == false) goto L12;
        int r12 = R.string.user_aware_poi_detect_bypass_near_poi_check_on;
    L13:
        r11.setText(r12);     // Catch: Throwable -> L15
        return;
    L12:
        r12 = R.string.user_aware_poi_detect_bypass_near_poi_check_off;
    L15:
        e = move-exception;
        CaeLog.e(TAG, "onDebugToggleBypassNearPoiCheck failed", e);
        this.mDebugBypassNearPoiCheckEnabled = !this.mDebugBypassNearPoiCheckEnabled;
    }

    private void onDebugTriggerLocation() {
        IStarPoiManager r8 = this.mPoiManager;
        if (r8 != null) goto L11;
        CaeLog.w(TAG, "onDebugTriggerLocation: poiManager is null, binding service first");
        bindStarLocationService();
        return;
    L11:
        r8.triggerNearPoiLocation();     // Catch: Throwable -> L8
        CaeLog.d(TAG, "onDebugTriggerLocation: triggered");     // Catch: Throwable -> L8
        return;
    L8:
        e = move-exception;
        CaeLog.e(TAG, "onDebugTriggerLocation failed", e);
    }

    private void onFeedbackUpdateTaskFinished(FeedbackUpdateTask r8, PoiArrivalFeedbackInfo r10, Button r11, int r12) {
        this.mFeedbackUpdateTasks.remove(r8);
        handlePoiFeedbackResult(r10, r11, r12);
    }

    private void onHistoryLoadTaskFinished(HistoryLoadTask r8, ArrayList<PoiArrivalFeedbackInfo> r10) {
        if (this.mHistoryLoadTask != r8) goto L5;
        this.mHistoryLoadTask = null;
    L5:
        renderLoadedHistoryLines(r10);
    }

    private void onRegisterClicked() {
        this.mPendingRegister = true;
        updateButtonState(true);
        if (this.mPoiManager == null) goto L6;
        registerNearPoiCallback();
        return;
    L6:
        bindStarLocationService();
    }

    private void onUnregisterClicked() {
        unregisterNearPoiCallback();
    }

    public static /* synthetic */ void p(PoiArrivalActivity r8, View r10) {
        r8.lambda$initViews$10(r10);
    }

    private void persistPoiArrivalRecordAsync(PoiArrivalFeedbackInfo r8) {
        if (r8.getId() == (-1)) goto L5;
        return;
    L5:
        int r10 = 1;
        new Thread(new e1(r10, getApplicationContext(), r8)).start();
    }

    public static /* synthetic */ void q(PoiArrivalActivity r8) {
        r8.lambda$addArrivalRecordView$14();
    }

    public static /* synthetic */ void r(PoiArrivalActivity r8, View r10) {
        r8.lambda$initViews$4(r10);
    }

    private void refreshFeedbackState(PoiArrivalFeedbackInfo r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.mListContainer.getChildCount()) goto L14;
        View r11 = this.mListContainer.getChildAt(r10);
        Object r12 = r11.getTag();
        if ((r12 instanceof PoiArrivalFeedbackInfo) == false) goto L13;
        PoiArrivalFeedbackInfo r13 = (PoiArrivalFeedbackInfo) r12;
        if (StoreArrivalEventManager.isSameRecord(r13, r8) == false) goto L13;
        r13.setId(r8.getId());
        r13.setHasFeedback(r8.getHasFeedback());
        r13.setUserChoice(r8.getUserChoice());
        r13.setFeedbackTime(r8.getFeedbackTime());
        if ((r11 instanceof LinearLayout) == false) goto L13;
        LinearLayout r14 = (LinearLayout) r11;
        updateItemBackground(r14, r13);
        updateFeedbackButton(r14, r13);
    L13:
        r10 = r10 + 1;
        goto L4
    }

    private void registerNearPoiCallback() {
        IStarPoiManager r8 = this.mPoiManager;
        if (r8 != null) goto L5;
        return;
    L5:
        StoreArrivalEventManager.onExternalNearPoiCallbackRegistered();
        r8.registerNearPoiCallback(this.mNearPoiCallback);     // Catch: Throwable -> L8
        this.mRegistered = true;     // Catch: Throwable -> L8
        sRegistered = true;     // Catch: Throwable -> L8
        this.mPendingRegister = false;     // Catch: Throwable -> L8
        updateButtonState(true);     // Catch: Throwable -> L8
        CaeLog.d(TAG, "registerNearPoiCallback success");     // Catch: Throwable -> L8
        return;
    L8:
        e = move-exception;
        CaeLog.e(TAG, "registerNearPoiCallback failed", e);
        StoreArrivalEventManager.onExternalNearPoiCallbackUnregistered();
        this.mRegistered = false;
        sRegistered = false;
        this.mPendingRegister = false;
        updateButtonState(false);
    }

    private void renderHistoryLines() {
        if (this.mListContainer != null) goto L5;
        return;
    L5:
        clearArrivalRecordViews();
        TextView r8 = this.mEmptyText;
        if (r8 == null) goto L8;
        r8.setVisibility(0);
    L8:
        cancelHistoryLoadTask();
        HistoryLoadTask r10 = new HistoryLoadTask(this, getApplicationContext());
        this.mHistoryLoadTask = r10;
        r10.start();
    }

    private void renderLoadedHistoryLines(ArrayList<PoiArrivalFeedbackInfo> r8) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        if (this.mListContainer != null) goto L8;
        return;
    L8:
        if (r8.isEmpty() == false) goto L13;
        TextView r10 = this.mEmptyText;
        if (r10 == null) goto L22;
        r10.setVisibility(0);
        return;
    L22:
        return;
    L13:
        TextView r11 = this.mEmptyText;
        if (r11 == null) goto L16;
        r11.setVisibility(8);
    L16:
        Collections.reverse(r8);
        Iterator<PoiArrivalFeedbackInfo> r12 = r8.iterator();
    L18:
        if (r12.hasNext() == false) goto L24;
        addArrivalRecordView(r12.next(), 0);
        goto L18
    }

    private void requestNotificationPermissionIfNeeded() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return;
    L5:
        if (checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) goto L9;
        requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 1001);
        return;
    }

    private void showPoiArrivalNotification(String r8) {
        if (isUserAwareLauncherVisible() == true) goto L5;
        return;
    L5:
        PoiArrivalNotificationHelper.show(this, TAG, CHANNEL_ID, PoiArrivalActivity.class, getString(R.string.user_aware_poi_arrival_notification_title), r8);
    }

    private void showPoiFeedbackDialog(PoiArrivalFeedbackInfo r8, Button r10) {
        int r11 = 0;
        new AlertDialog.Builder(this).setTitle(getString(R.string.user_aware_poi_arrival_feedback_title)).setMessage(formatDisplayLine(r8)).setPositiveButton(R.string.user_aware_har_select_true, new i0(this, r8, r10, r11)).setNegativeButton(R.string.user_aware_har_select_false, new j0(this, r8, r10, r11)).show();
    }

    private void startPoiDetectStatePolling() {
        if (this.mPoiStateHandler == null) goto L5;
        return;
    L5:
        this.mPoiStateHandler = new Handler();
        Runnable r8 = new AnonymousClass3(this);
        this.mPoiStateRunnable = r8;
        this.mPoiStateHandler.postDelayed(r8, 1000);
    }

    private void stopPoiDetectStatePolling() {
        Handler r8 = this.mPoiStateHandler;
        if (r8 == null) goto L5;
        r8.removeCallbacks(this.mPoiStateRunnable);
        this.mPoiStateHandler = null;
    L5:
        this.mPoiStateRunnable = null;
    }

    private void unregisterNearPoiCallback() {
        IStarPoiManager r8 = this.mPoiManager;
        if (r8 != null) goto L10;
    L8:
        this.mRegistered = false;
        sRegistered = false;
        this.mPendingRegister = false;
        updateButtonState(false);
        StoreArrivalEventManager.onExternalNearPoiCallbackUnregistered();
        return;
    L10:
        r8.unregisterNearPoiCallback();     // Catch: Throwable -> L6
        CaeLog.d(TAG, "unregisterNearPoiCallback success");     // Catch: Throwable -> L6
    L6:
        e = move-exception;
        CaeLog.e(TAG, "unregisterNearPoiCallback failed", e);
        goto L8
    }

    private void updateButtonState(boolean r8) {
        Button r10 = this.mRegisterButton;
        if (r10 == null) goto L5;
        r10.setEnabled(!r8);
    L5:
        Button r11 = this.mUnregisterButton;
        if (r11 == null) goto L9;
        r11.setEnabled(r8);
        return;
    }

    private void updateFeedbackButton(LinearLayout r8, PoiArrivalFeedbackInfo r10) {
        int r11 = 0;
    L4:
        if (r11 >= r8.getChildCount()) goto L10;
        View r12 = r8.getChildAt(r11);
        if ((r12 instanceof Button) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        ((Button) r12).setText(getFeedbackButtonText(r10));
        r12.setEnabled(true);
        return;
    }

    private void updateItemBackground(LinearLayout r8, PoiArrivalFeedbackInfo r10) {
        if (r10.getHasFeedback() == false) goto L5;
        int r11 = 0;
    L6:
        r8.setBackgroundColor(r11);
        return;
    L5:
        r11 = Color.rgb(250, 174, 55);
        goto L6
    }

    private void updatePoiDetectState() {
        IStarPoiManager r8 = this.mPoiManager;
        if (r8 != null) goto L10;
        return;
    L10:
        int r10 = 1;
        runOnUiThread(new com.obric.cae.libs.softap.g(this, r8.getPoiDetectState(), r10, r8.getPoiDetectInfo()));     // Catch: Throwable -> L7
        return;
    L7:
        e = move-exception;
        CaeLog.e(TAG, "getPoiDetectState failed", e);
    }

    private void updatePoiFeedback(PoiArrivalFeedbackInfo r8, Button r10, boolean r11) {
        r10.setEnabled(false);
        FeedbackUpdateTask r12 = new FeedbackUpdateTask(this, getApplicationContext(), r8, r10, r11);
        this.mFeedbackUpdateTasks.add(r12);
        r12.start();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        this.mDestroyed = false;
        setContentView(R.layout.activity_poi_arrival);
        initViews();
        createNotificationChannel();
        requestNotificationPermissionIfNeeded();
        StoreArrivalEventManager.addListener(this);
        renderHistoryLines();
        updateButtonState(sRegistered);
        if (sRegistered == false) goto L6;
        this.mPendingRegister = true;
        bindStarLocationService();
        return;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.mDestroyed = true;
        cancelHistoryLoadTask();
        cancelFeedbackUpdateTasks();
        stopPoiDetectStatePolling();
        if (this.mRegistered == false) goto L6;
        unregisterNearPoiCallback();
    L6:
        if (this.mPendingRegister == false) goto L11;
        if (this.mRegistered == true) goto L11;
        this.mPendingRegister = false;
        updateButtonState(sRegistered);
    L11:
        if (this.mBound == true) goto L19;
    L17:
        StoreArrivalEventManager.removeListener(this);
        super.onDestroy();
        return;
    L19:
        unbindService(this.mServiceConnection);     // Catch: Exception -> L14
    L16:
        this.mBound = false;
    L14:
        e = move-exception;
        CaeLog.e(TAG, "unbind StarLocationService failed", e);
        goto L16
    }

    @Override // com.obric.cae.userAware.ui.StoreArrivalEventManager.Listener
    public void onStoreArrivalEvent(PoiArrivalFeedbackInfo r8) {
    }

    @Override // com.obric.cae.userAware.ui.StoreArrivalEventManager.Listener
    public void onStoreArrivalFeedbackUpdated(PoiArrivalFeedbackInfo r8) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        if (this.mListContainer == null) goto L10;
        refreshFeedbackState(r8);
        return;
    }

    private String formatDisplayLine(PoiArrivalFeedbackInfo r8) {
        String r10 = formatLocalTime(r8.getTimeStamp()) + " " + nullToEmpty(r8.getAoiName()) + " " + nullToEmpty(r8.getPoiName());
        String r11 = r8.getCategory();
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return r10;
    L5:
        if (";;".equals(r11) == false) goto L7;
        return r10;
    L7:
        return defpackage.a.f(r10, " ", r11);
    }
}
