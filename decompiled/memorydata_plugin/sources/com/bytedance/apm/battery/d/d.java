package com.bytedance.apm.battery.d;

import android.app.PendingIntent;
import androidx.core.app.NotificationCompat;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends c<com.bytedance.apm.battery.d.a.a> implements com.bytedance.apm.battery.b.b {
    private int[] e;
    private int f;
    private List<Long> g;
    private int h;
    private final Object i;
    private final List<Long> j;

    public d() {
        super(NotificationCompat.CATEGORY_ALARM);
        this.g = new ArrayList();
        this.i = new Object();
        this.j = new ArrayList();
    }

    private void a(int[] r14, int r15) {
        long r9 = System.currentTimeMillis();
        if (this.f1162b == false) goto L7;
        if ((r15 % 2) != 0) goto L7;
    L10:
        com.bytedance.apm.battery.c.a.a().a(new com.bytedance.apm.c.a(false, r9, getType(), this.c, r14[0], null));
        com.bytedance.apm.battery.c.a r16 = com.bytedance.apm.battery.c.a.a();
        com.bytedance.apm.c.a r12 = new com.bytedance.apm.c.a(true, r9, getType(), this.c, r14[1], null);
    L12:
        r16.a(r12);
        return;
    L7:
        if (this.f1162b == false) goto L9;
    L11:
        com.bytedance.apm.battery.c.a.a().a(new com.bytedance.apm.c.a(true, r9, getType(), this.c, r14[0], null));
        r16 = com.bytedance.apm.battery.c.a.a();
        r12 = new com.bytedance.apm.c.a(false, r9, getType(), this.c, r14[1], null);
        goto L12
    L9:
        if ((r15 % 2) != 1) goto L11;
        goto L10
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void a(Object[] r11) {
        com.bytedance.apm.battery.d.a.a r0 = new com.bytedance.apm.battery.d.a.a();
        int r1 = r11.length;
        int r3 = 0;
        int r6 = -1;
        boolean r4 = false;
        int r5 = 0;
    L3:
        if (r3 >= r1) goto L20;
        Object r7 = r11[r3];
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L9;
        if (r4 == true) goto L9;
        r0.f1154a = ((Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.memorydata.plugin")).intValue();
        r4 = true;
    L19:
        r3 = r3 + 1;
    L9:
        if (ZeusTransformUtils.instanceOf(r7, Long.class) == false) goto L17;
        if (r5 != 0) goto L13;
        r0.d = ((Long) ZeusTransformUtils.preCheckCast(r7, Long.class, "com.obric.memorydata.plugin")).longValue();
        r0.d = r0.a();
    L15:
        r5 = r5 + 1;
        goto L19
    L13:
        if (r5 != 2) goto L15;
        r0.f1155b = ((Long) ZeusTransformUtils.preCheckCast(r7, Long.class, "com.obric.memorydata.plugin")).longValue();
        goto L15
    L17:
        if (ZeusTransformUtils.instanceOf(r7, PendingIntent.class) == false) goto L19;
        PendingIntent r8 = (PendingIntent) ZeusTransformUtils.preCheckCast(r7, PendingIntent.class, "com.obric.memorydata.plugin");
        r0.c = com.bytedance.apm.util.h.a(r8);
        r6 = r8.hashCode();
        goto L19
    L20:
        if (r6 != (-1)) goto L22;
        return;
    L22:
        if (r0.f1155b != 0) goto L24;
        long r2 = r0.d;
    L25:
        r0.e = r2;
        if (com.bytedance.apm.battery.a.a().g() == false) goto L28;
        r0.f = Thread.currentThread().getName();
        r0.g = Thread.currentThread().getStackTrace();
    L28:
        this.d.put(Integer.valueOf(r6), r0);
        return;
    L24:
        r2 = -1;
        goto L25
    }

    private void b() {
        long r1 = System.currentTimeMillis();
        int[] r3 = this.e;
        int r4 = 0;
        double r5 = (((((double) r3[0]) + ((double) r3[1])) / (r1 - this.f1161a)) * 60000.0d) * 10.0d;
        double r11 = ((((double) this.f) / (r1 - this.f1161a)) * 60000.0d) * 10.0d;
        if (r5 < com.bytedance.apm.battery.a.a.d()) goto L6;
        r4 = 49;
    L6:
        if (r11 < com.bytedance.apm.battery.a.a.e()) goto L8;
        r4 = r4 | 50;
    L8:
        if (r4 != 0) goto L22;
        return;
    L22:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L21
        r2.put("issue_type", r4).put("wake_up_count", r5).put("normal_count", r11);     // Catch: Throwable -> L21
        if (this.d != null) goto L13;
    L19:
        com.bytedance.apm.h.b.a(r2, "battery_trace");     // Catch: Throwable -> L21
        com.bytedance.apm.data.pipeline.a.b().a(new com.bytedance.apm.data.a.d("battery_trace", r2));     // Catch: Throwable -> L21
        return;
    L13:
        if (this.d.size() <= 0) goto L19;
        JSONArray r6 = new JSONArray();     // Catch: Throwable -> L21
        Iterator r15 = this.d.values().iterator();     // Catch: Throwable -> L21
    L16:
        if (r15.hasNext() == false) goto L18;
        r6.put(((com.bytedance.apm.battery.d.a.a) ZeusTransformUtils.preCheckCast(r15.next(), com.bytedance.apm.battery.d.a.a.class, "com.obric.memorydata.plugin")).c());     // Catch: Throwable -> L21
        goto L16
    L18:
        r2.put(MemoryListActivity.JUMP_FROM_DETAIL, r6);     // Catch: Throwable -> L21
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void b(Object[] r6) {
        if (r6[0] != null) goto L5;
    L7:
        int r7 = -1;
    L8:
        com.bytedance.apm.battery.d.a.a r0 = (com.bytedance.apm.battery.d.a.a) ZeusTransformUtils.preCheckCast(this.d.get(Integer.valueOf(r7)), com.bytedance.apm.battery.d.a.a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.f1155b <= 0) goto L15;
        r0.e = System.currentTimeMillis();
        this.d.put(Integer.valueOf(r7), r0);
        return;
    L15:
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r6[0], PendingIntent.class) == false) goto L7;
        r7 = r6[0].hashCode();
        goto L8
    }

    @Override // com.bytedance.apm.battery.b.b
    public String a() {
        return "android.app.IAlarmManager";
    }

    @Override // com.bytedance.apm.battery.d.c
    public void a(long r8, long r10, boolean r12) {
        this.f = 0;
        this.e = new int[2];
        this.j.add(Long.valueOf(r8));
        Object r9 = this.i;
        monitor-enter(r9);
        this.j.addAll(this.g);     // Catch: Throwable -> L15
        this.g.clear();     // Catch: Throwable -> L15
        monitor-exit(r9);     // Catch: Throwable -> L15
        this.j.add(Long.valueOf(r10));
        this.h = 1;
    L8:
        if (this.h >= this.j.size()) goto L10;
        super.a(((Long) ZeusTransformUtils.preCheckCast(this.j.get(this.h - 1), Long.class, "com.obric.memorydata.plugin")).longValue(), ((Long) ZeusTransformUtils.preCheckCast(this.j.get(this.h), Long.class, "com.obric.memorydata.plugin")).longValue(), r12);
        this.h++;
        goto L8
    L10:
        int[] r11 = this.e;
        if ((r11[0] + r11[1]) == 0) goto L13;
        a(r11, this.j.size());
    L13:
        this.j.clear();
        b();
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(com.bytedance.apm.battery.c.b r3, com.bytedance.apm.c.a r4) {
        if (getType().equals(r4.f1245b) == true) goto L5;
        return;
    L5:
        boolean r2 = r4.b();
        long r0 = r4.d();
        if (r2 == false) goto L8;
        r3.i(r0);
        return;
    L8:
        r3.r(r0);
    }

    public void a(com.bytedance.apm.battery.d.a.a r9, long r10, long r12) {
        int r1 = 1;
        if (r9.f1155b <= 0) goto L5;
        long r4 = r9.d;
        if (r4 >= r10) goto L13;
        r4 = (r9.f1155b + r10) - ((r10 - r9.d) % r9.f1155b);
    L13:
        long r11 = r9.e;
        if (r11 <= r12) goto L16;
    L19:
        long r13 = r12 - r4;
        if (r13 <= 0) goto L28;
        r1 = 1 + ((int) (r13 / r9.f1155b));
    L23:
        if (r9.b() == false) goto L25;
        int[] r14 = this.e;
        int r8 = this.h % 2;
        r14[r8] = r14[r8] + r1;
        return;
    L25:
        this.f += r1;
        return;
    L28:
        return;
    L16:
        if (r9.e <= 0) goto L19;
        r12 = r11;
        goto L19
    L5:
        if (r10 <= r9.d) goto L7;
        return;
    L7:
        if (r9.d <= r12) goto L23;
    }

    @Override // com.bytedance.apm.battery.d.c
    public /* synthetic */ void a(com.bytedance.apm.battery.d.a.b r7, long r8, long r10) {
        a((com.bytedance.apm.battery.d.a.a) ZeusTransformUtils.preCheckCast(r7, com.bytedance.apm.battery.d.a.a.class, "com.obric.memorydata.plugin"), r8, r10);
    }

    @Override // com.bytedance.apm.battery.b.b
    public void a(Object r1, Method r2, Object[] r3) {
        String r4 = r2.getName();     // Catch: Exception -> L9
        if ("set".equals(r4) == false) goto L6;
        a(r3);     // Catch: Exception -> L9
    L10:
        return;
    L6:
        if ("remove".equals(r4) == false) goto L10;
        b(r3);     // Catch: Exception -> L9
    }

    @Override // com.bytedance.apm.battery.d.c, com.bytedance.apm.battery.d.l
    public void a(boolean r3) {
        super.a(r3);
        long r0 = System.currentTimeMillis();
        Object r4 = this.i;
        monitor-enter(r4);
        this.g.add(Long.valueOf(r0));     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(boolean r1, boolean r2) {
        this.c = r1;
    }

    @Override // com.bytedance.apm.battery.d.c, com.bytedance.apm.battery.d.l
    public void b(boolean r3) {
        super.b(r3);
        long r0 = System.currentTimeMillis();
        Object r4 = this.i;
        monitor-enter(r4);
        this.g.add(Long.valueOf(r0));     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
