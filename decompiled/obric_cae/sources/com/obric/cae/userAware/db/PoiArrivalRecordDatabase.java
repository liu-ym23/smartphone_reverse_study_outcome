package com.obric.cae.userAware.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.datacollection.PoiArrivalFeedbackInfo;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PoiArrivalRecordDatabase {
    private static final TimeZone BEIJING_TIME_ZONE = null;
    public static final String COLUMN_AOI_NAME = "aoi_name";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_EVENT_TIME = "event_time";
    public static final String COLUMN_EVENT_TIME_TEXT = "event_time_text";
    public static final String COLUMN_FEEDBACK_TIME = "feedback_time";
    public static final String COLUMN_FEEDBACK_TIME_TEXT = "feedback_time_text";
    public static final String COLUMN_HAS_FEEDBACK = "has_feedback";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_POI_NAME = "poi_name";
    public static final String COLUMN_USER_CHOICE = "user_choice";
    static final String CREATE_EVENT_TIME_INDEX = "CREATE INDEX IF NOT EXISTS poi_arrival_event_time_index ON poi_arrival_records (event_time DESC)";
    static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS poi_arrival_records (_id INTEGER PRIMARY KEY AUTOINCREMENT, event_time INTEGER NOT NULL, event_time_text TEXT DEFAULT '', feedback_time INTEGER NOT NULL DEFAULT 0, feedback_time_text TEXT DEFAULT '', poi_name TEXT DEFAULT '', aoi_name TEXT DEFAULT '', category TEXT DEFAULT '', has_feedback INTEGER NOT NULL DEFAULT 0, user_choice INTEGER NOT NULL DEFAULT -1, UNIQUE(event_time, poi_name, aoi_name, category))";
    private static final String EVENT_POI_FEEDBACK = "poi_feedback";
    private static final char[] HEX_ARRAY = null;
    private static final int MAX_RECORD_COUNT = 500;
    private static final int POI_EVENT_KEY_HEX_LENGTH = 16;
    private static final int REPORT_TYPE_FEEDBACK = 1;
    private static final int REPORT_TYPE_INSERT = 0;
    public static final String TABLE_RECORDS = "poi_arrival_records";
    private static final String TAG = "PoiArrivalRecordDatabase";
    private final HARStatusDatabaseHelper mDatabaseHelper;

    static {
        BEIJING_TIME_ZONE = TimeZone.getTimeZone("Asia/Shanghai");
        HEX_ARRAY = "0123456789abcdef".toCharArray();
    }

    public PoiArrivalRecordDatabase(Context r8) {
        this.mDatabaseHelper = new HARStatusDatabaseHelper(r8);
    }

    private static boolean applyFeedbackFromDb(SQLiteDatabase r10, PoiArrivalFeedbackInfo r11) {
        Cursor r12 = r10.query(TABLE_RECORDS, null, "_id=?", new String[]{String.valueOf(r11.getId())}, null, null, null, "1");
        boolean r8 = false;
        if (r12.moveToFirst() == true) goto L6;
        r12.close();
        return false;
    L6:
        if (r12.getInt(r12.getColumnIndexOrThrow("has_feedback")) != 1) goto L8;
        r8 = true;
    L8:
        r11.setHasFeedback(r8);     // Catch: Throwable -> L13
        r11.setUserChoice(r12.getInt(r12.getColumnIndexOrThrow(COLUMN_USER_CHOICE)));     // Catch: Throwable -> L13
        r11.setFeedbackTime(r12.getLong(r12.getColumnIndexOrThrow(COLUMN_FEEDBACK_TIME)));     // Catch: Throwable -> L13
        r12.close();
        return true;
    L13:
        th = move-exception;
        if (r12 != null) goto L22;
    L19:
        throw th;
    L22:
        r12.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    }

    private static ContentValues buildInsertValues(PoiArrivalFeedbackInfo r8) {
        ContentValues r10 = new ContentValues();
        r10.put("event_time", Long.valueOf(r8.getTimeStamp()));
        r10.put(COLUMN_EVENT_TIME_TEXT, formatBeijingTime(r8.getTimeStamp()));
        r10.put(COLUMN_FEEDBACK_TIME, Long.valueOf(r8.getFeedbackTime()));
        r10.put(COLUMN_FEEDBACK_TIME_TEXT, formatBeijingTime(r8.getFeedbackTime()));
        r10.put("poi_name", nullToEmpty(r8.getPoiName()));
        r10.put("aoi_name", nullToEmpty(r8.getAoiName()));
        r10.put("category", nullToEmpty(r8.getCategory()));
        r10.put("has_feedback", Integer.valueOf(r8.getHasFeedback() ? 1 : 0));
        r10.put(COLUMN_USER_CHOICE, Integer.valueOf(r8.getUserChoice()));
        return r10;
    }

    private static String buildPoiEventKey(PoiArrivalFeedbackInfo r8) {
        String r10 = r8.getTimeStamp() + "|" + nullToEmpty(r8.getPoiName()) + "|" + nullToEmpty(r8.getAoiName());
        return toHexString(MessageDigest.getInstance("SHA-256").digest(r10.getBytes(StandardCharsets.UTF_8)), 16);
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "buildPoiEventKey failed", e);
        return Integer.toHexString(r10.hashCode());
    }

    private static void ensureSchema(SQLiteDatabase r8) {
        HARStatusDatabaseHelper.ensureSchema(r8);
    }

    private static String formatBeijingTime(long r8) {
        if (r8 > 0) goto L7;
        return "";
    L7:
        if (r8 > 100000000000L) goto L10;
        r8 = r8 * 1000;
    L10:
        SimpleDateFormat r10 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        r10.setTimeZone(BEIJING_TIME_ZONE);
        return r10.format(new Date(r8));
    }

    private static String nullToEmpty(String r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        return r8;
    }

    private static PoiArrivalFeedbackInfo parseRecord(Cursor r8) {
        PoiArrivalFeedbackInfo r10 = new PoiArrivalFeedbackInfo();
        r10.setId(r8.getLong(r8.getColumnIndexOrThrow("_id")));
        r10.setTimeStamp(r8.getLong(r8.getColumnIndexOrThrow("event_time")));
        r10.setFeedbackTime(r8.getLong(r8.getColumnIndexOrThrow(COLUMN_FEEDBACK_TIME)));
        r10.setPoiName(r8.getString(r8.getColumnIndexOrThrow("poi_name")));
        r10.setAoiName(r8.getString(r8.getColumnIndexOrThrow("aoi_name")));
        r10.setCategory(r8.getString(r8.getColumnIndexOrThrow("category")));
        boolean r11 = true;
        if (r8.getInt(r8.getColumnIndexOrThrow("has_feedback")) == 1) goto L6;
        r11 = false;
    L6:
        r10.setHasFeedback(r11);
        r10.setUserChoice(r8.getInt(r8.getColumnIndexOrThrow(COLUMN_USER_CHOICE)));
        return r10;
    }

    private static long queryRecordId(SQLiteDatabase r10, PoiArrivalFeedbackInfo r11) {
        Cursor r12 = r10.query(TABLE_RECORDS, new String[]{"_id"}, "event_time=? AND poi_name=? AND aoi_name=? AND category=?", new String[]{String.valueOf(r11.getTimeStamp()), nullToEmpty(r11.getPoiName()), nullToEmpty(r11.getAoiName()), nullToEmpty(r11.getCategory())}, null, null, null, "1");
    L10:
        th = move-exception;
        if (r12 != null) goto L19;
    L16:
        throw th;
    L19:
        r12.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    L4:
        if (r12.moveToFirst() == false) goto L8;
        long r8 = r12.getLong(r12.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L10
        r12.close();
        return r8;
    L8:
        r12.close();
        return -1;
    }

    private void reportPoiFeedbackEvent(PoiArrivalFeedbackInfo r8, int r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L4
        r11.put("report_type", r10);     // Catch: Exception -> L4
        r11.put("poi_event_key", buildPoiEventKey(r8));     // Catch: Exception -> L4
        r11.put("event_time", r8.getTimeStamp());     // Catch: Exception -> L4
        r11.put(COLUMN_USER_CHOICE, r8.getUserChoice());     // Catch: Exception -> L4
        r11.put("poi_name", nullToEmpty(r8.getPoiName()));     // Catch: Exception -> L4
        r11.put("aoi_name", nullToEmpty(r8.getAoiName()));     // Catch: Exception -> L4
        r11.put("device_id", MatrixDidUtils.getDid());     // Catch: Exception -> L4
        ByteIOUtils.trackEvent(EVENT_POI_FEEDBACK, r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CommSenseLog.e(TAG, "reportPoiFeedbackEvent failed", e);
    }

    private static String toHexString(byte[] r8, int r10) {
        StringBuilder r11 = new StringBuilder(r10);
        int r12 = r8.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        byte r14 = r8[r13];
        if (r11.length() >= r10) goto L9;
        int r15 = r14 & 255;
        char[] r16 = HEX_ARRAY;
        r11.append(r16[r15 >>> 4]);
        r11.append(r16[r15 & 15]);
        r13 = r13 + 1;
    L9:
        return r11.toString();
    }

    private static void trimRecords(SQLiteDatabase r8) {
        r8.delete(TABLE_RECORDS, "_id NOT IN (SELECT _id FROM poi_arrival_records ORDER BY _id DESC LIMIT 500)", null);
    }

    public synchronized List<PoiArrivalFeedbackInfo> getRecords(int r12) {
        monitor-enter(this);
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L35
        SQLiteDatabase r10 = this.mDatabaseHelper.getReadableDatabase();     // Catch: RuntimeException -> L31 Throwable -> L35
        ensureSchema(r10);     // Catch: Throwable -> L24
        if (r12 <= 0) goto L8;
        String r13 = String.valueOf(r12);     // Catch: Throwable -> L24
    L9:
        Cursor r14 = r10.query(TABLE_RECORDS, null, null, null, null, null, "event_time DESC", r13);     // Catch: Throwable -> L24
    L42:
    L17:
        th = move-exception;
        if (r14 != null) goto L38;
    L23:
        throw th;     // Catch: Throwable -> L24
    L38:
        r14.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L24
        goto L23
    L11:
        if (r14.moveToNext() == false) goto L14;
        r8.add(parseRecord(r14));     // Catch: Throwable -> L17
    L14:
        r14.close();     // Catch: Throwable -> L24
        r10.close();     // Catch: RuntimeException -> L31 Throwable -> L35
    L33:
        monitor-exit(this);
        return r8;
    L8:
        r13 = null;
    L24:
        th = move-exception;
        if (r10 != null) goto L45;
    L30:
        throw th;     // Catch: RuntimeException -> L31 Throwable -> L35
    L45:
        r10.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RuntimeException -> L31 Throwable -> L35
    L31:
        e = move-exception;
        CommSenseLog.e(TAG, "getRecords failed", e);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    }

    public synchronized long insertOrGetRecord(PoiArrivalFeedbackInfo r8) {
        monitor-enter(this);
        long r10 = -1;
        SQLiteDatabase r11 = this.mDatabaseHelper.getWritableDatabase();     // Catch: Throwable -> L29 RuntimeException -> L31
        ensureSchema(r11);     // Catch: Throwable -> L22
        long r12 = r11.insertWithOnConflict(TABLE_RECORDS, null, buildInsertValues(r8), 4);     // Catch: Throwable -> L22
        if (r12 == (-1)) goto L40;
        boolean r13 = true;
    L13:
        if (r12 == (-1)) goto L46;
        r8.setId(r12);     // Catch: Throwable -> L9
        applyFeedbackFromDb(r11, r8);     // Catch: Throwable -> L9
        if (r13 == false) goto L17;
        reportPoiFeedbackEvent(r8, 0);     // Catch: Throwable -> L9
    L17:
        trimRecords(r11);     // Catch: Throwable -> L9
    L9:
        th = th;
        r10 = r12;
    L23:
        if (r11 != null) goto L42;
    L28:
        throw th;     // Catch: Throwable -> L29 RuntimeException -> L31
    L42:
        r11.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29 RuntimeException -> L31
    L46:
        r11.close();     // Catch: RuntimeException -> L20 Throwable -> L29
    L34:
        monitor-exit(this);
        return r12;
    L20:
        e = e;
        r10 = r12;
    L32:
        CommSenseLog.e(TAG, "insertOrGetRecord failed", e);     // Catch: Throwable -> L29
        r12 = r10;
        goto L34
    L40:
        r12 = queryRecordId(r11, r8);     // Catch: Throwable -> L9
        r13 = false;
    L22:
        th = th;
    L31:
        e = e;
    L29:
        th = move-exception;
        throw th;
    }

    public synchronized int updateFeedback(PoiArrivalFeedbackInfo r12, boolean r13) {
        monitor-enter(this);
    L42:
        th = move-exception;
        throw th;
    L4:
        if (r12.getId() != (-1)) goto L7;
        insertOrGetRecord(r12);     // Catch: Throwable -> L42
    L7:
        int r8 = 0;
        if (r12.getId() != (-1)) goto L11;
        monitor-exit(this);
        return 0;
    L11:
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L42
        SQLiteDatabase r11 = this.mDatabaseHelper.getWritableDatabase();     // Catch: RuntimeException -> L37 Throwable -> L42
        ensureSchema(r11);     // Catch: Throwable -> L30
        ContentValues r14 = new ContentValues();     // Catch: Throwable -> L30
        r14.put("has_feedback", 1);     // Catch: Throwable -> L30
        if (r13 == false) goto L16;
        int r15 = 1;
    L17:
        r14.put(COLUMN_USER_CHOICE, Integer.valueOf(r15));     // Catch: Throwable -> L30
        r14.put(COLUMN_FEEDBACK_TIME, Long.valueOf(r10));     // Catch: Throwable -> L30
        r14.put(COLUMN_FEEDBACK_TIME_TEXT, formatBeijingTime(r10));     // Catch: Throwable -> L30
        int r16 = r11.update(TABLE_RECORDS, r14, "_id=?", new String[]{String.valueOf(r12.getId())});     // Catch: Throwable -> L30
        if (r16 <= 0) goto L23;
        r12.setHasFeedback(true);     // Catch: Throwable -> L28
        if (r13 == false) goto L22;
        r8 = 1;
    L22:
        r12.setUserChoice(r8);     // Catch: Throwable -> L28
        r12.setFeedbackTime(r10);     // Catch: Throwable -> L28
        reportPoiFeedbackEvent(r12, 1);     // Catch: Throwable -> L28
    L45:
        r11.close();     // Catch: RuntimeException -> L26 Throwable -> L42
    L40:
        monitor-exit(this);
        return r16;
    L26:
        e = e;
        r8 = r16;
    L38:
        CommSenseLog.e(TAG, "updateFeedback failed", e);     // Catch: Throwable -> L42
        r16 = r8;
        goto L40
    L23:
        applyFeedbackFromDb(r11, r12);     // Catch: Throwable -> L28
    L28:
        th = th;
        r8 = r16;
    L31:
        if (r11 != null) goto L52;
    L36:
        throw th;     // Catch: RuntimeException -> L37 Throwable -> L42
    L52:
        r11.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RuntimeException -> L37 Throwable -> L42
        goto L36
    L16:
        r15 = 0;
    L30:
        th = th;
    L37:
        e = e;
        goto L38
    }
}
