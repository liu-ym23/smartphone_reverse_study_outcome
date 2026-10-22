package com.bytedance.memory.upload;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class MemoryUploadService extends Service {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile MemoryUploadService f2167c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f2168g;

    public MemoryUploadService() {
    }

    public static Intent a(Context r10) {
        Log.i("guozhimemory", "MemoryUploadService createStartIntent");
        return new Intent(r10, MemoryUploadService.class);
    }

    public static MemoryUploadService b() {
        return f2167c;
    }

    public void c() {
        Log.i("guozhimemory", "MemoryUploadService stopService " + f2168g);
        stopSelf();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent r10) {
        Log.i("guozhimemory", "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.i("guozhimemory", "MemoryUploadService onCreate");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.i("guozhimemory", "onDestroy");
        Thread.sleep(2000);     // Catch: InterruptedException -> L6
    L4:
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        Log.i("guozhimemory", "MemoryUploadService onStartCommand " + f2168g);
        f2167c = this;
        f2168g = r12;
        return 1;
    }
}
