package j1;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8540a = null;

    static {
        f8540a = androidx.work.m.f("Schedulers");
    }

    public static void a(androidx.work.c r8, WorkDatabase r10, List<r> r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.size() == 0) goto L55;
        r1.u r12 = r10.f();
        r10.beginTransaction();
        ArrayList r13 = r12.m(r8.f2804i);     // Catch: Throwable -> L36
        ArrayList r14 = r12.k();     // Catch: Throwable -> L36
        if (r13 != null) goto L10;
    L15:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L36
        r10.endTransaction();
        if (r13 != null) goto L19;
    L26:
        if (r14 != null) goto L28;
        return;
    L28:
        if (r14.size() <= 0) goto L53;
        r1.t[] r15 = (r1.t[]) r14.toArray(new r1.t[r14.size()]);
        Iterator<r> r16 = r11.iterator();
    L31:
        if (r16.hasNext() == false) goto L54;
        r r17 = r16.next();
        if (r17.d() == true) goto L31;
        r17.a(r15);
        goto L31
    L54:
        return;
    L53:
        return;
    L19:
        if (r13.size() <= 0) goto L26;
        r1.t[] r18 = (r1.t[]) r13.toArray(new r1.t[r13.size()]);
        Iterator<r> r19 = r11.iterator();
    L22:
        if (r19.hasNext() == false) goto L26;
        r r20 = r19.next();
        if (r20.d() == false) goto L22;
        r20.a(r18);
        goto L22
    L10:
        if (r13.size() <= 0) goto L15;
        long r21 = System.currentTimeMillis();     // Catch: Throwable -> L36
        Iterator r22 = r13.iterator();     // Catch: Throwable -> L36
    L13:
        if (r22.hasNext() == false) goto L15;
        r12.b(r21, ((r1.t) r22.next()).f11339a);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }
}
