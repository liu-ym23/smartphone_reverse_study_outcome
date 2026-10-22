package com.obric.cae.smartNetwork.throughtput;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.obric.cae.log.CaeLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ThroughputJitterCalculator {
    private static final String DEFAULT_JSON_CONFIG = "{    \"formulas\": [    {        \"segmentName\": \"Segment 1\",        \"minValue\": null,        \"maxValue\": 23,        \"a\": 0.000,        \"b\": -0.001    },    {        \"segmentName\": \"Segment 2\",        \"minValue\": 24,        \"maxValue\": 52,        \"a\": 0.002,        \"b\": -0.048    },    {        \"segmentName\": \"Segment 3\",        \"minValue\": 55,        \"maxValue\": null,        \"a\": 0.011,        \"b\": -0.518    }    ],    \"formulas_cca_per\": [        {\"coefficient\": 1, \"cca_power\": 1, \"per_power\": 0, \"constant\": 0},        {\"coefficient\": 2, \"cca_power\": 0, \"per_power\": 1, \"constant\": 0}    ]}";
    private static final String SETTINGS_GLOBAL_THROUGHPUT_JITTER_SAVE_KEY = "throughput_jitter_prediction_formula";
    private static final String TAG = "ThroughputJitterCalculator";
    private double mCca;
    private Context mContext;
    private List<FormulasCcaPerConfig> mFormulaCcaPerList;
    private List<FormulasSegmentConfig> mFormulaSegmentList;
    private double mJitter;
    private double mPer;

    public static class FormulasCcaPerConfig {
        private int mCcaPower;
        private double mCoefficient;
        private double mConstant;
        private int mPerPower;

        public FormulasCcaPerConfig(double r8, int r10, int r11, double r12) {
            this.mCoefficient = r8;
            this.mConstant = r12;
            this.mCcaPower = r10;
            this.mPerPower = r11;
        }

        public double calculate(double r8, double r10) {
            return (Math.pow(r10, this.mPerPower) * (Math.pow(r8, this.mCcaPower) * this.mCoefficient)) + this.mConstant;
        }
    }

    public static class FormulasSegmentConfig {
        private double mCoefficient;
        private double mConstant;
        private Double mMaxValue;
        private Double mMinValue;
        private String mSegmentName;

        public FormulasSegmentConfig(String r8, Double r10, Double r11, double r12, double r13) {
            this.mSegmentName = r8;
            this.mMinValue = r10;
            this.mMaxValue = r11;
            this.mCoefficient = r12;
            this.mConstant = r13;
        }

        public double calculate(double r8) {
            return ((this.mCoefficient * r8) + this.mConstant) * 100.0d;
        }

        public boolean isInRange(double r8) {
            Double r10 = this.mMinValue;
            if (r10 != null) goto L5;
        L8:
            boolean r11 = true;
        L9:
            Double r12 = this.mMaxValue;
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

    public ThroughputJitterCalculator(Context r8) {
        this.mContext = r8;
        this.mCca = 0.0d;
        this.mPer = 0.0d;
        this.mJitter = 0.0d;
        String r10 = Settings.Global.getString(r8.getContentResolver(), SETTINGS_GLOBAL_THROUGHPUT_JITTER_SAVE_KEY);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        r10 = DEFAULT_JSON_CONFIG;
    L5:
        this.mFormulaSegmentList = parseFormulasConfig(r10);
        this.mFormulaCcaPerList = parseFormulasCcaPerConfig(r10);
    }

    private void calculateJitter() {
        Iterator<FormulasCcaPerConfig> r8 = this.mFormulaCcaPerList.iterator();
        double r10 = 0.0d;
        double r11 = 0.0d;
    L4:
        if (r8.hasNext() == false) goto L6;
        r11 = r11 + r8.next().calculate(this.mCca, this.mPer);
        goto L4
    L6:
        Iterator<FormulasSegmentConfig> r12 = this.mFormulaSegmentList.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        FormulasSegmentConfig r13 = r12.next();
        if (r13.isInRange(r11) == false) goto L8;
        r10 = r13.calculate(r11);
    L12:
        this.mJitter = r10;
    }

    private List<FormulasCcaPerConfig> parseFormulasCcaPerConfig(String r11) {
        ArrayList r10 = new ArrayList();
        JSONArray r12 = new JSONObject(r11).getJSONArray("formulas_cca_per");     // Catch: JSONException -> L8
        int r8 = 0;
    L5:
        if (r8 >= r12.length()) goto L10;
        JSONObject r13 = r12.getJSONObject(r8);     // Catch: JSONException -> L8
        r10.add(new FormulasCcaPerConfig(r13.getDouble("coefficient"), r13.getInt("cca_power"), r13.getInt("per_power"), r13.getDouble("constant")));     // Catch: JSONException -> L8
        r8 = r8 + 1;
    L10:
        return r10;
    L8:
        e = move-exception;
        CaeLog.e(TAG, "Error parsing JSON configuration", e);
        goto L10
    }

    private List<FormulasSegmentConfig> parseFormulasConfig(String r14) {
        ArrayList r8 = new ArrayList();
        JSONArray r15 = new JSONObject(r14).getJSONArray("formulas");     // Catch: JSONException -> L16
        int r10 = 0;
    L4:
        if (r10 >= r15.length()) goto L18;
        JSONObject r11 = r15.getJSONObject(r10);     // Catch: JSONException -> L16
        String r12 = r11.getString("segmentName");     // Catch: JSONException -> L16
        if (r11.isNull("minValue") == false) goto L9;
        Double r13 = null;
    L11:
        if (r11.isNull("maxValue") == false) goto L13;
        Double r16 = null;
    L14:
        r8.add(new FormulasSegmentConfig(r12, r13, r16, r11.getDouble("a"), r11.getDouble("b")));     // Catch: JSONException -> L16
        r10 = r10 + 1;
        goto L4
    L13:
        r16 = Double.valueOf(r11.getDouble("maxValue"));     // Catch: JSONException -> L16
        goto L14
    L9:
        r13 = Double.valueOf(r11.getDouble("minValue"));     // Catch: JSONException -> L16
    L18:
        return r8;
    L16:
        e = move-exception;
        CaeLog.e(TAG, "Error parsing JSON configuration", e);
        goto L18
    }

    public synchronized double getJitter() {
        monitor-enter(this);
        double r8 = this.mJitter;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void updateFormula(String r8) {
        monitor-enter(this);
        Settings.Global.putString(this.mContext.getContentResolver(), SETTINGS_GLOBAL_THROUGHPUT_JITTER_SAVE_KEY, r8);     // Catch: Throwable -> L6
        this.mFormulaSegmentList = parseFormulasConfig(r8);     // Catch: Throwable -> L6
        this.mFormulaCcaPerList = parseFormulasCcaPerConfig(r8);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void updateInputValues(double r8, double r10) {
        monitor-enter(this);
        this.mCca = r8;     // Catch: Throwable -> L6
        this.mPer = r10;     // Catch: Throwable -> L6
        calculateJitter();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
