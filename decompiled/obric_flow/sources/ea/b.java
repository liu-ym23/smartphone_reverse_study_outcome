package ea;

import android.content.Context;
import android.database.Cursor;
import android.os.Message;
import android.text.TextUtils;
import com.lynx.tasm.ui.image.h;
import ia.f;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ia.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16799c;
    public c d;
    public String e;
    public Context f;
    public JSONObject g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f16800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f16801i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f16802j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f16803k;

    @Override // ia.b
    public final void a(long r21) {
        long r5 = this.f16803k;
        boolean r10 = true;
        if (r5 <= 0) goto L8;
        if ((r21 - this.f16802j) <= r5) goto L8;
        this.f16800h = true;
        this.f16803k = 0;
    L8:
        if (this.f16800h == true) goto L10;
        return;
    L10:
        if (this.f16801i == true) goto L91;
        long r11 = System.currentTimeMillis();
        c r12 = this.d;
        String r13 = this.e;
        monitor-enter(r12);
    L20:
        th = move-exception;
        throw th;
    L15:
        if (r12.f16807b <= 10) goto L17;
    L22:
        int r14 = r12.d(r13);     // Catch: Throwable -> L20
        r12.f16806a.put(r13, Integer.valueOf(r14));     // Catch: Throwable -> L20
        r12.f16807b = 0;     // Catch: Throwable -> L20
        int r15 = r14;
    L24:
        monitor-exit(r12);
        long r16 = r15;
        if (r16 <= 0) goto L92;
        int r17 = this.f16799c;
        if (r16 <= r17) goto L31;
    L32:
        this.f16797a = r11;
        String r18 = this.e;
        int r19 = Integer.parseInt(r18);
        c r20 = this.d;
        r20.getClass();
        Cursor r22 = null;
        LinkedList r23 = null;
        Cursor r24 = r20.d.query("monitor_log", c.f16804h, "aid= ?", new String[]{String.valueOf(r19)}, null, null, "_id ASC ", r17 + "");     // Catch: Throwable -> L71
    L42:
        r22 = r24;
        goto L43
    L35:
        if (r24.getCount() != 0) goto L37;
    L36:
        c.f(r24);
        List r25 = r23;
    L44:
        if (r25 != null) goto L46;
        return;
    L46:
        if (r25.size() == 0) goto L93;
        JSONArray r26 = new JSONArray();     // Catch: Throwable -> L72
        LinkedList r27 = new LinkedList();     // Catch: Throwable -> L72
        Iterator r28 = r25.iterator();     // Catch: Throwable -> L72
        long r29 = -1;
    L50:
        if (r28.hasNext() == false) goto L75;
        ga.a r30 = (ga.a) r28.next();     // Catch: Throwable -> L72
        long r110 = r30.f17074a;     // Catch: Throwable -> L72
        if (r110 <= r29) goto L54;
        r29 = r110;
    L54:
        String r111 = r30.e;     // Catch: Throwable -> L72
        r27.add(r30);     // Catch: Throwable -> L72
        JSONObject r31 = new JSONObject(r111);     // Catch: Throwable -> L69
        r31.put("log_id", r110);     // Catch: Throwable -> L69
        r31.put("d_s_t", System.currentTimeMillis());     // Catch: Throwable -> L69
        r26.put(r31);     // Catch: Throwable -> L69
        goto L50
    L75:
        JSONObject r32 = new JSONObject();     // Catch: Throwable -> L70
        if (r26.length() == 0) goto L59;
        r32.put("data", r26);     // Catch: Throwable -> L70
        JSONObject r33 = this.g;     // Catch: Throwable -> L70
        if (r33 == null) goto L63;
        r32.put("header", r33);     // Catch: Throwable -> L70
        r10 = ha.c.a(r18, r32.toString());     // Catch: Throwable -> L70
    L63:
        if (r10 == false) goto L90;
        b(r29);     // Catch: Throwable -> L72
        return;
    L90:
        return;
    L59:
        r10 = false;
    L95:
        return;
    L93:
        return;
    L37:
        r23 = new LinkedList();     // Catch: Throwable -> L42
    L39:
        if (r24.moveToNext() == false) goto L36;
        long r34 = r24.getLong(r24.getColumnIndex("_id"));     // Catch: Throwable -> L42
        String r35 = r24.getString(r24.getColumnIndex("data"));     // Catch: Throwable -> L42
        ga.a r36 = new ga.a();     // Catch: Throwable -> L42
        r36.f17074a = r34;     // Catch: Throwable -> L42
        r36.e = r35;     // Catch: Throwable -> L42
        r23.add(r36);     // Catch: Throwable -> L42
    L43:
        c.f(r22);
        r25 = Collections.emptyList();
        goto L44
    L31:
        if (((r11 - this.f16797a) / 1000) > this.f16798b) goto L32;
        return;
    L92:
        return;
    L17:
        if (r12.f16806a.containsKey(r13) == false) goto L22;
        r15 = ((Integer) r12.f16806a.get(r13)).intValue();     // Catch: Throwable -> L20
        r12.f16807b++;     // Catch: Throwable -> L20
        goto L24
    }

    public final int b(long r5) {
        c r10 = this.d;
        String r11 = this.e;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r10.d != null) goto L7;
    L14:
        monitor-exit(r10);
        return -1;
    L7:
        if (r5 < 0) goto L14;
        String[] r12 = {r11, String.valueOf(r5)};     // Catch: Throwable -> L12
        int r13 = r10.d.delete("monitor_log", "aid = ? AND _id<= ? ", r12);     // Catch: Throwable -> L12
        r10.a(r13 * (-1), r11);     // Catch: Throwable -> L12
        monitor-exit(r10);
        return r13;
    }

    public final void c() {
        i4.a r5 = ia.c.f17555a;
        r5.getClass();
        f r10 = (f) r5.f17502b;
        ((CopyOnWriteArraySet) r5.d).add(this);     // Catch: Throwable -> L8
        h r11 = (h) r5.f17503c;
        r10.a(r11);     // Catch: Throwable -> L8
        r10.b(Message.obtain(r10.d, r11), 5000);     // Catch: Throwable -> L8
    L6:
        ha.b r12 = new ha.b();
        String r13 = this.e;
        r12.e = r13;
        q7.a r14 = new q7.a(7, r12, r13);
        s6.c r15 = new s6.c(8, r12, false, r13);
        r12.f17291a = new ha.a(r12, this.f.getApplicationContext(), r14, r15, r13);
        ha.c.f17297b.put(r13, r12);
    }

    public final void d() {
        ConcurrentHashMap r5 = fa.c.f16887a;
        String r10 = this.e;
        if (TextUtils.isEmpty(r10) == true) goto L7;
        ConcurrentHashMap r11 = fa.c.f16887a;
        if (r11.get(r10) == null) goto L7;
        int r12 = ((fa.b) r11.get(r10)).b();
    L8:
        if (r12 <= 0) goto L12;
        this.f16798b = r12;
    L12:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        ConcurrentHashMap r13 = fa.c.f16887a;
        if (r13.get(r10) == null) goto L16;
        int r14 = ((fa.b) r13.get(r10)).g();
    L17:
        if (r14 <= 0) goto L21;
        this.f16799c = r14;
    L21:
        if (TextUtils.isEmpty(r10) == true) goto L25;
        ConcurrentHashMap r15 = fa.c.f16887a;
        if (r15.get(r10) == null) goto L25;
        JSONObject r16 = ((fa.b) r15.get(r10)).d();
    L26:
        this.g = r16;
        ha.b r17 = (ha.b) ha.c.f17297b.get(r10);
        if (r17 == null) goto L30;
        r17.f17291a.d = null;
        return;
    L30:
        return;
    L25:
        r16 = null;
    L16:
        r14 = 100;
    L7:
        r12 = 120;
        goto L8
    }
}
