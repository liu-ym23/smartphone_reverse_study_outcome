package a6;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal.ws.RealWebSocket;
import oo.j;
import org.json.JSONObject;
import wn.f;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f114b;

    public static boolean b(d r5, List r10) {
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L25;
        m6.a r14 = (m6.a) r13.next();
        if (r14.d == true) goto L7;
        r12.add(r14);
        goto L4
    L7:
        r11.add(r14);
        goto L4
    L25:
    L22:
        e = move-exception;
        j.h(e, "divideByChargingStatusAndReport");
        return false;
    L11:
        if (r11.isEmpty() == false) goto L13;
    L15:
        boolean r15 = true;
    L17:
        if (r12.isEmpty() == true) goto L33;
        if (g(r5, r12) == true) goto L33;
        return false;
    L33:
        return r15;
    L13:
        if (g(r5, r11) == true) goto L15;
        r15 = false;
        goto L17
    }

    public static boolean c(d r5, List r10) {
        HashMap r11 = new HashMap(4);
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L21;
        m6.a r13 = (m6.a) r12.next();
        String r14 = r13.e;
        List r15 = (List) r11.get(r14);
        if (r15 != null) goto L7;
        LinkedList r16 = new LinkedList();
        r16.add(r13);
        r11.put(r14, r16);
        goto L4
    L7:
        r15.add(r13);
        goto L4
    L21:
        Iterator r17 = r11.values().iterator();     // Catch: Exception -> L16
        boolean r18 = true;
    L12:
        if (r17.hasNext() == false) goto L34;
        if (b(r5, (List) r17.next()) == true) goto L12;
        r18 = false;
        goto L12
    L34:
        return r18;
    L16:
        e = move-exception;
        j.h(e, "divideBySceneAndReport");
        return false;
    }

    public static boolean g(d r10, ArrayList r11) {
        ConcurrentHashMap r5 = w5.c.f22719a.f;
        StringBuilder r12 = new StringBuilder();
        Iterator r13 = r11.iterator();
        String r14 = null;
    L4:
        if (r13.hasNext() == false) goto L19;
        m6.a r15 = (m6.a) r13.next();
        if (r14 != null) goto L8;
    L9:
        r14 = r15.f20015i;
        r12.append(r14);
    L11:
        if ("ground_record".equals(r15.f20013c) == true) goto L12;
        b6.a r16 = (b6.a) r5.get(r15.f20013c);
        if (r16 == null) goto L4;
        r16.b(r10, r15);
        goto L4
    L12:
        long r17 = r15.f;
        if (r15.f20011a == true) goto L14;
        r10.f116b += r17;
        goto L4
    L14:
        r10.f115a += r17;
        goto L4
    L8:
        if (r14.equals(r15.f20015i) == true) goto L11;
    L19:
        m6.a r18 = (m6.a) r11.get(0);
        r10.f132w = r18.f20014h;
        r10.f133x = r18.g;
        r10.f134y = r12.toString();
        r10.f135z = r18.e;
        r10.f131v = r18.d;
        r11.size();
        return r10.c(true);
    }

    public static void i(m6.a r5) {
        JSONObject r10 = new JSONObject();
        r10.put("front", r5.f20011a);
        r10.put("time", r5.f20012b);
        String r11 = r5.f20013c;
        r10.put("type", r11);
        r10.put("scene", r5.e);
        r10.put("processName", r5.g);
        boolean r12 = TextUtils.equals(r11, "cpu_active_time");
        long r13 = r5.f;
        if (r12 == false) goto L6;
        r10.put("accumulation", (r13 * 1000) / com.bytedance.apm.util.a.j());
    L9:
        r10.toString();
        return;
    L6:
        if (TextUtils.equals(r11, "traffic") == false) goto L8;
        r10.put("accumulation", r13 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
        goto L9
    L8:
        r10.put("accumulation", r13);
        goto L9
    }

    public void a(long r5) {
    L12:
        e = move-exception;
        j.h(e, "cleanBatteryLog");
        return;
    L3:
        monitor-enter(e());     // Catch: Exception -> L12
        new ContentValues().put("delete_flag", 1);     // Catch: Throwable -> L9
        String.valueOf(r5);     // Catch: Throwable -> L9
        boolean r10 = com.bytedance.apm.j.f3887a;     // Catch: Exception -> L7 Throwable -> L9
        throw null;     // Catch: Exception -> L7 Throwable -> L9
    L19:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Exception -> L12
    }

    public List d(long r5, boolean r10) {
        z5.a r11 = e();     // Catch: Exception -> L16
        monitor-enter(r11);     // Catch: Exception -> L16
        if (r10 == true) goto L22;
        String.valueOf(r5);     // Catch: Throwable -> L13
        throw null;     // Catch: Throwable -> L10
    L10:
        List r12 = Collections.emptyList();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r11);     // Catch: Exception -> L16
        return r12;
    L22:
        throw null;     // Catch: Throwable -> L7
    L7:
        r12 = Collections.emptyList();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L17:
        return Collections.emptyList();
    }

    public z5.a e() {
        monitor-enter(z5.a.class);
        new HashMap();     // Catch: Throwable -> L8
        boolean r5 = com.bytedance.apm.j.f3887a;     // Catch: Throwable -> L8
        throw null;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public JSONObject f() {
        JSONObject r5 = new JSONObject();
        List r11 = d(0, true);
        if (f.j(r11) == false) goto L5;
        return r5;
    L5:
        d r10 = new d();
        ConcurrentHashMap r12 = w5.c.f22719a.f;
        StringBuilder r13 = new StringBuilder();
        Iterator r14 = r11.iterator();
        String r15 = null;
    L7:
        if (r14.hasNext() == false) goto L22;
        m6.a r16 = (m6.a) r14.next();
        if (r15 != null) goto L11;
    L12:
        r15 = r16.f20015i;
        r13.append(r15);
    L14:
        if ("ground_record".equals(r16.f20013c) == true) goto L15;
        b6.a r17 = (b6.a) r12.get(r16.f20013c);
        if (r17 == null) goto L7;
        r17.b(r10, r16);
        goto L7
    L15:
        boolean r18 = r16.f20011a;
        long r19 = r16.f;
        if (r18 == true) goto L17;
        r10.f116b += r19;
        goto L7
    L17:
        r10.f115a += r19;
        goto L7
    L11:
        if (r15.equals(r16.f20015i) == true) goto L14;
    L22:
        m6.a r110 = (m6.a) r11.get(0);
        r10.f132w = r110.f20014h;
        r10.f133x = r110.g;
        r10.f134y = r13.toString();
        JSONObject r111 = r10.a(true);     // Catch: Exception -> L26
        if (r111 == null) goto L28;
        return r111;
    L28:
        return r5;
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    public void h() {
        if (com.bytedance.apm.j.d() == true) goto L5;
        return;
    L5:
        d r5 = new d();
        List r10 = d(0, true);
        if (f.j(r10) == false) goto L8;
        return;
    L8:
        boolean r11 = c(r5, r10);
        r5.b();
        m6.a r12 = (m6.a) r10.get(r10.size() - 1);
        r12.getClass();
        if (r11 == true) goto L16;
        if (com.bytedance.apm.j.f3887a == false) goto L13;
        Log.w("<monitor><battery>", com.bytedance.android.anniex.base.service.f.o(new String[]{"report main process data failed, clean data and stop calc data of other process"}));
    L13:
        a(0);
        return;
    L16:
        if (com.bytedance.apm.j.f3887a == false) goto L18;
        Log.i("<monitor><battery>", com.bytedance.android.anniex.base.service.f.o(new String[]{"report main process data over, begin handle other process data"}));
    L18:
        List r13 = d(r12.f20012b, false);
        HashMap r14 = new HashMap(4);
        Iterator r15 = r13.iterator();
    L20:
        if (r15.hasNext() == false) goto L37;
        m6.a r16 = (m6.a) r15.next();
        String r17 = r16.g;
        List r18 = (List) r14.get(r17);
        if (r18 != null) goto L23;
        LinkedList r19 = new LinkedList();
        r19.add(r16);
        r14.put(r17, r19);
        goto L20
    L23:
        r18.add(r16);
        goto L20
    L37:
        Iterator r20 = r14.values().iterator();     // Catch: Exception -> L30
    L27:
        if (r20.hasNext() == false) goto L32;
        c(r5, (List) r20.next());     // Catch: Exception -> L30
        r5.b();     // Catch: Exception -> L30
    L32:
        r5.f118h = r5.C;
        r5.e = r5.F;
        r5.f = r5.D;
        r5.g = r5.E;
        r5.f115a = r5.A;
        r5.f119i = r5.G;
        r5.f120j = r5.H;
        r5.f121k = r5.I;
        r5.f122l = r5.J;
        r5.f127q = r5.K;
        r5.f124n = r5.N;
        r5.f125o = r5.L;
        r5.f126p = r5.M;
        r5.f116b = r5.B;
        r5.f128r = r5.O;
        r5.s = r5.P;
        r5.f129t = r5.Q;
        r5.f130u = r5.R;
        r5.f132w = false;
        r5.f133x = "all_process";
        r5.f131v = false;
        r5.f135z = "";
        r5.c(false);     // Catch: Exception -> L36
    L34:
        a(0);
        return;
    L30:
        e = move-exception;
        j.h(e, "reportLastTimeBattery");
        goto L32
    }
}
