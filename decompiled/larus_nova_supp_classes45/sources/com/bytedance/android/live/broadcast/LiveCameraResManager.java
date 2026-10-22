package com.bytedance.android.live.broadcast;

import android.content.res.AssetManager;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final enum LiveCameraResManager extends Enum<LiveCameraResManager> {
    public static final LiveCameraResManager INST = null;
    public static final String LATEST_RES_VERSION = "0.0.23";
    public static final String a = null;
    public static final String[] b = null;
    public static final String c = null;
    public static final /* synthetic */ LiveCameraResManager[] d = null;
    public MutableLiveData<Boolean> isLoadedRes;
    private boolean isLoadingRes;
    private String lastTimeFailedReason;

    public synchronized void loadResources() {
        monitor-enter(this);
        Logger.d("LiveCameraResManager", "call loadResources");     // Catch: Throwable -> L20
        if (this.isLoadingRes == false) goto L9;
        Logger.d("LiveCameraResManager", "resources is loading, return");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L9:
        if (LATEST_RES_VERSION.equals(com.bytedance.android.livesdk.sharedpref.b.c.getValue()) == false) goto L17;
        Logger.d("LiveCameraResManager", "resources is already loaded, return");     // Catch: Throwable -> L20
        if (this.isLoadedRes.getValue() != null) goto L13;
    L14:
        Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this));     // Catch: Throwable -> L20
    L15:
        monitor-exit(this);
        return;
    L13:
        if (((Boolean) this.isLoadedRes.getValue()).booleanValue() == true) goto L15;
    L17:
        this.isLoadingRes = true;     // Catch: Throwable -> L20
        Flowable.fromCallable(new k(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this), new m(this), new n(this));     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    static {
        LiveCameraResManager r0 = new LiveCameraResManager();
        INST = r0;
        d = new LiveCameraResManager[]{r0};
        a = "roi";
        b = new String[0];
        c = s1.getContext().getDir("live_res", 0).getAbsolutePath() + File.separator;
    }

    public LiveCameraResManager() {
        super("INST", 0);
        this.isLoadingRes = false;
        this.isLoadedRes = new MutableLiveData();
    }

    public static LiveCameraResManager[] values() {
        return (LiveCameraResManager[]) d.clone();
    }

    public String getROIResPath() {
        return c + a;
    }

    public boolean isLoadedRes() {
        if (this.isLoadedRes.getValue() != null) goto L6;
        this.isLoadedRes.setValue(Boolean.valueOf(LATEST_RES_VERSION.equals(com.bytedance.android.livesdk.sharedpref.b.c.getValue())));
    L6:
        return ((Boolean) this.isLoadedRes.getValue()).booleanValue();
    }

    public static /* synthetic */ void a(LiveCameraResManager r1) {
        r1.isLoadingRes = false;
    }

    public static LiveCameraResManager valueOf(String r1) {
        return (LiveCameraResManager) r27.a.a(LiveCameraResManager.class, r1);
    }

    public static void b(LiveCameraResManager r1, Boolean r2) {
        r1.getClass();
        if (r2.booleanValue() == false) goto L5;
        r1.isLoadingRes = false;
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.c;
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, LATEST_RES_VERSION);
        r1.isLoadedRes.setValue(Boolean.TRUE);
        Logger.d("LiveCameraResManager", "all resources loaded");
        return;
    L5:
        r1.isLoadingRes = false;
        r1.isLoadedRes.setValue(Boolean.FALSE);
    }

    public static /* synthetic */ void c(LiveCameraResManager r2, Throwable r3) {
        r2.isLoadedRes.setValue(Boolean.FALSE);
        r2.isLoadingRes = false;
        r2.lastTimeFailedReason = r3.toString();
        Logger.e("LiveCameraResManager", "error occurred when load resources: " + r3.toString());
        ALogger.e("LiveCameraResManager", r3.toString());
    }

    public static void d(AssetManager r7, String r8, String r9) throws IOException {
        String[] r0 = r7.list(r8);
        if (r0.length <= 0) goto L8;
        new PolarisFileWrapper(r9).mkdirs();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L56;
        String r3 = r0[r2];
        StringBuilder r4 = new StringBuilder();
        r4.append(r8);
        String r5 = File.separator;
        r4.append(r5);
        r4.append(r3);
        d(r7, r4.toString(), r9 + r5 + r3);
        r2 = r2 + 1;
        goto L5
    L56:
        return;
    L8:
        if (TextUtils.isEmpty(r8) == true) goto L55;
        BufferedSink r6 = null;
        InputStream r11 = r7.open(r8);     // Catch: Throwable -> L33
        Source r12 = Okio.source(r11);     // Catch: Throwable -> L31
        PolarisFileWrapper r13 = new PolarisFileWrapper(r9);     // Catch: Throwable -> L29
        if (r13.exists() == false) goto L17;
        Logger.d("LiveCameraResManager", "old file found when copy res, path is " + r13.getAbsolutePath());     // Catch: Throwable -> L29
        Logger.d("LiveCameraResManager", "old file delete result: " + r13.delete());     // Catch: Throwable -> L29
    L17:
        Sink r14 = Okio.sink(r13);     // Catch: Throwable -> L29
        r6 = Okio.buffer(r14);     // Catch: Throwable -> L27
        r6.writeAll(r12);     // Catch: Throwable -> L27
        r6.flush();     // Catch: Throwable -> L27
        Logger.d("LiveCameraResManager", "1 file copied: " + r13.getAbsolutePath());     // Catch: Throwable -> L27
        r6.close();
        if (r14 == null) goto L22;
        r14.close();
    L22:
        if (r12 == null) goto L24;
        r12.close();
    L24:
        if (r11 == null) goto L54;
        r11.close();
        return;
    L54:
        return;
    L27:
        Throwable th = th;
    L36:
        if (r6 == null) goto L38;
        r6.close();
    L38:
        if (r14 == null) goto L40;
        r14.close();
    L40:
        if (r12 == null) goto L42;
        r12.close();
    L42:
        if (r11 == null) goto L44;
        r11.close();
    L44:
        throw th;
    L29:
        th = move-exception;
        th = th;
        r14 = null;
    L31:
        th = move-exception;
        th = th;
    L35:
        r12 = null;
        r14 = null;
    L33:
        th = move-exception;
        th = th;
        r11 = null;
        goto L35
    }
}
