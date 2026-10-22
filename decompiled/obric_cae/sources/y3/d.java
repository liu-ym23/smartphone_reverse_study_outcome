package y3;

import c4.l;
import i4.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f13954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f13955b;

    public d(c r8, ArrayList r10) {
        this.f13955b = r8;
        this.f13954a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13955b.f13938n.getClass();
        c r8 = this.f13955b;
        String[] r13 = r8.f13937m.f11396d.d(r8, true, null);
        c r15 = this.f13955b;
        List<r4.a> r14 = this.f13954a;
        r15.d().getClass();
        JSONObject r10 = r15.f13942r.a();
        defpackage.c.n0(r10);
        int r11 = r13.length;
        r3.c r12 = r15.f13937m;
        if (r11 <= 0) goto L71;
        r12.getClass();
        r4.i r16 = new r4.i();
        JSONArray[] r17 = {null, new JSONArray(), null};     // Catch: Throwable -> L37
        long[] r18 = new long[3];     // Catch: Throwable -> L37
        Iterator<r4.a> r19 = r14.iterator();     // Catch: Throwable -> L37
    L7:
        if (r19.hasNext() == false) goto L9;
        r17[1].put(r19.next().m());     // Catch: Throwable -> L37
        goto L7
    L9:
        r4.i r21 = r16;
        r3.c r20 = r12;
        r16.u(r12.f11401i, r10, null, null, null, r17, r18, null, null, 8);     // Catch: Throwable -> L35
        r21.v();     // Catch: Throwable -> L35
        String r22 = r20.f11401i;     // Catch: Throwable -> L35
        if (l.b() == false) goto L15;
    L16:
        long r23 = 0;
    L41:
        i4.f r24 = r20.f11417y;
        boolean r25 = true;
        r4.i r26 = r21;
        byte[] r27 = r26.H;
        if (r27 != null) goto L44;
    L70:
        List<r4.a> r28 = r14;
        c r29 = r15;
        boolean r30 = false;
    L73:
        Iterator<r4.a> r31 = r28.iterator();
        if (r30 == true) goto L82;
    L76:
        if (r31.hasNext() == false) goto L80;
        r4.a r32 = r31.next();
        if (r32.C <= 0) goto L76;
        l6.a.P0(r20.f11417y, i4.a.B, r32);
        goto L76
    L80:
        r29.f13947w.obtainMessage(8, r28).sendToTarget();
        return;
    L82:
        if (r31.hasNext() == false) goto L86;
        r4.a r33 = r31.next();
        if (r33.C <= 0) goto L82;
        l6.a.P0(r20.f11417y, i4.a.J, r33);
        goto L82
    L86:
        r20.f11417y.b(k.f8264p, r28.size());
        r29.b().m(r28);
        return;
    L44:
        if (r27.length <= 0) goto L70;
        r28 = r14;
        r29 = r15;
        int r34 = r20.f11397e.f(r13, r27, r15, new String[]{r26.U, r26.V}, r26.X, r26.Y, null, true);
        if (r34 != 200) goto L49;
        r29.f13948x = r23;
    L58:
        if (r25 == false) goto L60;
        k r35 = k.Y;
    L61:
        r24.b(r35, r28.size());
        if (l.b() == true) goto L72;
        String r36 = r20.f11401i;
        HashSet r37 = r26.r();
        List<String> r38 = i.f13964k;
        if (r37.isEmpty() == true) goto L72;
        if (l.b() == true) goto L72;
        l.c("event_upload_eid", new h(r36, r37, r25));
    L72:
        r20.H.l(0, c.G, "sendRealTime: {}", new Object[]{Boolean.valueOf(r25)});
        r30 = r25;
        goto L73
    L60:
        r35 = k.Z;
        goto L61
    L49:
        if (r34 >= 500) goto L51;
    L53:
        r25 = false;
    L54:
        if (r25 == false) goto L56;
        r29.f13948x = System.currentTimeMillis();
    L56:
        r25 = false;
        goto L58
    L51:
        if (r34 >= 600) goto L53;
    L15:
        if (r14.isEmpty() == true) goto L16;
        JSONArray r39 = new JSONArray();     // Catch: Throwable -> L35
        Iterator<r4.a> r40 = r14.iterator();     // Catch: Throwable -> L35
    L19:
        if (r40.hasNext() == false) goto L92;
        r4.a r41 = r40.next();     // Catch: Throwable -> L35
        if (r41 == null) goto L19;
        long r42 = r41.A;     // Catch: Throwable -> L35
        long r43 = 0;
        if (r42 <= 0) goto L19;
        r39.put(r42);     // Catch: Throwable -> L27
    L27:
        th = th;
    L34:
        r23 = r43;
    L40:
        r20.H.k(th, 4, "pack real time failed", new Object[0]);
        goto L41
    L92:
        l.c("event_realtime_eid", new r4.h(r22, r39));     // Catch: Throwable -> L32
        r23 = 0;
    L32:
        th = th;
        r43 = 0;
    L35:
        th = th;
    L39:
        r23 = 0;
    L37:
        th = th;
        r21 = r16;
        r20 = r12;
        goto L39
    L71:
        r20 = r12;
        r28 = r14;
        r29 = r15;
        r25 = false;
        goto L72
    }
}
