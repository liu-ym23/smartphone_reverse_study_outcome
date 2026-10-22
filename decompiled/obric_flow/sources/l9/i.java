package l9;

import android.content.Context;
import android.text.TextUtils;
import androidx.room.writer.DaoWriter;
import cn.nubia.neopush.commons.AppUtil;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static i f19564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f19565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f19566j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f19568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19569c;
    public int d;
    public int e;
    public final String f;
    public final boolean g;

    public i(Context r13) {
        this.f19569c = 100;
        this.d = 2;
        this.e = 5;
        this.g = false;
        f19565i = true;
        this.f19567a = r13;
        boolean r5 = com.bytedance.crash.n.f4074w;
        this.g = r5;
        if (r5 == false) goto L12;
        String r10 = com.bytedance.crash.util.g.f4181a;
        if (ym.m.q(com.bytedance.crash.n.f4057a) == false) goto L7;
        File r11 = new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a) + "/issueCrashTimes/current.times");
    L13:
        this.f = r11.getAbsolutePath();
        ConcurrentHashMap r14 = new ConcurrentHashMap();
        r14.put("time", Long.valueOf(System.currentTimeMillis()));
        JSONArray r12 = cl.a.F(r11.getAbsolutePath());     // Catch: Throwable -> L35 IOException -> L41
        if (r12 == null) goto L36;
        if (mh.e.m(r12) == true) goto L36;
        String r15 = r12.optString(0, null);     // Catch: Throwable -> L35 IOException -> L41
        if (TextUtils.isEmpty(r15) == false) goto L42;
    L24:
        long r16 = 0;
    L25:
        Long r17 = Long.valueOf(r16);     // Catch: Throwable -> L35 IOException -> L41
        if ((System.currentTimeMillis() - r16) <= AppUtil.MILLIS_IN_DAYS) goto L28;
        b(r11);     // Catch: Throwable -> L35 IOException -> L41
        goto L36
    L28:
        r14.put("time", r17);     // Catch: Throwable -> L35 IOException -> L41
        int r18 = 1;
    L30:
        if (r18 >= r12.length()) goto L36;
        String[] r19 = r12.optString(r18, "").split(" ");     // Catch: Throwable -> L35 IOException -> L41
        if (r19.length != 2) goto L34;
        r14.put(r19[0], Long.decode(r19[1]));     // Catch: Throwable -> L35 IOException -> L41
    L34:
        r18 = r18 + 1;
        goto L30
    L42:
        r16 = Long.decode(r15).longValue();     // Catch: Throwable -> L40
    L35:
        cl.a.C(r11);
    L36:
        this.f19568b = r14;
        e();
        f r110 = new f(this, 1);
        c.f19554a.add(r110);
        if (c.f19555b == false) goto L48;
        r110.b();
        r110.a();
        return;
    L48:
        return;
    L7:
        File r20 = new File(com.bytedance.crash.util.g.h(r13), "issueCrashTimes");
        String r111 = ym.m.f23304a;
        if (r111 != null) goto L11;
        r111 = "";
    L11:
        r11 = new File(r20, io.reactivex.internal.observers.h.b(r111.replace(".", "_").replace(":", DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD), "_current.times"));
        goto L13
    L12:
        String r21 = com.bytedance.crash.util.g.f4181a;
        r11 = new File(com.bytedance.crash.util.g.h(r13) + "/issueCrashTimes/current.times");
        goto L13
    }

    public static i a() {
        if (f19564h != null) goto L16;
        monitor-enter(i.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19564h != null) goto L11;
        f19564h = new i(com.bytedance.crash.n.f4057a);     // Catch: Throwable -> L9
    L11:
        monitor-exit(i.class);     // Catch: Throwable -> L9
    L16:
        return f19564h;
    }

    public static void c(boolean r5) {
        if (r5 == false) goto L4;
        return;
    L4:
        if (f19566j == true) goto L8;
        f19566j = true;
        n.b("crash_limit_exceed", mh.e.g("exception", "crash_type", new JSONObject()), null);
        return;
    }

    public final void b(File r10) {
        Context r5 = this.f19567a;     // Catch: Exception -> L19
        String r11 = com.bytedance.crash.util.g.f4181a;     // Catch: Exception -> L19
        File r12 = new File(com.bytedance.crash.util.g.h(r5), "issueCrashTimes");     // Catch: Exception -> L19
        if (this.g == false) goto L10;
        String r13 = ym.m.f23304a;     // Catch: Exception -> L19
        if (r13 != null) goto L9;
        r13 = "";
    L9:
        String r14 = r13.replace(".", "_").replace(":", DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);     // Catch: Exception -> L19
        r10.renameTo(new File(r12, System.currentTimeMillis() + "_" + r14));     // Catch: Exception -> L19
        File[] r15 = r12.listFiles(new h(r14));     // Catch: Exception -> L19
    L11:
        if (r15 != null) goto L13;
        return;
    L13:
        if (r15.length != 0) goto L16;
        return;
    L16:
        if (r15.length <= 5) goto L24;
        Arrays.sort(r15);     // Catch: Exception -> L19
        r15[0].delete();     // Catch: Exception -> L19
        return;
    L24:
        return;
    L10:
        r10.renameTo(new File(r12, String.valueOf(System.currentTimeMillis())));     // Catch: Exception -> L19
        r15 = r12.listFiles();     // Catch: Exception -> L19
    }

    public final synchronized boolean d(String r10, long r11, boolean r12) {
        monitor-enter(this);
        if (r10 != null) goto L28;
        r10 = "default";
    L28:
        ConcurrentHashMap r5 = this.f19568b;     // Catch: Throwable -> L5
        if (r12 == false) goto L10;
        long r13 = 1;
    L11:
        Long r14 = Long.valueOf(r13);     // Catch: Throwable -> L5
        if (r5 != null) goto L14;
        Long r15 = -1L;     // Catch: Throwable -> L5
    L18:
        long r16 = r15.longValue();     // Catch: Throwable -> L5
        monitor-exit(this);
        if (r16 >= r11) goto L24;
        return true;
    L24:
        return false;
    L14:
        Long r17 = (Long) r5.get(r10);     // Catch: Throwable -> L5
        if (r17 == null) goto L17;
        r14 = Long.valueOf(r17.longValue() + r13);     // Catch: Throwable -> L5
    L17:
        r5.put(r10, r14);     // Catch: Throwable -> L5
        r15 = r14;
        goto L18
    L10:
        r13 = 0;
    L5:
        th = move-exception;
        throw th;
    }

    public final void e() {
        JSONObject r5 = c.e();
        this.f19569c = mh.e.c(r5, this.f19569c, new String[]{"custom_event_settings", "npth_simple_setting", "crash_limit_exception"});
        JSONObject r10 = c.e();
        this.e = mh.e.c(r10, this.e, new String[]{"custom_event_settings", "npth_simple_setting", "crash_limit_exception_md5"});
        JSONObject r11 = c.e();
        this.d = mh.e.c(r11, this.d, new String[]{"custom_event_settings", "npth_simple_setting", "crash_limit_exception_stack"});
    }

    public final void f() {
        ConcurrentHashMap r5 = this.f19568b;
        Long r10 = (Long) r5.remove("time");
        if (r10 != null) goto L6;
        m.b r11 = com.bytedance.crash.c.f4025a;
        RuntimeException r12 = new RuntimeException("err times, no time");
        r11.getClass();
        m.b.h("NPTH_CATCH", r12);
        return;
    L6:
        StringBuilder r13 = new StringBuilder();
        r13.append(r10);
        r13.append('\n');
        Iterator r14 = r5.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L14;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13.append((String) r15.getKey());
        r13.append(' ');
        r13.append(r15.getValue());
        r13.append('\n');
        goto L8
    L14:
        File r16 = new File(this.f);     // Catch: IOException -> L13
        cl.a.u(r13.toString(), r16, false);     // Catch: IOException -> L13
    L11:
        r5.put("time", r10);
    }
}
