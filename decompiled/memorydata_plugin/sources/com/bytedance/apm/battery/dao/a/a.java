package com.bytedance.apm.battery.dao.a;

import android.content.ContentValues;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.battery.dao.a<com.bytedance.apm.c.a> implements com.bytedance.apm.battery.dao.a.InterfaceC0085a<com.bytedance.apm.c.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f1169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f1170b = "_id <= ? ";
    private static final String[] c = null;
    private static String d;
    private static String e;

    static {
        c = new String[]{"_id", CpuReportEvent.VALUE_FRONT, "type", "timestamp", "accumulation", "version_id", AILabCheckPermissionTask.KEY_SOURCE, "status", MemoryInfoSectionEditActivity.KIND_SCENE, "process", "main_process", "sid"};
        d = "main_process = 1 AND delete_flag = 0";
        e = "main_process = 0 AND delete_flag = 0 AND timestamp <= ? ";
    }

    private a() {
    }

    public static a e() {
        if (f1169a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1169a != null) goto L9;
        f1169a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f1169a;
    }

    public synchronized long a(com.bytedance.apm.c.a r10) {
        monitor-enter(this);
        if (r10 != null) goto L27;
        monitor-exit(this);
        return -1;
    L27:
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L22 Exception -> L25
        int r5 = 1;
        if (r10.a() == false) goto L10;
        int r4 = 1;
    L11:
        r2.put(CpuReportEvent.VALUE_FRONT, Integer.valueOf(r4));     // Catch: Throwable -> L22 Exception -> L25
        r2.put(AILabCheckPermissionTask.KEY_SOURCE, r10.h());     // Catch: Throwable -> L22 Exception -> L25
        r2.put("type", r10.getType());     // Catch: Throwable -> L22 Exception -> L25
        r2.put("timestamp", Long.valueOf(r10.e()));     // Catch: Throwable -> L22 Exception -> L25
        r2.put("accumulation", Long.valueOf(r10.d()));     // Catch: Throwable -> L22 Exception -> L25
        r2.put("version_id", Long.valueOf(r10.i()));     // Catch: Throwable -> L22 Exception -> L25
        if (r10.f() == false) goto L14;
        int r6 = 1;
    L15:
        r2.put("status", Integer.valueOf(r6));     // Catch: Throwable -> L22 Exception -> L25
        r2.put(MemoryInfoSectionEditActivity.KIND_SCENE, r10.g());     // Catch: Throwable -> L22 Exception -> L25
        if (r10.k() == true) goto L19;
        r5 = 0;
    L19:
        r2.put("main_process", Integer.valueOf(r5));     // Catch: Throwable -> L22 Exception -> L25
        r2.put("process", r10.j());     // Catch: Throwable -> L22 Exception -> L25
        r2.put("sid", r10.l());     // Catch: Throwable -> L22 Exception -> L25
        long r0 = insert(r2);     // Catch: Throwable -> L22 Exception -> L25
        monitor-exit(this);
        return r0;
        goto L26
    L14:
        r6 = 0;
        goto L15
    L10:
        r4 = 0;
    L22:
        th = move-exception;
        throw th;
    L26:
        return -1;
    }

    @Override // com.bytedance.apm.battery.dao.a.InterfaceC0085a
    public /* synthetic */ com.bytedance.apm.c.a a(com.bytedance.apm.battery.dao.a.b r1) {
        return b(r1);
    }

    public synchronized List<com.bytedance.apm.c.a> a(boolean r3, long r4) {
        monitor-enter(this);
        if (r3 == false) goto L5;
        List<com.bytedance.apm.c.a> r5 = query(d, null, "_id", this);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r5;
    L5:
        r5 = query(e, new String[]{String.valueOf(r4)}, "_id", this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void a(long r5) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put("delete_flag", 1);     // Catch: Throwable -> L6
        update(r0, f1170b, new String[]{String.valueOf(r5)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public com.bytedance.apm.c.a b(com.bytedance.apm.battery.dao.a.b r22) {
        long r1 = r22.a("_id");
        long r3 = r22.a(CpuReportEvent.VALUE_FRONT);
        String r10 = r22.c("type");
        long r8 = r22.a("timestamp");
        long r12 = r22.a("accumulation");
        long r14 = r22.a("version_id");
        String r5 = r22.c(AILabCheckPermissionTask.KEY_SOURCE);
        long r6 = r22.a("status");
        String r16 = r22.c(MemoryInfoSectionEditActivity.KIND_SCENE);
        int r11 = r22.b("main_process");
        String r13 = r22.c("process");
        if (r3 == 0) goto L5;
        boolean r4 = true;
    L7:
        if (r6 == 0) goto L9;
        boolean r17 = true;
    L10:
        com.bytedance.apm.c.a r0 = new com.bytedance.apm.c.a(r4, r8, r10, r17, r12, r16, r5);
        r0.b(r13);
        r0.b(r1);
        r0.a(r14);
        if (r11 != 1) goto L13;
        boolean r7 = true;
    L14:
        r0.b(r7);
        r0.c(r22.c("sid"));
        return r0;
    L13:
        r7 = false;
        goto L14
    L9:
        r17 = false;
        goto L10
    L5:
        r4 = false;
        goto L7
    }

    @Override // com.bytedance.apm.battery.dao.a
    public String b() {
        return "t_battery";
    }

    @Override // com.bytedance.apm.battery.dao.a
    public String[] c() {
        return c;
    }
}
