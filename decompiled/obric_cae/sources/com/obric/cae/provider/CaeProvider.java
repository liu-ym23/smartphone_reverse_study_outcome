package com.obric.cae.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import com.obric.cae.log.CaeLog;
import defpackage.b;

/* JADX INFO: loaded from: classes.dex */
public class CaeProvider extends ContentProvider {
    public static final String AUTHORITY = "com.cae.CaeProvider";
    public static final String BLUETOOTH_DB_NAME = "cae_bluetooth.db";
    private static final int BLUETOOTH_DB_VERSION = 2;
    public static final Uri CONTENT_URI = null;
    private static final String DB_CREATE_BLUETOOTH_A2DP_JITTER_ML = "create table if not exists bluetooth_a2dp_jitter_ml (_id INTEGER PRIMARY KEY,MAC TEXT,Remote_Device_name TEXT,Fence_location TEXT,Optimize_count INTEGER,Severe_trigger_count INTEGER,Auto_optimize_count INTEGER,Manual_disabled INTEGER,Last_optimize_time TEXT);";
    private static final String DB_CREATE_BLUETOOTH_COMPATIBILITY = "create table bluetooth_compatibility (_id INTEGER PRIMARY KEY,Module INTEGER,Profile_type INTEGER,Category INTEGER,MAC TEXT,COD INTEGER,Remote_Device_name TEXT,Detail_msg TEXT,Err_code TEXT,Err_count INTEGER,Last_happened_time TEXT,Issue_id INTEGER,Fixed INTEGER,Solution TEXT,Uploaded INTEGER,Uploaded_time TEXT);";
    private static final String DB_CREATE_BLUETOOTH_PROFILE_INFO = "create table bluetooth_profile_info (_id INTEGER PRIMARY KEY,Module INTEGER,Profile_type INTEGER,Profile_count INTEGER,MAC TEXT);";
    public static final int ITEM_BLUETOOTH_A2DP_JITTER_ML = 5;
    public static final int ITEM_BLUETOOTH_A2DP_JITTER_ML_RECORD = 6;
    public static final int ITEM_BLUETOOTH_COMPATIBILITY = 1;
    public static final int ITEM_BLUETOOTH_COMPATIBILITY_RECORD = 2;
    public static final int ITEM_BLUETOOTH_PROFILE_INFO = 3;
    public static final int ITEM_BLUETOOTH_PROFILE_INFO_RECORD = 4;
    public static final String TABLE_NAME_BLUETOOTH_A2DP_JITTER_ML = "bluetooth_a2dp_jitter_ml";
    public static final String TABLE_NAME_BLUETOOTH_COMPATIBILITY = "bluetooth_compatibility";
    public static final String TABLE_NAME_BLUETOOTH_PROFILE_INFO = "bluetooth_profile_info";
    private static final String TAG = "CaeProvider";
    private static final UriMatcher mUriMatcher = null;
    private CaeDbHelper mDbHelper;

    public static class A2dpJitterMlEntry implements BaseColumns {
        public static final String AUTO_OPTIMIZE_COUNT = "Auto_optimize_count";
        public static final String FENCE_LOCATION = "Fence_location";
        public static final String LAST_OPTIMIZE_TIME = "Last_optimize_time";
        public static final String MAC = "MAC";
        public static final String MANUAL_DISABLED = "Manual_disabled";
        public static final String OPTIMIZE_COUNT = "Optimize_count";
        public static final String REMOTE_DEVICE_NAME = "Remote_Device_name";
        public static final String SEVERE_TRIGGER_COUNT = "Severe_trigger_count";

        public A2dpJitterMlEntry() {
        }
    }

    public static class CaeDbHelper extends SQLiteOpenHelper {
        public CaeDbHelper(Context r8) {
            super(r8, CaeProvider.BLUETOOTH_DB_NAME, null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r8) {
            r8.execSQL(CaeProvider.DB_CREATE_BLUETOOTH_COMPATIBILITY);
            r8.execSQL(CaeProvider.DB_CREATE_BLUETOOTH_PROFILE_INFO);
            r8.execSQL(CaeProvider.DB_CREATE_BLUETOOTH_A2DP_JITTER_ML);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r8, int r10, int r11) {
            CaeLog.w(CaeProvider.TAG, "Database downgrade from " + r10 + " to " + r11);
            if (r10 < 2) goto L7;
            if (r11 >= 2) goto L8;
            r8.execSQL("DROP TABLE IF EXISTS bluetooth_a2dp_jitter_ml");
            return;
        L8:
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
            if (r10 >= 2) goto L6;
            r8.execSQL(CaeProvider.DB_CREATE_BLUETOOTH_A2DP_JITTER_ML);
            return;
        }
    }

    public static class CompatibilityEntry implements BaseColumns {
        public static final String CATEGORY = "Category";
        public static final String COD = "COD";
        public static final String DETAIL_MSG = "Detail_msg";
        public static final String ERR_CODE = "Err_code";
        public static final String ERR_COUNT = "Err_count";
        public static final String FIXED = "Fixed";
        public static final String ISSUE_ID = "Issue_id";
        public static final String LAST_HAPPENED_TIME = "Last_happened_time";
        public static final String MAC = "MAC";
        public static final String MODULE = "Module";
        public static final String PROFILE_TYPE = "Profile_type";
        public static final String REMOTE_DEVICE_NAME = "Remote_Device_name";
        public static final String SOLUTION = "Solution";
        public static final String UPLOADED = "Uploaded";
        public static final String UPLOADED_TIME = "Uploaded_time";

