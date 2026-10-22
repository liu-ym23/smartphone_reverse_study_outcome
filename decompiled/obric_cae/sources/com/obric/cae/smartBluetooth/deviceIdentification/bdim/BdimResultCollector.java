package com.obric.cae.smartBluetooth.deviceIdentification.bdim;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.app.r;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class BdimResultCollector {
    private static final String CSV_HEADER = "Timestamp,Address,Name,ServiceInfo,Method,IO,CoD,Manuf,ActualCodType,PredictedClass,Confidence,FinalType\n";
    private static final String FILE_NAME = "bdim_prediction_results.csv";
    private static final String TAG = "BdimResultCollector";
    private static BdimResultCollector sInstance;
    private final ExecutorService mExecutorService;
    private File mLogFile;
    private final Set<String> mWrittenRecords;

    private BdimResultCollector(Context r8) {
        this.mWrittenRecords = ConcurrentHashMap.newKeySet();
        this.mExecutorService = Executors.newSingleThreadExecutor();
        initLogFile(r8);
    }

    public static /* synthetic */ void a(BdimResultCollector r8, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, int r19, float r110) {
        r8.lambda$logPredictionResult$1(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
    }

    public static /* synthetic */ void b(BdimResultCollector r8, Context r10) {
        r8.lambda$initLogFile$0(r10);
    }

    public static synchronized BdimResultCollector getInstance(Context r8) {
        monitor-enter(BdimResultCollector.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new BdimResultCollector(r8.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        BdimResultCollector r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(BdimResultCollector.class);
        return r10;
    }

    private void initLogFile(Context r8) {
        this.mExecutorService.submit(new r(15, this, r8));
    }

    private /* synthetic */ void lambda$initLogFile$0(Context r8) {
        File r10 = r8.getNoBackupFilesDir();     // Catch: Exception -> L47
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.exists() == true) goto L8;
        r10.mkdirs();     // Catch: Exception -> L47
    L8:
        File r11 = new File(r10, FILE_NAME);     // Catch: Exception -> L47
        this.mLogFile = r11;     // Catch: Exception -> L47
        if (r11.exists() == true) goto L12;
    L36:
        FileWriter r12 = new FileWriter(this.mLogFile, true);     // Catch: Exception -> L47
        r12.append(CSV_HEADER);     // Catch: Throwable -> L41
        r12.close();     // Catch: Exception -> L47
    L39:
        Log.i(TAG, "Log file initialized at: " + this.mLogFile.getAbsolutePath());     // Catch: Exception -> L47
        return;
    L41:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L44
    L46:
        throw th;     // Catch: Exception -> L47
    L44:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L47
        goto L46
    L12:
        if (this.mLogFile.length() == 0) goto L36;
        BufferedReader r13 = new BufferedReader(new FileReader(this.mLogFile));     // Catch: Exception -> L34
        boolean r14 = true;
    L55:
        String r15 = r13.readLine();     // Catch: Throwable -> L28
        if (r15 == null) goto L26;
        if (r14 == true) goto L19;
        int r16 = r15.indexOf(44);     // Catch: Throwable -> L28
        if (r16 == (-1)) goto L55;
        if (r16 >= (r15.length() - 1)) goto L55;
        this.mWrittenRecords.add(r15.substring(r16 + 1));     // Catch: Throwable -> L28
    L19:
        r14 = false;
        goto L55
    L26:
        r13.close();     // Catch: Exception -> L34
    L28:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L31
    L33:
        throw th;     // Catch: Exception -> L34
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L34
    L34:
        e = move-exception;
        Log.e(TAG, "Failed to read existing CSV for deduplication", e);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        Log.e(TAG, "Failed to initialize log file", e);
    }

    private /* synthetic */ void lambda$logPredictionResult$1(String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, float r25) {
        if (this.mLogFile != null) goto L6;
        Log.w(TAG, "Log file is not initialized, skipping log.");
        return;
    L6:
        String r8 = String.format(Locale.US, "%s,%s,%s,%s,%s,%s,%s,%s,%s,%.4f,%s", new Object[]{sanitizeCsvField(r15), sanitizeCsvField(r16), sanitizeCsvField(r17), sanitizeCsvField(r18), sanitizeCsvField(r19), sanitizeCsvField(r20), sanitizeCsvField(r21), sanitizeCsvField(r22), sanitizeCsvField(r23), Float.valueOf(r25), sanitizeCsvField(BluetoothDeviceIdentificationModel.mapIntTypeToString(r24))});
        if (this.mWrittenRecords.add(r8) == true) goto L29;
        Log.d(TAG, "Exact same data already exists in CSV, skipping log for address: " + r15);
        return;
    L29:
        FileWriter r10 = new FileWriter(this.mLogFile, true);     // Catch: IOException -> L22
        r10.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date()) + "," + r8 + "\n");     // Catch: Throwable -> L14
        r10.flush();     // Catch: Throwable -> L14
        r10.close();     // Catch: IOException -> L22
        return;
    L14:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L18
    L30:
        throw th;     // Catch: IOException -> L22
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
        throw th;     // Catch: IOException -> L22
    L22:
        e = move-exception;
        Log.e(TAG, "Failed to write prediction result to log file", e);
        this.mWrittenRecords.remove(r8);
    }

    private String sanitizeCsvField(String r8) {
        if (r8 != null) goto L6;
        return "NULL";
    L6:
        if (r8.contains(",") == true) goto L14;
        if (r8.contains("\"") == true) goto L14;
        if (r8.contains("\n") == true) goto L14;
        return r8;
    L14:
        return "\"" + r8.replace("\"", "\"\"") + "\"";
    }

    public void logPredictionResult(final String r16, final String r17, final String r18, final String r19, final String r20, final String r21, final String r22, final String r23, final String r24, final float r25, final int r26) {
        this.mExecutorService.submit(new b(this, r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, r25));
    }
}
