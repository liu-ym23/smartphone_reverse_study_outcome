package com.obric.cae.userAware.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.datacollection.PoiArrivalFeedbackInfo;
import com.obric.cae.userAware.db.PoiArrivalRecordDatabase;
import com.obric.oui.titlebar.OCTitleBar;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class StoreArrivalActivity extends Activity implements StoreArrivalEventManager.Listener {
    private static final TimeZone BEIJING_TIME_ZONE = null;
    private static final ExecutorService FEEDBACK_EXECUTOR = null;
    private static final ThreadLocal<SimpleDateFormat> LOCAL_DATE_FORMAT = null;
    private static final ThreadLocal<SimpleDateFormat> LOCAL_TIME_FORMAT = null;
    private static final Handler MAIN_HANDLER = null;
    private static final String TAG = "StoreArrivalActivity";
    private TextView mDateFilterTextView;
    private boolean mDestroyed;
    private TextView mEmptyText;
    private final ArrayList<FeedbackUpdateTask> mFeedbackUpdateTasks;
    private StoreArrivalEventManager.HistoryLoadTask mHistoryLoadTask;
    private LinearLayout mListContainer;
    private ScrollView mScrollView;
    private String mSelectedDate;

    public static final class FeedbackUpdateTask {
        private final WeakReference<StoreArrivalActivity> mActivityRef;
        private final Context mAppContext;
        private volatile boolean mCanceled;
        private Runnable mDeliverRunnable;
        private Button mFeedbackButton;
        private Future<?> mFuture;
        private final boolean mIsCorrect;
        private PoiArrivalFeedbackInfo mRecord;
        private final Object mTaskLock;

        public FeedbackUpdateTask(StoreArrivalActivity r8, Context r10, PoiArrivalFeedbackInfo r11, Button r12, boolean r13) {
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
            StoreArrivalActivity r11 = this.mActivityRef.get();     // Catch: Throwable -> L20
            PoiArrivalFeedbackInfo r12 = this.mRecord;     // Catch: Throwable -> L20
            Button r13 = this.mFeedbackButton;     // Catch: Throwable -> L20
            this.mFuture = null;     // Catch: Throwable -> L20
            this.mDeliverRunnable = null;     // Catch: Throwable -> L20
            monitor-exit(r10);     // Catch: Throwable -> L20
            if (r11 == null) goto L15;
            StoreArrivalActivity.access$200(r11, this, r12, r13, r8);
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
            o0 r12 = new o0(r11, 1, this);
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
            StoreArrivalActivity.access$100().post(r12);
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
            StoreArrivalActivity.access$100().removeCallbacks(r11);
            return;
        L17:
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public void start() {
            Future<?> r8 = StoreArrivalActivity.access$000().submit(new c0(this, 2));
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
        BEIJING_TIME_ZONE = TimeZone.getTimeZone("Asia/Shanghai");
        MAIN_HANDLER = new Handler(Looper.getMainLooper());
        LOCAL_TIME_FORMAT = ThreadLocal.withInitial(new v0());
        int r8 = 1;
        LOCAL_DATE_FORMAT = ThreadLocal.withInitial(new com.google.protobuf.f(r8));
        FEEDBACK_EXECUTOR = Executors.newSingleThreadExecutor(new com.obric.cae.location.a(r8));
    }

    public StoreArrivalActivity() {
        this.mFeedbackUpdateTasks = new ArrayList();
    }

    public static /* synthetic */ void a(StoreArrivalActivity r8) {
        r8.lambda$scrollToTop$9();
    }

    public static /* synthetic */ ExecutorService access$000() {
        return FEEDBACK_EXECUTOR;
    }

    public static /* synthetic */ Handler access$100() {
        return MAIN_HANDLER;
    }

    public static /* synthetic */ void access$200(StoreArrivalActivity r8, FeedbackUpdateTask r10, PoiArrivalFeedbackInfo r11, Button r12, int r13) {
        r8.onFeedbackUpdateTaskFinished(r10, r11, r12, r13);
    }

    private void addArrivalRecordView(PoiArrivalFeedbackInfo r8, int r10) {
        addArrivalRecordView(r8, r10, true);
    }

    public static /* synthetic */ void b(StoreArrivalActivity r8, View r10) {
        r8.lambda$initViews$4(r10);
    }

    public static /* synthetic */ void c(StoreArrivalActivity r8, PoiArrivalFeedbackInfo r10, Button r11, View r12) {
        r8.lambda$addArrivalRecordView$8(r10, r11, r12);
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
        StoreArrivalEventManager.HistoryLoadTask r8 = this.mHistoryLoadTask;
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

    public static /* synthetic */ SimpleDateFormat d() {
        return lambda$static$0();
    }

    public static /* synthetic */ void e(StoreArrivalActivity r8, DialogInterface r10, int r11) {
        r8.lambda$showDateDialog$5(r10, r11);
    }

    public static /* synthetic */ void f(StoreArrivalActivity r8, PoiArrivalFeedbackInfo r10, Button r11, DialogInterface r12, int r13) {
        r8.lambda$showPoiFeedbackDialog$10(r10, r11, r12, r13);
    }

    private ArrayList<PoiArrivalFeedbackInfo> filterRecordsBySelectedDate(ArrayList<PoiArrivalFeedbackInfo> r8) {
        if (TextUtils.isEmpty(this.mSelectedDate) == false) goto L5;
        return r8;
    L5:
        ArrayList<PoiArrivalFeedbackInfo> r10 = new ArrayList();
        Iterator<PoiArrivalFeedbackInfo> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        PoiArrivalFeedbackInfo r12 = r11.next();
        if (matchesSelectedDate(r12) == false) goto L7;
        r10.add(r12);
        goto L7
    L11:
        return r10;
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

    private String formatLocalDate(long r8) {
        if (r8 > 100000000000L) goto L7;
        r8 = r8 * 1000;
    L7:
        return LOCAL_DATE_FORMAT.get().format(new Date(r8));
    }

    private String formatLocalTime(long r8) {
        if (r8 > 100000000000L) goto L7;
        r8 = r8 * 1000;
    L7:
        return LOCAL_TIME_FORMAT.get().format(new Date(r8));
    }

    public static /* synthetic */ Thread g(Runnable r8) {
        return lambda$static$2(r8);
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

    public static /* synthetic */ void h(StoreArrivalActivity r8, View r10) {
        r8.lambda$initViews$3(r10);
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

    public static /* synthetic */ void i(StoreArrivalActivity r8, Calendar r10, DatePicker r11, DialogInterface r12, int r13) {
        r8.lambda$showDateDialog$7(r10, r11, r12, r13);
    }

    private void initViews() {
        OCTitleBar r8 = (OCTitleBar) findViewById(R.id.store_arrival_title);
        if (r8 == null) goto L5;
        r8.getMLeftActionBack().setOnClickListener(new k(this, 3));
    L5:
        this.mListContainer = (LinearLayout) findViewById(R.id.store_arrival_list_container);
        this.mEmptyText = (TextView) findViewById(R.id.store_arrival_empty_text);
        TextView r10 = (TextView) findViewById(R.id.store_arrival_date_filter_text);
        this.mDateFilterTextView = r10;
        if (r10 == null) goto L8;
        r10.setText(R.string.user_aware_har_all_dates);
        this.mDateFilterTextView.setOnClickListener(new n(this, 1));
    L8:
        this.mScrollView = (ScrollView) findViewById(R.id.store_arrival_scroll_view);
    }

    public static /* synthetic */ void j(StoreArrivalActivity r8, ArrayList r10) {
        r8.renderLoadedHistoryLines(r10);
    }

    public static /* synthetic */ void k(DialogInterface r8, int r10) {
        lambda$showDateDialog$6(r8, r10);
    }

    public static /* synthetic */ SimpleDateFormat l() {
        return lambda$static$1();
    }

    private /* synthetic */ void lambda$addArrivalRecordView$8(PoiArrivalFeedbackInfo r8, Button r10, View r11) {
        showPoiFeedbackDialog(r8, r10);
    }

    private /* synthetic */ void lambda$initViews$3(View r8) {
        finish();
    }

    private /* synthetic */ void lambda$initViews$4(View r8) {
        showDateDialog();
    }

    private /* synthetic */ void lambda$scrollToTop$9() {
        this.mScrollView.smoothScrollTo(0, 0);
    }

    private /* synthetic */ void lambda$showDateDialog$5(DialogInterface r8, int r10) {
        this.mSelectedDate = null;
        TextView r11 = this.mDateFilterTextView;
        if (r11 == null) goto L5;
        r11.setText(R.string.user_aware_har_all_dates);
    L5:
        renderHistoryLines();
    }

    private static /* synthetic */ void lambda$showDateDialog$6(DialogInterface r8, int r10) {
        r8.dismiss();
    }

    private /* synthetic */ void lambda$showDateDialog$7(Calendar r8, DatePicker r10, DialogInterface r11, int r12) {
        r8.set(r10.getYear(), r10.getMonth(), r10.getDayOfMonth());
        String r13 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(r8.getTime());
        this.mSelectedDate = r13;
        TextView r14 = this.mDateFilterTextView;
        if (r14 == null) goto L5;
        r14.setText(r13);
    L5:
        CaeLog.d(TAG, "selected date:" + r8.getTime());
        renderHistoryLines();
    }

    private /* synthetic */ void lambda$showPoiFeedbackDialog$10(PoiArrivalFeedbackInfo r8, Button r10, DialogInterface r11, int r12) {
        updatePoiFeedback(r8, r10, true);
    }

    private /* synthetic */ void lambda$showPoiFeedbackDialog$11(PoiArrivalFeedbackInfo r8, Button r10, DialogInterface r11, int r12) {
        updatePoiFeedback(r8, r10, false);
    }

    private static /* synthetic */ SimpleDateFormat lambda$static$0() {
        return new SimpleDateFormat("HH:mm:ss", Locale.US);
    }

    private static /* synthetic */ SimpleDateFormat lambda$static$1() {
        SimpleDateFormat r8 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        r8.setTimeZone(BEIJING_TIME_ZONE);
        return r8;
    }

    private static /* synthetic */ Thread lambda$static$2(Runnable r8) {
        return new Thread(r8, "StoreArrivalFeedbackUpdater");
    }

    public static /* synthetic */ void m(StoreArrivalActivity r8, PoiArrivalFeedbackInfo r10, Button r11, DialogInterface r12, int r13) {
        r8.lambda$showPoiFeedbackDialog$11(r10, r11, r12, r13);
    }

    private boolean matchesSelectedDate(PoiArrivalFeedbackInfo r8) {
        if (TextUtils.isEmpty(this.mSelectedDate) == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.equals(this.mSelectedDate, formatLocalDate(r8.getTimeStamp())) == true) goto L8;
        return false;
    }

    private static String nullToEmpty(String r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        return r8;
    }

    private void onFeedbackUpdateTaskFinished(FeedbackUpdateTask r8, PoiArrivalFeedbackInfo r10, Button r11, int r12) {
        this.mFeedbackUpdateTasks.remove(r8);
        handlePoiFeedbackResult(r10, r11, r12);
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

    private void renderHistoryLines() {
        if (this.mListContainer != null) goto L5;
        return;
    L5:
        clearArrivalRecordViews();
        this.mEmptyText.setVisibility(0);
        cancelHistoryLoadTask();
        this.mHistoryLoadTask = StoreArrivalEventManager.loadHistoryRecordsAsync(new com.obric.cae.libs.softap.j(this));
    }

    private void renderLoadedHistoryLines(ArrayList<PoiArrivalFeedbackInfo> r8) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        if (this.mListContainer == null) goto L19;
        ArrayList<PoiArrivalFeedbackInfo> r10 = filterRecordsBySelectedDate(r8);
        if (r10.isEmpty() == false) goto L11;
        this.mEmptyText.setVisibility(0);
        return;
    L11:
        this.mEmptyText.setVisibility(8);
        Collections.reverse(r10);
        Iterator<PoiArrivalFeedbackInfo> r11 = r10.iterator();
    L13:
        if (r11.hasNext() == false) goto L15;
        addArrivalRecordView(r11.next(), 0, false);
        goto L13
    L15:
        scrollToTop();
        return;
    }

    private void scrollToTop() {
        ScrollView r8 = this.mScrollView;
        if (r8 == null) goto L6;
        r8.post(new androidx.activity.k(this, 25));
        return;
    }

    private void showDateDialog() {
        Calendar r8 = Calendar.getInstance();
        DatePicker r10 = new DatePicker(this);
        r10.init(r8.get(1), r8.get(2), r8.get(5), null);
        AlertDialog.Builder r11 = new AlertDialog.Builder(this);
        r11.setTitle(R.string.user_aware_har_select_date);
        r11.setView(r10);
        r11.setNeutralButton(R.string.user_aware_har_all_dates, new t0(this));
        r11.setNegativeButton(R.string.user_aware_har_cancel, new u0());
        r11.setPositiveButton(R.string.user_aware_har_confirm, new j0(this, r8, r10, 2));
        r11.show();
    }

    private void showPoiFeedbackDialog(PoiArrivalFeedbackInfo r8, Button r10) {
        int r11 = 1;
        new AlertDialog.Builder(this).setTitle(getString(R.string.user_aware_store_arrival_feedback_title)).setMessage(formatDisplayLine(r8)).setPositiveButton(R.string.user_aware_har_select_true, new i0(this, r8, r10, r11)).setNegativeButton(R.string.user_aware_har_select_false, new j0(this, r8, r10, r11)).show();
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
        setContentView(R.layout.activity_store_arrival);
        initViews();
        StoreArrivalEventManager.addListener(this);
        StoreArrivalEventManager.ensureRegistered(getApplicationContext());
        renderHistoryLines();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.mDestroyed = true;
        cancelHistoryLoadTask();
        cancelFeedbackUpdateTasks();
        StoreArrivalEventManager.removeListener(this);
        super.onDestroy();
    }

    @Override // com.obric.cae.userAware.ui.StoreArrivalEventManager.Listener
    public void onStoreArrivalEvent(PoiArrivalFeedbackInfo r8) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        if (this.mListContainer != null) goto L7;
        return;
    L7:
        if (this.mScrollView != null) goto L10;
        return;
    L10:
        if (matchesSelectedDate(r8) == true) goto L12;
        return;
    L12:
        addArrivalRecordView(r8, 0);
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

    private void addArrivalRecordView(final PoiArrivalFeedbackInfo r8, int r10, boolean r11) {
        this.mEmptyText.setVisibility(8);
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
        r15.setOnClickListener(new w0(this, r8, r15));
        r12.addView(r15, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-1, -2);
        r16.setMargins(0, 0, 0, 1);
        this.mListContainer.addView(r12, r10, r16);
        if (r11 == false) goto L6;
        scrollToTop();
        return;
    }
}
