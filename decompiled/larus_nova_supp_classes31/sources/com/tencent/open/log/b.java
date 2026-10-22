package com.tencent.open.log;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.open.utils.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class b {
    private static SimpleDateFormat a;
    private String b;
    private int c;
    private int d;
    private int e;
    private long f;
    private File g;
    private int h;
    private String i;
    private long j;

    static {
        a = d.C0053d.a("yy.MM.dd.HH");
    }

    public File[] a() {
        return d(System.currentTimeMillis());
    }

    public File b() {
        File r0 = e();
        if (r0 == null) goto L5;
        r0.mkdirs();
    L5:
        return r0;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    public File e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public static String a(long r1) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r1);
        return new SimpleDateFormat("yy.MM.dd.HH").format(r0.getTime());
    }

    private String c(String r3) {
        return "com.tencent.mobileqq_connectSdk." + r3 + ".log";
    }

    private File[] d(long r5) {
        File r1 = b();
        String r6 = c(a(r5));
        r1 = new PolarisFileWrapper(r1, r6);     // Catch: Throwable -> L5
    L7:
        String r7 = m.b();
        if (TextUtils.isEmpty(r7) == false) goto L20;
        if (r7 != null) goto L20;
    L17:
        PolarisFileWrapper r8 = null;
    L19:
        return new File[]{r1, r8};
    L20:
        PolarisFileWrapper r2 = new PolarisFileWrapper(r7, c.o);     // Catch: Exception -> L15
        if (r2.exists() == true) goto L13;
        r2.mkdirs();     // Catch: Exception -> L15
    L13:
        r8 = new PolarisFileWrapper(r2, r6);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e);
    L5:
        th = move-exception;
        SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
        goto L7
    }

    public void b(int r1) {
        this.d = r1;
    }

    public void a(int r1) {
        this.c = r1;
    }

    public void b(long r1) {
        this.f = r1;
    }

    public void c(int r1) {
        this.e = r1;
    }

    public void d(int r1) {
        this.h = r1;
    }

    public void a(File r1) {
        this.g = r1;
    }

    public void b(String r1) {
        this.i = r1;
    }

    public void c(long r1) {
        this.j = r1;
    }

    public void a(String r1) {
        this.b = r1;
    }

    public b(File r3, int r4, int r5, int r6, String r7, long r8, int r10, String r11, long r12) {
        this.b = "Tracer.File";
        this.c = Integer.MAX_VALUE;
        this.d = Integer.MAX_VALUE;
        this.e = 4096;
        this.f = 10000;
        this.h = 10;
        this.i = ".log";
        this.j = Long.MAX_VALUE;
        a(r3);
        b(r4);
        a(r5);
        c(r6);
        a(r7);
        b(r8);
        d(r10);
        b(r11);
        c(r12);
    }
}
