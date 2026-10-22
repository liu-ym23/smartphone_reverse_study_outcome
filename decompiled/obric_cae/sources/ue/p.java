package ue;

import java.util.Iterator;
import java.util.List;
import pe.l1;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l1 f12623a = null;

    static {
        int r8 = v.f12626a;
        l1 r10 = null;
        String r11 = System.getProperty("kotlinx.coroutines.fast.service.loader");     // Catch: SecurityException -> L5
    L6:
        if (r11 == null) goto L34;
        Boolean.parseBoolean(r11);
    L34:
        List<? extends o> r12 = me.c.i1(me.e.f1(android.aimedia.a.m()));     // Catch: Throwable -> L30
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L30
        if (r13.hasNext() == true) goto L11;
        Object r14 = null;
    L20:
        o r15 = (o) r14;     // Catch: Throwable -> L30
        if (r15 == null) goto L29;
        r10 = r15.b(r12);     // Catch: Throwable -> L24
    L25:
        if (r10 == null) goto L29;
        f12623a = r10;
        return;
    L24:
        r15.a();     // Catch: Throwable -> L30
    L29:
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");     // Catch: Throwable -> L30
    L11:
        r14 = r13.next();     // Catch: Throwable -> L30
        if (r13.hasNext() == false) goto L20;
        int r16 = ((o) r14).c();     // Catch: Throwable -> L30
    L15:
        Object r17 = r13.next();     // Catch: Throwable -> L30
        int r18 = ((o) r17).c();     // Catch: Throwable -> L30
        if (r16 >= r18) goto L19;
        r14 = r17;
        r16 = r18;
    L19:
        if (r13.hasNext() == true) goto L15;
    L30:
        th = move-exception;
        throw th;
    L5:
        r11 = null;
        goto L6
    }
}
