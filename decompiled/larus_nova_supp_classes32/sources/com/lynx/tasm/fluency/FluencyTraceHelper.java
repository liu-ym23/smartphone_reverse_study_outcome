package com.lynx.tasm.fluency;

import android.os.SystemClock;
import android.view.Choreographer;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FluencyTraceHelper {
    public final a a;
    public final SecureRandom b;
    public double c;
    public ForceStatus d;
    public boolean e;
    public LynxBooleanOption f;

    public static final enum ForceStatus extends Enum<ForceStatus> {
        public static final ForceStatus FORCED_OFF = null;
        public static final ForceStatus FORCED_ON = null;
        public static final ForceStatus NON_FORCED = null;
        public static final /* synthetic */ ForceStatus[] a = null;

        static {
            ForceStatus r0 = new ForceStatus("FORCED_ON", 0);
            FORCED_ON = r0;
            ForceStatus r1 = new ForceStatus("FORCED_OFF", 1);
            FORCED_OFF = r1;
            ForceStatus r3 = new ForceStatus("NON_FORCED", 2);
            NON_FORCED = r3;
            a = new ForceStatus[]{r0, r1, r3};
        }

        public static ForceStatus[] values() {
            return (ForceStatus[]) a.clone();
        }

        public static ForceStatus valueOf(String r1) {
            return (ForceStatus) r27.a.a(ForceStatus.class, r1);
        }

        public ForceStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean a() {
        ForceStatus r0 = this.d;
        if (r0 != ForceStatus.NON_FORCED) goto L10;
        if (FluencySample.a.compareAndSet(true, false) == false) goto L8;
        FluencySample.b = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_FLUENCY_TRACE, false);
    L8:
        return FluencySample.b;
    L10:
        if (r0 != ForceStatus.FORCED_ON) goto L13;
        return true;
    L13:
        return false;
    }

    public final void d() {
        if (this.c >= 0.0d) goto L5;
        LynxBooleanOption r0 = this.f;
        if (r0 != LynxBooleanOption.UNSET) goto L16;
        return;
    L16:
        if (r0 != LynxBooleanOption.TRUE) goto L18;
        ForceStatus r1 = ForceStatus.FORCED_ON;
    L19:
        this.d = r1;
        return;
    L18:
        r1 = ForceStatus.FORCED_OFF;
        goto L19
    L5:
        if (this.e == true) goto L7;
    L9:
        this.e = true;
        if (this.b.nextDouble() > this.c) goto L12;
        this.d = ForceStatus.FORCED_ON;
        return;
    L12:
        this.d = ForceStatus.FORCED_OFF;
        return;
    L7:
        if (this.d == ForceStatus.NON_FORCED) goto L9;
    }

    public FluencyTraceHelper(LynxContext r4) {
        this.b = new SecureRandom();
        this.c = -1.0d;
        this.d = ForceStatus.NON_FORCED;
        this.e = false;
        this.f = LynxBooleanOption.UNSET;
        this.c = r4.getEnableLynxScrollFluency();
        this.e = false;
        d();
        this.a = new a(r4);
    }

    public final void c(int r17) {
        if (this.a != null) goto L5;
        return;
    L5:
        if (a() == false) goto L61;
        a r1 = this.a;
        b r2 = (b) ((HashMap) r1.b).get(Integer.valueOf(r17));
        if (r2 != null) goto L10;
    L47:
        TraceEvent.instant(0, "StopFluencyTrace");
        return;
    L10:
        if (r2.b == false) goto L46;
        r2.j = SystemClock.elapsedRealtime() - r2.i;
        if (r2.d == null) goto L15;
        Choreographer.getInstance().removeFrameCallback(r2.d);
    L15:
        final b.C0061b r5 = new b.C0061b();
        r5.d = r2.j;
        long r6 = r2.g - r2.f;
        if (r6 <= 0) goto L45;
        int r9 = r2.h;
        if (r9 <= 1) goto L45;
        r5.b = (int) (((((double) (r9 - 1)) * 1000000.0d) * 1000.0d) / r6);
        r5.c = r2.k;
        r2.k = -1;
        if (r2.e.isEmpty() == true) goto L45;
        LinkedList<Long> r7 = r2.e;
        r2.e = new LinkedList();
        if (r7.isEmpty() == true) goto L37;
        int r8 = r5.c - 1;
        Iterator<Long> r10 = r7.iterator();
    L27:
        if (r10.hasNext() == false) goto L37;
        Long r11 = r10.next();
        int r12 = (int) 1666.6666666666667d;
        int r13 = Math.max(Math.min((int) (((r11.longValue() + ((long) (r12 - 1))) / ((long) r12)) - 1), r8), 0);
        long r14 = (r11.longValue() / 100) - ((long) 16.666666666666668d);
        r5.a++;
        if (r13 < 1) goto L27;
        r5.e++;
        r5.f += r14;
        if (r13 < 3) goto L27;
        r5.g++;
        r5.h += r14;
        if (r13 < 7) goto L27;
        r5.i++;
        r5.j += r14;
        if (r13 < 25) goto L27;
        r5.k++;
        r5.l += r14;
    L37:
        LynxContext r15 = r2.a.get();
        if (r15 == null) goto L45;
        if (r15.enableEventReporter() == false) goto L45;
        b.a r16 = r2.c;
        if (r16 == null) goto L45;
        final a.b r18 = (a.b) r16;
        LynxEventReporter.onEvent("lynxsdk_fluency_event", r18.b, new o7a.a(r18, r5));
    L45:
        r2.b = false;
    L46:
        ((HashMap) r1.b).remove(Integer.valueOf(r17));
        goto L47
    }

    public final void b(int r6, String r7) {
        if (this.a != null) goto L5;
        return;
    L5:
        if (a() == false) goto L29;
        a.C0060a r0 = new a.C0060a();
        r0.a = "scroll";
        r0.b = r7;
        r0.c = this.c;
        r0.d = this.f;
        a r8 = this.a;
        Map<Integer, b> r1 = r8.b;
        HashMap r2 = (HashMap) r1;
        b r3 = (b) r2.get(Integer.valueOf(r6));
        if (r3 != null) goto L14;
        LynxContext r4 = r8.a.get();
        if (r4 == null) goto L30;
        b r5 = new b(r4);
        r5.c = new a.b(r0, r4.getInstanceId());
        Map<Integer, b> r9 = r8.b;
        HashMap r10 = (HashMap) r9;
        r10.put(Integer.valueOf(r6), r5);
        r3 = r5;
        goto L14
    L30:
        return;
    L14:
        if (r3.b == true) goto L22;
        r3.e.clear();
        r3.f = -1;
        r3.g = -1;
        r3.h = 0;
        r3.d = new o7a.b(r3);
        r3.i = SystemClock.elapsedRealtime();     // Catch: Exception -> L19
        Choreographer.getInstance().postFrameCallback(r3.d);     // Catch: Exception -> L19
    L20:
        r3.b = true;
    L19:
        r3.b = false;
        r3.f = -1;
        r3.g = -1;
        r3.h = 0;
        r3.d = null;
        r3.i = -1;
    L22:
        if (TraceEvent.isTracingStarted() == false) goto L28;
        HashMap r11 = new HashMap();
        r11.put("scene", r0.a);
        r11.put("tag", r0.b);
        TraceEvent.instant(0, "StartFluencyTrace", r11);
        return;
    L28:
        return;
    }
}
