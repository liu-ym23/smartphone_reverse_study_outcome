package i9;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.writer.DaoWriter;
import av.h;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import l9.o;
import org.json.JSONArray;
import org.json.JSONObject;
import ym.m;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f17537a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static File f17538b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static File f17539c = null;
    public static File d = null;
    public static LinkedList e = null;
    public static ListMap f = null;
    public static boolean g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f17540h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f17541i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f17542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f17543k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f17544l = null;

    static {
        f17541i = new ConcurrentLinkedQueue();
        f17542j = false;
        f17543k = false;
        f17544l = new Object();
    }

    public static long a(File r5) {
        return b(cl.a.c(-1, new File(r5, "app_start_time"), "\n"), System.currentTimeMillis());
    L5:
        return System.currentTimeMillis();
    }

    public static long b(String r5, long r10) {
        return Long.decode(r5).longValue();
    L4:
        return r10;
    }

    public static c5.a c(JSONArray r12) {
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r12.length() == 0) goto L47;
        ArrayList r5 = new ArrayList(r12.length());
        i();
        int r10 = 0;
    L9:
        if (r10 >= r12.length()) goto L36;
        JSONObject r11 = r12.optJSONObject(r10);
        if (r11 == null) goto L34;
        int r13 = r11.optInt(LynxMonitorService.KEY_PID);
        long r14 = r11.optLong("start_time");
        if (r13 <= 0) goto L34;
        if (r14 <= 0) goto L34;
        File r15 = com.bytedance.android.anniex.base.service.e.d(r14);
        StringBuilder r16 = new StringBuilder();
        if (p.f23509c != null) goto L21;
        p.f23509c = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss", Locale.getDefault());
    L21:
        r16.append(p.f23509c.format(new Date(r14)));
        r16.append("_");
        r16.append(r13);
        String[] r17 = r15.list(new h(r16.toString(), 5));
        if (r17 != null) goto L24;
    L27:
        File r18 = null;
    L28:
        if (r18 != null) goto L32;
        r18 = new File(f17539c, com.lynx.jsbridge.a.d(r13, "proc/"));
        if (r18.exists() == true) goto L32;
        r18 = null;
    L32:
        if (r18 == null) goto L34;
        r5.add(r18);
        goto L34
    L24:
        if (r17.length == 0) goto L27;
        r18 = new File(r15, r17[0]);
    L34:
        r10 = r10 + 1;
        goto L9
    L36:
        if (r5.isEmpty() == false) goto L38;
        return null;
    L38:
        File[] r19 = new File[r5.size()];
        r5.toArray(r19);
        return new c5.a(r19, false);
    L47:
        return null;
    }

    public static e d(long r5, File r10, String r11) {
        long r12 = Long.decode(r11).longValue();     // Catch: Throwable -> L12
        if ((r5 - r12) >= 1000) goto L16;
        return null;
    L16:
        return new e(r10, new File(r10, "info.txt"), r12);
    L10:
        cl.a.C(r10);
        return null;
    L12:
        cl.a.C(r10);
        return null;
    }

    public static void e(e r16, File r17, long r18, File r20) {
        z8.f r10 = z8.f.q(new StackTraceElement(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a", "a", 1), "DiedProcess.unknownReason: please see logcat or oncall.\n", "PROCESS_DIED", "unknown", "PROCESS_DIED", "PROCESS_DIED", null);
        Long r11 = Long.valueOf(r18);
        JSONObject r12 = r10.f23416a;
        mh.e.g(r11, "crash_time", r12);
        mh.e.g(Long.valueOf(r18), "timestamp", r12);
        String r13 = r16.g;
        mh.e.g(r13, "process_name", r12);
        mh.e.g(Long.valueOf(r16.e), "app_start_time", r12);
        mh.e.g(Long.valueOf(r16.f), "last_alive_time", r12);
        mh.e.g(Long.valueOf(r16.d), LynxMonitorService.KEY_PID, r12);
        StringBuilder r14 = new StringBuilder();
        Iterator r15 = r16.f17534c.iterator();
    L4:
        if (r15.hasNext() == false) goto L43;
        d r19 = (d) r15.next();
        r14.append("pid:");
        r14.append(r19.f17529a);
        r14.append(" alive_time:");
        r14.append(r18 - r19.f17530b);
        r14.append(" process:");
        r14.append(r19.d);
        r14.append(" last_alive_time:");
        r14.append(r18 - r19.f17531c);
        r14.append('\n');
        String r110 = p.b((int) r19.f17529a, r18);
        if (r110 == null) goto L4;
        z5.a.d(r110, r12);
        r14.append("exitInfo:\n");
        r14.append(r110);
        r14.append("\n");
        goto L4
    L43:
        JSONArray r111 = cl.a.d(-1, new File(r17, "logcat.txt"));     // Catch: Throwable -> L37
        mh.e.g(r111, "logcat", r12);     // Catch: Throwable -> L37
        if (mh.e.m(r111) == true) goto L15;
        if (r111.length() <= 10) goto L15;
        z8.c.l(r10.b(), "filters", "has_logcat", "true");     // Catch: Throwable -> L37
    L15:
        if (r20 != null) goto L41;
    L18:
        String r5 = null;
    L20:
        if (TextUtils.isEmpty(r5) == true) goto L47;
    L29:
        z8.c.l(r10.b(), "custom", "activity_track", r5);
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "disable_kill_history_alog"}) == 1) goto L33;
        v8.a r21 = v8.a.d();
        String r22 = r16.f17533b;
        v8.a.a(r22, r21.c(r18, r22));
        z8.c.l(r10.b(), "filters", "may_has_alog", "true");
    L33:
        io.reactivex.exceptions.a.e("terminateMonitor", "upload " + r14);
        z8.c.l(r10.b(), "custom", "died_processes", r14.toString());
        n.d(r10, z8.d.f23419b, r18, r17);     // Catch: Throwable -> L39
    L35:
        cl.a.C(r17);
        return;
    L47:
        long r112 = r16.f17532a;     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r13) == false) goto L24;
        r13 = com.bytedance.crash.n.f4057a.getPackageName();     // Catch: Throwable -> L38
    L24:
        File r113 = new File(com.bytedance.android.anniex.base.service.e.d(r112), r13.replace(':', '_') + ".txt");     // Catch: Throwable -> L38
        long r23 = r113.length();     // Catch: Throwable -> L38
        if (r23 <= 30720) goto L27;
        long r114 = r23 - 30720;     // Catch: Throwable -> L38
    L28:
        r5 = cl.a.c(r114, r113, "\n");     // Catch: Throwable -> L38
        goto L29
    L27:
        r114 = -1;
        goto L28
    L41:
        r5 = cl.a.c(-1, new File(r20, "procHistory.txt"), "\n");     // Catch: Throwable -> L40
        goto L20
    }

    public static boolean f(int r18, String r19) {
        io.reactivex.exceptions.a.d("TermianteMonitor", "process one died " + r18);
        File r5 = new File(f17539c, com.lynx.jsbridge.a.d(r18, "proc/"));
        long r10 = System.currentTimeMillis();
        long r11 = a(r5);
        if (r19 != null) goto L5;
        File r12 = null;
    L7:
        if (r19 != null) goto L92;
        e r13 = null;
    L17:
        HashMap r14 = new HashMap();
        String r15 = com.lynx.jsbridge.a.d(r18, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        com.bytedance.crash.upload.g.k(r14, new h(r15, 3));
        com.bytedance.crash.upload.g.q(r14, new h(r15, 4));
        Iterator r16 = r14.values().iterator();
    L18:
        boolean r17 = false;
        if (r16.hasNext() == false) goto L43;
        com.bytedance.crash.upload.f r110 = (com.bytedance.crash.upload.f) r16.next();
        if (r110.f4114j != r18) goto L18;
        ArrayList r20 = r110.f4110b;
        if (r20.isEmpty() == true) goto L33;
        cl.a.I(new File(r5, "hasJavaCrash"));
        if (r13 == null) goto L33;
        cl.a.I(new File(r12.getParent(), "hasJavaCrash"));
        Iterator r21 = r20.iterator();
    L29:
        if (r21.hasNext() == false) goto L33;
        cl.a.u(r12.getParentFile().getAbsolutePath(), new File(((com.bytedance.crash.upload.e) r21.next()).f4105a, "has_kill_info"), false);     // Catch: Throwable -> L79
    L33:
        ArrayList r22 = r110.f4111c;
        if (r22.isEmpty() == true) goto L43;
        cl.a.I(new File(r5, "hasNativeCrash"));
        if (r13 == null) goto L43;
        cl.a.I(new File(r12.getParent(), "hasNativeCrash"));
        Iterator r23 = r22.iterator();
    L39:
        if (r23.hasNext() == false) goto L43;
        cl.a.u(r12.getParentFile().getAbsolutePath(), new File(((com.bytedance.crash.upload.e) r23.next()).f4105a, "has_kill_info"), false);     // Catch: Throwable -> L80
    L43:
        File r24 = w8.e.f22803a;
        String[] r25 = r5.list();
        if (r25 == null) goto L86;
        int r26 = r25.length;
        int r27 = 0;
    L47:
        if (r27 >= r26) goto L86;
        String r111 = r25[r27];
        if (r111.startsWith("anr_info_") == true) goto L54;
        if (r111.startsWith("trace_") == true) goto L54;
        r27 = r27 + 1;
    L54:
        Context r28 = com.bytedance.crash.n.f4057a;
        String r29 = com.bytedance.crash.util.g.f4181a;
        File r30 = new File(com.bytedance.crash.util.g.h(r28) + "/" + x8.a.e, r5.getName());
        r30.mkdirs();
        cl.a.k(r5, r30);
        r17 = true;
    L86:
        File r112 = r5;
        String r31 = cl.a.c(-1, new File(r5, "cmd"), "\n");     // Catch: Throwable -> L81
    L62:
        if (TextUtils.isEmpty(r31) == false) goto L64;
        r31 = com.bytedance.crash.n.f4057a.getPackageName();
    L64:
        File r32 = com.bytedance.android.anniex.base.service.e.d(r11);
        StringBuilder r33 = new StringBuilder();
        r33.append(r31.replace(':', '_'));
        r33.append("_");
        if (p.f23509c != null) goto L68;
        p.f23509c = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss", Locale.getDefault());
    L68:
        r33.append(p.f23509c.format(new Date(r11)));
        r33.append("_");
        r33.append(r112.getName());
        cl.a.k(r112, new File(r32, r33.toString()));
        File r34 = new File(r112, "procHistory.txt");
        if (TextUtils.isEmpty(r31) == false) goto L71;
        r31 = com.bytedance.crash.n.f4057a.getPackageName();
    L71:
        cl.a.l(r34, new File(com.bytedance.android.anniex.base.service.e.d(r11), r31.replace(':', '_') + ".txt"), true, Integer.MAX_VALUE);
        if (r19 == null) goto L77;
        if (r13 == null) goto L77;
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_kill_history_err"}) != 1) goto L77;
        e(r13, r12.getParentFile(), r10, r112);
    L77:
        cl.a.C(r112);
        return r17;
    L60:
        r31 = null;
    L59:
        r112 = r5;
        goto L60
    L92:
        r13 = new e(null, r12, r10);     // Catch: Throwable -> L13
        cl.a.I(new File(r5, "has_kill_info"));     // Catch: Throwable -> L11
    L11:
        th = th;
    L15:
        io.reactivex.exceptions.a.j(th);
    L13:
        th = th;
        r13 = null;
        goto L15
    L5:
        r12 = new File(r19);
        goto L7
    }

    public static void g() {
        File r5 = new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.f22986i);
        f17539c = r5;
        r5.mkdirs();
        d = new File(f17539c, "kill_info");
        File r10 = new File(f17539c, "proc/" + Process.myPid());
        f17538b = r10;
        r10.mkdirs();
        cl.a.u(m.o(com.bytedance.crash.n.f4057a), new File(r10, "cmd"), false);     // Catch: IOException -> L5 Throwable -> L8
        cl.a.u(String.valueOf(com.bytedance.crash.n.f4059c), new File(r10, "app_start_time"), false);     // Catch: IOException -> L5 Throwable -> L8
        return;
    L5:
        e = move-exception;
        io.reactivex.exceptions.a.f(e);
        return;
    }

    public static JSONArray h() {
        File[] r5 = new File(f17539c, "proc/").listFiles();
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.length == 0) goto L23;
        JSONArray r10 = new JSONArray();
        int r11 = r5.length;
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L16;
        File r13 = r5[r12];
        long r14 = b(r13.getName(), -1);
        if (r14 < 0) goto L15;
        if (NativeTools.k().q((int) r14) == false) goto L15;
        JSONObject r15 = new JSONObject();
        mh.e.g(Long.valueOf(r14), LynxMonitorService.KEY_PID, r15);
        mh.e.g(Long.valueOf(a(r13)), "start_time", r15);
        r10.put(r15);
    L15:
        r12 = r12 + 1;
        goto L8
    L16:
        return r10;
    L23:
        return null;
    }

    public static boolean i() {
        int r5 = 0;
        if (f17542j == false) goto L5;
        return false;
    L5:
        Object r10 = f17544l;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (f17542j == false) goto L13;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return false;
    L13:
        f17542j = true;     // Catch: Throwable -> L11
        io.reactivex.exceptions.a.d("TermianteMonitor", "processStart try clear all");     // Catch: Throwable -> L11
        File[] r11 = new File(f17539c, "proc/").listFiles();     // Catch: Throwable -> L11
        if (r11 != null) goto L17;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return false;
    L17:
        int r12 = r11.length;     // Catch: Throwable -> L11
        boolean r13 = false;
    L18:
        if (r5 >= r12) goto L27;
        long r14 = b(r11[r5].getName(), -1);     // Catch: Throwable -> L11
        if (r14 == (-1)) goto L26;
        if (r14 == Process.myPid()) goto L26;
        int r15 = (int) r14;     // Catch: Throwable -> L11
        if (NativeTools.k().q(r15) == true) goto L26;
        r13 = r13 | f(r15, null);     // Catch: Throwable -> L11
    L26:
        r5 = r5 + 1;     // Catch: Throwable -> L11
        goto L18
    L27:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r13;
    }

    public static void j() {
        if (com.bytedance.crash.p.f4084h == false) goto L5;
        return;
    L5:
        if (com.bytedance.crash.p.f4085i == false) goto L8;
        return;
    L8:
        if (g == true) goto L71;
        g = true;
        LinkedList r5 = e;
        if (r5 != null) goto L47;
        e = new LinkedList();
        f = new ListMap();
        long r10 = System.currentTimeMillis();
        File r11 = d;
        if (r11.exists() == true) goto L16;
        r5 = e;
        goto L47
    L16:
        String[] r12 = r11.list();
        if (r12 != null) goto L19;
    L45:
        r5 = e;
        goto L47
    L19:
        if (r12.length == 0) goto L45;
        Arrays.sort(r12);
        int r13 = 0;
        if (r12.length == 0) goto L31;
        JSONObject r14 = l9.c.e();
        int r15 = mh.e.c(r14, 5, new String[]{"custom_event_settings", "npth_simple_setting", "kill_history_limit"});
        if (r12.length <= r15) goto L31;
        Arrays.sort(r12);
    L28:
        if (r13 >= (r12.length - r15)) goto L30;
        cl.a.C(new File(d, r12[r13]));
        r13 = r13 + 1;
        goto L28
    L30:
        r13 = r12.length - r15;
    L31:
        int r16 = r13;
    L33:
        if (r16 >= r12.length) goto L44;
        if (r16 >= (r13 + 5)) goto L44;
        String r17 = r12[r16];
        File r18 = new File(r11, r17);
        e r19 = d(r10, r18, r17);
        if (r19 != null) goto L39;
        cl.a.C(r18);
    L43:
        r16 = r16 + 1;
        goto L33
    L39:
        e.add(r19);
        Iterator r20 = r19.f17534c.iterator();
    L41:
        if (r20.hasNext() == false) goto L43;
        d r21 = (d) r20.next();
        f.a(Integer.valueOf((int) r21.f17529a)).add(r19);
    L44:
        r5 = e;
    L47:
        if (p.f == true) goto L55;
        p.f = true;
        p.p();     // Catch: Throwable -> L52
    L54:
        p.h();
    L52:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L57
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        p.h();
        throw th;
    L55:
        o.e().b(new com.lynx.tasm.ui.image.h(r5, 21));
        return;
    }
}
