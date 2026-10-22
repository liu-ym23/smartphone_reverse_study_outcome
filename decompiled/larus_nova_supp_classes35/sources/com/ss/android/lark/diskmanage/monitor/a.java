package com.ss.android.lark.diskmanage.monitor;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.apm.ApmAgent;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.diskmanage.monitor.settings.DiskMonitorConfig;
import com.ss.android.lark.diskmanage.monitor.settings.MonitorGlobalConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.suite.lark.component.protocol.Biz;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public boolean a;
    public boolean b;
    public long c;
    public long d;
    public long e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public long k;
    public long l;
    public long m;
    public long n;
    public boolean o;
    public final List<C0191a> p;
    public b<C0191a> q;
    public b<C0191a> r;
    public final com.ss.android.lark.storage.kv.repo.a s;

    /* JADX INFO: renamed from: com.ss.android.lark.diskmanage.monitor.a$a, reason: collision with other inner class name */
    public class C0191a implements Comparable {
        public final String a;
        public final long b;
        public final long c;

        @Override // java.lang.Comparable
        public final int compareTo(Object r5) {
            long r0 = this.b;
            long r2 = ((C0191a) r5).b;
            if (r0 != r2) goto L7;
            return 0;
        L7:
            if (r0 <= r2) goto L10;
            return 1;
        L10:
            return -1;
        }

        public C0191a(String r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    public class b<E extends Comparable> {
        public final PriorityQueue<E> a;
        public final int b;

        public b(int r3) {
            if (r3 <= 0) goto L7;
            this.b = r3;
            this.a = new PriorityQueue(r3, new com.ss.android.lark.diskmanage.monitor.b());
            return;
        L7:
            throw new IllegalStateException();
        }

        public final void a(C0191a r3) {
            if (this.a.size() >= this.b) goto L6;
            this.a.add(r3);
            return;
        L6:
            if (r3.compareTo(this.a.peek()) <= 0) goto L10;
            this.a.poll();
            this.a.add(r3);
            return;
        }
    }

    public final void b() {
        Iterator r0 = ((ArrayList) this.p).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        C0191a r1 = (C0191a) r0.next();
        if (r1.c == 2) goto L4;
        if (TextUtils.equals(r1.a, this.h) == true) goto L10;
        if (TextUtils.equals(r1.a, this.j) == false) goto L4;
        this.n = r1.b;
        goto L4
    L10:
        this.m = r1.b;
        goto L4
    }

    public a() {
        this.b = true;
        this.c = 629145600;
        this.d = 20971520;
        this.e = 52428800;
        this.f = 50;
        this.p = new ArrayList();
        this.s = LarkKVStorage.j(Biz.Performance, false);
    }

    public final String d(String r3) {
        if (r3.contains(this.g) == false) goto L6;
        return r3.replace(this.g, "internal");
    L6:
        if (r3.contains(this.i) == true) goto L8;
        return r3;
    L8:
        return r3.replace(this.i, "external");
    }

    public final void f(Context r14) {
        if (this.a == false) goto L6;
        Log.i("StorageMetricsHandler", "Storage metric have done within the current period");
        return;
    L6:
        long r6 = System.currentTimeMillis() - this.s.getLong("lark_check_disk_last_time", 0);
        if (r6 < 86400000) goto L9;
    L11:
        String r0 = this.s.getString("key_storage_monitor_setting", BuildConfig.FLAVOR);
        Log.i("StorageMetricsHandler", "settingJson = " + r0);
        DiskMonitorConfig r1 = (DiskMonitorConfig) JSON.parseObject(r0, DiskMonitorConfig.class);     // Catch: Exception -> L19
        if (r1 != null) goto L15;
        Log.i("StorageMetricsHandler", "parseConfig return null ");     // Catch: Exception -> L19
        this.a = true;     // Catch: Exception -> L19
    L25:
        if (this.a == false) goto L29;
        Log.i("StorageMetricsHandler", "Storage metric have done within the current period");
        return;
    L29:
        if (this.g != null) goto L42;
        this.g = r14.getFilesDir().getParent();     // Catch: Exception -> L39
        this.h = r14.getCacheDir().getAbsolutePath();     // Catch: Exception -> L39
        File r2 = r14.getExternalFilesDir(null);     // Catch: Exception -> L39
        if (r2 == null) goto L34;
        this.i = r2.getParent();     // Catch: Exception -> L39
    L34:
        File r3 = r14.getExternalCacheDir();     // Catch: Exception -> L39
        if (r3 == null) goto L37;
        this.j = r3.getAbsolutePath();     // Catch: Exception -> L39
    L37:
        this.q = new b(this.f);     // Catch: Exception -> L39
        this.r = new b(this.f);     // Catch: Exception -> L39
    L39:
        e = move-exception;
        Log.e("StorageMetricsHandlerparseConfig return initPaths", e, true);
        this.o = true;
    L42:
        if (this.o == false) goto L51;
        Log.i("StorageMetricsHandler", "parseConfig return mInitException ");
        this.a = true;
        return;
    L51:
        Log.i("StorageMetricsHandler", "CollectStorageMetrics start");     // Catch: Throwable -> L47
        PolarisFileWrapper r4 = new PolarisFileWrapper(this.g);     // Catch: Throwable -> L47
        PolarisFileWrapper r5 = new PolarisFileWrapper(this.i);     // Catch: Throwable -> L47
        this.k = c(r4, 0);     // Catch: Throwable -> L47
        this.l = c(r5, 0);     // Catch: Throwable -> L47
        b();     // Catch: Throwable -> L47
        e(this.l + this.k, this.n + this.m, Environment.getRootDirectory().getTotalSpace() + Environment.getDataDirectory().getTotalSpace(), Environment.getDataDirectory().getFreeSpace());     // Catch: Throwable -> L47
        this.s.putLong("lark_check_disk_last_time", System.currentTimeMillis());     // Catch: Throwable -> L47
        Log.i("StorageMetricsHandler", "CollectStorageMetrics end");     // Catch: Throwable -> L47
    L49:
        this.a = true;
        return;
    L47:
        th = move-exception;
        Log.e("StorageMetricsHandlerCollectStorageMetrics error!", th, true);
        goto L49
    L15:
        MonitorGlobalConfig r7 = r1.getGlobalConfig();     // Catch: Exception -> L19
        if (r7 == null) goto L22;
        this.b = r7.getDumpSwitch();     // Catch: Exception -> L19
        this.c = (r7.getDumpThreshold() * 1024) * 1024;     // Catch: Exception -> L19
        this.d = (r7.getAbnormalFileSize() * 1024) * 1024;     // Catch: Exception -> L19
        this.e = (r7.getAbnormalFolderSize() * 1024) * 1024;     // Catch: Exception -> L19
        this.f = r7.getDumpTopCount();     // Catch: Exception -> L19
    L22:
        if (this.b == true) goto L25;
        Log.i("StorageMetricsHandler", "parseConfig return mDiskSwitch ");
        this.a = true;
    L19:
        e = move-exception;
        Log.e("StorageMetricsHandlerparse DiskMonitorConfig fail. ", e, true);
        goto L22
    L9:
        if (r6 <= 0) goto L11;
        this.a = true;
        goto L25
    }

    public final long c(File r13, long r14) {
        if (r13.isFile() == true) goto L5;
        long r0 = 0;
        File[] r15 = r13.listFiles();     // Catch: Exception -> L20
        if (r15 != null) goto L10;
    L19:
        return 0;
    L10:
        if (r15.length == 0) goto L19;
        int r2 = r15.length;     // Catch: Exception -> L20
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L22;
        File r5 = r15[r3];     // Catch: Exception -> L20
        if (r5.isDirectory() == false) goto L17;
        long r8 = r14 + 1;     // Catch: Exception -> L20
        long r6 = c(r5, r8);     // Catch: Exception -> L20
        r0 = r0 + r6;     // Catch: Exception -> L20
        a(r5, r6, r8);     // Catch: Exception -> L20
    L18:
        r3 = r3 + 1;
        goto L13
    L17:
        r0 = r0 + r5.length();     // Catch: Exception -> L20
        a(r5, r5.length(), r14 + 1);     // Catch: Exception -> L20
    L22:
        return r0;
    L20:
        e = move-exception;
        Log.e("StorageMetricsHandler", "getFileSize error!", e);
        goto L22
    L5:
        return r13.length();
    }

    public final void a(File r8, long r9, long r11) {
        C0191a r6 = new C0191a(r8.getAbsolutePath(), r9, r11);
        if (r11 > 2) goto L7;
        ((ArrayList) this.p).add(r6);
        return;
    L7:
        if (r8.isFile() == false) goto L12;
        if (r9 < this.d) goto L12;
        this.q.a(r6);
        return;
    L12:
        if (r9 < this.e) goto L16;
        this.r.a(r6);
        return;
    }

    public final void e(long r7, long r9, long r11, long r13) {
        Log.i("StorageMetricsHandler", "disk: data: " + r7 + " , cache: " + r9 + " , total: " + r11 + " , free: " + r13);     // Catch: Exception -> L27
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L27
        r1.put(Keys.API_RETURN_KEY_DATA, r7);     // Catch: Exception -> L27
        r1.put("cache", r9);     // Catch: Exception -> L27
        r1.put("total", r11);     // Catch: Exception -> L27
        r1.put("rom_free", r13);     // Catch: Exception -> L27
        Iterator r10 = ((ArrayList) this.p).iterator();     // Catch: Exception -> L27
    L6:
        if (r10.hasNext() == false) goto L14;
        C0191a r12 = (C0191a) r10.next();     // Catch: Exception -> L27
        String r14 = d(r12.a);     // Catch: Exception -> L27
        if (r12.b <= 0) goto L10;
        Log.i("StorageMetricsHandler", "path: " + r14 + ", size: " + r12.b);     // Catch: Exception -> L27
    L10:
        long r15 = r12.b;     // Catch: Exception -> L27
        if (r15 < 1048576) goto L6;
        r1.put(r14, r15);     // Catch: Exception -> L27
        goto L6
    L14:
        b<C0191a> r16 = this.r;     // Catch: Exception -> L27
        r16.getClass();     // Catch: Exception -> L27
        Iterator r17 = new ArrayList(r16.a).iterator();     // Catch: Exception -> L27
    L16:
        if (r17.hasNext() == false) goto L18;
        C0191a r18 = (C0191a) r17.next();     // Catch: Exception -> L27
        String r19 = d(r18.a);     // Catch: Exception -> L27
        Log.i("StorageMetricsHandler", "path: " + r19 + ", size: " + r18.b);     // Catch: Exception -> L27
        r1.put(r19, r18.b);     // Catch: Exception -> L27
        goto L16
    L18:
        b<C0191a> r20 = this.q;     // Catch: Exception -> L27
        r20.getClass();     // Catch: Exception -> L27
        Iterator r21 = new ArrayList(r20.a).iterator();     // Catch: Exception -> L27
    L20:
        if (r21.hasNext() == false) goto L23;
        C0191a r110 = (C0191a) r21.next();     // Catch: Exception -> L27
        String r111 = d(r110.a);     // Catch: Exception -> L27
        Log.i("StorageMetricsHandler", "path: " + r111 + ", size: " + r110.b);     // Catch: Exception -> L27
        r1.put(r111, r110.b);     // Catch: Exception -> L27
        goto L20
    L23:
        if (r7 <= this.c) goto L25;
        ApmAgent.monitorEvent("lark_storage_size_all", null, r1, null);     // Catch: Exception -> L27
    L25:
        ((ArrayList) this.p).clear();     // Catch: Exception -> L27
        this.q.a.clear();     // Catch: Exception -> L27
        this.r.a.clear();     // Catch: Exception -> L27
        return;
    L27:
        e = move-exception;
        Log.e("StorageMetricsHandlergetFileSize error!", e, true);
    }
}
