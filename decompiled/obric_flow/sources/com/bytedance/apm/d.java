package com.bytedance.apm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.salamander.anniex.b0;
import java.io.File;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import l9.l;
import l9.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3863b;

    public /* synthetic */ d(int r5, String r10, Object r11) {
        this.f3862a = r5;
        this.f3863b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r5 = null;
        Process r10 = null;
        View r11 = null;
        r5 = null;
        switch(this.f3862a) {
            case 0: goto L114;
            case 1: goto L106;
            case 2: goto L98;
            case 3: goto L90;
            case 4: goto L81;
            case 5: goto L39;
            case 6: goto L33;
            case 7: goto L139;
            case 8: goto L132;
            case 9: goto L6;
            default: goto L133;
        };
    L6:
        io.reactivex.exceptions.a.i("dumpLogcat use java");
        r10 = Runtime.getRuntime().exec(new String[]{"logcat", "-b", "main,system,crash,events", "-f", this.f3863b});     // Catch: Throwable -> L10
        r10.waitFor(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
        if (r10 == null) goto L149;
        r10.destroy();
        return;
    L149:
        return;
    L10:
        if (r10 == null) goto L151;
        r10.destroy();
        return;
    L151:
        return;
    L33:
        StringBuilder r12 = new StringBuilder("invalidateID [monitorId:");
        String r14 = this.f3863b;
        r12.append(r14);
        r12.append(']');
        d5.b.f("ContainerStandardApi", r12.toString());
        j5.e.f18241a.getClass();
        Intrinsics.checkNotNullParameter(r14, "monitorId");
        j5.b.f18236b.remove(r14);
        j5.b.f18237c.remove(r14);
        WeakHashMap r13 = j5.b.f;
        j5.f r15 = (j5.f) j5.b.e.get(r14);
        if (r15 == null) goto L36;
        r11 = (View) r15.f18245b.get();
    L36:
        r13.remove(r11);
        j5.b.d.remove(r14);
        return;
    L81:
        z8.c r16 = new z8.c();
        String r17 = this.f3863b;
        JSONObject r18 = r16.f23416a;
        mh.e.g(r17, "data", r18);
        mh.e.g(1, "userdefine", r18);
        z8.c r19 = l.f().g(CrashType.CUSTOM_JAVA, r16, null, false);
        if (r19 == null) goto L159;
        sj.k.g().getClass();
        JSONObject r110 = r19.f23416a;
        if (r110 != null) goto L86;
        return;
    L86:
        if (r110.length() == 0) goto L161;
        o.e().b(new a(r110));
        return;
    L161:
        return;
    L159:
        return;
    L90:
        EventSubType r20 = EventSubType.f6609p;
        JSONObject r21 = new JSONObject();
        r21.put("sub_type", r20.f6615a);
        String r111 = this.f3863b;
        if (r111 == null) goto L94;
        r21.put("err_msg", r111);
    L94:
        if (0 == 0) goto L96;
        r21.put("duration", 0);
    L96:
        com.lynx.tasm.utils.j.g("geckosdk_event_message", r21);
        return;
    L98:
        EventSubType r22 = EventSubType.f6607n;
        JSONObject r23 = new JSONObject();
        r23.put("sub_type", r22.f6615a);
        String r112 = this.f3863b;
        if (r112 == null) goto L102;
        r23.put("err_msg", r112);
    L102:
        if (0 == 0) goto L104;
        r23.put("duration", 0);
    L104:
        com.lynx.tasm.utils.j.g("geckosdk_event_message", r23);
        return;
    L106:
        EventSubType r24 = EventSubType.f6608o;
        JSONObject r25 = new JSONObject();
        r25.put("sub_type", r24.f6615a);
        String r113 = this.f3863b;
        if (r113 == null) goto L110;
        r25.put("err_msg", r113);
    L110:
        if (0 == 0) goto L112;
        r25.put("duration", 0);
    L112:
        com.lynx.tasm.utils.j.g("geckosdk_event_message", r25);
        return;
    L114:
        b0 r26 = h7.a.f17285a;
        String r114 = this.f3863b;
        if (TextUtils.isEmpty(r114) == true) goto L117;
        j7.a r27 = new j7.a(1);
        r27.f18266b = r114;
        h7.a.f17285a.c(r27);
        if (td.b.f22124a == false) goto L122;
        io.reactivex.exceptions.a.m("APM-CommonEvent", "Cached CommonLog: " + r27);
    L122:
        h7.a.a();
        return;
    L117:
        if (td.b.f22124a == false) goto L162;
        io.reactivex.exceptions.a.m("APM-CommonEvent", "logType must be not empty");
        return;
    L162:
        return;
    L132:
        if (LockMonitorManager.access$900() == false) goto L16;
        LockMonitorManager.access$1000(this.f3863b);     // Catch: Throwable -> L126
        return;
    L16:
        String r115 = com.lynx.tasm.utils.g.o(Looper.getMainLooper().getThread().getStackTrace());     // Catch: Throwable -> L126
        BlockingQueue r28 = LockMonitorManager.access$400();     // Catch: Throwable -> L126
        monitor-enter(r28);     // Catch: Throwable -> L126
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L126
    L19:
        if (LockMonitorManager.access$400().size() == 0) goto L23;
        LockMonitorManager.access$400().clear();     // Catch: Throwable -> L21
    L23:
        LockMonitorManager.access$400().put(r115);     // Catch: Throwable -> L21
        monitor-exit(r28);     // Catch: Throwable -> L21
        goto L153
    L152:
        return;
    L153:
        return;
    L133:
        JSONObject r116 = new JSONObject();     // Catch: JSONException -> L125
        r116.put("evil_method_section", this.f3863b);     // Catch: JSONException -> L125
        i6.a.i().b(new j6.b("evil_method_tracing", 0, null, r116, null, null));     // Catch: JSONException -> L125
        return;
    L148:
        return;
    L139:
        jg.e r117 = jg.e.a(this.f3863b);     // Catch: Throwable -> L127
        if (r117 == null) goto L154;
        z6.b.f23409a.d(new com.lynx.tasm.ui.image.h(r117, 28));     // Catch: Throwable -> L127
        return;
    L154:
        return;
    L155:
        return;
    L39:
        if (cl.a.f1218b != null) goto L57;
        cl.a.f1218b = new HashMap();
        File r29 = new File(n.f4057a.getFilesDir(), x8.a.f22988k);
        String[] r30 = r29.list();
        if (r30 == null) goto L57;
        int r31 = r30.length;
        int r32 = 0;
    L45:
        if (r32 >= r31) goto L57;
        String r33 = r30[r32];
        if (r33.endsWith(".ver") == false) goto L54;
        String r118 = androidx.constraintlayout.motion.widget.a.n(r33, 4, 0);
        cl.a.f1218b.put(r118, cl.a.D(r29.getAbsolutePath() + "/" + r33));     // Catch: Throwable -> L51
    L56:
        r32 = r32 + 1;
    L51:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L56
    L54:
        if (r33.endsWith(".so") == true) goto L56;
        cl.a.C(new File(r29, r33));
    L57:
        HashMap r34 = cl.a.f1218b;
        String r119 = this.f3863b;
        if ("3.1.7-rc.89".equals((String) r34.get(r119)) == true) goto L60;
        boolean r35 = false;
    L61:
        if (r35 == true) goto L156;
        StringBuilder r36 = new StringBuilder();
        r36.append(n.f4057a.getFilesDir());
        File r37 = new File(androidx.constraintlayout.motion.widget.a.u(r36, x8.a.f22988k, "lib", r119, ".so"));
        r37.getParentFile().mkdirs();
        if (r37.exists() == false) goto L65;
        r37.delete();
    L65:
        io.reactivex.exceptions.a.l("doUnpackLibrary: ".concat(r119));
        Context r38 = n.f4057a;
        int r39 = e9.c.f16794a;
        ApplicationInfo r40 = r38.getApplicationInfo();
        String r41 = e9.c.a(r40.sourceDir, r119, r37);
        if (r41 == null) goto L77;
        String[] r42 = r40.splitSourceDirs;
        if (r42 == null) goto L76;
        int r43 = r42.length;
        int r44 = 0;
    L71:
        if (r44 >= r43) goto L76;
        r41 = e9.c.a(r42[r44], r119, r37);
        if (r41 == null) goto L77;
        r44 = r44 + 1;
    L76:
        r5 = r41;
    L77:
        if (r5 != null) goto L157;
        cl.a.f1218b.put(r37.getName(), "3.1.7-rc.89");
        cl.a.u("3.1.7-rc.89", new File(n.f4057a.getFilesDir() + x8.a.f22988k + r119 + ".ver"), false);     // Catch: Throwable -> L124
        return;
    L158:
        return;
    L157:
        return;
    L156:
        return;
    L60:
        StringBuilder r45 = new StringBuilder();
        r45.append(n.f4057a.getFilesDir());
        r35 = new File(androidx.constraintlayout.motion.widget.a.u(r45, x8.a.f22988k, "lib", r119, ".so")).exists();
        goto L61
    }

    public /* synthetic */ d(String r5, int r10) {
        this.f3862a = r10;
        this.f3863b = r5;
    }
}
