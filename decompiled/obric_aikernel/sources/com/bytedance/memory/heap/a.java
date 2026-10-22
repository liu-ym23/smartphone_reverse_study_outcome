package com.bytedance.memory.heap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.core.MonitorSharedPreferences;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;
import p3.c;
import p3.h;
import q3.b;
import t3.k;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile a f2161e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f2163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile HeapDump f2164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile SharedPreferences f2165d;

    private a(@NonNull Context r10) {
        this.f2165d = null;
        this.f2162a = r10.getApplicationContext();
    }

    private void A(@NonNull HeapDump r10, JSONObject r11) {
        r11.put("heapDumpFilePath", r10.heapDumpFile.getPath());
        r11.put("shrinkFilePath", r10.shrinkFilePath);
        r11.put("heapDumpFileSize", r10.heapDumpFile.length());
        r11.put("referenceName", r10.referenceName);
        r11.put("isDebug", r10.isDebug);
        r11.put("gcDurationMs", r10.gcDurationMs);
        r11.put("watchDurationMs", r10.watchDurationMs);
        r11.put("dumpDurationMs", r10.heapDumpDurationMs);
        r11.put("currentTime", r10.currentTime);
    }

    @NonNull
    private HeapDump B(JSONObject r10, File r11) {
        return HeapDump.newBuilder().g(r11).c(r10.optLong("currentTime")).h(r10.optLong("heapDumpFileSize")).k(r10.optString("referenceName")).i(r10.optBoolean("isDebug")).e(r10.optLong("gcDurationMs")).m(r10.optLong("watchDurationMs")).f(r10.optLong("dumpDurationMs")).l(r10.optString("shrinkFilePath")).a();
    }

    private void b(String r10, long r11, File r12, String r13) {
        File r14 = new File(b.e().k(), "dump.hprof");
        if (r12.getPath().contains("jpg") == false) goto L5;
        r12.renameTo(r14);
    L5:
        File r15 = new File(b.e().d(), r13.replace("dump", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(r11))) + "_" + r10 + "_origin.zip");
        r3.a.e("origin_compress_begin");
        long r16 = System.currentTimeMillis();
        HashMap<String, Object> r17 = new HashMap();
        r17.put("before_hprof_compress_size", Long.valueOf(r14.length()));
        u3.a.b().c("compress_begin", r17);
        h.c(r14, r15);
        c.c("compress origin file succeed", new Object[0]);
        r3.a.g("origin_compress_time", System.currentTimeMillis() - r16);
        r3.a.e("origin_compress_end");
        r3.a.g("origin_compress_size", r15.length() / 1024);
        HashMap<String, Object> r18 = new HashMap();
        u3.a.b().h(r15.length());
        u3.a.b().c("compress_end", r18);
        if (r14.exists() == false) goto L8;
        r14.delete();
    L8:
        j().v(1);
        j().x(true);
        j().w(r15.getAbsolutePath());
    }

    private void c(String r10, long r11, File r12) {
        c.c("shrink begin with path %s, length %s ", new Object[]{r12.getPath(), Long.valueOf(r12.length())});
        File r13 = r(r12);
        if (r13 != null) goto L5;
    L14:
        c.c("shrink failed deleteCache", new Object[0]);
        u3.a.b().f("shrink_failed");
        j().d();
        return;
    L5:
        if (r13.length() < 31457280) goto L7;
    L9:
        c.c("shrink succeed", new Object[0]);
        r3.a.e("shrink_compress_begin");
        long r14 = System.currentTimeMillis();
        File r15 = h.b(r13, true);
        r3.a.g("shrink_compress_time", System.currentTimeMillis() - r14);
        r3.a.e("shrink_compress_end");
        r3.a.g("shrink_compress_size", r15.length() / 1024);
        File r16 = new File(r15.getParent(), new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(r11)) + "_" + r10 + "_shrink.zip");
        if (r15.exists() == false) goto L12;
        r15.renameTo(r16);
    L12:
        j().x(true);
        j().w(r16.getAbsolutePath());
        return;
    L7:
        if (j().i() != 2) goto L9;
        goto L9
    }

    private void e() {
        u("");
    }

    private String h() {
        return m().getString("filePath", "");
    }

    public static a j() {
        if (f2161e != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2161e != null) goto L9;
        f2161e = new a(o3.a.j().i());     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2161e;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x006c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x006c */
    @Nullable
    private HeapDump q(@NonNull String r10) {
        File r11 = new File(r10);
        FileInputStream r12 = null;
        if (r11.exists() == true) goto L6;
        e();
        return null;
    L6:
        StringBuilder r13 = new StringBuilder();
        FileInputStream r14 = new FileInputStream(r11);     // Catch: Throwable -> L16 Exception -> L18
    L42:
        int r15 = r14.read();     // Catch: Exception -> L14 Throwable -> L27
        if (r15 == (-1)) goto L11;
        r13.append((char) r15);     // Catch: Exception -> L14 Throwable -> L27
        goto L42
    L11:
        JSONObject r16 = new JSONObject(r13.toString());     // Catch: Exception -> L14 Throwable -> L27
        HeapDump r17 = B(r16, new File(r16.optString("heapDumpFilePath")));     // Catch: Exception -> L14 Throwable -> L27
        this.f2164c = r17;     // Catch: Exception -> L14 Throwable -> L27
        r14.close();     // Catch: IOException -> L32
    L13:
        return r17;
    L14:
        e = e;
    L21:
        if (r11.delete() == false) goto L23;
        c.b(e, "Could not read result file %s, deleted it.", new Object[]{r11});     // Catch: Throwable -> L27
    L24:
        if (r14 != null) goto L35;
    L26:
        return null;
    L35:
        r14.close();     // Catch: IOException -> L33
        goto L26
    L23:
        c.b(e, "Could not read result file %s, could not delete it either.", new Object[]{r11});     // Catch: Throwable -> L27
        goto L24
    L27:
        th = th;
        r12 = r2;
    L29:
        if (r12 != null) goto L39;
    L31:
        throw th;
    L39:
        r12.close();     // Catch: IOException -> L34
    L18:
        e = e;
        r14 = null;
    L16:
        th = th;
        goto L29
    }

    @Nullable
    @SuppressLint({"SimpleDateFormat"})
    @WorkerThread
    private File r(@NonNull File r10) {
    L10:
        th = move-exception;
        r3.a.e("realShrink_error");
        t4.a.d(th, "realShrink failed");
        th.printStackTrace();
        return null;
    L4:
        if (r10.exists() == false) goto L15;
        File r11 = b.e().i();     // Catch: Throwable -> L10
        if (r11.exists() == true) goto L8;
        r11.mkdirs();     // Catch: Throwable -> L10
    L8:
        return k.a(r10, new File(r11, "dump.hprof"));
    L15:
        return null;
    }

    private void t(HeapDump r10) {
        this.f2164c = r10;
    }

    private void u(String r10) {
        m().edit().putString("filePath", r10).commit();
    }

    public void C(long r10) {
        m().edit().putLong("lastDumpTime", r10).commit();
    }

    @WorkerThread
    public void a() {
        if (this.f2164c == null) goto L5;
        return;
    L5:
        String r10 = h();
        if (TextUtils.isEmpty(r10) == true) goto L9;
        HeapDump r11 = q(r10);
        c.c("cache heapdump %s", new Object[]{r11});
        t(r11);
        return;
    }

    public void d() {
        this.f2164c = null;
        b.e().c();
    }

    @Nullable
    public HeapDump f() {
        return this.f2164c;
    }

    public long g() {
        if (j().f() == null) goto L6;
        return j().f().currentTime;
    L6:
        return System.currentTimeMillis();
    }

    public int i() {
        return m().getInt("hprof_type", 1);
    }

    public long k() {
        return m().getLong("lastDumpTime", 0);
    }

    public String l() {
        return m().getString("latestFilePath", "");
    }

    @NonNull
    public SharedPreferences m() {
        if (this.f2165d != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f2165d != null) goto L8;
        this.f2165d = MonitorSharedPreferences.getSharedPreferences(this.f2162a, "MemoryWidgetSp");     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f2165d;
    }

    public String n() {
        return m().getString("updateVersionCode", "");
    }

    public boolean o() {
        return m().getBoolean("hasShrink", false);
    }

    public boolean p() {
        long r10 = m().getLong("lastDumpTime", 0);
        if ((System.currentTimeMillis() - r10) >= 28800000) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public File s(@NonNull HeapDump r10) {
        t(r10);
        File r11 = b.e().h();
        if (r11.exists() == false) goto L5;
        r11.delete();
    L5:
        c.c("analyzedHeapFile.getHeapDumpFilePath() %s", new Object[]{r11.getPath()});
        u(r11.getPath());
        JSONObject r12 = new JSONObject();
        FileOutputStream r13 = null;
        A(r10, r12);     // Catch: Throwable -> L12 Exception -> L14
        FileOutputStream r14 = new FileOutputStream(r11);     // Catch: Throwable -> L12 Exception -> L14
        r14.write(r12.toString().getBytes());     // Catch: Exception -> L10 Throwable -> L20
        r14.close();     // Catch: IOException -> L25
    L9:
        return r11;
    L10:
        e = e;
    L16:
        r3.a.e("dumpHeap_saveHeapDump_error");     // Catch: Throwable -> L20
        c.b(e, "Could not save leak analysis result to disk.", new Object[0]);     // Catch: Throwable -> L20
        if (r14 != null) goto L34;
    L19:
        return null;
    L34:
        r14.close();     // Catch: IOException -> L26
    L20:
        th = th;
        r13 = r14;
    L22:
        if (r13 != null) goto L28;
    L24:
        throw th;
    L28:
        r13.close();     // Catch: IOException -> L27
        goto L24
    L14:
        e = e;
        r14 = null;
    L12:
        th = th;
        goto L22
    }

    @SuppressLint({"ApplySharedPref"})
    public void v(int r10) {
        m().edit().putInt("hprof_type", r10).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void w(String r10) {
        m().edit().putString("latestFilePath", r10).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void x(boolean r10) {
        m().edit().putBoolean("hasShrink", r10).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void y(String r10) {
        m().edit().putString("updateVersionCode", r10).commit();
    }

    @SuppressLint({"SimpleDateFormat"})
    @WorkerThread
    public void z() {
        if (this.f2163b == false) goto L7;
        r3.a.e("shrink_error_isShrinking");
        return;
    L7:
        if (j().o() == false) goto L11;
        c.c("HeapSaver shrink hasShrinked", new Object[0]);
        com.bytedance.memory.upload.a.m();
        return;
    L11:
        if (b.e().m() == false) goto L28;
        String r10 = j().n();
        if (b.e().g().length() > 31457280) goto L15;
    L26:
        c.c("HeapSaver shrink return deleteCache. updateVersionCode:" + r10, new Object[0]);
        r3.a.e("shrink_error_dumpInvalid");
        j().d();
        u3.a.b().f("shrink_error_dumpInvalid");
        return;
    L15:
        if (TextUtils.isEmpty(r10) == true) goto L26;
        this.f2163b = true;
        Process.setThreadPriority(10);
        if (j().f() == null) goto L20;
        long r11 = j().f().currentTime;
    L21:
        File r12 = b.e().g();
        String r13 = r12.getName().substring(0, r12.getName().lastIndexOf("."));
        if (r3.a.d("memory_upload_origin") == false) goto L24;
        b(r10, r11, r12, r13);
    L25:
        b.e().b();
        this.f2163b = false;
        Process.setThreadPriority(0);
        com.bytedance.memory.upload.a.m();
        return;
    L24:
        c(r10, r11, r12);
        goto L25
    L20:
        r11 = System.currentTimeMillis();
        goto L21
    L28:
        r3.a.e("shrink_error_HeapFileNotExist");
        u3.a.b().f("shrink_error_HeapFileNotExist");
    }
}
