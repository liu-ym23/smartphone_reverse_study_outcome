package com.obric.cae.BWDL.BwdlDrop.provider;

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
public class BwdlDropProvider extends ContentProvider {
    public static final String AUTHORITY = "com.cae.BwdlDropProvider";
    public static final String BWDL_DROP_DB_NAME = "bwdl_drop.db";
    public static final Uri BWDL_DROP_URI = null;
    public static final Uri CONTENT_URI = null;
    private static final String DB_CREATE_BWDL_DROP = "create table bwdl_drop (_id INTEGER PRIMARY KEY,Uri TEXT,File_Name TEXT,Mime_Type TEXT,Total_Size INTEGER,Position INTEGER,Timestamp INTEGER,MAC TEXT,Remote_Device_name TEXT,Direction INTEGER,Status INTEGER);";
    private static final int DB_VERSION = 1;
    public static final int ITEM_BWDL_DROP = 1;
    public static final int ITEM_BWDL_DROP_RECORD = 2;
    public static final String TABLE_NAME_BWDL_DROP = "bwdl_drop";
    private static final String TAG = "BwdlDropProvider";
    private static final UriMatcher mUriMatcher = null;
    private BwdlDropDbHelper mDbHelper;

    public static class BwdlDropDbEntry {
        public int Direction;
        public String File_Name;
        public String MAC;
        public String Mime_Type;
        public long Position;
        public String Remote_Device_name;
        public int Status;
        public long Timestamp;
        public long Total_Size;
        public String Uri;

        public BwdlDropDbEntry() {
        }
    }

    public static class BwdlDropDbHelper extends SQLiteOpenHelper {
        public BwdlDropDbHelper(Context r8) {
            super(r8, BwdlDropProvider.BWDL_DROP_DB_NAME, null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r8) {
            r8.execSQL(BwdlDropProvider.DB_CREATE_BWDL_DROP);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
        }
    }

    public static class BwdlDropEntry implements BaseColumns {
        public static final String DIRECTION = "Direction";
        public static final String FILE_NAME = "File_Name";
        public static final String MAC = "MAC";
        public static final String MIME_TYPE = "Mime_Type";
        public static final String POSITION = "Position";
        public static final String REMOTE_DEVICE_NAME = "Remote_Device_name";
        public static final String STATUS = "Status";
        public static final String TIMESTAMP = "Timestamp";
        public static final String TOTAL_SIZE = "Total_Size";
        public static final String URI = "Uri";

        public BwdlDropEntry() {
        }
    }

    static {
        Uri r8 = Uri.parse("content://com.cae.BwdlDropProvider");
        CONTENT_URI = r8;
        BWDL_DROP_URI = Uri.parse(r8 + "/bwdl_drop");
        UriMatcher r10 = new UriMatcher(-1);
        mUriMatcher = r10;
        r10.addURI(AUTHORITY, TABLE_NAME_BWDL_DROP, 1);
        r10.addURI(AUTHORITY, "bwdl_drop/#", 2);
    }

    public BwdlDropProvider() {
    }

    private void checkUriValid(Uri r8) {
        int r10 = mUriMatcher.match(r8);
        if (r10 != 1) goto L5;
        return;
    L5:
        if (r10 != 2) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(b.b("checkUriValid,unknown uri:", r8));
    }

    private String getTableName(Uri r8) {
        int r10 = mUriMatcher.match(r8);
        if (r10 != 1) goto L5;
    L7:
        return TABLE_NAME_BWDL_DROP;
    L5:
        if (r10 == 2) goto L7;
        return null;
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
        int r10 = mUriMatcher.match(r8);
        if (r10 != 1) goto L5;
        return "vnd.android.cursor.dir/bwdl_drop_multi";
    L5:
        if (r10 != 2) goto L9;
        return "vnd.android.cursor.item/bwdl_drop_single";
    L9:
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
        this.mDbHelper = new BwdlDropDbHelper(getContext());
        CaeLog.d(TAG, "onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r11, String[] r12, String r13, String[] r14, String r15) {
        checkUriValid(r11);
        int r8 = mUriMatcher.match(r11);
        SQLiteDatabase r10 = this.mDbHelper.getReadableDatabase();
        if (r8 != 1) goto L6;
        return r10.query(getTableName(r11), r12, r13, r14, null, null, r15);
    L6:
        if (r8 != 2) goto L8;
        long r16 = ContentUris.parseId(r11);
        return r10.query(getTableName(r11), r12, "_id=?", new String[]{r16 + ""}, null, null, r15);
    L8:
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r8, ContentValues r10, String r11, String[] r12) {
        checkUriValid(r8);
        int r13 = this.mDbHelper.getWritableDatabase().update(getTableName(r8), r10, r11, r12);
        b.m("Number of uri has updated:", r13, TAG);
        if (r13 > 0) goto L5;
    L7:
        return r13;
    L5:
        if (getContext() == null) goto L7;
        getContext().getContentResolver().notifyChange(r8, null);
        goto L7
    }
}
