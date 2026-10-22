package com.obric.cae.smartBluetooth.storage.carkey;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.r;
import androidx.room.m;
import com.obric.cae.location.geosdk.bytedance.a;
import com.obric.cae.location.geosdk.bytedance.b;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import s1.g;
import s1.x;

/* JADX INFO: loaded from: classes.dex */
public class CarkeyAppRepository {
    private static volatile CarkeyAppRepository sInstance;
    private final CarkeyAppInfoDao mDao;
    private final ExecutorService mIoExecutor;
    private final Handler mMainHandler;

    public interface ResultCallback<T> {
        void onError(Throwable r8);

        void onSuccess(T r8);
    }

    private CarkeyAppRepository(CarkeyAppInfoDao r8) {
        this.mDao = r8;
        this.mIoExecutor = Executors.newSingleThreadExecutor();
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ void a(ResultCallback r8, Throwable r10) {
        lambda$submit$4(r8, r10);
    }

    public static /* synthetic */ CarkeyAppInfo b(CarkeyAppRepository r8, String r10) {
        return r8.lambda$getByAppNameAsync$2(r10);
    }

    public static /* synthetic */ Void c(CarkeyAppRepository r8, CarkeyAppInfo r10) {
        return r8.lambda$deleteAsync$1(r10);
    }

    public static /* synthetic */ void d(CarkeyAppRepository r8, Callable r10, ResultCallback r11) {
        r8.lambda$submit$5(r10, r11);
    }

    public static /* synthetic */ Void e(CarkeyAppRepository r8, CarkeyAppInfo r10) {
        return r8.lambda$upsertAsync$0(r10);
    }

    public static /* synthetic */ void f(ResultCallback r8, Object r10) {
        lambda$submit$3(r8, r10);
    }

    public static CarkeyAppRepository getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(CarkeyAppRepository.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CarkeyAppRepository(CarkeyRoomDatabase.getInstance(r8).carkeyAppInfoDao());     // Catch: Throwable -> L11
    L9:
        monitor-exit(CarkeyAppRepository.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private /* synthetic */ Void lambda$deleteAsync$1(CarkeyAppInfo r8) {
        this.mDao.delete(r8);
        return null;
    }

    private /* synthetic */ CarkeyAppInfo lambda$getByAppNameAsync$2(String r8) {
        return this.mDao.getByAppName(r8);
    }

    private static /* synthetic */ void lambda$submit$3(ResultCallback r8, Object r10) {
        r8.onSuccess(r10);
    }

    private static /* synthetic */ void lambda$submit$4(ResultCallback r8, Throwable r10) {
        r8.onError(r10);
    }

    private /* synthetic */ void lambda$submit$5(Callable r8, ResultCallback r10) {
        Object r11 = r8.call();     // Catch: Throwable -> L6
        if (r10 == null) goto L12;
        this.mMainHandler.post(new x(6, r10, r11));     // Catch: Throwable -> L6
        return;
    L12:
        return;
    L6:
        th = move-exception;
        if (r10 == null) goto L13;
        this.mMainHandler.post(new r(16, r10, th));
        return;
    }

    private /* synthetic */ Void lambda$upsertAsync$0(CarkeyAppInfo r8) {
        this.mDao.upsert(r8);
        return null;
    }

    private <T> void submit(Callable<T> r8, ResultCallback<T> r10) {
        this.mIoExecutor.execute(new m(this, r8, r10, 4));
    }

    public void deleteAsync(CarkeyAppInfo r8, ResultCallback<Void> r10) {
        submit(new a(2, this, r8), r10);
    }

    public void deleteSync(CarkeyAppInfo r8) {
        this.mDao.delete(r8);
    }

    public void getAllAsync(ResultCallback<List<CarkeyAppInfo>> r8) {
        CarkeyAppInfoDao r10 = this.mDao;
        Objects.requireNonNull(r10);
        submit(new g(r10, 3), r8);
    }

    public List<CarkeyAppInfo> getAllSync() {
        return this.mDao.getAll();
    }

    public void getByAppNameAsync(String r8, ResultCallback<CarkeyAppInfo> r10) {
        submit(new a(3, this, r8), r10);
    }

    public CarkeyAppInfo getByAppNameSync(String r8) {
        return this.mDao.getByAppName(r8);
    }

    public void upsertAsync(CarkeyAppInfo r8, ResultCallback<Void> r10) {
        submit(new b(2, this, r8), r10);
    }

    public void upsertSync(CarkeyAppInfo r8) {
        this.mDao.upsert(r8);
    }
}
