package qn;

import android.os.SystemClock;
import android.view.Choreographer;
import c7.e;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.fluency.FluencySample;
import com.lynx.tasm.fluency.FluencyTraceHelper$ForceStatus;
import com.lynx.tasm.u0;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.animax.player.b f21533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SecureRandom f21534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f21535c;
    public FluencyTraceHelper$ForceStatus d;
    public boolean e;
    public LynxBooleanOption f;

    public a(LynxContext r5) {
        this.f21534b = new SecureRandom();
        double r10 = -1.0d;
        this.f21535c = -1.0d;
        this.d = FluencyTraceHelper$ForceStatus.f10849c;
        this.e = false;
        this.f = LynxBooleanOption.f9962a;
        u0 r11 = r5.K;
        if (r11 == null) goto L5;
        r10 = r11.L;
    L5:
        this.f21535c = r10;
        this.e = false;
        a();
        this.f21533a = new com.lynx.animax.player.b(r5);
    }

    public final void a() {
        double r5 = this.f21535c;
        if (r5 >= 0.0d) goto L5;
        LynxBooleanOption r10 = this.f;
        if (r10 != LynxBooleanOption.f9962a) goto L18;
        return;
    L18:
        if (r10 != LynxBooleanOption.f9963b) goto L20;
        FluencyTraceHelper$ForceStatus r11 = FluencyTraceHelper$ForceStatus.f10847a;
    L21:
        this.d = r11;
        return;
    L20:
        r11 = FluencyTraceHelper$ForceStatus.f10848b;
        goto L21
    L5:
        if (this.e == true) goto L7;
    L9:
        this.e = true;
        if (this.f21534b.nextDouble() > r5) goto L13;
        this.d = FluencyTraceHelper$ForceStatus.f10847a;
        return;
    L13:
        this.d = FluencyTraceHelper$ForceStatus.f10848b;
        return;
    L7:
        if (this.d == FluencyTraceHelper$ForceStatus.f10849c) goto L9;
    }

    public final void b(int r15) {
        if (this.f21533a == null) goto L66;
        FluencyTraceHelper$ForceStatus r5 = this.d;
        if (r5 != FluencyTraceHelper$ForceStatus.f10849c) goto L11;
        if (FluencySample.f10845a.compareAndSet(true, false) == false) goto L9;
        FluencySample.f10846b = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.f9973j, false);
    L9:
        boolean r10 = FluencySample.f10846b;
    L14:
        if (r10 == false) goto L67;
        com.lynx.animax.player.b r14 = this.f21533a;
        d r11 = (d) ((HashMap) r14.f9658c).get(Integer.valueOf(r15));
        if (r11 != null) goto L19;
    L53:
        TraceEvent.g(0, "StopFluencyTrace");
        return;
    L19:
        if (r11.f21548b == false) goto L52;
        r11.f21552j = SystemClock.elapsedRealtime() - r11.f21551i;
        if (r11.d == null) goto L24;
        Choreographer.getInstance().removeFrameCallback(r11.d);
    L24:
        c r12 = new c();
        r12.d = r11.f21552j;
        long r13 = r11.g - r11.f;
        if (r13 <= 0) goto L51;
        int r16 = r11.f21550h;
        if (r16 <= 1) goto L51;
        r12.f21540b = (int) (((((double) (r16 - 1)) * 1000000.0d) * 1000.0d) / r13);
        r12.f21541c = r11.f21553k;
        r11.f21553k = -1;
        if (r11.e.isEmpty() == true) goto L51;
        LinkedList r17 = r11.e;
        r11.e = new LinkedList();
        if (r17.isEmpty() == true) goto L47;
        int r18 = r12.f21541c - 1;
        Iterator r19 = r17.iterator();
    L36:
        if (r19.hasNext() == false) goto L47;
        Long r20 = (Long) r19.next();
        int r21 = (int) 1666.6666666666667d;
        int r22 = Math.max(Math.min((int) (((r20.longValue() + ((long) (r21 - 1))) / ((long) r21)) - 1), r18), 0);
        long r110 = (r20.longValue() / 100) - ((long) 16.666666666666668d);
        r12.f21539a++;
        if (r22 < 1) goto L36;
        r12.e++;
        r12.f += r110;
        if (r22 < 3) goto L36;
        r12.g++;
        r12.f21542h += r110;
        if (r22 < 7) goto L36;
        r12.f21543i++;
        r12.f21544j += r110;
        if (r22 < 25) goto L36;
        r12.f21545k++;
        r12.f21546l += r110;
    L47:
        if (((LynxContext) r11.f21547a.get()) == null) goto L51;
        al.a r23 = r11.f21549c;
        if (r23 == null) goto L51;
        LynxEventReporter.onEvent("lynxsdk_fluency_event", r23.f313a, new com.lynx.animax.a(1, r23, r12));
    L51:
        r11.f21548b = false;
    L52:
        ((HashMap) r14.f9658c).remove(Integer.valueOf(r15));
        goto L53
    L67:
        return;
    L11:
        if (r5 != FluencyTraceHelper$ForceStatus.f10847a) goto L13;
        r10 = true;
        goto L14
    L13:
        r10 = false;
        goto L14
    }

    public final void c(int r10, String r11) {
        if (this.f21533a == null) goto L36;
        FluencyTraceHelper$ForceStatus r5 = this.d;
        if (r5 != FluencyTraceHelper$ForceStatus.f10849c) goto L11;
        if (FluencySample.f10845a.compareAndSet(true, false) == false) goto L9;
        FluencySample.f10846b = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.f9973j, false);
    L9:
        boolean r12 = FluencySample.f10846b;
    L14:
        if (r12 == false) goto L38;
        b r13 = new b();
        r13.f21536a = "";
        r13.f21537b = "";
        r13.f21538c = -1.0d;
        LynxBooleanOption r14 = LynxBooleanOption.f9962a;
        r13.f21536a = "scroll";
        r13.f21537b = r11;
        r13.f21538c = this.f21535c;
        r13.d = this.f;
        com.lynx.animax.player.b r15 = this.f21533a;
        d r16 = (d) ((HashMap) r15.f9658c).get(Integer.valueOf(r10));
        if (r16 != null) goto L23;
        LynxContext r17 = (LynxContext) ((WeakReference) r15.f9657b).get();
        if (r17 == null) goto L39;
        d r18 = new d(r17);
        r18.f21549c = new al.a(r13, r17.A);
        ((HashMap) r15.f9658c).put(Integer.valueOf(r10), r18);
        r16 = r18;
        goto L23
    L39:
        return;
    L23:
        if (r16.f21548b == true) goto L31;
        r16.e.clear();
        r16.f = -1;
        r16.g = -1;
        r16.f21550h = 0;
        r16.d = new e(r16, 7);
        r16.f21551i = SystemClock.elapsedRealtime();     // Catch: Exception -> L28
        Choreographer.getInstance().postFrameCallback(r16.d);     // Catch: Exception -> L28
    L29:
        r16.f21548b = true;
    L28:
        r16.f21548b = false;
        r16.f = -1;
        r16.g = -1;
        r16.f21550h = 0;
        r16.d = null;
        r16.f21551i = -1;
    L31:
        if (TraceController.g == false) goto L37;
        HashMap r19 = new HashMap();
        r19.put("scene", r13.f21536a);
        r19.put("tag", r13.f21537b);
        TraceEvent.h(0, "StartFluencyTrace", r19);
        return;
    L37:
        return;
    L38:
        return;
    L11:
        if (r5 != FluencyTraceHelper$ForceStatus.f10847a) goto L13;
        r12 = true;
        goto L14
    L13:
        r12 = false;
        goto L14
    }
}