        public CompatibilityEntry() {
        }
    }

    public static class ProfileInfoEntry implements BaseColumns {
        public static final String MAC = "MAC";
        public static final String MODULE = "Module";
        public static final String PROFILE_COUNT = "Profile_count";
        public static final String PROFILE_TYPE = "Profile_type";

        public ProfileInfoEntry() {
        }
    }

    static {
        CONTENT_URI = Uri.parse("content://com.cae.CaeProvider");
        UriMatcher r8 = new UriMatcher(-1);
        mUriMatcher = r8;
        r8.addURI(AUTHORITY, TABLE_NAME_BLUETOOTH_COMPATIBILITY, 1);
        r8.addURI(AUTHORITY, "bluetooth_compatibility/#", 2);
        r8.addURI(AUTHORITY, TABLE_NAME_BLUETOOTH_PROFILE_INFO, 3);
        r8.addURI(AUTHORITY, "bluetooth_profile_info/#", 4);
        r8.addURI(AUTHORITY, TABLE_NAME_BLUETOOTH_A2DP_JITTER_ML, 5);
        r8.addURI(AUTHORITY, "bluetooth_a2dp_jitter_ml/#", 6);
    }

    public CaeProvider() {
    }

    private void checkUriValid(Uri r8) {
        switch(mUriMatcher.match(r8)) {
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return;
    L5:
        throw new IllegalArgumentException(b.b("checkUriValid,unknown uri:", r8));
    }

    private String getTableName(Uri r8) {
        switch(mUriMatcher.match(r8)) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return null;
    L5:
        return TABLE_NAME_BLUETOOTH_A2DP_JITTER_ML;
    L6:
        return TABLE_NAME_BLUETOOTH_PROFILE_INFO;
    L7:
        return TABLE_NAME_BLUETOOTH_COMPATIBILITY;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r8, String r10, String[] r11) {
        checkUriValid(r8);
        int r12 = this.mDbHelper.getWritableDatabase().delete(getTableName(r8), r10, r11);
        b.m("delete uri at: ", r12, TAG);
        if (r12 > 0) goto L5;
    L7:
        return r12;
    L5:
        if (getContext() == null) goto L7;
        getContext().getContentResolver().notifyChange(r8, null);
        goto L7
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r8) {
        switch(mUriMatcher.match(r8)) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return "vnd.android.cursor.item/bluetooth_a2dp_jitter_ml_single";
    L8:
        return "vnd.android.cursor.dir/bluetooth_a2dp_jitter_ml_multi";
    L10:
        return "vnd.android.cursor.item/bluetooth_profile_type_single";
    L12:
        return "vnd.android.cursor.dir/bluetooth_profile_type_multi";
    L14:
        return "vnd.android.cursor.item/bluetooth_compatibility_single";
    L16:
        return "vnd.android.cursor.dir/bluetooth_compatibility_multi";
    L5:
        throw new IllegalArgumentException(b.b("getType unknown uri:", r8));
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r8, ContentValues r10) {
        checkUriValid(r8);
        long r11 = this.mDbHelper.getWritableDatabase().insert(getTableName(r8), null, r10);
        if (r11 != (-1)) goto L5;
        CaeLog.d(TAG, "insert failed for " + r8 + " values: " + r10);
    L5:
        CaeLog.d(TAG, "inserted uri at: " + r11);
        Uri r12 = ContentUris.withAppendedId(r8, r11);
        if (getContext() == null) goto L8;
        getContext().getContentResolver().notifyChange(r12, null);
    L8:
        return r12;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mDbHelper = new CaeDbHelper(getContext());
        CaeLog.d(TAG, "onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r11, String[] r12, String r13, String[] r14, String r15) {
        checkUriValid(r11);
        int r8 = mUriMatcher.match(r11);
        SQLiteDatabase r10 = this.mDbHelper.getReadableDatabase();
        if (r8 == 1) goto L19;
        if (r8 == 3) goto L19;
        if (r8 == 5) goto L19;
        if (r8 != 2) goto L12;
    L17:
        long r16 = ContentUris.parseId(r11);
        return r10.query(getTableName(r11), r12, "_id=?", new String[]{r16 + ""}, null, null, r15);
    L12:
        if (r8 == 4) goto L17;
        if (r8 == 6) goto L17;
        return null;
    L19:
        return r10.query(getTableName(r11), r12, r13, r14, null, null, r15);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r8, ContentValues r10, String r11, String[] r12) {
        checkUriValid(r8);
        int r13 = this.mDbHelper.getWritableDatabase().update(getTableName(r8), r10, r11, r12);
        b.m("update uri at: ", r13, TAG);
        if (r13 > 0) goto L5;
    L7:
        return r13;
    L5:
        if (getContext() == null) goto L7;
        getContext().getContentResolver().notifyChange(r8, null);
        goto L7
    }
}
