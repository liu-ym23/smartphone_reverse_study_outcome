package com.obric.cae.softap;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public final class CaeSoftApExportService extends Service {
    private CaeSoftApService mBinder;

    public CaeSoftApExportService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mBinder = new CaeSoftApService(this);
    }
}
