package com.obric.cae.log;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.alog.Alog;
import com.obric.cae.smartNetwork.networkRateLimit.TrafficControlConfig;
import defpackage.c;
import fd.a;
import fd.d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class ALogger {
    private static final String ALOG_DIR_NAME = "/logs/";
    private static final String TAG = "ALogger-CAE";
    private File mALogFile;
    private final AtomicBoolean mInitSucceed;

    public ALogger() {
        this.mInitSucceed = new AtomicBoolean(false);
    }

    private void checkOrCreateALogFile() {
        File r8 = this.mALogFile;
        if (r8 != null) goto L5;
    L6:
        String r10 = a.f7381b.f7412f;
        Log.i(TAG, "checkOrCreateALogFile path===." + r10);
        File r11 = new File(r10);
        if (r11.exists() == true) goto L24;
        r11.mkdirs();
        a.HandlerC0074a r12 = a.f7387h;
        if (r12 == null) goto L11;
        r12.sendEmptyMessage(2);
    L11:
        Alog r13 = c.f3213r;
        if (r13 == null) goto L14;
        r13.a();
    L14:
        Alog r14 = a.f7384e;
        if (r14 == null) goto L17;
        r14.a();
    L17:
        Iterator<WeakReference<Alog>> r15 = a.f7385f.iterator();
    L19:
        if (r15.hasNext() == false) goto L23;
        Alog r16 = r15.next().get();
        if (r16 == null) goto L19;
        r16.a();
        goto L19
    L23:
        Log.d(TAG, "create new ALog file.");
    L24:
        this.mALogFile = r11;
        Log.i(TAG, "checkOrCreateALogFile mALogFile===." + this.mALogFile);
        return;
    L5:
        if (r8.exists() == false) goto L6;
    }

    private String getLogPath(Context r8) {
        File r10 = r8.getExternalFilesDir(ALOG_DIR_NAME);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getAbsolutePath();
    }

    public void changeDebugLevel(int r8) {
        a.f7380a = r8;
        int r10 = r8 - 2;
        Alog r11 = c.f3213r;
        if (r11 == null) goto L5;
        r11.d(r10);
    L5:
        Alog r12 = a.f7384e;
        if (r12 == null) goto L9;
        r12.d(r10);
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public void d(String r8, String r10) {
        a.c(r8, r10);
    }

    @SuppressLint({"LogTagMismatch"})
    public void e(String r8, String r10) {
        a.d(r8, r10);
    }

    @SuppressLint({"LogTagMismatch"})
    public void i(String r8, String r10) {
        a.f(r8, r10);
    }

    public void init(Context r10) {
        Log.i(TAG, "init ALog.");
        if (TextUtils.isEmpty(getLogPath(r10)) == false) goto L6;
        Log.e(TAG, "get log path is null!!!");
        this.mInitSucceed.set(false);
        return;
    L6:
        d.a r8 = new d.a(r10);
        r8.f7421b = getLogPath(r10);
        r8.f7424e = true;
        r8.f7422c = true;
        r8.f7423d = true;
        d r11 = new d();
        Context r12 = r8.f7420a;
        r11.f7407a = r12;
        r11.f7408b = 14;
        r11.f7409c = 20971520;
        r11.f7410d = TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
        String r13 = null;
        if (TextUtils.isEmpty(null) == false) goto L14;
        File r14 = r12.getFilesDir();
        if (r14 == null) goto L14;
        File r15 = new File(r14.getAbsolutePath(), "ALOG");
        if (r15.exists() == true) goto L13;
        r15.mkdir();
    L13:
        r13 = r15.getAbsolutePath();
    L14:
        r11.f7411e = r13;
        if (TextUtils.isEmpty(r8.f7421b) == false) goto L20;
        File r16 = new File(r12.getFilesDir(), "logs");
        if (r16.exists() == true) goto L19;
        r16.mkdir();
    L19:
        String r17 = r16.getAbsolutePath();
    L21:
        r11.f7412f = r17;
        r11.f7413g = r8.f7422c;
        r11.f7414h = r8.f7423d;
        r11.f7415i = 3;
        r11.f7416j = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
        r11.f7417k = true;
        r11.f7418l = r8.f7424e;
        r11.f7419m = false;
        a.f7382c = true;
        boolean r18 = a.f7382c;
        Alog r19 = c.f3213r;
        if (r19 == null) goto L24;
        r19.e(r18);
    L24:
        Alog r20 = a.f7384e;
        if (r20 == null) goto L27;
        r20.e(a.f7382c);
    L27:
        boolean r21 = a.g(r11);
        this.mInitSucceed.set(r21);
        Log.i(TAG, "init ALog " + r21);
        checkOrCreateALogFile();
        return;
    L20:
        r17 = r8.f7421b;
        goto L21
    }

    public boolean initSucceed() {
        return this.mInitSucceed.get();
    }

    @SuppressLint({"LogTagMismatch"})
    public void v(String r8, String r10) {
        a.i(r8, r10);
    }

    @SuppressLint({"LogTagMismatch"})
    public void w(String r8, String r10) {
        a.j(r8, r10);
    }

    @SuppressLint({"LogTagMismatch"})
    public void e(String r8, String r10, Throwable r11) {
        a.e(r8, r10, r11);
    }
}
