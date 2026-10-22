package com.obric.cae.location.zpp.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.datepicker.q;
import com.obric.cae.R;
import com.obric.cae.location.zpp.StarZppManager;
import com.obric.cae.log.CaeLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class StarZppUiActivity extends Activity {
    private static final String TAG = "StarLocation-ZppUi";
    private static final int ZOOM_STEP = 50;
    private final List<Float> mConfidenceData;
    private final List<Float> mDistanceData;
    private final List<float[]> mFeaturesData;
    private TextView mFileInfoTextView;
    private int mZoomLevel;
    private ZppChart mZppChart;

    public StarZppUiActivity() {
        this.mConfidenceData = new ArrayList();
        this.mDistanceData = new ArrayList();
        this.mFeaturesData = new ArrayList();
        this.mZoomLevel = 1;
    }

    public static /* synthetic */ void a(StarZppUiActivity r8, View r10) {
        r8.lambda$onCreate$0(r10);
    }

    public static /* synthetic */ void b(StarZppUiActivity r8, View r10) {
        r8.lambda$onCreate$1(r10);
    }

    public static /* synthetic */ void c(StarZppUiActivity r8, View r10) {
        r8.lambda$onCreate$2(r10);
    }

    private /* synthetic */ void lambda$onCreate$0(View r8) {
        this.mZoomLevel = 1;
        parseZppLog();
        updateCharts();
    }

    private /* synthetic */ void lambda$onCreate$1(View r8) {
        this.mZoomLevel++;
        updateCharts();
    }

    private /* synthetic */ void lambda$onCreate$2(View r8) {
        parseZppLog();
        if (this.mFeaturesData.isEmpty() == true) goto L6;
        Intent r10 = new Intent(this, ZppFeaturesActivity.class);
        r10.putStringArrayListExtra(ZppFeaturesActivity.EXTRA_FEATURE_NAMES, new ArrayList(StarZppManager.FEATURE_COLUMNS));
        List<float[]> r11 = this.mFeaturesData;
        r10.putExtra(ZppFeaturesActivity.EXTRA_FEATURE_VALUES, r11.get(r11.size() - 1));
        startActivity(r10);
        return;
    }

    @SuppressLint({"SetTextI18n"})
    private void parseZppLog() {
        this.mConfidenceData.clear();
        this.mDistanceData.clear();
        this.mFeaturesData.clear();
        File r8 = new File(new File(getFilesDir(), "star"), "star_zpp.txt");
        if (r8.exists() == false) goto L57;
        this.mFileInfoTextView.setText("Zpp Analysis Data");
        BufferedReader r10 = new BufferedReader(new FileReader(r8));     // Catch: IOException -> L55
        Pattern r11 = Pattern.compile("confidence: ([-+]?\\d*\\.?\\d+)");     // Catch: Throwable -> L49
        Pattern r12 = Pattern.compile("distance: ([-+]?\\d*\\.?\\d+)");     // Catch: Throwable -> L49
        Pattern r13 = Pattern.compile("features: \\[(.*?)]");     // Catch: Throwable -> L49
    L7:
        String r14 = r10.readLine();     // Catch: Throwable -> L49
        if (r14 == null) goto L47;
        Matcher r15 = r11.matcher(r14);     // Catch: Throwable -> L49
        Matcher r16 = r12.matcher(r14);     // Catch: Throwable -> L49
        Matcher r17 = r13.matcher(r14);     // Catch: Throwable -> L49
        boolean r18 = r15.find();     // Catch: Throwable -> L49
        boolean r19 = r16.find();     // Catch: Throwable -> L49
        if (r17.find() == false) goto L12;
        String r20 = r17.group(1);     // Catch: Throwable -> L49
    L13:
        if (r18 == true) goto L18;
        if (r20 == null) goto L7;
        if (r20.isEmpty() == true) goto L7;
    L18:
        if (r18 == false) goto L26;
        String r21 = r15.group(1);     // Catch: Throwable -> L49
        if (r21 != null) goto L22;
    L24:
        List<Float> r22 = this.mConfidenceData;     // Catch: Throwable -> L49
        Float r23 = Float.valueOf(0.0f);     // Catch: Throwable -> L49
    L25:
        r22.add(r23);     // Catch: Throwable -> L49
    L27:
        if (r19 == false) goto L35;
        String r24 = r16.group(1);     // Catch: Throwable -> L49
        if (r24 != null) goto L31;
    L33:
        List<Float> r25 = this.mDistanceData;     // Catch: Throwable -> L49
        Float r26 = Float.valueOf(0.0f);     // Catch: Throwable -> L49
    L34:
        r25.add(r26);     // Catch: Throwable -> L49
    L36:
        int r27 = 0;
        if (r20 == null) goto L45;
        if (r20.isEmpty() == true) goto L45;
        String[] r28 = r20.split(", ");     // Catch: Throwable -> L49
        float[] r29 = new float[r28.length];     // Catch: Throwable -> L49
    L42:
        if (r27 >= r28.length) goto L44;
        r29[r27] = Float.parseFloat(r28[r27]);     // Catch: Throwable -> L49
        r27 = r27 + 1;     // Catch: Throwable -> L49
        goto L42
    L44:
        this.mFeaturesData.add(r29);     // Catch: Throwable -> L49
    L45:
        this.mFeaturesData.add(new float[0]);     // Catch: Throwable -> L49
        goto L7
    L31:
        if (r24.isEmpty() == true) goto L33;
        this.mDistanceData.add(Float.valueOf(Float.parseFloat(r24)));     // Catch: Throwable -> L49
        goto L36
    L35:
        r25 = this.mDistanceData;     // Catch: Throwable -> L49
        r26 = Float.valueOf(0.0f);     // Catch: Throwable -> L49
        goto L34
    L22:
        if (r21.isEmpty() == true) goto L24;
        this.mConfidenceData.add(Float.valueOf(Float.parseFloat(r21)));     // Catch: Throwable -> L49
        goto L27
    L26:
        r22 = this.mConfidenceData;     // Catch: Throwable -> L49
        r23 = Float.valueOf(0.0f);     // Catch: Throwable -> L49
        goto L25
    L12:
        r20 = null;
        goto L13
    L47:
        r10.close();     // Catch: IOException -> L55
        return;
    L49:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L52
    L54:
        throw th;     // Catch: IOException -> L55
    L52:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L55
    L55:
        e = move-exception;
        CaeLog.e(TAG, "Error reading log file", e);
        return;
    L57:
        this.mFileInfoTextView.setText("Log file not found.");
    }

    private void updateCharts() {
        int r8 = 0;
        if (this.mConfidenceData.isEmpty() == false) goto L5;
    L32:
        this.mZppChart.setData(new float[0], new float[0]);
        return;
    L5:
        if (this.mDistanceData.isEmpty() == true) goto L32;
        int r10 = 0;
    L9:
        if (r10 >= this.mConfidenceData.size()) goto L14;
        if (this.mConfidenceData.get(r10).floatValue() != 0.0f) goto L15;
        r10 = r10 + 1;
    L15:
        if (r10 != (-1)) goto L18;
        this.mZppChart.setData(new float[0], new float[0]);
        return;
    L18:
        int r11 = Math.min(this.mConfidenceData.size(), this.mDistanceData.size());
        if (r10 < r11) goto L22;
        this.mZppChart.setData(new float[0], new float[0]);
        return;
    L22:
        List<Float> r12 = this.mConfidenceData.subList(r10, r11);
        List<Float> r13 = this.mDistanceData.subList(r10, r11);
        int r14 = r12.size();
        int r15 = Math.max(0, r14 - Math.min(r14, this.mZoomLevel * 50));
        List<Float> r16 = r12.subList(r15, r14);
        List<Float> r17 = r13.subList(r15, r14);
        float[] r18 = new float[r16.size()];
        int r19 = 0;
    L24:
        if (r19 >= r16.size()) goto L26;
        r18[r19] = r16.get(r19).floatValue();
        r19 = r19 + 1;
        goto L24
    L26:
        float[] r20 = new float[r17.size()];
    L28:
        if (r8 >= r17.size()) goto L30;
        r20[r8] = r17.get(r8).floatValue();
        r8 = r8 + 1;
        goto L28
    L30:
        this.mZppChart.setData(r18, r20);
        return;
    L14:
        r10 = -1;
        goto L15
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_star_zpp_ui);
        this.mZppChart = (ZppChart) findViewById(R.id.zpp_chart);
        this.mFileInfoTextView = (TextView) findViewById(R.id.file_info);
        Button r10 = (Button) findViewById(R.id.refresh_button);
        Button r11 = (Button) findViewById(R.id.show_features_button);
        Button r12 = (Button) findViewById(R.id.zoom_button);
        r10.setOnClickListener(new com.google.android.material.search.a(this, 2));
        r12.setOnClickListener(new a(this, 1));
        r11.setOnClickListener(new q(this, 4));
        parseZppLog();
        updateCharts();
    }
}
