package com.bytedance.apm.battery.d;

import android.os.IBinder;
import com.bytedance.crash.constants.Constants;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k extends a<com.bytedance.apm.battery.d.a.d> implements com.bytedance.apm.battery.b.b {
    public k() {
        super("power");
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void a(Object[] r7) {
        b();
        if (com.bytedance.apm.battery.a.a().g() == true) goto L5;
        return;
    L5:
        if (r7.length <= 7) goto L7;
        return;
    L7:
        if (r7.length >= 4) goto L10;
        return;
    L10:
        if (r7[0] != null) goto L12;
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r7[0], IBinder.class) == false) goto L36;
        int r0 = r7[0].hashCode();
        if (this.d.containsKey(Integer.valueOf(r0)) == true) goto L25;
        com.bytedance.apm.battery.d.a.d r1 = new com.bytedance.apm.battery.d.a.d();
        if (r7[1] != null) goto L18;
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r7[1], Integer.class) == false) goto L30;
        r1.f1157a = ((Integer) ZeusTransformUtils.preCheckCast(r7[1], Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r7[2] != null) goto L22;
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r7[2], String.class) == false) goto L32;
        r1.f1158b = (String) ZeusTransformUtils.preCheckCast(r7[2], String.class, "com.obric.memorydata.plugin");
        r1.e = -1;
    L28:
        r1.g = Thread.currentThread().getStackTrace();
        r1.f = Thread.currentThread().getName();
        r1.d = System.currentTimeMillis();
        this.d.put(Integer.valueOf(r0), r1);
        return;
    L32:
        return;
    L30:
        return;
    L25:
        r1 = (com.bytedance.apm.battery.d.a.d) ZeusTransformUtils.preCheckCast(this.d.get(Integer.valueOf(r0)), com.bytedance.apm.battery.d.a.d.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L28;
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void b(Object[] r4) {
        c();
        if (com.bytedance.apm.battery.a.a().g() == true) goto L5;
        return;
    L5:
        if (r4.length == 2) goto L8;
        return;
    L8:
        if (r4[0] != null) goto L10;
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4[0], IBinder.class) == false) goto L17;
        int r5 = r4[0].hashCode();
        com.bytedance.apm.battery.d.a.d r0 = (com.bytedance.apm.battery.d.a.d) ZeusTransformUtils.preCheckCast(this.d.get(Integer.valueOf(r5)), com.bytedance.apm.battery.d.a.d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L18;
        r0.e = System.currentTimeMillis();
        this.d.put(Integer.valueOf(r5), r0);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.apm.battery.b.b
    public String a() {
        return "android.os.IPowerManager";
    }

    @Override // com.bytedance.apm.battery.d.a
    public void a(double r5, double r7) {
        if (r5 < com.bytedance.apm.battery.a.a.c()) goto L5;
        int r1 = 17;
    L7:
        if (r7 < com.bytedance.apm.battery.a.a.b()) goto L9;
        r1 = r1 | 18;
    L9:
        if (r1 != 0) goto L23;
        return;
    L23:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L22
        r2.put("issue_type", r1).put("total_hold_time", r5).put("total_acquire_count", r7);     // Catch: Throwable -> L22
        if (this.d != null) goto L14;
    L20:
        com.bytedance.apm.h.b.a(r2, "battery_trace");     // Catch: Throwable -> L22
        com.bytedance.apm.data.pipeline.a.b().a(new com.bytedance.apm.data.a.d("battery_trace", r2));     // Catch: Throwable -> L22
        return;
    L14:
        if (this.d.size() <= 0) goto L20;
        JSONArray r6 = new JSONArray();     // Catch: Throwable -> L22
        Iterator r4 = this.d.values().iterator();     // Catch: Throwable -> L22
    L17:
        if (r4.hasNext() == false) goto L19;
        r6.put(((com.bytedance.apm.battery.d.a.d) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.apm.battery.d.a.d.class, "com.obric.memorydata.plugin")).a());     // Catch: Throwable -> L22
        goto L17
    L19:
        r2.put(MemoryListActivity.JUMP_FROM_DETAIL, r6);     // Catch: Throwable -> L22
    L26:
        return;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(com.bytedance.apm.battery.c.b r3, com.bytedance.apm.c.a r4) {
        if (getType().equals(r4.f1245b) == false) goto L9;
        boolean r2 = r4.a();
        long r0 = r4.d();
        if (r2 == false) goto L7;
        r3.l(r0);
        return;
    L7:
        r3.c(r0);
        return;
    }

    @Override // com.bytedance.apm.battery.d.a
    public /* synthetic */ void a(com.bytedance.apm.battery.d.a.b r3, long r4) {
        a((com.bytedance.apm.battery.d.a.d) ZeusTransformUtils.preCheckCast(r3, com.bytedance.apm.battery.d.a.d.class, "com.obric.memorydata.plugin"), r4);
    }

    public void a(com.bytedance.apm.battery.d.a.d r4, long r5) {
        if (r5 >= com.bytedance.apm.battery.a.a.a()) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L7
        r0.put(Constants.EVENT_TYPE, "battery_trace");     // Catch: JSONException -> L7
        r0.put("issue_type", 16).put("single_hold_time", r5).put("wake_lock_info", r4.toString());     // Catch: JSONException -> L7
        com.bytedance.apm.h.b.a(r0, "battery_trace");     // Catch: JSONException -> L7
        com.bytedance.apm.data.pipeline.a.b().a(new com.bytedance.apm.data.a.d("battery_trace", r0));     // Catch: JSONException -> L7
        return;
    }

    @Override // com.bytedance.apm.battery.b.b
    public synchronized void a(Object r1, Method r2, Object[] r3) {
        monitor-enter(this);
        String r4 = r2.getName();     // Catch: Throwable -> L10 Exception -> L15
        if ("acquireWakeLock".equals(r4) == false) goto L7;
        a(r3);     // Catch: Throwable -> L10 Exception -> L15
    L16:
        goto L13
    L7:
        if ("releaseWakeLock".equals(r4) == false) goto L16;
        b(r3);     // Catch: Throwable -> L10 Exception -> L15
    L10:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(this);
    }
}
