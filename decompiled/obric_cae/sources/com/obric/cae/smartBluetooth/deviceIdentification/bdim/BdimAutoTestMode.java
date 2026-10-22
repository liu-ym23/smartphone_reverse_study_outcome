package com.obric.cae.smartBluetooth.deviceIdentification.bdim;

import android.content.Context;
import android.os.Environment;
import com.obric.cae.libs.bluetooth.BdimPredictEvent;
import com.obric.cae.log.CaeLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BdimAutoTestMode {
    private static final String TAG = "BdimAutoTestMode";

    public BdimAutoTestMode() {
    }

    public static /* synthetic */ boolean a(File r8, String r10) {
        return lambda$runBatchTest$0(r8, r10);
    }

    private static /* synthetic */ boolean lambda$runBatchTest$0(File r8, String r10) {
        if (r10.endsWith(".csv") == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.startsWith("result_") == true) goto L7;
        return true;
    }

    public static String runBatchTest(Context r39, BluetoothDeviceIdentificationModel r40) {
        BluetoothDeviceIdentificationModel r8 = r40;
        String r10 = TAG;
        if (r39 == null) goto L147;
        if (r8 == null) goto L147;
        File r11 = r39.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        if (r11 != null) goto L10;
        CaeLog.d(TAG, "External documents directory not available.");
        return "External documents directory not available.";
    L10:
        File r12 = new File(r11, "autotest");
        if (r12.exists() == true) goto L14;
        r12.mkdirs();
        CaeLog.d(TAG, "Autotest directory not found. Created at: " + r12.getAbsolutePath());
        return "Autotest directory not found. Just created it at: " + r12.getAbsolutePath() + "\nPlease push your csv files there.";
    L14:
        File[] r13 = r12.listFiles(new a());
        if (r13 != null) goto L17;
    L145:
        CaeLog.d(TAG, "No CSV files found in autotest directory for batch testing.");
        return "No CSV files found in autotest directory for batch testing.\nPlease put csv files in: " + r12.getAbsolutePath();
    L17:
        if (r13.length == 0) goto L145;
        StringBuilder r14 = new StringBuilder("Found ");
        StringBuilder r15 = new StringBuilder();
        r14.append(r13.length);
        r14.append(" test file(s):\n\n");
        int r16 = r13.length;
        boolean r17 = false;
        int r18 = 0;
        int r19 = 0;
    L20:
        if (r18 >= r16) goto L139;
        File r110 = r13[r18];
        File r20 = new File(r12, "result_" + r110.getName());
        BufferedReader r111 = new BufferedReader(new FileReader(r110));     // Catch: Exception -> L135
        FileWriter r112 = new FileWriter(r20, r17);     // Catch: Throwable -> L124
        String r113 = r111.readLine();     // Catch: Throwable -> L113
        if (r113 == null) goto L31;
        r112.append(r113).append(",BatchTestPredictedType,IsCorrect\n");     // Catch: Throwable -> L29
    L29:
        th = th;
        String r21 = r10;
        File r22 = r12;
        File[] r114 = r13;
    L111:
        StringBuilder r23 = r14;
        r16 = r16;
        int r24 = r18;
        r110 = r110;
        BufferedReader r34 = r111;
    L112:
        boolean r25 = false;
    L115:
        Throwable r26 = th;
    L167:
        r112.close();     // Catch: Throwable -> L118
    L121:
        throw r26;     // Catch: Throwable -> L122
    L118:
        th = move-exception;
        r26.addSuppressed(th);     // Catch: Throwable -> L122
    L122:
        th = th;
    L126:
        Throwable r27 = th;
        r34.close();     // Catch: Throwable -> L129
    L132:
        throw r27;     // Catch: Exception -> L133
    L129:
        th = move-exception;
        r27.addSuppressed(th);     // Catch: Exception -> L133
    L133:
        e = e;
    L137:
        String r28 = "Error testing file " + r110.getName() + ": " + e.getMessage();
        r23.append(r28);
        r23.append("\n\n");
        CaeLog.e(r21, r28, e);
    L138:
        r18 = r24 + 1;
        r17 = r25;
        r13 = r114;
        r16 = r16;
        r12 = r22;
        r14 = r23;
        r10 = r21;
        r8 = r40;
    L31:
        r114 = r13;
        int r29 = 0;
        int r115 = 0;
    L163:
        String r30 = r111.readLine();     // Catch: Throwable -> L109
        r16 = r16;
        if (r30 == null) goto L81;
        if (r30.trim().isEmpty() == true) goto L163;
        r22 = r12;
        String[] r31 = r30.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);     // Catch: Throwable -> L73
        r24 = r18;
        if (r31.length >= 12) goto L179;
        String r35 = r10;
        StringBuilder r36 = r14;
        r110 = r110;
        r34 = r111;
    L72:
        r8 = r40;
        r12 = r22;
        r18 = r24;
        r111 = r34;
        r10 = r35;
        r14 = r36;
        r20 = r20;
        r110 = r110;
        goto L163
    L179:
        String r32 = unquote(r31[1]);     // Catch: Throwable -> L69
        String r116 = unquote(r31[2]);     // Catch: Throwable -> L69
        r34 = r111;
        String r117 = unquote(r31[3]);     // Catch: Throwable -> L67
        String r210 = unquote(r31[4]);     // Catch: Throwable -> L67
        r35 = r10;
        String r33 = unquote(r31[5]);     // Catch: Throwable -> L65
        r36 = r14;
        String r37 = unquote(r31[6]);     // Catch: Throwable -> L62
        String r38 = unquote(r31[7]);     // Catch: Throwable -> L62
        String r310 = unquote(r31[8]);     // Catch: Throwable -> L62
        String r41 = unquote(r31[11]);     // Catch: Throwable -> L62
        r110 = r110;
        String r118 = BluetoothDeviceIdentificationModel.mapIntTypeToString(r8.predict(new BdimPredictEvent(null, r32, r116, r117, r210, r33, r37, r38, r310)));     // Catch: Throwable -> L60
        int r42 = r29 + 1;     // Catch: Throwable -> L60
        boolean r119 = r41.equalsIgnoreCase(r118);     // Catch: Throwable -> L60
        if (r119 == false) goto L56;
        r115 = r115 + 1;
    L58:
        r112.append(r30).append(",").append(r118).append(",").append(String.valueOf(r119)).append("\n");     // Catch: Throwable -> L60
        r29 = r42;
        goto L72
    L56:
        r19 = r19 + 1;
        r15.append("Device: ");     // Catch: Throwable -> L60
        r15.append(r116);     // Catch: Throwable -> L60
        r15.append(" (");     // Catch: Throwable -> L60
        r15.append(r32);     // Catch: Throwable -> L60
        r15.append(")\n");     // Catch: Throwable -> L60
        r15.append("CoD: ");     // Catch: Throwable -> L60
        r15.append(r37);     // Catch: Throwable -> L60
        r15.append("\n");     // Catch: Throwable -> L60
        r15.append("Service: ");     // Catch: Throwable -> L60
        r15.append(r117);     // Catch: Throwable -> L60
        r15.append("\n");     // Catch: Throwable -> L60
        r15.append("IO: ");     // Catch: Throwable -> L60
        r15.append(r33);     // Catch: Throwable -> L60
        r15.append("\n");     // Catch: Throwable -> L60
        r15.append("Manuf: ");     // Catch: Throwable -> L60
        r15.append(r38);     // Catch: Throwable -> L60
        r15.append("\n");     // Catch: Throwable -> L60
        r15.append("Expected: ");     // Catch: Throwable -> L60
        r15.append(r41);     // Catch: Throwable -> L60
        r15.append(" | Predicted: ");     // Catch: Throwable -> L60
        r15.append(r118);     // Catch: Throwable -> L60
        r15.append("\n");     // Catch: Throwable -> L60
        r15.append("----------------------------\n");     // Catch: Throwable -> L60
    L60:
        th = th;
    L64:
        r26 = th;
        r21 = r35;
        r23 = r36;
    L80:
        r25 = false;
    L62:
        th = th;
        r110 = r110;
    L65:
        th = move-exception;
        r110 = r110;
        r26 = th;
        r23 = r14;
        r21 = r35;
    L67:
        th = th;
    L79:
        r26 = th;
        r21 = r10;
        r23 = r14;
    L69:
        th = th;
    L78:
        r34 = r111;
    L73:
        th = th;
    L77:
        r24 = r18;
    L75:
        th = th;
        r22 = r12;
        goto L77
    L81:
        File r311 = r20;
        String r312 = r10;
        r22 = r12;
        StringBuilder r313 = r14;
        r24 = r18;
        r110 = r110;
        r34 = r111;
        r112.flush();     // Catch: Throwable -> L107
        if (r29 <= 0) goto L85;
        float r43 = (r115 / r29) * 100.0f;     // Catch: Throwable -> L107
    L86:
        Locale r44 = Locale.US;     // Catch: Throwable -> L107
        Object[] r45 = new Object[5];     // Catch: Throwable -> L107
        r25 = false;
        r45[0] = r110.getName();     // Catch: Throwable -> L105
        r45[1] = Integer.valueOf(r29);     // Catch: Throwable -> L107
        r45[2] = Integer.valueOf(r115);     // Catch: Throwable -> L107
        r45[3] = Float.valueOf(r43);     // Catch: Throwable -> L107
        r45[4] = r311.getName();     // Catch: Throwable -> L107
        r23 = r313;
        r23.append(String.format(r44, "[%s]\nTotal Samples: %d, Correct: %d\nAccuracy: %.2f%%\nResult saved to: %s\n\n", r45));     // Catch: Throwable -> L103
        StringBuilder r46 = new StringBuilder();     // Catch: Throwable -> L103
        r46.append("Batch test completed for ");     // Catch: Throwable -> L103
        r46.append(r110.getName());     // Catch: Throwable -> L103
        r46.append(". Total: ");     // Catch: Throwable -> L103
        r46.append(r29);     // Catch: Throwable -> L103
        r46.append(", Correct: ");     // Catch: Throwable -> L103
        r46.append(r115);     // Catch: Throwable -> L103
        r46.append(", Accuracy: ");     // Catch: Throwable -> L103
        Object[] r47 = new Object[1];     // Catch: Throwable -> L103
        r25 = false;
        r47[0] = Float.valueOf(r43);     // Catch: Throwable -> L101
        r46.append(String.format("%.2f%%", r47));     // Catch: Throwable -> L101
        String r48 = r46.toString();     // Catch: Throwable -> L101
        r21 = r312;
        CaeLog.i(r21, r48);     // Catch: Throwable -> L99
        CaeLog.i(r21, "Batch test results saved to: " + r311.getAbsolutePath());     // Catch: Throwable -> L99
        r112.close();     // Catch: Throwable -> L122
        r34.close();     // Catch: Exception -> L133
    L99:
        th = th;
    L101:
        th = th;
        r21 = r312;
    L103:
        th = th;
        r21 = r312;
    L105:
        th = th;
        r21 = r312;
        r23 = r313;
        goto L115
    L85:
        r43 = 0.0f;
    L107:
        th = th;
        r21 = r312;
        r23 = r313;
    L109:
        th = th;
        r21 = r10;
        r22 = r12;
    L113:
        th = th;
        r21 = r10;
        r22 = r12;
        r114 = r13;
        r23 = r14;
        r16 = r16;
        r25 = r17;
        r24 = r18;
        r110 = r110;
        r34 = r111;
    L124:
        th = th;
        r21 = r10;
        r22 = r12;
        r114 = r13;
        r23 = r14;
        r16 = r16;
        r25 = r17;
        r24 = r18;
        r110 = r110;
        r34 = r111;
    L135:
        e = e;
        r21 = r10;
        r22 = r12;
        r114 = r13;
        r23 = r14;
        r16 = r16;
        r25 = r17;
        r24 = r18;
        r110 = r110;
        goto L137
    L139:
        StringBuilder r49 = r14;
        if (r19 <= 0) goto L142;
        r49.append("\n[ Failed Cases Details (Total: ");
        r49.append(r19);
        r49.append(") ]\n");
        String r50 = r15.toString();
    L143:
        r49.append(r50);
        return r49.toString();
    L142:
        r50 = "\n[ All tests passed! No failed cases. ]\n";
    L147:
        CaeLog.d(TAG, "Context or Model is null. Cannot run batch test.");
        return "Context or Model is null. Cannot run batch test.";
    }

    private static String unquote(String r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        String r10 = r8.trim();
        if (r10.startsWith("\"") == true) goto L8;
        return r10;
    L8:
        if (r10.endsWith("\"") == true) goto L10;
        return r10;
    L10:
        if (r10.length() >= 2) goto L12;
        return r10;
    L12:
        return r10.substring(1, r10.length() - 1).replace("\"\"", "\"");
    }
}
