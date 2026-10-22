package com.obric.cae.smartBluetooth.storage.carkey;

import android.content.Context;
import androidx.room.q;
import androidx.room.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class CarkeyRoomDatabase extends r {
    private static volatile CarkeyRoomDatabase sInstance;

    public CarkeyRoomDatabase() {
    }

    public static CarkeyRoomDatabase getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(CarkeyRoomDatabase.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        r.a r10 = q.a(r8.getApplicationContext(), CarkeyRoomDatabase.class, "carkey_room.db");     // Catch: Throwable -> L11
        r10.f2674l = false;     // Catch: Throwable -> L11
        r10.f2675m = true;     // Catch: Throwable -> L11
        sInstance = (CarkeyRoomDatabase) r10.b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CarkeyRoomDatabase.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public abstract CarkeyAppInfoDao carkeyAppInfoDao();
}
