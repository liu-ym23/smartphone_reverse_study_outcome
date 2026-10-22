package com.obric.sva.sdk.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class SvaSdkDatabase_Impl extends SvaSdkDatabase {
    private volatile VoicePrintDao _voicePrintDao;

    @Override // com.obric.sva.sdk.db.SvaSdkDatabase
    public VoicePrintDao VoicePrintDao() {
        if (this._voicePrintDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._voicePrintDao != null) goto L10;
        this._voicePrintDao = new VoicePrintDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        VoicePrintDao r0 = this._voicePrintDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._voicePrintDao;
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `sva_voice_print`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L15;
        r2.execSQL("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L12;
        r2.execSQL("VACUUM");
    L12:
        throw th;
    }

    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"sva_voice_print"});
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r0 = new HashMap();
        r0.put(VoicePrintDao.class, VoicePrintDao_Impl.getRequiredConverters());
        return r0;
    }

    public SvaSdkDatabase_Impl() {
    }

    public static /* synthetic */ List access$000(SvaSdkDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List access$100(SvaSdkDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List access$1000(SvaSdkDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List access$200(SvaSdkDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List access$300(SvaSdkDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List access$400(SvaSdkDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List access$500(SvaSdkDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List access$800(SvaSdkDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List access$900(SvaSdkDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        final int r2 = 2;
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new AnonymousClass1(this, r2), "5997d8a19b2ff40e61fb8918aaebb981", "4cb388f15698c2ba5bba887f1741a7c7");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r1) {
        return Arrays.asList(new Migration[0]);
    }

    public static /* synthetic */ SupportSQLiteDatabase access$602(SvaSdkDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
        return r1;
    }

    public static /* synthetic */ void access$700(SvaSdkDatabase_Impl r0, SupportSQLiteDatabase r1) {
        r0.internalInitInvalidationTracker(r1);
    }
}
