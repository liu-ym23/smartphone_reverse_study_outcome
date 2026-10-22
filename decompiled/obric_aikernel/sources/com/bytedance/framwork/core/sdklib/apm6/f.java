package com.bytedance.framwork.core.sdklib.apm6;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f1928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, c> f1930c;

    class a implements Comparator<String> {
        a(f r10) {
        }

        public int a(String r10, String r11) {
            return String.CASE_INSENSITIVE_ORDER.compare(r10, r11);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(String r10, String r11) {
            return a(r10, r11);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f1931a = null;

        static {
            f1931a = new f(null);
        }

        static /* synthetic */ f a() {
            return f1931a;
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f1933b;

        public c(int r10, long r11) {
            this.f1932a = r10;
            this.f1933b = r11;
        }

        static /* synthetic */ int a(c r10) {
            return r10.f1932a;
        }

        static /* synthetic */ long b(c r10) {
            return r10.f1933b;
        }

        public static c e(String r10) {
            String[] r11 = r10.split("_");     // Catch: Exception -> L8
            if (r11.length != 2) goto L7;
            return new c(Integer.parseInt(r11[0]), Long.parseLong(r11[1]));
        L7:
            return new c(0, 0);
        L8:
            e = move-exception;
            j3.c.c("APM-SDK", "parseRetryMessage " + r10, e);
            return null;
        }

        public int c() {
            return this.f1932a;
        }

        public String d() {
            return this.f1932a + "_" + this.f1933b;
        }

        void f(int r10, long r11) {
            this.f1932a = r10;
            this.f1933b = r11;
        }
    }

    private f() {
        this.f1930c = new ConcurrentHashMap();
    }

    /* synthetic */ f(a r10) {
        this();
    }

    private synchronized void b() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f1929b == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f1928a = j.c().getSharedPreferences("sdk_log_report_message", 0);     // Catch: Throwable -> L10
        this.f1929b = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    static f c() {
        return b.a();
    }

    @SuppressLint({"ApplySharedPref"})
    synchronized void a(File r10) {
        monitor-enter(this);
        if (r10 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        b();     // Catch: Throwable -> L9
        FileUtils.deleteFile(r10);     // Catch: Throwable -> L9
        this.f1930c.remove(r10.getName());     // Catch: Throwable -> L9
        SharedPreferences.Editor r11 = this.f1928a.edit();     // Catch: Throwable -> L9
        r11.remove(r10.getName());     // Catch: Throwable -> L9
        r11.commit();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    c d(File r10) {
        c r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        b();
        String r12 = r10.getName();
        if (this.f1930c.containsKey(r12) == false) goto L10;
        return this.f1930c.get(r12);
    L10:
        if (this.f1928a.contains(r12) == false) goto L16;
        String r13 = this.f1928a.getString(r12, "");
        if (TextUtils.isEmpty(r13) == true) goto L14;
        r11 = c.e(r13);
    L14:
        if (r11 == null) goto L16;
        this.f1930c.put(r12, r11);
    L16:
        return r11;
    }

    synchronized File e() {
        monitor-enter(this);
        File r10 = com.bytedance.framwork.core.sdklib.apm6.a.d();     // Catch: Throwable -> L40
        File r11 = null;
        if (r10 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        String[] r12 = r10.list();     // Catch: Throwable -> L40
        if (r12 != null) goto L11;
    L38:
        monitor-exit(this);
        return null;
    L11:
        if (r12.length == 0) goto L38;
        List r13 = Arrays.asList(r12);     // Catch: Throwable -> L40
        Collections.sort(r13, new a(this));     // Catch: Throwable -> L40
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L40
        c r15 = null;
    L14:
        if (r14.hasNext() == false) goto L36;
        File r16 = new File(r10, (String) r14.next());     // Catch: Throwable -> L40
        c r17 = d(r16);     // Catch: Throwable -> L40
        if (r17 == null) goto L35;
        if (j.f() == false) goto L23;
        j3.c.a("APM-SDK", "list send file:" + r16.getName() + " " + c.a(r17) + " " + c.b(r17) + " " + System.currentTimeMillis());     // Catch: Throwable -> L40
    L23:
        if (c.a(r17) > LogReportController.getInstance().getMaxRetryCount()) goto L24;
        if (c.a(r17) == 0) goto L35;
        if (c.b(r17) < System.currentTimeMillis()) goto L35;
        if (r15 == null) goto L34;
        if (c.b(r15) <= c.b(r17)) goto L14;
    L34:
        r15 = r17;
        r11 = r16;
        goto L14
    L24:
        a(r16);     // Catch: Throwable -> L40
        j3.c.b("APM-SDK", "retry count reached top");     // Catch: Throwable -> L40
    L35:
        r11 = r16;
    L36:
        monitor-exit(this);
        return r11;
    L40:
        th = move-exception;
        throw th;
    }

    synchronized boolean f(byte[] r10, int r11, long r12) {
        monitor-enter(this);
        b();     // Catch: Throwable -> L24
        if (com.bytedance.framwork.core.sdklib.apm6.a.d() != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        File r13 = new File(com.bytedance.framwork.core.sdklib.apm6.a.d(), String.format("%d%s%s%s", new Object[]{Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), ".log"}));     // Catch: Throwable -> L24
        FileChannel r14 = null;
        g(r13, r11, r12);     // Catch: Throwable -> L16
        r14 = new FileOutputStream(r13).getChannel();     // Catch: Throwable -> L16
        r14.write(ByteBuffer.wrap(r10));     // Catch: Throwable -> L16
        if (j.f() == false) goto L13;
        j3.c.a("APM-SDK", "saveFile:" + r13.getName());     // Catch: Throwable -> L16
    L13:
        IOUtils.closeQuietly(r14);     // Catch: Throwable -> L24
        monitor-exit(this);
        return true;
    L16:
        th = move-exception;
        j3.c.c("APM-SDK", "saveFile:" + r13.getName(), th);     // Catch: Throwable -> L21
        IOUtils.closeQuietly(r14);     // Catch: Throwable -> L24
        return false;
    L21:
        th = move-exception;
        IOUtils.closeQuietly(r14);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    void g(File r10, int r11, long r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        b();
        SharedPreferences.Editor r13 = this.f1928a.edit();
        String r14 = r10.getName();
        if (this.f1930c.containsKey(r14) == false) goto L7;
        c r15 = this.f1930c.get(r14);
    L8:
        r15.f(r11, r12);
        r13.putString(r14, r15.d());
        r13.commit();
        return;
    L7:
        c r16 = new c(r11, r12);
        this.f1930c.put(r14, r16);
        r15 = r16;
        goto L8
    }
}
