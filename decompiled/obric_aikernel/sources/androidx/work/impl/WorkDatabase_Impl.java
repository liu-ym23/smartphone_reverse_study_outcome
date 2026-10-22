package androidx.work.impl;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.RawWorkInfoDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    private volatile DependencyDao _dependencyDao;
    private volatile PreferenceDao _preferenceDao;
    private volatile RawWorkInfoDao _rawWorkInfoDao;
    private volatile SystemIdInfoDao _systemIdInfoDao;
    private volatile WorkNameDao _workNameDao;
    private volatile WorkProgressDao _workProgressDao;
    private volatile WorkSpecDao _workSpecDao;
    private volatile WorkTagDao _workTagDao;

    public WorkDatabase_Impl() {
    }

    static /* synthetic */ List access$000(WorkDatabase_Impl r10) {
        return r10.mCallbacks;
    }

    static /* synthetic */ List access$100(WorkDatabase_Impl r10) {
        return r10.mCallbacks;
    }

    static /* synthetic */ List access$1000(WorkDatabase_Impl r10) {
        return r10.mCallbacks;
    }

    static /* synthetic */ List access$200(WorkDatabase_Impl r10) {
        return r10.mCallbacks;
    }

    static /* synthetic */ List access$300(WorkDatabase_Impl r10) {
        return r10.mCallbacks;
    }

    static /* synthetic */ List access$400(WorkDatabase_Impl r10) {
        return r10.mCallbacks;
    }

    static /* synthetic */ List access$500(WorkDatabase_Impl r10) {
        return r10.mCallbacks;
    }

    static /* synthetic */ SupportSQLiteDatabase access$602(WorkDatabase_Impl r10, SupportSQLiteDatabase r11) {
        r10.mDatabase = r11;
        return r11;
    }

    static /* synthetic */ void access$700(WorkDatabase_Impl r10, SupportSQLiteDatabase r11) {
        r10.internalInitInvalidationTracker(r11);
    }

    static /* synthetic */ List access$800(WorkDatabase_Impl r10) {
        return r10.mCallbacks;
    }

    static /* synthetic */ List access$900(WorkDatabase_Impl r10) {
        return r10.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r10 = super.getOpenHelper().getWritableDatabase();
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L28;
    L9:
        super.beginTransaction();     // Catch: Throwable -> L20
        if (r11 == false) goto L12;
        r10.execSQL("PRAGMA defer_foreign_keys = TRUE");     // Catch: Throwable -> L20
    L12:
        r10.execSQL("DELETE FROM `Dependency`");     // Catch: Throwable -> L20
        r10.execSQL("DELETE FROM `WorkSpec`");     // Catch: Throwable -> L20
        r10.execSQL("DELETE FROM `WorkTag`");     // Catch: Throwable -> L20
        r10.execSQL("DELETE FROM `SystemIdInfo`");     // Catch: Throwable -> L20
        r10.execSQL("DELETE FROM `WorkName`");     // Catch: Throwable -> L20
        r10.execSQL("DELETE FROM `WorkProgress`");     // Catch: Throwable -> L20
        r10.execSQL("DELETE FROM `Preference`");     // Catch: Throwable -> L20
        super.setTransactionSuccessful();     // Catch: Throwable -> L20
        super.endTransaction();
        if (r11 == true) goto L16;
        r10.execSQL("PRAGMA foreign_keys = TRUE");
    L16:
        r10.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r10.inTransaction() == true) goto L30;
        r10.execSQL("VACUUM");
        return;
    L30:
        return;
    L20:
        th = move-exception;
        super.endTransaction();
        if (r11 == true) goto L24;
        r10.execSQL("PRAGMA foreign_keys = TRUE");
    L24:
        r10.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r10.inTransaction() == true) goto L27;
        r10.execSQL("VACUUM");
    L27:
        throw th;
    L28:
        r10.execSQL("PRAGMA foreign_keys = FALSE");     // Catch: Throwable -> L20
        goto L9
    L5:
        r11 = false;
        goto L7
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference"});
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r10) {
        final int r11 = 16;
        RoomOpenHelper r12 = new RoomOpenHelper(r10, new AnonymousClass1(this, r11), "5181942b9ebc31ce68dacb56c16fd79f", "ae2044fb577e65ee8bb576ca48a2f06e");
        SupportSQLiteOpenHelper.Configuration r13 = SupportSQLiteOpenHelper.Configuration.builder(r10.context).name(r10.name).callback(r12).build();
        return r10.sqliteOpenHelperFactory.create(r13);
    }

    @Override // androidx.work.impl.WorkDatabase
    public DependencyDao dependencyDao() {
        if (this._dependencyDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._dependencyDao != null) goto L10;
        this._dependencyDao = new DependencyDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        DependencyDao r10 = this._dependencyDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r10;
    L5:
        return this._dependencyDao;
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r10) {
        return Arrays.asList(new Migration[]{new WorkDatabase_AutoMigration_13_14_Impl(), new WorkDatabase_AutoMigration_14_15_Impl()});
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r10 = new HashMap();
        r10.put(WorkSpecDao.class, WorkSpecDao_Impl.getRequiredConverters());
        r10.put(DependencyDao.class, DependencyDao_Impl.getRequiredConverters());
        r10.put(WorkTagDao.class, WorkTagDao_Impl.getRequiredConverters());
        r10.put(SystemIdInfoDao.class, SystemIdInfoDao_Impl.getRequiredConverters());
        r10.put(WorkNameDao.class, WorkNameDao_Impl.getRequiredConverters());
        r10.put(WorkProgressDao.class, WorkProgressDao_Impl.getRequiredConverters());
        r10.put(PreferenceDao.class, PreferenceDao_Impl.getRequiredConverters());
        r10.put(RawWorkInfoDao.class, RawWorkInfoDao_Impl.getRequiredConverters());
        return r10;
    }

    @Override // androidx.work.impl.WorkDatabase
    public PreferenceDao preferenceDao() {
        if (this._preferenceDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._preferenceDao != null) goto L10;
        this._preferenceDao = new PreferenceDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PreferenceDao r10 = this._preferenceDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r10;
    L5:
        return this._preferenceDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public RawWorkInfoDao rawWorkInfoDao() {
        if (this._rawWorkInfoDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._rawWorkInfoDao != null) goto L10;
        this._rawWorkInfoDao = new RawWorkInfoDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        RawWorkInfoDao r10 = this._rawWorkInfoDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r10;
    L5:
        return this._rawWorkInfoDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public SystemIdInfoDao systemIdInfoDao() {
        if (this._systemIdInfoDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._systemIdInfoDao != null) goto L10;
        this._systemIdInfoDao = new SystemIdInfoDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        SystemIdInfoDao r10 = this._systemIdInfoDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r10;
    L5:
        return this._systemIdInfoDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkNameDao workNameDao() {
        if (this._workNameDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._workNameDao != null) goto L10;
        this._workNameDao = new WorkNameDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        WorkNameDao r10 = this._workNameDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r10;
    L5:
        return this._workNameDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkProgressDao workProgressDao() {
        if (this._workProgressDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._workProgressDao != null) goto L10;
        this._workProgressDao = new WorkProgressDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        WorkProgressDao r10 = this._workProgressDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r10;
    L5:
        return this._workProgressDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkSpecDao workSpecDao() {
        if (this._workSpecDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._workSpecDao != null) goto L10;
        this._workSpecDao = new WorkSpecDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        WorkSpecDao r10 = this._workSpecDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r10;
    L5:
        return this._workSpecDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkTagDao workTagDao() {
        if (this._workTagDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._workTagDao != null) goto L10;
        this._workTagDao = new WorkTagDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        WorkTagDao r10 = this._workTagDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r10;
    L5:
        return this._workTagDao;
    }
}
