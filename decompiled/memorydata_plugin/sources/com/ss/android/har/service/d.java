package com.ss.android.har.service;

import android.os.Handler;
import com.bytedance.retrofit2.PriorityLevel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15238b;
    private boolean c;
    private g d;
    private com.ss.android.har.service.a e;
    private final ArrayList<i> f;
    private e g;
    private ReentrantReadWriteLock h;
    private LinkedList<e> i;
    private Handler j;
    private Handler k;
    private c l;
    private boolean m;
    private int n;
    private int o;
    private Runnable p;
    private c.a q;

    /* JADX INFO: renamed from: com.ss.android.har.service.d$2, reason: invalid class name */
    class AnonymousClass2 implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f15240a;

        AnonymousClass2(d r1) {
            this.f15240a = r1;
        }

        private /* synthetic */ void a(long r5, boolean r7, int r8, Map r9) {
            Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
            if (r7 == false) goto L8;
            if (r10 == null) goto L8;
            if (r10.isEmpty() == true) goto L8;
            boolean r1 = true;
        L10:
            if (b.f15233a == false) goto L12;
            b.a("HAR", "HARService predictRun end2 runSuccess:" + r1 + " cost:" + (System.currentTimeMillis() - r5) + " success:" + r7 + " errCode:" + r8 + " outputs:" + r10);
        L12:
            d r4 = this.f15240a;
            if (r1 == false) goto L15;
            d.a(r4, r1, 0, r10);
            return;
        L15:
            d.a(r4, false, -3, null);
            return;
        L8:
            r1 = false;
            goto L10
        }

        private /* synthetic */ void b(float[] r8) {
            if (b.f15233a == false) goto L5;
            final long r0 = System.currentTimeMillis();
        L7:
            if (d.c(this.f15240a) != null) goto L9;
        L11:
            boolean r2 = false;
        L13:
            if (b.f15233a == false) goto L15;
            b.a("HAR", "HARService predictRun begin canRun:" + r2 + " >>>>");
        L15:
            if (r2 == false) goto L17;
            d.c(this.f15240a).a(r8, new $$Lambda$d$2$KQQZNZCOaje87l48S2NGGYZ9y3g(this, r0));
        L19:
            if (b.f15233a == false) goto L22;
            b.a("HAR", "HARService predictRun end1 canRun:" + r2 + " cost:" + (System.currentTimeMillis() - r0) + " <<<<");
            return;
        L22:
            return;
        L17:
            d.a(this.f15240a, false, -2, null);
            goto L19
        L9:
            if (d.c(this.f15240a).a() == false) goto L11;
            r2 = true;
            goto L13
        L5:
            r0 = 0;
            goto L7
        }

        public static /* synthetic */ void lambda$DhjdwJzFOh_HsZEkSHAFBj4axWk(AnonymousClass2 r0, float[] r1) {
            r0.b(r1);
        }

        public static /* synthetic */ void lambda$KQQZNZCOaje87l48S2NGGYZ9y3g(AnonymousClass2 r0, long r1, boolean r3, int r4, Map r5) {
            r0.a(r1, r3, r4, r5);
        }

        @Override // com.ss.android.har.service.c.a
        public void a(final float[] r7) {
            boolean r1 = true;
            if (b.f15233a == false) goto L15;
            if (r7 == null) goto L6;
            int r0 = r7.length;
        L8:
            if (d.c(this.f15240a) != null) goto L10;
        L12:
            boolean r3 = false;
        L13:
            b.a("HAR", "HARService.onOnePredictSensorDataReady inputs.size:" + r0 + " isEngineReady:" + r3);
            goto L15
        L10:
            if (d.c(this.f15240a).a() == false) goto L12;
            r3 = true;
            goto L13
        L6:
            r0 = -1;
        L15:
            if (d.c(this.f15240a) != null) goto L17;
        L22:
            r1 = false;
        L24:
            if (r1 == true) goto L26;
            d.a(this.f15240a, false, -2, null);
            return;
        L26:
            if (d.d(this.f15240a) == null) goto L32;
            d.d(this.f15240a).removeCallbacksAndMessages(null);
            d.d(this.f15240a).post(new $$Lambda$d$2$DhjdwJzFOh_HsZEkSHAFBj4axWk(this, r7));
            if (d.e(this.f15240a) == false) goto L33;
            d.b(this.f15240a);
            return;
        L33:
            return;
        L32:
            return;
        L17:
            if (d.c(this.f15240a).a() == false) goto L22;
            if (r7 == null) goto L22;
            if (r7.length <= 0) goto L22;
            goto L22
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static d f15241a;

        static {
            f15241a = new d();
        }
    }

    public d() {
        this.f15237a = false;
        this.f15238b = false;
        this.c = false;
        this.d = null;
        this.e = null;
        this.f = new ArrayList();
        this.g = null;
        this.h = new ReentrantReadWriteLock();
        this.i = new LinkedList();
        this.m = false;
        this.n = PriorityLevel.INVALID;
        this.o = PriorityLevel.INVALID;
        this.p = new AnonymousClass1(this);
        this.q = new AnonymousClass2(this);
    }

    static /* synthetic */ c a(d r0) {
        return r0.l;
    }

    public static d a() {
        return a.f15241a;
    }

    static /* synthetic */ void a(d r2, boolean r3, int r4, Map r5) {
        r2.a(r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
    }

    private void a(e r3) {
        if (b.f15233a == false) goto L5;
        b.a("HAR", "HARService.recordHistoryHarStatus statusInfo:" + r3);
    L5:
        if (r3 == null) goto L14;
        this.h.writeLock().lock();
        this.i.addFirst(r3);     // Catch: Throwable -> L11
        if (this.i.size() <= 64) goto L10;
        this.i.removeLast();     // Catch: Throwable -> L11
    L10:
        this.h.writeLock().unlock();
        return;
    L11:
        th = move-exception;
        this.h.writeLock().unlock();
        throw th;
    }

    private /* synthetic */ void a(boolean r6, int r7) {
        if (this.f.isEmpty() == false) goto L6;
        return;
    L6:
        if (b.f15233a == false) goto L8;
        b.a("HAR", "HARService.onPredictResultChanged real in success:" + r6 + " errCode:" + r7 + " lastResult:" + b());
    L8:
        ArrayList<i> r0 = this.f;
        monitor-enter(r0);
        int r1 = 0;
    L22:
    L19:
        th = move-exception;
        throw th;
    L12:
        if (r1 >= this.f.size()) goto L17;
        i r2 = (i) ZeusTransformUtils.preCheckCast(this.f.get(r1), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r2 == null) goto L16;
        r2.a(r6, r7, b());     // Catch: Throwable -> L19
    L16:
        r1 = r1 + 1;     // Catch: Throwable -> L19
        goto L22
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
    }

    private void a(final boolean r5, final int r6, Map<String, Float> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L6;
        if (r8 == null) goto L6;
        a(this.g);
        this.g = new e(r8);
    L6:
        Handler r0 = this.j;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L13:
        if (b.f15233a == false) goto L15;
        b.a("HAR", "HARService.onPredictResultChanged success:" + r5 + " errCode:" + r6 + " outputs:" + r8 + "needCallback:" + r1 + " lastSuccessPredictResult:" + this.g + " predictListeners.size:" + this.f.size());
    L15:
        d();
        if (r1 == false) goto L19;
        r0.post(new $$Lambda$d$c08_1UZwwnmxrokzYBEOxNtykTI(this, r5, r6));
        return;
    L19:
        return;
    L9:
        if (this.f.isEmpty() == true) goto L11;
        r1 = true;
        goto L13
    }

    static /* synthetic */ void b(d r0) {
        r0.c();
    }

    static /* synthetic */ g c(d r0) {
        return r0.d;
    }

    private List<e> c(int r3, boolean r4) {
        if (r4 == false) goto L6;
        if (this.g == null) goto L6;
    L7:
        ArrayList r0 = new ArrayList();
        if (r4 == false) goto L13;
        e r5 = this.g;
        if (r5 == null) goto L13;
        r0.add(r5);
        r3 = r3 - 1;
    L13:
        if (this.i.isEmpty() == true) goto L25;
        this.h.readLock().lock();
        int r6 = Math.min(r3, this.i.size());     // Catch: Throwable -> L20
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L19;
        r0.add(this.i.get(r7));     // Catch: Throwable -> L20
        r7 = r7 + 1;
        goto L16
    L19:
        this.h.readLock().unlock();
    L20:
        th = move-exception;
        this.h.readLock().unlock();
        throw th;
    L25:
        if (b.f15233a == false) goto L27;
        b.a("HAR", "HARService.getRangeHistoryHarStatus outList:" + r0);
    L27:
        return r0;
    L6:
        if (this.i.isEmpty() == false) goto L7;
        r0 = null;
        goto L25
    }

    private void c() {
        if (this.k == null) goto L12;
        com.ss.android.har.service.a r0 = this.e;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.f15232b <= 0) goto L14;
        this.k.removeCallbacks(this.p);
        this.k.postDelayed(this.p, this.e.f15232b);
        if (b.f15233a == false) goto L15;
        b.a("HAR", "HARService.checkAndPutContinuousPredictMsg continuousPredictIntervalMs:" + this.e.f15232b);
        return;
    L15:
        return;
    L14:
        return;
    }

    static /* synthetic */ Handler d(d r0) {
        return r0.k;
    }

    private void d() {
        if (b.f15233a == false) goto L6;
        b.a("HAR", "HARService.checkAndStopOncePredicting hasInit:" + this.m + " predicting:" + this.f15237a + " oncePredicting:" + this.c);
    L6:
        if (this.c == false) goto L11;
        this.c = false;
        if (this.f15237a == true) goto L12;
        e();
        return;
    L12:
        return;
    }

    private void e() {
        if (b.f15233a == false) goto L5;
        b.a("HAR", "HARService.doStopPredict");
    L5:
        c r0 = this.l;
        if (r0 == null) goto L8;
        r0.a();
    L8:
        Handler r1 = this.k;
        if (r1 == null) goto L11;
        r1.removeCallbacksAndMessages(null);
    L11:
        Handler r2 = this.j;
        if (r2 == null) goto L15;
        r2.removeCallbacksAndMessages(null);
        return;
    }

    static /* synthetic */ boolean e(d r0) {
        return r0.f15237a;
    }

    public static /* synthetic */ void lambda$c08_1UZwwnmxrokzYBEOxNtykTI(d r0, boolean r1, int r2) {
        r0.a(r1, r2);
    }

    public List<e> a(int r3, boolean r4) {
        List<e> r2 = c(r3, r4);
        if (r2 != null) goto L5;
    L9:
        ArrayList r5 = null;
    L11:
        if (b.f15233a == false) goto L13;
        b.a("HAR", "HARService.getLastRangeHARInfoWithoutFill out:" + r5);
    L13:
        return r5;
    L5:
        if (r2.isEmpty() == true) goto L9;
        r5 = new ArrayList();
        int r6 = Math.min(r2.size(), r3);
        int r0 = 0;
    L7:
        if (r0 >= r6) goto L11;
        r5.add(r2.get(r0));
        r0 = r0 + 1;
        goto L7
    }

    public int b(int r5, boolean r6) {
        List<e> r4 = c(r5, r6);
        int r7 = 0;
        if (r4 == null) goto L11;
        if (r4.isEmpty() == true) goto L11;
        HashMap r8 = new HashMap();
        int r0 = r4.size();
    L7:
        if (r7 >= r0) goto L9;
        ((e) ZeusTransformUtils.preCheckCast(r4.get(r7), e.class, "com.obric.memorydata.plugin")).a(r8);
        r7 = r7 + 1;
        goto L7
    L9:
        r7 = f.b(f.a(r8));
    L11:
        if (b.f15233a == false) goto L13;
        b.a("HAR", "HARService.getLastRangeMostIntStatus status:" + r7);
    L13:
        return r7;
    }

    public Map<String, Float> b() {
        if (b.f15233a == false) goto L5;
        b.a("HAR", "HARService.getLastResult result:" + this.g);
    L5:
        e r2 = this.g;
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.d;
    }
}
