package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
class ActivityChooserModel extends DataSetObservable {
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final String LOG_TAG = null;
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = null;
    private static final Object sRegistryLock = null;
    private final List<ActivityResolveInfo> mActivities;
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter;
    boolean mCanReadHistoricalData;
    final Context mContext;
    private final List<HistoricalRecord> mHistoricalRecords;
    private boolean mHistoricalRecordsChanged;
    final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock;
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;
    private boolean mReloadActivities;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel r10);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo r10) {
            this.resolveInfo = r10;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ActivityResolveInfo r10) {
            return Float.floatToIntBits(r10.weight) - Float.floatToIntBits(this.weight);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ActivityResolveInfo r10) {
            return compareTo2(r10);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 != null) goto L9;
            return false;
        L9:
            if (ActivityResolveInfo.class == r10.getClass()) goto L12;
            return false;
        L12:
            if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) r10).weight)) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }
    }

    public interface ActivitySorter {
        void sort(Intent r10, List<ActivityResolveInfo> r11, List<HistoricalRecord> r12);
    }

    private static final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap;

        DefaultSorter() {
            this.mPackageNameToActivityMap = new HashMap();
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent r10, List<ActivityResolveInfo> r11, List<HistoricalRecord> r12) {
            Map<ComponentName, ActivityResolveInfo> r13 = this.mPackageNameToActivityMap;
            r13.clear();
            int r14 = r11.size();
            int r15 = 0;
        L3:
            if (r15 >= r14) goto L5;
            ActivityResolveInfo r16 = r11.get(r15);
            r16.weight = 0.0f;
            ActivityInfo r17 = r16.resolveInfo.activityInfo;
            r13.put(new ComponentName(r17.packageName, r17.name), r16);
            r15 = r15 + 1;
            goto L3
        L5:
            int r18 = r12.size() - 1;
            float r19 = 1.0f;
        L6:
            if (r18 < 0) goto L11;
            HistoricalRecord r20 = r12.get(r18);
            ActivityResolveInfo r21 = r13.get(r20.activity);
            if (r21 == null) goto L10;
            r21.weight += r20.weight * r19;
            r19 = r19 * WEIGHT_DECAY_COEFFICIENT;
        L10:
            r18 = r18 - 1;
            goto L6
        L11:
            Collections.sort(r11);
        }
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(ComponentName r10, long r11, float r12) {
            this.activity = r10;
            this.time = r11;
            this.weight = r12;
        }

        public HistoricalRecord(String r10, long r11, float r12) {
            this(ComponentName.unflattenFromString(r10), r11, r12);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 != null) goto L9;
            return false;
        L9:
            if (HistoricalRecord.class == r10.getClass()) goto L11;
            return false;
        L11:
            HistoricalRecord r11 = (HistoricalRecord) r10;
            ComponentName r12 = this.activity;
            if (r12 != null) goto L17;
            if (r11.activity == null) goto L20;
            return false;
        L20:
            if (this.time == r11.time) goto L23;
            return false;
        L23:
            if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(r11.weight)) goto L25;
            return false;
        L25:
            return true;
        L17:
            if (r12.equals(r11.activity) == true) goto L20;
            return false;
        }

        public int hashCode() {
            ComponentName r10 = this.activity;
            if (r10 != null) goto L5;
            int r11 = 0;
        L6:
            long r12 = this.time;
            return ((((r11 + 31) * 31) + ((int) (r12 ^ (r12 >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        L5:
            r11 = r10.hashCode();
            goto L6
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel r10, Intent r11);
    }

    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ ActivityChooserModel this$0;

        PersistHistoryAsyncTask(ActivityChooserModel r10) {
            this.this$0 = r10;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(Object[] r10) {
            return doInBackground2(r10);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Void doInBackground2(Object... r15) {
            List r10 = (List) r15[0];
            String r16 = (String) r15[1];
            FileOutputStream r17 = this.this$0.mContext.openFileOutput(r16, 0);     // Catch: FileNotFoundException -> L35
            XmlSerializer r11 = Xml.newSerializer();
            r11.setOutput(r17, null);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r11.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r11.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            int r12 = r10.size();     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            int r13 = 0;
        L6:
            if (r13 >= r12) goto L8;
            HistoricalRecord r14 = (HistoricalRecord) r10.remove(0);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r11.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r11.attribute(null, ActivityChooserModel.ATTRIBUTE_ACTIVITY, r14.activity.flattenToString());     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r11.attribute(null, "time", String.valueOf(r14.time));     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r11.attribute(null, ActivityChooserModel.ATTRIBUTE_WEIGHT, String.valueOf(r14.weight));     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r11.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r13 = r13 + 1;     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            goto L6
        L8:
            r11.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r11.endDocument();     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            this.this$0.mCanReadHistoricalData = true;
            if (r17 != null) goto L43;
        L30:
            return null;
        L43:
            r17.close();     // Catch: IOException -> L38
            goto L30
        L13:
            th = move-exception;
            this.this$0.mCanReadHistoricalData = true;
            if (r17 != null) goto L46;
        L34:
            throw th;
        L46:
            r17.close();     // Catch: IOException -> L39
        L15:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L13
            this.this$0.mCanReadHistoricalData = true;
            if (r17 == null) goto L30;
        L25:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L13
            this.this$0.mCanReadHistoricalData = true;
            if (r17 == null) goto L30;
        L20:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L13
            this.this$0.mCanReadHistoricalData = true;
            if (r17 == null) goto L30;
        L35:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + r16, e);
            return null;
        }
    }

    static {
        LOG_TAG = ActivityChooserModel.class.getSimpleName();
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap();
    }

    private ActivityChooserModel(Context r10, String r11) {
        this.mInstanceLock = new Object();
        this.mActivities = new ArrayList();
        this.mHistoricalRecords = new ArrayList();
        this.mActivitySorter = new DefaultSorter();
        this.mHistoryMaxSize = 50;
        this.mCanReadHistoricalData = true;
        this.mReadShareHistoryCalled = false;
        this.mHistoricalRecordsChanged = true;
        this.mReloadActivities = false;
        this.mContext = r10.getApplicationContext();
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L7:
        this.mHistoryFileName = r11;
        return;
    L5:
        if (r11.endsWith(HISTORY_FILE_EXTENSION) == true) goto L7;
        this.mHistoryFileName = r11 + HISTORY_FILE_EXTENSION;
    }

    private boolean addHistoricalRecord(HistoricalRecord r10) {
        boolean r11 = this.mHistoricalRecords.add(r10);
        if (r11 == false) goto L5;
        this.mHistoricalRecordsChanged = true;
        pruneExcessiveHistoricalRecordsIfNeeded();
        persistHistoricalDataIfNeeded();
        sortActivitiesIfNeeded();
        notifyChanged();
    L5:
        return r11;
    }

    private void ensureConsistentState() {
        boolean r10 = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (r10 == false) goto L6;
        sortActivitiesIfNeeded();
        notifyChanged();
        return;
    }

    public static ActivityChooserModel get(Context r10, String r11) {
        Object r12 = sRegistryLock;
        monitor-enter(r12);
        Map<String, ActivityChooserModel> r13 = sDataModelRegistry;     // Catch: Throwable -> L9
        ActivityChooserModel r14 = r13.get(r11);     // Catch: Throwable -> L9
        if (r14 != null) goto L7;
        r14 = new ActivityChooserModel(r10, r11);     // Catch: Throwable -> L9
        r13.put(r11, r14);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r12);     // Catch: Throwable -> L9
        return r14;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean loadActivitiesIfNeeded() {
        int r10 = 0;
        if (this.mReloadActivities == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mIntent == null) goto L11;
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> r11 = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int r12 = r11.size();
    L7:
        if (r10 >= r12) goto L9;
        ResolveInfo r13 = r11.get(r10);
        this.mActivities.add(new ActivityResolveInfo(r13));
        r10 = r10 + 1;
        goto L7
    L9:
        return true;
    }

    private void persistHistoricalDataIfNeeded() {
        if (this.mReadShareHistoryCalled == false) goto L12;
        if (this.mHistoricalRecordsChanged == true) goto L7;
        return;
    L7:
        this.mHistoricalRecordsChanged = false;
        if (TextUtils.isEmpty(this.mHistoryFileName) == true) goto L13;
        new PersistHistoryAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.mHistoricalRecords), this.mHistoryFileName});
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("No preceding call to #readHistoricalData");
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int r10 = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (r10 > 0) goto L5;
        return;
    L5:
        this.mHistoricalRecordsChanged = true;
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L8;
        HistoricalRecord r12 = this.mHistoricalRecords.remove(0);
        r11 = r11 + 1;
        goto L6
    }

    private boolean readHistoricalDataIfNeeded() {
        if (this.mCanReadHistoricalData == true) goto L5;
    L10:
        return false;
    L5:
        if (this.mHistoricalRecordsChanged == false) goto L10;
        if (TextUtils.isEmpty(this.mHistoryFileName) == true) goto L10;
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    private void readHistoricalDataImpl() {
        FileInputStream r10 = this.mContext.openFileInput(this.mHistoryFileName);     // Catch: FileNotFoundException -> L44
        XmlPullParser r11 = Xml.newPullParser();     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
        r11.setInput(r10, "UTF-8");     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
        int r12 = 0;
    L6:
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L11;
        r12 = r11.next();     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
    L11:
        if (TAG_HISTORICAL_RECORDS.equals(r11.getName()) == false) goto L29;
        List<HistoricalRecord> r13 = this.mHistoricalRecords;     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
        r13.clear();     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
    L13:
        int r14 = r11.next();     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
        if (r14 == 1) goto L15;
        if (r14 == 3) goto L13;
        if (r14 == 4) goto L13;
        if (TAG_HISTORICAL_RECORD.equals(r11.getName()) == false) goto L27;
        r13.add(new HistoricalRecord(r11.getAttributeValue(null, ATTRIBUTE_ACTIVITY), Long.parseLong(r11.getAttributeValue(null, "time")), Float.parseFloat(r11.getAttributeValue(null, ATTRIBUTE_WEIGHT))));     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
        goto L13
    L27:
        throw new XmlPullParserException("Share records file not well-formed.");     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
    L15:
        if (r10 != null) goto L52;
        return;
    L52:
        r10.close();     // Catch: IOException -> L45
        return;
    L67:
        return;
    L29:
        throw new XmlPullParserException("Share records file does not start with historical-records tag.");     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
    L30:
        th = move-exception;
        if (r10 != null) goto L50;
    L43:
        throw th;
    L50:
        r10.close();     // Catch: IOException -> L46
    L32:
        e = move-exception;
        Log.e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, e);     // Catch: Throwable -> L30
        if (r10 != null) goto L52;
        return;
    L36:
        e = move-exception;
        Log.e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, e);     // Catch: Throwable -> L30
        if (r10 != null) goto L52;
        return;
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter != null) goto L5;
        return false;
    L5:
        if (this.mIntent != null) goto L7;
        return false;
    L7:
        if (this.mActivities.isEmpty() == false) goto L9;
        return false;
    L9:
        if (this.mHistoricalRecords.isEmpty() == true) goto L16;
        this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    L16:
        return false;
    }

    public Intent chooseActivity(int r10) {
        Object r11 = this.mInstanceLock;
        monitor-enter(r11);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != null) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L17
        return null;
    L8:
        ensureConsistentState();     // Catch: Throwable -> L17
        ActivityInfo r12 = this.mActivities.get(r10).resolveInfo.activityInfo;     // Catch: Throwable -> L17
        ComponentName r13 = new ComponentName(r12.packageName, r12.name);     // Catch: Throwable -> L17
        Intent r14 = new Intent(this.mIntent);     // Catch: Throwable -> L17
        r14.setComponent(r13);     // Catch: Throwable -> L17
        if (this.mActivityChoserModelPolicy == null) goto L14;
        Intent r15 = new Intent(r14);     // Catch: Throwable -> L17
        if (this.mActivityChoserModelPolicy.onChooseActivity(this, r15) == false) goto L14;
        monitor-exit(r11);     // Catch: Throwable -> L17
        return null;
    L14:
        addHistoricalRecord(new HistoricalRecord(r13, System.currentTimeMillis(), 1.0f));     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return r14;
    }

    public ResolveInfo getActivity(int r10) {
        Object r11 = this.mInstanceLock;
        monitor-enter(r11);
        ensureConsistentState();     // Catch: Throwable -> L7
        ResolveInfo r12 = this.mActivities.get(r10).resolveInfo;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public int getActivityCount() {
        Object r10 = this.mInstanceLock;
        monitor-enter(r10);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r11 = this.mActivities.size();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public int getActivityIndex(ResolveInfo r10) {
        Object r11 = this.mInstanceLock;
        monitor-enter(r11);
        ensureConsistentState();     // Catch: Throwable -> L14
        List<ActivityResolveInfo> r12 = this.mActivities;     // Catch: Throwable -> L14
        int r13 = r12.size();     // Catch: Throwable -> L14
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L12;
        if (r12.get(r14).resolveInfo == r10) goto L8;
        r14 = r14 + 1;     // Catch: Throwable -> L14
        goto L5
    L8:
        monitor-exit(r11);     // Catch: Throwable -> L14
        return r14;
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L14
        return -1;
    L14:
        th = move-exception;
        throw th;
    }

    public ResolveInfo getDefaultActivity() {
        Object r10 = this.mInstanceLock;
        monitor-enter(r10);
        ensureConsistentState();     // Catch: Throwable -> L12
        if (this.mActivities.isEmpty() == true) goto L9;
        ResolveInfo r11 = this.mActivities.get(0).resolveInfo;     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r11;
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public int getHistoryMaxSize() {
        Object r10 = this.mInstanceLock;
        monitor-enter(r10);
        int r11 = this.mHistoryMaxSize;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public int getHistorySize() {
        Object r10 = this.mInstanceLock;
        monitor-enter(r10);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r11 = this.mHistoricalRecords.size();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public Intent getIntent() {
        Object r10 = this.mInstanceLock;
        monitor-enter(r10);
        Intent r11 = this.mIntent;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public void setActivitySorter(ActivitySorter r10) {
        Object r11 = this.mInstanceLock;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mActivitySorter != r10) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L8:
        this.mActivitySorter = r10;     // Catch: Throwable -> L13
        if (sortActivitiesIfNeeded() == false) goto L11;
        notifyChanged();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
    }

    public void setDefaultActivity(int r10) {
        Object r11 = this.mInstanceLock;
        monitor-enter(r11);
        ensureConsistentState();     // Catch: Throwable -> L11
        ActivityResolveInfo r12 = this.mActivities.get(r10);     // Catch: Throwable -> L11
        ActivityResolveInfo r13 = this.mActivities.get(0);     // Catch: Throwable -> L11
        if (r13 == null) goto L7;
        float r14 = (r13.weight - r12.weight) + 5.0f;     // Catch: Throwable -> L11
    L8:
        ActivityInfo r15 = r12.resolveInfo.activityInfo;     // Catch: Throwable -> L11
        addHistoricalRecord(new HistoricalRecord(new ComponentName(r15.packageName, r15.name), System.currentTimeMillis(), r14));     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L7:
        r14 = 1.0f;
    L11:
        th = move-exception;
        throw th;
    }

    public void setHistoryMaxSize(int r10) {
        Object r11 = this.mInstanceLock;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mHistoryMaxSize != r10) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L8:
        this.mHistoryMaxSize = r10;     // Catch: Throwable -> L13
        pruneExcessiveHistoricalRecordsIfNeeded();     // Catch: Throwable -> L13
        if (sortActivitiesIfNeeded() == false) goto L11;
        notifyChanged();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
    }

    public void setIntent(Intent r10) {
        Object r11 = this.mInstanceLock;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != r10) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        this.mIntent = r10;     // Catch: Throwable -> L11
        this.mReloadActivities = true;     // Catch: Throwable -> L11
        ensureConsistentState();     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    }

    public void setOnChooseActivityListener(OnChooseActivityListener r10) {
        Object r11 = this.mInstanceLock;
        monitor-enter(r11);
        this.mActivityChoserModelPolicy = r10;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
