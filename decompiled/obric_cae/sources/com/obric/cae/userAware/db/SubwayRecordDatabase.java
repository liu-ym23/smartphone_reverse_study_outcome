package com.obric.cae.userAware.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.obric.cae.userAware.datacollection.SubwayFeedbackInfo;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayRecordDatabase extends BaseRecordDatabase<SubwayFeedbackInfo> {
    public static final String COLUMN_STATION_NAME = "station_name";
    public static final String COLUMN_SUBWAY_STATUS = "subway_status";
    private static final String CREATE_TABLE = "CREATE TABLE subway_records (_id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp INTEGER NOT NULL, subway_status INTEGER NOT NULL, station_name TEXT, has_feedback INTEGER NOT NULL DEFAULT 0, is_correct INTEGER)";
    private static final String DATABASE_NAME = "SubwayStatusRecords.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_RECORDS = "subway_records";
    public static final String TAG = "SubwayRecordDatabase";

    public SubwayRecordDatabase(Context r8) {
        super(r8, DATABASE_NAME, 1, TABLE_RECORDS, CREATE_TABLE);
    }

    @Override // com.obric.cae.userAware.db.BaseRecordDatabase
    public String getTag() {
        return TAG;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.cae.userAware.db.BaseRecordDatabase
    public SubwayFeedbackInfo parseRecordFromCursor(Cursor r8) {
        SubwayFeedbackInfo r10 = new SubwayFeedbackInfo();
        r10.setId(r8.getLong(r8.getColumnIndexOrThrow("_id")));
        r10.setTimeStamp(r8.getLong(r8.getColumnIndexOrThrow("timestamp")));
        r10.setSubwayStatus(r8.getInt(r8.getColumnIndexOrThrow(COLUMN_SUBWAY_STATUS)));
        int r11 = r8.getColumnIndex(COLUMN_STATION_NAME);
        if (r11 != (-1)) goto L5;
    L7:
        boolean r12 = true;
        if (r8.getInt(r8.getColumnIndexOrThrow("has_feedback")) == 1) goto L11;
        r12 = false;
    L11:
        r10.setHasFeedback(r12);
        if (r8.isNull(r8.getColumnIndexOrThrow(BaseRecordDatabase.COLUMN_IS_CORRECT)) == true) goto L14;
        r10.setUserChoice(r8.getInt(r8.getColumnIndexOrThrow(BaseRecordDatabase.COLUMN_IS_CORRECT)));
    L15:
        return r10;
    L14:
        r10.setUserChoice(-1);
        goto L15
    L5:
        if (r8.isNull(r11) == true) goto L7;
        r10.setStationName(r8.getString(r11));
        goto L7
    }

    /* JADX INFO: renamed from: toContentValues, reason: avoid collision after fix types in other method */
    public ContentValues toContentValues2(SubwayFeedbackInfo r8) {
        ContentValues r10 = new ContentValues();
        r10.put("timestamp", Long.valueOf(r8.getTimeStamp()));
        r10.put(COLUMN_SUBWAY_STATUS, Integer.valueOf(r8.getSubwayStatus()));
        r10.put(COLUMN_STATION_NAME, r8.getStationName());
        r10.put("has_feedback", Integer.valueOf(r8.getHasFeedback() ? 1 : 0));
        if (r8.getHasFeedback() == false) goto L5;
        r10.put(BaseRecordDatabase.COLUMN_IS_CORRECT, Integer.valueOf(r8.getUserChoice()));
    L6:
        return r10;
    L5:
        r10.putNull(BaseRecordDatabase.COLUMN_IS_CORRECT);
        goto L6
    }

    @Override // com.obric.cae.userAware.db.BaseRecordDatabase
    public /* bridge */ /* synthetic */ SubwayFeedbackInfo parseRecordFromCursor(Cursor r8) {
        return parseRecordFromCursor(r8);
    }

    @Override // com.obric.cae.userAware.db.BaseRecordDatabase
    public /* bridge */ /* synthetic */ ContentValues toContentValues(SubwayFeedbackInfo r8) {
        return toContentValues2(r8);
    }
}
