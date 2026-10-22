package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f1947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f1948b;

    class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f1949a;

        a(i r10) {
            this.f1949a = r10;
        }

        @Override // java.io.FileFilter
        public boolean accept(File r10) {
            String r11 = r10.getName();
            if (i.a(this.f1949a, r10) == false) goto L7;
            FileUtils.deleteFile(r10);
            return false;
        L7:
            if (r11.endsWith(".log") == false) goto L10;
            return true;
        L10:
            r11.endsWith(".tmp");
            return false;
        }
    }

    class b implements Comparator<String> {
        b(i r10) {
        }

        public int a(String r10, String r11) {
            return String.CASE_INSENSITIVE_ORDER.compare(r10, r11);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(String r10, String r11) {
            return a(r10, r11);
        }
    }

    public i(File r10, File r11) {
        this.f1947a = r11;
        this.f1948b = new RandomAccessFile(r10, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 262160);     // Catch: Throwable -> L5
        b();     // Catch: Throwable -> L5
    L8:
        if (this.f1948b != null) goto L10;
        this.f1948b = ByteBuffer.allocate(262160);
    L10:
        k();
        return;
    L5:
        th = move-exception;
        j3.c.c("APM-SDK", "create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        goto L8
    }

    static /* synthetic */ boolean a(i r10, File r11) {
        return r10.h(r11);
    }

    private void c() {
        this.f1948b.position(e() + 16);
        this.f1948b.flip();
        com.bytedance.framwork.core.sdklib.apm6.b r10 = com.bytedance.framwork.core.sdklib.apm6.b.b(this.f1948b);
        if (j.f() == false) goto L5;
        j3.c.a("APM-SDK", "flush to memory success. logFile=" + r10);
    L5:
        d.c().h(r10);
    }

    private int d() {
        return this.f1948b.getInt(0);
    }

    private int e() {
        return this.f1948b.getInt(12);
    }

    private int f() {
        return this.f1948b.getInt(8);
    }

    private int g() {
        return this.f1948b.getInt(4);
    }

    private boolean h(File r10) {
        String r11 = r10.getName();
        boolean r12 = false;
        int r13 = r11.indexOf("_");     // Catch: Exception -> L12
        if (r13 == (-1)) goto L9;
        if ((System.currentTimeMillis() - Long.parseLong(r11.substring(0, r13))) < 604800000) goto L9;
        r12 = true;
    L9:
        if (j.f() == false) goto L11;
        j3.c.a("APM-SDK", "fileName:" + r11 + " " + r12);     // Catch: Exception -> L12
    L11:
        return r12;
    }

    private void k() {
        this.f1948b.clear();
        this.f1948b.putInt(1095781686);
        this.f1948b.putInt(1);
        this.f1948b.putInt(0);
        this.f1948b.putInt(0);
    }

    private void l(int r10) {
        this.f1948b.putInt(12, r10);
    }

    private void m(int r10) {
        this.f1948b.putInt(8, r10);
    }

    public synchronized void b() {
        monitor-enter(this);
        int r10 = d();     // Catch: Throwable -> L51
        int r11 = g();     // Catch: Throwable -> L51
        int r12 = f();     // Catch: Throwable -> L51
        int r13 = e();     // Catch: Throwable -> L51
        if (r10 != 1095781686) goto L46;
        if (r13 <= 0) goto L46;
        if (r12 <= 0) goto L46;
        if (j.f() == false) goto L11;
        j3.c.a("APM-SDK", "flushing: magicNumber=" + r10 + " version=" + r11 + " totalCount=" + r12 + " totalBytes=" + r13);     // Catch: Throwable -> L51
    L11:
        long r14 = System.nanoTime();     // Catch: Throwable -> L51
        FileChannel r15 = null;
        boolean r16 = false;
        String r17 = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();     // Catch: Throwable -> L35
    L21:
        th = move-exception;
        j3.c.c("APM-SDK", "flushDir create error.", th);     // Catch: Throwable -> L35
    L23:
        File r18 = new File(this.f1947a, r17 + ".tmp");     // Catch: Throwable -> L35
        if (r18.exists() == false) goto L26;
        j3.c.b("APM-SDK", "file is exist:" + r18.getName());     // Catch: Throwable -> L35
    L26:
        r15 = new FileOutputStream(r18, false).getChannel();     // Catch: Throwable -> L35
        this.f1948b.position(r13 + 16);     // Catch: Throwable -> L35
        this.f1948b.flip();     // Catch: Throwable -> L35
        r15.write(this.f1948b);     // Catch: Throwable -> L35
        File r19 = new File(this.f1947a, r17 + ".log");     // Catch: Throwable -> L35
        if (r18.renameTo(r19) == false) goto L29;
        r16 = true;
    L31:
        if (j.f() == false) goto L33;
        j3.c.a("APM-SDK", "flush to file success. flushFile=" + r19.getAbsolutePath());     // Catch: Throwable -> L35
    L33:
        IOUtils.closeQuietly(r15);     // Catch: Throwable -> L51
        if (r16 == true) goto L40;
        c();     // Catch: Throwable -> L51
    L40:
        k();     // Catch: Throwable -> L51
        if (j.f() == false) goto L43;
        j3.c.a("APM-SDK", "flush cost=" + (System.nanoTime() - r14));     // Catch: Throwable -> L51
    L43:
        monitor-exit(this);
        return;
    L29:
        j3.c.b("APM-SDK", "rename error" + r18.getAbsolutePath());     // Catch: Throwable -> L35
        goto L31
    L15:
        if (this.f1947a.exists() == true) goto L23;
        File r20 = this.f1947a.getParentFile();     // Catch: Throwable -> L21
        if (r20.exists() == true) goto L19;
        r20.mkdirs();     // Catch: Throwable -> L21
    L19:
        this.f1947a.mkdirs();     // Catch: Throwable -> L21
    L35:
        th = move-exception;
        j3.c.c("APM-SDK", this.f1947a.exists() + " flush to file failed.", th);     // Catch: Throwable -> L54
    L46:
        if (j.f() == false) goto L48;
        j3.c.a("APM-SDK", "flushing: Skipped. no data to flush. reset buffer now.");     // Catch: Throwable -> L51
    L48:
        k();     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L51:
        th = move-exception;
        throw th;
    }

    public synchronized List<File> i() {
        monitor-enter(this);
        File r10 = this.f1947a;     // Catch: Throwable -> L25
        if (r10 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        File[] r11 = r10.listFiles(new a(this));     // Catch: Throwable -> L25
        if (r11 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L25
        int r13 = r11.length;     // Catch: Throwable -> L25
        int r14 = 0;
        int r15 = 0;
    L13:
        if (r15 >= r13) goto L15;
        r12.add(r11[r15].getName());     // Catch: Throwable -> L25
        r15 = r15 + 1;     // Catch: Throwable -> L25
        goto L13
    L15:
        Collections.sort(r12, new b(this));     // Catch: Throwable -> L25
        if (j.f() == false) goto L18;
        j3.c.a("APM-SDK", "reportFile: parsing " + r12.size() + " files. fileNameList" + r12);     // Catch: Throwable -> L25
    L18:
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L25
    L19:
        if (r14 >= r12.size()) goto L23;
        r16.add(new File(this.f1947a, (String) r12.get(r14)));     // Catch: Throwable -> L25
        r14 = r14 + 1;
        goto L19
    L23:
        monitor-exit(this);
        return r16;
    L25:
        th = move-exception;
        throw th;
    }

    public synchronized void j(long r10, long r11, JSONObject r12) {
        monitor-enter(this);
        if (r12 != null) goto L30;
        monitor-exit(this);
        return;
    L30:
        String r13 = r12.toString();     // Catch: Throwable -> L27
        byte[] r14 = r13.getBytes();     // Catch: Throwable -> L27
        int r15 = (r14.length + 4) + 16;     // Catch: Throwable -> L27
        if (r15 <= 262144) goto L15;
        j3.c.f("APM-SDK", "LogItem " + r13 + " is too large. please check it.");     // Catch: Throwable -> L27
        if (j.f() == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        throw new RuntimeException("LogItem is too large. please check it.");     // Catch: Throwable -> L27
    L15:
        if (r15 <= this.f1948b.remaining()) goto L17;
        b();     // Catch: Throwable -> L27
    L17:
        this.f1948b.putInt(r14.length);     // Catch: Throwable -> L27
        this.f1948b.putLong(r10);     // Catch: Throwable -> L27
        this.f1948b.putLong(r11);     // Catch: Throwable -> L27
        this.f1948b.put(r14);     // Catch: Throwable -> L27
        m(f() + 1);     // Catch: Throwable -> L27
        l(e() + r15);     // Catch: Throwable -> L27
        if (j.f() == false) goto L21;
        j3.c.a("APM-SDK", String.format("push success: totalCount=%s, totalBytes=%s, logItem=%s,", new Object[]{Integer.valueOf(f()), Integer.valueOf(e()), r13}));     // Catch: Throwable -> L27
    L21:
        if (this.f1948b.position() < 131072) goto L23;
    L24:
        b();     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return;
    L23:
        if (f() < 100) goto L25;
    L27:
        th = move-exception;
        throw th;
    }
}
