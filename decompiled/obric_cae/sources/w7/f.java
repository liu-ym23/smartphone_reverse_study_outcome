package w7;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import com.obric.cae.userAware.WifiScanStateMachine;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class f extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13051b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f13052m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f13053n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f13054o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f13055p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f13056q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d f13057r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinkedList<b> f13058s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13059t;

    public f(Context r8, d r10, LinkedList<b> r11, AtomicBoolean r12) {
        super("LogSender");
        this.f13051b = new Object();
        this.f13054o = -1;
        this.f13055p = 0;
        this.f13056q = 120000;
        this.f13057r = r10;
        this.f13050a = r8;
        this.f13058s = r11;
        this.f13052m = r12;
        if (e.f13048c == null) goto L5;
    L14:
        this.f13053n = e.f13048c;
        return;
    L5:
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e.f13048c != null) goto L9;
        e.f13048c = new e(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static boolean b(a r8, String r10, byte[] r11) {
        if (r11 != null) goto L4;
        return false;
    L4:
        if (r11.length > 0) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        return false;
    L9:
        return r8.a(r10, r11);
    }

    public final boolean a() {
        return this.f13052m.get();
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
    L4:
        if (a() == true) goto L250;
        boolean r8 = false;
        Cursor r10 = null;
        if (a() == true) goto L13;
        LinkedList<b> r11 = this.f13058s;
        monitor-enter(r11);
        if (a() == false) goto L15;
        monitor-exit(r11);     // Catch: Throwable -> L247
        goto L13
    L15:
        if (this.f13058s.isEmpty() == true) goto L17;
        b r12 = this.f13058s.poll();     // Catch: Throwable -> L247
    L18:
        boolean r13 = !this.f13058s.isEmpty();     // Catch: Throwable -> L247
        monitor-exit(r11);     // Catch: Throwable -> L247
        if (r12 == null) goto L27;
    L25:
        this.f13053n.e();
        goto L27
    L22:
        if (this.f13053n.b(r12.f13039e, r12.f13036b) < Long.MAX_VALUE) goto L27;
        this.f13053n.e();     // Catch: SQLiteFullException -> L25
    L27:
        if (a() == true) goto L294;
        if (a() == false) goto L33;
    L116:
        boolean r20 = false;
        boolean r14 = true;
        boolean r15 = false;
    L217:
        if (r20 == true) goto L222;
        if (r13 == true) goto L222;
        r14 = r15;
    L222:
        if (a() == true) goto L295;
        if (r14 == true) goto L4;
        Object r16 = this.f13051b;
        monitor-enter(r16);
        long r17 = this.f13056q;     // Catch: Throwable -> L233 InterruptedException -> L252
        if (r17 != 0) goto L231;
        this.f13051b.wait();     // Catch: Throwable -> L233 InterruptedException -> L252
        goto L235
    L231:
        this.f13051b.wait(r17);     // Catch: Throwable -> L233 InterruptedException -> L252
        goto L235
    L233:
        th = move-exception;
        throw th;
    L235:
        monitor-exit(r16);     // Catch: Throwable -> L233
        goto L4
    L295:
        return;
    L33:
        if (this.f13054o >= 0) goto L59;
        if ((System.currentTimeMillis() - this.f13055p) <= 600000) goto L59;
        this.f13054o = 0;
        if (a() == true) goto L57;
        ConcurrentHashMap r18 = this.f13057r.f13043a;
        e r19 = this.f13053n;
        if (r18 != null) goto L42;
    L56:
        r19.a(-1, null, 864000000);
        goto L57
    L42:
        if (r18.isEmpty() == true) goto L56;
        Iterator r21 = r18.keySet().iterator();
    L45:
        if (r21.hasNext() == false) goto L56;
        String r110 = (String) r21.next();
        if (a() == true) goto L56;
        a r111 = (a) r18.get(r110);
        if (r111 == null) goto L45;
        a.b r112 = r111.f13030b;
        if (r112 == null) goto L45;
        r19.a(((t7.a.C0162a) r112).b(), r110, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS);
    L57:
        this.f13055p = System.currentTimeMillis();
    L59:
        if (c.f13040a.a(this.f13050a) == true) goto L61;
        this.f13056q = 120000;
        goto L116
    L61:
        e r22 = this.f13053n;
        long r113 = this.f13054o;
        monitor-enter(r22);
    L244:
        th = move-exception;
        throw th;
    L64:
        if (r22.c() == true) goto L277;
        monitor-exit(r22);
        b r114 = null;
    L87:
        if (r114 == null) goto L89;
        long r115 = this.f13054o;
        long r23 = r114.f13035a;
        if (r115 >= r23) goto L120;
        this.f13054o = r23;
    L121:
        byte[] r24 = r114.f13036b;
        if (r24 != null) goto L124;
    L200:
        r15 = false;
        boolean r25 = false;
        r8 = true;
        t7.a.C0162a r26 = null;
        a r116 = null;
    L202:
        if (a() == false) goto L205;
        r14 = true;
    L204:
        r20 = true;
        goto L217
    L205:
        e r27 = this.f13053n;
        if (r8 == false) goto L208;
        r27.d(r114.f13035a, true, 0, 0);
        r14 = true;
    L216:
        r20 = r14;
        goto L217
    L208:
        long r28 = r114.f13035a;
        r26.getClass();
        if (r27.d(r28, r25, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS, r26.b()) == false) goto L214;
        r14 = true;
        long r29 = r26.d() * ((long) (r114.f13037c + 1));
        if (r29 <= 0) goto L213;
        this.f13056q = r29;
    L213:
        this.f13056q = Math.min(120000, this.f13056q);
    L215:
        r116.getClass();
        goto L216
    L214:
        r14 = true;
        this.f13056q = 120000;
        goto L215
    L124:
        if (r24.length <= 0) goto L200;
        a r30 = (a) this.f13057r.f13043a.get(r114.f13039e);
        if (r30 != null) goto L129;
        r20 = true;
        r15 = false;
        r14 = true;
        goto L217
    L129:
        a.b r31 = r30.f13030b;
        a.c r32 = r30.f13033e;
        long r117 = System.currentTimeMillis();
        t7.a.C0162a r118 = (t7.a.C0162a) r31;
        long r119 = r118.d();
        if (r32 == null) goto L154;
        t7.a.b r33 = (t7.a.b) r32;
        ConcurrentHashMap<String, r7.b> r120 = r7.c.f11537a;
        String r34 = r33.f12294a;
        if (TextUtils.isEmpty(r34) == true) goto L136;
        ConcurrentHashMap<String, r7.b> r121 = r7.c.f11537a;
        if (r121.get(r34) == null) goto L136;
        boolean r35 = r121.get(r34).c();
    L137:
        if (r35 == false) goto L139;
        r25 = true;
        r116 = r30;
        r26 = r118;
        r15 = false;
        goto L202
    L139:
        t7.a r36 = r33.f12295b;
        if (r36.f12284b <= r36.f12289g) goto L142;
        long r37 = r36.f12284b;
    L144:
        if (r37 > r36.f12290h) goto L148;
        r37 = r36.f12290h;
    L148:
        if (r37 > 0) goto L150;
    L152:
        r30.f13034f = System.currentTimeMillis();
        goto L154
    L150:
        if ((r117 - r30.f13034f) >= r37) goto L152;
    L162:
        r14 = true;
        r15 = false;
        goto L204
    L142:
        r37 = r36.f12289g;
    L136:
        r35 = false;
    L154:
        if (r119 <= 0) goto L160;
        int r38 = r114.f13037c;
        if (r38 <= 0) goto L160;
        if ((r117 - r114.f13038d) < (r119 * ((long) r38))) goto L162;
    L160:
        String r39 = r30.f13032d;
        List<String> r40 = r118.a();
        if (r40 == null) goto L162;
        String r41 = r118.c();     // Catch: Throwable -> L194
        if (TextUtils.isEmpty(r41) == true) goto L167;
        boolean r42 = b(r30, r41, r114.f13036b);     // Catch: Throwable -> L194
    L175:
        r15 = false;
    L199:
        r25 = r42;
        r8 = r15;
        r116 = r30;
        r26 = r118;
        goto L202
    L167:
        if (TextUtils.isEmpty(r39) == true) goto L177;
        boolean r43 = b(r30, r39, r114.f13036b);     // Catch: Throwable -> L194
        if (r43 == true) goto L174;
        String r44 = "";
        r15 = false;
    L262:
        r30.f13032d = r44;     // Catch: Throwable -> L190
    L198:
        r42 = r43;
    L190:
        th = th;
    L197:
        th.toString();
        goto L198
    L174:
        r42 = r43;
        goto L175
    L177:
        if (((t7.a.b) r32).f12295b.f12285c == false) goto L179;
        this.f13059t++;     // Catch: Throwable -> L194
    L179:
        int r45 = r40.size();     // Catch: Throwable -> L194
        int r46 = this.f13059t;     // Catch: Throwable -> L194
        if (r45 <= r46) goto L184;
        if (r46 < 0) goto L184;
        String r47 = r40.get(r46);     // Catch: Throwable -> L194
        r15 = false;
    L266:
        r44 = r47;     // Catch: Throwable -> L192
        r43 = b(r30, r44, r114.f13036b);     // Catch: Throwable -> L192
        if (r43 == false) goto L198;
    L192:
        th = th;
    L196:
        r43 = r15;
    L184:
        r15 = false;
        this.f13059t = 0;     // Catch: Throwable -> L192
        r47 = r40.get(0);     // Catch: Throwable -> L192
    L194:
        th = th;
        r15 = false;
        goto L196
    L120:
        this.f13054o = r115 + 1;
        goto L121
    L89:
        if (this.f13054o != 0) goto L113;
        e r48 = this.f13053n;
        monitor-enter(r48);
    L109:
        th = move-exception;
        throw th;
    L93:
        if (r48.c() == true) goto L275;
        monitor-exit(r48);
        long r122 = 0;
    L107:
        if (r122 != 0) goto L113;
        this.f13056q = 0;
        goto L116
    L275:
        String r123 = "select count(*) from queue";
        if (TextUtils.isEmpty(null) == true) goto L99;
        r123 = "select count(*) from queue null";     // Catch: Throwable -> L251
    L99:
        r10 = r48.f13049a.rawQuery(r123, null);     // Catch: Throwable -> L251
        if (r10.moveToNext() == false) goto L103;
        r122 = r10.getLong(0);     // Catch: Throwable -> L251
    L104:
        e.f(r10);     // Catch: Throwable -> L109
        monitor-exit(r48);
    L103:
        r122 = 0;
    L113:
        if (this.f13054o != (-1)) goto L115;
        this.f13056q = 120000;
    L115:
        this.f13054o = -1;
        goto L116
    L277:
        Cursor r124 = r22.f13049a.query("queue", e.f13047b, "_id > ?", new String[]{String.valueOf(r113)}, null, null, "_id ASC", "1");     // Catch: Throwable -> L80 Exception -> L82
    L78:
        e = e;
        r114 = null;
    L264:
        e.toString();     // Catch: Throwable -> L239
    L85:
        e.f(r124);     // Catch: Throwable -> L244
        monitor-exit(r22);
    L239:
        th = th;
        r10 = r124;
    L241:
        r124 = r10;
    L242:
        e.f(r124);     // Catch: Throwable -> L244
        throw th;     // Catch: Throwable -> L244
    L76:
        th = th;
        goto L242
    L69:
        if (r124.moveToNext() == false) goto L75;
        r114 = new b();     // Catch: Throwable -> L76 Exception -> L78
        r114.f13035a = r124.getLong(0);     // Catch: Exception -> L73 Throwable -> L76
        r114.f13036b = r124.getBlob(1);     // Catch: Exception -> L73 Throwable -> L76
        r114.f13039e = r124.getString(2);     // Catch: Exception -> L73 Throwable -> L76
        r124.getLong(3);     // Catch: Exception -> L73 Throwable -> L76
        r114.f13037c = r124.getInt(4);     // Catch: Exception -> L73 Throwable -> L76
        r114.f13038d = r124.getLong(5);     // Catch: Exception -> L73 Throwable -> L76
    L73:
        e = e;
        goto L264
    L75:
        r114 = null;
        goto L85
    L82:
        e = e;
        r124 = null;
        r114 = null;
    L80:
        th = th;
        goto L241
    L294:
        return;
    L17:
        r12 = null;
    L247:
        th = move-exception;
        throw th;
    L13:
        r13 = false;
        goto L27
    }
}
