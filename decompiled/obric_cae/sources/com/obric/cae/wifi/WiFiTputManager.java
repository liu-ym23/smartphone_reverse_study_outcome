package com.obric.cae.wifi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.obric.cae.utils.CaeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class WiFiTputManager {
    private static final String TAG = "WiFiTputManager";
    private static final long UPDATE_TIME_MS_THRESHOLD = 100000000000L;
    private static volatile WiFiTputManager instance;
    private final WiFiDBHelper dbHelper;
    private final SQLiteDatabase writableDb;

    private WiFiTputManager(Context r8) {
        WiFiDBHelper r10 = WiFiDBHelper.getInstance(r8);
        this.dbHelper = r10;
        this.writableDb = r10.getWritableDatabase();
    }

    private static void addCsvIntsToSet(Set<Integer> r8, String r10) {
        if (r8 == null) goto L14;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L22;
        String[] r11 = r10.split(",");
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L23;
        String r14 = r11[r13];
        if (r14 == null) goto L13;
        r8.add(Integer.valueOf(Integer.parseInt(r14.trim())));     // Catch: NumberFormatException -> L15
    L13:
        r13 = r13 + 1;
        goto L8
    L23:
        return;
    L22:
        return;
    }

    public static WiFiTputManager getInstance() {
        if (instance == null) goto L7;
        return instance;
    L7:
        throw new IllegalStateException("WiFiTputManager not initialized");
    }

    private long[] getUpdateTimeRangeSeconds() {
        Cursor r8 = null;
        r8 = this.writableDb.rawQuery("SELECT MIN(update_time), MAX(update_time) FROM wifi_ema_tput", null);     // Catch: Throwable -> L21 Throwable -> L23
        if (r8 != null) goto L6;
    L18:
        if (r8 == null) goto L28;
    L41:
        r8.close();     // Catch: RuntimeException -> L33
    L28:
        return new long[]{0, 0};
    L6:
        if (r8.moveToFirst() == false) goto L18;
        long r10 = 0;
        if (r8.isNull(0) == false) goto L10;
        long r11 = 0;
    L12:
        if (r8.isNull(1) == true) goto L15;
        r10 = r8.getLong(1);     // Catch: Throwable -> L21 Throwable -> L23
    L15:
        long[] r12 = {r11, r10};     // Catch: Throwable -> L21 Throwable -> L23
        r8.close();     // Catch: RuntimeException -> L32
    L17:
        return r12;
    L10:
        r11 = r8.getLong(0);     // Catch: Throwable -> L21 Throwable -> L23
    L23:
        e = move-exception;
        Log.e(TAG, "getUpdateTimeRangeSeconds failed", e);     // Catch: Throwable -> L21
        if (r8 == null) goto L28;
    L21:
        th = move-exception;
        if (r8 != null) goto L37;
    L31:
        throw th;
    L37:
        r8.close();     // Catch: RuntimeException -> L34
        goto L31
    }

    private static String joinIntSet(Set<Integer> r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.isEmpty() == true) goto L24;
        StringBuilder r10 = new StringBuilder();
        Iterator<Integer> r11 = r8.iterator();
        boolean r12 = true;
    L8:
        if (r11.hasNext() == false) goto L16;
        Integer r13 = r11.next();
        if (r13 == null) goto L8;
        if (r12 == true) goto L14;
        r10.append(',');
    L14:
        r10.append(r13);
        r12 = false;
        goto L8
    L16:
        return r10.toString();
    L24:
        return "";
    }

    private void normalizeUpdateTimeUnitIfNeeded() {
        Cursor r8 = null;
        r8 = this.writableDb.rawQuery("SELECT MAX(update_time) FROM wifi_ema_tput", null);     // Catch: Throwable -> L21 Throwable -> L23
        if (r8 != null) goto L6;
    L18:
        if (r8 == null) goto L47;
        r8.close();     // Catch: RuntimeException -> L33
        return;
    L48:
        return;
    L47:
        return;
    L6:
        if (r8.moveToFirst() == false) goto L18;
        if (r8.isNull(0) == true) goto L18;
        long r10 = r8.getLong(0);     // Catch: Throwable -> L21 Throwable -> L23
        if (r10 < UPDATE_TIME_MS_THRESHOLD) goto L39;
        this.writableDb.execSQL("UPDATE wifi_ema_tput SET update_time = (update_time / 1000) WHERE update_time >= 100000000000");     // Catch: Throwable -> L21 Throwable -> L23 Throwable -> L23
        Log.w(TAG, "normalizeUpdateTimeUnitIfNeeded: converted update_time from ms to sec, max(before)=" + r10);     // Catch: Throwable -> L21 Throwable -> L23 Throwable -> L23
    L43:
        r8.close();     // Catch: RuntimeException -> L31
        return;
    L50:
        return;
    L39:
        r8.close();     // Catch: RuntimeException -> L32
        return;
    L46:
        return;
    L23:
        e = move-exception;
        Log.e(TAG, "normalizeUpdateTimeUnitIfNeeded failed", e);     // Catch: Throwable -> L21
        if (r8 != null) goto L43;
        return;
    L21:
        th = move-exception;
        if (r8 != null) goto L41;
    L30:
        throw th;
    L41:
        r8.close();     // Catch: RuntimeException -> L34
        goto L30
    }

    public void cleanExpiredData(long r11) {
        int r8 = getTotalRowCount();
        normalizeUpdateTimeUnitIfNeeded();
        long r10 = System.currentTimeMillis() / 1000;
        long r12 = r10 - r11;
        long[] r13 = getUpdateTimeRangeSeconds();
        Log.d(TAG, "cleanExpiredData: nowSec=" + r10 + ", thresholdSec=" + r12 + ", updateTimeRangeSec=[" + r13[0] + "," + r13[1] + "], rows(before)=" + r8 + ", deletedTput=" + this.writableDb.delete(WiFiDBHelper.TABLE_EMA_TPUT, "update_time < ?", new String[]{String.valueOf(r12)}) + ", deletedScan=" + this.writableDb.delete(WiFiDBHelper.TABLE_SCAN_BAND, "timestamp < ?", new String[]{String.valueOf(1000 * r12)}) + ", rows(after)=" + getTotalRowCount());
    }

    public void close() {
        this.dbHelper.closeDatabase();
        instance = null;
    }

    public void dumpAllRows(int r20) {
        if (r20 > 0) goto L5;
        int r8 = 100;
    L6:
        Cursor r10 = null;
        r10 = this.writableDb.query(WiFiDBHelper.TABLE_EMA_TPUT, new String[]{WiFiDBHelper.COL_BSSID, WiFiDBHelper.COL_RSSI, WiFiDBHelper.COL_EMA_TPUT, WiFiDBHelper.COL_SAMPLE_COUNT, WiFiDBHelper.COL_UPDATE_TIME}, null, null, null, null, "update_time DESC", String.valueOf(r8));     // Catch: Throwable -> L38 Throwable -> L40
        if (r10 != null) goto L10;
        int r11 = 0;
    L11:
        Log.d(TAG, "dumpAllRows: rows=" + r11 + ", limit=" + r8);     // Catch: Throwable -> L38 Throwable -> L40
        if (r10 != null) goto L16;
        if (r10 == null) goto L59;
        r10.close();     // Catch: RuntimeException -> L48
        return;
    L60:
        return;
    L59:
        return;
    L16:
        int r12 = r10.getColumnIndex(WiFiDBHelper.COL_BSSID);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        int r13 = r10.getColumnIndex(WiFiDBHelper.COL_RSSI);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        int r14 = r10.getColumnIndex(WiFiDBHelper.COL_EMA_TPUT);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        int r15 = r10.getColumnIndex(WiFiDBHelper.COL_SAMPLE_COUNT);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        int r16 = r10.getColumnIndex(WiFiDBHelper.COL_UPDATE_TIME);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        int r17 = 0;
    L17:
        if (r10.moveToNext() == false) goto L53;
        if (r12 < 0) goto L21;
        String r18 = r10.getString(r12);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
    L22:
        if (r13 < 0) goto L24;
        int r19 = r10.getInt(r13);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
    L25:
        if (r14 < 0) goto L27;
        int r110 = r10.getInt(r14);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
    L28:
        if (r15 < 0) goto L30;
        int r111 = r10.getInt(r15);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
    L31:
        if (r16 < 0) goto L33;
        long r112 = r10.getLong(r16);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
    L34:
        StringBuilder r113 = new StringBuilder();     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append("dumpAllRows[");     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        int r114 = r17 + 1;     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append(r17);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append("]: bssid=");     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append(CaeUtil.maskMacOrBssid(r18));     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append(", rssi=");     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append(r19);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append(", ema_tput=");     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append(r110);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append(", sample_count=");     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append(r111);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append(", update_time=");     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r113.append(r112);     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        Log.d(TAG, r113.toString());     // Catch: Throwable -> L38 Throwable -> L40 Throwable -> L40
        r17 = r114;
        goto L17
    L33:
        r112 = 0;
        goto L34
    L30:
        r111 = 0;
        goto L31
    L27:
        r110 = 0;
        goto L28
    L24:
        r19 = 0;
        goto L25
    L21:
        r18 = "";
    L53:
        r10.close();     // Catch: RuntimeException -> L49
        return;
    L62:
        return;
    L10:
        r11 = r10.getCount();     // Catch: Throwable -> L38 Throwable -> L40
    L38:
        th = move-exception;
        if (r10 != null) goto L51;
    L47:
        throw th;
    L51:
        r10.close();     // Catch: RuntimeException -> L50
    L40:
        e = move-exception;
        Log.e(TAG, "dumpAllRows failed", e);     // Catch: Throwable -> L38
        if (r10 != null) goto L53;
        return;
    L5:
        r8 = r20;
        goto L6
    }

    public int getEmaTput(String r16, int r17) {
        int r8 = 0;
        int r10 = 0;
    L4:
        if (r10 >= 3) goto L35;
        Cursor r11 = null;
        SQLiteDatabase r12 = this.writableDb;     // Catch: Throwable -> L16 Throwable -> L18
        String[] r13 = new String[1];     // Catch: Throwable -> L16 Throwable -> L18
        r13[r8] = WiFiDBHelper.COL_EMA_TPUT;     // Catch: Throwable -> L16 Throwable -> L18
        String[] r14 = new String[2];     // Catch: Throwable -> L16 Throwable -> L18
        r14[r8] = r16;     // Catch: Throwable -> L16 Throwable -> L18
        r14[1] = String.valueOf(r17);     // Catch: Throwable -> L16 Throwable -> L18
        r11 = r12.query(WiFiDBHelper.TABLE_EMA_TPUT, r13, "bssid=? AND rssi=?", r14, null, null, null);     // Catch: Throwable -> L16 Throwable -> L18
        if (r11 == null) goto L13;
        if (r11.moveToFirst() == false) goto L13;
        int r15 = r11.getColumnIndex(WiFiDBHelper.COL_EMA_TPUT);     // Catch: Throwable -> L16 Throwable -> L18
        if (r15 < 0) goto L13;
        r8 = r11.getInt(r15);     // Catch: Throwable -> L16 Throwable -> L18
    L13:
        if (r11 != null) goto L46;
    L15:
        return r8;
    L46:
        r11.close();     // Catch: RuntimeException -> L37
    L18:
        e = move-exception;
        r10 = r10 + 1;
        if (r10 >= 3) goto L21;
        Thread.sleep(100);     // Catch: Throwable -> L16 InterruptedException -> L28
    L29:
        if (r11 == null) goto L4;
        r11.close();     // Catch: RuntimeException -> L36
        goto L4
    L28:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L16
        goto L29
    L21:
        Log.e(TAG, "getEmaTput failed after retries, bssid=" + CaeUtil.maskMacOrBssid(r16) + ", rssi=" + r17, e);     // Catch: Throwable -> L16
        if (r11 != null) goto L44;
    L24:
        return r8;
    L44:
        r11.close();     // Catch: RuntimeException -> L39
    L16:
        th = move-exception;
        if (r11 != null) goto L48;
    L34:
        throw th;
    L48:
        r11.close();     // Catch: RuntimeException -> L38
        goto L34
    L35:
        return r8;
    }

    public int getSampleCount(String r16, int r17) {
        int r8 = 0;
        int r10 = 0;
    L4:
        if (r10 >= 3) goto L35;
        Cursor r11 = null;
        SQLiteDatabase r12 = this.writableDb;     // Catch: Throwable -> L16 Throwable -> L18
        String[] r13 = new String[1];     // Catch: Throwable -> L16 Throwable -> L18
        r13[r8] = WiFiDBHelper.COL_SAMPLE_COUNT;     // Catch: Throwable -> L16 Throwable -> L18
        String[] r14 = new String[2];     // Catch: Throwable -> L16 Throwable -> L18
        r14[r8] = r16;     // Catch: Throwable -> L16 Throwable -> L18
        r14[1] = String.valueOf(r17);     // Catch: Throwable -> L16 Throwable -> L18
        r11 = r12.query(WiFiDBHelper.TABLE_EMA_TPUT, r13, "bssid=? AND rssi=?", r14, null, null, null);     // Catch: Throwable -> L16 Throwable -> L18
        if (r11 == null) goto L13;
        if (r11.moveToFirst() == false) goto L13;
        int r15 = r11.getColumnIndex(WiFiDBHelper.COL_SAMPLE_COUNT);     // Catch: Throwable -> L16 Throwable -> L18
        if (r15 < 0) goto L13;
        r8 = r11.getInt(r15);     // Catch: Throwable -> L16 Throwable -> L18
    L13:
        if (r11 != null) goto L46;
    L15:
        return r8;
    L46:
        r11.close();     // Catch: RuntimeException -> L37
    L18:
        e = move-exception;
        r10 = r10 + 1;
        if (r10 >= 3) goto L21;
        Thread.sleep(100);     // Catch: Throwable -> L16 InterruptedException -> L28
    L29:
        if (r11 == null) goto L4;
        r11.close();     // Catch: RuntimeException -> L36
        goto L4
    L28:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L16
        goto L29
    L21:
        Log.e(TAG, "getSampleCount failed after retries, bssid=" + CaeUtil.maskMacOrBssid(r16) + ", rssi=" + r17, e);     // Catch: Throwable -> L16
        if (r11 != null) goto L44;
    L24:
        return r8;
    L44:
        r11.close();     // Catch: RuntimeException -> L39
    L16:
        th = move-exception;
        if (r11 != null) goto L48;
    L34:
        throw th;
    L48:
        r11.close();     // Catch: RuntimeException -> L38
        goto L34
    L35:
        return r8;
    }

    public List<Integer> getScannedFreqsMhz(String r13, String r14) {
        HashSet r8 = new HashSet();
        Cursor r10 = null;
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L38 Exception -> L40
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L38 Exception -> L40
        if (r13 != null) goto L7;
    L12:
        if (r14 != null) goto L14;
    L19:
        SQLiteDatabase r15 = this.writableDb;     // Catch: Throwable -> L38 Exception -> L40
        String[] r16 = {WiFiDBHelper.COL_SCAN_FREQS_MHZ};     // Catch: Throwable -> L38 Exception -> L40
        if (r11.length() <= 0) goto L22;
        String r17 = r11.toString();     // Catch: Throwable -> L38 Exception -> L40
    L24:
        if (r12.isEmpty() == false) goto L26;
        String[] r18 = null;
    L27:
        r10 = r15.query(WiFiDBHelper.TABLE_SCAN_BAND, r16, r17, r18, null, null, null, null);     // Catch: Throwable -> L38 Exception -> L40
        if (r10 == null) goto L35;
        int r19 = r10.getColumnIndex(WiFiDBHelper.COL_SCAN_FREQS_MHZ);     // Catch: Throwable -> L38 Exception -> L40
        if (r19 < 0) goto L35;
    L31:
        if (r10.moveToNext() == false) goto L35;
        addCsvIntsToSet(r8, r10.getString(r19));     // Catch: Throwable -> L38 Exception -> L40
        goto L31
    L35:
        if (r10 != null) goto L56;
    L44:
        ArrayList r110 = new ArrayList(r8);
        Collections.sort(r110);
        return r110;
    L56:
        r10.close();     // Catch: RuntimeException -> L49
        goto L44
    L26:
        r18 = (String[]) r12.toArray(new String[0]);     // Catch: Throwable -> L38 Exception -> L40
        goto L27
    L22:
        r17 = null;
        goto L24
    L14:
        if (r14.isEmpty() == true) goto L19;
        if (r11.length() <= 0) goto L18;
        r11.append(" AND ");     // Catch: Throwable -> L38 Exception -> L40
    L18:
        r11.append(WiFiDBHelper.COL_SCAN_CURR_SSID);     // Catch: Throwable -> L38 Exception -> L40
        r11.append(" = ?");     // Catch: Throwable -> L38 Exception -> L40
        r12.add(r14);     // Catch: Throwable -> L38 Exception -> L40
        goto L19
    L7:
        if (r13.isEmpty() == true) goto L12;
        if (r11.length() <= 0) goto L11;
        r11.append(" AND ");     // Catch: Throwable -> L38 Exception -> L40
    L11:
        r11.append(WiFiDBHelper.COL_SCAN_CURR_BSSID);     // Catch: Throwable -> L38 Exception -> L40
        r11.append(" = ?");     // Catch: Throwable -> L38 Exception -> L40
        r12.add(r13);     // Catch: Throwable -> L38 Exception -> L40
    L40:
        e = move-exception;
        Log.e(TAG, "Failed to get scanned freqs mhz", e);     // Catch: Throwable -> L38
        if (r10 == null) goto L44;
    L38:
        th = move-exception;
        if (r10 != null) goto L53;
    L48:
        throw th;
    L53:
        r10.close();     // Catch: RuntimeException -> L50
        goto L48
    }

    public int getTotalRowCount() {
        Cursor r8 = null;
        r8 = this.writableDb.rawQuery("SELECT COUNT(*) FROM wifi_ema_tput", null);     // Catch: Throwable -> L13 Throwable -> L15
        if (r8 != null) goto L6;
    L10:
        if (r8 != null) goto L33;
    L12:
        return 0;
    L33:
        r8.close();     // Catch: RuntimeException -> L24
        goto L12
    L6:
        if (r8.moveToFirst() == false) goto L10;
        int r10 = r8.getInt(0);     // Catch: Throwable -> L13 Throwable -> L15
    L35:
        r8.close();     // Catch: RuntimeException -> L23
    L9:
        return r10;
    L13:
        th = move-exception;
        if (r8 != null) goto L28;
    L22:
        throw th;
    L28:
        r8.close();     // Catch: RuntimeException -> L25
    L15:
        e = move-exception;
        Log.e(TAG, "getTotalRowCount failed", e);     // Catch: Throwable -> L13
        if (r8 != null) goto L31;
    L19:
        return 0;
    L31:
        r8.close();     // Catch: RuntimeException -> L26
        goto L19
    }

    public SQLiteDatabase getWritableDb() {
        return this.writableDb;
    }

    public void insertBandRecords(List<ScannedBandRecord> r27) {
        String r8 = WiFiDBHelper.COL_SCAN_FREQS_MHZ;
        String r10 = "timestamp";
        if (r27 != null) goto L5;
        return;
    L5:
        if (r27.isEmpty() == true) goto L92;
        this.writableDb.beginTransaction();
        Iterator<ScannedBandRecord> r11 = r27.iterator();     // Catch: Throwable -> L63 Exception -> L65
    L10:
        if (r11.hasNext() == false) goto L61;
        ScannedBandRecord r12 = r11.next();     // Catch: Throwable -> L63 Exception -> L65
        if (r12 == null) goto L10;
        String r13 = r12.currentBssid;     // Catch: Throwable -> L63 Exception -> L65
        String r14 = r12.currentSsid;     // Catch: Throwable -> L63 Exception -> L65
        HashSet r15 = new HashSet();     // Catch: Throwable -> L63 Exception -> L65
        addCsvIntsToSet(r15, r12.scannedFreqsMhz);     // Catch: Throwable -> L63 Exception -> L65
        long r16 = r12.timestamp;     // Catch: Throwable -> L63 Exception -> L65
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L63 Exception -> L65
        ArrayList r18 = new ArrayList();     // Catch: Throwable -> L63 Exception -> L65
        if (r13 != null) goto L19;
        r17.append(WiFiDBHelper.COL_SCAN_CURR_BSSID);     // Catch: Throwable -> L63 Exception -> L65
        r17.append(" IS NULL");     // Catch: Throwable -> L63 Exception -> L65
    L18:
        Iterator<ScannedBandRecord> r28 = r11;
        r17.append(" AND ");     // Catch: Throwable -> L63 Exception -> L65
        String r19 = WiFiDBHelper.COL_SCAN_CURR_SSID;
        if (r14 != null) goto L24;
        r17.append(WiFiDBHelper.COL_SCAN_CURR_SSID);     // Catch: Throwable -> L63 Exception -> L65
        r17.append(" IS NULL");     // Catch: Throwable -> L63 Exception -> L65
    L79:
        SQLiteDatabase r110 = this.writableDb;     // Catch: Throwable -> L56
        long r24 = r16;
        int r111 = 0;
        String[] r112 = {r10, r8};     // Catch: Throwable -> L56
        String r113 = r17.toString();     // Catch: Throwable -> L56
        if (r18.isEmpty() == false) goto L28;
        String[] r20 = null;
    L29:
        Cursor r114 = r110.query(WiFiDBHelper.TABLE_SCAN_BAND, r112, r113, r20, null, null, null);     // Catch: Throwable -> L56
        if (r114 == null) goto L43;
        long r115 = r24;
    L81:
        if (r114.moveToNext() == false) goto L40;
        if (r114.isNull(r111) == false) goto L37;
        long r116 = 0;
    L38:
        String r117 = r8;
        String r118 = r10;
        String r119 = r19;
        addCsvIntsToSet(r15, r114.getString(1));     // Catch: Throwable -> L41
        r115 = Math.max(r115, r116);     // Catch: Throwable -> L41
        r19 = r119;
        r8 = r117;
        r10 = r118;
        r111 = 0;
        goto L81
    L37:
        r116 = r114.getLong(r111);     // Catch: Throwable -> L41
        goto L38
    L40:
        String r120 = r8;
        String r121 = r10;
        String r122 = r19;
        r24 = r115;
    L44:
        if (r114 == null) goto L76;
        r114.close();     // Catch: RuntimeException -> L72 Throwable -> L63 Exception -> L65
    L76:
        SQLiteDatabase r21 = this.writableDb;     // Catch: Throwable -> L52
        String r22 = r17.toString();     // Catch: Throwable -> L52
        if (r18.isEmpty() == false) goto L49;
        String[] r23 = null;
    L50:
        r21.delete(WiFiDBHelper.TABLE_SCAN_BAND, r22, r23);     // Catch: Throwable -> L52
    L54:
        ContentValues r25 = new ContentValues();     // Catch: Throwable -> L63 Exception -> L65
        r25.put(WiFiDBHelper.COL_SCAN_CURR_BSSID, r13);     // Catch: Throwable -> L63 Exception -> L65
        r25.put(r122, r14);     // Catch: Throwable -> L63 Exception -> L65
        String r26 = r120;
        r25.put(r26, joinIntSet(r15));     // Catch: Throwable -> L63 Exception -> L65
        String r29 = r121;
        r25.put(r29, Long.valueOf(r24));     // Catch: Throwable -> L63 Exception -> L65
        this.writableDb.insert(WiFiDBHelper.TABLE_SCAN_BAND, null, r25);     // Catch: Throwable -> L63 Exception -> L65
        r8 = r26;
        r10 = r29;
        r11 = r28;
        goto L10
    L49:
        r23 = (String[]) r18.toArray(new String[0]);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        Log.w(TAG, "Failed to delete old scan rows for merge", th);     // Catch: Throwable -> L63 Exception -> L65
    L41:
        th = th;
        Cursor r123 = r114;
    L58:
        if (r123 != null) goto L83;
    L60:
        throw th;     // Catch: Throwable -> L63 Exception -> L65
    L83:
        r123.close();     // Catch: RuntimeException -> L73 Throwable -> L63 Exception -> L65
        goto L60
    L43:
        r120 = r8;
        r121 = r10;
        r122 = WiFiDBHelper.COL_SCAN_CURR_SSID;
        goto L44
    L28:
        r20 = (String[]) r18.toArray(new String[0]);     // Catch: Throwable -> L56
    L56:
        th = th;
        r123 = null;
        goto L58
    L24:
        r17.append(WiFiDBHelper.COL_SCAN_CURR_SSID);     // Catch: Throwable -> L63 Exception -> L65
        r17.append("=?");     // Catch: Throwable -> L63 Exception -> L65
        r18.add(r14);     // Catch: Throwable -> L63 Exception -> L65
        goto L79
    L19:
        r17.append(WiFiDBHelper.COL_SCAN_CURR_BSSID);     // Catch: Throwable -> L63 Exception -> L65
        r17.append("=?");     // Catch: Throwable -> L63 Exception -> L65
        r18.add(r13);     // Catch: Throwable -> L63 Exception -> L65
        goto L18
    L61:
        this.writableDb.setTransactionSuccessful();     // Catch: Throwable -> L63 Exception -> L65
    L67:
        this.writableDb.endTransaction();
        return;
    L63:
        th = move-exception;
        this.writableDb.endTransaction();
        throw th;
    L65:
        e = move-exception;
        Log.e(TAG, "Failed to insert band records", e);     // Catch: Throwable -> L63
        goto L67
    }

    public void upsertEmaTput(String r8, int r10, int r11, int r12) {
        ContentValues r13 = new ContentValues();
        r13.put(WiFiDBHelper.COL_BSSID, r8);
        r13.put(WiFiDBHelper.COL_RSSI, Integer.valueOf(r10));
        r13.put(WiFiDBHelper.COL_EMA_TPUT, Integer.valueOf(r11));
        r13.put(WiFiDBHelper.COL_SAMPLE_COUNT, Integer.valueOf(r12));
        r13.put(WiFiDBHelper.COL_UPDATE_TIME, Long.valueOf(System.currentTimeMillis() / 1000));
        this.writableDb.replace(WiFiDBHelper.TABLE_EMA_TPUT, null, r13);
    }

    public static WiFiTputManager getInstance(Context r8) {
        if (instance != null) goto L15;
        monitor-enter(WiFiTputManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new WiFiTputManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(WiFiTputManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }
}
