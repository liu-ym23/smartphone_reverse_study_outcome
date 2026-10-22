package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.IOUtils;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f2606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f2607b;

    public i(File r8, File r9) {
        this.f2606a = r9;
        this.f2607b = new RandomAccessFile(r8, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 262160);     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
    L8:
        if (this.f2607b != null) goto L10;
        this.f2607b = ByteBuffer.allocate(262160);
    L10:
        c();
        return;
    L5:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        goto L8
    }

    private void a(int r2) {
        this.f2607b.putInt(8, r2);
    }

    static /* synthetic */ boolean a(i r0, File r1) {
        return r0.a(r1);
    }

    private boolean a(File r6) {
        String r5 = r6.getName();
        boolean r7 = false;
        int r0 = r5.indexOf("_");     // Catch: Exception -> L12
        if (r0 == (-1)) goto L9;
        if ((System.currentTimeMillis() - Long.parseLong(r5.substring(0, r0))) < WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS) goto L9;
        r7 = true;
    L9:
        if (j.d() == false) goto L11;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "fileName:" + r5 + " " + r7);     // Catch: Exception -> L12
    L11:
        return r7;
    }

    private void b(int r2) {
        this.f2607b.putInt(12, r2);
    }

    private void c() {
        this.f2607b.clear();
        this.f2607b.putInt(1095781686);
        this.f2607b.putInt(1);
        this.f2607b.putInt(0);
        this.f2607b.putInt(0);
    }

    private int d() {
        return this.f2607b.getInt(0);
    }

    private int e() {
        return this.f2607b.getInt(4);
    }

    private int f() {
        return this.f2607b.getInt(8);
    }

    private int g() {
        return this.f2607b.getInt(12);
    }

    private void h() {
        this.f2607b.position(g() + 16);
        this.f2607b.flip();
        b r2 = b.a(this.f2607b);
        if (j.d() == false) goto L5;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "flush to memory success. logFile=" + r2);
    L5:
        d.a().a(r2);
    }

    public synchronized void a() {
        monitor-enter(this);
        int r0 = d();     // Catch: Throwable -> L51
        int r1 = e();     // Catch: Throwable -> L51
        int r2 = f();     // Catch: Throwable -> L51
        int r3 = g();     // Catch: Throwable -> L51
        if (r0 != 1095781686) goto L46;
        if (r3 <= 0) goto L46;
        if (r2 <= 0) goto L46;
        if (j.d() == false) goto L11;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "flushing: magicNumber=" + r0 + " version=" + r1 + " totalCount=" + r2 + " totalBytes=" + r3);     // Catch: Throwable -> L51
    L11:
        long r4 = System.nanoTime();     // Catch: Throwable -> L51
        FileChannel r5 = null;
        boolean r6 = false;
        String r7 = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();     // Catch: Throwable -> L35
    L21:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "flushDir create error.", th);     // Catch: Throwable -> L35
    L23:
        File r8 = new File(this.f2606a, r7 + ".tmp");     // Catch: Throwable -> L35
        if (r8.exists() == false) goto L26;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.c("APM-SDK", "file is exist:" + r8.getName());     // Catch: Throwable -> L35
    L26:
        r5 = new FileOutputStream(r8, false).getChannel();     // Catch: Throwable -> L35
        this.f2607b.position(r3 + 16);     // Catch: Throwable -> L35
        this.f2607b.flip();     // Catch: Throwable -> L35
        r5.write(this.f2607b);     // Catch: Throwable -> L35
        File r9 = new File(this.f2606a, r7 + ".log");     // Catch: Throwable -> L35
        if (r8.renameTo(r9) == false) goto L29;
        r6 = true;
    L31:
        if (j.d() == false) goto L33;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "flush to file success. flushFile=" + r9.getAbsolutePath());     // Catch: Throwable -> L35
    L33:
        IOUtils.closeQuietly(r5);     // Catch: Throwable -> L51
        if (r6 == true) goto L40;
        h();     // Catch: Throwable -> L51
    L40:
        c();     // Catch: Throwable -> L51
        if (j.d() == false) goto L43;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "flush cost=" + (System.nanoTime() - r4));     // Catch: Throwable -> L51
    L43:
        monitor-exit(this);
        return;
    L29:
        com.bytedance.framwork.core.sdklib.apm6.safety.c.c("APM-SDK", "rename error" + r8.getAbsolutePath());     // Catch: Throwable -> L35
        goto L31
    L15:
        if (this.f2606a.exists() == true) goto L23;
        File r10 = this.f2606a.getParentFile();     // Catch: Throwable -> L21
        if (r10.exists() == true) goto L19;
        r10.mkdirs();     // Catch: Throwable -> L21
    L19:
        this.f2606a.mkdirs();     // Catch: Throwable -> L21
    L35:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", this.f2606a.exists() + " flush to file failed.", th);     // Catch: Throwable -> L54
    L46:
        if (j.d() == false) goto L48;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "flushing: Skipped. no data to flush. reset buffer now.");     // Catch: Throwable -> L51
    L48:
        c();     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L51:
        th = move-exception;
        throw th;
    }

    public synchronized void a(long r5, long r7, JSONObject r9) {
        monitor-enter(this);
        if (r9 != null) goto L30;
        monitor-exit(this);
        return;
    L30:
        String r10 = r9.toString();     // Catch: Throwable -> L27
        byte[] r0 = r10.getBytes();     // Catch: Throwable -> L27
        int r1 = (r0.length + 4) + 16;     // Catch: Throwable -> L27
        if (r1 <= 262144) goto L15;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.b("APM-SDK", "LogItem " + r10 + " is too large. please check it.");     // Catch: Throwable -> L27
        if (j.d() == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        throw new RuntimeException("LogItem is too large. please check it.");     // Catch: Throwable -> L27
    L15:
        if (r1 <= this.f2607b.remaining()) goto L17;
        a();     // Catch: Throwable -> L27
    L17:
        this.f2607b.putInt(r0.length);     // Catch: Throwable -> L27
        this.f2607b.putLong(r5);     // Catch: Throwable -> L27
        this.f2607b.putLong(r7);     // Catch: Throwable -> L27
        this.f2607b.put(r0);     // Catch: Throwable -> L27
        a(f() + 1);     // Catch: Throwable -> L27
        b(g() + r1);     // Catch: Throwable -> L27
        if (j.d() == false) goto L21;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", String.format("push success: totalCount=%s, totalBytes=%s, logItem=%s,", new Object[]{Integer.valueOf(f()), Integer.valueOf(g()), r10}));     // Catch: Throwable -> L27
    L21:
        if (this.f2607b.position() < 131072) goto L23;
    L24:
        a();     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return;
    L23:
        if (f() < 100) goto L25;
    L27:
        th = move-exception;
        throw th;
    }

    public synchronized List<File> b() {
        monitor-enter(this);
        File r0 = this.f2606a;     // Catch: Throwable -> L25
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        File[] r1 = r0.listFiles(new AnonymousClass1(this));     // Catch: Throwable -> L25
        if (r1 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L25
        int r3 = r1.length;     // Catch: Throwable -> L25
        int r4 = 0;
        int r5 = 0;
    L13:
        if (r5 >= r3) goto L15;
        r2.add(r1[r5].getName());     // Catch: Throwable -> L25
        r5 = r5 + 1;     // Catch: Throwable -> L25
        goto L13
    L15:
        Collections.sort(r2, new AnonymousClass2(this));     // Catch: Throwable -> L25
        if (j.d() == false) goto L18;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "reportFile: parsing " + r2.size() + " files. fileNameList" + r2);     // Catch: Throwable -> L25
    L18:
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L25
    L19:
        if (r4 >= r2.size()) goto L23;
        r6.add(new File(this.f2606a, (String) ZeusTransformUtils.preCheckCast(r2.get(r4), String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L25
        r4 = r4 + 1;
        goto L19
    L23:
        monitor-exit(this);
        return r6;
    L25:
        th = move-exception;
        throw th;
    }
}
