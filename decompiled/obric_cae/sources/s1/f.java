package s1;

import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f11972m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j1.u f11973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j1.m f11974b;

    static {
        f11972m = androidx.work.m.f("EnqueueRunnable");
    }

    public f(j1.u r8, j1.m r10) {
        this.f11973a = r8;
        this.f11974b = r10;
    }

    public static boolean a(j1.u r23) {
        List<j1.u> r8 = r23.f8549i;
        String r10 = f11972m;
        if (r8 == null) goto L11;
        Iterator<j1.u> r11 = r8.iterator();
        boolean r12 = false;
    L6:
        if (r11.hasNext() == false) goto L12;
        j1.u r13 = r11.next();
        if (r13.f8550j == false) goto L9;
        androidx.work.m.d().g(r10, "Already enqueued work ids (" + TextUtils.join(", ", r13.f8547g) + ")");
        goto L6
    L9:
        r12 = r12 | a(r13);
    L12:
        String[] r14 = (String[]) j1.u.B(r23).toArray(new String[0]);
        long r15 = System.currentTimeMillis();
        j1.b0 r16 = r23.f8543c;
        WorkDatabase r17 = r16.f8453c;
        if (r14 != null) goto L15;
    L17:
        boolean r18 = false;
    L18:
        if (r18 == false) goto L35;
        int r19 = r14.length;
        int r110 = 0;
        boolean r111 = false;
        boolean r112 = false;
        boolean r113 = true;
    L20:
        if (r110 >= r19) goto L36;
        String r20 = r14[r110];
        r1.t r21 = r17.f().g(r20);
        if (r21 == null) goto L23;
        androidx.work.u.a r22 = r21.f11340b;
        if (r22 != androidx.work.u.a.f2954m) goto L27;
        boolean r24 = true;
    L28:
        r113 = r113 & r24;
        if (r22 != androidx.work.u.a.f2955n) goto L32;
        r112 = true;
    L34:
        r110 = r110 + 1;
        goto L20
    L32:
        if (r22 != androidx.work.u.a.f2957p) goto L34;
        r111 = true;
        goto L34
    L27:
        r24 = false;
        goto L28
    L23:
        androidx.work.m.d().b(r10, "Prerequisite " + r20 + " doesn't exist; not enqueuing");
    L60:
        boolean r114 = r12;
        boolean r25 = true;
        boolean r26 = false;
    L126:
        r23.f8550j = r25;
        return r114 | r26;
    L36:
        String r27 = r23.f8544d;
        boolean r28 = !TextUtils.isEmpty(r27);
        if (r28 == false) goto L40;
        if (r18 == true) goto L40;
        boolean r29 = true;
    L41:
        if (r29 == false) goto L97;
        ArrayList r30 = r17.f().l(r27);
        if (r30.isEmpty() == true) goto L97;
        androidx.work.g r115 = androidx.work.g.f2829m;
        androidx.work.g r116 = r23.f8545e;
        if (r116 != r115) goto L47;
    L66:
        r1.b r117 = r17.a();
        ArrayList r118 = new ArrayList();
        Iterator r31 = r30.iterator();
    L68:
        if (r31.hasNext() == false) goto L84;
        Iterator r119 = r31;
        r1.t.a r32 = (r1.t.a) r31.next();
        boolean r120 = r12;
        if (r117.d(r32.f11359a) == true) goto L83;
        androidx.work.u.a r33 = androidx.work.u.a.f2954m;
        androidx.work.u.a r121 = r32.f11360b;
        if (r121 != r33) goto L74;
        boolean r34 = true;
    L75:
        boolean r35 = r34 & r113;
        if (r121 != androidx.work.u.a.f2955n) goto L79;
        r112 = true;
    L81:
        r118.add(r32.f11359a);
        r113 = r35;
        goto L83
    L79:
        if (r121 != androidx.work.u.a.f2957p) goto L81;
        r111 = true;
        goto L81
    L74:
        r34 = false;
    L83:
        r117 = r117;
        r31 = r119;
        r12 = r120;
        goto L68
    L84:
        r114 = r12;
        List r122 = r118;
        r122 = r118;
        if (r116 != androidx.work.g.f2830n) goto L93;
        if (r111 == true) goto L88;
        if (r112 == false) goto L93;
    L88:
        r1.u r36 = r17.f();
        Iterator r37 = r36.l(r27).iterator();
    L90:
        if (r37.hasNext() == false) goto L92;
        r36.delete(((r1.t.a) r37.next()).f11359a);
        goto L90
    L92:
        r111 = false;
        r112 = false;
        r122 = Collections.emptyList();
    L93:
        r14 = (String[]) r122.toArray(r14);
        if (r14.length <= 0) goto L96;
        boolean r123 = true;
    L98:
        boolean r38 = false;
    L99:
        Iterator<? extends androidx.work.w> r39 = r23.f8546f.iterator();
    L101:
        if (r39.hasNext() == false) goto L125;
        androidx.work.w r124 = r39.next();
        r1.t r125 = r124.f2961b;
        if (r123 == false) goto L112;
        if (r113 == true) goto L112;
        if (r112 == false) goto L108;
        androidx.work.u.a r126 = androidx.work.u.a.f2955n;
    L111:
        r125.f11340b = r126;
    L113:
        long r127 = r15;
        if (r125.f11340b != androidx.work.u.a.f2952a) goto L116;
        r38 = true;
    L116:
        r1.u r40 = r17.f();
        he.i.f(r16.f8455e, "schedulers");
        r40.x(r125);
        UUID r41 = r124.f2960a;
        if (r123 == false) goto L121;
        int r42 = r14.length;
        int r128 = 0;
    L119:
        if (r128 >= r42) goto L121;
        int r129 = r42;
        String r43 = r14[r128];
        String[] r210 = r14;
        j1.b0 r211 = r16;
        String r44 = r41.toString();
        he.i.e(r44, "id.toString()");
        r17.a().c(new r1.a(r44, r43));
        r128 = r128 + 1;
        r42 = r129;
        r14 = r210;
        r16 = r211;
    L121:
        String[] r212 = r14;
        j1.b0 r213 = r16;
        r1.y r45 = r17.g();
        String r46 = r41.toString();
        he.i.e(r46, "id.toString()");
        r45.c(r46, r124.f2962c);
        if (r28 == false) goto L124;
        r1.n r47 = r17.d();
        String r48 = r41.toString();
        he.i.e(r48, "id.toString()");
        r47.a(new r1.m(r27, r48));
    L124:
        r39 = r39;
        r15 = r127;
        r14 = r212;
        r16 = r213;
        goto L101
    L108:
        if (r111 == false) goto L110;
        r126 = androidx.work.u.a.f2957p;
        goto L111
    L110:
        r126 = androidx.work.u.a.f2956o;
    L112:
        r125.f11352n = r15;
        goto L113
    L125:
        r26 = r38;
        r25 = true;
        goto L126
    L96:
        r123 = false;
        goto L98
    L47:
        if (r116 == androidx.work.g.f2830n) goto L66;
        if (r116 != androidx.work.g.f2828b) goto L61;
        Iterator r130 = r30.iterator();
    L53:
        if (r130.hasNext() == false) goto L61;
        androidx.work.u.a r131 = ((r1.t.a) r130.next()).f11360b;
        boolean r132 = r18;
        if (r131 == androidx.work.u.a.f2952a) goto L60;
        if (r131 == androidx.work.u.a.f2953b) goto L60;
        r18 = r132;
    L61:
        boolean r133 = r18;
        new d(r16, r27, false).run();
        r1.u r134 = r17.f();
        Iterator r49 = r30.iterator();
    L63:
        if (r49.hasNext() == false) goto L65;
        r134.delete(((r1.t.a) r49.next()).f11359a);
        goto L63
    L65:
        r114 = r12;
        r123 = r133;
        r38 = true;
    L97:
        r114 = r12;
        r123 = r18;
    L40:
        r29 = false;
        goto L41
    L35:
        r113 = true;
        r111 = false;
        r112 = false;
        goto L36
    L15:
        if (r14.length <= 0) goto L17;
        r18 = true;
        goto L18
    L11:
        r12 = false;
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        j1.m r8 = this.f11974b;
        j1.u r10 = this.f11973a;
        r10.getClass();     // Catch: Throwable -> L18
        j1.b0 r11 = r10.f8543c;
        if (j1.u.A(r10, new HashSet()) == true) goto L17;
        WorkDatabase r12 = r11.f8453c;     // Catch: Throwable -> L18
        r12.beginTransaction();     // Catch: Throwable -> L18
        boolean r13 = a(r10);     // Catch: Throwable -> L13
        r12.setTransactionSuccessful();     // Catch: Throwable -> L13
        r12.endTransaction();     // Catch: Throwable -> L18
        if (r13 == false) goto L12;
        m.a(r11.f8451a, RescheduleReceiver.class, true);     // Catch: Throwable -> L18
        j1.s.a(r11.f8452b, r11.f8453c, r11.f8455e);     // Catch: Throwable -> L18
    L12:
        r8.a(androidx.work.p.f2939a);     // Catch: Throwable -> L18
        return;
    L13:
        th = move-exception;
        r12.endTransaction();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L17:
        throw new IllegalStateException("WorkContinuation has cycles (" + r10 + ")");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r8.a(new androidx.work.p.a.C0026a(th));
    }
}
