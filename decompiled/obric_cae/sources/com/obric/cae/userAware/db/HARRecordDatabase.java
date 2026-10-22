package com.obric.cae.userAware.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.obric.cae.userAware.datacollection.HARFeedbackInfo;

/* JADX INFO: loaded from: classes2.dex */
public class HARRecordDatabase extends BaseRecordDatabase<HARFeedbackInfo> {
    public static final String COLUMN_HAR_STATUS = "har_status";
    static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS har_records (_id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp INTEGER NOT NULL, har_status TEXT NOT NULL, has_feedback INTEGER NOT NULL DEFAULT 0, is_correct INTEGER)";
    static final String DATABASE_NAME = "HARStatusRecords.db";
    static final int DATABASE_VERSION = 2;
    public static final String TABLE_RECORDS = "har_records";
    public static final String TAG = "HARRecordDatabase";

    public HARRecordDatabase(Context r8) {
        super(new HARStatusDatabaseHelper(r8), TABLE_RECORDS);
    }

    @Override // com.obric.cae.userAware.db.BaseRecordDatabase
    public String getTag() {
        return TAG;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.cae.userAware.db.BaseRecordDatabase
    public HARFeedbackInfo parseRecordFromCursor(Cursor r8) {
        HARFeedbackInfo r10 = new HARFeedbackInfo();
        r10.setId(r8.getLong(r8.getColumnIndexOrThrow("_id")));
        r10.setTimeStamp(r8.getLong(r8.getColumnIndexOrThrow("timestamp")));
        r10.setStateCode(Integer.parseInt(r8.getString(r8.getColumnIndexOrThrow(COLUMN_HAR_STATUS))));
        boolean r11 = true;
        if (r8.getInt(r8.getColumnIndexOrThrow("has_feedback")) == 1) goto L6;
        r11 = false;
    L6:
        r10.setHasFeedback(r11);
        if (r8.isNull(r8.getColumnIndexOrThrow(BaseRecordDatabase.COLUMN_IS_CORRECT)) == true) goto L9;
        int r12 = r8.getInt(r8.getColumnIndexOrThrow(BaseRecordDatabase.COLUMN_IS_CORRECT));
    L10:
        r10.setUserChoice(r12);
        return r10;
    L9:
        r12 = -1;
        goto L10
    }

    /* JADX INFO: renamed from: toContentValues, reason: avoid collision after fix types in other method */
    public ContentValues toContentValues2(HARFeedbackInfo r8) {
        ContentValues r10 = new ContentValues();
        r10.put("timestamp", Long.valueOf(r8.getTimeStamp()));
        r10.put(COLUMN_HAR_STATUS, Integer.valueOf(r8.getStateCode()));
        int r11 = 1;
        if (r8.getUserChoice() == 1) goto L6;
        r11 = 0;
    L6:
        r10.put("has_feedback", Integer.valueOf(r11));
        r10.put(BaseRecordDatabase.COLUMN_IS_CORRECT, "");
        return r10;
    }

    @Override // com.obric.cae.userAware.db.BaseRecordDatabase
    public /* bridge */ /* synthetic */ HARFeedbackInfo parseRecordFromCursor(Cursor r8) {
        return parseRecordFromCursor(r8);
    }

    @Override // com.obric.cae.userAware.db.BaseRecordDatabase
    public /* bridge */ /* synthetic */ ContentValues toContentValues(HARFeedbackInfo r8) {
        return toContentValues2(r8);
    }
}
