package com.obric.cae.smartNetwork.throughtput;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.cae.caed.DeltaInfoParcel;
import com.cae.caed.LLStatsParcel;
import com.cae.caed.NefiInfoParcel;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.CloudConfigParseAndSave;
import com.obric.cae.utils.CaeUtil;
import defpackage.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SingleThroughputCalculation {
    private static final String CLOUD_CONFIG_THROUGHPUT_FORMLA_CCA = "cca";
    private static final String CLOUD_CONFIG_THROUGHPUT_FORMLA_COEFFICIENT = "coefficient";
    private static final String CLOUD_CONFIG_THROUGHPUT_FORMLA_PER = "per";
    private static final double DEFAULT_EXPONENTIAL_MOVING_AVERAGE_ALPHA = 0.6d;
    private static final String DEFAULT_JSON_CONFIG = "{    \"per\": [        {            \"segmentName\": \"Segment 1\",            \"minValue\": null,            \"maxValue\": 14,            \"a\": -0.00658758,            \"b\": 0.85821974        },        {            \"segmentName\": \"Segment 2\",            \"minValue\": 15,            \"maxValue\": 20,            \"a\": -0.03191118,            \"b\": 1.23951614        },        {            \"segmentName\": \"Segment 3\",            \"minValue\": 21,            \"maxValue\": 24,            \"a\": -0.03830434,            \"b\": 1.36867406        },        {            \"segmentName\": \"Segment 4\",            \"minValue\": 25,            \"maxValue\": 28,            \"a\": -0.0642404,            \"b\": 2.0439208        },        {            \"segmentName\": \"Segment 5\",            \"minValue\": 29,            \"maxValue\": 40,            \"a\": -0.01825775,            \"b\": 0.7769288        },        {            \"segmentName\": \"Segment 6\",            \"minValue\": 41,            \"maxValue\": null,            \"a\": -0.01156888,            \"b\": 0.52864458        }    ],    \"cca\": [        {\"coefficient\": -1, \"power\": 2, \"constant\": 0},        {\"coefficient\": 2, \"power\": 1, \"constant\": 0}    ],    \"coefficient\": 0.7}";
    private static final float DEFAULT_THROUGHPUT_JITTER_WEIGHT = 0.3f;
    private static final int MAX_PER_RATE_THRESHOLD = 100;
    private static final int MIN_CCA_BUSY_RATE_THRESHOLD = 0;
    private static final int MIN_TOTAL_RX_MPDU_THRESHOLD = 0;
    private static final String TAG = "SingleThroughputCalculation";
    private static final float TPUT_PRED_ABNORMAL_VALUE = -1000000.0f;
    private ApDataRecords mApDataRecords;
    private List<Polynomial> mCcaPolynomialList;
    private Context mContext;
    private String mCurrentConnectedApMacAddress;
    private ThroughputPredictor.Band mCurrentConnectedBand;
    private int mCurrentDataRate;
    private ExponentialMovingAverage mExponentialMovingAverage;
    private int mFinalRxTput;
    private int mFinalTxTput;
    private double mFormulaPredRxTput;
    private String mIfName;
    private ThroughputJitterCalculator mJitterCalculator;
    private double mLastCcaBusyRate;
    private double mLastPerRate;
    private float mLastRxLinkSpeed;
    private long mLastUpdateTime;
    private float mModelPredRxTput;
    private float mModelPredTxTput;
    private List<SegmentFormula> mPerSegmentFormulaList;
    private SingleThroughputCallback mSingleThroughputCallback;
    private double mThroughputCoefficient;
    private ThroughputFactor mThroughputFactor;
    private float mThroughputJitterWeight;
    private float mTxDelayAvg;
    private float mTxDelayP10;
    private float mTxDelayP90;
    private long mTxDelayPkts;
    private WifiManager mWifiManager;

    public static class Polynomial {
        double coefficient;
        double constant;
        int power;

        public Polynomial(double r8, int r10, double r11) {
            this.coefficient = r8;
            this.power = r10;
            this.constant = r11;
        }
    }

    public static class SegmentFormula {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f5815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f5816b;
        public Double maxValue;
        public Double minValue;
        public String segmentName;

        public SegmentFormula(String r8, Double r10, Double r11, double r12, double r13) {
            this.segmentName = r8;
            this.minValue = r10;
            this.maxValue = r11;
            this.f5815a = r12;
            this.f5816b = r13;
        }

        public boolean isInSegment(double r8) {
            Double r10 = this.minValue;
            if (r10 != null) goto L5;
        L8:
            boolean r11 = true;
        L9:
            Double r12 = this.maxValue;
            if (r12 != null) goto L12;
        L15:
            boolean r13 = true;
        L16:
            if (r11 == false) goto L20;
            if (r13 == true) goto L19;
            return false;
        L19:
            return true;
        L20:
            return false;
        L12:
            if (r8 <= r12.doubleValue()) goto L15;
            r13 = false;
            goto L16
        L5:
            if (r8 >= r10.doubleValue()) goto L8;
            r11 = false;
            goto L9
        }
    }

    public interface SingleThroughputCallback {
        void onThroughputChanged(String r8, int r10, int r11, int r12, int r13);

        default void onTxDelayStatsUpdated(String r8, int r10, long r11, float r12, float r13, float r14) {
        }
    }

    public SingleThroughputCalculation(Context r8, String r10, SingleThroughputCallback r11) {
        this.mContext = r8;
        this.mIfName = r10;
        this.mSingleThroughputCallback = r11;
        this.mExponentialMovingAverage = new ExponentialMovingAverage(DEFAULT_EXPONENTIAL_MOVING_AVERAGE_ALPHA);
        this.mApDataRecords = new ApDataRecords();
        this.mJitterCalculator = new ThroughputJitterCalculator(r8);
        WifiManager r12 = (WifiManager) this.mContext.getSystemService("wifi");
        this.mWifiManager = r12;
        if (r12 == null) goto L7;
        WifiInfo r13 = r12.getConnectionInfo();
        if (r13 == null) goto L7;
        this.mCurrentConnectedApMacAddress = r13.getBSSID();
        CaeLog.d(TAG, "Connected AP MAC Address: " + CaeUtil.maskMacOrBssid(this.mCurrentConnectedApMacAddress));
    L7:
        String r14 = Settings.Global.getString(this.mContext.getContentResolver(), "throughput_prediction_formula");
        if (TextUtils.isEmpty(r14) == false) goto L10;
        r14 = DEFAULT_JSON_CONFIG;
    L10:
        updateThroughputFormulaConfigs(r14);
        String r15 = Settings.Global.getString(this.mContext.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_THROUGHPUT_SAVE_KEY_2);
        if (TextUtils.isEmpty(r15) == false) goto L13;
        ThroughputConfigLoader.applyDefaultConfig();
    L14:
        updateThroughputJitterWeightProportion(Settings.Global.getFloat(this.mContext.getContentResolver(), "throughput_prediction_formula", DEFAULT_THROUGHPUT_JITTER_WEIGHT));
        return;
    L13:
        updateThroughputFormulaConfigs2(r15);
        goto L14
    }

    private double calculateCcaCoefficient(double r8) {
        Iterator<Polynomial> r10 = this.mCcaPolynomialList.iterator();
        double r11 = 0.0d;
    L4:
        if (r10.hasNext() == false) goto L6;
        Polynomial r12 = r10.next();
        r11 = r11 + ((Math.pow(r8, r12.power) * r12.coefficient) + r12.constant);
        goto L4
    L6:
        return r11;
    }

    private double calculateEvaluateThroughput(double r8, double r10, double r12, int r14) {
        return ThroughputPredictor.predict(this.mCurrentConnectedBand, r8, r10, r12);
    }

    private void calculateThroughput() {
        ThroughputFactor r8 = this.mThroughputFactor;
        if (r8 != null) goto L8;
        SingleThroughputCallback r10 = this.mSingleThroughputCallback;
        if (r10 == null) goto L90;
        r10.onThroughputChanged(this.mIfName, 0, 0, 0, 0);
        return;
    L90:
        return;
    L8:
        float r11 = r8.getRxLinkSpeed();
        if (r11 == 6.0f) goto L12;
        this.mLastRxLinkSpeed = r11;
    L12:
        if (this.mThroughputFactor.getTxSpeed() <= this.mThroughputFactor.getRxSpeed()) goto L14;
        int r12 = this.mThroughputFactor.getTxSpeed();
    L15:
        int r13 = r12;
        this.mCurrentDataRate = r13;
        this.mLastUpdateTime = System.currentTimeMillis();
        if (this.mThroughputFactor.getTotalRxMpdu() >= 0) goto L18;
    L22:
        Map<String, Double> r14 = this.mApDataRecords.getWeightedMetrics(this.mCurrentConnectedApMacAddress, this.mThroughputFactor.getRssi());
        if (r14 == null) goto L27;
        double r15 = r14.get(ApDataRecords.KEY_CCA_BUSY_RATE).doubleValue();
        double r16 = r14.get("per").doubleValue();
        double r17 = r14.get(ApDataRecords.KEY_RX_LINK_SPEED).doubleValue();
        String r18 = "saved rssiMap data";
    L25:
        String r19 = r18;
        double r110 = r15;
        double r111 = r17;
        double r20 = r16;
        double r21 = calculateEvaluateThroughput(r20, r111, r110, r13);
        this.mJitterCalculator.updateInputValues(r110, r20);
        boolean r22 = false;
        double r23 = r20;
        String r24 = r19;
    L33:
        this.mJitterCalculator.getJitter();
        StringBuilder r25 = new StringBuilder("ifName: ");
        r25.append(this.mIfName);
        r25.append(", actual ");
        r25.append(this.mThroughputFactor);
        r25.append(",used ");
        r25.append(r24);
        r25.append(": ");
        if (r22 == true) goto L36;
        r25.append(String.format(Locale.US, "cca=%.1f, per=%.2f, rxlinkspeed=%.1f, ", new Object[]{Double.valueOf(r110), Double.valueOf(r23), Double.valueOf(r111)}));
    L36:
        this.mExponentialMovingAverage.add(r21);
        double r26 = this.mExponentialMovingAverage.getCurrentEma();
        this.mFormulaPredRxTput = r26;
        float r27 = this.mModelPredRxTput;
        if (r27 != TPUT_PRED_ABNORMAL_VALUE) goto L41;
    L38:
        int r28 = (int) r26;
    L39:
        this.mFinalRxTput = r28;
    L54:
        float r29 = this.mModelPredTxTput;
        if (r29 != TPUT_PRED_ABNORMAL_VALUE) goto L58;
        this.mFinalTxTput = -1;
    L69:
        if (this.mFinalRxTput >= r13) goto L71;
        this.mFinalRxTput = r13;
    L71:
        int r30 = this.mFinalTxTput;
        if (r30 == (-1)) goto L76;
        if (r30 >= r13) goto L76;
        this.mFinalTxTput = r13;
    L76:
        if (this.mFinalRxTput < 0) goto L91;
        int r31 = this.mFinalTxTput;
        if (r31 >= 0) goto L80;
        if (r31 == (-1)) goto L80;
        return;
    L80:
        this.mSingleThroughputCallback.onThroughputChanged(this.mIfName, this.mThroughputFactor.getCenterFreq(), this.mFinalRxTput, this.mFinalTxTput, this.mCurrentDataRate);
        r25.append(" formula_rx=");
        r25.append((int) this.mFormulaPredRxTput);
        r25.append(", model_rx=");
        r25.append(this.mModelPredRxTput);
        r25.append(", model_tx=");
        r25.append(this.mModelPredTxTput);
        r25.append(", final_rx=");
        r25.append(this.mFinalRxTput);
        r25.append(" Kbps");
        if (this.mFinalTxTput == (-1)) goto L83;
        r25.append(", final_tx=");
        r25.append(this.mFinalTxTput);
        r25.append(" Kbps");
    L83:
        r25.append(String.format(Locale.US, ", txDelay=[pkts:%d, avg:%.1f, p10:%.1f, p90:%.1f]", new Object[]{Long.valueOf(this.mTxDelayPkts), Float.valueOf(this.mTxDelayAvg), Float.valueOf(this.mTxDelayP10), Float.valueOf(this.mTxDelayP90)}));
        SingleThroughputCallback r32 = this.mSingleThroughputCallback;
        if (r32 != null) goto L86;
    L88:
        CaeUtil.MLog(TAG, r25.toString());
        CaeLog.d("TxDelayDebug", r25.toString());
        return;
    L86:
        if (this.mTxDelayPkts <= 0) goto L88;
        r32.onTxDelayStatsUpdated(this.mIfName, this.mThroughputFactor.getCenterFreq(), this.mTxDelayPkts, this.mTxDelayAvg, this.mTxDelayP10, this.mTxDelayP90);
        goto L88
    L91:
        return;
    L58:
        if (r29 < 0.0f) goto L61;
    L59:
        int r33 = (int) r29;
    L60:
        this.mFinalTxTput = r33;
        goto L69
    L61:
        r29 = this.mModelPredRxTput;
        if (r29 <= 0.0f) goto L65;
        this.mModelPredTxTput = r29;
        goto L59
    L65:
        if (r26 <= 0.0d) goto L67;
        r33 = (int) r26;
        goto L60
    L67:
        this.mFinalTxTput = r13;
        goto L69
    L41:
        if (r27 < 0.0f) goto L46;
        float r34 = this.mModelPredTxTput;
        if (r27 >= r34) goto L45;
        this.mModelPredRxTput = r34;
    L45:
        float r35 = this.mModelPredRxTput;
    L49:
        r28 = (int) r35;
        goto L39
    L46:
        r35 = this.mModelPredTxTput;
        if (r35 <= 0.0f) goto L51;
        this.mModelPredRxTput = r35;
        goto L49
    L51:
        if (r26 > 0.0d) goto L38;
        this.mFinalRxTput = r13;
        goto L54
    L27:
        if (this.mThroughputFactor.getCcaBusyRate() >= 0.0f) goto L29;
    L31:
        r17 = this.mThroughputFactor.getRxLinkSpeed();
        r16 = this.mLastPerRate;
        r15 = this.mLastCcaBusyRate;
        r18 = "last data";
        goto L25
    L29:
        if (this.mThroughputFactor.getPerRate() > 100.0f) goto L31;
        r15 = this.mThroughputFactor.getCcaBusyRate();
        r16 = this.mThroughputFactor.getPerRate();
        r17 = this.mThroughputFactor.getRxLinkSpeed();
        r18 = "poor rxMpdu data";
        goto L25
    L18:
        if (this.mThroughputFactor.getCcaBusyRate() < 0.0f) goto L22;
        if (this.mThroughputFactor.getPerRate() > 100.0f) goto L22;
        r21 = calculateEvaluateThroughput(this.mThroughputFactor.getPerRate(), this.mThroughputFactor.getRxLinkSpeed(), this.mThroughputFactor.getCcaBusyRate(), r13);
        this.mJitterCalculator.updateInputValues(this.mThroughputFactor.getCcaBusyRate(), this.mThroughputFactor.getPerRate());
        r22 = true;
        r24 = "current caed data, ";
        r23 = 0.0d;
        r110 = 0.0d;
        r111 = 0.0d;
        goto L33
    L14:
        r12 = this.mThroughputFactor.getRxSpeed();
        goto L15
    }

    private static double linearFormula(double r8, double r10, double r11) {
        return (r10 * r8) + r11;
    }

    private static List<Polynomial> parseThroughputFormulaCca(String r13) {
        ArrayList r8 = new ArrayList();
        JSONArray r10 = new JSONArray(r13);     // Catch: Exception -> L8
        int r11 = 0;
    L5:
        if (r11 >= r10.length()) goto L10;
        JSONObject r12 = r10.getJSONObject(r11);     // Catch: Exception -> L8
        r8.add(new Polynomial(r12.optDouble(CLOUD_CONFIG_THROUGHPUT_FORMLA_COEFFICIENT, 0.0d), r12.optInt("power", 0), r12.optDouble("constant", 0.0d)));     // Catch: Exception -> L8
        r11 = r11 + 1;
    L10:
        return r8;
    L8:
        e = move-exception;
        CaeLog.e(TAG, "Error parsing CCA formula configuration", e);
        goto L10
    }

    private static List<SegmentFormula> parseThroughputFormulaPer(String r14) {
        ArrayList r8 = new ArrayList();
        JSONArray r10 = new JSONArray(r14);     // Catch: Exception -> L16
        int r15 = 0;
    L4:
        if (r15 >= r10.length()) goto L18;
        JSONObject r11 = r10.getJSONObject(r15);     // Catch: Exception -> L16
        String r12 = r11.getString("segmentName");     // Catch: Exception -> L16
        if (r11.isNull("minValue") == false) goto L9;
        Double r13 = null;
    L11:
        if (r11.isNull("maxValue") == false) goto L13;
        Double r16 = null;
    L14:
        r8.add(new SegmentFormula(r12, r13, r16, r11.getDouble("a"), r11.getDouble("b")));     // Catch: Exception -> L16
        r15 = r15 + 1;
        goto L4
    L13:
        r16 = Double.valueOf(r11.getDouble("maxValue"));     // Catch: Exception -> L16
        goto L14
    L9:
        r13 = Double.valueOf(r11.getDouble("minValue"));     // Catch: Exception -> L16
    L18:
        return r8;
    L16:
        e = move-exception;
        CaeLog.e(TAG, "Error parsing PER formula configuration", e);
        goto L18
    }

    public double calculatePerCoefficient(double r10) {
        int r8 = (int) r10;
        Iterator<SegmentFormula> r11 = this.mPerSegmentFormulaList.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        SegmentFormula r12 = r11.next();
        double r13 = r8;
        if (r12.isInSegment(r13) == false) goto L4;
        return linearFormula(r13, r12.f5815a, r12.f5816b);
    L10:
        throw new IllegalArgumentException("No matching segment found for perRate: " + r10);
    }

    public int getCurrentDataRate() {
        return this.mCurrentDataRate;
    }

    public long getLastUpdateTime() {
        return this.mLastUpdateTime;
    }

    public int getThroughput() {
        return this.mFinalRxTput;
    }

    public int getThroughputJitter() {
        return (int) this.mJitterCalculator.getJitter();
    }

    public float getThroughputJitterWeight() {
        return this.mThroughputJitterWeight;
    }

    public void updateThroughputFormulaConfigs(String r10) {
        String r8 = null;
        JSONObject r11 = new JSONObject(r10);     // Catch: JSONException -> L8
        String r12 = r11.getString(CLOUD_CONFIG_THROUGHPUT_FORMLA_CCA);     // Catch: JSONException -> L8
        r8 = r11.getString("per");     // Catch: JSONException -> L6
        this.mThroughputCoefficient = r11.getDouble(CLOUD_CONFIG_THROUGHPUT_FORMLA_COEFFICIENT);     // Catch: JSONException -> L6
    L11:
        b.o("throughput_prediction_formula: ", r10, TAG);
        List<Polynomial> r13 = parseThroughputFormulaCca(r12);
        this.mCcaPolynomialList = r13;
        if (r13 != null) goto L14;
    L34:
        this.mCcaPolynomialList = parseThroughputFormulaCca(new JSONObject(DEFAULT_JSON_CONFIG).getString(CLOUD_CONFIG_THROUGHPUT_FORMLA_CCA));     // Catch: JSONException -> L17
    L19:
        List<SegmentFormula> r14 = parseThroughputFormulaPer(r8);
        this.mPerSegmentFormulaList = r14;
        if (r14 != null) goto L22;
    L30:
        this.mPerSegmentFormulaList = parseThroughputFormulaPer(new JSONObject(DEFAULT_JSON_CONFIG).getString("per"));     // Catch: JSONException -> L25
        return;
    L25:
        e = move-exception;
        CaeLog.e(TAG, "Error parsing default PER formula configuration", e);
        return;
    L22:
        if (r14.isEmpty() == true) goto L30;
        return;
    L17:
        e = move-exception;
        CaeLog.e(TAG, "Error parsing default CCA formula configuration", e);
        goto L19
    L14:
        if (r13.isEmpty() == false) goto L19;
    L6:
        e = move-exception;
        String r15 = r8;
        r8 = r12;
        JSONException r16 = e;
    L10:
        r16.printStackTrace();
        r12 = r8;
        r8 = r15;
    L8:
        e = move-exception;
        r16 = e;
        r15 = null;
        goto L10
    }

    public void updateThroughputFormulaConfigs2(String r8) {
        ThroughputConfigLoader.applyConfigFromJson(r8);
    }

    public void updateThroughputJitterSegmentConfigs(String r8) {
        this.mJitterCalculator.updateFormula(r8);
    }

    public void updateThroughputJitterWeightProportion(float r8) {
        this.mThroughputJitterWeight = r8;
    }

    public void updateWithInfoParcel(NefiInfoParcel r8) {
        this.mModelPredRxTput = r8.f4161q;
        this.mModelPredTxTput = r8.f4162r;
        this.mTxDelayPkts = r8.f4163s;
        this.mTxDelayAvg = r8.f4164t;
        this.mTxDelayP10 = r8.f4165u;
        this.mTxDelayP90 = r8.f4166v;
        DeltaInfoParcel r10 = (DeltaInfoParcel) r8.f4160p.get(0);
        LLStatsParcel r11 = (LLStatsParcel) r8.f4158n.get(0);
        Iterator r12 = r8.f4160p.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        DeltaInfoParcel r13 = (DeltaInfoParcel) r12.next();
        if ((r13.f4122z + r13.f4121y) <= (r10.f4122z + r10.f4121y)) goto L4;
        r11 = (LLStatsParcel) r8.f4158n.get(r8.f4160p.indexOf(r13));
        r10 = r13;
        goto L4
    L8:
        ThroughputFactor r14 = this.mThroughputFactor;
        if (r14 != null) goto L11;
        this.mThroughputFactor = new ThroughputFactor(r10, r8.f4156b, r11, r8.f4167w);
    L13:
        if (CaeUtil.getCurrentWifiBand(this.mThroughputFactor.getCenterFreq()) != 1) goto L15;
        ThroughputPredictor.Band r15 = ThroughputPredictor.Band.BAND_2G;
    L16:
        this.mCurrentConnectedBand = r15;
        if (this.mThroughputFactor.getCcaBusyRate() > 0.0f) goto L19;
    L21:
        calculateThroughput();
        this.mLastCcaBusyRate = this.mThroughputFactor.getCcaBusyRate();
        this.mLastPerRate = this.mThroughputFactor.getPerRate();
        return;
    L19:
        if (this.mThroughputFactor.getPerRate() > 45.0f) goto L21;
        this.mApDataRecords.updateAPData(this.mCurrentConnectedApMacAddress, this.mThroughputFactor.getRssi(), this.mThroughputFactor.getTotalRxMpdu(), (int) this.mThroughputFactor.getRxLinkSpeed(), (int) this.mThroughputFactor.getPerRate(), (int) this.mThroughputFactor.getCcaBusyRate());
        goto L21
    L15:
        r15 = ThroughputPredictor.Band.BAND_5G;
        goto L16
    L11:
        r14.setFactor(r10, r8.f4156b, r11, r8.f4167w);
        goto L13
    }
}
