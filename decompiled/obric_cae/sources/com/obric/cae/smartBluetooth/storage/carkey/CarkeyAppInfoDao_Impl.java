package com.obric.cae.smartBluetooth.storage.carkey;

import android.database.Cursor;
import androidx.room.e;
import androidx.room.f;
import androidx.room.r;
import androidx.room.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y0.a;
import y0.b;

/* JADX INFO: loaded from: classes.dex */
public final class CarkeyAppInfoDao_Impl implements CarkeyAppInfoDao {
    private final r __db;
    private final e<CarkeyAppInfo> __deletionAdapterOfCarkeyAppInfo;
    private final f<CarkeyAppInfo> __insertionAdapterOfCarkeyAppInfo;

    public CarkeyAppInfoDao_Impl(final r r8) {
        this.__db = r8;
        this.__insertionAdapterOfCarkeyAppInfo = new AnonymousClass1(this, r8);
        this.__deletionAdapterOfCarkeyAppInfo = new AnonymousClass2(this, r8);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppInfoDao
    public void delete(CarkeyAppInfo r8) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfCarkeyAppInfo.handle(r8);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppInfoDao
    public List<CarkeyAppInfo> getAll() {
        t r8 = t.k(0, "SELECT * FROM carkey_app_info");
        this.__db.assertNotSuspendingTransaction();
        Cursor r10 = b.b(this.__db, r8, false);
        int r11 = a.b(r10, "appName");     // Catch: Throwable -> L18
        int r12 = a.b(r10, "addressList");     // Catch: Throwable -> L18
        ArrayList r13 = new ArrayList(r10.getCount());     // Catch: Throwable -> L18
    L4:
        if (r10.moveToNext() == false) goto L16;
        String r14 = null;
        if (r10.isNull(r11) == false) goto L9;
        String r15 = null;
    L11:
        if (r10.isNull(r12) == true) goto L14;
        r14 = r10.getString(r12);     // Catch: Throwable -> L18
    L14:
        r13.add(new CarkeyAppInfo(r15, CarkeyTypeConverters.toStringList(r14)));     // Catch: Throwable -> L18
        goto L4
    L9:
        r15 = r10.getString(r11);     // Catch: Throwable -> L18
        goto L11
    L16:
        r10.close();
        r8.n();
        return r13;
    L18:
        th = move-exception;
        r10.close();
        r8.n();
        throw th;
    }

    @Override // com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppInfoDao
    public CarkeyAppInfo getByAppName(String r8) {
        t r10 = t.k(1, "SELECT * FROM carkey_app_info WHERE appName = ? LIMIT 1");
        if (r8 != null) goto L5;
        r10.g0(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = b.b(this.__db, r10, false);
        int r12 = a.b(r11, "appName");     // Catch: Throwable -> L20
        int r13 = a.b(r11, "addressList");     // Catch: Throwable -> L20
        CarkeyAppInfo r14 = null;
        String r15 = null;
        if (r11.moveToFirst() == true) goto L10;
    L18:
        r11.close();
        r10.n();
        return r14;
    L10:
        if (r11.isNull(r12) == false) goto L12;
        String r16 = null;
    L14:
        if (r11.isNull(r13) == true) goto L17;
        r15 = r11.getString(r13);     // Catch: Throwable -> L20
    L17:
        r14 = new CarkeyAppInfo(r16, CarkeyTypeConverters.toStringList(r15));     // Catch: Throwable -> L20
        goto L18
    L12:
        r16 = r11.getString(r12);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r11.close();
        r10.n();
        throw th;
    L5:
        r10.R(1, r8);
        goto L6
    }

    @Override // com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppInfoDao
    public void upsert(CarkeyAppInfo r8) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfCarkeyAppInfo.insert(r8);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
