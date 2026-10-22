package com.obric.cae.smartBluetooth.storage.carkey;

import a1.b;
import a1.c;
import android.content.Context;
import androidx.room.i;
import androidx.room.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import x0.a;

/* JADX INFO: loaded from: classes.dex */
public final class CarkeyRoomDatabase_Impl extends CarkeyRoomDatabase {
    private volatile CarkeyAppInfoDao _carkeyAppInfoDao;

    public CarkeyRoomDatabase_Impl() {
    }

    public static /* synthetic */ List access$000(CarkeyRoomDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    public static /* synthetic */ List access$100(CarkeyRoomDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    public static /* synthetic */ b access$202(CarkeyRoomDatabase_Impl r8, b r10) {
        r8.mDatabase = r10;
        return r10;
    }

    public static /* synthetic */ void access$300(CarkeyRoomDatabase_Impl r8, b r10) {
        r8.internalInitInvalidationTracker(r10);
    }

    public static /* synthetic */ List access$400(CarkeyRoomDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    @Override // com.obric.cae.smartBluetooth.storage.carkey.CarkeyRoomDatabase
    public CarkeyAppInfoDao carkeyAppInfoDao() {
        if (this._carkeyAppInfoDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._carkeyAppInfoDao != null) goto L10;
        this._carkeyAppInfoDao = new CarkeyAppInfoDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CarkeyAppInfoDao r8 = this._carkeyAppInfoDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r8;
    L5:
        return this._carkeyAppInfoDao;
    }

    @Override // androidx.room.r
    public void clearAllTables() {
        super.assertNotMainThread();
        b r8 = super.getOpenHelper().Z();
        super.beginTransaction();     // Catch: Throwable -> L8
        r8.e("DELETE FROM `carkey_app_info`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r8.a0("PRAGMA wal_checkpoint(FULL)").close();
        if (r8.j0() == true) goto L15;
        r8.e("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r8.a0("PRAGMA wal_checkpoint(FULL)").close();
        if (r8.j0() == true) goto L12;
        r8.e("VACUUM");
    L12:
        throw th;
    }

    @Override // androidx.room.r
    public i createInvalidationTracker() {
        return new i(this, new HashMap(0), new HashMap(0), new String[]{"carkey_app_info"});
    }

    @Override // androidx.room.r
    public c createOpenHelper(androidx.room.c r8) {
        final int r10 = 1;
        s r11 = new s(r8, new AnonymousClass1(this, r10), "6847b79894d2ba03eb57bc88f3a68632", "4e249a2c5615f58061623586ea929f8b");
        Context r12 = r8.f2602a;
        he.i.f(r12, "context");
        c.b.a r13 = new c.b.a(r12);
        r13.f23b = r8.f2603b;
        r13.f24c = r11;
        c.b r14 = r13.a();
        return r8.f2604c.a(r14);
    }

    @Override // androidx.room.r
    public List<a> getAutoMigrations(Map<Class<Object>, Object> r8) {
        return new ArrayList();
    }

    @Override // androidx.room.r
    public Set<Class<Object>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.r
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r8 = new HashMap();
        r8.put(CarkeyAppInfoDao.class, CarkeyAppInfoDao_Impl.getRequiredConverters());
        return r8;
    }
}
