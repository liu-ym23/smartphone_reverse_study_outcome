package com.bytedance.monitor.collector;

import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import android.util.Pair;
import b27.d;
import b27.e;
import b27.i;
import bt3.f;
import c27.c;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import d27.a;
import es3.h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b extends AbsMonitor {
    public final a e;
    public int f;
    public volatile int g;
    public int h;
    public int i;
    public f j;
    public long k;
    public long l;
    public int m;
    public long n;
    public String o;
    public String p;
    public volatile boolean q;
    public boolean r;
    public final f s;
    public volatile boolean t;
    public final a u;

    static {
    }

    public final void d(int r1) {
    }

    public final JSONArray f() {
        return null;
    }

    public final Pair<String, ?> a() {
        return new Pair(((AbsMonitor) this).a, g());
    }

    public final JSONObject g() {
        long r2 = SystemClock.uptimeMillis();
        JSONObject r4 = new JSONObject();
        JSONArray r5 = new JSONArray();
        int r0 = 0;
        Iterator r6 = ((ArrayList) this.j.a()).iterator();     // Catch: Throwable -> L58
        int r7 = 0;
    L5:
        if (r6.hasNext() == false) goto L11;
        e r8 = (e) r6.next();     // Catch: Throwable -> L58
        if (r8 == null) goto L5;
        r7 = r7 + 1;     // Catch: Throwable -> L58
        r5.put(r8.b().put("id", r7));     // Catch: Throwable -> L58
    L11:
        JSONObject r9 = new JSONObject();
        r9.put("message", this.p);     // Catch: Throwable -> L60
        r9.put("currentMessageCost", r2 - this.l);     // Catch: Throwable -> L60
        int r10 = this.m;     // Catch: Throwable -> L60
        long r11 = -1;
        if (c.j == false) goto L30;
        long r12 = MonitorJni.doGetCpuTime(r10);     // Catch: Throwable -> L59
        if (i.b != (-1)) goto L28;
        long r13 = i.a;     // Catch: Throwable -> L59
        if (r13 > 0) goto L27;
        r13 = Os.sysconf(OsConstants._SC_CLK_TCK);     // Catch: Throwable -> L59
        if (r13 > 0) goto L26;
        r13 = 100;
    L26:
        i.a = r13;     // Catch: Throwable -> L59
    L27:
        i.b = 1000 / r13;     // Catch: Throwable -> L59
    L28:
        r11 = r12 * i.b;
    L30:
        r9.put("currentMessageCpu", r11 - this.n);     // Catch: Throwable -> L60
        r9.put("messageCount", this.f);     // Catch: Throwable -> L60
        r9.put("start", this.l);     // Catch: Throwable -> L60
        r9.put("end", r2);     // Catch: Throwable -> L60
    L31:
        MessageQueue r14 = b27.f.b();
        JSONArray r15 = new JSONArray();
        if (r14 != null) goto L73;
    L64:
        r4.put("history_message", r5);     // Catch: JSONException -> L63
        r4.put("current_message", r9);     // Catch: JSONException -> L63
        r4.put("pending_messages", r15);     // Catch: JSONException -> L63
        r4.put("check_time_info", f());     // Catch: JSONException -> L63
    L57:
        return r4;
    L73:
        monitor-enter(r14);     // Catch: Throwable -> L62
        Message r16 = b27.f.c(r14);     // Catch: Throwable -> L53
        if (r16 != null) goto L39;
        monitor-exit(r14);     // Catch: Throwable -> L53
        goto L64
    L39:
        Message r17 = r16;
        int r18 = 0;
    L40:
        if (r17 == null) goto L51;
        if (r0 >= 100) goto L51;
        r0 = r0 + 1;     // Catch: Throwable -> L53
        r18 = r18 + 1;     // Catch: Throwable -> L53
        JSONObject r19 = i(r17, r2);     // Catch: Throwable -> L53
        r19.put("id", r18);     // Catch: JSONException -> L61 Throwable -> L53
    L45:
        r15.put(r19);     // Catch: Throwable -> L53
        Field r110 = b27.f.c;     // Catch: Throwable -> L53
        if (r110 != null) goto L48;
        Field r111 = b27.f.a("android.os.Message").getDeclaredField("next");     // Catch: Exception -> L50 Throwable -> L53
        b27.f.c = r111;     // Catch: Exception -> L50 Throwable -> L53
        r111.setAccessible(true);     // Catch: Exception -> L50 Throwable -> L53
        r17 = (Message) b27.f.c.get(r17);     // Catch: Exception -> L50 Throwable -> L53
    L50:
        r17 = null;
        goto L40
    L48:
        r17 = (Message) r110.get(r17);     // Catch: Exception -> L50 Throwable -> L53
    L51:
        monitor-exit(r14);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    }

    public final void c() {
        super.c();
        if (this.q == true) goto L30;
        this.q = true;
        int r1 = ((AbsMonitor) this).c;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L14;
        if (r1 != 2) goto L11;
    L13:
        this.h = 300;
        this.i = 200;
    L15:
        this.j = new f(this.h);
        d r0 = new d(this);
        CopyOnWriteArrayList r2 = e.d;
        monitor-enter(r2);
    L25:
        th = move-exception;
        throw th;
    L18:
        if (r2.contains(r0) == true) goto L22;
        r2.add(r0);     // Catch: Throwable -> L25
        if (h.z.w == false) goto L22;
        e.g();     // Catch: Throwable -> L25
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L25
        b27.f.c(b27.f.b());
        return;
    L11:
        if (r1 == 3) goto L13;
    L14:
        this.h = 100;
        this.i = 300;
        goto L15
    }

    public b(int r4) {
        super(r4, "block_looper_info");
        this.f = 0;
        this.g = 0;
        this.h = 100;
        this.i = 200;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.q = false;
        this.r = false;
        this.t = false;
        this.u = new a(this);
        c27.d r5 = c27.d.b;
        Handler r0 = (Handler) a.e();     // Catch: Throwable -> L6
        Field r1 = c27.a.a(Handler.class, "mCallback");     // Catch: Throwable -> L6
        r5.a = (Handler.Callback) r1.get(r0);     // Catch: Throwable -> L6
        r1.set(r0, r5);     // Catch: Throwable -> L6
    L4:
        this.e = new a(this);
        this.s = null;
    }

    public static JSONObject i(Message r3, long r4) {
        JSONObject r0 = new JSONObject();
        r0.put("when", r3.getWhen() - r4);     // Catch: JSONException -> L15
        if (r3.getCallback() == null) goto L6;
        r0.put("callback", String.valueOf(r3.getCallback()));     // Catch: JSONException -> L15
    L6:
        r0.put("what", r3.what);     // Catch: JSONException -> L15
        if (r3.getTarget() == null) goto L9;
        r0.put("target", String.valueOf(r3.getTarget()));     // Catch: JSONException -> L15
    L10:
        r0.put("arg1", r3.arg1);     // Catch: JSONException -> L15
        r0.put("arg2", r3.arg2);     // Catch: JSONException -> L15
        Object r5 = r3.obj;     // Catch: JSONException -> L15
        if (r5 == null) goto L13;
        r0.put("obj", String.valueOf(r5));     // Catch: JSONException -> L15
    L13:
        r0.put("start", r3.getWhen());     // Catch: JSONException -> L15
        r0.put("end", -1);     // Catch: JSONException -> L15
    L17:
        return r0;
    L9:
        r0.put("barrier", r3.arg1);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public final Pair<String, ?> b(long r1, long r3) {
        return new Pair(((AbsMonitor) this).a, g());
    L4:
        return null;
    }

    public static void e(b r13, boolean r14, long r15) {
        int r0 = r13.g + 1;
        r13.g = r0;
        r13.g = r0 & 65535;
        r13.r = false;
        if (r13.k >= 0) goto L6;
        r13.k = r15;
    L6:
        if (r13.l >= 0) goto L9;
        r13.l = r15;
    L9:
        if (r13.m >= 0) goto L11;
        r13.m = Process.myTid();
        r13.n = SystemClock.currentThreadTimeMillis();
    L11:
        c r10 = c27.d.c;
        c27.d.c = null;
        long r1 = r15 - r13.k;
        long r2 = r13.i;
        if (r1 > r2) goto L14;
        if (r10 != null) goto L14;
    L28:
        r13.l = r15;
        return;
    L14:
        long r4 = r13.l;
        if ((r15 - r4) > r2) goto L19;
        if (r10 != null) goto L19;
        r13.h(9, r15, r13.p, true, null);
    L19:
        if (r14 == false) goto L25;
        if (r13.f != 0) goto L23;
        r13.h(1, r15, "no message running", true, null);
        goto L28
    L23:
        r13.h(9, r4, r13.o, true, null);
        r13.h(1, r15, "no message running", false, null);
        goto L28
    L25:
        if (r13.f != 0) goto L27;
        r13.h(8, r15, r13.p, true, r10);
        goto L28
    L27:
        r13.h(9, r4, r13.o, false, null);
        r13.h(8, r15, r13.p, true, r10);
        goto L28
    }

    public final void h(int r16, long r17, String r19, boolean r20, c r21) {
        this.r = true;
        f r6 = this.j;
        e r7 = r6.c;
        if (r7 == null) goto L5;
        r7.d = r16;
        r6.c = null;
    L6:
        r7.f = r17 - this.k;
        if (r20 == false) goto L9;
        long r11 = SystemClock.currentThreadTimeMillis();
        r7.g = r11 - this.n;
        this.n = r11;
    L10:
        r7.e = this.f;
        r7.i = r19;
        r7.a = this.k;
        r7.b = r17;
        r7.c = this.l;
        if (r21 == null) goto L13;
        r7.h = r21;
    L13:
        f r1 = this.j;
        int r4 = ((ArrayList) r1.d).size();
        int r8 = r1.a;
        if (r4 >= r8) goto L16;
        ((ArrayList) r1.d).add(r7);
        r1.b = ((ArrayList) r1.d).size();
    L17:
        this.f = 0;
        this.k = r17;
        return;
    L16:
        int r5 = r1.b % r8;
        r1.b = r5;
        e r9 = (e) ListProtector.set(r1.d, r5, r7);
        r9.d = -1;
        r9.e = -1;
        r9.f = -1;
        r9.i = null;
        r9.j = null;
        r9.k = null;
        r9.l = null;
        r9.m = null;
        r9.n = null;
        r9.h = null;
        r1.c = r9;
        r1.b++;
        goto L17
    L9:
        r7.g = -1;
        goto L10
    L5:
        r7 = new e();
        r7.d = r16;
        goto L6
    }
}
