package com.obric.cae.smartNetwork.networkHandoverRL;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IThermalService;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Temperature;
import androidx.activity.j;
import com.bytedance.keva.KevaImpl;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.FeatureData;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkSwitchPolicyML {
    private static final int DEFAULT_BATCH_SIZE = 8;
    private static final int DEFAULT_MAX_EVAL_SAMPLES = 1000;
    private static final int DEFAULT_MAX_TRAIN_SAMPLES = 50000;
    private static final int DEFAULT_MAX_TRAIN_STEPS = 1200;
    private static final int DEFAULT_MIN_TRAIN_STEPS = 400;
    private static final int DEFAULT_OTHER_PER_IMPORTANT = 4;
    private static final int DEFAULT_TRAIN_BATTERY_PERCENT = 60;
    private static final int DEFAULT_TRAIN_IMPORTANT_FEATURE_COUNT = 80;
    private static final float DEFAULT_TRAIN_SKIN_TEMPERATURE_C = 33.9f;
    private static final int IMPORTANT_FEATURE_MAX_DAYS = 90;
    private static final String KEY_LAST_TRAIN_IMPORTANT_COUNT = "last_train_important_count";
    private static final String KEY_TOTAL_FEATURE_COUNT = "total_feature_count";
    private static final String KEY_TOTAL_IMPORTANT_COUNT = "total_important_count";
    private static final int MAX_FEATURE_HISTORY_COUNT = 60;
    public static final int RESULT_TYPE_SWITCH_CELL_INTERVENTION = 1;
    public static final int RESULT_TYPE_SWITCH_CELL_NO_INTERVENTION = 2;
    public static final int RESULT_TYPE_USER_SWITCH_CELL = 0;
    private static final String TAG = "NetworkSwitchPolicyML";
    private static final int UNIMPORTANT_FEATURE_MAX_DAYS = 30;
    private static volatile NetworkSwitchPolicyML sInstance;
    private final ScheduledExecutorService mAutoTrainScheduler;
    private final Context mContext;
    private NetworkSwitchDatabase mDatabase;
    private int mFeatureCount;
    private final List<FeatureParams> mFeatureHistory;
    private final Object mHistoryLock;
    private boolean mIsAvailable;
    private NetworkSwitchML mNetworkSwitchML;
    private final IThermalService mThermalService;
    private final ExecutorService mTrainExecutor;
    private final AtomicBoolean mTrainingInProgress;

    public static class FeatureParams {
        public int important;
        public final long index;
        public int label;
        public final int[] params;
        public float predict;
        public int saved;
        public final long timestamp;

        public FeatureParams(long r8, long r10, int[] r11, int r12, int r13) {
            this.timestamp = r8;
            this.index = r10;
            this.params = r11;
            this.label = r12;
            this.important = r13;
            this.saved = 0;
            this.predict = 0.0f;
        }

        public String toString() {
            return "params: " + Arrays.toString(this.params) + " label: " + this.label + " predict: " + this.predict + " important: " + this.important + " saved: " + this.saved + " timestamp: " + this.timestamp + " index: " + this.index;
        }
    }

    private NetworkSwitchPolicyML(Context r8) {
        this.mFeatureCount = 0;
        this.mHistoryLock = new Object();
        this.mNetworkSwitchML = null;
        this.mDatabase = null;
        this.mTrainExecutor = Executors.newSingleThreadExecutor();
        this.mTrainingInProgress = new AtomicBoolean(false);
        this.mAutoTrainScheduler = Executors.newSingleThreadScheduledExecutor();
        this.mIsAvailable = false;
        this.mFeatureHistory = new ArrayList();
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mThermalService = IThermalService.Stub.asInterface(ServiceManager.getService("thermalservice"));
        this.mNetworkSwitchML = NetworkSwitchML.getInstance(r10);     // Catch: Throwable -> L5
        this.mDatabase = NetworkSwitchDatabase.getInstance(r10);     // Catch: Throwable -> L5
        this.mIsAvailable = true;     // Catch: Throwable -> L5
    L8:
        if (this.mIsAvailable == false) goto L13;
        initAutoTrainTimer();
        return;
    L13:
        return;
    L5:
        th = move-exception;
        CaeLog.e(TAG, "NetworkSwitchPolicyML init failed: " + th.getMessage(), th);
        this.mIsAvailable = false;
        goto L8
    }

    public static /* synthetic */ void a(NetworkSwitchPolicyML r8) {
        r8.lambda$initAutoTrainTimer$0();
    }

    public static /* synthetic */ void b(NetworkSwitchPolicyML r8, float r10) {
        r8.lambda$trainFromRecentDatasAsync$1(r10);
    }

    private void checkAndTriggerAutoTraining() {
        int r8 = getBatteryLevelPercent();
        boolean r10 = isCharging();
        boolean r11 = true;
        boolean r12 = !isScreenOn();
        float r13 = getCurrentSkinTemperatureC();
        if (r13 > 0.0f) goto L5;
    L7:
        r11 = false;
    L8:
        int r14 = Math.max(0, this.mDatabase.getValueInt(KEY_TOTAL_IMPORTANT_COUNT, 0) - Math.max(0, this.mDatabase.getValueInt(KEY_LAST_TRAIN_IMPORTANT_COUNT, 0)));
        StringBuilder r15 = new StringBuilder("check train condition: battery=");
        r15.append(r8);
        r15.append(", charging=");
        r15.append(r10);
        r15.append(", skinTempC=");
        r15.append(r13);
        r15.append(", screenOff=");
        r15.append(r12);
        r15.append(", untrained=");
        defpackage.b.p(r15, r14, TAG);
        if (r8 <= 60) goto L19;
        if (r10 == false) goto L20;
        if (r11 == false) goto L21;
        if (r12 == true) goto L14;
        return;
    L14:
        if (r14 > DEFAULT_TRAIN_IMPORTANT_FEATURE_COUNT) goto L16;
        return;
    L16:
        if (this.mTrainingInProgress.get() == true) goto L24;
        trainFromRecentDatasAsync(1.0E-4f);
        return;
    L24:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (r13 >= DEFAULT_TRAIN_SKIN_TEMPERATURE_C) goto L7;
        goto L7
    }

    private float doPredictSwitchCell(FeatureParams r8) {
        if (this.mIsAvailable == false) goto L11;
        NetworkSwitchML r10 = this.mNetworkSwitchML;
        if (r10 == null) goto L11;
        return r10.predict(r8.params);
    L9:
        e = move-exception;
        CaeLog.e(TAG, "doPredictSwitchCell error: " + e.getMessage(), e);
    L11:
        return 0.0f;
    }

    private float doTrainAllDatas(List<FeatureParams> r17, float r18) {
        if (this.mDatabase != null) goto L5;
    L23:
        CaeLog.w(TAG, "doTrainAllDatas: database or ML is null");
        return 0.0f;
    L5:
        if (this.mNetworkSwitchML == null) goto L23;
        int r8 = r17.size();     // Catch: Exception -> L20
        int[][] r10 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r8, 11});     // Catch: Exception -> L20
        float[][] r11 = (float[][]) Array.newInstance(Float.TYPE, new int[]{r8, 1});     // Catch: Exception -> L20
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r12 >= r8) goto L18;
        FeatureParams r15 = r17.get(r12);     // Catch: Exception -> L20
        System.arraycopy(r15.params, 0, r10[r12], 0, 11);     // Catch: Exception -> L20
        float[] r16 = r11[r12];     // Catch: Exception -> L20
        int r19 = r15.label;     // Catch: Exception -> L20
        if (r19 != 0) goto L12;
        float r110 = 0.0f;
    L13:
        r16[0] = r110;     // Catch: Exception -> L20
        if (r19 != 0) goto L16;
        r14 = r14 + 1;     // Catch: Exception -> L20
    L17:
        r12 = r12 + 1;     // Catch: Exception -> L20
        goto L8
    L16:
        r13 = r13 + 1;     // Catch: Exception -> L20
        goto L17
    L12:
        r110 = 1.0f;
        goto L13
    L18:
        CaeLog.i(TAG, "doTrainAllDatas: train_size=" + r8 + ", switch_count=" + r13 + ", no_switch_count=" + r14);     // Catch: Exception -> L20
        int r20 = Math.min(DEFAULT_MAX_TRAIN_STEPS, Math.max(DEFAULT_MIN_TRAIN_STEPS, Math.max(1, ((r8 + 8) - 1) / 8)));     // Catch: Exception -> L20
        long r111 = System.currentTimeMillis();     // Catch: Exception -> L20
        float r21 = this.mNetworkSwitchML.train(r10, r11, r18, r20, 8);     // Catch: Exception -> L20
        CaeLog.i(TAG, "doTrainAllDatas: training finished: steps=" + r20 + ", lr=" + r18 + ", batchSize=8, train_time_ms=" + (System.currentTimeMillis() - r111) + ", last_loss=" + r21);     // Catch: Exception -> L20
        this.mNetworkSwitchML.saveUpdatedModel();     // Catch: Exception -> L20
        return r21;
    L20:
        e = move-exception;
        CaeLog.e(TAG, "doTrainAllDatas error: " + e.getMessage(), e);
        return 0.0f;
    }

    private FeatureParams featureParamSmooth(FeatureParams r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r8 = this.mFeatureHistory.size();
        if (r8 > 0) goto L8;
        return r10;
    L8:
        FeatureParams r11 = this.mFeatureHistory.get(r8 - 1);
        long r12 = r10.timestamp - r11.timestamp;
        if (r12 >= 0) goto L11;
    L30:
        return r10;
    L11:
        if (r12 > 1200) goto L30;
        int r13 = r11.params[8];
        int[] r14 = r10.params;
        if (r13 != r14[8]) goto L30;
        int[] r15 = new int[r14.length];
        int r16 = 0;
    L16:
        int[] r17 = r10.params;
        if (r16 >= r17.length) goto L29;
        if (r16 != 7) goto L21;
    L26:
        r15[r16] = (int) Math.round((((double) r17[r16]) * 0.6d) + (((double) r11.params[r16]) * 0.4d));
    L27:
        r16 = r16 + 1;
        goto L16
    L21:
        if (r16 == 9) goto L26;
        if (r16 == 10) goto L26;
        r15[r16] = r17[r16];
        goto L27
    L29:
        return new FeatureParams(r10.timestamp, r10.index, r15, r10.label, r10.important);
    }

    private int getBatteryLevelPercent() {
        Intent r8 = this.mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L13
        if (r8 != null) goto L6;
        return -1;
    L6:
        int r10 = r8.getIntExtra("level", -1);     // Catch: Throwable -> L13
        int r11 = r8.getIntExtra("scale", -1);     // Catch: Throwable -> L13
        if (r10 < 0) goto L12;
        if (r11 <= 0) goto L12;
        return (int) ((r10 * 100.0f) / r11);
    L12:
        return -1;
    L13:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("getBatteryLevelPercent error: "), TAG);
        return -1;
    }

    private float getCurrentSkinTemperatureC() {
        IThermalService r8 = this.mThermalService;
        if (r8 != null) goto L20;
        return -1.0f;
    L20:
        Temperature[] r10 = r8.getCurrentTemperaturesWithType(3);     // Catch: Throwable -> L14 RemoteException -> L16
        if (r10 != null) goto L9;
    L13:
        return -1.0f;
    L9:
        if (r10.length <= 0) goto L13;
        return r10[0].getValue();
    L16:
        e = move-exception;
        StringBuilder r11 = new StringBuilder("getCurrentSkinTemperatureC RemoteException: ");
        String r12 = e.getMessage();
    L18:
        r11.append(r12);
        CaeLog.w(TAG, r11.toString());
        return -1.0f;
    L14:
        th = move-exception;
        r11 = new StringBuilder("getCurrentSkinTemperatureC error: ");
        r12 = th.getMessage();
        goto L18
    }

    public static NetworkSwitchPolicyML getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(NetworkSwitchPolicyML.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NetworkSwitchPolicyML(r8.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkSwitchPolicyML.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private List<FeatureParams> getTrainFeatureList(int r11, int r12, int r13, int r14) {
        int r8 = Math.min(30, r11);
        List<FeatureParams> r10 = this.mDatabase.getRecentModelParams(r11, 1);
        List<FeatureParams> r15 = this.mDatabase.getRecentModelParams(r8, 0);
        if (r10 != null) goto L5;
        int r16 = 0;
    L6:
        if (r15 != null) goto L8;
        int r17 = 0;
    L10:
        if (r16 <= 0) goto L20;
        if (r17 <= 0) goto L20;
        int r18 = r16 * r12;
        int r19 = Math.min(r13 * r18, r17);
        ArrayList r20 = new ArrayList(r18 + r19);
        StringBuilder r110 = defpackage.a.g("getTrainFeatureList day=", r11, ", importantCount=", r16, ", increase=");
        defpackage.b.q(r110, r12, ", impCount=", r18, ", other count=");
        r110.append(r17);
        r110.append(", desiredOther=");
        r110.append(r19);
        CaeLog.i(TAG, r110.toString());
        int r111 = 0;
    L14:
        if (r111 >= r12) goto L16;
        r20.addAll(r10);
        r111 = r111 + 1;
        goto L14
    L16:
        Collections.shuffle(r15);
        r20.addAll(r15.subList(0, r19));
        Collections.shuffle(r20);
        if (r20.size() > r14) goto L19;
        return r20;
    L19:
        return new ArrayList(r20.subList(0, r14));
    L20:
        CaeLog.w(TAG, "No sufficient recent data for training, importantCount=" + r16 + ", otherCount=" + r17);
        return null;
    L8:
        r17 = r15.size();
        goto L10
    L5:
        r16 = r10.size();
        goto L6
    }

    private float getWeightsOfL24(FeatureParams r8) {
        int[] r10 = r8.params;
        int r11 = r10[7];
        int r12 = r10[8];
        int r13 = r10[10];
        if (r12 == 0) goto L5;
        int r14 = 5000;
        int r15 = BWDLInnerConstant.DATA_LINK_TOUT;
    L6:
        float r16 = 1.0f;
        if (r11 > r14) goto L9;
        float r17 = 1.0f;
    L13:
        if (r13 >= 200) goto L18;
        if (r13 > 10) goto L17;
        r16 = 0.0f;
        goto L18
    L17:
        r16 = (r13 - 10) / 190;
    L18:
        float r18 = r17 + r16;
        if (r18 > 0.0f) goto L23;
        return 0.5f;
    L23:
        return r16 / r18;
    L9:
        if (r11 < r15) goto L11;
        r17 = 0.0f;
        goto L13
    L11:
        r17 = 1.0f - ((r11 - r14) / (r15 - r14));
        goto L13
    L5:
        r14 = BWDLInnerConstant.EVENT_TIME_TOUT;
        r15 = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        goto L6
    }

    private void handleNotImportantFeature(FeatureParams r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.label = 0;
        float r10 = r8.predict;
        if (r10 <= 0.5d) goto L8;
        return;
    L8:
        if (r10 <= 0.1d) goto L10;
        saveFeatureParams(r8, 0, true);
        return;
    L10:
        saveFeatureParams(r8, 0, false);
    }

    private void handleSwitchCellIntervention(int r8, int r10) {
        int r11 = r8;
    L4:
        if (r11 < Math.max(0, r8 - r10)) goto L9;
        FeatureParams r12 = this.mFeatureHistory.get(r11);
        if (r12.predict >= 0.9d) goto L8;
        r12.label = 0;
        saveFeatureParams(r12, 1, true);
    L8:
        r11 = r11 - 1;
        goto L4
    }

    private void handleSwitchCellNoIntervention(int r10, int r11) {
        int r8 = r10;
    L4:
        if (r8 < Math.max(0, r10 - r11)) goto L12;
        FeatureParams r12 = this.mFeatureHistory.get(r8);
        if (r12.predict <= 0.8d) goto L9;
        r12.label = 1;
        saveFeatureParams(r12, 1, true);
    L9:
        if (r12.predict >= 0.2d) goto L11;
        r12.label = 0;
        saveFeatureParams(r12, 1, true);
    L11:
        r8 = r8 - 1;
        goto L4
    }

    private void handleUserSwitchCell(int r8, int r10) {
        int r11 = r8;
    L4:
        if (r11 < Math.max(0, r8 - r10)) goto L9;
        FeatureParams r12 = this.mFeatureHistory.get(r11);
        if (r12.predict <= 0.1d) goto L8;
        r12.label = 1;
        saveFeatureParams(r12, 1, true);
    L8:
        r11 = r11 - 1;
        goto L4
    }

    private void initAutoTrainTimer() {
        this.mAutoTrainScheduler.scheduleWithFixedDelay(new j(this, 25), 6, 6, TimeUnit.MINUTES);
    }

    private boolean isCharging() {
        IntentFilter r8 = new IntentFilter("android.intent.action.BATTERY_CHANGED");     // Catch: Throwable -> L14
        Intent r10 = this.mContext.registerReceiver(null, r8);     // Catch: Throwable -> L14
        if (r10 != null) goto L6;
        return false;
    L6:
        int r11 = r10.getIntExtra("status", -1);     // Catch: Throwable -> L14
        int r12 = r10.getIntExtra("plugged", 0);     // Catch: Throwable -> L14
        if (r11 != 2) goto L10;
    L12:
        return true;
    L10:
        if (r11 == 5) goto L12;
        if (r12 != 0) goto L12;
        return false;
    L14:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("isCharging error: "), TAG);
        return false;
    }

    private boolean isScreenOn() {
        PowerManager r8 = (PowerManager) this.mContext.getSystemService("power");     // Catch: Throwable -> L10
        if (r8 == null) goto L8;
        if (r8.isInteractive() == false) goto L8;
        return true;
    L8:
        return false;
    L10:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("isScreenOn error: "), TAG);
        return true;
    }

    private /* synthetic */ void lambda$initAutoTrainTimer$0() {
        checkAndTriggerAutoTraining();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("autoTrain timer error: "), TAG);
    }

    private /* synthetic */ void lambda$trainFromRecentDatasAsync$1(float r13) {
        CaeLog.i(TAG, "after train lr=" + r13 + ", loss=" + trainFromRecentDatas(r13));     // Catch: Throwable -> L5
    L7:
        int r14 = this.mDatabase.purgeRecordsOlderThan(90, 1);
        int r8 = this.mDatabase.purgeRecordsOlderThan(30, 0);
        this.mDatabase.setValueInt(KEY_TOTAL_IMPORTANT_COUNT, r14);
        this.mDatabase.setValueInt(KEY_TOTAL_FEATURE_COUNT, r8 + r14);
        this.mDatabase.setValueInt(KEY_LAST_TRAIN_IMPORTANT_COUNT, r14);
        this.mDatabase.commitAllValue();
        this.mTrainingInProgress.set(false);
        return;
    L5:
        th = move-exception;
        CaeLog.e(TAG, "async training error: " + th.getMessage(), th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        int r10 = this.mDatabase.purgeRecordsOlderThan(90, 1);
        int r11 = this.mDatabase.purgeRecordsOlderThan(30, 0);
        this.mDatabase.setValueInt(KEY_TOTAL_IMPORTANT_COUNT, r10);
        this.mDatabase.setValueInt(KEY_TOTAL_FEATURE_COUNT, r11 + r10);
        this.mDatabase.setValueInt(KEY_LAST_TRAIN_IMPORTANT_COUNT, r10);
        this.mDatabase.commitAllValue();
        this.mTrainingInProgress.set(false);
        throw th;
    }

    private void printFeatureLog(FeatureData r18, FeatureParams r19, float r20) {
        CaeLog.i(TAG, String.format("wifiqoe score:%d rtt:%d send_pkts:%d recv_pkts:%d recv_ooo_per:%d unacked:%d retran_per:%d send_speed_bps:%d recv_speed_bps:%d", new Object[]{Integer.valueOf(r19.params[10]), Integer.valueOf(r18.getWifiL4Rtt()), Integer.valueOf(r18.getWifiL4SendPkts()), Integer.valueOf(r18.getWifiL4RecvPkts()), Integer.valueOf(r18.getWifiL4RecvOooRate()), Integer.valueOf(r18.getWifiL4UnackPkts()), Integer.valueOf(r18.getWifiL4RetryRate()), Integer.valueOf(r18.getWifiL4SendSpeed()), Integer.valueOf(r18.getWifiL4RecvSpeed())}));
        CaeLog.i(TAG, String.format("model featrue: cell:%d|%d  app:%d|%d|%d|%d loc:%d band:%2d rssi:%4d l2_tp:%7d qoe:%3d predict:%.8f l24Weight:%.2f", new Object[]{Integer.valueOf(r19.params[0]), Integer.valueOf(r19.params[1]), Integer.valueOf(r19.params[2]), Integer.valueOf(r19.params[3]), Integer.valueOf(r19.params[4]), Integer.valueOf(r19.params[5]), Integer.valueOf(r19.params[6]), Integer.valueOf(r19.params[8]), Integer.valueOf(r19.params[9]), Integer.valueOf(r19.params[7]), Integer.valueOf(r19.params[10]), Float.valueOf(r19.predict), Float.valueOf(r20)}));
    }

    private void saveFeatureParams(FeatureParams r25, int r26, boolean r27) {
        if (this.mDatabase == null) goto L35;
        if (r25 == null) goto L35;
        if (r25.saved != 1) goto L11;
        CaeLog.d(TAG, "saveFeatureParams: params already saved");
        return;
    L11:
        if (r26 != 0) goto L24;
        if (r27 == true) goto L24;
        Object r8 = this.mHistoryLock;
        monitor-enter(r8);
        int r10 = this.mFeatureCount + 1;     // Catch: Throwable -> L21
        this.mFeatureCount = r10;     // Catch: Throwable -> L21
        if ((r10 % 5) == 3) goto L19;
        monitor-exit(r8);     // Catch: Throwable -> L21
        return;
    L19:
        monitor-exit(r8);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L24:
        r25.important = r26;
        r25.saved = 1;
        this.mDatabase.saveModelParams(r25.timestamp, r25.params, r25.label, r26);
        CaeLog.i(TAG, "saveFeatureParams: " + r25.toString());
        NetworkSwitchDatabase r11 = this.mDatabase;
        r11.setValueInt(KEY_TOTAL_FEATURE_COUNT, r11.getValueInt(KEY_TOTAL_FEATURE_COUNT, 0) + 1);
        NetworkSwitchDatabase r12 = this.mDatabase;
        int r13 = r12.getValueInt(KEY_TOTAL_IMPORTANT_COUNT, 0);
        if (r26 != 1) goto L27;
        int r14 = 1;
    L28:
        r12.setValueInt(KEY_TOTAL_IMPORTANT_COUNT, r13 + r14);
        if (r26 != 1) goto L33;
        int[] r15 = r25.params;
        char r16 = 7;
        int r17 = r15[7];
        char r18 = '\t';
        int r19 = r15[9];
        int r20 = r15[10];
        int r110 = 0;
    L31:
        if (r110 >= 3) goto L33;
        int[] r111 = r25.params;
        int[] r112 = Arrays.copyOf(r111, r111.length);
        r112[r16] = (int) Math.round(((Math.random() * 0.2d) + 0.9d) * ((double) r17));
        r112[r18] = (int) Math.round(Math.max(-100.0d, ((Math.random() * 0.1d) + 0.95d) * ((double) r19)));
        r112[10] = (int) Math.round(((Math.random() * 0.2d) + 0.9d) * ((double) r20));
        FeatureParams r113 = new FeatureParams(r25.timestamp, r25.index, r112, r25.label, r25.important);
        r113.saved = 1;
        r113.predict = r25.predict;
        CaeLog.i(TAG, "saveFeatureParams Enhancement: " + r113.toString());
        this.mDatabase.saveModelParams(r113.timestamp, r113.params, r113.label, r113.important);
        NetworkSwitchDatabase r21 = this.mDatabase;
        r21.setValueInt(KEY_TOTAL_FEATURE_COUNT, r21.getValueInt(KEY_TOTAL_FEATURE_COUNT, 0) + 1);
        NetworkSwitchDatabase r22 = this.mDatabase;
        r22.setValueInt(KEY_TOTAL_IMPORTANT_COUNT, r22.getValueInt(KEY_TOTAL_IMPORTANT_COUNT, 0) + 1);
        r110 = r110 + 1;
        r17 = r17;
        r16 = 7;
        r18 = '\t';
    L33:
        this.mDatabase.commitAllValue();
        return;
    L27:
        r14 = 0;
    L35:
        CaeLog.w(TAG, "saveFeatureParams: database or params is null");
    }

    private FeatureParams toFeatureParams(FeatureData r10) {
        int[] r8 = new int[11];
        long r11 = r10.getCellUsedTraffic();
        long r12 = r10.getCellRemainingTraffic();
        long r13 = r11 + r12;
        if (r13 > 0) goto L5;
        r8[0] = 10000;
        r8[1] = 500;
    L6:
        r8[2] = r10.getAppCategory();
        int r14 = r10.getD7CellAppUsed();
        int r15 = r10.getD7CellTotalUsed();
        int r16 = r10.getD7TrafficAppUsed();
        r8[3] = Math.max(0, r14);
        if (r15 > 0) goto L9;
        int r17 = 0;
    L10:
        r8[4] = r17;
        if (r16 > 0) goto L13;
        int r18 = 0;
    L14:
        r8[5] = r18;
        r8[6] = r10.getCurLocation();
        r8[7] = Math.max(0, r10.getWifiL2RxTput());
        r8[8] = r10.getWifiBand();
        r8[9] = r10.getWifiRssi();
        r8[10] = WifiQoeScore.getWifiQoeScore(r10);
        return new FeatureParams(r10.getTimeStamp(), r10.getIndex(), r8, 0, 0);
    L13:
        r18 = (int) ((r14 / r16) * 1000.0f);
        goto L14
    L9:
        r17 = (int) ((r14 / r15) * 1000.0f);
        goto L10
    L5:
        r8[0] = (int) r12;
        r8[1] = (int) Math.round((r12 * 1000.0d) / r13);
        goto L6
    }

    private float trainFromRecentDatas(float r11) {
        int[][] r8 = {new int[]{7, 3}, new int[]{30, 2}, new int[]{90, 1}};
        ArrayList r10 = new ArrayList();
        int r12 = 0;
    L4:
        if (r12 >= 3) goto L15;
        int[] r13 = r8[r12];
        List<FeatureParams> r14 = getTrainFeatureList(r13[0], r13[1], 4, DEFAULT_MAX_TRAIN_SAMPLES);
        if (r14 == null) goto L13;
        if (r14.isEmpty() == true) goto L13;
        r10.addAll(r14);
        if (r10.size() >= DEFAULT_MAX_TRAIN_SAMPLES) goto L15;
    L13:
        r12 = r12 + 1;
    L15:
        if (r10.isEmpty() == false) goto L18;
        CaeLog.w(TAG, "No sufficient recent data for training");
        return 0.0f;
    L18:
        Collections.shuffle(r10);
        int r15 = r10.size();
        List<FeatureParams> r16 = r10;
        if (r15 <= DEFAULT_MAX_TRAIN_SAMPLES) goto L22;
        r16 = r10.subList(0, DEFAULT_MAX_TRAIN_SAMPLES);
    L22:
        return doTrainAllDatas(r16, r11);
    }

    private void trainFromRecentDatasAsync(final float r8) {
        if (this.mTrainingInProgress.getAndSet(true) == false) goto L6;
        CaeLog.w(TAG, "training already in progress, skip new request");
        return;
    L6:
        CaeLog.i(TAG, "before train lr=" + r8);
        this.mTrainExecutor.submit(new b(this, r8));
    }

    public boolean isAvailable() {
        return this.mIsAvailable;
    }

    public void notifyResult(long r8, int r10) {
        Object r11 = this.mHistoryLock;
        monitor-enter(r11);
        int r12 = this.mFeatureHistory.size() - 1;     // Catch: Throwable -> L30
    L5:
        if (r12 < 0) goto L12;
        if (this.mFeatureHistory.get(r12).index == r8) goto L13;
        if (this.mFeatureHistory.get(r12).index == (r8 - 1)) goto L13;
        r12 = r12 - 1;     // Catch: Throwable -> L30
    L13:
        if (r12 >= 0) goto L18;
        CaeLog.w(TAG, "notifyResult: featureIndexPos not found: " + r12);     // Catch: Throwable -> L30
        monitor-exit(r11);     // Catch: Throwable -> L30
        return;
    L18:
        if (r10 == 0) goto L27;
        if (r10 != 1) goto L21;
        CaeLog.i(TAG, "notifyResult: featureIndex = " + r8 + ", result = " + r10 + " RESULT_TYPE_SWITCH_CELL_INTERVENTION");     // Catch: Throwable -> L30
        handleSwitchCellIntervention(r12, 6);     // Catch: Throwable -> L30
    L28:
        monitor-exit(r11);     // Catch: Throwable -> L30
        return;
    L21:
        if (r10 == 2) goto L25;
        CaeLog.e(TAG, "notifyResult: unknown result type: " + r10);     // Catch: Throwable -> L30
        monitor-exit(r11);     // Catch: Throwable -> L30
        return;
    L25:
        CaeLog.i(TAG, "notifyResult: featureIndex = " + r8 + ", result = " + r10 + " RESULT_TYPE_SWITCH_CELL_NO_INTERVENTION");     // Catch: Throwable -> L30
        handleSwitchCellNoIntervention(r12, 8);     // Catch: Throwable -> L30
        goto L28
    L27:
        CaeLog.i(TAG, "notifyResult: featureIndex = " + r8 + ", result = " + r10 + " RESULT_TYPE_USER_SWITCH_CELL");     // Catch: Throwable -> L30
        handleUserSwitchCell(r12, 6);     // Catch: Throwable -> L30
        goto L28
    L12:
        r12 = -1;
    L30:
        th = move-exception;
        throw th;
    }

    public float[] predictSwitchCell(FeatureData r8) {
        if (this.mIsAvailable == true) goto L6;
        CaeLog.w(TAG, "predictSwitchCell: policy not available, return default.");
        return new float[]{0.0f, 0.5f};
    L6:
        if (r8 == null) goto L8;
        FeatureParams r10 = toFeatureParams(r8);
        Object r11 = this.mHistoryLock;
        monitor-enter(r11);
        FeatureParams r12 = featureParamSmooth(r10);     // Catch: Throwable -> L18
        if (this.mFeatureHistory.size() < 60) goto L14;
        handleNotImportantFeature(this.mFeatureHistory.get(0));     // Catch: Throwable -> L18
        this.mFeatureHistory.remove(0);     // Catch: Throwable -> L18
    L14:
        r12.predict = doPredictSwitchCell(r12);     // Catch: Throwable -> L18
        float r13 = getWeightsOfL24(r12);     // Catch: Throwable -> L18
        this.mFeatureHistory.add(r12);     // Catch: Throwable -> L18
        monitor-exit(r11);     // Catch: Throwable -> L18
        printFeatureLog(r8, r12, r13);
        return new float[]{r12.predict, r13};
    L18:
        th = move-exception;
        throw th;
    L8:
        return new float[]{0.0f, 0.0f};
    }
}
