package q7;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements u7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f10175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f10177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f10178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f10179h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f10180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f10181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f10182k;

    public b(Context r8, String r10) {
        this.f10172a = 0;
        this.f10173b = 120;
        this.f10174c = 100;
        this.f10179h = true;
        this.f10180i = false;
        this.f10177f = r8;
        if (c.f10186i == null) goto L5;
    L14:
        this.f10175d = c.f10186i;
        this.f10176e = r10;
        return;
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c.f10186i != null) goto L9;
        c.f10186i = new c(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // u7.b
    public final void a(long r21) {
        long r8 = this.f10182k;
        boolean r10 = true;
        if (r8 <= 0) goto L8;
        if ((r21 - this.f10181j) <= r8) goto L8;
        this.f10179h = true;
        this.f10182k = 0;
    L8:
        if (this.f10179h == true) goto L10;
        return;
    L10:
        if (this.f10180i == true) goto L86;
        long r11 = System.currentTimeMillis();
        c r12 = this.f10175d;
        String r13 = this.f10176e;
        monitor-enter(r12);
    L63:
        th = move-exception;
        throw th;
    L15:
        if (r12.f10188b <= 10) goto L17;
    L20:
        int r14 = r12.c(r13);     // Catch: Throwable -> L63
        r12.f10187a.put(r13, Integer.valueOf(r14));     // Catch: Throwable -> L63
        r12.f10188b = 0;     // Catch: Throwable -> L63
        int r15 = r14;
    L22:
        monitor-exit(r12);
        long r16 = r15;
        if (r16 <= 0) goto L87;
        int r17 = this.f10174c;
        if (r16 <= r17) goto L29;
    L30:
        this.f10172a = r11;
        int r18 = Integer.parseInt(this.f10176e);
        c r19 = this.f10175d;
        r19.getClass();
        Cursor r20 = null;
        LinkedList r22 = null;
        Cursor r23 = r19.f10190d.query("monitor_log", c.f10185h, "aid= ?", new String[]{String.valueOf(r18)}, null, null, "_id ASC ", r17 + "");     // Catch: Throwable -> L68
    L41:
        r20 = r23;
        goto L42
    L33:
        if (r23.getCount() == 0) goto L40;
        r22 = new LinkedList();     // Catch: Throwable -> L41
    L37:
        if (r23.moveToNext() == false) goto L40;
        r22.add(new s7.a(r23.getLong(r23.getColumnIndex("_id")), r23.getString(r23.getColumnIndex("data"))));     // Catch: Throwable -> L41
    L40:
        c.e(r23);
        List r24 = r22;
    L43:
        if (r24 != null) goto L45;
    L48:
        if (r10 == true) goto L88;
        JSONArray r25 = new JSONArray();     // Catch: Throwable -> L69
        LinkedList r26 = new LinkedList();     // Catch: Throwable -> L69
        Iterator r27 = r24.iterator();     // Catch: Throwable -> L69
        long r28 = -1;
    L52:
        if (r27.hasNext() == false) goto L60;
        s7.a r29 = (s7.a) r27.next();     // Catch: Throwable -> L69
        long r30 = r29.f12042a;     // Catch: Throwable -> L69
        if (r30 <= r28) goto L56;
        r28 = r30;
    L56:
        String r31 = r29.f12046e;     // Catch: Throwable -> L69
        r26.add(r29);     // Catch: Throwable -> L69
        JSONObject r32 = new JSONObject(r31);     // Catch: Throwable -> L67
        r32.put("log_id", r30);     // Catch: Throwable -> L67
        r32.put("d_s_t", System.currentTimeMillis());     // Catch: Throwable -> L67
        r25.put(r32);     // Catch: Throwable -> L67
        goto L52
    L60:
        if (c(r25) == false) goto L85;
        b(r28);     // Catch: Throwable -> L69
        return;
    L85:
        return;
    L90:
        return;
    L88:
        return;
    L45:
        if (r24.size() == 0) goto L48;
        r10 = false;
    L42:
        c.e(r20);
        r24 = Collections.emptyList();
        goto L43
    L29:
        if (((r11 - this.f10172a) / 1000) > this.f10173b) goto L30;
        return;
    L87:
        return;
    L17:
        if (r12.f10187a.containsKey(r13) == false) goto L20;
        r15 = ((Integer) r12.f10187a.get(r13)).intValue();     // Catch: Throwable -> L63
        r12.f10188b++;     // Catch: Throwable -> L63
        goto L22
    }

    public final int b(long r8) {
        c r10 = this.f10175d;
        String r11 = this.f10176e;
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r10.f10190d != null) goto L7;
    L12:
        monitor-exit(r10);
        return -1;
    L7:
        if (r8 < 0) goto L12;
        int r12 = r10.f10190d.delete("monitor_log", "aid = ? AND _id<= ? ", new String[]{r11, String.valueOf(r8)});     // Catch: Throwable -> L15
        r10.a(r12 * (-1), r11);     // Catch: Throwable -> L15
        monitor-exit(r10);
        return r12;
    }

    public final boolean c(JSONArray r8) {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L17
        if (r8.length() != 0) goto L6;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L9;
        return false;
    L9:
        r10.put("data", r8);     // Catch: Throwable -> L17
        JSONObject r12 = this.f10178g;     // Catch: Throwable -> L17
        if (r12 == null) goto L16;
        r10.put(CloudServiceConstants.OCloud.HEADER, r12);     // Catch: Throwable -> L17
        String r13 = this.f10176e;     // Catch: Throwable -> L17
        String r14 = r10.toString();     // Catch: Throwable -> L17
        ConcurrentHashMap<String, t7.c> r15 = t7.d.f12298a;     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r14) == true) goto L20;
        return t7.d.f12299b.get(r13).a(r14);
    L20:
        return false;
    L16:
        return true;
    L6:
        r11 = false;
    L17:
        return false;
    }

    public final void d() {
        ConcurrentHashMap<String, r7.b> r8 = r7.c.f11537a;
        String r10 = this.f10176e;
        if (TextUtils.isEmpty(r10) == true) goto L7;
        ConcurrentHashMap<String, r7.b> r11 = r7.c.f11537a;
        if (r11.get(r10) == null) goto L7;
        int r12 = r11.get(r10).b();
    L8:
        if (r12 <= 0) goto L12;
        this.f10173b = r12;
    L12:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        ConcurrentHashMap<String, r7.b> r13 = r7.c.f11537a;
        if (r13.get(r10) == null) goto L16;
        int r14 = r13.get(r10).h();
    L17:
        if (r14 <= 0) goto L21;
        this.f10174c = r14;
    L21:
        if (TextUtils.isEmpty(r10) == true) goto L25;
        ConcurrentHashMap<String, r7.b> r15 = r7.c.f11537a;
        if (r15.get(r10) == null) goto L25;
        JSONObject r16 = r15.get(r10).e();
    L26:
        this.f10178g = r16;
        t7.b r17 = t7.d.f12299b.get(r10);
        if ((r17 instanceof t7.a) == false) goto L30;
        ((t7.a) r17).f12283a.f13032d = null;
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
