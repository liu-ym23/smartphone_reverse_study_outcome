package com.lynx.tasm.performance;

import b8a.l;
import b8a.m;
import c8a.b;
import c8a.c;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.b2;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.performance.fsp.FSPTracer;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import i8a.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import y7a.a;
import y7a.d;
import y7a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PerformanceController implements c {
    public static volatile boolean k;
    public static volatile LynxBooleanOption l;
    public static volatile long m;
    public b a;
    public volatile long b;
    public WeakReference<a> c;
    public WeakReference<i8a.a> d;
    public boolean e;
    public JavaOnlyMap f;
    public JavaOnlyArray g;
    public int h;
    public FSPTracer i;
    public Boolean j;

    private native void nativeAllocateMemory(long r1, String r3, long r4, String r6, String r7);

    private static native long nativeCurrentSystemTimeMicroseconds();

    private native void nativeDeallocateMemory(long r1, String r3, long r4, String r6, String r7);

    private static native boolean nativeIsMemoryMonitorEnabled();

    private native void nativeSetFSPTimingInfo(long r1, long r3, Map<String, String> r5);

    private native void nativeSetPaintEndTimingAndHostPlatformTiming(long r1, long r3, JavaOnlyMap r5, JavaOnlyArray r6);

    private native void nativeSetTiming(long r1, String r3, long r4, String r6);

    private native void nativeUpdateMemoryUsage(long r1, String r3, long r4, int r6, Map<String, String> r7);

    static {
        l = LynxBooleanOption.UNSET;
        m = -1;
    }

    public static long j() {
        if (k == true) goto L6;
        k = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (k == true) goto L8;
        LLog.e("PerformanceController", "Failed to call currentSystemTimeMicroseconds to obtain the timestamp.");
        return 0;
    L8:
        return nativeCurrentSystemTimeMicroseconds();
    }

    public static boolean m() {
        if (k == true) goto L6;
        k = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (k == false) goto L19;
        LynxBooleanOption r0 = l;
        LynxBooleanOption r2 = LynxBooleanOption.FALSE;
        if (r0 != r2) goto L11;
        return false;
    L11:
        if (r0 != LynxBooleanOption.UNSET) goto L17;
        boolean r1 = nativeIsMemoryMonitorEnabled();
        if (r1 == false) goto L15;
        r2 = LynxBooleanOption.TRUE;
    L15:
        l = r2;
        return r1;
    L17:
        return true;
    L19:
        return false;
    }

    @Override // c8a.c
    public final void b() {
        if (this.e == false) goto L12;
        k();
        b r0 = this.a;
        if (r0.e == true) goto L7;
    L9:
        long r8 = j();
        n("Timing::Mark", "paintEnd", r8, NameKeys.UnloadStrategy_No_Strategy);
        this.a.c("paintEnd", r8);
        return;
    L7:
        if ((!r0.c.isEmpty()) == true) goto L9;
        return;
    L12:
        if (UIThreadUtils.isOnUiThread() == true) goto L14;
        return;
    L14:
        if (this.g.isEmpty() == true) goto L19;
        final long r4 = j();
        o("Timing::Mark", "paintEnd", r4);
        final JavaOnlyMap r6 = this.f;
        this.f = null;
        final JavaOnlyArray r7 = this.g;
        this.g = new JavaOnlyArray();
        q(new f(this, r4, r6, r7));
        return;
    }

    public final void k() {
        if (this.e == true) goto L5;
        return;
    L5:
        if (this.a != null) goto L9;
        b r0 = new b();
        this.a = r0;
        r0.h = this.c;
        r0.g = this.h;
        return;
    }

    public final boolean l() {
        Boolean r0 = this.j;
        if (r0 != null) goto L6;
        return LynxEnv.inst().enableFSP();
    L6:
        return r0.booleanValue();
    }

    public PerformanceController() {
        this.b = 0;
        this.e = false;
        this.g = new JavaOnlyArray();
        this.h = -1;
        this.i = null;
    }

    @Override // c8a.c
    public final JavaOnlyArray c() {
        return this.g;
    }

    @Override // c8a.c
    public final void a(String r4) {
        if (this.e == false) goto L5;
        return;
    L5:
        if (UIThreadUtils.isOnUiThread() == true) goto L7;
        return;
    L7:
        if (this.g.isEmpty() == true) goto L22;
        if (r4 != null) goto L11;
        return;
    L11:
        if (this.f != null) goto L13;
        this.f = new JavaOnlyMap();
    L18:
        long r0 = j();
        o("Timing::MarkHostPlatformTiming", r4, r0);
        this.f.put(r4, Long.valueOf(r0));
        return;
    L13:
        if (r4.endsWith("Start") == false) goto L18;
        if (this.f.containsKey(r4) == false) goto L18;
        return;
    }

    public void onPerformanceEvent(ReadableMap r4) {
        if (this.e == false) goto L5;
        return;
    L5:
        a r0 = this.c.get();
        l r1 = m.e(r4);
        if (r0 == null) goto L8;
        r0.onPerformanceEvent(r1);
    L8:
        WeakReference<i8a.a> r2 = this.d;
        if (r2 == null) goto L11;
        i8a.a r3 = r2.get();
    L14:
        if (r3 == null) goto L19;
        int r5 = r4.getInt("instanceId", -1);
        if (r5 == (-1)) goto L20;
        HashMap<String, Object> r6 = LynxEventReporter.getGenericInfoWithExtraParams(Integer.valueOf(r5));
        r6.putAll(r4.asHashMap());
        r3.onPerformanceEvent(m.e(JavaOnlyMap.from(r6)));
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r3 = (i8a.a) n.c().a(i8a.a.class);
        if (r3 == null) goto L14;
        this.d = new WeakReference(r3);
        goto L14
    }

    public final void q(Runnable r2) {
        if (this.e == false) goto L5;
        return;
    L5:
        LynxEventReporter.runOnReportThread(r2);
    }

    public void setNativePtr(long r2) {
        if (this.e == false) goto L5;
        return;
    L5:
        this.b = r2;
    }

    public static void d(PerformanceController r9, Map r10) {
        if (r9.b == 0) goto L12;
        Iterator r11 = r10.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L18;
        a8a.a r0 = (a8a.a) ((Map.Entry) r11.next()).getValue();
        if (r0 == null) goto L7;
        r9.nativeUpdateMemoryUsage(r9.b, r0.a, r0.b, r0.c, r0.d);
        goto L7
    L18:
        return;
    }

    public static /* synthetic */ void f(PerformanceController r14, b2 r15) {
        if (r14.b != 0) goto L6;
        return;
    L6:
        if (r15.a <= 0) goto L9;
        r14.nativeSetTiming(r14.b, "openTime", r15.a * 1000, null);
    L9:
        if (r15.b <= 0) goto L12;
        r14.nativeSetTiming(r14.b, "containerInitStart", r15.b * 1000, null);
    L12:
        if (r15.c <= 0) goto L15;
        r14.nativeSetTiming(r14.b, "containerInitEnd", r15.c * 1000, null);
    L15:
        if (r15.d <= 0) goto L18;
        r14.nativeSetTiming(r14.b, "prepareTemplateStart", r15.d * 1000, null);
    L18:
        if (r15.e <= 0) goto L21;
        r14.nativeSetTiming(r14.b, "prepareTemplateEnd", r15.e * 1000, null);
        return;
    }

    public final void p(final String r10, final String r11) {
        final long r6 = j();
        n("Timing::Mark", r10, r6, r11);
        if (this.e == false) goto L6;
        k();
        this.a.c(r10, r6);
        return;
    L6:
        q(new d(this, r10, r6, r11));
    }

    public static /* synthetic */ void i(PerformanceController r11, long r12, Map r14) {
        if (r11.b == 0) goto L7;
        r11.nativeSetFSPTimingInfo(r11.b, r12, r14);
        return;
    }

    public final void o(String r9, String r10, long r11) {
        if (TraceEvent.isTracingStarted() == false) goto L8;
        Iterator<Object> r0 = this.g.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        n(r9, r10, r11, (String) r0.next());
        goto L6
    L10:
        return;
    }

    public static /* synthetic */ void e(PerformanceController r7, String r8, long r9, String r11) {
        if (r7.b == 0) goto L7;
        r7.nativeSetTiming(r7.b, r8, r9 * 1000, r11);
        return;
    }

    public static /* synthetic */ void g(PerformanceController r7, String r8, long r9, String r11) {
        if (r7.b == 0) goto L7;
        r7.nativeSetTiming(r7.b, r8, r9, r11);
        return;
    }

    public static /* synthetic */ void h(PerformanceController r7, long r8, JavaOnlyMap r10, JavaOnlyArray r11) {
        if (r7.b == 0) goto L7;
        r7.nativeSetPaintEndTimingAndHostPlatformTiming(r7.b, r8, r10, r11);
        return;
    }

    public final void n(String r3, String r4, long r5, String r7) {
        if (TraceEvent.isTracingStarted() == false) goto L6;
        HashMap r0 = new HashMap();
        r0.put("timing_key", r4);
        r0.put("timestamp", String.valueOf(r5));
        r0.put("pipeline_id", r7);
        r0.put("instance_id", String.valueOf(this.h));
        TraceEvent.instant(0, r3 + "." + r4, r0);
        return;
    }
}
