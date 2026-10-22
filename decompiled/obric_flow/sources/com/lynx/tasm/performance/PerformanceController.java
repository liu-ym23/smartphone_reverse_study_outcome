package com.lynx.tasm.performance;

import androidx.annotation.RestrictTo;
import ao.b;
import co.e;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.utils.j;
import com.lynx.tasm.w0;
import eo.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class PerformanceController implements a {
    public static volatile boolean g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile LynxBooleanOption f10928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile long f10929i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f10930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f10931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f10932c;
    public JavaOnlyMap d;
    public JavaOnlyArray e;
    public int f;

    static {
        f10928h = LynxBooleanOption.f9962a;
        f10929i = -1;
    }

    public static long a() {
        if (g == true) goto L6;
        g = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (g == true) goto L8;
        LynxLog.b(4, "PerformanceController", "Failed to call currentSystemTimeMicroseconds to obtain the timestamp.");
        return 0;
    L8:
        return nativeCurrentSystemTimeMicroseconds();
    }

    public static boolean k() {
        if (g == true) goto L6;
        g = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (g == false) goto L19;
        LynxBooleanOption r5 = f10928h;
        LynxBooleanOption r10 = LynxBooleanOption.f9964c;
        if (r5 != r10) goto L11;
        return false;
    L11:
        if (r5 != LynxBooleanOption.f9962a) goto L17;
        boolean r11 = nativeIsMemoryMonitorEnabled();
        if (r11 == false) goto L15;
        r10 = LynxBooleanOption.f9963b;
    L15:
        f10928h = r10;
        return r11;
    L17:
        return true;
    L19:
        return false;
    }

    private native void nativeAllocateMemory(long r5, String r10, long r11, String r12, String r13);

    private static native long nativeCurrentSystemTimeMicroseconds();

    private native void nativeDeallocateMemory(long r5, String r10, long r11, String r12, String r13);

    private static native boolean nativeIsMemoryMonitorEnabled();

    private native void nativeSetPaintEndTimingAndHostPlatformTiming(long r5, long r10, JavaOnlyMap r11, JavaOnlyArray r12);

    private native void nativeSetTiming(long r5, String r10, long r11, String r12);

    private native void nativeUpdateMemoryUsage(long r5, String r10, long r11, int r12, Map<String, String> r13);

    public final /* synthetic */ void b(long r10, JavaOnlyMap r11, JavaOnlyArray r12) {
        if (this.f10930a != 0) goto L5;
        return;
    L5:
        nativeSetPaintEndTimingAndHostPlatformTiming(this.f10930a, r10, r11, r12);
    }

    public final /* synthetic */ void c(w0 r14) {
        if (this.f10930a != 0) goto L6;
        return;
    L6:
        if (r14.f11188a <= 0) goto L9;
        nativeSetTiming(this.f10930a, "openTime", r14.f11188a * 1000, null);
    L9:
        if (r14.f11189b <= 0) goto L12;
        nativeSetTiming(this.f10930a, "containerInitStart", r14.f11189b * 1000, null);
    L12:
        if (r14.f11190c <= 0) goto L15;
        nativeSetTiming(this.f10930a, "containerInitEnd", r14.f11190c * 1000, null);
    L15:
        if (r14.d <= 0) goto L18;
        nativeSetTiming(this.f10930a, "prepareTemplateStart", r14.d * 1000, null);
    L18:
        if (r14.e <= 0) goto L21;
        nativeSetTiming(this.f10930a, "prepareTemplateEnd", r14.e * 1000, null);
        return;
    }

    public final void d(String r10) {
        if (j.j() == true) goto L5;
        return;
    L5:
        if (this.e.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.d != null) goto L9;
        this.d = new JavaOnlyMap();
    L14:
        long r11 = a();
        if (TraceController.g == false) goto L20;
        Iterator<Object> r5 = this.e.iterator();
    L18:
        if (r5.hasNext() == false) goto L20;
        f("Timing::MarkHostPlatformTiming", r11, r10, (String) r5.next());
    L20:
        this.d.put(r10, Long.valueOf(r11));
        return;
    L9:
        if (r10.endsWith("Start") == false) goto L14;
        if (this.d.containsKey(r10) == false) goto L14;
    }

    public final /* synthetic */ void e(String r10, long r11) {
        if (this.f10930a != 0) goto L5;
        return;
    L5:
        nativeSetTiming(this.f10930a, r10, r11, null);
    }

    public final void f(String r5, long r10, String r11, String r12) {
        if (TraceController.g == false) goto L6;
        HashMap r13 = new HashMap();
        r13.put("timing_key", r11);
        r13.put("timestamp", String.valueOf(r10));
        r13.put("pipeline_id", r12);
        r13.put("instance_id", String.valueOf(this.f));
        TraceEvent.h(0, r5 + "." + r11, r13);
        return;
    }

    public final void g(HashMap r10) {
        if (this.f10930a == 0) goto L12;
        Iterator r11 = r10.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L18;
        bo.a r5 = (bo.a) ((Map.Entry) r11.next()).getValue();
        if (r5 == null) goto L7;
        nativeUpdateMemoryUsage(this.f10930a, r5.f963a, r5.f964b, r5.f965c, r5.d);
        goto L7
    L18:
        return;
    }

    public final void h(long r10, String r11) {
        LynxEventReporter.runOnReportThread(new b(this, r11, r10, 0));
    }

    public final /* synthetic */ void i(long r10, String r11) {
        if (this.f10930a != 0) goto L5;
        return;
    L5:
        nativeSetTiming(this.f10930a, r11, r10 * 1000, null);
    }

    public final void j(String r10) {
        long r11 = a();
        f("Timing::Mark", r11, r10, null);
        LynxEventReporter.runOnReportThread(new b(this, r10, r11, 1));
    }

    @CalledByNative
    public void onPerformanceEvent(ReadableMap r5) {
        ao.a r10 = (ao.a) this.f10931b.get();
        e r11 = f4.b.a(r5);
        if (r10 == null) goto L5;
        r10.onPerformanceEvent(r11);
    L5:
        WeakReference r12 = this.f10932c;
        if (r12 == null) goto L8;
        ko.a r13 = (ko.a) r12.get();
    L12:
        if (r13 == null) goto L17;
        int r14 = r5.getInt("instanceId", -1);
        if (r14 == (-1)) goto L18;
        HashMap<String, Object> r15 = LynxEventReporter.getGenericInfo(Integer.valueOf(r14));
        r15.putAll(r5.asHashMap());
        r13.onPerformanceEvent(f4.b.a(new JavaOnlyMap(r15)));
        return;
    L18:
        return;
    L17:
        return;
    L8:
        ko.a r16 = (ko.a) r.g().e(ko.a.class);
        if (r16 == null) goto L11;
        this.f10932c = new WeakReference(r16);
    L11:
        r13 = r16;
        goto L12
    }

    @CalledByNative
    public void setNativePtr(long r5) {
        this.f10930a = r5;
    }
}
