package com.bytedance.apm6.cpu;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.j;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import jg.k;
import k7.c;
import l7.d;
import l7.e;
import o7.a;
import o7.b;

/* JADX INFO: loaded from: classes2.dex */
public class ApmCpuManager {
    private static volatile ApmCpuManager singleton;
    private CopyOnWriteArraySet<String> mSceneSet;

    private ApmCpuManager() {
        this.mSceneSet = new CopyOnWriteArraySet();
    }

    public static ApmCpuManager getInstance() {
        if (singleton != null) goto L16;
        monitor-enter(ApmCpuManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L11;
        singleton = new ApmCpuManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(ApmCpuManager.class);     // Catch: Throwable -> L9
    L16:
        return singleton;
    }

    public double getCpuRate() {
        return a.f20413a.f20414a;
    }

    public CopyOnWriteArraySet<String> getCpuSceneSet() {
        return this.mSceneSet;
    }

    public String getCpuSceneString() {
        Object[] r10 = this.mSceneSet.toArray();
        if (r10 != null) goto L5;
        String r11 = "";
    L14:
        if (TextUtils.isEmpty(r11) == true) goto L16;
        return r11;
    L16:
        return "";
    L5:
        StringBuilder r5 = new StringBuilder();
        int r12 = r10.length;
        boolean r13 = true;
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L12;
        Object r15 = r10[r14];
        if (r13 == false) goto L10;
        r13 = false;
    L11:
        r5.append(r15.toString());
        r14 = r14 + 1;
        goto L6
    L10:
        r5.append("#");
        goto L11
    L12:
        r11 = r5.toString();
        goto L14
    }

    public double getCpuSpeed() {
        return a.f20413a.f20415b;
    }

    public t6.a getCurrentCpuRate() {
        return getCurrentCpuRateNew();
    }

    public t6.a getCurrentCpuRateNew() {
        t6.a r12 = new t6.a();
        double r5 = -1.0d;
        r12.f22102a = -1.0d;
        r12.f22103b = -1.0d;
        if (com.bytedance.apm.util.a.i() > 0) goto L6;
        return r12;
    L6:
        long r10 = System.currentTimeMillis();     // Catch: Exception -> L15
        k.m().getClass();     // Catch: Exception -> L15
        long r11 = com.bytedance.apm.util.a.h();     // Catch: Exception -> L15
        k.m().getClass();     // Catch: Exception -> L15
        long r13 = com.bytedance.apm.util.a.m();     // Catch: Exception -> L15
        Thread.sleep(360);     // Catch: InterruptedException -> L14 Exception -> L15
    L9:
        k.m().getClass();     // Catch: Exception -> L15
        long r14 = com.bytedance.apm.util.a.h();     // Catch: Exception -> L15
        k.m().getClass();     // Catch: Exception -> L15
        long r15 = com.bytedance.apm.util.a.m() - r13;     // Catch: Exception -> L15
        if (r15 <= 0) goto L12;
        r5 = (r14 - r11) / r15;     // Catch: Exception -> L15
    L12:
        double r16 = (((r14 - r11) * 1000.0d) / (System.currentTimeMillis() - r10)) / com.bytedance.apm.util.a.j();     // Catch: Exception -> L15
        r12.f22102a = r5;     // Catch: Exception -> L15
        r12.f22103b = r16;     // Catch: Exception -> L15
    L13:
        return r12;
    }

    public Pair<Long, LinkedList<Object>> getExceptionThreadList() {
        b r5 = a.f20413a;
        if (((LinkedList) r5.d.second).isEmpty() == false) goto L6;
        return r5.d;
    L6:
        return new Pair(r5.d.first, new LinkedList((Collection) r5.d.second));
    }

    public long getLastCpuExceptionTimestamp() {
        int r5 = m7.a.f20019a;
        throw null;
    }

    public Pair<Long, LinkedList<Object>> getThreadList() {
        Pair<Long, LinkedList<Object>> r5 = a.f20413a.f20416c;
        if (((LinkedList) r5.second).isEmpty() == false) goto L6;
        return r5;
    L6:
        return new Pair(r5.first, new LinkedList((Collection) r5.second));
    }

    public void setCpuDataListener(k7.a r5) {
        l7.a.f19543a.getClass();
    }

    public void setCpuExceptionFilter(k7.b r5) {
        int r10 = m7.a.f20019a;
        throw null;
    }

    public void setExceptionListener(c r5) {
        int r10 = m7.a.f20019a;
        throw null;
    }

    public void startExceptionDetectNoStack() {
        boolean r5 = j.f3887a;
    }

    public void startScene(String r5) {
        this.mSceneSet.add(r5);
        ((CopyOnWriteArraySet) q7.a.k().f21488b).add(r5);
    }

    public void startUsageDetect(String r5) {
        HashMap r10 = e.f19546a;
        monitor-enter(e.class);
        d r11 = new d();     // Catch: Throwable -> L7
        System.currentTimeMillis();     // Catch: Throwable -> L7
        k.m().getClass();     // Catch: Throwable -> L7
        r11.f19544a = com.bytedance.apm.util.a.h();     // Catch: Throwable -> L7
        k r12 = k.m();     // Catch: Throwable -> L7
        com.bytedance.apm.util.a.i();     // Catch: Throwable -> L7
        r12.getClass();     // Catch: Throwable -> L7
        r11.f19545b = com.bytedance.apm.util.a.m();     // Catch: Throwable -> L7
        e.f19546a.put(r5, r11);     // Catch: Throwable -> L7
        monitor-exit(e.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void stopExceptionDetectNoStack() {
        boolean r5 = j.f3887a;
    }

    public void stopScene(String r5) {
        this.mSceneSet.remove(r5);
        ((CopyOnWriteArraySet) q7.a.k().f21488b).remove(r5);
    }

    public void stopUsageDetect(String r10, boolean r11) {
        HashMap r5 = e.f19546a;
        monitor-enter(e.class);
        HashMap r12 = e.f19546a;     // Catch: Throwable -> L15
        d r13 = (d) r12.get(r10);     // Catch: Throwable -> L15
        if (r13 != null) goto L9;
        monitor-exit(e.class);
        return;
    L9:
        if (r13.f19544a < 0) goto L12;
    L17:
        k.m().getClass();     // Catch: Throwable -> L15
        com.bytedance.apm.util.a.h();     // Catch: Throwable -> L15
        k r14 = k.m();     // Catch: Throwable -> L15
        com.bytedance.apm.util.a.i();     // Catch: Throwable -> L15
        r14.getClass();     // Catch: Throwable -> L15
        com.bytedance.apm.util.a.m();     // Catch: Throwable -> L15
        System.currentTimeMillis();     // Catch: Throwable -> L15
        com.bytedance.apm.util.a.j();     // Catch: Throwable -> L15
        r12.remove(r10);     // Catch: Throwable -> L15
        w7.b.a(AsyncTaskManagerType.CPU).b(new l7.c(0, 0));     // Catch: Throwable -> L15
        monitor-exit(e.class);
        return;
    L12:
        if (r13.f19545b >= 0) goto L17;
        monitor-exit(e.class);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public void tmpStartExceptionDetect() {
        int r5 = m7.a.f20019a;
        throw null;
    }
}
