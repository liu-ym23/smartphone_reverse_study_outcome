package d9;

import ai.g0;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.crash.nativecrash.NativeImpl;
import com.bytedance.crash.p;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.h;
import i9.f;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import m9.d;
import mh.e;
import org.json.JSONArray;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f16620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16621c;
    public final String d;
    public final boolean e;
    public final Thread f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f16622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final File f16623i;

    public c(boolean r5, Throwable r10, long r11, String r12, boolean r13, Thread r14, String r15, File r16, boolean r17) {
        this.f16619a = r5;
        this.f = r14;
        this.f16620b = r10;
        this.f16621c = r11;
        this.d = r12;
        this.e = r13;
        this.g = r15;
        this.f16623i = r16;
        this.f16622h = r17;
    }

    @Override // m9.d
    public final z8.c c(int r12, z8.c r13) {
        int r5 = 2;
        if (r12 == 0) goto L109;
        if (r12 == 1) goto L57;
        if (r12 == 2) goto L33;
        if (r12 != 3) goto L10;
        File r11 = new File(g.c(n.f4057a, n.f()), "trace.txt");
        NativeTools r14 = NativeTools.f4167b;
        if (Header.i() == false) goto L23;
    L29:
        JSONObject r15 = h.d(Thread.currentThread().getName());
    L30:
        if (r15 == null) goto L125;
        e.g(r15, "all_thread_stacks", r13.f23416a);
    L125:
        return r13;
    L23:
        if (e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_anr_dump_for_java_crash"}) != 1) goto L29;
        NativeTools.k().i(r11.getAbsolutePath());
        JSONArray r16 = cl.a.F(r11.getAbsolutePath());     // Catch: Throwable -> L27
    L28:
        r15 = (JSONObject) w8.b.a(r16, null, false).second;
    L27:
        r16 = null;
        goto L28
    L10:
        if (r12 == 4) goto L17;
        if (r12 != 5) goto L125;
        e.g(this.g, "crash_uuid", r13.f23416a);
        return r13;
    L17:
        if (this.f16619a == true) goto L125;
        m.g(n.f4057a, r13.f23416a);
        return r13;
    L33:
        if (this.f16619a == false) goto L36;
        m.g(n.f4057a, r13.f23416a);
    L36:
        if (this.f16622h == false) goto L38;
        e.g(f9.a.h(n.f4057a), "launch_did", r13.f23416a);
    L38:
        JSONArray r17 = a.a.p();
        long r10 = SystemClock.uptimeMillis();
        JSONObject r18 = a.a.f();
        JSONArray r19 = a.a.e(r10);
        e.g(r17, "history_message", r13.f23416a);
        e.g(r18, "current_message", r13.f23416a);
        e.g(r19, "pending_messages", r13.f23416a);
        z8.c.l(r13.b(), "filters", "disable_looper_monitor", String.valueOf(l9.c.b()));
        if (this.f16619a == false) goto L41;
    L54:
        e.g(f.h(), "alive_pids", r13.f23416a);
        return r13;
    L41:
        if (e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_hprof_all_java_crash"}) != 1) goto L54;
        z8.c.l(r13.b(), "filters", "may_have_hprof", "true");
        Thread r110 = this.f;
        Throwable r20 = this.f16620b;
        boolean r21 = this.f16622h;
        long r22 = this.f16621c;
        b r111 = b.g;
        CopyOnWriteArrayList r112 = (CopyOnWriteArrayList) p.f.f;
        if (r21 == false) goto L45;
        CrashType r23 = CrashType.LAUNCH;
    L46:
        Iterator r113 = r112.iterator();
    L48:
        if (r113.hasNext() == false) goto L54;
        ((IOOMCallback) r113.next()).onCrash(r23, r20, r110, r22);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);
        goto L48
    L45:
        r23 = CrashType.JAVA;
        goto L46
    L57:
        if (this.f16622h == false) goto L59;
        e.g(Long.valueOf(this.f16621c), "timestamp", r13.f23416a);
        e.g(Boolean.valueOf(m.q(n.f4057a)), "main_process", r13.f23416a);
        e.g(CrashType.JAVA, "crash_type", r13.f23416a);
    L59:
        Thread r24 = this.f;
        if (r24 == null) goto L62;
        String r25 = r24.getName();
    L63:
        e.g(r25, "crash_thread_name", r13.f23416a);
        e.g(Integer.valueOf(Process.myTid()), "tid", r13.f23416a);
        boolean r26 = p.f4081a;
        Boolean r27 = (Boolean) b.f16614i.get();
        if (r27 == null) goto L69;
        if (r27.booleanValue() == false) goto L69;
    L70:
        String r28 = "true";
    L72:
        z8.c.l(r13.b(), "filters", "crash_after_crash", r28);
        if (NativeImpl.j() == false) goto L75;
        String r29 = "true";
    L76:
        z8.c.l(r13.b(), "filters", "crash_after_native", r29);
        if (b.g != null) goto L79;
        b.g = new b();
    L79:
        b r114 = b.g;
        Thread r30 = this.f;
        Throwable r31 = this.f16620b;
        boolean r32 = this.f16622h;
        r114.getClass();
        if (r32 == false) goto L89;
        g0 r115 = p.f;
        ListMap r33 = (ListMap) r115.f209a;
        monitor-enter(r33);
        ListMap r116 = (ListMap) r115.f209a;     // Catch: Throwable -> L86
        CrashType r34 = CrashType.LAUNCH;     // Catch: Throwable -> L86
        List r117 = r116.a(r34);     // Catch: Throwable -> L86
        monitor-exit(r33);     // Catch: Throwable -> L86
    L93:
        Iterator r118 = r117.iterator();
    L95:
        if (r118.hasNext() == false) goto L101;
        ICrashCallback r35 = (ICrashCallback) r118.next();
        long r36 = SystemClock.uptimeMillis();
        r35.onCrash(r34, h.a(r31), r30);     // Catch: Throwable -> L99
        z8.c.l(r13.b(), "custom", "callback_cost_" + r35.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - r36));     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);
        z8.c.l(r13.b(), "custom", "callback_err_".concat(r35.getClass().getName()), String.valueOf(SystemClock.uptimeMillis() - r36));
        goto L95
    L101:
        File r119 = g.f(n.f4057a);
        if (this.f16622h == false) goto L104;
        CrashType r120 = CrashType.LAUNCH;
    L105:
        z5.a.c(r119, r120);
        goto L125
    L104:
        r120 = CrashType.JAVA;
    L86:
        th = move-exception;
        throw th;
    L89:
        g0 r121 = p.f;
        ListMap r37 = (ListMap) r121.f209a;
        monitor-enter(r37);
        ListMap r122 = (ListMap) r121.f209a;     // Catch: Throwable -> L106
        r34 = CrashType.JAVA;     // Catch: Throwable -> L106
        r117 = r122.a(r34);     // Catch: Throwable -> L106
        monitor-exit(r37);     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        throw th;
    L75:
        r29 = "false";
    L69:
        if (NativeImpl.j() == true) goto L70;
        r28 = "false";
        goto L72
    L62:
        r25 = "";
        goto L63
    L109:
        e.g(h.a(this.f16620b), "data", r13.f23416a);
        e.g(Boolean.valueOf(this.f16619a), "isOOM", r13.f23416a);
        if (this.f16622h == false) goto L112;
        e.g("start_crash", "event_type", r13.f23416a);
    L113:
        e.g(Long.valueOf(this.f16621c), "crash_time", r13.f23416a);
        int r38 = m9.c.f20032y;
        if (r38 == 1) goto L116;
        r5 = r38;
    L120:
        e.g(Integer.valueOf(r5), "launch_mode", r13.f23416a);
        e.g(Long.valueOf(m9.c.A), "launch_time", r13.f23416a);
        z8.c.l(r13.b(), "filters", "from_custom", "false");
        String r123 = this.d;
        if (r123 == null) goto L125;
        e.g(r123, "crash_md5", r13.f23416a);
        z8.c.l(r13.b(), "filters", "crash_md5", this.d);
        boolean r124 = this.e;
        if (r124 == false) goto L125;
        z8.c.l(r13.b(), "filters", "has_ignore", String.valueOf(r124));
        goto L125
    L116:
        if (m9.c.f20033z == true) goto L120;
        r5 = 1;
        goto L120
    L112:
        e.g(1, "isJava", r13.f23416a);
        goto L113
    }

    @Override // m9.d
    public final z8.c d(int r5, z8.c r10) {
        File r11 = this.f16623i;
        cl.a.q(new File(r11, r11.getName() + "." + r5), r10.f23416a);     // Catch: Throwable -> L5
    L4:
        return r10;
    }
}
