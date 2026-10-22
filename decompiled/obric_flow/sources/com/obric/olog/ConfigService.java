package com.obric.olog;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;
import bb.b;

/* JADX INFO: loaded from: classes3.dex */
public class ConfigService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f11907a;

    public ConfigService() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r5) {
        getApplicationContext();
        Log.d("ConfigService", "onBind");
        return this.f11907a.getBinder();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.d("olog ConfigService", "onCreate");
        Context r5 = getApplicationContext();
        b r10 = new b();
        r10.f894b = r5;
        this.f11907a = new Messenger(r10);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Log.d("olog ConfigService", "onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent r5) {
        Log.d("olog ConfigService", "onUnbind");
        return super.onUnbind(r5);
    }
}
