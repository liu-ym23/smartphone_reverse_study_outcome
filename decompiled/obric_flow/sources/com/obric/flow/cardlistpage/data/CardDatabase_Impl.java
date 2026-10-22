package com.obric.flow.cardlistpage.data;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class CardDatabase_Impl extends CardDatabase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile h f11466b;

    public CardDatabase_Impl() {
    }

    public static /* synthetic */ List b(CardDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List c(CardDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List d(CardDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List e(CardDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List f(CardDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List g(CardDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List h(CardDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ void i(CardDatabase_Impl r5, SupportSQLiteDatabase r10) {
        r5.mDatabase = r10;
    }

    public static /* synthetic */ List j(CardDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List k(CardDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    @Override // com.obric.flow.cardlistpage.data.CardDatabase
    public final a a() {
        if (this.f11466b != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f11466b != null) goto L12;
        this.f11466b = new h(this);     // Catch: Throwable -> L10
    L12:
        h r5 = this.f11466b;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r5;
    L5:
        return this.f11466b;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r5 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r5.execSQL("DELETE FROM `cards`");     // Catch: Throwable -> L8
        r5.execSQL("DELETE FROM `id_sequence`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r5.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r5.inTransaction() == true) goto L15;
        r5.execSQL("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r5.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r5.inTransaction() == true) goto L12;
        r5.execSQL("VACUUM");
    L12:
        throw th;
    }

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"cards", "id_sequence"});
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r10 = new RoomOpenHelper(r5, new i(this), "e46b5dadaa2d321229f1fdcef7b733be", "3ca4b7be78f5f7590d2fb75b70a908f6");
        SupportSQLiteOpenHelper.Configuration r11 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r10).build();
        return r5.sqliteOpenHelperFactory.create(r11);
    }

    @Override // androidx.room.RoomDatabase
    public final List getAutoMigrations(Map r5) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public final Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final Map getRequiredTypeConverters() {
        HashMap r5 = new HashMap();
        r5.put(a.class, Collections.emptyList());
        return r5;
    }
}
