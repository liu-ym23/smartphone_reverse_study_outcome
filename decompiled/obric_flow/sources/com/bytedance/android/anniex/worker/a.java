package com.bytedance.android.anniex.worker;

import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import com.bytedance.apm.agent.instrumentation.FragmentInstrumentation;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.j;
import com.bytedance.common.graphics.GraphicsMonitor;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.crash.util.g;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.CallbackImpl;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.r;
import com.lynx.tasm.behavior.XElementBehavior;
import com.lynx.tasm.core.VSyncMonitor;
import com.lynx.tasm.p;
import com.lynx.tasm.utils.CallStackUtil;
import i9.f;
import io.reactivex.internal.schedulers.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jg.i;
import l9.o;
import mh.e;
import mn.h;
import org.json.JSONException;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3504a;

    public /* synthetic */ a(int r5) {
        this.f3504a = r5;
    }

    private final void a() {
    }

    private final void b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f3504a) {
            case 0: goto L261;
            case 1: goto L298;
            case 2: goto L251;
            case 3: goto L288;
            case 4: goto L244;
            case 5: goto L242;
            case 6: goto L224;
            case 7: goto L222;
            case 8: goto L218;
            case 9: goto L215;
            case 10: goto L207;
            case 11: goto L202;
            case 12: goto L360;
            case 13: goto L188;
            case 14: goto L274;
            case 15: goto L304;
            case 16: goto L162;
            case 17: goto L150;
            case 18: goto L136;
            case 19: goto L280;
            case 20: goto L282;
            case 21: goto L102;
            case 22: goto L101;
            case 23: goto L94;
            case 24: goto L38;
            case 25: goto L278;
            case 26: goto L300;
            case 27: goto L8;
            case 28: goto L6;
            default: goto L4;
        };
    L4:
        h.h();
        return;
    L6:
        h.h();
        return;
    L8:
        h.h();
        return;
    L94:
        Iterator r15 = new ArrayList(l.d.keySet()).iterator();
    L96:
        if (r15.hasNext() == false) goto L354;
        ScheduledThreadPoolExecutor r5 = (ScheduledThreadPoolExecutor) r15.next();
        if (r5.isShutdown() == true) goto L99;
        r5.purge();
        goto L96
    L99:
        l.d.remove(r5);
        goto L96
    L354:
        return;
    L101:
        return;
    L102:
        File r16 = f.f17539c;
        r16.mkdirs();
        if (e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_all_worker"}) == 1) goto L105;
    L109:
        String r10 = Build.BRAND;
        if (TextUtils.isEmpty(r10) == false) goto L112;
    L113:
        String r11 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r11) == false) goto L116;
    L124:
        NativeTools.k().d(System.currentTimeMillis(), r16.getAbsolutePath(), new File(f.f17539c, "pid_tid").getAbsolutePath());
        return;
    L116:
        if (r11.contains("yteDance") == false) goto L124;
    L118:
        if (f.f17543k == false) goto L120;
        return;
    L120:
        if (f.f17540h == true) goto L123;
        f.f17540h = true;
    L123:
        f.f17543k = true;
        return;
    L112:
        if (r10.contains("aries") == true) goto L118;
    L105:
        if (f.f17540h == true) goto L108;
        f.f17540h = true;
    L108:
        f.f17543k = true;
        goto L109
    L136:
        Object r17 = MethodCollector.access$1400();
        monitor-enter(r17);
    L143:
        th = move-exception;
        throw th;
    L139:
        if (MethodCollector.access$100() != Integer.MAX_VALUE) goto L141;
    L145:
        MethodCollector.access$102(-2);     // Catch: Throwable -> L143
        MethodCollector.access$1502(true);     // Catch: Throwable -> L143
    L146:
        monitor-exit(r17);     // Catch: Throwable -> L143
        return;
    L141:
        if (MethodCollector.access$100() != 1) goto L146;
    L150:
        MethodCollector.access$1000().removeCallbacksAndMessages(null);
        jg.a r18 = MethodCollector.access$1100();
        if (r18 != null) goto L153;
        boolean r19 = i.f18332a;
    L157:
        MethodCollector.access$1200().quit();
        MethodCollector.access$1302(null);
        return;
    L153:
        CopyOnWriteArrayList r12 = i.f18334c;
        monitor-enter(r12);
        r12.remove(r18);     // Catch: Throwable -> L159
        d6.c.f16598k.getClass();     // Catch: Throwable -> L159
        monitor-exit(r12);     // Catch: Throwable -> L159
    L159:
        th = move-exception;
        throw th;
    L162:
        MethodCollector.access$900();
        return;
    L188:
        long r13 = SystemClock.uptimeMillis();
        Class.forName(fo.c.class.getName());     // Catch: Throwable -> L195
        Class.forName(com.lynx.tasm.behavior.utils.d.class.getName());     // Catch: Throwable -> L195
        Class.forName(com.lynx.tasm.behavior.d.class.getName());     // Catch: Throwable -> L195
        Class.forName(com.lynx.tasm.behavior.a.class.getName());     // Catch: Throwable -> L195
        Class.forName(LynxModuleFactory.class.getName());     // Catch: Throwable -> L195
        Class.forName(CallbackImpl.class.getName());     // Catch: Throwable -> L195
        Class.forName(p.class.getName());     // Catch: Throwable -> L195
        Class.forName(kn.b.class.getName());     // Catch: Throwable -> L195
        Class.forName(r.class.getName());     // Catch: Throwable -> L195
        Class.forName(XElementBehavior.class.getName());     // Catch: Throwable -> L195
        Iterator<String> r110 = XElementBehavior.GENERATOR_FILE_NAME_SETS.iterator();     // Catch: Throwable -> L195
    L191:
        if (r110.hasNext() == false) goto L197;
        Class.forName(r110.next() + ".BehaviorGenerator");     // Catch: Throwable -> L266
        goto L191
    L197:
        Log.i("Lynx_ClassWarmer", "Task0 class warm-up cost:" + (SystemClock.uptimeMillis() - r13));     // Catch: Throwable -> L195
        return;
    L195:
        th = move-exception;
        th.printStackTrace();
        return;
    L218:
        o.e().d.removeCallbacks(this);
        if (com.bytedance.crash.upload.b.o(null) == false) goto L367;
        com.bytedance.crash.upload.b.f4094b = 40;
        o.e().b(com.bytedance.crash.upload.b.f4093a);
        return;
    L367:
        return;
    L222:
        n.b(n.a());
        return;
    L224:
        int r111 = com.bytedance.crash.upload.b.f4094b;
        if (r111 <= 0) goto L236;
        com.bytedance.crash.upload.b.f4094b = r111 - 1;
        io.reactivex.exceptions.a.i("try fetchApmConfig");
        if (m.q(com.bytedance.crash.n.f4057a) == true) goto L306;
        com.bytedance.crash.upload.b.r();
        if (com.bytedance.crash.upload.b.f == false) goto L236;
        com.bytedance.crash.upload.b.f4094b = 0;
        goto L236
    L306:
        com.bytedance.crash.upload.b.q();     // Catch: Throwable -> L231 JSONException -> L267
    L231:
        com.bytedance.crash.upload.b.f4094b = 0;
    L236:
        if (com.bytedance.crash.upload.b.f4094b <= 0) goto L368;
        boolean r112 = m.q(com.bytedance.crash.n.f4057a);
        a r14 = com.bytedance.crash.upload.b.f4093a;
        if (r112 == false) goto L240;
        o.e().c(r14, 15000);
        return;
    L240:
        o.e().c(r14, 60000);
        return;
    L368:
        return;
    L242:
        io.reactivex.exceptions.a.i("afterNpthInit delay timeout");
        l9.n.b("npthStart", null, a.a.f15a);
        return;
    L244:
        NativeTools.k().C();
        return;
    L251:
        e.u();
        return;
    L261:
        tc.c r113 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r114 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r114 == null) goto L376;
        com.bytedance.ies.bullet.service.base.d r115 = (com.bytedance.ies.bullet.service.base.d) r114.f6163b.getValue();
        return;
    L376:
        return;
    L278:
        VSyncMonitor.f10833c = Choreographer.getInstance();     // Catch: RuntimeException -> L34
        return;
    L34:
        e = move-exception;
        LynxLog.b(4, "VSyncMonitor", "initUIThreadChoreographer failed: " + CallStackUtil.a(e));
        return;
    L282:
        Intent r116 = new Intent("com.apm.setting.update.action");     // Catch: Exception -> L128
        boolean r20 = j.f3887a;     // Catch: Exception -> L128
        r116.putExtra("PROCESS_NAME", xq.b.l());     // Catch: Exception -> L128
        throw null;     // Catch: Exception -> L128
    L128:
        return;
    L288:
        NativeTools.k().a();     // Catch: Throwable -> L248
        return;
    L248:
        th = move-exception;
        com.bytedance.crash.c.b(th);     // Catch: Throwable -> L268
        return;
    L371:
        return;
    L298:
        if (FragmentInstrumentation.access$200() != null) goto L256;
        return;
    L256:
        if (FragmentInstrumentation.access$000() != null) goto L258;
        return;
    L258:
        if (FragmentInstrumentation.access$000().get() == null) goto L374;
        ((View) FragmentInstrumentation.access$000().get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentInstrumentation.access$200());     // Catch: Exception -> L269
        return;
    L374:
        return;
    L375:
        return;
    L304:
    L177:
        return;
    L165:
        if (MethodCollector.access$400() == true) goto L169;
        if (MethodCollector.access$100() <= (-1)) goto L169;
        MethodCollector.access$502(MethodCollector.access$600() - MethodCollector.access$700());     // Catch: InterruptedException -> L177
        MethodCollector.access$502(MethodCollector.access$500() & 8796093022207L);     // Catch: InterruptedException -> L177
        SystemClock.sleep(5);     // Catch: InterruptedException -> L177
    L169:
        Object r117 = MethodCollector.access$800();     // Catch: InterruptedException -> L177
        monitor-enter(r117);     // Catch: InterruptedException -> L177
        MethodCollector.access$800().wait();     // Catch: Throwable -> L174
        monitor-exit(r117);     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L177
    L360:
        return;
    L300:
        p7.b r21 = (p7.b) p7.a.f21320b.take();     // Catch: Throwable -> L27
        Iterator r22 = p7.a.f21319a.iterator();     // Catch: Throwable -> L27
    L13:
        if (r22.hasNext() == false) goto L300;
        if (r22.next() != null) goto L30;
    L23:
        th = move-exception;
        io.reactivex.exceptions.a.n("APM-Monitor", "monitorableHandler null handle monitorable " + r21 + "failed.", th);     // Catch: Throwable -> L27
        goto L13
    L17:
        if (r21.a() == false) goto L19;
        throw null;     // Catch: Throwable -> L23
    L19:
        if (td.b.f22124a == false) goto L13;
        String r23 = "monitorable invalid. ignored. " + r21;     // Catch: Throwable -> L23
        if (td.b.f22124a == false) goto L13;
        Log.w("APM-Monitor", r23);     // Catch: Throwable -> L23
        goto L13
    L30:
        throw new ClassCastException();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        io.reactivex.exceptions.a.n("APM", "Oh, Damn it!!!", th);
        goto L300
    L38:
        if (m.q(com.bytedance.crash.n.f4057a) == false) goto L350;
        File r24 = new File(g.h(com.bytedance.crash.n.f4057a), x8.a.f22990m);
        String[] r25 = r24.list();
        if (r25 != null) goto L44;
        return;
    L44:
        if (r25.length <= 5) goto L49;
        Arrays.sort(r25);
        int r26 = 0;
    L47:
        if (r26 >= (r25.length - 5)) goto L49;
        cl.a.C(new File(r24, r25[r26]));
        r26 = r26 + 1;
    L49:
        String[] r27 = r24.list();
        if (r27 == null) goto L352;
        int r28 = 0;
    L276:
        if (r28 >= r27.length) goto L353;
        File r29 = new File(r24, r27[r28]);     // Catch: Throwable -> L78
        String[] r30 = r29.list();     // Catch: Throwable -> L78
        if (r30 == null) goto L91;
        if (r30.length <= 10) goto L91;
        Arrays.sort(r30, new ca.d(22));     // Catch: Throwable -> L78
        HashMap r31 = new HashMap();     // Catch: Throwable -> L78
        int r32 = 0;
    L62:
        if (r32 >= r30.length) goto L91;
        File r118 = new File(r29, r30[r32]);     // Catch: Throwable -> L78
        if (r118.isDirectory() == false) goto L88;
        Matcher r119 = Pattern.compile("([\\s\\S]*)_\\d{4}-\\d{2}-\\d{2}@[\\s\\S]*").matcher(r30[r32]);     // Catch: Throwable -> L69
        if (r119.find() == false) goto L71;
        String r120 = r119.group(1);     // Catch: Throwable -> L69
    L76:
        if (r120.equals("") == false) goto L81;
        io.reactivex.exceptions.a.c("process name is null, delete:" + r118.getAbsolutePath());     // Catch: Throwable -> L78
        cl.a.C(r118);     // Catch: Throwable -> L78
    L90:
        r32 = r32 + 1;
        goto L62
    L81:
        if (r31.containsKey(r120) == true) goto L83;
        r31.put(r120, 1);     // Catch: Throwable -> L78
        goto L90
    L83:
        if (((Integer) r31.get(r120)).intValue() < 10) goto L85;
        io.reactivex.exceptions.a.c("dir number overflow, delete:" + r118.getAbsolutePath());     // Catch: Throwable -> L78
        cl.a.C(r118);     // Catch: Throwable -> L78
        goto L90
    L85:
        r31.put(r120, Integer.valueOf(((Integer) r31.get(r120)).intValue() + 1));     // Catch: Throwable -> L78
        goto L90
    L71:
        io.reactivex.exceptions.a.c("NO MATCH");     // Catch: Throwable -> L69
    L74:
        r120 = "";
        goto L76
    L69:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);     // Catch: Throwable -> L78
        goto L74
    L88:
        if (r118.length() <= 5242880) goto L90;
        io.reactivex.exceptions.a.c("file size overflow, delete:" + r118.getAbsolutePath());     // Catch: Throwable -> L78
        cl.a.C(r118);     // Catch: Throwable -> L78
    L91:
        r28 = r28 + 1;
        goto L276
    L353:
        return;
    L78:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
        return;
    L352:
        return;
    L350:
        return;
    L280:
        if (GraphicsMonitor.access$000() == true) goto L133;
        GraphicsMonitor.access$100();     // Catch: Throwable -> L265
        Thread.sleep(GraphicsMonitor.access$200());     // Catch: Throwable -> L265
        GraphicsMonitor.access$300();     // Catch: Throwable -> L265
        GraphicsMonitor.access$402(GraphicsMonitor.access$500());     // Catch: Throwable -> L265
    L134:
        Log.i("atrace_gpu", "bytegpu: " + GraphicsMonitor.access$400());     // Catch: Throwable -> L265
        return;
    L133:
        GraphicsMonitor.access$402(-1.0d);     // Catch: Throwable -> L265
    L357:
        return;
    L274:
        long r33 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L182
        Class.forName("com.lynx.devtool.LynxInspectorOwner");     // Catch: Throwable -> L182 ClassNotFoundException -> L184
    L358:
        return;
    L184:
        Log.i("Lynx_ClassWarmer", "LynxInspectorOwner class not find");     // Catch: Throwable -> L182
        System.loadLibrary("lynx");     // Catch: Throwable -> L182
        Log.i("Lynx_ClassWarmer", "Task1 preload Lynx so cost:" + (SystemClock.elapsedRealtime() - r33));     // Catch: Throwable -> L182
        return;
    L182:
        th = move-exception;
        th.printStackTrace();
        return;
    L202:
        if (f.f17540h == true) goto L362;
        f.f17540h = true;
        return;
    L362:
        return;
    L207:
        if (f.i() == true) goto L209;
        return;
    L209:
        if (m.q(com.bytedance.crash.n.f4057a) == true) goto L211;
        return;
    L211:
        if (w8.e.d == false) goto L365;
        o.e().b(new a(9));
        return;
    L365:
        return;
    L215:
        if (com.bytedance.ies.bullet.base.utils.b.n(com.bytedance.crash.n.f4057a) == false) goto L366;
        w8.e.l();
        return;
    }

    public String toString() {
        switch(this.f3504a) {
            case 22: goto L6;
            default: goto L5;
        };
    L6:
        return "EmptyRunnable";
    L5:
        return super.toString();
    }
}
