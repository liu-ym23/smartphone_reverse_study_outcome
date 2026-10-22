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
    static final String LOG_TAG = "ActivityChooserModel";
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
        void setActivityChooserModel(ActivityChooserModel r5);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo r5) {
            this.resolveInfo = r5;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ActivityResolveInfo r5) {
            return compareTo2(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (ActivityResolveInfo.class == r5.getClass()) goto L12;
            return false;
        L12:
            if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) r5).weight)) goto L14;
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

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ActivityResolveInfo r5) {
            return Float.floatToIntBits(r5.weight) - Float.floatToIntBits(this.weight);
        }
    }

    public interface ActivitySorter {
        void sort(Intent r5, List<ActivityResolveInfo> r10, List<HistoricalRecord> r11);
    }

    public static final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap;

        public DefaultSorter() {
            this.mPackageNameToActivityMap = new HashMap();
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent r10, List<ActivityResolveInfo> r11, List<HistoricalRecord> r12) {
            Map<ComponentName, ActivityResolveInfo> r5 = this.mPackageNameToActivityMap;
            r5.clear();
            int r13 = r11.size();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L5;
            ActivityResolveInfo r15 = r11.get(r14);
            r15.weight = 0.0f;
            ActivityInfo r16 = r15.resolveInfo.activityInfo;
            r5.put(new ComponentName(r16.packageName, r16.name), r15);
            r14 = r14 + 1;
            goto L3
        L5:
            int r17 = r12.size() - 1;
            float r18 = 1.0f;
        L6:
            if (r17 < 0) goto L11;
            HistoricalRecord r19 = r12.get(r17);
            ActivityResolveInfo r20 = r5.get(r19.activity);
            if (r20 == null) goto L10;
            r20.weight = (r19.weight * r18) + r20.weight;
            r18 = r18 * WEIGHT_DECAY_COEFFICIENT;
        L10:
            r17 = r17 - 1;
            goto L6
        L11:
            Collections.sort(r11);
        }
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String r5, long r10, float r11) {
            this(ComponentName.unflattenFromString(r5), r10, r11);
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
            ComponentName r5 = this.activity;
            if (r5 != null) goto L17;
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
            if (r5.equals(r11.activity) == true) goto L20;
            return false;
        }

        public int hashCode() {
            ComponentName r5 = this.activity;
            if (r5 != null) goto L5;
            int r10 = 0;
        L6:
            long r11 = this.time;
            int r12 = Float.floatToIntBits(this.weight);
            return r12 + ((((r10 + 31) * 31) + ((int) (r11 ^ (r11 >>> 32)))) * 31);
        L5:
            r10 = r5.hashCode();
            goto L6
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        public HistoricalRecord(ComponentName r5, long r10, float r11) {
            this.activity = r5;
            this.time = r10;
            this.weight = r11;
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel r5, Intent r10);
    }

    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ ActivityChooserModel this$0;

        public PersistHistoryAsyncTask(ActivityChooserModel r5) {
            this.this$0 = r5;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(Object[] r5) {
            return doInBackground2(r5);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Void doInBackground2(Object... r15) {
            List r5 = (List) r15[0];
            String r16 = (String) r15[1];
            FileOutputStream r17 = this.this$0.mContext.openFileOutput(r16, 0);     // Catch: FileNotFoundException -> L38
            XmlSerializer r10 = Xml.newSerializer();
            r10.setOutput(r17, null);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r10.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r10.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            int r11 = r5.size();     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            int r12 = 0;
        L6:
            if (r12 >= r11) goto L16;
            HistoricalRecord r13 = (HistoricalRecord) r5.remove(0);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r10.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r10.attribute(null, ActivityChooserModel.ATTRIBUTE_ACTIVITY, r13.activity.flattenToString());     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r10.attribute(null, ActivityChooserModel.ATTRIBUTE_TIME, String.valueOf(r13.time));     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r10.attribute(null, ActivityChooserModel.ATTRIBUTE_WEIGHT, String.valueOf(r13.weight));     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r10.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r12 = r12 + 1;     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            goto L6
        L16:
            r10.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r10.endDocument();     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            this.this$0.mCanReadHistoricalData = true;
            if (r17 != null) goto L43;
        L33:
            return null;
        L43:
            r17.close();     // Catch: IOException -> L41
            goto L33
        L8:
            th = move-exception;
            this.this$0.mCanReadHistoricalData = true;
            if (r17 != null) goto L49;
        L37:
            throw th;
        L49:
            r17.close();     // Catch: IOException -> L42
        L10:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L8
            this.this$0.mCanReadHistoricalData = true;
            if (r17 == null) goto L33;
        L14:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L8
            this.this$0.mCanReadHistoricalData = true;
            if (r17 == null) goto L33;
        L12:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L8
            this.this$0.mCanReadHistoricalData = true;
            if (r17 == null) goto L33;
        L38:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + r16, e);
            return null;
        }
    }

    static {
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap();
    }

    private ActivityChooserModel(Context r5, String r10) {
        this.mInstanceLock = new Object();
        this.mActivities = new ArrayList();
        this.mHistoricalRecords = new ArrayList();
        this.mActivitySorter = new DefaultSorter();
        this.mHistoryMaxSize = 50;
        this.mCanReadHistoricalData = true;
        this.mReadShareHistoryCalled = false;
        this.mHistoricalRecordsChanged = true;
        this.mReloadActivities = false;
        this.mContext = r5.getApplicationContext();
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        this.mHistoryFileName = r10;
        return;
    L5:
        if (r10.endsWith(HISTORY_FILE_EXTENSION) == true) goto L7;
        this.mHistoryFileName = r10.concat(HISTORY_FILE_EXTENSION);
    }

    private boolean addHistoricalRecord(HistoricalRecord r5) {
        boolean r10 = this.mHistoricalRecords.add(r5);
        if (r10 == false) goto L5;
        this.mHistoricalRecordsChanged = true;
        pruneExcessiveHistoricalRecordsIfNeeded();
        persistHistoricalDataIfNeeded();
        sortActivitiesIfNeeded();
        notifyChanged();
    L5:
        return r10;
    }

    private void ensureConsistentState() {
        boolean r5 = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (r5 == false) goto L6;
        sortActivitiesIfNeeded();
        notifyChanged();
        return;
    }

    public static ActivityChooserModel get(Context r5, String r10) {
        Object r11 = sRegistryLock;
        monitor-enter(r11);
        Map<String, ActivityChooserModel> r12 = sDataModelRegistry;     // Catch: Throwable -> L7
        ActivityChooserModel r13 = r12.get(r10);     // Catch: Throwable -> L7
        if (r13 != null) goto L9;
        r13 = new ActivityChooserModel(r5, r10);     // Catch: Throwable -> L7
        r12.put(r10, r13);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r13;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean loadActivitiesIfNeeded() {
        int r5 = 0;
        if (this.mReloadActivities == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mIntent == null) goto L11;
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> r10 = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int r11 = r10.size();
    L7:
        if (r5 >= r11) goto L9;
        ResolveInfo r12 = r10.get(r5);
        this.mActivities.add(new ActivityResolveInfo(r12));
        r5 = r5 + 1;
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
        int r5 = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (r5 > 0) goto L5;
        return;
    L5:
        this.mHistoricalRecordsChanged = true;
        int r10 = 0;
    L6:
        if (r10 >= r5) goto L8;
        HistoricalRecord r11 = this.mHistoricalRecords.remove(0);
        r10 = r10 + 1;
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
        FileInputStream r5 = this.mContext.openFileInput(this.mHistoryFileName);     // Catch: FileNotFoundException -> L46
        XmlPullParser r10 = Xml.newPullParser();     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        r10.setInput(r5, "UTF-8");     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        int r11 = 0;
    L6:
        if (r11 == 1) goto L17;
        if (r11 == 2) goto L17;
        r11 = r10.next();     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
    L17:
        if (TAG_HISTORICAL_RECORDS.equals(r10.getName()) == false) goto L35;
        List<HistoricalRecord> r12 = this.mHistoricalRecords;     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        r12.clear();     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
    L19:
        int r13 = r10.next();     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        if (r13 == 1) goto L21;
        if (r13 == 3) goto L19;
        if (r13 == 4) goto L19;
        if (TAG_HISTORICAL_RECORD.equals(r10.getName()) == false) goto L33;
        r12.add(new HistoricalRecord(r10.getAttributeValue(null, ATTRIBUTE_ACTIVITY), Long.parseLong(r10.getAttributeValue(null, ATTRIBUTE_TIME)), Float.parseFloat(r10.getAttributeValue(null, ATTRIBUTE_WEIGHT))));     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        goto L19
    L33:
        throw new XmlPullParserException("Share records file not well-formed.");     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
    L21:
        if (r5 != null) goto L51;
        return;
    L51:
        r5.close();     // Catch: IOException -> L47
        return;
    L69:
        return;
    L35:
        throw new XmlPullParserException("Share records file does not start with historical-records tag.");     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
    L12:
        e = move-exception;
        Log.e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, e);     // Catch: Throwable -> L10
        if (r5 != null) goto L51;
        return;
    L14:
        e = move-exception;
        Log.e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, e);     // Catch: Throwable -> L10
        if (r5 != null) goto L51;
        return;
    L46:
        return;
    L10:
        th = move-exception;
        if (r5 != null) goto L49;
    L45:
        throw th;
    L49:
        r5.close();     // Catch: IOException -> L48
        goto L45
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
        Object r5 = this.mInstanceLock;
        monitor-enter(r5);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != null) goto L10;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return null;
    L10:
        ensureConsistentState();     // Catch: Throwable -> L8
        ActivityInfo r11 = this.mActivities.get(r10).resolveInfo.activityInfo;     // Catch: Throwable -> L8
        ComponentName r12 = new ComponentName(r11.packageName, r11.name);     // Catch: Throwable -> L8
        Intent r13 = new Intent(this.mIntent);     // Catch: Throwable -> L8
        r13.setComponent(r12);     // Catch: Throwable -> L8
        if (this.mActivityChoserModelPolicy == null) goto L16;
        Intent r14 = new Intent(r13);     // Catch: Throwable -> L8
        if (this.mActivityChoserModelPolicy.onChooseActivity(this, r14) == false) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return null;
    L16:
        addHistoricalRecord(new HistoricalRecord(r12, System.currentTimeMillis(), 1.0f));     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        return r13;
    }

    public ResolveInfo getActivity(int r5) {
        Object r10 = this.mInstanceLock;
        monitor-enter(r10);
        ensureConsistentState();     // Catch: Throwable -> L7
        ResolveInfo r11 = this.mActivities.get(r5).resolveInfo;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public int getActivityCount() {
        Object r5 = this.mInstanceLock;
        monitor-enter(r5);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r10 = this.mActivities.size();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public int getActivityIndex(ResolveInfo r5) {
        Object r10 = this.mInstanceLock;
        monitor-enter(r10);
        ensureConsistentState();     // Catch: Throwable -> L10
        List<ActivityResolveInfo> r11 = this.mActivities;     // Catch: Throwable -> L10
        int r12 = r11.size();     // Catch: Throwable -> L10
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        if (r11.get(r13).resolveInfo == r5) goto L8;
        r13 = r13 + 1;     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r13;
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return -1;
    L10:
        th = move-exception;
        throw th;
    }

    public ResolveInfo getDefaultActivity() {
        Object r5 = this.mInstanceLock;
        monitor-enter(r5);
        ensureConsistentState();     // Catch: Throwable -> L9
        if (this.mActivities.isEmpty() == true) goto L11;
        ResolveInfo r10 = this.mActivities.get(0).resolveInfo;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r10;
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public int getHistoryMaxSize() {
        Object r5 = this.mInstanceLock;
        monitor-enter(r5);
        int r10 = this.mHistoryMaxSize;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public int getHistorySize() {
        Object r5 = this.mInstanceLock;
        monitor-enter(r5);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r10 = this.mHistoricalRecords.size();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public Intent getIntent() {
        Object r5 = this.mInstanceLock;
        monitor-enter(r5);
        Intent r10 = this.mIntent;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public void setActivitySorter(ActivitySorter r5) {
        Object r10 = this.mInstanceLock;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mActivitySorter != r5) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        this.mActivitySorter = r5;     // Catch: Throwable -> L8
        if (sortActivitiesIfNeeded() == false) goto L13;
        notifyChanged();     // Catch: Throwable -> L8
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L8
    }

    public void setDefaultActivity(int r10) {
        Object r5 = this.mInstanceLock;
        monitor-enter(r5);
        ensureConsistentState();     // Catch: Throwable -> L7
        ActivityResolveInfo r11 = this.mActivities.get(r10);     // Catch: Throwable -> L7
        ActivityResolveInfo r12 = this.mActivities.get(0);     // Catch: Throwable -> L7
        if (r12 == null) goto L9;
        float r13 = (r12.weight - r11.weight) + 5.0f;     // Catch: Throwable -> L7
    L10:
        ActivityInfo r14 = r11.resolveInfo.activityInfo;     // Catch: Throwable -> L7
        addHistoricalRecord(new HistoricalRecord(new ComponentName(r14.packageName, r14.name), System.currentTimeMillis(), r13));     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L9:
        r13 = 1.0f;
    L7:
        th = move-exception;
        throw th;
    }

    public void setHistoryMaxSize(int r5) {
        Object r10 = this.mInstanceLock;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mHistoryMaxSize != r5) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        this.mHistoryMaxSize = r5;     // Catch: Throwable -> L8
        pruneExcessiveHistoricalRecordsIfNeeded();     // Catch: Throwable -> L8
        if (sortActivitiesIfNeeded() == false) goto L13;
        notifyChanged();     // Catch: Throwable -> L8
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L8
    }

    public void setIntent(Intent r5) {
        Object r10 = this.mInstanceLock;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != r5) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        this.mIntent = r5;     // Catch: Throwable -> L8
        this.mReloadActivities = true;     // Catch: Throwable -> L8
        ensureConsistentState();     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
    }

    public void setOnChooseActivityListener(OnChooseActivityListener r5) {
        Object r10 = this.mInstanceLock;
        monitor-enter(r10);
        this.mActivityChoserModelPolicy = r5;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
